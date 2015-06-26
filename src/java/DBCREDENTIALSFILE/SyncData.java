/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBCREDENTIALSFILE;

import dbConnect.dbConnect;
import dbConnect.dbConnectTemp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AphiaPlus
 */
public class SyncData extends HttpServlet {

  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
         
//In some
        
        
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
            Logger.getLogger(concatenateData.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(concatenateData.class.getName()).log(Level.SEVERE, null, ex);
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


public boolean MergeData() throws SQLException{

  InternetThreadClass itc=new InternetThreadClass();
        //false means no syncing is ongoing 
        itc.syncingstatus=true;
       // itc.startorendthread();

  String AuditID,UniqueID,DrnkAlc,AlchHav,DrnkOcc,StpDrnk,FailDrnk,RemHap,NeedAlc,GuiltDrnk,InjureDrnk,FriendDrnk,DrnkAlctxt,AlcHavtxt,DrnkOcctxt,StpDrnktxt,FailDrnktxt,RemHaptxt,NeedAlctxt,GuiltDrnktxt,InjureDrnktxt,FriendDrnktxt,FinalAudit;
    String enrollpefar_year,UniqueIDs,ClientInit,DOE,District,DICName,DOB,Sex,Age,MaritalStatus,Children,ChildNo,Religion,EducationLevel,PhoneNo,Residence,OperationArea,Occupation,MemberOfID,DICLearn,Email,PhoneNo1,Venue,AgeID,FirstName,SecondName,LastName,venueOther,DicLearnOther,timestamp1,hand,biometric,ward="";
//    String ResultID,County,District,menAchieved,womenAchieved, reportingPeriod,financialYear,titleIDs="";
//    String ResultID1,County1,District1,totalAchieved, reportingPeriod1,financialYear1,titleIDs1="";
    String ID,ChildID,UniqueID2,AgeBrackets,NoChild,timestamp2="";
    String ID1,MemberID,UniqueID3,timestamp3,MemID="";
    String ID2,CoccID,UniqueID4,OccupationID,timestamp4="";
    String ID3,COPID,UniqueID5,AreaOpID,timestamp5="";
   String ID4,FHIClient="";
   String  id,unique_identifier,temperature,temperature_complain,blood_pressure,blood_pressure_complain,p,p_complain,weight,weightcomplain,ga,ga_findings,skin,skin_findings,ent,ent_findings,eyes,eyes_findings,abdomen,abdomen_findings,genitourinary,genitourinary_findings,
           musculoskeletal,musculoskeletal_findings,respiratory,respiratory_findings,psychological,psychological_findings,diagnosis,management,
           referral,specify_others,TCA,cadre,dater,signature,timestamp6="";
    
   String RiskAssessDetailID,AssessmentID,QuestionsID,DirectAnswers,CodedAnswers,timestamp7="";
   String RedID,RiskReductionID,QID,currentStatus,Action,Appointments,timestamp8="";
   String AssessID,AssessmentDate,UniqueID6,timestamp9="";
   String RiskRedID,DOA,CadreProvider,UniqueID7,timestamp10="";
   String  hostcomp,action,time,username,timestamp11="";        
   String Name,Username,Password,PhoneNos,Emails,Location,AccessLevel,timestamp12="";
   int already_added;
   String timestamp="";
   int audits,enrollments,childages,clientmembers,clientoccupations,clientopareas,dummys,medical_forms,riskassessmentdetail,riskassessmentmains,riskreductiondetails,riskreductionmains,taskauditors,users=0;
//    HttpSession session;

    
        int numberofqueries=0;
        int existingdata=0;
      
//        session=request.getSession();
        
        
dbConnectTemp conn1 = new dbConnectTemp();
dbConnect conn = new dbConnect();

System.out.println("Merging Data");
audits=enrollments=childages=clientmembers=clientoccupations=clientopareas=dummys=medical_forms=riskassessmentdetail=riskassessmentmains=riskreductiondetails=riskreductionmains=taskauditors=users=0;
//read data from the new database-indicatoractivities1 
String selector="SELECT * FROM audit WHERE AuditID!='' and syncstatus='0'";
conn.rs=conn.state.executeQuery(selector);
while(conn.rs.next()){
   
    
    already_added=0;
    AuditID=UniqueID=DrnkAlc=AlchHav=DrnkOcc=StpDrnk=FailDrnk=RemHap=NeedAlc=GuiltDrnk=InjureDrnk=
            FriendDrnk=DrnkAlctxt=AlcHavtxt=DrnkOcctxt=StpDrnktxt=FailDrnktxt=RemHaptxt=NeedAlctxt
            =GuiltDrnktxt=InjureDrnktxt=FriendDrnktxt=FinalAudit=""; 
    
         AuditID=conn.rs.getString(1);
         UniqueID=conn.rs.getString(2);
         DrnkAlc=conn.rs.getString(3);
         AlchHav=conn.rs.getString(4);
         DrnkOcc=conn.rs.getString(5);
         StpDrnk=conn.rs.getString(6);
         FailDrnk=conn.rs.getString(7);
         RemHap=conn.rs.getString(8);
         NeedAlc=conn.rs.getString(9);
         GuiltDrnk=conn.rs.getString(10);
         InjureDrnk=conn.rs.getString(11); 
         FriendDrnk=conn.rs.getString(12); 
         DrnkAlctxt=conn.rs.getString(13); 
         AlcHavtxt=conn.rs.getString(14); 
         DrnkOcctxt=conn.rs.getString(15); 
         StpDrnktxt=conn.rs.getString(16); 
         FailDrnktxt=conn.rs.getString(17); 
         RemHaptxt=conn.rs.getString(18); 
         NeedAlctxt=conn.rs.getString(19); 
         GuiltDrnktxt=conn.rs.getString(20); 
         InjureDrnktxt=conn.rs.getString(21); 
         FriendDrnktxt=conn.rs.getString(22); 
         FinalAudit=conn.rs.getString(23); 
         timestamp=conn.rs.getTimestamp(24).toString(); 
  
 String check_if_exist="SELECT * FROM audit WHERE UniqueID='"+UniqueID+"'AND DrnkAlc='"+DrnkAlc+"' AND AlchHav='"+AlchHav+"' AND DrnkOcc='"+DrnkOcc+"' AND StpDrnk='"+StpDrnk+"'"
 + " AND FailDrnk='"+FailDrnk+"' AND RemHap='"+RemHap+"' AND NeedAlc='"+NeedAlc+"' AND GuiltDrnk='"+GuiltDrnk+"' AND InjureDrnk='"+InjureDrnk+"'"
         + " AND FriendDrnk='"+FriendDrnk+"' AND DrnkAlctxt='"+DrnkAlctxt+"' AND AlchHavtxt='"+AlcHavtxt+"' AND DrnkOcctxt='"+DrnkOcctxt+"' AND "
         + "StpDrnktxt='"+StpDrnktxt+"' AND FailDrnktxt='"+FailDrnktxt+"'AND RemHaptxt='"+RemHaptxt+"'AND NeedAlctxt='"+NeedAlctxt+"'AND GuiltDrnktxt='"+GuiltDrnktxt+"'"
         + " AND InjureDrnktxt='"+InjureDrnktxt+"'AND FriendDrnktxt='"+FriendDrnktxt+"'AND FinalAudit='"+FinalAudit+"' syncstatus='0'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO audit (UniqueID,DrnkAlc,AlchHav,DrnkOcc,StpDrnk,FailDrnk,RemHap,NeedAlc,GuiltDrnk,InjureDrnk,FriendDrnk,DrnkAlctxt,AlchHavtxt,DrnkOcctxt,StpDrnktxt,"
          + "FailDrnktxt,RemHaptxt,NeedAlctxt,GuiltDrnktxt,InjureDrnktxt,FriendDrnktxt,FinalAudit,timestamp,syncstatus)"
          + "VALUES('"+UniqueID+"','"+DrnkAlc+"','"+AlchHav+"','"+DrnkOcc+"','"+StpDrnk+"','"+FailDrnk+"','"+RemHap+"','"+NeedAlc+"','"+GuiltDrnk+"','"+InjureDrnk+"','"+FriendDrnk+"','"+DrnkAlctxt+"','"+AlcHavtxt+"','"+DrnkOcctxt+"','"+StpDrnktxt+"','"+FailDrnktxt+"','"+RemHaptxt+"','"+NeedAlctxt+"','"+GuiltDrnktxt+"','"+InjureDrnktxt+"','"+FriendDrnktxt+"','"+FinalAudit+"','"+timestamp+"','1')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state2.executeUpdate(inserter);  
   audits++;
   
   
 }   
    
}


// END OF AUDIT 
//
// BEGINING OF ENROLMENT

String enrollment="SELECT * FROM enrollment WHERE UniqueID!='' and syncstatus='0'";
conn.rs=conn.state6.executeQuery(enrollment);
while(conn.rs.next()){
   
    
    already_added=0;
  UniqueIDs=ClientInit=DOE=District=DICName=DOB=Sex=Age=MaritalStatus=Children=ChildNo=Religion=
  EducationLevel=PhoneNo=Residence=OperationArea=Occupation=MemberOfID=DICLearn=Email=PhoneNo1=Venue=AgeID=FirstName=SecondName=LastName=venueOther=DicLearnOther=timestamp1=hand=biometric=""; 
  ward=enrollpefar_year="";
        
         UniqueIDs=conn.rs.getString("UniqueID");
         ClientInit=conn.rs.getString("ClientInit");
         DOE=conn.rs.getString("DOE");
         District=conn.rs.getString("District");
         DICName=conn.rs.getString("DICName");
         DOB=conn.rs.getString("DOB");
         Sex=conn.rs.getString("Sex");
         Age=conn.rs.getString("Age");
         MaritalStatus=conn.rs.getString("MaritalStatus");
         Children=conn.rs.getString("Children");
         ChildNo=conn.rs.getString("ChildNo");
         Religion=conn.rs.getString("Religion"); 
         EducationLevel=conn.rs.getString("EducationLevel"); 
         PhoneNo=conn.rs.getString("PhoneNo"); 
         Residence=conn.rs.getString("Residence"); 
         OperationArea=conn.rs.getString("OperationArea"); 
         Occupation=conn.rs.getString("Occupation"); 
         MemberOfID=conn.rs.getString("MemberOfID"); 
         DICLearn=conn.rs.getString("DICLearn"); 
         Email=conn.rs.getString("Email"); 
         PhoneNo1=conn.rs.getString("PhoneNo1"); 
         Venue=conn.rs.getString("Venue"); 
         AgeID=conn.rs.getString("AgeID"); 
         FirstName=conn.rs.getString("FirstName"); 
         SecondName=conn.rs.getString("SecondName"); 
         LastName=conn.rs.getString("LastName"); 
         venueOther=conn.rs.getString("venueOther"); 
         DicLearnOther=conn.rs.getString("DicLearnOther");
         enrollpefar_year=conn.rs.getString("Pefar_year");
        timestamp = conn.rs.getString("timestamp");
        hand = conn.rs.getString("capturedhand");
        biometric = conn.rs.getString("fingerprint");
         ward=conn.rs.getString("ward");
 String check_if_exist="SELECT * FROM enrollment where OperationArea='"+OperationArea+"'"
         + " AND Occupation='"+Occupation+"'AND MemberOfID='"+MemberOfID+"'";
 
  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){
     already_added=1; 
// String inserter="UPDATE enrollment set UniqueID='"+UniqueIDs+"',ClientInit='"+ClientInit+"',DOE='"+DOE+"',District='"+District+"',DICName='"+DICName+"',DOB='"+DOB+"',Sex='"+Sex+"',Age='"+Age+"',"
//         + "MaritalStatus='"+MaritalStatus+"',Children='"+Children+"',ChildNo='"+ChildNo+"',Religion='"+Religion+"',EducationLevel='"+EducationLevel+"',PhoneNo='"+PhoneNo+"',Residence='"+Residence+"',"
//         + "OperationArea='"+OperationArea+"',Occupation='"+Occupation+"',MemberOfID='"+MemberOfID+"',DICLearn='"+DICLearn+"',Email='"+Email+"',PhoneNo1='"+PhoneNo1+"',Venue='"+Venue+"',AgeID='"+AgeID+"',"
//         + "FirstName='"+FirstName+"',SecondName='"+SecondName+"',LastName='"+LastName+"',venueOther='"+venueOther+"',DicLearnOther='"+DicLearnOther+"',capturedhand='"+hand+"',fingerprint='"+biometric+"' where  AgeID='"+AgeID+"'"
//         + " AND Religion='"+Religion+"' AND EducationLevel='"+EducationLevel+"'AND PhoneNo='"+PhoneNo+"' "
//         + "AND MemberOfID='"+MemberOfID+"'";
 String inserter="UPDATE enrollment set ward='"+ward+"',capturedhand='"+hand+"',fingerprint='"+biometric+"' where  AgeID='"+AgeID+"'"
         + " AND Religion='"+Religion+"' AND EducationLevel='"+EducationLevel+"'AND PhoneNo='"+PhoneNo+"' "
         + "AND MemberOfID='"+MemberOfID+"' AND  UniqueID='"+UniqueIDs+"'";
            
          conn.state5.executeUpdate(inserter);
//  System.out.println("Data already added");
  System.out.println("_"+inserter+"\n");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO enrollment(UniqueID,ClientInit,DOE,District,DICName,Ward,DOB,Sex,Age,MaritalStatus,Children,ChildNo,Religion,EducationLevel,PhoneNo,Residence,OperationArea,Occupation,MemberOfID,DICLearn,Email,PhoneNo1,Venue,AgeID,FirstName,SecondName,LastName,venueOther,DicLearnOther,Pefar_year,capturedhand,fingerprint,syncstatus)"
          + "VALUES('"+UniqueIDs+"','"+ClientInit+"','"+DOE+"','"+District+"','"+DICName+"','"+ward+"','"+DOB+"','"+Sex+"','"+Age+"','"+MaritalStatus+"','"+Children+"','"+ChildNo+"','"+Religion+"','"+EducationLevel+"','"+PhoneNo+"','"+Residence+"','"+OperationArea+"',"
          + "'"+Occupation+"','"+MemberOfID+"','"+DICLearn+"','"+Email+"','"+PhoneNo1+"','"+Venue+"','"+AgeID+"','"+FirstName+"','"+SecondName+"','"+LastName+"','"+venueOther+"','"+DicLearnOther+"','"+enrollpefar_year+"','"+hand+"','"+biometric+"','1')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state2.executeUpdate(inserter);  
  enrollments++;
   
   
 }   
    
}

// end of enrollment 

//// start of childage
//
//
String childage="SELECT * FROM childage WHERE ID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(childage);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID=ChildID=UniqueID2=AgeBrackets=NoChild=timestamp2="";
    
