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
 * @author Maureen
 */
public class Summary extends HttpServlet {

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
       // PrintWriter out = response.getWriter();
        try {
            dbConnect conn = new dbConnect();
            
             HSSFWorkbook wb=new HSSFWorkbook();
          HSSFSheet shet1=wb.createSheet("Enrollments");
          HSSFSheet shet2=wb.createSheet("Risk Assessments");
          HSSFSheet shet3=wb.createSheet("Risk Reductions");
          String startdate="";
          String enddate="";
          String period="";
          
          startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
         // period= "monthly";
          period= request.getParameter("period");
          int qtr=0;
//          startdate= "01/04/2014";
//          enddate= "30/06/2014";
          
        //Styles for the created work Book
          //Code showing the font of the styles
          HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)15);
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
            
            //Setting Column width of the DIC NAMES
           
            
     shet1.setColumnWidth(0, 4000);
    shet1.setColumnWidth(1, 6000); 
    shet1.setColumnWidth(2, 4000);
    shet1.setColumnWidth(3, 4000);
    shet1.setColumnWidth(4, 4000);
    shet1.setColumnWidth(5, 4000);
   
    shet2.setColumnWidth(0, 4000);
    shet2.setColumnWidth(1, 4000); 
    shet2.setColumnWidth(2, 4000);
    shet2.setColumnWidth(3, 4000);
    shet2.setColumnWidth(4, 4000);
  
        
    shet3.setColumnWidth(0, 4000);
    shet3.setColumnWidth(1, 4000); 
    shet3.setColumnWidth(2, 4000);
    shet3.setColumnWidth(3, 4000);
    shet3.setColumnWidth(4, 4000);
   
    shet3.setColumnWidth(17, 2000);
            
       HSSFCell cell1,cell101,cell102,cell103,cell2,cell3,cell31,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16,cell17,cell18,cell19,cell20;      
          HSSFFont font=wb.createFont();    
          font.setFontHeightInPoints((short)12);
    font.setFontName("Cambria");

    font.setBoldweight((short)02);
    font.setColor(HSSFColor.BLACK.index);
    CellStyle style=wb.createCellStyle();
    style.setFont(font);
    style.setWrapText(true);
    style.setFillForegroundColor(HSSFColor.GOLD.index);
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    style.setBottomBorderColor(HSSFColor.BRIGHT_GREEN.index);     
   
    HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.WHITE.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

HSSFFont fontx = wb.createFont();
//fontx.setColor(HSSFColor.DARK_BLUE.index);
      stylex.setFont(fontx);
      stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    
     HSSFFont font_header1=wb.createFont();
    font_header1.setFontHeightInPoints((short)10);
    font_header1.setFontName("Arial Black");
//    font.setItalic(true);
    font_header1.setBoldweight((short)05);
    font_header1.setColor(HSSFColor.BLACK.index);
    CellStyle style_header1=wb.createCellStyle();
    style_header1.setFont(font_header);
    style_header1.setWrapText(true);
    style_header1.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style_header1.getBorderBottom();
