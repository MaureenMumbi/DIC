/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enroll;

import dbConnect.AES;
import dbConnect.Destest;
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
public class EnrollServlet extends HttpServlet {

    String query="";
    String computername;
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
    
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          
String uniq="";
HttpSession session =request.getSession(true);
dbConnect conn = new dbConnect();
String fingerprint="";
String ward="";
Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);
String UniqueID ="";
if(request.getParameter("UniqueID")!=null && !request.getParameter("UniqueID").equals("") ){
UniqueID=request.getParameter("UniqueID");}
String full_name="";
if(request.getParameter("client_name")!=null && !request.getParameter("client_name").equals("") ){
full_name=request.getParameter("client_name");}
if(request.getParameter("ward")!=null && !request.getParameter("ward").equals("") ){
 ward=request.getParameter("ward");}
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
String ClientInit = request.getParameter("ClientInit");
String DOE = request.getParameter("DOE").toString();

System.out.println(DOE);
String time = DOE.substring(3,10);

String Report_Date[]= DOE.split("/");
String monthly = Report_Date[1];
int yearly = Integer.parseInt(Report_Date[2]);


System.out.println(time);
String UniqueCode="";
String District = request.getParameter("district");
String Districts="";
String[] Dist;
        Dist = District.split(",");
        System.out.println("DistrictID:"+Dist[0]);
if(request.getParameter("district")!= null ){
Districts = Dist[0];}
else{
Dist[0]="";
}
String DOB;
if(request.getParameter("DOB")!= null && !request.getParameter("DOB").equals("")){
DOB = request.getParameter("DOB");}
else{
    DOB="";
}
String DICName ="";
if(request.getParameter("DICName")!= null && !request.getParameter("DICName").equals("")){
DICName = request.getParameter("DICName");}
else{
DICName ="";
}
String capturedhand ="";
if(request.getParameter("capturedhand")!= null && !request.getParameter("capturedhand").equals("")){
capturedhand = request.getParameter("capturedhand");}
else{
capturedhand ="";
}
String capturedfinger ="";
if(request.getParameter("capturedfinger")!= null && !request.getParameter("capturedfinger").equals("")){
capturedfinger = request.getParameter("capturedfinger");}
else{
capturedfinger ="";
}
String Sex=""; 
        if(request.getParameter("Sex")!= null && !request.getParameter("Sex").equals("")){
        Sex= request.getParameter("Sex");
        }
        else{Sex="";
        }
String Age ="";
if(request.getParameter("age")!=null && !request.getParameter("age").equals("")){
       Age= request.getParameter("age");}
else{
Age ="";}

String MaritalStatus="";
        if(request.getParameter("MaritalStatus")!=null && !request.getParameter("MaritalStatus").equals("") ){
      MaritalStatus  = request.getParameter("MaritalStatus");}
        else
        { MaritalStatus="";
        }
String venueother="";
        if(request.getParameter("Venue1")!=null && !request.getParameter("Venue1").equals("") ){
      venueother  = request.getParameter("Venue1");}
        else
        { venueother="";
        }
String Children="";
         if(request.getParameter("Children")!=null && !request.getParameter("Children").equals("") ){
             Children= request.getParameter("Children");
         }else{
             Children="";
         }
int ChildNo=0;

if(request.getParameter("ChildNo")!= null && !request.getParameter("ChildNo").equals("")){
       ChildNo = Integer.parseInt(request.getParameter("ChildNo"));
}else{
ChildNo=0;}
String Religion="";
if(request.getParameter("Religion")!=null && !request.getParameter("Religion").equals("")){
 Religion= request.getParameter("Religion");}
else{
Religion="";
}
String EducationLevel="";
if(request.getParameter("EducationLevel")!=null &&  !request.getParameter("EducationLevel").equals("")){
EducationLevel = request.getParameter("EducationLevel");}
else{EducationLevel="";}
String PhoneNo="";
if(request.getParameter("PhoneNo")!= null && !request.getParameter("PhoneNo").equals("")){
PhoneNo = request.getParameter("PhoneNo");}
else{ PhoneNo="";}
String Residence="";
if(request.getParameter("Residence")!=null && !request.getParameter("Residence").equals("")){
 Residence = request.getParameter("Residence");}
else{
Residence=null;
}
String DICLearn="";
if(request.getParameter("DICLearn")!=null &&  !request.getParameter("DICLearn").equals("")){
DICLearn= request.getParameter("DICLearn");}
else{
    DICLearn="";
}
String Email="";
        if(request.getParameter("Email")!=null && !request.getParameter("Email").equals("")){
 Email= request.getParameter("Email");}
        else{Email="";}
        
String PhoneNo1="";
if(request.getParameter("PhoneNo1")!=null && !request.getParameter("PhoneNo1").equals("")){
 PhoneNo1= request.getParameter("PhoneNo1");}
else{PhoneNo1="";}

String Venue="";
if(request.getParameter("Venue")!= null && !request.getParameter("Venue").equals("")){
Venue= request.getParameter("Venue");}
else{
 Venue="";}
