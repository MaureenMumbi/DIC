/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import dbConnect.AES;

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
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Maureen
 */
@WebServlet(name = "RawData", urlPatterns = {"/RawData"})
public class RawData extends HttpServlet {
HttpSession session;
    
     int a=1;
            int count=0;
            int counter=0;
            int counter1=0;
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InvalidFormatException {
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
        try {
            dbConnect conn = new dbConnect();
          session=request.getSession();
          if(session.getAttribute("lockNames")!=null){
          System.out.println("status : "+session.getAttribute("lockNames").toString());
          }
         String startdate="";
          String enddate="";
          String type="";
          String district="";
          String month="";
          String targets ="";
          int qtr=0;
          String quarters="";
             String uniqueid="";
        String riskreductionid="";
        String riskassessmentid="";
        String DOA="";
        String cadre="";
        String dicname="";
        String districts="";
        String QID="";
             startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
         // period= "monthly";
          type= request.getParameter("type");
           counter=1;
           counter1=1;
           a=1;
           // dbConnect  conn = new dbConnect();
                XSSFCell cell,cell0,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
                XSSFWorkbook wb=new XSSFWorkbook();
//           String allpath="";   
//           String allpath = getServletContext().getRealPath("/enrollment.xlsm");

                
//                XSSFWorkbook wb;
//
//wb = new XSSFWorkbook(OPCPackage.open(allpath));

                XSSFSheet shet1=wb.createSheet();
                XSSFRow rw1=shet1.createRow(1);
         rw1.setHeightInPoints(60);
    
          XSSFFont font_header=wb.createFont();
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
                XSSFFont fonts = wb.createFont();
                fonts.setColor(HSSFColor.BLACK.index);
                fonts.setFontName("cambria");
                fonts.setFontHeightInPoints((short) 11);
            indicator_style.setFont(fonts);
            indicator_style.setBorderBottom(CellStyle.BORDER_THIN);
            indicator_style.setBorderLeft(CellStyle.BORDER_THIN);
            indicator_style.setBorderRight(CellStyle.BORDER_THIN);
            indicator_style.setBorderTop(CellStyle.BORDER_THIN);
            indicator_style.setAlignment(CellStyle.ALIGN_LEFT);
            //Cell Style header known as "cell"
             CellStyle cell_styles = wb.createCellStyle();
           
            cell_styles.setFillForegroundColor(HSSFColor.WHITE.index);
            cell_styles.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                XSSFFont fonts2 = wb.createFont();
                fonts2.setColor(HSSFColor.BLACK.index);
                fonts2.setFontName("cambria");
                fonts2.setFontHeightInPoints((short) 11);
            cell_styles.setFont(fonts2);
            cell_styles.setBorderBottom(CellStyle.BORDER_THIN);
            cell_styles.setBorderLeft(CellStyle.BORDER_THIN);
            cell_styles.setBorderRight(CellStyle.BORDER_THIN);
            cell_styles.setBorderTop(CellStyle.BORDER_THIN);
            cell_styles.setAlignment(CellStyle.ALIGN_LEFT);
          
            //Style known as "cell_style"
//            CellStyle cell_style = wb.createCellStyle();
          
          
//                XSSFFont fonts1 = wb.createFont();
//                fonts1.setColor(HSSFColor.BLACK.index);
//                fonts1.setFontHeightInPoints((short) 11);
//            cell_style.setFont(fonts1);
//            cell_style.setBorderBottom(CellStyle.BORDER_THIN);
//            cell_style.setBorderLeft(CellStyle.BORDER_THIN);
//            cell_style.setBorderRight(CellStyle.BORDER_THIN);
//            cell_style.setBorderTop(CellStyle.BORDER_THIN);
//                     
                      
                       
                        
   
     
      shet1.setColumnWidth(0, 8000 ); 
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
    shet1.setColumnWidth(11, 4000);
    shet1.setColumnWidth(12, 4000);
    shet1.setColumnWidth(13, 4000);
    shet1.setColumnWidth(14, 4000);
    shet1.setColumnWidth(15, 4000);
    shet1.setColumnWidth(16, 4000);
    shet1.setColumnWidth(17, 4000);
    shet1.setColumnWidth(18, 4000);
    
    shet1.setColumnWidth(19, 4000);
    shet1.setColumnWidth(20, 4000);
    shet1.setColumnWidth(21, 4000);
    
    shet1.setColumnWidth(22, 4000);
    shet1.setColumnWidth(23, 4000);
    shet1.setColumnWidth(24, 4000);
    shet1.setColumnWidth(25, 4000);
    shet1.setColumnWidth(26, 4000);
    shet1.setColumnWidth(27, 4000);
    shet1.setColumnWidth(28, 4000);
    shet1.setColumnWidth(29, 4000);
    shet1.setColumnWidth(30, 4000);
    shet1.setColumnWidth(31, 4000);
    shet1.setColumnWidth(32, 4000);
    shet1.setColumnWidth(33, 4000);
    shet1.setColumnWidth(34, 4000);
    shet1.setColumnWidth(35, 4000);
    shet1.setColumnWidth(36, 4000);
    shet1.setColumnWidth(37, 4000);
    shet1.setColumnWidth(38, 4000);
    shet1.setColumnWidth(39, 4000);
    shet1.setColumnWidth(40, 4000);
    shet1.setColumnWidth(41, 4000);
    shet1.setColumnWidth(42, 4000);
    shet1.setColumnWidth(43, 4000);
    shet1.setColumnWidth(44, 4000);
    shet1.setColumnWidth(45, 4000);
    shet1.setColumnWidth(46, 4000);
    shet1.setColumnWidth(47, 4000);
    shet1.setColumnWidth(48, 4000);
    shet1.setColumnWidth(49, 4000);
    shet1.setColumnWidth(50, 4000);
    shet1.setColumnWidth(51, 4000);
    shet1.setColumnWidth(52, 4000);
    shet1.setColumnWidth(53, 4000);
    shet1.setColumnWidth(54, 4000);
    shet1.setColumnWidth(55, 4000);
    shet1.setColumnWidth(56, 4000);
    shet1.setColumnWidth(57, 4000);
    shet1.setColumnWidth(58, 4000);
    shet1.setColumnWidth(59, 4000);
    shet1.setColumnWidth(60, 4000);
    shet1.setColumnWidth(61, 4000);
    shet1.setColumnWidth(62, 4000);
    shet1.setColumnWidth(63, 4000);
    shet1.setColumnWidth(64, 4000);
    shet1.setColumnWidth(65, 4000);
    shet1.setColumnWidth(66, 4000);
                
              
            /* TODO output your page here. You may use following sample code. */
       //  for(int y=0;y<districts.length;y++){
//        ArrayList dics = new ArrayList();
//
//                     String dicnames="select * from dicname";
//conn.rs6 = conn.state6.executeQuery(dicnames);
//while(conn.rs6.next()){  
//  dics.add(conn.rs6.getString("DICName"));  
//   System.out.println(dics.get(0));
//  // diccount++;
//   
//}
        //}
//    for(int e=0;e<dics.size();e++){ 
    String year[];
    year = startdate.split("/");
     
    if(type.equals("all")){
        
                   cell = rw1.createCell(0);
                     cell.setCellValue("UniqueID");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("ClientInit ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("DOE");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("District");
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("DICName ");
                        cell4 = rw1.createCell(5);
                     cell4.setCellValue("DOB ");
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("Sex ");
                        cell4 = rw1.createCell(7);
                     cell4.setCellValue("Age ");
                        cell4 = rw1.createCell(8);
                     cell4.setCellValue("MaritalStatus");
                        cell4 = rw1.createCell(9);
                     cell4.setCellValue("Children");
                        cell4 = rw1.createCell(10);
                     cell4.setCellValue("ChildNo");
                        cell4 = rw1.createCell(11);
                     cell4.setCellValue("Religion");
                        cell4 = rw1.createCell(12);
                     cell4.setCellValue("EducationLevel");
                     
                    if(session.getAttribute("lockNames")==null){
                          shet1.setColumnWidth(13, 0);
                           cell4 = rw1.createCell(13);
                           cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                           shet1.setColumnWidth(13, 0);
                           cell4 = rw1.createCell(13);
                           cell4.setCellValue("");    
                           }
                           else{
                    cell4 = rw1.createCell(13);
                     cell4.setCellValue("PhoneNo");
                       }
                       } 
                    
                        cell4 = rw1.createCell(14);
                     cell4.setCellValue("Residence");
                        cell4 = rw1.createCell(15);
                     cell4.setCellValue("DICLearn");
                      if(session.getAttribute("lockNames")==null){
                          shet1.setColumnWidth(16, 0);
                          cell4 = rw1.createCell(16);
                          cell4.setCellValue("");
                         
                      
                           shet1.setColumnWidth(17, 0);
                           cell4 = rw1.createCell(17);
                           cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                           shet1.setColumnWidth(16, 0);
                          cell4 = rw1.createCell(16);
                          cell4.setCellValue("");
                          
                           shet1.setColumnWidth(17, 0);
                           cell4 = rw1.createCell(17);
                           cell4.setCellValue("");    
                           }
                           else{
                        
                        cell4 = rw1.createCell(16);
                     cell4.setCellValue("Email");
                        cell4 = rw1.createCell(17);
                     cell4.setCellValue("PhoneNo1");
                       }
                       }
                     
                     
                        cell4 = rw1.createCell(18);
                     cell4.setCellValue("Venue");
                     
     if(session.getAttribute("lockNames")==null){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);
    cell4 = rw1.createCell(19);
    cell4.setCellValue("");
    cell4 = rw1.createCell(20);
    cell4.setCellValue("");
    cell4 = rw1.createCell(21);
    cell4.setCellValue("");
    System.out.println("No session");
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);
    cell4 = rw1.createCell(19);
    cell4.setCellValue("");
    cell4 = rw1.createCell(20);
    cell4.setCellValue("");
    cell4 = rw1.createCell(21);
    cell4.setCellValue(""); 
      System.out.println("yess ");
                                }
                                else{
  System.out.println("Noooo ");
                        cell4 = rw1.createCell(19);
                     cell4.setCellValue("FirstName");
                        cell4 = rw1.createCell(20);
                     cell4.setCellValue("SecondName");
                        cell4 = rw1.createCell(21);
                     cell4.setCellValue("LastName");
                                }
     }
                     
                        cell4 = rw1.createCell(22);
                     cell4.setCellValue("venueOther");
                        cell4 = rw1.createCell(23);
                     cell4.setCellValue("DicLearnOther");
                        cell4 = rw1.createCell(24);
                     cell4.setCellValue("Cadre");
                        cell4 = rw1.createCell(25);
                     cell4.setCellValue("RiskRedID");
                        cell4 = rw1.createCell(26);
                     cell4.setCellValue("UniqueIDs1");
                        cell4 = rw1.createCell(26);
                     cell4.setCellValue("Date");
                        cell4 = rw1.createCell(27);
                     cell4.setCellValue("CasualCdUse");
                        cell4 = rw1.createCell(28);
                     cell4.setCellValue("CdProvided");
                        cell4 = rw1.createCell(29);
                     cell4.setCellValue("RegCdUse");
                        cell4 = rw1.createCell(30);
                     cell4.setCellValue("RegCdAction");
                        cell4 = rw1.createCell(31);
                     cell4.setCellValue("WBLubricant");
                        cell4 = rw1.createCell(32);
                     cell4.setCellValue("WBLubAction");
                        cell4 = rw1.createCell(33);
                     cell4.setCellValue("AlDrugUseAction");
                        cell4 = rw1.createCell(34);
                     cell4.setCellValue("XSFTKnowToday");
                        cell4 = rw1.createCell(35);
                     cell4.setCellValue("XSFTKnowTodayAction");
                        cell4 = rw1.createCell(36);
                     cell4.setCellValue("XSFTAppointment");
                        cell4 = rw1.createCell(37);
                     cell4.setCellValue("XSFTAppointmentAction");
                        cell4 = rw1.createCell(38);
                     cell4.setCellValue("HIVTodayTest");
                        cell4 = rw1.createCell(39);
                     cell4.setCellValue("HIVTodayTestStatus");
                        cell4 = rw1.createCell(40);
                     cell4.setCellValue("HIVTodayTestAction");
                        cell4 = rw1.createCell(41);
                     cell4.setCellValue("HIVTestPart");
                        cell4 = rw1.createCell(42);
                     cell4.setCellValue("HIVTodayPartTestStatus");
                        cell4 = rw1.createCell(43);
                     cell4.setCellValue("HIVTestPartAction");
                        cell4 = rw1.createCell(44);
                     cell4.setCellValue("STICheck");
                        cell4 = rw1.createCell(45);
                     cell4.setCellValue("STICheckAction");
                        cell4 = rw1.createCell(46);
                     cell4.setCellValue("STINextCheck");
                        cell4 = rw1.createCell(47);
                     cell4.setCellValue("STINextCheckAction");
                        cell4 = rw1.createCell(48);
                     cell4.setCellValue("CCScreening");
                        cell4 = rw1.createCell(49);
                     cell4.setCellValue("CCAppointment");
                        cell4 = rw1.createCell(50);
                     cell4.setCellValue("CCAppointmentAction");
                        cell4 = rw1.createCell(51);
                     cell4.setCellValue("TBCheck");
                        cell4 = rw1.createCell(52);
                     cell4.setCellValue("TBCheckAction");
                        cell4 = rw1.createCell(53);
                     cell4.setCellValue("NextAppt");
                        cell4 = rw1.createCell(54);
                     cell4.setCellValue("NextApptAction");
                        cell4 = rw1.createCell(55);
                     cell4.setCellValue("GBVCheck");
                        cell4 = rw1.createCell(56);
                     cell4.setCellValue("GBVCheckAction");
                        cell4 = rw1.createCell(57);
                     cell4.setCellValue("FPCurrentMethod");
                        cell4 = rw1.createCell(58);
                     cell4.setCellValue("FPCurrMAction");
                        cell4 = rw1.createCell(59);
                     cell4.setCellValue("FPMethod");
                        cell4 = rw1.createCell(60);
                     cell4.setCellValue("FPMethodAction");
                        cell4 = rw1.createCell(61);
                     cell4.setCellValue("FPMethodType");
                        cell4 = rw1.createCell(62);
                     cell4.setCellValue("FPMethodTypeAction");
                        cell4 = rw1.createCell(63);
                     cell4.setCellValue("NoMethod");
                        cell4 = rw1.createCell(64);
                     cell4.setCellValue("NoMethodAction");
                        cell4 = rw1.createCell(65);
                     cell4.setCellValue("AltIncomeSource");
                        cell4 = rw1.createCell(66);
                     cell4.setCellValue("AltIncomeSourceAction");
                        cell4 = rw1.createCell(67);
                     cell4.setCellValue("DONA");
        
   String alldata="select UniqueID, ClientInit,DOE,District,DICName, DOB, Sex, Age,MaritalStatus, Children, ChildNo, "
           + "Religion, EducationLevel, PhoneNo, Residence, DICLearn, Email, "
           + "PhoneNo1, Venue,  FirstName, SecondName, LastName, venueOther, DicLearnOther,"
 + "Cadre, RiskRedID, UniqueIDs1, Date," 
 + "CasualCdUse, CdProvided, RegCdUse, RegCdAction, WBLubricant,WBLubAction, AlDrugUseScore, AlDrugUseAction, XSFTKnowToday,"
 + "XSFTKnowTodayAction, XSFTAppointment, XSFTAppointmentAction,HIVTodayTest, HIVTodayTestStatus, HIVTodayTestAction, HIVTestPart,"
 + "HIVTodayPartTestStatus, HIVTestPartAction, STICheck, STICheckAction,STINextCheck, STINextCheckAction, CCScreening,"
           + " CCScreeningAction, "
 + "CCAppointment, CCAppointmentAction, TBCheck, TBCheckAction, NextAppt, NextApptAction, GBVCheck, GBVCheckAction, "
           + "FPCurrentMethod, FPCurrMAction,"
 + "FPMethod, FPMethodAction, FPMethodType, FPMethodTypeAction, NoMethod, NoMethodAction, "
 + "AltIncomeSource, AltIncomeSourceAction,DONA from enrollment LEFT OUTER JOIN riskreductions2 "
           + "ON enrollment.UniqueID= riskreductions2.UniqueIDs1 and (STR_TO_DATE(DOE, '%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"', '%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"', '%e/%c/%Y')) order by enrollment.UniqueID limit 1000000 ;";