style_header1.setBottomBorderColor(HSSFColor.LEMON_CHIFFON.index);
     shet1.addMergedRegion(new CellRangeAddress(0,0,1,7));
      int uniqueidcount=0;
   String dicname="";
   String district="";
   int uniqueidcount1=0;
   String dicname1="";
   String district1="";
   int uniqueidcount2=0;
   String dicname2="";
   String district2="";
    int counter=2;
    int counter1=2;
    int counter2=2;
    String  monthval="";
    int monthcopy=2;
    int monthcopy1=2;
    int monthcopy2=2;
    int monthcopy_1=3;
    int monthcopy_2=3;
    int monthcopy_3=3;
    
    String countys="";
    String months="";
    
      HSSFRow rw1 =shet1.createRow(1);
              cell10=rw1.createCell(2);
              cell15=rw1.createCell(3);
              cell16=rw1.createCell(4);
              cell10.setCellValue("Summary of Enrollments");   
              cell10.setCellStyle(style_header);
              cell15.setCellStyle(style_header);
              cell16.setCellStyle(style_header);
              
              shet1.addMergedRegion(new CellRangeAddress(1,1,2,4)); 
       HSSFRow rw2 =shet2.createRow(1);
             cell11=rw2.createCell(2);
             cell13=rw2.createCell(3);
             cell14=rw2.createCell(4);
             cell11.setCellValue("Summary of Assessments");
                 cell11.setCellStyle(style_header);
                 cell13.setCellStyle(style_header);
                 cell14.setCellStyle(style_header);
                 
                 shet2.addMergedRegion(new CellRangeAddress(1,1,2,4)); 
       HSSFRow rw3 =shet3.createRow(1);
             cell12=rw3.createCell(2);
             cell16=rw3.createCell(3);
             cell17=rw3.createCell(4);
             cell12.setCellValue("Summary of Reductions");
         cell12.setCellStyle(style_header);  
         cell16.setCellStyle(style_header);  
         cell17.setCellStyle(style_header);  
         shet3.addMergedRegion(new CellRangeAddress(1,1,2,4));
   if(period.equals("monthly")){
      
       rw1 =shet1.createRow(2);
              cell101=rw1.createCell(1);
              cell101.setCellValue("FROM "+startdate +"TO"+enddate);   
              cell101.setCellStyle(style_header);  
              cell10=rw1.createCell(2);
              cell10.setCellValue("COUNTY");   
              cell10.setCellStyle(style_header);  
              cell10=rw1.createCell(3);
              cell10.setCellValue("DICNAME");   
              cell10.setCellStyle(style_header);  
              cell10=rw1.createCell(4);
              cell10.setCellValue("TOTAL");   
              cell10.setCellStyle(style_header);  
        rw2 =shet2.createRow(2);
             cell102=rw2.createCell(1);
             cell102.setCellValue("FROM "+startdate +"TO"+enddate);
                 cell102.setCellStyle(style_header);  
             cell11=rw2.createCell(2);
             cell11.setCellValue("COUNTY");
                 cell11.setCellStyle(style_header);  
             cell11=rw2.createCell(3);
             cell11.setCellValue("DICNAME");
                 cell11.setCellStyle(style_header);  
             cell11=rw2.createCell(4);
             cell11.setCellValue("TOTAL");
                 cell11.setCellStyle(style_header);  
       rw3 =shet3.createRow(2);
             cell103=rw3.createCell(2);
             cell103.setCellValue("FROM "+startdate +"TO"+enddate);
         cell103.setCellStyle(style_header);  
             cell12=rw3.createCell(2);
             cell12.setCellValue("COUNTY");
         cell12.setCellStyle(style_header);  
             cell12=rw3.createCell(3);
             cell12.setCellValue("DICNAME");
         cell12.setCellStyle(style_header);  
             cell12=rw3.createCell(4);
             cell12.setCellValue("TOTAL");
         cell12.setCellStyle(style_header);  
   
  
    
    
      
          
          
  
        String enrollments="select count(UniqueID),DICName,District,MONTH(STR_TO_DATE(DOE,'%e/%c/%Y'))from enrollment  where "
                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) GROUP BY MONTH(STR_TO_DATE(DOE,'%e/%c/%Y')),DICName ORDER BY MONTH(STR_TO_DATE(DOE,'%e/%c/%Y'))  ;";
        
        System.out.println(enrollments);
         conn.rs = conn.state.executeQuery(enrollments);
         while(conn.rs.next()){
             counter++;
             
             rw1 =shet1.createRow(counter);
              String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district=conn.rs4.getString(1);
              }
                cell1=rw1.createCell(4);
                cell2=rw1.createCell(3);
                cell3=rw1.createCell(2);
                cell31=rw1.createCell(1);
            String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs.getInt(4) +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            months = conn.rs5.getString(1);
            
            
           if(monthval.equals("")){
              monthval= months;
              System.out.println("88"+monthval +"___"+months);
                System.out.println("88"+monthcopy);
                System.out.println("88"+counter);
                cell31.setCellValue(months);
                shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy=counter;
            
            }
          if(!monthval.equals("") && !monthval.equals(months)){
                 monthval= months;
                System.out.println("!!!"+monthval +"___"+months);
                System.out.println("!!!"+monthcopy);
                System.out.println("!!!!"+counter);
//                cell31.setCellValue(months);
//              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy=counter;
               
            }
            
            
           
            }
            System.out.println(monthcopy+"(((("+counter);
            shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter,1,1));
            monthcopy=counter;
             uniqueidcount=conn.rs.getInt(1);
             dicname=conn.rs.getString(2);
           System.out.println("aaa"+uniqueidcount);
           System.out.println("aaa"+dicname);
           System.out.println("qqqq    "+months +"___"+ conn.rs.getInt(4) );
            
            
             cell1.setCellValue(uniqueidcount);
             cell2.setCellValue(dicname);
             cell3.setCellValue(district);
             cell31.setCellValue(months);
             
             
            cell1.setCellStyle(stylex);  
            cell2.setCellStyle(stylex);  
            cell3.setCellStyle(stylex);  
            cell31.setCellStyle(stylex);  
             
           
         }
        
      String riskassessments="SELECT dicname,count(distinct(riskassessmentmain.Uniqueid)),district, MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y'))  FROM enrollment,riskassessmentmain where (STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))and enrollment.Uniqueid= riskassessmentmain.uniqueid group by dicname,MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) ORDER BY MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) ";  
        
