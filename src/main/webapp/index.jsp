<%-- 
    Document   : index
    Created on : 9 dic. 2023, 23:59:24
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Bienvenida</title>
    </head>
    <body style="display: flex;justify-content: center; align-items: center; min-height: 100vh;">

        <div style="width: 50%; min-height: 40vh; background-color: #f5f5f5; border-radius:  1rem; margin: auto;position: relative;">

            <h1 style="text-align: center; margin: 10px 0;"> Bienvenido al TP final de CAC </h1>

            <p  style="width: 95%; margin: 10px auto;text-align: center;"> El trabajo consta de un crud que se realiza con una aplicación web en java que permite el alta
                visualizacion, modificación y eliminación de usuarios. <br>

                ¡ Espero les guste ! </p>

            <div style="position: absolute; width: 100%; bottom: 0; display: flex; justify-content: center; align-items: center;height: 6rem;"> 

                <a class="btn btn-primary" href="Controller?accion=listar"> Ingresar </a>

            </div>
        </div>

    </body>
</html>
