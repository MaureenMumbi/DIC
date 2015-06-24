/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maureen
 */
public class AddQuestionnaire extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String domain= request.getParameter("domain");
            String SubDomainID= request.getParameter("subdomain");
            String Question= request.getParameter("question");
            String QuestionNo= request.getParameter("questionName");
            String questionName= request.getParameter("type");
            String type= request.getParameter("type");
            String isCoded= request.getParameter("iscoded");
            String required= request.getParameter("required");
            String code= request.getParameter("code");
            String HasDependant= request.getParameter("HasDependants");
            String DependantValue= request.getParameter("DependantValue");
            String DependantQstn= request.getParameter("dependantQuestion");
      dbConnect conn = new dbConnect();
    String query = "INSERT INTO questions(DomainID,SubDomainID,Question,type,isCoded,hasDependant,DependantValue,DependantQuestion,questionNo,questionsName,code,required)"
            + " VALUES ('"+domain+"','"+SubDomainID+"','"+Question+"','"+type+"','"+isCoded+"','"+HasDependant+"','"+DependantValue+"','"+DependantQstn+"',"
            + "'"+QuestionNo+"','"+questionName+"','"+code+"','"+required+"')";
    
 try {
                    conn.state.executeUpdate(query);
                    out.println("Inserted into db");
//                   response.sendRedirect("../DIC/DistrictServletRecord");
                } catch (SQLException ex) {
                    Logger.getLogger(AddDIC.class.getName()).log(Level.SEVERE, null, ex);
                    out.println(ex);
                }
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
