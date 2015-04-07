<%@ page import="economylist.valueobject.Purchase" %>
<%@ page import="java.util.List" %>
<%@ page import="economylist.valueobject.User" %>
<%@ page import="economylist.dao.DAOFactory" %>
<%@ page import="economylist.dao.purchase.PurchaseDAO" %>
<%@ page import="economylist.dao.category.CategoryDAO" %>
<%@ page import="economylist.valueobject.Category" %>
<%
    DAOFactory daoFactory = new DAOFactory();
    PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();
    User user = (User) request.getAttribute("user");
    List<Purchase> purchaseList = purchaseDAO.getAllByUserID(user.getId());

    CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
    List<Category> categoryList = categoryDAO.getCategoies();
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
<script>
    function submitForm() {
        var form = document.getElementsByName('submit-form')[0];
        form.submit();
        var elem = document.getElementById('addModal');
        elem.parentNode.removeChild(elem);
        return false;
    }
</script>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-brand">EconomyList</span>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                <li><a data-toggle="modal" data-target="#addPurchaseModal" href="">Add</a></li>
                <li><a href="#">Change</a></li>
                <li><a href="#">Delete</a></li>
            </ul>

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
        <%for (Purchase p : purchaseList) {%>
        <tr>
            <td><input type="checkbox" id="<%=p.getId()%>" value="<%=p.getId()%>"></td>
            <td><%=p.getName()%>
            </td>
            <td><%=p.getNumber()%>
            </td>
            <td><%=p.getDate()%>
            </td>
            <td><%=p.getCost()%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<div id="addModal">
    <div class="modal fade" id="addPurchaseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" align="center">
                    <h5 class="modal-title" id="myModalLabel">ADD PURCHASE</h5>
                </div>
                <form method="post" action="PurchaseList" name="submit-form">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="sel1">CATEGORY:</label>
                            <select class="form-control" id="sel1" name="sel1">
                                <%for(Category c : categoryList){%>
                                    <option><%=c.getName().toUpperCase()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="sel1">SUBCATEGORY:</label>
                            <select class="form-control" id="sel2" name="sel2">
                                <option>1</option>
                            </select>
                        </div>
                        <label for="name">NAME:</label>
                        <input class="form-control" type="text" id="name" name="name">
                        <br/>
                        <label for="number">NUMBER:</label>
                        <input class="form-control" type="number" min="1" id="number" name="number">
                        <br/>
                        <label for="date">DATE:</label>
                        <input class="form-control" type="date" id="date" name="date">
                        <br/>
                        <label for="cost">COST:</label>
                        <input class="form-control" type="number" min="1" step="0.01" id="cost" name="cost">

                        <input type="hidden" name="email" value="<%=user.getEmail()%>"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-success btn-sm" onclick="submitForm()">Add purchase
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
