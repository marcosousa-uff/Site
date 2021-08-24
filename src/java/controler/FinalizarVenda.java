/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import aplicacao.Produtos;
import aplicacao.Vendas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import javax.servlet.http.HttpSession;
import model.Conexao;
import model.ProdutosDAO;
import model.VendasDAO;

/**
 *
 * @author marco
 */
@WebServlet(name = "FinalizarVenda", urlPatterns = {"/FinalizarVenda"})
public class FinalizarVenda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
            
            int id = 0;
        
            int qtd =1;
            
            int idFuncionario = (int)(ses.getAttribute("idFuncionario"));
            
            int idCliente = (int)((ses.getAttribute("idCliente")));
            
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            
            float preco = Float.parseFloat(request.getParameter("preco"));
            
            java.util.Date data = new java.util.Date();  
            java.sql.Date dataSql = new java.sql.Date(data.getTime());
            
            Vendas venda = new Vendas(id,qtd,dataSql,preco,idCliente,idProduto,idFuncionario);
            VendasDAO vendasdao = new VendasDAO();
            System.out.println("idCliente:"+idCliente);
            
            //boolean vendaConcluida = vendasdao.gravar(venda);
            
            ProdutosDAO produtosdao = new ProdutosDAO();
            
            System.out.println("id do produto:"+idProduto);
            Produtos produto = produtosdao.getProdutosPorID(idProduto);
            
            if(vendasdao.gravar(venda)){//grava nova venda e verifica se a gravação funcionou      
                int qtdProduto =  produto.getQtdDisponivel();
                qtdProduto--;
                if(qtdProduto>0){
                    produto.setQtdDisponivel(qtdProduto);
                }else{
                    qtdProduto = 0;
                    produto.setLiberadoVenda("N");
                    produto.setQtdDisponivel(qtdProduto);
                }
                produtosdao.gravar(produto);
                
                request.setAttribute("vendaConcluida", "S");

                RequestDispatcher rd = request.getRequestDispatcher("ListarProdutos");
                rd.forward(request, response);
            }else{

                RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                rd.forward(request, response);
            }
            
        
    }

  

}
