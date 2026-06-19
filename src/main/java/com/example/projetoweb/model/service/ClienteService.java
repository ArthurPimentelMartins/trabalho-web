package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.ClienteDAO;
import com.example.projetoweb.model.entity.Cliente;

public class ClienteService {

    private ClienteDAO clienteDao;

    public ClienteService() {
        this.clienteDao = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new Exception("Erro! Nome do cliente vazio");
        }

        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty() || !cliente.getEmail().contains("@")) {
            throw new Exception("Erro! Email sem @");
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            throw new Exception("Erro! Telefone vazio");
        }

        clienteDao.cadastrar(cliente);
    }
}