String DICLearn1="";
if(request.getParameter("DICLearn1")!= null && !request.getParameter("DICLearn1").equals("")){
DICLearn1= request.getParameter("DICLearn1");}
else{
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
// to be inserted into occupation table +id

String AgeNo1 = request.getParameter("AgeNo0");
String AgeNo2 = request.getParameter("AgeNo1");
String AgeNo3 = request.getParameter("AgeNo2");
String AgeNo4 = request.getParameter("AgeNo3");
String AgeNo5 = request.getParameter("AgeNo4");

String AgeID1 = request.getParameter("AgeID0");
String AgeID2 = request.getParameter("AgeID1");
String AgeID3 = request.getParameter("AgeID2");
String AgeID4 = request.getParameter("AgeID3");
String AgeID5 = request.getParameter("AgeID4");

//____________________GET COMPUTER NAME____________________________________
computername=InetAddress.getLocalHost().getHostName();
System.out.println("Computer name "+computername);
                


if(Religion.matches("Other")){
  Religion = request.getParameter("Religion1").toString();
                                }
//if(OperationArea.matches("Other")){
//  OperationArea = request.getParameter("OperationArea1").toString();
//                                }
if(DICLearn.matches("Other")){
  DICLearn = request.getParameter("DICLearn1").toString();
                            }
if(session.getAttribute("uniqueid")!=null){
uniq= session.getAttribute("uniqueid").toString();
if(uniq.equals(UniqueID)){
 fingerprint=session.getAttribute("kidole").toString();}}

String FHIClient="FHIClient";
String query1 = "INSERT INTO dummy(FHIClient,timestamp)"           
  + " VALUES ('"+FHIClient+"','"+formattedDate+"')";
try {
conn.state.executeUpdate(query1);
} catch (SQLException ex) {
Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
}


String query2="SELECT max(UniqueID) from dummy";
int Unique=0;
conn.state= conn.connect.createStatement();
conn.rs = conn.state.executeQuery(query2);

while(conn.rs.next()){
 Unique=conn.rs.getInt(1);
 System.out.println(UniqueID);

}


int uni=Unique+1;


session.setAttribute("UniqueCode", UniqueCode);
session.setAttribute("UniqueID", UniqueID);
session.setAttribute("count", "0");
 session.getAttribute("UniqueID");
String OperationAreaID = ClientInit+'/'+ formattedDate +'/'+uni;
String OccupationID = ClientInit+'/'+ formattedDate +'/'+uni;
String MemberOfID = ClientInit+'/'+ formattedDate +'/'+uni;
String ChildID = ClientInit+'/'+ formattedDate +'/'+uni;
String queryOperation=null;
String[] OperationArea = request.getParameterValues("OperationArea");
if(OperationArea != null ){
for(int i=0; i<OperationArea.length;i++){
    
queryOperation="INSERT INTO clientoparea(COPid,UniqueID,AreaOpID,syncstatus) VALUE('"+OperationAreaID+"','"+UniqueID+"','"+OperationArea[i]+"','0')";
                              
 conn.state.executeUpdate(queryOperation);
   }
    }
String[] Occupation = request.getParameterValues("Occupation");
String queryOccupation="";
 if(Occupation != null){
for(int i=0; i<Occupation.length;i++){
   
queryOccupation ="INSERT INTO clientoccupation(CoccID,UniqueID,OccupationID,syncstatus) VALUE('"+OccupationID+"','"+UniqueID+"','"+Occupation[i]+"','0')";
 conn.state.executeUpdate(queryOccupation);}
}
String[] AgeNo = request.getParameterValues("AgeNo");
String No="";

//for(int i=0; i<AgeID.length;i++){
if(AgeID1!=null && AgeNo1!=null){
String queryAges1="INSERT INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,syncstatus)VALUE('"+ChildID+"','"+UniqueID+"','"+AgeID1+"','"+AgeNo1+"','0')";

 conn.state.executeUpdate(queryAges1);}
//    }                               
//for(int i=0; i<AgeID.length;i++){
if(AgeID2!=null && AgeNo2!=null){
String queryAges2="INSERT INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,syncstatus)VALUE('"+ChildID+"','"+UniqueID+"','"+AgeID2+"','"+AgeNo2+"','0')";

 conn.state.executeUpdate(queryAges2);
}                              
//for(int i=0; i<AgeID.length;i++){
if(AgeID3!=null && AgeNo3!=null){
String queryAges3="INSERT INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,syncstatus)VALUE('"+ChildID+"','"+UniqueID+"','"+AgeID3+"','"+AgeNo3+"','0')";

 conn.state.executeUpdate(queryAges3);
}
//}                               
//for(int i=0; i<AgeID.length;i++){
if(AgeID4!=null && AgeNo4!=null){
String queryAges4="INSERT INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,syncstatus)VALUE('"+ChildID+"','"+UniqueID+"','"+AgeID4+"','"+AgeNo4+"','0')";

 conn.state.executeUpdate(queryAges4);
}
//}                               
//for(int i=0; i<AgeID.length;i++){
if(AgeID5!=null && AgeNo5!=null){
String queryAges5="INSERT INTO childage(ChildID,UniqueID,AgeBrackets,NoChild,syncstatus)VALUE('"+ChildID+"','"+UniqueID+"','"+AgeID5+"','"+AgeNo5+"','0')";

 conn.state.executeUpdate(queryAges5);
}
//}                               
String member=null;
String memberans="";
String[] MemberOf = request.getParameterValues("member");
if(MemberOf!=null){
for(int i=0; i<MemberOf.length;i++){
if(MemberOf[i].equals("")){
memberans="2";
}
else{
memberans=MemberOf[i];
}
String queryMember="INSERT INTO clientmember(MemberID,UniqueID,MemID,syncstatus) VALUE('"+MemberOfID+"','"+UniqueID+"','"+memberans+"','0')";
 conn.state.executeUpdate(queryMember);}
}
System.out.println(UniqueID);
                     String firstname = fname;
                     String secondname = mname;
                     String lastname = lname;
                     String phoneno = PhoneNo;
                     String fingerprints = fingerprint;
                    
                  
                    String first="";
                     final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                    if(firstname!=null && !firstname.trim().equals("") && !firstname.equals("null")){
                       AES.encrypt (firstname.trim());
                        System.out.println("Encrypted______________________: " + firstname);
                   
                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
                      first= AES.getEncryptedString();
            }
                    
                    //middle name encrypt
                      String midname="";
                     if(mname!=null && !mname.trim().equals("") && !mname.equals("null")){
                     AES.encrypt (mname.trim());
                        System.out.println("Encrypted______________________: " + mname);
                   
                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
                      midname=AES.getEncryptedString();
                     }
                     //last name encrypt
                     String lasname="";
                      if(lname!=null && !lname.trim().equals("") && !lname.equals("null")){
                     AES.encrypt (lname.trim());
                        System.out.println("Encrypted______________________: " + lname);
                   
                    System.out.println("Encrypted:____________________ " + AES.getEncryptedString());
                      lasname= AES.getEncryptedString();
                      }
                      String phone="";
                     if(phoneno!=null && !phoneno.trim().equals("") && !phoneno.equals("null")){
                     AES.encrypt (phoneno.trim());
                      System.out.println("String to Encrypt:_______****(**** " + phoneno); 
                    System.out.println("Encrypted:________******** " + AES.getEncryptedString());
                    
                     phone= AES.getEncryptedString();
                     } 
                     String biofing="";
                     if(fingerprints!=null && !fingerprints.trim().equals("") && !fingerprints.equals("null")){
                    
                    
                      AES.encrypt (fingerprints.trim());
                    System.out.println("String to Encrypt:_______+++++++ " + fingerprints); 
                   System.out.println("Encrypted:_______+++++++ " + AES.getEncryptedString());
                    biofing=AES.getEncryptedString();
                     }
                     else{
                     biofing="";}
//    System.out.println(fname+"     encrypted   "+pw+" decrypted"+decrypted);

if(UniqueID != null && ClientInit!= null && DOE!=null && District!=null && DOB!= null && DICName!=null ){
query = "INSERT INTO enrollment (UniqueID,ClientInit,DOE,District,DOB,DICName,ward,Sex,Age,MaritalStatus,Children,ChildNo,Religion,"
     + "EducationLevel,PhoneNo,Residence,OperationArea,Occupation,MemberOfID,DICLearn,DICLearnOther,Email,PhoneNo1,Venue,AgeID,FirstName,SecondName,LastName,VenueOther,Pefar_year,capturedhand,capturedfinger,fingerprint,syncstatus)"
+ " VALUES ('"+UniqueID+"','"+ClientInit+"','"+DOE+"','"+Districts+"','"+DOB+"','"+DICName+"','"+ward+"','"+Sex+"','"+Age+"','"+MaritalStatus+"','"+Children+"','"+ChildNo+"',"
     + "'"+Religion+"','"+EducationLevel+"','"+phone+"','"+Residence+"','"+OperationAreaID+"','"+OccupationID+"','"+MemberOfID+"','"+DICLearn+"','"+DICLearn1+"'"
        + ",'"+Email+"','"+PhoneNo1+"','"+Venue+"','"+ChildID+"','"+first+"','"+midname+"','"+lasname+"','"+venueother+"','"+yearly+"','"+capturedhand+"','"+capturedfinger+"','"+biofing+"','0')";
}
                   
          System.out.println("dic    "+query);               
 String inserter = "insert into taskauditor set host_comp='" + computername + "' , action='Enrolled a sex worker  whose UniqueID is "+UniqueID+" from the enrollment',time='" + formattedDate + "',username='" + session.getAttribute("Username") + "',syncstatus='0'";

 

try {

                                        conn.state.executeUpdate(query);
                                         conn.state1.executeUpdate(inserter);
        System.out.println("Inserted into db");                                    
           
                                
                                 response.sendRedirect("../DIC/RiskAssessment.jsp");
                                           
                                          
		
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
                                               Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                                               System.out.println(ex.toString());
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
            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
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
