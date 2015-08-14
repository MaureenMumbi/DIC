/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author Maureen
 */

public class VisitsReport extends HttpServlet {

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
    
    int counts=0;
    int counter;
     int visit1=0;
     int visit2=0;
      int servicecopy;
      int totalvisit1=0;
      int totalvisit2=0;
       int totalenrolled=0;
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
          String targets ="";
          int qtr=0;
          String quarters="";
           String dics="";
          counter=2;
           servicecopy=2;
             startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
         // period= "monthly";
          period= request.getParameter("period");
            int a=1;
            int count=0;
           // dbConnect  conn = new dbConnect();
                HSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
                HSSFWorkbook wb=new HSSFWorkbook();
//           String allpath="";   
//           String allpath = getServletContext().getRealPath("/Enrollments.xlsm");

                
//                HSSFWorkbook wb;
//
//wb = new HSSFWorkbook(OPCPackage.open(allpath));

                HSSFSheet shet1=wb.createSheet();
                HSSFRow rw1=shet1.createRow(1);
                   
                       
                       
                        
   
     int enrolled=0;
      shet1.setColumnWidth(0, 7000 ); 
      shet1.setColumnWidth(1, 7000 ); 
    shet1.setColumnWidth(2,7000); 
    shet1.setColumnWidth(3, 7000); 
    shet1.setColumnWidth(4, 7000); 
    shet1.setColumnWidth(5, 4000); 
    shet1.setColumnWidth(6, 4000); 
    shet1.setColumnWidth(7, 4000); 
    shet1.setColumnWidth(8, 4000);
    shet1.setColumnWidth(9, 4000);
    shet1.setColumnWidth(10, 4000);
    shet1.setColumnWidth(11, 4000);
    shet1.setColumnWidth(12, 4000);
     
    
    
          HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)17);
    font_header.setColor(HSSFColor.BLACK.index);
          //Style for the row showing the start date of the report
    //Cell Style known as "style_header"
          CellStyle style_header=wb.createCellStyle();
    style_header.setFont(font_header);
    style_header.setWrapText(true);
    style_header.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
 
            style_header.setBorderBottom(CellStyle.BORDER_THIN);
            style_header.setBorderLeft(CellStyle.BORDER_THIN);
            style_header.setBorderRight(CellStyle.BORDER_THIN);
            style_header.setBorderTop(CellStyle.BORDER_THIN);
            style_header.setAlignment(CellStyle.ALIGN_CENTER);
            
            //Creating yellow for the years
            CellStyle year_style_header=wb.createCellStyle();
    year_style_header.setFont(font_header);
    year_style_header.setWrapText(true);
    year_style_header.setFillForegroundColor(HSSFColor.YELLOW.index);
year_style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
 
            year_style_header.setBorderBottom(CellStyle.BORDER_THIN);
            year_style_header.setBorderLeft(CellStyle.BORDER_THIN);
            year_style_header.setBorderRight(CellStyle.BORDER_THIN);
            year_style_header.setBorderTop(CellStyle.BORDER_THIN);
            year_style_header.setAlignment(CellStyle.ALIGN_CENTER);
            
            
            //Cell Style header known as "indicator_style"
             CellStyle indicator_style = wb.createCellStyle();
            indicator_style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            indicator_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                HSSFFont fonts = wb.createFont();
                fonts.setColor(HSSFColor.BLACK.index);
                fonts.setFontHeightInPoints((short) 11);
            indicator_style.setFont(fonts);
            indicator_style.setBorderBottom(CellStyle.BORDER_THIN);
            indicator_style.setBorderLeft(CellStyle.BORDER_THIN);
            indicator_style.setBorderRight(CellStyle.BORDER_THIN);
            indicator_style.setBorderTop(CellStyle.BORDER_THIN);
            indicator_style.setAlignment(CellStyle.ALIGN_CENTER);
          
            //Style known as "cell_style"
            CellStyle cell_style = wb.createCellStyle();
          
          
                HSSFFont fonts1 = wb.createFont();
                fonts1.setColor(HSSFColor.BLACK.index);
                fonts1.setFontHeightInPoints((short) 11);
            cell_style.setFont(fonts1);
            cell_style.setBorderBottom(CellStyle.BORDER_THIN);
            cell_style.setBorderLeft(CellStyle.BORDER_THIN);
            cell_style.setBorderRight(CellStyle.BORDER_THIN);
            cell_style.setBorderTop(CellStyle.BORDER_THIN);
                  cell = rw1.createCell(0);
                     cell.setCellValue("DICNAME");
                      cell.setCellStyle(style_header);
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("ENROLLMENTS ");
                        cell2.setCellStyle(style_header);
                        cell4 = rw1.createCell(2);
                     cell4.setCellValue("INDICATOR");
                       cell4.setCellStyle(style_header);
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("1ST VISIT ");
                       cell4.setCellStyle(style_header);

                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("2nd VISIT");
                       cell4.setCellStyle(style_header);
