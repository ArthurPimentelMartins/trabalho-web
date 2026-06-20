package com.example.projetoweb.controller.servlet;

import com.example.projetoweb.model.entity.Produto;

import com.example.projetoweb.model.service.ProdutosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {

    private ProdutosService produtoService;

    public ProdutoServlet() {
        this.produtoService = new ProdutosService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String acao = request.getParameter("acao");

        if (acao == null) {
            acao = "listar";
        }

        try {
            switch (acao) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;
                case "atualizar":
                    atualizar(request, response);
                    break;
                case "deletar":
                    deletar(request, response);
                    break;
                default:
                    response.sendRedirect("produto?acao=listar");
            }
        } catch (Exception e) {
            request.setAttribute("mensagemErro", "Erro inesperado: " + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            acao = "listar";
        }

        try {
            switch (acao) {
                case "listar":
                    listar(request, response);
                    break;
                case "prepararAtualizacao":
                    prepararAtualizacao(request, response);
                    break;
                default:
                    doPost(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("mensagemErro", "Erro inesperado: " + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeInput = request.getParameter("nome");
        String precoInput = request.getParameter("preco");
        String estoqueInput = request.getParameter("estoque");

        try {
            float preco = Float.parseFloat(precoInput);
            int estoque = Integer.parseInt(estoqueInput);

            Produto novoProduto = new Produto();
            novoProduto.setNome_produto(nomeInput);
            novoProduto.setPreco(preco);
            novoProduto.setQuantidade_estoque(estoque);

            produtoService.cadastrarProduto(novoProduto);
            response.sendRedirect("produto?acao=listar");

        } catch (NumberFormatException e) {

            request.setAttribute("mensagemErro", "Erro! Certifique-se de digitar valores numéricos válidos para Preço e Estoque.");
            request.getRequestDispatcher("cadastro-produto.jsp").forward(request, response);
        } catch (Exception e) {

            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("cadastro-produto.jsp").forward(request, response);
        }
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            float preco = Float.parseFloat(request.getParameter("preco"));
            int estoque = Integer.parseInt(request.getParameter("estoque"));

            Produto produto = new Produto();
            produto.setId(id);
            produto.setNome_produto(nome);
            produto.setPreco(preco);
            produto.setQuantidade_estoque(estoque);

            response.sendRedirect("produto?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", "Erro ao atualizar: " + e.getMessage());
            request.getRequestDispatcher("editar-produto.jsp").forward(request, response);
        }
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            response.sendRedirect("produto?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("produto?acao=listar").forward(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("lista-produtos.jsp").forward(request, response);
    }

    private void prepararAtualizacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("editar-produto.jsp").forward(request, response);
    }
}