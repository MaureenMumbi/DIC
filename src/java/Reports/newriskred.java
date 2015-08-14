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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Header;
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
public class newriskred extends HttpServlet {

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
   String DICName="";
String reporttype="";
String reportyear="";
String question="";
String questionRed="";
String quarter="";
String semiannual="";
String dates1 ="";
String dates2 ="";
String period ="";
  int NoofEnrolls=0;
   int total= 0;   
String DIC1="";
String DOA1="";
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
      
        int countJ3=0;
   int totalDIC=0;
        int FPcount=0;
       
       int rowcount=0;
      int totalCounts=0;
      int counts=0;
      int condomcount=0;
      int wblcount=0;
        int a=1;
        int b=1;
          int c=16;
   int ansas4=0;
   String DOA2="";
   String DIC2="";
   String DOA="";
   String DIC="";
  String qstnsID="";
  int d=0;
  int f=0;
  int totals=0;
  int columnadd=1;
  int columnadd1=1;
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
NoofEnrolls=0;
   quarter="";
   semiannual="";
   dates1="";
   dates2="";
   quarter="";
   total= 0;
   a=1;
    columnadd=1;
    columnadd1=1;
   reportyear="";
   
    int totalperrow=0;    
            session=request.getSession();
            dbConnect conn=new dbConnect();
            
            
            Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);
           
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
//          
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
          

////  HSSFSheet sheet1 = wb.getSheetAt(0);
////    shet1.setColumnWidth(0, 4000); 
//    shet1.setColumnWidth(1,4000); 
//    shet1.setColumnWidth(2, 15000); 
//    shet1.setColumnWidth(3, 4000); 
//    shet1.setColumnWidth(4, 4000); 
//    shet1.setColumnWidth(5, 4000); 
//    shet1.setColumnWidth(6, 4000); 
//    shet1.setColumnWidth(7, 4000); 
//    shet1.setColumnWidth(8, 4000); 
//    shet1.setColumnWidth(9, 4000); 
//    shet1.setColumnWidth(10, 4000); 
  HSSFRow rw1=shet1.createRow(1);
  HSSFCell cell;
//  cell=rw1.createCell(1);
//  cell.setCellValue("DIC REPORTS");
//   cell.setCellStyle(style_header);
    
    String months[] = new String[]{"Jan","Feb","March","April","May","June","July","August","Sept","Nov","Oct","Dec"};
    String quarters[] = new String[]{"Oct-Dec","Jan-March","April-June","July-Sept"};
  
  
  
//  Merge the cells
//  shet1.addMergedRegion(new CellRangeAddress(1,1,1,3));
            
   HSSFRow rw4=shet1.createRow(3);
    rw4.setHeightInPoints(25);
//    rw4.setRowStyle(style);
//    
   HSSFRow rw5=shet1.createRow(2);
    rw5.setHeightInPoints(25);
////    rw5.setRowStyle(stylex);
// 
//    shet1.addMergedRegion(new CellRangeAddress(2,2,6,9));
   
    
    
   
    ArrayList dics = new ArrayList();
    ArrayList dicsList = new ArrayList();
    ArrayList quarters1 = new ArrayList();
    ArrayList years1 = new ArrayList();
   String[] months1 =null ;
    
    
// rw4.createCell(1).setCellValue("Number");
    HSSFCell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
   // cells fo row 2 
   
//cell13=cell14=cell15=cell16=;

 
// cell10.setCellValue("over 50% attendance");  
// cell11.setCellValue("less than 50% attendance"); 
// cell12.setCellValue("Overall Attendance"); 
// 
// HSSFCellStyle stylex = wb.createCellStyle();
//stylex.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
//stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//HSSFFont fontx = wb.createFont();
//fontx.setColor(HSSFColor.DARK_BLUE.index);
//stylex.setFont(fontx);


int years=0;

