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
public class DQAextra extends HttpServlet {

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
    int a=1;
    int b=1;
     int c=1;
            int count=0;
            int counter=0;
            int counter1=0;
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
        try {
            dbConnect conn = new dbConnect();
          
         String startdate="";
          String enddate="";
         String uniqueid="";
    String fullname="";
    String doe="";
    String dicname="";
    String county="";
    String entrydate="";
    String syncdate="";
    String month="";
    
             startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
         
           counter=1;
           counter1=1;
           a=1;
           b=1;
           c=1;
           // dbConnect  conn = new dbConnect();
                XSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
                XSSFWorkbook wb=new XSSFWorkbook();
//           String allpath="";   
//           String allpath = getServletContext().getRealPath("/Enrollments.xlsm");

                
//                XSSFWorkbook wb;
//
//wb = new XSSFWorkbook(OPCPackage.open(allpath));

                XSSFSheet shet1=wb.createSheet("ENROLLMENTS ");
                XSSFRow rw1=shet1.createRow(1);
                XSSFSheet shet2=wb.createSheet("RISK REDUCTIONS ");
                XSSFRow rw2=shet2.createRow(1);
                   
                XSSFSheet shet3=wb.createSheet("RISK ASSESSMENT ");
                XSSFRow rw3=shet3.createRow(1);
                   
                      
                       
                        
   
     
      shet1.setColumnWidth(1, 4000 ); 
    shet1.setColumnWidth(2,4000); 
    shet1.setColumnWidth(3, 4000); 
    shet1.setColumnWidth(4, 4000); 
    shet1.setColumnWidth(5, 4000); 
    shet1.setColumnWidth(6, 4000); 
    shet1.setColumnWidth(7, 4000); 
    shet1.setColumnWidth(8, 4000);
    shet1.setColumnWidth(9, 4000);
    shet1.setColumnWidth(10, 4000);
     
    shet2.setColumnWidth(1, 4000 ); 
    shet2.setColumnWidth(2,4000); 
    shet2.setColumnWidth(3, 4000); 
    shet2.setColumnWidth(4, 4000); 
    shet2.setColumnWidth(5, 4000); 
    shet2.setColumnWidth(6, 4000); 
    shet2.setColumnWidth(7, 4000); 
    shet2.setColumnWidth(8, 4000);
    shet2.setColumnWidth(9, 4000);
    shet2.setColumnWidth(10, 4000);
    shet3.setColumnWidth(1, 4000 ); 
    shet3.setColumnWidth(2,4000); 
    shet3.setColumnWidth(3, 4000); 
    shet3.setColumnWidth(4, 4000); 
    shet3.setColumnWidth(5, 4000); 
    shet3.setColumnWidth(6, 4000); 
    shet3.setColumnWidth(7, 4000); 
    shet3.setColumnWidth(8, 4000);
    shet3.setColumnWidth(9, 4000);
    shet3.setColumnWidth(10, 4000);
  
    /* TODO output your page here. You may use following sample code. */
         
     
                        
    
    String getData=" select * from enrollment where  entrydate BETWEEN '"+startdate+"' and '"+enddate+"'";
         conn.rs = conn.state.executeQuery(getData);
         System.out.println(getData);
         while(conn.rs.next()){
             cell = rw1.createCell(0);
                     cell.setCellValue("UniqueID");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("Full Name ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("DOE");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("County");
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("DICName ");
                        cell4 = rw1.createCell(5);
                     cell4.setCellValue("Entry Date ");
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("Sync Date ");
             count++;

   
     System.out.println(conn.rs.getString("UniqueID"));
  XSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+" for a "+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString("UniqueID"));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString("FirstName") +" "+ conn.rs.getString("SecondName") +" "+ conn.rs.getString("LastName"));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs.getString("DOE"));
                 cell13=rwa.createCell(3);
                 String getcounty="select * from districts where DistrictID='"+conn.rs.getString("district")+"'";
                 conn.rs3 = conn.state3.executeQuery(getcounty);
                 while(conn.rs3.next())
                 { 
                     cell13.setCellValue(conn.rs3.getString("District"));
                 }
                 cell13=rwa.createCell(4);
                 cell13.setCellValue(conn.rs.getString("dicname"));
                 cell13=rwa.createCell(5);
                 cell13.setCellValue(conn.rs.getString("entrydate"));
                 cell14=rwa.createCell(6);
                 cell14.setCellValue(conn.rs.getString("timestamp"));
                
             
             
         }
         
         
         
         String getRiskAssess ="select * from riskassessmentmain where entrydate BETWEEN '"+startdate+"' and '"+enddate+"'";
         conn.rs2 = conn.state2.executeQuery(getRiskAssess);
         while(conn.rs2.next()){
        
                     cell = rw2.createCell(0);
                       cell.setCellValue("UNIQUE ID");
                       cell2 = rw2.createCell(1);
                     cell2.setCellValue("NAME ");
                        cell2 = rw2.createCell(2);
                     cell2.setCellValue("RISK ASSESSMENTID ");
                        cell3 = rw2.createCell(3);
                     cell3.setCellValue("ASSESSMENT DATE");
                        cell4 = rw2.createCell(4);
                     cell4.setCellValue("ENTRY DATE");
                        cell4 = rw2.createCell(5);
                     cell4.setCellValue("SYNC DATE ");
             
             count++;

   
     System.out.println(conn.rs2.getString("UniqueID"));
     
  XSSFRow rwa = shet2.createRow(b+=1);
  System.out.println("^^^"+b+" for b "+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs2.getString("UniqueID"));
                 String getnames="select * from enrollment where UniqueID ='"+conn.rs2.getString("UniqueID")+"'";
      conn.rs = conn.state.executeQuery(getnames);
      while(conn.rs.next()){
                cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString("FirstName") +" "+ conn.rs.getString("SecondName") +" "+ conn.rs.getString("LastName"));
      }
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs2.getString("AssessmentID"));
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(conn.rs2.getString("AssessmentDate"));
                 cell13=rwa.createCell(4);
                 cell13.setCellValue(conn.rs2.getString("entrydate"));
                 cell13=rwa.createCell(5);
                 cell13.setCellValue(conn.rs2.getString("timestamp"));
                
                
         
         }
         
         String getRiskRed ="select * from riskreductionmain where entrydate BETWEEN '"+startdate+"' and '"+enddate+"'";
         conn.rs2 = conn.state2.executeQuery(getRiskRed);
         while(conn.rs2.next()){
        
                     cell = rw3.createCell(0);
                       cell.setCellValue("UNIQUE ID");
                       cell2 = rw3.createCell(1);
                     cell2.setCellValue("NAME ");
                        cell2 = rw3.createCell(2);
                     cell2.setCellValue("RISK REDUCTION ID ");
                        cell3 = rw3.createCell(3);
                     cell3.setCellValue("ASSESSMENT DATE");
                        cell4 = rw3.createCell(4);
                     cell3.setCellValue("CADRE");
                        cell4 = rw3.createCell(5);
                     cell4.setCellValue("ENTRY DATE");
                        cell4 = rw3.createCell(6);
                     cell4.setCellValue("SYNC DATE ");
             
             count++;

   
     System.out.println(conn.rs2.getString("UniqueID"));
     
  XSSFRow rwa = shet3.createRow(c+=1);
  System.out.println("^^^"+c+" for c "+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs2.getString("UniqueID"));
                 String getnames="select * from enrollment where UniqueID ='"+conn.rs2.getString("UniqueID")+"'";
      conn.rs = conn.state.executeQuery(getnames);
      while(conn.rs.next()){
                cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString("FirstName") +" "+ conn.rs.getString("SecondName") +" "+ conn.rs.getString("LastName"));
      }
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs2.getString("RiskReductionID"));
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(conn.rs2.getString("DOA"));
                
                 
                 String getcadre="select * from cadrecode where cadrecodeid='"+conn.rs2.getString("CadreProvider")+"'";
                  conn.rs4= conn.state.executeQuery(getcadre);
                   while(conn.rs4.next()){
                        cell13=rwa.createCell(4);
                 cell13.setCellValue(conn.rs4.getString("CadreCode"));
                   }
                 cell13=rwa.createCell(5);
                 cell13.setCellValue(conn.rs2.getString("entrydate"));
                 cell13=rwa.createCell(6);
                 cell13.setCellValue(conn.rs2.getString("timestamp"));
                
                
         
         }
         
         ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DateEnteredDQA.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        } finally {            
           
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
            Logger.getLogger(DQAextra.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DQAextra.class.getName()).log(Level.SEVERE, null, ex);
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
