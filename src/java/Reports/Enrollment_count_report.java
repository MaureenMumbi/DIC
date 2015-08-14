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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Enrollment_count_report extends HttpServlet {
    //Initialising the variables
HttpSession session;
String year,year_id,quarter, quarter_id,report_type,report_year,start_date,end_date,dic_name,period;
int year_pos;
 int targets=0;
 int yeartotal=0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //Creating the db connector
        dbConnect conn = new dbConnect();
        //Receiving the parameters from the form
        report_year = request.getParameter("year");
        report_type = request.getParameter("parameter");
         period = request.getParameter("period");
        start_date = request.getParameter("startdate");
        end_date = request.getParameter("enddate");
        System.out.println("The start date is: " +start_date);
        System.out.println(report_type);
        System.out.println("The end date is: " +end_date);
        //Sceduling depemding on the type of report
        if (report_type.equals("No of Enrollment")){
            if (period.equals("quarterly")){
        //Creating the Excel document
        int row_starter = 5;
        int end_col_starter = 0;
        int col_starter = 2;
        int quarter1_pos = 2;
        int quarter2_pos = 3;
        int quarter3_pos = 4;
        int quarter4_pos = 5;
        int TARGET_pos=6;
        int ACHIEVED_pos=7;
        int found1=0;
           int found2=0;
           int found3=0;
           int found4=0;
           int foundcaptured=0;
           int foundcaptured2=0;
           int foundcaptured3=0;
           int foundcaptured4=0;
           int total_found = 0;
           int total_captured=0;
           int cell_quarter1 = 2;
           int cell_quarter2 = 3;
           int cell_quarter3 = 4;
           int cell_quarter4 = 5;
           
           int cell_target=6;
           int cell_achieved=7;
        //***Creating workbook
         HSSFWorkbook wb=new HSSFWorkbook();
          HSSFSheet shet1=wb.createSheet();
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
            shet1.setColumnWidth(1, 4000 );
//          
    HSSFRow rw1 =shet1.createRow(3);      
   HSSFRow rw100=shet1.createRow(1);
    HSSFRow rw101=shet1.createRow(2);
     HSSFRow rw111=shet1.createRow(4);
    
    //Getting the years
   String split_start_date[] = start_date.split("/");
    String split_end_date[] = end_date.split("/");
    //After splitting Years
    String split_start_year = split_start_date[2];
    System.out.println("Start year is    :   "+split_start_year);
    //getting_splitted_month
    //Getting the Pefar years
    String Splitted_start_month = split_start_date[1];
    String Splitted_end_month = split_end_date[1];
     
    
    String split_end_year = split_end_date[2];  
     //Creating cells that are merged by Topic,Range of date and Years
     //Writing the years in excel
    int beg;
    int anz;
    int com;
    int en;
    int kwi;
     int hal;
     //To write the Pepfar Years
     if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         anz = Integer.parseInt(split_start_year);
         beg = anz + 1;
         com= anz + 1;
         }
     else{
     beg = Integer.parseInt(split_start_year);
     com = Integer.parseInt(split_start_year);
     }
            if (Splitted_end_month.equals("10") || Splitted_end_month.equals("11") || Splitted_end_month.equals("12")){
         kwi = Integer.parseInt(split_end_year);
        en = kwi + 1;
         hal = kwi + 1;
         }
     else{
     en = Integer.parseInt(split_end_year);
     hal = Integer.parseInt(split_end_year);
     }
     int differen = 0;
      differen = (hal - com + 1);
      int merge_start_topic = 1;
       //To get the end of merge_start_topic
           int end_merge_start_topic = ((differen * 7)+2);
   
           //Creating the cells where data will be put and surrounding them with borders
               while( merge_start_topic <= end_merge_start_topic){
                   
         //Puts empty values on the created cells.....will later be replaced by data
         HSSFCell cell004 = rw100.createCell(merge_start_topic);
          HSSFCell cell005 = rw101.createCell(merge_start_topic);
         cell004.setCellValue("");
         cell004.setCellStyle(indicator_style);
         cell005.setCellValue("");
         cell005.setCellStyle(indicator_style);
         
         //Incrementing the merge_start_topic
         merge_start_topic = merge_start_topic + 1;
         
                        
    }
               //Reseting the merge_start_topic back to its default value
               merge_start_topic = 2;
   ///Writing the topic
   HSSFCell cell000 = rw100.createCell(1);
   cell000.setCellValue("DIC NEW ENROLLMENTS REPORTS");
   cell000.setCellStyle(indicator_style);
   //   Writing the subtopic of the report
   HSSFCell cell001 = rw101.createCell(1);
   cell001.setCellValue("Based on Quarters from "+start_date+" to "+end_date+"");
   cell001.setCellStyle(style_header);
   //Writing the DIC Name title
   HSSFCell cell111 = rw111.createCell(1);
   cell111.setCellValue("");
    cell111.setCellStyle(year_style_header);
   HSSFCell cell002 = rw1.createCell(1);
   cell002.setCellValue("DIC Name");
    cell002.setCellStyle(year_style_header);
     shet1.addMergedRegion(new CellRangeAddress(1,1,1,9));
     shet1.addMergedRegion(new CellRangeAddress(2,2,1,9));
  
    
    System.out.println("End date date    :   "+split_end_year);
    //Writing the years in excel
    int begin;
    int anza;
    int commence;
    int end;
    int kwisha;
     int halt;
     int reportyear=0;
     int lastyear=0;
     //To write the Pepfar Years
     if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         anza = Integer.parseInt(split_start_year);
         begin = anza + 1;
         commence = anza + 1;
         reportyear=anza + 1;
         }
     else{
     begin = Integer.parseInt(split_start_year);
     commence = Integer.parseInt(split_start_year);
    reportyear=Integer.parseInt(split_start_year);
     }
            if (Splitted_end_month.equals("10") || Splitted_end_month.equals("11") || Splitted_end_month.equals("12")){
         kwisha = Integer.parseInt(split_end_year);
        end = kwisha + 1;
         halt = kwisha + 1;
         lastyear=kwisha+1;
         }
     else{
     end = Integer.parseInt(split_end_year);
     halt = Integer.parseInt(split_end_year);
     lastyear = Integer.parseInt(split_end_year);
     }
   
    //Creating the years in the range of Four
    while( begin <= end){
        //The years as outputed in excel
        
        HSSFCell cell004 = rw1.createCell(col_starter);
         cell004.setCellValue(begin);
         cell004.setCellStyle(year_style_header);
         //Shows position of ending the Merging
         end_col_starter = col_starter + 5;
         //Merging the cells of the year
           shet1.addMergedRegion(new CellRangeAddress(3,3,col_starter,end_col_starter)); 
         col_starter = col_starter + 6;
         
         begin ++;
         
         
//         end_col_starter++;
          
//    HSSFCell cell010 = rw1.createCell(end_col_starter);
//         cell010.setCellValue("TARGETS");
//         cell010.setCellStyle(year_style_header);
//         end_col_starter++;
//         
//    HSSFCell cell011_1 = rw1.createCell(end_col_starter);
//         cell011_1.setCellValue("ACHIEVED");
//         cell011_1.setCellStyle(year_style_header);
//      //   end_col_starter++;
        
    }
    //Creating TOTALS title for the column
    int total_region = end_col_starter + 1;
     HSSFCell cell112 = rw111.createCell(total_region);
   cell112.setCellValue("");
   cell112.setCellStyle(year_style_header);
    HSSFCell cell012_1 = rw1.createCell(total_region);
         cell012_1.setCellValue("TOTAL");
         cell012_1.setCellStyle(year_style_header);
         
           HSSFCell cell114 = rw111.createCell(total_region+1);
   cell114.setCellValue("");
    cell114.setCellStyle(year_style_header);
    
           HSSFCell cell013 = rw1.createCell(total_region+1);
         cell013.setCellValue("FINGERPRINT TOTAL");
         cell013.setCellStyle(year_style_header);
         shet1.addMergedRegion(new CellRangeAddress(3,4,total_region,total_region));
         shet1.addMergedRegion(new CellRangeAddress(3,4,total_region+1,total_region+1));
    //Creating the quarters
    int difference = 0;
     difference = (halt - commence + 1);
    System.out.println("The difference value is    :   "+difference);
           int total_difference = (difference * 5);
           
           //To get the end of determiner_start end
           int end_determiner_start = ((difference * 5)+3);
           
           //Merging cells that show the date difference
           int dffrnt_date_start = 1;
           int dffrnt_date_end = dffrnt_date_start + total_difference + 1;
           shet1.addMergedRegion(new CellRangeAddress(2,2,dffrnt_date_start,dffrnt_date_end));
           //Merging the cells that show the report title
           shet1.addMergedRegion(new CellRangeAddress(1,1,dffrnt_date_start,dffrnt_date_end));
           
           System.out.println("The total_difference value is    :   "+total_difference);
           int determiner = 1;
          
           //To show the start of the cells
           int determiner_start = 2;
           
        while(determiner <= difference ){
            //Creating Cells 
         HSSFCell cell005 = rw111.createCell(quarter1_pos);
         HSSFCell cell006 = rw111.createCell(quarter2_pos);
         HSSFCell cell007 = rw111.createCell(quarter3_pos);
         HSSFCell cell008 = rw111.createCell(quarter4_pos);
         HSSFCell cell008_1 = rw111.createCell(TARGET_pos);
         HSSFCell cell008_2 = rw111.createCell(ACHIEVED_pos);
         //Inserting values of the Celss
         cell005.setCellValue("Oct-Dec");
         cell005.setCellStyle(style_header);
         shet1.setColumnWidth(quarter1_pos, 2500 );
         cell006.setCellValue("Jan-Mar");
         cell006.setCellStyle(style_header);
         shet1.setColumnWidth(quarter2_pos, 2500 );
         cell007.setCellValue("Apr Jun");
         cell007.setCellStyle(style_header);
         shet1.setColumnWidth(quarter3_pos, 2500 );
         cell008.setCellValue("Jul Sept");
         cell008.setCellStyle(style_header);
         shet1.setColumnWidth(quarter4_pos, 2500 );
         cell008_1.setCellValue("Target");
         cell008_1.setCellStyle(style_header);
         shet1.setColumnWidth(TARGET_pos, 2550 );
         cell008_2.setCellValue("Achieved");
         cell008_2.setCellStyle(style_header);
         shet1.setColumnWidth(ACHIEVED_pos, 2700);
         //Changing positions of the columns
         quarter1_pos = quarter1_pos + 6;
         quarter2_pos = quarter2_pos + 6;
         quarter3_pos = quarter3_pos + 6;
         quarter4_pos = quarter4_pos + 6;
         TARGET_pos = TARGET_pos + 6;
         ACHIEVED_pos = ACHIEVED_pos + 6;
         
         
         
         System.out.println("pppp "+quarter1_pos+"____"+quarter2_pos+"____"+quarter3_pos+" "+quarter4_pos +"_____"+ TARGET_pos+"_____"+ACHIEVED_pos);
         determiner ++;
         
         System.out.println(determiner+"hhh___"+difference);
        }   
   
   //Writing the Dic Names on Excel
   String DIC_Name_fetcher = "SELECT * FROM dicname";
   
   conn.rs=conn.state.executeQuery(DIC_Name_fetcher);
        while(conn.rs.next()){
            dic_name = conn.rs.getString(2);
            //Crating Style for rows
            
            //Creating the rows and inserting the DIC Names
           HSSFRow rw =shet1.createRow(row_starter);
           HSSFCell cell003 = rw.createCell(1);
            cell003.setCellStyle(cell_style);
           cell003.setCellValue(dic_name);
           
           //Creating the cells where data will be put and surrounding them with borders
               while( determiner_start <= end_determiner_start){
                   
         //Puts empty values on the created cells.....will later be replaced by data
         HSSFCell cell004 = rw.createCell(determiner_start);
         cell004.setCellValue("");
         cell004.setCellStyle(cell_style);
         
         //Incrementing the determiner_start
         determiner_start = determiner_start + 1;
         
                        
    }
               //Reseting the determiner_start back to its default value
               determiner_start = 2;
           
           
           //Getting the pefar start yea
           int mnth_determine_year=0;
           int mnth_determine_year00=0;
           int mnth_determine_year1=0;
           int mnth_determine_year99=0;
           if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
            if (Splitted_end_month.equals("10") || Splitted_end_month.equals("11") || Splitted_end_month.equals("12")){
         mnth_determine_year1 = Integer.parseInt(split_end_year);
        mnth_determine_year99 = mnth_determine_year1 + 1;
         }
     else{
     mnth_determine_year99 = Integer.parseInt(split_end_year);
     }
     ///End of getting the Pefar years
        // while(anza <= kwisha){
           //Doin the counts for Eact DIC
          String DIC_count_enrol="select count(DISTINCT UniqueID),DICName,QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y')),Pefar_year,DOE,count(NULLIF(fingerprint,'')) from enrollment where DICName='"+ dic_name+"' AND (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+start_date+"','%e/%c/%Y')) AND (STR_TO_DATE('"+end_date+"','%e/%c/%Y'))  GROUP BY QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y')),DICName,Pefar_year ";
          //Prints out the query
          System.out.println(DIC_count_enrol);
          //Executes the query
          conn.rs1=conn.state1.executeQuery(DIC_count_enrol);
          //Shows all that is outputed by the query
           while(conn.rs1.next()==true){
               HSSFCell  cell009= rw.createCell(0);
           int   NoofEnrolls=conn.rs1.getInt(1);
           String    dic=conn.rs1.getString(2);
//           String   DOE=conn.rs1.getString(3);
           String   DOE="0";
           String  QTR=conn.rs1.getString(3);
           String Pefar_year = conn.rs1.getString(4);
           int totals = 0;
                  totals = totals + NoofEnrolls;
           String see_date = conn.rs1.getString(5);
           System.out.println("DOE: "+DOE +"...QTR: "+QTR +"..."+dic_name+"...dic: "+dic+" Number of enrollment: "+NoofEnrolls+" Pefar Year: "+Pefar_year+" See Enrollment Date: "+see_date );
           System.out.println(totals);
           //Writing in data Excel
           
           //To write the qtr1 data from financial year to pefars_year
           if (QTR.equals("1")){
               found1 = conn.rs1.getInt(1);
               foundcaptured=conn.rs1.getInt(6);
               //Adding the total
               total_found = total_found + found1;
               total_captured=total_captured+foundcaptured;
               //Checking the start years if match the pefar years to check where to place in excel
               while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter2 = cell_quarter2 + 6;
               
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
              
              // HSSFRow rw =shet1.createRow(row_starter);
          cell009 = rw.createCell(cell_quarter2);
           cell009.setCellValue(found1);
           cell009.setCellStyle(cell_style);
           cell_quarter2 = 3;
                         }
           
           if (QTR.equals("2")){
               found2 = conn.rs1.getInt(1);
               total_found = total_found + found2;
               foundcaptured2=conn.rs1.getInt(6);
               
               total_captured=total_captured+foundcaptured2;
               while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter3 = cell_quarter3 + 6;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
              cell009 = rw.createCell(cell_quarter3);
               cell009.setCellValue(found2);
               cell009.setCellStyle(cell_style);
              cell_quarter3 = 4; 
           }
           if (QTR.equals("3")){
               found3 = conn.rs1.getInt(1);
               total_found = total_found + found3;
               foundcaptured3=conn.rs1.getInt(6);
               
               total_captured=total_captured+foundcaptured3;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter4 = cell_quarter4 +6;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter4);
               cell009.setCellValue(found3);
              cell009.setCellStyle(cell_style);
//              
//              cell009 = rw.createCell(cell_target);
//               cell009.setCellValue("target");
//               cell009.setCellStyle(cell_style);
//               
//               
//             cell009 = rw.createCell(cell_achieved);
//               cell009.setCellValue("achieved ");
//               cell009.setCellStyle(cell_style);
              
             cell_quarter4 = 5;
             
//             cell_target = 6;
//              cell_achieved = 7;
           }
           if (QTR.equals("4")){
               found4 = conn.rs1.getInt(1);
               total_found = total_found + found4;
               foundcaptured4=conn.rs1.getInt(6);
               
               total_captured=total_captured+foundcaptured4;
               while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter1 = cell_quarter1 + 6;
               cell_target = cell_target+6;
               cell_achieved = cell_achieved+6;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               //if statement to check the condition of the figure
               if (found4 > 0){
             cell009 = rw.createCell(cell_quarter1);
               cell009.setCellValue(found4);
               cell009.setCellStyle(cell_style);
               
             cell_quarter1 = 2;
             
          
              
               }
               else{
              cell009 = rw.createCell(cell_quarter1);
               cell009.setCellValue(" ");
               cell009.setCellStyle(cell_style);
               
            
              cell_quarter1 = 2;
            
               }
           }
          
            String getTargets="select * from targets  where dicname='"+dic_name+"' and Year='"+reportyear+"'";
            
                System.out.println("ggg"+getTargets);
                conn.rs6 = conn.state6.executeQuery(getTargets);
           if(conn.rs6.next()==true){
            targets = conn.rs6.getInt("Target");
            System.out.println(targets +" targetsdd" + conn.rs6.getString("dicname"));
               cell009 = rw.createCell(cell_target);
               cell009.setCellValue(targets);
               cell009.setCellStyle(cell_style);
               
               
                cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue("");
               cell009.setCellStyle(cell_style);
              System.out.println("total_found  "+total_found +"nnn"+targets) ;
               if(total_found>0){
             cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue((targets/total_found)*100);
               cell009.setCellStyle(cell_style);
               }
               else{
                 cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue(1);
               cell009.setCellStyle(cell_style);
               }
               cell_target = 6;
              cell_achieved = 7;
            }
                    else{
           
           cell009 = rw.createCell(cell_target);
               cell009.setCellValue("");
               cell009.setCellStyle(cell_style);
               
               
              cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue("");
               cell009.setCellStyle(cell_style);
              
              cell_target = 6;
              cell_achieved = 7;
           
           }
           
            cell009.setCellStyle(cell_style);
           }
          // anza ++;
         // }
           //Calculating the totals of the totals present
         //total_found = found1 + found2 + found3 + found4;
           //Creating a cell for calculating the totals
           HSSFCell cell011 = rw.createCell(total_region);
               cell011.setCellValue(total_found);
               cell011.setCellStyle(cell_style);
               
                  HSSFCell cell012 = rw.createCell(total_region+1);
               cell012.setCellValue(total_captured);
               cell012.setCellStyle(cell_style);
           
           //Regesharing Total found to zero
               total_found = 0;
               total_captured = 0;
           row_starter ++;
        }
        //Creating cell for showing totals of the quarter
       // row_starter = row_starter + 1;