//cell10.setCellStyle(stylex);
//cell11.setCellStyle(stylex);
//cell12.setCellStyle(stylex);
String DICNames="";
String[] districts=null;
//if(!quarters1.isEmpty()){
//         quarters1.clear();
//     }
//     if(!years1.isEmpty()){
//         years1.clear();
//     }
if(request.getParameter("startdate") !=null && !request.getParameter("startdate").equals("") ){
            
            dates1=request.getParameter("startdate");
            }
            if(request.getParameter("enddate") !=null && !request.getParameter("enddate").equals("") ){
            
            dates2=request.getParameter("enddate");
            }
//            if(request.getParameter("DICName") !=null && !request.getParameter("DICName").equals("") ){
//            
//            DICNames=request.getParameter("DICName");
//            }
            if(request.getParameterValues("district") !=null && !request.getParameterValues("district").equals("") ){
            
            districts=request.getParameterValues("district");
            }
if(request.getParameter("parameter")!= null && !request.getParameter("parameter").equals("")){
reporttype = request.getParameter("parameter");
}
if(request.getParameter("year")!= null && !request.getParameter("year").equals("")){
reportyear = request.getParameter("year");
}
if(request.getParameter("period")!= null && !request.getParameter("period").equals("")){
period = request.getParameter("period");
}
if(request.getParameterValues("months")!= null && !request.getParameterValues("months").equals("")){
months1=request.getParameterValues("months");
}
String [] quarters2=null;
if(request.getParameterValues("Quarter")!= null && !request.getParameterValues("Quarter").equals("")){
  quarters2=request.getParameterValues("Quarter");
}


 String dic="";
 String district="";
 String Enrolls1="";
 String DOE="";
 String DOE1="";
 int i=3;
 int count=0;
 int l=2;
 String[] availableQTR;
System.out.println("reporttype"+reporttype);
System.out.println("period"+period);
System.out.println("dates1"+dates1);
System.out.println("dates2"+dates2);
//String[] daters1= dates1.split("/") ;     
//String[] daters2= dates2.split("/") ;
//String month1="";
//String month2="";
// String year1="";
// year1=daters1[2];
// month1=daters1[1];
// String year2="";
// year2=daters2[2];
//  month2=daters2[1];
  String[]  questions = new String[]{"B1","B3","C","D2","E1","E2","F1","G1","H1","I","J1","J2","K"};
              String[]  questions1 = new String[]{"Number provided with Health Education","Number provided with HIV testing ","Number provided with HIV testing with partner","Number provided with STI Checkup ","Number provided with Cervical Cancer Screening ","Number provided with tuberculosis screening","Number provided with referall for Gender Based Violence","Number currently on FP Methods","Number provided with FP Methods","Number Linked to IGA Group","FP Methods Provided",};
           
 
// reports for service provided 
 
 
 if(reporttype.equalsIgnoreCase("Services Provided") && period.equalsIgnoreCase("quarterly")){
   
//           HSSFRow row2 = shet1.createRow(b);
//                  row2.setHeightInPoints(30);
     
     for (int y =1; y <=6; ++y) {
//    Cell cell = row.createCell(i);
                        cell = rw1.createCell(y);
                        cell.setCellStyle(indicator_style);
                        if (y == 1) {
                            cell.setCellValue("DIC SERVICES PROVIDED REPORTS");
                        }
                    }
  rw1.setHeightInPoints(30);
  shet1.addMergedRegion(new CellRangeAddress(1,1,1, 6));
   
     
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
     
     String[] quarteryear;
     String[] quarteryearnames;
     quarteryear=new String[]{"Q1","Q2","Q3","Q4"};
     quarteryearnames=new String[]{"Oct-Dec","Jan-March","April-June","July-Sept"};
    
//      String nomonths ="select qtr,year from riskreductionmain where (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) GROUP BY qtr";
//  conn.rs3 = conn.state3.executeQuery(nomonths);
//  while(conn.rs3.next()){
//      System.out.println(conn.rs3.getString(1));
//      quarters1.add(conn.rs3.getString(1));
//      Quarter
//      years1.add(conn.rs3.getString(2));
//  }
    
   
  HSSFCell cells_5, cells_6, cells_7, cells_8;
         
                   HSSFRow rows = shet1.createRow(a +1);
                   
                    for (int y = 1; y <=1; y++) {

                        cells_5 = rows.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("Indicator");
                        }
                    }
           
                               
                                for(int y=0;y<districts.length;y++){
                                 String dicname="select * from dicname where DistrictID='"+districts[y]+"'";
                                conn.rs = conn.state.executeQuery(dicname);
                                System.out.println(dicname);
                                while(conn.rs.next()){  
                                  dicsList.add(conn.rs.getString("DICName"));  
                                  System.out.println(conn.rs.getString("DICName"));
                                }
                                }

                                System.out.println(""+dicsList);

                                for(int h=0;h<dicsList.size();h++){
                                   cells_6=rows.createCell(2+h);
                                   cells_6.setCellValue(dicsList.get(h).toString());
                                    cells_6.setCellStyle(style_header);
                                }
