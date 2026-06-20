<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Controle de Estoque</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>

<body>
<div class="container-fluid tela-login">

    <h1 class="titulo-empresa">APEX</h1>

    <div class="card-login">

        <h2 class="mb-4">Login</h2>

        <form action="login" method="post">

            <div class="mb-3">
                <label class="form-label">Usuário</label>
                <div class="input-group">
                        <span class="input-group-text">
                            <i class="bi bi-person"></i>
                        </span>
                    <input type="text" class="form-control" name="login" placeholder="Digite seu usuário" required>
                </div>
            </div> <div class="mb-4">
            <label class="form-label">Senha</label>
            <div class="input-group">
                        <span class="input-group-text">
                            <i class="bi bi-lock"></i>
                        </span>
                <input type="password" class="form-control" name="senha" placeholder="Digite sua senha" required>
            </div>
        </div> <div class="d-grid mt-3">
            <button type="submit" class="btn btn-primary">
                Acessar
            </button>
        </div>

        </form>

    </div>
</div>
</body>
</html>