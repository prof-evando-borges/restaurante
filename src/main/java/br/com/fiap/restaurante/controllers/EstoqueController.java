package br.com.fiap.restaurante.controllers;

import br.com.restaurante.entities.Estoque;
import br.com.restaurante.entities.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/estoque")
public class EstoqueController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarProduto(@RequestBody Produto produto, @RequestParam int quantidade) {
        System.out.println("Produto adicionado!");
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estoque buscarPorId(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarQuantidade(@PathVariable int id, @RequestParam int novaQuantidade) {
        System.out.println("Atualizado");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEstoque(@PathVariable int id) {
        System.out.println("Removido");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estoque> listarTodos() {
        return null;
    }
}
