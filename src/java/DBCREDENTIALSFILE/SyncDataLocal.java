/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBCREDENTIALSFILE;

import dbConnect.AES;
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
public class SyncDataLocal extends HttpServlet {

  

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
        
        
dbConnect local = new dbConnect();
dbConnectTemp online = new dbConnectTemp();

System.out.println("Merging Data to from ONLINE from LOCAL ");
audits=enrollments=childages=clientmembers=clientoccupations=clientopareas=dummys=medical_forms=riskassessmentdetail=riskassessmentmains=riskreductiondetails=riskreductionmains=taskauditors=users=0;
//read data from the new database-indicatoractivities1 
//

// END OF AUDIT 
//
// BEGINING OF ENROLMENT
//
String enrollment="SELECT * FROM enrollment WHERE UniqueID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00'";
online.rs=online.state6.executeQuery(enrollment);
while(online.rs.next()){
   
    
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
        biometric = online.rs.getString("fingerprint");
         ward=online.rs.getString("ward");
 String check_if_exist="SELECT * FROM enrollment where OperationArea='"+OperationArea+"'"
         + " AND Occupation='"+Occupation+"'AND MemberOfID='"+MemberOfID+"'";
 
  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 

      
 String inserter="UPDATE enrollment set ward='"+ward+"',capturedhand='"+hand+"',fingerprint='"+biometric+"' where  AgeID='"+AgeID+"'"
         + " AND Religion='"+Religion+"' AND EducationLevel='"+EducationLevel+"'AND PhoneNo='"+PhoneNo+"' "
         + "AND MemberOfID='"+MemberOfID+"' AND  UniqueID='"+UniqueIDs+"'";
            System.out.println(inserter)   ;
   if(ward!=null && !ward.equals("") && hand!=null && !hand.equals("") && biometric!=null && !biometric.equals("")){
          local.state5.executeUpdate(inserter);
  System.out.println("Data already added");
  String updatesync="update enrollment set syncstatus='1' where UniqueID='"+UniqueIDs+"'"; 
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);

 existingdata++;}
 
 }
 else {
     
     
                    String firstname = FirstName;
                     String secondname = SecondName;
                     String lastname = LastName;
                     String phoneno = PhoneNo;
                     String fingerprints = biometric;
                    

  String inserter="REPLACE INTO enrollment(UniqueID,ClientInit,DOE,District,DICName,Ward,DOB,Sex,Age,MaritalStatus,Children,ChildNo,Religion,EducationLevel,PhoneNo,Residence,OperationArea,Occupation,MemberOfID,DICLearn,Email,PhoneNo1,Venue,AgeID,FirstName,SecondName,LastName,venueOther,DicLearnOther,Pefar_year,capturedhand,fingerprint)"
          + "VALUES('"+UniqueIDs+"','"+ClientInit+"','"+DOE+"','"+District+"','"+DICName+"','"+ward+"','"+DOB+"','"+Sex+"','"+Age+"','"+MaritalStatus+"','"+Children+"','"+ChildNo+"','"+Religion+"','"+EducationLevel+"','"+PhoneNo+"','"+Residence+"','"+OperationArea+"',"
          + "'"+Occupation+"','"+MemberOfID+"','"+DICLearn+"','"+Email+"','"+PhoneNo1+"','"+Venue+"','"+AgeID+"','"+FirstName+"','"+SecondName+"','"+LastName+"','"+venueOther+"','"+DicLearnOther+"','"+enrollpefar_year+"','"+hand+"','"+biometric+"')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state2.executeUpdate(inserter);  
  enrollments++;
  String updatesync="update enrollment set syncstatus='1' where UniqueID='"+UniqueIDs+"'"; 
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
   
 }   
    
}

// end of enrollment 

//// start of childage
//
//

//start of risk assessment main
String riskasesmain="SELECT * FROM riskassessmentmain WHERE ID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00'";
online.rs2=online.state3.executeQuery(riskasesmain);

