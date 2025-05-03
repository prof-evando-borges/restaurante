package br.com.fiap.restaurante.funcionario.model;

import java.util.Date;


public class Garcom extends Funcionario {
    private int mesasResponsaveis;

    public Garcom(int id,String nome, String telefone, String email, String cpf, String cargo,
                  double salario, String turno, Date dataAdmissao, double comissao, int mesasResponsaveis) {
        super(id, nome, telefone, email, cpf, cargo, salario, turno, dataAdmissao, comissao);
        this.mesasResponsaveis = mesasResponsaveis;
    }

    public int getMesasResponsaveis() {
        return mesasResponsaveis;
    }

    public void setMesasResponsaveis(int mesasResponsaveis) {
        this.mesasResponsaveis = mesasResponsaveis;
    }

    public void atenderMesa(int numeroMesa) {
        System.out.println(getNome() + " está atendendo a mesa " + numeroMesa + ".");
    }

    public void entregarPedido(int numeroMesa) {
        System.out.println(getNome() + " está entregando o pedido para a mesa " + numeroMesa + ".");
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
}