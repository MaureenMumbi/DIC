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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


/**
 *
 * @author Maureen
 */
@WebServlet(name = "DuplicateReport", urlPatterns = {"/DuplicateReport"})
public class DuplicateReport extends HttpServlet {

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
            throws ServletException, IOException, SQLException, InvalidFormatException {
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
        try {
            dbConnect conn = new dbConnect();
          
         String startdate="";
          String enddate="";
          String period="";
          String district="";
          String month="";
          
          int qtr=0;
          String quarters="";
            
             startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
//         // period= "monthly";
//          period= request.getParameter("period");
            int a=1;
            int count=0;
           // dbConnect  conn = new dbConnect();
                HSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
                HSSFWorkbook wb=new HSSFWorkbook();


                HSSFSheet shet1=wb.createSheet();
                HSSFRow rw1=shet1.createRow(1);
     
    String year[];
    year = startdate.split("/");
    
//    if(period.equals("monthly")){
    
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
        
            cell = rw1.createCell(0);
                     cell.setCellValue("UNIQUEID");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DICNAME ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("COUNTY");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("DOE");
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("UNIQUE KEY");
                        cell4 = rw1.createCell(5);
                     cell4.setCellValue("FIRST NAME");
                        cell4 = rw1.createCell(6);
                     cell4.setCellValue("MIDDLE NAME");
                         
                        cell4 = rw1.createCell(7);
                     cell4.setCellValue("LAST NAME");
                        cell4 = rw1.createCell(8);
                     cell4.setCellValue("DUPLICATE");
                         
//    String enrollments="select count(UniqueID),DICName,District,MONTH(STR_TO_DATE(DOE,'%e/%c/%Y'))from enrollment  where "
//                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
//                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) ";
//
                     
                     
                     String occurences="1";
                     
                     
                    // for(int i=0;i<occurences.length;i++){
//   String enrollments = "SELECT uniqueid,district,dicname,doe ,CONCAT(u.firstname,\"\", u.secondname,\"\", u.lastname), u.firstname, u.secondname, u.lastname from"
//+" enrollment u"
//+" inner join("
//+" select count(*) c ,firstname, secondname,"
//+" lastname, CONCAT(firstname,\"\", secondname,\"\", lastname)"
//+" from enrollment where"
//+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('01/04/2014','%e/%c/%Y')) AND (STR_TO_DATE('30/09/2014','%e/%c/%Y'))"
//+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname)"
//+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname))=1"
//+" ) as temp"
//+" on"
//+" temp.firstname= u.firstname"
//+" and temp.secondname=u.secondname"
//+" and temp.lastname= u.lastname"
//+" where"
//+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('01/04/2014','%e/%c/%Y')) AND (STR_TO_DATE('30/09/2014','%e/%c/%Y'))"
//+" order by firstname, secondname,lastname ";

   String enrollments="SELECT uniqueid,district,dicname,doe "
           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , upper(u.firstname), upper(u.secondname),"
+"upper(u.lastname) from "
+"enrollment as u "
+" inner join("
+" select count(*) c ,firstname, secondname,"
+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname)"

+" from enrollment where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('01/04/2014','%e/%c/%Y')) AND (STR_TO_DATE('30/09/2014','%e/%c/%Y'))"
+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname)"
+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname))>1"
+" ) as temp"
+" on"
+" temp.firstname= u.firstname"
+" and temp.secondname=u.secondname"
+" and temp.lastname= u.lastname"
+" where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" order by u.firstname, u.secondname,"
+" u.lastname limit 100000000";

   
   conn.rs = conn.state.executeQuery(enrollments);

System.out.println(enrollments);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;
//a++;
//
 String county=" select district from districts where districtid='"+conn.rs.getString(2)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              while(conn.rs4.next()){
                district=conn.rs4.getString(1);
              }
//             
//              
//              
//
//
////if(!conn.rs.getString(3).equals("others")){
//    
//    
  HSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(district);
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs.getString(3));
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(conn.rs.getString(4));
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(conn.rs.getString(5));
                 cell14=rwa.createCell(5);
                 cell14.setCellValue(conn.rs.getString(6));
                 cell14=rwa.createCell(6);
                 cell14.setCellValue(conn.rs.getString(7));
                 cell14=rwa.createCell(7);
                 cell14.setCellValue(conn.rs.getString(8));
                 cell14=rwa.createCell(8);
                 cell14.setCellValue("1");

                

}
                     //}

//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DuplicatesReport.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
        
  
    response.sendRedirect("DuplicateReport.jsp");
     		
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