String qidarray[] = {"E1","F1","J1","J2"};
String visitsarray[] ={"1","2"};
 String dicname="";
 String enrollments="";
    String service="";
 String serviceval="";
 String dicval="";
//String enrollment ="select count(*), dicname from enrollments group by dicname";
//conn.rs3 = conn.state3.executeQuery(enrollment);
//while(conn.rs3.next()){
//dicname= conn.rs3.getString(2);
//enrollments = conn.rs3.getString(1);
//                 
//}
   String DIC_Name_fetcher = "SELECT * FROM dicname";
  String dic_name=""; 
   conn.rs3=conn.state3.executeQuery(DIC_Name_fetcher);
        while(conn.rs3.next()){
            dic_name = conn.rs3.getString(2);
 

 String enrollment = "select count(*) , dicname from enrollment where dicname='"+dic_name+"'  AND str_to_date(DOE,'%e/%c/%Y') between "
+"str_to_date('"+startdate+"','%e/%c/%Y') and str_to_date('"+enddate+"','%e/%c/%Y') group by dicname";
 conn.rs4 = conn.state4.executeQuery(enrollment);
 while(conn.rs4.next()){
 enrolled = conn.rs4.getInt(1);
 dics=conn.rs4.getString(2);
 totalenrolled+=enrolled;
 System.out.println(enrolled +"ppp"+dics );
 }
 
    for(int i=0;i<qidarray.length;i++){
        
        
//        for(int k=0;k<visitsarray.length;k++){
    String getdata="select DISTINCT(enrollment.UniqueID) ,enrollment.DICName, riskreductiondetails.QID, "
	+"CASE riskreductiondetails.QID WHEN 'E1' THEN 'HIV TESTED' WHEN 'F1' THEN 'STI CHECKUP' WHEN 'J1' THEN 'ON FP CURRENTLY' WHEN 'J2' THEN 'FP TODAY' END as 'INDICATORNAME',"
        +"COUNT(CASE WHEN riskreductiondetails.QID='"+qidarray[i]+"' AND riskreductiondetails.currentstatus = 'Yes' THEN riskreductiondetails.currentstatus END )as OCCURENCE,"

+"CASE WHEN COUNT(CASE WHEN riskreductiondetails.QID='"+qidarray[i]+"' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus END ) >='1' THEN  1 "
            + " END AS VISITS"
+"  from enrollment inner join "
	+"riskreductionmain on   riskreductionmain.UniqueID = enrollment.UniqueID "
	+"inner join riskreductiondetails on riskreductiondetails.RiskReductionID= riskreductionmain.RiskReductionID "
+"and str_to_date(riskreductionmain.DOA,'%e/%c/%Y') between "
+"str_to_date('"+startdate+"','%e/%c/%Y') and str_to_date('"+enddate+"','%e/%c/%Y') "
 +"and riskreductiondetails.QID='"+qidarray[i]+"'  and dicname='"+dic_name+"'"
+"group by riskreductionmain.RiskReductionID order by dicname,INDICATORNAME  LIMIT 100000000000";

   
System.out.println(getdata);
conn.rs = conn.state.executeQuery(getdata);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4)+"_______"+conn.rs.getString(5)+"_______"+conn.rs.getString(6) );
count++;
 HSSFRow rwa = shet1.createRow(counter);
