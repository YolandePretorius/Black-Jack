/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 18038659
 */
@WebServlet(name = "statsXML", urlPatterns = {"/jack/statsXML"})
public class stats extends HttpServlet {

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
        String xml2String = null;
       // response.setContentType("text/html;charset=UTF-8");
        response.setContentType(" application/xml;charset=UTF-8");

//        File sFileOut = new File("stats.xml");
//
//        if (sFileOut.exists()) {
//            Reader fileReader = new FileReader(sFileOut);
//            BufferedReader bufReader = new BufferedReader(fileReader);
//            StringBuilder sb = new StringBuilder();
//            String line = bufReader.readLine();
//            while (line != null) {
//                sb.append(line).append("\n");
//                line = bufReader.readLine();
//            }
//            xml2String = sb.toString();
//
////Read more: https://javarevisited.blogspot.com/2015/07/how-to-read-xml-file-as-string-in-java-example.html#ixzz6uDqi7KAr
//        }

        File sFileOut = new File("stats.xml");
        if (sFileOut.exists()) {
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream("stats.xml");
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        }

        //try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            //out.print("hello");
            //out.print(xml2String);
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet statsXML</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet statsXML at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        //}
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
