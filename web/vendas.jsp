<%-- 
    Document   : vendas
    Created on : 15/03/2021, 15:27:17
    Author     : marco
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="aplicacao.Vendas"%>
<%@page import="model.VendasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
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
			 <li class="nav-item"><a class="nav-link" href="login.html">Vender</a></li>
			 <li class="nav-item active"><a class="nav-link" href="login.html">Vendas</a></li>
			 <li class="nav-item"><a class="nav-link" href="index.html">Sair</a></li>
		</ul>
	</nav>
	</div>

        <h2>Historico de Vendas</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Data</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Id do Cliente</th>
                            <th scope="col">Id do Produto</th>
                            <th scope="col">Id do vendedor</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            VendasDAO vendasdao = new VendasDAO();
                            ArrayList<Vendas> listaVendas = vendasdao.getLista();
                            for (int i = 0; i < listaVendas.size(); i++) {
                                Vendas aux = listaVendas.get(i);
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getQtdVenda()%></td> 
                            <td><%=aux.getData()%></td> 
                            <td><%=aux.getValorVenda()%></td> 
                            <td><%=aux.getIdCliente()%></td> 
                            <td><%=aux.getIdProduto()%></td>
                            <td><%=aux.getIdVendedor()%></td> 
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
                    
        <script src="jquery-3.4.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
