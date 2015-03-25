<%
    String verification = (String)request.getAttribute("verif");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type">
    <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap.css">
    <link rel="stylesheet" href="style/bootstrap-3.3.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="style/bootstrap-3.3.2/js/bootstrap.js">
    <title>EconomyList - Registration</title>
</head>
<body>
<h3 align="center">Registration</h3>
<div align="center" style="margin-top:30px">
    <div class="container">
        <form method="post" action="SignUp">
            <label  for="name">Name:</label>
            <input class="form-control" type="text" id="name" name="name" placeholder="Name">
            <br/>

            <label  for="surname">Surname:</label>
            <input class="form-control" type="text" id="surname" name="surname" placeholder="Surname">
            <br/>

            <label  for="email">Email:</label>
            <input class="form-control" type="email" id="email" name="email" placeholder="Email">
            <br/>

            <label for="password">Password:</label>
            <input class="form-control" type="password" id="password" name="password" placeholder="Password">
            <br/>

            <label for="repeat">Repeat password:</label>
            <input class="form-control" type="password" id="repeat" name="repeat" placeholder="Repeat password">
            <br/>

            <%if(verification != null){%>
                <p class="text-warning">
                    <%=verification%>
                </p>
            <%}%>

            <button type="submit" class="btn btn-lg btn-success">Sign up</button>
            <br/><br/>

            <a href="SignIn">Already registered?</a>

        </form>
    </div>
</div>
</body>
</html>
