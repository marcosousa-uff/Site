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
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" type=\"text/css\"/>");
            out.println("<title>Servlet AreaRestrita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<p></p>");
            out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">");
            out.println("<ul class=\"navbar-nav\">");
            out.println("<li class=\"nav-item active\"><a class=\"nav-link\" href=\"#\">Vender</a></li>");
            out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"vendas.jsp\">Vendas</a></li>");
            out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"index.html\">sair</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</div>");
            out.println("<div class=\"container\">");
            out.println("<form method=\"POST\" action=\"VenderProduto\">");
            out.println("<input type=\"hidden\" name=\"id\" value="+id+">");
            out.println("<div");
            out.println("<label for=\"nome\">Nome do Cliente</label>");
            out.println("<input class=\"form-control\" \n" +
"			name=\"nome\" placeholder=\"nome\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<button type=\"submit\" class=\"btn btn-primary\">Vender Produto</button>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("<script src=\"jquery-3.4.1.min.js\"></script>");
            out.println("<script src=\"js/popper.min.js\"></script>");
            out.println("<script src=\"js/bootstrap.min.js\"></script");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.sendRedirect("index.html");
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
