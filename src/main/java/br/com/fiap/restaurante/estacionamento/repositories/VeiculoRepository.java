package br.com.fiap.restaurante.estacionamento.repositories;

import br.com.fiap.restaurante.estacionamento.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, String> {
}