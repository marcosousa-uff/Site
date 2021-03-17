/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import aplicacao.Produtos;
import aplicacao.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdutosDAO;
import model.UsuariosDAO;

/**
 *
 * @author marco
 */
@WebServlet(name = "ChecarUsuarios", urlPatterns = {"/ChecarUsuarios"})
public class ChecarUsuarios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuariosDAO usuariosdao = new UsuariosDAO();  
        ArrayList<Usuarios> resultado = usuariosdao.getLista();
            
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
            if (resultado != null) {
                
                boolean logado = false;
                int id = 0;
                for (int i = 0; i < resultado.size(); i++) {
                    Usuarios aux = resultado.get(i);
                    if((aux.getCpf().equals(cpf) && aux.getSenha().equals(senha))){
                        logado = true;
                        id = aux.getId();      
                    }        
                }
                
                if(logado){
                    request.setAttribute("id", id);
                    request.setAttribute("logado", logado);
                    RequestDispatcher rd = request.getRequestDispatcher("AreaRestrita");
                    rd.forward(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }
    }
}

   
