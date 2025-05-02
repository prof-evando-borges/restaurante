package br.com.fiap.restaurante.estacionamento.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo",
        uniqueConstraints = @UniqueConstraint(columnNames = "placa"))
public class VeiculoEntity {

    @Id
    @Column(name = "placa", unique = true)
    private String placa;

    private String modelo;

    @Column(name = "horas_estacionado")
    private int horasEstacionado;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    private EstacionamentoEntity estacionamento;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHorasEstacionado() {
        return horasEstacionado;
    }

    public void setHorasEstacionado(int horasEstacionado) {
        this.horasEstacionado = horasEstacionado;
    }

    public EstacionamentoEntity getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(EstacionamentoEntity estacionamento) {
        this.estacionamento = estacionamento;
    }
}