//        String riskassessments="select dicname, count(riskassessmentmain.uniqueid),district,MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y'))from enrollment, riskassessmentmain where enrollment.uniqueid in(select uniqueid from riskassessmentmain "
//                + " where (STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) BETWEEN "
//                + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
//                + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ) group by dicname,MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y'))  ";
        System.out.println(riskassessments);
         conn.rs2 = conn.state2.executeQuery(riskassessments);
        while(conn.rs2.next()){
            counter1++;
           rw2=shet2.createRow(counter1);
          
           cell4=rw2.createCell(4);
   cell5=rw2.createCell(3);
   cell6=rw2.createCell(2);
   cell31=rw2.createCell(1);
//   cell11=rw2.createCell(1);
             uniqueidcount1=conn.rs2.getInt(2);
             dicname1=conn.rs2.getString(1);
//             district1=conn.rs2.getString(3);
             
              String county=" select district from districts where districtid='"+conn.rs2.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district1=conn.rs4.getString(1);
              }
              
               String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs2.getInt(4) +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            months = conn.rs5.getString(1);
            
            
           if(monthval.equals("")){
              monthval= months;
              System.out.println("88"+monthval +"___"+months);
                System.out.println("88"+monthcopy1);
                System.out.println("88"+counter1);
                cell31.setCellValue(months);
                shet2.addMergedRegion(new CellRangeAddress(monthcopy1,counter1-1,1,1));
                monthcopy1=counter1;
            
            }
          if(!monthval.equals("") && !monthval.equals(months)){
                 monthval= months;
                System.out.println("!!!"+monthval +"___"+months);
                System.out.println("!!!"+monthcopy1);
                System.out.println("!!!!"+counter1);
//                cell31.setCellValue(months);
//              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy1=counter1;
               
            }
            
            
           
            }
            System.out.println(monthcopy1+"(((("+counter1);
            shet2.addMergedRegion(new CellRangeAddress(monthcopy1,counter1,1,1));
//             cell11.setCellValue("Summary of Assessments");
             cell4.setCellValue(uniqueidcount1);
             cell5.setCellValue(dicname1);
             cell6.setCellValue(district1);
             cell31.setCellValue(months);
             
             cell4.setCellStyle(stylex);  
            cell5.setCellStyle(stylex);  
            cell6.setCellStyle(stylex);
            cell31.setCellStyle(stylex);
        }
        
        
        
