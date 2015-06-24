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

/**
 *
 * @author Maureen
 */
public class RepeatVisit extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        try {
  
           String quarter="";
  String semiannual="";
   String dates1="";
   String dates2="";
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
        String DIC1="";
        String totalDIC="";
   int total= 0;
   int a=1;
    int columnadd=1;
    int columnadd1=1;
   String reportyear="";
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
  HSSFRow rw1=shet1.createRow(0);
  HSSFCell cell;
//  cell=rw1.createCell(1);
//  cell.setCellValue("DIC REPORTS");
//   cell.setCellStyle(style_header);
    
    String months[] = new String[]{"Jan","Feb","March","April","May","June","July","August","Sept","Nov","Oct","Dec"};
    String quarters[] = new String[]{"Oct-Dec","Jan-March","April-June","July-Sept"};
  
  
  ArrayList lister= new ArrayList();
//  Merge the cells
//  shet1.addMergedRegion(new CellRangeAddress(1,1,1,3));
            
//   HSSFRow rw4=shet1.createRow(3);
//    rw4.setHeightInPoints(25);
////    rw4.setRowStyle(style);
////    
//   HSSFRow rw5=shet1.createRow(2);
//    rw5.setHeightInPoints(25);

   
    ArrayList dics = new ArrayList();
    ArrayList dicsList = new ArrayList();
    ArrayList quarters1 = new ArrayList();
    ArrayList years1 = new ArrayList();
   String[] months1 =null ;
    
    
// rw4.createCell(1).setCellValue("Number");
    HSSFCell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
 

String dicnames1="";
int years=0;

String DICNames="";
String[] districts=null;

if(request.getParameter("startdate") !=null && !request.getParameter("startdate").equals("") ){
            
            dates1=request.getParameter("startdate");
            }
            if(request.getParameter("enddate") !=null && !request.getParameter("enddate").equals("") ){
            
            dates2=request.getParameter("enddate");
            }

            if(request.getParameterValues("district") !=null && !request.getParameterValues("district").equals("") ){
            
            districts=request.getParameterValues("district");
            }
            String reporttype="";
            String period="";
           
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
 
 String noof="";
 String noofs="";
 String noof1="";

        int counters=0;
          ArrayList   listers = new ArrayList() ;
             
           
          String dicnames2="";
 String[] availableQTR;
System.out.println("reporttype"+reporttype);
System.out.println("period"+period);
System.out.println("dates1"+dates1);
System.out.println("dates2"+dates2);

 
 
