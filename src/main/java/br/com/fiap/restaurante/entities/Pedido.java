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
      //  this.cliente = new Cliente();
        this.produtos = produtos;
        this.cardapios = cardapios;
    }
    public Pedido(int id, int id_delivery, String status, int id_cliente, List<Produto> produtos, List<Cardapio> cardapios) {
        this.id = id;
        this.id_delivery = id_delivery;
       // this.cliente = new Cliente();
        this.produtos = produtos;
        this.cardapios = cardapios;
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
