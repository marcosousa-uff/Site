<%-- 
    Document   : iniciarVenda
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
    
    
    if (!(tipo.equals("1")))response.sendRedirect("login.html"); 
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
			 <li class="nav-item"><a class="nav-link" href="vendas.jsp">Vendas</a></li>
                         <li class="nav-item"><a class="nav-link" href="cadastrar.jsp">Cadastrar</a></li>
                         <li class="nav-item active"><a class="nav-link" href="iniciarVenda.jsp">Vender</a></li> 
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
                         <div class="container">
                             <form method="POST" action="VenderProduto">
                                 <input type="hidden" name="id" value=<%=id%>>
                                 <div>
                                     <label for="nome">Nome do Cliente</label>
                                     <input class="form-control"
                                            name="nome" placeholder="nome">
                                 </div>
                                 <div class="space">
                                     <button type="submit" class="btn btn-primary">Vender Produto</button>
                                 </div>
                             </form>
                         </div>

        <script src="jquery-3.4.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
