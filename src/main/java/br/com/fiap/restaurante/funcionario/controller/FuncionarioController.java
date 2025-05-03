package br.com.fiap.restaurante.funcionario.controller;

import br.com.fiap.restaurante.funcionario.model.Funcionario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        // Lógica para cadastrar funcionário
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> listarFuncionarios() {
        // Lógica para listar funcionários
        return new ArrayList<Funcionario>();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Funcionario buscarPorId(@PathVariable int id) {
        // Lógica para buscar funcionário por ID
        Funcionario funcionario = null;

        if (funcionario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        } else{
            return funcionario;
        }

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarFuncionario(@PathVariable int id, @RequestBody Funcionario funcionario) {
        // Lógica para atualizar funcionário
        Funcionario funcionarioExistente = null;
        if (funcionarioExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        }
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarFuncionario(@PathVariable int id) {
        // Lógica para deletar funcionário
        Funcionario funcionario = null;
        if (funcionario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        }
    }

    @GetMapping("/{id}/comissao")
    @ResponseStatus(HttpStatus.OK)
    public double calcularComissao(@PathVariable int id) {
        // Lógica para buscar funcionário por ID
        Funcionario funcionario = null;
        if (funcionario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        }
        
        return funcionario.calcularComissao();
    }

    @GetMapping("/{id}/salario")
    @ResponseStatus(HttpStatus.OK)
    public double calcularSalario(@PathVariable int id) {
        // Lógica para buscar funcionário por ID
        Funcionario funcionario = null;
        if (funcionario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        }
        return funcionario.calcularSalario();
    }

    @GetMapping("/{id}/rescisao")
    @ResponseStatus(HttpStatus.OK)
    public double calcularRescisao(@PathVariable int id) {
        // Lógica para buscar funcionário por ID
        Funcionario funcionario = null;
        if (funcionario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado");
        }
        return funcionario.calcularRescisao();
    }
}
