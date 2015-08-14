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
public class NumberOfEnrollments extends HttpServlet {

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
  
//  shet1.addMergedRegion(new CellRangeAddress(a, a,1, 3)); 
//                    
                    
                     
                   
                   
                    HSSFRow rwa = shet1.createRow(a + 3); 
                      
                   HSSFRow rwc = shet1.createRow(a + 4);
                   HSSFRow rowc = shet1.createRow(a + 5);
                 
                   
                   //HSSFRow rwd= shet1.createRow(a +16);
                   
        
        
    
   
     
        
                  

for(int u=0;u<dics.size();u++){
     
//  
                      row4.setHeightInPoints(30);
    


   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
        if(dics.get(u)!=null && !dics.get(u).equals("")){            
                 cell12=rwa.createCell(2+u);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);     
String query1 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,Enrollment.DICName,RiskReductionMain.DOA"
        + " FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment "
        + "where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B1'  "
          + "AND RiskReductionDetails.action LIKE '%Condoms were provided_%' AND Enrollment.DICName='"+dics.get(u).toString()+"' AND RiskReductionMain.qtr='"+quarters2[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName ";
      
        System.out.println("%%%%%"+query1);
        System.out.println("%%%%%%"+dics.get(u));

//EXTRACT(YEAR_MONTH FROM '2009-07-02 01:02:03')

 conn.rs= conn.state.executeQuery(query1);
        }
 while(conn.rs.next()){
 System.out.println("______________________"+conn.rs.getString(2));
 System.out.println("______________________"+conn.rs.getString(4));
 System.out.println("______________________"+conn.rs.getString(6));

 id1 = conn.rs.getString(1);
            ansas1 = conn.rs.getInt(2);
            QID1 = conn.rs.getString(3);
            Action1 = conn.rs.getString(4);
            DIC1 = conn.rs.getString(5);
  
 condomcount+=ansas1;
//                     a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                     

 System.out.println("++++++DIC1"+DIC1+"ansa"+ansas1);
 
   
  
                 // for checking dic and placing it in correct cells
        // rwa.createCell(1).setCellValue("Condoms were provided");  
 
 
                 cell1=rwa.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue("No of condoms provided");  
         
         
         
                         if(DIC1!=null && !DIC1.equals("")){

                cell12=rwa.createCell(2+u);
                 cell12.setCellValue(ansas1);
                  cell12.setCellStyle(cell_style);
//               }
   totalDIC+=ansas1;
   
 }
 
                         
          else {
     cell12=rwa.createCell(u+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            }                   
                         
                   cell12=rwa.createCell(diccount);
                 cell12.setCellValue(condomcount);
                  cell12.setCellStyle(cell_style);
               
                        
 }
 




}
  condomcount=0;
                 ansas1=0;
//  a+=1  ;
                        
      for(int k=0;k<dics.size();k++){ 
          
          cell1=rwc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue("Water based Lubricants Provided"); 
         
                  cell12=rwc.createCell(2+k);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);       
                 String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%' AND Enrollment.DICName ='"+dics.get(k).toString()+"' AND RiskReductionMain.qtr='"+quarters2[z]+"'AND RiskReductionMain.year='"+reportyear+"'  group by Enrollment.DICName"
          ; 
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
            
            
            
            

 
 wblcount+=ansas2 ;
                         
//            ****************EXCEL FOR ONE ROW*********************************
 
  
         
               
                     
           
                 //  rwc.createCell(1).setCellValue("Water based Lubricants Provided");               
                     
                         if(DIC2!=null && !DIC2.equals("") ){

//  for(int p=2;p<=13;i++){    
  
                cell12=rwc.createCell(2+k);
                 cell12.setCellValue(ansas2);
                  cell12.setCellStyle(cell_style);
               totalDIC+=ansas2;

 
 
                         }
                         else {
     cell12=rwc.createCell(k+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            }   
                           cell12=rwc.createCell(diccount);
                 cell12.setCellValue(wblcount);
                  cell12.setCellStyle(cell_style);
                
                    
}

  }
 
