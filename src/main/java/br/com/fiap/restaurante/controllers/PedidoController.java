package br.com.fiap.restaurante.controllers;

import br.com.fiap.restaurante.entities.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvar(@RequestBody Pedido pedido) {
        return null;
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable int id, @RequestBody Pedido pedido) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable int id) {
        System.out.println("Pedido deletado com sucesso");
    }
}