String ward1="";
String county1="";
String Dicname1="";
while(online.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    String Quarter,Month,Pefar_year="";
          ID2=online.rs2.getString("ID");
         AssessID=online.rs2.getString("AssessmentID");
         AssessmentDate=online.rs2.getString("AssessmentDate");
         UniqueID6=online.rs2.getString("UniqueID");
         county1=online.rs2.getString("County1");
         Dicname1=online.rs2.getString("DICName1");
         ward=online.rs2.getString("ward1");
         timestamp4=online.rs2.getString("timestamp");
         Quarter=online.rs2.getString("Quarter");
         Month=online.rs2.getString("Month");
         Pefar_year=online.rs2.getString("Pefar_year");
        
      
       
 String check_if_exist="SELECT * FROM riskassessmentmain WHERE AssessmentID='"+AssessID+"' AND AssessmentDate='"+AssessmentDate+"'  ";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update riskassessmentmain set syncstatus='1' WHERE ID='"+ID2+"'and AssessmentID='"+AssessID+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 existingdata++;
 
 }
 else {
  String inserter="REPLACE INTO riskassessmentmain(AssessmentID,AssessmentDate,UniqueID,Quarter,Month,Pefar_year,entrydate,County1,DICName1,ward1)"
          + "VALUES('"+AssessID+"','"+AssessmentDate+"','"+UniqueID6+"','"+Quarter+"','"+Month+"','"+Pefar_year+"','"+timestamp4+"','"+county1+"','"+Dicname1+"','"+ward+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   
   
   riskassessmentmains++;
   
   
   String updatesync="update riskassessmentmain set syncstatus='1' WHERE ID='"+ID2+"'and AssessmentID='"+AssessID+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }   
    
}
//start of risk reduction main
String riskredmain="SELECT * FROM riskreductionmain WHERE ID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00' ORDER BY DOA DESC";
online.rs2=online.state3.executeQuery(riskredmain);
while(online.rs2.next()){
   
    
    already_added=0;
    RiskRedID=DOA=CadreProvider=UniqueID7=timestamp4="";
    String qtr="";
    String year="";
         RiskRedID=online.rs2.getString("RiskReductionID");
         DOA=online.rs2.getString("DOA");
         CadreProvider=online.rs2.getString("CadreProvider");
         UniqueID7=online.rs2.getString("UniqueID");
         timestamp4=online.rs2.getString("timestamp");
         qtr=online.rs2.getString("qtr");
         year=online.rs2.getString("year");
      
        //added later 201510
         county1=online.rs2.getString("County1");
         Dicname1=online.rs2.getString("DICName1");
         ward=online.rs2.getString("ward1");
      
       
 String check_if_exist="SELECT * FROM riskreductionmain WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ORDER BY DOA DESC";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update riskreductionmain set syncstatus='1' WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskreductionmain(RiskReductionID,DOA,CadreProvider,UniqueID,entrydate,qtr,year, County1, DICName1, ward1)"
          + "VALUES('"+RiskRedID+"','"+DOA+"','"+CadreProvider+"','"+UniqueID7+"','"+online.rs2.getString("timestamp")+"','"+qtr+"','"+year+"','"+county1+"','"+Dicname1+"','"+ward+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   
   riskreductionmains++;
   
   
   String updatesync="update riskreductionmain set syncstatus='1' WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }   
    
}

//end of riskassessmentmain

