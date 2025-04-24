package br.com.fiap.restaurante.exceptions;

public class DatabaseException extends Exception {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable reason) {
        super(message, reason);
    }
}
