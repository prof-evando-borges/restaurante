package br.com.fiap.restaurante.exceptions;

import java.sql.SQLException;

public class DatabaseException extends SQLException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable reason) {
        super(message, reason);
    }
}
