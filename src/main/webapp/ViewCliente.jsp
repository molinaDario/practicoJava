<%-- 
    Document   : ViewCliente
    Created on : 29/09/2019, 19:51:28
    Author     : dario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Clientes</h1>

        <table>
            <header>
                <th>Cod.</th>
                <th>Dni</th>
                <th>Nombre</th>  
                <th>Apellido</th>  
                <th>Direccion</th>  
                <th>Saldo</th>  
                <th>Puntos</th>  
            </header>
            <c:forEach var="clienteList" items="${requestScope.listCliente}">
                <tr>
                    <td>${clienteList.id_cliente}</td>
                    <td>${clienteList.dni}</td>
                    <td>${clienteList.nombre}</td>
                    <td>${clienteList.apellido}</td>
                    <td>${clienteList.direccion}</td>
                    <td>${clienteList.saldo}</td>
                    <td>${clienteList.puntos}</td>

                </tr>
            </c:forEach>

        </table>
        <br>
        <a href="MenuSeleccion.jsp">Regresar</a>
    </body>
</html>
