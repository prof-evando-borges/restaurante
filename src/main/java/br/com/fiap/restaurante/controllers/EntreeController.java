package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Entree;
import br.com.fiap.restaurante.entities.Estoque;
import br.com.fiap.restaurante.entities.Produto;
import br.com.fiap.restaurante.controllers.CardapioEstoqueValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/Entree")
public class EntreeController {

    // Lista mockada de estoque
    private final List<Estoque> estoque = Arrays.asList(
            new Estoque(1, new Produto("pão", "Pão francês", "padaria"), 10),
            new Estoque(2, new Produto("salsicha", "Salsicha tipo hot dog", "açougue"), 5)
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarEntree(@RequestBody Entree entree) {
        System.out.println(entree);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entree> listarEntradas() {
        // Ingredientes como objetos Produto
        Produto pao = new Produto("pão", "Pão francês", "padaria");
        Produto salsicha = new Produto("salsicha", "Salsicha tipo hot dog", "açougue");

        Set<Produto> ingredientes = new HashSet<>(Arrays.asList(pao, salsicha));

        List<Entree> entradas = Arrays.asList(
                new Entree(
                        "Mini Cachorro Quente",
                        "Pão com salsicha",
                        8.89,
                        true,
                        600,
                        false,
                        false,
                        ingredientes,
                        "Cozido",
                        "Pequena",
                        "Salsicha",
                        "Bandeja"
                )
        );

        // Verifica se todos os ingredientes estão no estoque
        CardapioEstoqueValidator.validarDisponibilidadeEmLote(entradas, estoque);

        return entradas;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Entree buscarPorId(@PathVariable Long id) {
        Produto pao = new Produto("pão", "Pão francês", "padaria");
        Produto salsicha = new Produto("salsicha", "Salsicha tipo hot dog", "açougue");

        Set<Produto> ingredientes = new HashSet<>(Arrays.asList(pao, salsicha));

        Entree entree = new Entree(
                "Mini Cachorro Quente",
                "Pão com salsicha",
                8.89,
                true,
                600,
                false,
                false,
                ingredientes,
                "Cozido",
                "Pequena",
                "Salsicha",
                "Bandeja"
        );
        entree.setIdEntree(id.intValue());

        CardapioEstoqueValidator.validarDisponibilidade(entree, estoque);

        return entree;
    }

    @PutMapping("/{id}")
    public Entree atualizar(@PathVariable Long id, @RequestBody Entree entree) {
        entree.setIdEntree(id.intValue());
        return entree;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // Lógica de exclusão fictícia
    }
}
