package br.com.fiap.restaurante.exceptions;

import br.com.fiap.restaurante.entities.Cliente;
import br.com.fiap.restaurante.entities.Endereco;

public class ValidationException {

    public static void validarCliente(Cliente cliente) throws Exception {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty() || !cliente.getNome().matches("[a-zA-ZÀ-ÿ ]+")) {
            throw new Exception("Nome inválido! Deve conter apenas letras e não pode ser vazio.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty() || !cliente.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Email inválido! Insira um email válido.");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty() || !cliente.getTelefone().matches("^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$")) {
            throw new Exception("Telefone inválido! Formato correto: (XX) XXXXX-XXXX.");
        }
    }

    public static void validarEndereco(Endereco endereco) throws Exception {
        if (endereco.getRua() == null || endereco.getRua().trim().length() < 3) {
            throw new Exception("Erro: Rua inválida. Deve ter pelo menos 3 caracteres.");
        }
        if (endereco.getCidade() == null || endereco.getCidade().trim().length() < 2) {
            throw new Exception("Erro: Cidade inválida. Deve ter pelo menos 2 caracteres.");
        }
        if (endereco.getEstado() == null || endereco.getEstado().trim().length() != 2 || !endereco.getEstado().matches("[A-Z]{2}")) {
            throw new Exception("Erro: Estado inválido. Deve ter exatamente 2 letras maiúsculas.");
        }
        if (endereco.getCep() == null || !endereco.getCep().matches("\\d{8}")) {
            throw new Exception("Erro: CEP inválido. Deve conter exatamente 8 números.");
        }
    }
}


