/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import aplicacao.Fornecedor;
import aplicacao.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FornecedorDAO;
import model.UsuariosDAO;

/**
 *
 * @author cliente
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");

        
        boolean resultado = false;
        if((!nome.isEmpty()) && (!cpf.isEmpty()) &&(!senha.isEmpty())&& (!tipo.isEmpty())){
        
            Usuarios usuario = new Usuarios(0,nome,cpf,senha,tipo);
            UsuariosDAO usuariodao = new UsuariosDAO();
            resultado = usuariodao.gravar(usuario);
        }else{
            response.sendRedirect("erro.jsp");
        }    
        
        
        
        
        if(resultado){
            response.sendRedirect("ListarUsuarios");
        }else{
            response.sendRedirect("index.html");
        }
        
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
