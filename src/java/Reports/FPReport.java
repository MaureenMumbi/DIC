/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reports;

import dbConnect.dbConnect;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author user
 */
public class FPReport extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        try {
        int counter=2;
        int servicecopy=2;
         dbConnect  conn = new dbConnect();   
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
                   
                       
                       
                        
   String dicval="";
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
                fonts.setFontName("cambria");
                fonts.setFontHeightInPoints((short) 11);
            indicator_style.setFont(fonts);
            indicator_style.setBorderBottom(CellStyle.BORDER_THIN);
            indicator_style.setBorderLeft(CellStyle.BORDER_THIN);
            indicator_style.setBorderRight(CellStyle.BORDER_THIN);
            indicator_style.setBorderTop(CellStyle.BORDER_THIN);
            indicator_style.setAlignment(CellStyle.ALIGN_LEFT);
          
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
                      cell.setCellValue("QTR");
                       cell.setCellStyle(style_header);
                  cell = rw1.createCell(1);
                      cell.setCellValue("DICNAME");
                      cell.setCellStyle(style_header);
                        cell2 = rw1.createCell(2);
                       cell2.setCellValue("METHOD ");
                        cell2.setCellStyle(style_header);
                        cell4 = rw1.createCell(3);
                        cell4.setCellValue("TOTAL");
                       cell4.setCellStyle(style_header);
                        cell4 = rw1.createCell(4);
                   

  
String startdate="";
String enddate="";
if(request.getParameter("startdate") !=null && !request.getParameter("startdate").equals("") ){
            
            startdate=request.getParameter("startdate");
            }
            if(request.getParameter("enddate") !=null && !request.getParameter("enddate").equals("") ){
            
            enddate=request.getParameter("enddate");
            }

           
            
            int counts=0;
            String dicname="";
            String status="";
            int qtr=0;
            String qtrs="";
            String qtrval="";
            int qtrcopy=2;
            int diccopy=2;
            String getFPMethods="SELECT COUNT(RISKREDUCTIONMAIN.UNIQUEID),DICNAME,CURRENTSTATUS,QUARTER(STR_TO_DATE(DOA,'%e/%c/%Y')) as qtr,YEAR(STR_TO_DATE(DOA,'%e/%c/%Y')) as year \n" +
"FROM dic.riskreductiondetails, RISKREDUCTIONMAIN,ENROLLMENT \n" +
"WHERE \n" +
"qid='J3' AND CURRENTSTATUS!=''\n" +
" AND  STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y') \n" +
"BETWEEN STR_TO_DATE('"+startdate+"','%e/%c/%Y') \n" +
"AND STR_TO_DATE('"+enddate+"','%e/%c/%Y')\n" +
"AND RISKREDUCTIONMAIN.UNIQUEID =ENROLLMENT.UniqueID\n" +
"AND RISKREDUCTIONMAIN.RiskReductionID = riskreductiondetails.RiskReductionID \n" +
"GROUP BY qtr,CURRENTSTATUS order by year,qtr,DICNAME";
            System.out.println(getFPMethods);
          conn.rs=  conn.state.executeQuery(getFPMethods);
          while(conn.rs.next()){
              counter++;
              
          System.out.println(counts+" "+dicname+" "+status);
           HSSFRow rwa = shet1.createRow(counter);
                                        
              counts= conn.rs.getInt(1);
              dicname= conn.rs.getString(2);
              status= conn.rs.getString(3);
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
                  String getqtr="select quarter_name from quarters where quarter_id='"+qtr+"' ";
            conn.rs5 = conn.state5.executeQuery(getqtr);
            while(conn.rs5.next()){
            qtrs = conn.rs5.getString(1);
            
          
           if(qtrval.equals("")){                                                     
              qtrval= qtrs;
              System.out.println("88"+qtrval +"___"+qtrs);
                System.out.println("88"+qtrs);
                System.out.println("88"+counter);
                                
                cell11=rwa.createCell(0);
                cell11.setCellValue(qtrs);
                cell11.setCellStyle(indicator_style);
                shet1.addMergedRegion(new CellRangeAddress(qtrcopy,counter-1,0,0));
                qtrcopy=counter;
            
            }
          if(!qtrval.equals("") && !qtrval.equals(qtrs)){
                 qtrval= qtrs;
                System.out.println("!!!"+qtrval +"___"+qtrcopy);
                System.out.println("!!!"+qtrcopy);
                System.out.println("!!!!"+counter);
                
                   cell11=rwa.createCell(0);
                cell11.setCellValue(qtrs);
                cell11.setCellStyle(indicator_style);
//                cell31.setCellValue(months);
              shet1.addMergedRegion(new CellRangeAddress(qtrcopy,counter-1,0,0));
                qtrcopy=counter;
               
            }
            
            
           
            }
                
             shet1.addMergedRegion(new CellRangeAddress(qtrcopy,counter,0,0));
                    cell11=rwa.createCell(0);
                cell11.setCellValue(qtrs);
                cell11.setCellStyle(indicator_style);        
                
                
                  if(dicval.equals("")){                                                     
              dicval= dicname;
              System.out.println("88"+dicval +"___"+dicname);
             
                                
                cell11=rwa.createCell(1);
                cell11.setCellValue(dicval);
                cell11.setCellStyle(cell_style);
                shet1.addMergedRegion(new CellRangeAddress(diccopy,counter-1,1,1));
                diccopy=counter;
            
            }
          if(!dicval.equals("") && !dicval.equals(dicname)){
                 dicval= dicname;
                System.out.println("!!!"+dicname +"___"+diccopy);
              
                
                   cell11=rwa.createCell(1);
                cell11.setCellValue(dicval);
                cell11.setCellStyle(cell_style);
//                cell31.setCellValue(months);
              shet1.addMergedRegion(new CellRangeAddress(diccopy,counter-1,0,0));
                diccopy=counter;
               
            }
                     shet1.addMergedRegion(new CellRangeAddress(diccopy,counter,1,1));                       
                                        cell11=rwa.createCell(1);
                                         cell11.setCellValue(dicname);
                                         cell11.setCellStyle(cell_style);
                                         
                                          cell13=rwa.createCell(2);
                                         cell13.setCellValue(status);
                                         cell13.setCellStyle(cell_style);
                                         cell12=rwa.createCell(3);
                                         cell12.setCellValue(counts);
                                         cell12.setCellStyle(cell_style);
                                         
                                        
         

          
          }
//          if(counter>servicecopy){
//    shet1.addMergedRegion(new CellRangeAddress(servicecopy,counter-1,0,0));
//              
//                servicecopy=counter;
//         }
                 // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=FPMETHODS.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        } finally {
//            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            Logger.getLogger(FPReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
            Logger.getLogger(FPReport.class.getName()).log(Level.SEVERE, null, ex);
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
