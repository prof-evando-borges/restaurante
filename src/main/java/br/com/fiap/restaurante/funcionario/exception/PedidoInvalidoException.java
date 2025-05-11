package br.com.fiap.restaurante.funcionario.exception;

public class PedidoInvalidoException extends Exception{
	
	public PedidoInvalidoException(String mensagem) {
		super(mensagem);
	}
}