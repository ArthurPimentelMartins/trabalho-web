<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes - Controle de Estoque</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" href="css/style.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

    <body>

    <nav class="navbar navbar-dark bg-dark shadow">

        <div class="container-fluid">

            <a class="navbar-brand d-flex align-items-center" href="index.jsp">

                <img src="src\main/webapp/img/logo.jpeg"
                     alt="Logo"
                     width="50"
                     height="50"
                     class="rounded me-3">

                <div>

                    <h5 class="mb-0">
                        Controle de Estoque
                    </h5>

                    <small>
                        Módulo de Clientes
                    </small>

                </div>

            </a>

        </div>

    </nav>

    <div class="container mt-5">

    </div>


    <div class="container mt-5">

        <div class="card shadow-lg p-4">

            <div class="d-flex justify-content-between align-items-center mb-4">

                <h2>
                    <i class="bi bi-person-vcard"></i>
                    Clientes
                </h2>

                <button
                    class="btn btn-success"
                    data-bs-toggle="modal"
                    data-bs-target="#modalCliente">

                    <i class="bi bi-plus-circle"></i>
                Novo Cliente

                </button>

            </div>

            <table class="table table-striped table-hover align-middle">

                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Ações</th>
                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td>1</td>
                        <td>João Silva</td>
                        <td>joao@email.com</td>
                        <td>(18) 99999-9999</td>

                        <td>
                            <button class="btn btn-warning btn-sm">
                                <i class="bi bi-pencil"></i>
                            </button>

                            <button class="btn btn-danger btn-sm">
                                <i class="bi bi-trash"></i>
                            </button>
                        </td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>Maria Souza</td>
                        <td>maria@email.com</td>
                        <td>(18) 98888-8888</td>

                        <td>
                            <button class="btn btn-warning btn-sm">
                                <i class="bi bi-pencil"></i>
                            </button>

                            <button class="btn btn-danger btn-sm">
                                <i class="bi bi-trash"></i>
                            </button>
                        </td>
                    </tr>

                </tbody>

            </table>

            <div class="mt-3">
                <a href="index.jsp" class="btn btn-secondary">
                    <i class="bi bi-arrow-left"></i>
                    Voltar
                </a>
            </div>

        </div>

    </div>

    <div class="modal fade" id="modalCliente" tabindex="-1">

    <div class="modal-dialog modal-lg">

        <div class="modal-content">

            <div class="modal-header">

                <h5 class="modal-title">
                    <i class="bi bi-person-plus-fill"></i>
                    Cadastro de Cliente
                </h5>

                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal">
                </button>

            </div>

            <div class="modal-body">

                <form action="ClienteServlet" method="post">

                    <div class="mb-3">

                        <label class="form-label">
                            Nome
                        </label>

                        <div class="input-group">

                            <span class="input-group-text">
                                <i class="bi bi-person"></i>
                            </span>

                            <input
                                type="text"
                                class="form-control"
                                name="nome"
                                placeholder="Digite o nome do cliente"
                                required>

                        </div>

                    </div>

                    <div class="mb-3">

                        <label class="form-label">
                            E-mail
                        </label>

                        <div class="input-group">

                            <span class="input-group-text">
                                <i class="bi bi-envelope"></i>
                            </span>

                            <input
                                type="email"
                                class="form-control"
                                name="email"
                                placeholder="Digite o e-mail"
                                required>

                        </div>

                    </div>

                    <div class="mb-3">

                        <label class="form-label">
                            Telefone
                        </label>

                        <div class="input-group">

                            <span class="input-group-text">
                                <i class="bi bi-telephone"></i>
                            </span>

                            <input
                                type="tel"
                                class="form-control"
                                name="telefone"
                                placeholder="(18) 99999-9999"
                                maxlength="15"
                                required>

                        </div>

                    </div>

                    <div class="text-end">

                        <button
                            type="button"
                            class="btn btn-secondary"
                            data-bs-dismiss="modal">

                            Cancelar

                        </button>

                        <button
                            type="submit"
                            class="btn btn-success">

                            Salvar

                        </button>

                    </div>

                </form>

            </div>

        </div>

    </div>

</div>

</body>

</html>