<%
    String verification = (String)request.getAttribute("verification");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
      <meta content="text/html; charset=utf-8" http-equiv="content-type">
      <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap.css">
      <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap-theme.min.css">
      <link rel="stylesheet" href="style/bootstrap-3.3.2/js/bootstrap.js">
      <title>EconomyList - Sign in</title>
  </head>

  <body>
      <h2 align="center">Economy List</h2>
      <div align="center" style="margin-top:30px">
          <div class="container">
              <form method="post" action="SignIn">
                  <label  for="email">Email:</label>
                  <input class="form-control" type="email" id="email" name="email" placeholder="Email">
                  <br/>

                  <label for="password">Password:</label>
                  <input class="form-control" type="password" id="password" name="password" placeholder="Password">
                  <br/>

                  <%if(verification != null){%>
                      <p class="text-warning">
                          <%=verification%>
                      </p>
                  <%}%>

                  <button type="submit" class="btn btn-lg btn-success">Sign In</button>
                  <br/><br/>

                  <a href="SignUp">Not registered?</a>

              </form>
          </div>
      </div>
  </body>
</html>
