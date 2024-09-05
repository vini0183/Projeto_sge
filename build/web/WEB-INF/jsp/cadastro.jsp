<%-- 
    Document   : cadastro
    Created on : 05/09/2024, 14:02:34
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Cadastrar</h1>


        <form method="post" action="./cadastro">
            
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Nome</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="nome">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Matricula</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" name="matricula">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">Admissão</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" name="admissao">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Senha</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="senha">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">CPF/User</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" name="cpf">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">FK</label>
                <input type="number" class="form-control" id="formGroupExampleInput2" name="area_id">
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>

        </form>
        
        <a href="./login"><button>Voltar Login</button></a>







        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
