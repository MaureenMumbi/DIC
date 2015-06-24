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
 * @author Hare Cheka Arnold
 */
public class RiskAssesmentReport extends HttpServlet {
HttpSession session;
String county_name,county_id,dic_name,dic_id,quarter_id,excel_quarter,report_type,excel_month,month_id,report_year,dic_name1;
String period [],county [],year_quarter [],year_months[],dicnaming[];
int dic_pos,county_pos,dc,found;
int found2,found3,found4,found5,found6,found7;
int checker;
//Declaring the array list
    ArrayList total_found = new ArrayList();
    ArrayList total_found2 = new ArrayList();
    ArrayList total_found3 = new ArrayList();        
    ArrayList total_found4 = new ArrayList();
    ArrayList total_found5 = new ArrayList();
    ArrayList total_found6 = new ArrayList();
    ArrayList total_found7 = new ArrayList();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        dbConnect conn = new dbConnect();
        report_year = request.getParameter("year");
        report_type = request.getParameter("type");
        System.out.println(report_type);
        year_months=request.getParameterValues("months");
        dicnaming=request.getParameterValues("dic_name");
        int dic_size = dicnaming.length;
//Clearing the Arraylists
//        total_found.clear();
//        total_found2.clear();
//        total_found3.clear();
//        total_found4.clear();
//        total_found5.clear();
//        total_found6.clear();
//        total_found7.clear();
        
         year_quarter=request.getParameterValues("Quarter");
         if (report_type.equals("2")){
         int size = year_quarter.length;
         checker=0;   
           
        period=request.getParameterValues("period");
        
        int row_starter = 3;
        int year_quarter_index = 0;
         HSSFWorkbook wb=new HSSFWorkbook();
  HSSFSheet shet1=wb.createSheet();
     HSSFRow rw1=shet1.createRow(row_starter + 1);
       HSSFRow rw0=shet1.createRow(row_starter);
        HSSFRow rw8=shet1.createRow(row_starter - 2);
         HSSFRow rw44=shet1.createRow(row_starter - 1);
  for( int q=0;q<size;q++) {
       
       
       quarter_id = year_quarter[q];
       county_pos=3;
        dic_pos=3;
        dc=0;
        found=found2=found3=found4=found5=found6=0;
   
   HSSFRow rw2=shet1.createRow(row_starter + 3);
   HSSFRow rw3=shet1.createRow(row_starter + 4);
   HSSFRow rw4=shet1.createRow(row_starter + 5);
   HSSFRow rw5=shet1.createRow(row_starter + 6);
   HSSFRow rw6=shet1.createRow(row_starter + 7);
   HSSFRow rw7=shet1.createRow(row_starter + 8);
   HSSFRow rw9=shet1.createRow(row_starter + 2);
   HSSFRow rw10=shet1.createRow(row_starter + 9);
  
   
   //Font_header Style
   HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)05);
    font_header.setColor(HSSFColor.BLACK.index);
   
   //Setting Styles For Excel known as Style_header
   CellStyle style_header=wb.createCellStyle();
    style_header.setFont(font_header);
    //style_header.setWrapText(true);
    style_header.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style_header.setBorderBottom(CellStyle.BORDER_THIN);
    style_header.setBottomBorderColor(HSSFColor.BLACK.index);
    style_header.setBorderLeft(CellStyle.BORDER_THIN);
    style_header.setAlignment(CellStyle.ALIGN_CENTER);
    style_header.setLeftBorderColor(HSSFColor.BLACK.index);
    style_header.setBorderRight(CellStyle.BORDER_THIN);
    style_header.setRightBorderColor(HSSFColor.BLACK.index);
    style_header.setBorderTop(CellStyle.BORDER_THIN);
    style_header.setTopBorderColor(HSSFColor.BLACK.index);
//style_header.getBorderBottom();
//style_header.setBottomBorderColor(HSSFColor.LEMON_CHIFFON.index);



//Font for cells
HSSFFont font=wb.createFont();
    font.setFontHeightInPoints((short)12);
    font.setFontName("Cambria");
//    font.setItalic(true);
    font.setBoldweight((short)05);
    font.setColor(HSSFColor.BLACK.index);
    
