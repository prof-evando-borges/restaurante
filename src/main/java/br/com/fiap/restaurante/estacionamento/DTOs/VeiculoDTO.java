package br.com.fiap.restaurante.estacionamento.DTOs;

public record VeiculoDTO(
        String placa,
        String modelo,
        int horasEstacionado
) {}
