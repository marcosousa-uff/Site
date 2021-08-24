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
    
    
    if (!(tipo.equals("0")))response.sendRedirect("login.html"); 
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
			 <li class="nav-item"><a class="nav-link" href=<%=link%>>Voltar</a></li>
                         <li class="nav-item active"><a class="nav-link" href="cadastrarFornecedor.jsp">Cadastrar Fornecedor</a></li>
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
	</div>
        
            <div class="container">
		<form method="POST" action="CadastrarUsuario">
                    <div class="form-group>">
                        <label for="nome">Nome</label>
			<input class="form-control" 
			name="nome" placeholder="nome">
                    </div>
		
                    <div class="form-group>">
                        <label for="cpf">CPF</label>        
			<input class="form-control" 
			name="cpf" placeholder="Ex.: 111.111.111-11" data-mask="000.000.000-00" maxlength="15" autocomplete="off">
                    </div>
                    <div class="form-group>">
                        <label for="senha">Senha</label>
			<input class="form-control"  
			name="senha" placeholder="senha">
                    </div>
                    <div class="form-group>">
                        <label for="tipo" class="space">Tipo</label>
                        <select name="tipo">
                            <option value="0">Administrador</option>
                            <option value="1">Vendedor</option>
                            <option value="2">Comprador</option>
                        </select> 
                    </div>
                    <div class="space">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </div>
		</form>
	</div>
        
        
       
        <script src="jquery-3.4.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
