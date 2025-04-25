package br.com.fiap.restaurante.exceptions;

public class MesaInvalidaException extends Exception {

    public MesaInvalidaException() {
        super();
    }

    public MesaInvalidaException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MesaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MesaInvalidaException(String message) {
        super(message);
    }

    public MesaInvalidaException(Throwable cause) {
        super(cause);
    }
}
