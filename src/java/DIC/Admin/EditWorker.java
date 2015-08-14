/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.AES;
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
public class EditWorker extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        try {
            String[] Occupation=null;
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

             dbConnect conn = new dbConnect();
String computername=InetAddress.getLocalHost().getHostName();
//System.out.println("Computer name "+computername);
Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formattedDate = formatter.format(date);

String UniqueID = request.getParameter("UniqueID");
String oldUniqueID = request.getParameter("OLDUniqueID");
String rowid = request.getParameter("ROWID");

System.out.println("jjjj"+UniqueID);
String OperationAreaID= request.getParameter("OperationAreaID");
//System.out.println("OperationAreaID"+ OperationAreaID);

String OccupationID= request.getParameter("OccupationID");
//System.out.println("OccupationID"+ OccupationID);


String ChildID= request.getParameter("ChildID");
String operationsID= request.getParameter("OperationsID");
System.out.println("nnn "+operationsID);
String occupationsID= request.getParameter("occupationID");
String childsID= request.getParameter("childsID");

String occupationIDArray[];
occupationIDArray = occupationsID.split("_");

String childsIDArray[];
childsIDArray = childsID.split("_");

String operationIDArray[];
operationIDArray = operationsID.split("_");


String MemberOfID= request.getParameter("MemberofID");


String ClientInit = request.getParameter("ClientInit");
String DOE = request.getParameter("DOE").toString();

//System.out.println(DOE);
String time = DOE.substring(3,10);
//System.out.println(time);
String UniqueCode="";
String District = request.getParameter("district");
String Districts="";
String[] Dist;
Dist = District.split(",");
System.out.println("DistrictID:"+Dist[0]);
if(request.getParameter("district")!= null){
Districts = Dist[0];}
else{
Dist[0]="";
}
String DOB;
if(request.getParameter("DOB")!= null){
DOB = request.getParameter("DOB");}
else{
DOB="";
}
String DICName ="";
if(request.getParameter("DICName")!= null){
DICName = request.getParameter("DICName");}
else{
DICName ="";
}
String Sex=""; 
if(request.getParameter("Sex")!= null){
Sex= request.getParameter("Sex");
}
else{Sex="";
}
String Age ="";
if(request.getParameter("age")!=null){
Age= request.getParameter("age");}
else{
Age ="";}

String MaritalStatus="";
if(request.getParameter("MaritalStatus")!=null){
MaritalStatus  = request.getParameter("MaritalStatus");}
else
{ MaritalStatus="";
}
String Children="";
if(request.getParameter("MaritalStatus")!=null){
 Children= request.getParameter("Children");
}else{
 Children="";
}
String ChildNo="";

if(request.getParameter("ChildNo")!= null){
ChildNo = request.getParameter("ChildNo");
}else{
ChildNo="";}
String Religion="";
if(request.getParameter("Religion")!=null){
Religion= request.getParameter("Religion");}
else{
Religion="";
}
String EducationLevel="";
if(request.getParameter("EducationLevel")!=null){
EducationLevel = request.getParameter("EducationLevel");}
else{EducationLevel="";}
String PhoneNo="";
if(request.getParameter("PhoneNo")!= null){
PhoneNo = request.getParameter("PhoneNo");}
else{ PhoneNo="";}
String Residence="";
if(request.getParameter("Residence")!=null){
Residence = request.getParameter("Residence");}
else{
Residence=null;
}
String DICLearn="";
if(request.getParameter("DICLearn")!=null){
DICLearn= request.getParameter("DICLearn");}
else{
DICLearn="";
}
String Email="";
if(request.getParameter("Email")!=null){
Email= request.getParameter("Email");}
else{Email="";}
        
String PhoneNo1="";
if(request.getParameter("PhoneNo1")!=null){
PhoneNo1= request.getParameter("PhoneNo1");}
else{PhoneNo1="";}

String Venue="";
if(request.getParameter("Venue")!= null){
Venue= request.getParameter("Venue");}else{
Venue="";}
// to insert into client member of table
//String NHIFmember = request.getParameter("NHIFmember");
//String NSSFmember = request.getParameter("NSSFmember");
//String MFinanceMem= request.getParameter("MFinanceMem");
//String WomenGroup= request.getParameter("WomenGroup");

//System.out.println("AAAAAAAA"+MemberOf[0]);
//System.out.println("AAAAAAAA"+MemberOf[1]);
//System.out.println("AAAAAAAA"+MemberOf[2]);
//System.out.println("AAAAAAAA"+MemberOf[3]);
// to isert into client child ages 

String[] AgeID = request.getParameterValues("AgeID");
String age="";



//String Age_14= request.getParameter("Age_14");
//String Age_24= request.getParameter("Age_24");
//String Age_25= request.getParameter("Age_25");

String area="";
//to be inserted into operation area

String OperationArea2 = request.getParameter("OperationArea2");
String OperationArea3 = request.getParameter("OperationArea3");
String OperationArea4 = request.getParameter("OperationArea4");
String OperationArea5 = request.getParameter("OperationArea5");
String OperationArea6 = request.getParameter("OperationArea6");
String OperationArea7 = request.getParameter("OperationArea7");
String OperationArea8 = request.getParameter("OperationArea8");
String occupation=null;




if(Religion.matches("Other")){
Religion = request.getParameter("Religion1").toString();
                    }
//if(OperationArea.matches("Other")){
//  OperationArea = request.getParameter("OperationArea1").toString();
//                                }
if(DICLearn.matches("Other")){
DICLearn = request.getParameter("DICLearn1").toString();
                    }


//UniqueCode = District +'/'+time +'/'+ uni;
HttpSession session =request.getSession(true);
String queryOperation="";
String Copid="";
String newopareas="";
String deleteopareas="";
 if(request.getParameter("COPID")!=null && !request.getParameter("COPID").equals("")){
Copid= request.getParameter("COPID");}
 if(request.getParameter("newoperation")!=null && !request.getParameter("newoperation").equals("")){
newopareas= request.getParameter("newoperation");}
 if(request.getParameter("deleteoperation")!=null && !request.getParameter("deleteoperation").equals("")){
deleteopareas= request.getParameter("deleteoperation");}
 String newareas[];
 newareas=newopareas.split("_");
 String deleteareas[];
 deleteareas=deleteopareas.split("_");
       
 


for(int i=0; i<newareas.length;i++){
    System.out.println("OperationArea             "+newareas[i] +"       ");

    if(!newareas[i].equals("") && newareas[i]!=null ){
       if(!newareas[i].equals("")){
       String queryOperation1="insert into clientoparea SET AreaOpID='"+newareas[i]+"', COPID='"+Copid+"',UniqueID='"+UniqueID+"',syncstatus=0 ";
     System.out.println(queryOperation1);
       conn.state.executeUpdate(queryOperation1);
       }
    }
       
   
 


}
for(int j=0;j<deleteareas.length;j++){

 if(!deleteareas[j].equals("") && deleteareas[j]!=null ){
      if(!deleteareas[j].equals("")){
      String  queryOperation2="delete * from clientoparea where AreaOpID='"+deleteareas[j]+"' and UniqueID='"+UniqueID+"'";
 System.out.println(queryOperation2);  
         conn.state.executeUpdate(queryOperation);
 }}
      

}
String Cocid="";
String newoccupation="";
String deleteoccupation="";

// Occupation= request.getParameterValues("Occupation");
 if(request.getParameter("COCID")!=null && !request.getParameter("COCID").equals("")){
Cocid= request.getParameter("COCID");}
 if(request.getParameter("newoccupation")!=null && !request.getParameter("newoccupation").equals("")){
newoccupation= request.getParameter("newoccupation");}
 if(request.getParameter("deleteoccupation")!=null && !request.getParameter("deleteoccupation").equals("")){
deleteoccupation= request.getParameter("deleteoccupation");}
String newoccs[]=newoccupation.split("_");
String deleteoccs[]=deleteoccupation.split("_");
  for(int k=0;k<newoccs.length;k++){
      if(!newoccs[k].equals("")){
String queryOccupation ="INSERT INTO clientoccupation SET OccupationID= '"+newoccs[k]+"',CoccID='"+Cocid+"',UniqueID='"+UniqueID+"',syncstatus=0";
  System.out.println("queryOccupation          "+queryOccupation);
 conn.state.executeUpdate(queryOccupation);
  }}
  for(int k=0;k<deleteoccs.length;k++){
      if(!deleteoccs[k].equals("")){
String queryOccupation ="DELETE * FROM clientoccupation WHERE  OccupationID= '"+deleteoccs[k]+"' AND UniqueID='"+UniqueID+"'";
  System.out.println("queryOccupation          "+queryOccupation);
 conn.state.executeUpdate(queryOccupation);
  }}
   

String childageid="";
String newchild="";
String deletechild="";
String ageno="";
  if(request.getParameter("childageid")!=null && !request.getParameter("childageid").equals("")){
childageid= request.getParameter("childageid");}
 if(request.getParameter("newchild")!=null && !request.getParameter("newchild").equals("")){
newchild= request.getParameter("newchild");}
 if(request.getParameter("deletechild")!=null && !request.getParameter("deletechild").equals("")){
deletechild= request.getParameter("deletechild");}
String newchilds[]=newchild.split("_");
String deletechilds[]=deletechild.split("_");
  for(int k=0;k<newchilds.length;k++){
      if(!newchilds[k].equals("")){
          if( request.getParameter("AgeNo"+k)!=null && !request.getParameter("AgeNo"+k).equals("")){
    ageno = request.getParameter("AgeNo"+k);
    } 
String querychilds ="INSERT INTO childage SET  AgeBrackets='"+newchilds[k]+"',NoChild='"+ageno+"',childID='"+childageid+"',UniqueID='"+UniqueID+"',syncstatus=0";
  System.out.println("queryOccupation          "+querychilds);
 conn.state.executeUpdate(querychilds);
  }}
  for(int k=0;k<deletechilds.length;k++){
      if(!deletechilds[k].equals("")){
String querychild ="DELETE * FROM childage WHERE  AgeBrackets='"+newchilds[k]+"' AND NoChild='"+ageno+"' AND UniqueID='"+UniqueID+"'";
  System.out.println("queryOccupation          "+querychild);
 conn.state.executeUpdate(querychild);
  }}
  
  
  
  
//String[] AgeNo = request.getParameterValues("AgeNo");
//String No="";
//
//for(int i=0; i<childsIDArray.length;i++){
//    String AgeIDs ="";
//    String AgeNos="";
//    if( request.getParameter("AgeID"+i)!=null && !request.getParameter("AgeID"+i).equals("")){
//    AgeIDs = request.getParameter("AgeID"+i);
//    }  
//    if( request.getParameter("AgeNo"+i)!=null && !request.getParameter("AgeNo"+i).equals("")){
//    AgeNos = request.getParameter("AgeNo"+i);
//    }  
//    
//    //System.out.println("childsIDArray[i]               "+childsIDArray[i]);
//    if(childsIDArray[i]!=null && !childsIDArray[i].equals("")){
//
//try {
//String queryAges1="UPDATE childage SET AgeBrackets='"+AgeIDs+"',NoChild='"+AgeNos+"',syncstatus=0  where ID='"+childsIDArray[i]+"'";
//System.out.println(queryAges1);
// conn.state.executeUpdate(queryAges1);
//} catch (SQLException ex) {
//Logger.getLogger(EditWorker.class.getName()).log(Level.SEVERE, null, ex);
//}
//}
//
//}                               
String member=null;

if(request.getParameter("checkifexist").equals("0")){
String[] MemberOf =null;
if(request.getParameterValues("member")!=null){
       MemberOf= request.getParameterValues("member");
        }
if(MemberOf!=null){
for(int i=0; i<MemberOf.length;i++){
    String memID="";
    if(request.getParameter("memID"+i)!=null && !request.getParameter("memID"+i).equals("")){
 memID= request.getParameter("memID"+i);
//System.out.println("memID                "+ memID);
}
try {
String queryMember="UPDATE clientmember SET MemID='"+MemberOf[i]+"',UniqueID='"+UniqueID+"',syncstatus=0  WHERE ID='"+memID+"'";
 conn.state.executeUpdate(queryMember);
System.out.println("queryMember"+queryMember);
} catch (SQLException ex) {
Logger.getLogger(EditWorker.class.getName()).log(Level.SEVERE, null, ex);
}
}
}
}
String nhifmem="2";
String nssfmem="2";
String womenmem="2";
String micromem="2";
String memberid="";
if(request.getParameter("checkifexist").equals("1")){
if(request.getParameter("nhifmembernew")!=null && !request.getParameter("nhifmembernew").equals("")){
  nhifmem =request.getParameter("nhifmembernew"); 
}
if(request.getParameter("memberid")!=null && !request.getParameter("memberid").equals("")){
  memberid =request.getParameter("memberid"); 
}
if(request.getParameter("nssfmembernew")!=null && !request.getParameter("nssfmembernew").equals("")){
  nssfmem =request.getParameter("nssfmembernew"); 
}
if(request.getParameter("micromembernew")!=null && !request.getParameter("micromembernew").equals("")){
  micromem =request.getParameter("micromembernew"); 
}
if(request.getParameter("womenmembernew")!=null && !request.getParameter("womenmembernew").equals("")){
  womenmem =request.getParameter("womenmembernew"); 
}
String insert1="insert into clientmember SET MemID='"+nhifmem+"',UniqueID='"+UniqueID+"',syncstatus=0,MemberID='"+memberid+"'";
String insert2="insert into clientmember SET MemID='"+nssfmem+"',UniqueID='"+UniqueID+"',syncstatus=0,MemberID='"+memberid+"'";
String insert3="insert into clientmember SET MemID='"+micromem+"',UniqueID='"+UniqueID+"',syncstatus=0,MemberID='"+memberid+"'";
String insert4="insert into clientmember SET MemID='"+womenmem+"',UniqueID='"+UniqueID+"',syncstatus=0,MemberID='"+memberid+"'";
 conn.state.executeUpdate(insert1);
 conn.state.executeUpdate(insert2);
 conn.state.executeUpdate(insert3);
 conn.state.executeUpdate(insert4);
 System.out.println(insert1 +"------  "+insert2+"------ "+insert3+"------- "+insert4);

}




String full_name=request.getParameter("client_name");
String[]full=full_name.split(" ");
String fname="",mname="",lname="";
int name_length=full.length;
if(name_length==2){
 fname= full[0];
 lname=full[1];
 mname="";
 
}
if(name_length>2){
 fname= full[0];
 lname=full[2];
 mname=full[1];
}
 String query="";              

//System.out.println(UniqueID);
                 String firstname = fname;
                     String secondname = mname;
                     String lastname = lname;
                     String phoneno = PhoneNo;
                   