    //Excel Styling known as Style
    CellStyle style=wb.createCellStyle();
    style.setFont(font);
    style.setWrapText(true);
    style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style.setBottomBorderColor(HSSFColor.BRIGHT_GREEN.index);
style.setBorderBottom(CellStyle.BORDER_THIN);
    style.setBottomBorderColor(HSSFColor.BLACK.index);
    style.setBorderLeft(CellStyle.BORDER_THIN);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setLeftBorderColor(HSSFColor.BLACK.index);
    style.setBorderRight(CellStyle.BORDER_THIN);
    style.setRightBorderColor(HSSFColor.BLACK.index);
    style.setBorderTop(CellStyle.BORDER_THIN);
    style.setTopBorderColor(HSSFColor.BLACK.index);

//Excel Stylings for cells known as Stylex
 HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.GOLD.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylex.setWrapText(true);
stylex.setBorderBottom(CellStyle.BORDER_THIN);
    stylex.setBottomBorderColor(HSSFColor.BLACK.index);
    stylex.setBorderLeft(CellStyle.BORDER_THICK);
    stylex.setAlignment(CellStyle.ALIGN_CENTER);
    stylex.setLeftBorderColor(HSSFColor.BLACK.index);
    stylex.setBorderRight(CellStyle.BORDER_THICK);
    stylex.setRightBorderColor(HSSFColor.BLACK.index);
    stylex.setBorderTop(CellStyle.BORDER_THIN);
    stylex.setTopBorderColor(HSSFColor.BLACK.index);

stylex.setFont(font);

//Excel Stylings for cells known as stylex_risk
 HSSFCellStyle stylex_risk = wb.createCellStyle();
stylex_risk.setFillForegroundColor(HSSFColor.WHITE.index);
stylex_risk.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylex_risk.setWrapText(true);
stylex_risk.setBorderBottom(CellStyle.BORDER_THIN);
    stylex_risk.setBottomBorderColor(HSSFColor.BLACK.index);
    stylex_risk.setBorderLeft(CellStyle.BORDER_THIN);
    stylex_risk.setLeftBorderColor(HSSFColor.BLACK.index);
    stylex_risk.setBorderRight(CellStyle.BORDER_THIN);
    stylex_risk.setRightBorderColor(HSSFColor.BLACK.index);
    stylex_risk.setBorderTop(CellStyle.BORDER_THIN);
    stylex_risk.setTopBorderColor(HSSFColor.BLACK.index);

stylex.setFont(font);

//Excel Stylings for cells known as stylex_risk_data
 HSSFCellStyle stylex_risk_data = wb.createCellStyle();
stylex_risk_data.setFillForegroundColor(HSSFColor.WHITE.index);
stylex_risk_data.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylex_risk_data.setWrapText(true);
stylex_risk_data.setBorderBottom(CellStyle.BORDER_THIN);
    stylex_risk_data.setBottomBorderColor(HSSFColor.BLACK.index);
    stylex_risk_data.setBorderLeft(CellStyle.BORDER_THIN);
    stylex_risk_data.setLeftBorderColor(HSSFColor.BLACK.index);
    stylex_risk_data.setBorderRight(CellStyle.BORDER_THIN);
    stylex_risk_data.setRightBorderColor(HSSFColor.BLACK.index);
    stylex_risk_data.setBorderTop(CellStyle.BORDER_THIN);
    stylex_risk_data.setTopBorderColor(HSSFColor.BLACK.index);

stylex.setFont(font);
   
   HSSFCell cell08 = rw0.createCell(2);    
             cell08.setCellValue("RISK ASSESSED");
             cell08.setCellStyle(stylex);
   
   //Merging cells for the Topic of Risk Assessed
   shet1.addMergedRegion(new CellRangeAddress(3,4,2,2));
   
   //Setting Height Poiints Of Rows Styling
   rw0.setHeightInPoints(25);
   rw1.setHeightInPoints(30);
   rw2.setHeightInPoints(25);
   rw3.setHeightInPoints(25);
   rw4.setHeightInPoints(25);
   rw5.setHeightInPoints(25);
   rw6.setHeightInPoints(25);
   rw7.setHeightInPoints(25);
   rw8.setHeightInPoints(30);
   
   //Setting Column2 Width 
   shet1.setColumnWidth(2, 8000);
   
   //Code for showing the quarters
   String quarter_show = "SELECT * FROM quarters where QUARTER_ID ='"+quarter_id+"'";
   System.out.println("Query for picked quarter:   "+quarter_show);
   conn.rs5=conn.state6.executeQuery(quarter_show);
   if(conn.rs5.next()==true){
       excel_quarter = conn.rs5.getString(2);
      System.out.println("Quarter Printed in Excel    :   "+excel_quarter);
   }
   //Creating cell for the excel quarter
   HSSFCell cell100 = rw9.createCell(2);    
             cell100.setCellValue(excel_quarter+" "+report_year+"");
             cell100.setCellStyle(style_header);
    
