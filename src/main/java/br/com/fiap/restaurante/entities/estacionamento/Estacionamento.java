package br.com.fiap.restaurante.entities.estacionamento;

import br.com.fiap.restaurante.exceptions.EstacionamentoException;

import java.sql.*;

public class Estacionamento {
    //private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    //private static final String USER = "USUARIO_ADICIONAR";
    //private static final String PASSWORD = "SENHA_ADICIONAR";

    public void mostrarEstacionamento(String URL, String USER, String PASSWORD) {
        String query = "SELECT total_vagas, vagas_ocupadas, preco_por_hora FROM estacionamento WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Conexão estabelecida");

            if (rs.next()) {  // Agora posicionamos no primeiro resultado
                System.out.println("Total de Vagas: " + rs.getInt(1));
                System.out.println("Vagas Ocupadas: " + rs.getInt(2));
                System.out.println("Preço por Hora: R$" + rs.getDouble(3));
            } else {
                System.out.println("Nenhum dado encontrado no banco.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new EstacionamentoException("Erro ao recuperar informações do estacionamento.");
        }
    }


    public boolean temVagasDisponiveis(String URL, String USER, String PASSWORD) {
        String sql = "SELECT vagas_ocupadas, total_vagas FROM estacionamento WHERE id = 1";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int vagasOcupadas = rs.getInt("vagas_ocupadas");
                int totalVagas = rs.getInt("total_vagas");
                return vagasOcupadas < totalVagas;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar vagas disponíveis: " + e.getMessage());
        }
        return false;
    }

    public void adicionarVeiculo(Veiculo veiculo, String URL, String USER, String PASSWORD) {
        if (!temVagasDisponiveis(URL, USER, PASSWORD)) {
            throw new EstacionamentoException("Estacionamento lotado! Não é possível adicionar mais veículos.");
        }
        String insertQuery = "INSERT INTO veiculo (placa, modelo, horas_estacionado, estacionamento_id) VALUES (?, ?, ?, 1)";
        String updateQuery = "UPDATE estacionamento SET vagas_ocupadas = vagas_ocupadas + 1 WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            insertStmt.setString(1, veiculo.getPlaca());
            insertStmt.setString(2, veiculo.getModelo());
            insertStmt.setInt(3, veiculo.getHorasEstacionado());
            insertStmt.executeUpdate();

            updateStmt.executeUpdate();

            System.out.println("Veículo estacionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao estacionar veículo: " + e.getMessage());
        }
    }

    public void testarConexao(String URL, String USER, String PASSWORD) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }

    public void removerVeiculo(String placa, String URL, String USER, String PASSWORD) {
        String precoQuery = "SELECT preco_por_hora FROM estacionamento WHERE id = 1";
        String horasQuery = "SELECT horas_estacionado FROM veiculo WHERE placa = ?";
        String deleteQuery = "DELETE FROM veiculo WHERE placa = ?";
        String updateQuery = "UPDATE estacionamento SET vagas_ocupadas = vagas_ocupadas - 1 WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement horasStmt = conn.prepareStatement(horasQuery);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
             Statement precoStmt = conn.createStatement();
             ResultSet precoRs = precoStmt.executeQuery(precoQuery)) {

            horasStmt.setString(1, placa);
            ResultSet horasRs = horasStmt.executeQuery();

            if (horasRs.next() && precoRs.next()) {
                double precoPorHora = precoRs.getDouble(1);
                int horasEstacionado = horasRs.getInt(1);
                double totalPagar = precoPorHora * horasEstacionado;

                deleteStmt.setString(1, placa);
                int affectedRows = deleteStmt.executeUpdate();

                if (affectedRows > 0) {
                    updateStmt.executeUpdate();
                    System.out.println("Veículo removido! Valor a pagar: R$" + totalPagar);
                } else {
                    throw new EstacionamentoException("Veículo não encontrado! Verifique a placa e tente novamente.");
                }
            } else {
                System.out.println("Erro ao calcular pagamento!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }
    }
}
