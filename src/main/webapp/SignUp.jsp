<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop House:Sign Up</title>
<link rel="stylesheet" href="./css/signup.css">
</head>
<body>
    <div id="main_content">
        <header><h1>SHOP HOUSE</h1></header>
        <form action="SignUpPage" method="post">
            <h2>SIGN UP</h2>
            <label for="id">ID</label><br>
            <input type="number" id="id" name="id" class="input"><br>
            <label for="name">Name</label><br>
            <input type="text" id="name" name="name" class="input"><br>
            <label for="contact">Contact</label><br>
            <input type="number" id="contact" name="contact" class="input"><br>
            <label for="email">Email</label><br>
            <input type="email" name="email" id="email" class="input"><br>
            <label for="pass" >Password</label><br>
            <input type="password" name="password" id="pass" class="input"><br>

            <input type="submit" id="submit_button" value="Sign Up">
            
        </form>
    </div>
</body>
</html>