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
public class RiskReductionReport extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ int CDCount=0;
        int WBLCount=0;
        String questionQuery="";
        String qstns="";
        String ansas="";
        String id="";
        String QID="";
        String Action="";
        String[]  CDs;
        String[]  WBL;
        int StatusAction=0;
        int count=0;
        int countD2=0;
        int countE1=0;
        int countE2=0;
        int countF1=0;
        int countG1=0;
        int countH1=0;
        int countI=0;
        int countJ1=0;
        int countJ2=0;
        int countK=0;
        int FPcount=0;
        int FPcount1=0;
        int FPcount2=0;
        int FPcount3=0;
        int FPcount4=0;
        int FPcount5=0;
        int FPcount6=0;
        int FPcount7=0;
       int rowcount=0;
        String que,que1,que2,que3,que4,que5,que6,que7,que8,que9,que10="";
         
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        dbConnect conn = new dbConnect();
       
String DICName="";
String parameter="";

if(request.getParameter("DICName")!= null && !request.getParameter("DICName").equals("")){
DICName = request.getParameter("DICName");
}
if(request.getParameter("parameter")!= null && !request.getParameter("parameter").equals("")){
parameter = request.getParameter("parameter");
}
        
        
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
          

    shet1.setColumnWidth(0, 4000); 
    shet1.setColumnWidth(1,8000 ); 
    shet1.setColumnWidth(2, 8000); 
    shet1.setColumnWidth(3, 8000); 
    shet1.setColumnWidth(4, 10000); 
  HSSFRow rw1=shet1.createRow(1);
  HSSFCell cell;
  
   for (int y =1; y <=4; ++y) {

                        cell = rw1.createCell(y);
                        cell.setCellStyle(indicator_style);
                        if (y == 1) {
                            cell.setCellValue("DIC RISK REDUCTION REPORTS");
                        }
                    }
  rw1.setHeightInPoints(30);
  shet1.addMergedRegion(new CellRangeAddress(1,1,1, 4));

            
   HSSFRow rw0=shet1.createRow(3);
    rw0.setHeightInPoints(25);

    
   HSSFRow rw=shet1.createRow(2);
    rw.setHeightInPoints(25);
     HSSFCell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;    
       String[] FPMethods = new String[]{"condom", "depo","injection", "pills","jadelle","implanon","injectable","Tubal Ligation","iud"};
        CDCount=0;
        WBLCount=0;
        count=0;
        try {
             // creating the cells for enrollment   
  cell1=rw0.createCell(1);
   cell2=rw0.createCell(2);
   cell3=rw0.createCell(3);
   cell4=rw0.createCell(4);
   
   
   // cell for row 3
//   cell6=rw5.createCell(0);
//   cell7=rw5.createCell(1);
//   cell8=rw5.createCell(4);
//   cell9=rw5.createCell(5);
 for (int y =1; y <= 4; ++y) {
//    Cell cell = row.createCell(i);
                        cell6 = rw.createCell(y);
                        cell6.setCellStyle(style_header);
                        if (y == 1) {
                            cell6.setCellValue("Services provided");
                        }
                    }
 
  rw.setHeightInPoints(20);

//  Merge the cells
                    shet1.addMergedRegion(new CellRangeAddress(2, 2, 1, 4));

//   cell6.setCellValue("No of Enrollments ");
//   cell7.setCellValue("based on months for the year "+reportyear+"");         


cell1.setCellValue("Indicator");
cell2.setCellValue("DIC Name");
cell3.setCellValue("Year Enrolled");
cell4.setCellValue("Total");
// styling the cells

cell1.setCellStyle(style);
cell2.setCellStyle(style);
cell3.setCellStyle(style);
cell4.setCellStyle(style);
            
            
            
            String[]  questions = new String[]{"B1","B3","C","D1","D2","E1","E2","F1","G1","H1","I","J1","J2","J3","K"};
           
            
//             //  String enrolls="SELECT count(currentStatus),currentStatus,count(Action),Action,Appointments FROM riskreductiondetails WHERE QID='"+questionRed+"' AND RiskReductionID"
//                    + " IN(SELECT RiskReductionID FROM riskreductionmain WHERE UniqueID "
//                    + "IN(SELECT UniqueID FROM enrollment WHERE DICName='"+DICName+"')) GROUP BY currentStatus ORDER BY count(currentStatus)";    
            
                if(parameter .equals("All services")){
                     for(int i=0;i<questions.length;i++){
                String query = "select RiskReductionID,currentstatus,QID,Action from riskreductiondetails where QID='"+questions[i]+"'";
//            String query = "SELECT RiskReductionID,currentstatus,QID,Action from riskreductiondetails where QID='"+questions[i]+"'AND RiskReductionID"
//                    + " IN(SELECT UniqueID from riskreductionmain where  UniqueID "
//                   +"IN(SELECT UniqueID FROM enrollment WHERE DICName='"+DICName+"' GROUP BY DICName))";
            conn.rs2 = conn.state2.executeQuery(query);
            while(conn.rs2.next()){
          
            id = conn.rs2.getString(1);
            ansas = conn.rs2.getString(2);
            QID = conn.rs2.getString(3);
            Action = conn.rs2.getString(4);
        questionQuery ="select * from questions where QuestionsID='"+QID+"' and DomainID=2";
             conn.rs=conn.state.executeQuery(questionQuery);
             while(conn.rs.next()){
                 qstns = conn.rs.getString("Question");
//                 System.out.println(qstns);
             }
           
            // System.out.println(id +"----"+QID+"-----"+ansas+"-----"+Action);
             
             if(Action.contains("Condoms were provided")){
                  CDs= Action.split("_");
//                System.out.println(CDs[1]);
//                if(CDs[i].contains("pcs")){
//                CDs[i]
//                }
                     if(CDs.length==2){
                CDCount+=Integer.parseInt(CDs[1]);
                     }
             } 
              if(Action.contains("WBL Provided")){
                  WBL= Action.split("_");
                  if(WBL.length==2){
//                System.out.println(WBL[1]);

                WBLCount+=Integer.parseInt(WBL[1]);}
               
              } 
              if(ansas.equalsIgnoreCase("Yes")){
                  if(QID.equals("D2")){
                  countD2++;
                  que1="Health Education provided";
                  }
                  if(QID.equals("E1")){
                  countE1++;
                  que2="HIV Tests";
                  }
                  if(QID.equals("E2")){
                  countE2++;
                  que3="HIV Tests with partner";
                  }
                  if(QID.equals("F1")){
                  countF1++;
                  que4="STI checkups";
                  }
                  if(QID.equals("G1")){
                  countG1++;
                  que5="Cervical Cancer Screening";
                  }
                  if(QID.equals("I")){
                  countI++;
                  que6="Gender Based Violence Provided Referrals";
                  }
                  if(QID.equals("H1")){
                  countH1++;
                   que7="Tuberculosis Screening";
                  }
                  if(QID.equals("J1")){
                  countJ1++;
                   que8="Family Planning Services(Currently on method)";
                  }
                  if(QID.equals("J2")){
                  countJ2++;
                  que9="Family Planning Method Provided";
                  }
                  if(QID.equals("K")){
                  countK++;
                   que10="Linked to an IGA Group";
                  }
                  
                  
                 
              // System.out.println("---------"+id +"----"+QID+"-----"+ansas+"-----"+Action);
               
              count++;
              }
              
             if(QID.equals("J3") && ansas!=null && !ansas.equals(" ") && !ansas.equals("null") && Action!=null && !Action.equals(" ") && !Action.equals("null")){
//             System.out.println("====="+ansas +"======"+ Action);
             for(int k=0;k<FPMethods.length;k++){
       
             if(ansas.contains(FPMethods[k])){
                FPcount++;
             System.out.println(ansas);
             if(ansas.contains("depo")|| ansas.contains("injection")){
                 FPcount1++;  
             }
             if(ansas.equalsIgnoreCase("condoms")){
                 FPcount2++;  
             }
             if(ansas.contains("pills")){
                 FPcount3++;  
             }
             if(ansas.contains("implanon")){
                 FPcount4++;  
             }
             if(ansas.contains("jadelle")){
                 FPcount5++;  
             }
             }
             
             
             }
             }
             
             
             
             
             
             
            }
            
             }
         
            //String auditscore="select RiskReductionID,currentstatus,QID,Action from riskreductiondetails where QID='C' and ";
         System.out.println("count"+count);
         System.out.println(que1+"count"+countD2);
         System.out.println(que2+"count"+countE1);
         System.out.println(que3+"count"+countE2);
         System.out.println(que4+"count"+countF1);
         System.out.println(que5+"count"+countG1);
         System.out.println(que6+"count"+countH1);
         System.out.println(que7+"count"+countI);
         System.out.println(que8+"count"+countJ1);
         System.out.println(que9+"count"+countJ2);
         System.out.println(que10+"count"+countK);
         System.out.println("TOTAL COUNT"+(countD2+countE1+countE2+countF1+countG1+countH1+countI+countJ1+countJ2+countK));
         
              int counts =0;
counts= rowcount+4;
HSSFRow rwB1=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rwB1.setHeightInPoints(20);

   cell9=rwB1.createCell(1);
   cell10=rwB1.createCell(2);
   cell11=rwB1.createCell(3);
   cell12=rwB1.createCell(4);
   
 cell9.setCellValue("No of Condoms Provided");
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(CDCount);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style);
 counts++;
HSSFRow rwB3=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rwB3.setHeightInPoints(20);

   cell9=rwB3.createCell(1);
   cell10=rwB3.createCell(2);
   cell11=rwB3.createCell(3);
   cell12=rwB3.createCell(4);
   
 cell9.setCellValue("No Water Based Lubricants Provided");
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countD2);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style);
 
  counts++; 
