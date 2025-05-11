package br.com.fiap.restaurante.entities;

import br.com.fiap.restaurante.exceptions.DatabaseException;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.restaurante.entities.Produto;

public class Delivery {

    private int id;
    private String tipo;
    private List<Pedido> pedidos;



    public Delivery(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }



    public void buscarPedidos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<Pedido>();

        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM553377";
        String password = "fiap#2025";

        String select = "SELECT * FROM TB_PEDIDO WHERE ID_DELIVERY = ?";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            preparedStatement = conn.prepareStatement(select);
            preparedStatement.setInt(1, this.id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String status = resultSet.getString("STATUS");
                int id_cliente = resultSet.getInt("ID_CLIENTE");

               // pedidos.add(new Pedido(id, this.id, status, id_cliente, new ArrayList<Produto>(), new ArrayList<Cardapio>()));
            }
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            conn.close();
        }

        this.pedidos = pedidos;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

