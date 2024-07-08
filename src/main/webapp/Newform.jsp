<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body >
<h1 id="h">Registration form</h1>
<div class="container">
<form action="servletoperation" method="post">
<input type="text" class="name" name="name"  placeholder="Name"><br>
<input type="text" class="email" name="email"  placeholder="Emai"><br>
<input type="text" class="password" name="password"  placeholder="Password"><br>
<input type="text" class="address" name="address"  placeholder="Address"><br>
<input type="text" class="place" name="place"  placeholder="Place"><br>
<input type="text" class="phoneno" name="phoneno" placeholder="Phoneno"><br>
<input type="submit" class="submit" name=register>
</form>
</div>
</body>
</html>