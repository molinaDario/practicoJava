<%-- 
    Document   : ViewProducto
    Created on : 29/09/2019, 22:10:22
    Author     : dario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos</h1>

        <table>
            <header>
                <th>Cod.</th>
                <th>Nombre</th>  
                <th>Descripcion</th>  
                <th>Stock</th>  
                <th>precio</th>  
            </header>
            <c:forEach var="productoList" items="${requestScope.allProducto}">
                <tr>
                    <td>${productoList.id_producto}</td>
                    <td>${productoList.nombre}</td>
                    <td>${productoList.descripcion}</td>
                    <td>${productoList.stock}</td>
                    <td>${productoList.precio}</td>
                </tr>
            </c:forEach>

        </table>
        <br>

        <a href="MenuSeleccion.jsp">Regresar</a>

    </body>
</html>
