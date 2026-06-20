    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projetoweb.model.entity.Cliente" %>
<%@ page import="com.example.projetoweb.model.entity.Produto" %>
<%@ page import="com.example.projetoweb.model.service.ClienteService" %>
<%@ page import="com.example.projetoweb.model.service.ProdutoService" %>
<!DOCTYPE html>
<html lang="pt-br">
    
<head>
    <meta charset="UTF-8">
    <title>Registrar Nova Venda</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-header bg-success text-white">
                    <h4 class="mb-0">Registrar Venda</h4>
                </div>
                <div class="card-body">

                    <% if (request.getAttribute("mensagemErro") != null) { %>
                        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
                    <% } %>

                    <form action="venda?acao=cadastrar" method="POST">
                        
                        <div class="mb-3">
                            <label for="idCliente" class="form-label">Cliente</label>
                            <select class="form-select" id="idCliente" name="idCliente" required>
                                <option value="">-- Selecione o Cliente --</option>
                                <%
                                    List<Cliente> listaClientesVenda = new ClienteService().listarClientes();
                                    for (Cliente c : listaClientesVenda) {
                                %>
                                <option value="<%= c.getId() %>"><%= c.getNome() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                        <div class="mb-3">
                            <label for="idProduto" class="form-label">Produto</label>
                            <select class="form-select" id="idProduto" name="idProduto" required>
                                <option value="">-- Selecione o Produto --</option>
                                <%
                                    List<Produto> listaProdutosVenda = new ProdutoService().listarProdutos();
                                    for (Produto p : listaProdutosVenda) {
                                %>
                                <option value="<%= p.getId() %>"><%= p.getNome_produto() %> (estoque: <%= p.getQuantidade_estoque() %>)</option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                        <div class="mb-3">
                            <label for="quantidade" class="form-label">Quantidade Comprada</label>
                            <input type="number" class="form-control" id="quantidade" name="quantidade" min="1" placeholder="Ex: 5" required>
                        </div>
                        
                        <div class="d-flex justify-content-between mt-4">
                            <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
                            <button type="submit" class="btn btn-success">Finalizar Venda</button>
                        </div>
                        
                    </form>
                    
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>