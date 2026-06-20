package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.ProdutoDAO;
import com.example.projetoweb.model.entity.Produto;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDao;

    public ProdutoService() {
        this.produtoDao = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) throws Exception {
        validarDadosProduto(produto);
        produtoDao.cadastrar(produto);
    }

    public void atualizarProduto(Produto produto) throws Exception {
        validarDadosProduto(produto);
        produtoDao.atualizar(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoDao.listar();
    }

    public void deletarProduto(int id) {
        produtoDao.excluir(id);
    }

    public Produto buscarPorId(int id) {
        return produtoDao.buscarPorId(id);
    }

    private void validarDadosProduto(Produto produto) throws Exception {
        if (produto.getNome_produto() == null || produto.getNome_produto().trim().isEmpty()) {
            throw new Exception("Erro! O nome do produto é obrigatório.");
        }
        if (produto.getPreco() <= 0) {
            throw new Exception("Erro! O preço do produto deve ser maior que zero.");
        }
        if (produto.getQuantidade_estoque() < 0) {
            throw new Exception("Erro! A quantidade em estoque não pode ser negativa.");
        }
    }
}