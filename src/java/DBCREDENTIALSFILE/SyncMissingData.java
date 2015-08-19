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
 * @author Emmanuel E
 */
public class SyncMissingData extends HttpServlet {
HttpSession session=null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String currentdic="";
        session=request.getSession();
        if(session.getAttribute("Location")!=null){
       currentdic=session.getAttribute("Location").toString();
       
        }
        PrintWriter out = response.getWriter();
     
        
        
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    //this method does all the syncing from cloud to the desktop
   public boolean syncbetweentwodics(String clouduniqid){
   
       System.out.println("================================================================");
       System.out.println("SYNCING GLOBAL DATA...");
       System.out.println("================================================================"); 
   boolean returnmsg=true;
   

    try {
        String AuditID, UniqueID, DrnkAlc, AlchHav, DrnkOcc, StpDrnk, FailDrnk, RemHap, NeedAlc, GuiltDrnk, InjureDrnk, FriendDrnk, DrnkAlctxt, AlcHavtxt, DrnkOcctxt, StpDrnktxt, FailDrnktxt, RemHaptxt, NeedAlctxt, GuiltDrnktxt, InjureDrnktxt, FriendDrnktxt, FinalAudit;
        String enrollpefar_year, UniqueIDs, ClientInit, DOE, District, DICName, DOB, Sex, Age, MaritalStatus, Children, ChildNo, Religion, EducationLevel, PhoneNo, Residence, OperationArea, Occupation, MemberOfID, DICLearn, Email, PhoneNo1, Venue, AgeID, FirstName, SecondName, LastName, venueOther, DicLearnOther, timestamp1, hand, biometric, ward = "";
        String ID, ChildID, UniqueID2, AgeBrackets, NoChild, timestamp2 = "";
        String ID1, MemberID, UniqueID3, timestamp3, MemID = "";
        String ID2, CoccID, UniqueID4, OccupationID, timestamp4 = "";
        String ID3, COPID, UniqueID5, AreaOpID, timestamp5 = "";
        String ID4, FHIClient = "";
        String id, unique_identifier, temperature, temperature_complain, blood_pressure, blood_pressure_complain, p, p_complain, weight, weightcomplain, ga, ga_findings, skin, skin_findings, ent, ent_findings, eyes, eyes_findings, abdomen, abdomen_findings, genitourinary, genitourinary_findings,
                musculoskeletal, musculoskeletal_findings, respiratory, respiratory_findings, psychological, psychological_findings, diagnosis, management,
                referral, specify_others, TCA, cadre, dater, signature, timestamp6 = "";
        String RiskAssessDetailID, AssessmentID, QuestionsID, DirectAnswers, CodedAnswers, timestamp7 = "";
        String RedID, RiskReductionID, QID, currentStatus, Action, Appointments, timestamp8 = "";
        String AssessID, AssessmentDate, UniqueID6, timestamp9 = "";
        String RiskRedID, DOA, CadreProvider, UniqueID7, timestamp10 = "";
        String hostcomp, action, time, username, timestamp11 = "";
        String Name, Username, Password, PhoneNos, Emails, Location, AccessLevel, timestamp12 = "";
        int already_added;
        String timestamp = "";
        int audits, enrollments, childages, clientmembers, clientoccupations, clientopareas, dummys, medical_forms, riskassessmentdetail, riskassessmentmains, riskreductiondetails, riskreductionmains, taskauditors, users = 0;
        //    HttpSession session;
        dbConnect local=new dbConnect();
        dbConnectTemp online=new dbConnectTemp();
        //_______________________________________________________________
        // BEGINING OF ENROLMENT
//
        String enrollment="SELECT * FROM enrollment WHERE UniqueID='"+clouduniqid+"'  ";
        online.rs=online.state6.executeQuery(enrollment);
        if(online.rs.next()){
            
            already_added=0;
            UniqueIDs=ClientInit=DOE=District=DICName=DOB=Sex=Age=MaritalStatus=Children=ChildNo=Religion=
            EducationLevel=PhoneNo=Residence=OperationArea=Occupation=MemberOfID=DICLearn=Email=PhoneNo1=Venue=AgeID=FirstName=SecondName=LastName=venueOther=DicLearnOther=timestamp1=hand=biometric="";
            ward=enrollpefar_year="";
            
            UniqueIDs=online.rs.getString("UniqueID");
            ClientInit=online.rs.getString("ClientInit");
            DOE=online.rs.getString("DOE");
            District=online.rs.getString("District");
            DICName=online.rs.getString("DICName");
            DOB=online.rs.getString("DOB");
            Sex=online.rs.getString("Sex");
            Age=online.rs.getString("Age");
            MaritalStatus=online.rs.getString("MaritalStatus");
            Children=online.rs.getString("Children");
            ChildNo=online.rs.getString("ChildNo");
            Religion=online.rs.getString("Religion");
            EducationLevel=online.rs.getString("EducationLevel");
            PhoneNo=online.rs.getString("PhoneNo");
            Residence=online.rs.getString("Residence");
            OperationArea=online.rs.getString("OperationArea");
            Occupation=online.rs.getString("Occupation");
            MemberOfID=online.rs.getString("MemberOfID");
            DICLearn=online.rs.getString("DICLearn");
            Email=online.rs.getString("Email");
            PhoneNo1=online.rs.getString("PhoneNo1");
            Venue=online.rs.getString("Venue");
            AgeID=online.rs.getString("AgeID");
            FirstName=online.rs.getString("FirstName");
            SecondName=online.rs.getString("SecondName");
            LastName=online.rs.getString("LastName");
            venueOther=online.rs.getString("venueOther");
            DicLearnOther=online.rs.getString("DicLearnOther");
            enrollpefar_year=online.rs.getString("Pefar_year");
            timestamp = online.rs.getString("timestamp");
            hand = online.rs.getString("capturedhand");
           
            
            
            if(online.rs.getString("fingerprint")!=null){biometric=online.rs.getString("fingerprint");}
            if(online.rs.getString("ward")!=null){ward=online.rs.getString("ward");}
           
            
            
            
             String check_if_exist="SELECT * FROM enrollment where OperationArea='"+OperationArea+"'"
         + " AND Occupation='"+Occupation+"'AND MemberOfID='"+MemberOfID+"'";
 
  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 

      String biofing="";

     
      String isupdateward="";
      if(!ward.trim().equals("")||!ward.equalsIgnoreCase("null")){
     isupdateward="ward='"+ward+"',"; 
      
      }
      
      String isfingerprint="";
      if(!biometric.trim().equals("")||!biometric.equalsIgnoreCase("null")){
     isfingerprint=",fingerprint='"+biometric+"'"; 
      
      }
      
     
     String updater="UPDATE enrollment set "+isupdateward+" capturedhand='"+hand+"' "+isfingerprint+" where  AgeID='"+AgeID+"'"
         + " AND Religion='"+Religion+"' AND EducationLevel='"+EducationLevel+"'AND PhoneNo='"+PhoneNo+"' "
         + "AND MemberOfID='"+MemberOfID+"' AND  UniqueID='"+UniqueIDs+"'";
            System.out.println(updater)   ;
   if(ward!=null && !ward.equals("") && hand!=null && !hand.equals("") && biometric!=null && !biometric.equals("")){
          local.state5.executeUpdate(updater);


//  System.out.println("_"+inserter+"\n");

   
   }
 }
            
            else {
            //now do the merging
            
            
            String firstname = FirstName;
            String secondname = SecondName;
            String lastname = LastName;
            String phoneno = PhoneNo;
            String fingerprints = biometric;
            
            
            
            String inserter="REPLACE INTO enrollment(UniqueID,ClientInit,DOE,District,DICName,Ward,DOB,Sex,Age,MaritalStatus,Children,ChildNo,Religion,EducationLevel,PhoneNo,Residence,OperationArea,Occupation,MemberOfID,DICLearn,Email,PhoneNo1,Venue,AgeID,FirstName,SecondName,LastName,venueOther,DicLearnOther,Pefar_year,capturedhand,fingerprint,entrydate)"
                    + "VALUES('"+UniqueIDs+"','"+ClientInit+"','"+DOE+"','"+District+"','"+DICName+"','"+ward+"','"+DOB+"','"+Sex+"','"+Age+"','"+MaritalStatus+"','"+Children+"','"+ChildNo+"','"+Religion+"','"+EducationLevel+"','"+PhoneNo+"','"+Residence+"','"+OperationArea+"',"
                    + "'"+Occupation+"','"+MemberOfID+"','"+DICLearn+"','"+Email+"','"+PhoneNo1+"','"+Venue+"','"+AgeID+"','"+FirstName+"','"+SecondName+"','"+LastName+"','"+venueOther+"','"+DicLearnOther+"','"+enrollpefar_year+"','"+hand+"','"+biometric+"','"+timestamp+"')"   ;
            
            System.out.println("%%%%%>>>>>>>>"+inserter+"\n");
            local.state2.executeUpdate(inserter);
            String updatesync="update enrollment set syncstatus='1' where UniqueID='"+UniqueIDs+"'";
            local.state7.executeUpdate(updatesync);
            System.out.println(updatesync);
            
        }
            
        }     
    
    
    //start of risk assessment main
    //get data that is in the cloud
String riskasesmain="SELECT * FROM riskassessmentmain WHERE ID!='' and UniqueID='"+clouduniqid+"' and timestamp!='0000-00-00 00:00:00'";
online.rs2=online.state3.executeQuery(riskasesmain);
while(online.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    String Quarter,Month,Pefar_year="";
         ID2=online.rs2.getString(1);
         AssessID=online.rs2.getString(2);
         AssessmentDate=online.rs2.getString(3);
         UniqueID6=online.rs2.getString(4);
         timestamp4=online.rs2.getString("timestamp");
         Quarter=online.rs2.getString("Quarter");
         Month=online.rs2.getString("Month");
         Pefar_year=online.rs2.getString("Pefar_year");
        
      
       
 String check_if_exist="SELECT * FROM riskassessmentmain WHERE AssessmentID='"+AssessID+"' AND AssessmentDate='"+AssessmentDate+"'  ";

 System.out.println(check_if_exist+"\n");
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     
     already_added=1; 
 

 
 }
 else {
  String inserter="REPLACE INTO riskassessmentmain(AssessmentID,AssessmentDate,UniqueID,Quarter,Month,Pefar_year,entrydate)"
          + "VALUES('"+AssessID+"','"+AssessmentDate+"','"+UniqueID6+"','"+Quarter+"','"+Month+"','"+Pefar_year+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
 
  local.state4.executeUpdate(inserter);  
   
 
 }   
    
}
//start of risk reduction main
String riskredmain="SELECT * FROM riskreductionmain WHERE ID!='' and UniqueID='"+clouduniqid+"' and timestamp!='0000-00-00 00:00:00' ORDER BY DOA DESC";
online.rs2=online.state3.executeQuery(riskredmain);
while(online.rs2.next()){
   
    
    already_added=0;
    RiskRedID=DOA=CadreProvider=UniqueID7=timestamp4="";
    String qtr="";
    String year="";
         RiskRedID=online.rs2.getString(2);
         DOA=online.rs2.getString(3);
         CadreProvider=online.rs2.getString(4);
         UniqueID7=online.rs2.getString(5);
         timestamp4=online.rs2.getString("timestamp");
         qtr=online.rs2.getString("qtr");
         year=online.rs2.getString("year");
      
        
      
       
 String check_if_exist="SELECT * FROM riskreductionmain WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ORDER BY DOA DESC";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 
 
 }
 else {
  String inserter="REPLACE INTO riskreductionmain(RiskReductionID,DOA,CadreProvider,UniqueID,entrydate,qtr,year,entrydate)"
          + "VALUES('"+RiskRedID+"','"+DOA+"','"+CadreProvider+"','"+UniqueID7+"','"+local.rs2.getString("timestamp")+"','"+qtr+"','"+year+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  
  local.state4.executeUpdate(inserter);  
   
 

 }   
    
}

