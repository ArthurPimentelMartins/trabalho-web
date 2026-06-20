<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.projetoweb.model.entity.Usuario" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuário</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<div class="container mt-5">
    <h2>Editar Usuário</h2>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <% if (usuario != null) { %>
    <form action="usuario?acao=atualizar" method="post">

        <input type="hidden" name="id" value="<%= usuario.getId() %>">

        <div class="mb-3">
            <label class="form-label">Login</label>
            <input type="text" class="form-control" name="login" value="<%= usuario.getLogin() %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Senha</label>
            <input type="password" class="form-control" name="senha" value="<%= usuario.getSenha() %>">
        </div>

        <a href="usuario?acao=listar" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
    <% } else { %>
        <p class="text-muted">Usuário não encontrado.</p>
        <a href="usuario?acao=listar" class="btn btn-secondary">Voltar</a>
    <% } %>
</div>

</body>
</html>
