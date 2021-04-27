/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "won", urlPatterns = {"/jack/won"})
public class won extends HttpServlet {
    
    

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
        
         if(session == null){
            throw new ServletException("404 Not Found");
        }
        
        Object obj = session.getAttribute("game");
        GameSession gameState = (GameSession)obj;
        
        int dealerScore = gameState.getScoreDealerGame();
        int playerScore = gameState.getScorePlayerGame();
        
        GameLogic gamelogic = new GameLogic();
        
        if(gameState.isPlayersTurn){
          String winner = "none";
          gameState.setWinner(winner);
        }else{
           String winner = gamelogic.getWinner(dealerScore, playerScore);
           gameState.setWinner(winner);
        }
        
        if(!"none".equals(gameState.getWinner())){
            //session.invalidate();
            request.setAttribute("Gamestate",gameState);
            response.sendRedirect(request.getContextPath()+"/jack/start");
        }else{
            request.setAttribute("Gamestate",gameState);
            response.sendRedirect(request.getContextPath()+"/jack/start");
        }
       
//        request.setAttribute("Gamestate",gameState);
//        response.sendRedirect(request.getContextPath()+"/jack/start");
    }
       
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet won</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet won at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    

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
