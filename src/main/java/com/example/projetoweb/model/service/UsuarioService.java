package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.UsuarioDAO;
import com.example.projetoweb.model.entity.Usuario;

public class UsuarioService {

    private UsuarioDAO usuarioDao;

    public UsuarioService() {
        this.usuarioDao = new UsuarioDAO();
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {

        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new Exception("Erro! O login do usuário é obrigatório.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new Exception("Erro! A senha é obrigatória.");
        }

        if (usuario.getSenha().trim().length() < 4) {
            throw new Exception("Erro! Por questões de segurança, a senha deve ter pelo menos 4 caracteres.");
        }

        usuarioDao.cadastrar(usuario);
    }
}