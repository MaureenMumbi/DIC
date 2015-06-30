/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import Enroll.RikAssessServlet;
import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class EditRiskReduction extends HttpServlet {
        String[] status ;
        String[] action;
        String[] que ;
        String[] dates;
        String[] Qdates;
        String[] datesAction;
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          

			 dbConnect conn = new dbConnect();
                         
String computername=InetAddress.getLocalHost().getHostName();
System.out.println("Computer name "+computername);
Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formattedDate = formatter.format(date);
			//out.println(request.getRequestURI());
String Ans37="";
			
// the .getParameter gets the neterd values from the text fields and stores them as a string 
                      //actions
String Ans1 = request.getParameter("CdProvided")+"_"+request.getParameter("NoCD");//action
String Ans2 = request.getParameter("RegCdAction");//action
String Ans3 = request.getParameter("WBLubProvided")+"_"+request.getParameter("NoWBL");//action
String Ans4 = request.getParameter("AlDrugUseAction");//action
String Ans5 = request.getParameter("HSFTKnowTodayAction");
String Ans6 = request.getParameter("HealthEducationAction");
String Ans7_0= request.getParameter("HIVTodayTest");


String Ans7_1="";
if(request.getParameter("HIVTodayTestStatus")!=null && !request.getParameter("HIVTodayTestStatus").equals("")){
 Ans7_1= request.getParameter("HIVTodayTestStatus");
}
else{
    Ans7_1=" ";
}
String Ans7_2="";
if(request.getParameter("HIVTodayAction")!=null && !request.getParameter("HIVTodayAction").equals("")){
 Ans7_2= request.getParameter("HIVTodayAction");
}
else{
    Ans7_2=" ";
}
String Ans7= request.getParameter("HIVTodayTestAction");


String Ans8_0= request.getParameter("HIVTestPart");
String Ans8= request.getParameter("HIVTestPartAction");

String Ans8_1="";
if(request.getParameter("HIVTestPartStatus")!=null && !request.getParameter("HIVTestPartStatus").equals("")){
 Ans8_1= request.getParameter("HIVTestPartStatus");}
else{
Ans8_1=" ";
}
String Ans8_2="";
//if(request.getParameter("HIVAction_PARTNER")!=null && !request.getParameter("HIVAction_PARTNER").equals("")){
// Ans8_2= request.getParameter("HIVAction_PARTNER");}
//else{
//Ans8_2=" ";
//}
String Ans9= request.getParameter("STICheckAction");
String Ans10= request.getParameter("CCScreeningAction");
String Ans11 = request.getParameter("TBCheckAction");
String Ans12 = request.getParameter("GBVCheckAction");
String Ans13= request.getParameter("FPCurrMAction");
String Ans14 = request.getParameter("FPMethodAction");
String Ans15 = request.getParameter("FPMethodTypeAction");
String Ans16 = request.getParameter("NoMethodAction");
String Ans17= request.getParameter("AltIncomeSourceAction");

System.out.println("Ans1"+Ans1);
System.out.println("Ans3"+Ans3);

//for status

String Ans20 = request.getParameter("CasualCdUse");
String Ans21 = request.getParameter("RegCdUse");
String Ans22 = request.getParameter("WBLubricant");
String Ans23 = request.getParameter("AlDrugUseScore");
String Ans24 = request.getParameter("HSFTKnowToday");
String Ans25 = request.getParameter("HealthEducation");
String Ans26 = request.getParameter("HIVTodayTest");
String Ans27= request.getParameter("HIVTestPart");
String Ans28= request.getParameter("STICheck");
String Ans29= request.getParameter("CCScreening");
String Ans30 = request.getParameter("TBCheck");
String Ans31 = request.getParameter("GBVCheck");
String Ans32= request.getParameter("FPCurrentMethod");
String Ans33= request.getParameter("FPMethod");
String Ans34 = request.getParameter("FPMethodType");
String Ans35 = request.getParameter("NoMethod");
String Ans36= request.getParameter("AltIncomeSource");




//PUT IN DIFFERENT TABLE
String DOA = request.getParameter("DOA");
String Ans = request.getParameter("Cadre");

String QID = request.getParameter("QIDA1");
String QueID1 = request.getParameter("QIDA2");



// for status

String QueID2 = request.getParameter("QIDB1");
String QueID3 = request.getParameter("QIDB2");
String QueID4 = request.getParameter("QIDB3");
String QueID5 = request.getParameter("QIDC");
String QueID6 = request.getParameter("QIDD1");
String QueID7 = request.getParameter("QIDD2");
String QueID8 = request.getParameter("QIDE1");
String QueID8_0 = "QIDE1_0_self";
String QueID8_1 = "QIDE1_1_self";
String QueID8_2 = "QIDE1_status";
String QueID8_3 = "QIDE1_partner";
String QueID9 = request.getParameter("QIDE2");
String QueID10 = request.getParameter("QIDF1");
String QueID11 = request.getParameter("QIDG1");
String QueID12= request.getParameter("QIDH1");
String QueID13 = request.getParameter("QIDI");
String QueID14 = request.getParameter("QIDJ1");
String QueID15 = request.getParameter("QIDJ2");
String QueID16 = request.getParameter("QIDJ3");
String QueID17 = request.getParameter("QIDJ4");
String QueID18 = request.getParameter("QIDK");
String QueID19 = request.getParameter("QIDL");
//dates
String dates1= request.getParameter("NextAppt");
String dates2= request.getParameter("CCAppointment");
String dates3 = request.getParameter("TBCheckAppt");
String dates4= request.getParameter("STINextCheck");



String QID_1 = request.getParameter("QIDD3");
String QID_2 = request.getParameter("QIDF2");
String QID_3 = request.getParameter("QIDG2");
String QID_4 = request.getParameter("QIDH2");



//Actions

String dates5= request.getParameter("NextApptAction");
String dates6= request.getParameter("CCAppointmentAction");
String dates7 = request.getParameter("TBCheckApptAction");
String dates8= request.getParameter("STINextCheckAction");

if(request.getParameter("nxtapp")!=null && !request.getParameter("nxtapp").equals("")){
 Ans37= request.getParameter("nxtapp");}
else{
Ans37=" ";
}






//Date date= new Date(); 
//SimpleDateFormat formatter= new SimpleDateFormat("YYYY-MM-dd");
//String formattedDate = formatter.format(date);

String answers ="";
String questions ="";
String AnsStatus="";
String AnsAction="",an;
 String queAction="";
 String queStatus="";

HttpSession session;
session = request.getSession(true);
 String UniqueID= (String) session.getAttribute("UniqueID");
 an="";
 
// //action array
//an += Ans1 +","+Ans2 +","+ Ans3 +","+ Ans4 +","+ Ans5 +","+Ans6 +","+ Ans7 +","+Ans7_2+","+ Ans8 +","+Ans9+","+Ans10+","+ Ans11 +","+ Ans12+","+Ans13+","+Ans14+","+
//         Ans15+","+Ans16+","+Ans17;
//
//System.out.println("Actions"+an);
//
// AnsStatus += Ans20+","+Ans21+","+Ans22+","+Ans23+","+Ans24+","+Ans25+","+Ans26+","+Ans7_1+","+Ans27+","+Ans8_1+","+Ans28+","+Ans29+","+Ans30+","+Ans31+","+Ans32+","+Ans33+","+Ans34+","+Ans35+","+Ans36;
// System.out.println(AnsStatus) ;  
//// queAction+=QID2 +","+ QID3+","+ QID4 +","+ QID5 +","+QID6 +","+ QID7 +","+ QID8 +","+QID9+","+QID10+","+ QID11 +","+ QID12+","+QID13+","+QID14+","+
////         QID15+","+QID16+","+QID17+","+QID18+","+QID19+","+QID20+","+QID21+","+QID22+","+QID23+","+QID24;
// 
// queStatus=QueID2 +","+ QueID3+","+ QueID4 +","+ QueID5 +","+QueID6 +","+ QueID7+","+ QueID8 +","+QueID7_0 +","+ QueID7_1  +","+QueID9+","+  QueID8_2 +","+QueID10+","+ QueID11 +","+ QueID12+","+QueID13+","+QueID14+","+
//         QueID15+","+QueID16+","+QueID17+","+QueID18;
 
 String Ansapp=" ";
 
 
 an += Ans1 +","+Ans2 +","+ Ans3 +","+ Ans4 +","+ Ans5 +","+Ans6 +","+ Ans7+","+Ans7_1+","+ Ans7_2+","+ Ans8+","+Ans8_1 +","+Ans8_2+","+Ans9+","+Ans10+","+ Ans11 +","+ Ans12+","+Ans13+","+Ans14+","+
         Ans15+","+Ans16+","+Ans17+","+Ansapp;

System.out.println("Actions"+an);
String Ans27_1="";
String Ans27_2="";
String Ans28_1="";
String Ans28_2="";

 AnsStatus += Ans20+","+Ans21+","+Ans22+","+Ans23+","+Ans24+","+Ans25+","+Ans26+","+Ans27_1+","+Ans27_2+","+Ans27+","+Ans28_1+","+Ans28_2+","+Ans28+","+Ans29+","+Ans30+","+Ans31+","+Ans32+","+Ans33+","+Ans34+","+Ans35+","+Ans36+","+Ans37;
    

 System.out.println(AnsStatus);
 queStatus=QueID2 +","+ QueID3+","+ QueID4 +","+ QueID5 +","+QueID6 +","+ QueID7 +","+ QueID8+","+ QueID8_0+","+ QueID8_1+","+QueID8_2+","+QueID8_3 +","+QueID9+","+QueID10+","+ QueID11 +","+ QueID12+","+QueID13+","+QueID14+","+
         QueID15+","+QueID16+","+QueID17+","+QueID18+","+QueID19;
 System.out.println(queStatus);
 String queDates="";
 String AnsDates="";
 String ActionDates="";
 String Actionque="";

 
 System.out.println(queStatus);

 AnsDates += dates1+","+dates2+","+dates3 +","+ dates4;
 ActionDates+=dates5 +","+ dates6 +","+ dates7 +","+dates8;
 
 System.out.println("queStatus:" +queStatus);
 System.out.println("ActionActions:" +an);
 System.out.println("AnsStatus:" +AnsStatus);
 
 queDates += QID_1+","+QID_2+","+QID_3 +","+ QID_4;

 
   
         status = AnsStatus.split(",");
        action = an.split(",");
         que = queStatus.split(",");
         dates = AnsDates.split(",");
         Qdates = queDates.split(",");
        datesAction = ActionDates.split(",");
      
 
        
//        System.out.println("action length:"+action.length);
//         System.out.println("status length:"+status.length);
//         System.out.println("que length:"+que.length);
//         System.out.println("dates length:"+dates.length);
//         System.out.println("Qdates length:"+Qdates.length);
//         System.out.println("datesAction length:"+datesAction.length);
         String AssessmentID = request.getParameter("RiskID");
         
    
         
//         System.out.println("AssessmentID"+AssessmentID);
 
 String Aphia="Aphia";
   // String AssessmentID = Aphia+'/'+ DOA +'/'+UniqueID;
//    String[] ans = answers.split(",");
//    String[] que = questions.split(",");
//    for(int i=0; i<ans.length;i++){System.out.println("ans"+ans[i]);}
//    for(int j=0;j<que.length;j++){ System.out.println("que"+que[j]);}
    String query="";
    
   String inserter="";
    if(AssessmentID!=null && !AssessmentID.equals("")){
     query="UPDATE riskreductionmain SET DOA='"+DOA+"',CadreProvider='"+Ans+"',syncstatus=0  where RiskReductionID=?";
//    inserter = "insert into taskauditor set host_comp='" + computername + "' ,time='" + formattedDate + "',username='" + session.getAttribute("Username") + "', action=Performed Risk Reduction Update on a Sex Worker from the Risk Reduction Form whose UniqueID is "+session.getAttribute("UniqueID");
    
     

     inserter = "INSERT INTO taskauditor (host_comp,time,username,action) VALUES(?,?,?,?)";
    
    
 conn.ps = conn.connect.prepareStatement(inserter);
conn.ps.setString(1,computername);
conn.ps.setString(2,formattedDate);
if(session.getAttribute("Username")!=null){
conn.ps.setString(3,(session.getAttribute("Username")).toString() );}
conn.ps.setString(4,"Performed Risk Reduction Update on a Sex Worker from the Risk Reduction Form whose UniqueID is "+session.getAttribute("UniqueID"));
conn.ps.executeUpdate();                      
    
    }
       
             if(AssessmentID!=null&&DOA !=null && Ans!=null &&UniqueID!=null){
                 conn.ps1 = conn.connect.prepareStatement(query);
conn.ps1.setString(1,AssessmentID);
conn.ps1.executeUpdate();    
                // conn.state.executeUpdate(query);
//                 conn.state.executeUpdate(inserter);  
               
             }
       
 try{    
 for(int a=0;a<action.length;a++){
                    
                      if(AssessmentID != null && que[a].length()!= 0 &&  status[a].length()!=0 && action[a].length()!=0 ){
                        String update="UPDATE riskreductiondetails SET currentStatus='"+status[a]+"',Action='"+action[a]+"',Appointments='' WHERE QID='"+que[a]+"' AND RiskReductionID=?";
                           conn.ps2 = conn.connect.prepareStatement(update);
                            conn.ps2.setString(1,AssessmentID);
                            conn.ps2.executeUpdate();      
                     System.out.println(update);
                System.out.println(que[a] +" ________ "+status[a] +"_____________"+ action[a]);    
                      }
                          
                    
                    

 
 }
    
 for(int b=0;b<datesAction.length;b++){
                   
                        if(AssessmentID != null && Qdates[b].length()!=0  && datesAction[b].length()!=0 && dates[b].length()!=0){
                        String update1= "UPDATE riskreductiondetails SET currentStatus='',Action='"+datesAction[b]+"',Appointments='"+dates[b]+"' WHERE QID='"+Qdates[b]+"' AND RiskReductionID=?";
                           
                        System.out.println(update1);
                        conn.ps2 = conn.connect.prepareStatement(update1);
                            conn.ps2.setString(1,AssessmentID);
                            conn.ps2.executeUpdate();   
                       
                        }
                    
                    
  
 }
          response.sendRedirect("admin/index_RiskReduction.jsp");       

      
    }catch(SQLException S){
        out.println(S.toString());
        
        
    }}
    
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
            Logger.getLogger(EditRiskAssessment.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditRiskAssessment.class.getName()).log(Level.SEVERE, null, ex);
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



                     