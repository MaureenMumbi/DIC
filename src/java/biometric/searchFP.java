/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
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
 * @author SIXTYFOURBIT
 */
public class searchFP extends HttpServlet {

   
   public static ReaderCollection mcollection;
   private String chosenreader = "";
  
   private Reader m_reader;
   private boolean m_bStreaming;
   private String scannercalled;
   PrintWriter out ;
   boolean detailssaved;
   HttpSession session;
   String locationid; 
   String todaysdate;
   String returntable="";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                
         out = response.getWriter();
         session=request.getSession();
         detailssaved=false;
         scannercalled="";
         locationid="";
         chosenreader = "";
        returntable="";
          String FirstName="";
      String MiddleName="";
      String LastName="";
      
        
        mcollection=null;
       
        
        
        
       //  else{
//            try {
                //select maximum location id from the database
                //this happens only when the session has expired
                //otherwise, a new session will be loaded     
                    dbConnect conn= new dbConnect();
                    
//                    conn.rs=conn.state.executeQuery("select MAX(tableid) from location");
//                    if(conn.rs.next()){
//                    
//                        conn.rs1=conn.state1.executeQuery("select locationid from location where tableid='"+conn.rs.getString(1) +"'");
//                        
//                        if(conn.rs1.next()){
//                        
//                            locationid=conn.rs1.getString(1);
//                        System.out.println("Location id"+locationid);
//                        }
//                        
//                    }
                    
                    
//            } catch (SQLException ex) {
//                Logger.getLogger(searchFP.class.getName()).log(Level.SEVERE, null, ex);
//            }
             
            
        // }//end of else
         
         
         
         
        
         
        
        try {
            mcollection = UareUGlobal.GetReaderCollection();
  
            
            mcollection.GetReaders();
          
          
          
        } catch (UareUException e) {
            //error while getting readers
            System.out.println("Error while getting scanner "+e);
           // chosenreader = "Error while getting scanner "+e;
        }

       
        
        
          ArrayList readersAL = new ArrayList();

        for (int i = 0; i < mcollection.size(); i++) {
            
            
                readersAL.add(mcollection.get(i).GetDescription().name);
                chosenreader = mcollection.get(i).GetDescription().name;

               chosenreader=" <img src=\"images/present.png\"><font color=\"orange\"> SCANNER DETECTED</font><br/>";
                
            
                    //set the chosen reader
                    m_reader = mcollection.get(i);
                    
                 
                    System.out.println(" SCANNER  ::"+m_reader);
          
                    
                      if(chosenreader.equals("")){
                          
                          scannercalled="";
                          
                          chosenreader="NO SCANNER DETECTED";
               
               }
                
                 
        

            //out.println(chosenreader);

       
       
        }//end of for loop

        //call the vrification method
        
        
        
        //open the reader



        if (m_reader != null) {
                    
              if(scannercalled==""){
                          // scannercalled= Capture.Run(m_reader, true);
             
                         // out.println("CAPTURING FINGERPRINTS..<br/>");
                          
                          
                          //================  CALL THE VERIFICATION ================
                          
                          
                      scannercalled=verification.Run(m_reader);
	
                      if(scannercalled!=""){
                      
                      detailssaved=true;
                      
                      }    
                      
                      
                           }
                           else{
                           
                           System.out.println("VERIFICATION CLASS ALREADY CALLED");
                           
              }
                           
              }
			
                  
             
          

        

        else {
	returntable="Fingerprints Reader not Detected. Ensure it is inserted on a functioning USB port";
	  System.out.println("NO READER AVAILABLE");
        //closeReaders();
        }

        //closeReaders();
        
        System.out.println("is scanner called already? == "+scannercalled);
        
    
         if(detailssaved==true){
            try {
                // out.println("<img src=\"images/present.png\"/><font color=\"orange\">USER DETAILS SAVED SUCCESFULLY</font>");
               //create a table of the existing chws from the database
                         
//           returntable="<tr><td colspan=\"6\" style=\"background-color:yellow;height:60px;\"> Attendance List for  chws Present at a meeting held on "+todaysdate+"</td></tr>";          
//           returntable=returntable+"<tr><td>Number</td><td>First Name</td><td>Last Name</td><td>Id Number</td><td>Time in</td><td>Location id</td></tr>";          
//                         
        
                         
          conn.rs1=conn.state.executeQuery("select * from enrollment where UniqueID='"+scannercalled+"'");
          System.out.println("select * from enrollment where UniqueID='"+scannercalled+"'");
              
          int count=0;
        
         
              while(conn.rs1.next()){
          
                  count++;
        
                final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs1.getString("FirstName")!=null && !conn.rs1.getString("FirstName").trim().equals("") && !conn.rs1.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs1.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs1.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs1.getString("SecondName")!=null && !conn.rs1.getString("SecondName").trim().equals("") && !conn.rs1.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs1.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs1.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs1.getString("LastName")!=null && !conn.rs1.getString("LastName").trim().equals("") && !conn.rs1.getString("LastName").equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs1.getString("LastName").trim());
                     System.out.println("String To Decrypt : " + conn.rs1.getString("LastName"));
                     LastName=AES.getDecryptedString();
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
            
            } catch (SQLException ex) {
                Logger.getLogger(searchFP.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             

} 
        
         out.println(returntable);
         out.close();
         
         
        closeReaders();
        
        
        System.out.println(returntable);
        
        
        
        

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


   public void closeReaders() {
        try {

       



            UareUGlobal.DestroyReaderCollection();


        } catch (UareUException ex) {
            Logger.getLogger(searchFP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



}
