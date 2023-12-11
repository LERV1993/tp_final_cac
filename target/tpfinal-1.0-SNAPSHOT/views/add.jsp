<%-- 
    Document   : add
    Created on : 10 dic. 2023, 00:31:57
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Agregar usuarios</title>
    </head>
    <body style="display: flex;justify-content: center; align-items: center; min-height: 100vh;">

        <div style="width: 50%; min-height: 40vh; background-color: #f5f5f5; border-radius:  1rem; margin: auto;position: relative;">
            <h1 style="text-align: center; margin: 15px 0;"> Agregar Usuarios </h1>
            <form style="width: 95%; margin: auto;">

                <div class="input-group mb-3">
                    <span class="input-group-text" id="spanDni">DNI : </span>
                    <input type="text" name="txtDni" class="form-control" aria-label="dni" aria-describedby="input dni">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="spanDni">Nombre : </span>
                    <input type="text" name="txtName" class="form-control" aria-label="nombre" aria-describedby="input nombre">
                </div>

                <div style=" width: 50%; margin: auto; display: flex; justify-content: space-between; align-items: center;height: 6rem;">
                    <input  class="btn btn-success" type="submit" name="accion" value="agregar">
                    <a class="btn btn-warning" href="Controller?accion=listar"> Regresar </a>
                </div>

            </form>

        </div>

    </body>
</html>