conn.rs = conn.state.executeQuery(alldata);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;

    
    
  XSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs.getString(3));
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(conn.rs.getString(4));
                 cell13=rwa.createCell(4);
                 cell13.setCellValue(conn.rs.getString(5));
                 cell14=rwa.createCell(5);
                 cell14.setCellValue(conn.rs.getString(6));
                 cell14=rwa.createCell(6);
                 cell14.setCellValue(conn.rs.getString(7));
                 cell14=rwa.createCell(7);
                 cell14.setCellValue(conn.rs.getString(8));
                 cell14=rwa.createCell(8);
                 cell14.setCellValue(conn.rs.getString(9));
                 cell14=rwa.createCell(9);
                 cell14.setCellValue(conn.rs.getString(10));
                 cell14=rwa.createCell(10);
                 cell14.setCellValue(conn.rs.getString(11));
                 cell14=rwa.createCell(11);
                 cell14.setCellValue(conn.rs.getString(12));
                 cell14=rwa.createCell(12);
                 cell14.setCellValue(conn.rs.getString(13));
                 if(session.getAttribute("lockNames")==null){
                          shet1.setColumnWidth(13, 0);
                           cell4 = rwa.createCell(13);
                           cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                           shet1.setColumnWidth(13, 0);
                           cell4 = rwa.createCell(13);
                           cell4.setCellValue("");    
                           }
                           else{
                     cell14=rwa.createCell(13);
                 cell14.setCellValue(conn.rs.getString(14));
                       }
                       } 
                
                 
                 cell14=rwa.createCell(14);
                 cell14.setCellValue(conn.rs.getString(15));
                 cell14=rwa.createCell(15);
                 cell14.setCellValue(conn.rs.getString(16));
                 cell14=rwa.createCell(16);
                 cell14.setCellValue(conn.rs.getString(17));
                 cell14=rwa.createCell(17);
                 cell14.setCellValue(conn.rs.getString(18));
                 cell14=rwa.createCell(18);
                 cell14.setCellValue(conn.rs.getString(19));
                  if(session.getAttribute("lockNames")==null){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);

                 cell14=rwa.createCell(19);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(20);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(21);
                 cell14.setCellValue(""); 
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);

                 cell14=rwa.createCell(19);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(20);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(21);
                 cell14.setCellValue("");    
                                }
                                else{
                 cell14=rwa.createCell(19);
                 cell14.setCellValue(conn.rs.getString(20));
                 cell14=rwa.createCell(20);
                 cell14.setCellValue(conn.rs.getString(21));
                 cell14=rwa.createCell(21);
                 cell14.setCellValue(conn.rs.getString(22));
                                }
                  }
                 cell14=rwa.createCell(22);
                 cell14.setCellValue(conn.rs.getString(23));
                 cell14=rwa.createCell(23);
                 cell14.setCellValue(conn.rs.getString(24));
                 cell14=rwa.createCell(24);
                 cell14.setCellValue(conn.rs.getString(25));
                 cell14=rwa.createCell(25);
                 cell14.setCellValue(conn.rs.getString(26));
                 cell14=rwa.createCell(26);
                 cell14.setCellValue(conn.rs.getString(27));
                 cell14=rwa.createCell(27);
                 cell14.setCellValue(conn.rs.getString(28));
                 cell14=rwa.createCell(28);
                 cell14.setCellValue(conn.rs.getString(29));
                 cell14=rwa.createCell(29);
                 cell14.setCellValue(conn.rs.getString(30));
                 cell14=rwa.createCell(30);
                 cell14.setCellValue(conn.rs.getString(31));
                 cell14=rwa.createCell(31);
                 cell14.setCellValue(conn.rs.getString(32));
                 cell14=rwa.createCell(32);
                 cell14.setCellValue(conn.rs.getString(33));
                 cell14=rwa.createCell(33);
                 cell14.setCellValue(conn.rs.getString(34));
                 cell14=rwa.createCell(34);
                 cell14.setCellValue(conn.rs.getString(35));
                 cell14=rwa.createCell(35);
                 cell14.setCellValue(conn.rs.getString(36));
                 cell14=rwa.createCell(36);
                 cell14.setCellValue(conn.rs.getString(37));
                 cell14=rwa.createCell(37);
                 cell14.setCellValue(conn.rs.getString(38));
                 cell14=rwa.createCell(38);
                 cell14.setCellValue(conn.rs.getString(39));
                 cell14=rwa.createCell(39);
                 cell14.setCellValue(conn.rs.getString(40));
                 cell14=rwa.createCell(40);
                 cell14.setCellValue(conn.rs.getString(41));
                 cell14=rwa.createCell(41);
                 cell14.setCellValue(conn.rs.getString(42));
                 cell14=rwa.createCell(42);
                 cell14.setCellValue(conn.rs.getString(43));
                 cell14=rwa.createCell(43);
                 cell14.setCellValue(conn.rs.getString(44));
                 cell14=rwa.createCell(44);
                 cell14.setCellValue(conn.rs.getString(45));
                 cell14=rwa.createCell(45);
                 cell14.setCellValue(conn.rs.getString(46));
                 cell14=rwa.createCell(46);
                 cell14.setCellValue(conn.rs.getString(47));
                 cell14=rwa.createCell(47);
                 cell14.setCellValue(conn.rs.getString(48));
                 cell14=rwa.createCell(48);
                 cell14.setCellValue(conn.rs.getString(49));
                 cell14=rwa.createCell(49);
                 cell14.setCellValue(conn.rs.getString(50));
                 cell14=rwa.createCell(50);
                 cell14.setCellValue(conn.rs.getString(51));
                 cell14=rwa.createCell(51);
                 cell14.setCellValue(conn.rs.getString(52));
                 cell14=rwa.createCell(52);
                 cell14.setCellValue(conn.rs.getString(53));
                 cell14=rwa.createCell(53);
                 cell14.setCellValue(conn.rs.getString(54));
                 cell14=rwa.createCell(54);
                 cell14.setCellValue(conn.rs.getString(55));
                 cell14=rwa.createCell(55);
                 cell14.setCellValue(conn.rs.getString(56));
                 cell14=rwa.createCell(56);
                 cell14.setCellValue(conn.rs.getString(57));
                 cell14=rwa.createCell(57);
                 cell14.setCellValue(conn.rs.getString(58));
                 cell14=rwa.createCell(58);
                 cell14.setCellValue(conn.rs.getString(59));
                 cell14=rwa.createCell(59);
                 cell14.setCellValue(conn.rs.getString(60));
                 cell14=rwa.createCell(60);
                 cell14.setCellValue(conn.rs.getString(61));
                 cell14=rwa.createCell(61);
                 cell14.setCellValue(conn.rs.getString(62));
                 cell14=rwa.createCell(62);
                 cell14.setCellValue(conn.rs.getString(63));
                 cell14=rwa.createCell(63);
                 cell14.setCellValue(conn.rs.getString(64));
                 cell14=rwa.createCell(64);
                 cell14.setCellValue(conn.rs.getString(65));
                 cell14=rwa.createCell(65);
                 cell14.setCellValue(conn.rs.getString(66));
                 cell14=rwa.createCell(66);
                 cell14.setCellValue(conn.rs.getString(67));
               
                  //cell12.setCellStyle(cell_style);

}



