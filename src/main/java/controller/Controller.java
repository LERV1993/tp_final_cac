package controller;

import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Usuario;

public class Controller extends HttpServlet {

    String listar = "views/list.jsp";
    String add = "views/add.jsp";
    String edit = "views/edit.jsp";
    Usuario usuario = new Usuario();
    UsuarioDao usuarioDao = new UsuarioDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("agregar")) {

            String dni = request.getParameter("txtDni");
            String name = request.getParameter("txtName");

            usuario.setDni(dni);
            usuario.setName(name);

            usuarioDao.Add(usuario);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idUser", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("actualizar")) {

            String id = request.getParameter("txtId");
            String dni = request.getParameter("txtDni");
            String name = request.getParameter("txtName");

            usuario.setId(Integer.parseInt(id));
            usuario.setDni(dni);
            usuario.setName(name);

            usuarioDao.Edit(usuario);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            usuario.setId(id);
            usuarioDao.Delete(id);
            acceso=listar;
        }

        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
