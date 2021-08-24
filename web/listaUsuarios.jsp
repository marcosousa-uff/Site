<%-- 
    Document   : listaUsuarios
    Created on : 03/05/2021, 13:49:46
    Author     : cliente
--%>

<%@page import="model.UsuariosDAO"%>
<%@ page import="java.util.*,aplicacao.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <!-- Meta tags Obrigatórias -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
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
			 <li class="nav-item active"><a class="nav-link" href="#">Usuarios</a></li>
                         <li class="nav-item"><a class="nav-link" href="index.html">sair</a></li>
		</ul>
	</nav>
	</div>
      <h1>Lista de Produtos</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">cpf</th>
                            <th scope="col">senha</th>
                            <th scope="col">tipo</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Usuarios> ListaUsuario = (ArrayList<Usuarios>) request.getAttribute("usuarios");
                            for (int i = 0; i < ListaUsuario.size(); i++) {
                                Usuarios aux = ListaUsuario.get(i);
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getCpf()%></td> 
                            <td><%=aux.getSenha()%></td>
                            <td><%=aux.getTipo()%></td> 
                        </tr>
                        <%
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
