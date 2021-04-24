<%-- 
    Document   : Index
    Created on : 20/04/2021, 1:05:35 PM
    Author     : 18038659
--%>

<%@page import="nz.ac.massey.cs.webtech.s_18038659.server.GameSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    
        <%--<jsp:useBean id="game" scope="session" class="nz.ac.massey.cs.webtech.s_18038659.server.Gamestate"/>--%>
        <% GameSession game = (GameSession)request.getAttribute("Gamestate");%>
        <div>Welcome to Black Jack</div>
<!--        <p>Players turn: <%= game.getDeck().size()%></p>-->
        <%
            for (Object object : game.getPlayerCards()) {
        %> <li><%= object %>
      <%
      }
      %>
        
    
<!--        <form action ="start" method = "post">
            <p> Name: <input type ="text" name="name"/>
            </p>
            <p>
         <input type="submit" value="Submit">
            </p>-->
    </form>
    

