package br.com.fiap.restaurante.exceptions;


public class PagamentoException extends Exception {
	/**
	 * Exceção personalizada para erros relacionados ao pagamento.
	 */
	public PagamentoException(String mensagem) {
		super(mensagem);
	}
}
