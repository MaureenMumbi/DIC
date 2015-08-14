/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enroll;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class AuditServlet extends HttpServlet {

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
       dbConnect conn = new dbConnect();


String DrnkAlc = request.getParameter("DrnkAlc");
String AlchHav = request.getParameter("AlchHav");
String DrnkOcc = request.getParameter("DrnkOcc");
String StpDrnk = request.getParameter("StpDrnk");
String FailDrnk = request.getParameter("FailDrnk");
String RemHap = request.getParameter("RemHap");
String NeedAlc = request.getParameter("NeedAlc");
String GuiltDrnk = request.getParameter("GuiltDrnk");
String InjureDrnk = request.getParameter("InjureDrnk");
String FriendDrnk = request.getParameter("FriendDrnk");
 String DrnkAlctxt="";
 String AlchHavtxt="";
 String DrnkOcctxt="";
 String StpDrnktxt="";
 String FailDrnktxt ="";
 String RemHaptxt="";
 String NeedAlctxt="";
 String GuiltDrnktxt="";
 String InjureDrnktxt="";
 String FriendDrnktxt="";

 DrnkAlctxt = request.getParameter("DrnkAlctxt");


 AlchHavtxt = request.getParameter("AlchHavtxt");

DrnkOcctxt = request.getParameter("DrnkOcctxt");

StpDrnktxt =  request.getParameter("StpDrnktxt");

FailDrnktxt = request.getParameter("FailDrnktxt");

RemHaptxt = request.getParameter("RemHaptxt");

NeedAlctxt = request.getParameter("NeedAlctxt");

GuiltDrnktxt =request.getParameter("GuiltDrnktxt") ;

 InjureDrnktxt = request.getParameter("InjureDrnktxt");

FriendDrnktxt = request.getParameter("FriendDrnktxt");

int A1=0,A2=0,A3=0,A4=0,A5=0,A6=0,A7=0,A8=0,A9=0,A10=0;
//GETS THE VALUES POSTED AND MAKES THEM INTEGER TO ALLOW FOR ADDITION
if(!request.getParameter("DrnkAlctxt").equals("") && request.getParameter("DrnkAlctxt")!= null){
 A1 =Integer.parseInt(DrnkAlctxt);}
else{
    A1=0;
}
if(request.getParameter("AlchHavtxt")!= null && !request.getParameter("AlchHavtxt").equals("") ){
 A2 =Integer.parseInt(AlchHavtxt);}
else{
A2=0;
}
if(request.getParameter("DrnkOcctxt")!= null && !request.getParameter("DrnkOcctxt").equals("") ) {
 A3 =(Integer.parseInt(DrnkOcctxt));}
else{
A3=0;}
if(request.getParameter("StpDrnktxt")!= null && !request.getParameter("StpDrnktxt").equals("") ){
 A4 =Integer.parseInt(StpDrnktxt);}
else{
A4=0;}
if(request.getParameter("FailDrnktxt")!= null && !request.getParameter("FailDrnktxt").equals("") ){
 A5 =Integer.parseInt(FailDrnktxt);}
else{
A5=0;}
if(request.getParameter("RemHaptxt")!= null && !request.getParameter("RemHaptxt").equals("")){
 A6 =Integer.parseInt(RemHaptxt);}
else{A6=0;}
if(request.getParameter("NeedAlctxt")!=null && !request.getParameter("NeedAlctxt").equals("") ){
A7 =Integer.parseInt(NeedAlctxt);}
else{
A7=0;}
if(request.getParameter("GuiltDrnktxt")!=null && !request.getParameter("GuiltDrnktxt").equals("") ){
A8 =Integer.parseInt(GuiltDrnktxt);}
else{
A8=0;}
if(request.getParameter("InjureDrnktxt")!=null && !request.getParameter("InjureDrnktxt").equals("")){
 A9 =Integer.parseInt(InjureDrnktxt);}
else{
A9=0;}
if(request.getParameter("FriendDrnktxt")!=null && !request.getParameter("FriendDrnktxt").equals("")){
 A10 =Integer.parseInt(FriendDrnktxt);}
else{
A10=0;}


System.out.println(DrnkAlc+""+AlchHav+""+DrnkOcc+""+StpDrnk+""+FailDrnk+""+RemHap+""+NeedAlc+""+GuiltDrnk+
        ""+InjureDrnk+""+FriendDrnk+""+DrnkAlctxt+""+AlchHavtxt+""+DrnkOcctxt+""+StpDrnktxt+""+FailDrnktxt+""+RemHaptxt+""+GuiltDrnktxt+""+InjureDrnktxt+""+FriendDrnktxt+""+NeedAlctxt);

int FinalAudit =A1+A2+A3+A4+A5+A6+A7+A8+A9+A10;
System.out.println("FinalAudit"+FinalAudit);
HttpSession session;
session = request.getSession(true);
String UniqueID = (String) session.getAttribute("UniqueID");

System.out.println("SESSION"+ UniqueID);

                    try {
    
                        conn.state.executeUpdate("INSERT INTO audit(UniqueID,DrnkAlc,AlchHav,DrnkOcc,StpDrnk,FailDrnk,RemHap,NeedAlc,GuiltDrnk,InjureDrnk,FriendDrnk,DrnkAlctxt,"
                                + "AlchHavtxt,DrnkOcctxt,StpDrnktxt,FailDrnktxt,RemHaptxt,NeedAlctxt,GuiltDrnktxt,InjureDrnktxt,FriendDrnktxt,FinalAudit,syncstatus)"
                                + "VALUES('"+UniqueID+"','"+DrnkAlc+"','"+AlchHav+"','"+DrnkOcc+"','"+StpDrnk+"','"+FailDrnk+"','"+RemHap+"','"+NeedAlc+"','"+GuiltDrnk+"','"+InjureDrnk+"',"
                                + "'"+FriendDrnk+"',"
                                + "'"+DrnkAlctxt+"','"+AlchHavtxt+"','"+DrnkOcctxt+"','"+StpDrnktxt+"','"+FailDrnktxt+"','"+RemHaptxt+"','"+NeedAlctxt+"',"
                                + "'"+GuiltDrnktxt+"','"+InjureDrnktxt+"','"+FriendDrnktxt+"','"+FinalAudit+"','0')");
                        out.println("Saved Successfully");
                        session.setAttribute("saved", "Saved Successfully");
                        
                                         
                    
                    		
                         if(conn.rs!=null){ conn.rs.close();}
     
         if(conn.state!=null){ conn.state.close();}
       
                    
                    
                    }
catch (SQLException ex) {
                                               Logger.getLogger(AuditServlet.class.getName()).log(Level.SEVERE, null, ex);
                                              System.out.println(ex.toString()) ;
                                           }


response.sendRedirect("audit.jsp");


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