//     for(int y=0;y<years1.size;y++){                         
     for(int z=0; z<quarters2.length;z++){
         
         
//                               a += 1;
// shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 2));
   
        int diccount=2;
        
        for(int y=0;y<districts.length;y++){
                     String dicnames="select * from dicname where DistrictID='"+districts[y]+"'";
conn.rs6 = conn.state6.executeQuery(dicnames);
while(conn.rs6.next()){  
  dics.add(conn.rs6.getString("DICName"));  
   System.out.println("ddd"+dics.get(0));
   diccount++;
   
}}
     
        System.out.println("aaaa"+dics.size() +"@@@"+dicsList.size());
        
        cells_6 = rows.createCell(diccount);
                        cells_6.setCellStyle(style_header);
                      cells_6.setCellValue("Total");                  
  
HSSFRow row4 = shet1.createRow(a+2);
String qtr="";
   int yearsss =0;
                if(quarters2[z].equals("Q1")){
                    
                  
                               yearsss= Integer.parseInt(reportyear);
                  qtr="1";  
                  yearsss-=1;
                  
                  System.out.println("hhhh"+yearsss);
                }
                if(quarters2[z].equals("Q2")){
                  qtr="2";  
                }
                if(quarters2[z].equals("Q3")){
                  qtr="3";  
                }
                if(quarters2[z].equals("Q4")){
                  qtr="4";  
                }

                        cells_7 = row4.createCell(1);
                        cells_7.setCellStyle(style_header);
                       String selectQtrs="select * from quarters where QUARTER_ID='"+qtr+"' ";
                       
                       System.out.println(selectQtrs);
                       conn.rs4 = conn.state4.executeQuery(selectQtrs);
                       while(conn.rs4.next()){
                           
                           if(qtr.equals("1")){
                         
                              cells_7.setCellValue("QUARTER:   "+conn.rs4.getString("QUARTER_NAME") +"  "+ yearsss);
                           }
                           else{
                               cells_7.setCellValue("QUARTER:   "+conn.rs4.getString("QUARTER_NAME") +"  "+reportyear);
                       }}
                     row4.setHeightInPoints(30);
  
//  shet1.addMergedRegion(new CellRangeAddress(a, a,1, 3)); 
//                    
                    
                     
                   
                   
                    HSSFRow rwa = shet1.createRow(a + 3); 
                      
//                   HSSFRow rwc = shet1.createRow(a + 4);
                   HSSFRow rowc = shet1.createRow(a + 5);
                 
                   
                   //HSSFRow rwd= shet1.createRow(a +16);
                   
        
        
    
   
     
        
                  


     
//  
                      row4.setHeightInPoints(30);
    


   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
                         
  a +=3;

             
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(g+a);
    
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {
  
                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              
                   HSSFCell cells_1, cells_2, cells_3, cells_4;
 //rwi.createCell(1).setCellValue(questions1[g]);
// 
//         cell1=rwc.createCell(1);
//         cell1.setCellStyle(cell_style);
//         cell1.setCellValue(questions1[g]);

for(int t=0;t<dics.size();t++){ 
    
    cell12=rwc.createCell(2+t);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);
//                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
//                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
//                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
//                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes' AND Enrollment.DICName='"+dics.get(t)+"' AND RiskReductionMain.qtr='"+quarters2[z]+"'AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
//                                 ;
                  
                  
                    String query="select enrollment.DICName, riskreductiondetails.QID, \n" +
"	CASE riskreductiondetails.QID\n" +
"WHEN 'B1' THEN 'CONDOMS PROVIDED'  \n" +
"		WHEN 'B3' THEN 'WBL PROVIDED' \n" +
"         WHEN 'C' THEN 'AUDITS' \n" +
"	     WHEN 'D2'  THEN 'HEALTH EDUCATION' \n" +
"		WHEN 'E1' THEN 'HIV TESTED'\n" +
"		WHEN 'E2' THEN 'TESTED WITH PARTNER' \n" +
"		WHEN 'F1' THEN 'STI CHECKUP' \n" +
"		WHEN 'G1' THEN 'CC SCREENING'\n" +
"		WHEN 'H1' THEN 'TB SCREENING' \n" +
"		WHEN 'I' THEN 'GBV REFERRAL' \n" +
"		WHEN 'J1' THEN 'CURRENTLY ON FP METHOD(Y)' \n" +
"		WHEN 'J2' THEN 'PROVIDED FP METHOD TODAY(Y)' \n" +
"		WHEN 'K' THEN 'IGA GROUP' \n" +
  

"	END as 'INDICATORNAME',\n" +
"\n" +
"CASE riskreductiondetails.QID \n" +
"		WHEN 'B1' AND RiskReductionDetails.action LIKE '%Condoms were provided_%'  THEN SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1))  \n" +
"		WHEN 'B3' AND RiskReductionDetails.action LIKE 'WBL Provided_%' THEN SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1) ) end as e,\n" +
"	COUNT(CASE  \n" +
"		WHEN riskreductiondetails.QID='C' AND (riskreductiondetails.currentstatus>0 or riskreductiondetails.action>0) \n" +
"							THEN (riskreductiondetails.currentstatus)  or (riskreductiondetails.action)\n" +
"		WHEN riskreductiondetails.QID='D2'AND riskreductiondetails.currentstatus = 'Yes' THEN \n" +
"riskreductiondetails.currentstatus='Yes'\n" +
"        WHEN riskreductiondetails.QID='E1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='E2' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus \n" +
"		WHEN riskreductiondetails.QID='F1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='G1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus         \n" +
"		WHEN riskreductiondetails.QID='H1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='I' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='J1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='J2' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"               WHEN riskreductiondetails.QID='K' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus END) as kkk,\n" +

"riskreductionmain.qtr, riskreductionmain.year\n" +
"from enrollment, \n" +
"	riskreductionmain, \n" +
"	riskreductiondetails\n" +
"	where riskreductionmain.UniqueID = enrollment.UniqueID \n" +
"	and riskreductiondetails.RiskReductionID= riskreductionmain.RiskReductionID \n" +
"	and  Enrollment.DICName='"+dics.get(t).toString()+"' AND RiskReductionDetails.QID='"+questions[g]+"' AND RiskReductionMain.qtr='"+quarters2[z]+"' AND RiskReductionMain.year='"+reportyear+"'"+
//                             + "str_to_date(riskreductionmain.DOA,'%e/%c/%Y') between\n" +G
//"str_to_date('01/04/2014','%e/%c/%Y') and str_to_date('30/04/2014','%e/%c/%Y')\n" +
"group by riskreductiondetails.QID,enrollment.DICName\n" +
"";
            conn.rs = conn.state2.executeQuery(query);
          System.out.println("&&&&"+dics.get(t).toString());
              
          
            while(conn.rs.next()){
System.out.println("goes how may times ");
//    if(conn.rs.getString(3)!=null && !conn.rs.getString(3).equals("")){
                            
//                   if((conn.rs.getString(3)).equals("FAMILY PLANNING METHOD"))  {      
//                              cell1=rwc.createCell(1);
//         cell1.setCellStyle(cell_style);
//         cell1.setCellValue(conn.rs.getString(6));  
//                   }
//                   else{
                    cell1=rwc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(conn.rs.getString(3));  
                   
//                   }

        
                        if( !conn.rs.getString(4).equals("0")){
            System.out.println("gg"+a);
         System.out.println("UU"+t);
                cell12=rwc.createCell(2+t);
                 cell12.setCellValue(conn.rs.getString(4));
                  cell12.setCellStyle(cell_style);
                   totalperrow+=conn.rs.getInt(4);   
            }
                        else{
                 cell12=rwc.createCell(2+t);
                 cell12.setCellValue(conn.rs.getString(5));
                 cell12.setCellStyle(cell_style);
                     totalperrow+=conn.rs.getInt(5);   
                        }
                       
                       
                       

                        }

 
            }

