package br.com.fiap.restaurante;

import br.com.fiap.restaurante.entities.Cardapio;
import br.com.fiap.restaurante.entities.Delivery;
import br.com.fiap.restaurante.entities.Pedido;
import br.com.fiap.restaurante.entities.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootApplication
public class RestauranteApplication {

    public static void main(String[] args) throws SQLException {
        //SpringApplication.run(RestauranteApplication.class, args);

        /*Delivery delivery = new Delivery(1, "Teste");

        delivery.buscarPedidos();

        for (int i = 0; i < delivery.getPedidos().size(); i++) {
            Pedido pedido = delivery.getPedidos().get(i);
            System.out.println(pedido.getId() + " " + pedido.getStatus());
        }*/

        Pedido pedido = new Pedido(1, 1, 0, new ArrayList<Produto>(), new ArrayList<Cardapio>());

        pedido.fazerPedido();

        System.out.println(pedido.getId());

        System.out.println(pedido.calculaTotal());

        pedido.verificarStatus();

        System.out.println(pedido.getStatus());
    }

}