         ID=conn.rs2.getString(1);
         ChildID=conn.rs2.getString(2);
         UniqueID2=conn.rs2.getString(3);
         AgeBrackets=conn.rs2.getString(4);
         ChildNo=conn.rs2.getString(5);
         timestamp2=conn.rs2.getString(6);
       
 String check_if_exist="SELECT * FROM childage  WHERE ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";

  System.out.println(check_if_exist+"\n");
 
 //conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,timestamp,syncstatus)"
          + "VALUES('"+ChildID+"','"+UniqueID2+"','"+AgeBrackets+"','"+NoChild+"','"+timestamp2+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  //conn1.state4.executeUpdate(inserter);  
  childages++; 
   
   
 }   
    
}

//// end of child age 
//
//
//start of client member
String clientmember="SELECT * FROM clientmember WHERE ID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(clientmember);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID1=MemberID=UniqueID3=MemID=timestamp3="";
    
         ID=conn.rs2.getString(1);
         MemberID=conn.rs2.getString(2);
         UniqueID3=conn.rs2.getString(3);
         MemID=conn.rs2.getString(4);
         timestamp3=conn.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientmember WHERE MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){
    already_added=1; 
// 
// String inserter="REPLACE INTO clientmember(MemberID,UniqueID,MemID,timestamp)"
//          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"')";
//  
//  System.out.println("_"+inserter+"\n");
//  numberofqueries++;
//  conn1.state4.executeUpdate(inserter);  
// existingdata++;
 }
 else {
  String inserter="INSERT INTO clientmember(MemberID,UniqueID,MemID,timestamp,syncstatus)"
          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   clientmembers++;
   
   
 }   
    
}
//
//
////end of clientmember 


