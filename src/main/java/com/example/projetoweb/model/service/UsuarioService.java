package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.UsuarioDAO;
import com.example.projetoweb.model.entity.Usuario;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // ... (Os seus métodos existentes de cadastrar, listar, etc.) ...

    /**
     * Tenta autenticar um utilizador com as credenciais fornecidas.
     * @param login O login digitado.
     * @param senha A senha digitada.
     * @return O objeto Usuario se a autenticação for bem-sucedida.
     * @throws Exception Se as credenciais forem inválidas.
     */
    public Usuario autenticar(String login, String senha) throws Exception {
        if (login == null || login.trim().isEmpty()) {
            throw new Exception("O campo Login não pode estar vazio.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new Exception("O campo Senha não pode estar vazio.");
        }

        // Chama o DAO para procurar na base de dados
        Usuario usuarioAutenticado = usuarioDAO.buscarPorLoginESenha(login, senha);

        if (usuarioAutenticado == null) {
            // Se o DAO retornar null, significa que não encontrou ninguém com aquele login/senha
            throw new Exception("Login ou senha inválidos.");
        }

        return usuarioAutenticado;
    }
}