HSSFRow rwi=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rwi.setHeightInPoints(20);

   cell9=rwi.createCell(1);
   cell10=rwi.createCell(2);
   cell11=rwi.createCell(3);
   cell12=rwi.createCell(4);
   
 cell9.setCellValue(que1);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countD2);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style);
           
    counts++;    
 HSSFRow rw2=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw2.setHeightInPoints(20);

   cell9=rw2.createCell(1);
   cell10=rw2.createCell(2);
   cell11=rw2.createCell(3);
   cell12=rw2.createCell(4);
   
 cell9.setCellValue(que2);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countE1);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style);
 
 
  counts++;    
 HSSFRow rw3=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw3.createCell(1);
   cell10=rw3.createCell(2);
   cell11=rw3.createCell(3);
   cell12=rw3.createCell(4);
   
 cell9.setCellValue(que3);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countE2);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style);
 
   counts++;    
 HSSFRow rw4=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw4.createCell(1);
   cell10=rw4.createCell(2);
   cell11=rw4.createCell(3);
   cell12=rw4.createCell(4);
   
 cell9.setCellValue(que4);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countF1);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style);  
 
   counts++;    
 HSSFRow rw5=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw5.createCell(1);
   cell10=rw5.createCell(2);
   cell11=rw5.createCell(3);
   cell12=rw5.createCell(4);
   
 cell9.setCellValue(que5);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countG1);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style); 
   counts++;    
 HSSFRow rw6=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw6.createCell(1);
   cell10=rw6.createCell(2);
   cell11=rw6.createCell(3);
   cell12=rw6.createCell(4);
   
 cell9.setCellValue(que6);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countH1);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style); 
   counts++;    
 HSSFRow rw7=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw7.createCell(1);
   cell10=rw7.createCell(2);
   cell11=rw7.createCell(3);
   cell12=rw7.createCell(4);
   
 cell9.setCellValue(que7);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countI);
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style); 
 
 
  counts++;    
 HSSFRow rw8=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw8.createCell(1);
   cell10=rw8.createCell(2);
   cell11=rw8.createCell(3);
   cell12=rw8.createCell(4);
   
 cell9.setCellValue(que8);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countJ1);
 
  cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style); 
  counts++;    
 HSSFRow rw9=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw9.createCell(1);
   cell10=rw9.createCell(2);
   cell11=rw9.createCell(3);
   cell12=rw9.createCell(4);
   
 cell9.setCellValue(que9);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countJ2);
 
  cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style); 
  counts++;  
  
 HSSFRow rw10=shet1.createRow(counts);       
