<%-- 
    Document   : list
    Created on : 10 dic. 2023, 00:32:13
    Author     : lucas
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="models.Usuario"%>
<%@page import="dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista de usuarios</title>
    </head>
    <body>

        <div style="width: 95%;margin: auto;">

            <h1  style="text-align: center; margin-top: 15px;">Usuarios</h1>

            <a class="btn btn-success" href="Controller?accion=add" style="margin: 10px 0"> Agregar usuario </a>

            <table  class="table table-bordered" style="width: 100%;">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRE</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%

                        UsuarioDao dao = new UsuarioDao();
                        List<Usuario> list = dao.listUsers();
                        Iterator<Usuario> iter = list.iterator();
                        Usuario user = new Usuario();
                        while (iter.hasNext()) {

                            user = iter.next();

                    %>
                    <tr>
                        <td>
                            <%= user.getId()%>
                        </td>
                        <td>
                            <%= user.getDni()%>
                        </td>
                        <td>
                            <%= user.getName()%>
                        </td>
                        <td>
                            <a class="btn btn-warning" href="Controller?accion=editar&id=<%= user.getId()%>"> Editar </a>

                            <!-- Abrir modal eliminar usuario -->
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#eliminarUsuario<%= user.getId()%>">
                                Eliminar usuario
                            </button>

                            <!-- Modal eliminar usuario-->
                            <div class="modal fade" id="eliminarUsuario<%= user.getId()%>" tabindex="-1" aria-labelledby="eliminarUsuarioLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel"> Eliminar usuario </h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Se va a eliminar el usuario con nombre:  <%= user.getName()%>  <br>
                                            ¿Confirma acción?
                                        </div>
                                        <div class="modal-footer">
                                            <a class="btn btn-danger" href="Controller?accion=eliminar&id=<%= user.getId()%>"> Eliminar </a>
                                            <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Cancelar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        
                        </td>
                    </tr>
                    <%                        }
                    %>
                </tbody>
            </table>

        </div>
                
                
                <script src="./js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
