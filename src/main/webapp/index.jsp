<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Principal - Controle de Estoque</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <header class="cabecalho">
        <h1>APEX</h1>

        <img src="img/logo.jpeg" alt="Logo da Empresa" class="logo">
    </header>

    <main class="area-principal">

        <div class="menu-card">

            <h2>Consultar</h2>

            <div class="menu-grid">

                <a href="cliente?acao=listar" class="opcao-menu">
                    <i class="bi bi-person-vcard"></i>
                    <span>Cliente</span>
                </a>

                <a href="produto?acao=listar" class="opcao-menu">
                    <i class="bi bi-bag fill"></i>
                    <span>Produto</span>
                </a>

                <a href="usuario?acao=listar" class="opcao-menu">
                    <i class="bi bi-person-lock"></i>
                    <span>Usuário</span>
                </a>

                <a href="venda?acao=listar" class="opcao-menu">
                    <i class="bi bi-cart"></i>
                    <span>Venda</span>
                </a>

            </div>

        </div>

    </main>

</body>

</html>