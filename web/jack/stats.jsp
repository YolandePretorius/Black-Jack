<%-- 
    Document   : stats
    Created on : 30/04/2021, 10:05:57 AM
    Author     : 18038659
--%>

<%@page import="nz.ac.massey.cs.webtech.s_18038659.server.GameStats"%>
<%@page contentType="xml/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stats Page</title>
    </head>
    <body>
        <h1>Game Stats!!! </h1>
        <% GameStats gameStat = (GameStats) request.getAttribute("GameStats");%>
        <p>Number of games dealer won: <%= gameStat.getNumGamesDealerWon()%></p>
        <p>Number of games player won: <%= gameStat.getNumGamesPlayerWon()%></p>
        <p>Number of games played: <%= gameStat.getTotalGamesPlayed()%></p>
        <p>User win percentage: <%= gameStat.getUserWinPersentage()%></p>

</html>
