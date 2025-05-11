package br.com.fiap.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class RestauranteApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(RestauranteApplication.class, args);

    }

}
