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

    // O POST é usado para enviar as credenciais de forma segura (escondidas no corpo da requisição)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String loginInput = request.getParameter("login");
        String senhaInput = request.getParameter("senha");

        try {
            // 1. Tenta autenticar usando o Service
            Usuario usuarioLogado = usuarioService.autenticar(loginInput, senhaInput);

            // 2. SE DEU CERTO: Criamos a Sessão (o "crachá" do utilizador)
            // O true significa: "Se não existir uma sessão, crie uma nova agora"
            HttpSession sessao = request.getSession(true);

            // Colocamos o objeto do utilizador dentro da sessão com a etiqueta "usuarioAutenticado"
            sessao.setAttribute("usuarioAutenticado", usuarioLogado);

            // 3. Redireciona para a página principal do sistema (o Menu)
            response.sendRedirect("index.jsp");

        } catch (Exception e) {
            // SE DEU ERRO (Senha errada ou campos vazios):
            // Devolvemos a mensagem de erro para o ecrã de login
            request.setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // O GET será usado para o botão "Sair" (Logout)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if ("sair".equals(acao)) {
            // Pega a sessão atual (false significa: não crie uma nova se não existir)
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                // Destrói a sessão (rasga o crachá)
                sessao.invalidate();
            }
            // Manda de volta para a tela de login
            response.sendRedirect("login.jsp");
        } else {
            // Se aceder a /login diretamente via GET, mostra a página de login
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}