//end of riskassessmentmain

System.out.println("**** to online database syncing before riskreduction details ");
String riskreddets="SELECT riskreductiondetails.ID as ID,riskreductiondetails.RiskReductionID as RiskReductionID ,    riskreductiondetails.QID as QID,  riskreductiondetails.currentStatus as currentStatus, riskreductiondetails.Action as Action,  riskreductiondetails.Appointments as Appointments, riskreductiondetails.timestamp as timestamp, riskreductiondetails.entrydate entrydate, riskreductiondetails.syncstatus as syncstatus FROM riskreductiondetails join riskreductionmain on riskreductionmain.RiskReductionID=riskreductiondetails.RiskReductionID  WHERE riskreductiondetails.RiskReductionID!='' and riskreductionmain.UniqueID='"+clouduniqid+"'  and riskreductiondetails.timestamp!='0000-00-00 00:00:00'";
online.rs2=online.state3.executeQuery(riskreddets);
while(online.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
    RiskAssessDetailID = online.rs2.getString(1);
    RiskReductionID = online.rs2.getString(2);
    QID = online.rs2.getString(3);
    currentStatus = online.rs2.getString(4);
    Action = online.rs2.getString(5);
    Appointments = online.rs2.getString(6);
    timestamp4 = online.rs2.getString("timestamp");
     
    System.out.println("entered "+RiskAssessDetailID);
       
 String check_if_exist="SELECT * FROM riskreductiondetails WHERE RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 


 }
 else {
  String inserter="REPLACE INTO riskreductiondetails(RiskReductionID,QID,currentStatus,Action,Appointments,entrydate)"
          + "VALUES('"+RiskReductionID+"','"+QID+"','"+currentStatus+"','"+Action+"','"+Appointments+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
 
  local.state4.executeUpdate(inserter);  
   
   
 }   
    
}
////// end of riskreductiondetails 
////
//

