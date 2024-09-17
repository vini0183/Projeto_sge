<%-- 
    Document   : inicio
    Created on : 05/09/2024, 16:52:10
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
        <form method="post" action="logout">
            <button type="submit"> Logout</button>
        </form>
        
        <p>id: ${id_professor}</p>
        <p>Bem vindo Professor ${nome} !!</p>
        <img src="${imagens}" alt="iconeProfessor"> 
        
        

    </body>
</html>
