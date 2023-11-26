<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./LogIn.css">
</head>
<body>
    <div id="main_content">
        <header><h1>SHOP HOUSE</h1></header>
        <form action="LogInPage" method="post">
            <h2>Log In</h2>
            <label for="email">Email</label><br>
            <input type="text" name="email" id="email" class="input"><br>
            <label for="password">Password</label><br>
            <input type="password" name="password" id="password" class="input"><br>
            <%String message = (String)request.getAttribute("message"); %>
            <%if(message!=null){ %>
           	<h3><%=message%></h3>
            <%} %>
            <input type="submit" id="submit" value="Sign in">
        </form>
    </div>
</body>
</html>