//start of clientoccupation


////start of client member
String clientoccupation="SELECT * FROM clientoccupation WHERE ID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(clientoccupation);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         ID2=conn.rs2.getString(1);
         CoccID=conn.rs2.getString(2);
         UniqueID4=conn.rs2.getString(3);
         OccupationID=conn.rs2.getString(4);
         timestamp4=conn.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientoccupation WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO clientoccupation(CoccID,UniqueID,OccupationID,syncstatus)"
          + "VALUES('"+CoccID+"','"+UniqueID4+"','"+OccupationID+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
   
   clientoccupations++;
 }   
    
}
//// end of clientoccupation
//
//
////start of client op area
String clientoparea="SELECT * FROM clientoparea WHERE ID!=''";
conn.rs2=conn.state3.executeQuery(clientoparea);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID3=COPID=UniqueID5=AreaOpID=timestamp5="";
    
         ID3=conn.rs2.getString(1);
         COPID=conn.rs2.getString(2);
         UniqueID5=conn.rs2.getString(3);
         AreaOpID=conn.rs2.getString(4);
         timestamp5=conn.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientoparea WHERE COPID='"+COPID+"' AND UniqueID='"+UniqueID5+"' AND AreaOpID='"+AreaOpID+"' and syncstatus='0'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO clientoparea(COPID,UniqueID,AreaOpID,timestamp,syncstatus)"
          + "VALUES('"+COPID+"','"+UniqueID5+"','"+AreaOpID+"','"+timestamp5+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   clientopareas++;
   
   
 }   
    
}
//
//
////END OF CLIENT OP AREA
//
////start of DUMMY

