<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projetoweb.model.entity.Cliente" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes - Controle de Estoque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Clientes</h2>
        <div>
            <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
            <a href="cliente-cadastro.jsp" class="btn btn-primary">Novo Cliente</a>
        </div>
    </div>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <table class="table table-striped table-bordered align-middle">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
                if (listaClientes != null && !listaClientes.isEmpty()) {
                    for (Cliente cliente : listaClientes) {
            %>
            <tr>
                <td><%= cliente.getId() %></td>
                <td><%= cliente.getNome() %></td>
                <td><%= cliente.getEmail() %></td>
                <td><%= cliente.getTelefone() %></td>
                <td>
                    <a href="cliente?acao=prepararAtualizacao&id=<%= cliente.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                    <a href="cliente?acao=deletar&id=<%= cliente.getId() %>"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Tem certeza que deseja excluir este cliente?');">Excluir</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5" class="text-center text-muted">Nenhum cliente cadastrado.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</div>

</body>
</html>
