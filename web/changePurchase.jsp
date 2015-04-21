<%@ page import="economylist.dao.DAOFactory" %>
<%@ page import="economylist.dao.purchase.PurchaseDAO" %>
<%@ page import="economylist.valueobject.Purchase" %>
<%
  String email = (String) request.getAttribute("email");
  Integer id = Integer.valueOf((String) request.getAttribute("selected"));
  DAOFactory daoFactory = new DAOFactory();
  PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();
  Purchase purchase = purchaseDAO.getPurchaseByID(id);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=utf-8" http-equiv="content-type">
  <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap.css">
  <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap-theme.css">
  <title>EconomyList - Add purchase</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="style/bootstrap-3.3.2/js/bootstrap.js"></script>

<body>
<h3 align="center">Change purchase</h3>
<div class="container">
  <form method="post" action="ChangePurchase">

    <label for="name">NAME:</label>
    <input class="form-control" type="text" id="name" name="name" value="<%=purchase.getName()%>">
    <br/>
    <label for="number">NUMBER:</label>
    <input class="form-control" type="number" min="1" id="number" name="number" value="<%=purchase.getNumber()%>">
    <br/>
    <label for="date">DATE:</label>
    <input class="form-control" type="date" id="date" name="date" value="<%=purchase.getDate()%>">
    <br/>
    <label for="cost">COST:</label>
    <input class="form-control" type="number" min="1" step="0.01" id="cost" name="cost" value="<%=purchase.getCost()%>">

    <input type="hidden" name="email" value="<%=email%>"/>
    <input type="hidden" name="id" value="<%=id%>"/>
    <br/>
    <div align="center">
      <button type="submit" class="btn btn-success">Change purchase</button>
    </div>
  </form>
</div>
</body>
</html>
