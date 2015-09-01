/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import dbConnect.dbConnect;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Maureen
 */
public class ComprehensiveReport extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
         String County,DICName,QID,CurrentStatus,Action;
             County=DICName=QID=CurrentStatus=Action="";
           String B1ANS="";
             B1ANS="";
             String DANS="";
             DANS="";
             int Actions=0;
             String questions="";
             String [] cd;
           String [] wbl;
           String wblprovided="";
           int nowbl=0;
           XSSFWorkbook wb;
wb = new XSSFWorkbook();

XSSFSheet shet1=wb.createSheet();
XSSFRow rw1=shet1.createRow(1);                   
  int i=1;
     
     shet1.setColumnWidth(1, 15000 ); 
    shet1.setColumnWidth(2,4000); 
    shet1.setColumnWidth(3, 4000); 
    shet1.setColumnWidth(4, 4000); 
    shet1.setColumnWidth(5, 4000); 
    shet1.setColumnWidth(6, 4000); 
    shet1.setColumnWidth(7, 4000); 
    shet1.setColumnWidth(8, 4000);
    shet1.setColumnWidth(9, 4000);
    shet1.setColumnWidth(10, 4000);
    shet1.setColumnWidth(11, 4000);
    shet1.setColumnWidth(12, 4000);
        String cdsprovided="";
        int cdno=0;
         XSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
          
                         
        try {
                    cell = rw1.createCell(0);
                     cell.setCellValue("County");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DICNAME ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("Questions");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("CurrentStatus");
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("Count cs");
                        cell4 = rw1.createCell(5);
                     cell4.setCellValue("Action");
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("Action count");
            dbConnect conn = new dbConnect();
            String[]  questionsRed = new String[]{"B1","B1.1","B2","B3","B2.2","D1","D2","E1","E2","F1","G1","H1","I","J1","J2","J3","J4","K"};
String[]  qstnsReduction = new String[]
               {"B. a) 100% condom use with paying partners",
                "B. a.1) No of Condoms Provided Today",
                "B. b) 100% condom use with non  paying partners",
                "B. c) Water Based Lubricants",
                "B. c) No of Water Based Lubricants",
                "D. a) Knowledge on HIV,STIs,FP and TB",
                "D. b) Health Education Provided",
                "E. HIV Testing a) Provided HIV Testing",
                "E. b)Tested with partner",
                "F. Sexually Transmitted Infections a)Provided an STI Checkup today",
                "G. Cervical Cancer Screening a) Screened Today?",
                "H. Tuberculosis(TB) Screening",
                "I. Gender Based Violence Referal Provided",
                "J. Family Planning Method a) Currently on Method",
                "J. b) Provided Method Today",
                "J. c) If yes, what method?",
                "J. d) If not on method and not provided,why?",
                "K. Linked to IGA Group"};
          
            /* TODO output your page here. You may use following sample code. */
             Actions=0;
        for(int j=0;j<questionsRed.length;j++ ){
     String getdata="  SELECT County1,DICName1,QID,CurrentStatus,Action,count(CurrentStatus),count(Action) FROM dic.riskreductionmain,dic.riskreductiondetails where "
             + "riskreductionmain.RiskReductionid=riskreductiondetails.RiskReductionid AND QID='"+questionsRed[j]+"' AND (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('01/01/2015','%e/%c/%Y'))"
                + " AND (STR_TO_DATE('31/04/2015','%e/%c/%Y')) GROUP BY  County1,DICName1,QID,CurrentStatus,Action,riskreductiondetails.RiskReductionid,QID";
     conn.rs= conn.state.executeQuery(getdata);
    int count1=0; int count2=0;int count3=0;
     while(conn.rs.next()){
      
         i++;
      
             County=conn.rs.getString(1);
             DICName=conn.rs.getString(2);
             QID=conn.rs.getString(3);
             if(conn.rs.getString(4)!=null && !conn.rs.getString(4).equals("")){
             CurrentStatus=conn.rs.getString(4);
             }
                if(conn.rs.getString(5)!=null && !conn.rs.getString(5).equals("")){
             Action=conn.rs.getString(5);}
             
             
             if(CurrentStatus.equals("1") &&( QID.equals("B1")||QID.equals("B2") ||QID.equals("B3") ) ){
    CurrentStatus="Always";
   }
    else if(CurrentStatus.equals("2") && (QID.equals("B1")||QID.equals("B2")||QID.equals("B3") ) ){
       CurrentStatus="Sometimes";
    }
    else if(CurrentStatus.equals("3") && (QID.equals("B1")||QID.equals("B2") ||QID.equals("B3")) ){
      CurrentStatus="Never";  
    } 
             
          if(CurrentStatus.equals("1") && QID.equals("D1") ){
      CurrentStatus="Low"; }
    else if(CurrentStatus.equals("2") && QID.equals("D1")){
      CurrentStatus="Average";}
    else if(CurrentStatus.equals("3") &&  QID.equals("D1")){
      CurrentStatus="Good";  }
                
            
              
               if(Action.contains("CONDOMS WERE PROVIDED") ){
                   
               cd=Action.split("_");
               if(cd[1].equals("null")){
                   cdsprovided="Yes";
                      Action="0";
                  }
               else{
                   cdsprovided="Yes";
               Action=cd[1];
               }
               System.out.println("ccc"+Actions);
               
                 XSSFRow rwa=shet1.createRow(i);  
                cell12=rwa.createCell(0);
                 cell12.setCellValue(County);
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(DICName);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(qstnsReduction[j]);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue("XXXXX "+CurrentStatus);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue("XXXXX  "+cdsprovided);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(Action);
                }else if (Action.contains("CONDOMS NOT PROVIDED")){
               
                 cdsprovided="No";
                        Action="0";
                
                XSSFRow rwa=shet1.createRow(i);  
                cell12=rwa.createCell(0);
                 cell12.setCellValue(County);
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(DICName);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(qstnsReduction[j]);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue("XXXXX "+CurrentStatus);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue("XXXXX  "+cdsprovided);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(Action);
               
               }
               
                if(Action.contains("WBL PROVIDED")){  
                  wbl=Action.split("_");
                  if(wbl[1].equals("null")){
                        wblprovided="Yes";
                        Action="0";
                  }
                  else{
                        wblprovided="Yes";
                        Action=wbl[1];
                  }
                  XSSFRow rwa=shet1.createRow(i);  
                cell12=rwa.createCell(0);
                 cell12.setCellValue(County);
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(DICName);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(qstnsReduction[j]);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue("XXXXX "+CurrentStatus);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue("XXXXX "+wblprovided);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(Action);
                  
                  
                  } else if(Action.contains("WBL NOT PROVIDED")){  
                
                
                  wblprovided="No";
                        Action="0";
                
                 XSSFRow rwa=shet1.createRow(i);  
                cell12=rwa.createCell(0);
                 cell12.setCellValue(County);
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(DICName);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(qstnsReduction[j]);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue("XXXXX "+CurrentStatus);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue("XXXXX "+wblprovided);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(Action);
                
                }
               
                
                
                 XSSFRow rwa=shet1.createRow(i);  
                cell12=rwa.createCell(0);
                 cell12.setCellValue(County);
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(DICName);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(qstnsReduction[j]);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(CurrentStatus);
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(Action);
                
               
               
//               else if(Action.contains("Condoms not provided")  && QID.equals("B1") && CurrentStatus.equals("2")){{
//               
//                ncdsprovided="No";
//               cdno=0;
//               
//               
//               }
//                 XSSFRow rwa=shet1.createRow(2);  
//                cell12=rwa.createCell(0);
//                 cell12.setCellValue(County);
//                 cell12=rwa.createCell(1);
//                 cell12.setCellValue(DICName);
//                 cell12=rwa.createCell(2);
//                 cell12.setCellValue("Condoms Provided Today");
//                 cell13=rwa.createCell(3);
//                 cell13.setCellValue(cdsprovided);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(cdno);
//                 
//                  
                 
////                  else{
////                   wblprovided="No";
////                        nowbl=0;
////                  }
//                  
//                  
//                   rwa=shet1.createRow(3);  
//                cell12=rwa.createCell(0);
//                 cell12.setCellValue(County);
//                 cell12=rwa.createCell(1);
//                 cell12.setCellValue(DICName);
//                 cell12=rwa.createCell(2);
//                 cell12.setCellValue("WBL Provided Today");
//                 cell13=rwa.createCell(3);
//                 cell13.setCellValue(wblprovided);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(nowbl);
//                 
//    if(CurrentStatus.equals("1") &&( QID.equals("B1")||QID.equals("B2") ||QID.equals("B3") ) ){
//    CurrentStatus="Always";
//   }
//    else if(CurrentStatus.equals("2") && (QID.equals("B1")||QID.equals("B2")||QID.equals("B3") ) ){
//       CurrentStatus="Sometimes";
//    }
//    else if(CurrentStatus.equals("3") && (QID.equals("B1")||QID.equals("B2") ||QID.equals("B3")) ){
//      CurrentStatus="Never";  
//    } 
//    if(QID.equals("B1")){
//    
//                    rwa=shet1.createRow(1);  
//                     cell12=rwa.createCell(0);
//                 cell12.setCellValue(County);
//                 cell12=rwa.createCell(1);
//                 cell12.setCellValue(DICName);
//                 cell12=rwa.createCell(2);
//                 cell12.setCellValue("a)100% Condom use with paying partners");
//                 cell13=rwa.createCell(3);
//                 cell13.setCellValue(CurrentStatus);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(conn.rs.getString(6));
//    }
//    if(QID.equals("B2")){
//                   rwa=shet1.createRow(1);  
//                     cell12=rwa.createCell(0);
//                 cell12.setCellValue(County);
//                 cell12=rwa.createCell(1);
//                 cell12.setCellValue(DICName);
//                 cell12=rwa.createCell(2);
//                 cell12.setCellValue("b)100% Condom use with non paying partners");
//                 cell13=rwa.createCell(3);
//                 cell13.setCellValue(CurrentStatus);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(conn.rs.getString(6));
//    }
//    if(QID.equals("B3")){
//                   rwa=shet1.createRow(4);  
//                     cell12=rwa.createCell(0);
//                 cell12.setCellValue(County);
//                 cell12=rwa.createCell(1);
//                 cell12.setCellValue(DICName);
//                 cell12=rwa.createCell(2);
//                 cell12.setCellValue("WaterBased Lubricants");
//                 cell13=rwa.createCell(3);
//                 cell13.setCellValue(CurrentStatus);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(conn.rs.getString(6));
//    }
//                  
//    if(CurrentStatus.equals("1") && QID.equals("D1") ){
//      CurrentStatus="Low"; }
//    else if(CurrentStatus.equals("2") && QID.equals("D1")){
//      CurrentStatus="Average";}
//    else if(CurrentStatus.equals("3") &&  QID.equals("D1")){
//      CurrentStatus="Good";  }
//    
//    System.out.println(questions+"_______"+CurrentStatus +"_________"+conn.rs.getString(6)+"_________"+conn.rs.getString(7));
//    
//     
//                
//     
     }
        }
        } finally {            
//            out.close();
//               out.println(QID+"___________"+B1ANS +"_______"+CurrentStatus);
        }
   
    
    
    
      ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=ComprehensiveReport.xlsx");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
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
            Logger.getLogger(ComprehensiveReport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ComprehensiveReport.class.getName()).log(Level.SEVERE, null, ex);
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
