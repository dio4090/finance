<%-- 
    Document   : EmployeeAdd
    Created on : 2 Oct, 2016, 12:29:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
    </head>
    <body>
        <div id="add">
        <h1> Adicionar Categoria</h1>
        <form action="CategoriaController" method="GET">
            <table>
                <tr>
                    <td> Nome da Categoria: </td>
                    <td><input type="text" name="cNome"></td>
                </tr>
                <tr>
                    <td> Id do Produto: </td>
                    <td><input type="text" name="cProduto"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="addCategoria" value="Add"></td>
                    
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>