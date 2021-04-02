<%-- 
    Document   : Comprar
    Created on : 30/03/2021, 17:56:54
    Author     : cliente
--%>

<%@page import="model.ProdutosDAO"%>
<%@page import="model.CategoriasDAO"%>
<%@page import="model.UsuariosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,aplicacao.*" %>

<!DOCTYPE html>

<%
    
    HttpSession ses = request.getSession();
    int id = (int) (ses.getAttribute("idFuncionario"));
    UsuariosDAO usuario = new UsuariosDAO();
    String tipo = usuario.getUsuarioPorID(id).getTipo();
    
    
    if (!(tipo.equals("2")))response.sendRedirect("login.html"); 
    boolean logado = true;
   
    String link = "AreaRestrita?id="+id+"&logado="+logado;
    
    
        
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Comprar</title>
    </head>
    <body>
        <div class="container">
	<p></p>
	<!-- Conteúdo aqui -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			 <li class="nav-item"><a class="nav-link" href=<%=link%>>Area Restrita</a></li>
                         <li class="nav-item active"><a class="nav-link" href="Comprar.jsp">Comprar</a></li>
                         <li class="nav-item"><a class="nav-link" href="CadastrarCategoria.jsp">Categorias</a></li> 
                         <li class="nav-item"><a class="nav-link" href="cadastrarFornecedor.jsp">Cadastrar Fornecedor</a></li>
                         <li class="nav-item"><a class="nav-link" href="mudaDisponibilidade.jsp">Produtos</a></li>
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
	</div>     
            <div class="container">
                <h2>Lista de Produtos</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Disponivel</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ProdutosDAO produtosdao = new ProdutosDAO();  
                            ArrayList<Produtos> ListaProdutos = produtosdao.getLista();
                            for (int i = 0; i < ListaProdutos.size(); i++) {
                                Produtos aux = ListaProdutos.get(i);
                                String url="MudaDisponibilidade?idProduto="+aux.getId()+"&disponivel="+aux.getLiberadoVenda();
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getQtdDisponivel()%></td> 
                            <td><%=aux.getLiberadoVenda()%></td> 
                            <form method="POST" action="ComprarProdutoExistente"> 
                                <input type="hidden" name="idProduto" value="<%=aux.getId()%>">
                                <td class="form-group>">
                                    <input type="number" class="form-control" 
                                           name="adicionar"  placeholder="quantidade" required>
                                </td> 
                                <td>
                                    <button type="submit" class="btn btn-primary">Adicionar</button>
                                </td>   
                            </form>    
                            
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="container">
            <h1>Comprar Novo Produto</h1>
		<form method="POST" action="ComprarNovoProduto">
                    <div class="form-group>">
                        <label for="nome">Nome</label>
			<input class="form-control" 
			name="nome" placeholder="nome do produto">
                    </div>
		
                    <div class="form-group>">
                        <label for="descrição">Descricao</label>        
			<input class="form-control" 
			name="descricao" >
                    </div>
                    <div class="form-group>">
                        <label for="preço de compra">PrecoCompra</label>
			<input class="form-control"  
			name="compra">
                    </div>
                    <div class="form-group>">
                        <label for="preço de venda">PrecoVenda</label>    
			<input class="form-control"  
			name="venda">
                    </div>
                    <div class="form-group>">
                        <label for="quantidade">Quantidade</label>
			<input class="form-control" 
			name="quantidade">
                        
                    </div>
                    <div class="form-group>">
                        <label for="liberado">Liberado para venda</label>
			<input class="form-control" 
			name="liberado" placeholder=" S ou N" maxlength="1">                        
                    </div>
                    
                    <div class="form-group">
                        <label for="categoria" class="space">Categoria</label>
			<select name="categoria">
                            <%
                            CategoriasDAO categoriasdao = new CategoriasDAO();
                            ArrayList<Categoria> lista = categoriasdao.getLista();
                            for (int i = 0; i < lista.size(); i++) {
                                Categoria aux = lista.get(i);
                                int idCategoria = aux.getId();
                                String nomeCategoria = aux.getNome();
                            %>
                            <option value="<%=idCategoria%>"><%=nomeCategoria%></option>
                            <%}%>
                        </select>    
                    </div>
                    <button type="submit" class="btn btn-primary">Comprar</button>
		</form>
	</div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
