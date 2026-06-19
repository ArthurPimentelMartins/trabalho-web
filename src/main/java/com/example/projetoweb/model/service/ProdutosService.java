package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.ProdutoDAO;
import com.example.projetoweb.model.entity.Produto;

public class ProdutosService {

    private ProdutoDAO produtoDao;

    public ProdutosService() {
        this.produtoDao = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) throws Exception {

        if (produto.getNome_produto() == null || produto.getNome_produto().trim().isEmpty()) {
            throw new Exception("Erro! O nome do produto é obrigatório.");
        }

        if (produto.getPreco() <= 0) {
            throw new Exception("Erro! O preço do produto deve ser maior que zero.");
        }

        if (produto.getQuantidade_estoque() < 0) {
            throw new Exception("Erro! A quantidade em estoque não pode ser negativa.");
        }

        produtoDao.cadastrar(produto);
    }
}