//
//// MEDICAL FORM 
//
//
String medical_form="SELECT * FROM medical_form WHERE unique_identifier!='' and syncstatus='0'";
conn.rs=conn.state.executeQuery(medical_form);
while(conn.rs.next()){
   
    
    already_added=0;
           id=unique_identifier=temperature=temperature_complain=blood_pressure=blood_pressure_complain=p=p_complain=weight=weightcomplain=ga=ga_findings
                   =skin=skin_findings=ent=ent_findings=eyes=eyes_findings=abdomen=abdomen_findings=genitourinary=genitourinary_findings=
           musculoskeletal=musculoskeletal_findings=respiratory=respiratory_findings=psychological=psychological_findings=diagnosis=management=
           referral=specify_others=TCA=cadre=dater=signature=timestamp6="";
    
         id=conn.rs.getString(1);
         unique_identifier=conn.rs.getString(2);
         temperature=conn.rs.getString(3);
         temperature_complain=conn.rs.getString(4);
         blood_pressure=conn.rs.getString(5);
         blood_pressure_complain=conn.rs.getString(6);
         p=conn.rs.getString(7);
         p_complain=conn.rs.getString(8);
         weight=conn.rs.getString(9);
         weightcomplain=conn.rs.getString(10);
         ga=conn.rs.getString(11);
         ga_findings=conn.rs.getString(12);
         skin=conn.rs.getString(13); 
         skin_findings=conn.rs.getString(14); 
         ent=conn.rs.getString(15); 
         ent_findings=conn.rs.getString(16); 
         eyes=conn.rs.getString(17); 
         eyes_findings=conn.rs.getString(18); 
         abdomen=conn.rs.getString(19); 
         abdomen_findings=conn.rs.getString(20); 
         genitourinary=conn.rs.getString(21); 
         genitourinary_findings=conn.rs.getString(22); 
         musculoskeletal=conn.rs.getString(23); 
         musculoskeletal_findings=conn.rs.getString(24); 
         respiratory=conn.rs.getString(25); 
         respiratory_findings=conn.rs.getString(26); 
         psychological=conn.rs.getString(27);
         psychological_findings=conn.rs.getString(28);
         diagnosis=conn.rs.getString(29); 
         management=conn.rs.getString(30); 
         referral=conn.rs.getString(31); 
         specify_others=conn.rs.getString(32); 
         TCA=conn.rs.getString(33); 
         cadre=conn.rs.getString(34); 
         dater=conn.rs.getString(35); 
         signature=conn.rs.getString(36); 
         timestamp6=conn.rs.getString(37); 
  
 String check_if_exist="SELECT * FROM medical_form WHERE unique_identifier='"+unique_identifier+"', temperature='"+temperature+"' AND temperature_complain='"+temperature_complain+"' AND blood_pressure='"+blood_pressure_complain+"' AND p='"+p+"'"
 + " AND p_complain='"+p_complain+"' AND weight_complain='"+weightcomplain+"' AND ga='"+ga+"' AND ga_findings='"+ga_findings+"' AND skin='"+skin+"'"
         + " AND skin_findings='"+skin_findings+"' AND ent='"+ent+"' AND ent_findings='"+ent_findings+"' AND eyes='"+eyes+"' AND "
         + "eyes_findings='"+eyes_findings+"' AND abdomen='"+abdomen+"'AND abdomen_findings='"+abdomen_findings+"'AND genitourinary='"+genitourinary+"'AND genitourinary_findings='"+genitourinary_findings+"'"
         + " AND musculoskeletal='"+musculoskeletal+"'AND musculoskeletal_findings='"+musculoskeletal_findings+"'AND respiratory='"+respiratory+"' AND respiratory_findings='"+respiratory_findings+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO medical_form(unique_identifier,temperature,temperature_complain,blood_pressure,blood_pressure_complain,p,p_complain,weight"
          + ",weight_complain,ga,ga_findings,skin,skin_findings,ent,ent_findings,eyes,eyes_findings,"
          + "abdomen,abdomen_findings,genitourinary,genitourinary_findings," 
          +"musculoskeletal,musculoskeletal_findings,respiratory,respiratory_findings,psychological,psychological_findings,"
          + "diagnosis,management,referral,specify_others,TCA,cadre,dater,signature,timestamp,syncstatus)"
          + "VALUES('"+unique_identifier+"','"+temperature+"','"+temperature_complain+"','"+blood_pressure+"','"+blood_pressure_complain+"','"+p+"','"+p_complain+"','"+weight+"',"
          + "'"+weightcomplain+"','"+ga+"','"+ga_findings+"','"+skin+"','"+skin_findings+"','"+ent+"','"+ent_findings+"','"+eyes+"',"
          + "'"+eyes_findings+"','"+abdomen+"','"+abdomen_findings+"','"+genitourinary+"','"+genitourinary_findings+"','"+psychological+"','"+psychological_findings+"',"
          + "'"+musculoskeletal+"','"+musculoskeletal_findings+"','"+respiratory+"','"+respiratory_findings+"',"
          + "'"+diagnosis+"','"+management+"','"+referral+"','"+specify_others+"','"+TCA+"','"+cadre+"',"
          + "'"+dater+"','"+signature+"','"+timestamp6+"','1')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state2.executeUpdate(inserter);  
   
   medical_forms++;
   
 }   
    
}
//// END OF MEDICAL FORM 
//
////start of risk assessment details 
//
//
//
////start of client member
//
//
//
////start of risk reductiondetails
String riskreddets="SELECT * FROM riskreductiondetails WHERE RiskReductionID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(riskreddets);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         RiskAssessDetailID=conn.rs2.getString(1);
         RiskReductionID=conn.rs2.getString(2);
         QID=conn.rs2.getString(3);
         currentStatus=conn.rs2.getString(4);
         Action=conn.rs2.getString(5);
         Appointments=conn.rs2.getString(6);
       timestamp4=conn.rs2.getString("timestamp");
      
       
 String check_if_exist="SELECT * FROM riskreductiondetails WHERE RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskreductiondetails(RiskReductionID,QID,currentStatus,Action,Appointments,syncstatus)"
          + "VALUES('"+RiskReductionID+"','"+QID+"','"+currentStatus+"','"+Action+"','"+Appointments+"','0')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
 riskreductiondetails++;  
   
 }   
    
}
////// end of riskreductiondetails 
////
//
//start of risk assessment main
String riskasesmain="SELECT * FROM riskassessmentmain WHERE ID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(riskasesmain);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    String Quarter,Month,Pefar_year="";
         AssessID=conn.rs2.getString(2);
         AssessmentDate=conn.rs2.getString(3);
         UniqueID6=conn.rs2.getString(4);
         timestamp4=conn.rs2.getString("timestamp");
         Quarter=conn.rs2.getString("Quarter");
         Month=conn.rs2.getString("Month");
         Pefar_year=conn.rs2.getString("Pefar_year");
        
      
       
 String check_if_exist="SELECT * FROM riskassessmentmain WHERE AssessmentID='"+AssessID+"' AND AssessmentDate='"+AssessmentDate+"'  ";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskassessmentmain(AssessmentID,AssessmentDate,UniqueID,Quarter,Month,Pefar_year,entrydate,syncstatus)"
          + "VALUES('"+AssessID+"','"+AssessmentDate+"','"+UniqueID6+"','"+Quarter+"','"+Month+"','"+Pefar_year+"','"+timestamp4+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
   
   riskassessmentmains++;
 }   
    
}
//start of risk reduction main
String riskredmain="SELECT * FROM riskreductionmain WHERE ID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(riskredmain);
while(conn.rs2.next()){
   
    
    already_added=0;
    RiskRedID=DOA=CadreProvider=UniqueID7=timestamp4="";
    String qtr="";
    String year="";
         RiskRedID=conn.rs2.getString(2);
         DOA=conn.rs2.getString(3);
         CadreProvider=conn.rs2.getString(4);
         UniqueID7=conn.rs2.getString(5);
         timestamp4=conn.rs2.getString("timestamp");
         qtr=conn.rs2.getString("qtr");
         year=conn.rs2.getString("year");
      
        
      
       
 String check_if_exist="SELECT * FROM riskreductionmain WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskreductionmain(RiskReductionID,DOA,CadreProvider,UniqueID,entrydate,qtr,year,syncstatus)"
          + "VALUES('"+RiskRedID+"','"+DOA+"','"+CadreProvider+"','"+UniqueID7+"','"+timestamp+"','"+qtr+"','"+year+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
   riskreductionmains++;
   
 }   
    
}

