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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class RiskReduction extends HttpServlet {

 public void doPost(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException,IOException{
                  
     
response.setContentType("text/html");
PrintWriter out = response.getWriter();

dbConnect conn = new dbConnect();
HttpSession session =request.getSession(true);
String UniqueID1 = (String)session.getAttribute("UniqueID");           
String ClientInit1 = (String)session.getAttribute("ClientInit");           
String District1 = (String)session.getAttribute("District");           
String Sex1 = (String)session.getAttribute("Sex");           
String DICName1 = (String)session.getAttribute("DICName");           

               
//____________________GET COMPUTER NAME____________________________________
String computername=InetAddress.getLocalHost().getHostName();
System.out.println("Computer name "+computername);
                


//String ClientInit = request.getParameter("ClientInit").toString();
//String UniqueID = request.getParameter("UniqueID").toString();
//String DICName = request.getParameter("DICName").toString();
String Date = request.getParameter("Date");
String CasualCdUse = request.getParameter("CasualCdUse");
String CdProvided = request.getParameter("CdProvided");
String NoCD = request.getParameter("NoCD");
String RegCdUse = request.getParameter("RegCdUse");
String RegCdAction = request.getParameter("RegCdAction");
String WBLubricant = request.getParameter("WBLubricant");
String WBLubAction = request.getParameter("WBLubAction");
String AlDrugUseScore = request.getParameter("AlDrugUseScore");
String AlDrugUseAction = request.getParameter("AlDrugUseAction");
String HSFTKnowToday = request.getParameter("HSFTKnowToday");
String HSFTKnowTodayAction = request.getParameter("HSFTKnowTodayAction");
String HSFTAppointment = request.getParameter("HSFTAppointment");
String HSFTAppointmentAction = request.getParameter("HSFTAppointmentAction");
String NextAppt= request.getParameter("NextAppt");
String NextApptAction= request.getParameter("NextApptAction");
String HIVTodayTest= request.getParameter("HIVTodayTest");
String HIVTodayTestAction= request.getParameter("HIVTodayTestAction");
String HIVTestPart= request.getParameter("HIVTestPart");
String HIVTestPartAction= request.getParameter("HIVTestPartAction");
String AltIncomeSource= request.getParameter("AltIncomeSource");
String AltIncomeSourceAction= request.getParameter("AltIncomeSourceAction");
String STICheck= request.getParameter("STICheck");
String STICheckAction= request.getParameter("STICheckAction");
String STINextCheck= request.getParameter("STINextCheck");
String STINextCheckAction= request.getParameter("STINextCheckAction");
String CCScreening= request.getParameter("CCScreening");
String CCScreeningAction= request.getParameter("CCScreeningAction");
String CCAppointment= request.getParameter("CCAppointment");
String CCAppointmentAction= request.getParameter("CCAppointmentAction");
String FPCurrentMethod= request.getParameter("FPCurrentMethod");
String FPCurrMAction= request.getParameter("FPCurrMAction");
String FPMethod= request.getParameter("FPMethod");
String FPMethodAction = request.getParameter("FPMethodAction");
String FPMethodType = request.getParameter("FPMethodType");
String FPMethodTypeAction = request.getParameter("FPMethodTypeAction");
String NoMethod = request.getParameter("NoMethod");
String NoMethodAction = request.getParameter("NoMethodAction");
String Cadre = request.getParameter("Cadre");
String NoWBL = request.getParameter("NoWBL");
String TBCheck = request.getParameter("TBCheck");
String TBCheckAppt = request.getParameter("TBCheckAppt");
String TBCheckAction = request.getParameter("TBCheckAction");
String GBVCheck = request.getParameter("GBVCheck");
String GBVCheckAction = request.getParameter("GBVCheckAction");
Date date= new Date(); 
SimpleDateFormat formatter= new SimpleDateFormat("YYYY-MM-dd");
String formattedDate = formatter.format(date);

                

String query = "INSERT INTO riskreduction(ClientInit,UniqueID,DICName,Date,CasualCdUse,CdProvided,NoCD,RegCdUse,RegCdAction,"
        + "WBLubricant,WBLubAction,AlDrugUseScore,AlDrugUseAction,HSFTKnowToday,HSFTKnowTodayAction,HSFTAppointment,"
        + "HSFTAppointmentAction,NextAppt,NextApptAction,HIVTodayTest,"
        + "HIVTodayTestAction,HIVTestPart,HIVTestPartAction,AltIncomeSource,AltIncomeSourceAction,STICheck,STICheckAction,"
        + "STINextCheck,STINextCheckAction,CCScreening,CCScreeningAction,CCAppointment,"
        + "CCAppointmentAction,FPCurrentMethod,FPCurrMAction,FPMethod,FPMethodAction,FPMethodType,FPMethodTypeAction,"
        + "NoMethod,NoMethodAction,Cadre,NoWBL,TBCheck,TBCheckAction,GBVCheck,GBVCheckAction)"
+ " VALUES ('"+ClientInit1+"','"+UniqueID1+"','"+DICName1+"','"+Date+"','"+CasualCdUse+"','"+CdProvided+"','"+NoCD+"',"
        + "'"+RegCdUse+"','"+RegCdAction+"','"+WBLubricant+"',"
     + "'"+WBLubAction+"','"+AlDrugUseScore+"','"+AlDrugUseAction+"','"+HSFTKnowToday+"',"
        + "'"+HSFTKnowTodayAction+"','"+HSFTAppointment+"','"+HSFTAppointmentAction+"','"+NextAppt+"','"+NextApptAction+"',"
        + "'"+HIVTodayTest+"','"+HIVTodayTestAction+"','"+HIVTestPart+"','"+HIVTestPartAction+"','"+AltIncomeSource+"',"
        + "'"+AltIncomeSourceAction+"','"+STICheck+"','"+STICheckAction+"','"+STINextCheck+"','"+STINextCheckAction+"','"+CCScreening+"',"
        + "'"+CCScreeningAction+"','"+CCAppointment+"','"+CCAppointmentAction+"','"+FPCurrentMethod+"','"+FPCurrMAction+"','"+FPMethod+"',"
        + "'"+FPMethodAction+"','"+FPMethodType+"','"+FPMethodTypeAction+"','"+NoMethod+"','"+NoMethodAction+"',"
        + "'"+Cadre+"','"+NoWBL+"','"+TBCheck+"','"+TBCheckAction+"','"+GBVCheck+"','"+GBVCheckAction+"')";
                                           try {
                                               conn.state.executeUpdate(query);
                                               out.println("Inserted into db");
response.sendRedirect("/index_1.jsp");
                                           } catch (SQLException ex) {
                                               Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                                           }





}         
}

                                
                                
                                
                                
                               

 
    
    
    

