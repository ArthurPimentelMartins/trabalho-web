<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Produto</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-5">

    <h2>Cadastro de Produto</h2>

    <form>

        <div class="mb-3">
            <label class="form-label">Nome do Produto</label>
            <input type="text"
                   class="form-control"
                   name="nome_produto">
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
                   name="quantidade_estoque">
        </div>

        <button type="submit" class="btn btn-primary">
            Salvar Produto
        </button>

    </form>

</div>

</body>
</html>