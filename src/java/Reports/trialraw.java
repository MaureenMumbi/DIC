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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


/**
 *
 * @author Maureen
 */
@WebServlet(name = "trialraw", urlPatterns = {"/trialraw"})
public class trialraw extends HttpServlet {

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
            throws ServletException, IOException, SQLException, InvalidFormatException {
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
        try {
            dbConnect conn = new dbConnect();
          
         String startdate="";
          String enddate="";
          String period="";
          String district="";
          String month="";
          
          int qtr=0;
          String quarters="";
            
             startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
         // period= "monthly";
          period= request.getParameter("period");
            int a=1;
            int count=0;
           // dbConnect  conn = new dbConnect();
                HSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
                HSSFWorkbook wb=new HSSFWorkbook();


                HSSFSheet shet1=wb.createSheet();
                HSSFRow rw1=shet1.createRow(1);
     
    String year[];
    year = startdate.split("/");
    
    if(period.equals("monthly")){
    
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
        
            cell = rw1.createCell(0);
                     cell.setCellValue("ENROLLED");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DICNAME ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("COUNTY");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("MONTH NAME");
                         
//    String enrollments="select count(UniqueID),DICName,District,MONTH(STR_TO_DATE(DOE,'%e/%c/%Y'))from enrollment  where "
//                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
//                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ";
//             
 String enrollments="select count(UniqueID),DICName,"
            + " case when DICName='Naivasha' then district='Naivasha'"
          + " else district end as County"
            + ""
            + ",month(STR_TO_DATE(DOE,'%e/%c/%Y'))from enrollment  where "
                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) group by DICName,District,month(STR_TO_DATE(DOE,'%e/%c/%Y')) ";
        
conn.rs = conn.state.executeQuery(enrollments);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;
//a++;

 String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              if(conn.rs4.next()){
                district=conn.rs4.getString(1);
              }
              else{
              district="Naivasha";
              }
              
               String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs.getInt(4) +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            month = conn.rs5.getString(1);}


//if(!conn.rs.getString(3).equals("others")){
    
    
  HSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getInt(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(district);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(month);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(conn.rs.getString(5));

                  //cell12.setCellStyle(cell_style);

}

//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=Enrollments.csv");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
        
    }
    
    else if(period.equals("quarterly")){
   cell = rw1.createCell(0);
                     cell.setCellValue("SERVED");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DICNAME ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("COUNTY");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("MONTH");
                        
    String enrollments="select count(riskreductionmain.UniqueID),DICName,"
            + " case when DICName='Naivasha' then district='Naivasha'"
          + " else district end as County"
            + ""
            + ",MONTH(STR_TO_DATE(DOA,'%e/%c/%Y'))from enrollment,riskreductionmain  where "
                + " (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) and enrollment.uniqueid=riskreductionmain.uniqueid group by DICName,District,MONTH(STR_TO_DATE(DOA,'%e/%c/%Y')) ";
        
        System.out.println(enrollments);
         conn.rs = conn.state.executeQuery(enrollments);
         while(conn.rs.next()){
           
         System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
              String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              if(conn.rs4.next()== true){
                district=conn.rs4.getString(1);
              }
             else if (conn.rs.getString(3).equals("0")){
                  district="Naivasha";
              }
              
                
                
                if(conn.rs.getString(4).equals("1")){
                  qtr=2;
                }
                else if(conn.rs.getString(4).equals("2")){
                  qtr=3;
                }
                else if(conn.rs.getString(4).equals("3")){
                  qtr=4;
                }
                else if(conn.rs.getString(4).equals("4")){
                  qtr=1;
                }
           String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs.getInt(4) +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            month = conn.rs5.getString(1);
            }


//if(!conn.rs.getString(3).equals("others")){
    
    
  HSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getInt(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(district);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(month);
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(conn.rs.getString(5));

                  //cell12.setCellStyle(cell_style);

}

//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=MonthlyServed.csv");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
    }
    
    
        
        
        } finally {            
//            out.close();
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
                    try {
                        processRequest(request, response);
                    } catch (InvalidFormatException ex) {
                        Logger.getLogger(KPMSReport.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(KPMSReport.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        processRequest(request, response);
                    } catch (InvalidFormatException ex) {
                        Logger.getLogger(KPMSReport.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(KPMSReport.class.getName()).log(Level.SEVERE, null, ex);
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
