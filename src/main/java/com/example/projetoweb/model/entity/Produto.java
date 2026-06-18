package com.example.projetoweb.model.entity;

public class Produto {

    private int id;
    private String nome_produto;
    private float preco;
    private int quantidade_estoque;

    public Produto() {

    }

    public Produto (int id, String nome_produto, float preco, int quantidade_estoque) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.preco = preco;
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
}
