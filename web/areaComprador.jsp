<%-- 
    Document   : cadastrarFornecedor
    Created on : 31/03/2021, 08:25:37
    Author     : cliente
--%>

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
   
    //String link = "AreaRestrita?id="+id+"&logado="+logado;
        
        
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
			 <li class="nav-item active"><a class="nav-link" href=#>Area do Comprador</a></li>
                         <li class="nav-item"><a class="nav-link" href="Comprar.jsp">Comprar</a></li>
                         <li class="nav-item"><a class="nav-link" href="CadastrarCategoria.jsp">Categorias</a></li> 
                         <li class="nav-item"><a class="nav-link" href="cadastrarFornecedor.jsp">Cadastrar Fornecedor</a></li>
                         <li class="nav-item"><a class="nav-link" href="mudaDisponibilidade.jsp">Produtos</a></li>
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>

        <script src="jquery-3.4.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
