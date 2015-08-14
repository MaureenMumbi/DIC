/*
 * To change this template, choose Tools | Templates
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
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
 * @author Maureen
 */
public class ServicesProvided extends HttpServlet {

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
     int CDCount=0;
        int WBLCount=0;
        String questionQuery="";
        String qstns="";
        String ansas="";
        String id="";
        String QID="";
        String Action="";
        int ansas1=0;
        String id1="";
        String QID1="";
        String Action1="";
        int ansas2=0;
        int ansas3=0;
        String id2="";
        String QID2="";
        String Action2="";
        String id3="";
        String QID3="";
         String Action3="";
        String DOA3="";
        String DIC3="";
        String id4="";
        String QID4="";
         String Action4="";
        String DOA4="";
        String DIC4="";
        String[]  CDs;
        String[]  WBL;
        int StatusAction=0;
        int count=0;
        int countD2=0;
        int countE1=0;
        int countE2=0;
        int countF1=0;
        int countG1=0;
        int countH1=0;
        int countI=0;
        int countJ1=0;
        int countJ2=0;
        int countJ3=0;
        int countK=0;
        int FPcount=0;
        int FPcount1=0;
        int FPcount2=0;
        int FPcount3=0;
        int FPcount4=0;
        int FPcount5=0;
        int FPcount6=0;
        int FPcount7=0;
       int rowcount=0;
      int totalCounts=0;
      int counts=0;
      int condomcount=0;
      int wblcount=0;
        int b=1;
          int c=1;
        String que,que1,que2,que3,que4,que5,que6,que7,que8,que9,que10="";
         int total=0;
         String reporttype="";
String reportyear="";
String question="";
String questionRed="";
String quarter="";
String semiannual="";
String dates1 ="";
String dates2 ="";
int ansas4=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        dbConnect conn = new dbConnect();
       condomcount=0;
      wblcount=0;
      ansas1=0;
      ansas2=0;
      ansas4=0;
      b=1;
      c=1;
String DICName="";
String parameter="";
String DOA="";
String DIC="";
String DOA1="";
String DIC1="";
String DOA2="";
String DIC2="";
String DOA4="";
String DIC4="";
String qstnsID="";
int years=0;
      //  PrintWriter out = response.getWriter();
        try {
           
            //System.out.println("current day is: "+current_date);
          
            HttpSession session;
            session = request.getSession();
            String county = "";
            String indicator = "";
            String[] district_ids;
             String district_name = "";
             
          

//            *******************RECEIVE PARAMETERS*******************************
 if(request.getParameter("DICName")!= null && !request.getParameter("DICName").equals("")){
DICName = request.getParameter("DICName");
}

if(request.getParameter("parameter")!= null && !request.getParameter("parameter").equals("")){
reporttype = request.getParameter("parameter");
}
if(request.getParameter("year")!= null && !request.getParameter("year").equals("")){
reportyear = request.getParameter("year");
 years=Integer.parseInt(reportyear)-1;
}
if(request.getParameter("quarter")!= null && !request.getParameter("quarter").equals("")){
quarter = request.getParameter("quarter");
}
if(request.getParameter("semi-annual")!= null && !request.getParameter("semi-annual").equals("")){
semiannual = request.getParameter("semi-annual");
}
int a=0;
                     
              HSSFWorkbook wb=new HSSFWorkbook();
  HSSFSheet shet1=wb.createSheet();
  HSSFFont font=wb.createFont();
    font.setFontHeightInPoints((short)12);
    font.setFontName("Cambria");
//    font.setItalic(true);
    font.setBoldweight((short)02);
    font.setColor(HSSFColor.BLACK.index);
    CellStyle style=wb.createCellStyle();
    style.setFont(font);
    style.setWrapText(true);
    style.setFillForegroundColor(HSSFColor.GOLD.index);
style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
  style.setBorderBottom(CellStyle.BORDER_THIN);
            style.setBorderLeft(CellStyle.BORDER_THIN);
            style.setBorderRight(CellStyle.BORDER_THIN);
            style.setBorderTop(CellStyle.BORDER_THIN);
            style.setAlignment(CellStyle.ALIGN_CENTER);


//%%%%%%%%%%%%%%%%HEADER FONTS AND COLORATION%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)15);
    font_header.setColor(HSSFColor.BLACK.index);
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
//shet1.addMergedRegion(new CellRangeAddress(0,0,1,7));
     
            
            
HSSFCellStyle stylex = wb.createCellStyle();
            stylex.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            HSSFFont fontx = wb.createFont();
            fontx.setColor(HSSFColor.DARK_BLUE.index);
            stylex.setFont(fontx);
            stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
             //stylex.setAlignment(CellStyle.ALIGN_CENTER);
            stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            HSSFCellStyle styley = wb.createCellStyle();
//styley.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
//styley.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            HSSFFont fonty = wb.createFont();
            styley.setFont(fonty);
// styley.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
// styley.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
// styley.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
            styley.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFCellStyle stylez = wb.createCellStyle();
            HSSFFont fontz = wb.createFont();
            stylez.setFont(fontz);
            stylez.setBorderRight(HSSFCellStyle.BORDER_THIN);

            HSSFCellStyle styletop = wb.createCellStyle();
            HSSFFont fontp = wb.createFont();
            styletop.setFont(fontp);
            styletop.setBorderTop(HSSFCellStyle.BORDER_THIN);


            CellStyle borderStyle = wb.createCellStyle();
            borderStyle.setFillForegroundColor(HSSFColor.ROSE.index);
            borderStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            borderStyle.setFont(fontx);
            borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
            borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
            borderStyle.setBorderRight(CellStyle.BORDER_THIN);
            borderStyle.setBorderTop(CellStyle.BORDER_THIN);
            borderStyle.setAlignment(CellStyle.ALIGN_CENTER);
            
            
            CellStyle indicator_style = wb.createCellStyle();
            indicator_style.setFillForegroundColor(HSSFColor.PLUM.index);
            indicator_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                HSSFFont fonts = wb.createFont();
                fonts.setColor(HSSFColor.BLACK.index);
                fonts.setFontHeightInPoints((short) 17);
            indicator_style.setFont(fonts);
            indicator_style.setBorderBottom(CellStyle.BORDER_THIN);
            indicator_style.setBorderLeft(CellStyle.BORDER_THIN);
            indicator_style.setBorderRight(CellStyle.BORDER_THIN);
            indicator_style.setBorderTop(CellStyle.BORDER_THIN);
            indicator_style.setAlignment(CellStyle.ALIGN_CENTER);
            
            CellStyle cell_style = wb.createCellStyle();
          
          
                HSSFFont fonts1 = wb.createFont();
                fonts1.setColor(HSSFColor.BLACK.index);
                fonts1.setFontHeightInPoints((short) 11);
            cell_style.setFont(fonts1);
            cell_style.setBorderBottom(CellStyle.BORDER_THIN);
            cell_style.setBorderLeft(CellStyle.BORDER_THIN);
            cell_style.setBorderRight(CellStyle.BORDER_THIN);
            cell_style.setBorderTop(CellStyle.BORDER_THIN);
          
            CellStyle Total_style = wb.createCellStyle();
             Total_style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            Total_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
          
                HSSFFont fonts2 = wb.createFont();
                fonts2.setColor(HSSFColor.BLACK.index);
                fonts2.setFontHeightInPoints((short) 11);
            Total_style.setFont(fonts1);
            Total_style.setBorderBottom(CellStyle.BORDER_THIN);
            Total_style.setBorderLeft(CellStyle.BORDER_THIN);
            Total_style.setBorderRight(CellStyle.BORDER_THIN);
            Total_style.setBorderTop(CellStyle.BORDER_THIN);
          

    shet1.setColumnWidth(0, 4000); 
    shet1.setColumnWidth(1,8000 ); 
    shet1.setColumnWidth(2, 8000); 
    shet1.setColumnWidth(3, 8000); 
    shet1.setColumnWidth(4, 10000); 
 
    HSSFRow rw0 = shet1.createRow(a);
                    HSSFCell cell0;
                    //cell0=rw0.createCell(2);
                    //cell0.setCellValue("Program Progress Table");
                    for (int y = 1; y <= 18; ++y) {
//    Cell cell = row.createCell(i);
                        cell0 = rw0.createCell(y);
                        cell0.setCellStyle(indicator_style);
                        if (y == 1) {
                            cell0.setCellValue("Risk Reduction Services Report");
                        }
                    }

                    // cell0.setCellStyle(style_header);
                     rw0.setHeightInPoints(30);

//  Merge the cells
                    shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 18));
                    
                    // begigning of total REPORT 
                    if(reporttype.equalsIgnoreCase("Services Provided") && reportyear.equals("") && quarter.equals("") && semiannual.equals("") ){
   
     HSSFRow row2 = shet1.createRow(b);
                    

                     row2.setHeightInPoints(30);


                    HSSFRow row4 = shet1.createRow(b + 1);
                    HSSFCell cells_5, cells_6, cells_7, cells_8;

                   for (int y = 1; y <=2; y++) {

                        cells_5 = row4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("Condoms Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = row4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = row4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("year");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = row4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      row4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
                    
                    
                                                        String query1 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B1'  "
          + "AND  RiskReductionDetails.currentstatus='1' OR RiskReductionDetails.currentstatus='2' "
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 
String CD="";
 conn.rs4= conn.state4.executeQuery(query1);
 while(conn.rs4.next()){
 System.out.println("______________________"+conn.rs4.getString(2));
 System.out.println("______________________"+conn.rs4.getString(4));
 String [] cds;
 id1 = conn.rs4.getString(1);
            ansas1 = conn.rs4.getInt(2);
            QID1 = conn.rs4.getString(3);
            Action1 = conn.rs4.getString(4);
            DOA1 = conn.rs4.getString(5);
            DIC1 = conn.rs4.getString(6);
                  
 cds= conn.rs4.getString(4).split("_");
 for(int k=0;k<=cds.length;k++){
 if(cds.length==2){
 CD = cds[1];
  
 
 }

 System.out.println(CD);
  
 } 
 
 condomcount+=ansas1;
                     b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwa = shet1.createRow(b);
  
                 

                      rwa.createCell(3).setCellValue(DIC1);
                        rwa.createCell(6).setCellValue(DOA1);
                         rwa.createCell(9).setCellValue(ansas1);
shet1.addMergedRegion(new CellRangeAddress(b,b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
  

  }
 
 
  b+=1  ;
                        
                           HSSFRow row = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells6 = row.createCell(y);

                        cells6.setCellStyle(stylex);
                        if (y == 3) {
                            cells6.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row.createCell(11);
                    cells5.setCellValue(condomcount);
                    cells5.setCellStyle(stylex);
                      condomcount=0;
                      ansas1=0;
                      // END OF CD PROVIDED 
                      
                    b+=3; 
//                
                    
                    
                    
                    
                    // begining of wbl      
       
                       HSSFRow rows2 = shet1.createRow(b);
                    

                     rows2.setHeightInPoints(30);


                    HSSFRow rows4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No of water based lubricants provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("year");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%' "
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 
String WBL="";
 conn.rs6= conn.state6.executeQuery(query2);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));
 String [] WBLS;
             id2 = conn.rs6.getString(1);
            ansas2 = conn.rs6.getInt(2);
            QID2 = conn.rs6.getString(3);
            Action2 = conn.rs6.getString(4);
            DOA2 = conn.rs6.getString(5);
            DIC2= conn.rs6.getString(6);
 WBLS= conn.rs6.getString(4).split("_");
 for(int k=0;k<=WBLS.length;k++){
 if(WBLS.length==2){
 WBL = WBLS[1];
 
  
 }

 System.out.println(WBLS);
  
 }
 
 wblcount+=ansas2 ;
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC2);
                        rwc.createCell(6).setCellValue(DOA2);
                         rwc.createCell(9).setCellValue(ansas2);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 
 
  b+=1  ;
                        
                           HSSFRow row1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row1.createCell(11);
                    cells5.setCellValue(wblcount);
                    cells5.setCellStyle(stylex);
                      wblcount=0;     
                      ansas2=0;
                       b+=3; 
                      
                       // end of wbl 
                       
                      
                      // for alcohol audit 
//                      
       
                       HSSFRow rw_2 = shet1.createRow(b);
                    

                     rw_2.setHeightInPoints(30);


                    HSSFRow rw_4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rw_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No provided with an AUDIT");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rw_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rw_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("year");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rw_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query5 ="SELECT COUNT((CASE WHEN RiskReductionDetails.action IS NULL THEN  RiskReductionDetails.currentstatus ELSE RiskReductionDetails.action END)"
                         + " OR (CASE WHEN RiskReductionDetails.currentstatus IS NULL THEN RiskReductionDetails.action"
                         + "  ELSE RiskReductionDetails.currentstatus END)) AS TOTAL ,RiskReductionDetails.QID,"
                         + "YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),"
                         + "Enrollment.DICName FROM RiskReductionDetails,RiskReductionMain,Enrollment"
                         + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                         + "and Enrollment.uniqueid = RiskReductionMain.uniqueid and RiskReductionDetails.QID='C'"
                         + " and (RiskReductionDetails.ACTION!=NULL OR RiskReductionDetails.ACTION!=''OR"
                         + "  RiskReductionDetails.currentstatus!='' OR RiskReductionDetails.currentstatus!=NULL)"
                         + " and (RiskReductionDetails.ACTION!=0 OR RiskReductionDetails.currentstatus!=0) "
                         + "GROUP BY YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName"; 

 conn.rs6= conn.state6.executeQuery(query5);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

//             id4 = conn.rs6.getString(1);
            ansas4 = conn.rs6.getInt(1);
            QID4 = conn.rs6.getString(2);
       
            DOA4 = conn.rs6.getString(3);
            DIC4= conn.rs6.getString(4);
 countJ3+=ansas4;
 
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC4);
                        rwc.createCell(6).setCellValue(DOA4);
                         rwc.createCell(9).setCellValue(ansas4);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 System.out.println("countJ3"+countJ3);
 
  b+=1  ;
                        
                           HSSFRow row_1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row_1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row_1.createCell(11);
                    cells5.setCellValue(countJ3);
                    cells5.setCellStyle(stylex);
                       countJ3=0;     
                      ansas4=0;
                       b+=3; 
                      
                      
                      
                      
                      
              a+=b;      


              String[]  questions = new String[]{"D2","E1","E2","F1","G1","H1","I","J1","J2","K"};
              String[]  questions1 = new String[]{"Number provided with Health Education","Number provided with HIV testing ","Number provided with HIV testing with partner","Number provided with STI Checkup ","Number provided with Cervical Cancer Screening ","Number provided with tuberculosis screening","Number provided with referall for Gender Based Violence","Number currently on FP Methods","Number provided with FP Methods","Number Linked to IGA Group"};
           
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
       
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {

                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              


                     HSSFRow rw2 = shet1.createRow(a + 2);
                  
                     rw2.setHeightInPoints(30);


                    HSSFRow rw4 = shet1.createRow(a + 1);
                    HSSFCell cells1, cells2, cells3, cells4;

                   for (int y = 1; y <=2; y++) {

                        cells1 = rw4.createCell(y);
                        cells1.setCellStyle(style_header);
                        if (y == 1) {
                               cells1.setCellValue(questions1[g]);
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells2 = rw4.createCell(y);
                        cells2.setCellStyle(style_header);
                        if (y ==3) {
                        cells2.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells3 = rw4.createCell(y);

                        cells3.setCellStyle(style_header);
                        if (y == 6) {
                              cells3.setCellValue("year");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells4 = rw4.createCell(y);

                        cells4.setCellStyle(style_header);
                        if (y == 9) {
                              cells4.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rw4.setHeightInPoints(30);
    a += 1;
 shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));
  
 
//                 if(totalCounts==0) { 

                      
                      
                // end of wbl       
//                       b++;
                // }

                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes'"
                                 + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))";
            conn.rs2 = conn.state2.executeQuery(query);
            conn.rs3 = conn.state3.executeQuery(query);
                   
            while(conn.rs3.next()){
           rowcount++;}
            while(conn.rs2.next()){
         counts++;
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
            DOA = conn.rs2.getString(5);
            DIC = conn.rs2.getString(6);
            totalCounts = conn.rs2.getInt(7);
             
 
                        a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwi = shet1.createRow(a);

                        HSSFCell cells_1, cells_2, cells_3, cells_4;

                                              rwi.createCell(9).setCellValue(totalCounts);

                      rwi.createCell(3).setCellValue(DIC);
                        rwi.createCell(6).setCellValue(DOA);
                     
   
                  total+=  totalCounts;    
                        
                     
      
//                    a += 1;
      System.out.println("rowcount"+rowcount);             
      System.out.println("counts"+counts);             
// shet1.addMergedRegion(new CellRangeAddress(a,a, 2,4));
shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));

                    //System.out.println("VALUE OF J IS :System.out"+j);





//                    a += 1;
//                b+=51;
//                c+=51;
//                d+=51;
//                e+=51;
//                f+=51;
//                i+=51;
                    //p+=20;
            }
             a += 1;
             
                    HSSFRow rwj = shet1.createRow(a);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells2 = rwj.createCell(y);

                        cells2.setCellStyle(stylex);
                        if (y == 3) {
                            cells2.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 10));
                    cells5 = rwj.createCell(11);
                    cells5.setCellValue(total);
                    cells5.setCellStyle(stylex);

              a += 3;
              
              total=0;
              totalCounts=0;
            }
        }
      
        
        c+=a;
                       HSSFRow rows_2 = shet1.createRow(c);
                    

                     rows_2.setHeightInPoints(30);


                    HSSFRow rows_4 = shet1.createRow(c + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("FP Methods Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("year");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("FP Method");
                        }
                    }
                    for (int y = 12; y <= 13; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y ==12) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows_4.setHeightInPoints(30);
    c += 1;
 shet1.addMergedRegion(new CellRangeAddress(c, c, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c, c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12, 13));
 
                      
                 String query3 ="SELECT RiskReductionDetails.RiskReductionID,count(RiskReductionDetails.currentstatus),RiskReductionDetails.QID,RiskReductionDetails.currentstatus,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='J3' AND (UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('depo_%') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('condoms') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('pills') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('jadelle') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('implanon') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('injection'))"
          + "GROUP BY RiskReductionDetails.currentstatus,Enrollment.DICName,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 

 conn.rs6= conn.state6.executeQuery(query3);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

             id3 = conn.rs6.getString(1);
            ansas3 = conn.rs6.getInt(2);
            QID3 = conn.rs6.getString(3);
            Action3 = conn.rs6.getString(4);
            DOA3 = conn.rs6.getString(5);
            DIC3= conn.rs6.getString(6);
 
 
 FPcount+=ansas3;
 
                           c += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(c);
 
                 

                      rwc.createCell(3).setCellValue(DIC3);
                        rwc.createCell(6).setCellValue(DOA3);
                         rwc.createCell(12).setCellValue(ansas3);
                         rwc.createCell(9).setCellValue(Action3);
shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c,c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));
             

  }
 
 
  c+=1  ;
                        
                           HSSFRow rows1 = shet1.createRow(c);


                    for (int y = 3; y <= 11; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = rows1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                    for (int y = 12; y <= 13; ++y) {
//    Cell cell = row.createCell(i);
                        cells9 = rows1.createCell(y);

                        cells9.setCellStyle(stylex);
                        if (y ==12) {
                            cells9.setCellValue(FPcount);
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 11));
                     shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));  
//                    cells5 = rows1.createCell(12);
//                    cells5.setCellValue(FPcount);
//                    cells5.setCellStyle(stylex);
                     
                    } 
                    
              // end of report for all years 
                    
                    
                    
                    
                    
                    
                    
              //begining of report for year eg 2011,2012,2013
                    
                    else if (reporttype.equalsIgnoreCase("Services Provided") && reportyear!=null && !reportyear.equals("") && quarter.equals("") && semiannual.equals("") ){  
                     
                        
                        
                      
                    HSSFRow row4 = shet1.createRow(b + 1);
                    HSSFCell cells_5, cells_6, cells_7, cells_8;

                   for (int y = 1; y <=2; y++) {

                        cells_5 = row4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("Condoms Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = row4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = row4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("year");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = row4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      row4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
                    
                    
                                                        String query1 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B1'  "
          + "AND RiskReductionDetails.action LIKE 'Condoms were provided_%' AND YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) ='"+reportyear+"'"
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 
String CD="";
 conn.rs4= conn.state4.executeQuery(query1);
 while(conn.rs4.next()){
 System.out.println("______________________"+conn.rs4.getString(2));
 System.out.println("______________________"+conn.rs4.getString(4));
 String [] cds;
 id1 = conn.rs4.getString(1);
            ansas1 = conn.rs4.getInt(2);
            QID1 = conn.rs4.getString(3);
            Action1 = conn.rs4.getString(4);
            DOA1 = conn.rs4.getString(5);
            DIC1 = conn.rs4.getString(6);
               String []dater =DOA1.split("-");
               String enrolDate ="";
              
               System.out.println(dater[1]);
               if(dater[1].equals("01")){
                   enrolDate="January ";
               }
               if(dater[1].equals("02")){
                   enrolDate="February";
               }
               if(dater[1].equals("03")){
                   enrolDate="March ";
               }
               if(dater[1].equals("04")){
                   enrolDate="April ";
               }
               else if(dater[1].equals("05")){
                   enrolDate="May ";
               }
                if(dater[1].equals("06")){
                   enrolDate="June";
               }
              if(dater[1].equals("07")){
                   enrolDate="July ";
               }
               if(dater[1].equals("08")){
                   enrolDate="August ";
               }
               if(dater[1].equals("09")){
                   enrolDate="September ";
               }
               if(dater[1].equals("10")){
                   enrolDate="October ";
               }
               if(dater[1].equals("11")){
                   enrolDate="November";
               }
               if(dater[1].equals("12")){
                   enrolDate="December";
               }
            
            
                  
 cds= conn.rs4.getString(4).split("_");
 for(int k=0;k<=cds.length;k++){
 if(cds.length==2){
 CD = cds[1];
  
 
 }

 System.out.println(CD);
  
 } 
 
 condomcount+=ansas1;
                     b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwa = shet1.createRow(b);
  
                 

                      rwa.createCell(3).setCellValue(DIC1);
                        rwa.createCell(6).setCellValue(enrolDate);
                         rwa.createCell(9).setCellValue(ansas1);
shet1.addMergedRegion(new CellRangeAddress(b,b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
  

  }
 
 
  b+=1  ;
                        
                           HSSFRow row = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells6 = row.createCell(y);

                        cells6.setCellStyle(stylex);
                        if (y == 3) {
                            cells6.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row.createCell(11);
                    cells5.setCellValue(condomcount);
                    cells5.setCellStyle(stylex);
                      condomcount=0;
                      ansas1=0;
                      // END OF CD PROVIDED 
                      
                    b+=3; 
//                
                    
                    
                    
                    
                    // begining of wbl      
       
                       HSSFRow rows2 = shet1.createRow(b);
                    

                     rows2.setHeightInPoints(30);


                    HSSFRow rows4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No of water based lubricants provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month"+reportyear);
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%'AND (RiskReductionDetails.currentstatus='1'|| RiskReductionDetails.currentstatus='2') AND YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) ='"+reportyear+"' "
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 
String WBL="";
 conn.rs6= conn.state6.executeQuery(query2);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));
 String [] WBLS;
             id2 = conn.rs6.getString(1);
            ansas2 = conn.rs6.getInt(2);
            QID2 = conn.rs6.getString(3);
            Action2 = conn.rs6.getString(4);
            DOA2 = conn.rs6.getString(5);
            DIC2= conn.rs6.getString(6);
 String []dater =DOA2.split("-");
               String enrolDate ="";
              
               System.out.println(dater[1]);
               if(dater[1].equals("01")){
                   enrolDate="January ";
               }
               if(dater[1].equals("02")){
                   enrolDate="February";
               }
               if(dater[1].equals("03")){
                   enrolDate="March ";
               }
               if(dater[1].equals("04")){
                   enrolDate="April ";
               }
               else if(dater[1].equals("05")){
                   enrolDate="May ";
               }
                if(dater[1].equals("06")){
                   enrolDate="June";
               }
              if(dater[1].equals("07")){
                   enrolDate="July ";
               }
               if(dater[1].equals("08")){
                   enrolDate="August ";
               }
               if(dater[1].equals("09")){
                   enrolDate="September ";
               }
               if(dater[1].equals("10")){
                   enrolDate="October ";
               }
               if(dater[1].equals("11")){
                   enrolDate="November";
               }
               if(dater[1].equals("12")){
                   enrolDate="December";
               }
            
 
 wblcount+=ansas2 ;
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC2);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(9).setCellValue(ansas2);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 
 
  b+=1  ;
                        
                           HSSFRow row1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row1.createCell(11);
                    cells5.setCellValue(wblcount);
                    cells5.setCellStyle(stylex);
                      wblcount=0;     
                      ansas2=0;
                       b+=3; 
                      
                       // end of wbl 
                       
                      
                      // for alcohol audit 
//                      
       
                       HSSFRow rw_2 = shet1.createRow(b);
                    

                     rw_2.setHeightInPoints(30);


                    HSSFRow rw_4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rw_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No provided with an AUDIT");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rw_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rw_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month"+reportyear);
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rw_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query5 ="SELECT COUNT((CASE WHEN RiskReductionDetails.action IS NULL THEN  RiskReductionDetails.currentstatus ELSE RiskReductionDetails.action END)"
                         + " OR (CASE WHEN RiskReductionDetails.currentstatus IS NULL THEN RiskReductionDetails.action"
                         + "  ELSE RiskReductionDetails.currentstatus END)) AS TOTAL ,RiskReductionDetails.QID,"
                         + "STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'),"
                         + "Enrollment.DICName FROM RiskReductionDetails,RiskReductionMain,Enrollment"
                         + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                         + "and Enrollment.uniqueid = RiskReductionMain.uniqueid and RiskReductionDetails.QID='C'"
                         + " and (RiskReductionDetails.ACTION!=NULL OR RiskReductionDetails.ACTION!=''OR"
                         + "  RiskReductionDetails.currentstatus!='' OR RiskReductionDetails.currentstatus!=NULL)"
                         + " and (RiskReductionDetails.ACTION!=0 OR RiskReductionDetails.currentstatus!=0) AND YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) ='"+reportyear+"' "
                         + "GROUP BY MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName"; 

 conn.rs6= conn.state6.executeQuery(query5);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

//             id4 = conn.rs6.getString(1);
            ansas4 = conn.rs6.getInt(1);
            QID4 = conn.rs6.getString(2);
       
            DOA4 = conn.rs6.getString(3);
            DIC4= conn.rs6.getString(4);
 countJ3+=ansas4;
  String []dater =DOA4.split("-");
               String enrolDate ="";
              
               System.out.println(dater[1]);
               if(dater[1].equals("01")){
                   enrolDate="January ";
               }
               if(dater[1].equals("02")){
                   enrolDate="February";
               }
               if(dater[1].equals("03")){
                   enrolDate="March ";
               }
               if(dater[1].equals("04")){
                   enrolDate="April ";
               }
               else if(dater[1].equals("05")){
                   enrolDate="May ";
               }
                if(dater[1].equals("06")){
                   enrolDate="June";
               }
              if(dater[1].equals("07")){
                   enrolDate="July ";
               }
               if(dater[1].equals("08")){
                   enrolDate="August ";
               }
               if(dater[1].equals("09")){
                   enrolDate="September ";
               }
               if(dater[1].equals("10")){
                   enrolDate="October ";
               }
               if(dater[1].equals("11")){
                   enrolDate="November";
               }
               if(dater[1].equals("12")){
                   enrolDate="December";
               }
            
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC4);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(9).setCellValue(ansas4);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 System.out.println("countJ3"+countJ3);
 
  b+=1  ;
                        
                           HSSFRow row_1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row_1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row_1.createCell(11);
                    cells5.setCellValue(countJ3);
                    cells5.setCellStyle(stylex);
                       countJ3=0;     
                      ansas4=0;
                       b+=3; 
                      
                      
                      
                      
                      
              a+=b;      


              String[]  questions = new String[]{"D2","E1","E2","F1","G1","H1","I","J1","J2","K"};
              String[]  questions1 = new String[]{"Number provided with Health Education","Number provided with HIV testing ","Number provided with HIV testing with partner","Number provided with STI Checkup ","Number provided with Cervical Cancer Screening ","Number provided with tuberculosis screening","Number provided with referall for Gender Based Violence","Number currently on FP Methods","Number provided with FP Methods","Number Linked to IGA Group"};
           
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
       
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {

                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              


                     HSSFRow rw2 = shet1.createRow(a + 2);
                  
                     rw2.setHeightInPoints(30);


                    HSSFRow rw4 = shet1.createRow(a + 1);
                    HSSFCell cells1, cells2, cells3, cells4;

                   for (int y = 1; y <=2; y++) {

                        cells1 = rw4.createCell(y);
                        cells1.setCellStyle(style_header);
                        if (y == 1) {
                               cells1.setCellValue(questions1[g]);
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells2 = rw4.createCell(y);
                        cells2.setCellStyle(style_header);
                        if (y ==3) {
                        cells2.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells3 = rw4.createCell(y);

                        cells3.setCellStyle(style_header);
                        if (y == 6) {
                              cells3.setCellValue("Month" +reportyear);
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells4 = rw4.createCell(y);

                        cells4.setCellStyle(style_header);
                        if (y == 9) {
                              cells4.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rw4.setHeightInPoints(30);
    a += 1;
 shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));
  
 
//                 if(totalCounts==0) { 

                      
                      
                // end of wbl       
//                       b++;
                // }

                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes' AND YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) ='"+reportyear+"'"
                                 + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))";
            conn.rs2 = conn.state2.executeQuery(query);
            conn.rs3 = conn.state3.executeQuery(query);
                   
            while(conn.rs3.next()){
           rowcount++;}
            while(conn.rs2.next()){
         counts++;
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
            DOA = conn.rs2.getString(5);
            DIC = conn.rs2.getString(6);
            totalCounts = conn.rs2.getInt(7);
              String []dater =DOA.split("-");
               String enrolDate ="";
              
               System.out.println(dater[1]);
               if(dater[1].equals("01")){
                   enrolDate="January ";
               }
               if(dater[1].equals("02")){
                   enrolDate="February";
               }
               if(dater[1].equals("03")){
                   enrolDate="March ";
               }
               if(dater[1].equals("04")){
                   enrolDate="April ";
               }
               else if(dater[1].equals("05")){
                   enrolDate="May ";
               }
                if(dater[1].equals("06")){
                   enrolDate="June";
               }
              if(dater[1].equals("07")){
                   enrolDate="July ";
               }
               if(dater[1].equals("08")){
                   enrolDate="August ";
               }
               if(dater[1].equals("09")){
                   enrolDate="September ";
               }
               if(dater[1].equals("10")){
                   enrolDate="October ";
               }
               if(dater[1].equals("11")){
                   enrolDate="November";
               }
               if(dater[1].equals("12")){
                   enrolDate="December";
               }
            
 
                        a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwi = shet1.createRow(a);

                        HSSFCell cells_1, cells_2, cells_3, cells_4;

                                              rwi.createCell(9).setCellValue(totalCounts);

                      rwi.createCell(3).setCellValue(DIC);
                        rwi.createCell(6).setCellValue(enrolDate);
                     
   
                  total+=  totalCounts;    
                        
                     
      
//                    a += 1;
      System.out.println("rowcount"+rowcount);             
      System.out.println("counts"+counts);             
// shet1.addMergedRegion(new CellRangeAddress(a,a, 2,4));
shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));

                    //System.out.println("VALUE OF J IS :System.out"+j);





//                    a += 1;
//                b+=51;
//                c+=51;
//                d+=51;
//                e+=51;
//                f+=51;
//                i+=51;
                    //p+=20;
            }
             a += 1;
             
                    HSSFRow rwj = shet1.createRow(a);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells2 = rwj.createCell(y);

                        cells2.setCellStyle(stylex);
                        if (y == 3) {
                            cells2.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 10));
                    cells5 = rwj.createCell(11);
                    cells5.setCellValue(total);
                    cells5.setCellStyle(stylex);

              a += 3;
              
              total=0;
              totalCounts=0;
            }
        }
      
        
        c+=a;
                       HSSFRow rows_2 = shet1.createRow(c);
                    

                     rows_2.setHeightInPoints(30);


                    HSSFRow rows_4 = shet1.createRow(c + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("FP Methods Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month"+reportyear);
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("FP Method");
                        }
                    }
                    for (int y = 12; y <= 13; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y ==12) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows_4.setHeightInPoints(30);
    c += 1;
 shet1.addMergedRegion(new CellRangeAddress(c, c, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c, c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12, 13));
 
                      
                 String query3 ="SELECT RiskReductionDetails.RiskReductionID,count(RiskReductionDetails.currentstatus),RiskReductionDetails.QID,RiskReductionDetails.currentstatus,STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='J3' AND (UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('depo_%') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('condoms') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('pills') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('jadelle') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('implanon') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('injection'))  AND YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) ='"+reportyear+"'"
          + "GROUP BY RiskReductionDetails.currentstatus,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 

 conn.rs6= conn.state6.executeQuery(query3);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

             id3 = conn.rs6.getString(1);
            ansas3 = conn.rs6.getInt(2);
            QID3 = conn.rs6.getString(3);
            Action3 = conn.rs6.getString(4);
            DOA3 = conn.rs6.getString(5);
            DIC3= conn.rs6.getString(6);
 
  String []dater =DOA3.split("-");
               String enrolDate ="";
              
               System.out.println(dater[1]);
               if(dater[1].equals("01")){
                   enrolDate="January ";
               }
               if(dater[1].equals("02")){
                   enrolDate="February";
               }
               if(dater[1].equals("03")){
                   enrolDate="March ";
               }
               if(dater[1].equals("04")){
                   enrolDate="April ";
               }
               else if(dater[1].equals("05")){
                   enrolDate="May ";
               }
                if(dater[1].equals("06")){
                   enrolDate="June";
               }
              if(dater[1].equals("07")){
                   enrolDate="July ";
               }
               if(dater[1].equals("08")){
                   enrolDate="August ";
               }
               if(dater[1].equals("09")){
                   enrolDate="September ";
               }
               if(dater[1].equals("10")){
                   enrolDate="October ";
               }
               if(dater[1].equals("11")){
                   enrolDate="November";
               }
               if(dater[1].equals("12")){
                   enrolDate="December";
               }
            
 FPcount+=ansas3;
 
                           c += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(c);
 
                 

                      rwc.createCell(3).setCellValue(DIC3);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(12).setCellValue(ansas3);
                         rwc.createCell(9).setCellValue(Action3);
shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c,c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));
             

  }
 
 
  c+=1  ;
                        
                           HSSFRow rows1 = shet1.createRow(c);


                    for (int y = 3; y <= 11; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = rows1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                    for (int y = 12; y <= 13; ++y) {
//    Cell cell = row.createCell(i);
                        cells9 = rows1.createCell(y);

                        cells9.setCellStyle(stylex);
                        if (y ==12) {
                            cells9.setCellValue(FPcount);
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 11));
                     shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));  
//                    cells5 = rows1.createCell(12);
//                    cells5.setCellValue(FPcount);
//                    cells5.setCellStyle(stylex);
                     
                    }          
    // end of report by an year broken down into months 
            
                    
                    
                    
                    
                    
                  // begining of report by quarters   
                    
                    
                    
                    
                    else if(reporttype.equalsIgnoreCase("Services Provided") && quarter!=null && !quarter.equals("") && reportyear!=null && !reportyear.equals("")){
     
                        
                        
   if(quarter.equals("Q1")){
   
   dates1 ="01/10/"+years;
   dates2 ="31/12/"+years;
   }
   else if(quarter.equals("Q2")){
     dates1 ="01/01/"+reportyear;
   dates2 ="31/03/"+reportyear;
   }
   else if(quarter.equals("Q3")){
    dates1 ="01/04/"+reportyear;
   dates2 ="30/06/"+reportyear;
   }
   else if(quarter.equals("Q4")){
      dates1 ="01/07/"+reportyear;
   dates2 ="30/09/"+reportyear;
   }
   
       HSSFRow row7 = shet1.createRow(b);
                    HSSFCell cell1;
                    //cell0=rw0.createCell(2);
                    //cell0.setCellValue("Program Progress Table");
                    for (int y = 3; y <= 12; ++y) {
//    Cell cell = row.createCell(i);
                        cell1 = row7.createCell(y);
                        cell1.setCellStyle(style_header);
                        if (y == 3) {
                            cell1.setCellValue("From " +dates1 +" to "+ dates2);
                        }
                    }
                row7.setHeightInPoints(30);
     shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 12));
 b+=1;
                        
