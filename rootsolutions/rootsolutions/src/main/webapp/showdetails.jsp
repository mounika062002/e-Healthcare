<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="lform.css">
    <title>Document</title>
</head>
<body>
<%
String name = String.valueOf(session.getAttribute("name"));
int age = Integer.parseInt(String.valueOf(session.getAttribute("age")));
String history = String.valueOf(session.getAttribute("history"));
String Rdate = String.valueOf(session.getAttribute("Rdate"));
int sugar = Integer.parseInt(String.valueOf(session.getAttribute("sugar")));
int bp = Integer.parseInt(String.valueOf(session.getAttribute("bp")));
int pulserate = Integer.parseInt(String.valueOf(session.getAttribute("pulserate")));
String gender = String.valueOf(session.getAttribute("gender"));
%>



    <div class="container">
    <div class="title">Patient Details</div>
    <form class="#">
        <div class="user-details">
            <div class="input-box">
                <span class="details">Patient Id </span> 
                <p>enter id </p>
                </div>
                <br>
                <div class="input-box">
                    <span class="details">Patient name </span> 
                    <p>enter name</p>
                    </div>
                    <br>
                    <div class="input-box">
                        <span class="details">Patient Address </span> 
                        <p>enter address</p>
                        </div>
                        <br>
                        <div class="input-box">
                            <span class="details">Diabetes </span> 
                            <p>Enter Diabetes</p>
                            </div>
                            <br>
                            <div class="input-box">
                                <span class="details">Patient bp </span> 
                                <p>enter bp</p>
                                </div>
                                <br>
                                <div class="input-box">
                                    <span class="details">Patient ps </span> 
                                    <p>enter ps</p>
                                    </div>
                                    <br>
                                    <div class="input-box">
                                        <span class="details">Patient severity </span> 
                                        <p>enter severity</p>
                                        </div>
                                        <br>
                                        <div class="input-box">
                                            <span class="details">Patient histroy </span> 
                                            <p>enter histroy</p>
                                            </div>
        </div>
        
        <div class="btn">
            <input type="submit" value="Diabetes">
        </div>
  
        <div class="btn">
            <input type="submit" value="Blood Pressure">
        </div>
  
        <div class="btn">
            <input type="submit" value="Pulse Rate">
        </div>
  
        <div class="button">
            <input type="submit" value="Button">
        </div>

    </form>
    </div>

</body>
</html>