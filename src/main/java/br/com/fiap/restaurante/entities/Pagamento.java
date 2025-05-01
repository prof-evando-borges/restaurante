package br.com.fiap.restaurante.entities;
import br.com.fiap.restaurante.exceptions.PagamentoException;
import java.time.LocalDateTime;

public class Pagamento {

    private int id;
    private double valor;
    private LocalDateTime dataHora;
    private String tipoPagamento;

    public Pagamento(double valor, String tipoPagamento) throws PagamentoException{
        if (valor < 0) {
        	throw new PagamentoException("Valor do pagamento não pode ser negativo"); 
        }
    	
    	this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.dataHora = LocalDateTime.now();
    }

    public void pagar() {
        System.out.println("Pagamento de R$ " + this.valor + " realizado via " + this.tipoPagamento);
        gerarNota();
    }

    public void gerarNota() {
        System.out.println("===== NOTA FISCAL =====");
        System.out.println("Valor: R$ " + valor);
        System.out.println("Tipo de Pagamento: " + tipoPagamento);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("=======================");
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
