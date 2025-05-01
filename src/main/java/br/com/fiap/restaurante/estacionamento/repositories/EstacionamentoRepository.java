package br.com.fiap.restaurante.estacionamento.repositories;

import br.com.fiap.restaurante.estacionamento.entities.EstacionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<EstacionamentoEntity, Long> {
}
