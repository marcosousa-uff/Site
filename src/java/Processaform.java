

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author marco
 */
@WebServlet(name="Processaform", urlPatterns = {"/Processaform"})
public class Processaform extends HttpServlet {
    
    Connection conexao = null;
    public void init() throws ServletException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Processaform.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        try {
            if((!nome.isEmpty()) && (!nome.isEmpty()) && (!cpf.isEmpty()) 
                    &&(!endereco.isEmpty()) && (!bairro.isEmpty()) &&(!cidade.isEmpty()) 
                    &&(!uf.isEmpty()) && (!cep.isEmpty()) &&(!telefone.isEmpty()) &&(!email.isEmpty())){
                PreparedStatement sql= conexao.prepareStatement
                    ("insert into clientes(nome,cpf,endereco,bairro,cidade,uf,cep,telefone,email) values(?,?,?,?,?,?,?,?,?)");
                sql.setString(1, nome);
                sql.setString(2, cpf);
                sql.setString(3, endereco);
                sql.setString(4, bairro);
                sql.setString(5, cidade);
                sql.setString(6, uf);
                sql.setString(7, cep);
                sql.setString(8, telefone);
                sql.setString(9, email);
                sql.executeUpdate();
                sql.close();
                
                RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/cadastrar.html");
                rd.forward(request, response);             
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Processaform.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
