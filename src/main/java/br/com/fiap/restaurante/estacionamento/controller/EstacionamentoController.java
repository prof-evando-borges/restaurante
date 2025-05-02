package br.com.fiap.restaurante.estacionamento.controller;

import br.com.fiap.restaurante.estacionamento.DTOs.EstacionamentoDTO;
import br.com.fiap.restaurante.estacionamento.DTOs.VeiculoDTO;
import br.com.fiap.restaurante.estacionamento.service.EstacionamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estacionamento")
public class EstacionamentoController {
    private final EstacionamentoService service;

    public EstacionamentoController(EstacionamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstacionamentoDTO> mostrarEstacionamento() {
        EstacionamentoDTO estDto = service.obterEstacionamento();
        return ResponseEntity.ok(estDto);
    }

    @GetMapping("/disponivel")
    public ResponseEntity<Boolean> temVagasDisponiveis() {
        return ResponseEntity.ok(service.temVagasDisponiveis());
    }

    @GetMapping("/veiculos")
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos() {
        List<VeiculoDTO> veiculos = service.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping("/veiculo")
    public ResponseEntity<Void> adicionarVeiculo(@RequestBody VeiculoDTO dto) {
        service.adicionarVeiculo(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/veiculo/{placa}")
    public ResponseEntity<String> removerVeiculo(@PathVariable String placa) {
        double total = service.removerVeiculo(placa);
        return ResponseEntity.ok("Preço a pagar: R$" + total);
    }

    @GetMapping("/teste-conexao")
    public ResponseEntity<Void> testarConexao() {
        service.testarConexao();
        return ResponseEntity.ok().build();
    }
}