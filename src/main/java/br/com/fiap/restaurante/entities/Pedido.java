package br.com.fiap.restaurante.entities;

import br.com.fiap.restaurante.exceptions.PedidoInvalidoException;
import br.com.fiap.restaurante.exceptions.MesaInvalidaException;

import java.sql.*;

public class Pedido {
    private int idMesa;
    private String opcao;
    private int quantidade;
    private String observacoes;

    public Pedido(int idMesa, String opcao, int quantidade) {
        this.idMesa = idMesa;
        this.opcao = opcao;
        this.quantidade = quantidade;
    }

    public Pedido(int idMesa, String opcao, int quantidade, String observacoes) {
        this.idMesa = idMesa;
        this.opcao = opcao;
        this.quantidade = quantidade;
        this.observacoes = observacoes;
    }

    public void adcionarPedido() throws PedidoInvalidoException, MesaInvalidaException {
        if (this.idMesa <= 0) {
            throw new MesaInvalidaException("Número da mesa inválido!");
        }

        if (this.opcao == null || this.quantidade <= 0) {
            throw new PedidoInvalidoException("É necessário informar a opção e a quantidade do pedido!");
        }
    }

    public void editarPedido() {
        System.out.println("Pedido editado");
    }

    public void deletarPedido() {
        System.out.println("Pedido deletado");
    }

    public void visualizarPedido() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String selectQuery = "SELECT p.NUMERO_MESA, pr.NOME AS PRODUTO, p.QUANTIDADE, p.TIMESTAMP_PEDIDO " +
                "FROM PEDIDO p " +
                "JOIN PRODUTO pr ON p.PRODUTO_ID = pr.ID " +
                "WHERE p.NUMERO_MESA = ?";
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm553518", "");
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, this.idMesa); // Usando o idMesa do objeto Pedido
            System.out.println(resultSet);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int numeroMesa = resultSet.getInt("NUMERO_MESA");
                String produto = resultSet.getString("PRODUTO");
                int quantidade = resultSet.getInt("QUANTIDADE");
                Timestamp timestampPedido = resultSet.getTimestamp("TIMESTAMP_PEDIDO");

                System.out.println("Pedido encontrado:");
                System.out.println("Número da mesa: " + numeroMesa);
                System.out.println("Produto: " + produto);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("Data e hora do pedido: " + timestampPedido);
            } else {
                System.out.println("Pedido não encontrado para a mesa " + this.idMesa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}