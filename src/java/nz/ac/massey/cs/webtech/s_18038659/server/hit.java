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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 18038659
 */
public class hit extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    /**
     * Destroys the servlet.
     */
    public void destroy() {

    }

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
        HttpSession session = request.getSession(false);
        response.addHeader("session-ID", session.getId());
        if (session == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);

            return;
        }

        Object obj = session.getAttribute("game");
        GameSession gameState = (GameSession) obj;
        //gameState.setIsPlayersTurn(!(gameState.isPlayersTurn));
        response.addHeader("session-ID", session.getId());
        GameLogic gamelogic = new GameLogic();
        gamelogic.setDeckOfCards(gameState.getDeck());
        gamelogic.setPlayerCards(gameState.getPlayerCards());
        gameState.setUrl("../");

        if (gameState.isPlayersTurn && gameState.getScorePlayerGame() < 21) {
            gamelogic.playerGetsCard();
            gameState.setDeck(gamelogic.getDeckOfCards());
            gameState.setPlayerCards(gamelogic.getPlayerCards());
            gameState.setScorePlayerGame(gamelogic.getTotalPlayerScore(gamelogic.getPlayerCards())); // score of players cards 
            request.setAttribute("Gamestate", gameState);
            response.sendRedirect(request.getContextPath() + "/jack/start");
        } else {

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "player busted");

            return;
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
