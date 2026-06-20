<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projetoweb.model.entity.Usuario" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuários - Controle de Estoque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Usuários</h2>
        <div>
            <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
            <a href="usuario-cadastro.jsp" class="btn btn-primary">Novo Usuário</a>
        </div>
    </div>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <table class="table table-striped table-bordered align-middle">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
                if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
                    for (Usuario usuario : listaUsuarios) {
            %>
            <tr>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getLogin() %></td>
                <td>
                    <a href="usuario?acao=prepararAtualizacao&id=<%= usuario.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                    <a href="usuario?acao=deletar&id=<%= usuario.getId() %>"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Tem certeza que deseja excluir este usuário?');">Excluir</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3" class="text-center text-muted">Nenhum usuário cadastrado.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <p class="text-muted small">Por segurança, as senhas não são exibidas na listagem.</p>

</div>

</body>
</html>
