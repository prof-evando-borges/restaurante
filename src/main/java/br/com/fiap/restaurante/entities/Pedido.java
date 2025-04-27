package br.com.fiap.restaurante.entities;

import br.com.fiap.restaurante.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private int id_delivery;
    private String status;
    private Cliente cliente;
    private List<Produto> produtos;
    private List<Cardapio> cardapios;



    public Pedido(int id, int id_delivery, int id_cliente, List<Produto> produtos, List<Cardapio> cardapios) {
        this.id = id;
        this.id_delivery = id_delivery;
        this.cliente = new Cliente();
        this.produtos = produtos;
        this.cardapios = cardapios;
    }
    public Pedido(int id, int id_delivery, String status, int id_cliente, List<Produto> produtos, List<Cardapio> cardapios) {
        this.id = id;
        this.id_delivery = id_delivery;
        this.cliente = new Cliente();
        this.produtos = produtos;
        this.cardapios = cardapios;
    }



    public double calculaTotal() throws SQLException {
        double total = 0;

        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM553377";
        String password = "fiap#2025";

        String select = """
            SELECT SUM(tb.VALOR) VALOR_TOTAL
            FROM (
                    SELECT 100 VALOR FROM DUAL /*TB_PRODUTO WHERE ID_PEDIDO = ?*/
                    UNION
                    SELECT 200 VALOR FROM DUAL /*TB_CARDAPIO WHERE ID_PEDIDO = ?*/
            ) tb
        """;

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            preparedStatement = conn.prepareStatement(select);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                total = resultSet.getDouble("VALOR_TOTAL");
            }
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            conn.close();
        }

        return total;
    }

    public void fazerPedido() throws SQLException {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM553377";
        String password = "fiap#2025";

        String insert = "INSERT INTO TB_PEDIDO (ID_DELIVERY, STATUS, ID_CLIENTE) VALUES (?, 'PENDENTE', 0)";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            preparedStatement = conn.prepareStatement(insert, new String[] { "ID" });
            preparedStatement.setInt(1, this.id_delivery);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            conn.close();
        }
    }

    public void verificarStatus() throws SQLException {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM553377";
        String password = "fiap#2025";

        String select = "SELECT STATUS FROM TB_PEDIDO WHERE ID = ?";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            preparedStatement = conn.prepareStatement(select);
            preparedStatement.setInt(1, this.id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                this.status = resultSet.getString("STATUS");
            }
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            conn.close();
        }
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_delivery() {
        return id_delivery;
    }
    public void setId_delivery(int id_delivery) {
        this.id_delivery = id_delivery;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public List<Cardapio> getCardapios() {
        return cardapios;
    }
    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }
}