//        String riskreductions="select dicname, count(uniqueid),district from enrollment where uniqueid in(select uniqueid from riskreductionmain "
//                + " where (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN "
//                + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
//                + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ) group by dicname";
        
          String riskreductions="SELECT dicname,count(distinct(riskreductionmain.Uniqueid)),district, MONTH(STR_TO_DATE(DOA,'%e/%c/%Y'))  FROM enrollment,riskreductionmain where (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))and enrollment.Uniqueid= riskreductionmain.uniqueid group by dicname,MONTH(STR_TO_DATE(DOA,'%e/%c/%Y')) ORDER BY MONTH(STR_TO_DATE(DOA,'%e/%c/%Y')) ";  
      System.out.println(riskreductions);
         conn.rs3 = conn.state3.executeQuery(riskreductions);
          while(conn.rs3.next()){
        counter2++;
             uniqueidcount2=conn.rs3.getInt(2);
             dicname2=conn.rs3.getString(1);
             district2=conn.rs3.getString(3);
             rw3=shet3.createRow(counter2);
   
   
                cell7=rw3.createCell(4);
                cell8=rw3.createCell(3);
                cell9=rw3.createCell(2);
                cell31=rw3.createCell(1);
//                cell12=rw3.createCell(1);
             cell7.setCellValue(uniqueidcount2);
             cell8.setCellValue(dicname2);
             
//             cell12.setCellValue("Summary of Risk Reductions");
              String county=" select district from districts where districtid='"+conn.rs3.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district2=conn.rs4.getString(1);
              }
              cell9.setCellValue(district2);
              
           String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs3.getInt(4) +"' ";
           
           System.out.println(getmonths);
           conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            months = conn.rs5.getString(1);
            
            
           if(monthval.equals("")){
              monthval= months;
              System.out.println("88"+monthval +"___"+months);
                System.out.println("88"+monthcopy2);
                System.out.println("88"+counter2);
                cell31.setCellValue(months);
                shet3.addMergedRegion(new CellRangeAddress(monthcopy2,counter2-1,1,1));
                monthcopy2=counter2;
            
            }
          if(!monthval.equals("") && !monthval.equals(months)){
                 monthval= months;
                System.out.println("!!!"+monthval +"___"+months);
                System.out.println("!!!"+monthcopy1);
                System.out.println("!!!!"+counter1);
//                cell31.setCellValue(months);
//              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy2=counter2;
               
            }
            
            
           
            }
            
             System.out.println(monthcopy2+"(((("+counter2);
            shet3.addMergedRegion(new CellRangeAddress(monthcopy2,counter2,1,1));
//             cell11.setCellValue("Summary of Assessments");
           
             cell31.setCellValue(months);
             cell7.setCellStyle(stylex);  
            cell8.setCellStyle(stylex);  
            cell9.setCellStyle(stylex);
            cell31.setCellStyle(stylex);
             System.out.println(uniqueidcount2);
             System.out.println(dicname2);
             System.out.println(district2);
        }
    }
   else if(period.equals("quarterly")){
        
         
       rw1 =shet1.createRow(2);
              cell101=rw1.createCell(1);
              cell101.setCellValue("QUARTER");   
              cell101.setCellStyle(style_header);  
              cell10=rw1.createCell(2);
              cell10.setCellValue("COUNTY");   
              cell10.setCellStyle(style_header);  
              cell10=rw1.createCell(3);
              cell10.setCellValue("DICNAME");   
              cell10.setCellStyle(style_header);  
              cell10=rw1.createCell(4);
              cell10.setCellValue("TOTAL");   
              cell10.setCellStyle(style_header);  
        rw2 =shet2.createRow(2);
             cell102=rw2.createCell(1);
             cell102.setCellValue("QUARTER");
                 cell102.setCellStyle(style_header);  
             cell11=rw2.createCell(2);
             cell11.setCellValue("COUNTY");
                 cell11.setCellStyle(style_header);  
             cell11=rw2.createCell(3);
             cell11.setCellValue("DICNAME");
                 cell11.setCellStyle(style_header);  
             cell11=rw2.createCell(4);
             cell11.setCellValue("TOTAL");
                 cell11.setCellStyle(style_header);  
       rw3 =shet3.createRow(2);
             cell103=rw3.createCell(2);
//             cell103.setCellValue("QUARTER");
         cell103.setCellStyle(style_header);  
             cell12=rw3.createCell(2);
             cell12.setCellValue("COUNTY");
         cell12.setCellStyle(style_header);  
             cell12=rw3.createCell(3);
             cell12.setCellValue("DICNAME");
         cell12.setCellStyle(style_header);  
             cell12=rw3.createCell(4);
             cell12.setCellValue("TOTAL");
         cell12.setCellStyle(style_header);  
   
  
    
    
      
          
          
  
        String enrollments="select count(UniqueID),DICName,District,QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y'))from enrollment  where "
                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) GROUP BY QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y')),DICName ORDER BY QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y'))";
        
        System.out.println(enrollments);
         conn.rs = conn.state.executeQuery(enrollments);
         while(conn.rs.next()){
             counter++;
             
             rw1 =shet1.createRow(counter);
              String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district=conn.rs4.getString(1);
              }
                cell1=rw1.createCell(4);
                cell2=rw1.createCell(3);
                cell3=rw1.createCell(2);
                cell31=rw1.createCell(1);
                
                
                
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
             String getmonths="select quarter_name from quarters where quarter_id='"+qtr+"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            months = conn.rs5.getString(1);
            
            
           if(monthval.equals("")){
              monthval= months;
              System.out.println("88"+monthval +"___"+months);
                System.out.println("88"+monthcopy);
                System.out.println("88"+counter);
                cell31.setCellValue(months);
                shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy=counter;
            
            }
          if(!monthval.equals("") && !monthval.equals(months)){
                 monthval= months;
                System.out.println("!!!"+monthval +"___"+months);
                System.out.println("!!!"+monthcopy);
                System.out.println("!!!!"+counter);
//                cell31.setCellValue(months);
//              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy=counter;
               
            }
            
            
           
            }
            System.out.println(monthcopy+"(((("+counter);
            shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter,1,1));
            monthcopy=counter;
             uniqueidcount=conn.rs.getInt(1);
             dicname=conn.rs.getString(2);
           System.out.println("aaa"+uniqueidcount);
           System.out.println("aaa"+dicname);
           System.out.println("qqqq    "+months +"___"+ conn.rs.getInt(4) );
            
            
             cell1.setCellValue(uniqueidcount);
             cell2.setCellValue(dicname);
             cell3.setCellValue(district);
             cell31.setCellValue(months);
             
             
            cell1.setCellStyle(stylex);  
            cell2.setCellStyle(stylex);  
            cell3.setCellStyle(stylex);  
            cell31.setCellStyle(stylex);  
             
           
         }
        
      String riskassessments="SELECT dicname,count(riskassessmentmain.Uniqueid),"
              + "district, QUARTER(STR_TO_DATE(AssessmentDate,'%e/%c/%Y'))"
              + "  FROM enrollment,riskassessmentmain where"
              + " (STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) "
              + "AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))and enrollment.Uniqueid= riskassessmentmain.uniqueid group by dicname,QUARTER(STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) ORDER BY QUARTER(STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) ";  
        