                     String strPssword = "?*1>9@(&#";
                    AES.setKey(strPssword);
                    String first="";
                  
                    if(firstname!=null && !firstname.trim().equals("") && !firstname.equals("null")){
                       AES.encrypt (fname.trim().replace("'", ""));
                        System.out.println("Encrypted______________________: " + fname);
                   
                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
                      first= AES.getEncryptedString();
            }
                    
                    //middle name encrypt
                      String midname="";
                     if(mname!=null && !mname.trim().equals("") && !mname.equals("null")){
                     AES.encrypt (mname.trim().replace("'", ""));
                        System.out.println("Encrypted______________________: " + mname);
                   
                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
                      midname=AES.getEncryptedString();
                     }
                     //last name encrypt
                     String lasname="";
                      if(lname!=null && !lname.trim().equals("") && !lname.equals("null")){
                     AES.encrypt (lname.trim().replace("'", ""));
                        System.out.println("Encrypted______________________: " + lname);
                   
                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
                      lasname= AES.getEncryptedString();
                      }
                      String phone="";
                     if(phoneno!=null && !PhoneNo.trim().equals("") && !phoneno.equals("null")){
                     AES.encrypt (phoneno.trim());
                      System.out.println("String to Encrypt:_______****(**** " + phoneno); 
                    System.out.println("Encrypted:________******** " + AES.getEncryptedString());
                    
                     phone= AES.getEncryptedString();
                     } 
                     String ward="";
        if(request.getParameter("ward")!=null && !request.getParameter("ward").equals("") ){
 ward=request.getParameter("ward");}            

String query1 = "UPDATE enrollment set ClientInit='"+ClientInit+"',DOE= '"+DOE+"',District='"+Districts+"',DOB='"+DOB+"',"
+ "DICName='"+DICName+"',ward='"+ward+"',Sex='"+Sex+"',Age='"+Age+"',MaritalStatus='"+MaritalStatus+"',Children='"+Children+"',ChildNo='"+ChildNo+"',Religion='"+Religion+"',"
+ "EducationLevel='"+EducationLevel+"',PhoneNo='"+phone+"',Residence='"+Residence+"',OperationArea='"+OperationAreaID+"',Occupation='"+OccupationID+"',MemberOfID='"+OperationAreaID+"',DICLearn='"+DICLearn+"',"
+ "Email='"+Email+"',PhoneNo1='"+PhoneNo1+"',Venue='"+Venue+"',AgeID='"+OperationAreaID+"',FirstName='"+first+"',SecondName='"+midname+"', Lastname='"+lasname+"',syncstatus=0 ,UniqueID='"+UniqueID+"' WHERE EnrollID='"+rowid+"'";
// conn.ps1 = conn.connect.prepareStatement(query1);
 System.out.println(query1);
//conn.ps1.setString(1,UniqueID);
//conn.ps1.executeUpdate(); 
conn.state.executeUpdate(query1);


String getRRUniqueID="select * from riskreductionmain where UniqueID='"+oldUniqueID+"'";
conn.rs4 = conn.state4.executeQuery(getRRUniqueID);
while(conn.rs4.next()){
String updateRiskRed="update riskreductionmain set UniqueID='"+UniqueID+"' where RiskReductionID='"+conn.rs4.getString("RiskReductionID")+"'";

System.out.println("^^^^^"+updateRiskRed);
conn.state.executeUpdate(updateRiskRed);
}
String getRAUniqueID="select * from riskassessmentmain where UniqueID='"+oldUniqueID+"'";
conn.rs3 = conn.state3.executeQuery(getRAUniqueID);
while(conn.rs3.next()){
String updateRiskAss="update riskassessmentmain set UniqueID='"+UniqueID+"' where AssessmentID='"+conn.rs3.getString("AssessmentID")+"'";

System.out.println("^^^^^"+updateRiskAss);
conn.state.executeUpdate(updateRiskAss);
}
String getMedUniqueID="select * from medical_form where unique_identifier='"+oldUniqueID+"'";
conn.rs5 = conn.state5.executeQuery(getMedUniqueID);
while(conn.rs5.next()){
String updateMed="update medical_form set unique_identifier='"+UniqueID+"' where id='"+conn.rs5.getString("id")+"'";

System.out.println("^^^^^"+updateMed);
conn.state.executeUpdate(updateMed);
}
//System.out.println("query"+query);
                             
//        conn.state.executeUpdate(query);
//         String inserter = "insert into taskauditor set host_comp='" + computername + "' , action='Performed Enrollment Update on a Sex Worker  whose UniqueID is '"+UniqueID+"' from the Risk Enrollment Form',time='" + formattedDate + "',username='" + session.getAttribute("Username") + "'";
//                      conn.state.executeUpdate(inserter);
        
         String inserter = "INSERT INTO taskauditor (host_comp,time,username,action) VALUES(?,?,?,?)";
 String usersession="";
         if(session.getAttribute("Username") !=null){
      usersession =  session.getAttribute("Username").toString();   
                 }
 conn.ps = conn.connect.prepareStatement(inserter);
conn.ps.setString(1,computername);
conn.ps.setString(2,formattedDate);
conn.ps.setString(3,usersession );
conn.ps.setString(4,"Performed Enrollment Update on a Sex Worker  whose UniqueID is '"+UniqueID+"' from the Enrollment Form");
conn.ps.executeUpdate(); 
        
           
             response.sendRedirect("/DIC/admin/indexWorker.jsp");
             
             
             		
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
        } catch (SQLException ex) {
            Logger.getLogger(EditWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
            
}}		

                     