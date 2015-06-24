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
public class Diary extends HttpServlet {

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
  String selecteddate="";
 // selecteddate= request.getParameter("selecteddate");
        dbConnect conn = new dbConnect();
        int count=0;
        try {String uniqueid="";
        String doa="";
        String dates="";
        String fname="";
        String mname="";
        String phoneno="";
        String phoneno1="";
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

     
            
            
HSSFCellStyle stylex = wb.createCellStyle();
            stylex.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            HSSFFont fontx = wb.createFont();
            fontx.setColor(HSSFColor.DARK_BLUE.index);
            stylex.setFont(fontx);
            stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
          
            stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            HSSFCellStyle styley = wb.createCellStyle();

            HSSFFont fonty = wb.createFont();
            styley.setFont(fonty);

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
   
  HSSFRow rw1=shet1.createRow(1);
  HSSFCell cell;

   HSSFRow rw4=shet1.createRow(3);
    rw4.setHeightInPoints(25);

  
   HSSFRow rw5=shet1.createRow(2);
    rw5.setHeightInPoints(25);

   
     Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);
           
  
    HSSFCell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
 

int years=0;


String DICNames="";
String[] districts=null;


            if(request.getParameterValues("district") !=null && !request.getParameterValues("district").equals("") ){
            
            districts=request.getParameterValues("district");
            }

String [] quarters2=null;
if(request.getParameterValues("Quarter")!= null && !request.getParameterValues("Quarter").equals("")){
  quarters2=request.getParameterValues("Quarter");
}

System.out.println("nnn"+quarters2[1]);
System.out.println("nnn"+quarters2[2]);
System.out.println("nnn"+quarters2[3]);
System.out.println("nnn"+districts[1]);
System.out.println("nnn"+districts[2]);
System.out.println("nnn"+districts[3]);
ArrayList dicsList = new ArrayList();
 String dic="";
 String district="";
 String Enrolls1="";
 String DOE="";
 String DOE1="";
 int i=3;
int a=1;
 int l=2;
  
 for (int y =1; y <=6; ++y) {
//    Cell cell = row.createCell(i);
                        cell = rw1.createCell(y);
                        cell.setCellStyle(indicator_style);
                        if (y == 1) {
                            cell.setCellValue("CLIENTS DUE FOR THE WEEK");
                        }
                    }
  rw1.setHeightInPoints(30);
  shet1.addMergedRegion(new CellRangeAddress(1,1,1, 6));
   
     
    shet1.setColumnWidth(1,12000); 
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
    
    
     HSSFCell cells_5, cells_6, cells_7, cells_8;
         
               ArrayList dicLists = new ArrayList();   
     
