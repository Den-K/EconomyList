<%@ page import="economylist.dao.DAOFactory" %>
<%@ page import="economylist.dao.category.CategoryDAO" %>
<%@ page import="economylist.valueobject.Category" %>
<%@ page import="java.util.List" %>
<%
  String email = (String) request.getAttribute("email");
  DAOFactory daoFactory = new DAOFactory();
  CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
  List<Category> categoryList = categoryDAO.getCategories();
  //String selectedID = (String) request.getAttribute("selectedID");
  //List<Category> subCategoryList = categoryDAO.getSubCategories(Integer.parseInt(selectedID));
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
<script>
  window.onload = sendSel;
  function sendSel(){
    var e = document.getElementById("sel1");
    var sel1ID = e.options[e.selectedIndex].value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "AddPurchase?sel1ID=" + sel1ID, true)
    xhr.send();
  }
</script>
<body>
<h3 align="center">Add purchase</h3>
<div class="container">
      <form method="post" action="PurchaseList" name="submit-form">
          <div class="form-group">
            <label for="sel1">CATEGORY:</label>
            <select class="form-control" id="sel1" name="category">
              <%for(Category c : categoryList){%>
              <option value="<%=c.getId()%>"  onclick=""><%=c.getName().toUpperCase()%></option>
              <%}%>
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

          <input type="hidden" name="email" value="<%=email%>"/>
        <br/>
        <div align="center">
          <button type="submit" class="btn btn-success">Add purchase</button>
        </div>
      </form>
</div>
</body>
</html>