   HSSFCell cell02 = rw2.createCell(2);    
             cell02.setCellValue("STI signs");
             cell02.setCellStyle(stylex_risk);
             HSSFCell cell03 = rw3.createCell(2);    
             cell03.setCellValue("Unmet Needs(Family Planning)");
             cell03.setCellStyle(stylex_risk);
             HSSFCell cell04 = rw4.createCell(2);    
             cell04.setCellValue("Sexual Gender Violence Experience");
             cell04.setCellStyle(stylex_risk);
             HSSFCell cell05 = rw5.createCell(2);    
             cell05.setCellValue("Vaginal Sex:");
             cell05.setCellStyle(stylex_risk);
             HSSFCell cell06 = rw6.createCell(2);    
             cell06.setCellValue("Oral Sex:");
             cell06.setCellStyle(stylex_risk);
             HSSFCell cell07 = rw7.createCell(2);    
             cell07.setCellValue("Anal Sex:");
             cell07.setCellStyle(stylex_risk);
             HSSFCell cell23 = rw10.createCell(2);    
             cell23.setCellValue("TOTAL:");
             cell23.setCellStyle(stylex_risk);
           // autoSizeColumn(int 2, boolean useMergedCells);
//             HSSFCell cell08 = rw1.createCell(2);    
//             cell08.setCellValue(""); 
//             HSSFCell cell09 = rw1.createCell(2);    
//             cell09.setCellValue(""); 
            for( int m=0;m<dic_size;m++) {
       
       
       dic_name1 = dicnaming[m];  
        String county_selector="SELECT * FROM districts WHERE DistrictID = '"+dic_name1+"'";
        conn.rs=conn.state.executeQuery(county_selector);
        while(conn.rs.next()){
          county_name=conn.rs.getString(2);
            
            String dic_selector="SELECT * FROM dicname WHERE DistrictID='"+dic_name1+"'";
            conn.rs1=conn.state1.executeQuery(dic_selector);
            while(conn.rs1.next()){
               dic_name=conn.rs1.getString(2);
               
            HSSFCell cell0 = rw1.createCell(dic_pos);    
             cell0.setCellValue(dic_name);
             cell0.setCellStyle(stylex);
           
           System.out.println("Here dic   :  "+dic_name);  
             String dom1="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='M1' && riskassessmentdetails.DirectAnswers='Yes')  || (riskassessmentdetails.QuestionID='M2' && riskassessmentdetails.DirectAnswers='Yes') || "
                     + " (riskassessmentdetails.QuestionID='M3' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='M4' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='M5' && riskassessmentdetails.DirectAnswers='Yes') ||"
                     + " (riskassessmentdetails.QuestionID='M6' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='M7' && riskassessmentdetails.DirectAnswers='Yes')) && riskassessmentmain.Quarter='"+quarter_id+"' && riskassessmentmain.Pefar_year='"+report_year+"' ";   
            System.out.println("The query run is  :  "+dom1);
             System.out.println("Here quarter id   :  "+quarter_id);    
             conn.rs2=conn.state2.executeQuery(dom1);
                if(conn.rs2.next()==true){
                    found=conn.rs2.getInt(1);
                }
              if(found>0) {
             HSSFCell cell021 = rw2.createCell(dic_pos);    
             cell021.setCellValue(found);
             cell021.setCellStyle(stylex_risk_data);
              }
              if(found==0) {
             HSSFCell cell021 = rw2.createCell(dic_pos);    
             cell021.setCellValue(" ");
             cell021.setCellStyle(stylex_risk_data);
              }
              
              String dom2="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='P1' && riskassessmentdetails.DirectAnswers='No')  || (riskassessmentdetails.QuestionID='P2' && riskassessmentdetails.DirectAnswers='No') || "
                     + " (riskassessmentdetails.QuestionID='P3' && riskassessmentdetails.DirectAnswers='No')) && riskassessmentmain.Quarter='"+quarter_id+"' && riskassessmentmain.Pefar_year='"+report_year+"' "; 
               
                 conn.rs2=conn.state2.executeQuery(dom2);
                if(conn.rs2.next()==true){
                    found2=conn.rs2.getInt(1);
                }
              if(found2>0) {
             HSSFCell cell022 = rw3.createCell(dic_pos);    
             cell022.setCellValue(found2);
             cell022.setCellStyle(stylex_risk_data);
              }
              if(found2==0) {
             HSSFCell cell022 = rw3.createCell(dic_pos);    
             cell022.setCellValue(" ");
             cell022.setCellStyle(stylex_risk_data);
              }
              
              String dom3="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='T1' && riskassessmentdetails.DirectAnswers='Yes')  || (riskassessmentdetails.QuestionID='T3' && riskassessmentdetails.DirectAnswers='Yes') || "
                     + " (riskassessmentdetails.QuestionID='T5' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='T7' && riskassessmentdetails.DirectAnswers='Yes') || "
                     + " (riskassessmentdetails.QuestionID='T9' && riskassessmentdetails.DirectAnswers='Yes')) && riskassessmentmain.Quarter='"+quarter_id+"' && riskassessmentmain.Pefar_year='"+report_year+"' ";   
                 conn.rs2=conn.state2.executeQuery(dom3);
                if(conn.rs2.next()==true){
                    found3=conn.rs2.getInt(1);
                }
              if(found3>0) {
             HSSFCell cell023 = rw4.createCell(dic_pos);    
             cell023.setCellValue(found3);
             cell023.setCellStyle(stylex_risk_data);
              }
              if(found3==0) {
             HSSFCell cell023 = rw4.createCell(dic_pos);    
             cell023.setCellValue(" ");
             cell023.setCellStyle(stylex_risk_data);
              }
              
              String dom4="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='J1' && riskassessmentdetails.DirectAnswers='3') || ( riskassessmentdetails.QuestionID='J1' && riskassessmentdetails.DirectAnswers='4') ||(riskassessmentdetails.QuestionID='J1' &&  riskassessmentdetails.DirectAnswers='5')) && riskassessmentmain.Quarter='"+quarter_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom4);
                if(conn.rs2.next()==true){
                    found4=conn.rs2.getInt(1);
                }
              if(found4>0) {
             HSSFCell cell024 = rw5.createCell(dic_pos);    
             cell024.setCellValue(found4);
             cell024.setCellStyle(stylex_risk_data);
              }
              if(found4==0) {
             HSSFCell cell024 = rw5.createCell(dic_pos);    
             cell024.setCellValue(" ");
             cell024.setCellStyle(stylex_risk_data);
              }
              String dom5="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='J2' && riskassessmentdetails.DirectAnswers='3') || ( riskassessmentdetails.QuestionID='J2' && riskassessmentdetails.DirectAnswers='4') ||(riskassessmentdetails.QuestionID='J2' &&  riskassessmentdetails.DirectAnswers='5')) && riskassessmentmain.Quarter='"+quarter_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom5);
                if(conn.rs2.next()==true){
                    found5=conn.rs2.getInt(1);
                }
             if(found5>0) {
             HSSFCell cell025 = rw6.createCell(dic_pos);    
             cell025.setCellValue(found5);
             cell025.setCellStyle(stylex_risk_data);
              } 
             if(found5==0) {
             HSSFCell cell025 = rw6.createCell(dic_pos);    
             cell025.setCellValue(" ");
             cell025.setCellStyle(stylex_risk_data);
              }
              String dom6="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='J' && riskassessmentdetails.DirectAnswers='3') || ( riskassessmentdetails.QuestionID='J' && riskassessmentdetails.DirectAnswers='4') ||(riskassessmentdetails.QuestionID='J' &&  riskassessmentdetails.DirectAnswers='5')) && riskassessmentmain.Quarter='"+quarter_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom6);
                if(conn.rs2.next()==true){
                    found6=conn.rs2.getInt(1);
                }
              if(found6>0) {
             HSSFCell cell026 = rw7.createCell(dic_pos);    
             cell026.setCellValue(found6);
             cell026.setCellStyle(stylex_risk_data);
              } 
              if(found6==0) {
             HSSFCell cell026 = rw7.createCell(dic_pos);    
             cell026.setCellValue(" ");
             cell026.setCellStyle(stylex_risk_data);
              }
              found7=found + found2+found3+found4+found5+found6;
              if (found7==0){
              HSSFCell cell24 = rw10.createCell(dic_pos);    
             cell24.setCellValue(" ");
             cell24.setCellStyle(stylex_risk_data);
              }
              if (found7>0){
              HSSFCell cell24 = rw10.createCell(dic_pos);    
             cell24.setCellValue(found7);
             cell24.setCellStyle(stylex_risk_data);
              }
              //Code to do totals of the counts of the Risk Assessed
//              total_found.add(found);
//              total_found2.add(found2);
//              total_found3.add(found3);
//              total_found4.add(found4);
//              total_found5.add(found5);
//              total_found6.add(found6);
//              total_found7.add(found7);
              
