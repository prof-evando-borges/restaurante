package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        System.out.println(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes() {
        Cliente cliente = new Cliente("Evando", "evando@gmail.com", "(11) 555-5555");
        cliente.setId(12);

        return List.of(cliente);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarPorId(@PathVariable int id) {
        Cliente cliente = new Cliente("Evando", "evando@gmail.com", "(11) 555-5555");
        cliente.setId(id);
        return cliente;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        System.out.println(cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        System.out.println("Cliente com ID " + id + " deletado.");
    }
}