//        String riskassessments="select dicname, count(riskassessmentmain.uniqueid),district,MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y'))from enrollment, riskassessmentmain where enrollment.uniqueid in(select uniqueid from riskassessmentmain "
//                + " where (STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) BETWEEN "
//                + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
//                + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ) group by dicname,MONTH(STR_TO_DATE(AssessmentDate,'%e/%c/%Y'))  ";
        System.out.println(riskassessments);
         conn.rs2 = conn.state2.executeQuery(riskassessments);
        while(conn.rs2.next()){
            counter1++;
           rw2=shet2.createRow(counter1);
          
           cell4=rw2.createCell(4);
   cell5=rw2.createCell(3);
   cell6=rw2.createCell(2);
   cell31=rw2.createCell(1);
//   cell11=rw2.createCell(1);
             uniqueidcount1=conn.rs2.getInt(2);
             dicname1=conn.rs2.getString(1);
//             district1=conn.rs2.getString(3);
             
              String county=" select district from districts where districtid='"+conn.rs2.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district1=conn.rs4.getString(1);
              }
               if(conn.rs2.getString(4).equals("1")){
                  qtr=2;
                }
                else if(conn.rs2.getString(4).equals("2")){
                  qtr=3;
                }
                else if(conn.rs2.getString(4).equals("3")){
                  qtr=4;
                }
                else if(conn.rs2.getString(4).equals("4")){
                  qtr=1;
                }
               String getmonths="select quarter_name from quarters where quarter_id='"+qtr +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            months = conn.rs5.getString(1);
            
            
           if(monthval.equals("")){
              monthval= months;
              System.out.println("88"+monthval +"___"+months);
                System.out.println("88"+monthcopy1);
                System.out.println("88"+counter1);
                cell31.setCellValue(months);
                shet2.addMergedRegion(new CellRangeAddress(monthcopy_1,counter1-1,1,1));
                monthcopy1=counter1;
            
            }
          if(!monthval.equals("") && !monthval.equals(months)){
                 monthval= months;
                System.out.println("!!!"+monthval +"___"+months);
                System.out.println("!!!"+monthcopy_1);
                System.out.println("!!!!"+counter1);
//                cell31.setCellValue(months);
//              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy_1=counter1;
               
            }
            
            
           
            }
            System.out.println(monthcopy_1+"(((("+counter1);
            shet2.addMergedRegion(new CellRangeAddress(monthcopy_1,counter1,1,1));