String riskassessdets="SELECT riskassessmentdetails.RiskAssessDetailID as RiskAssessDetailID, riskassessmentdetails.AssessmentID as  AssessmentID,riskassessmentdetails.QuestionID as QuestionID,riskassessmentdetails.DirectAnswers as DirectAnswers,riskassessmentdetails.CodedAnswers as CodedAnswers,riskassessmentdetails.timestamp as timestamp,riskassessmentdetails.entrydate as entrydate, riskassessmentdetails.syncstatus as syncstatus  FROM riskassessmentdetails join riskassessmentmain on riskassessmentdetails.AssessmentID=riskassessmentmain.AssessmentID  WHERE RiskAssessDetailID!='' and UniqueID='"+clouduniqid+"' and riskassessmentdetails.timestamp!='0000-00-00 00:00:00'";
online.rs2=online.state3.executeQuery(riskassessdets);
while(online.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         RiskAssessDetailID=online.rs2.getString(1);
         AssessmentID=online.rs2.getString(2);
         QuestionsID=online.rs2.getString(3);
         DirectAnswers=online.rs2.getString(4);
         CodedAnswers=online.rs2.getString(5);
         timestamp4=online.rs2.getString("timestamp");
       
      
       
 String check_if_exist="SELECT * FROM riskassessmentdetails WHERE AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 

 }
 else {
  String inserter="REPLACE INTO riskassessmentdetails(AssessmentID,QuestionID,DirectAnswers,CodedAnswers,entrydate)"
          + "VALUES('"+AssessmentID+"','"+QuestionsID+"','"+DirectAnswers+"','"+CodedAnswers+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  
  local.state4.executeUpdate(inserter);  

   
   
 }   
    
}
//// end of riskassessmentdetails 