System.out.println(" to local databse from onle before riskreduction details ");
String riskreddets="SELECT * FROM riskreductiondetails WHERE RiskReductionID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00' ORDER BY  RiskReductionID DESC limit 5000";
online.rs2=online.state3.executeQuery(riskreddets);
while(online.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         RiskAssessDetailID=online.rs2.getString(1);
         RiskReductionID=online.rs2.getString(2);
         QID=online.rs2.getString(3);
         currentStatus=online.rs2.getString(4);
         Action=online.rs2.getString(5);
         Appointments=online.rs2.getString(6);
       timestamp4=online.rs2.getString("timestamp");
      System.out.println("entered "+RiskAssessDetailID);
       
 String check_if_exist="SELECT * FROM riskreductiondetails WHERE RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update riskreductiondetails set syncstatus='1' WHERE ID='"+RiskAssessDetailID+"' and RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskreductiondetails(RiskReductionID,QID,currentStatus,Action,Appointments)"
          + "VALUES('"+RiskReductionID+"','"+QID+"','"+currentStatus+"','"+Action+"','"+Appointments+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
  
   riskreductiondetails++;  
   
   
    String updatesync="update riskreductiondetails set syncstatus='1' WHERE ID='"+RiskAssessDetailID+"' and RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
   
 }   
    
}
////// end of riskreductiondetails 
////
//

String riskassessdets="SELECT * FROM riskassessmentdetails WHERE RiskAssessDetailID!='' and syncstatus=0 and timestamp!='0000-00-00 00:00:00'  order by RiskAssessDetailID desc limit 5000";
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
 
     String updatesync="update riskassessmentdetails set syncstatus='1'  WHERE RiskAssessDetailID='"+RiskAssessDetailID+"'and  AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskassessmentdetails(AssessmentID,QuestionID,DirectAnswers,CodedAnswers,entrydate)"
          + "VALUES('"+AssessmentID+"','"+QuestionsID+"','"+DirectAnswers+"','"+CodedAnswers+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   
   riskassessmentdetail++;
   
   
     String updatesync="update riskassessmentdetails set syncstatus='1'  WHERE RiskAssessDetailID='"+RiskAssessDetailID+"'and  AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
   
 }   
    
}
//// end of riskassessmentdetails 




String childage="SELECT * FROM childage WHERE ID!='' and syncstatus='0' order by ID desc limit 5000 ";
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
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
  String updatesync="update childage set syncstatus='1' where ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);  
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,timestamp)"
          + "VALUES('"+ChildID+"','"+UniqueID2+"','"+AgeBrackets+"','"+NoChild+"','"+timestamp2+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  //local.state4.executeUpdate(inserter);  
  childages++; 
  String updatesync="update childage set syncstatus='1' where ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);  
   
 }   
    
}

