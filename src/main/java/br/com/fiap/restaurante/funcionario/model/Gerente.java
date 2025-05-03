package br.com.fiap.restaurante.funcionario.model;

import java.util.Date;

public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(int id,String nome, String telefone, String email, String cpf, String cargo,
                   double salario, String turno, Date dataAdmissao, double comissao, String departamento) {
        super(id, nome, telefone, email, cpf, cargo, salario, turno, dataAdmissao, comissao);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void supervisionar() {
        System.out.println(getNome() + " está supervisionando o departamento " + departamento + ".");
    }

    @Override
    public double calcularComissao() {
        return 0;
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