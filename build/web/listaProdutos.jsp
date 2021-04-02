<%-- 
    Document   : listaProdutos
    Created on : 14/03/2021, 02:49:43
    Author     : marco
--%>
<%@ page import="java.util.*,aplicacao.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			 <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
			 <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
			 <li class="nav-item active"><a class="nav-link" href="ListarProdutos">Produtos</a></li>
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
                            <th scope="col">Descrição</th>
                            <th scope="col">Preço de Compra</th>
                            <th scope="col">Preço de Venda</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Disponivel</th>
                            <th scope="col">Categoria</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Produtos> ListaProdutos = (ArrayList<Produtos>) request.getAttribute("produtos");
                            for (int i = 0; i < ListaProdutos.size(); i++) {
                                Produtos aux = ListaProdutos.get(i);
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getDescricao()%></td> 
                            <td><%=aux.getPrecoCompra()%></td>
                            <td><%=aux.getPrecoVenda()%></td> 
                            <td><%=aux.getQtdDisponivel()%></td> 
                            <td><%=aux.getLiberadoVenda()%></td> 
                            <td><%=aux.getIdCategoria()%></td> 
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
