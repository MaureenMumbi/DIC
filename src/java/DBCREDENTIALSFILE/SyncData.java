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
        
        
dbConnectTemp online = new dbConnectTemp();
dbConnect local = new dbConnect();

System.out.println("Merging Data TO ONLINE DATABASE");
audits=enrollments=childages=clientmembers=clientoccupations=clientopareas=dummys=medical_forms=riskassessmentdetail=riskassessmentmains=riskreductiondetails=riskreductionmains=taskauditors=users=0;
//read data from the new database-indicatoractivities1 
//

// END OF AUDIT 
//
// BEGINING OF ENROLMENT
//
String enrollment="SELECT * FROM enrollment WHERE UniqueID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00'";
local.rs=local.state6.executeQuery(enrollment);
while(local.rs.next()){
   
    
    already_added=0;
  UniqueIDs=ClientInit=DOE=District=DICName=DOB=Sex=Age=MaritalStatus=Children=ChildNo=Religion=
  EducationLevel=PhoneNo=Residence=OperationArea=Occupation=MemberOfID=DICLearn=Email=PhoneNo1=Venue=AgeID=FirstName=SecondName=LastName=venueOther=DicLearnOther=timestamp1=hand=biometric=""; 
  ward=enrollpefar_year="";
        
         UniqueIDs=local.rs.getString("UniqueID");
         ClientInit=local.rs.getString("ClientInit");
         DOE=local.rs.getString("DOE");
         District=local.rs.getString("District");
         DICName=local.rs.getString("DICName");
         DOB=local.rs.getString("DOB");
         Sex=local.rs.getString("Sex");
         Age=local.rs.getString("Age");
         MaritalStatus=local.rs.getString("MaritalStatus");
         Children=local.rs.getString("Children");
         ChildNo=local.rs.getString("ChildNo");
         Religion=local.rs.getString("Religion"); 
         EducationLevel=local.rs.getString("EducationLevel"); 
         PhoneNo=local.rs.getString("PhoneNo"); 
         Residence=local.rs.getString("Residence"); 
         OperationArea=local.rs.getString("OperationArea"); 
         Occupation=local.rs.getString("Occupation"); 
         MemberOfID=local.rs.getString("MemberOfID"); 
         DICLearn=local.rs.getString("DICLearn"); 
         Email=local.rs.getString("Email"); 
         PhoneNo1=local.rs.getString("PhoneNo1"); 
         Venue=local.rs.getString("Venue"); 
         AgeID=local.rs.getString("AgeID"); 
         FirstName=local.rs.getString("FirstName"); 
         SecondName=local.rs.getString("SecondName"); 
         LastName=local.rs.getString("LastName"); 
         venueOther=local.rs.getString("venueOther"); 
         DicLearnOther=local.rs.getString("DicLearnOther");
         enrollpefar_year=local.rs.getString("Pefar_year");
        timestamp = local.rs.getString("timestamp");
        hand = local.rs.getString("capturedhand");
        biometric = local.rs.getString("fingerprint");
         ward=local.rs.getString("ward");
 String check_if_exist="SELECT * FROM enrollment where OperationArea='"+OperationArea+"'"
         + " AND Occupation='"+Occupation+"'AND MemberOfID='"+MemberOfID+"'";
 
  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){
     already_added=1; 
// String inserter="UPDATE enrollment set UniqueID='"+UniqueIDs+"',ClientInit='"+ClientInit+"',DOE='"+DOE+"',District='"+District+"',DICName='"+DICName+"',DOB='"+DOB+"',Sex='"+Sex+"',Age='"+Age+"',"
//         + "MaritalStatus='"+MaritalStatus+"',Children='"+Children+"',ChildNo='"+ChildNo+"',Religion='"+Religion+"',EducationLevel='"+EducationLevel+"',PhoneNo='"+PhoneNo+"',Residence='"+Residence+"',"
//         + "OperationArea='"+OperationArea+"',Occupation='"+Occupation+"',MemberOfID='"+MemberOfID+"',DICLearn='"+DICLearn+"',Email='"+Email+"',PhoneNo1='"+PhoneNo1+"',Venue='"+Venue+"',AgeID='"+AgeID+"',"
//         + "FirstName='"+FirstName+"',SecondName='"+SecondName+"',LastName='"+LastName+"',venueOther='"+venueOther+"',DicLearnOther='"+DicLearnOther+"',capturedhand='"+hand+"',fingerprint='"+biometric+"' where  AgeID='"+AgeID+"'"
//         + " AND Religion='"+Religion+"' AND EducationLevel='"+EducationLevel+"'AND PhoneNo='"+PhoneNo+"' "
//         + "AND MemberOfID='"+MemberOfID+"'";
 
      String biofing="";
      
        
                   
//                     final  String strPssword ="?*1>9@(&#";    
//              AES.setKey(strPssword);
//                     if(biometric!=null && !biometric.trim().equals("") && !biometric.equals("null")){
//                    
//                    
//                      AES.encrypt (biometric.trim());
//                    System.out.println("String to Encrypt:_______+++++++ " + biometric); 
//                   System.out.println("Encrypted:_______+++++++ " + AES.getEncryptedString());
//                    biofing=AES.getEncryptedString();
//                     }
//                     else{
//                     biofing="";}
     
     
     String inserter="UPDATE enrollment set ward='"+ward+"',capturedhand='"+hand+"',fingerprint='"+biometric+"' where  AgeID='"+AgeID+"'"
         + " AND Religion='"+Religion+"' AND EducationLevel='"+EducationLevel+"'AND PhoneNo='"+PhoneNo+"' "
         + "AND MemberOfID='"+MemberOfID+"' AND  UniqueID='"+UniqueIDs+"'";
            System.out.println(inserter)   ;
   if(ward!=null && !ward.equals("") && hand!=null && !hand.equals("") && biometric!=null && !biometric.equals("")){
          online.state5.executeUpdate(inserter);
  System.out.println("Data already added");
  String updatesync="update enrollment set syncstatus='1' where UniqueID='"+UniqueIDs+"'"; 
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
//  System.out.println("_"+inserter+"\n");
 existingdata++;}
 }
 else {
     
     
                    String firstname = FirstName;
                     String secondname = SecondName;
                     String lastname = LastName;
                     String phoneno = PhoneNo;
                     String fingerprints = biometric;
                    
                  
//                    String first="";
//                     final  String strPssword ="?*1>9@(&#";    
//              AES.setKey(strPssword);
//                    if(firstname!=null && !firstname.trim().equals("") && !firstname.equals("null")){
//                       AES.encrypt (firstname.trim());
//                        System.out.println("Encrypted______________________: " + firstname);
//                   
//                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
//                      first= AES.getEncryptedString();
//            }
//                    
//                    //middle name encrypt
//                      String midname="";
//                     if(secondname!=null && !secondname.trim().equals("") && !secondname.equals("null")){
//                     AES.encrypt (secondname.trim());
//                        System.out.println("Encrypted______________________: " + secondname);
//                   
//                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
//                      midname=AES.getEncryptedString();
//                     }
//                     //last name encrypt
//                     String lasname="";
//                      if(lastname!=null && !lastname.trim().equals("") && !lastname.equals("null")){
//                     AES.encrypt (lastname.trim());
//                        System.out.println("Encrypted______________________: " + lastname);
//                   
//                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
//                      lasname= AES.getEncryptedString();
//                      }
//                      String phone="";
//                     if(phoneno!=null && !phoneno.trim().equals("") && !phoneno.equals("null")){
//                     AES.encrypt (phoneno.trim());
//                      System.out.println("String to Encrypt:_______****(**** " + phoneno); 
//                    System.out.println("Encrypted:________******** " + AES.getEncryptedString());
//                    
//                     phone= AES.getEncryptedString();
//                     } 
//                     String biofing="";
//                     if(fingerprints!=null && !fingerprints.trim().equals("") && !fingerprints.equals("null")){
//                    
//                    
//                      AES.encrypt (fingerprints.trim());
//                    System.out.println("String to Encrypt:_______+++++++ " + fingerprints); 
//                   System.out.println("Encrypted:_______+++++++ " + AES.getEncryptedString());
//                    biofing=AES.getEncryptedString();
//                     }
//                     else{
//                     biofing="";}
  String inserter="REPLACE INTO enrollment(UniqueID,ClientInit,DOE,District,DICName,Ward,DOB,Sex,Age,MaritalStatus,Children,ChildNo,Religion,EducationLevel,PhoneNo,Residence,OperationArea,Occupation,MemberOfID,DICLearn,Email,PhoneNo1,Venue,AgeID,FirstName,SecondName,LastName,venueOther,DicLearnOther,Pefar_year,capturedhand,fingerprint,entrydate)"
          + "VALUES('"+UniqueIDs+"','"+ClientInit+"','"+DOE+"','"+District+"','"+DICName+"','"+ward+"','"+DOB+"','"+Sex+"','"+Age+"','"+MaritalStatus+"','"+Children+"','"+ChildNo+"','"+Religion+"','"+EducationLevel+"','"+PhoneNo+"','"+Residence+"','"+OperationArea+"',"
          + "'"+Occupation+"','"+MemberOfID+"','"+DICLearn+"','"+Email+"','"+PhoneNo1+"','"+Venue+"','"+AgeID+"','"+FirstName+"','"+SecondName+"','"+LastName+"','"+venueOther+"','"+DicLearnOther+"','"+enrollpefar_year+"','"+hand+"','"+biometric+"','"+timestamp+"')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state2.executeUpdate(inserter);  
  enrollments++;
  String updatesync="update enrollment set syncstatus='1' where UniqueID='"+UniqueIDs+"'"; 
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
   
 }   
    
}

