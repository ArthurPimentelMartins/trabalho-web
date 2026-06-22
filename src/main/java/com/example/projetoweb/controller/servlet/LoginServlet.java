package com.example.projetoweb.controller.servlet;

import com.example.projetoweb.model.entity.Usuario;
import com.example.projetoweb.model.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioService usuarioService;

    public LoginServlet() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String loginInput = request.getParameter("login");
        String senhaInput = request.getParameter("senha");

        try {
            Usuario usuarioLogado = usuarioService.autenticar(loginInput, senhaInput);

            HttpSession sessao = request.getSession(true);

            sessao.setAttribute("usuarioAutenticado", usuarioLogado);

            response.sendRedirect("index.jsp");

        } catch (Exception e) {
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}