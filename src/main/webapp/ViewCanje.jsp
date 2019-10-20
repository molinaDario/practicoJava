<%-- 
    Document   : ViewCanje
    Created on : 30/09/2019, 20:24:39
    Author     : dario
--%>

<%@page import="com.molinadario.entity.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Canje</h1>

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

        <h2>Seleccione articulo</h2>

        <form  action="CanjeProducto" method="POST">

            <br>
            <c:forEach var="productoList" items="${requestScope.allProducto}">
                <label><input type="checkbox" name="productos" value="${productoList.getPrecio()}"> ${productoList.getNombre()}</label><br>
                <br>
            </c:forEach>
            <br>
            <input type="submit" value="Canjear">

        </form>

        <h2>Carro de compra</h2>
   
        <br>
        <h2>Cliente</h2>

        <%  Cliente cliente = (Cliente) request.getAttribute("Cliente");
            out.print(cliente.toString());
        %>

        <br>

    </body>
</html>
