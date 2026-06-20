<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produto</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-5">

    <h2>Cadastro de Produto</h2>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <form action="produto?acao=cadastrar" method="post">

        <div class="mb-3">
            <label class="form-label">Nome do Produto</label>
            <input type="text"
                   class="form-control"
                   name="nome">
        </div>

        <div class="mb-3">
            <label class="form-label">Preço</label>
            <input type="number"
                   step="0.01"
                   class="form-control"
                   name="preco">
        </div>

        <div class="mb-3">
            <label class="form-label">Quantidade em Estoque</label>
            <input type="number"
                   class="form-control"
                   name="estoque">
        </div>

        <a href="produto?acao=listar" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">
            Salvar Produto
        </button>

    </form>

</div>

</body>
</html>