              found=found2=found3=found4=found5=found6=0;
              
               dic_pos++;
            dc++;
            }
            
           if(dc>0 && checker==0){
            HSSFCell cell0 = rw0.createCell(county_pos);    
             cell0.setCellValue(county_name);
             cell0.setCellStyle(style);
         int end_merge=county_pos+dc-1;
            shet1.addMergedRegion(new CellRangeAddress(3,3,county_pos,end_merge));
            county_pos+=dc;
            //Merging cells to show the title report
            HSSFCell cell9 = rw8.createCell(2);    
             cell9.setCellValue("RISK ASSESSMENT REPORT");
             cell9.setCellStyle(style_header);
             shet1.addMergedRegion(new CellRangeAddress(1,1,2,end_merge));
             
             //Writing the PEPFAR YEAR
             HSSFCell cell44 = rw44.createCell(2);    
             cell44.setCellValue("PEPFAR YEAR "+report_year+"");
             cell44.setCellStyle(style_header);
             shet1.addMergedRegion(new CellRangeAddress(2,2,2,end_merge));
             
           }
           dc=0;
           }
  }
           row_starter += 8;
            year_quarter_index ++;
        
        //Here the code to reset row starter
        
       
        dic_pos = 0;
        county_pos = 0;
        dc = 0;
        found=found2=found3=found4=found5=found6=0;
       checker++; 
  }
         
    System.out.println("Quarterly Report Generated");     
    // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIC_RiskAssesment_Quarter_Report.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
    }
         //Code for report if report type months
         else{
         int size = year_months.length;
         checker=0;   
           
        period=request.getParameterValues("period");
        
        int row_starter = 3;
        int year_month_index = 0;
        int end_merge = 0;
         HSSFWorkbook wb=new HSSFWorkbook();
  HSSFSheet shet1=wb.createSheet();
     HSSFRow rw1=shet1.createRow(row_starter + 1);
       HSSFRow rw0=shet1.createRow(row_starter);
        HSSFRow rw8=shet1.createRow(row_starter - 2);
        HSSFRow rw44=shet1.createRow(row_starter - 1);
  for( int q=0;q<size;q++) {
       
       
       month_id = year_months[q];
       county_pos=3;
        dic_pos=3;
        dc=0;
        found=found2=found3=found4=found5=found6=0;
   
   HSSFRow rw2=shet1.createRow(row_starter + 3);
   HSSFRow rw3=shet1.createRow(row_starter + 4);
   HSSFRow rw4=shet1.createRow(row_starter + 5);
   HSSFRow rw5=shet1.createRow(row_starter + 6);
   HSSFRow rw6=shet1.createRow(row_starter + 7);
   HSSFRow rw7=shet1.createRow(row_starter + 8);
   HSSFRow rw9=shet1.createRow(row_starter + 2);
   HSSFRow rw10=shet1.createRow(row_starter + 9);
  
   
   //Font_header Style
   HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)05);
    font_header.setColor(HSSFColor.BLACK.index);
   
   //Setting Styles For Excel known as Style_header
   CellStyle style_header=wb.createCellStyle();
    style_header.setFont(font_header);
    //style_header.setWrapText(true);
    style_header.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style_header.setBorderBottom(CellStyle.BORDER_THIN);
    style_header.setBottomBorderColor(HSSFColor.BLACK.index);
    style_header.setBorderLeft(CellStyle.BORDER_THIN);
    style_header.setAlignment(CellStyle.ALIGN_CENTER);
    style_header.setLeftBorderColor(HSSFColor.BLACK.index);
    style_header.setBorderRight(CellStyle.BORDER_THIN);
    style_header.setRightBorderColor(HSSFColor.BLACK.index);
    style_header.setBorderTop(CellStyle.BORDER_THIN);
    style_header.setTopBorderColor(HSSFColor.BLACK.index);
