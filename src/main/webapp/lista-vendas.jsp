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
    <title>Vendas - Controle de Estoque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    ClienteService clienteServiceVendas = new ClienteService();
    ProdutoService produtoServiceVendas = new ProdutoService();
%>

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Vendas</h2>
        <div>
            <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
            <a href="venda-cadastro.jsp" class="btn btn-primary">Nova Venda</a>
        </div>
    </div>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <table class="table table-striped table-bordered align-middle">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Cliente</th>
                <th>Produto</th>
                <th>Quantidade</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Venda> listaVendas = (List<Venda>) request.getAttribute("listaVendas");
                if (listaVendas != null && !listaVendas.isEmpty()) {
                    for (Venda venda : listaVendas) {
                        Cliente clienteVenda = clienteServiceVendas.buscarPorId(venda.getId_cliente());
                        Produto produtoVenda = produtoServiceVendas.buscarPorId(venda.getId_produto());
            %>
            <tr>
                <td><%= venda.getId() %></td>
                <td><%= clienteVenda != null ? clienteVenda.getNome() : "Cliente #" + venda.getId_cliente() %></td>
                <td><%= produtoVenda != null ? produtoVenda.getNome_produto() : "Produto #" + venda.getId_produto() %></td>
                <td><%= venda.getQuantidade_comprada() %></td>
                <td>
                    <a href="venda?acao=prepararAtualizacao&id=<%= venda.getId() %>" class="btn btn-sm btn-warning">Editar</a>
                    <a href="venda?acao=deletar&id=<%= venda.getId() %>"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Tem certeza que deseja cancelar esta venda? O estoque será devolvido.');">Excluir</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5" class="text-center text-muted">Nenhuma venda registrada.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</div>

</body>
</html>
