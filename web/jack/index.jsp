<%-- 
    Document   : Index
    Created on : 20/04/2021, 1:05:35 PM
    Author     : 18038659
--%>

<%@page import="java.util.List"%>
<%@page import="nz.ac.massey.cs.webtech.s_18038659.server.Card"%>
<%@page import="nz.ac.massey.cs.webtech.s_18038659.server.GameSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
</head>
<body>

    <%--<jsp:useBean id="game" scope="session" class="nz.ac.massey.cs.webtech.s_18038659.server.Gamestate"/>--%>
    <% GameSession game = (GameSession) request.getAttribute("Gamestate");%>
    <div><h1>Welcome to Black Jack</h1></div>
<!--        <p>Players turn: <%= game.getDeck().size()%></p>-->
    <p><h2>Player Cards</h2></p>
<p><h3>Player score <%= game.getScorePlayerGame()%></h3></p>
<%
    for (Card card : game.getPlayerCards()) {
%>
<%--<%= card.getFaceName() %> <%= card.getSuit()%>--%>
<img src="<%= card.getCardURL(game.getUrl())%>" alt="card" ></a>

<%
    }
%>


<p><h2>Dealer Cards</h2></p>
<%
    if (game.getIsPlayersTurn()) {
        List<Card> cardList = game.getDealerCards();%>
<img src="<%= cardList.get(0).getCardURL(game.getUrl())%>" alt="card" ></a>
<img src="<%= game.getUrl() + "game/backOfCard.png"%>" alt="card" ></a>
<%
} else {
    List<Card> cardList = game.getDealerCards();
%>
<p><h3>Dealer score:<%=game.getScoreDealerGame()%></h3> </p>
<%
    for (Card card : cardList) {
%>
<%--<%= card.getFaceName() %> <%= card.getSuit()%>--%>
<img src="<%= card.getCardURL(game.getUrl())%>" alt="card" ></a>

<%
    }
%>

<%
    }
%>
<%
    if (game.getIsPlayersTurn()) {%>
<form action ="move/hit" method = "post" style=" position: relative">
    <input type="submit" value="Hit" >
</form>
<br>
<form action ="move/stand" method = "post" style="position: right">
    <input type="submit" value="Stand">
</form>
<%}%>
<%
    if (!game.getIsPlayersTurn()) {%>
<br> 
<form action ="./statsDisplay" method = "post" style="position: right">
    <input type="submit" value="Stats">
</form>

<% if (game.getWinner() != "Null") {%>
<p>winner is <%= game.getWinner()%></p>
<%  }%>
<%  }%>

</body>
</html>