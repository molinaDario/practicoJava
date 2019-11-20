<%-- 
    Document   : CanjeRealizado
    Created on : 29/10/2019, 21:58:37
    Author     : dario
--%>

<%@page import="com.molinadario.entity.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Canje realizado con exito</h1>
        <%Cliente cliente = (Cliente) request.getAttribute("ClienteUpdate");
           out.print(cliente);
        %>
    </body>
</html>
