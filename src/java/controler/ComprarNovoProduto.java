/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import aplicacao.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ComprarNovoProduto", urlPatterns = {"/ComprarNovoProduto"})
public class ComprarNovoProduto extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        float precoCompra = Float.parseFloat(request.getParameter("compra"));
        float precoVenda = Float.parseFloat(request.getParameter("venda"));
        int qtd = Integer.parseInt(request.getParameter("quantidade"));
        String liberado = request.getParameter("liberado").toUpperCase();
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        if(!(liberado.equals("S")||liberado.equals("N"))){
            response.sendRedirect("index.html");
        }
        
        Produtos produto = new Produtos(0,nome,descricao,precoCompra,precoVenda,qtd,liberado,idCategoria);
        ProdutosDAO produtosdao = new ProdutosDAO();
        boolean compraConcluida = produtosdao.gravar(produto);
        if(compraConcluida){
            response.sendRedirect("ListarProdutos");
            
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