//a+=1;
            
           
} 


                   cell12=rwc.createCell(diccount);
                   cell12.setCellValue(totalperrow);
                   cell12.setCellStyle(cell_style);
                  
      totalperrow=0;         
     totals=0;
    totalCounts=0;
    d=g;
//     a+=2; 
            }
//        }
//        total=0;
//       totalCounts=0;
        
      
      

 
 
//System.out.println("total"+totalDIC);
//HSSFRow rwds = shet1.createRow(a); 
//if(totalDIC!=0 ){
//  cell12=rwds.createCell(2);
//            cell12.setCellValue("Total per DIC");
//                  cell12.setCellStyle(cell_style); 
//for(int r=0;r<dicsList.size()+1;r++){
//           cell12=rwds.createCell(r+2);
//            cell12.setCellValue(totalDIC);
//                  cell12.setCellStyle(cell_style); 
//} }
 
System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+quarters2[z]);
totalDIC=0;
 ansas3=0;
       totalCounts=0;
       ansas2=0;
       ansas1=0;
       ansas4=0;
a+=15;

 if(!dics.isEmpty() && dics!=null){
        dics.clear();
    }
//       a+=1;      
     }
     
      ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename="+period+"_Services_DIC_Report_Created_On_"+formattedDate+".xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();

   
 } 
 if(reporttype.equalsIgnoreCase("Services Provided") && period.equalsIgnoreCase("monthly")){
   //           HSSFRow row2 = shet1.createRow(b);
//                  row2.setHeightInPoints(30);
    for (int y =1; y <=6; ++y) {
//    Cell cell = row.createCell(i);
                        cell = rw1.createCell(y);
                        cell.setCellStyle(indicator_style);
                        if (y == 1) {
                            cell.setCellValue("DIC SERVICES PROVIDED REPORTS");
                        }
                    }
  rw1.setHeightInPoints(30);
  shet1.addMergedRegion(new CellRangeAddress(1,1,1, 6));
   
      
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
     
     String[] monthsNo;
     String[] monthnames;
     monthsNo=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
     monthnames=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
   int monthyear=0;
monthyear= Integer.parseInt(reportyear)-1;

     for(int z=0; z<months1.length;z++){

          HSSFCell cells_5, cells_6, cells_7, cells_8;
        HSSFRow rows = shet1.createRow(a +1);
          
         
                  for (int y = 1; y<=2; y++) {

                        cells_7 = rows.createCell(y);
                        cells_7.setCellStyle(style_header);
                        if (y == 1) {
                             String monthname="select * from months where MONTH_ID='"+months1[z]+"'";
          conn.rs3 = conn.state3.executeQuery(monthname);
          System.out.println(monthname);
         while(conn.rs3.next())
                  
         {if(months1[z].equals("10") || months1[z].equals("11")|| months1[z].equals("12") ){
           
                               cells_7.setCellValue("MONTH:   "+conn.rs3.getString("MONTH_NAME") +" "+monthyear);
                        }
         else{
             cells_7.setCellValue("MONTH:   "+conn.rs3.getString("MONTH_NAME") +" "+reportyear);
             
             
         }}
                    }
         }
                    
                  
//                    a++;
                    rows.setHeightInPoints(30);
                    
                    shet1.addMergedRegion(new CellRangeAddress(a, a,1, 2)); 
                      
                    
                    
                   HSSFRow row4 = shet1.createRow(a +2);
                   
                    HSSFRow rwa = shet1.createRow(a + 3); 
                      
//                   HSSFRow rwc = shet1.createRow(a + 4);
                   HSSFRow rowc = shet1.createRow(a + 5);
                 
                   
                  //HSSFRow rwd= shet1.createRow(a +16);
                   
        
        
        
        
                   for (int y = 1; y <=2; y++) {

                        cells_5 = row4.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("Indicator");
                        }
                    }
           
                               a += 1;
 shet1.addMergedRegion(new CellRangeAddress(a, a, 1, 2));
 int diccount=2;
  for(int k=0;k<districts.length;k++){
     String dicname="select * from dicname where DistrictID='"+districts[k]+"'";
conn.rs6 = conn.state6.executeQuery(dicname);
while(conn.rs6.next()){  
  dics.add(conn.rs6.getString("DICName"));  
   diccount++; 
}
  }                   cells_6 = row4.createCell(diccount);
                        cells_6.setCellStyle(style_header);
                        cells_6.setCellValue("Total");

System.out.println("dics"+dics);

for(int p=0;p<dics.size();p++){
   cells_6=row4.createCell(2+p);
   cells_6.setCellValue(dics.get(p).toString());
    cells_6.setCellStyle(style_header);
}

  a +=3;

             
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwc = shet1.createRow(g+a);
    
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {
  
                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              
                   HSSFCell cells_1, cells_2, cells_3, cells_4;
 //rwi.createCell(1).setCellValue(questions1[g]);
// 
//         cell1=rwc.createCell(1);
//         cell1.setCellStyle(cell_style);
//         cell1.setCellValue(questions1[g]);

for(int t=0;t<dics.size();t++){ 
    
    cell12=rwc.createCell(2+t);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);
//                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
//                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
//                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
//                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes' AND Enrollment.DICName='"+dics.get(t)+"' AND RiskReductionMain.qtr='"+quarters2[z]+"'AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
//                                 ;
                  
                  
                    String query="select enrollment.DICName, riskreductiondetails.QID, \n" +
"	CASE riskreductiondetails.QID\n" +
"WHEN 'B1' THEN 'CONDOMS PROVIDED'  \n" +
"		WHEN 'B3' THEN 'WBL PROVIDED' \n" +
"         WHEN 'C' THEN 'AUDITS' \n" +
"	     WHEN 'D2'  THEN 'HEALTH EDUCATION' \n" +
"		WHEN 'E1' THEN 'HIV TESTED'\n" +
"		WHEN 'E2' THEN 'TESTED WITH PARTNER' \n" +
"		WHEN 'F1' THEN 'STI CHECKUP' \n" +
"		WHEN 'G1' THEN 'CC SCREENING'\n" +
"		WHEN 'H1' THEN 'TB SCREENING' \n" +
"		WHEN 'I' THEN 'GBV REFERRAL' \n" +
"		WHEN 'J1' THEN 'CURRENTLY ON FP METHOD(Y)' \n" +
"		WHEN 'J2' THEN 'PROVIDED FP METHOD TODAY(Y)' \n" +
"		WHEN 'K' THEN 'LINKED IGA GROUP' \n" +
"        \n" +

"	END as 'INDICATORNAME',\n" +
"\n" +
"CASE riskreductiondetails.QID \n" +
"		WHEN 'B1' AND RiskReductionDetails.action LIKE '%Condoms were provided_%'  THEN SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1))  \n" +
"		WHEN 'B3' AND RiskReductionDetails.action LIKE 'WBL Provided_%' THEN SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1) ) end as e,\n" +
"	COUNT(CASE  \n" +
"		WHEN riskreductiondetails.QID='C' AND (riskreductiondetails.currentstatus>0 or riskreductiondetails.action>0) \n" +
"							THEN (riskreductiondetails.currentstatus)  or (riskreductiondetails.action)\n" +
"		WHEN riskreductiondetails.QID='D2'AND riskreductiondetails.currentstatus = 'Yes' THEN \n" +
"riskreductiondetails.currentstatus='Yes'\n" +
"        WHEN riskreductiondetails.QID='E1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='E2' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus \n" +
"		WHEN riskreductiondetails.QID='F1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='G1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus         \n" +
"		WHEN riskreductiondetails.QID='H1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='I' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='J1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"		WHEN riskreductiondetails.QID='J2' AND riskreductiondetails.currentstatus = 'Yes' THEN riskreductiondetails.currentstatus\n" +
"               WHEN riskreductiondetails.QID='K' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" + "END) as kkk,\n" +
"riskreductionmain.qtr, riskreductionmain.year\n" +
"from enrollment, \n" +
"	riskreductionmain, \n" +
"	riskreductiondetails\n" +
"	where riskreductionmain.UniqueID = enrollment.UniqueID \n" +
"	and riskreductiondetails.RiskReductionID= riskreductionmain.RiskReductionID \n" +
"	and  Enrollment.DICName='"+dics.get(t).toString()+"' AND RiskReductionDetails.QID='"+questions[g]+"' AND MONTH((STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')))='"+months1[z]+"' AND RiskReductionMain.year='"+reportyear+"'"+
//                             + "str_to_date(riskreductionmain.DOA,'%e/%c/%Y') between\n" +G
//"str_to_date('01/04/2014','%e/%c/%Y') and str_to_date('30/04/2014','%e/%c/%Y')\n" +
"group by riskreductiondetails.QID,enrollment.DICName\n" +
"";
            conn.rs = conn.state2.executeQuery(query);
          System.out.println("&&&&"+dics.get(t).toString());
              
          
            while(conn.rs.next()){
System.out.println("goes how may times ");
//    if(conn.rs.getString(3)!=null && !conn.rs.getString(3).equals("")){
                            
//                   if((conn.rs.getString(3)).equals("FAMILY PLANNING METHOD"))  {      
//                              cell1=rwc.createCell(1);
//         cell1.setCellStyle(cell_style);
//         cell1.setCellValue(conn.rs.getString(6));  
//                   }
//                   else{
                    cell1=rwc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(conn.rs.getString(3));  
                   
//                   }

        
                        if(!conn.rs.getString(4).equals("0")){
            System.out.println("gg"+a);
         System.out.println("UU"+t);
                cell12=rwc.createCell(2+t);
                 cell12.setCellValue(conn.rs.getString(4));
                  cell12.setCellStyle(cell_style);
                   totalperrow+=conn.rs.getInt(4);   
            }
                        else{
                 cell12=rwc.createCell(2+t);
                 cell12.setCellValue(conn.rs.getString(5));
                 cell12.setCellStyle(cell_style);
                     totalperrow+=conn.rs.getInt(5);   
                        }
                       
                       
                       

                        }

 
            }

//a+=1;
            
           
} 


                   cell12=rwc.createCell(diccount);
                   cell12.setCellValue(totalperrow);
                   cell12.setCellStyle(cell_style);
                  
      totalperrow=0;         
     totals=0;
    totalCounts=0;
    
//     a+=2; 
    
    f=g;
            }
//        }
//        total=0;
//       totalCounts=0;
        
      
      

 
 
//System.out.println("total"+totalDIC);
//HSSFRow rwds = shet1.createRow(a); 
//if(totalDIC!=0 ){
//  cell12=rwds.createCell(2);
//            cell12.setCellValue("Total per DIC");
//                  cell12.setCellStyle(cell_style); 
//for(int r=0;r<dicsList.size()+1;r++){
//           cell12=rwds.createCell(r+2);
//            cell12.setCellValue(totalDIC);
//                  cell12.setCellStyle(cell_style); 
//} }
 
System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+months1[z]);
totalDIC=0;
 ansas3=0;
       totalCounts=0;
       ansas2=0;
       ansas1=0;
       ansas4=0;
a+=f;

 if(!dics.isEmpty() && dics!=null){
        dics.clear();
    }
//       a+=1;      
     }
     
      ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename="+period+"_Services_DIC_Report_Created_On_"+formattedDate+".xls");
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
            Logger.getLogger(NumberOfEnrollments.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NumberOfEnrollments.class.getName()).log(Level.SEVERE, null, ex);
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
