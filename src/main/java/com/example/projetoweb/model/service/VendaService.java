package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.ProdutoDAO;
import com.example.projetoweb.model.dao.VendaDAO;
import com.example.projetoweb.model.entity.Produto;
import com.example.projetoweb.model.entity.Venda;

public class VendaService {

    private VendaDAO vendaDao;
    private ProdutoDAO produtoDao;

    public VendaService() {
        this.vendaDao = new VendaDAO();
        this.produtoDao = new ProdutoDAO();
    }

    public void realizarVenda(Venda venda) throws Exception {

        if (venda.getQuantidade_comprada() <= 0) {
            throw new Exception("Erro! A quantidade comprada deve ser maior que zero");
        }

        Produto produtoEstoque = produtoDao.buscarPorId(venda.getId_produto());

        if (produtoEstoque == null) {
            throw new Exception("Erro! Produto não encontrado");
        }

        if (produtoEstoque.getQuantidade_estoque() < venda.getQuantidade_comprada()) {
            throw new Exception("Erro! Estoque insuficiente para esta venda.");
        }

        vendaDao.cadastrar(venda);
    }
}
