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
public class RikAssessServlet extends HttpServlet {

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
      String insert_quarter="";
   int insert_year;
    String Ans2,Ans3,Ans4,Ans5,Ans6,Ans7,Ans8,Ans9,Ans10,Ans11,Ans12,Ans13,Ans14,Ans15,Ans16,Ans17,Ans18,Ans19,Ans20,Ans21,Ans22,Ans23,Ans24,Ans25,Ans26,Ans27,Ans28,Ans29,Ans30,Ans31,Ans32,Ans33,Ans34,Ans35,Ans36,Ans37,Ans38,Ans39,Ans40, Ans41, Ans42,Ans43,Ans44,Ans45,Ans46,Ans47,Ans48,Ans49,Ans50,Ans51,Ans52,Ans53,Ans54,Ans55,Ans56,Ans57,Ans58,Ans59,Ans60,Ans61,Ans62,Ans63="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       //String unique = request.getParameter("unique").toString();
String Ans1 = request.getParameter("DOA").toString();
dbConnect conn = new dbConnect();
String County="";
String DICName="";
if(request.getParameter("district")!=null && !request.getParameter("district").equals("") ){
County= request.getParameter("district");       
        }
if(request.getParameter("DICName")!=null && !request.getParameter("DICName").equals("") ){
DICName= request.getParameter("DICName");       
        }

String Report_Date[]= Ans1.split("/");
String monthly = Report_Date[1];
int yearly = Integer.parseInt(Report_Date[2]);


//Identifying the quarter
if (monthly.equals("10") || monthly.equals("11") || monthly.equals("12")){
             insert_quarter = "1";
         }
         if (monthly.equals("01") || monthly.equals("02") || monthly.equals("03")){
             insert_quarter = "2";
         }
         if (monthly.equals("04") || monthly.equals("05") || monthly.equals("06")){
             insert_quarter = "3";
         }
         if (monthly.equals("07") || monthly.equals("08") || monthly.equals("09")){
             insert_quarter = "4";
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
//____________________GET COMPUTER NAME____________________________________
String computername=InetAddress.getLocalHost().getHostName();

Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);
if(request.getParameter("SexLast")!=null && !request.getParameter("SexLast").equals("")){
 Ans2 = request.getParameter("SexLast");}
else{
Ans2=" ";}
if(request.getParameter("CondomUse")!=null && !request.getParameter("CondomUse").equals("") ){
 Ans3 = request.getParameter("CondomUse");}
else{
Ans3=" ";}
if(request.getParameter("SexPartGender")!=null && !request.getParameter("SexPartGender").equals("") ){
 Ans4 = request.getParameter("SexPartGender");}
else{
Ans4="";}
if(!request.getParameter("ActiveSexWork").equals("") && request.getParameter("ActiveSexWork")!=null){
 Ans5 = request.getParameter("ActiveSexWork");}
else{
    Ans5=" ";}
if(request.getParameter("AvgNoPayingClients")!=null && !request.getParameter("AvgNoPayingClients").equals("")){
 Ans6= request.getParameter("AvgNoPayingClients");}
else{
Ans6=" ";}

//System.out.println("Ans6"+Ans6);
if(request.getParameter("RegPartner")!=null && !request.getParameter("RegPartner").equals("")){
 Ans7 = request.getParameter("RegPartner");}
else{
Ans7=" ";}
if(request.getParameter("NoRegPartner")!=null && !request.getParameter("NoRegPartner").equals("") ){
Ans8 = request.getParameter("NoRegPartner");}
else{
Ans8=" ";
}
if(request.getParameter("TimeRegPartners")!=null && !request.getParameter("TimeRegPartners").equals("")){
 Ans9 = request.getParameter("TimeRegPartners");}
else{
    Ans9=" ";
}
if(request.getParameter("PracticeVaginal")!=null && !request.getParameter("PracticeVaginal").equals("")){
 Ans10 = request.getParameter("PracticeVaginal");}
else{
Ans10=" ";
}
if(request.getParameter("PracticeOral")!=null && !request.getParameter("PracticeOral").equals("")){
 Ans11 = request.getParameter("PracticeOral");}
else{
Ans11=" ";}
if(request.getParameter("PracticeAnal")!=null && !request.getParameter("PracticeAnal").equals("")){
 Ans12 = request.getParameter("PracticeAnal");}
else{
Ans12="";}
if(request.getParameter("CondomVaginal")!=null && !request.getParameter("CondomVaginal").equals("")){
 Ans13= request.getParameter("CondomVaginal");}
else{
Ans13=" ";}
if(request.getParameter("CondomOral")!=null && !request.getParameter("CondomOral").equals("")){
 Ans14= request.getParameter("CondomOral");}
else{
Ans14=" ";
}
if(request.getParameter("CondomAnal")!=null && !request.getParameter("CondomAnal").equals("")){
Ans15= request.getParameter("CondomAnal");}
else{
Ans15=" ";}
if(request.getParameter("CondomProvider")!=null && !request.getParameter("CondomProvider").equals("")){
    Ans16= request.getParameter("CondomProvider");}
else{
Ans16=" ";
}
if(request.getParameter("HIVPartStatus")!=null && !request.getParameter("HIVPartStatus").equals("")){
 Ans17= request.getParameter("HIVPartStatus");}
else{
Ans17=" ";
}
if(request.getParameter("NoHIVPartStatus")!=null && !request.getParameter("NoHIVPartStatus").equals("")){
 Ans18= request.getParameter("NoHIVPartStatus");}
else{
Ans18=" ";}
if(request.getParameter("PartCondomUse")!=null && !request.getParameter("PartCondomUse").equals("")){
 Ans19= request.getParameter("PartCondomUse");
}
else{
Ans19=" ";
}
if(request.getParameter("DGenitals")!=null && !request.getParameter("DGenitals").equals("")){
 Ans20= request.getParameter("DGenitals");}
else{
Ans20=" ";}
if(request.getParameter("PUrine")!=null && !request.getParameter("PUrine").equals("")){
 Ans21= request.getParameter("PUrine");}
else{
Ans21=" ";
}
if(request.getParameter("PSex")!=null && !request.getParameter("PSex").equals("")){
 Ans22= request.getParameter("PSex");}
else{
Ans22=" ";
}
if(request.getParameter("SGenitals")!=null && !request.getParameter("SGenitals").equals("")){
 Ans23= request.getParameter("SGenitals");}
else{
Ans23=" ";}
if(request.getParameter("GSores")!=null && !request.getParameter("GSores").equals("")){
 Ans24= request.getParameter("GSores");}
else{
Ans24=" ";
}
if(request.getParameter("DiscolorUrine")!=null && !request.getParameter("DiscolorUrine").equals("")){
 Ans25= request.getParameter("DiscolorUrine");}
else{
Ans25=" ";}
if(request.getParameter("AbdominalPain")!=null && !request.getParameter("AbdominalPain").equals("")){
 Ans26 = request.getParameter("AbdominalPain");}
else{
Ans26=" ";}
if(request.getParameter("STISeekTreat")!=null && !request.getParameter("STISeekTreat").equals("")){
 Ans27= request.getParameter("STISeekTreat");}
else{
Ans27=" ";
}
if(request.getParameter("STIPlaceTreated")!=null && !request.getParameter("STIPlaceTreated").equals("")){
 Ans28= request.getParameter("STIPlaceTreated");}
else{
Ans28=" ";}
if(request.getParameter("LubricantUse")!=null && !request.getParameter("LubricantUse").equals("")){
 Ans29= request.getParameter("LubricantUse");}
else{
Ans29=" ";
}
if(request.getParameter("KYJelly")!=null && !request.getParameter("KYJelly").equals("")){
 Ans30= request.getParameter("KYJelly");}
else{
Ans30=" ";
}
if(request.getParameter("Saliva")!=null && !request.getParameter("Saliva").equals("")){
 Ans31= request.getParameter("Saliva");}
else{
Ans31=" ";
}
if(request.getParameter("OtherLubricants")!=null && !request.getParameter("OtherLubricants").equals("")){
Ans32= request.getParameter("OtherLubricants");}
else{
Ans32=" ";
}
if(request.getParameter("LubUseVaginal")!=null && !request.getParameter("LubUseVaginal").equals("")){
Ans33= request.getParameter("LubUseVaginal");}
else{
Ans33=" ";
}
if(request.getParameter("LubUseAnal")!=null && !request.getParameter("LubUseAnal").equals("")){
Ans34= request.getParameter("LubUseAnal");}
else{
Ans34=" ";
}
if(request.getParameter("pregnant")!=null && !request.getParameter("pregnant").equals("")){
Ans35= request.getParameter("pregnant");}
else{
Ans35=" ";
}
if(request.getParameter("HaveKids")!=null  && !request.getParameter("HaveKids").equals("")){
Ans36= request.getParameter("HaveKids");}
else{
Ans36=" ";
}
if( request.getParameter("UseFP")!=null &&  !request.getParameter("UseFP").equals("")){
 Ans37= request.getParameter("UseFP");}
else{
Ans37=" ";
}
if(request.getParameter("FPMethodUsed")!=null && !request.getParameter("FPMethodUsed").equals("")){
Ans38= request.getParameter("FPMethodUsed");}
else{
Ans38=" ";
}

if(request.getParameter("AlcoholUse")!=null && !request.getParameter("AlcoholUse").equals("")){
Ans39= request.getParameter("AlcoholUse");}
else{
Ans39=" ";
}
if(request.getParameter("AlcoholFrequency")!=null && !request.getParameter("AlcoholFrequency").equals("")){
Ans40= request.getParameter("AlcoholFrequency");}
else{
Ans40=" ";}
if(request.getParameter("DrugUse")!=null && !request.getParameter("DrugUse").equals("")){
Ans41= request.getParameter("DrugUse");}
else{
Ans41=" ";}
String drugtype[] = null;
Ans42="";
  if(request.getParameterValues("DrugType")!= null && !(request.getParameterValues("DrugType").equals(""))){
           drugtype = request.getParameterValues("DrugType");
           for(int y=0;y<drugtype.length; y++){
            Ans42+=drugtype[y]+"_";
           
           }}
//if(request.getParameterValues("DrugType")!=null && !request.getParameterValues("DrugType").equals("")){
//Ans42= request.getParameterValues("DrugType");}
//else{
//Ans42=" ";}
if(request.getParameter("DrugFrequency")!=null && !request.getParameter("DrugFrequency").equals("")){
Ans43= request.getParameter("DrugFrequency");}
else{
Ans43=" ";}
if(request.getParameter("VaginalDouche")!=null && !request.getParameter("VaginalDouche").equals("")){
Ans44= request.getParameter("VaginalDouche");}
else{
Ans44=" ";}
if(request.getParameter("AfterSexDouche")!=null && !request.getParameter("AfterSexDouche").equals("")){
 Ans45= request.getParameter("AfterSexDouche");}
else{
Ans45=" ";}
if(request.getParameter("BathDouche")!=null && !request.getParameter("BathDouche").equals("")){
 Ans46= request.getParameter("BathDouche");}
else{
Ans46=" ";
}
if(request.getParameter("CdBurstDouche")!=null && !request.getParameter("CdBurstDouche").equals("")){
Ans47= request.getParameter("CdBurstDouche");}
else{
Ans47=" ";
}
if(request.getParameter("OtherDouche")!=null && !request.getParameter("OtherDouche").equals("")){
 Ans48= request.getParameter("OtherDouche");}
else{
Ans48=" ";
}


if(request.getParameter("VerbalInsults")!=null && !request.getParameter("VerbalInsults").equals("")){
 Ans49= request.getParameter("VerbalInsults");}
else{
Ans49=" ";
}
if(request.getParameter("LastVerbalInsult")!=null && !request.getParameter("LastVerbalInsult").equals("")){
 Ans50= request.getParameter("LastVerbalInsult");}
else{
Ans50=" ";
}
if(request.getParameter("Hit")!=null && !request.getParameter("Hit").equals("")){
Ans51= request.getParameter("Hit");}
else{
Ans51=" ";}
if(request.getParameter("LastVerbalInsultHit")!=null && !request.getParameter("LastVerbalInsultHit").equals("")){
Ans52= request.getParameter("LastVerbalInsultHit");}
else{
Ans52=" ";}
if(request.getParameter("ForcedSex")!=null && !request.getParameter("ForcedSex").equals("")){
 Ans53= request.getParameter("ForcedSex");
}
else{
Ans53=" ";}
if(request.getParameter("LastVerbalInsultForced")!=null && !request.getParameter("LastVerbalInsultForced").equals("") ){
Ans54= request.getParameter("LastVerbalInsultForced");
}
else{
Ans54=" ";}
if(request.getParameter("VerbalAbuse")!=null && !request.getParameter("VerbalAbuse").equals("")){
 Ans55 = request.getParameter("VerbalAbuse");}
else{
Ans55=" ";
}
if(request.getParameter("VerbalAbuseTime")!=null && !request.getParameter("VerbalAbuseTime").equals("")){
 Ans56 = request.getParameter("VerbalAbuseTime");}
else{
Ans56=" ";
}
if(request.getParameter("PartnerProblem")!=null && !request.getParameter("PartnerProblem").equals("")){
Ans57 = request.getParameter("PartnerProblem");}
else{
Ans57=" ";
}
if(request.getParameter("PartnerProblemTime")!=null && !request.getParameter("PartnerProblemTime").equals("")){
Ans58 = request.getParameter("PartnerProblemTime");}
else{
Ans58=" ";
}
if(request.getParameter("SeekTreatment")!=null && !request.getParameter("SeekTreatment").equals("")){
 Ans59= request.getParameter("SeekTreatment");}
else{

    Ans59=" ";}
if(request.getParameter("PlaceTreated")!=null && !request.getParameter("PlaceTreated").equals("")){
Ans60= request.getParameter("PlaceTreated");}
else{
Ans60=" ";
}
if(request.getParameter("ReportPolice")!=null && !request.getParameter("ReportPolice").equals("")){
 Ans61= request.getParameter("ReportPolice");}
else{
Ans61=" ";}
if(request.getParameter("ReportWhere")!=null && !request.getParameter("ReportWhere").equals("")){
 Ans62 = request.getParameter("ReportWhere");}
else{
Ans62=" ";
}


String QID = request.getParameter("QID1");
String QID1 = request.getParameter("QIDA");
String QID2 = request.getParameter("QIDB");
String QID3 = request.getParameter("QIDC");
String QID4 = request.getParameter("QIDD");
String QID5 = request.getParameter("QIDE");
String QID6 = request.getParameter("QIDF");
String QID7 = request.getParameter("QIDG");
String QID8 = request.getParameter("QIDH");
String QID9 = request.getParameter("QIDIa");
String QID10 = request.getParameter("QIDIb");
String QID11 = request.getParameter("QIDIc");
String QID12 = request.getParameter("QIDJa");
String QID13 = request.getParameter("QIDJb");
String QID14 = request.getParameter("QIDJc");
String QID15 = request.getParameter("QIDK");
String QID16 = request.getParameter("QIDLa");
String QID17 = request.getParameter("QIDLb");
String QID18 = request.getParameter("QIDLc");
String QID19= request.getParameter("QIDMa");
String QID20 = request.getParameter("QIDMb");
String QID21 = request.getParameter("QIDMc");
String QID22 = request.getParameter("QIDMd");
String QID23 = request.getParameter("QIDMe");
String QID24 = request.getParameter("QIDMf");
String QID25 = request.getParameter("QIDMg");
String QID26 = request.getParameter("QIDNa");
String QID27 = request.getParameter("QIDNb");
String QID28 = request.getParameter("QIDOa");
String QID29 = request.getParameter("QIDOKyJelly");
String QID30 = request.getParameter("QIDOSaliva");
String QID31 = request.getParameter("QIDOOther");
String QID32 = request.getParameter("QIDOVaginal");
String QID33 = request.getParameter("QIDOAnal");
String QID34 = request.getParameter("QIDPa");
String QID35 = request.getParameter("QIDPb");
String QID36 = request.getParameter("QIDPc");
String QID37 = request.getParameter("QIDPd");
String QID38 = request.getParameter("QIDQa");
String QID39 = request.getParameter("QIDQb");
String QID40 = request.getParameter("QIDRa");
String QID41 = request.getParameter("QIDRb");
String QID42 = request.getParameter("QIDRc");
String QID43 = request.getParameter("QIDSa");
String QID44 = request.getParameter("QIDSbA");
String QID45 = request.getParameter("QIDSbB");
String QID46 = request.getParameter("QIDSbC");
String QID47 = request.getParameter("QIDSbD");
String QID48 = request.getParameter("QIDTa");
String QID49 = request.getParameter("QIDTa1");
String QID50 = request.getParameter("QIDTb");
String QID51 = request.getParameter("QIDTb1");
String QID52 = request.getParameter("QIDTc");
String QID53 = request.getParameter("QIDTc1");
String QID54 = request.getParameter("QIDTd");
String QID55 = request.getParameter("QIDTd1");
String QID56 = request.getParameter("QIDTe");
String QID57 = request.getParameter("QIDTe1");
String QID58 = request.getParameter("QIDUa");
String QID59 = request.getParameter("QIDUb");
String QID60 = request.getParameter("QIDVa");
String QID61 = request.getParameter("QIDVb");
//String QID56 = request.getParameter("QIDA");
//String QID57 = request.getParameter("QIDA");
//String QID46 = request.getParameter("QIDA");
String answers ="";
String questions ="";
HttpSession session;
session = request.getSession(true);
 String UniqueID= (String) session.getAttribute("UniqueID");
// System.out.println("UniqueID|||||||||||||||||||||||||||||||||"+ UniqueID);
 
 
 
 
 answers += Ans1 +","+Ans2 +","+ Ans3 +","+ Ans4 +","+ Ans5 +","+Ans6 +","+ Ans7 +","+ Ans8 +","+Ans9+","+Ans10+","+ Ans11 +","+ Ans12+","+Ans13+","+Ans14+","+
         Ans15+","+Ans16+","+Ans17+","+Ans18+","+Ans19+","+Ans20+","+Ans21+","+Ans22+","+Ans23+","+Ans24+","+Ans25+","+
         Ans26+","+Ans27+","+Ans28+","+Ans29+","+Ans30+","+Ans31+","+Ans32+","+Ans33+","+Ans34+","+Ans35+","+Ans36+","+Ans37+","+
         Ans38+","+Ans39+","+Ans40+","+Ans41+","+Ans42+","+Ans43+","+Ans44+","+Ans45+","+Ans46+","+Ans47+","+Ans48+","+Ans49+","+
         Ans50+","+Ans51+","+Ans52+","+Ans53+","+Ans54+","+Ans55+","+Ans56+","+Ans57+","+Ans58+","+Ans59+","+Ans60+","+Ans61+","+Ans62;
 
    
 questions += QID+","+QID1 +","+QID2 +","+ QID3 +","+ QID4 +","+ QID5 +","+QID6 +","+ QID7 +","+ QID8 +","+QID9+","+QID10+","+ QID11 +","+ QID12+","+QID13+","+QID14+","+
         QID15+","+QID16+","+QID17+","+QID18+","+QID19+","+QID20+","+QID21+","+QID22+","+QID23+","+QID24+","+QID25+","+
         QID26+","+QID27+","+QID28+","+QID29+","+QID30+","+QID31+","+QID32+","+QID33+","+QID34+","+QID35+","+QID36+","+QID37+","+
         QID38+","+QID39+","+QID40+","+QID41+","+QID42+","+QID43+","+QID44+","+QID45+","+QID46+","+QID47+","+QID48+","+QID49+","+
         QID50+","+QID51+","+QID52+","+QID53+","+QID54+","+QID55+","+QID56+","+QID57+","+QID58+","+QID59+","+QID60+","+QID61;
 
