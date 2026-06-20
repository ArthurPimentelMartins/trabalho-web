<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.projetoweb.model.entity.Cliente" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<div class="container mt-5">
    <h2>Editar Cliente</h2>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <% if (cliente != null) { %>
    <form action="cliente?acao=atualizar" method="post">

        <input type="hidden" name="id" value="<%= cliente.getId() %>">

        <div class="mb-3">
            <label class="form-label">Nome</label>
            <input type="text" class="form-control" name="nome" value="<%= cliente.getNome() %>">
        </div>

        <div class="mb-3">
            <label class="form-label">E-mail</label>
            <input type="email" class="form-control" name="email" value="<%= cliente.getEmail() %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Telefone</label>
            <input type="text" class="form-control" name="telefone" value="<%= cliente.getTelefone() %>">
        </div>

        <a href="cliente?acao=listar" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
    <% } else { %>
        <p class="text-muted">Cliente não encontrado.</p>
        <a href="cliente?acao=listar" class="btn btn-secondary">Voltar</a>
    <% } %>
</div>

</body>
</html>