//                        HSSFRow row2 = shet1.createRow(b);
                    

                     row7.setHeightInPoints(30);


                    HSSFRow row4 = shet1.createRow(b + 1);
                    HSSFCell cells_5, cells_6, cells_7, cells_8;

                   for (int y = 1; y <=2; y++) {

                        cells_5 = row4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("Condoms Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = row4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = row4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Quarter");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = row4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      row4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
                    
                    
                                                        String query1 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B1'  "
          + "AND RiskReductionDetails.action LIKE 'Condoms were provided_%' AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y'))"
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 

 conn.rs4= conn.state4.executeQuery(query1);
 while(conn.rs4.next()){
 System.out.println("______________________"+conn.rs4.getString(2));
 System.out.println("______________________"+conn.rs4.getString(4));
 
 id1 = conn.rs4.getString(1);
            ansas1 = conn.rs4.getInt(2);
            QID1 = conn.rs4.getString(3);
            Action1 = conn.rs4.getString(4);
            DOA1 = conn.rs4.getString(5);
            DIC1 = conn.rs4.getString(6);
            
             
               String enrolDate ="";   
               if(DOA1.equals("1")){
                   enrolDate="January ";
               }
               if(DOA1.equals("2")){
                   enrolDate="February";
               }
               if(DOA1.equals("3")){
                   enrolDate="March ";
               }
               if(DOA1.equals("4")){
                   enrolDate="April ";
               }
               else if(DOA1.equals("5")){
                   enrolDate="May ";
               }
                if(DOA1.equals("6")){
                   enrolDate="June";
               }
              if(DOA1.equals("7")){
                   enrolDate="July ";
               }
               if(DOA1.equals("8")){
                   enrolDate="August ";
               }
               if(DOA1.equals("9")){
                   enrolDate="September ";
               }
               if(DOA1.equals("10")){
                   enrolDate="October ";
               }
               if(DOA1.equals("11")){
                   enrolDate="November";
               }
               if(DOA1.equals("12")){
                   enrolDate="December";
               }
            
                  
 
 
 condomcount+=ansas1;
                     b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwa = shet1.createRow(b);
  
                 

                      rwa.createCell(3).setCellValue(DIC1);
                        rwa.createCell(6).setCellValue(enrolDate);
                         rwa.createCell(9).setCellValue(ansas1);
shet1.addMergedRegion(new CellRangeAddress(b,b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
  

  }
 
 
  b+=1  ;
                        
                           HSSFRow row = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells6 = row.createCell(y);

                        cells6.setCellStyle(stylex);
                        if (y == 3) {
                            cells6.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row.createCell(11);
                    cells5.setCellValue(condomcount);
                    cells5.setCellStyle(stylex);
                      condomcount=0;
                      ansas1=0;
                      // END OF CD PROVIDED 
                      
                    b+=3; 
//                
                    
                    
                    
                    
                    // begining of wbl      
       
                       HSSFRow rows2 = shet1.createRow(b);
                    

                     rows2.setHeightInPoints(30);


                    HSSFRow rows4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No of water based lubricants provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Quarter");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%'AND (RiskReductionDetails.currentstatus='1'|| RiskReductionDetails.currentstatus='2') AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) "
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 
String WBL="";
 conn.rs6= conn.state6.executeQuery(query2);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));
 String [] WBLS;
             id2 = conn.rs6.getString(1);
            ansas2 = conn.rs6.getInt(2);
            QID2 = conn.rs6.getString(3);
            Action2 = conn.rs6.getString(4);
            DOA2 = conn.rs6.getString(5);
            DIC2= conn.rs6.getString(6);
               String enrolDate ="";   
               if(DOA2.equals("1")){
                   enrolDate="January ";
               }
               if(DOA2.equals("2")){
                   enrolDate="February";
               }
               if(DOA2.equals("3")){
                   enrolDate="March ";
               }
               if(DOA2.equals("4")){
                   enrolDate="April ";
               }
              if(DOA2.equals("5")){
                   enrolDate="May ";
               }
                if(DOA2.equals("6")){
                   enrolDate="June";
               }
              if(DOA2.equals("7")){
                   enrolDate="July ";
               }
               if(DOA2.equals("8")){
                   enrolDate="August ";
               }
               if(DOA2.equals("9")){
                   enrolDate="September ";
               }
               if(DOA2.equals("10")){
                   enrolDate="October ";
               }
               if(DOA2.equals("11")){
                   enrolDate="November";
               }
               if(DOA2.equals("12")){
                   enrolDate="December";
               }
            
                  
 WBLS= conn.rs6.getString(4).split("_");
 for(int k=0;k<=WBLS.length;k++){
 if(WBLS.length==2){
 WBL = WBLS[1];
 
  
 }

 System.out.println(WBLS);
  
 }
 
 wblcount+=ansas2 ;
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC2);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(9).setCellValue(ansas2);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 
 
  b+=1  ;
                        
                           HSSFRow row1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row1.createCell(11);
                    cells5.setCellValue(wblcount);
                    cells5.setCellStyle(stylex);
                      wblcount=0;     
                      ansas2=0;
                       b+=3; 
                      
                       // end of wbl 
                       
                      
                      // for alcohol audit 
//                      
       
                       HSSFRow rw_2 = shet1.createRow(b);
                    

                     rw_2.setHeightInPoints(30);


                    HSSFRow rw_4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rw_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No provided with an AUDIT");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rw_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rw_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Quarter");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rw_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query5 ="SELECT COUNT((CASE WHEN RiskReductionDetails.action IS NULL THEN  RiskReductionDetails.currentstatus ELSE RiskReductionDetails.action END)"
                         + " OR (CASE WHEN RiskReductionDetails.currentstatus IS NULL THEN RiskReductionDetails.action"
                         + "  ELSE RiskReductionDetails.currentstatus END)) AS TOTAL ,RiskReductionDetails.QID,"
                         + "MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),"
                         + "Enrollment.DICName FROM RiskReductionDetails,RiskReductionMain,Enrollment"
                         + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                         + "and Enrollment.uniqueid = RiskReductionMain.uniqueid and RiskReductionDetails.QID='C'"
                         + " and (RiskReductionDetails.ACTION!=NULL OR RiskReductionDetails.ACTION!=''OR"
                         + "  RiskReductionDetails.currentstatus!='' OR RiskReductionDetails.currentstatus!=NULL)"
                         + " and (RiskReductionDetails.ACTION!=0 OR RiskReductionDetails.currentstatus!=0)  AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) "
                         + "GROUP BY MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName"; 

 conn.rs6= conn.state6.executeQuery(query5);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

