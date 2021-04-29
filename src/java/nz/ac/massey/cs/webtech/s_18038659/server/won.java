/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        
        
        // Create stats object that will keep track of wins and losses 
//        GameStats gameS = new GameStats();
//       
//       if(gameState.getWinner() == "player"){
//           gameS.setNumGamesPlayerWon();
//       }
//       
//       if(gameState.getWinner() == "dealer"){
//           gameS.setNumGamesDealerWon();
//       }
       
       
        //read stats from xml file 
       GameStats gameSatsNew = null;
        try{
            File sFileOut =  new File("stats.xml");
            if (sFileOut.exists()){
                FileInputStream fis = new FileInputStream(sFileOut);
                XMLDecoder decoder = new XMLDecoder(fis); 
                
                // Create stats object that will keep track of wins and losses 
                gameSatsNew =(GameStats)decoder.readObject();
                decoder.close();
                
                if(gameState.getWinner() == "player"){
                    gameSatsNew.setNumGamesPlayerWon();
                }
                if(gameState.getWinner() == "dealer"){      
                    gameSatsNew.setNumGamesDealerWon();
                }
            }
                }catch(IOException ex){
                ex.printStackTrace();
        }
//        //Store stats in xml file 
        
         // Create stats object that will keep track of wins and losses 

       
        try{
            File sFile =  new File("stats.xml");
            sFile.createNewFile();
            FileOutputStream statsFileOut = new FileOutputStream(sFile,false);
            //FileOutputStream statsFileOut = new FileOutputStream(new File("./stats.xml"));
            XMLEncoder encoder = new XMLEncoder(statsFileOut);
            encoder.writeObject(gameSatsNew);
            encoder.close();
            statsFileOut.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        } 
        
        if(!"none".equals(gameState.getWinner())){
            //session.invalidate();
            request.setAttribute("Gamestate",gameState);
            response.sendRedirect(request.getContextPath()+"/jack/start");
        }else{
            request.setAttribute("Gamestate",gameState);
            response.sendRedirect(request.getContextPath()+"/jack/start");
        }
    }   
        
        
        
//       GameStats gameS = new GameStats();
//       if(gameState.getWinner() == "player"){
//           gameS.setNumGamesPlayerWon();
//       }
//       
//       if(gameState.getWinner() == "dealer"){
//           gameS.setNumGamesDealerWon();
//       }
//       
//        try{ 
//            
//            FileOutputStream fos = new FileOutputStream(new File("stats.xml"));
//            
//            XMLEncoder encoder = new XMLEncoder(fos);
//            encoder.writeObject(gameS);
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
//        
//        //read stats from xml file 
//        try{
//            FileInputStream fis = new FileInputStream("/jack/stats.xml");
//            XMLDecoder decoder = new XMLDecoder(fis);   
//            }catch(IOException ex){
//            ex.printStackTrace();
//        }
//        //Store stats in xml file 
//        
        
    
       
        

    

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
