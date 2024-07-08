<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="NewFile1.css">
</head>
<body>

<h1>Login page</h1>
    <div class="container">
    <form action="LoginServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" class="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" class="password" name="password" required><br><br>
        
        <input type="submit" class="submit" value="Login">
    </form>
    </div>
</body>
</html>
