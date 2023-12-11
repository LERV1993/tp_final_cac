<%-- 
    Document   : edit
    Created on : 10 dic. 2023, 00:32:03
    Author     : lucas
--%>

<%@page import="models.Usuario"%>
<%@page import="dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar usuarios</title>
    </head>
    <body style="display: flex;justify-content: center; align-items: center; min-height: 100vh;">

        <div style="width: 50%; min-height: 40vh; background-color: #f5f5f5; border-radius:  1rem; margin: auto;position: relative;">
            <%
                UsuarioDao usuarioDao = new UsuarioDao();
                int id = Integer.parseInt(request.getAttribute("idUser").toString());
                Usuario usuario = (Usuario) usuarioDao.seeUser(id);
            %>
            <h1 style="text-align: center; margin: 15px 0;"> Editar Usuarios </h1>
            <form  style="width: 95%; margin: auto;">

                <input type="hidden" name="txtId" value="<%= usuario.getId()%>"> <br>


                <div class="input-group mb-3">
                    <span class="input-group-text" id="spanDni">DNI : </span>
                    <input type="text" name="txtDni" class="form-control" aria-label="dni" aria-describedby="input dni" value="<%= usuario.getDni()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="spanDni">Nombre : </span>
                    <input type="text" name="txtName" class="form-control" aria-label="nombre" aria-describedby="input nombre" value="<%= usuario.getName()%>">
                </div>

                <div style=" width: 50%; margin: auto; display: flex; justify-content: space-between; align-items: center;height: 6rem;">
                    <input class="btn btn-warning" type="submit" name="accion" value="actualizar">
                    <a class="btn btn-success" href="Controller?accion=listar"> Regresar </a>
                </div>
            </form>
        </div>

    </body>
</html>
