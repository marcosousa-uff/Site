package model;

import aplicacao.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import static sun.misc.FloatingDecimal.parseFloat;

@WebServlet(name = "ProdutosDAO", urlPatterns = {"/ProdutosDAO"})
public class ProdutosDAO extends HttpServlet {

  private Connection conexao;
    public ProdutosDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Produtos> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Produtos> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from produtos where quantidade_disponível >0");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {

                Produtos produto = new Produtos();
                
                produto.setId(rs.getInt("id") );
                produto.setNome( rs.getString("nome_produto") );
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoCompra(parseFloat(rs.getString("preco_compra")));
                produto.setPrecoVenda(parseFloat(rs.getString("preco_venda")));
                produto.setQtdDisponivel(rs.getInt("quantidade_disponível"));
                produto.setLiberadoVenda(rs.getString("liberado_venda"));
                produto.setIdCategoria(rs.getInt("id_categoria"));
                
                
                
                resultado.add(produto);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public Produtos getProdutosPorID( int codigo ) {
        Produtos produto = new Produtos();
        try {
            String sql = "SELECT * FROM produtos WHERE id =?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                produto.setId(rs.getInt("id") );
                produto.setNome( rs.getString("nome_produto") );
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoCompra(parseFloat(rs.getString("preco_compra")));
                produto.setPrecoVenda(parseFloat(rs.getString("preco_venda")));
                produto.setQtdDisponivel(rs.getInt("quantidade_disponível"));
                produto.setLiberadoVenda(rs.getString("liberado_venda"));
                produto.setIdCategoria(rs.getInt("id_categoria"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return produto;
    }
    
    public boolean gravar(Produtos produto) {
        try {
            String sql;
            if (produto.getId() == 0) {
                // Realizar uma inclusão
                sql = "INSERT INTO produtos (nome_produto, descricao, preco_compra, preco_venda, quantidade_disponível, liberado_venda, id_categoria) values(?,?,?,?,?,?,?)";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, produto.getNome());
                ps.setString(2, produto.getDescricao());
                ps.setFloat(3, produto.getPrecoCompra());
                ps.setFloat(4, produto.getPrecoVenda());
                ps.setInt(5, produto.getQtdDisponivel());
                ps.setString(6, produto.getLiberadoVenda());
                ps.setInt(7, produto.getIdCategoria());
                ps.execute();
                

            } else {
                // Realizar uma alteração
                sql = "UPDATE produtos SET nome_produto=?, descricao=?, preco_compra=?, preco_venda=?, quantidade_disponível=?, liberado_venda=? WHERE id=?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, produto.getNome());
                ps.setString(2, produto.getDescricao());
                ps.setFloat(3, produto.getPrecoCompra());
                ps.setFloat(4, produto.getPrecoVenda());
                ps.setInt(5, produto.getQtdDisponivel());
                ps.setString(6, produto.getLiberadoVenda());
                ps.setInt(7, produto.getId());
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
            String sql = "DELETE FROM produtos WHERE id = ?";
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
