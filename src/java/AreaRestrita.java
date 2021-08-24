/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuariosDAO;

/**
 *
 * @author marco
 */
@WebServlet(name="AreaRestrita", urlPatterns = {"/AreaRestrita"})
public class AreaRestrita extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean logado = (boolean)request.getAttribute("logado");
        int id = (int)request.getAttribute("id");
        if(!logado) response.sendRedirect("index.html");
        UsuariosDAO usuario = new UsuariosDAO();
        String tipo = usuario.getUsuarioPorID(id).getTipo();

        HttpSession ses = request.getSession();
        ses.setAttribute("idFuncionario", id);
        
        switch(tipo){
            case "1":
                response.sendRedirect("areaVendedor.jsp");
                break;
            case "2":
                response.sendRedirect("areaComprador.jsp");
                break;
            case "0":
                response.sendRedirect("areaAdministrador.jsp");
                break;                
        }

//        
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<meta charset=\"utf-8>");
//            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
//            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
//            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" type=\"text/css\"/>");
//            out.println("<title>Servlet AreaRestrita</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div class=\"container\">");
//            out.println("<p></p>");
//            out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">");
//            out.println("<ul class=\"navbar-nav\">");
//            out.println("<li class=\"nav-item active\"><a class=\"nav-link\" href=\"#\">Area Restrita</a></li>");
//            out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"areaVendedor.jsp\">Area do Vendedor</a></li>");
//            out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"areaComprador.jsp\">Area do Comprador</a></li>");
//            out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"index.html\">sair</a></li>");
//            out.println("</ul>");
//            out.println("</nav>");
//            out.println("</div>");
//            out.println("<script src=\"jquery-3.4.1.min.js\"></script>");
//            out.println("<script src=\"js/popper.min.js\"></script>");
//            out.println("<script src=\"js/bootstrap.min.js\"></script");
//            out.println("</body>");
//            out.println("</html>");
//        }
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean logado =Boolean.parseBoolean(request.getParameter("logado")); 
        request.setAttribute("logado", logado);
        request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
