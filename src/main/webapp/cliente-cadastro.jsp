<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h2>Cadastro de Cliente</h2>

    <% if (request.getAttribute("mensagemErro") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("mensagemErro") %></div>
    <% } %>

    <form action="cliente?acao=cadastrar" method="post">

        <div class="mb-3">
            <label class="form-label">Nome</label>
            <input type="text" class="form-control" name="nome">
        </div>

        <div class="mb-3">
            <label class="form-label">E-mail</label>
            <input type="email" class="form-control" name="email">
        </div>

        <div class="mb-3">
            <label class="form-label">Telefone</label>
            <input type="text" class="form-control" name="telefone">
        </div>

        <a href="cliente?acao=listar" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">
            Salvar
        </button>

    </form>

</div>

</body>
</html>
