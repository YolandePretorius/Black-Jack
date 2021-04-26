/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 18038659
 */
@WebServlet(name = "stand", urlPatterns = {"/jack/move/stand"})
public class stand extends HttpServlet {

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
        
        Object obj = session.getAttribute("game");
        GameSession gameState = (GameSession)obj;
        
        gameState.setIsPlayersTurn(!(gameState.isPlayersTurn)); //change to computer to deal cards
        if(gameState.getScorePlayerGame() > 21){
            throw new ServletException("PLAYER LOOSES,ITS A BUST");
        }
        
        gameState.setUrl("../");
        
        GameLogic gamelogic = new GameLogic();
        
        gamelogic.setDeckOfCards(gameState.getDeck());
        gamelogic.setPlayerCards(gameState.getPlayerCards());
        gamelogic.setDealerCards(gameState.getDealerCards());
        //gameState.setScorePlayerGame(gamelogic.getTotalScore(gamelogic.getPlayerCards()));
        gameState.setScoreDealerGame(gamelogic.getTotalDealerScore(gamelogic.getDealerCards()));
        
        while(gameState.getScoreDealerGame() < 17){
            gamelogic.dealerGetCard();
            gameState.setScoreDealerGame(gamelogic.getTotalDealerScore(gamelogic.getDealerCards()));
        }
        
        gameState.setDealerCards(gamelogic.getDealerCards());
        gameState.setDeck(gamelogic.getDeckOfCards());
        
        request.setAttribute("Gamestate",gameState);
        response.sendRedirect(request.getContextPath()+"/jack/start");
        
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet stand</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            
//            for (Card card : gameState.getPlayerCards()) {
//                 out.println("<h1>Player Card: "+ card.getFaceName()+" "+ card.getSuit()+"</h1>");
//            }
//
//            for (Card card : gameState.getDealerCards()) {
//                out.println("<h1>Dealer Cards: "+ card.getFaceName()+" "+ card.getSuit()+"</h1>");
//                }
//            out.println("<h1>Player card total: " +gameState.getScorePlayerGame()+"</h1>");
//            out.println("<h1>Dealer card total: " +gameState.getScoreDealerGame()+"</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
