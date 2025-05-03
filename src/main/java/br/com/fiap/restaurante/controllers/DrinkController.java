package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Drink;
import br.com.fiap.restaurante.entities.DrinkTemperature;
import br.com.fiap.restaurante.entities.Estoque;
import br.com.fiap.restaurante.entities.Produto;
import br.com.fiap.restaurante.controllers.CardapioEstoqueValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/drinks")
public class DrinkController {

    // Estoque simulado para bebidas
    private final List<Estoque> estoque = Arrays.asList(
            new Estoque(1, new Produto("água gaseificada", "Base líquida com gás", "bebidas"), 20),
            new Estoque(2, new Produto("xarope de cola", "Concentrado de refrigerante", "xaropes"), 10),
            new Estoque(3, new Produto("corantes", "Corante caramelo IV", "aditivos"), 5)
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDrink(@RequestBody Drink drink) {
        System.out.println(drink);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Drink> listarDrinks() {
        Produto agua = new Produto("água gaseificada", "Base líquida com gás", "bebidas");
        Produto xarope = new Produto("xarope de cola", "Concentrado de refrigerante", "xaropes");
        Produto corante = new Produto("corantes", "Corante caramelo IV", "aditivos");

        Set<Produto> ingredientes = new HashSet<>(Arrays.asList(agua, xarope, corante));

        Drink drink = new Drink(
                "Coca-Cola",
                "Refrigerante tradicional",
                6.00,
                "Bebida",
                true,
                0,
                150,
                false,
                true,
                ingredientes,
                false,
                "Lata",
                "Cola",
                "Cola",
                true,
                "small",
                "Contém cafeína",
                DrinkTemperature.Iced
        );
        drink.setIdDrink(1);

        List<Drink> drinks = List.of(drink);
        CardapioEstoqueValidator.validarDisponibilidadeEmLote(drinks, estoque);

        return drinks;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Drink buscarPorId(@PathVariable Long id) {
        Produto agua = new Produto("água gaseificada", "Base líquida com gás", "bebidas");
        Produto xarope = new Produto("xarope de cola", "Concentrado de refrigerante", "xaropes");
        Produto corante = new Produto("corantes", "Corante caramelo IV", "aditivos");

        Set<Produto> ingredientes = new HashSet<>(Arrays.asList(agua, xarope, corante));

        Drink drink = new Drink(
                "Coca-Cola",
                "Refrigerante tradicional",
                6.00,
                "Bebida",
                true,
                0,
                150,
                false,
                true,
                ingredientes,
                false,
                "Lata",
                "Cola",
                "Cola",
                true,
                "small",
                "Contém cafeína",
                DrinkTemperature.Iced
        );
        drink.setIdDrink(id.intValue());

        CardapioEstoqueValidator.validarDisponibilidade(drink, estoque);
        return drink;
    }

    @PutMapping("/{id}")
    public Drink atualizar(@PathVariable Long id, @RequestBody Drink drink) {
        drink.setIdDrink(id.intValue());
        return drink;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // Simulação de exclusão
    }
}