//             cell11.setCellValue("Summary of Assessments");
             cell4.setCellValue(uniqueidcount1);
             cell5.setCellValue(dicname1);
             cell6.setCellValue(district1);
             cell31.setCellValue(months);
             
             cell4.setCellStyle(stylex);  
            cell5.setCellStyle(stylex);  
            cell6.setCellStyle(stylex);
            cell31.setCellStyle(stylex);
        }
        
        
        
//        String riskreductions="select dicname, count(uniqueid),district from enrollment where uniqueid in(select uniqueid from riskreductionmain "
//                + " where (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN "
//                + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
//                + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ) group by dicname";
        
          String riskreductions="SELECT dicname,count(riskreductionmain.Uniqueid),"
                  + "district, QUARTER(STR_TO_DATE(DOA,'%e/%c/%Y')) "
                  + " FROM enrollment,riskreductionmain where "
                  + "(STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN "
                  + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
                  + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y'))and "
                  + "enrollment.Uniqueid= riskreductionmain.uniqueid "
                  + "group by dicname,QUARTER(STR_TO_DATE(DOA,'%e/%c/%Y')) "
                  + "ORDER BY QUARTER(STR_TO_DATE(DOA,'%e/%c/%Y')) ";  
      System.out.println(riskreductions);
         conn.rs3 = conn.state3.executeQuery(riskreductions);
          while(conn.rs3.next()){
        counter2++;
             uniqueidcount2=conn.rs3.getInt(2);
             dicname2=conn.rs3.getString(1);
             district2=conn.rs3.getString(3);
             rw3=shet3.createRow(counter2);
   
   
                cell7=rw3.createCell(4);
                cell8=rw3.createCell(3);
                cell9=rw3.createCell(2);
                cell31=rw3.createCell(1);
//                cell12=rw3.createCell(1);
             cell7.setCellValue(uniqueidcount2);
             cell8.setCellValue(dicname2);
             
//             cell12.setCellValue("Summary of Risk Reductions");
              String county=" select district from districts where districtid='"+conn.rs3.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district2=conn.rs4.getString(1);
              }
              cell9.setCellValue(district2);
               if(conn.rs3.getString(4).equals("1")){
                  qtr=2;
                }
                else if(conn.rs3.getString(4).equals("2")){
                  qtr=3;
                }
                else if(conn.rs3.getString(4).equals("3")){
                  qtr=4;
                }
                else if(conn.rs3.getString(4).equals("4")){
                  qtr=1;
                }
             String getmonths="select quarter_name from quarters where quarter_id='"+qtr +"' ";
           
           System.out.println(getmonths);
           conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            months = conn.rs5.getString(1);
            
            
           if(monthval.equals("")){
              monthval= months;
              System.out.println("88"+monthval +"___"+months);
                System.out.println("88"+monthcopy_2);
                System.out.println("88"+counter2);
                cell31.setCellValue(months);
                shet3.addMergedRegion(new CellRangeAddress(monthcopy_2,counter2-1,1,1));
                monthcopy_2=counter2;
            
            }
          if(!monthval.equals("") && !monthval.equals(months)){
                 monthval= months;
                System.out.println("!!!"+monthval +"___"+months);
                System.out.println("!!!"+monthcopy_2);
                System.out.println("!!!!"+counter2);
//                cell31.setCellValue(months);
//              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
                monthcopy_2=counter2;
               
            }
            
            
           
            }
            
             System.out.println(monthcopy2+"(((("+counter2);
            shet3.addMergedRegion(new CellRangeAddress(monthcopy_2,counter2,1,1));
//             cell11.setCellValue("Summary of Assessments");
           
             cell31.setCellValue(months);
             cell7.setCellStyle(stylex);  
            cell8.setCellStyle(stylex);  
            cell9.setCellStyle(stylex);
            cell31.setCellStyle(stylex);
             System.out.println(uniqueidcount2);
             System.out.println(dicname2);
             System.out.println(district2);
        }
        }