//             id4 = conn.rs6.getString(1);
            ansas4 = conn.rs6.getInt(1);
            QID4 = conn.rs6.getString(2);
       
            DOA4 = conn.rs6.getString(3);
            DIC4= conn.rs6.getString(4);
 countJ3+=ansas4;
 String enrolDate ="";   
               if(DOA4.equals("1")){
                   enrolDate="January ";
               }
               if(DOA4.equals("2")){
                   enrolDate="February";
               }
               if(DOA4.equals("3")){
                   enrolDate="March ";
               }
               if(DOA4.equals("4")){
                   enrolDate="April ";
               }
              if(DOA4.equals("5")){
                   enrolDate="May ";
               }
                if(DOA4.equals("6")){
                   enrolDate="June";
               }
              if(DOA4.equals("7")){
                   enrolDate="July ";
               }
               if(DOA4.equals("8")){
                   enrolDate="August ";
               }
               if(DOA4.equals("9")){
                   enrolDate="September ";
               }
               if(DOA4.equals("10")){
                   enrolDate="October ";
               }
               if(DOA4.equals("11")){
                   enrolDate="November";
               }
               if(DOA4.equals("12")){
                   enrolDate="December";
               }
            
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC4);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(9).setCellValue(ansas4);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 System.out.println("countJ3"+countJ3);
 
  b+=1  ;
                        
                           HSSFRow row_1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row_1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row_1.createCell(11);
                    cells5.setCellValue(countJ3);
                    cells5.setCellStyle(stylex);
                       countJ3=0;     
                      ansas4=0;
                       b+=3; 
                      
                      
                      
                      
                      
              a+=b;      


              String[]  questions = new String[]{"D2","E1","E2","F1","G1","H1","I","J1","J2","K"};
              String[]  questions1 = new String[]{"Number provided with Health Education","Number provided with HIV testing ","Number provided with HIV testing with partner","Number provided with STI Checkup ","Number provided with Cervical Cancer Screening ","Number provided with tuberculosis screening","Number provided with referall for Gender Based Violence","Number currently on FP Methods","Number provided with FP Methods","Number Linked to IGA Group"};
           
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
       
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {

                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              


                     HSSFRow rw2 = shet1.createRow(a + 2);
                  
                     rw2.setHeightInPoints(30);


                    HSSFRow rw4 = shet1.createRow(a + 1);
                    HSSFCell cells1, cells2, cells3, cells4;

                   for (int y = 1; y <=2; y++) {

                        cells1 = rw4.createCell(y);
                        cells1.setCellStyle(style_header);
                        if (y == 1) {
                               cells1.setCellValue(questions1[g]);
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells2 = rw4.createCell(y);
                        cells2.setCellStyle(style_header);
                        if (y ==3) {
                        cells2.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells3 = rw4.createCell(y);

                        cells3.setCellStyle(style_header);
                        if (y == 6) {
                              cells3.setCellValue("Quarter");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells4 = rw4.createCell(y);

                        cells4.setCellStyle(style_header);
                        if (y == 9) {
                              cells4.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rw4.setHeightInPoints(30);
    a += 1;
 shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));
  
 
//                 if(totalCounts==0) { 

                      
                      
                // end of wbl       
//                       b++;
                // }

                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes'  AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y'))"
                                 + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))";
            conn.rs2 = conn.state2.executeQuery(query);
            conn.rs3 = conn.state3.executeQuery(query);
                   
            while(conn.rs3.next()){
           rowcount++;}
            while(conn.rs2.next()){
         counts++;
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
            DOA = conn.rs2.getString(5);
            DIC = conn.rs2.getString(6);
            totalCounts = conn.rs2.getInt(7);
             String enrolDate ="";   
               if(DOA.equals("1")){
                   enrolDate="January ";
               }
               if(DOA.equals("2")){
                   enrolDate="February";
               }
               if(DOA.equals("3")){
                   enrolDate="March ";
               }
               if(DOA.equals("4")){
                   enrolDate="April ";
               }
              if(DOA.equals("5")){
                   enrolDate="May ";
               }
                if(DOA.equals("6")){
                   enrolDate="June";
               }
              if(DOA.equals("7")){
                   enrolDate="July ";
               }
               if(DOA.equals("8")){
                   enrolDate="August ";
               }
               if(DOA.equals("9")){
                   enrolDate="September ";
               }
               if(DOA.equals("10")){
                   enrolDate="October ";
               }
               if(DOA.equals("11")){
                   enrolDate="November";
               }
               if(DOA.equals("12")){
                   enrolDate="December";
               }
            
 
                        a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwi = shet1.createRow(a);

                        HSSFCell cells_1, cells_2, cells_3, cells_4;

                                              rwi.createCell(9).setCellValue(totalCounts);

                      rwi.createCell(3).setCellValue(DIC);
                        rwi.createCell(6).setCellValue(enrolDate);
                     
   
                  total+=  totalCounts;    
                        
                     
      
//                    a += 1;
      System.out.println("rowcount"+rowcount);             
      System.out.println("counts"+counts);             
// shet1.addMergedRegion(new CellRangeAddress(a,a, 2,4));
shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));

                    //System.out.println("VALUE OF J IS :System.out"+j);





