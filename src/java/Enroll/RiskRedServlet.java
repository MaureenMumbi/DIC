/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enroll;

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
public class RiskRedServlet extends HttpServlet {

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
    
    String[] status ;
        String[] action;
        String[] que ;
        String[] dates;
        String[] Qdates;
        String[] datesAction;
        String Ans1,Ans2,Ans3,Ans4,Ans5,Ans6,Ans7,Ans8,Ans9,Ans10,Ans11,Ans12,Ans13,Ans14,Ans15,Ans16,Ans17,Ans18,Ans19,Ans20,
                Ans21,Ans22,Ans23,Ans24,Ans25,Ans26,Ans27,Ans28,Ans29,Ans30,Ans31,Ans32,Ans33,Ans34,Ans35,Ans36,Ans37="";
      String dates0,dates1,dates2,dates3,dates4,dates5,dates6,dates7,dates8="";
      HttpSession session;
   
        String insert_quarter;
int insert_year;  
              
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           dbConnect conn = new dbConnect();
session = request.getSession(true);
 Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);



//actions

if(request.getParameter("CdProvided")!=null && !request.getParameter("CdProvided").equals("")
        && request.getParameter("NoCD")!=null && !request.getParameter("NoCD").equals("")){
 Ans1 = request.getParameter("CdProvided")+"_"+request.getParameter("NoCD");//action
}else{
Ans1=" ";
}

if(!request.getParameter("RegCdAction").equals("") && request.getParameter("RegCdAction")!=null){
 Ans2 = request.getParameter("RegCdAction");//action
}
else{
    Ans2=" ";
}

if(!request.getParameter("WBLubProvided").equals("")  && request.getParameter("WBLubProvided")!=null ){
 Ans3 = request.getParameter("WBLubProvided")+"_"+request.getParameter("NoWBL");//action
}
else{
Ans3=" ";
}

if(!request.getParameter("AlDrugUseAction").equals("") && request.getParameter("AlDrugUseAction")!=null ){
 Ans4 = request.getParameter("AlDrugUseAction");//action
}
else{
Ans4=" ";
}

if(!request.getParameter("HSFTKnowTodayAction").equals("") && request.getParameter("HSFTKnowTodayAction")!=null){
 Ans5 = request.getParameter("HSFTKnowTodayAction");}
else{
Ans5=" ";
}

if(request.getParameter("HealthEducationAction")!=null && !request.getParameter("HealthEducationAction").equals("")){
 Ans6 = request.getParameter("HealthEducationAction");}
    else{
Ans6=" ";
}

if(request.getParameter("HIVTodayTestAction")!=null && !request.getParameter("HIVTodayTestAction").equals("")){
 Ans7= request.getParameter("HIVTodayTestAction");
}
else{
    Ans7=" ";
}

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

if(request.getParameter("HIVTestPartAction")!=null && !request.getParameter("HIVTestPartAction").equals("")){
 Ans8= request.getParameter("HIVTestPartAction");}
else{
Ans8=" ";
}
String Ans8_1="";
if(request.getParameter("HIVTestPartStatus")!=null && !request.getParameter("HIVTestPartStatus").equals("")){
 Ans8_1= request.getParameter("HIVTestPartStatus");}
else{
Ans8_1=" ";
}
String Ans8_2="";
if(request.getParameter("HIVAction_PARTNER")!=null && !request.getParameter("HIVAction_PARTNER").equals("")){
 Ans8_2= request.getParameter("HIVAction_PARTNER");}
else{
Ans8_2=" ";
}

if(request.getParameter("STICheckAction")!=null && !request.getParameter("STICheckAction").equals("")){
 Ans9= request.getParameter("STICheckAction");
}
else{
Ans9=" ";
}

if(request.getParameter("CCScreeningAction")!=null && !request.getParameter("CCScreeningAction").equals("")){
 Ans10= request.getParameter("CCScreeningAction");}
else{
Ans10=" ";
}

if(request.getParameter("TBCheckAction")!=null && !request.getParameter("TBCheckAction").equals("")){
 Ans11 = request.getParameter("TBCheckAction");}
else{
Ans11=" ";
}

if(request.getParameter("GBVCheckAction")!=null && !request.getParameter("GBVCheckAction").equals("")){
 Ans12 = request.getParameter("GBVCheckAction");}
else{
Ans12=" ";
}
if(request.getParameter("FPCurrMAction")!=null && !request.getParameter("FPCurrMAction").equals("")){
 Ans13= request.getParameter("FPCurrMAction");}
else{
Ans13=" ";
}