   wblcount =0;
   ansas2=0;
                 
//  a+=1  ;
        for(int W=0;W<dics.size();W++){                   
                    cell12=rowc.createCell(2+W);
                 cell12.setCellValue(" ");
                  cell12.setCellStyle(cell_style);     
                      
                 String query5 ="SELECT COUNT((CASE WHEN RiskReductionDetails.action IS NULL THEN  RiskReductionDetails.currentstatus ELSE RiskReductionDetails.action END)"
                         + " OR (CASE WHEN RiskReductionDetails.currentstatus IS NULL THEN RiskReductionDetails.action"
                         + "  ELSE RiskReductionDetails.currentstatus END)) AS TOTAL ,RiskReductionDetails.QID,"
                         + "YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),"
                         + "Enrollment.DICName FROM RiskReductionDetails,RiskReductionMain,Enrollment"
                         + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                         + "and Enrollment.uniqueid = RiskReductionMain.uniqueid and RiskReductionDetails.QID='C'"
                         + " and (RiskReductionDetails.ACTION!=NULL OR RiskReductionDetails.ACTION!=''OR"
                         + "  RiskReductionDetails.currentstatus!='' OR RiskReductionDetails.currentstatus!=NULL)"
                         + " and (RiskReductionDetails.ACTION!=0 OR RiskReductionDetails.currentstatus!=0) AND  Enrollment.DICName='"+dics.get(W).toString()+"' AND RiskReductionMain.qtr='"+quarters2[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
                         ; 

 conn.rs3= conn.state3.executeQuery(query5);
 while(conn.rs3.next()){

//             id4 = conn.rs6.getString(1);
            ansas4 = conn.rs3.getInt(1);
            QID4 = conn.rs3.getString(2);
       
            DOA4 = conn.rs3.getString(3);
            DIC4= conn.rs3.getString(4); System.out.println("______________________"+conn.rs3.getString(2));
// System.out.println("______________________"+conn.rs3.getString(4));

 countJ3+=ansas4;
 
//                            a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                      
       //rowc.createCell(1).setCellValue("No of audit scores ");  
       cell1=rowc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue("No of audit scores ");
                       
                         if(DIC4!=null && !DIC4.equals("") ){

//  for(int p=2;p<=13;i++){    
  
                cell12=rowc.createCell(2+W);
                 cell12.setCellValue(ansas4);
                  cell12.setCellStyle(cell_style);
          totalDIC+=ansas4;
  
 
                         }
                          else {
     cell12=rowc.createCell(W+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            }   
   
 
                 cell12=rowc.createCell(diccount);
                 cell12.setCellValue(countJ3);
                 cell12.setCellStyle(cell_style);
                  
 
 }
// 

             

  }

 
 
     countJ3=0;
       ansas4=0;                     
  a +=6;

             
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwi = shet1.createRow(g+a);
    
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {
  
                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              
                   HSSFCell cells_1, cells_2, cells_3, cells_4;
 //rwi.createCell(1).setCellValue(questions1[g]);
 
 cell1=rwi.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(questions1[g]);

for(int t=0;t<dics.size();t++){ 
    
    cell12=rwi.createCell(2+t);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);
                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
                                 + "and RiskReductionDetails.QID='"+qstnsID+"'AND RiskReductionDetails.currentstatus='Yes' AND Enrollment.DICName='"+dics.get(t)+"' AND RiskReductionMain.qtr='"+quarters2[z]+"'AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
                                 ;
            conn.rs2 = conn.state2.executeQuery(query);
          
                   
          
            while(conn.rs2.next()){
         counts++;
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
          
            DIC = conn.rs2.getString(5);
            totalCounts = conn.rs2.getInt(6);
              totals+=  totalCounts;   

                    

     
  
       if(DIC!=null && !DIC.equals("")) {                                      

                cell12=rwi.createCell(2+t);
                 cell12.setCellValue(totalCounts);
                  cell12.setCellStyle(cell_style);
totalDIC+=totalCounts;
 
                         }
      
       else {
     cell12=rwi.createCell(t+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);}

                     
 
            }
            
           
} 


                   cell12=rwi.createCell(diccount);
                   cell12.setCellValue(totals);
                   cell12.setCellStyle(cell_style);
                  
               
     totals=0;
    totalCounts=0;
       
      
            }
        }
//        total=0;
//       totalCounts=0;
        
