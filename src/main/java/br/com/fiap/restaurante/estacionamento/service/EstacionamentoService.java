package br.com.fiap.restaurante.estacionamento.service;

import br.com.fiap.restaurante.estacionamento.DTOs.EstacionamentoDTO;
import br.com.fiap.restaurante.estacionamento.DTOs.VeiculoDTO;
import br.com.fiap.restaurante.estacionamento.entities.EstacionamentoEntity;
import br.com.fiap.restaurante.estacionamento.entities.VeiculoEntity;
import br.com.fiap.restaurante.estacionamento.exceptions.EstacionamentoException;
import br.com.fiap.restaurante.estacionamento.repositories.EstacionamentoRepository;
import br.com.fiap.restaurante.estacionamento.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstacionamentoService {

    @Autowired
    private VeiculoRepository veiculoRepo;

    @Autowired
    private EstacionamentoRepository estRepo;


    public EstacionamentoDTO obterEstacionamento() {
        EstacionamentoEntity e = estRepo.findById(1L)
                .orElseThrow(() -> new EstacionamentoException("Não encontrado"));

        List<VeiculoDTO> veiculos = veiculoRepo.findAll().stream()
                .map(this::toVeiculoDTO)
                .collect(Collectors.toList());

        return new EstacionamentoDTO(
                e.getId(),
                e.getTotalVagas(),
                e.getVagasOcupadas(),
                e.getPrecoPorHora(),
                veiculos
        );
    }

    public void mostrarEstacionamento() {
        EstacionamentoEntity est = estRepo.findById(1L).orElseThrow();
        System.out.printf("Total: %d, Ocupadas: %d, Preço: R$%.2f%n",
                est.getTotalVagas(), est.getVagasOcupadas(), est.getPrecoPorHora());
    }

    public boolean temVagasDisponiveis() {
        EstacionamentoEntity est = estRepo.findById(1L)
                .orElseThrow(() -> new EstacionamentoException("Estacionamento não encontrado"));
        return est.getVagasOcupadas() < est.getTotalVagas();
    }


    public void adicionarVeiculo(VeiculoDTO dto) {
        if (veiculoRepo.existsById(dto.placa())) {
            throw new EstacionamentoException("Já existe um veículo estacionado com a placa " + dto.placa());
        }

        EstacionamentoEntity est = estRepo.findById(1L)
                .orElseThrow(() -> new EstacionamentoException("Estacionamento não encontrado"));

        if (est.getVagasOcupadas() >= est.getTotalVagas()) {
            throw new EstacionamentoException("Estacionamento cheio!");
        }

        VeiculoEntity v = new VeiculoEntity();
        v.setPlaca(dto.placa());
        v.setModelo(dto.modelo());
        v.setHorasEstacionado(dto.horasEstacionado());
        v.setEstacionamento(est);
        veiculoRepo.save(v);

        est.setVagasOcupadas(est.getVagasOcupadas() + 1);
        estRepo.save(est);
    }

    public double removerVeiculo(String placa) {
        VeiculoEntity veiculo = veiculoRepo.findById(placa)
                .orElseThrow(() -> new EstacionamentoException("Veículo não encontrado"));

        double total = veiculo.getHorasEstacionado() * veiculo.getEstacionamento().getPrecoPorHora();
        veiculoRepo.delete(veiculo);

        EstacionamentoEntity est = veiculo.getEstacionamento();
        est.setVagasOcupadas(est.getVagasOcupadas() - 1);
        estRepo.save(est);

        return total;
    }

    public List<VeiculoDTO> listarVeiculos() {
        return veiculoRepo.findAll().stream()
                .map(this::toVeiculoDTO)
                .collect(Collectors.toList());
    }

    public void testarConexao() {
        // Só verifica se o estacionamento está acessível via repositório
        estRepo.findById(1L).orElseThrow(() -> new RuntimeException("Falha na conexão"));
        System.out.println("Conexão com banco bem-sucedida via JPA!");
    }

    private VeiculoDTO toVeiculoDTO(VeiculoEntity e) {
        return new VeiculoDTO(
                e.getPlaca(),
                e.getModelo(),
                e.getHorasEstacionado()
        );
    }
}