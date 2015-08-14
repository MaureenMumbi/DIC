/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

import com.digitalpersona.uareu.Fid;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Selection extends HttpServlet {

    
    
    
    private ReaderCollection mcollection;
    private String chosenreader = "";
    public Reader.CaptureResult capture_result;
    public Reader.Status reader_status;
    private boolean m_bCancel;
    private Reader m_reader;
    private boolean m_bStream;
    private Fid.Format m_format;
    private Reader.ImageProcessing m_proc;
   
    private boolean m_bStreaming;
    PrintWriter out ;
    boolean detailssaved;
    
    String uniqueid="";
    String hand="";
    String finger="";
    String Responsetext="";
    private String scannercalled;
    int incrementor=0;
    
    String Fingerprintstring="";
   public HttpSession sessions; 
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        sessions=request.getSession();
        
        
        uniqueid=request.getParameter("uniqueid");
        hand=request.getParameter("hand");
        finger=request.getParameter("capturedfinger");
        Fingerprintstring="";
        
        
        
     
        
        mcollection=null;
        m_reader=null;
        
        detailssaved=false;   
        scannercalled="";
      //  incrementor=0; 
         
         out = response.getWriter();
          
         if(incrementor==0){
                
              //used top avoid calling two instances of the same class ...
                
                
         // incrementor++;
          
       //   System.out.println("Incrementor value:::"+incrementor);
          
          try {
          
             
          
             
            
                
          
           mcollection = UareUGlobal.GetReaderCollection();

            
            
      
            
            
          mcollection.GetReaders();
          
          
          
        } catch (UareUException e) {
            //error while getting readers
            System.out.println("Error while getting scanner "+e);
           // chosenreader = "Error while getting scanner "+e;
        }
        
         
          
         //  System.out.println("MCOLLECTION SIZE:::"+ mcollection.size());
          
         
           for (int i = 0; i < mcollection.size(); i++) {
            
            
               
                chosenreader = mcollection.get(i).GetDescription().name;

              // chosenreader=" <img src=\"images/present.png\"><font color=\"orange\"> SCANNER DETECTED</font><br/>";
                
            
                    //set the chosen reader
                    m_reader = mcollection.get(i);
                    
                   
                 
                    System.out.println(" SCANNER  ::"+m_reader);
          
                      if(chosenreader.equals("")){
                          
                      scannercalled="";
                          
                      chosenreader="NO SCANNER DETECTED";
               
                                                  }
             
            //out.println(chosenreader);
            

        }//end of for loop

         //close the readers at this point
          
           
              if (m_reader != null) {
                    
//              if(scannercalled==false){
scannercalled= Capture1.Run(m_reader, false,uniqueid,hand,finger);
             
         System.out.println("___________!!!!!!"+scannercalled);               
   
sessions.setAttribute("kidole",scannercalled);
sessions.setAttribute("uniqueid",uniqueid);
sessions.setAttribute("hand",hand);
sessions.setAttribute("finger",finger);
	//detailssaved=saveEditedFingerprint.Run(m_reader, chwid);
                                   //scannercalled=true;
                                   
                                   //if a return came back to the code
                                   if(detailssaved==true){
                                   
                                   incrementor=0;
                                   
                                                       }
                                   
                                   
                                   if(scannercalled!=""){
                                   
                                  // incrementor=0;
                                        Responsetext=" Client "+uniqueid+" has been captured successfully";
        
                                   
                                                       }
                                   
                                   
//                           }
//                           else{
//                           
//                           System.out.println("ENROLLMENT CLASS ALREADY CALLED");
//                           
//              }
                           
              }
              
              
              else{
              
                Responsetext="Fingerprint Reader device not Detected. Ensure it is inserted on a functioning USB port";
        
              
              }
              
		
    }//end of if which checks whether a class has been called..
              
              
              
          else {
	//MessageBox.Warning("Fingerprint Reader device not Detected. Ensure it is inserted on a functioning USB port");
	  System.out.println("NO READER AVAILABLE");
          
          Responsetext="Fingerprint Reader device not Detected. Ensure it is inserted on a functioning USB port";
        
          
          incrementor=0; 
        //closeReaders();
        }

        //closeReaders();
        
      //  System.out.println("is scanner called already? == "+scannercalled);
        
    
         if(detailssaved==true){

             
             Responsetext="<img src=\"images/present.png\"/><font color=\"orange\"> "+uniqueid+"s fingerprint edited succesfully</font>";
             
     //out.println("<img src=\"images/present.png\"/><font color=\"orange\">USER DETAILS SAVED SUCCESFULLY</font>");
            

} 
         
         else{
         
            // System.out.println("eXITEd   with an error");
         
         }  
           
        try {
            
            
        } finally {   
            
            out.println(Responsetext);
            
            out.close();
            closeReaders();
            
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


  public void closeReaders() {
        try {

       



            UareUGlobal.DestroyReaderCollection();


        } catch (UareUException ex) {
            Logger.getLogger(Selection.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println("ERROR WHILE CLOSING ___________"+ex);
            
        }

    }
 
    
    


}
