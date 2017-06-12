<%-- 
    Document   : Success
    Created on : 2 Oct, 2016, 12:39:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#deleteFornecedor").hide();
     $("#updateFornecedor").hide();
    
    $("#update").click(function(){
        $("#updateFornecedor").show();
        $("#deleteFornecedor").hide();
    });
    $("#delete").click(function(){
        $("#deleteFornecedor").show();
         $("#updateFornecedor").hide();
    });
});
</script>
    </head>
    <body>
        Todos os Fornecedores: <br> 
        <c:forEach var="for" items="${fornecedorList}">
            Fornecedor ID: ${for.id} <br>
            Fornecedor Razao Social: ${for.fRazaoSocial} <br>
            Fornecedor CNPJ: ${for.fCnpj}<br>
            Fornecedor Email: ${for.fEmail}<br>
            Fornecedor Endereco: ${for.fEndereco}<br>
            Fornecedor Telefone: ${for.fTelefone}<br>
            -------------------------------------<br>
        </c:forEach>
        
        <form action="FornecedorController" method="POST">
            Update: <input type="checkbox" id="update"> Delete: <input type="checkbox" id="delete" onclick="document.getElementById('fRazaoSocial').disabled=this.checked;document.getElementById('fnumberupdate').disabled=this.checked;"><br><br>
            <select name="id">
                <c:forEach items="${fornecedorList}" var="fornecedor">
                <option value="${fornecedor.id}">${fornecedor.id}</option>
                 </c:forEach>
            </select>
            
            <br>
            Update Name: <input id="ename" type="text" name="ename"><br>
            Update Number: <input id="enumberupdate" type="text" name="enumberupdate"> <br><br>
            <button type="submit" id="updateFornecedor" name="updateFornecedor"> Update</button> <br> <br>
            <button type="submit" id="deleteFornecedor" name="deleteFornecedor"> Delete </button>
            
            
               
       
        </form>
    </body>
</html>