//end of riskassessmentmain


//start of taskauditor
String taskauditor="SELECT * FROM taskauditor WHERE audit!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(taskauditor);
while(conn.rs2.next()){
   
    
    already_added=0;
    hostcomp=action=time=username=timestamp11="";
    
         hostcomp=conn.rs2.getString(2);
         action=conn.rs2.getString(3);
         time=conn.rs2.getString(4);
         username=conn.rs2.getString(5);
         timestamp11=conn.rs2.getString(6);
        
      
       
 String check_if_exist="SELECT * FROM taskauditor WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO taskauditor(host_comp,action,time,username,timestamp,syncstatus)"
          + "VALUES('"+hostcomp+"','"+action.replace("'", " ")+"','"+time+"','"+username+"','"+timestamp11+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
   taskauditors++;
   
 }   
    
}

//end of task auditor 

////
////start of user
String user="SELECT * FROM user WHERE UserID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(user);
while(conn.rs2.next()){
   
    
    already_added=0;
    Name=Username=Password=PhoneNos=Email=Location=AccessLevel=timestamp12="";
    
         Name=conn.rs2.getString(2);
         Username=conn.rs2.getString(3);
         Password=conn.rs2.getString(4);
         PhoneNos=conn.rs2.getString(5);
         Email=conn.rs2.getString(6);
         Location=conn.rs2.getString(7);
         AccessLevel=conn.rs2.getString(8);
         timestamp12=conn.rs2.getString(9);
        
      
       
 String check_if_exist="SELECT * FROM user WHERE Name='"+Name+"' AND Username='"+Username+"' AND Password='"+Password+"' AND PhoneNo='"+PhoneNos+"' AND Email='"+Email+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO user(Name,Username,Password,PhoneNo,Email,Location,AccessLevel,timestamp,syncstatus)"
          + "VALUES('"+Name+"','"+Username+"','"+Password+"','"+PhoneNos+"','"+Email+"','"+Location+"','"+AccessLevel+"','"+timestamp11+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
   
   users++;
 }   
    
}
//
////end of task auditor
//
//
//

