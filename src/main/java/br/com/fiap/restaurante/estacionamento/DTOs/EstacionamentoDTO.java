package br.com.fiap.restaurante.estacionamento.DTOs;

import java.util.List;

public record EstacionamentoDTO(
        Long id,
        int totalVagas,
        int vagasOcupadas,
        double precoPorHora,
        List<VeiculoDTO> veiculos
) {}