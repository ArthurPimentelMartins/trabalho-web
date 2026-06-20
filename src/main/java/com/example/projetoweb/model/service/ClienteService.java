package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.ClienteDAO;
import com.example.projetoweb.model.entity.Cliente;
import java.util.List;

public class ClienteService {

    private ClienteDAO clienteDao;

    public ClienteService() {
        this.clienteDao = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        validarDadosCliente(cliente);
        clienteDao.cadastrar(cliente);
    }

    public void atualizarCliente(Cliente cliente) throws Exception {
        validarDadosCliente(cliente);
        clienteDao.atualizar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDao.listar();
    }

    public void deletarCliente(int id) {
        clienteDao.excluir(id);
    }

    public Cliente buscarPorId(int id) {
        return clienteDao.buscarPorId(id);
    }

    private void validarDadosCliente(Cliente cliente) throws Exception {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new Exception("Erro! Nome do cliente vazio");
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty() || !cliente.getEmail().contains("@")) {
            throw new Exception("Erro! Email sem @");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            throw new Exception("Erro! Telefone vazio");
        }
    }
}