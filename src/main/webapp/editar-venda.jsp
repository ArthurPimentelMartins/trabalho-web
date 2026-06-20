<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projetoweb.model.entity.Venda" %>
<%@ page import="com.example.projetoweb.model.entity.Cliente" %>
<%@ page import="com.example.projetoweb.model.entity.Produto" %>
<%@ page import="com.example.projetoweb.model.service.ClienteService" %>
<%@ page import="com.example.projetoweb.model.service.ProdutoService" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Venda</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    Venda venda = (Venda) request.getAttribute("venda");
%>

<div class="container mt-5">
    <h2>Editar Venda</h2>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <% if (venda != null) { %>
    <form action="venda?acao=atualizar" method="post">

        <input type="hidden" name="id" value="<%= venda.getId() %>">

        <div class="mb-3">
            <label class="form-label">Cliente</label>
            <select class="form-select" name="idCliente" required>
                <%
                    List<Cliente> listaClientesEdicao = new ClienteService().listarClientes();
                    for (Cliente c : listaClientesEdicao) {
                        boolean selecionado = c.getId() == venda.getId_cliente();
                %>
                <option value="<%= c.getId() %>" <%= selecionado ? "selected" : "" %>><%= c.getNome() %></option>
                <%
                    }
                %>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Produto</label>
            <select class="form-select" name="idProduto" required>
                <%
                    List<Produto> listaProdutosEdicao = new ProdutoService().listarProdutos();
                    for (Produto p : listaProdutosEdicao) {
                        boolean selecionado = p.getId() == venda.getId_produto();
                %>
                <option value="<%= p.getId() %>" <%= selecionado ? "selected" : "" %>><%= p.getNome_produto() %></option>
                <%
                    }
                %>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Quantidade Comprada</label>
            <input type="number" class="form-control" name="quantidade" min="1" value="<%= venda.getQuantidade_comprada() %>">
        </div>

        <a href="venda?acao=listar" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
    <% } else { %>
        <p class="text-muted">Venda não encontrada.</p>
        <a href="venda?acao=listar" class="btn btn-secondary">Voltar</a>
    <% } %>
</div>

</body>
</html>
