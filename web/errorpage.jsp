<%-- 
    Document   : errorpage
    Created on : 24/04/2021, 9:19:31 PM
    Author     : 18038659
--%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%= exception.getMessage() %>
    </body>
</html>
