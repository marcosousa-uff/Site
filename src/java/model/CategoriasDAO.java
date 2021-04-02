/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Categoria;
import aplicacao.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static sun.misc.FloatingDecimal.parseFloat;

/**
 *
 * @author cliente
 */
@WebServlet(name = "CategoriasDAO", urlPatterns = {"/CategoriasDAO"})
public class CategoriasDAO extends HttpServlet {

    private Connection conexao;
    public CategoriasDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Categoria> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Categoria> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from categorias");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {

                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("id") );
                categoria.setNome( rs.getString("nome_categoria") );
                
                
                
                
                resultado.add(categoria);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    public boolean gravar(Categoria categoria) {
        try {
            String sql;
            if (categoria.getId() == 0) {
                // Realizar uma inclusão
                sql = "INSERT INTO categorias (nome_categoria) values(?)";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, categoria.getNome());
                ps.execute();
                

            } else {
                // Realizar uma alteração
                sql = "UPDATE categorias SET nome_categoria=? WHERE id=?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, categoria.getNome());
                ps.execute();
            }


            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

}