// end of enrollment 

//// start of childage
//
//

//start of risk assessment main
String riskasesmain="SELECT * FROM riskassessmentmain WHERE ID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00'";
local.rs2=local.state3.executeQuery(riskasesmain);
while(local.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    String Quarter,Month,Pefar_year="";
         ID2=local.rs2.getString(1);
         AssessID=local.rs2.getString(2);
         AssessmentDate=local.rs2.getString(3);
         UniqueID6=local.rs2.getString(4);
         timestamp4=local.rs2.getString("timestamp");
         Quarter=local.rs2.getString("Quarter");
         Month=local.rs2.getString("Month");
         Pefar_year=local.rs2.getString("Pefar_year");
        
      
       
 String check_if_exist="SELECT * FROM riskassessmentmain WHERE AssessmentID='"+AssessID+"' AND AssessmentDate='"+AssessmentDate+"'  ";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update riskassessmentmain set syncstatus='1' WHERE ID='"+ID2+"'and AssessmentID='"+AssessID+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 existingdata++;
 
 }
 else {
  String inserter="REPLACE INTO riskassessmentmain(AssessmentID,AssessmentDate,UniqueID,Quarter,Month,Pefar_year,entrydate)"
          + "VALUES('"+AssessID+"','"+AssessmentDate+"','"+UniqueID6+"','"+Quarter+"','"+Month+"','"+Pefar_year+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   
   
   riskassessmentmains++;
   
   
   String updatesync="update riskassessmentmain set syncstatus='1' WHERE ID='"+ID2+"'and AssessmentID='"+AssessID+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }   
    
}
//start of risk reduction main
String riskredmain="SELECT * FROM riskreductionmain WHERE ID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00' ORDER BY DOA DESC";
local.rs2=local.state3.executeQuery(riskredmain);
while(local.rs2.next()){
   
    
    already_added=0;
    RiskRedID=DOA=CadreProvider=UniqueID7=timestamp4="";
    String qtr="";
    String year="";
         RiskRedID=local.rs2.getString(2);
         DOA=local.rs2.getString(3);
         CadreProvider=local.rs2.getString(4);
         UniqueID7=local.rs2.getString(5);
         timestamp4=local.rs2.getString("timestamp");
         qtr=local.rs2.getString("qtr");
         year=local.rs2.getString("year");
      
        
      
       
 String check_if_exist="SELECT * FROM riskreductionmain WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ORDER BY DOA DESC";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update riskreductionmain set syncstatus='1' WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskreductionmain(RiskReductionID,DOA,CadreProvider,UniqueID,entrydate,qtr,year,entrydate)"
          + "VALUES('"+RiskRedID+"','"+DOA+"','"+CadreProvider+"','"+UniqueID7+"','"+local.rs2.getString("timestamp")+"','"+qtr+"','"+year+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   
   riskreductionmains++;
   
   
   String updatesync="update riskreductionmain set syncstatus='1' WHERE RiskReductionID='"+RiskRedID+"' AND DOA='"+DOA+"' AND CadreProvider='"+CadreProvider+"' ";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }   
    
}

