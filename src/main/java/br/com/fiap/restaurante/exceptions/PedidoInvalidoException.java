package br.com.fiap.restaurante.exceptions;

public class PedidoInvalidoException extends Exception {

    public PedidoInvalidoException() {
        super();
    }

    public PedidoInvalidoException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PedidoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PedidoInvalidoException(String message) {
        super(message);
    }

    public PedidoInvalidoException(Throwable cause) {
        super(cause);
    }
}