String childage="SELECT * FROM childage WHERE ID!='' and UniqueID='"+clouduniqid+"'";
online.rs2=online.state3.executeQuery(childage);
while(online.rs2.next()){
    already_added=0;
    ID=ChildID=UniqueID2=AgeBrackets=NoChild=timestamp2="";
    
         ID=online.rs2.getString(1);
         ChildID=online.rs2.getString(2);
         UniqueID2=online.rs2.getString(3);
         AgeBrackets=online.rs2.getString(4);
         ChildNo=online.rs2.getString(5);
         timestamp2=online.rs2.getString(6);
       
 String check_if_exist="SELECT * FROM childage  WHERE ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     
     already_added=1; 
 
  System.out.println("check to see if update is necessary");
  
 
                             }
 else {
  String inserter="REPLACE INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,entrydate)"
          + "VALUES('"+ChildID+"','"+UniqueID2+"','"+AgeBrackets+"','"+NoChild+"','"+timestamp2+"')";
  
  System.out.println("_"+inserter+"\n");

   
   
 }   
    
}

//// end of child age 
//
//
//start of client member
String clientmember="SELECT * FROM clientmember WHERE ID!='' and UniqueID='"+clouduniqid+"'";
local.rs2=local.state3.executeQuery(clientmember);
while(local.rs2.next()){
   
    
    already_added=0;
    ID1=MemberID=UniqueID3=MemID=timestamp3="";
    
         ID=local.rs2.getString(1);
         MemberID=local.rs2.getString(2);
         UniqueID3=local.rs2.getString(3);
         MemID=local.rs2.getString(4);
         timestamp3=local.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientmember WHERE MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
   
  //check to see if you can update the data.  
     
 
// existingdata++;
 }
 else {
  String inserter="INSERT INTO clientmember(MemberID,UniqueID,MemID,entrydate)"
          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"')";
  
  System.out.println("_"+inserter+"\n");

  local.state4.executeUpdate(inserter);  
   
 
 }   
    
}
//
//
////end of clientmember 


