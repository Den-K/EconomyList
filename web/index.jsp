<%--
  Created by IntelliJ IDEA.
  User: Den
  Date: 02.03.2015
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("epassword");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <meta charset="utf-8">
      <link rel="stylesheet" href="style/style.css">
      <title>EconomyList - Sign in</title>
  </head>
  <body>
  <h1 align="center">EconomyList</h1>
  <div class="main" align="center">
      <div class="container">
          <form method="post" action="#">
              <label for="email">Email:</label>
              <input type="email" id="email" name="email">
              <br/>
              <label for="password">Password:</label>
              <input type="password" id="password" name="password">
              <br/><br/>
              <input type="submit" value="Sign In">
          </form>
      </div>
      <p>
              Email: <%=email%>
              Password: <%=password%>
      </p>
  </div>
  </body>
</html>