//style_header.getBorderBottom();
//style_header.setBottomBorderColor(HSSFColor.LEMON_CHIFFON.index);



//Font for cells
HSSFFont font=wb.createFont();
    font.setFontHeightInPoints((short)12);
    font.setFontName("Cambria");
//    font.setItalic(true);
    font.setBoldweight((short)05);
    font.setColor(HSSFColor.BLACK.index);
    
    //Excel Styling known as Style
    CellStyle style=wb.createCellStyle();
    style.setFont(font);
    style.setWrapText(true);
    style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style.setBottomBorderColor(HSSFColor.BRIGHT_GREEN.index);
style.setBorderBottom(CellStyle.BORDER_THIN);
    style.setBottomBorderColor(HSSFColor.BLACK.index);
    style.setBorderLeft(CellStyle.BORDER_THIN);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setLeftBorderColor(HSSFColor.BLACK.index);
    style.setBorderRight(CellStyle.BORDER_THIN);
    style.setRightBorderColor(HSSFColor.BLACK.index);
    style.setBorderTop(CellStyle.BORDER_THIN);
    style.setTopBorderColor(HSSFColor.BLACK.index);

//Excel Stylings for cells known as Stylex
 HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.GOLD.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylex.setWrapText(true);
stylex.setBorderBottom(CellStyle.BORDER_THIN);
    stylex.setBottomBorderColor(HSSFColor.BLACK.index);
    stylex.setBorderLeft(CellStyle.BORDER_THICK);
    stylex.setAlignment(CellStyle.ALIGN_CENTER);
    stylex.setLeftBorderColor(HSSFColor.BLACK.index);
    stylex.setBorderRight(CellStyle.BORDER_THICK);
    stylex.setRightBorderColor(HSSFColor.BLACK.index);
    stylex.setBorderTop(CellStyle.BORDER_THIN);
    stylex.setTopBorderColor(HSSFColor.BLACK.index);

