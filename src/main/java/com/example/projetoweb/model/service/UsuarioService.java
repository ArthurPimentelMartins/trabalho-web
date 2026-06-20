package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.UsuarioDAO;
import com.example.projetoweb.model.entity.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticar(String login, String senha) throws Exception {
        if (login == null || login.trim().isEmpty()) {
            throw new Exception("O campo Login não pode estar vazio.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new Exception("O campo Senha não pode estar vazio.");
        }

        Usuario usuarioAutenticado = usuarioDAO.buscarPorLoginESenha(login, senha);

        if (usuarioAutenticado == null) {
            throw new Exception("Login ou senha inválidos.");
        }

        return usuarioAutenticado;
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new Exception("O login é obrigatório para cadastro.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new Exception("A senha é obrigatória para cadastro.");
        }

        usuarioDAO.cadastrar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar();
    }

    public void atualizarUsuario(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new Exception("O login não pode ser vazio na atualização.");
        }
        usuarioDAO.atualizar(usuario);
    }

    public void deletarUsuario(int id) {
        usuarioDAO.excluir(id);
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }
}