/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

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
 * @author Geofrey Nyabuto
 */
public class dic_changer extends HttpServlet {
int counter=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           dbConnect conn= new dbConnect();
           counter=0;
           String select_dic="select * from enrollment";
           conn.rs=conn.state.executeQuery(select_dic);
           while(conn.rs.next()){
               String dic_name="";
             String unique=conn.rs.getString(1); 
             
             if(counter>0 && counter<=30){
                 dic_name="Nakuru Central";
                 String county_id="";
              String update_dic= "UPDATE enrollment set DICName='"+dic_name+"', District='"+county_id+"' where UniqueID='"+unique+"'";
              conn.state1.executeUpdate(update_dic);
             } 
            
                          if(counter>30 && counter<=80){
                 dic_name="Salgaa";
                 String county_id="";
              String update_dic= "UPDATE enrollment set DICName='"+dic_name+"', District='"+county_id+"' where UniqueID='"+unique+"'";
              conn.state1.executeUpdate(update_dic);
             }
                if(counter>80 && counter<=120){
                 dic_name="Narok";
                 String county_id="";
              String update_dic= "UPDATE enrollment set DICName='"+dic_name+"', District='"+county_id+"' where UniqueID='"+unique+"'";
              conn.state1.executeUpdate(update_dic);
             }
                  if(counter>120 && counter<=180){
                 dic_name="Naivasha";
                 String county_id="";
              String update_dic= "UPDATE enrollment set DICName='"+dic_name+"', District='"+county_id+"' where UniqueID='"+unique+"'";
              conn.state1.executeUpdate(update_dic);
             }
                                             
                 if(counter>180 && counter<=215){
                 dic_name="Nanyuki";
                 String county_id="";
              String update_dic= "UPDATE enrollment set DICName='"+dic_name+"', District='"+county_id+"' where UniqueID='"+unique+"'";
              conn.state1.executeUpdate(update_dic);
             }
                 if(counter>215 && counter<=229){
                 dic_name="Nakuru Central";
                 String county_id="";
              String update_dic= "UPDATE enrollment set DICName='"+dic_name+"', District='"+county_id+"' where UniqueID='"+unique+"'";
              conn.state1.executeUpdate(update_dic);
             }
            counter++;   
           }
           
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
            Logger.getLogger(dic_changer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(dic_changer.class.getName()).log(Level.SEVERE, null, ex);
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