//   rwi.createCell(1).setCellValue(i-3);
 rw3.setHeightInPoints(20);

   cell9=rw10.createCell(1);
   cell10=rw10.createCell(2);
   cell11=rw10.createCell(3);
   cell12=rw10.createCell(4);
   
 cell9.setCellValue(que10);
 cell10.setCellValue("");
 cell11.setCellValue("");
 cell12.setCellValue(countK);
  counts++;    
 
 
 cell9.setCellStyle(cell_style);
 cell10.setCellStyle(cell_style);
 cell11.setCellStyle(cell_style);
 cell12.setCellStyle(cell_style); 
         System.out.println("Total CD "+CDCount); 
         System.out.println("Total WBL "+WBLCount); 
         System.out.println("FP COUNT "+FPcount); 
         System.out.println("depo count "+FPcount1); 
         System.out.println("condoms count "+FPcount2); 
         System.out.println("pills count "+FPcount3); 
         System.out.println("implanon count "+FPcount4); 
         System.out.println("jadelle count "+FPcount5); 
       
           CDCount=0;
           
            WBLCount=0;}
            
            
            else if (parameter.equals("Broken Down")){}
         // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIC Enrollment.xls");
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
            Logger.getLogger(RiskReductionReport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RiskReductionReport.class.getName()).log(Level.SEVERE, null, ex);
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