if(!request.getParameter("FPMethodAction").equals("") && request.getParameter("FPMethodAction")!=null){
Ans14 = request.getParameter("FPMethodAction");
}
else{
    Ans14=" ";
}

if(request.getParameter("FPMethodTypeAction")!=null){
 Ans15 = request.getParameter("FPMethodTypeAction");}
else{
    Ans15=" ";
}

if(request.getParameter("NoMethodAction")!=null){
 Ans16 = request.getParameter("NoMethodAction");}
else{
Ans16=" ";}

if(!request.getParameter("AltIncomeSourceAction").equals("") && request.getParameter("AltIncomeSourceAction")!=null){
 Ans17= request.getParameter("AltIncomeSourceAction");}
else{
Ans17=" ";}

System.out.println("Ans1"+Ans1);
System.out.println("Ans3"+Ans3);

//for status
if(request.getParameter("CasualCdUse")!=null && !request.getParameter("CasualCdUse").equals("")){
 Ans20 = request.getParameter("CasualCdUse");}
else{
Ans20=" ";
}
if(request.getParameter("RegCdUse")!=null && !request.getParameter("RegCdUse").equals("")){
 Ans21 = request.getParameter("RegCdUse");}
else{
Ans21=" ";
}
if( request.getParameter("WBLubricant")!=null &&  !request.getParameter("WBLubricant").equals("")){
 Ans22 = request.getParameter("WBLubricant");}
    else{
Ans22=" ";
}
if( request.getParameter("AlDrugUseScore")!=null &&  !request.getParameter("AlDrugUseScore").equals("")){
Ans23 = request.getParameter("AlDrugUseScore");}
else{
Ans23=" ";}
if( request.getParameter("HSFTKnowToday")!=null &&  !request.getParameter("HSFTKnowToday").equals("")){
 Ans24 = request.getParameter("HSFTKnowToday");}
else{
Ans24=" ";
}
if( request.getParameter("HealthEducation")!=null &&  !request.getParameter("HealthEducation").equals("")){
 Ans25 = request.getParameter("HealthEducation");}
else{
Ans25=" ";
}
if( request.getParameter("HIVTodayTest")!=null &&  !request.getParameter("HIVTodayTest").equals("")){
 Ans26 = request.getParameter("HIVTodayTest");}
else{
Ans26=" ";}
if(request.getParameter("HIVTestPart")!=null && !request.getParameter("HIVTestPart").equals("")){
Ans27= request.getParameter("HIVTestPart");}
else{
Ans27=" ";
}
if(request.getParameter("STICheck")!=null && !request.getParameter("STICheck").equals("")){
 Ans28= request.getParameter("STICheck");}
else{
Ans28=" ";
}
if(request.getParameter("CCScreening")!=null && !request.getParameter("CCScreening").equals("")){
 Ans29= request.getParameter("CCScreening");}
else{
Ans29=" ";
}
if(request.getParameter("TBCheck")!=null && !request.getParameter("TBCheck").equals("")){
 Ans30 = request.getParameter("TBCheck");}
else{
Ans30=" ";}
if(request.getParameter("GBVCheck")!=null && !request.getParameter("GBVCheck").equals("")){
 Ans31 = request.getParameter("GBVCheck");}
    else{
Ans31=" ";
}
if(request.getParameter("FPCurrentMethod")!=null && !request.getParameter("FPCurrentMethod").equals("")){
 Ans32= request.getParameter("FPCurrentMethod");}
else{
Ans32=" ";
}
if(request.getParameter("FPMethod")!=null && !request.getParameter("FPMethod").equals("")){
    Ans33= request.getParameter("FPMethod");}
else{
Ans33=" ";}
if(request.getParameter("FPMethodType")!=null && !request.getParameter("FPMethodType").equals("")){
 Ans34 = request.getParameter("FPMethodType");}
else{
Ans34=" ";}
if(request.getParameter("NoMethod")!=null && !request.getParameter("NoMethod").equals("")){
Ans35 = request.getParameter("NoMethod");}
else{
Ans35=" ";}
if(request.getParameter("AltIncomeSource")!=null && !request.getParameter("AltIncomeSource").equals("")){
 Ans36= request.getParameter("AltIncomeSource");}
else{
Ans36=" ";
}
if(request.getParameter("nxtapp")!=null && !request.getParameter("nxtapp").equals("")){
 Ans37= request.getParameter("nxtapp");}
else{
Ans37=" ";
}

//PUT IN DIFFERENT TABLE
String DOA = request.getParameter("DOA");
String Ans = request.getParameter("Cadre");

String QID = request.getParameter("QIDA1");
String QueID1 = request.getParameter("QIDA2");