service = conn.rs.getString(4);
dicname = conn.rs.getString(2);

                if(conn.rs.getInt(5)==1){
                 visit1++ ; 
                 counts++;
                 
                
                 System.out.println("ccc "+visit1);
                }
                else if(conn.rs.getInt(5)==2){
                    visit2++ ; 
                  
                }
System.out.println("visits "+ visit1 +"  "+ visit2);
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(enrolled);
                 cell12.setCellStyle(cell_style);
  if(serviceval.equals("")){
              serviceval= service;
              System.out.println("88"+serviceval +"___"+service);
                
                System.out.println("88"+counter);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12.setCellStyle(cell_style);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(service);
                 cell12.setCellStyle(cell_style);
                 cell12=rwa.createCell(3);
                 cell12.setCellValue(visit1);
                 cell12.setCellStyle(cell_style);
                 cell12=rwa.createCell(4);
                 cell12.setCellValue(visit2);
                 cell12.setCellStyle(cell_style);
                  totalvisit1+=visit1;
                    totalvisit2+=visit2;
                 visit1=0;
                 visit2=0;

                counter++;
              
                
                
                
            }
          if(!serviceval.equals("") && !serviceval.equals(service)){
                 serviceval= service;
               
                System.out.println("!!!!"+counter);

               
               
           
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12.setCellStyle(cell_style);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs.getString(4));
                 cell12.setCellStyle(cell_style);
                 cell12=rwa.createCell(3);
                 cell12.setCellValue(visit1);
                 cell12.setCellStyle(cell_style);
                 cell12=rwa.createCell(4);
                 cell12.setCellValue(visit2);
                 cell12.setCellStyle(cell_style);
                  counter++;  
 totalvisit1+=visit1;
         totalvisit2+=visit2;       
               visit1=0;
               visit2=0;
               
} 
          
      if(dicval.equals("")){
       dicval= dicname;
       
            System.out.println(servicecopy+"  fff   "+counter);
             if(counter>servicecopy){
                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter,0,0));
                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter,1,1));
                 servicecopy=counter;
             }
               
    
      }   
        if(!dicval.equals("") && !dicval.equals(dicname)){
                 dicval= dicname;
                 
//                      System.out.println(servicecopy+"  fff   "+counter);
//                      if(counter>servicecopy){
//                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter,0,0));
//                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter,1,1));
                    //  servicecopy=counter;
                     // }
               
//     System.out.println(servicecopy+"  ffff   "+counter);
                     
        }

       
        
        
        // for array for visits
    } // for array for questions
//  if(counter>servicecopy){
//    shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter-1,0,0));
//                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter-1,1,1));
//                servicecopy=counter;
//         }
      
        }// for dicnames 
  if(counter>servicecopy){
    shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter-1,0,0));
                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter-1,1,1));
                servicecopy=counter;
         }
  
  

}
        
         HSSFRow rwb = shet1.createRow(counter);
                  cell12=rwb.createCell(0);
                  cell12.setCellValue("Total");
                 cell12.setCellStyle(indicator_style);
                  cell12=rwb.createCell(1);
                  cell12.setCellValue(totalenrolled);
                 cell12.setCellStyle(indicator_style);
                  cell12=rwb.createCell(2);
                  cell12.setCellValue("");
                 cell12.setCellStyle(indicator_style);
                  cell12=rwb.createCell(3);
                  cell12.setCellValue(totalvisit1);
                 cell12.setCellStyle(indicator_style);
                 cell12=rwb.createCell(4);
                 cell12.setCellValue(totalvisit2);
                 cell12.setCellStyle(indicator_style);
        
//         if(counter>servicecopy){
//    shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter,0,0));
//                 shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter,1,1));
//                servicecopy=counter;
//         }
//        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=VisitReports.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
   
 		
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
