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
                         <li class="nav-item"><a class="nav-link" href="Comprar.jsp">Comprar</a></li>
                         <li class="nav-item"><a class="nav-link" href="CadastrarCategoria.jsp">Categorias</a></li> 
                         <li class="nav-item active"><a class="nav-link" href="cadastrarFornecedor.jsp">Cadastrar Fornecedor</a></li>
                         <li class="nav-item"><a class="nav-link" href="mudaDisponibilidade.jsp">Produtos</a></li>
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
	</div>
        
            <div class="container">
		<form method="POST" action="CadastrarFornecedor">
                    <div class="form-group>">
                        <label for="razao">Razao Social</label>
			<input class="form-control" 
			name="razao" placeholder="nome">
                    </div>
		
                    <div class="form-group>">
                        <label for="cnpj">CNPJ</label>        
			<input class="form-control" 
			name="cnpj" placeholder="Ex.: 11.111.111/1111-11" data-mask="00.000.000/0000-00" maxlength="18" autocomplete="off">
                    </div>
                    <div class="form-group>">
                        <label for="endereco">Endereço</label>
			<input class="form-control"  
			name="endereco" placeholder="seu endereço">
                    </div>
                    <div class="form-group>">
                        <label for="bairro">Bairro</label>    
			<input class="form-control"  
			name="bairro" placeholder="seu bairro">
                    </div>
                    <div class="form-group>">
                        <label for="cidade">Cidade</label>
			<input class="form-control" 
			name="cidade" placeholder="sua cidade">
                        
                    </div>
                    <div class="form-group>">
                        <label for="uf" class="space">UF</label>
                        <select name="uf">
                            <option value="RJ">RJ</option>
                            <option value="SP">SP</option>
                            <option value="MG">MG</option>
                        </select> 
                    </div>   
                    <div class="form-group>">
                        <label for="cep">CEP</label>
			<input class="form-control"  
			name="cep" placeholder="seu CEP" data-mask="00000-000" maxlength="9" autocomplete="off">
                    </div>    
		    <div class="form-group>">
                        <label for="telefone">Telefone</label>
			<input class="form-control"  
			name="telefone" placeholder="seu telefone">
                    </div>
                    <div class="form-group>">
                        <label for="email">email</label>    
			<input class="form-control" 
			name="email" placeholder="seu email">
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