stylex.setFont(font);

//Excel Stylings for cells known as stylex_risk
 HSSFCellStyle stylex_risk = wb.createCellStyle();
stylex_risk.setFillForegroundColor(HSSFColor.WHITE.index);
stylex_risk.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylex_risk.setWrapText(true);
stylex_risk.setBorderBottom(CellStyle.BORDER_THIN);
    stylex_risk.setBottomBorderColor(HSSFColor.BLACK.index);
    stylex_risk.setBorderLeft(CellStyle.BORDER_THIN);
    stylex_risk.setLeftBorderColor(HSSFColor.BLACK.index);
    stylex_risk.setBorderRight(CellStyle.BORDER_THIN);
    stylex_risk.setRightBorderColor(HSSFColor.BLACK.index);
    stylex_risk.setBorderTop(CellStyle.BORDER_THIN);
    stylex_risk.setTopBorderColor(HSSFColor.BLACK.index);

stylex.setFont(font);

//Excel Stylings for cells known as stylex_risk_data
 HSSFCellStyle stylex_risk_data = wb.createCellStyle();
stylex_risk_data.setFillForegroundColor(HSSFColor.WHITE.index);
stylex_risk_data.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylex_risk_data.setWrapText(true);
stylex_risk_data.setBorderBottom(CellStyle.BORDER_THIN);
    stylex_risk_data.setBottomBorderColor(HSSFColor.BLACK.index);
    stylex_risk_data.setBorderLeft(CellStyle.BORDER_THIN);
    stylex_risk_data.setLeftBorderColor(HSSFColor.BLACK.index);
    stylex_risk_data.setBorderRight(CellStyle.BORDER_THIN);
    stylex_risk_data.setRightBorderColor(HSSFColor.BLACK.index);
    stylex_risk_data.setBorderTop(CellStyle.BORDER_THIN);
    stylex_risk_data.setTopBorderColor(HSSFColor.BLACK.index);

stylex.setFont(font);
   
   HSSFCell cell08 = rw0.createCell(2);    
             cell08.setCellValue("RISK ASSESSED");
             cell08.setCellStyle(stylex);
   
   //Merging cells for the Topic of Risk Assessed
   shet1.addMergedRegion(new CellRangeAddress(3,4,2,2));
   
   //Setting Height Poiints Of Rows Styling
   rw0.setHeightInPoints(25);
   rw1.setHeightInPoints(30);
   rw2.setHeightInPoints(25);
   rw3.setHeightInPoints(25);
   rw4.setHeightInPoints(25);
   rw5.setHeightInPoints(25);
   rw6.setHeightInPoints(25);
   rw7.setHeightInPoints(25);
   rw8.setHeightInPoints(30);
   
   //Setting Column2 Width 
   shet1.setColumnWidth(2, 8000);
   
   //Code for showing the quarters
   String quarter_show = "SELECT * FROM months where MONTH_ID ='"+month_id+"'";
   System.out.println("Query for picked month:   "+quarter_show);
   conn.rs5=conn.state6.executeQuery(quarter_show);
   if(conn.rs5.next()==true){
       excel_month = conn.rs5.getString(2);
      System.out.println("Quarter Printed in Excel    :   "+excel_month);
   }
   //Creating cell for the excel quarter
   HSSFCell cell100 = rw9.createCell(2);    
             cell100.setCellValue(excel_month+" "+report_year+"");
             cell100.setCellStyle(style_header);
    
   HSSFCell cell02 = rw2.createCell(2);    
             cell02.setCellValue("STI signs");
             cell02.setCellStyle(stylex_risk);
             HSSFCell cell03 = rw3.createCell(2);    
             cell03.setCellValue("Unmet Needs(Family Planning)");
             cell03.setCellStyle(stylex_risk);
             HSSFCell cell04 = rw4.createCell(2);    
             cell04.setCellValue("Sexual Gender Violence Experience");
             cell04.setCellStyle(stylex_risk);
             HSSFCell cell05 = rw5.createCell(2);    
             cell05.setCellValue("Vaginal Sex:");
             cell05.setCellStyle(stylex_risk);
             HSSFCell cell06 = rw6.createCell(2);    
             cell06.setCellValue("Oral Sex:");
             cell06.setCellStyle(stylex_risk);
             HSSFCell cell07 = rw7.createCell(2);    
             cell07.setCellValue("Anal Sex:");
             cell07.setCellStyle(stylex_risk);
             HSSFCell cell23 = rw10.createCell(2);    
             cell23.setCellValue("TOTAL:");
             cell23.setCellStyle(stylex_risk);
           // autoSizeColumn(int 2, boolean useMergedCells);
