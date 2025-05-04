package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enderecos")
public class EnderecoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarEndereco(@RequestBody Endereco endereco) {
        System.out.println("Cadastrando endereço: " + endereco);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listarEnderecos() {
        Endereco endereco = new Endereco(1, "Rua das Flores", "São Paulo", "SP", "12345-678");
        endereco.setId(10);
        return List.of(endereco);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco buscarPorId(@PathVariable int id) {
        Endereco endereco = new Endereco(1, "Av. Brasil", "Rio de Janeiro", "RJ", "98765-432");
        endereco.setId(id);
        return endereco;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco atualizar(@PathVariable int id, @RequestBody Endereco endereco) {
        endereco.setId(id);
        System.out.println("Atualizando endereço: " + endereco);
        return endereco;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable int id) {
        System.out.println("Endereço com ID " + id + " deletado.");
    }
}
