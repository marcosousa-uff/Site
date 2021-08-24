<%-- 
    Document   : CadastrarCategoria
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
			 <li class="nav-item"><a class="nav-link" href=<%=link%>>Voltar</a></li>
                         <li class="nav-item active"><a class="nav-link" href="CadastrarCategoria.jsp">Categorias</a></li> 
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
	</div>
        
            <div class="container" style="display:table;">
                <h2>Categorias</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col"></th>
                            <th scope="col" style="width:20px;"></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            CategoriasDAO categoriasdao = new CategoriasDAO();
                            ArrayList<Categoria> Lista = categoriasdao.getLista();
                            for (int i = 0; i < Lista.size(); i++) {
                                Categoria aux = Lista.get(i);
                                
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getNome()%></td> 
                            <form method="POST" action="AlterarCategoria"> 
                                <input type="hidden" name="idCategoria" value="<%=aux.getId()%>">
                                <td class="form-group>">
                                    <input type="text" class="form-control" 
                                           name="nome"  placeholder="novo nome" required>
                                </td> 
                                <td>
                                    <button type="submit" class="btn btn-primary">Alterar</button>
                                </td>   
                            </form>    
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
                    
            <div class="container">
                <h3>Cadastrar Categoria</h3>
		<form method="POST" action="AtualizarCategoria">
                    <div class="form-group">
                        <label for="nome">Nome</label>
			<input class="form-control" 
			name="nome" required="required" placeholder="nome da categoria">
                    </div>
		
		<input type="submit" value="Submit">
		</form>
	</div>
        
        
       
        <script src="jquery-3.4.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
