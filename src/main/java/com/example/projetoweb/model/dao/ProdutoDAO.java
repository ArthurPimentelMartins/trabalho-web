package com.example.projetoweb.model.dao;

import com.example.projetoweb.model.entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrar(Produto produto) {

        String sql = "INSERT INTO produto (nome_produto, preco, quantidade_estoque) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome_produto());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade_estoque());

            stmt.executeUpdate();

            System.out.println("Produto salvo com sucesso no Banco de Dados");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto no banco: " + e.getMessage(), e);
        }
    }

    public List<Produto> listar() {

        List<Produto> listaProdutos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade_estoque(rs.getInt("quantidade_estoque"));

                listaProdutos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os produtos: " + e.getMessage(), e);
        }

        return listaProdutos;
    }

    public void atualizar(Produto produto) {

        String sql = "UPDATE produto SET nome_produto = ?, preco = ?, quantidade_estoque = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome_produto());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade_estoque());

            stmt.setInt(4, produto.getId());

            stmt.executeUpdate();

            System.out.println("Produto atualizado com sucesso no banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o produto: " + e.getMessage(), e);
        }
    }

    public Produto buscarPorId(int id) {

        Produto produtoEncontrado = null;

        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    produtoEncontrado = new Produto();
                    produtoEncontrado.setId(rs.getInt("id"));
                    produtoEncontrado.setNome_produto(rs.getString("nome_produto"));
                    produtoEncontrado.setPreco(rs.getFloat("preco"));
                    produtoEncontrado.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o produto por ID: " + e.getMessage(), e);
        }

        return produtoEncontrado;
    }

    public void excluir(int id) {

        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Produto excluído com sucesso do banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o produto: " + e.getMessage(), e);
        }
    }
}
