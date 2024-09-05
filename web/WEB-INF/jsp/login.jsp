<%-- 
    Document   : login
    Created on : 05/09/2024, 14:41:30
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
        
        <form action="./logar" method="post">
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">CPF/User</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" name="cpf">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Senha</label>
            <input type="text" class="form-control" id="formGroupExampleInput" name="senha">
        </div>
        
            <button type="submit" class="btn btn-primary">Entrar</button>
        
        </form>
        
        <a href="./cadastro"><button>Cadastrar</button></a>

        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
