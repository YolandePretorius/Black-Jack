/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 18038659
 */
public class start extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
       
        GameSession gameState = new GameSession();
        
        session.setAttribute("game", gameState);
        gameState.setIsPlayersTurn(true);
        GameLogic gamelogic = new GameLogic();
        
        gamelogic.setInitialGameState(gameState);
        
        gameState.setDeck(gamelogic.deckCards);
        gameState.setPlayerCards(gamelogic.playerCards);
        gameState.setDealerCards(gamelogic.dealerCards);
        gameState.setNumberGamesPlayed(gamelogic.numberGamesPlayed);
        gameState.setScorePlayerGame(gamelogic.getTotalScore(gamelogic.getPlayerCards())); // score of players cards
        
        
        //connect to index---------------------------------------------------------
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jack/index.jsp");
        request.setAttribute("Gamestate",gameState);
        dispatcher.forward(request, response);
        //----------------------------------------------------------------------------
        
        
        
//        response.sendRedirect("index.jsp");
        
//        request.setAttribute("Player Cards", gameState.getPlayerCards());
//        
//        if (gameState.isPlayersTurn) {
//                List<Card> card = gameState.getDealerCards();
//                request.setAttribute("Dealer card", card.get(0));
////                out.println("<h1>Dealer Card1: "+ card.get(0).getFaceName()+" "+ card.get(0).getSuit()+"</h1>");
////                out.print("<h1>Dealer Card2, back of card<h1>");
//            } else {
//                request.setAttribute("Dealer cards", gameState.getDealerCards());
////                 out.println("<h1>Dealer Cards "+ card.getFaceName()+" "+ card.getSuit()+"</h1>");
//             }
        
//        response.sendRedirect("/")
// 
//        requestDispatcher.forward(request, response);
//        session.setAttribute("card1", 2);
//        session.setAttribute("card2", 44);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("Start");
            out.println("<title>Start</title>");            
            out.println("</head>");
            out.println("<body>");
           //out.println("<h1>Servlet start at " + session.getId() + "</h1>");
            out.println("<h1>Start game</h1>");
            for (Card card : gameState.getPlayerCards()) {
                 out.println("<h1>Player Card: "+ card.getFaceName()+" "+ card.getSuit()+"</h1>");
                 out.println("<h1>Player Card: "+ card.getCardURL()+"</h1>");
            }
            if (gameState.isPlayersTurn) {
                List<Card> card = gameState.getDealerCards();
                out.println("<h1>Dealer Card: "+ card.get(0).getFaceName()+" "+ card.get(0).getSuit()+"</h1>");
                out.print("<h1>Dealer Card, back of card<h1>");
            } else {
                for (Card card : gameState.getDealerCards()) {
                 out.println("<h1>Dealer Cards: "+ card.getFaceName()+" "+ card.getSuit()+"</h1>");
             }
             out.println();
            }
            out.println("Player card total: " +gameState.getScorePlayerGame());
            
//            for (Card card : gameState.Deck) {
//                //out.println("<h1>Deck of card"+ card.getFaceName()+"</h1>");
//                 out.println("<h1>Deck of card"+ card.getCardImage()+"</h1>");
//            }
//           out.println("<h2>Card1 " + session.getAttribute("card1") + "</h2>");
//           out.println("<h2>Card2 " + session.getAttribute("card2") + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
        
    processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
