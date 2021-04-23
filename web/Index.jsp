<%-- 
    Document   : Index
    Created on : 20/04/2021, 1:05:35 PM
    Author     : 18038659
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
<jsp:useBean id="user" scope="session" class="nz.ac.massey.cs.webtech.s_18038659.server.Card"/>
    <body>
        <h1>Hello form index</h1>
        <form action ="start" method = "post">
            <p> Name: <input type ="text" name="name"/>
            </p>
            <p>
         <input type="submit" value="Submit">
            </p>
    </form>
    </body>
</html>
