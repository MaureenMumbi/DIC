/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;


import dbConnect.dbConnect;
import java.io.*;
import java.sql.SQLException;
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
public class EnrollmentReport extends HttpServlet {

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
    HttpSession session;
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

   
            
            session=request.getSession();
            dbConnect conn=new dbConnect();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//            ^^^^^^^^^^^^^CREATE STATIC AND WRITE STATIC DATA TO THE EXCELL^^^^^^^^^^^^
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
style.setBottomBorderColor(HSSFColor.BRIGHT_GREEN.index);


//%%%%%%%%%%%%%%%%HEADER FONTS AND COLORATION%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)05);
    font_header.setColor(HSSFColor.BLACK.index);
    CellStyle style_header=wb.createCellStyle();
    style_header.setFont(font_header);
    style_header.setWrapText(true);
    style_header.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style_header.getBorderBottom();
style_header.setBottomBorderColor(HSSFColor.LEMON_CHIFFON.index);
     shet1.addMergedRegion(new CellRangeAddress(0,0,1,7));
     
//  HSSFSheet sheet1 = wb.getSheetAt(0);
    shet1.setColumnWidth(0, 4000); 
    shet1.setColumnWidth(1, 13000); 
    shet1.setColumnWidth(2, 8000); 
    shet1.setColumnWidth(3, 8000); 
  HSSFRow rw1=shet1.createRow(1);
  HSSFCell cell;
  cell=rw1.createCell(1);
  cell.setCellValue("DIC REPORTS");
   cell.setCellStyle(style_header);
  rw1.setHeightInPoints(30);
  
  
//  Merge the cells
//  shet1.addMergedRegion(new CellRangeAddress(1,1,1,3));
            
   HSSFRow rw4=shet1.createRow(3);
    rw4.setHeightInPoints(25);
//    rw4.setRowStyle(style);
    
   HSSFRow rw5=shet1.createRow(2);
    rw5.setHeightInPoints(25);
//    rw5.setRowStyle(stylex);
 
    
   
// rw4.createCell(1).setCellValue("Number");
    HSSFCell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13;
   // cells fo row 2 
   


 
// cell10.setCellValue("over 50% attendance");  
// cell11.setCellValue("less than 50% attendance"); 
// cell12.setCellValue("Overall Attendance"); 
 
 HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

HSSFFont fontx = wb.createFont();
fontx.setColor(HSSFColor.DARK_BLUE.index);
stylex.setFont(fontx);



//cell10.setCellStyle(stylex);
//cell11.setCellStyle(stylex);
//cell12.setCellStyle(stylex);
String DICName="";
String reporttype="";
String reportyear="";
String question="";
String questionRed="";

if(request.getParameter("DICName")!= null && !request.getParameter("DICName").equals("")){
DICName = request.getParameter("DICName");
}
if(request.getParameter("parameter")!= null && !request.getParameter("parameter").equals("")){
reporttype = request.getParameter("parameter");
}
if(request.getParameter("year")!= null && !request.getParameter("year").equals("")){
reportyear = request.getParameter("year");
}
if(request.getParameter("questionAssess")!= null && !request.getParameter("questionAssess").equals("")){
question = request.getParameter("questionAssess");
}
if(request.getParameter("questionRed")!= null && !request.getParameter("questionRed").equals("")){
questionRed = request.getParameter("questionRed");
}

 String NoofEnrolls="";
 String dic="";
 String district="";
 String DOE="";
 int i=3;
 int count=0;
 
 
 
  //______________________________________________________________________________ report for enrollments  _______________________________________________________________________
 