//                    a += 1;
//                b+=51;
//                c+=51;
//                d+=51;
//                e+=51;
//                f+=51;
//                i+=51;
                    //p+=20;
            }
             a += 1;
             
                    HSSFRow rwj = shet1.createRow(a);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells2 = rwj.createCell(y);

                        cells2.setCellStyle(stylex);
                        if (y == 3) {
                            cells2.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 10));
                    cells5 = rwj.createCell(11);
                    cells5.setCellValue(total);
                    cells5.setCellStyle(stylex);

              a += 3;
              
              total=0;
              totalCounts=0;
            }
        }
      
        
        c+=a;
                       HSSFRow rows_2 = shet1.createRow(c);
                    

                     rows_2.setHeightInPoints(30);


                    HSSFRow rows_4 = shet1.createRow(c + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("FP Methods Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Quarter");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("FP Method");
                        }
                    }
                    for (int y = 12; y <= 13; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y ==12) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows_4.setHeightInPoints(30);
    c += 1;
 shet1.addMergedRegion(new CellRangeAddress(c, c, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c, c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12, 13));
 
                      
                 String query3 ="SELECT RiskReductionDetails.RiskReductionID,count(RiskReductionDetails.currentstatus),RiskReductionDetails.QID,RiskReductionDetails.currentstatus,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='J3' AND (UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('depo_%') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('condoms') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('pills') OR UPPER(RiskReductionDetails.currentstatus) "
                         + "LIKE UPPER('jadelle') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('implanon') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('injection'))  AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y'))"
          + "GROUP BY RiskReductionDetails.currentstatus,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 

 conn.rs6= conn.state6.executeQuery(query3);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

             id3 = conn.rs6.getString(1);
            ansas3 = conn.rs6.getInt(2);
            QID3 = conn.rs6.getString(3);
            Action3 = conn.rs6.getString(4);
            DOA3 = conn.rs6.getString(5);
            DIC3= conn.rs6.getString(6);
 
 String enrolDate ="";   
               if(DOA3.equals("1")){
                   enrolDate="January ";
               }
               if(DOA3.equals("2")){
                   enrolDate="February";
               }
               if(DOA3.equals("3")){
                   enrolDate="March ";
               }
               if(DOA3.equals("4")){
                   enrolDate="April ";
               }
              if(DOA3.equals("5")){
                   enrolDate="May ";
               }
                if(DOA3.equals("6")){
                   enrolDate="June";
               }
              if(DOA3.equals("7")){
                   enrolDate="July ";
               }
               if(DOA3.equals("8")){
                   enrolDate="August ";
               }
               if(DOA3.equals("9")){
                   enrolDate="September ";
               }
               if(DOA3.equals("10")){
                   enrolDate="October ";
               }
               if(DOA3.equals("11")){
                   enrolDate="November";
               }
               if(DOA3.equals("12")){
                   enrolDate="December";
               }
            
 FPcount+=ansas3;
 
                           c += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(c);
 
                 

                      rwc.createCell(3).setCellValue(DIC3);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(12).setCellValue(ansas3);
                         rwc.createCell(9).setCellValue(Action3);
shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c,c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));
             

  }
 
 
  c+=1  ;
                        
                           HSSFRow rows1 = shet1.createRow(c);


                    for (int y = 3; y <= 11; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = rows1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                    for (int y = 12; y <= 13; ++y) {
//    Cell cell = row.createCell(i);
                        cells9 = rows1.createCell(y);

                        cells9.setCellStyle(stylex);
                        if (y ==12) {
                            cells9.setCellValue(FPcount);
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 11));
                     shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));  
//                    cells5 = rows1.createCell(12);
//                    cells5.setCellValue(FPcount);
//                    cells5.setCellStyle(stylex);
                     
                    } 
                    
                    
                    
                    
                    // end of quarter report 
                    
                    
                    else if(reporttype.equalsIgnoreCase("Services Provided") && semiannual!=null && !semiannual.equals("") && reportyear!=null && !reportyear.equals("")){
                 
  if(semiannual.equals("Half-1")){
            dates1 ="01/10/"+years;
            dates2 ="31/03/"+reportyear;
            }
   else if(semiannual.equals("Half-2")){
     dates1 ="01/04/"+reportyear;
   dates2 ="30/09/"+reportyear;
                                        }
   
       HSSFRow row7 = shet1.createRow(b);
                    HSSFCell cell1;
                    //cell0=rw0.createCell(2);
                    //cell0.setCellValue("Program Progress Table");
                    for (int y = 3; y <= 12; ++y) {
//    Cell cell = row.createCell(i);
                        cell1 = row7.createCell(y);
                        cell1.setCellStyle(style_header);
                        if (y == 3) {
                            cell1.setCellValue("From " +dates1 +" to "+ dates2);
                        }
                    }
                row7.setHeightInPoints(30);
     shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 12));
 b+=1;
                        
