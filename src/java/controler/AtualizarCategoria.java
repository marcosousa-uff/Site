/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import aplicacao.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoriasDAO;

/**
 *
 * @author cliente
 */
@WebServlet(name = "AtualizarCategoria", urlPatterns = {"/AtualizarCategoria"})
public class AtualizarCategoria extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriasDAO categoriasdao = new CategoriasDAO();
        Categoria categoria = new Categoria();
        int id =0;
        String nome = request.getParameter("nome");
        categoria.setId(id);
        categoria.setNome(nome);
        
        if(!nome.isEmpty()){
            categoriasdao.gravar(categoria);
            RequestDispatcher rd = request.getRequestDispatcher("/CadastrarCategoria.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/CadastrarCategoria.jsp");
            rd.forward(request, response);
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
