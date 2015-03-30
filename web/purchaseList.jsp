<%@ page import="economylist.valueobject.Purchase" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    List<Purchase> purchaseList = (ArrayList<Purchase>)request.getAttribute("purchaseList");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type">
    <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap.css">
    <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap-theme.css">
    <title>EconomyList - Purchases</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="style/bootstrap-3.3.2/js/bootstrap.js"></script>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-brand">EconomyList</span>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Add</a></li>
                <li><a href="#">Change</a></li>
                <li><a href="#">Delete</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Your name <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="mycontainer">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th></th>
            <th>NAME</th>
            <th>NUMBER</th>
            <th>DATE</th>
            <th>COST</th>
        </tr>
        </thead>
        <tbody>
        <%for(Purchase p : purchaseList){%>
            <tr>
                <td><input type="checkbox" id="<%=p.getId()%>" value="<%=p.getId()%>"></td>
                <td><%=p.getName()%></td>
                <td><%=p.getNumber()%></td>
                <td><%=p.getDate()%></td>
                <td><%=p.getCost()%></td>
            </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
