/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Produtos;
import aplicacao.Vendas;
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
@WebServlet(name = "VendasDAO", urlPatterns = {"/VendasDAO"})
public class VendasDAO extends HttpServlet {

    private Connection conexao;
    public VendasDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }  
    public ArrayList<Vendas> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Vendas> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from vendas");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {

                Vendas venda = new Vendas();
                
                venda.setId(rs.getInt("id") );
                venda.setQtdVenda(rs.getInt("quantidade_venda") );
                venda.setData(rs.getDate("data_venda"));
                venda.setValorVenda(parseFloat(rs.getString("valor_venda")));
                venda.setIdCliente(rs.getInt("id_cliente") );
                venda.setIdProduto(rs.getInt("id_produto") );
                venda.setIdVendedor(rs.getInt("id_vendedor") );
                
                
                
                resultado.add(venda);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public boolean gravar(Vendas venda) {
        try {
            String sql;
            if (venda.getId() == 0) {
                System.out.println("entrou 1");
                // Realizar uma inclusão
                sql = "INSERT INTO vendas (quantidade_venda,data_venda,valor_venda,id_cliente,id_produto,id_vendedor) values(?,?,?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, venda.getQtdVenda());
                ps.setDate(2, venda.getData());
                ps.setFloat(3, venda.getValorVenda());
                ps.setInt(4, venda.getIdCliente());
                ps.setInt(5, venda.getIdProduto());
                ps.setInt(6, venda.getIdVendedor());
                ps.execute();
            } else {
                System.out.println("entrou 2");
                // Realizar uma alteração
                sql = "UPDATE vendas SET quantidade_venda=?, data_venda=?,valor_venda=? WHERE id=?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, venda.getQtdVenda());
                ps.setDate(2, venda.getData());
                ps.setFloat(3, venda.getValorVenda());
                ps.setInt(4, venda.getId());

                ps.execute();
            }

            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM vendas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

}