 if(reporttype.equalsIgnoreCase("No of Enrollment")){
     
     // for merging cells 
   shet1.addMergedRegion(new CellRangeAddress(2,2,6,9));
  // creating the cells for enrollment   
  cell1=rw4.createCell(0);
   cell2=rw4.createCell(1);
   cell3=rw4.createCell(2);
   cell4=rw4.createCell(3);
   
   
   // cell for row 3
   cell6=rw5.createCell(0);
   cell7=rw5.createCell(1);
   cell8=rw5.createCell(2);
   cell9=rw5.createCell(3);

   cell6.setCellValue("No of Enrollments ");
   cell7.setCellValue(" for "+DICName+" based on months for the year "+reportyear+"");         

cell1 .setCellValue("No of Enrollments");
cell2.setCellValue("District");
cell3.setCellValue("DIC Name");
cell4.setCellValue("Doe");

// styling the cells

cell1.setCellStyle(style);
cell2.setCellStyle(style);
cell3.setCellStyle(style);
cell4.setCellStyle(style);
String age="";
cell6.setCellStyle(stylex);
cell7.setCellStyle(stylex);
cell8.setCellStyle(stylex);
cell9.setCellStyle(stylex);

            String enrolls="select count(UniqueID),DICName,District,STR_TO_DATE(DOE, '%e/%c/%Y') AS dates from enrollment where DICName='"+DICName+"' AND YEAR(STR_TO_DATE(DOE,'%e/%c/%Y')) ='"+reportyear+"' group by MONTH(dates)";
            conn.rs=conn.state.executeQuery(enrolls);
            while(conn.rs.next()){
                 count++;
                NoofEnrolls=conn.rs.getString(1);
//                district=conn.rs.getString(2);
               
               String query = "select * from districts where DistrictID='"+conn.rs.getString(3)+"'";
               conn.rs1= conn.state2.executeQuery(query);
               while(conn.rs1.next()){
                    district=conn.rs1.getString(2);
               }
                dic=conn.rs.getString(2);
                DOE=conn.rs.getString(4);
//                age=conn.rs.getString(5);
//                String querys= "select count(UniqueID) where Age >=18";
                
                String []dater =DOE.split("-");
               String enrolDate ="";
              
               System.out.println(dater[1]);
               if(dater[1].equals("01")){
                   enrolDate="January "+dater[0]+"";
               }
               if(dater[1].equals("02")){
                   enrolDate="February "+dater[0]+"";
               }
               if(dater[1].equals("03")){
                   enrolDate="March "+dater[0]+"";
               }
               if(dater[1].equals("04")){
                   enrolDate="April "+dater[0]+"";
               }
               else if(dater[1].equals("05")){
                   enrolDate="May "+dater[0]+"";
               }
                if(dater[1].equals("06")){
                   enrolDate="June "+dater[0]+"";
               }
              if(dater[1].equals("07")){
                   enrolDate="July "+dater[0]+"";
               }
               if(dater[1].equals("08")){
                   enrolDate="August "+dater[0]+"";
               }
               if(dater[1].equals("09")){
                   enrolDate="September "+dater[0]+"";
               }
               if(dater[1].equals("10")){
                   enrolDate="October "+dater[0]+"";
               }
               if(dater[1].equals("11")){
                   enrolDate="November "+dater[0]+"";
               }
               if(dater[1].equals("12")){
                   enrolDate="December "+dater[0]+"";
               }

int counts =0;
counts=count+3;
HSSFRow rwi=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rwi.setHeightInPoints(20);

 rwi.createCell(0).setCellValue(NoofEnrolls);
 rwi.createCell(1).setCellValue(district);
 rwi.createCell(2).setCellValue(dic);
 rwi.createCell(3).setCellValue(enrolDate);
  
               
            }
            
           
             
             
   }             
  //______________________________________________________________________________ end of no of enrollments  _______________________________________________________________________
  //______________________________________________________________________________ report  of no of risk assessments _______________________________________________________________________
 
