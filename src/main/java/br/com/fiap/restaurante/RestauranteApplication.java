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
        SpringApplication.run(RestauranteApplication.class, args);

    }

}