//                        HSSFRow row2 = shet1.createRow(b);
                    

                     row7.setHeightInPoints(30);


                    HSSFRow row4 = shet1.createRow(b + 1);
                    HSSFCell cells_5, cells_6, cells_7, cells_8;

                   for (int y = 1; y <=2; y++) {

                        cells_5 = row4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("Condoms Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = row4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = row4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = row4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      row4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
                    
                    
                                                        String query1 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B1'  "
          + "AND RiskReductionDetails.action LIKE 'Condoms were provided_%' AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y'))"
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 

 conn.rs4= conn.state4.executeQuery(query1);
 while(conn.rs4.next()){
 System.out.println("______________________"+conn.rs4.getString(2));
 System.out.println("______________________"+conn.rs4.getString(4));
 
 id1 = conn.rs4.getString(1);
            ansas1 = conn.rs4.getInt(2);
            QID1 = conn.rs4.getString(3);
            Action1 = conn.rs4.getString(4);
            DOA1 = conn.rs4.getString(5);
            DIC1 = conn.rs4.getString(6);
            
             
               String enrolDate ="";   
               if(DOA1.equals("1")){
                   enrolDate="January ";
               }
               if(DOA1.equals("2")){
                   enrolDate="February";
               }
               if(DOA1.equals("3")){
                   enrolDate="March ";
               }
               if(DOA1.equals("4")){
                   enrolDate="April ";
               }
               else if(DOA1.equals("5")){
                   enrolDate="May ";
               }
                if(DOA1.equals("6")){
                   enrolDate="June";
               }
              if(DOA1.equals("7")){
                   enrolDate="July ";
               }
               if(DOA1.equals("8")){
                   enrolDate="August ";
               }
               if(DOA1.equals("9")){
                   enrolDate="September ";
               }
               if(DOA1.equals("10")){
                   enrolDate="October ";
               }
               if(DOA1.equals("11")){
                   enrolDate="November";
               }
               if(DOA1.equals("12")){
                   enrolDate="December";
               }
            
                  
 
 
 condomcount+=ansas1;
                     b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwa = shet1.createRow(b);
  
                 

                      rwa.createCell(3).setCellValue(DIC1);
                        rwa.createCell(6).setCellValue(enrolDate);
                         rwa.createCell(9).setCellValue(ansas1);
shet1.addMergedRegion(new CellRangeAddress(b,b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
  

  }
 
 
  b+=1  ;
                        
                           HSSFRow row = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells6 = row.createCell(y);

                        cells6.setCellStyle(stylex);
                        if (y == 3) {
                            cells6.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row.createCell(11);
                    cells5.setCellValue(condomcount);
                    cells5.setCellStyle(stylex);
                      condomcount=0;
                      ansas1=0;
                      // END OF CD PROVIDED 
                      
                    b+=3; 
//                
                    
                    
                    
                    
                    // begining of wbl      
       
                       HSSFRow rows2 = shet1.createRow(b);
                    

                     rows2.setHeightInPoints(30);


                    HSSFRow rows4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No of water based lubricants provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%'AND (RiskReductionDetails.currentstatus='1'|| RiskReductionDetails.currentstatus='2') AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) "
          + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 
String WBL="";
 conn.rs6= conn.state6.executeQuery(query2);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));
 String [] WBLS;
             id2 = conn.rs6.getString(1);
            ansas2 = conn.rs6.getInt(2);
            QID2 = conn.rs6.getString(3);
            Action2 = conn.rs6.getString(4);
            DOA2 = conn.rs6.getString(5);
            DIC2= conn.rs6.getString(6);
               String enrolDate ="";   
               if(DOA2.equals("1")){
                   enrolDate="January ";
               }
               if(DOA2.equals("2")){
                   enrolDate="February";
               }
               if(DOA2.equals("3")){
                   enrolDate="March ";
               }
               if(DOA2.equals("4")){
                   enrolDate="April ";
               }
              if(DOA2.equals("5")){
                   enrolDate="May ";
               }
                if(DOA2.equals("6")){
                   enrolDate="June";
               }
              if(DOA2.equals("7")){
                   enrolDate="July ";
               }
               if(DOA2.equals("8")){
                   enrolDate="August ";
               }
               if(DOA2.equals("9")){
                   enrolDate="September ";
               }
               if(DOA2.equals("10")){
                   enrolDate="October ";
               }
               if(DOA2.equals("11")){
                   enrolDate="November";
               }
               if(DOA2.equals("12")){
                   enrolDate="December";
               }
            
                  
 WBLS= conn.rs6.getString(4).split("_");
 for(int k=0;k<=WBLS.length;k++){
 if(WBLS.length==2){
 WBL = WBLS[1];
 
  
 }

 System.out.println(WBLS);
  
 }
 
 wblcount+=ansas2 ;
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC2);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(9).setCellValue(ansas2);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 
 
  b+=1  ;
                        
                           HSSFRow row1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row1.createCell(11);
                    cells5.setCellValue(wblcount);
                    cells5.setCellStyle(stylex);
                      wblcount=0;     
                      ansas2=0;
                       b+=3; 
                      
                       // end of wbl 
                       
                      
                      // for alcohol audit 
//                      
       
                       HSSFRow rw_2 = shet1.createRow(b);
                    

                     rw_2.setHeightInPoints(30);


                    HSSFRow rw_4 = shet1.createRow(b + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rw_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("No provided with an AUDIT");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rw_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rw_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rw_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows4.setHeightInPoints(30);
    b += 1;
 shet1.addMergedRegion(new CellRangeAddress(b, b, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b, b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
 
                      
                 String query5 ="SELECT COUNT((CASE WHEN RiskReductionDetails.action IS NULL THEN  RiskReductionDetails.currentstatus ELSE RiskReductionDetails.action END)"
                         + " OR (CASE WHEN RiskReductionDetails.currentstatus IS NULL THEN RiskReductionDetails.action"
                         + "  ELSE RiskReductionDetails.currentstatus END)) AS TOTAL ,RiskReductionDetails.QID,"
                         + "MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),"
                         + "Enrollment.DICName FROM RiskReductionDetails,RiskReductionMain,Enrollment"
                         + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                         + "and Enrollment.uniqueid = RiskReductionMain.uniqueid and RiskReductionDetails.QID='C'"
                         + " and (RiskReductionDetails.ACTION!=NULL OR RiskReductionDetails.ACTION!=''OR"
                         + "  RiskReductionDetails.currentstatus!='' OR RiskReductionDetails.currentstatus!=NULL)"
                         + " and (RiskReductionDetails.ACTION!=0 OR RiskReductionDetails.currentstatus!=0)  AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) "
                         + "GROUP BY MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName"; 

 conn.rs6= conn.state6.executeQuery(query5);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

//             id4 = conn.rs6.getString(1);
            ansas4 = conn.rs6.getInt(1);
            QID4 = conn.rs6.getString(2);
       
            DOA4 = conn.rs6.getString(3);
            DIC4= conn.rs6.getString(4);
 countJ3+=ansas4;
 String enrolDate ="";   
               if(DOA4.equals("1")){
                   enrolDate="January ";
               }
               if(DOA4.equals("2")){
                   enrolDate="February";
               }
               if(DOA4.equals("3")){
                   enrolDate="March ";
               }
               if(DOA4.equals("4")){
                   enrolDate="April ";
               }
              if(DOA4.equals("5")){
                   enrolDate="May ";
               }
                if(DOA4.equals("6")){
                   enrolDate="June";
               }
              if(DOA4.equals("7")){
                   enrolDate="July ";
               }
               if(DOA4.equals("8")){
                   enrolDate="August ";
               }
               if(DOA4.equals("9")){
                   enrolDate="September ";
               }
               if(DOA4.equals("10")){
                   enrolDate="October ";
               }
               if(DOA4.equals("11")){
                   enrolDate="November";
               }
               if(DOA4.equals("12")){
                   enrolDate="December";
               }
            
                            b += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(b);
 
                 

                      rwc.createCell(3).setCellValue(DIC4);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(9).setCellValue(ansas4);
shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(b,b, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(b, b, 9, 11));
             

  }
 System.out.println("countJ3"+countJ3);
 
  b+=1  ;
                        
                           HSSFRow row_1 = shet1.createRow(b);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = row_1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(b, b, 3, 10));
                    cells5 = row_1.createCell(11);
                    cells5.setCellValue(countJ3);
                    cells5.setCellStyle(stylex);
                       countJ3=0;     
                      ansas4=0;
                       b+=3; 
                      
                      
                      
                      
                      
              a+=b;      


              String[]  questions = new String[]{"D2","E1","E2","F1","G1","H1","I","J1","J2","K"};
              String[]  questions1 = new String[]{"Number provided with Health Education","Number provided with HIV testing ","Number provided with HIV testing with partner","Number provided with STI Checkup ","Number provided with Cervical Cancer Screening ","Number provided with tuberculosis screening","Number provided with referall for Gender Based Violence","Number currently on FP Methods","Number provided with FP Methods","Number Linked to IGA Group"};
           
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
       
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {

                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              


                     HSSFRow rw2 = shet1.createRow(a + 2);
                  
                     rw2.setHeightInPoints(30);


                    HSSFRow rw4 = shet1.createRow(a + 1);
                    HSSFCell cells1, cells2, cells3, cells4;

                   for (int y = 1; y <=2; y++) {

                        cells1 = rw4.createCell(y);
                        cells1.setCellStyle(style_header);
                        if (y == 1) {
                               cells1.setCellValue(questions1[g]);
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells2 = rw4.createCell(y);
                        cells2.setCellStyle(style_header);
                        if (y ==3) {
                        cells2.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells3 = rw4.createCell(y);

                        cells3.setCellStyle(style_header);
                        if (y == 6) {
                              cells3.setCellValue("Month");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells4 = rw4.createCell(y);

                        cells4.setCellStyle(style_header);
                        if (y == 9) {
                              cells4.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rw4.setHeightInPoints(30);
    a += 1;
 shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));
  
 
//                 if(totalCounts==0) { 

                      
                      
                // end of wbl       
//                       b++;
                // }

                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes'  AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y'))"
                                 + "GROUP BY RiskReductionDetails.QID,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))";
            conn.rs2 = conn.state2.executeQuery(query);
            conn.rs3 = conn.state3.executeQuery(query);
                   
            while(conn.rs3.next()){
           rowcount++;}
            while(conn.rs2.next()){
         counts++;
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
            DOA = conn.rs2.getString(5);
            DIC = conn.rs2.getString(6);
            totalCounts = conn.rs2.getInt(7);
             String enrolDate ="";   
               if(DOA.equals("1")){
                   enrolDate="January ";
               }
               if(DOA.equals("2")){
                   enrolDate="February";
               }
               if(DOA.equals("3")){
                   enrolDate="March ";
               }
               if(DOA.equals("4")){
                   enrolDate="April ";
               }
              if(DOA.equals("5")){
                   enrolDate="May ";
               }
                if(DOA.equals("6")){
                   enrolDate="June";
               }
              if(DOA.equals("7")){
                   enrolDate="July ";
               }
               if(DOA.equals("8")){
                   enrolDate="August ";
               }
               if(DOA.equals("9")){
                   enrolDate="September ";
               }
               if(DOA.equals("10")){
                   enrolDate="October ";
               }
               if(DOA.equals("11")){
                   enrolDate="November";
               }
               if(DOA.equals("12")){
                   enrolDate="December";
               }
            
 
                        a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwi = shet1.createRow(a);

                        HSSFCell cells_1, cells_2, cells_3, cells_4;

                                              rwi.createCell(9).setCellValue(totalCounts);

                      rwi.createCell(3).setCellValue(DIC);
                        rwi.createCell(6).setCellValue(enrolDate);
                     
   
                  total+=  totalCounts;    
                        
                     
      
//                    a += 1;
      System.out.println("rowcount"+rowcount);             
      System.out.println("counts"+counts);             
// shet1.addMergedRegion(new CellRangeAddress(a,a, 2,4));
shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(a, a, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));

                    //System.out.println("VALUE OF J IS :System.out"+j);





//                    a += 1;
//                b+=51;
//                c+=51;
//                d+=51;
//                e+=51;
//                f+=51;
//                i+=51;
                    //p+=20;
            }
             a += 1;
             
                    HSSFRow rwj = shet1.createRow(a);


                    for (int y = 3; y <= 10; ++y) {
//    Cell cell = row.createCell(i);
                        cells2 = rwj.createCell(y);

                        cells2.setCellStyle(stylex);
                        if (y == 3) {
                            cells2.setCellValue("Total");
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 10));
                    cells5 = rwj.createCell(11);
                    cells5.setCellValue(total);
                    cells5.setCellStyle(stylex);

              a += 3;
              
              total=0;
              totalCounts=0;
            }
        }
      
        
        c+=a;
                       HSSFRow rows_2 = shet1.createRow(c);
                    

                     rows_2.setHeightInPoints(30);


                    HSSFRow rows_4 = shet1.createRow(c + 1);
                   
                   for (int y = 1; y <=2; y++) {

                        cells_5 = rows_4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("FP Methods Provided");
                        }
                    }

                  
                for (int y = 3; y <= 5; y++) {
//    Cell cell = row.createCell(i);
                        cells_6 = rows_4.createCell(y);
                        cells_6.setCellStyle(style_header);
                        if (y ==3) {
                        cells_6.setCellValue("DIC");
                        }
                    }
               

//                    cells3 = rw4.createCell(7);
//                    cells3.setCellValue("Activity title");
//                    cells3.setCellStyle(stylex);
                    
                    for (int y = 6; y <= 8; y++) {
//    Cell cell = row.createCell(i);
                        cells_7 = rows_4.createCell(y);

                        cells_7.setCellStyle(style_header);
                        if (y == 6) {
                              cells_7.setCellValue("Month");
                        }
                    }
                    for (int y = 9; y <= 11; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y == 9) {
                              cells_8.setCellValue("FP Method");
                        }
                    }
                    for (int y = 12; y <= 13; y++) {
//    Cell cell = row.createCell(i);
                        cells_8 = rows_4.createCell(y);

                        cells_8.setCellStyle(style_header);
                        if (y ==12) {
                              cells_8.setCellValue("Total");
                        }
                    }
                 
            
