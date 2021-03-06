/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Produtos;
import aplicacao.Usuarios;
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
 * @author marco
 */
@WebServlet(name = "UsuariosDAO", urlPatterns = {"/UsuariosDAO"})
public class UsuariosDAO extends HttpServlet {

  private Connection conexao;
    public UsuariosDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Usuarios> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuarios> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {

                Usuarios usuario = new Usuarios();
                
                usuario.setId(rs.getInt("id") );
                usuario.setNome( rs.getString("nome") );
                usuario.setCpf(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
         
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    public Usuarios getUsuarioPorID( int codigo ) {
        Usuarios usuario = new Usuarios();
        try {
            String sql = "SELECT * FROM usuarios WHERE id =?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id") );
                usuario.setNome( rs.getString("nome") );
                usuario.setCpf(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }
    public boolean gravar(Usuarios usuario) {
        try {
            String sql;
            if (usuario.getId() == 0) {
                // Realizar uma inclusão
                sql = "INSERT INTO usuarios (nome, cpf, senha, tipo) values(?,?,?,?)";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getCpf());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getTipo());
                ps.execute();     

            } else {
                // Realizar uma alteração
                sql = "UPDATE usuarios SET nome=?, cpf=?, senha=?, tipo=? WHERE id=?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getCpf());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getTipo());
                ps.setInt(5, usuario.getId());
                ps.execute();
            }


            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
