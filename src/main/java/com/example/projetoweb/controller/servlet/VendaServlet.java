package com.example.projetoweb.controller.servlet;

import com.example.projetoweb.model.entity.Venda;
import com.example.projetoweb.model.service.VendaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/venda")
public class VendaServlet extends HttpServlet {

    private VendaService vendaService;

    public VendaServlet() {
        this.vendaService = new VendaService();
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
                    response.sendRedirect("venda?acao=listar");
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
        String idClienteInput = request.getParameter("idCliente");
        String idProdutoInput = request.getParameter("idProduto");
        String quantidadeInput = request.getParameter("quantidade");

        try {
            // Conversão dos IDs e da quantidade para números inteiros
            int idCliente = Integer.parseInt(idClienteInput);
            int idProduto = Integer.parseInt(idProdutoInput);
            int quantidade = Integer.parseInt(quantidadeInput);

            Venda novaVenda = new Venda();
            novaVenda.setId_cliente(idCliente);
            novaVenda.setId_produto(idProduto);
            novaVenda.setQuantidade_comprada(quantidade);

            vendaService.realizarVenda(novaVenda);

            response.sendRedirect("venda?acao=listar");

        } catch (NumberFormatException e) {
            request.setAttribute("mensagemErro", "Erro! IDs e quantidades devem ser valores numéricos válidos.");
            request.getRequestDispatcher("cadastro-venda.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("cadastro-venda.jsp").forward(request, response);
        }
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idVenda = Integer.parseInt(request.getParameter("id"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            Venda venda = new Venda();
            venda.setId(idVenda);
            venda.setId_cliente(idCliente);
            venda.setId_produto(idProduto);
            venda.setQuantidade_comprada(quantidade);

            response.sendRedirect("venda?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", "Erro ao atualizar: " + e.getMessage());
            request.getRequestDispatcher("editar-venda.jsp").forward(request, response);
        }
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            response.sendRedirect("venda?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("venda?acao=listar").forward(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("lista-vendas.jsp").forward(request, response);
    }

    private void prepararAtualizacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("editar-venda.jsp").forward(request, response);
    }
}