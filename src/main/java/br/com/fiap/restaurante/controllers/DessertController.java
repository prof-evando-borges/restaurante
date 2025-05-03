package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Dessert;
import br.com.fiap.restaurante.entities.Estoque;
import br.com.fiap.restaurante.entities.Produto;
import br.com.fiap.restaurante.controllers.CardapioEstoqueValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/Dessert")
public class DessertController {

    // Estoque mockado para sobremesas
    private final List<Estoque> estoque = Arrays.asList(
            new Estoque(1, new Produto("biscoito", "Base crocante", "confeitaria"), 8),
            new Estoque(2, new Produto("geleia de frutas vermelhas", "Geleia artesanal", "doces"), 5),
            new Estoque(3, new Produto("creme", "Creme de leite condensado", "laticínios"), 6)
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDessert(@RequestBody Dessert dessert) {
        System.out.println(dessert);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dessert> listarDesserts() {
        Dessert dessert = new Dessert(
                "Cheesecake de Frutas Vermelhas",
                "Delicioso cheesecake com frutas",
                15.00,
                true,
                300,
                false,
                false,
                new HashSet<>(Arrays.asList("biscoito", "geleia de frutas vermelhas", "creme")),
                "Torta",
                "Frutas vermelhas",
                "Cold",
                "Frutas vermelhas, glúten",
                "Sweet",
                "Medium",
                "800 calorias, alto em açúcar"
        );
        dessert.setIdDessert(1);

        List<Dessert> lista = List.of(dessert);
        CardapioEstoqueValidator.validarDisponibilidadeEmLote(lista, estoque);
        return lista;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dessert buscarPorId(@PathVariable Long id) {
        Dessert dessert = new Dessert(
                "Cheesecake de Frutas Vermelhas",
                "Delicioso cheesecake com frutas",
                15.00,
                true,
                300,
                false,
                false,
                new HashSet<>(Arrays.asList("biscoito", "geleia de frutas vermelhas", "creme")),
                "Torta",
                "Frutas vermelhas",
                "Cold",
                "Frutas vermelhas, glúten",
                "Sweet",
                "Medium",
                "800 calorias, alto em açúcar"
        );
        dessert.setIdDessert(id.intValue());

        CardapioEstoqueValidator.validarDisponibilidade(dessert, estoque);
        return dessert;
    }

    @PutMapping("/{id}")
    public Dessert atualizar(@PathVariable Long id, @RequestBody Dessert dessert) {
        dessert.setIdDessert(id.intValue());
        return dessert;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // Exclusão simulada
    }
}
