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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

/**
 *
 * @author Maureen
 */
public class riskreductionsreport extends HttpServlet {

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
//        PrintWriter out = response.getWriter();
        try {
            int a=1;
            int count=0;
            dbConnect  conn = new dbConnect();
                HSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
                HSSFWorkbook wb=new HSSFWorkbook();
                HSSFSheet shet1=wb.createSheet();
                HSSFRow rw1=shet1.createRow(1);
                     for (int y =1; y <=6; ++y) {
                        cell = rw1.createCell(y);
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
                
              
            /* TODO output your page here. You may use following sample code. */
       //  for(int y=0;y<districts.length;y++){
        ArrayList dics = new ArrayList();

                     String dicnames="select * from dicname where DistrictID='3'";
conn.rs6 = conn.state6.executeQuery(dicnames);
while(conn.rs6.next()){  
  dics.add(conn.rs6.getString("DICName"));  
   System.out.println(dics.get(0));
  // diccount++;
   
}
        //}
    for(int e=0;e<dics.size();e++){ 
    String query ="select enrollment.DICName,"
                + " riskreductiondetails.QID, "
	+"CASE  WHEN riskreductiondetails.QID='B1' THEN 'CONDOMS PROVIDED' " 
		+"WHEN riskreductiondetails.QID ='B3'THEN 'WBL PROVIDED' "
                   +"WHEN riskreductiondetails.QID='C' THEN 'AUDITS'" 
	           +"WHEN riskreductiondetails.QID='D2'  THEN 'HEALTH EDUCATION' "
		 +"WHEN riskreductiondetails.QID='E1' THEN 'HIV TESTED'"
		 +"WHEN riskreductiondetails.QID='E2' THEN 'TESTED WITH PARTNER' "
		 +"WHEN riskreductiondetails.QID='F1' THEN 'STI CHECKUP'" 
		 +"WHEN riskreductiondetails.QID='G1' THEN 'CC SCREENING'"
		 +"WHEN riskreductiondetails.QID='H1' THEN 'TB SCREENING'" 
		 +"WHEN riskreductiondetails.QID='I' THEN 'GBV REFERRAL' "
		 +"WHEN riskreductiondetails.QID='J1' THEN 'FP METHOD'" 
		 +"WHEN riskreductiondetails.QID='J2' THEN 'PROVIDED FP' "
		 +"WHEN riskreductiondetails.QID='K' THEN 'IGA GROUP'" 
                 +"WHEN riskreductiondetails.QID='J3' THEN 'FAMILY PLANNING METHOD'" 
	 +"ELSE 'others' "
	+"END AS 'INDICATORNAME',"

                        +"CASE  "
		+"WHEN riskreductiondetails.QID='B1' THEN riskreductiondetails.QID =SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1))"
                + " WHEN riskreductiondetails.QID='B3' THEN SUM(SUBSTRING_INDEX(riskreductiondetails.Action, '_', -1) )END as 'FREQUENCY1',"
            
                + "COUNT(CASE WHEN riskreductiondetails.QID='C' AND (riskreductiondetails.currentstatus>0 or riskreductiondetails.action>0) THEN (riskreductiondetails.currentstatus)  or (riskreductiondetails.action)"
                + " WHEN riskreductiondetails.QID='D2'AND riskreductiondetails.currentstatus = 'Yes' THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='E1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='E2' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='F1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus"
                + " WHEN riskreductiondetails.QID='G1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus"
                + " WHEN riskreductiondetails.QID='H1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='I' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='J1' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='J2' AND riskreductiondetails.currentstatus = 'Yes' THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID='K' AND riskreductiondetails.currentstatus = 'Yes'  THEN riskreductiondetails.currentstatus "
                + "WHEN riskreductiondetails.QID ='J3' AND (riskreductiondetails.currentstatus != '' or riskreductiondetails.action != '')"
                + " THEN riskreductiondetails.currentstatus END) as 'FREQUENCY',"
                
                +"CASE WHEN riskreductiondetails.QID ='J3' AND (riskreductiondetails.currentstatus != '' or riskreductiondetails.action != '') THEN riskreductiondetails.currentstatus end as fpmethods,"
+"riskreductionmain.qtr, riskreductionmain.year "
                + "from enrollment,riskreductionmain ,riskreductiondetails"
                + " where riskreductionmain.UniqueID = enrollment.UniqueID and "
                + "riskreductiondetails.RiskReductionID= riskreductionmain.RiskReductionID "
                + "and str_to_date(riskreductionmain.DOA,'%e/%c/%Y') between str_to_date('01/05/2014','%e/%c/%Y') "
                + "and str_to_date('30/05/2014','%e/%c/%Y') and enrollment.DICName='"+dics.get(e)+"'"
                + "group by riskreductiondetails.QID";

conn.rs = conn.state.executeQuery(query);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(3)+"________"+conn.rs.getString(4)+"________"+conn.rs.getString(5)+"_______"+conn.rs.getString(6));
count++;
//a++;

if(!conn.rs.getString(3).equals("others")){
  HSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getString(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(3));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(conn.rs.getString(4));
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(conn.rs.getString(5));
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(conn.rs.getString(6));}
                  //cell12.setCellStyle(cell_style);

}}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=ServiceProvided.xls");
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
        } finally {            
            //out.close();
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
            Logger.getLogger(riskreductionsreport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(riskreductionsreport.class.getName()).log(Level.SEVERE, null, ex);
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