//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=RiskAssessments.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
    }
    
    if(type.equals("riskreductions")){
   
        
//        Cadre,RiskRedID,UniqueIDs1,Date,districts1,dicnames1,CasualCdUse, CdProvided,  RegCdUse, RegCdAction,"
//        + " WBLubricant, WBLubAction, AlDrugUseScore, AlDrugUseAction,XSFTKnowToday,XSFTKnowTodayAction,"
//        + " XSFTAppointment, XSFTAppointmentAction, HIVTodayTest, HIVTodayTestAction, HIVTestPart, HIVTestPartAction,"
//        + " STICheck, STICheckAction, STINextCheck, STINextCheckAction, CCScreening, CCScreeningAction,"
//        + "CCAppointment, CCAppointmentAction, TBCheck, TBCheckAction, NextAppt, NextApptAction, GBVCheck, GBVCheckAction, "
//        + "FPCurrentMethod, FPCurrMAction, FPMethod, FPMethodAction, FPMethodType, FPMethodTypeAction,NoMethod"
//        + ", NoMethodAction, AltIncomeSource, AltIncomeSourceAction,DONA
//   
        
           
counter1=2;
  XSSFRow rwa=shet1.createRow(2);
         cell = rw1.createCell(0);
                     cell.setCellValue("UniqueID");
                      cell.setCellStyle(indicator_style); 
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DOA ");
                      cell2.setCellStyle(indicator_style); 
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("CADRE");
                      cell3.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(3);
                         cell4.setCellStyle(indicator_style); 
                     cell4.setCellValue("COUNTY");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("DIC NAME ");
                      cell4.setCellStyle(indicator_style); 

                     //b1
                      cell4 = rw1.createCell(5);
                     cell4.setCellValue("CasualCdUse");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("CdProvided");
                      cell4.setCellStyle(indicator_style); 
                     //b2
                        cell4 = rw1.createCell(7);
                     cell4.setCellValue("RegCdUse");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(8);
                     cell4.setCellValue("RegCdAction");
                      cell4.setCellStyle(indicator_style); 
                       
                     //b3
                        cell4 = rw1.createCell(9);
                     cell4.setCellValue("WBLubricant");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(10);
                     cell4.setCellValue("WBLubAction");
                      cell4.setCellStyle(indicator_style); 
                    // c
                        cell4 = rw1.createCell(11);
                     cell4.setCellValue("AlDrugUseScore");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(12);
                     cell4.setCellValue("AlDrugUseAction");
                      cell4.setCellStyle(indicator_style); 
                      
                      //d1 
                       cell4 = rw1.createCell(13);
                     cell4.setCellValue("XSFTKnowToday");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(14);
                     cell4.setCellValue("XSFTKnowTodayAction");
                      cell4.setCellStyle(indicator_style); 
                      
                      //d2  
                       cell4 = rw1.createCell(15);
                     cell4.setCellValue("XSFTAppointment");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(16);
                     cell4.setCellValue("XSFTAppointmentAction");
                      cell4.setCellStyle(indicator_style); 
                     //e1
                        cell4 = rw1.createCell(17);
                     cell4.setCellValue("HIVTodayTest");
                      cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(18);
                     cell4.setCellValue("HIVTodayTestAction");
                      cell4.setCellStyle(indicator_style); 
                     
                      
                     
                       cell4 = rw1.createCell(19);
                     cell4.setCellValue("hiv action taken");
                      cell4.setCellStyle(indicator_style); 
//                      shet1.addMergedRegion(new CellRangeAddress(1,1,18,20)); 
         
                     
                     //e2
                        cell4 = rw1.createCell(20);
                     cell4.setCellValue("HIVTestPart");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(21);
                     cell4.setCellValue("HIVTestPartAction");
                      cell4.setCellStyle(indicator_style); 
                     //f1
                        cell4 = rw1.createCell(22);
                     cell4.setCellValue("STICheck");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(23);
                     cell4.setCellValue("STICheckAction");
                      cell4.setCellStyle(indicator_style); 
                     //f2
                        cell4 = rw1.createCell(24);
                     cell4.setCellValue("STINextCheck");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(25);
                     cell4.setCellValue("STINextCheckAction");
                      cell4.setCellStyle(indicator_style); 
                     
                     //g1
                        cell4 = rw1.createCell(26);
                     cell4.setCellValue("CCScreening");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(27);
                     cell4.setCellValue("CCScreeningAction");
                      cell4.setCellStyle(indicator_style); 
                     //g2
                        cell4 = rw1.createCell(28);
                     cell4.setCellValue("CCAppointment");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(29);
                     cell4.setCellValue("CCAppointmentAction");
                      cell4.setCellStyle(indicator_style); 
                     
                     //h1
                        cell4 = rw1.createCell(30);
                     cell4.setCellValue("TBCheck");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(31);
                     cell4.setCellValue("TBCheckAction");
                      cell4.setCellStyle(indicator_style); 
                     //h2
                        cell4 = rw1.createCell(32);
                     cell4.setCellValue("NextAppt");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(33);
                     cell4.setCellValue("NextApptAction");
                      cell4.setCellStyle(indicator_style); 
                     
                     //i
                        cell4 = rw1.createCell(34);
                     cell4.setCellValue("GBVCheck");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(35);
                     cell4.setCellValue("GBVCheckAction");
                      cell4.setCellStyle(indicator_style); 
                     //j1
                        cell4 = rw1.createCell(36);
                     cell4.setCellValue("FPCurrentMethod");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(37);
                     cell4.setCellValue("FPCurrMAction");
                      cell4.setCellStyle(indicator_style); 
                     //j2
                        cell4 = rw1.createCell(38);
                     cell4.setCellValue("FPMethod");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(39);
                     cell4.setCellValue("FPMethodAction");
                      cell4.setCellStyle(indicator_style); 
                     //j3
                        cell4 = rw1.createCell(40);
                     cell4.setCellValue("FPMethodType");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(41);
                     cell4.setCellValue("FPMethodTypeAction");
                      cell4.setCellStyle(indicator_style); 
                     //j4
                        cell4 = rw1.createCell(42);
                     cell4.setCellValue("NoMethod");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(43);
                     cell4.setCellValue("NoMethodAction");
                      cell4.setCellStyle(indicator_style); 
                     //k
                        cell4 = rw1.createCell(44);
                     cell4.setCellValue("AltIncomeSource");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(45);
                       cell4.setCellValue("AltIncomeSourceAction");
                        cell4.setCellStyle(indicator_style); 
                       
                       cell4 = rw1.createCell(46);
                       cell4.setCellValue("DONA");
                        cell4.setCellStyle(indicator_style); 
                       
                       cell4 = rw1.createCell(47);
                       cell4.setCellValue("ID");
                       cell4.setCellStyle(indicator_style); 
                
  String query="select * from riskreductionmain,riskreductiondetails where (STR_TO_DATE(DOA, '%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"', '%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"', '%e/%c/%Y')) and  riskreductionmain.riskreductionid=riskreductiondetails.riskreductionid";
          conn.rs = conn.state2.executeQuery(query);
          while(conn.rs.next()){
              counter++;
          uniqueid=conn.rs.getString("uniqueid");
          riskreductionid=conn.rs.getString("riskreductionid");
          DOA=conn.rs.getString("DOA");
          cadre=conn.rs.getString("cadreprovider");
           QID=conn.rs.getString("QID");
            if(QID.equalsIgnoreCase("B1")){
                    rwa = shet1.createRow(counter1);
                       rwa.setHeightInPoints(30); 
                   counter1++;
          }
           
          
          String query3="select dicname,District from enrollment where Uniqueid='"+uniqueid+"'";
          conn.rs3= conn.state4.executeQuery(query3);
          while(conn.rs3.next()){
          dicname=conn.rs3.getString("dicname");
          districts=conn.rs3.getString("District");
          }
            System.out.println("^^^"+a+" hhh "+counter +"  "+count +" "+riskreductionid +" "+uniqueid +" "+DOA +" "+dicname);
//          String alldata="select * from riskreductiondetails where riskreductionid='"+riskreductionid+"'";
//conn.rs = conn.state.executeQuery(alldata);
//System.out.println(alldata);
//while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;

   
    
 
 
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(uniqueid);
                  cell12.setCellStyle(cell_styles); 
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(DOA);
                  cell12.setCellStyle(cell_styles); 
                 cell13=rwa.createCell(2);
                 cell13.setCellValue(cadre);
                 cell13.setCellStyle(cell_styles); 
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(districts);
                  cell13.setCellStyle(cell_styles); 
                 cell13=rwa.createCell(4);
                 cell13.setCellValue(dicname);
                  cell13.setCellStyle(cell_styles); 
                 
                 if(QID.equals("B1")){
                 cell14=rwa.createCell(5);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(6);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("B2")){
                 cell14=rwa.createCell(7);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(8);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                 
                 if(QID.equals("B3")){
                 cell14=rwa.createCell(9);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(10);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("C")){
                 cell14=rwa.createCell(11);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 cell14=rwa.createCell(12);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("D1")){
                  cell14=rwa.createCell(13);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(14);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                
                 if(QID.equals("D2")){
                  cell14=rwa.createCell(15);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(16);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                 
                 
                 
                        }
                 
                 
                 
                   if(QID.equals("E1")){
                  cell14=rwa.createCell(17);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                 
                        }
                   if(QID.equals("QIDE1_0_self") || QID.equals("E1")){
                       if(conn.rs.getString("Action")!=null || !conn.rs.getString("Action").equals("")){
                  cell14=rwa.createCell(18);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                       }
                       else{
                        cell14=rwa.createCell(18);
                 cell14.setCellValue("");
                  cell14.setCellStyle(cell_styles); 
                       }
                        }
                  
                   if(QID.equals("QIDE1_1_self")){
                 
                  cell14=rwa.createCell(19);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("E2")){
                  cell14=rwa.createCell(20);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(21);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("F1")){
                  cell14=rwa.createCell(22);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(23);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("F2")){
                  cell14=rwa.createCell(24);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(25);
                 cell14.setCellValue(conn.rs.getString("Appointments"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("G1")){
                  cell14=rwa.createCell(26);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(27);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("G2")){
                   cell14=rwa.createCell(28);
                 cell14.setCellValue(conn.rs.getString("Appointments"));
                  cell14.setCellStyle(cell_styles); 
                 cell14=rwa.createCell(29);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                  if(QID.equals("H1")){
                  cell14=rwa.createCell(30);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(31);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                  
                   if(QID.equals("H2")){
                
                  cell14=rwa.createCell(32);
                 cell14.setCellValue(conn.rs.getString("Appointments"));
                  cell14.setCellStyle(cell_styles); 
                 
                   cell14=rwa.createCell(33);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("I")){
                  cell14=rwa.createCell(34);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(35);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("J1")){
                  cell14=rwa.createCell(36);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(37);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("J2")){
                  cell14=rwa.createCell(38);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(39);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("J3")){
                  cell14=rwa.createCell(40);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(41);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("J4")){
                  cell14=rwa.createCell(42);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                   cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(43);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("K")){
                  cell14=rwa.createCell(44);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                  cell14.setCellStyle(cell_styles); 
                 
                  cell14=rwa.createCell(45);
                 cell14.setCellValue(conn.rs.getString("Action"));
                  cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("L")){
                  cell14=rwa.createCell(46);
                 cell14.setCellValue(conn.rs.getString("currentStatus"));
                    cell14.setCellStyle(cell_styles); 
                
                        }
               cell13=rwa.createCell(47);
                 cell13.setCellValue(riskreductionid);
                  cell13.setCellStyle(cell_styles); 

}
//          }



    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=RiskReductions_RAWDATA.xlsx");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
    }
    if(type.equals("riskassessment")){
   
counter1=2;
  XSSFRow rwa=shet1.createRow(2);
       
                     cell = rw1.createCell(0);
                     cell.setCellValue("UniqueID");
                           cell.setCellStyle(indicator_style); 
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("Risk Assessment ID  ");
                           cell2.setCellStyle(indicator_style); 
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("DOA");
                           cell3.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("COUNTY");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("DIC NAME ");
      cell4.setCellStyle(indicator_style); 
                     
//                     DOA,RiskAssessID, UniqueIDs,districts,dicnames ,SexLast, CondomUse, SexPartGender, Lasttime, NoPayingClients,
                     //RegPartner, NoRegPartner, TimeRegPartner, PracticeVaginal, PracticeOral, "
//                  + "PracticeAnal, CondomVaginal, CondomOral, CondomAnal, CondomProvider,
                     //HIVPartStatus, NoHIVPartStatus,"
//                   //b1
                      cell4 = rw1.createCell(5);
                     cell4.setCellValue("SexLast A" );
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("CondomUse B");
                           cell4.setCellStyle(indicator_style); 
                      cell4 = rw1.createCell(7);
                     cell4.setCellValue("SexPartGender C");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(8);
                     cell4.setCellValue("Lasttime D");
                           cell4.setCellStyle(indicator_style); 
                     cell4 = rw1.createCell(9);
                     cell4.setCellValue("NoPayingClients E");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(10);
                     cell4.setCellValue("RegPartner F");
                           cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(11);
                     cell4.setCellValue("NoRegPartner G");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(12);
                     cell4.setCellValue("TimeRegPartner H");
                           cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(13);
                     cell4.setCellValue("PracticeVaginal I1");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(14);
                     cell4.setCellValue("PracticeOral I2");
                           cell4.setCellStyle(indicator_style); 
                    cell4 = rw1.createCell(15);
                     cell4.setCellValue("PracticeAnal I3 ");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(16);
                     cell4.setCellValue("CondomVaginal J1");
                           cell4.setCellStyle(indicator_style); 
                      cell4 = rw1.createCell(17);
                     cell4.setCellValue("CondomOral J2");
                           cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(18);
                     cell4.setCellValue("CondomAnal J");
                           cell4.setCellStyle(indicator_style); 
                   cell4 = rw1.createCell(19);
                     cell4.setCellValue("CondomProvider K");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(20);
                     cell4.setCellValue("HIVPartStatus L1");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(21);
                     cell4.setCellValue("NoHIVPartStatus L2");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(22);
                     cell4.setCellValue("PartCondomUse L3");
                           cell4.setCellStyle(indicator_style); 
                     cell4 = rw1.createCell(23);
                     cell4.setCellValue("Dgenitals M1");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(24);
                     cell4.setCellValue("PUrine M2" );
                           cell4.setCellStyle(indicator_style); 
                      cell4 = rw1.createCell(25);
                     cell4.setCellValue("PSex M3");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(26);
                     cell4.setCellValue("SGenitals M4");
                           cell4.setCellStyle(indicator_style); 
                     cell4 = rw1.createCell(27);
                     cell4.setCellValue("GSores M5");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(28);
                     cell4.setCellValue("DiscolorUrine M6");
                           cell4.setCellStyle(indicator_style); 
                    cell4 = rw1.createCell(29);
                     cell4.setCellValue("AbdominalPain M7");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(30);
                     cell4.setCellValue("STISeekTreat N1");
                           cell4.setCellStyle(indicator_style); 
                     cell4 = rw1.createCell(31);
                     cell4.setCellValue("STIPlaceTreated N2 ");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(32);
                     cell4.setCellValue("LubricantUse 01");
                           cell4.setCellStyle(indicator_style); 
                      cell4 = rw1.createCell(33);
                     cell4.setCellValue("KYJelly O2A");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(34);
                     cell4.setCellValue("Saliva 02B");
                           cell4.setCellStyle(indicator_style); 
                    cell4 = rw1.createCell(35);
                     cell4.setCellValue("OtherLubricants 02C");
                             cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(36);
                     cell4.setCellValue("LubUseVaginal 03B");
                           cell4.setCellStyle(indicator_style); 
                      cell4 = rw1.createCell(37);
                     cell4.setCellValue("LubUseAnal O3A"); 
                           cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(38);
                     cell4.setCellValue("Pregnant P1");
                           cell4.setCellStyle(indicator_style); 
                     
                       cell4 = rw1.createCell(39);
                       cell4.setCellValue("HaveKids P2");
                             cell4.setCellStyle(indicator_style); 
                       
                       cell4 = rw1.createCell(40);
                       cell4.setCellValue("UseFP P3");
                             cell4.setCellStyle(indicator_style); 
                       
                         cell4 = rw1.createCell(41);
                       cell4.setCellValue("FPMethodUsed P4");
                             cell4.setCellStyle(indicator_style); 
                       
                        cell4 = rw1.createCell(42);
                     cell4.setCellValue("AlcoholUse Q1");
                           cell4.setCellStyle(indicator_style); 
                     
                     cell4 = rw1.createCell(43);
                     cell4.setCellValue("AlcoholFrequency Q2");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(44);
                     cell4.setCellValue("DrugUse R1");
                           cell4.setCellStyle(indicator_style); 
                     cell4 = rw1.createCell(45);
                     cell4.setCellValue("DrugType R2");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(46);
                     cell4.setCellValue("DrugFrequency R3");
                           cell4.setCellStyle(indicator_style); 
                     cell4 = rw1.createCell(47);
                     cell4.setCellValue("VaginalDouche S1");
                           cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(48);
                        
                       cell4.setCellValue("AfterSexDouche SBA");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(49);
                       cell4.setCellValue("BathDouche SBB");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(50);
                       cell4.setCellValue("CdBurstDouche SBC");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(51);
                       cell4.setCellValue("OtherDouche SBD");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(52);
                       cell4.setCellValue("hit T1");
                      cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(53);
                       cell4.setCellValue("LasttimeHit T2");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(54);
                       cell4.setCellValue("raped T3");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(55);
                       cell4.setCellValue("LasttimeRaped T4");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(56);
                       cell4.setCellValue("economiccsupport T5");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(57);
                       cell4.setCellValue("LastEconomic T6");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(58);
                       cell4.setCellValue("Verbal T7");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(59);
                       cell4.setCellValue("LastVerbal T8");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(60);
                       cell4.setCellValue("FPnotUse T9");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(61);
                       cell4.setCellValue("FPnotUseLast T10");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(62);
                       cell4.setCellValue("SeekTreatment U1");
                             cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(63);
                       cell4.setCellValue("PlaceTreated U2");
                       cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(64);
                       cell4.setCellValue("ReportPolice V1");
                       cell4.setCellStyle(indicator_style); 
                       cell4 = rw1.createCell(65);
                       cell4.setCellValue("ReportWhere V2");
                       cell4.setCellStyle(indicator_style); 
                    
                       
      
                
//  String query="select * from riskassessmentmain where (STR_TO_DATE(AssessmentDate, '%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"', '%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"', '%e/%c/%Y')) group by AssessmentID";
         
                       String query="select * from riskassessmentmain,riskassessmentdetails where (STR_TO_DATE(AssessmentDate, '%e/%c/%Y'))\n" +
" BETWEEN (STR_TO_DATE('"+startdate+"', '%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"', '%e/%c/%Y'))  and \n" +
" riskassessmentdetails.AssessmentID=riskassessmentmain.AssessmentID\n" +
" ";
                       conn.rs = conn.state5.executeQuery(query);
          while(conn.rs.next()){
              
            
               
          uniqueid=conn.rs.getString("UniqueID");
          riskassessmentid=conn.rs.getString("AssessmentID");
          DOA=conn.rs.getString("AssessmentDate");
            QID=conn.rs.getString("QuestionID");
           
              if(QID.equalsIgnoreCase("A")){
                    rwa = shet1.createRow(counter1);
                       rwa.setHeightInPoints(30); 
                   counter1++;
          }
//              else{
//               rwa = shet1.getRow(counter1);
//              }
           
      
           System.out.println("^^^"+uniqueid+""+riskassessmentid +"uuuu"+DOA +" counter "+counter1);
          String query3="select dicname,District from enrollment where Uniqueid='"+uniqueid+"'";
          conn.rs3= conn.state4.executeQuery(query3);
          while(conn.rs3.next()){
          dicname=conn.rs3.getString("dicname");
          districts=conn.rs3.getString("District");
          }
                  cell12=rwa.createCell(0);
                   cell12.setCellValue(uniqueid);
                   cell12.setCellStyle(cell_styles); 
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(riskassessmentid);
                   cell12.setCellStyle(cell_styles); 
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(DOA);
                   cell12.setCellStyle(cell_styles); 
                     String getDistrictName="select * from districts where DistrictID='"+districts+"'";
                 conn.rs2 = conn.state2.executeQuery(getDistrictName);
                 while(conn.rs2.next())
                 {
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(conn.rs2.getString("District"));
                   cell13.setCellStyle(cell_styles); 
                 }
                 cell13=rwa.createCell(4);
                 cell13.setCellValue(dicname);
                 cell13.setCellStyle(cell_styles); 
//          String alldata="select * from riskassessmentdetails where AssessmentID='"+conn.rs7.getString("AssessmentID")+"'";
//conn.rs = conn.state.executeQuery(alldata);
//while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;

  
     System.out.println("vvvv"+QID+"    "+conn.rs.getString("DirectAnswers"));
 
 
                
                  
                 
                 if(QID.equals("A")){
                 cell14=rwa.createCell(5);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 }
                  if(QID.equals("B")){
                  cell14=rwa.createCell(6);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("C")){
                 cell14=rwa.createCell(7);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 }
                  if(QID.equals("D")){
                  cell14=rwa.createCell(8);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("E")){
                 cell14=rwa.createCell(9);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 }
                   if(QID.equals("F")){
                  cell14=rwa.createCell(10);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("G")){
                 cell14=rwa.createCell(11);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 }
                   if(QID.equals("H")){
                 cell14=rwa.createCell(12);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                 if(QID.equals("I1")){
                  cell14=rwa.createCell(13);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 }
                   if(QID.equals("I2")){
                  cell14=rwa.createCell(14);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                
                 if(QID.equals("I3")){
                  cell14=rwa.createCell(15);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 }
                   if(QID.equals("J1")){
                  cell14=rwa.createCell(16);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                    }
                 
                   if(QID.equals("J2")){
                  cell14=rwa.createCell(17);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                     if(QID.equals("J")){
                  cell14=rwa.createCell(18);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("K")){
                  cell14=rwa.createCell(19);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                     cell14.setCellStyle(cell_styles); }
                   
                   if(QID.equals("L1")){
                  cell14=rwa.createCell(20);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("L2")){
                  cell14=rwa.createCell(21);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                     if(QID.equals("L3")){
                  cell14=rwa.createCell(22);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("M1")){
                  cell14=rwa.createCell(23);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                     if(QID.equals("M2")){
                  cell14=rwa.createCell(24);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("M3")){
                  cell14=rwa.createCell(25);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                     if(QID.equals("M4")){
                  cell14=rwa.createCell(26);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("M5")){
                   cell14=rwa.createCell(27);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers")); 
                   cell14.setCellStyle(cell_styles); 
                   }
                    if(QID.equals("M6")){
                 cell14=rwa.createCell(28);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                  if(QID.equals("M7")){
                  cell14=rwa.createCell(29);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("N1")){
                  cell14=rwa.createCell(30);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                  
                   if(QID.equals("N2")){
                
                  cell14=rwa.createCell(31);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                    if(QID.equals("O1")){
                   cell14=rwa.createCell(32);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("O2A")){
                  cell14=rwa.createCell(33);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                    if(QID.equals("02B")){
                  cell14=rwa.createCell(34);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("02C")){
                  cell14=rwa.createCell(35);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                    if(QID.equals("03B")){
                  cell14=rwa.createCell(36);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("O3A")){
                  cell14=rwa.createCell(37);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                   
                      if(QID.equals("P1")){
                  cell14=rwa.createCell(38);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("P2")){
                  cell14=rwa.createCell(39);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("P3")){
                  cell14=rwa.createCell(40);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("P4")){
                  cell14=rwa.createCell(41);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
            
                    if(QID.equals("Q1")){
                  cell14=rwa.createCell(42);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("Q2")){
                  cell14=rwa.createCell(43);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   }
                   
                  if(QID.equals("R1")){
                  cell14=rwa.createCell(44);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("R2")){
                  cell14=rwa.createCell(45);
                  String ans=conn.rs.getString("DirectAnswers").replace("NULL","");
                 cell14.setCellValue(ans.replace("_",","));
                   cell14.setCellStyle(cell_styles); 
                   }
                    if(QID.equals("R3")){
                  cell14=rwa.createCell(46);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("S1")){
                  cell14=rwa.createCell(47);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                   } 
                   if(QID.equals("SbA")){
                  cell14=rwa.createCell(48);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                        }
                   if(QID.equals("SbB")){
                  cell14=rwa.createCell(49);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("SbC")){
                  cell14=rwa.createCell(50);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("SbD")){
                  cell14=rwa.createCell(51);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T1")){
                  cell14=rwa.createCell(52);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T2")){
                  cell14=rwa.createCell(53);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T3")){
                  cell14=rwa.createCell(54);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T4")){
                  cell14=rwa.createCell(55);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T5")){
                  cell14=rwa.createCell(56);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T6")){
                  cell14=rwa.createCell(57);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T7")){
                  cell14=rwa.createCell(58);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T8")){
                  cell14=rwa.createCell(59);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T9")){
                  cell14=rwa.createCell(60);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("T10")){
                  cell14=rwa.createCell(61);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("U1")){
                  cell14=rwa.createCell(62);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("U2")){
                  cell14=rwa.createCell(63);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("V1")){
                  cell14=rwa.createCell(64);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                  }
                   if(QID.equals("V2")){
                  cell14=rwa.createCell(65);
                 cell14.setCellValue(conn.rs.getString("DirectAnswers"));
                   cell14.setCellStyle(cell_styles); 
                 
                 
                   }
                
}
        //  }



    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=RiskAssessments.xlsx");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
    }
    
    if(type.equals("enrollment")){
 final String jesus = "?*1>9@(&#";
        AES.setKey(jesus);
                   String PhoneNo="";       
                   String FirstName="";       
                   String MiddleName="";       
                   String LastName="";       
              String fingerprint="";
                 String fingerprints="";
                        cell = rw1.createCell(0);
                        cell.setCellStyle(indicator_style);
                        cell.setCellValue("UniqueID");
                        
                        cell1 = rw1.createCell(1);
                        cell1.setCellValue("ClientInit ");
                        cell1.setCellStyle(indicator_style);
                        
                        cell2 = rw1.createCell(2);
                        cell2.setCellValue("DOE");
                        cell2.setCellStyle(indicator_style); 
                       
                        cell4 = rw1.createCell(3);
                        cell4.setCellValue("District");
                        cell4.setCellStyle(indicator_style); 
                      
                        cell4 = rw1.createCell(4);
                        cell4.setCellValue("DICName ");
                         cell4.setCellStyle(indicator_style);
                         
                        cell4 = rw1.createCell(5);
                     cell4.setCellValue("DOB ");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("Sex ");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(7);
                     cell4.setCellValue("Age ");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(8);
                     cell4.setCellValue("MaritalStatus");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(9);
                     cell4.setCellValue("Children");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(10);
                     cell4.setCellValue("No of Children");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(11);
                     cell4.setCellValue("Religion");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(12);
                     cell4.setCellValue("EducationLevel");
                      cell4.setCellStyle(indicator_style);
                      
                       if(session.getAttribute("lockNames")==null){
                         shet1.setColumnWidth(13, 0);
                           cell4 = rw1.createCell(13);
                           cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                           shet1.setColumnWidth(13, 0);
                           cell4 = rw1.createCell(13);
                           cell4.setCellValue("");    
                           }
                           else{
                     cell4 = rw1.createCell(13);
                     cell4.setCellValue("PhoneNo");
                      cell4.setCellStyle(indicator_style); 
                       }
                       }
                      
                      
                        cell4 = rw1.createCell(14);
                     cell4.setCellValue("Residence");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(15);
                     cell4.setCellValue("How client learnt DIC");
                      cell4.setCellStyle(indicator_style); 
                        
                       if(session.getAttribute("lockNames")==null){
                          shet1.setColumnWidth(16, 0);
                          cell4 = rw1.createCell(16);
                          cell4.setCellValue("");
                         
                      
                           shet1.setColumnWidth(17, 0);
                           cell4 = rw1.createCell(17);
                           cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                           shet1.setColumnWidth(16, 0);
                          cell4 = rw1.createCell(16);
                          cell4.setCellValue("");
                          
                           shet1.setColumnWidth(17, 0);
                           cell4 = rw1.createCell(17);
                           cell4.setCellValue("");    
                           }
                           else{
                          cell4 = rw1.createCell(16);
                          cell4.setCellValue("Email");
                          cell4.setCellStyle(indicator_style);
                          
                           cell4 = rw1.createCell(17);
                           cell4.setCellValue("PhoneNo1");
                           cell4.setCellStyle(indicator_style); 
                       }
                       } 
                        cell4 = rw1.createCell(18);
                     cell4.setCellValue("Venue");
                      cell4.setCellStyle(indicator_style); 
                      
                      
                     
                      if(session.getAttribute("lockNames")==null){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);

                 cell14=rw1.createCell(19);
                 cell14.setCellValue("");
                 cell14=rw1.createCell(20);
                 cell14.setCellValue("");
                 cell14=rw1.createCell(21);
                 cell14.setCellValue(""); 
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);

                 cell14=rw1.createCell(19);
                 cell14.setCellValue("");
                 cell14=rw1.createCell(20);
                 cell14.setCellValue("");
                 cell14=rw1.createCell(21);
                 cell14.setCellValue("");    
                                }
                                else{
                                    
                                    
                                    
                                    
                                    
                    cell4 = rw1.createCell(19);
                     cell4.setCellValue("FirstName");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(20);
                     cell4.setCellValue("SecondName");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(21);
                     cell4.setCellValue("LastName");
                      cell4.setCellStyle(indicator_style); 
                                }
                  }
                   
                      
                        cell4 = rw1.createCell(22);
                     cell4.setCellValue("venueOther");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(23);
                         cell4.setCellStyle(indicator_style); 
                     cell4.setCellValue("DicLearnOther");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(24);
                     cell4.setCellValue("Captured Hand");
                      cell4.setCellStyle(indicator_style); 
                        cell4 = rw1.createCell(25);
                     cell4.setCellValue("Fingerprint");
                      cell4.setCellStyle(indicator_style); 
                    
                      
                      cell4 = rw1.createCell(27);
                     cell4.setCellValue("Ward");
                      cell4.setCellStyle(indicator_style); 
                      
                       cell4 = rw1.createCell(26);
                     cell4.setCellValue("Month");
                      cell4.setCellStyle(indicator_style);
        
   String alldata="select UniqueID, UPPER(ClientInit),DOE,District,DICName, DOB, Sex, Age,MaritalStatus, Children, ChildNo, "
           + "Religion, EducationLevel, PhoneNo, Residence, DICLearn, Email, "
           + "PhoneNo1, Venue,  FirstName, SecondName,LastName, venueOther, DicLearnOther,capturedhand,fingerprint ,ward,monthname((STR_TO_DATE(DOE, '%e/%c/%Y')))"
           + "from enrollment where (STR_TO_DATE(DOE, '%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"', '%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"', '%e/%c/%Y')) order by enrollment.UniqueID limit 1000000 ";
System.out.println(alldata);
conn.rs = conn.state.executeQuery(alldata);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println("enrollments  "+conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;

    
    
  XSSFRow rwa = shet1.createRow(a+=1);
  rwa.setHeightInPoints(30);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString(1));
                 cell12.setCellStyle(cell_styles);
                 
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12.setCellStyle(cell_styles);
                  
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs.getString(3));
                 cell12.setCellStyle(cell_styles);
                 
                 String getDistrictName="select * from districts where DistrictID='"+conn.rs.getString(4)+"'";
                 conn.rs2 = conn.state2.executeQuery(getDistrictName);
                 while(conn.rs2.next()){
                 cell10=rwa.createCell(3);
                 cell10.setCellValue(conn.rs2.getString("District"));
                 cell10.setCellStyle(cell_styles);
                 }
                 cell11=rwa.createCell(4);
                 cell11.setCellValue(conn.rs.getString(5));
                  cell11.setCellStyle(cell_styles);
                  
                 cell14=rwa.createCell(5);
                 cell14.setCellValue(conn.rs.getString(6));
                cell14.setCellStyle(cell_styles);
                  
                 cell14=rwa.createCell(6);
                 cell14.setCellValue(conn.rs.getString(7));
                 cell14.setCellStyle(cell_styles);
                 
                 cell14=rwa.createCell(7);
                 cell14.setCellValue(conn.rs.getString(8));
                 cell14.setCellStyle(cell_styles);
                 String getMaritalStatus="SELECT * FROM marital_status where Marital_StatusID='"+conn.rs.getString(9)+"'";
                 conn.rs3 = conn.state3.executeQuery(getMaritalStatus);
                 while(conn.rs3.next()){
                 cell14=rwa.createCell(8);
                 cell14.setCellValue(conn.rs3.getString("Marital_Status"));
                   cell14.setCellStyle(cell_styles);
                 }
                 cell14=rwa.createCell(9);
                 cell14.setCellValue(conn.rs.getString(10));
                   cell14.setCellStyle(cell_styles);
                 cell14=rwa.createCell(10);
                 cell14.setCellValue(conn.rs.getString(11));
                   cell14.setCellStyle(cell_styles);
                   
                 cell14=rwa.createCell(11);
                 cell14.setCellValue(conn.rs.getString(12));
                   cell14.setCellStyle(cell_styles);
                 String getEducationLevel="SELECT * FROM dic.educationlevel where EducationLevelID='"+conn.rs.getString(13)+"'";
                 conn.rs4 = conn.state4.executeQuery(getEducationLevel);
                 while(conn.rs4.next()){
                 cell14=rwa.createCell(12);
                 cell14.setCellValue(conn.rs4.getString("EducationLevel"));
                   cell14.setCellStyle(cell_styles);
                 }
                 
                  if(session.getAttribute("lockNames")==null){
                         cell4 = rwa.createCell(13);
                         cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                          cell4 = rwa.createCell(13);
                           cell4.setCellValue("");    
                           }
                           else{
                               
                        
              
               if(conn.rs.getString("PhoneNo")!=null && !conn.rs.getString("PhoneNo").trim().equals("") && !conn.rs.getString("PhoneNo").equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs.getString("PhoneNo").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("PhoneNo"));
                     PhoneNo=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }
                    cell14=rwa.createCell(13);
                     cell14.setCellValue(PhoneNo);
                   cell14.setCellStyle(cell_styles);
                       }
                       }
                    
                 String getResidence= "SELECT * FROM ResidenceArea where ResidenceAreaID ='"+conn.rs.getString(15)+"'";
                 conn.rs5 = conn.state5.executeQuery(getResidence);
                 while(conn.rs5.next()){
                 cell14=rwa.createCell(14);
                 cell14.setCellValue(conn.rs5.getString("ResidenceArea"));
                   cell14.setCellStyle(cell_styles);
                 }
                  String Query5= "SELECT * FROM clientlearnt where ClientLearntID ='"+conn.rs.getString(16)+"'";
               conn.rs6= conn.state6.executeQuery(Query5);
               while(conn.rs6.next()){
                  cell14=rwa.createCell(15);
                 cell14.setCellValue(conn.rs6.getString("ClientLearnt"));
                   cell14.setCellStyle(cell_styles);
               }
               if(session.getAttribute("lockNames")==null){
                          shet1.setColumnWidth(16, 0);
                          cell4 = rwa.createCell(16);
                          cell4.setCellValue("");
                         
                      
                           shet1.setColumnWidth(17, 0);
                           cell4 = rwa.createCell(17);
                           cell4.setCellValue("");     
                       }
                       else{
                           if(session.getAttribute("lockNames").toString().equals("YES")){ 
                           shet1.setColumnWidth(16, 0);
                          cell4 = rwa.createCell(16);
                          cell4.setCellValue("");
                          
                           shet1.setColumnWidth(17, 0);
                           cell4 = rwa.createCell(17);
                           cell4.setCellValue("");    
                           }
                           else{
                          cell14=rwa.createCell(16);
                 cell14.setCellValue(conn.rs.getString(17));
                   cell14.setCellStyle(cell_styles);
                 cell14=rwa.createCell(17);
                 cell14.setCellValue(conn.rs.getString(18));
                   cell14.setCellStyle(cell_styles);
                   }
                       }
               
                 cell14=rwa.createCell(18);
                 cell14.setCellValue(conn.rs.getString(19));
                   cell14.setCellStyle(cell_styles);
                 if(session.getAttribute("lockNames")==null){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);

                 cell14=rwa.createCell(19);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(20);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(21);
                 cell14.setCellValue(""); 
                                }
                                else{
                                if(session.getAttribute("lockNames").toString().equals("YES")){
    shet1.setColumnWidth(19, 0);
    shet1.setColumnWidth(20, 0);
    shet1.setColumnWidth(21, 0);

                 cell14=rwa.createCell(19);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(20);
                 cell14.setCellValue("");
                 cell14=rwa.createCell(21);
                 cell14.setCellValue("");    
                                }
                                else{
                  cell14=rwa.createCell(19);
                  cell14.setCellValue("");
                   cell14.setCellStyle(cell_styles);
                         if(conn.rs.getString("FirstName")!=null && !conn.rs.getString("FirstName").trim().equals("") && !conn.rs.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                 
                         cell14=rwa.createCell(19);
                  cell14.setCellValue(FirstName.toUpperCase());
                   cell14.setCellStyle(cell_styles);
//                   System.out.println("locale   "+FirstName.toUpperCase(Locale.ENGLISH));
                         }
                  cell14=rwa.createCell(20);
                  cell14.setCellValue("");
                   cell14.setCellStyle(cell_styles);            
                          if(conn.rs.getString("SecondName")!=null && !conn.rs.getString("SecondName").trim().equals("") && !conn.rs.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                         
                              
                  cell14=rwa.createCell(20);
                  cell14.setCellValue(MiddleName.toUpperCase());
                   cell14.setCellStyle(cell_styles);
                          }
                  cell14=rwa.createCell(21);
                 cell14.setCellValue("");
                  cell14.setCellStyle(cell_styles);
                      if(conn.rs.getString(22)!=null && !conn.rs.getString(22).trim().equals("") && !conn.rs.getString(22).equals("null")){
//                      Lastname =  conn.rs.getString("LastName");
                    AES.decrypt(conn.rs.getString(22).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(22));
                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                      cell14=rwa.createCell(21);
                 cell14.setCellValue(LastName.toUpperCase());
                   cell14.setCellStyle(cell_styles);
                      }
              System.out.println("name     "+conn.rs.getString(22));
              
              
               
                                }
                  }
                
                   
                   
                 cell14=rwa.createCell(22);
                 cell14.setCellValue(conn.rs.getString(23));
                   cell14.setCellStyle(cell_styles);
                 cell14=rwa.createCell(23);
                 cell14.setCellValue(conn.rs.getString(24));
                   cell14.setCellStyle(cell_styles);
                 cell14=rwa.createCell(24);                 
                 cell14.setCellValue(conn.rs.getString(25));
                 cell14.setCellStyle(cell_styles);
                 cell14=rwa.createCell(25);
                
           
                 fingerprint=conn.rs.getString(26);
                 if(conn.rs.getString(26)!="" &&conn.rs.getString(26)!=null){
                  fingerprints="FINGERPRINT CAPTURED";
                 }
                 else{
                  fingerprints="";
                 }
                 cell14.setCellValue(fingerprints);
                 cell14.setCellStyle(cell_styles);
                fingerprints="";
                
                 cell14=rwa.createCell(26);
                 cell14.setCellValue(conn.rs.getString(28));
                 cell14.setCellStyle(cell_styles);
                
                  cell14=rwa.createCell(27);
                   cell14.setCellValue(conn.rs.getString(27));
                 cell14.setCellStyle(cell_styles);
                

}



//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=Enrollment_Raw_Data.xlsx");
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