//Splitting Date
String Report_Date[]= DOA.split("/");
String monthly = Report_Date[1];
//String insert_quarter;
//int insert_year;
int yearly = Integer.parseInt(Report_Date[2]);

//Identifying the quarter
if (monthly.equals("10") || monthly.equals("11") || monthly.equals("12")){
             insert_quarter = "Q1";
         }
         if (monthly.equals("01") || monthly.equals("02") || monthly.equals("03")){
             insert_quarter = "Q2";
         }
         if (monthly.equals("04") || monthly.equals("05") || monthly.equals("06")){
             insert_quarter = "Q3";
         }
         if (monthly.equals("07") || monthly.equals("08") || monthly.equals("09")){
             insert_quarter = "Q4";
         }
//Identifying the year
         if (monthly.equals("10") || monthly.equals("11") || monthly.equals("12")){
             insert_year = (yearly + 1);
         }
         if (monthly.equals("01") || monthly.equals("02") || monthly.equals("03")){
             insert_year = yearly;
         }
         if (monthly.equals("04") || monthly.equals("05") || monthly.equals("06")){
             insert_year = yearly;
         }
         if (monthly.equals("07") || monthly.equals("08") || monthly.equals("09")){
             insert_year = yearly;
         }


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
if(request.getParameter("NextAppt")!=null && !request.getParameter("NextAppt").equals("")){
 dates1= request.getParameter("NextAppt");}
else {
dates1=" ";
}
if(request.getParameter("CCAppointment")!=null && !request.getParameter("CCAppointment").equals("")){
 dates2= request.getParameter("CCAppointment");}
else{
dates2=" ";
}
if( request.getParameter("TBCheckAppt")!=null &&  !request.getParameter("TBCheckAppt").equals("")){
dates3 = request.getParameter("TBCheckAppt");}
else{
    dates3=" ";
}
if( request.getParameter("STINextCheck")!=null &&  !request.getParameter("STINextCheck").equals("")){
 dates4= request.getParameter("STINextCheck");
}
else{
dates4=" ";}


String QID_1 = request.getParameter("QIDD3");
String QID_2 = request.getParameter("QIDF2");
String QID_3 = request.getParameter("QIDG2");
String QID_4 = request.getParameter("QIDH2");



//Actions
if(request.getParameter("NextApptAction")!=null && !request.getParameter("NextApptAction").equals("")){
 dates5= request.getParameter("NextApptAction");
}
else{
dates5=" ";
}
if(request.getParameter("CCAppointmentAction")!=null && !request.getParameter("CCAppointmentAction").equals("")){
 dates6= request.getParameter("CCAppointmentAction");
}
else{
dates6=" ";
}
if(request.getParameter("TBCheckApptAction")!=null && !request.getParameter("TBCheckApptAction").equals("")){
 dates7 = request.getParameter("TBCheckApptAction");}
else{
dates7=" ";
}
if(request.getParameter("STINextCheckAction")!=null && !request.getParameter("STINextCheckAction").equals("")){
 dates8= request.getParameter("STINextCheckAction");}
else{
dates8=" ";
}


String answers ="";
String questions ="";
String AnsStatus="";
String AnsAction="",an;
 String queAction="";
 String queStatus="";
 
   String cadre_name="";
String cadre_selector="select * from cadrecode where CadreCodeID='"+Ans+"'";
conn.rs=conn.state.executeQuery(cadre_selector);
while(conn.rs.next()){
 cadre_name=conn.rs.getString("CadreCode"); 
 
 
}
System.out.println("cadre name"+cadre_name);
 session.setAttribute("cadre", cadre_name);
 session.setAttribute("cadre_id", Ans);            
//____________________GET COMPUTER NAME____________________________________
String computername=InetAddress.getLocalHost().getHostName();
System.out.println("Computer name "+computername);
String Ansapp=" ";

 String UniqueID= (String) session.getAttribute("UniqueID");
 an="";
 String name_selector="select * from enrollment where UniqueID=?";
  conn.ps = conn.connect.prepareStatement(name_selector);
            conn.ps.setString(1,UniqueID);
            conn.rs= conn.ps.executeQuery(); 
