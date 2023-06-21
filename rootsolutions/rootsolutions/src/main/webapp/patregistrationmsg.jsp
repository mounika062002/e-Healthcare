<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="thank.css">
    <title>Document</title>
</head>
<body>
<%

String pid=String.valueOf(session.getAttribute("pid"));
%>

    <div class="hero">
    <form action="returnhome">
    <p>THANK YOU!</p>
    <br>
    <p>Patient registration is completed</p>
    <br>
     Patient-id: <a><%=pid%></a>
    
    <br>
    <br>
    <p>"Please Remember This"</p>
    <div class="btn">
    <input type="submit" value="submit">
    </div>

    </div>
 
</form>
</body>
</html>