package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Estoque;
import br.com.fiap.restaurante.entities.MainCourse;
import br.com.fiap.restaurante.entities.Produto;
import br.com.fiap.restaurante.controllers.CardapioEstoqueValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/MainCourse")
public class MainCourseController {

    private final List<Estoque> estoque = Arrays.asList(
            new Estoque(1, new Produto("frango", "Filé de frango", "carnes"), 10),
            new Estoque(2, new Produto("arroz", "Arroz branco", "grãos"), 15),
            new Estoque(3, new Produto("alface", "Alface crespa", "verduras"), 5)
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarMainCourse(@RequestBody MainCourse mainCourse) {
        System.out.println(mainCourse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MainCourse> listarMainCourses() {
        List<MainCourse> pratos = List.of(
                new MainCourse(
                        "Frango Grelhado",
                        "Peito de frango grelhado com legumes",
                        24.90,
                        true,
                        450,
                        true,
                        false,
                        new HashSet<>(Arrays.asList("frango", "arroz", "alface")),
                        "Grelhado",
                        "Médio",
                        "Grelhado",
                        new HashSet<>(Collections.singleton("Rico em proteínas")),
                        true,
                        "Local",
                        true,
                        false
                )
        );

        CardapioEstoqueValidator.validarDisponibilidadeEmLote(pratos, estoque);

        return pratos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MainCourse buscarPorId(@PathVariable Long id) {
        MainCourse prato = new MainCourse(
                "Frango Grelhado",
                "Peito de frango grelhado com legumes",
                24.90,
                true,
                450,
                true,
                false,
                new HashSet<>(Arrays.asList("frango", "arroz", "alface")),
                "Grelhado",
                "Médio",
                "Grelhado",
                new HashSet<>(Collections.singleton("Rico em proteínas")),
                true,
                "Local",
                true,
                false
        );
        prato.setIdMainCourse(id.intValue());

        CardapioEstoqueValidator.validarDisponibilidade(prato, estoque);

        return prato;
    }

    @PutMapping("/{id}")
    public MainCourse atualizar(@PathVariable Long id, @RequestBody MainCourse mainCourse) {
        mainCourse.setIdMainCourse(id.intValue());
        return mainCourse;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // Lógica de deleção mockada
    }
}