// conn.rs=conn.state.executeQuery(name_selector);
 while(conn.rs.next()){
 String fname=conn.rs.getString("FirstName");
         String mname=conn.rs.getString("SecondName");
                 String lname=conn.rs.getString("LastName");
        String full_name=fname+" "+mname+" "+lname;         
                 session.setAttribute("name", full_name);}
 String Ans7new="";
 Ans7new =Ans7+"_"+Ans7_1;
 
 String Ans8New="";
 Ans8New=Ans8+"_"+Ans8_1;
 //action array
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
 
 AnsDates += dates1+","+dates2+","+dates3 +","+ dates4;
 ActionDates+=dates5 +","+ dates6 +","+ dates7 +","+dates8;
 
 System.out.println("queStatus FOR STATUS:" +queStatus +"ANS _"+AnsStatus);
 System.out.println("queStatus FOR ACTIN:"+queStatus +"ANS _"+an);
 System.out.println("AnsStatus:" +AnsStatus);
 
 queDates += QID_1+","+QID_2+","+QID_3 +","+ QID_4;

 
   
         status = AnsStatus.split(",");
       action = an.split(",");
         que = queStatus.split(",");
         dates = AnsDates.split(",");
         Qdates = queDates.split(",");
        datesAction = ActionDates.split(",");
      
 
        
        System.out.println("action length:"+action.length);
         System.out.println("status length:"+status.length);
         System.out.println("que length:"+que.length);
         System.out.println("dates length:"+dates.length);
         System.out.println("Qdates length:"+Qdates.length);
         System.out.println("datesAction length:"+datesAction.length);
         
 
 String Aphia="Aphia";
    String AssessmentID = Aphia+'/'+ DOA +'/'+UniqueID;
//    String[] ans = answers.split(",");
//    String[] que = questions.split(",");
//    for(int i=0; i<ans.length;i++){System.out.println("ans"+ans[i]);}
//    for(int j=0;j<que.length;j++){ System.out.println("que"+que[j]);}
    String query="";
   
     String ip=InetAddress.getLocalHost().getHostAddress(); 
     String inserter="";
    if(AssessmentID!=null && !AssessmentID.equals(""))
    {
      
        query="INSERT INTO riskreductionmain(RiskReductionID,DOA,CadreProvider,UniqueID,qtr,year)"
            + "VALUES(?,?,?,?,?,?)";
            conn.ps = conn.connect.prepareStatement(query);
            conn.ps.setString(1,AssessmentID);
            conn.ps.setString(2,DOA);
            conn.ps.setString(3,Ans);
            conn.ps.setString(4,UniqueID);
                conn.ps.setString(5,insert_quarter);
            //Changing the year to be entered into string
            String insert_year1=Integer.toString(insert_year);
            conn.ps.setString(6,insert_year1);
            conn.ps.executeUpdate(); 
 
inserter="insert into taskauditor set host_comp=?, action=?,time=?,username=?";                     
conn.ps1 = conn.connect.prepareStatement(inserter);
conn.ps1.setString(1,computername+""+ip);
conn.ps1.setString(2,"Perfomed a Risk Reduction on a Sex Worker whose UniqueID="+UniqueID+"" );
conn.ps1.setString(3,formattedDate);
conn.ps1.setString(4,(session.getAttribute("Username")).toString());

conn.ps1.executeUpdate();          
                       
    
    }
       
   
 for(int a=0;a<que.length;a++){
                    String querys1="";
                      if(AssessmentID != null && !AssessmentID.equals("")){
querys1= "INSERT INTO riskreductiondetails(RiskReductionID,QID,currentStatus,Action,Appointments) "
                                + "Values(?,?,?,UPPER(?),?)";
                        conn.ps2 = conn.connect.prepareStatement(querys1);
                        conn.ps2.setString(1,AssessmentID);
                        conn.ps2.setString(2,que[a] );
                        conn.ps2.setString(3,status[a]);
                        conn.ps2.setString(4,action[a]);
                        conn.ps2.setString(5,"");
                       
                        conn.ps2.executeUpdate(); 
 
                      }
 
                     
                       
 }
    
for(int b=0;b<Qdates.length;b++){
                  String querys="";
                        if(AssessmentID != null && !AssessmentID.equals("")){
                         querys ="INSERT INTO riskreductiondetails(RiskReductionID,QID,currentStatus,Action,Appointments) "
                                + "Values(?,?,?,UPPER(?),?)";
                       
                        conn.ps3 = conn.connect.prepareStatement(querys);
                        conn.ps3.setString(1,AssessmentID);
                        conn.ps3.setString(2,Qdates[b]);
                        conn.ps3.setString(3,"");
                        conn.ps3.setString(4,datesAction[b]);
                        conn.ps3.setString(5,dates[b]);

                        conn.ps3.executeUpdate(); 
  
 
 }
//                          conn.state.executeUpdate(querys);
//                        System.out.println("QUERY 2   "+querys);
 
 }
    
    
                        response.sendRedirect("admin/medical_form.jsp");
    
    
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
            Logger.getLogger(RiskRedServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RiskRedServlet.class.getName()).log(Level.SEVERE, null, ex);
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
