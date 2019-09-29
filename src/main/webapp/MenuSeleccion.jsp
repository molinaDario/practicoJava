<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/logginStyle.css">
    </head>
    <body>

        <div class="login-user">

            <img class="logoJava" src="imag/java.jpeg">
            <h1>Menu</h1>

            <form action="ClienteController" method="get">
                <input type="submit" value="Cliente">
            </form>
            
            <form action="ProductoController" method="get">
                <input type="submit" value="Producto">
            </form>
            
            <form action="CanjeController" method="get">
                <input type="submit" value="Canje">
            </form>

        </div>
    </body>
</html>
