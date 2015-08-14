/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enroll;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Enroll extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
                  
     
                   
			   
                                try {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

dbConnect conn = new dbConnect();


String UniqueID = request.getParameter("UniqueID");

String ClientInit = request.getParameter("ClientInit");
String DOE = request.getParameter("DOE").toString();

System.out.println(DOE);
String time = DOE.substring(3,10);
System.out.println(time);
String UniqueCode="";
String District = request.getParameter("district");
String DOB = request.getParameter("DOB");
String DICName = request.getParameter("DICName");
String Sex = request.getParameter("Sex");
String Age = request.getParameter("age");
String MaritalStatus = request.getParameter("MaritalStatus");
String Children = request.getParameter("Children");
String ChildNo = request.getParameter("ChildNo");
String Religion = request.getParameter("Religion");
String EducationLevel = request.getParameter("EducationLevel");
String PhoneNo = request.getParameter("PhoneNo");
String Residence = request.getParameter("Residence");
String OperationArea = request.getParameter("OperationArea");
String Occupation = request.getParameter("Occupation");
String NHIFmember = request.getParameter("NHIFmember");
String NSSFmember = request.getParameter("NSSFmember");
String MFinanceMem= request.getParameter("MFinanceMem");
String WomenGroup= request.getParameter("WomenGroup");
String DICLearn= request.getParameter("DICLearn");
String Email= request.getParameter("Email");
String PhoneNo1= request.getParameter("PhoneNo1");
String Venue= request.getParameter("Venue");
String Age_9= request.getParameter("Age_9");
String Age_14= request.getParameter("Age_14");
String Age_24= request.getParameter("Age_24");
String Age_25= request.getParameter("Age_25");
Date date= new Date(); 
SimpleDateFormat formatter= new SimpleDateFormat("YYYY-MM-dd");
String formattedDate = formatter.format(date);

if(Religion.matches("Other")){
  Religion = request.getParameter("Religion1").toString();
                                }
if(OperationArea.matches("Other")){
  OperationArea = request.getParameter("OperationArea1").toString();
                                }
if(DICLearn.matches("Other")){
  DICLearn = request.getParameter("DICLearn1").toString();
                                }

String FHIClient="FHIClient";
String query1 = "INSERT INTO dummy(FHIClient)"           
  + " VALUES ('"+FHIClient+"')";
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

UniqueCode = District+'/'+time +'/'+ uni;
HttpSession session =request.getSession(true);
session.setAttribute("UniqueCode", UniqueCode);


System.out.println(UniqueCode);
String query = "INSERT INTO enrollment(UniqueID,ClientInit,DOE,District,DOB,DICName,Sex,Age,MaritalStatus,Children,ChildNo,Religion,"
     + "EducationLevel,PhoneNo,Residence,OperationArea,Occupation,NHIFmember,NSSFmember,MFinanceMem,WomenGroup,DICLearn"
        + ",Email,PhoneNo1,Venue,Age_9,Age_14,Age_24,Age_25)"
+ " VALUES ('"+UniqueCode+"','"+ClientInit+"','"+DOE+"','"+District+"','"+DOB+"','"+DICName+"','"+Sex+"','"+Age+"','"+MaritalStatus+"','"+Children+"','"+ChildNo+"',"
     + "'"+Religion+"','"+EducationLevel+"','"+PhoneNo+"','"+Residence+"','"+OperationArea+"','"+Occupation+"','"+NHIFmember+"','"+NSSFmember+"','"+MFinanceMem+"','"+WomenGroup+"','"+DICLearn+"'"
        + ",'"+Email+"','"+PhoneNo1+"','"+Venue+"','"+Age_9+"','"+Age_14+"','"+Age_24+"','"+Age_25+"')";
                                           try {
                                               conn.state.executeUpdate(query);
                                           } catch (SQLException ex) {
                                               Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                                           }


out.println("Inserted into db");
response.sendRedirect("../DIC/home1.jsp");
		
                         if(conn.rs!=null){ conn.rs.close();}
        
         if(conn.state!=null){ conn.state.close();}
        

} 
        catch (SQLException ex) {                    
            Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
        }                    
                
}
}
                                
                                
                                
                                
                               

 
    
    
    
    
    
    
    
    
    
    
    
    
    