 else if(reporttype.equalsIgnoreCase("No of Risk Assessment")){
     // for merging cells 
   shet1.addMergedRegion(new CellRangeAddress(2,2,6,9));
  // creating the cells for enrollment   
  cell1=rw4.createCell(0);
   cell2=rw4.createCell(1);
   cell3=rw4.createCell(2);
   cell4=rw4.createCell(3);
   
   
   // cell for row 3
   cell6=rw5.createCell(0);
   cell7=rw5.createCell(1);
   cell8=rw5.createCell(2);
   cell9=rw5.createCell(3);
cell1 .setCellValue("No of Risk Assessment");
cell2.setCellValue("Month Assessed");

// styling the cells

cell1.setCellStyle(style);
cell2.setCellStyle(style);
cell3.setCellStyle(style);
cell4.setCellStyle(style);

cell6.setCellStyle(style_header);
cell7.setCellStyle(style_header);
cell8.setCellStyle(style_header);
cell9.setCellStyle(style_header);

 cell6.setCellValue(" ");
             cell7.setCellValue(" No of Assessment done for "+DICName+" based on months "+reportyear+"");
String NoofAssess="";
String DatesofAssess="";
 String enrolDate ="";
//  HSSFRow rwi=shet1.createRow(4);
//  rwi.setHeightInPoints(20);
    int totalAssess=0;
String months[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
int fetchedMonths[]= new int[12];
      for(int k=0;k<months.length;k++){  
             String uniqueID="select * from enrollment where DICName='"+DICName+"' ";
            conn.rs=conn.state.executeQuery(uniqueID);
//            System.out.println(uniqueID);
            while(conn.rs.next()){
 String assess="select count(AssessmentID),AssessmentDate from riskassessmentmain where UniqueID='"+ conn.rs.getString(1)+"' AND MONTH(STR_TO_DATE(AssessmentDate, '%e/%c/%Y'))='"+months[k]+"' AND YEAR(STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) ='"+reportyear+"' GROUP BY MONTH(AssessmentDate)";
         conn.rs1=conn.state1.executeQuery(assess);
//         System.out.println(assess);
         
            while(conn.rs1.next()){
               
                NoofAssess=conn.rs1.getString(1);
//System.out.println("NoofAssess "+NoofAssess);

                DatesofAssess=conn.rs1.getString(2);
                
//                System.out.println("NoofAssess"+ NoofAssess+"DatesofAssess "+DatesofAssess);
                
               totalAssess+=Integer.parseInt(NoofAssess);

                 fetchedMonths[k]=totalAssess;
                 
               
               }//while
            
            }//while
         
          System.out.println(fetchedMonths[k]+" for "+months[k]);
            totalAssess=0;
     
             }//for
          int y=0 ;
       for(int w=0;w<fetchedMonths.length;w++){
                y++;
            System.out.print(fetchedMonths[w]+"fetched months");
            System.out.println(months[w]);
            int counts1=0;
            counts1=y+3;
 HSSFRow rwi=shet1.createRow(counts1);       
//   rwi.createCell(1).setCellValue(i-3);
 rwi.setHeightInPoints(20);
String dateAssessed="";
 
  if(months[w].equals("1")){
                   dateAssessed="January";
               }
               if(months[w].equals("2")){
                   dateAssessed="February";
               }
               if(months[w].equals("3")){
                   dateAssessed="March";
               }
               if(months[w].equals("4")){
                   dateAssessed="April";
               }
               else if(months[w].equals("5")){
                   dateAssessed="May";
               }
                if(months[w].equals("6")){
                   dateAssessed="June";
               }
              if(months[w].equals("7")){
                   dateAssessed="July";
               }
               if(months[w].equals("8")){
                   dateAssessed="August";
               }
               if(months[w].equals("9")){
                   dateAssessed="September";
               }
               if(months[w].equals("10")){
                   dateAssessed="October";
               }
               if(months[w].equals("11")){
                   dateAssessed="November";
               }
               if(months[w].equals("12")){
                   dateAssessed="December";
               }

 
 rwi.createCell(0).setCellValue(fetchedMonths[w]);
 rwi.createCell(1).setCellValue(dateAssessed);
            }
      
   
}
 
 //______________________________________________________________________________ end of no risk assessments _______________________________________________________________________
 
 
 //______________________________________________________________________________ report generator for risk reduction_______________________________________________________________________
 
 
  else if(reporttype.equalsIgnoreCase("No of Risk Reductions")){
     // for merging cells 
   shet1.addMergedRegion(new CellRangeAddress(2,2,6,9));
  // creating the cells for enrollment   
  cell1=rw4.createCell(0);
   cell2=rw4.createCell(1);
   cell3=rw4.createCell(2);
   cell4=rw4.createCell(3);
   
   
   // cell for row 3
   cell6=rw5.createCell(0);
   cell7=rw5.createCell(1);
   cell8=rw5.createCell(2);
   cell9=rw5.createCell(3);
cell1 .setCellValue("No of Risk Reductions");
cell2.setCellValue("Month Assessed");

// styling the cells

cell1.setCellStyle(style);
cell2.setCellStyle(style);
cell3.setCellStyle(style);
cell4.setCellStyle(style);

cell6.setCellStyle(style_header);
cell7.setCellStyle(style_header);
cell8.setCellStyle(style_header);
cell9.setCellStyle(style_header);

 cell6.setCellValue(" ");
             cell7.setCellValue(" No of Risk Reduction Done for "+DICName+" based on months for the year "+reportyear+"");
String NoofAssess="";
String DatesofAssess="";
 String enrolDate ="";
//  HSSFRow rwi=shet1.createRow(4);
//  rwi.setHeightInPoints(20);
    int totalAssess=0;
String months[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
int fetchedMonths[]= new int[12];
      for(int k=0;k<months.length;k++){  
             String uniqueID="select * from enrollment where DICName='"+DICName+"' ";
            conn.rs=conn.state.executeQuery(uniqueID);
//            System.out.println(uniqueID);
            while(conn.rs.next()){
 String assess="select count(RiskReductionID),DOA from riskreductionmain where UniqueID='"+ conn.rs.getString(1)+"' AND MONTH(STR_TO_DATE(DOA, '%e/%c/%Y'))='"+months[k]+"' AND YEAR(STR_TO_DATE(DOA,'%e/%c/%Y')) ='"+reportyear+"' GROUP BY MONTH(DOA)";
         conn.rs1=conn.state1.executeQuery(assess);
//         System.out.println(assess);
         
            while(conn.rs1.next()){
               
                NoofAssess=conn.rs1.getString(1);
//System.out.println("NoofAssess "+NoofAssess);

                DatesofAssess=conn.rs1.getString(2);
                
//                System.out.println("NoofAssess"+ NoofAssess+"DatesofAssess "+DatesofAssess);
                
               totalAssess+=Integer.parseInt(NoofAssess);

                 fetchedMonths[k]=totalAssess;
                 
               
               }//while
            
            }//while
         
          System.out.println(fetchedMonths[k]+" for "+months[k]);
            totalAssess=0;
     
             }//for
          int y=0 ;
       for(int w=0;w<fetchedMonths.length;w++){
                y++;
            System.out.print(fetchedMonths[w]+"fetched months");
            System.out.println(months[w]);
            int counts1=0;
            counts1=y+3;
 HSSFRow rwi=shet1.createRow(counts1);       
//   rwi.createCell(1).setCellValue(i-3);
 rwi.setHeightInPoints(20);
String dateAssessed="";
 
  if(months[w].equals("1")){
                   dateAssessed="January";
               }
               if(months[w].equals("2")){
                   dateAssessed="February";
               }
               if(months[w].equals("3")){
                   dateAssessed="March";
               }
               if(months[w].equals("4")){
                   dateAssessed="April";
               }
               else if(months[w].equals("5")){
                   dateAssessed="May";
               }
                if(months[w].equals("6")){
                   dateAssessed="June";
               }
              if(months[w].equals("7")){
                   dateAssessed="July";
               }
               if(months[w].equals("8")){
                   dateAssessed="August";
               }
               if(months[w].equals("9")){
                   dateAssessed="September";
               }
               if(months[w].equals("10")){
                   dateAssessed="October";
               }
               if(months[w].equals("11")){
                   dateAssessed="November";
               }
               if(months[w].equals("12")){
                   dateAssessed="December";
               }

 
 rwi.createCell(0).setCellValue(fetchedMonths[w]);
 rwi.createCell(1).setCellValue(dateAssessed);
            }
      
   
}
//__________________________________________________________________________End of Risk reduction report__________________________________________________________________________________________________________________________

 
//__________________________________________________________________________BEGINNING OF QUESTION REPORTS__________________________________________________________________________________________________________________________
  else if(reporttype.equalsIgnoreCase("Risk Assessments")){
  
       // for merging cells 
   shet1.addMergedRegion(new CellRangeAddress(2,2,6,9));
  // creating the cells for enrollment   
  cell1=rw4.createCell(0);
   cell2=rw4.createCell(1);
   cell3=rw4.createCell(2);
   cell4=rw4.createCell(3);
     
   // cell for row 3
   cell6=rw5.createCell(0);
   cell7=rw5.createCell(1);
   cell8=rw5.createCell(2);
   cell9=rw5.createCell(3);

// styling the cells

cell1.setCellStyle(style);
cell2.setCellStyle(style);
cell3.setCellStyle(style);
cell4.setCellStyle(style);
// header for each column
cell1 .setCellValue("NO.");
cell2.setCellValue("ANSWERS");

cell6.setCellStyle(stylex);
cell7.setCellStyle(stylex);
cell8.setCellStyle(stylex);
cell9.setCellStyle(stylex);
String directanswers="";
 String answers="";
 String no="";
            String enrolls="SELECT count(DirectAnswers),DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+question+"' AND AssessmentID"
                    + " IN(SELECT AssessmentID FROM riskassessmentmain WHERE UniqueID "
                    + "IN(SELECT UniqueID FROM enrollment WHERE DICName='"+DICName+"')) GROUP BY DirectAnswers ORDER BY count(DirectAnswers)";
                 conn.rs=conn.state.executeQuery(enrolls);
            while(conn.rs.next()){
                 count++;
                no=conn.rs.getString(1);
                answers=conn.rs.getString(2);
                 if(question.equalsIgnoreCase("A")){
                     
                      String querylast = "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code where LastSex_CodeID='"+answers+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querylast);
                                                              
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("LastSex_Code"); 
                                                                }
            cell6.setCellValue("");
            cell7.setCellValue("Statistics for question on ' When did you last have sexual intercourse?' for "+DICName+" DIC ");
            
                 
                 }
                 else if(question.equalsIgnoreCase("D")){
                     
                      String querylast = "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code where LastSex_CodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querylast);
                                                             while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("LastSex_Code"); 
                                                                }
                 
              cell6.setCellValue("");
              cell7.setCellValue("Statistics for question on 'When was the last time you had sex with a paying partner?' for "+DICName+" DIC ");
                 }
                   else if(question.equalsIgnoreCase("I1")){
                  String querybehaviour =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querybehaviour);
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("BehavioursCode"); 
                                                                }
                     cell6.setCellValue("");
                     cell7.setCellValue("Statistics for question on 'How often do you practice the following behaviors?- Vaginal Sex' for "+DICName+" DIC  ");
                   }
                   else if(question.equalsIgnoreCase("I2")){
                  String querybehaviour =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querybehaviour);
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("BehavioursCode"); 
                                                                }
                   cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'How often do you practice the following behaviors?-Oral Sex' for "+DICName+" for DIC  ");
                   }
                   else if(question.equalsIgnoreCase("I3")){
                  String querybehaviour =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querybehaviour);
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("BehavioursCode"); 
                     cell6.setCellValue("");                                            }
                   cell7.setCellValue("Statistics for question on 'How often do you practice the following behaviors?-Anal Sex' for "+DICName+" for  DIC  ");
                   }
                   else if(question.equalsIgnoreCase("J1")){
                  String querybehaviour =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querybehaviour);
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("BehavioursCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'How often do you use condoms when engaging in the following?-Vaginal Sex' for "+DICName+" DIC");
                   }
                   else if(question.equalsIgnoreCase("J")){
                  String querybehaviour =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querybehaviour);
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("BehavioursCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'How often do you use condoms when engaging in the following?-Oral Sex' for "+DICName+" DIC ");
                   }
                   else if(question.equalsIgnoreCase("L3")){
                String queryvenue =  "SELECT CondomCode,CondomCodeID FROM condomcode where CondomCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                               
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("CondomCode"); 
                                                                }
                 cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'How often do you use condoms when engaging in the following?-Anal Sex' for "+DICName+" DIC ");

                   }
                   else if(question.equalsIgnoreCase("N2")){
                   String queryvenue = "SELECT STITreatment_Code,STITreatment_CodeID FROM stitreatment_code where STITreatment_CodeID='"+answers+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("STITreatment_Code"); 
                                                                }
                                                                cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Place treated for STI/HIV Signs' for "+DICName+" DIC ");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("P4")){
                   String queryvenue = "SELECT FPMethods_Code,FPMethods_CodeID FROM fpmethods_code where FPMethods_CodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                              
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("FPMethods_Code"); 
                                                                }
                                                                cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Family Planning Methods Used' for "+DICName+" DIC");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("Q2")){
                   String queryalcohol =  "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes where Alcohol_CodesID='"+answers+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String alcoholcodes="";
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("Alcohol_Codes"); 
                                                                }
                                                                cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Family Planning Methods Used' for "+DICName+" DIC  ");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("R3")){
                   String queryalcohol =  "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes where Alcohol_CodesID='"+answers+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                               while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("Alcohol_Codes"); 
                                                                }
                                                                cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Family Planning Methods Used' for "+DICName+" DIC ");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("T2")){
                    String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                  while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("AbuseCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'The last time you were beaten or seriously threatened by your partner or anyone' for "+DICName+" DIC ");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("T4")){
                    String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                  while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("AbuseCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'The last time raped by your partner or any other person?' for "+DICName+" DIC ");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("T6")){
                    String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                  while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("AbuseCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'The last time your partner deliberately deprived you of economic support?' for "+DICName+" DIC ");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("T8")){
                    String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                  while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("AbuseCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'The last time your partner deliberately say or do bad things in order to hurt you?' for "+DICName+" DIC");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("T10")){
                    String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                  while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("AbuseCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'The last time your partner related problems affect your use of condoms,FP or seeking health services through disclosure and adherence to treatment' for "+DICName+" DIC");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("U2")){
                     String queryalcohol =  "SELECT PlaceTreated_Code,PlaceTreated_CodeID FROM placetreated_code where PlaceTreated_CodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                               
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("PlaceTreated_Code"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Place treatment was seeked after Sexual and Gender Based Violence' for "+DICName+" DIC");
                                                                 
                   }
                   else if(question.equalsIgnoreCase("V2")){
                     String queryalcohol =  "SELECT ReportCode,ReportCodeID FROM reportCode where ReportCodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                               while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("ReportCode"); 
                                                                }
                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Place reported after Sexual and Gender Based Violence' for "+DICName+" DIC ");
                                                                 
                   }
                   else{

                       String directans="";
                       String questions = "select * from questions where QuestionsID='"+question+"'";
                       conn.rs3= conn.state1.executeQuery(questions);
                       while(conn.rs3.next()){
                            directans=conn.rs3.getString(5);
                       }
                   directanswers=answers;
                   cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on '"+directans+"' for "+DICName+" DIC ");
                   
                   }
