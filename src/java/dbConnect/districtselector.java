/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class districtselector extends HttpServlet {


    String DistrictID,current_districts;
   HttpSession session; 
    ArrayList dist=new ArrayList();
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
           session= request.getSession();
       
           DistrictID=request.getParameter("district"); 
           System.out.println(" District:"+ DistrictID); 
           current_districts="";
 String Location="";
 if(session.getAttribute("Location")!=null){
 Location=session.getAttribute("Location").toString();
 }
 
 System.out.println("bbb   "+Location);
           String districts="select * from dicname where DistrictID='"+DistrictID+"'";
           System.out.println(districts);
           dbConnect conn=new dbConnect();
           
           conn.rs=conn.state.executeQuery(districts);
           
           //add all the districts to the 
          
           current_districts="<option value=\"\">Choose DIC Name</option>";
           
           while(conn.rs.next()){
               
         //dist arraylist stays in the session
          dist.add(conn.rs.getString("DICName")); 
          
          
          //dynamically add districts to the string array
          if(Location.equalsIgnoreCase("Naivasha")){
              current_districts="";
               current_districts+="<option value=\"\">Choose DIC Name</option>";
          current_districts+="<option value=\"Naivasha\">Naivasha</option>";

          }
          else{
              current_districts="";
                current_districts+="<option value=\"\">Choose DIC Name</option>";
          
              String districts1="select * from dicname where DistrictID='"+DistrictID+"' and DICName!='Naivasha'";  
              System.out.println(districts1);
              conn.rs2= conn.state2.executeQuery(districts1);
              while(conn.rs2.next()){
           current_districts+="<option value=\""+conn.rs2.getString("DICName")+"\">"+conn.rs2.getString("DICName")+"</option>";
             System.out.println(current_districts);
              
              }
          }
          //        session.setAttribute("dist_names",dist);
         //12767711
        //3840
       //      1994
       // System.out.println(" <<>"+conn.rs.getString("district_name"));
         
           }
               
           
          //  System.out.println("size:" +dist.size());
      
          // System.out.println("My districts:"+current_districts);
           
           
           PrintWriter out = response.getWriter();
            
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" +current_districts+"</h1>");
            out.println("</body>");
            out.println("</html>");
             
           
           
           
       		
                         if(conn.rs!=null){ conn.rs.close();}
         if(conn.rs1!=null){ conn.rs1.close();}
         if(conn.rs2!=null){ conn.rs2.close();}
         if(conn.rs3!=null){ conn.rs3.close();}
         if(conn.rs4!=null){ conn.rs4.close();}
         if(conn.rs5!=null){ conn.rs5.close();}
         if(conn.rs6!=null){ conn.rs6.close();}
         if(conn.rs7!=null){ conn.rs7.close();}
        
         if(conn.state!=null){ conn.state.close();}
         if(conn.state1!=null){ conn.state1.close();}
         if(conn.state2!=null){ conn.state2.close();}
         if(conn.state3!=null){ conn.state3.close();}
         if(conn.state4!=null){ conn.state4.close();}
         if(conn.state5!=null){ conn.state5.close();}
         if(conn.state6!=null){ conn.state6.close();}
         if(conn.state7!=null){ conn.state7.close();}    
        
          // response.sendRedirect("myajax.html");
        } catch (SQLException ex) {
            Logger.getLogger(districtselector.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
