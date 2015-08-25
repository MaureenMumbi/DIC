/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import dbConnect.AES;
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
public class syncbyuniqueid extends HttpServlet {

      HttpSession session;  
      
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String returntable="";
      String FirstName="";
      String MiddleName="";
      String LastName="";
     
        session=request.getSession();
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String msg="";
            
            String uniqueid="";
            
            if(request.getParameter("value")!=null){
                
                uniqueid=request.getParameter("value").trim();
                
            }
            
            
            SyncMissingData sd=new SyncMissingData();
            
            if(sd.syncbetweentwodics(uniqueid)){
                msg="Data for client synced succesfully";
                
            }
            else {
                msg="Syncing ended with an error. Please contact the system administrator! ";
            }
            dbConnect conn= new dbConnect();
            
            conn.rs1=conn.state.executeQuery("select * from enrollment where UniqueID='"+uniqueid+"'");
            System.out.println("select * from enrollment where UniqueID='"+uniqueid+"'");
            
            int count=0;
            
            
            while(conn.rs1.next()){
                
                count++;
                
                final  String strPssword ="?*1>9@(&#";
                AES.setKey(strPssword);
                if(conn.rs1.getString("FirstName")!=null && !conn.rs1.getString("FirstName").trim().equals("") && !conn.rs1.getString("FirstName").equals("null")){
                    
                    AES.decrypt(conn.rs1.getString("FirstName").trim());
                    System.out.println("String To Decrypt : " +  conn.rs1.getString("FirstName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                     FirstName = AES.getDecryptedString();
                }
                
                if(conn.rs1.getString("SecondName")!=null && !conn.rs1.getString("SecondName").trim().equals("") && !conn.rs1.getString("SecondName").equals("null")){
//
                    AES.decrypt(conn.rs1.getString("SecondName").trim());
                    System.out.println("String To Decrypt : " + conn.rs1.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                     MiddleName = AES.getDecryptedString();
                }
                if(conn.rs1.getString("LastName")!=null && !conn.rs1.getString("LastName").trim().equals("") && !conn.rs1.getString("LastName").equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs1.getString("LastName").trim());
                    System.out.println("String To Decrypt : " + conn.rs1.getString("LastName"));
                     LastName = AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                }  
                
                if(session.getAttribute("lockNames")==null){
                    returntable=returntable+"<tr><td>Kindly Login to view details</td></tr>";
                    
                }  
                else{
                    if(session.getAttribute("lockNames").toString().equals("YES")){
                        returntable=returntable+"<tr><td><h3>Not allowed to view names</h3></td></tr><tr><td><h3>DIC Name</h3></td><td><h3>"+conn.rs1.getString("DICName") +"</h3></td></tr><tr><td><h3>UniqueID    :</h3></td><td><h3>"+conn.rs1.getString("UniqueID")+"</h3></td></tr>";
                        
                    }
                    else{
                        
                        returntable=returntable+"<tr><td><h3>Full Name   :</h3></td><td><h3>"+FirstName +"  "+LastName +"</h3></td></tr><tr><td><h3>DIC Name</h3></td><td><h3>"+conn.rs1.getString("DICName") +"</h3></td></tr><tr><td><h3>UniqueID    :</h3></td><td><h3>"+conn.rs1.getString("UniqueID")+"</h3></td></tr>";
                      }}
                
                
            }
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
        
            
            
            PrintWriter out = response.getWriter();
            try {
                /* TODO output your page here. You may use following sample code. */
                
                out.println(msg+"%"+returntable);
                
                } finally {
                out.close();
            }
        }   catch (SQLException ex) {
            Logger.getLogger(syncbyuniqueid.class.getName()).log(Level.SEVERE, null, ex);
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
