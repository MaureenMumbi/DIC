/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.AES;
import dbConnect.dbConnect;
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
public class getData extends HttpServlet {

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
    HttpSession session ;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     session = request.getSession();
        try {
          String dic="";
  String startdate="";
  String enddate="";
  String fullname="";
  String uniqueid="";
  String dicname="";
  String wards="";
  String alldata="";
      String FirstName="";
      String MiddleName="";
      String LastName="";    
                                        ArrayList warddata = new ArrayList();
//  alldata+="<thead><th>FULL NAME</th><th>UNIQUE ID</th><th>DIC</th><th>WARD</th></thead><tbody>";
  dic=request.getParameter("type");
  dbConnect conn = new dbConnect();
  
       if(warddata!=null && warddata.size()>0 ){warddata.clear();}
  String getppls="select FirstName,SecondName, LastName, UniqueID,dicname,ward from enrollment where dicname='"+dic+"'";
  System.out.println(getppls);
  conn.rs= conn.state.executeQuery(getppls);
  while(conn.rs.next()){
      
      
      final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString("FirstName")!=null && !conn.rs.getString("FirstName").trim().equals("") && !conn.rs.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs.getString("SecondName")!=null && !conn.rs.getString("SecondName").trim().equals("") && !conn.rs.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs.getString("LastName")!=null && !conn.rs.getString("LastName").trim().equals("") && !conn.rs.getString("LastName").equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs.getString("LastName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("LastName"));
                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
  fullname=FirstName+" "+MiddleName+"  "+LastName;
  dicname=conn.rs.getString(5);
  uniqueid=conn.rs.getString(4);
  wards=conn.rs.getString(6);
// String getWards="select * from wards where subcounty='"+dicname+"'";
//  conn.rs= conn.state2.executeQuery(getWards);
//  while(conn.rs.next()){
//  wards= conn.rs.getString("ward");
//  }

               wardbean DB= new wardbean();
                       DB.setUNIQUEID(uniqueid);
                       DB.setDICNAME(dicname);
                       if(session.getAttribute("lockNames")==null){
                                DB.setFULLNAME("");  
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
                              DB.setFULLNAME("");      
                                }
                                else{
                                DB.setFULLNAME(fullname);
                                }
                                }
                       DB.setWARD(wards);
                       
                       
                       System.out.println(uniqueid+" "+fullname +" "+wards);
//  alldata+="<tr><td>"+fullname+"</td>"
//          + "<td>"+uniqueid+"</td>"
//          + "<td>"+dicname+"</td>"
//          + "<td>"+wards  + "</td>"
//          + "<select name=\"ward\"  id=\"ward\"> "
//          + "<option value=\"\">Choose a ward</option>"
//          + "<option value=\""+wards+"\">"+wards+"</option></select>"
        
//          + "<td></td>"
//          + "</tr>";
                       
                       warddata.add(DB);
                      
  }
      session.setAttribute("warddata", warddata);
                                  
 		
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
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
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
