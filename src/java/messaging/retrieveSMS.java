/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messaging;

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
public class retrieveSMS extends HttpServlet {

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
    
      String msg,current_msg,status,category;
   HttpSession session;
    int count=0;
     String message;
     String Showmsgs="";
     String msgs="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Showmsgs="";
           Showmsgs+="<tr><th>#</th><th>MESSAGE</th><th>select message </th></tr>";
            
          if(request.getParameter("category")!=null && !request.getParameter("category").equals("")){
           category=request.getParameter("category"); }
//           System.out.println("status:"+ status); 
           current_msg="";
           count=0;
           
           
//           String titles="select status,PhoneNo,FName from mother_details where status='"+status+"'";
//           System.out.println(titles);
           String sms="";
          int msgcount=0;
//          int count1;
           dbConnect conn=new dbConnect();
        
//           conn.rs=conn.state.executeQuery(titles);
             String getmsgs="select * from messages where category='"+category+"'";
             System.out.println(getmsgs);
              conn.rs = conn.state.executeQuery(getmsgs) ;
              while(conn.rs.next()){
           count++;
           msgcount++;
           sms=conn.rs.getString("message");
               Showmsgs+="<tr><td>"+count+"</td><td><p id=\"label_"+count+"\">" +sms+"</p> "
                       + "  <input type=\"hidden\" value=\""+sms+"\" name=\"sms_"+count+"\"  id=\"sms_"+count+"\"></td>"
                   + "<td><input value=\"\"   type=\"checkbox\" onclick=\"togglesms('"+count+"');\" name=\"msg_"+count+"\" id=\"msg_"+count+"\" ></td></tr>";
           
           
           
              }
                   Showmsgs+=  "<tr><td><input type=\"hidden\" value=\""+count+"\" name=\"counter\"></td></tr>";
               if(msgcount==0){
            
            Showmsgs="<h2 style=\"background:white; \">NO messages under the selected category. You may add new messages for that category <a class=\"linkstyle\" href=\"createSMS.jsp\">here </a> .</h2>";
            }
          Showmsgs+="<tr><td><input type=\"submit\" value=\"submit\" name=\"submit\" class=\"submit\" id=\"submit\"  ></td></tr>";
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<body>");
            out.println(""+Showmsgs+"");
            out.println("</body>");
            out.println("</html>");
              count++; 
//              session.setAttribute("count", count);
        } finally {            
            out.close();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(retrieveSMS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(retrieveSMS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