       a+=10;
      
 for(int e=0;e<dics.size();e++){   
//                 if(!dics.get(e).equals("") && dics.get(e)!=null){
     
//       <option value="COC PILLS">COC PILLS</option>
//                                    <option value="POC PILLS">POC PILLS</option>
//                                    <option value="INJECTABLE">INJECTABLE</option>
//                                    <option value="CONDOMS">CONDOMS</option>
//                                    <option value="TUBAL LIGATION">TUBAL LIGATION</option>
//                                    <option value="IUD">IUD</option>
//                                    <option value="TRADITIONAL">TRADITIONAL</option>
//                                    <option value="IMPLANON IMPLANTS">IMPLANON IMPLANTS</option>
//                                    <option value="JADELLE IMPLANTS">JADELLE IMPLANTS</option>
     
      String fpmethods[] = new String[]{"CONDOMS","DEPO","PILLS","JADELLE","IMPLANON","INJECTION","UID"};
  
     
                     String query3="SELECT RiskReductionDetails.RiskReductionID,count(RiskReductionDetails.currentstatus), "
                             + "RiskReductionDetails.QID,UPPER(RiskReductionDetails.currentstatus), "
                             + "YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,"
                             + "COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
                             + " RiskReductionMain,Enrollment "
                             + "where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid      "
                             + " and Enrollment.uniqueid = RiskReductionMain.uniqueid                "
                             + " AND Enrollment.DICName='"+dics.get(e)+"'  and RiskReductionDetails.QID='J3' AND "
                             + "(  UPPER(RiskReductionDetails.currentstatus)  LIKE UPPER('condoms')     "
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('depo_%')   "
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('pills') "
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('jadelle')"
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('implanon')"
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('uid')"
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('injection'))AND RiskReductionMain.qtr='"+quarters2[z]+"' AND RiskReductionMain.year='"+reportyear+"' ";

                      
                     conn.rs7 = conn.state7.executeQuery(query3);
 
//                 }
 while(conn.rs7.next()){
// System.out.println("______________________"+conn.rs7.getString(2));
// System.out.println("______________________"+conn.rs7.getString(4));

             id3 = conn.rs7.getString(1);
            ansas3 = conn.rs7.getInt(2);
            QID3 = conn.rs7.getString(3);
            Action3 = conn.rs7.getString(4);
            DOA3 = conn.rs7.getString(5);
            DIC3= conn.rs7.getString(6);
        
 FPcount+=ansas3;
 
// System.out.println("**********************DIC WITH FP PLANNING"+DIC3 +"aCTION"+Action3+"ansasa"+ansas3);
                          
//  a++;                  
//            ****************EXCEL FOR ONE ROW*********************************
                 
  
    
          if(Action3!=null && !Action3.equals("")){ 
             for(int fp=0;fp<fpmethods.length;fp++){
              HSSFRow rwd = shet1.createRow(a+=fp);
                     
    for(int h=0;h<dicsList.size();h++){
                          cell12=rwd.createCell(2+h);
                         cell12.setCellValue("");
                         cell12.setCellStyle(cell_style);
                                  
                                }
               System.out.println(fpmethods[fp]);
             if(DIC3!=null && !DIC3.equals("")) {

//    if(fpmethods[fp].equalsIgnoreCase("condoms")){
    cell1=rwd.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(fpmethods[fp]);
         System.out.println(fpmethods[fp]);
         
           cell12=rwd.createCell(2+e);
                 cell12.setCellValue(ansas3);
                  cell12.setCellStyle(cell_style);
//    }

}
              
             
//                  cell1=rwd.createCell(1);
//         cell1.setCellStyle(cell_style);
//         cell1.setCellValue(Action3);
         totalDIC+=ansas3;

   
                 cell12=rwd.createCell(diccount);
                 cell12.setCellValue(FPcount);
                 cell12.setCellStyle(cell_style); 
               FPcount=0;                 
               ansas3=0;
             } 
           
            
}
                             

 }
 System.out.println("~~~~~~~~~~~~~"+dics.get(e));

  }
 a+=1; 
 
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
a+=2;

 if(!dics.isEmpty() && dics!=null){
        dics.clear();
    }
         
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
 
 
 
 // end of quarter report 
 
 
 
 
 
 
 
 
 
 
 
 // begining of monthly report 
 
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
                  
         {
                               cells_7.setCellValue("MONTH:   "+conn.rs3.getString("MONTH_NAME") +" "+reportyear);
                        }
                    }
         }
                    
                  
