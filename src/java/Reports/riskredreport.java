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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author AphiaPlus
 */
public class riskredreport extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
 int total=0;
 int a=0;
 int columnadd=0;
 int columnadd1=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        
   try{
    
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
  String[]  questions = new String[]{"D2","E1","E2","F1","G1","H1","I","J1","J2","K","J3"};
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
   System.out.println(dics.get(0));
   diccount++;
   
}}
                        cells_6 = rows.createCell(diccount);
                        cells_6.setCellStyle(style_header);
                      cells_6.setCellValue("Total");                  
  
HSSFRow row4 = shet1.createRow(a+2);
String qtr="";
                if(quarters2[z].equals("Q1")){
                  qtr="1";  
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
                               cells_7.setCellValue("QUARTER:   "+conn.rs4.getString("QUARTER_NAME") +"  "+reportyear);
                       }
                     row4.setHeightInPoints(30);
   HSSFRow rwa = shet1.createRow(a + 3); 
                      
             
                   HSSFRow rowc = shet1.createRow(a + 5);
                 
                 for(int u=0;u<dics.size();u++){
     
//  
                      row4.setHeightInPoints(30);
    

int totalperrow=0;
   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
        if(dics.get(u)!=null && !dics.get(u).equals("")){            
                cell1=rwa.createCell(2+u);
                 cell1.setCellValue("");
                  cell1.setCellStyle(cell_style); 
                     String hhh="select enrollment.DICName, riskreductiondetails.QID, \n" +
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
"		WHEN 'J1' THEN 'FP METHOD' \n" +
"		WHEN 'J2' THEN 'PROVIDED FP' \n" +
"		WHEN 'K' THEN 'IGA GROUP' \n" +
"         WHEN 'J3' THEN 'FAMILY PLANNING METHOD' \n" +

"	END as 'INDICATORNAME',\n" +
"\n" +
"CASE riskreductiondetails.QID \n" +
"		WHEN 'B1' THEN riskreductiondetails.QID =SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1))  \n" +
"		WHEN 'B3' THEN SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1) ) end as e,\n" +
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
"		WHEN riskreductiondetails.QID='J2' AND riskreductiondetails.currentstatus = 'Yes' \n" +
" THEN riskreductiondetails.currentstatus\n" +
"WHEN 'K' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus\n" +
"WHEN riskreductiondetails.QID ='J3' AND (riskreductiondetails.currentstatus != '' or riskreductiondetails.action != '') \n" +
" THEN riskreductiondetails.currentstatus		\n" +
"		\n" +
"END) as kkk,\n" +
"CASE WHEN riskreductiondetails.QID ='J3' AND (riskreductiondetails.currentstatus != '' or riskreductiondetails.action != '') \n" +
"THEN riskreductiondetails.currentstatus end as 'FREQUENCY',\n" +
"\n" +
"riskreductionmain.qtr, riskreductionmain.year\n" +
"from enrollment, \n" +
"	riskreductionmain, \n" +
"	riskreductiondetails\n" +
"	where riskreductionmain.UniqueID = enrollment.UniqueID \n" +
"	and riskreductiondetails.RiskReductionID= riskreductionmain.RiskReductionID \n" +
"	and  Enrollment.DICName='"+dics.get(u).toString()+"' AND RiskReductionMain.qtr='"+quarters2[z]+"' AND RiskReductionMain.year='"+reportyear+"'"+
//                             + "str_to_date(riskreductionmain.DOA,'%e/%c/%Y') between\n" +
//"str_to_date('01/04/2014','%e/%c/%Y') and str_to_date('30/04/2014','%e/%c/%Y')\n" +
"group by riskreductiondetails.QID,enrollment.DICName\n" +
"";
                     
                   
     conn.rs = conn.state.executeQuery(hhh) ;
           
        while(conn.rs.next()){
      System.out.println("aa"+conn.rs.getString(1)+ "  "+conn.rs.getString(2)+"  "+conn.rs.getString(3)+"  "+conn.rs.getString(4));
                    
                        if(conn.rs.getString(3)!=null && !conn.rs.getString(3).equals("")){
                              HSSFRow rwc = shet1.createRow(a+3);
                              cell1=rwc.createCell(0);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(conn.rs.getString(1)); 
         
         
         
//         if(conn.rs.getString(3)!=null && !conn.rs.getString(3).equals("")){
//                               }
          if(conn.rs.getString(3).equals("FAMILY PLANNING METHOD")){
         cell1=rwc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(conn.rs.getString(6));}
         else{
                 cell1=rwc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(conn.rs.getString(3)); 
                 }
         
         
       

         System.out.println("gg"+a);
                        if(conn.rs.getString(4)!=null && !conn.rs.getString(4).equals("")){

                cell12=rwc.createCell(2);
                 cell12.setCellValue(conn.rs.getString(4));
                  cell12.setCellStyle(cell_style);
                   totalperrow+=conn.rs.getInt(4);   
            }
                        else{
                 cell12=rwc.createCell(2);
                 cell12.setCellValue(conn.rs.getString(5));
                 cell12.setCellStyle(cell_style);
                     totalperrow+=conn.rs.getInt(5);   
                        }
                       
                         cell12=rwc.createCell(3);
                 cell12.setCellValue(conn.rs.getString(7));
                  cell12.setCellStyle(cell_style);
                  
                  
                         cell12=rwc.createCell(4);
                 cell12.setCellValue(conn.rs.getString(8));
                  cell12.setCellStyle(cell_style);
                       
                          a++;
                        }
//                        else{
//                  cell12=rwc.createCell(u+2);
//                  cell12.setCellValue("");
//                  cell12.setCellStyle(cell_style);      
//                        
//                        
//                        }
         
               
                        
 
        
        }
        }
                 }
        }}
   
   
   
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
            Logger.getLogger(rrreport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(rrreport.class.getName()).log(Level.SEVERE, null, ex);
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
