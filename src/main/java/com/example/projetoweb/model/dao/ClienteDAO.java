package com.example.projetoweb.model.dao;

import com.example.projetoweb.model.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void cadastrar(Cliente cliente) {

        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();

            System.out.println("Cliente salvo com sucesso no Banco de Dados");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente no banco: " + e.getMessage(), e);
        }
    }

    public List<Cliente> listar() {

        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));

                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os produtos: " + e.getMessage(), e);
        }

        return listaClientes;
    }

    public void atualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());

            stmt.setInt(4, cliente.getId());

            stmt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso no banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o cliente: " + e.getMessage(), e);
        }
    }

    public Cliente buscarPorId(int id) {

        Cliente clienteEncontrado = null;

        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    clienteEncontrado = new Cliente();
                    clienteEncontrado.setId(rs.getInt("id"));
                    clienteEncontrado.setNome(rs.getString("nome"));
                    clienteEncontrado.setEmail(rs.getString("email"));
                    clienteEncontrado.setTelefone(rs.getString("telefone"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o produto por ID: " + e.getMessage(), e);
        }

        return clienteEncontrado;
    }

    public void excluir(int id) {

        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Cliente excluído com sucesso do banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o cliente: " + e.getMessage(), e);
        }
    }
}