//                    a++;
                    rows.setHeightInPoints(30);
                    
                    shet1.addMergedRegion(new CellRangeAddress(a, a,1, 2)); 
                      
                    
                    
                   HSSFRow row4 = shet1.createRow(a +2);
                   
                    HSSFRow rwa = shet1.createRow(a + 3); 
                      
                   HSSFRow rwc = shet1.createRow(a + 4);
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


for(int u=0;u<dics.size();u++){
     
//  
                      row4.setHeightInPoints(30);
    


   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
        if(dics.get(u)!=null && !dics.get(u).equals("")){            
                cell1=rwa.createCell(2+u);
                 cell1.setCellValue("");
                  cell1.setCellStyle(cell_style);     
String query1 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,Enrollment.DICName"
        + " FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment "
        + "where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B1'  "
          + "AND RiskReductionDetails.action LIKE '%Condoms were provided_%' AND Enrollment.DICName='"+dics.get(u).toString()+"' AND MONTH((STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')))='"+months1[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName  ";
      
        

//EXTRACT(YEAR_MONTH FROM '2009-07-02 01:02:03')

 conn.rs= conn.state.executeQuery(query1);
        }
 while(conn.rs.next()){
 System.out.println("______________________"+conn.rs.getString(2));
 System.out.println("______________________"+conn.rs.getString(4));

 id1 = conn.rs.getString(1);
            ansas1 = conn.rs.getInt(2);
            QID1 = conn.rs.getString(3);
            Action1 = conn.rs.getString(4);
            DIC1 = conn.rs.getString(5);
  
 condomcount+=ansas1;
//                     a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                     

 System.out.println("++++++DIC1"+DIC1+"ansa"+ansas1);
 
   
  
                 // for checking dic and placing it in correct cells
    
         cell1=rwa.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue("No of condoms provided");               
                        
                         if(DIC1!=null && !DIC1.equals("")){

//  for(int p=2;p<=13;i++){    

                cell1=rwa.createCell(2+u);
                 cell1.setCellValue(ansas1);
                  cell1.setCellStyle(cell_style);
               

 }
 
       else {
     cell12=rwa.createCell(u+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            }                       
                         
                         
                   cell12=rwa.createCell(diccount);
                 cell12.setCellValue(condomcount);
                  cell12.setCellStyle(cell_style);
                  
                                       
                         
 }
 




}
condomcount=0;
ansas1=0;

//  a+=1  ;
                        
      for(int k=0;k<dics.size();k++){                
                     cell1=rwc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue("Water based Lubricants Provided");   
         
         
             cell12=rwc.createCell(k+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);
                 String query2 ="SELECT RiskReductionDetails.RiskReductionID,SUM(SUBSTRING_INDEX(RiskReductionDetails.Action, '_', -1)),RiskReductionDetails.QID,RiskReductionDetails.Action,YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,"
          + " RiskReductionMain,Enrollment where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
          + " and Enrollment.uniqueid = RiskReductionMain.uniqueid"
          + " and RiskReductionDetails.QID='B3'  "
          + "AND RiskReductionDetails.action LIKE 'WBL Provided_%' AND Enrollment.DICName ='"+dics.get(k).toString()+"'  AND MONTH((STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')))='"+months1[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
          ; 
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
            
            
            
            

 
 wblcount+=ansas2 ;
                         
//            ****************EXCEL FOR ONE ROW*********************************
                       
     
//                   rwc.createCell(1).setCellValue("Water based Lubricants Provided");               
                        
                         if(DIC2!=null && !DIC2.equals("") ){

//  for(int p=2;p<=13;i++){    
 
                cell12=rwc.createCell(2+k);
                 cell12.setCellValue(ansas2);
                  cell12.setCellStyle(cell_style);
             
 
                         }
                         
                             else {
     cell12=rwc.createCell(k+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            } 
                           cell12=rwc.createCell(diccount);
                 cell12.setCellValue(wblcount);
                  cell12.setCellStyle(cell_style);
//                  wblcount =0;
//                  ansas2=0;
                   
}
 

//                      rwc.createCell(1).setCellValue(QID2);
//                      rwc.createCell(3).setCellValue(DIC2);
//                        rwc.createCell(6).setCellValue(DOA2);
//                         rwc.createCell(9).setCellValue(ansas2);
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
//shet1.addMergedRegion(new CellRangeAddress(a, a, 3, 5));
//shet1.addMergedRegion(new CellRangeAddress(a,a, 6, 8));
//shet1.addMergedRegion(new CellRangeAddress(a, a, 9, 11));
             

  }
  wblcount=ansas2=0;
 
//  a+=1  ;
        for(int W=0;W<dics.size();W++){                   
                       
                        cell12=rowc.createCell(2+W);
                 cell12.setCellValue(" ");
                  cell12.setCellStyle(cell_style);
                 String query5 ="SELECT COUNT((CASE WHEN RiskReductionDetails.action IS NULL THEN  RiskReductionDetails.currentstatus ELSE RiskReductionDetails.action END)"
                         + " OR (CASE WHEN RiskReductionDetails.currentstatus IS NULL THEN RiskReductionDetails.action"
                         + "  ELSE RiskReductionDetails.currentstatus END)) AS TOTAL ,RiskReductionDetails.QID,"
                         + "YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),"
                         + "Enrollment.DICName FROM RiskReductionDetails,RiskReductionMain,Enrollment"
                         + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                         + "and Enrollment.uniqueid = RiskReductionMain.uniqueid and RiskReductionDetails.QID='C'"
                         + " and (RiskReductionDetails.ACTION!=NULL OR RiskReductionDetails.ACTION!=''OR"
                         + "  RiskReductionDetails.currentstatus!='' OR RiskReductionDetails.currentstatus!=NULL)"
                         + " and (RiskReductionDetails.ACTION!=0 OR RiskReductionDetails.currentstatus!=0) AND  Enrollment.DICName='"+dics.get(W).toString()+"' AND MONTH((STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')))='"+months1[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
                         ; 

 conn.rs3= conn.state3.executeQuery(query5);
 while(conn.rs3.next()){

//             id4 = conn.rs6.getString(1);
            ansas4 = conn.rs3.getInt(1);
            QID4 = conn.rs3.getString(2);
       
            DOA4 = conn.rs3.getString(3);
            DIC4= conn.rs3.getString(4); System.out.println("______________________"+conn.rs3.getString(2));
// System.out.println("______________________"+conn.rs3.getString(4));

 countJ3+=ansas4;
 
//                            a += 1;
//            ****************EXCEL FOR ONE ROW*********************************
                      
//       rowc.createCell(1).setCellValue("No of audit scores ");               
               cell1=rowc.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue("No of audit scores");           
                         if(DIC4!=null && !DIC4.equals("") ){

  
 
                cell12=rowc.createCell(2+W);
                 cell12.setCellValue(ansas4);
                  cell12.setCellStyle(cell_style);
            
              
 
                         }
       else {
     cell12=rowc.createCell(W+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            } 
 
   cell12=rowc.createCell(diccount);
                 cell12.setCellValue(countJ3);
                  cell12.setCellStyle(cell_style);
//                    countJ3=0;
//                   ansas4=0;
 
 }
// 

             

  }

 
  countJ3=ansas4=0;
                
  a += 5;

             
        for(int g=0;g<questions.length;g++){
                questionQuery ="select * from questions where QuestionsID='"+questions[g]+"' and DomainID=2";
          HSSFCell cells_1, cells_2, cells_3, cells_4;
//            ****************EXCEL FOR ONE ROW*********************************
                        HSSFRow rwi = shet1.createRow(g+a);
    
            conn.rs5 = conn.state5.executeQuery(questionQuery); 
            while (conn.rs5.next()) {
  
                 qstns = conn.rs5.getString("Question");
                 qstnsID = conn.rs5.getString("QuestionsID");
                
            System.out.println(qstns);
              
 cells_1=rwi.createCell(1);
         cells_1.setCellStyle(cell_style);
         cells_1.setCellValue(questions1[g]);

for(int t=0;t<dics.size();t++){  
    
     cell12=rwi.createCell(2+t);
                 cell12.setCellValue(" ");
                  cell12.setCellStyle(cell_style);
                    String query ="SELECT RiskReductionDetails.RiskReductionID,RiskReductionDetails.currentstatus,RiskReductionDetails.QID,RiskReductionDetails.Action,Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails, RiskReductionMain,Enrollment"
                                 + " where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid "
                                 + "and Enrollment.uniqueid = RiskReductionMain.uniqueid "
                                 + "and RiskReductionDetails.QID='"+qstnsID+"' AND RiskReductionDetails.QID='B' RiskReductionDetails.currentstatus='Yes' AND Enrollment.DICName='"+dics.get(t)+"' AND MONTH((STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')))='"+months1[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by Enrollment.DICName "
                                 ;
            conn.rs2 = conn.state2.executeQuery(query);
          
                   
          
           while(conn.rs2.next()){
         counts++;
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
          
            DIC = conn.rs2.getString(5);
            totalCounts = conn.rs2.getInt(6);
              totals+=  totalCounts;   

                    

                        
 ///rwi.createCell(1).setCellValue(questions1[g]);
  
//                      rwi.createCell(3).setCellValue(DIC);
//                        rwi.createCell(6).setCellValue(DOA);
//                                              rwi.createCell(9).setCellValue(totalCounts);
       if(DIC!=null && !DIC.equals("")) {                                      
 
                cell12=rwi.createCell(2+t);
                 cell12.setCellValue(totalCounts);
                  cell12.setCellStyle(cell_style);
               
       }
      
    else {
     cell12=rwi.createCell(t+2);
                 cell12.setCellValue("");
                  cell12.setCellStyle(cell_style);

                     
 
            } 

                     
 
            }
            
           
} 


 cell12=rwi.createCell(diccount);
                 cell12.setCellValue(totals);
                  cell12.setCellStyle(cell_style);
                  
                  
                 
     totals=0;
       totalCounts=0;
       
      
            }
        }
//        total=0;
//       totalCounts=0;
        
       a+=11;
      int ecount=0;
 for(int e=0;e<dics.size();e++){   
//                 if(!dics.get(e).equals("") && dics.get(e)!=null){
                     
                     String query3="SELECT RiskReductionDetails.RiskReductionID,count(RiskReductionDetails.currentstatus), RiskReductionDetails.QID,UPPER(RiskReductionDetails.currentstatus), YEAR(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')),Enrollment.DICName,COUNT(RiskReductionDetails.currentstatus) AS NOofYes FROM RiskReductionDetails,                         RiskReductionMain,Enrollment                          where RiskReductionMain.riskreductionid = RiskReductionDetails.riskreductionid                          and Enrollment.uniqueid = RiskReductionMain.uniqueid                "
                             + " AND Enrollment.DICName='"+dics.get(e)+"'  and RiskReductionDetails.QID='J3' AND      "
                             + "(UPPER(RiskReductionDetails.currentstatus)  LIKE UPPER('condoms')     "
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('depo_%')   "
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('pills') "
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('jadelle')"
                             + "|| UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('implanon')"
                             + " ||UPPER(RiskReductionDetails.currentstatus) LIKE UPPER('injection')) AND MONTH((STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y')))='"+months1[z]+"' AND RiskReductionMain.year='"+reportyear+"' group by RiskReductionDetails.currentstatus ";

 conn.rs7 = conn.state7.executeQuery(query3);
 
//                 }
      
 while(conn.rs7.next()){
// System.out.println("______________________"+conn.rs7.getString(2));
// System.out.println("______________________"+conn.rs7.getString(4));

             id3 = conn.rs7.getString(1);
            ansas3 = conn.rs7.getInt(2);
            QID3 = conn.rs7.getString(3);
            Action3 = conn.rs7.getString(4);
            DOA3 = conn.rs7.getString(5);
            DIC3= conn.rs7.getString(6);
       
 
 FPcount+=ansas3;
      
 System.out.println("**********************DIC WITH FP PLANNING"+DIC3 +"aCTION"+Action3+"ansasa"+ansas3);
                          
                  
//            ****************EXCEL FOR ONE ROW*********************************
//            if(Action3!=null && !Action3.equals("")){
          
////HSSFRow rwd = shet1.createRow(a); 
 
// ecount++;

 if(Action3!=null && !Action3.equals("")){
//    System.out.println("ecount"+ecount);
     
    HSSFRow rwd = shet1.createRow(a++); 
    
     for(int J=0;J<dics.size();J++){
                          cell12=rwd.createCell(2+J);
                         cell12.setCellValue("");
                         cell12.setCellStyle(cell_style);
                                  
                                }
            if(DIC3!=null && !DIC3.equals("")) {
                                                
 
                cell12=rwd.createCell(2+e);
                 cell12.setCellValue(ansas3);
                  cell12.setCellStyle(cell_style);
                    cell1=rwd.createCell(1);
         cell1.setCellStyle(cell_style);
         cell1.setCellValue(Action3);
            
            }
//            else{
//              cell12=rwd.createCell(2+e);
//                 cell12.setCellValue(ansas3);
//                  cell12.setCellStyle(cell_style);
//                    cell1=rwd.createCell(1);
//         cell1.setCellStyle(cell_style);
//         cell1.setCellValue(Action3);}
 
                 cell12=rwd.createCell(diccount);
                 cell12.setCellValue(FPcount);
                  cell12.setCellStyle(cell_style); 
                  FPcount=0;
                  ansas3=0;
           
 }
//            else{
////                  a+=1;  
//                System.out.println("if entered" +e);
//                 cell1=rwd.createCell(e+2);
//                 cell1.setCellValue("");
//                  cell1.setCellStyle(cell_style);
//
//                     
//            }             
 }
 
 System.out.println("~~~~~~~~~~~~~"+dics.get(e));

  }
if(!dics.isEmpty() && dics!=null){
        dics.clear();
    }
System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+months1[z]);
  a+=3; 

     
     
    
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
 

 // write it as an excel attachment
//ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
//wb.write(outByteStream);
//byte [] outArray = outByteStream.toByteArray();
//response.setContentType("application/ms-excel");
//response.setContentLength(outArray.length);
//response.setHeader("Expires:", "0"); // eliminates browser caching
//response.setHeader("Content-Disposition", "attachment; filename=DIC Enrollment.xls");
//OutputStream outStream = response.getOutputStream();
//outStream.write(outArray);
//outStream.flush();
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