//   
                                     
System.out.println("ans"+directanswers);
int counts =0;
counts=count+3;
HSSFRow rwi=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rwi.setHeightInPoints(20);

 rwi.createCell(0).setCellValue(no);
 rwi.createCell(1).setCellValue(directanswers);

  
               
            }
            
//             cell6.setCellValue("No of Products ");
//             cell7.setCellValue(" for"+dic+" based on months "+reportyear+"");
 } 
//_________________________________________________________________end of risk assessment reports ____________________________________________________________________________

  
  //_________________________________________________________________beginining of risk reduction reports ____________________________________________________________________________
 

 else if(reporttype.equalsIgnoreCase("Risk Reductions")){
  
       // for merging cells 
   shet1.addMergedRegion(new CellRangeAddress(2,2,6,9));
  // creating the cells for enrollment   
   cell1=rw4.createCell(0);
   cell2=rw4.createCell(1);
   cell3=rw4.createCell(2);
   cell4=rw4.createCell(3);
   
   
   // cell for row 3
   cell6=rw5.createCell(0);
   cell7=rw5.createCell(1);
   cell8=rw5.createCell(2);
   cell9=rw5.createCell(3);

// styling the cells

cell1.setCellStyle(style);
cell2.setCellStyle(style);
cell3.setCellStyle(style);
cell4.setCellStyle(style);

cell6.setCellStyle(stylex);
cell7.setCellStyle(stylex);
cell8.setCellStyle(stylex);
cell9.setCellStyle(stylex);

 cell1 .setCellValue("NO.");
 cell2.setCellValue("ANSWERS");
 
 String directanswers="";
 String answers="";
 String action="";
 String no="";
 String num="";
            String enrolls="SELECT count(currentStatus),currentStatus,count(Action),Action,Appointments FROM riskreductiondetails WHERE QID='"+questionRed+"' AND RiskReductionID"
                    + " IN(SELECT RiskReductionID FROM riskreductionmain WHERE UniqueID "
                    + "IN(SELECT UniqueID FROM enrollment WHERE DICName='"+DICName+"')) GROUP BY currentStatus ORDER BY count(currentStatus)";
                 conn.rs=conn.state.executeQuery(enrolls);
                 
                 System.out.println(enrolls);
            while(conn.rs.next()){
                 count++;
                no=conn.rs.getString(1);
                answers=conn.rs.getString(2);

                int counts =0;
                counts=count+3;


 if(questionRed.equalsIgnoreCase("B1")){
                  String querystatus=  "SELECT currentStatusID,currentStatus FROM currentStatus where currentStatusID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                               
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("currentStatus"); 
                                                               }


                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on '100% Condom use with paying partners' for "+DICName+" DIC ");
                                                                 
                   }
 else if(questionRed.equalsIgnoreCase("B2")){
                  String querystatus=  "SELECT currentStatusID,currentStatus FROM currentStatus where currentStatusID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                               
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("currentStatus"); 
                                                                }

                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on '100% condom use with non-paying partner(s)' for "+DICName+" DIC ");
                                                                 
                   }
 else if(questionRed.equalsIgnoreCase("B3")){
                  String querystatus=  "SELECT currentStatusID,currentStatus FROM currentStatus where currentStatusID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                                String statuscodes="";
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("currentStatus"); 
                                                                }

                  cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Water-Based Lubricants' for "+DICName+" DIC ");
                                                                 
 }
  else if(questionRed.equalsIgnoreCase("D1")){
                   String querystatus=  "SELECT Knowledge_CodeID,Knowledge_Code FROM knowledge_code where Knowledge_CodeID='"+answers+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                               
                                                                while(conn.rs2.next()){
                                                                 directanswers=  conn.rs2.getString("Knowledge_Code"); 
                                                                   cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on 'Knowledge on HIV,STIs,FP,TB' for "+DICName+" DIC ");
                                                                }
  }
 else {
                  String directans="";
                       String questions = "select * from questions where QuestionsID='"+questionRed+"'";
                       conn.rs3= conn.state1.executeQuery(questions);
                       while(conn.rs3.next()){
                            directans=conn.rs3.getString(5);
                       }
                 
                  directanswers=answers;
                  
                   cell6.setCellValue("");
                  cell7.setCellValue("Statistics for question on '"+directans+"' for "+DICName+" DIC.");
                   
                   }

HSSFRow rwi=shet1.createRow(counts);       
rwi.setHeightInPoints(20);

 rwi.createCell(0).setCellValue(no);
 rwi.createCell(1).setCellValue(directanswers);

       }
            

 } 
 
 
 //_________________________________________________________________end of risk reduction reports ____________________________________________________________________________
 
 
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
//response.sendRedirect("index.jsp");
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
            Logger.getLogger(EnrollmentReport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EnrollmentReport.class.getName()).log(Level.SEVERE, null, ex);
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
