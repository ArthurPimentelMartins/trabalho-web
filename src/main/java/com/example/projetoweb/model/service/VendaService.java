package com.example.projetoweb.model.service;

import com.example.projetoweb.model.dao.ProdutoDAO;
import com.example.projetoweb.model.dao.VendaDAO;
import com.example.projetoweb.model.entity.Produto;
import com.example.projetoweb.model.entity.Venda;
import java.util.List;

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

    public List<Venda> listarVendas() {
        return vendaDao.listar();
    }

    public void atualizarVenda(Venda venda) throws Exception {
        vendaDao.atualizar(venda);
    }

    public void deletarVenda(int id) {
        vendaDao.excluir(id);
    }

    public Venda buscarPorId(int id) {
        return vendaDao.buscarPorId(id);
    }
}