//end of riskassessmentmain

System.out.println("**** to online database syncing before riskreduction details ");
String riskreddets="SELECT * FROM riskreductiondetails WHERE RiskReductionID!='' and syncstatus='0' and timestamp!='0000-00-00 00:00:00'";
local.rs2=local.state3.executeQuery(riskreddets);
while(local.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         RiskAssessDetailID=local.rs2.getString(1);
         RiskReductionID=local.rs2.getString(2);
         QID=local.rs2.getString(3);
         currentStatus=local.rs2.getString(4);
         Action=local.rs2.getString(5);
         Appointments=local.rs2.getString(6);
       timestamp4=local.rs2.getString("timestamp");
      System.out.println("entered "+RiskAssessDetailID);
       
 String check_if_exist="SELECT * FROM riskreductiondetails WHERE RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update riskreductiondetails set syncstatus='1' WHERE ID='"+RiskAssessDetailID+"' and RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskreductiondetails(RiskReductionID,QID,currentStatus,Action,Appointments,entrydate)"
          + "VALUES('"+RiskReductionID+"','"+QID+"','"+currentStatus+"','"+Action+"','"+Appointments+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
  
   riskreductiondetails++;  
   
   
    String updatesync="update riskreductiondetails set syncstatus='1' WHERE ID='"+RiskAssessDetailID+"' and RiskReductionID='"+RiskReductionID+"' AND QID='"+QID+"' AND currentStatus='"+currentStatus+"' AND Action='"+Action+"' AND Appointments='"+Appointments+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
   
 }   
    
}
////// end of riskreductiondetails 
////
//

