package com.example.projetoweb.controller.servlet;

import com.example.projetoweb.model.entity.Cliente;
import com.example.projetoweb.model.service.ClienteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    private ClienteService clienteService;

    public ClienteServlet() {
        this.clienteService = new ClienteService();
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
                    response.sendRedirect("cliente?acao=listar");
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

        if(acao == null){
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

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nomeInput = request.getParameter("nome");
        String emailInput = request.getParameter("email");
        String telefoneInput = request.getParameter("telefone");

        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nomeInput);
        novoCliente.setEmail(emailInput);
        novoCliente.setTelefone(telefoneInput);

        try {
            clienteService.cadastrarCliente(novoCliente);
            response.sendRedirect("cliente?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("cliente-cadastro.jsp").forward(request, response);
        }
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");

            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);

            clienteService.atualizarCliente(cliente);

            response.sendRedirect("cliente?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("editar-cliente.jsp").forward(request, response);
        }
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            clienteService.deletarCliente(id);

            response.sendRedirect("cliente?acao=listar");

        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("cliente?acao=listar").forward(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("listaClientes", clienteService.listarClientes());
        request.getRequestDispatcher("lista-clientes.jsp").forward(request, response);
    }

    private void prepararAtualizacao(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("cliente", clienteService.buscarPorId(id));
        request.getRequestDispatcher("editar-cliente.jsp").forward(request, response);
    }
}