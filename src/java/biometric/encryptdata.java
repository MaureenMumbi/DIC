/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

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

/**
 *
 * @author Maureen
 */
public class encryptdata extends HttpServlet {

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
        try {
          dbConnect conn= new dbConnect();
            
            String selectdata="Select UniqueID,FirstName,SecondName,LastName, PhoneNo,fingerprint from enrollment  where ( PhoneNo not like '%==' && FirstName not like '%==' && LastName not like '%=='  ) ";            
            conn.rs=conn.state.executeQuery(selectdata);
            AES aes=new AES();
            String val=AES.encrypt("yes");
        System.out.println(" Encrypted: " + AES.getEncryptedString());
            
            while(conn.rs.next()){
                String update="update enrollment set ";                
           // System.out.println("__"+conn.rs.getString(2));
            if(conn.rs.getString("FirstName")!=null&&!conn.rs.getString("FirstName").equals("null")&& !conn.rs.getString("FirstName").trim().equals("")){
            AES.encrypt(conn.rs.getString("FirstName").trim());
            String fname=AES.getEncryptedString();
            update+=" FirstName='"+fname+"' , ";
            //AES.decrypt(fname);
            //System.out.println(" Decrepted name__"+AES.getDecryptedString());
            
                                                     }
            else {
              update+=" FirstName='' , ";
            }
            if(conn.rs.getString("SecondName")!=null&&!conn.rs.getString("SecondName").equals("null")&& !conn.rs.getString("SecondName").trim().equals("")){
            AES.encrypt(conn.rs.getString("SecondName").trim());
            String mname=AES.getEncryptedString();
            update+=" SecondName='"+mname+"' , ";
                                                     }
             else {
              update+=" SecondName='' , ";
            }
            
            
             if(conn.rs.getString("LastName")!=null&&!conn.rs.getString("LastName").equals("null")&& !conn.rs.getString("LastName").trim().equals("")){
            AES.encrypt(conn.rs.getString("LastName").trim());
            String lname=AES.getEncryptedString();
            update+=" LastName='"+lname+"' , ";
                                                     }
             else {
              update+=" LastName='' , ";
            }
            
             
              if(conn.rs.getString("PhoneNo")!=null&&!conn.rs.getString("PhoneNo").equals("null")&& !conn.rs.getString("PhoneNo").trim().equals("")){
            AES.encrypt(conn.rs.getString("PhoneNo").trim());
            String phone=AES.getEncryptedString();
            update+=" PhoneNo='"+phone+"' , ";
                                                     }
             else {
              update+=" PhoneNo='' , ";
            }
            System.out.println("Fingerprint_" + conn.rs.getString("fingerprint")+"_");
                if (conn.rs.getString("fingerprint") != null && !conn.rs.getString("fingerprint").equals("null")&& !conn.rs.getString("fingerprint").trim().equals("")) {
                    AES.encrypt(conn.rs.getString("fingerprint").trim());
                    String fp = AES.getEncryptedString();
                    update += " fingerprint='" + fp + "'  ";
                    
                    //AES.decrypt(fp);
                   // System.out.println(" Decrepted Fingerprint__" + AES.getDecryptedString());
                } else {
                    update += " fingerprint='' ";
                }
                //null
             update+=" where  UniqueID='"+conn.rs.getString("UniqueID")+"' ";
              
                System.out.println(update); 
             conn.state2.executeUpdate(update);
            }//end of while 
            
        } catch (SQLException ex) {
            Logger.getLogger(Migrateencdata.class.getName()).log(Level.SEVERE, null, ex);
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
