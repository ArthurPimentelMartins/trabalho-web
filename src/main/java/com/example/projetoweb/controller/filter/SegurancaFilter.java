package com.example.projetoweb.controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class SegurancaFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        boolean isRotaPublica = uri.endsWith("login.jsp") || uri.endsWith("/login") || uri.contains("/css/") || uri.contains("/img/");

        if (isRotaPublica) {
            chain.doFilter(request, response);
        } else {
            HttpSession sessao = req.getSession(false);

            boolean isLogado = (sessao != null && sessao.getAttribute("usuarioAutenticado") != null);

            if (isLogado) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        }
    }

    @Override
    public void destroy() { }
}