<%-- 
    Document   : jack
    Created on : 20/04/2021, 10:11:08 PM
    Author     : 18038659
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Black Jack</title>
    </head>
    <jsp:useBean id="user" scope="session" class="nz.ac.massey.cs.webtech.s_18038659.server.Card"/>
    <body>
        <h1>Welcome to Black Jack</h1>
        
    <form action ="start" method = "post">
        <p>
         <input type="submit" value="Start">
        </p>
    </form>
    </body>
</html>
