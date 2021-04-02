<%-- 
    Document   : vender
    Created on : 14/03/2021, 19:06:38
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
        <% 
            HttpSession ses = request.getSession();
            ses.setAttribute("idFuncionario",request.getAttribute("id"));
            ses.setAttribute("idCliente", request.getAttribute("idCliente"));
        %>
        <h2>Lista de Produtos</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Preço de Venda</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Disponivel</th>
                            <th scope="col"></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Produtos> ListaProdutos = (ArrayList<Produtos>) request.getAttribute("produtos");
                            for (int i = 0; i < ListaProdutos.size(); i++) {
                                Produtos aux = ListaProdutos.get(i);
                                String link = "FinalizarVenda?idProduto="+aux.getId()+"&preco="+aux.getPrecoVenda();
                                if(aux.getLiberadoVenda().equals("S")){
                        %>
                        <tr>
                            <td><%=aux.getId()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getDescricao()%></td> 
                            <td><%=aux.getPrecoVenda()%></td> 
                            <td><%=aux.getQtdDisponivel()%></td> 
                            <td><%=aux.getLiberadoVenda()%></td>
                            <td><a href="<%=link%>" class="btn btn-outline-danger float-right">Vender</a></td>
                        </tr>
                        <%
                                }
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
