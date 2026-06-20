<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projetoweb.model.entity.Produto" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produtos - Controle de Estoque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Produtos</h2>
        <div>
            <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
            <a href="produto-cadastro.jsp" class="btn btn-primary">Novo Produto</a>
        </div>
    </div>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <table class="table table-striped table-bordered align-middle">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nome do Produto</th>
                <th>Preço</th>
                <th>Estoque</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Produto> listaProdutos = (List<Produto>) request.getAttribute("listaProdutos");
                if (listaProdutos != null && !listaProdutos.isEmpty()) {
                    for (Produto produto : listaProdutos) {
            %>
            <tr>
                <td><%= produto.getId() %></td>
                <td><%= produto.getNome_produto() %></td>
                <td>R$ <%= String.format("%.2f", produto.getPreco()) %></td>
                <td><%= produto.getQuantidade_estoque() %></td>
                <td>
                    <a href="produto?acao=prepararAtualizacao&id=<%= produto.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                    <a href="produto?acao=deletar&id=<%= produto.getId() %>"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Tem certeza que deseja excluir este produto?');">Excluir</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5" class="text-center text-muted">Nenhum produto cadastrado.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</div>

</body>
</html>