//    else{
//    
//    
//    String enrollments="select count(UniqueID),DICName,District from enrollment  where "
//                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
//                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) group by DICName  ";
//        
//        System.out.println(enrollments);
//         conn.rs = conn.state.executeQuery(enrollments);
//         while(conn.rs.next()){
//             counter++;
//             
//             rw1 =shet1.createRow(counter);
//              String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
//              conn.rs4 = conn.state4.executeQuery(county);
//              while(conn.rs4.next()){
//                district=conn.rs4.getString(1);
//              }
//                cell1=rw1.createCell(4);
//                cell2=rw1.createCell(3);
//                cell3=rw1.createCell(2);
//            
//            
//             uniqueidcount=conn.rs.getInt(1);
//             dicname=conn.rs.getString(2);
//           
//           
//             cell1.setCellValue(uniqueidcount);
//             cell2.setCellValue(dicname);
//             cell3.setCellValue(district);
//            
//             
//             
//            cell1.setCellStyle(stylex);  
//            cell2.setCellStyle(stylex);  
//            cell3.setCellStyle(stylex);  
//           
//             
//           
//         }
//        
//        
//        
//        String riskassessments="select dicname, count(enrollment.uniqueid),district from enrollment where uniqueid in(select uniqueid from riskassessmentmain "
//                + " where (STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) BETWEEN "
//                + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
//                + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ) group by dicname  ";
//        
//         conn.rs2 = conn.state2.executeQuery(riskassessments);
//        while(conn.rs2.next()){
//            counter1++;
//           rw2=shet2.createRow(counter1);
//          
//           cell4=rw2.createCell(4);
//   cell5=rw2.createCell(3);
//   cell6=rw2.createCell(2);
////   cell11=rw2.createCell(1);
//             uniqueidcount1=conn.rs2.getInt(2);
//             dicname1=conn.rs2.getString(1);
////             district1=conn.rs2.getString(3);
//             
//              String county=" select district from districts where districtid='"+conn.rs2.getString(3)+"'";
//              conn.rs4 = conn.state4.executeQuery(county);
//              while(conn.rs4.next()){
//                district1=conn.rs4.getString(1);
//              }
////             cell11.setCellValue("Summary of Assessments");
//             cell4.setCellValue(uniqueidcount1);
//             cell5.setCellValue(dicname1);
//             cell6.setCellValue(district1);
//             
//             cell4.setCellStyle(stylex);  
//            cell5.setCellStyle(stylex);  
//            cell6.setCellStyle(stylex);
//        }
//        
//        
//        
//        String riskreductions="select dicname, count(uniqueid),district from enrollment where uniqueid in(select uniqueid from riskreductionmain "
//                + " where (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN "
//                + "(STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND "
//                + "(STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ) group by dicname";
//         conn.rs3 = conn.state3.executeQuery(riskreductions);
//          while(conn.rs3.next()){
//        counter2++;
//             uniqueidcount2=conn.rs3.getInt(2);
//             dicname2=conn.rs3.getString(1);
//             district2=conn.rs3.getString(3);
//             rw3=shet3.createRow(counter2);
//   
//   
//                cell7=rw3.createCell(4);
//                cell8=rw3.createCell(3);
//                cell9=rw3.createCell(2);
////                cell12=rw3.createCell(1);
//             cell7.setCellValue(uniqueidcount2);
//             cell8.setCellValue(dicname2);
//            
////             cell12.setCellValue("Summary of Risk Reductions");
//              String county=" select district from districts where districtid='"+conn.rs3.getString(3)+"'";
//              conn.rs4 = conn.state4.executeQuery(county);
//              while(conn.rs4.next()){
//                district2=conn.rs4.getString(1);
//              }
//              
//               cell9.setCellValue(district2);
//             cell7.setCellStyle(stylex);  
//            cell8.setCellStyle(stylex);  
//            cell9.setCellStyle(stylex);
//             System.out.println(uniqueidcount2);
//             System.out.println(dicname2);
//             System.out.println(district2);
//        }
//          
//          
//          
//          }
          
          
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=Summary.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Summary.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Summary.class.getName()).log(Level.SEVERE, null, ex);
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
