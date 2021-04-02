<%-- 
    Document   : mudaDisponibilidade
    Created on : 01/04/2021, 03:32:37
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
        <title>Loja de Eletrodomesticos</title>
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
                         <li class="nav-item active"><a class="nav-link" href="mudaDisponibilidade.jsp">Produtos</a></li>
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
        <h1>Lista de Produtos</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Disponivel</th>
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
                                if(aux.getQtdDisponivel()>0){
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getDescricao()%></td>  
                            <td><%=aux.getQtdDisponivel()%></td> 
                            <td><%=aux.getLiberadoVenda()%></td> 
                            <%if(aux.getLiberadoVenda().equals("S")){%>
                            
                                <td><a href="<%=url%>" class="btn btn-outline-danger float-right" >Tornar Indisponivel</a></td> 
                                    
                            <%}else{%>
                            
                                <td><a href="<%=url%>" class="btn btn-outline-success float-right" >Tornar Disponivel</a></td>
                                
                            <%}%>    
                                
                            
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <a href="index.html">Retorna</a>
        </div>
    

    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="jquery-3.4.1.min.js"></script>
    <script src="js/jquery.mask.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>