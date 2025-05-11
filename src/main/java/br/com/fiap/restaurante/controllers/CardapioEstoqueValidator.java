package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Estoque;
import br.com.fiap.restaurante.entities.MenuItem;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CardapioEstoqueValidator {

    public static void validarDisponibilidade(MenuItem item, List<Estoque> estoque) {
        /*Set<String> ingredientesNecessarios = item.getIngredients().stream()
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toSet());*/

        Set<String> ingredientesDisponiveis = estoque.stream()
                .filter(e -> e.getQuantidade() > 0)
                .map(e -> e.getProduto().getNome().toLowerCase().trim())
                .collect(Collectors.toSet());

      /*  boolean temTodosIngredientes = ingredientesNecessarios.stream()
                .allMatch(ingredientesDisponiveis::contains);*/

       // item.setAvailable(temTodosIngredientes);
    }

    public static void validarDisponibilidadeEmLote(List<? extends MenuItem> itens, List<Estoque> estoque) {
        for (MenuItem item : itens) {
            validarDisponibilidade(item, estoque);
        }
    }
}