String riskassessdets="SELECT * FROM riskassessmentdetails WHERE RiskAssessDetailID!='' and syncstatus=0 and timestamp!='0000-00-00 00:00:00'";
local.rs2=local.state3.executeQuery(riskassessdets);
while(local.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         RiskAssessDetailID=local.rs2.getString(1);
         AssessmentID=local.rs2.getString(2);
         QuestionsID=local.rs2.getString(3);
         DirectAnswers=local.rs2.getString(4);
         CodedAnswers=local.rs2.getString(5);
         timestamp4=local.rs2.getString("timestamp");
       
      
       
 String check_if_exist="SELECT * FROM riskassessmentdetails WHERE AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
     String updatesync="update riskassessmentdetails set syncstatus='1'  WHERE RiskAssessDetailID='"+RiskAssessDetailID+"'and  AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO riskassessmentdetails(AssessmentID,QuestionID,DirectAnswers,CodedAnswers,entrydate)"
          + "VALUES('"+AssessmentID+"','"+QuestionsID+"','"+DirectAnswers+"','"+CodedAnswers+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   
   riskassessmentdetail++;
   
   
     String updatesync="update riskassessmentdetails set syncstatus='1'  WHERE RiskAssessDetailID='"+RiskAssessDetailID+"'and  AssessmentID='"+AssessmentID+"' AND QuestionID='"+QuestionsID+"' AND DirectAnswers='"+DirectAnswers+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
   
 }   
    
}
//// end of riskassessmentdetails 




String childage="SELECT * FROM childage WHERE ID!='' and syncstatus='0'";
local.rs2=local.state3.executeQuery(childage);
while(local.rs2.next()){
   
    
    already_added=0;
    ID=ChildID=UniqueID2=AgeBrackets=NoChild=timestamp2="";
    
         ID=local.rs2.getString(1);
         ChildID=local.rs2.getString(2);
         UniqueID2=local.rs2.getString(3);
         AgeBrackets=local.rs2.getString(4);
         ChildNo=local.rs2.getString(5);
         timestamp2=local.rs2.getString(6);
       
 String check_if_exist="SELECT * FROM childage  WHERE ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
  String updatesync="update childage set syncstatus='1' where ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);  
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,entrydate)"
          + "VALUES('"+ChildID+"','"+UniqueID2+"','"+AgeBrackets+"','"+NoChild+"','"+timestamp2+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  //online.state4.executeUpdate(inserter);  
  childages++; 
  String updatesync="update childage set syncstatus='1' where ChildID='"+ChildID+"' AND UniqueID='"+UniqueID2+"' AND AgeBrackets='"+AgeBrackets+"' AND NoChild='"+ChildNo+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);  
   
 }   
    
}

