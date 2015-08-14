/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class EditRiskAssessment extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          
//____________________GET COMPUTER NAME____________________________________
String computername=InetAddress.getLocalHost().getHostName();
//System.out.println("Computer name "+computername);
Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formattedDate = formatter.format(date);
			 dbConnect conn = new dbConnect();
      

String Ans1 = request.getParameter("DOA").toString();

//String District = request.getParameter("District1").toString();
//String DICName = request.getParameter("DICName").toString();
//String ClientInit = request.getParameter("ClientInit").toString();
//String UniqueID = request.getParameter("UniqueID").toString();
//String Sex = request.getParameter("Sex").toString();
String Ans2 = request.getParameter("SexLast");
String Ans3 = request.getParameter("CondomUse");
String Ans4 = request.getParameter("SexPartGender");
String Ans5 = request.getParameter("ActiveSexWork");
String Ans6= request.getParameter("NoPayingClients");
String Ans7 = request.getParameter("RegPartner");
String Ans8 = request.getParameter("NoRegPartner");
String Ans9 = request.getParameter("TimeRegPartners");
String Ans10 = request.getParameter("PracticeVaginal");
String Ans11 = request.getParameter("PracticeOral");
String Ans12 = request.getParameter("PracticeAnal");
String Ans13= request.getParameter("CondomVaginal");
String Ans14= request.getParameter("CondomOral");
String Ans15= request.getParameter("CondomAnal");
String Ans16= request.getParameter("CondomProvider");
String Ans17= request.getParameter("HIVPartStatus");
String Ans18= request.getParameter("NoHIVPartStatus");
String Ans19= request.getParameter("PartCondomUse");


String Ans20= request.getParameter("DGenitals");
String Ans21= request.getParameter("PUrine");
String Ans22= request.getParameter("PSex");
String Ans23= request.getParameter("SGenitals");
String Ans24= request.getParameter("GSores");
String Ans25= request.getParameter("DiscolorUrine");
String Ans26 = request.getParameter("AbdominalPain");
String Ans27= request.getParameter("STISeekTreat");
String Ans28= request.getParameter("STIPlaceTreated");

String Ans29= request.getParameter("LubricantUse");
String Ans30= request.getParameter("KYJelly");
String Ans31= request.getParameter("Saliva");
String Ans32= request.getParameter("OtherLubricants");
String Ans33= request.getParameter("LubUseVaginal");
String Ans34= request.getParameter("LubUseAnal");

String Ans35= request.getParameter("pregnant");
String Ans36= request.getParameter("HaveKids");
String Ans37= request.getParameter("UseFP");
String Ans38= request.getParameter("FPMethodUsed");




String Ans39= request.getParameter("AlcoholUse");
String Ans40= request.getParameter("AlcoholFrequency");
String Ans41= request.getParameter("DrugUse");
String Ans42= request.getParameter("DrugType");
String Ans43= request.getParameter("DrugFrequency");
String Ans44= request.getParameter("VaginalDouche");
String Ans45= request.getParameter("AfterSexDouche");
String Ans46= request.getParameter("BathDouche");
String Ans47= request.getParameter("CdBurstDouche");
String Ans48= request.getParameter("OtherDouche");



String Ans49= request.getParameter("VerbalInsults");
String Ans50= request.getParameter("LastVerbalInsult");
String Ans51= request.getParameter("Hit");
String Ans52= request.getParameter("LastVerbalInsultHit");
String Ans53= request.getParameter("ForcedSex");
String Ans54= request.getParameter("LastVerbalInsultForced");

String Ans55 = request.getParameter("VerbalAbuse");
String Ans56 = request.getParameter("VerbalAbuseTime");

String Ans57 = request.getParameter("PartnerProblem");
String Ans58 = request.getParameter("PartnerProblemTime");

String Ans59= request.getParameter("SeekTreatment");
String Ans60= request.getParameter("PlaceTreated");


String Ans61= request.getParameter("ReportPolice");
String Ans62 = request.getParameter("ReportWhere");


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
 //System.out.println("UniqueID|||||||||||||||||||||||||||||||||"+ UniqueID);
 
 
 
 
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
 
   String Aphia="Aphia";
//    String AssessmentID = Aphia+'/'+ Ans1 +'/'+UniqueID;
    String[] ans = answers.split(",");
    String[] que = questions.split(",");
//    for(int i=0; i<ans.length;i++){
//        System.out.println("que___"+que[i]+"ans__________"+ans[i]);
//    }
//    for(int j=0;j<que.length;j++){ System.out.println("que"+que[j]);}
//   
   String AssessmentID = request.getParameter("AssID");
//   System.out.println("AssessmentID|||||||||||||||||||||||||||"+AssessmentID);
   try{
 for(int a=0;a<ans.length;a++){
                    
                        
                        if(AssessmentID!=null){
                        String query ="UPDATE riskassessmentdetails SET DirectAnswers='"+ans[a]+"',CodedAnswers=1,syncstatus=0 WHERE  QuestionID='"+que[a]+"' AND AssessmentID ="+AssessmentID;
                          conn.state.executeUpdate(query);
                   
//                     System.out.println("query    "+query);
                        }
                        
 }            
//     String inserter = "insert into taskauditor set host_comp='" + computername + "' , action='Performed Risk Assessment Update on a Sex Worker  whose UniqueID is '"+UniqueID+"' from the Risk Assess Form',time='" + formattedDate + "',username='" + session.getAttribute("Username") + "'";
//                      conn.state.executeUpdate(inserter);
 
 
 String inserter = "INSERT INTO taskauditor (host_comp,time,username,action) VALUES(?,?,?,?)";
    
    
 conn.ps = conn.connect.prepareStatement(inserter);
conn.ps.setString(1,computername);
conn.ps.setString(2,formattedDate);
conn.ps.setString(3,(session.getAttribute("Username")).toString() );
conn.ps.setString(4,"Performed Risk Assessment Update on a Sex Worker  whose UniqueID is "+UniqueID+" from the Risk Assess Form");
conn.ps.executeUpdate(); 
                    
   response.sendRedirect("admin/index_Assessment.jsp");                  
                    
                   
 		
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
 
 }
   catch(SQLException Ex){
   System.out.println(Ex.toString());
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



                     