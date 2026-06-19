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
                    
                    <form action="VendaController" method="POST">
                        
                        <div class="mb-3">
                            <label for="id_cliente" class="form-label">Cliente</label>
                            <select class="form-select" id="id_cliente" name="id_cliente" required>
                                <option value="">-- Selecione o Cliente --</option>
                                <option value="1">João Silva</option>
                                <option value="2">Maria Oliveira</option>
                            </select>
                        </div>
                        
                        <div class="mb-3">
                            <label for="id_produto" class="form-label">Produto</label>
                            <select class="form-select" id="id_produto" name="id_produto" required>
                                <option value="">-- Selecione o Produto --</option>
                                <option value="1">Notebook Intel i7</option>
                                <option value="2">Mouse Sem Fio</option>
                            </select>
                        </div>
                        
                        <div class="mb-3">
                            <label for="quantidade_comprada" class="form-label">Quantidade Comprada</label>
                            <input type="number" class="form-control" id="quantidade_comprada" name="quantidade_comprada" min="1" placeholder="Ex: 5" required>
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