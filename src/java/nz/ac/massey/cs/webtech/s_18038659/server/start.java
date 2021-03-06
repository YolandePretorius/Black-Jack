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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 18038659
 */
@WebServlet(name = "start", urlPatterns = {"/jack/start"})
public class start extends HttpServlet {

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
        String url = response.encodeURL("/jack/index.jsp");
        HttpSession session = request.getSession(false);
//        GameSession gameState = new GameSession();
        

        if (session == null) {
            GameSession gameState = new GameSession();
            session = request.getSession(true);
            gameState.setIsPlayersTurn(true);
            GameLogic gamelogic = new GameLogic();
            gameState.setUrl("../");
            gamelogic.setInitialGameState(gameState);

            gameState.setDeck(gamelogic.deckCards);
            gameState.setPlayerCards(gamelogic.playerCards);
            gameState.setDealerCards(gamelogic.dealerCards);
            gameState.setNumberGamesPlayed(gamelogic.numberGamesPlayed);
            gameState.setScorePlayerGame(gamelogic.getTotalPlayerScore(gamelogic.getPlayerCards())); // score of players cards

            session.setAttribute("game", gameState);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            request.setAttribute("Gamestate", gameState);
            dispatcher.include(request, response);

        } else {

            Object obj = session.getAttribute("game");
            GameSession gameState = (GameSession) obj;
            request.setAttribute("Gamestate", gameState);
            
            response.addHeader("session-ID", session.getId());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.include(request, response);
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
