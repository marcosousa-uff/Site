/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import aplicacao.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdutosDAO;

/**
 *
 * @author cliente
 */
@WebServlet(name = "MudaDisponibilidade", urlPatterns = {"/MudaDisponibilidade"})
public class MudaDisponibilidade extends HttpServlet {

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
        
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        String disponivel = request.getParameter("disponivel");
        
        ProdutosDAO produtosdao = new ProdutosDAO();
        Produtos produto = produtosdao.getProdutosPorID(idProduto);
        if(disponivel.equals("S")){
            produto.setLiberadoVenda("N");
        }else{
            produto.setLiberadoVenda("S");
        }
        produtosdao.gravar(produto);
        response.sendRedirect("mudaDisponibilidade.jsp");
        
    }

}
