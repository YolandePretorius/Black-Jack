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
        HttpSession session = request.getSession(false);
        response.addHeader("session-ID", session.getId());
        if (session == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Object obj = session.getAttribute("game");
        GameSession gameState = (GameSession) obj;

        gameState.setIsPlayersTurn(false); //change to computer to deal cards


       // gameState.setUrl("../../");

        GameLogic gamelogic = new GameLogic();

        gamelogic.setDeckOfCards(gameState.getDeck());
        gamelogic.setPlayerCards(gameState.getPlayerCards());
        gamelogic.setDealerCards(gameState.getDealerCards());

        int totalDealerScore = gamelogic.getTotalDealerScore(gamelogic.getDealerCards());
        if (gameState.getScorePlayerGame() <= 21) {
            while (totalDealerScore < 17) {
                gamelogic.dealerGetCard();
                totalDealerScore = gamelogic.getTotalDealerScore(gamelogic.getDealerCards());

            }
        }
        gameState.setScoreDealerGame(totalDealerScore);
        gameState.setDealerCards(gamelogic.getDealerCards());
        gameState.setDeck(gamelogic.getDeckOfCards());

        request.setAttribute("Gamestate", gameState);
        response.sendRedirect(request.getContextPath() + "/jack/state");
//        response.setStatus(HttpServletResponse.SC_OK);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jack/start");
//        dispatcher.include(request, response);

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
