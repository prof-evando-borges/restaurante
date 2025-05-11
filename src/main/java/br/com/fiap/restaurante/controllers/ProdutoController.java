package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestParam String nome, @RequestParam String descricao, @RequestParam String categoria) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editarProduto(@PathVariable int id, @RequestParam String nome, @RequestParam String descricao, @RequestParam String categoria) {
        System.out.println("Editando produto com ID: " + id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProduto(@PathVariable int id) {
        System.out.println("Removendo produto com ID: " + id);
    }

    @GetMapping("/verificar")
    @ResponseStatus(HttpStatus.OK)
    public boolean verificarProdutoExistente(@RequestParam String nome) {
        return false;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProdutos() {
        System.out.println("Listando todos os produtos");
        return null;
    }
}