////start of client member
String clientoccupation="SELECT * FROM clientoccupation WHERE ID!='' and UniqueID='"+clouduniqid+"'";
online.rs2=online.state3.executeQuery(clientoccupation);
while(online.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         ID2=online.rs2.getString(1);
         CoccID=online.rs2.getString(2);
         UniqueID4=online.rs2.getString(3);
         OccupationID=online.rs2.getString(4);
         timestamp4=online.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientoccupation WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("clientoccupation Data already added");

 
 }
 else {
  String inserter="REPLACE INTO clientoccupation(CoccID,UniqueID,OccupationID,entrydate)"
          + "VALUES('"+CoccID+"','"+UniqueID4+"','"+OccupationID+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");

  online.state4.executeUpdate(inserter);  
   
   
 
   
   
 }   
    
}
//// end of clientoccupation
//
//
////start of client op area
String clientoparea="SELECT * FROM clientoparea WHERE ID!='' and UniqueID='"+clouduniqid+"'";
online.rs2=online.state5.executeQuery(clientoparea);
while(online.rs2.next()){   
    
    already_added=0;
    ID3=COPID=UniqueID5=AreaOpID=timestamp5="";
    
         ID3=online.rs2.getString(1);
         COPID=online.rs2.getString(2);
         UniqueID5=online.rs2.getString(3);
         AreaOpID=online.rs2.getString(4);
         timestamp5=online.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientoparea WHERE COPID='"+COPID+"' AND UniqueID='"+UniqueID5+"' AND AreaOpID='"+AreaOpID+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 
 
  
 }
 else {
  String inserter="REPLACE INTO clientoparea(COPID,UniqueID,AreaOpID,entrydate)"
          + "VALUES('"+COPID+"','"+UniqueID5+"','"+AreaOpID+"','"+timestamp5+"')";
  
  System.out.println("_"+inserter+"\n");
  
  local.state4.executeUpdate(inserter);  
 
 
 }   
    
}

