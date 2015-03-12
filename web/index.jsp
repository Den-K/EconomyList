<%--
  Created by IntelliJ IDEA.
  User: Den
  Date: 02.03.2015
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%
    String verification = (String)request.getAttribute("verify");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <meta content="text/html; charset=utf-8" http-equiv="content-type">
      <link rel="stylesheet" href="style/style.css">
      <title>EconomyList - Sign in</title>
  </head>
  <body>
  <h1 align="center">EconomyList</h1>
  <div class="main" align="center">
      <div class="container">
          <form method="post" action="SignIn">
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
          <%if(verification != null){%>
                <font color="red"><%=verification%></font>
          <%}%>
      </p>
  </div>
  </body>
</html>
