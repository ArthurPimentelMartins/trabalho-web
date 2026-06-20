package com.example.projetoweb.controller.servlet;

import com.example.projetoweb.model.entity.Usuario;
import com.example.projetoweb.model.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private UsuarioService usuarioService;

    public UsuarioServlet() {
        this.usuarioService = new UsuarioService();
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
                    response.sendRedirect("usuario?acao=listar");
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
        String loginInput = request.getParameter("login");
        String senhaInput = request.getParameter("senha");

        try {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setLogin(loginInput);
            novoUsuario.setSenha(senhaInput);

            usuarioService.cadastrarUsuario(novoUsuario);

            response.sendRedirect("usuario?acao=listar");

        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("usuario-cadastro.jsp").forward(request, response);
        }
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setLogin(login);
            usuario.setSenha(senha);

            usuarioService.atualizarUsuario(usuario);

            response.sendRedirect("usuario?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", "Erro ao atualizar: " + e.getMessage());
            request.getRequestDispatcher("editar-usuario.jsp").forward(request, response);
        }
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            usuarioService.deletarUsuario(id);

            response.sendRedirect("usuario?acao=listar");
        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("usuario?acao=listar").forward(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listaUsuarios", usuarioService.listarUsuarios());
        request.getRequestDispatcher("lista-usuarios.jsp").forward(request, response);
    }

    private void prepararAtualizacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("usuario", usuarioService.buscarPorId(id));
        request.getRequestDispatcher("editar-usuario.jsp").forward(request, response);
    }
}