//
////END OF CLIENT OP AREA

String medical_form="SELECT * FROM medical_form WHERE unique_identifier='"+clouduniqid+"' ";
online.rs=online.state.executeQuery(medical_form);
while(online.rs.next()){
   
    
    already_added=0;
           id=unique_identifier=temperature=temperature_complain=blood_pressure=blood_pressure_complain=p=p_complain=weight=weightcomplain=ga=ga_findings
                   =skin=skin_findings=ent=ent_findings=eyes=eyes_findings=abdomen=abdomen_findings=genitourinary=genitourinary_findings=
           musculoskeletal=musculoskeletal_findings=respiratory=respiratory_findings=psychological=psychological_findings=diagnosis=management=
           referral=specify_others=TCA=cadre=dater=signature=timestamp6="";
    
         id=online.rs.getString(1);
         unique_identifier=online.rs.getString(2);
         temperature=online.rs.getString(3);
         temperature_complain=online.rs.getString(4);
         blood_pressure=online.rs.getString(5);
         blood_pressure_complain=online.rs.getString(6);
         p=online.rs.getString(7);
         p_complain=online.rs.getString(8);
         weight=online.rs.getString(9);
         weightcomplain=online.rs.getString(10);
         ga=online.rs.getString(11);
         ga_findings=online.rs.getString(12);
         skin=online.rs.getString(13); 
         skin_findings=online.rs.getString(14); 
         ent=online.rs.getString(15); 
         ent_findings=online.rs.getString(16); 
         eyes=online.rs.getString(17); 
         eyes_findings=online.rs.getString(18); 
         abdomen=online.rs.getString(19); 
         abdomen_findings=online.rs.getString(20); 
         genitourinary=online.rs.getString(21); 
         genitourinary_findings=online.rs.getString(22); 
         musculoskeletal=online.rs.getString(23); 
         musculoskeletal_findings=online.rs.getString(24); 
         respiratory=online.rs.getString(25); 
         respiratory_findings=online.rs.getString(26); 
         psychological=online.rs.getString(27);
         psychological_findings=online.rs.getString(28);
         diagnosis=online.rs.getString(29); 
         management=online.rs.getString(30); 
         referral=online.rs.getString(31); 
         specify_others=online.rs.getString(32); 
         TCA=online.rs.getString(33); 
         cadre=online.rs.getString(34); 
         dater=online.rs.getString(35); 
         signature=online.rs.getString(36); 
         timestamp6=online.rs.getString(37); 
  
 String check_if_exist="SELECT * FROM medical_form WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"'and temperature='"+temperature+"' AND temperature_complain='"+temperature_complain+"' AND blood_pressure='"+blood_pressure_complain+"' AND p='"+p+"'"
 + " AND p_complain='"+p_complain+"' AND weight_complain='"+weightcomplain+"' AND ga='"+ga+"' AND ga_findings='"+ga_findings+"' AND skin='"+skin+"'"
         + " AND skin_findings='"+skin_findings+"' AND ent='"+ent+"' AND ent_findings='"+ent_findings+"' AND eyes='"+eyes+"' AND "
         + "eyes_findings='"+eyes_findings+"' AND abdomen='"+abdomen+"'AND abdomen_findings='"+abdomen_findings+"'AND genitourinary='"+genitourinary+"'AND genitourinary_findings='"+genitourinary_findings+"'"
         + " AND musculoskeletal='"+musculoskeletal+"'AND musculoskeletal_findings='"+musculoskeletal_findings+"'AND respiratory='"+respiratory+"' AND respiratory_findings='"+respiratory_findings+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Data already added");

 //String updatesync="update medical_form set syncstatus='1' WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"' ";
 

 // local.state7.executeUpdate(updatesync);
  
 }
 else {
  String inserter="REPLACE INTO medical_form(unique_identifier,temperature,temperature_complain,blood_pressure,blood_pressure_complain,p,p_complain,weight"
          + ",weight_complain,ga,ga_findings,skin,skin_findings,ent,ent_findings,eyes,eyes_findings,"
          + "abdomen,abdomen_findings,genitourinary,genitourinary_findings," 
          +"musculoskeletal,musculoskeletal_findings,respiratory,respiratory_findings,psychological,psychological_findings,"
          + "diagnosis,management,referral,specify_others,TCA,cadre,dater,signature,entrydate)"
          + "VALUES('"+unique_identifier+"','"+temperature+"','"+temperature_complain+"','"+blood_pressure+"','"+blood_pressure_complain+"','"+p+"','"+p_complain+"','"+weight+"',"
          + "'"+weightcomplain+"','"+ga+"','"+ga_findings+"','"+skin+"','"+skin_findings+"','"+ent+"','"+ent_findings+"','"+eyes+"',"
          + "'"+eyes_findings+"','"+abdomen+"','"+abdomen_findings+"','"+genitourinary+"','"+genitourinary_findings+"','"+psychological+"','"+psychological_findings+"',"
          + "'"+musculoskeletal+"','"+musculoskeletal_findings+"','"+respiratory+"','"+respiratory_findings+"',"
          + "'"+diagnosis+"','"+management+"','"+referral+"','"+specify_others+"','"+TCA+"','"+cadre+"',"
          + "'"+dater+"','"+signature+"','"+timestamp6+"')"   ;
  

  local.state2.executeUpdate(inserter);  

   
 }   
    
}
//// END OF MEDICAL FORM 

   if(local.rs!=null){ local.rs.close();}
         if(local.rs1!=null){ local.rs1.close();}
         if(local.rs2!=null){ local.rs2.close();}
         if(local.rs3!=null){ local.rs3.close();}
         if(local.rs4!=null){ local.rs4.close();}
         if(local.rs5!=null){ local.rs5.close();}
         if(local.rs6!=null){ local.rs6.close();}
         if(local.rs7!=null){ local.rs7.close();}
        
         if(local.state!=null){ local.state.close();}
         if(local.state1!=null){ local.state1.close();}
         if(local.state2!=null){ local.state2.close();}
         if(local.state3!=null){ local.state3.close();}
         if(local.state4!=null){ local.state4.close();}
         if(local.state5!=null){ local.state5.close();}
         if(local.state6!=null){ local.state6.close();}
         if(local.state7!=null){ local.state7.close();}
 
    
         
         
         if(online.rs!=null){ online.rs.close();}
         if(online.rs1!=null){ online.rs1.close();}
         if(online.rs2!=null){ online.rs2.close();}
         if(online.rs3!=null){ online.rs3.close();}
         if(online.rs4!=null){ online.rs4.close();}
         if(online.rs5!=null){ online.rs5.close();}
         if(online.rs6!=null){ online.rs6.close();}
         if(online.rs7!=null){ online.rs7.close();}
        
         if(online.state!=null){ online.state.close();}
         if(online.state1!=null){ online.state1.close();}
         if(online.state2!=null){ online.state2.close();}
         if(online.state3!=null){ online.state3.close();}
         if(online.state4!=null){ online.state4.close();}
         if(online.state5!=null){ online.state5.close();}
         if(online.state6!=null){ online.state6.close();}
         if(online.state7!=null){ online.state7.close();}

    } catch (SQLException ex) {
        Logger.getLogger(SyncMissingData.class.getName()).log(Level.SEVERE, null, ex);
        returnmsg=false;
    }
    
    
    //===============================end of the return formulae
    
     return returnmsg;
   } 
}