//// end of child age 
//
//
//start of client member
String clientmember="SELECT * FROM clientmember WHERE ID!='' and syncstatus='0' ORDER BY  ID DESC limit 5000";
online.rs2=online.state3.executeQuery(clientmember);
while(online.rs2.next()){
   
    
    already_added=0;
    ID1=MemberID=UniqueID3=MemID=timestamp3="";
    
         ID=online.rs2.getString(1);
         MemberID=online.rs2.getString(2);
         UniqueID3=online.rs2.getString(3);
         MemID=online.rs2.getString(4);
         timestamp3=online.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientmember WHERE MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
    already_added=1; 
     String updatesync="update clientmember set syncstatus='1' where MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
// 
// String inserter="REPLACE INTO clientmember(MemberID,UniqueID,MemID,timestamp)"
//          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"')";
//  
//  System.out.println("_"+inserter+"\n");
//  numberofqueries++;
//  local.state4.executeUpdate(inserter);  
// existingdata++;
 }
 else {
  String inserter="INSERT INTO clientmember(MemberID,UniqueID,MemID,timestamp)"
          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   clientmembers++;
   
   String updatesync="update clientmember set syncstatus='1' where MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}
//
//
////end of clientmember 


//start of clientoccupation


////start of client member
String clientoccupation="SELECT * FROM clientoccupation WHERE ID!='' and syncstatus='0' ORDER BY  ID DESC limit 5000";
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
 
  System.out.println("Clerk Data already added");
 existingdata++;
  String updatesync="update clientoccupation set syncstatus='1' WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }
 else {
  String inserter="REPLACE INTO clientoccupation(CoccID,UniqueID,OccupationID)"
          + "VALUES('"+CoccID+"','"+UniqueID4+"','"+OccupationID+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   
   
   clientoccupations++;
   
  String updatesync="update clientoccupation set syncstatus='1' WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
   
 }   
    
}
//// end of clientoccupation
//
//
////start of client op area
String clientoparea="SELECT * FROM clientoparea WHERE ID!='' and syncstatus='0' ORDER BY  ID DESC limit 5000";
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
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 String updatesync="update clientoparea set syncstatus='1' WHERE ID='"+ID3+"' and  COPID='"+COPID+"' ";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }
 else {
  String inserter="REPLACE INTO clientoparea(COPID,UniqueID,AreaOpID,timestamp)"
          + "VALUES('"+COPID+"','"+UniqueID5+"','"+AreaOpID+"','"+timestamp5+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   clientopareas++;
   
   String updatesync="update clientoparea set syncstatus='1' WHERE ID='"+ID3+"' and  COPID='"+COPID+"' ";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
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
String medical_form="SELECT * FROM medical_form WHERE unique_identifier!='' and syncstatus='0' ORDER BY  ID DESC limit 5000";
online.rs=online.state.executeQuery(medical_form);
while(online.rs.next()){
   
    
    already_added=0;
           id=unique_identifier=temperature=temperature_complain=blood_pressure=blood_pressure_complain=p=p_complain=weight=weightcomplain=ga=ga_findings
                   =skin=skin_findings=ent=ent_findings=eyes=eyes_findings=abdomen=abdomen_findings=genitourinary=genitourinary_findings=
           musculoskeletal=musculoskeletal_findings=respiratory=respiratory_findings=psychological=psychological_findings=diagnosis=management=
           referral=specify_others=TCA=cadre=dater=signature=timestamp6="";
    
          id=online.rs.getString("id");
         unique_identifier=online.rs.getString("unique_identifier");
         temperature=online.rs.getString("temperature");
         temperature_complain=online.rs.getString("temperature_complain");
         blood_pressure=online.rs.getString("blood_pressure");
         blood_pressure_complain=online.rs.getString("blood_pressure_complain");
         p=online.rs.getString("p");
         p_complain=online.rs.getString("p_complain");
         weight=online.rs.getString("weight");
         weightcomplain=online.rs.getString("weight_complain");
         ga=online.rs.getString("ga");
         ga_findings=online.rs.getString("ga_findings");
         skin=online.rs.getString("skin"); 
         skin_findings=online.rs.getString("skin_findings"); 
         ent=online.rs.getString("ent"); 
         ent_findings=online.rs.getString("ent_findings"); 
         eyes=online.rs.getString("eyes"); 
         eyes_findings=online.rs.getString("eyes_findings"); 
         abdomen=online.rs.getString("abdomen"); 
         abdomen_findings=online.rs.getString("abdomen_findings"); 
         genitourinary=online.rs.getString("genitourinary"); 
         genitourinary_findings=online.rs.getString("genitourinary_findings"); 
         musculoskeletal=online.rs.getString("musculoskeletal"); 
         musculoskeletal_findings=online.rs.getString("musculoskeletal_findings"); 
         respiratory=online.rs.getString("respiratory"); 
         respiratory_findings=online.rs.getString("respiratory_findings"); 
         psychological=online.rs.getString("psychological");
         psychological_findings=online.rs.getString("psychological_findings");
         diagnosis=online.rs.getString("diagnosis"); 
         management=online.rs.getString("management"); 
         referral=online.rs.getString("referral"); 
         specify_others=online.rs.getString("specify_others"); 
         TCA=online.rs.getString("TCA"); 
         cadre=online.rs.getString(cadre); 
         dater=online.rs.getString("dater"); 
         signature=online.rs.getString("signature"); 
         timestamp6=online.rs.getString("timestamp"); 
  
         
          //added later 201510
         county1=online.rs2.getString("County1");
         Dicname1=online.rs2.getString("DICName1");
         ward=online.rs2.getString("ward1");
        
  
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
 existingdata++;
 String updatesync="update medical_form set syncstatus='1' WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"' ";
 

  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }
 else {
  String inserter="REPLACE INTO medical_form(unique_identifier,temperature,temperature_complain,blood_pressure,blood_pressure_complain,p,p_complain,weight"
          + ",weight_complain,ga,ga_findings,skin,skin_findings,ent,ent_findings,eyes,eyes_findings,"
          + "abdomen,abdomen_findings,genitourinary,genitourinary_findings," 
          +"musculoskeletal,musculoskeletal_findings,respiratory,respiratory_findings,psychological,psychological_findings,"
          + "diagnosis,management,referral,specify_others,TCA,cadre,dater,signature,timestamp,county1, DICName1,  ward1)"
          + "VALUES('"+unique_identifier+"','"+temperature+"','"+temperature_complain+"','"+blood_pressure+"','"+blood_pressure_complain+"','"+p+"','"+p_complain+"','"+weight+"',"
          + "'"+weightcomplain+"','"+ga+"','"+ga_findings+"','"+skin+"','"+skin_findings+"','"+ent+"','"+ent_findings+"','"+eyes+"',"
          + "'"+eyes_findings+"','"+abdomen+"','"+abdomen_findings+"','"+genitourinary+"','"+genitourinary_findings+"','"+psychological+"','"+psychological_findings+"',"
          + "'"+musculoskeletal+"','"+musculoskeletal_findings+"','"+respiratory+"','"+respiratory_findings+"',"
          + "'"+diagnosis+"','"+management+"','"+referral+"','"+specify_others+"','"+TCA+"','"+cadre+"',"
          + "'"+dater+"','"+signature+"','"+timestamp6+"','"+county1+"','"+Dicname1+"','"+ward+"')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state2.executeUpdate(inserter);  
   
   medical_forms++;
 
   
     String updatesync="update medical_form set syncstatus='1' WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"' ";
 

  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
   
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


String selector="SELECT * FROM audit WHERE AuditID!='' and syncstatus='0'";
online.rs=online.state.executeQuery(selector);
while(online.rs.next()){
   
    
    already_added=0;
    AuditID=UniqueID=DrnkAlc=AlchHav=DrnkOcc=StpDrnk=FailDrnk=RemHap=NeedAlc=GuiltDrnk=InjureDrnk=
            FriendDrnk=DrnkAlctxt=AlcHavtxt=DrnkOcctxt=StpDrnktxt=FailDrnktxt=RemHaptxt=NeedAlctxt
            =GuiltDrnktxt=InjureDrnktxt=FriendDrnktxt=FinalAudit=""; 
    
         AuditID=online.rs.getString(1);
         UniqueID=online.rs.getString(2);
         DrnkAlc=online.rs.getString(3);
         AlchHav=online.rs.getString(4);
         DrnkOcc=online.rs.getString(5);
         StpDrnk=online.rs.getString(6);
         FailDrnk=online.rs.getString(7);
         RemHap=online.rs.getString(8);
         NeedAlc=online.rs.getString(9);
         GuiltDrnk=online.rs.getString(10);
         InjureDrnk=online.rs.getString(11); 
         FriendDrnk=online.rs.getString(12); 
         DrnkAlctxt=online.rs.getString(13); 
         AlcHavtxt=online.rs.getString(14); 
         DrnkOcctxt=online.rs.getString(15); 
         StpDrnktxt=online.rs.getString(16); 
         FailDrnktxt=online.rs.getString(17); 
         RemHaptxt=online.rs.getString(18); 
         NeedAlctxt=online.rs.getString(19); 
         GuiltDrnktxt=online.rs.getString(20); 
         InjureDrnktxt=online.rs.getString(21); 
         FriendDrnktxt=online.rs.getString(22); 
         FinalAudit=online.rs.getString(23); 
         timestamp=online.rs.getTimestamp(24).toString(); 
  
 String check_if_exist="SELECT * FROM audit WHERE UniqueID='"+UniqueID+"'AND DrnkAlc='"+DrnkAlc+"' AND AlchHav='"+AlchHav+"' AND DrnkOcc='"+DrnkOcc+"' AND StpDrnk='"+StpDrnk+"'"
 + " AND FailDrnk='"+FailDrnk+"' AND RemHap='"+RemHap+"' AND NeedAlc='"+NeedAlc+"' AND GuiltDrnk='"+GuiltDrnk+"' AND InjureDrnk='"+InjureDrnk+"'"
         + " AND FriendDrnk='"+FriendDrnk+"' AND DrnkAlctxt='"+DrnkAlctxt+"' AND AlchHavtxt='"+AlcHavtxt+"' AND DrnkOcctxt='"+DrnkOcctxt+"' AND "
         + "StpDrnktxt='"+StpDrnktxt+"' AND FailDrnktxt='"+FailDrnktxt+"'AND RemHaptxt='"+RemHaptxt+"'AND NeedAlctxt='"+NeedAlctxt+"'AND GuiltDrnktxt='"+GuiltDrnktxt+"'"
         + " AND InjureDrnktxt='"+InjureDrnktxt+"'AND FriendDrnktxt='"+FriendDrnktxt+"'AND FinalAudit='"+FinalAudit+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 
  String updatesync="update audit set syncstatus='1' WHERE UniqueID='"+UniqueID+"'AND DrnkAlc='"+DrnkAlc+"' AND AlchHav='"+AlchHav+"' AND DrnkOcc='"+DrnkOcc+"' AND StpDrnk='"+StpDrnk+"'"
 + " AND FailDrnk='"+FailDrnk+"' AND RemHap='"+RemHap+"' AND NeedAlc='"+NeedAlc+"' AND GuiltDrnk='"+GuiltDrnk+"' AND InjureDrnk='"+InjureDrnk+"'"
         + " AND FriendDrnk='"+FriendDrnk+"' AND DrnkAlctxt='"+DrnkAlctxt+"' AND AlchHavtxt='"+AlcHavtxt+"' AND DrnkOcctxt='"+DrnkOcctxt+"' AND "
         + "StpDrnktxt='"+StpDrnktxt+"' AND FailDrnktxt='"+FailDrnktxt+"'AND RemHaptxt='"+RemHaptxt+"'AND NeedAlctxt='"+NeedAlctxt+"'AND GuiltDrnktxt='"+GuiltDrnktxt+"'"
         + " AND InjureDrnktxt='"+InjureDrnktxt+"'AND FriendDrnktxt='"+FriendDrnktxt+"'AND FinalAudit='"+FinalAudit+"'";
online.state7.executeUpdate(updatesync);
  System.out.println("Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO audit (UniqueID,DrnkAlc,AlchHav,DrnkOcc,StpDrnk,FailDrnk,RemHap,NeedAlc,GuiltDrnk,InjureDrnk,FriendDrnk,DrnkAlctxt,AlchHavtxt,DrnkOcctxt,StpDrnktxt,"
          + "FailDrnktxt,RemHaptxt,NeedAlctxt,GuiltDrnktxt,InjureDrnktxt,FriendDrnktxt,FinalAudit,timestamp)"
          + "VALUES('"+UniqueID+"','"+DrnkAlc+"','"+AlchHav+"','"+DrnkOcc+"','"+StpDrnk+"','"+FailDrnk+"','"+RemHap+"','"+NeedAlc+"','"+GuiltDrnk+"','"+InjureDrnk+"','"+FriendDrnk+"','"+DrnkAlctxt+"','"+AlcHavtxt+"','"+DrnkOcctxt+"','"+StpDrnktxt+"','"+FailDrnktxt+"','"+RemHaptxt+"','"+NeedAlctxt+"','"+GuiltDrnktxt+"','"+InjureDrnktxt+"','"+FriendDrnktxt+"','"+FinalAudit+"','"+timestamp+"')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state2.executeUpdate(inserter);  
   audits++;
 
   
    String updatesync="update audit set syncstatus='1' WHERE UniqueID='"+UniqueID+"'AND DrnkAlc='"+DrnkAlc+"' AND AlchHav='"+AlchHav+"' AND DrnkOcc='"+DrnkOcc+"' AND StpDrnk='"+StpDrnk+"'"
 + " AND FailDrnk='"+FailDrnk+"' AND RemHap='"+RemHap+"' AND NeedAlc='"+NeedAlc+"' AND GuiltDrnk='"+GuiltDrnk+"' AND InjureDrnk='"+InjureDrnk+"'"
         + " AND FriendDrnk='"+FriendDrnk+"' AND DrnkAlctxt='"+DrnkAlctxt+"' AND AlchHavtxt='"+AlcHavtxt+"' AND DrnkOcctxt='"+DrnkOcctxt+"' AND "
         + "StpDrnktxt='"+StpDrnktxt+"' AND FailDrnktxt='"+FailDrnktxt+"'AND RemHaptxt='"+RemHaptxt+"'AND NeedAlctxt='"+NeedAlctxt+"'AND GuiltDrnktxt='"+GuiltDrnktxt+"'"
         + " AND InjureDrnktxt='"+InjureDrnktxt+"'AND FriendDrnktxt='"+FriendDrnktxt+"'AND FinalAudit='"+FinalAudit+"'";

  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}





//start of taskauditor
String taskauditor="SELECT * FROM taskauditor WHERE audit!='' and syncstatus='0'";
online.rs2=online.state3.executeQuery(taskauditor);
while(online.rs2.next()){
   
    
    already_added=0;
    hostcomp=action=time=username=timestamp11="";
    
         hostcomp=online.rs2.getString(2);
         action=online.rs2.getString(3);
         time=online.rs2.getString(4);
         username=online.rs2.getString(5);
         timestamp11=online.rs2.getString(6);
        
      
       
 String check_if_exist="SELECT * FROM taskauditor WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update taskauditor set syncstatus='1' WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO taskauditor(host_comp,action,time,username,timestamp)"
          + "VALUES('"+hostcomp+"','"+action.replace("'", " ")+"','"+time+"','"+username+"','"+timestamp11+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   
   taskauditors++;
   
   
    String updatesync="update taskauditor set syncstatus='1' WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}

//end of task auditor 

////
////start of user
String user="SELECT * FROM user WHERE UserID!='' and syncstatus='0'";
online.rs2=online.state3.executeQuery(user);
while(online.rs2.next()){
   
    
    already_added=0;
    Name=Username=Password=PhoneNos=Email=Location=AccessLevel=timestamp12="";
    
         Name=online.rs2.getString(2);
         Username=online.rs2.getString(3);
         Password=online.rs2.getString(4);
         PhoneNos=online.rs2.getString(5);
         Email=online.rs2.getString(6);
         Location=online.rs2.getString(7);
         AccessLevel=online.rs2.getString(8);
         timestamp12=online.rs2.getString(9);
        
      
       
 String check_if_exist="SELECT * FROM user WHERE Name='"+Name+"' AND Username='"+Username+"' AND Password='"+Password+"' AND PhoneNo='"+PhoneNos+"' AND Email='"+Email+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO user(Name,Username,Password,PhoneNo,Email,Location,AccessLevel,timestamp)"
          + "VALUES('"+Name+"','"+Username+"','"+Password+"','"+PhoneNos+"','"+Email+"','"+Location+"','"+AccessLevel+"','"+timestamp12+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  local.state4.executeUpdate(inserter);  
   
   
   users++;
   
   
    String updatesync="update user set syncstatus='1' WHERE Name='"+Name+"' AND Username='"+Username+"' AND Password='"+Password+"' AND PhoneNo='"+PhoneNos+"' AND Email='"+Email+"'";
  online.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}
//
////end of task auditor
//
//
//


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

//since syncing has ended, Now start or end thread
itc.syncingstatus=false;

return true;

//session.setAttribute("msg", wholemsg);

}



}
