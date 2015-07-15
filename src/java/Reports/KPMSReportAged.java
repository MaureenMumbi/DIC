/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;


import Reports.copytemplates_1;
import dbConnect.dbConnect;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Maureen
 */
@WebServlet(name = "KPMSReportAged", urlPatterns = {"/KPMSReportAged"})
public class KPMSReportAged extends HttpServlet {

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
           String agebracket=""; 
             startdate= request.getParameter("startdate");
          enddate= request.getParameter("enddate");
         // period= "monthly";
          period= request.getParameter("period");
            int a=1;
            int count=0;
           // dbConnect  conn = new dbConnect();
                XSSFCell cell,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
//                HSSFWorkbook wb=new HSSFWorkbook();
//           String allpath="";   
          

            
                
              
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
    
    String mydrive="";
    if(period.equals("monthly")){
      String path=getServletContext().getRealPath("/dbconnection.txt");
      mydrive = path.substring(0, 1);
      
            System.out.println("drive name   "+mydrive);
        Date da= new Date();
String dat2 = da.toString().replace(" ", "_");
 dat2 = dat2.toString().replace(":", "_");

      
       String np=mydrive+":\\DIC_DBBACKUP\\MACROS\\enrolled"+dat2+".xlsm";
     
             // String desteepath1 = getServletContext().getRealPath("/Females 15to24.xlsm");
              String sr = getServletContext().getRealPath("/EnrolledTemplate.xlsm");
    //check if file exists
              
   //first time , it should create those folders that host the macro file
    File f = new File(np);
if(!f.exists()&& !f.isDirectory() ) { /* do something */
copytemplates_1 ct= new copytemplates_1();
    ct.transfermacros(sr,np);
 //rem np is the destination file name  
   
    System.out.println("Copying macros first time ..");
    
}
else
  //copy the file alone  
{
copytemplates_1 ct= new copytemplates_1();
//copy the agebased file only
ct.copymacros(sr,np);

}
     //String allpath = getServletContext().getRealPath("/EnrolledTemplate.xlsm");

                
                XSSFWorkbook wb;

//wb = new XSSFWorkbook();
wb = new XSSFWorkbook(OPCPackage.open(np));
            XSSFSheet shet1=wb.getSheet("Sheet0");
//XSSFSheet shet1=wb.createSheet();
                XSSFRow rw1=shet1.createRow(1);
                   
                    
   
     
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
                     cell.setCellValue("ENROLLED");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DICNAME ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("COUNTY");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("MONTH NAME");
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("AGE BRACKET");
                         
//   String enrollments="select count(UniqueID),DICName,"
//            + " case when DICName='Naivasha' then district='Naivasha'"
//          + " else district end as County"
//            + " ,SUM(CASE WHEN DOB<='14' THEN 1 ELSE 0 END) AS <14, "
//           +   "SUM(CASE WHEN DOB>'14' AND DOB<='19' THEN 1 ELSE 0 END) AS 15-19 "
//           +   "SUM(CASE WHEN DOB>'19' AND DOB<='24' THEN 1 ELSE 0 END) AS 20-24 "
//           +   "SUM(CASE WHEN DOB>'24' AND DOB<='49' THEN 1 ELSE 0 END) AS 25-49 "
//       
//            + ",month(STR_TO_DATE(DOE,'%e/%c/%Y')), YEAR(STR_TO_DATE(DOE,'%e/%c/%Y')), TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE()) from enrollment  where "
//                + " (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
//                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) group by DICName,District,month(STR_TO_DATE(DOE,'%e/%c/%Y'))  ";
//        
             
String enrollments="select count(UniqueID),DICName," +
"             case when DICName='Naivasha' then district='Naivasha'" +
"          else district end as County ," +
"          month(STR_TO_DATE(DOE,'%e/%c/%Y')) as month, " +
"          YEAR(STR_TO_DATE(DOE,'%e/%c/%Y'))," +
"         CASE " +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='14' THEN '<14'" +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'14' AND TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='19' THEN '15-19' " +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'19' AND TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='24' THEN '20-24'" +
"		 WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'24'AND TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='49' THEN  '25-49' " +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'49' THEN  '25-49' END AS AGEBRACKET" +
"         " +
"         ,TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())" +
"          from enrollment  where " +
"               (STR_TO_DATE(DOE,'%e/%c/%Y')) " +
"               BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))" +
"                AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) " +
"                group by DICName,AGEBRACKET,month" ;

conn.rs = conn.state.executeQuery(enrollments);
while(conn.rs.next()){
//System.out.println(conn.rs.getString(1)+"###"+conn.rs.getString(2)+"###"+conn.rs.getString(3)+"###"+conn.rs.getString(4)+"###"+conn.rs.getString(6)+"###"+conn.rs.getString(7)+"###"+conn.rs.getString(8));
System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
count++;
//a++;

 String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              if(conn.rs4.next()){
                district=conn.rs4.getString(1);
              }
              else{
              district="Naivasha";
              }
              
              
               String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs.getInt(4) +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            month = conn.rs5.getString(1);}


//if(!conn.rs.getString(3).equals("others")){
    
    
  XSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
               
                 cell12.setCellValue(conn.rs.getInt(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(district);
                 cell13=rwa.createCell(3);
                 cell13.setCellValue(""+conn.rs.getInt(5)+ " ("+conn.rs.getInt(4)+") "+ month.substring(0,3) );
                    cell12=rwa.createCell(4);
                 cell12.setCellValue(conn.rs.getString(6));
//                 cell14=rwa.createCell(4);
//                 cell14.setCellValue(conn.rs.getString(5));

                  //cell12.setCellStyle(cell_style);

}

//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=EnrollmentMonthlyAgeReport_"+startdate+"-"+enddate+".xlsm");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
    }
    
    else if(period.equals("quarterly")){
           String path=getServletContext().getRealPath("/dbconnection.txt");
      mydrive = path.substring(0, 1);
      
            System.out.println("drive name   "+mydrive);
        Date da= new Date();
String dat2 = da.toString().replace(" ", "_");
 dat2 = dat2.toString().replace(":", "_");

      
       String np=mydrive+":\\DIC_DBBACKUP\\MACROS\\served"+dat2+".xlsm";
     
             // String desteepath1 = getServletContext().getRealPath("/Females 15to24.xlsm");
              String sr = getServletContext().getRealPath("/ServedTemplate.xlsm");
    //check if file exists
              
   //first time , it should create those folders that host the macro file
    File f = new File(np);
if(!f.exists()&& !f.isDirectory() ) { /* do something */
copytemplates_1 ct= new copytemplates_1();
    ct.transfermacros(sr,np);
 //rem np is the destination file name  
   
    System.out.println("Copying macros first time ..");
    
}
else
  //copy the file alone  
{
copytemplates_1 ct= new copytemplates_1();
//copy the agebased file only
ct.copymacros(sr,np);

}   
      //  byte dataToWrite[] = //...;
FileOutputStream out = new FileOutputStream("the-file-name");
//out.write(dataToWrite);
out.close();
         //String allpath = getServletContext().getRealPath(np);

            System.out.println("nn   "+np);
                XSSFWorkbook wb;

wb = new XSSFWorkbook(OPCPackage.open(np));
        
            XSSFSheet shet1=wb.getSheet("Sheet0");
                XSSFRow rw1=shet1.createRow(1);
                   


//wb = new XSSFWorkbook();
//
//XSSFSheet shet1=wb.createSheet();
//                XSSFRow rw1=shet1.createRow(1);           
//   
     
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
                     cell.setCellValue("SERVED");
                        cell2 = rw1.createCell(1);
                     cell2.setCellValue("DICNAME ");
                        cell3 = rw1.createCell(2);
                     cell3.setCellValue("COUNTY");
                        cell4 = rw1.createCell(3);
                     cell4.setCellValue("MONTH");
                        cell4 = rw1.createCell(4);
                     cell4.setCellValue("AGE BRACKET");
                        
    String enrollments="select count(DISTINCT riskreductionmain.UniqueID),DICName,"
            + " case when DICName='Naivasha' then district='Naivasha'"
          + " else district end as County"

            + ",MONTH(STR_TO_DATE(DOA,'%e/%c/%Y')),YEAR(STR_TO_DATE(DOA,'%e/%c/%Y')),"
         +   "         CASE " +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='14' THEN '<14'" +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'14' AND TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='19' THEN '15-19' " +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'19' AND TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='24' THEN '20-24'" +
"		 WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'24'AND TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())<='49' THEN  '25-49' " +
"                WHEN  TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())>'49' THEN  '25-49' END AS AGEBRACKET" +
"                   ,TIMESTAMPDIFF( YEAR,STR_TO_DATE(DOB,'%e/%c/%Y'),CURDATE())from enrollment,riskreductionmain  where "
                + " (STR_TO_DATE(DOA,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y'))"
                + " AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y')) and enrollment.uniqueid=riskreductionmain.uniqueid "
            + " group by DICName,AGEBRACKET,MONTH(STR_TO_DATE(DOA,'%e/%c/%Y')) ";
     
                     
                     
//                     String enrollments ="SELECT "
//    +"COUNT(DISTINCT RISKREDUCTIONMAIN.UNIQUEID),"
//    +"DICNAME,"
//                        +"  case when DICName='Naivasha' then district='Naivasha'"
//          + " else district end as County,"
//    +"MONTH(STR_TO_DATE(DOA, '%e/%c/%Y')) "
//+"FROM"
//    +"dic.riskreductionmain,"
//    +"ENROLLMENT"
//+"WHERE"
//    +"RISKREDUCTIONMAIN.UNIQUEID = ENROLLMENT.UNIQUEID AND "
//
//	+"(STR_TO_DATE(DOA, '%e/%c/%Y')) BETWEEN "
//+"(STR_TO_DATE('"+startdate+"', '%e/%c/%Y'))"
// +"AND (STR_TO_DATE('"+enddate+"', '%e/%c/%Y'))"
//+"GROUP BY DICNAME, MONTH(STR_TO_DATE(DOA, '%e/%c/%Y'))" ;
//


        System.out.println(enrollments);
         conn.rs = conn.state.executeQuery(enrollments);
         while(conn.rs.next()){
           
         System.out.println(conn.rs.getString(1)+"________"+conn.rs.getString(2)+"________"+conn.rs.getString(3)+"_______"+conn.rs.getString(4) );
              String county=" select district from districts where districtid='"+conn.rs.getString(3)+"'";
              conn.rs4 = conn.state4.executeQuery(county);
              if(conn.rs4.next()== true){
                district=conn.rs4.getString(1);
              }
             else if (conn.rs.getString(3).equals("0")){
                  district="Naivasha";
              }
              
                
                
                if(conn.rs.getString(4).equals("1")){
                  qtr=2;
                }
                else if(conn.rs.getString(4).equals("2")){
                  qtr=3;
                }
                else if(conn.rs.getString(4).equals("3")){
                  qtr=4;
                }
                else if(conn.rs.getString(4).equals("4")){
                  qtr=1;
                }
           String getmonths="select MONTH_NAME from months where MONTH_ID='"+conn.rs.getInt(4) +"' ";
            conn.rs5 = conn.state5.executeQuery(getmonths);
            while(conn.rs5.next()){
            month = conn.rs5.getString(1);
            }


//if(!conn.rs.getString(3).equals("others")){
    
    
  XSSFRow rwa = shet1.createRow(a+=1);
  System.out.println("^^^"+a+""+count);
                 cell12=rwa.createCell(0);
                 cell12.setCellValue(conn.rs.getInt(1));
                 cell12=rwa.createCell(1);
                 cell12.setCellValue(conn.rs.getString(2));
                 cell12=rwa.createCell(2);
                 cell12.setCellValue(district);
                 cell13=rwa.createCell(3);
                  cell13.setCellValue(""+conn.rs.getInt(5)+ " ("+conn.rs.getInt(4)+") "+ month.substring(0,3) );
                 cell14=rwa.createCell(4);
                 cell14.setCellValue(conn.rs.getString(6));
}

//}
    
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=ServedQuarterlyAgeReport_"+startdate+"-"+enddate+".xlsm");

OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        
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
