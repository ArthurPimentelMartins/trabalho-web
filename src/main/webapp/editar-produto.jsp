<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.projetoweb.model.entity.Produto" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Produto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    Produto produto = (Produto) request.getAttribute("produto");
%>

<div class="container mt-5">
    <h2>Editar Produto</h2>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <% if (produto != null) { %>
    <form action="produto?acao=atualizar" method="post">

        <input type="hidden" name="id" value="<%= produto.getId() %>">

        <div class="mb-3">
            <label class="form-label">Nome do Produto</label>
            <input type="text" class="form-control" name="nome" value="<%= produto.getNome_produto() %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Preço</label>
            <input type="number" step="0.01" class="form-control" name="preco" value="<%= produto.getPreco() %>">
        </div>

        <div class="mb-3">
            <label class="form-label">Quantidade em Estoque</label>
            <input type="number" class="form-control" name="estoque" value="<%= produto.getQuantidade_estoque() %>">
        </div>

        <a href="produto?acao=listar" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
    <% } else { %>
        <p class="text-muted">Produto não encontrado.</p>
        <a href="produto?acao=listar" class="btn btn-secondary">Voltar</a>
    <% } %>
</div>

</body>
</html>
