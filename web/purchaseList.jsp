<%@ page import="economylist.dao.DAOFactory" %>
<%@ page import="economylist.dao.purchase.PurchaseDAO" %>
<%@ page import="economylist.valueobject.Purchase" %>
<%@ page import="economylist.valueobject.User" %>
<%@ page import="java.util.List" %>
<%@ page import="economylist.dao.category.CategoryDAO" %>
<%
    DAOFactory daoFactory = new DAOFactory();
    PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();
    User user = (User) request.getAttribute("user");
    List<Purchase> purchaseList = purchaseDAO.getAllByUserID(user.getId());
    double total = 0;
    CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
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
            <form name="submitForm" method="POST" action="AddPurchase">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="javascript:document.submitForm.submit()">Add</a>
                        <input type="hidden" name="email" value="<%=user.getEmail()%>">
                        <!--<input type="hidden" name="sel1ID" value="<%%>">-->
                    </li>
                    <li><a href="ListOperations?change=1" onclick="document.listForm.submit()">Change</a></li>
                    <li><a href="ListOperations?delete=1" onclick="document.listForm.submit()">Delete</a></li>
                </ul>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-expanded="false"><%=user.getEmail()%> <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Account settings</a></li>
                        <li><a href="#">Log out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="mycontainer">
    <form id="listForm" name="listForm" method="POST" action="ListOperations">
        <table class="table table-condensed">
            <thead>
            <tr>
                <th></th>
                <th>CATEGORY</th>
                <th>NAME</th>
                <th>NUMBER</th>
                <th>DATE</th>
                <th>COST</th>
            </tr>
            </thead>
            <tbody>
            <%for (Purchase p : purchaseList) {%>
            <tr>
                <td><input type="checkbox" name="selected" id="<%=p.getId()%>" value="<%=p.getId()%>"></td>
                <td><%=categoryDAO.getCategoryByPurchase(p.getId()).getName().toUpperCase()%>
                </td>
                <td><%=p.getName()%>
                </td>
                <td><%=p.getNumber()%>
                </td>
                <td><%=p.getDate()%>
                </td>
                <td><%=p.getCost()%>
                </td>
                <input type="hidden" name="email" value="<%=user.getEmail()%>">
                <%total = total + p.getCost();%>
            </tr>
            <%}%>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><b>Total: <%=total%></b></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
