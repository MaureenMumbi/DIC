/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import SCRIPTS.IdGenerator;
import dbConnect.dbConnect;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

/**
 *
 * @author Emmanuel E
 */
public class bimetricreport extends HttpServlet {
  HSSFWorkbook wb=null;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
           
            
             String statichour=" 00:00:00";
             String startdate="2012-01-01";
            String enddate="2015-11-15"; 
             
            
            if(request.getParameter("startdate")!=null&&!request.getParameter("startdate").equals("")){            
             startdate= request.getParameter("startdate");              
             }
            
             if(request.getParameter("enddate")!=null&&!request.getParameter("enddate").equals("")){            
             enddate= request.getParameter("enddate");              
             }
            
            String startdatecopy=startdate+statichour;
            String enddatecopy=enddate+statichour; 
            
            
            wb=new HSSFWorkbook();
            HSSFSheet shet3=wb.createSheet("Biometric Records"); 
            
               
             
    HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
   stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
    stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
    stylex.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    
HSSFFont fontx = wb.createFont();
fontx.setColor(HSSFColor.DARK_BLUE.index);
stylex.setFont(fontx);
stylex.setWrapText(true);

HSSFCellStyle stylemainHeader = wb.createCellStyle();
stylemainHeader.setFillForegroundColor(HSSFColor.ORANGE.index);
stylemainHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
stylemainHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
stylemainHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
stylemainHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
stylemainHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
stylemainHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
stylemainHeader.setWrapText(true);

    HSSFCellStyle styleHeader = wb.createCellStyle();
    styleHeader.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
    styleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
    styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
    styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    styleHeader.setWrapText(true);  
    
    
       
    HSSFCellStyle stborder = wb.createCellStyle();
    stborder.setBorderTop(HSSFCellStyle.BORDER_THIN);
    stborder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    stborder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    stborder.setBorderRight(HSSFCellStyle.BORDER_THIN);
    stborder.setAlignment(HSSFCellStyle.ALIGN_LEFT);
    stborder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    stborder.setWrapText(true);

    
            HSSFFont font1 = wb.createFont();
            font1.setFontName("Cambria");
            font1.setColor((short) 0000);
            stborder.setFont(font1);
            
    
    
    
    // for the red color
    HSSFCellStyle redstyle = wb.createCellStyle();
    redstyle.setFillForegroundColor(HSSFColor.RED.index);
    redstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    redstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
    redstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    redstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    redstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    redstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    redstyle.setWrapText(true);
    

  shet3.setColumnWidth(0, 4000);  
  shet3.setColumnWidth(1, 5000);  
  shet3.setColumnWidth(2, 4000);  
  
        HSSFRow header= shet3.createRow(0);
        header.setHeightInPoints(30);
        HSSFCell title=header.createCell(0);
        title.setCellValue("BIOMETRICS UPDATED BETWEEN DATE "+startdate+" AND "+enddate);
        title.setCellStyle(stylemainHeader);
        shet3.addMergedRegion(new CellRangeAddress(0,0,0,2));
        String headervalues[]={"County","DIC Name","No. of Clients"}; 
       
         HSSFRow header1= shet3.createRow(1);
         
        header1.setHeightInPoints(25);
        HSSFCell title1=null;
         
        for(int a=0;a<headervalues.length;a++){
        title1=header1.createCell(a);
        title1.setCellValue(headervalues[a]);
        title1.setCellStyle(styleHeader);
        }
       dbConnect conn= new dbConnect();
                      
       String data="Select districts.District as COUNTY, DICNAME, count(DISTINCT(UniqueID)) as enrolled from enrollment join districts on enrollment.District=districts.DistrictID where  (fingerprint !='' and fingerprint!='null') and  (timestamp between TIMESTAMP('"+startdate+"') and TIMESTAMP('"+enddate+"') )  group by DICNAME";
            
            System.out.println(""+data);
            
            
            conn.rs=conn.state.executeQuery(data);
             HSSFRow rwx=null;
             int rowno=2;
            while(conn.rs.next()){
                
                System.out.println(""+conn.rs.getString(1));
                 rwx= shet3.createRow(rowno); 
                  rwx.setHeightInPoints(20);
         rowno++;
                 HSSFCell clx=null;
         
        for(int a=0;a<headervalues.length;a++){
        clx=rwx.createCell(a);
        clx.setCellValue(conn.rs.getString(a+1));
        clx.setCellStyle(stborder);
        }
                
                
                
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(bimetricreport.class.getName()).log(Level.SEVERE, null, ex);
        }
     
            IdGenerator IG = new IdGenerator();
            String createdOn = IG.CreatedOn();
            
            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();
            response.setContentType("application/ms-excel");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0"); // eliminates browser caching
            response.setHeader("Content-Disposition", "attachment; filename=Biometric_Generated_On_" + createdOn + ".xls");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
            outStream.close();
        
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
