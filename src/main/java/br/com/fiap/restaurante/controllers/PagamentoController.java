package br.com.fiap.restaurante.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.restaurante.entities.Pagamento;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/pagamentos")
public class PagamentoController {

    // Simulando um banco de dados com uma lista
    private static final List<Pagamento> pagamentos = new ArrayList<>();
    private static int contadorId = 1;
    static {
        Pagamento pagamentoTest = new Pagamento(50.0, "Credito");
        pagamentoTest.setId(contadorId);
        contadorId++;
        pagamentos.add(pagamentoTest);
    }

    // Métodos para manipulação de pagamentos
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> getTodosPagamentos() {
        return pagamentos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getPagamentoPorId(@PathVariable int id) {
        
        for (Pagamento pagamento : pagamentos){
            if (pagamento.getId() == id) {
                return pagamento.toString();
            } 
        }
        throw new RuntimeException("Pagamento não encontrado com o ID: " + id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String postPagamento(@RequestBody Pagamento pagamento) {
        pagamento.setId(contadorId++);
        pagamentos.add(pagamento);
        return pagamento.toString();
    }    
    
}