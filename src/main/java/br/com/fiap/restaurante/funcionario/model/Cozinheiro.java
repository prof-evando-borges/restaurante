package br.com.fiap.restaurante.funcionario.model;

import java.util.Date;
import java.util.Map;

import br.com.fiap.restaurante.funcionario.exception.PedidoInvalidoException;

public class Cozinheiro extends Funcionario  {
    
    private Map<String, String> pedidosAtivos;

    public Cozinheiro(int id, String nome, String telefone, String email, String cpf, String cargo,
            double salario, String turno, Date dataAdmissao, double comissao) {
        super(id, nome, telefone, email, cpf, cargo, salario, turno, dataAdmissao, comissao);
    }
    
    @Override
    public double calcularComissao() {
        double diasTrabalhadosPorMes = 30;
        double comissaoPorDia = (getSalario() / diasTrabalhadosPorMes) * getComissao();
        double comissaoMensal = comissaoPorDia * diasTrabalhadosPorMes;
        return comissaoMensal;
    }

    @Override
    public double calcularSalario() {
        double salarioBase = getSalario();
        double comissao = getComissao();
        return salarioBase + (salarioBase * comissao);
    }

    @Override
    public double calcularRescisao() {
        Date dataAdmissao = getDataAdmissao();
        double diasTrabalhados = (new Date().getTime() - dataAdmissao.getTime()) / (1000 * 60 * 60 * 24);
        double salarioBase = getSalario();
        double rescisao = salarioBase * diasTrabalhados;
        return rescisao;
    }

    public String getPedidoAtivoStatus(String pedido) throws PedidoInvalidoException {
        try {
            return pedidosAtivos.get(pedido);
        } catch (NullPointerException e) {
            throw new PedidoInvalidoException("O pedido: " + pedido + " não existe ou não está ativo.");
        }
    }

    public String getPedidosAtivos() {
        return pedidosAtivos.toString();
    }

    public void setPedidosAtivos(Map<String, String> pedidosAtivos) throws IllegalArgumentException {
        if (pedidosAtivos == null || pedidosAtivos.isEmpty()) {
            throw new IllegalArgumentException("A lista de pedidos ativos não pode ser nula ou vazia.");
        }
        for (String pedido : pedidosAtivos.keySet()) {
            if (pedido == null || pedido.isEmpty()) {
                throw new IllegalArgumentException("O pedido não pode ser nulo ou vazio.");
            }
        }
        for (String status : pedidosAtivos.values()) {
            if (status == null || status.isEmpty()) {
                throw new IllegalArgumentException("O status do pedido não pode ser nulo ou vazio.");
            }
        }
        if (pedidosAtivos.size() > 10) {
            throw new IllegalArgumentException("A lista de pedidos ativos não pode ter mais de 10 itens.");
        }
        this.pedidosAtivos = pedidosAtivos;
    }

    public void prepararPrato() {
        System.out.println(getNome() + " (Cozinheiro) está preparando o prato.");
    }
    
    public void organizarCozinha() {
        System.out.println(getNome() + " (Cozinheiro) está organizando a cozinha.");
    }
    
    public void limparAreaTrabalho() {
        System.out.println(getNome() + " (Cozinheiro) está limpando a área de trabalho.");
    }
    
}