//// end of child age 
//
//
//start of client member
String clientmember="SELECT * FROM clientmember WHERE ID!='' and syncstatus='0'";
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
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){
    already_added=1; 
     String updatesync="update clientmember set syncstatus='1' where MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
// 
// String inserter="REPLACE INTO clientmember(MemberID,UniqueID,MemID,timestamp)"
//          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"')";
//  
//  System.out.println("_"+inserter+"\n");
//  numberofqueries++;
//  online.state4.executeUpdate(inserter);  
// existingdata++;
 }
 else {
  String inserter="INSERT INTO clientmember(MemberID,UniqueID,MemID,entrydate)"
          + "VALUES('"+MemberID+"','"+UniqueID3+"','"+MemID+"','"+timestamp3+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   clientmembers++;
   
   String updatesync="update clientmember set syncstatus='1' where MemberID='"+MemberID+"' AND UniqueID='"+UniqueID3+"' AND MemID='"+MemID+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}
//
//
////end of clientmember 


//start of clientoccupation


////start of client member
String clientoccupation="SELECT * FROM clientoccupation WHERE ID!='' and syncstatus='0'";
local.rs2=local.state3.executeQuery(clientoccupation);
while(local.rs2.next()){
   
    
    already_added=0;
    ID2=CoccID=UniqueID4=OccupationID=timestamp4="";
    
         ID2=local.rs2.getString(1);
         CoccID=local.rs2.getString(2);
         UniqueID4=local.rs2.getString(3);
         OccupationID=local.rs2.getString(4);
         timestamp4=local.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientoccupation WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
  String updatesync="update clientoccupation set syncstatus='1' WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }
 else {
  String inserter="REPLACE INTO clientoccupation(CoccID,UniqueID,OccupationID,entrydate)"
          + "VALUES('"+CoccID+"','"+UniqueID4+"','"+OccupationID+"','"+timestamp4+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   
   
   clientoccupations++;
   
  String updatesync="update clientoccupation set syncstatus='1' WHERE CoccID='"+CoccID+"' AND UniqueID='"+UniqueID4+"' AND OccupationID='"+OccupationID+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
   
 }   
    
}
//// end of clientoccupation
//
//
////start of client op area
String clientoparea="SELECT * FROM clientoparea WHERE ID!='' and syncstatus='0'";
local.rs2=local.state5.executeQuery(clientoparea);
while(local.rs2.next()){
   
    
    already_added=0;
    ID3=COPID=UniqueID5=AreaOpID=timestamp5="";
    
         ID3=local.rs2.getString(1);
         COPID=local.rs2.getString(2);
         UniqueID5=local.rs2.getString(3);
         AreaOpID=local.rs2.getString(4);
         timestamp5=local.rs2.getString(5);
      
       
 String check_if_exist="SELECT * FROM clientoparea WHERE COPID='"+COPID+"' AND UniqueID='"+UniqueID5+"' AND AreaOpID='"+AreaOpID+"'";

  System.out.println(check_if_exist+"\n");
 
 local.rs3=local.state1.executeQuery(check_if_exist);
 if(local.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 String updatesync="update clientoparea set syncstatus='1' WHERE ID='"+ID3+"' and  COPID='"+COPID+"' ";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
 }
 else {
  String inserter="REPLACE INTO clientoparea(COPID,UniqueID,AreaOpID,entrydate)"
          + "VALUES('"+COPID+"','"+UniqueID5+"','"+AreaOpID+"','"+timestamp5+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   clientopareas++;
   
   String updatesync="update clientoparea set syncstatus='1' WHERE ID='"+ID3+"' and  COPID='"+COPID+"' ";
  local.state7.executeUpdate(updatesync);
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
String medical_form="SELECT * FROM medical_form WHERE unique_identifier!='' and syncstatus='0'";
local.rs=local.state.executeQuery(medical_form);
while(local.rs.next()){
   
    
    already_added=0;
           id=unique_identifier=temperature=temperature_complain=blood_pressure=blood_pressure_complain=p=p_complain=weight=weightcomplain=ga=ga_findings
                   =skin=skin_findings=ent=ent_findings=eyes=eyes_findings=abdomen=abdomen_findings=genitourinary=genitourinary_findings=
           musculoskeletal=musculoskeletal_findings=respiratory=respiratory_findings=psychological=psychological_findings=diagnosis=management=
           referral=specify_others=TCA=cadre=dater=signature=timestamp6="";
    
         id=local.rs.getString(1);
         unique_identifier=local.rs.getString(2);
         temperature=local.rs.getString(3);
         temperature_complain=local.rs.getString(4);
         blood_pressure=local.rs.getString(5);
         blood_pressure_complain=local.rs.getString(6);
         p=local.rs.getString(7);
         p_complain=local.rs.getString(8);
         weight=local.rs.getString(9);
         weightcomplain=local.rs.getString(10);
         ga=local.rs.getString(11);
         ga_findings=local.rs.getString(12);
         skin=local.rs.getString(13); 
         skin_findings=local.rs.getString(14); 
         ent=local.rs.getString(15); 
         ent_findings=local.rs.getString(16); 
         eyes=local.rs.getString(17); 
         eyes_findings=local.rs.getString(18); 
         abdomen=local.rs.getString(19); 
         abdomen_findings=local.rs.getString(20); 
         genitourinary=local.rs.getString(21); 
         genitourinary_findings=local.rs.getString(22); 
         musculoskeletal=local.rs.getString(23); 
         musculoskeletal_findings=local.rs.getString(24); 
         respiratory=local.rs.getString(25); 
         respiratory_findings=local.rs.getString(26); 
         psychological=local.rs.getString(27);
         psychological_findings=local.rs.getString(28);
         diagnosis=local.rs.getString(29); 
         management=local.rs.getString(30); 
         referral=local.rs.getString(31); 
         specify_others=local.rs.getString(32); 
         TCA=local.rs.getString(33); 
         cadre=local.rs.getString(34); 
         dater=local.rs.getString(35); 
         signature=local.rs.getString(36); 
         timestamp6=local.rs.getString(37); 
  
 String check_if_exist="SELECT * FROM medical_form WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"'and temperature='"+temperature+"' AND temperature_complain='"+temperature_complain+"' AND blood_pressure='"+blood_pressure_complain+"' AND p='"+p+"'"
 + " AND p_complain='"+p_complain+"' AND weight_complain='"+weightcomplain+"' AND ga='"+ga+"' AND ga_findings='"+ga_findings+"' AND skin='"+skin+"'"
         + " AND skin_findings='"+skin_findings+"' AND ent='"+ent+"' AND ent_findings='"+ent_findings+"' AND eyes='"+eyes+"' AND "
         + "eyes_findings='"+eyes_findings+"' AND abdomen='"+abdomen+"'AND abdomen_findings='"+abdomen_findings+"'AND genitourinary='"+genitourinary+"'AND genitourinary_findings='"+genitourinary_findings+"'"
         + " AND musculoskeletal='"+musculoskeletal+"'AND musculoskeletal_findings='"+musculoskeletal_findings+"'AND respiratory='"+respiratory+"' AND respiratory_findings='"+respiratory_findings+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Data already added");
 existingdata++;
 String updatesync="update medical_form set syncstatus='1' WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"' ";
 

  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync); 
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
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state2.executeUpdate(inserter);  
   
   medical_forms++;
 
   
     String updatesync="update medical_form set syncstatus='1' WHERE id='"+id+"' and unique_identifier='"+unique_identifier+"' ";
 

  local.state7.executeUpdate(updatesync);
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
local.rs=local.state.executeQuery(selector);
while(local.rs.next()){
   
    
    already_added=0;
    AuditID=UniqueID=DrnkAlc=AlchHav=DrnkOcc=StpDrnk=FailDrnk=RemHap=NeedAlc=GuiltDrnk=InjureDrnk=
            FriendDrnk=DrnkAlctxt=AlcHavtxt=DrnkOcctxt=StpDrnktxt=FailDrnktxt=RemHaptxt=NeedAlctxt
            =GuiltDrnktxt=InjureDrnktxt=FriendDrnktxt=FinalAudit=""; 
    
         AuditID=local.rs.getString(1);
         UniqueID=local.rs.getString(2);
         DrnkAlc=local.rs.getString(3);
         AlchHav=local.rs.getString(4);
         DrnkOcc=local.rs.getString(5);
         StpDrnk=local.rs.getString(6);
         FailDrnk=local.rs.getString(7);
         RemHap=local.rs.getString(8);
         NeedAlc=local.rs.getString(9);
         GuiltDrnk=local.rs.getString(10);
         InjureDrnk=local.rs.getString(11); 
         FriendDrnk=local.rs.getString(12); 
         DrnkAlctxt=local.rs.getString(13); 
         AlcHavtxt=local.rs.getString(14); 
         DrnkOcctxt=local.rs.getString(15); 
         StpDrnktxt=local.rs.getString(16); 
         FailDrnktxt=local.rs.getString(17); 
         RemHaptxt=local.rs.getString(18); 
         NeedAlctxt=local.rs.getString(19); 
         GuiltDrnktxt=local.rs.getString(20); 
         InjureDrnktxt=local.rs.getString(21); 
         FriendDrnktxt=local.rs.getString(22); 
         FinalAudit=local.rs.getString(23); 
         timestamp=local.rs.getTimestamp(24).toString(); 
  
 String check_if_exist="SELECT * FROM audit WHERE UniqueID='"+UniqueID+"'AND DrnkAlc='"+DrnkAlc+"' AND AlchHav='"+AlchHav+"' AND DrnkOcc='"+DrnkOcc+"' AND StpDrnk='"+StpDrnk+"'"
 + " AND FailDrnk='"+FailDrnk+"' AND RemHap='"+RemHap+"' AND NeedAlc='"+NeedAlc+"' AND GuiltDrnk='"+GuiltDrnk+"' AND InjureDrnk='"+InjureDrnk+"'"
         + " AND FriendDrnk='"+FriendDrnk+"' AND DrnkAlctxt='"+DrnkAlctxt+"' AND AlchHavtxt='"+AlcHavtxt+"' AND DrnkOcctxt='"+DrnkOcctxt+"' AND "
         + "StpDrnktxt='"+StpDrnktxt+"' AND FailDrnktxt='"+FailDrnktxt+"'AND RemHaptxt='"+RemHaptxt+"'AND NeedAlctxt='"+NeedAlctxt+"'AND GuiltDrnktxt='"+GuiltDrnktxt+"'"
         + " AND InjureDrnktxt='"+InjureDrnktxt+"'AND FriendDrnktxt='"+FriendDrnktxt+"'AND FinalAudit='"+FinalAudit+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){
     already_added=1; 
 
  System.out.println("Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO audit (UniqueID,DrnkAlc,AlchHav,DrnkOcc,StpDrnk,FailDrnk,RemHap,NeedAlc,GuiltDrnk,InjureDrnk,FriendDrnk,DrnkAlctxt,AlchHavtxt,DrnkOcctxt,StpDrnktxt,"
          + "FailDrnktxt,RemHaptxt,NeedAlctxt,GuiltDrnktxt,InjureDrnktxt,FriendDrnktxt,FinalAudit,entrydate)"
          + "VALUES('"+UniqueID+"','"+DrnkAlc+"','"+AlchHav+"','"+DrnkOcc+"','"+StpDrnk+"','"+FailDrnk+"','"+RemHap+"','"+NeedAlc+"','"+GuiltDrnk+"','"+InjureDrnk+"','"+FriendDrnk+"','"+DrnkAlctxt+"','"+AlcHavtxt+"','"+DrnkOcctxt+"','"+StpDrnktxt+"','"+FailDrnktxt+"','"+RemHaptxt+"','"+NeedAlctxt+"','"+GuiltDrnktxt+"','"+InjureDrnktxt+"','"+FriendDrnktxt+"','"+FinalAudit+"','"+timestamp+"')"   ;
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state2.executeUpdate(inserter);  
   audits++;
 
   
    String updatesync="update audit set syncstatus='1' WHERE UniqueID='"+UniqueID+"'AND DrnkAlc='"+DrnkAlc+"' AND AlchHav='"+AlchHav+"' AND DrnkOcc='"+DrnkOcc+"' AND StpDrnk='"+StpDrnk+"'"
 + " AND FailDrnk='"+FailDrnk+"' AND RemHap='"+RemHap+"' AND NeedAlc='"+NeedAlc+"' AND GuiltDrnk='"+GuiltDrnk+"' AND InjureDrnk='"+InjureDrnk+"'"
         + " AND FriendDrnk='"+FriendDrnk+"' AND DrnkAlctxt='"+DrnkAlctxt+"' AND AlchHavtxt='"+AlcHavtxt+"' AND DrnkOcctxt='"+DrnkOcctxt+"' AND "
         + "StpDrnktxt='"+StpDrnktxt+"' AND FailDrnktxt='"+FailDrnktxt+"'AND RemHaptxt='"+RemHaptxt+"'AND NeedAlctxt='"+NeedAlctxt+"'AND GuiltDrnktxt='"+GuiltDrnktxt+"'"
         + " AND InjureDrnktxt='"+InjureDrnktxt+"'AND FriendDrnktxt='"+FriendDrnktxt+"'AND FinalAudit='"+FinalAudit+"'";

  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}





//start of taskauditor
String taskauditor="SELECT * FROM taskauditor WHERE audit!='' and syncstatus='0'";
local.rs2=local.state3.executeQuery(taskauditor);
while(local.rs2.next()){
   
    
    already_added=0;
    hostcomp=action=time=username=timestamp11="";
    
         hostcomp=local.rs2.getString(2);
         action=local.rs2.getString(3);
         time=local.rs2.getString(4);
         username=local.rs2.getString(5);
         timestamp11=local.rs2.getString(6);
        
      
       
 String check_if_exist="SELECT * FROM taskauditor WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
   String updatesync="update taskauditor set syncstatus='1' WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO taskauditor(host_comp,action,time,username,timestamp)"
          + "VALUES('"+hostcomp+"','"+action.replace("'", " ")+"','"+time+"','"+username+"','"+timestamp11+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   
   taskauditors++;
   
   
    String updatesync="update taskauditor set syncstatus='1' WHERE host_comp='"+hostcomp+"' AND action='"+action.replace("'", " ")+"' AND time='"+time+"' AND username='"+username+"' AND timestamp='"+timestamp11+"'";
  local.state7.executeUpdate(updatesync);
  System.out.println(updatesync);
 }   
    
}

//end of task auditor 

////
////start of user
String user="SELECT * FROM user WHERE UserID!='' and syncstatus='0'";
local.rs2=local.state3.executeQuery(user);
while(local.rs2.next()){
   
    
    already_added=0;
    Name=Username=Password=PhoneNos=Email=Location=AccessLevel=timestamp12="";
    
         Name=local.rs2.getString(2);
         Username=local.rs2.getString(3);
         Password=local.rs2.getString(4);
         PhoneNos=local.rs2.getString(5);
         Email=local.rs2.getString(6);
         Location=local.rs2.getString(7);
         AccessLevel=local.rs2.getString(8);
         timestamp12=local.rs2.getString(9);
        
      
       
 String check_if_exist="SELECT * FROM user WHERE Name='"+Name+"' AND Username='"+Username+"' AND Password='"+Password+"' AND PhoneNo='"+PhoneNos+"' AND Email='"+Email+"'";

  System.out.println(check_if_exist+"\n");
 
 online.rs3=online.state1.executeQuery(check_if_exist);
 if(online.rs3.next()==true){already_added=1; 
 
  System.out.println("Clerk Data already added");
 existingdata++;
 }
 else {
  String inserter="REPLACE INTO user(Name,Username,Password,PhoneNo,Email,Location,AccessLevel,timestamp)"
          + "VALUES('"+Name+"','"+Username+"','"+Password+"','"+PhoneNos+"','"+Email+"','"+Location+"','"+AccessLevel+"','"+timestamp12+"')";
  
  System.out.println("_"+inserter+"\n");
  numberofqueries++;
  online.state4.executeUpdate(inserter);  
   
   
   users++;
   
   
    String updatesync="update user set syncstatus='1' WHERE Name='"+Name+"' AND Username='"+Username+"' AND Password='"+Password+"' AND PhoneNo='"+PhoneNos+"' AND Email='"+Email+"'";
  local.state7.executeUpdate(updatesync);
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
         

//since syncing has ended, Now start or end thread
itc.syncingstatus=false;

return true;

//session.setAttribute("msg", wholemsg);

}



}