 if( period.equalsIgnoreCase("monthly")){
   
//           HSSFRow row2 = shet1.createRow(b);
//                  row2.setHeightInPoints(30);
     
     for (int y =1; y <=6; ++y) {
//    Cell cell = row.createCell(i);
                        cell = rw1.createCell(y);
                        cell.setCellStyle(indicator_style);
                        if (y == 1) {
                            cell.setCellValue("DIC REPEAT VISITS REPORT");
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
//     quarteryear=new String[]{"Q1","Q2","Q3","Q4"};
//     quarteryearnames=new String[]{"Oct-Dec","Jan-March","April-June","July-Sept"};
//    

    
   
  HSSFCell cells_5, cells_6, cells_7, cells_8;
         
                   HSSFRow rows = shet1.createRow(a+1);
               
                   
                    for (int y = 1; y <=1; y++) {

                        cells_5 = rows.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 1) {
                               cells_5.setCellValue("DIC Name");
                        }
                    }
           
                    for (int y = 2; y <=2; y++) {

                        cells_5 = rows.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 2) {
                               cells_5.setCellValue("No. of repeat visits");
                        }
                    }
                    for (int y = 3; y <=3; y++) {

                        cells_5 = rows.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 3) {
                               cells_5.setCellValue("No.of new visits");
                        }
                    }
                    for (int y = 4; y <=4; y++) {

                        cells_5 = rows.createCell(y);
                        cells_5.setCellStyle(style_header);
                        if (y == 4) {
                               cells_5.setCellValue("Served in this month");
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

                              
//     for(int y=0;y<years1.size;y++){                         
       
         
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
//                        cells_6 = rows.createCell(diccount);
//                        cells_6.setCellStyle(style_header);
//                      cells_6.setCellValue("Total");                  
               
                     
   
    
   
     
        
                  

for(int u=0;u<dics.size();u++){
     
//  
//                      row4.setHeightInPoints(30);
    


   HSSFCell  cells5, cells6, cells7, cells8, cells9, cells10;
        if(dics.get(u)!=null && !dics.get(u).equals("")){            
     
            
             int counts=0; 
            int counter=0;
             int counts1=0;
                String noof1s="";
            String query="SELECT COUNT(RiskReductionMain.UNIQUEID)as no,RiskReductionMain.DOA,RiskReductionMain.UNIQUEID"
                    + "  FROM RiskReductionMain GROUP BY RiskReductionMain.UNIQUEID HAVING  no>'1'"
                    + "AND  (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('01/01/2011','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) ";
            System.out.println(query);
            conn.rs = conn.state.executeQuery(query);
            while(conn.rs.next()){
            System.out.println("^^"+conn.rs.getString(1)+""+conn.rs.getString(3));
            String query2="SELECT COUNT(RiskReductionMain.uniqueid)as no,RiskReductionMain.DOA,"
                    + " RiskReductionMain.UNIQUEID,Enrollment.DICName FROM RiskReductionMain,enrollment  where"
                    + " (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) and RiskReductionMain.uniqueid='"+conn.rs.getString(3) +"'  AND Enrollment.DICName='"+dics.get(u).toString()+"'  GROUP BY Enrollment.DICName";
              conn.rs2= conn.state2.executeQuery(query2);
              
//              System.out.println(query2);
              while(conn.rs2.next()){
//              System.out.println("kkk___"+conn.rs2.getInt(1));
              counts+=conn.rs2.getInt(1);
              counter++;
             lister.add(dicnames1) ;
             
            noof = conn.rs2.getString(1);
            ansas1 = conn.rs2.getInt(2);
            dicnames1 = conn.rs2.getString(4);
          System.out.println("a "+counter);
                 
                         

              }
              
            
            }
            
            
            
            // for new visits only 
            
            
            
                 String query1="SELECT COUNT(RiskReductionMain.uniqueid)as no,RiskReductionMain.DOA,RiskReductionMain.UNIQUEID,Enrollment.DICName"
                    + " FROM RiskReductionMain,enrollment GROUP BY RiskReductionMain.UNIQUEID,enrollment.dicname HAVING  no='1'"
                    + " AND (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('01/01/2011','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) AND Enrollment.DICName='"+dics.get(u).toString()+"'";
            
            conn.rs4 = conn.state4.executeQuery(query1);
            while(conn.rs4.next()){
            
            String query3="SELECT COUNT(RiskReductionMain.uniqueid)as no,RiskReductionMain.DOA,"
                    + " RiskReductionMain.UNIQUEID,Enrollment.DICName FROM RiskReductionMain,enrollment  where"
                    + " (STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))" 
                    + " BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) "
                    + " AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) and RiskReductionMain.uniqueid='"+conn.rs4.getString(3) +"'  AND Enrollment.DICName='"+dics.get(u).toString()+"'  GROUP BY Enrollment.DICName";
              conn.rs2= conn.state2.executeQuery(query3);
              
            
              while(conn.rs2.next()){
//              System.out.println("kkk___"+conn.rs2.getInt(1));
              counts1+=conn.rs2.getInt(1);
              counters++;
             listers.add(dicnames2) ;
          
            noof1s = conn.rs2.getString(1);
            ansas2 = conn.rs2.getInt(2);
            dicnames2 = conn.rs2.getString(4);
          System.out.println("a "+counters);
        System.out.println("noof1  "+noof1s +"dicnames2") ;        
                         

              }
              
            
            }
             System.out.println("noof1  "+noof1s +"dicnames2") ;  
            
            // end of new visits 
            System.out.println("*** "+noof1s+"___"+counts +"____"+dicnames1+"counter "+ counter );
            System.out.println("size"+lister.size());
            System.out.println("dic list size"+dicsList.size());
//            for(int h=0;h<dicsList.size();h++){
               System.out.println("dics"+ dics.get(u)+"dics2"+ dicsList.get(u));
                                   HSSFRow rows2 = shet1.createRow(a+2);
                                   cells_6=rows2.createCell(1);
                                   cells_6.setCellValue(dics.get(u).toString());
                                    cells_6.setCellStyle(style_header);
                                    
                                    
                                         cell12=rows2.createCell(2);
                                         cell12.setCellValue(counts);
                                         cell12.setCellStyle(cell_style);
                                         
                                         
                                         cell12=rows2.createCell(3);
                                         cell12.setCellValue(counts1);
                                         cell12.setCellStyle(cell_style);
               
               
   // number served
  String noserved="";
  int counts2=0;
  String dicnames3="";
  int ansas4=0;
            int counters1=0;
//          
            String query3="SELECT COUNT(DISTINCT(RiskReductionMain.uniqueid))as no,Enrollment.DICName FROM RiskReductionMain,enrollment  where"
  +"(STR_TO_DATE(RiskReductionMain.DOA,'%e/%c/%Y'))"
+"BETWEEN (STR_TO_DATE('"+dates1+"','%e/%c/%Y')) "
+"AND (STR_TO_DATE('"+dates2+"','%e/%c/%Y')) AND Enrollment.DICName='"+dics.get(u).toString()+"'  GROUP BY Enrollment.DICName";
              conn.rs3= conn.state3.executeQuery(query3);
               while(conn.rs3.next()){
//              System.out.println("kkk___"+conn.rs2.getInt(1));
              counts2+=conn.rs3.getInt(1);
              counters1++;
          
          
            noserved = conn.rs3.getString(1);
           // ansas4 = conn.rs3.getInt(2);
            dicnames3 = conn.rs2.getString(2);
          System.out.println("a "+counters);
//        System.out.println("noof1  "+noof1s +"dicnames2") ;        
                         

              }
              
            
            
             System.out.println("noof1  "+noserved +"dicnames2"+"___-" +dicnames3+ counts2) ;  
            
            // end of new visits 
//            System.out.println("***served "+noserved+"___"+counts2 +"____"+dicnames3+"counter "+ counters1 );
            
            System.out.println("dic list size"+dicsList.size());
//            for(int h=0;h<dicsList.size();h++){
               System.out.println("dics"+ dics.get(u)+"dics2"+ dicsList.get(u));
                                  
                                         cell12=rows2.createCell(4);
                                         cell12.setCellValue(counts2);
                                         cell12.setCellStyle(cell_style);
                                         
                                         
                                       
     
                                         
                                         
                                         
                                         
                                         
            
a++;

System.out.println("value of a"+ a);


 }}}
 
        // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=Repeat_Visits.xls");
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
            Logger.getLogger(RepeatVisit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RepeatVisit.class.getName()).log(Level.SEVERE, null, ex);
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