String riskassessdets="SELECT * FROM riskassessmentdetails WHERE RiskAssessDetailID!='' and syncstatus='0'";
conn.rs2=conn.state3.executeQuery(riskassessdets);
while(conn.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         RiskAssessDetailID=conn.rs2.getString(1);
         AssessmentID=conn.rs2.getString(2);
         QuestionsID=conn.rs2.getString(3);
         DirectAnswers=conn.rs2.getString(4);
         CodedAnswers=conn.rs2.getString(5);
         timestamp4=conn.rs2.getString("timestamp");
       
      
       
 String check_if_exist="SELECT * FROM riskassessmentdetails WHERE AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";

  System.out.println(check_if_exist+"\n");
 
 conn1.rs3=conn1.state1.executeQuery(check_if_exist);
 if(conn1.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskassessmentdetails(AssessmentID,QuestionID,DirectAnswers,CodedAnswers,entrydate,syncstatus)"
          + "VALUES('"+AssessmentID+"','"+QuestionsID+"','"+DirectAnswers+"','"+CodedAnswers+"','"+timestamp4+"','1')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  conn1.state4.executeUpdate(inserter);  
   
   riskassessmentdetail++;
   
 }   
    
}
//// end of riskassessmentdetails 
String wholemsg="<font color=\"green\">Data Merging Completed </font>";

