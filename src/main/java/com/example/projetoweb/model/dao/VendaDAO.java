package com.example.projetoweb.model.dao;

import com.example.projetoweb.model.entity.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public void cadastrar(Venda venda) {
        String sqlVenda = "INSERT INTO venda (id_cliente, id_produto, quantidade_comprada) VALUES (?, ?, ?)";
        String sqlEstoque = "UPDATE produto SET quantidade_estoque = quantidade_estoque - ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda);
             PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque)) {

            stmtVenda.setInt(1, venda.getId_cliente());
            stmtVenda.setInt(2, venda.getId_produto());
            stmtVenda.setInt(3, venda.getQuantidade_comprada());
            stmtVenda.executeUpdate();

            stmtEstoque.setInt(1, venda.getQuantidade_comprada());
            stmtEstoque.setInt(2, venda.getId_produto());
            stmtEstoque.executeUpdate();

            System.out.println("Venda cadastrada e estoque atualizado no Banco de Dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar venda: " + e.getMessage(), e);
        }
    }

    public List<Venda> listar() {
        List<Venda> listaVendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setId_cliente(rs.getInt("id_cliente"));
                venda.setId_produto(rs.getInt("id_produto"));
                venda.setQuantidade_comprada(rs.getInt("quantidade_comprada"));

                listaVendas.add(venda);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar as vendas: " + e.getMessage(), e);
        }
        return listaVendas;
    }

    public Venda buscarPorId(int id) {
        Venda vendaEncontrada = null;
        String sql = "SELECT * FROM venda WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vendaEncontrada = new Venda();
                    vendaEncontrada.setId(rs.getInt("id"));
                    vendaEncontrada.setId_cliente(rs.getInt("id_cliente"));
                    vendaEncontrada.setId_produto(rs.getInt("id_produto"));
                    vendaEncontrada.setQuantidade_comprada(rs.getInt("quantidade_comprada"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar a venda por ID: " + e.getMessage(), e);
        }
        return vendaEncontrada;
    }

    public void atualizar(Venda venda) {
        String sql = "UPDATE venda SET id_cliente = ?, id_produto = ?, quantidade_comprada = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getId_cliente());
            stmt.setInt(2, venda.getId_produto());
            stmt.setInt(3, venda.getQuantidade_comprada());
            stmt.setInt(4, venda.getId());

            stmt.executeUpdate();

            System.out.println("Venda atualizada com sucesso no banco de dados!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a venda: " + e.getMessage(), e);
        }
    }

    public void excluir(int id) {

        Venda vendaCancelada = buscarPorId(id);

        if (vendaCancelada != null) {

            String sqlEstoque = "UPDATE produto SET quantidade_estoque = quantidade_estoque + ? WHERE id = ?";

            String sqlVenda = "DELETE FROM venda WHERE id = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque);
                 PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda)) {

                stmtEstoque.setInt(1, vendaCancelada.getQuantidade_comprada());
                stmtEstoque.setInt(2, vendaCancelada.getId_produto());
                stmtEstoque.executeUpdate();

                stmtVenda.setInt(1, id);
                stmtVenda.executeUpdate();

                System.out.println("Venda cancelada e estoque devolvido com sucesso!");

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao cancelar a venda: " + e.getMessage(), e);
            }
        } else {
            System.out.println("Venda não encontrada para exclusão.");
        }
    }
}