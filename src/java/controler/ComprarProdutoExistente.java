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
@WebServlet(name = "ComprarProdutoExistente", urlPatterns = {"/ComprarProdutoExistente"})
public class ComprarProdutoExistente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        int adicionar = Integer.parseInt(request.getParameter("adicionar"));
        
        ProdutosDAO produtosdao = new ProdutosDAO();
        Produtos produto = produtosdao.getProdutosPorID(idProduto);
        adicionar += produto.getQtdDisponivel();
        produto.setQtdDisponivel(adicionar);
        if(produtosdao.gravar(produto)){
            response.sendRedirect("Comprar.jsp");
        }else{
            response.sendRedirect("index.html");
        }
        
    }

}
