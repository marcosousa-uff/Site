/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import aplicacao.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteDAO;
import model.ProdutosDAO;

/**
 *
 * @author marco
 */
@WebServlet(name = "VenderProduto", urlPatterns = {"/VenderProduto"})
public class VenderProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        ClienteDAO clientedao = new ClienteDAO();
        
        int idCliente = clientedao.getClientePorNome(nome).getId();
        
        
        ProdutosDAO produtosdao = new ProdutosDAO();
            
            ArrayList<Produtos> resultado = produtosdao.getLista();

            if (resultado != null) {
                
                request.setAttribute("idCliente",idCliente);
                request.setAttribute("id", id);
                request.setAttribute("produtos", resultado);

                RequestDispatcher rd = request.getRequestDispatcher("/vender.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }

    }
    }


    