                                for(int y=0;y<districts.length;y++){
                                 String dicname="select * from dicname where DistrictID='"+districts[y]+"'";
                                conn.rs = conn.state.executeQuery(dicname);
                                System.out.println(dicname);
                                while(conn.rs.next()){  
                                  
                                 dicLists.add(conn.rs.getString("DICName"));
                                
                                }}
                                for(int t=0;t<dicLists.size();t++){
//                                  String  querys="SELECT dicname,riskreductionmain.uniqueID FROM enrollment INNER JOIN riskreductionmain where DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) BETWEEN (STR_TO_DATE('"+selecteddate+"','%e/%c/%Y')) AND DATE_ADD((STR_TO_DATE('"+selecteddate+"','%e/%c/%Y')),INTERVAL 7 DAY) and   riskreductionmain.UniqueID =  enrollment.UniqueID and dicname='"+ dicLists.get(t) +"' ";
                                  String  querys="SELECT dicname,riskreductionmain.uniqueID FROM enrollment INNER JOIN riskreductionmain where DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) BETWEEN CURDATE() AND DATE_ADD(CURDATE(),INTERVAL 7 DAY) and   riskreductionmain.UniqueID =  enrollment.UniqueID and dicname='"+ dicLists.get(t) +"' ";
                                     System.out.println(querys) ; 
                                conn.rs5 =conn.state5.executeQuery(querys);
                                       while(conn.rs5.next()){
                                            
//                                            
                                                 System.out.println("(((("+conn.rs5.getString(1) +"------"+ conn.rs5.getString(2));
//                                            
                                        }
                                        
//                                        System.out.println(dicsList.size());
//                                     
//                                        
////                                        for looping thro the dic selected 
//                                for(int h=0;h<dicsList.size();h++){
//                                    System.out.println("dics" +dicsList.get(h));
                                HSSFRow row4 = shet1.createRow(a+=1);      
                                 
//                       String  query="SELECT UniqueID,(STR_TO_DATE(DOA,'%e/%c/%Y')),DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) FROM riskreductionmain where DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) BETWEEN CURDATE() AND DATE_ADD(CURDATE(),INTERVAL 7 DAY) order by DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH)";
                       
          String  query="SELECT riskreductionmain.UniqueID,(STR_TO_DATE(DOA,'%e/%c/%Y')),DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH),dicname FROM riskreductionmain INNER JOIN enrollment where DATE_ADD((STR_TO_DATE(DOA,'%e/%c/%Y')), INTERVAL 3 MONTH) BETWEEN CURDATE() AND DATE_ADD(CURDATE(),INTERVAL 7 DAY) and   riskreductionmain.UniqueID =  enrollment.UniqueID and dicname='"+ dicLists.get(t)+"' ";
                                     
          conn.rs = conn.state.executeQuery(query); 
                          while(conn.rs.next()){
                              count++;
                              uniqueid= conn.rs.getString(1);
                              doa= conn.rs.getString(2);
                              dates= conn.rs.getString(3);
                              
                                cells_7 = row4.createCell(1);
                                     cells_7.setCellStyle(style_header);                       
                                         cells_7.setCellValue("County:   " +conn.rs.getString(4));
//                                         cells_7.setCellValue("County:   "+dicsList.get(h));
                                                row4.setHeightInPoints(30);



                         cells_5 = row4.createCell(2);
                         cells_5.setCellStyle(style_header);
                         cells_5.setCellValue("Unique ID");
                         cells_5 = row4.createCell(3);
                         cells_5.setCellStyle(style_header);
                         cells_5.setCellValue("First Name");
                         cells_5 = row4.createCell(4);
                         cells_5.setCellStyle(style_header);
                         cells_5.setCellValue("Last Name");
                         cells_5 = row4.createCell(5);
                         cells_5.setCellStyle(style_header);
                         cells_5.setCellValue("Phone No.");
                         cells_5 = row4.createCell(6);
                         cells_5.setCellStyle(style_header);
                         cells_5.setCellValue("Alt PhoneNo");
                         cells_5 = row4.createCell(6);
                         cells_5.setCellStyle(style_header);
                         cells_5.setCellValue("Visit Date");  
          a+=1;
                             String query2="SELECT * FROM enrollment where UniqueID='"+uniqueid+"'";
                              conn.rs2 = conn.state2.executeQuery(query2); 
//                               System.out.println(query2);
                               while(conn.rs2.next()){
                         
                           fname=conn.rs2.getString("FirstName");
                            mname=conn.rs2.getString("LastName");
                            phoneno=conn.rs2.getString("PhoneNo");
                           String dics=conn.rs2.getString("dicname");
                       
                           HSSFRow rwa = shet1.createRow(a); 
                            cell1=rwa.createCell(1);
                            cell1.setCellStyle(cell_style);
                            cell1.setCellValue(uniqueid);
                            
                       
                            cell1=rwa.createCell(2);
                            cell1.setCellStyle(cell_style);
                            cell1.setCellValue(fname); 
                         
                            cell1=rwa.createCell(3);
                            cell1.setCellStyle(cell_style);
                            cell1.setCellValue(mname); 
                          
                            cell1=rwa.createCell(4);
                            cell1.setCellStyle(cell_style);
                            cell1.setCellValue(phoneno);
                            
                           cell1=rwa.createCell(5);
                            cell1.setCellStyle(cell_style);
                            cell1.setCellValue(phoneno1);
                           
                            cell1=rwa.createCell(6);
                            cell1.setCellStyle(cell_style);
                            cell1.setCellValue(dates); 
                            
//                            cell1=rwa.createCell(7);
//                            cell1.setCellStyle(cell_style);
//                            cell1.setCellValue(dics); 
//                                 a+=1;
                        // details.add(DB);
                               }
                     
                     System.out.println("UNIQUE ID"+uniqueid);
                              System.out.println("DOA"+doa);
                              
                              
    } 
                                   
                         }      
//                            a=1;
                          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
String period="Weekly_";
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename="+period+"Appointment_Diary_Report_Created_On_"+formattedDate+".xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
                          
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
            Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Diary.class.getName()).log(Level.SEVERE, null, ex);
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