//  
                      rows_4.setHeightInPoints(30);
    c += 1;
 shet1.addMergedRegion(new CellRangeAddress(c, c, 1, 2));

shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c, c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12, 13));
 
                      
                 String query3 ="SELECT RiskReductionDetails.RiskReductionID,count(RiskReductionDetails.currentstatus),RiskReductionDetails.QID,RiskReductionDetails.currentstatus,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='J3' AND (UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('depo_%') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('condoms') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('pills') OR UPPER(RiskReductionDetails.currentstatus) "
                         + "LIKE UPPER('jadelle') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('implanon') OR UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('injection'))  AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y'))"
          + "GROUP BY RiskReductionDetails.currentstatus,Enrollment.DICName,MONTH(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"; 

 conn.rs6= conn.state6.executeQuery(query3);
 while(conn.rs6.next()){
 System.out.println("______________________"+conn.rs6.getString(2));
 System.out.println("______________________"+conn.rs6.getString(4));

             id3 = conn.rs6.getString(1);
            ansas3 = conn.rs6.getInt(2);
            QID3 = conn.rs6.getString(3);
            Action3 = conn.rs6.getString(4);
            DOA3 = conn.rs6.getString(5);
            DIC3= conn.rs6.getString(6);
 
 String enrolDate ="";   
               if(DOA3.equals("1")){
                   enrolDate="January ";
               }
               if(DOA3.equals("2")){
                   enrolDate="February";
               }
               if(DOA3.equals("3")){
                   enrolDate="March ";
               }
               if(DOA3.equals("4")){
                   enrolDate="April ";
               }
              if(DOA3.equals("5")){
                   enrolDate="May ";
               }
                if(DOA3.equals("6")){
                   enrolDate="June";
               }
              if(DOA3.equals("7")){
                   enrolDate="July ";
               }
               if(DOA3.equals("8")){
                   enrolDate="August ";
               }
               if(DOA3.equals("9")){
                   enrolDate="September ";
               }
               if(DOA3.equals("10")){
                   enrolDate="October ";
               }
               if(DOA3.equals("11")){
                   enrolDate="November";
               }
               if(DOA3.equals("12")){
                   enrolDate="December";
               }
            
 FPcount+=ansas3;
 
                           c += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(c);
 
                 

                      rwc.createCell(3).setCellValue(DIC3);
                        rwc.createCell(6).setCellValue(enrolDate);
                         rwc.createCell(12).setCellValue(ansas3);
                         rwc.createCell(9).setCellValue(Action3);
shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 5));
shet1.addMergedRegion(new CellRangeAddress(c,c, 6, 8));
shet1.addMergedRegion(new CellRangeAddress(c, c, 9, 11));
shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));
             

  }
 
 
  c+=1  ;
                        
                           HSSFRow rows1 = shet1.createRow(c);


                    for (int y = 3; y <= 11; ++y) {
//    Cell cell = row.createCell(i);
                        cells8 = rows1.createCell(y);

                        cells8.setCellStyle(stylex);
                        if (y == 3) {
                            cells8.setCellValue("Total");
                        }
                    }
                    for (int y = 12; y <= 13; ++y) {
//    Cell cell = row.createCell(i);
                        cells9 = rows1.createCell(y);

                        cells9.setCellStyle(stylex);
                        if (y ==12) {
                            cells9.setCellValue(FPcount);
                        }
                    }
                
            
                    shet1.addMergedRegion(new CellRangeAddress(c, c, 3, 11));
                     shet1.addMergedRegion(new CellRangeAddress(c, c, 12,13));  
//                    cells5 = rows1.createCell(12);
//                    cells5.setCellValue(FPcount);
//                    cells5.setCellStyle(stylex);
                     
                    } 
  
                    
                    
                    
//                    end of semi annual
                    
                    
          // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIC Enrollment.xls");
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
            Logger.getLogger(ServicesProvided.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServicesProvided.class.getName()).log(Level.SEVERE, null, ex);
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
