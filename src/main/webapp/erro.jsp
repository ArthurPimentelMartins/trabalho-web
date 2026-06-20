<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro - Controle de Estoque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="alert alert-danger">
        <h4 class="alert-heading">Ocorreu um erro</h4>
        <p>
            <%
                Object mensagemErro = request.getAttribute("mensagemErro");
            %>
            <%= mensagemErro != null ? mensagemErro : "Erro inesperado. Tente novamente." %>
        </p>
    </div>

    <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
</div>

</body>
</html>
