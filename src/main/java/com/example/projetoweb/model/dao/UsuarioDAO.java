package com.example.projetoweb.model.dao;

import com.example.projetoweb.model.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            stmt.executeUpdate();

            System.out.println("Usuario salvo com sucesso no Banco de Dados");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuario no banco: " + e.getMessage(), e);
        }
    }
    public List<Usuario> listar() {

        List<Usuario> listaUsuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os usuario: " + e.getMessage(), e);
        }

        return listaUsuarios;
    }

    public void atualizar(Usuario usuario) {

        String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            stmt.setInt(3, usuario.getId());

            stmt.executeUpdate();

            System.out.println("Usuario atualizado com sucesso no banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o usuario: " + e.getMessage(), e);
        }
    }

    public Usuario buscarPorId(int id) {

        Usuario usuarioEncontrado = null;

        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(rs.getInt("id"));
                    usuarioEncontrado.setLogin(rs.getString("login"));
                    usuarioEncontrado.setSenha(rs.getString("senha"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o usuario por ID: " + e.getMessage(), e);
        }

        return usuarioEncontrado;
    }

    public void excluir(int id) {

        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Usuario excluído com sucesso do banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o usuario: " + e.getMessage(), e);
        }
    }
}

