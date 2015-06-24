/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Maureen
 */
public class WaterBasedLubs extends HttpServlet {

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
   String year = "", rtype = "";
    String districts="";
    String reporttype="";
    String reportyear="";
    String period="";
    String []months1=null;
    String quarters2="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        
if(request.getParameter("district") !=null && !request.getParameter("district").equals("") ){
 districts=request.getParameter("district");
 }
if(request.getParameter("parameter")!= null && !request.getParameter("parameter").equals("")){
reporttype = request.getParameter("parameter");
}
if(request.getParameter("year")!= null && !request.getParameter("year").equals("")){
reportyear = request.getParameter("year");
}
if(request.getParameter("period")!= null && !request.getParameter("period").equals("")){
period = request.getParameter("period");
}
if(request.getParameterValues("months")!= null && !request.getParameterValues("months").equals("")){
months1=request.getParameterValues("months");
}

if(request.getParameter("Quarter")!= null && !request.getParameter("Quarter").equals("")){
  quarters2=request.getParameter("Quarter");
}
     

System.out.println("");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
           System.out.println("^^^"+districts+"__"+reporttype+"__year"+reportyear+"____"+period+"__"+quarters2);
             out.println("["); 
            try {
                
                
                JSONObject jsonobj = new JSONObject();
                JSONObject jsonobj1 = new JSONObject();
                JSONObject finaljsonobj = new JSONObject();
                JSONObject finaljsonobj1 = new JSONObject();
                
                
                JSONArray qtrsarray = new JSONArray();
                JSONArray dicsarray = new JSONArray();
                JSONArray ansas = new JSONArray();
                JSONArray Action = new JSONArray();
                JSONArray jsonobjArray = new JSONArray();
                
                
                
                
                ArrayList yearsAL = new ArrayList();
                ArrayList partnersidAL = new ArrayList();
                ArrayList partnersnameAL = new ArrayList();
                int globalcounter = 0;
                dbConnect conn = new dbConnect();
           ArrayList dicsList = new ArrayList();   
           ArrayList dics = new ArrayList();   

           String dists[];
                    dists = districts.split(",");
           String quater[];
                    quater = quarters2.split(",");
             String ansasforqtr="";
 for(int y=0;y<dists.length;y++){
     
     System.out.println(dists[y]);
                                 String dicname="select * from dicname where DistrictID='"+dists[y]+"'";
                                conn.rs = conn.state.executeQuery(dicname);
                                System.out.println(dicname);
                                while(conn.rs.next()){  
                                  dicsList.add(conn.rs.getString("DICName"));  
                                  System.out.println(conn.rs.getString("DICName"));
                                 
                                }
                                }
String qtr="";
 for(int z=0; z<quater.length;z++){
     System.out.println(quater[z]);
 if(quater[z].equals("Q1")){
                  qtr="1";  
                }
                if(quater[z].equals("Q2")){
                  qtr="2";  
                }
                if(quater[z].equals("Q3")){
                  qtr="3";  
                }
                if(quater[z].equals("Q4")){
                  qtr="4";  
                }
 }String qtrdata="";
                      
                      
                       
                       for(int y=0;y<dists.length;y++){
                     String dicnames="select * from dicname where DistrictID='"+dists[y]+"'";
conn.rs6 = conn.state6.executeQuery(dicnames);
while(conn.rs6.next()){  
  dics.add(conn.rs6.getString("DICName"));  
   System.out.println(dics.get(0));
   
   
}} 
                       for(int k=0;k<dics.size();k++){
                        dicsarray.put(dics.get(k).toString());
                                     finaljsonobj.put("name", "dics");
                          finaljsonobj.put("data", dicsarray);
                       }
                       int count=0;
                       String id1="";
                       int ansas1=0;
                       String QID1="";
                      String Action1="";
                      String DIC1="";
      if(period.equalsIgnoreCase("quarterly")){ 
          
          
            for(int z=0; z<quater.length;z++){
          for(int u=0;u<dics.size();u++){
              
               
              String query1="";
  
              String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%' AND Enrollment.DICName ='"+dics.get(u).toString()+"' AND RiskReductionMain.qtr='"+quater[z]+"'AND RiskReductionMain.year='"+reportyear+"'  group by Enrollment.DICName"
          ; 
   count++;
        System.out.println("%%%%%"+query2);
        System.out.println("%%%%%%"+dics.get(u));

//EXTRACT(YEAR_MONTH FROM '2009-07-02 01:02:03')

 conn.rs= conn.state.executeQuery(query2);
         if(conn.rs.next()){
 System.out.println("!!!!"+dics.get(u)+"______________________"+conn.rs.getString(2));
 System.out.println("______________________"+conn.rs.getString(4));
 System.out.println("______________________"+conn.rs.getString(6));

              id1 = conn.rs.getString(1);
            ansas1 = conn.rs.getInt(2);
            QID1 = conn.rs.getString(3);
            Action1 = conn.rs.getString(4);
            DIC1 = conn.rs.getString(5);
         
      
        
         }
         else{
          id1 = "";
            ansas1 = 0;
            QID1 = "";
            Action1 = "";
            DIC1 = "";
         }     
     
    
      
       if (count > 0) {
                        globalcounter++;
                        
                        
                        System.out.println("globalcount "+globalcounter);
                        //add the name of that partner into a jasson array
System.out.println("***"+ansas1);
                    
                       ansas.put(ansas1);
                     
                         ansasforqtr+=ansas1;
                      if(u<dics.size()-1){
 ansasforqtr+=",";
}
                        
                         } //end of count check
                   } // end of loop ya dic
          System.out.println("***"+ansas1);
        
         
           System.out.println("***"+ansasforqtr);
                         finaljsonobj1.put("name", quater[z]);
                         finaljsonobj1.put("data",ansas);
                         out.print(finaljsonobj1);
                         out.print(",");
                     ansasforqtr=""; 
                     
                    // ansas1=;
                     ansas = new JSONArray(new ArrayList<String>());
            }// end of if ya qtrs
                    
                  
                 System.out.println("***"+ansas1);
                }//end of inner for loop

               
                        
           out.print(finaljsonobj);
                         out.println("]");
        
      
      

                    
                  
                    
                  

                
                
                
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
            Logger.getLogger(ServiceProvidedChart.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServiceProvidedChart.class.getName()).log(Level.SEVERE, null, ex);
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
 