//        HSSFRow rw =shet1.createRow(row_starter);
//           HSSFCell cell003 = rw.createCell(1);
//            cell003.setCellStyle(cell_style);
//           cell003.setCellValue("TOTALS");
        
        
         // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIC_Enrollment_Quarter_Report.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        }
            
//**************************************************End of coding for Quartely Enrollment Report********************************
            
 //*************************************************The beginning coding of Monthly Report**************************************           
            if (period.equals("monthly")){
            //Creating the Excel document
        int row_starter = 5;
        int end_col_starter = 0;
        int col_starter = 2;
        int quarter1_pos = 2;
        int quarter2_pos = 3;
        int quarter3_pos = 4;
        int quarter4_pos = 5;
        int quarter5_pos = 6;
        int quarter6_pos = 7;
        int quarter7_pos = 8;
        int quarter8_pos = 9;
        int quarter9_pos = 10;
        int quarter10_pos = 11;
        int quarter11_pos = 12;
        int quarter12_pos = 13;
         int TARGET_pos=14;
        int ACHIEVED_pos=15;
        int found1;
           int found2;
           int found3;
           int found4;
           int found5;
           int found6;
           int found7;
           int found8;
           int found9;
           int found10;
           int found11;
           int found12;
           int total_found = 0;
           int captured1=0;
           int captured2=0;
           int captured3=0;
           int captured4=0;
           int captured5=0;
           int captured6=0;
           int captured7=0;
           int captured8=0;
           int captured9=0;
           int captured10=0;
           int captured11=0;
           int captured12=0;
         
           int total_captured = 0;
           int cell_quarter1 = 2;
           int cell_quarter2 = 3;
           int cell_quarter3 = 4;
           int cell_quarter4 = 5;
           int cell_quarter5 = 6;
           int cell_quarter6 = 7;
           int cell_quarter7 = 8;
           int cell_quarter8 = 9;
           int cell_quarter9 = 10;
           int cell_quarter10 = 11;
           int cell_quarter11 = 12;
           int cell_quarter12 = 13;
            int cell_target=14;
           int cell_achieved=15;
           
        //***Creating workbook
         HSSFWorkbook wb=new HSSFWorkbook();
          HSSFSheet shet1=wb.createSheet();
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
            shet1.setColumnWidth(1, 4000 );
//          
    HSSFRow rw1 =shet1.createRow(3);      
   HSSFRow rw100=shet1.createRow(1);
    HSSFRow rw101=shet1.createRow(2);
     HSSFRow rw111=shet1.createRow(4);
     
     //Getting the years
   String split_start_date[] = start_date.split("/");
    String split_end_date[] = end_date.split("/");
    //After splitting Years
    String split_start_year = split_start_date[2];
    System.out.println("Start year is    :   "+split_start_year);
    //getting_splitted_month
    //Getting the Pefar years
    String Splitted_start_month = split_start_date[1];
    String Splitted_end_month = split_end_date[1];
     
    
    String split_end_year = split_end_date[2];
    
    
    //Creating cells that are merged by Topic,Range of date and Years
     //Writing the years in excel
    int beg;
    int anz;
    int com;
    int en;
    int kwi;
     int hal;
     //To write the Pepfar Years
     if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         anz = Integer.parseInt(split_start_year);
         beg = anz + 1;
         com= anz + 1;
         }
     else{
     beg = Integer.parseInt(split_start_year);
     com = Integer.parseInt(split_start_year);
     }
            if (Splitted_end_month.equals("10") || Splitted_end_month.equals("11") || Splitted_end_month.equals("12")){
         kwi = Integer.parseInt(split_end_year);
        en = kwi + 1;
         hal = kwi + 1;
         }
     else{
     en = Integer.parseInt(split_end_year);
     hal = Integer.parseInt(split_end_year);
     }
     int differen = 0;
      differen = (hal - com + 1);
      int merge_start_topic = 1;
       //To get the end of merge_start_topic
           int end_merge_start_topic = ((differen * 15)+2);
   
           //Creating the cells where data will be put and surrounding them with borders
               while( merge_start_topic <= end_merge_start_topic){
                   
         //Puts empty values on the created cells.....will later be replaced by data
         HSSFCell cell004 = rw100.createCell(merge_start_topic);
          HSSFCell cell005 = rw101.createCell(merge_start_topic);
         cell004.setCellValue("");
         cell004.setCellStyle(indicator_style);
         cell005.setCellValue("");
         cell005.setCellStyle(indicator_style);
         
         //Incrementing the merge_start_topic
         merge_start_topic = merge_start_topic + 1;
         
                        
    }
               //Reseting the merge_start_topic back to its default value
               merge_start_topic = 2;
    
   
   ///Writing the topic
   HSSFCell cell000 = rw100.createCell(1);
   cell000.setCellValue("DIC NEW ENROLLMENTS REPORTS");
   cell000.setCellStyle(indicator_style);
   shet1.addMergedRegion(new CellRangeAddress(1,1,1,17));
   //   Writing the subtopic of the report
   HSSFCell cell001 = rw101.createCell(1);
   cell001.setCellValue("Based on Months from "+start_date+" to "+end_date+"");
   cell001.setCellStyle(style_header);
   
    shet1.addMergedRegion(new CellRangeAddress(2,2,1,17));
   //Writing the DIC Name title
   HSSFCell cell111 = rw111.createCell(1);
   cell111.setCellValue("");
    cell111.setCellStyle(year_style_header);
   HSSFCell cell002 = rw1.createCell(1);
   cell002.setCellValue("DIC Name");
    cell002.setCellStyle(year_style_header);
     
    
   
    
    System.out.println("End date date    :   "+split_end_year);
    //Writing the years in excel
    int begin;
    int anza;
    int commence;
    int end;
    int kwisha;
     int halt;
     int reportyear=0;
     int lastyear=0;
     //To write the Pepfar Years
     if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         anza = Integer.parseInt(split_start_year);
         begin = anza + 1;
         commence = anza + 1;
         reportyear= anza + 1;
         }
     else{
     begin = Integer.parseInt(split_start_year);
     commence = Integer.parseInt(split_start_year);
     reportyear = Integer.parseInt(split_start_year);
     
     }
            if (Splitted_end_month.equals("10") || Splitted_end_month.equals("11") || Splitted_end_month.equals("12")){
         kwisha = Integer.parseInt(split_end_year);
        end = kwisha + 1;
         halt = kwisha + 1;
         lastyear= kwisha + 1;
         }
     else{
     end = Integer.parseInt(split_end_year);
     halt = Integer.parseInt(split_end_year);
     lastyear=Integer.parseInt(split_end_year);
            
            }
   
    //Creating the years in the range of Four
    while( begin <= end){
        //The years as outputed in excel
        
        HSSFCell cell004 = rw1.createCell(col_starter);
         cell004.setCellValue(begin);
         cell004.setCellStyle(year_style_header);
         //Shows position of ending the Merging
         end_col_starter = col_starter + 13;
         //Merging the cells of the year
           shet1.addMergedRegion(new CellRangeAddress(3,3,col_starter,end_col_starter)); 
         col_starter = col_starter + 14;
         
         begin ++;
        
    }
    //Creating TOTALS title for the column
    int total_region = end_col_starter + 1;
     HSSFCell cell112 = rw111.createCell(total_region);
   cell112.setCellValue("");
    cell112.setCellStyle(year_style_header);
    HSSFCell cell010 = rw1.createCell(total_region);
         cell010.setCellValue("TOTAL");
         cell010.setCellStyle(year_style_header);
         
         
         
          HSSFCell cell114 = rw111.createCell(total_region+1);
   cell114.setCellValue("");
    cell114.setCellStyle(year_style_header);
         
          HSSFCell cell013 = rw1.createCell(total_region+1);
         cell013.setCellValue("FINGERPRINT TOTAL");
         cell013.setCellStyle(year_style_header);
         
         shet1.addMergedRegion(new CellRangeAddress(3,4,total_region,total_region));
         shet1.addMergedRegion(new CellRangeAddress(3,4,total_region+1,total_region+1));
    //Creating the quarters
    int difference = 0;
     difference = (halt - commence + 1);
    System.out.println("The difference value is    :   "+difference);
           int total_difference = (difference * 12);
           
            //To get the end of determiner_start end
           int end_determiner_start = ((difference * 12)+5);
           
           //Merging cells that show the date difference
           int dffrnt_date_start = 1;
           int dffrnt_date_end = dffrnt_date_start + total_difference + 1;
           shet1.addMergedRegion(new CellRangeAddress(2,2,dffrnt_date_start,dffrnt_date_end));
           //Merging the cells that show the report title
           shet1.addMergedRegion(new CellRangeAddress(1,1,dffrnt_date_start,dffrnt_date_end));
           
           System.out.println("The total_difference value is    :   "+total_difference);
           int determiner = 1;
            //To show the start of the cells
           int determiner_start = 2;
        while(determiner <= difference ){
            //Creating Cells 
         HSSFCell cell005 = rw111.createCell(quarter1_pos);
         HSSFCell cell006 = rw111.createCell(quarter2_pos);
         HSSFCell cell007 = rw111.createCell(quarter3_pos);
         HSSFCell cell008 = rw111.createCell(quarter4_pos);
         HSSFCell cell015 = rw111.createCell(quarter5_pos);
         HSSFCell cell016 = rw111.createCell(quarter6_pos);
         HSSFCell cell017 = rw111.createCell(quarter7_pos);
         HSSFCell cell018 = rw111.createCell(quarter8_pos);
         HSSFCell cell025 = rw111.createCell(quarter9_pos);
         HSSFCell cell026 = rw111.createCell(quarter10_pos);
         HSSFCell cell027 = rw111.createCell(quarter11_pos);
         HSSFCell cell028 = rw111.createCell(quarter12_pos);
           HSSFCell cell008_1 = rw111.createCell(TARGET_pos);
         HSSFCell cell008_2 = rw111.createCell(ACHIEVED_pos);
         //Inserting values of the Celss
         cell005.setCellValue("Oct");
         cell005.setCellStyle(style_header);
         shet1.setColumnWidth(quarter1_pos, 2500 );
         cell006.setCellValue("Nov");
         cell006.setCellStyle(style_header);
         shet1.setColumnWidth(quarter2_pos, 2500 );
         cell007.setCellValue("Dec");
         cell007.setCellStyle(style_header);
         shet1.setColumnWidth(quarter3_pos, 2500 );
         cell008.setCellValue("Jan");
         cell008.setCellStyle(style_header);
         shet1.setColumnWidth(quarter4_pos, 2500 );
         cell015.setCellValue("Feb");
         cell015.setCellStyle(style_header);
         shet1.setColumnWidth(quarter5_pos, 2500 );
         cell016.setCellValue("Mar");
         cell016.setCellStyle(style_header);
         shet1.setColumnWidth(quarter6_pos, 2500 );
         cell017.setCellValue("Apr");
         cell017.setCellStyle(style_header);
         shet1.setColumnWidth(quarter7_pos, 2500 );
         cell018.setCellValue("May");
         cell018.setCellStyle(style_header);
         shet1.setColumnWidth(quarter8_pos, 2500 );
         cell025.setCellValue("Jun");
         cell025.setCellStyle(style_header);
         shet1.setColumnWidth(quarter9_pos, 2500 );
         cell026.setCellValue("Jul");
         cell026.setCellStyle(style_header);
         shet1.setColumnWidth(quarter10_pos, 2500 );
         cell027.setCellValue("Aug");
         cell027.setCellStyle(style_header);
         shet1.setColumnWidth(quarter11_pos, 2500 );
         cell028.setCellValue("Sep");
         cell028.setCellStyle(style_header);
         shet1.setColumnWidth(quarter12_pos, 2500 );
         
           cell008_1.setCellValue("Target");
         cell008_1.setCellStyle(style_header);
         shet1.setColumnWidth(TARGET_pos, 2600 );
         cell008_2.setCellValue("Achieved");
         cell008_2.setCellStyle(style_header);
         shet1.setColumnWidth(ACHIEVED_pos, 2700);
         
         //Changing positions of the columns
         quarter1_pos = quarter1_pos + 14;
         quarter2_pos = quarter2_pos + 14;
         quarter3_pos = quarter3_pos + 14;
         quarter4_pos = quarter4_pos + 14;
         quarter5_pos = quarter5_pos + 14;
         quarter6_pos = quarter6_pos + 14;
         quarter7_pos = quarter7_pos + 14;
         quarter8_pos = quarter8_pos + 14;
         quarter9_pos = quarter9_pos + 14;
         quarter10_pos = quarter10_pos + 14;
         quarter11_pos = quarter11_pos + 14;
         quarter12_pos = quarter12_pos + 14;
          TARGET_pos = TARGET_pos + 14;
         ACHIEVED_pos = ACHIEVED_pos + 14;
         determiner ++;
        }   
   
   //Writing the Dic Names on Excel
   String DIC_Name_fetcher = "SELECT * FROM dicname";
   
   conn.rs=conn.state.executeQuery(DIC_Name_fetcher);
        while(conn.rs.next()){
            dic_name = conn.rs.getString(2);
            //Crating Style for rows
            
            //Creating the rows and inserting the DIC Names
           HSSFRow rw =shet1.createRow(row_starter);
           HSSFCell cell003 = rw.createCell(1);
            cell003.setCellStyle(cell_style);
           cell003.setCellValue(dic_name);
           
           //Creating the cells where data will be put and surrounding them with borders
               while( determiner_start <= end_determiner_start){
                   
         //Puts empty values on the created cells.....will later be replaced by data
         HSSFCell cell004 = rw.createCell(determiner_start);
         cell004.setCellValue("");
         cell004.setCellStyle(cell_style);
         
         //Incrementing the determiner_start
         determiner_start = determiner_start + 1;
         
                        
    }
               //Reseting the determiner_start back to its default value
               determiner_start = 2;
               
           //Getting the pefar start yea
           int mnth_determine_year=0;
           int mnth_determine_year00=0;
           int mnth_determine_year1=0;
           int mnth_determine_year99=0;
           if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
            if (Splitted_end_month.equals("10") || Splitted_end_month.equals("11") || Splitted_end_month.equals("12")){
         mnth_determine_year1 = Integer.parseInt(split_end_year);
        mnth_determine_year99 = mnth_determine_year1 + 1;
         }
     else{
     mnth_determine_year99 = Integer.parseInt(split_end_year);
     }
     ///End of getting the Pefar years
        // while(anza <= kwisha){
           //Doin the counts for Eact DIC
          String DIC_count_enrol="select count(UniqueID),DICName,MONTH(STR_TO_DATE(DOE,'%e/%c/%Y')),Pefar_year,DOE,QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y')),count(NULLIF(fingerprint,'')) from enrollment where DICName='"+ dic_name+"' AND (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+start_date+"','%e/%c/%Y')) AND (STR_TO_DATE('"+end_date+"','%e/%c/%Y'))  GROUP BY MONTH(STR_TO_DATE(DOE,'%e/%c/%Y')),QUARTER(STR_TO_DATE(DOE,'%e/%c/%Y')),DICName,Pefar_year ";
          //Prints out the query
          System.out.println(DIC_count_enrol);
          //Executes the query
          conn.rs1=conn.state1.executeQuery(DIC_count_enrol);
          //Shows all that is outputed by the query
           while(conn.rs1.next()==true){
               HSSFCell  cell009= rw.createCell(0);
           int   NoofEnrolls=conn.rs1.getInt(1);
           String    dic=conn.rs1.getString(2);
//           String   DOE=conn.rs1.getString(3);
           String   DOE="0";
           String  QTR=conn.rs1.getString(3);
           String  MNTH=conn.rs1.getString(6);
           String Pefar_year = conn.rs1.getString(4);
           int totals = 0;
                  totals = totals + NoofEnrolls;
           String see_date = conn.rs1.getString(5);
           System.out.println("Quarter: "+MNTH +"...MONTH: "+QTR +"..."+dic_name+"...dic: "+dic+" Number of enrollment: "+NoofEnrolls+" Pefar Year: "+Pefar_year+" See Enrollment Date: "+see_date );
           System.out.println(totals);
           //Writing in data Excel
           
           //To write the qtr1 data from financial year to pefars_year
           if (QTR.equals("1")){
               found1 = conn.rs1.getInt(1);
               //Adding the total
               total_found = total_found + found1;
              
               captured1 = conn.rs1.getInt(7);
               //Adding the total
//                captured1 = conn.rs1.getInt(7);
               total_captured = total_captured + captured1;
               //Checking the start years if match the pefar years to check where to place in excel
               while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter4 = cell_quarter4 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
              
              // HSSFRow rw =shet1.createRow(row_starter);
          cell009 = rw.createCell(cell_quarter4);
           cell009.setCellValue(found1);
           cell009.setCellStyle(cell_style);
           cell_quarter4 = 5;
                         }
           
           if (QTR.equals("2")){
               found2 = conn.rs1.getInt(1);
               total_found = total_found + found2;
                captured2 = conn.rs1.getInt(7);
               total_captured = total_captured + captured2;
               while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter5 = cell_quarter5 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
              cell009 = rw.createCell(cell_quarter5);
               cell009.setCellValue(found2);
               cell009.setCellStyle(cell_style);
              cell_quarter5 = 6; 
           }
           if (QTR.equals("3")){
               found3 = conn.rs1.getInt(1);
               total_found = total_found + found3;
                captured3 = conn.rs1.getInt(7);
               total_captured = total_captured + captured3;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter6 = cell_quarter6 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter6);
               cell009.setCellValue(found3);
              cell009.setCellStyle(cell_style);
             cell_quarter6 = 7;
           }
           if (QTR.equals("4")){
               found4 = conn.rs1.getInt(1);
               total_found = total_found + found4;
                captured4 = conn.rs1.getInt(7);
               total_captured = total_captured + captured4;
               while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter7 = cell_quarter7 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               //if statement to check the condition of the figure
               if (found4 > 0){
             cell009 = rw.createCell(cell_quarter7);
               cell009.setCellValue(found4);
               cell009.setCellStyle(cell_style);
              cell_quarter7 = 8;
               }
               else{
              cell009 = rw.createCell(cell_quarter7);
               cell009.setCellValue(" ");
               cell009.setCellStyle(cell_style);
              cell_quarter7 = 8;
               }
           }
           if (QTR.equals("5")){
               found5 = conn.rs1.getInt(1);
               total_found = total_found + found5;
                captured5 = conn.rs1.getInt(7);
               total_captured = total_captured + captured5;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter8 = cell_quarter8 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter8);
               cell009.setCellValue(found5);
              cell009.setCellStyle(cell_style);
             cell_quarter8 = 9;
           }
           if (QTR.equals("6")){
               found6 = conn.rs1.getInt(1);
               total_found = total_found + found6;
               
                captured6 = conn.rs1.getInt(7);
               total_captured = total_captured + captured6;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter9 = cell_quarter9 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter9);
               cell009.setCellValue(found6);
              cell009.setCellStyle(cell_style);
             cell_quarter9 = 10;
           }
           if (QTR.equals("7")){
               found7 = conn.rs1.getInt(1);
               total_found = total_found + found7;
               
                captured7 = conn.rs1.getInt(7);
               total_captured = total_captured + captured7;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter10 = cell_quarter10 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter10);
               cell009.setCellValue(found7);
              cell009.setCellStyle(cell_style);
             cell_quarter10 = 11;
           }
           if (QTR.equals("8")){
               found8 = conn.rs1.getInt(1);
               total_found = total_found + found8;
               
                captured8 = conn.rs1.getInt(7);
               total_captured = total_captured + captured8;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter11 = cell_quarter11 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter11);
               cell009.setCellValue(found8);
              cell009.setCellStyle(cell_style);
             cell_quarter11 = 12;
           }
           if (QTR.equals("9")){
               found9 = conn.rs1.getInt(1);
               total_found = total_found + found9;
               
                captured9 = conn.rs1.getInt(7);
               total_captured = total_captured + captured9;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter12 = cell_quarter12 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter12);
               cell009.setCellValue(found9);
              cell009.setCellStyle(cell_style);
             cell_quarter12 = 13;
           }
           if (QTR.equals("10")){
               found10 = conn.rs1.getInt(1);
               total_found = total_found + found10;
               
                captured10 = conn.rs1.getInt(7);
               total_captured = total_captured + captured10;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter1 = cell_quarter1 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter1);
               cell009.setCellValue(found10);
              cell009.setCellStyle(cell_style);
             cell_quarter1 = 2;
           }
           if (QTR.equals("11")){
               found11 = conn.rs1.getInt(1);
               total_found = total_found + found11;
               
               
               
                captured11 = conn.rs1.getInt(7);
               total_captured = total_captured + captured11;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter2 = cell_quarter2 + 14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter2);
               cell009.setCellValue(found11);
              cell009.setCellStyle(cell_style);
             cell_quarter2 = 3;
           }
           if (QTR.equals("12")){
               found12 = conn.rs1.getInt(1);
               total_found = total_found + found12;
               
               
                captured12 = conn.rs1.getInt(7);
               total_captured = total_captured + captured12;
                while (!(mnth_determine_year00 == Integer.parseInt(Pefar_year)) ){
               cell_quarter3 = cell_quarter3 + 14;
               cell_target=cell_target+14;
               cell_achieved=cell_achieved+14;
               mnth_determine_year00 ++;
                              }
               if (Splitted_start_month.equals("10") || Splitted_start_month.equals("11") || Splitted_start_month.equals("12")){
         mnth_determine_year = Integer.parseInt(split_start_year);
         mnth_determine_year00 = mnth_determine_year + 1;
         }
     else{
     mnth_determine_year00 = Integer.parseInt(split_start_year);
     }
               
               cell009 = rw.createCell(cell_quarter3);
               cell009.setCellValue(found12);
              cell009.setCellStyle(cell_style);
             cell_quarter3 = 4;
           }
           String getTargets="";
           
          
            
            
             getTargets="select * from targets  where dicname='"+dic_name+"' and Year='"+reportyear+"'";
             System.out.println(reportyear +"))))"+lastyear);
                System.out.println("ggg"+getTargets);
                conn.rs6 = conn.state6.executeQuery(getTargets);
            if(conn.rs6.next()==true){
            targets = conn.rs6.getInt("Target");
            System.out.println(targets +" targetsdd" + conn.rs6.getString("dicname"));
               cell009 = rw.createCell(cell_target);
               cell009.setCellValue(targets);
               cell009.setCellStyle(cell_style);
              System.out.println("total_found  "+total_found +"nnn"+targets) ;
               if(total_found>0){
             cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue((targets/total_found)*100);
               cell009.setCellStyle(cell_style);
               }
               else{
                 cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue(1);
               cell009.setCellStyle(cell_style);
               }
               cell_target = 14;
              cell_achieved = 15;
              
           
            }
          
         
           else{
           
           cell009 = rw.createCell(cell_target);
               cell009.setCellValue("0");
               cell009.setCellStyle(cell_style);
               
               
              cell009 = rw.createCell(cell_achieved);
               cell009.setCellValue("0");
               cell009.setCellStyle(cell_style);
              
              cell_target = 14;
              cell_achieved = 15;
           
           }
            
            
          
           
           
             
           // cell009.setCellStyle(cell_style);
           }
          // anza ++;
         // }
           //Calculating the totals of the totals present
         //total_found = found1 + found2 + found3 + found4;
           //Creating a cell for calculating the totals
           HSSFCell cell011 = rw.createCell(total_region);
               cell011.setCellValue(total_found);
               cell011.setCellStyle(cell_style);
               
           HSSFCell cell012 = rw.createCell(total_region+1);
               cell012.setCellValue(total_captured);
               cell012.setCellStyle(cell_style);
           
           //Regesharing Total found to zero
               total_found = 0;
               total_captured = 0;
           row_starter ++;
        }
        
        
         // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIC_Enrollment_Monthly_Report.xls");
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
            
            
            }
            //*************************End coding of the Monthly Report**********************************************************
        }
        //***********************************End of coding of the Enrollment Reports********************************************
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
            Logger.getLogger(Enrollment_count_report.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Enrollment_count_report.class.getName()).log(Level.SEVERE, null, ex);
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