if(audits==0 && enrollments==0 && childages==0 && clientmembers==0 && clientoccupations==0 && clientopareas==0 && dummys==0 && medical_forms==0 && riskassessmentdetail==0 && riskreductionmains==0 && taskauditors==0 && users==0 ){


  wholemsg+="<br/><font color=\"orange\"> No new Inserts done</font>";
}
else{

  wholemsg+="<br/><font color=\"orange\"> <b>"+audits+"</b> New Audits inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+enrollments+"</b> New Enrollments inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+childages+"</b> New Child Ages inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+clientmembers+"</b> New Client Members inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+clientoccupations+"</b> New Clietn Occupation inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+clientopareas+"</b> New Client Op Areas inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+dummys+"</b> New dummy inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+medical_forms+"</b> New Medical forms inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+riskassessmentdetail+"</b> New risk assessment details inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+riskassessmentmains+"</b> New risk asssessment main inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+riskreductiondetails+"</b> New Risk reduction details inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+riskreductionmains+"</b> New risk reduction main inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+taskauditors+"</b> New task auditors inserted </font>.";
  wholemsg+="<br/><font color=\"orange\"> <b>"+users+"</b> New Users inserted </font>.";

} 

if(existingdata>0){

//wholemsg+="<br/><b>"+existingdata+"</b> users in this file are already added to the Master database";
}

conn.state.close();
conn1.state1.close();

//since syncing has ended, Now start or end thread
itc.syncingstatus=false;

return true;

//session.setAttribute("msg", wholemsg);

}



}