 String codedAns=""; 
 
 
 
 String Aphia="Aphia";
    String AssessmentID = Aphia+'/'+ Ans1 +'/'+UniqueID;
    String[] ans = answers.split(",");
    String[] que = questions.split(",");
//    for(int i=0; i<ans.length;i++){
////        System.out.println("que"+que[i]+"ans"+ans[i] );
//    }
//    for(int j=0;j<que.length;j++){ System.out.println("que"+que[j]);}
    String query="";
    String inserter="";
    if(AssessmentID!=null&& UniqueID!=null){
   query="INSERT INTO riskassessmentmain(AssessmentID,AssessmentDate,UniqueID,County1,DICName1,Quarter,Month,Pefar_year,syncstatus)VALUE(?,?,?,?,?,?,?,?,?)";
   conn.ps = conn.connect.prepareStatement(query);
            conn.ps.setString(1,AssessmentID);
            conn.ps.setString(2,Ans1);
            conn.ps.setString(3,UniqueID);
            conn.ps.setString(4,County);
            conn.ps.setString(5,DICName);
            conn.ps.setString(6,insert_quarter);
            conn.ps.setString(7,monthly);
            //Changing the year to be entered into string
            String insert_year1=Integer.toString(insert_year);
            conn.ps.setString(8,insert_year1);
            conn.ps.setString(9,"0");
            conn.ps.executeUpdate(); 
   
//   System.out.println(query);
   
     inserter = "insert into taskauditor set host_comp=?,action=?,time=?,username=?,syncstatus=?";
    
            conn.ps1 = conn.connect.prepareStatement(inserter);
            conn.ps1.setString(1,computername);
            conn.ps1.setString(2,"Performed Risk Assessment on a Sex Worker  whose UniqueID is "+UniqueID+" from the Risk Assessment form");
            conn.ps1.setString(3,formattedDate);
            conn.ps1.setString(4, session.getAttribute("Username").toString());
            conn.ps1.setString(5,"0");
            conn.ps1.executeUpdate(); 
    
    
    
    
    }
   
   
 for(int a=0;a<que.length;a++){
                    try {
                        

                        
                        if(AssessmentID!=null & !AssessmentID.equals("")){
                        String query2 ="INSERT INTO riskassessmentdetails(AssessmentID,QuestionID,DirectAnswers,CodedAnswers,syncstatus) "
                                + "Values(?,?,UPPER(?),?,?)";
                   conn.ps2 = conn.connect.prepareStatement(query2);
                    conn.ps2.setString(1,AssessmentID);
                    conn.ps2.setString(2,que[a]);
                    conn.ps2.setString(3,ans[a]);
                    conn.ps2.setString(4,"0");
                    conn.ps2.setString(5,"0");
                   
                    conn.ps2.executeUpdate(); 
                    
//                    System.out.println(query2);
                      }
                  
         
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(RikAssessServlet.class.getName()).log(Level.SEVERE, null, ex);
                       System.out.println(ex.toString());
                    }
                                    

                   

 
 }
      String regdic="";
                   String getdic="select DICName from enrollment where UniqueID='"+UniqueID+"'" ;
                   conn.rs3 = conn.state.executeQuery(getdic);
                   if(conn.rs3.next()){
                   regdic=conn.rs3.getString(1);
                   }
                    String servicetracker="insert into servicetracker set UniqueID='"+UniqueID+"',RegisteredDIC='"+regdic+"',visitedDIC='"+DICName+"',RiskAssessment='Done',RiskReduction='',Date='"+Ans1+"'";
                    System.out.println(servicetracker);
                    conn.state.executeUpdate(servicetracker);
        session.setAttribute("DOA",Ans1);
        session.setAttribute("regdic",regdic);
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Counter1");
	                  dispatcher.forward(request, response);
                        
    
    
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
            Logger.getLogger(RikAssessServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RikAssessServlet.class.getName()).log(Level.SEVERE, null, ex);
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