//             HSSFCell cell08 = rw1.createCell(2);    
//             cell08.setCellValue(""); 
//             HSSFCell cell09 = rw1.createCell(2);    
//             cell09.setCellValue("");
             
        for( int m=0;m<dic_size;m++) {
       
       
       dic_name1 = dicnaming[m];  
        String county_selector="SELECT * FROM districts WHERE DistrictID = '"+dic_name1+"'";
        conn.rs=conn.state.executeQuery(county_selector);
        while(conn.rs.next()){
          county_name=conn.rs.getString(2);
            
            String dic_selector="SELECT * FROM dicname WHERE DistrictID='"+dic_name1+"'";
            conn.rs1=conn.state1.executeQuery(dic_selector);
            while(conn.rs1.next()){
               dic_name=conn.rs1.getString(2);
               
            HSSFCell cell0 = rw1.createCell(dic_pos);    
             cell0.setCellValue(dic_name);
             cell0.setCellStyle(stylex);
           
           System.out.println("Here dic   :  "+dic_name);  
             String dom1="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='M1' && riskassessmentdetails.DirectAnswers='Yes')  || (riskassessmentdetails.QuestionID='M2' && riskassessmentdetails.DirectAnswers='Yes') || "
                     + " (riskassessmentdetails.QuestionID='M3' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='M4' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='M5' && riskassessmentdetails.DirectAnswers='Yes') ||"
                     + " (riskassessmentdetails.QuestionID='M6' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='M7' && riskassessmentdetails.DirectAnswers='Yes')) && riskassessmentmain.Month='"+month_id+"' && riskassessmentmain.Pefar_year='"+report_year+"' ";   
            System.out.println("The query run is  :  "+dom1);
             System.out.println("Here quarter id   :  "+month_id);    
             conn.rs2=conn.state2.executeQuery(dom1);
                if(conn.rs2.next()==true){
                    found=conn.rs2.getInt(1);
                }
              if(found>0) {
             HSSFCell cell021 = rw2.createCell(dic_pos);    
             cell021.setCellValue(found);
             cell021.setCellStyle(stylex_risk_data);
              } 
              if(found==0) {
             HSSFCell cell021 = rw2.createCell(dic_pos);    
             cell021.setCellValue(" ");
             cell021.setCellStyle(stylex_risk_data);
              }
              String dom2="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='P1' && riskassessmentdetails.DirectAnswers='No')  || (riskassessmentdetails.QuestionID='P2' && riskassessmentdetails.DirectAnswers='No') || "
                     + " (riskassessmentdetails.QuestionID='P3' && riskassessmentdetails.DirectAnswers='No')) && riskassessmentmain.Month='"+month_id+"' && riskassessmentmain.Pefar_year='"+report_year+"' "; 
               
                 conn.rs2=conn.state2.executeQuery(dom2);
                if(conn.rs2.next()==true){
                    found2=conn.rs2.getInt(1);
                }
              if(found2>0) {
             HSSFCell cell022 = rw3.createCell(dic_pos);    
             cell022.setCellValue(found2);
             cell022.setCellStyle(stylex_risk_data);
              } 
              if(found2==0) {
             HSSFCell cell022 = rw3.createCell(dic_pos);    
             cell022.setCellValue(" ");
             cell022.setCellStyle(stylex_risk_data);
              }
              
              String dom3="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='T1' && riskassessmentdetails.DirectAnswers='Yes')  || (riskassessmentdetails.QuestionID='T3' && riskassessmentdetails.DirectAnswers='Yes') || "
                     + " (riskassessmentdetails.QuestionID='T5' && riskassessmentdetails.DirectAnswers='Yes') || (riskassessmentdetails.QuestionID='T7' && riskassessmentdetails.DirectAnswers='Yes') || "
                     + " (riskassessmentdetails.QuestionID='T9' && riskassessmentdetails.DirectAnswers='Yes')) && riskassessmentmain.Month='"+month_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom3);
                if(conn.rs2.next()==true){
                    found3=conn.rs2.getInt(1);
                }
              if(found3>0) {
             HSSFCell cell023 = rw4.createCell(dic_pos);    
             cell023.setCellValue(found3);
             cell023.setCellStyle(stylex_risk_data);
              } 
              if(found3==0) {
             HSSFCell cell023 = rw4.createCell(dic_pos);    
             cell023.setCellValue(" ");
             cell023.setCellStyle(stylex_risk_data);
              }
              
              String dom4="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='J1' && riskassessmentdetails.DirectAnswers='3') || ( riskassessmentdetails.QuestionID='J1' && riskassessmentdetails.DirectAnswers='4') ||(riskassessmentdetails.QuestionID='J1' &&  riskassessmentdetails.DirectAnswers='5')) && riskassessmentmain.Month='"+month_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom4);
                if(conn.rs2.next()==true){
                    found4=conn.rs2.getInt(1);
                }
              if(found4>0) {
             HSSFCell cell024 = rw5.createCell(dic_pos);    
             cell024.setCellValue(found4);
             cell024.setCellStyle(stylex_risk_data);
              } 
              if(found4==0) {
             HSSFCell cell024 = rw5.createCell(dic_pos);    
             cell024.setCellValue(" ");
             cell024.setCellStyle(stylex_risk_data);
              }
              String dom5="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='J2' && riskassessmentdetails.DirectAnswers='3') || ( riskassessmentdetails.QuestionID='J2' && riskassessmentdetails.DirectAnswers='4') ||(riskassessmentdetails.QuestionID='J2' &&  riskassessmentdetails.DirectAnswers='5')) && riskassessmentmain.Month='"+month_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom5);
                if(conn.rs2.next()==true){
                    found5=conn.rs2.getInt(1);
                }
              if(found5>0) {
             HSSFCell cell025 = rw6.createCell(dic_pos);    
             cell025.setCellValue(found5);
             cell025.setCellStyle(stylex_risk_data);
              } 
              if(found5==0) {
             HSSFCell cell025 = rw6.createCell(dic_pos);    
             cell025.setCellValue(" ");
             cell025.setCellStyle(stylex_risk_data);
              }
              String dom6="SELECT COUNT(DISTINCT enrollment.UniqueID) FROM enrollment JOIN riskassessmentmain ON "
                     + "enrollment.UniqueID=riskassessmentmain.UniqueID JOIN riskassessmentdetails ON "
                     + "riskassessmentmain.AssessmentID=riskassessmentdetails.AssessmentID WHERE "
                     + "enrollment.DICName='"+dic_name+"' && ((riskassessmentdetails.QuestionID='J' && riskassessmentdetails.DirectAnswers='3') || ( riskassessmentdetails.QuestionID='J' && riskassessmentdetails.DirectAnswers='4') ||(riskassessmentdetails.QuestionID='J' &&  riskassessmentdetails.DirectAnswers='5')) && riskassessmentmain.Month='"+month_id+"' && riskassessmentmain.Pefar_year='"+report_year+"'";   
                 conn.rs2=conn.state2.executeQuery(dom6);
                if(conn.rs2.next()==true){
                    found6=conn.rs2.getInt(1);
                }
              if(found6>0) {
             HSSFCell cell026 = rw7.createCell(dic_pos);    
             cell026.setCellValue(found6);
             cell026.setCellStyle(stylex_risk_data);
              } 
              if(found6==0) {
             HSSFCell cell026 = rw7.createCell(dic_pos);    
             cell026.setCellValue(" ");
             cell026.setCellStyle(stylex_risk_data);
              }
              found7=found + found2+found3+found4+found5+found6;
              if (found7==0){
              HSSFCell cell24 = rw10.createCell(dic_pos);    
             cell24.setCellValue(" ");
             cell24.setCellStyle(stylex_risk_data);
              }
              if (found7>0){
              HSSFCell cell24 = rw10.createCell(dic_pos);    
             cell24.setCellValue(found7);
             cell24.setCellStyle(stylex_risk_data);
              }
              found=found2=found3=found4=found5=found6=0;
              
               dic_pos++;
            dc++;
            }
           if(dc>0 && checker==0){
            HSSFCell cell0 = rw0.createCell(county_pos);    
             cell0.setCellValue(county_name);
             cell0.setCellStyle(style);
          end_merge=county_pos+dc-1;
            shet1.addMergedRegion(new CellRangeAddress(3,3,county_pos,end_merge));
            county_pos+=dc;
            //Merging cells to show the title report
            HSSFCell cell9 = rw8.createCell(2);    
             cell9.setCellValue("RISK ASSESSMENT REPORT");
             cell9.setCellStyle(style_header);
             shet1.addMergedRegion(new CellRangeAddress(1,1,2,end_merge));
             
             //Writing the PEPFAR YEAR
             HSSFCell cell44 = rw44.createCell(2);    
             cell44.setCellValue("PEPFAR YEAR "+report_year+"");
             cell44.setCellStyle(style_header);
             shet1.addMergedRegion(new CellRangeAddress(2,2,2,end_merge));
           }
           dc=0;
           }
  }
           row_starter += 8;
            year_month_index ++;
        
        //Here the code to reset row starter
        
       
        dic_pos = 0;
        county_pos = 0;
        dc = 0;
        found=found2=found3=found4=found5=found6=0;
       checker++; 
  }
         
        System.out.println("Monthly Report Generated"); 
    // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIC_RiskAssesment_Monthly_Report.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
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
            Logger.getLogger(RiskAssesmentReport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RiskAssesmentReport.class.getName()).log(Level.SEVERE, null, ex);
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
