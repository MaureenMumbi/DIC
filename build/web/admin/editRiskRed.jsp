<%-- 
    Document   : RiskReduction
    Created on : Aug 8, 2013, 2:14:45 PM
    Author     : Maureen
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
String[] array;
String[] array1;
 dbConnect conn = new dbConnect();
 
 HttpSession session;
 
           
 String RiskID = "";
 String UniqueIDS = "";

%>

<%
//fetching the data stored in the arraylist called userlist 
String UniqueID1=request.getParameter("UniqueID1");
               String UniqueID=request.getParameter("UniqueID");
               
                UniqueIDS= UniqueID1;

               

System.out.println(UniqueIDS +"____"+UniqueID);
session = request.getSession(true);  
RiskID= UniqueID1;


//}
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Risk Reduction Planning</title>
        <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>

	<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
	<link rel="stylesheet" href="themes/eggplant/jquery.ui.all.css">
	
	<link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>

       <script src="../js/datepicker.js"></script>
       <script src="../admin/ui/jquery.ui.datepicker.js"></script>
	
	 <script>	
                $(function() {
                        $( ".datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'2011:2015'
                        });
                });
               
            </script>
	
        <!--Javascript function to calculate age-->  
          
	
           <script type="text/javascript">
function dateGen(){

var x= document.getElementById("DOA").value;
var y = new Array();
y= x.split("/");
// alert(y[0]);
// y[1]+4
//var today = new Date();
var dd = parseInt(y[0]);
var mm= parseInt(y[1])+3;

if (mm > 12){
    var yyyy = parseInt(y[2]) + 1;

var n = mm - 12;
W = yyyy;
}


// alert(n);
// var mm = today.getMonth()+4; //January is 0!

var yyyy = parseInt(y[2]);
// alert(yyyy);
if(dd<10){dd='0'+dd} if(n<10){n='0'+n}
var tomoro = dd+'/'+n+'/'+W;

document.getElementById('nxtapp').value = tomoro;

}
</script>

  
   <script>
function disableOptions1(v) {
  var df = document.risk;
  var HIVTodayTest = df.HIVTodayTest;
  var HIVTestPart = df.HIVTestPart;
  //var location1=df.location1;
if(v==1) {
  HIVTestPart.options[1].disabled = true; HIVTestPart.options[2].disabled = true;
  document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    HIVTestPart.options[0].disabled = false; HIVTestPart.options[1].disabled = false; 
  }
}

function disableOptions2(v) {
  var df = document.risk;
  var STICheck = df.STICheck;
  var STINextCheck = df.STINextCheck;
  //var location1=df.location1;
if(v==1) {
  STINextCheck.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    STINextCheck.disabled = false; 
  }
}

function disableOptions3(v) {
  var df = document.risk;
  var CCScreening = df.CCScreening;
  var CCAppointment = df.CCAppointment;
  //var location1=df.location1;
if(v==0) {
  CCAppointment.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    CCAppointment.disabled = false; 
  }
}

function disableOptions4(v) {
  var df = document.risk;
  var FPCurrentMethod = df.FPCurrentMethod;
  var FPMethod = df.FPMethod;
  var FPMethodType = df.FPMethodType;
  var NoMethod = df.NoMethod;
  //var location1=df.location1;
if(v==0) {
  FPMethod.disabled = false; FPMethodType.disabled = true;
  NoMethod.disabled = true;
  document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  FPMethod.disabled = false; FPMethodType.disabled = false;
  NoMethod.disabled = false; 
  }
}

function disableOptions5(v) {
  var df = document.risk;
  var FPMethod = df.FPMethod;
  var FPMethodType = df.FPMethodType;
  var NoMethod = df.NoMethod;
  //var location1=df.location1;
if(v==0) {
  FPMethodType.disabled = false; NoMethod.disabled = true;
  document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  FPMethodType.disabled = true; NoMethod.disabled = true;
  }
}

function disableOptions6(v) {
  var df = document.risk;
  var CdProvided = df.CdProvided;
  var NoCD = df.NoCD;
  
  //var location1=df.location1;
if(v==0) {
  NoCD.disabled = false; 
  //document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  NoCD.disabled = true; 
  }
}

function disableOptions7(v) {
  var df = document.risk;
  var WBLubProvided = df.WBLubProvided;
  var NoWBL = df.NoWBL;
  
  //var location1=df.location1;
if(v==0) {
  NoWBL.disabled = false; 
  //document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  NoWBL.disabled = true; 
  }
}

function disableOptions11(v) {
  var df = document.risk;
  var HSFTAppointment = df.HSFTAppointment;
  var NextApptAction = df.NextApptAction;
  
  //var location1=df.location1;
if(v==0) {
  NextApptAction.disabled = false; 
  //document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  NextApptAction.disabled = true; 
  }
}
  </script>
        
   <link rel="StyleSheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <style type="text/css">
    #container{
               height:610px;
               width:1230px;
                
    }
     .example {
    height:900px;
    width:1350px;
     
     }
    </style>
  
<link href="css/demo_style.css" rel="stylesheet" type="text/css">

<link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.smartWizard.js"></script>

<link href="css/demo_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
   
    $(document).ready(function(){
    	// Smart Wizard     	
  		$('#wizard').smartWizard({transitionEffect:'slideleft',onLeaveStep:leaveAStepCallback,onFinish:onFinishCallback,enableFinishButton:true});

      function leaveAStepCallback(obj){
        var step_num= obj.attr('rel');
        return validateSteps(step_num);
      }
      
      function onFinishCallback(){
       if(validateAllSteps()){
        $('form').submit();
       }
      }
            
		});
	   
    function validateAllSteps(){
       var isStepValid = true;
       
       if(validateStep1() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:false});
       }
       
       if(validateStep3() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:3,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:3,iserror:false});
       }
       
       if(!isStepValid){
          $('#wizard').smartWizard('showMessage','Please correct the errors in the steps and continue');
       }
              
       return isStepValid;
    } 	
		
		
		function validateSteps(step){
		  var isStepValid = true;
      // validate step 1
      if(step == 1){
        if(validateStep1() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please correct the errors in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      // validate step3
      if(step == 3){
        if(validateStep3() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please correct the errors in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      return isStepValid;
    }
		
		function validateStep1(){
       var isValid = true; 
       // Validate Username
       var un = $('#Cadre').val();
       if(!un && un.length <= 0){
         isValid = false;
         $('#msg_Cadre').html('Please fill Cadre').show();
       }else{
         $('#msg_Cadre').html('').hide();
       }
       
       // validate password
       var pw = $('#DOA').val();
       if(!pw && pw.length <= 0){
         isValid = false;
         $('#msg_DOA').html('Please fill DOA').show();         
       }else{
         $('#msg_DOA').html('').hide();
       }
       
       // validate confirm password
//       var cpw = $('#cpassword').val();
//       if(!cpw && cpw.length <= 0){
//         isValid = false;
//         $('#msg_cpassword').html('Please fill confirm password').show();         
//       }else{
//         $('#msg_cpassword').html('').hide();
//       }  
       
       // validate password match
//       if(pw && pw.length > 0 && cpw && cpw.length > 0){
//         if(pw != cpw){
//           isValid = false;
//           $('#msg_cpassword').html('Password mismatch').show();            
//         }else{
//           $('#msg_cpassword').html('').hide();
//         }
//       }
       return isValid;
    }
       function validateStep3(){
     var isValid = true;  }  
      //validate email  email
//      var email = $('#email').val();
//       if(email && email.length > 0){
//         if(!isValidEmailAddress(email)){
//           isValid = false;
//           $('#msg_email').html('Email is invalid').show();           
//         }else{
//          $('#msg_email').html('').hide();
//         }
//       }else{
//         isValid = false;
//         $('#msg_email').html('Please enter email').show();
//       }       
           //return isValid;
//    }
//    
//    // Email Validation
//    function isValidEmailAddress(emailAddress) {
//      var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
//      return pattern.test(emailAddress);
   // } 
		
		
</script>


 
 <style>
.swMain ul.anchor {
    width:1300px;
}
.swMain .stepContainer {
   width:1220px;}
.actionBar{  width:1220px;}
</style>
    </head>
    <body>
         

<div class="example" >
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
               if(session.getAttribute("loggedIn")==null){
                   response.sendRedirect("/DIC/index.jsp");
             } else{
     %>
                   <a class="button-1" href="../logoutServlet">LogOut</a> 
     <%
               }
        String username=(String)session.getAttribute("Username");
      
               if(username==null){
                   
               } else{
     %>
               <h5>Welcome <%=username%></h5>
     <%
               }
        
 
      %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
    <div style="width:1350px;"> 
           <!--=========================================menu=========================================-->     
            
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="../menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="../menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="../menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
    
           

        <div id ="container">
            
     <div class="demoHead">   
  <h2>Risk Reduction</h2>
</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
                <form name="risk"  method="post" action="/DIC/EditRiskReduction">
                    
                     <input type='hidden' name="issubmit" value="1">
                      
<!-- Tabs -->
  		<div id="wizard" class="swMain">
  			<ul>
  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                 Qstns A & B<br />
                   <small>Fill details marked <font style="color: blue">*</font></small>
                </span>
            </a></li>
                           
  				<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                  Qstns C & D<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                  Qstns E & F<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
             </a></li>
  				<li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                  Qstns G & H<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  				<li><a href="#step-5">
                <label class="stepNumber">5</label>
                <span class="stepDesc">
                  Qstns I, J & K<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  			</ul>
              
         <div id="step-1" style="height: 350px; width:1230px;">	
            <h2 class="StepTitle">Step 1: Questions A & B</h2>
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
      <input type="hidden"  name="RiskID" value="<%= RiskID %>" >     
      
    
     
<tr class="d0">
   
<!--    <td>Date of Assessment</td>-->
 <% 
                            String QstnQuery= "SELECT QuestionsID,Question FROM questions where ID=58";
                              System.out.println(QstnQuery);                   
   
                                                         conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery);
                                                      while(conn.rs.next())
                                                           {
                                                          System.out.println(conn.rs.getString("Question"));
                                                   %>                                                                       
            <td><input type="text" name="QIDA1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly><font style="color: red">*</font></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
                <% 
            
                            //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans1="SELECT DOA FROM riskreductionmain WHERE RiskReductionID ='"+RiskID+"'"; 
    System.out.println(Ans1);
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans1);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                          System.out.println(conn.rs.getString("DOA"));
                                                   %>  
            
            <td><input type="text" name="DOA" class="datepicker" readonly title="Enter date" id="DOA" value="<%=conn.rs.getString("DOA")%>" onclick="return date()"  required></td></tr>
                                                  
               
                                                   <%
                                                                                                         }
                            else{
                                                   %>
              <td><input type="text" name="DOA" class="datepicker" title="Enter date" id="DOA" value="" onclick="return date()"  required></td></tr>
            <%}%>
    
           
           
                <tr class="d1">
<!--                    <td>Cadre of provider</td>-->
<% 
                            String QstnQuery1= "SELECT QuestionsID,Question FROM questions where ID=59";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery1);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDA2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
                    <td><select name="Cadre" id="Cadre">
                            <option value=""></option> 
                          <%   
                          
                        
                          String Ans2="SELECT CadreProvider FROM riskreductionmain WHERE RiskReductionID ='"+RiskID+"'";  
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans2);
                                                      while(conn.rs.next()){
                                                          
                                                        String a= conn.rs.getString("CadreProvider");
                                                           
                            
                            String QueryConverta= "SELECT CadreCode,CadreCodeID FROM cadrecode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConverta);
                                                      while(conn.rs.next()){
                                                          ArrayList cadre = new ArrayList();
                                                    ArrayList cadre1 = new ArrayList();
                                                    
                                                      if(cadre!= null && cadre.size()!=0){
                                                    cadre.clear();
                                                    }  if(cadre1!= null && cadre1.size()!=0){
                                                    cadre1.clear();
                                                    }
                                                          
                                                           cadre.add(conn.rs.getString("CadreCode"));
                                                           cadre1.add(conn.rs.getString("CadreCodeID"));
                                                      String queryalcohol =  "SELECT CadreCode,CadreCodeID FROM cadrecode where CadreCodeID='"+a+"'";
   if(conn.state2.isClosed()){conn= new dbConnect();}                                                              
                                                      conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String cadrecodes="";
                                                                while(conn.rs2.next()){
                                                                 cadrecodes=  conn.rs2.getString("CadreCode"); 
                                                                }

                                                 for(int n=0;n<cadre.size();n++){
                
  if(cadre.get(n).equals(cadrecodes)){
                                      %>
                                 
                    
                <option selected value="<%= cadre1.get(n)%>"><%=cadre.get(n)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= cadre1.get(n)%>"><%=cadre.get(n)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                   
                    

</select>

            </td></tr>
                <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td>Indicate Action Taken</td></tr> 
                   <tr class="d1">
<!--                       <td>100% Condom use with paying partners</td>-->
<% 
                            String QstnQuery2= "SELECT QuestionsID,Question FROM questions where ID=60";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery2);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
;                                                      }
                                
                                                           
                                                   %>
                       <td><select name="CasualCdUse">
                              <% 
            
                     String B1="B1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans3="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+B1+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans3);
   
                            
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                    String b= conn.rs.getString("currentStatus");
                                                           
                            
                            String QueryConvertb= "SELECT currentStatusID,currentStatus FROM currentStatus";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertb);
                                                      while(conn.rs.next()){
                                                          ArrayList status = new ArrayList();
                                                    ArrayList status1 = new ArrayList();
                                                    
                                                      if(status!= null && status.size()!=0){
                                                    status.clear();
                                                    }  if(status1!= null && status1.size()!=0){
                                                    status1.clear();
                                                    }
                                                          
                                                           status.add(conn.rs.getString("currentStatus"));
                                                           status1.add(conn.rs.getString("currentStatusID"));
                                                      String querystatus=  "SELECT currentStatusID,currentStatus FROM currentStatus where currentStatusID='"+b+"'";
                                                        if(conn.state2.isClosed()){conn= new dbConnect();}                                                            
                                                        conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                                String statuscodes="";
                                                                while(conn.rs2.next()){
                                                                 statuscodes=  conn.rs2.getString("currentStatus"); 
                                                                }

                                                 for(int n=0;n<status.size();n++){
                
  if(status.get(n).equals(statuscodes)){
                                      %>
                                 
                    
                <option selected value="<%= status1.get(n)%>"><%=status.get(n)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= status1.get(n)%>"><%=status.get(n)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                         </select>
                        </td>
                        
<!--                        <td style="width:200px;">Condoms Provided Today?
       </td>-->

<% 
                            String QstnQuery3= "SELECT QuestionsID,Question FROM questions where ID=62";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery3);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB1.1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
             </td>
                                                   <%
                                                       
                                                      }
                                
                                                           
                                                   %>
                        <td> <select name="CdProvided" id="CdProvided" onChange="disableOptions6(this.selectedIndex);">
                                  <% 
            
                     String B1A="B1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans4="SELECT Action FROM riskreductiondetails  WHERE QID='"+B1A+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans4);
   
                            
                                                    
                                                     if(conn.rs.next()==true)
                                                           {
                                                        String arr= conn.rs.getString("Action");
                                                        array =arr.split("_");
//                                                        
                                                   
                       
                       if(conn.rs.getString("Action")!=null && !conn.rs.getString("Action").equals("")&& !conn.rs.getString("Action").equals("_") ) {                                                 
   if(!array[0].equals("") && array[0]!=null){   
                      if(array[0].equals("Condoms were provided")){%>  
            
           
                                         <option selected value="<%=conn.rs.getString("Action")%>">Yes</option>         
                                         <option value="Condoms not provided">No</option>         
               
                                                   <%  }else{%>
                                                            <option value="Condoms were provided">Yes</option>   
                                                            <option selected value="<%=conn.rs.getString("Action")%>">No</option>   
                                                            <%    }                  }}}
                                                               else{%>
                                                                 <option value="Condoms were provided">Yes</option>   
                                                            <option selected value="Condoms not provided">No</option>   
                                                            <%    
                                                         }
                                                               %>
                               
                           </select>
                        </td>
                </tr>
                        <tr class="d0">
                            <td></td><td></td>
<!--                            <td>if yes,how many condoms?</td>-->

<% 
                            String QstnQuery5= "SELECT QuestionsID,Question FROM questions where ID=63";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery5);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB1.2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" id="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                                                           
                                                   %>
                            <td>
                                
                                 <% 
            
                     String B1b="B1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans5="SELECT Action FROM riskreductiondetails  WHERE QID='"+B1b+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans5);
   
                            
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                  String arr= conn.rs.getString("Action");
                                                        array =arr.split("_");
//                                                       
                                                   
                       
                      
                      
                                  if(array.length == 2){%>
                                           
                                            <input type="text" name="NoCD" id="NoCD" value="<%=array[1]%>">
                                                   <%}
                      
                                           else{%>
                                          <input type="text" name="NoCD" id="NoCD" value="">          
                                            
                                            
                                            <%}
                      
                      
                      }
                                                                                    
                       %>
                                
                       
                        </td>
                        </tr>  
                        <tr class="d1">
<!--                            <td>100% condom use with non-paying partner(s)</td>-->
<% 
                            String QstnQuery4= "SELECT QuestionsID,Question FROM questions where ID=61";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery4);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
                            <td><select name="RegCdUse">
                                    
                                      <option value=""></option>
                                     
                                     
                                      <% 
            
                     String B2="B2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans6="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+B2+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans6);
   
                            
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                  String k= conn.rs.getString("currentStatus");
                                                           
                            
                            String QueryConvertk= "SELECT currentStatusID,currentStatus FROM currentStatus ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertk);
                                 ArrayList status = new ArrayList();
                                                    ArrayList status1 = new ArrayList();
                                                     if(status!= null && status.size()!=0){
                                                    status.clear();
                                                    }  if(status1!= null && status1.size()!=0){
                                                    status1.clear();
                                                    }
                                                          
                                                status.add("N/A");
                                                 status1.add("4");
                                                     while(conn.rs.next()){
                                                           status.add(conn.rs.getString("currentStatus"));
                                                       
                                                           status1.add(conn.rs.getString("currentStatusID"));
                                                          
                                                      String querystatus=  "SELECT currentStatusID,currentStatus FROM currentStatus where currentStatusID='"+k+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                                String statuscodes="";
                                                                while(conn.rs2.next()){
                                                                 statuscodes=  conn.rs2.getString("currentStatus"); 
                                                                }

                                                 for(int n=0;n<status.size();n++){
                
  if(status.get(n).equals(statuscodes)){
                                      %>
                                 
                    
                <option selected value="<%= status1.get(n)%>"><%=status.get(n)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= status1.get(n)%>"><%=status.get(n)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>

                       
              
                         </select>
                        </td>
                        <td></td>
                         <% 
            
                     String B2a="B2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans7="SELECT Action FROM riskreductiondetails  WHERE QID='"+B2a+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans7);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
            

            <td><input type="text" name="RegCdAction" id="RegCdAction" value="<%=conn.rs.getString("Action")%>" ></td>
                                               
               
                                                   <%  
                                                                                    }
                                                       else{
                       %>
                        <td><input type="text" name="RegCdAction" id="RegCdAction" value="" ></td>
                       
                       
<%}%>


                      
                        </tr>
                        <tr class="d0">
<!--                            <td>Water-Based Lubricants</td>-->
<% 
                            String QstnQuery6= "SELECT QuestionsID,Question FROM questions where ID=64";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery6);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB3"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
                            <td><select name="WBLubricant">
                                     <option value=""></option>
                                       <% 
            
                     String B3a="B3";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Anst="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+B3a+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Anst);
   
                           
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                  String j= conn.rs.getString("currentStatus");
                                                           
                            
                            String QueryConvertj= "SELECT currentStatusID,currentStatus FROM currentStatus ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertj);
                                                        while(conn.rs.next()){
                                                          ArrayList status = new ArrayList();
                                                    ArrayList status1 = new ArrayList();
                                                    
                                                      if(status!= null && status.size()!=0){
                                                    status.clear();
                                                    }  if(status1!= null && status1.size()!=0){
                                                    status1.clear();
                                                    }
                                                          
                                                           status.add(conn.rs.getString("currentStatus"));
                                                           status1.add(conn.rs.getString("currentStatusID"));
                                                      String querystatus=  "SELECT currentStatusID,currentStatus FROM currentStatus where currentStatusID='"+j+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                                String statuscodes="";
                                                                while(conn.rs2.next()){
                                                                 statuscodes=  conn.rs2.getString("currentStatus"); 
                                                                }

                                                 for(int n=0;n<status.size();n++){
                
  if(status.get(n).equals(statuscodes)){
                                      %>
                                 
                    
                <option selected value="<%= status1.get(n)%>"><%=status.get(n)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= status1.get(n)%>"><%=status.get(n)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>

    
                         </select>
                        </td>
                        
<!--                        <td style="width:200px;">Water-Based Lubricants Provided today-->
<% 
                            String QstnQuery7= "SELECT QuestionsID,Question FROM questions where ID=65";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery7);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB3.1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>                                                


                        <td> <select name="WBLubProvided" id="WBLubProvided" onChange="disableOptions7(this.selectedIndex);">
                                 <option value=""></option>
                                
                                
                                      <% 
            
                     String B3="B3";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans8="SELECT Action FROM riskreductiondetails  WHERE QID='"+B3+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans8);
   
                            if(conn.rs.next()==true)   {
                                                    String arr1= conn.rs.getString("Action");
                                                        array1 =arr1.split("_");
                                                        
   if(conn.rs.getString("Action")!=null && !conn.rs.getString("Action").equals("")&& !conn.rs.getString("Action").equals("_") ) {                                                 
   if(!array1[0].equals("") && array1[0]!=null){                        
if(array1[0].equalsIgnoreCase("WBL Provided")){%>  
            
           
                                         <option selected value="<%=conn.rs.getString("Action")%>">Yes</option>         
                                         <option value="WBL Not Provided">No</option>         
               
                                                   <%  }
                                                        else{%>
                                                            <option value="WBL Provided">Yes</option>   
                                                            <option selected value="<%=conn.rs.getString("Action")%>">No</option>   
                                                            <%    }}             }
                                                        else if (conn.rs.getString("Action")=="_"){%>
                                                            <option value="WBL Provided">Yes</option>   
                                                            <option value="WBL Not Provided">No</option>   

<%}                                                            }
                                
                                 else{%>
                                                            <option value="WBL Provided">Yes</option>   
                                                            <option value="WBL Not Provided">No</option>   

<%} %>
                        
                           </select>
                        </td>
                        
                        </tr>
                        <tr class="d0">
                            <td></td><td></td>
<!--                            <td>if yes,how many WBL?</td>-->

<% 
                            String QstnQuery8= "SELECT QuestionsID,Question FROM questions where ID=66";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery8);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB3.2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                         
                                                   
                       if(array.length!=0) 
                       {
                      if(array1.length==2){  %>  
            <td> <input type="text" name="NoWBL" value="<%= array1[1] %>" id="NoWBL"></td>
             
            
            <%
                       } }else { %>
                        <td>  <input type="text" name="NoWBL" value="" id="NoWBL"> <td>
             <% }%>
                          
         
                                               
               

            
            
                        </tr> 
                          </table>          			
        </div>
                    <div id="step-2" style="height:350px; width:1206px;">
            <h2 class="StepTitle">Step 2: Questions C & D</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
            
                                <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td style="colspan:3">Indicate Action Taken</td></tr> 
                        
                        
                <tr class="d1">
                            <td>Alcohol and other drug use</td>
<!--                            <td>Audit Score:</td>-->
<% 
                            String QstnQuery9= "SELECT QuestionsID,Question FROM questions where ID=67";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery9);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDC"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
                            
            
                       
                               <% 
            
                     String C="C";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans10="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+C+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans10);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
            
                                                   <td> <input type="text" name="AlDrugScore" id="AlDrugScore" value="<%=conn.rs.getString("currentStatus")%>">
                                               
                                                   </td>
                                                   <%  
                                                                                    }
                                                       else{
                       %>

                     <td> <input type="text" name="AlDrugScore" id="AlDrugScore" value="">
                                
                                <%
                                                       }
%>
                  <% 
            
                     String Ca="C";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans11="SELECT Action FROM riskreductiondetails  WHERE QID='"+Ca+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans11);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
                                                   
                  <td><input type="text" name="AlDrugUseAction" value="<%=conn.rs.getString("Action")%>"></td>
            
               
                                                   <%  
                                                                                    }
                                                       else{
                       %>
                  <td><input type="text" name="AlDrugUseAction" value=""></td>
                         
                  <%
                                                       }
                            %>
                                
                        
                       
                        </tr>
                         <tr class="d0">
<!--                            <td>Knowledge on HIV,STIs,FP,TB </td>-->
<% 
                            String QstnQuery10= "SELECT QuestionsID,Question FROM questions where ID=68";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery10);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDD1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                                                           
                                                   %>
                              <td>
                          <select name="HSFTKnowToday">
                              
                             <% 
            
                     String D1="D1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans12="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+D1+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans12);
   
                            
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                          
                                                          String k=conn.rs.getString("currentStatus");
                                                   String QueryConvertk= "SELECT Knowledge_CodeID,Knowledge_Code FROM knowledge_code ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertk);
                                                        while(conn.rs.next()){
                                                          ArrayList knowledge = new ArrayList();
                                                    ArrayList knowledge1 = new ArrayList();
                                                    
                                                      if(knowledge!= null && knowledge.size()!=0){
                                                    knowledge.clear();
                                                    }  if(knowledge1!= null && knowledge1.size()!=0){
                                                    knowledge1.clear();
                                                    }
                                                          
                                                           knowledge.add(conn.rs.getString("Knowledge_Code"));
                                                           knowledge1.add(conn.rs.getString("Knowledge_CodeID"));
                                                      String querystatus=  "SELECT Knowledge_CodeID,Knowledge_Code FROM knowledge_code where Knowledge_CodeID='"+k+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querystatus);
                                                                String statuscodes="";
                                                                while(conn.rs2.next()){
                                                                 statuscodes=  conn.rs2.getString("Knowledge_Code"); 
                                                                }

                                                 for(int n=0;n<knowledge.size();n++){
                
  if(knowledge.get(n).equals(statuscodes)){
                                      %>
                                 
                    
                <option selected value="<%= knowledge1.get(n)%>"><%=knowledge.get(n)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= knowledge1.get(n)%>"><%=knowledge.get(n)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>


</select>
                              </td>           
                              <td></td>
                       
                         
                          <% 
            
                     String D1A="D1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans13="SELECT Action FROM riskreductiondetails  WHERE QID='"+D1A+"' AND RiskReductionID ='"+RiskID+"'";  
     conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Ans13);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
                                                   
                 <td><input type="text" name="HSFTKnowTodayAction" value="<%=conn.rs.getString("Action")%>"></td>
          
                                                   <%  
                                                                                    }
                                                       else{
                       %>
                        <td><input type="text" name="HSFTKnowTodayAction" value=""></td>
               <%}%>
                       
                        </tr>
                        <tr class="d1">
                            <td></td>
<!--                            <td>Health Education provided today</td>-->
<% 
                            String QstnQuery11= "SELECT QuestionsID,Question FROM questions where ID=69";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(QstnQuery11);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <td><input type="text" name="QIDD2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                 <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>
                            <td>
                            <select name="HealthEducation" id="HealthEducation" onChange="disableOptions11(this.selectedIndex);">
                                  <% 
            
                     String D2="D2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans14="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+D2+"' AND RiskReductionID ='"+RiskID+"'"; 
     conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Ans14);
   
                            
                                                    
                                                     String yesno1="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno1=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno1.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno1%>"> <%=yesno1%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno1.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno1%>"> <%=yesno1%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                
              
                                 </select></td>
                                 
                                   <% 
            
                     String D2A="D2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans15="SELECT Action FROM riskreductiondetails  WHERE QID='"+D2A+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Ans15);
   
                         
                                                    
                                                      if(conn.rs.next()==true)
                                                            {
                                                   %>  
              
                 <td><input type="text" name="HealthEducationAction" value="<%=conn.rs.getString("Action")%>"></td>
          
                                                   <%  
                                                                                    }
                                                       else{
                       %>
                                
                                  <td><input type="text" name="HealthEducationAction" value=""></td>
                                 
                                 <%}%>
                            
                        </tr>
                        <tr class="d0"><td></td>
<!--                            <td>Appointment for next session(s)</td>-->
<% 
                            String QstnQuery12= "SELECT QuestionsID,Question FROM questions where ID=70";
                                                    
				 conn.rs = conn.state.executeQuery(QstnQuery12);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <td><input type="text" name="QIDD3"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                 <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                    }
                                
                                                           
                                                   %>
            
             <% 
            
                     String D3a="D3";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans17="SELECT Appointments FROM riskreductiondetails  WHERE QID='"+D3a+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans17);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
                                                   <td><input type="text" class="datepicker" value="<%=conn.rs.getString("Appointments")%>" onclick="return date()" name="NextApptAction"></td>
           
                                                   <%  
                                                                                    }
                                                       else{
                       %>              

              <td><input type="text" class="datepicker" value="" onclick="return date()" name="NextApptAction"></td>
            <%
                                                       }
                            %>
            
            
            
 <% 
            
                     String D3="D3";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans16="SELECT Action FROM riskreductiondetails  WHERE QID='"+D3+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans16);
   
                            
                                                    
                                                     if(conn.rs.next()==true)
                                                           {
                                                   %>  
                
             <td><input type="text" value="<%=conn.rs.getString("Action")%>" name="NextAppt"></td>
                                                   <%  
                                                                                    }
                                                       else{
                       %>
                   <td><input type="text" value="" name="NextAppt"></td>              
             <%}%>
                        </tr>
                          
                           
                        </table></div>
                                       
  <div id="step-3" style="height:350px; width:1206px;">
            <h2 class="StepTitle">Step 3: Questions E & F</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>  
                         <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td>Indicate Action Taken</td></tr> 
                        
                        <tr class="d1">
                            <td>HIV Testing</td>
                        
<!--                            <td>Tested today</td>-->
<% 
                            String QstnQuery13= "SELECT QuestionsID,Question FROM questions where ID=71";
                                                    
				conn.rs = conn.state.executeQuery(QstnQuery13);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDE1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                                                           
                                                   %>
                            <td>
                                <select name="HIVTodayTest" id="HIVTodayTest" onChange="disableOptions1(this.selectedIndex);">
                                     <% 
            
                     String E1="E1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans18="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+E1+"' AND RiskReductionID ='"+RiskID+"'"; ; 
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans18);
   
                            
                                                    
                                                     
                                                    
                                                     String yesno2="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno2=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno2.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno2%>"> <%=yesno2%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno2.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno2%>"> <%=yesno2%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                
                                 </select></td> 
                                 
                         <td>        <select name="HIVTodayTestStatus" id="HIVTodayTestStatus" onChange="disableOptions1(this.selectedIndex);">     
                              
                                    
                                    <%
                                    

                     String E1A="E1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans19="SELECT Action FROM riskreductiondetails  WHERE(QID='QIDE1_0_self' || QID='E1') AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans19);
   
                           
                                                    
                                                      while(conn.rs.next())
                                                      {  if(conn.rs.getString("Action")!=""){
                                                        System.out.println("|||"+conn.rs.getString("Action"));  
                                          if(conn.rs.getString("Action").equals("P")){

%>  
                            
                                    <option value=""></option>
                                    <option selected value="P">P(Positive)</option>  
                                    <option value="N">N (Negative)</option> 
                                     
                                    <%
                                                          }
                    
                                           if(conn.rs.getString("Action").equalsIgnoreCase("N")){

%>
                            
                                    <option value=""></option>
                                    <option  value="P">P (Positive)</option>  
                                    <option selected value="N">N (Negative)</option> 
                                      
                                    <%
                                                                                             }
                                                                             }
                                                                                 }
                                                
if(conn.rs.next()==false) {%>

                                    <option value=""></option>
                                    <option  value="P">P (Positive)</option>  
                                    <option  value="N">N (Negative)</option> 
                                                                 
         <%                  
                                                                                     }               
                                         
                     %>
                             </select>  </td>
<td>
                              <select name="HIVTodayAction" id="HIVTodayAction" onChange="disableOptions1(this.selectedIndex);">
                                <% 
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans1_9="SELECT Action FROM riskreductiondetails  WHERE QID='QIDE1_1_self' AND RiskReductionID ='"+RiskID+"'";  
    System.out.println(Ans1_9);
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans1_9);
   if(conn.rs.next()== true){
       
if(conn.rs.getString("Action").equalsIgnoreCase("Referred")){
%>
                                  <option value=""></option> 
                                    <option selected value="Referred">Referred</option>  
                                    <option value="On Care">On care</option>  
                                    
                                    <% }
         else if(conn.rs.getString("Action").equalsIgnoreCase("On Care")){%>
                                    <option value=""></option> 
                                    <option  value="Referred">Referred</option>  
                                    <option selected value="On Care">On care</option>  
                                  
  <% }}else{
                                %>
                                
                                
                              <option value=""></option> 
                                    <option  value="Referred">Referred</option>  
                                    <option  value="On Care">On care</option>  
                                   
                                
                                <%}%>
                                
                                </select> 
                                </td>
                                
                                
                                
                                
                                                         <%
                                    

                                              //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans191="SELECT Action FROM riskreductiondetails  WHERE QID='"+E1+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans191);
   
                           
                                                    
                                                      if(conn.rs.next()==true)
                                                      {
                                                   if(!conn.rs.getString("Action").equals("P") ||!conn.rs.getString("Action").equals("N") )       
                                                                                                       {                     
                                              %>
                     <td><input type="text" name="HIVTodayTestAction" value="<%=conn.rs.getString("Action")%>"></td>       
                           
                           <%
                           }}
                                                      
%>
                                
                                
                        </tr>                   
                        <tr class="d0"> <td></td>
                            <% 
                            String QstnQuery14= "SELECT QuestionsID,Question FROM questions where ID=72";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery14);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDE2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
<!--                            <td>Tested with partner?</td>-->
                            <td>
                                <select name="HIVTestPart" id="HIVTestPart">
                                         <% 
            
                     String E2="E2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans20="SELECT currentStatus FROM riskreductiondetails  WHERE (QID='"+E2+"' ||  QID='QIDE1_status') AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans20);
   
                            
                                                    
                                                       String yesno3="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno3=conn.rs.getString("currentStatus");
                                                           
                                                           System.out.println("___"+yesno3);
                                                      
                                                          
                                                          // if( !conn.rs.getString("currentStatus").equals(null) ){
                                                               
                                                                System.out.println("---"+yesno3);
                                                                if(conn.rs.getString("currentStatus")!=""){
                                                          if(conn.rs.getString("currentStatus").equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno3%>">  <%=yesno3%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(conn.rs.getString("currentStatus").equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno3%>"> <%=yesno3%></option>
                                                       
                                                                                                           <%        } }
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes"> Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }}
                                %>
                                 </select>
                            </td> 
                            
                            
                                                      
                              
                                    
                                    <%
                                    

                     
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans192="SELECT Action FROM riskreductiondetails  WHERE QID='QIDE1_partner' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans192);
   
                           
                                                    
                                                      if(conn.rs.next()==true)
                                                      {
                                                          
                                                          if(conn.rs.getString("Action").equalsIgnoreCase("P")){

%>    <td><select name="HIVTestPartStatus" id="HIVTodayTestPartStatus" onChange="disableOptions1(this.selectedIndex);">
                            
                                    <option value=""></option>
                                    <option selected value="P">P (Positive)</option>  
                                    <option value="N">N (Negative)</option> 
                                       </select> 
                                </td>
                                    <%
                                                          }
                    
                                                         if(conn.rs.getString("Action").equalsIgnoreCase("N")){

%>
   <td> <select name="HIVTestPartStatus" id="HIVTodayTestPartStatus" onChange="disableOptions1(this.selectedIndex);">
                            
                                    <option value=""></option>
                                    <option  value="P">P (Positive)</option>  
                                    <option selected value="N">N (Negative)</option> 
                                       </select> 
                                </td>
                                    <%
                                                                                             }
                      
                         
                                                
else {%>
<td>     <select name="HIVTestPartStatus" id="HIVTodayTestPartStatus" onChange="disableOptions1(this.selectedIndex);">
                                    <option value=""></option>
                                    <option  value="P">P (Positive)</option>  
                                    <option  value="N">N (Negative)</option> 
                                       </select> 
                                </td>                            
         <%                 } 
                                             
                                         
                           } 
                       else{                                                        
%>
   <td>     <select name="HIVTestPartStatus" id="HIVTodayTestPartStatus" onChange="disableOptions1(this.selectedIndex);">
                                    <option value=""></option>
                                    <option  value="P">P (Positive)</option>  
                                    <option  value="N">N (Negative)</option> 
                                       </select> 
                                </td>                            
                            
                            
                             <% 
                                        }
                     String E2A="E2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans21="SELECT Action FROM riskreductiondetails  WHERE QID='"+E2A+"'  AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans21);
   
                            
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                            <td><input type="text" name="HIVTestPartAction" value="<%=conn.rs.getString("Action")%>"></td>
                        
           
                                                   <%  
                                                                                    }
                                                       else{
                       %> 
                       
                        <td><input type="text" name="HIVTestPartAction" value=""></td>
                          <%
                                                   }
  %> 
                        </tr>
                        
              

                        <tr class="d0">
                            <td>Sexually Transmitted Infections(STIs)</td>
<!--                            <td>Provided an STI checkup today</td>-->
<% 
                            String QstnQuery15= "SELECT QuestionsID,Question FROM questions where ID=73";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery15);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDF1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
                            <td><select name="STICheck" id="STICheck" onChange="disableOptions2(this.selectedIndex);">
                                       <% 
            
                     String F1="F1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans22="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+F1+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans22);
   
                            
                                                    
                                                      String yesno4="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno4=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno4.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno4%>"> <%=yesno4%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno4.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno4%>"> <%=yesno4%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                                 </select>
                            </td>                        
                          <% 
            
                     String F1A="F1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans23="SELECT Action FROM riskreductiondetails  WHERE QID='"+F1A+"' AND RiskReductionID ='"+RiskID+"'"; 
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans23);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                        <td><input type="text" name="STICheckAction" value="<%=conn.rs.getString("Action")%>"></td> 
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %> 
                        <td><input type="text" name="STICheckAction" value=""></td>     
                           
                        <%}%>
                        </tr>
                        <tr class="d1">
                            <td></td>
<!--                            <td>Next Checkup date</td>-->
<% 
                            String QstnQuery16= "SELECT QuestionsID,Question FROM questions where ID=74";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery16);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDF2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                           
                                                   %>
            
            
              <% 
            
                     String F2="F2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans24="SELECT Appointments FROM riskreductiondetails  WHERE QID='"+F2+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans24);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                     
                         <td><input type="text" name="STINextCheck" id="STINextCheck" class="datepicker" title="Enter date" onclick="return date()"  value="<%=conn.rs.getString("Appointments")%>" required ></td>
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %> 
                       <td><input type="text" name="STINextCheck" id="STINextCheck" class="datepicker" title="Enter date" onclick="return date()"  value="" required ></td>
                       <%
                                             }
             %>
                           
                  <% 
            
                     String F2A="F2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans25="SELECT Action FROM riskreductiondetails  WHERE QID='"+F2A+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans25);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                     
                         <td><input type="text" name="STINextCheckAction" id="STINextCheckAction"  title="Enter date" onclick="date();"  value="<%= conn.rs.getString("Action")%> "  ></td>
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>           
                                             <td><input type="text" name="STINextCheckAction" id="STINextCheckAction"  title="Enter date" onclick="date();"  value=""  ></td>
                        
                           <%}%> 
                        
                        </tr>
                         </table>
  </div>
                          
                          
                          
  			<div id="step-4" style="height:350px; width:1206px;">
            <h2 class="StepTitle">Step 4: Questions G & H</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                 
                        
                        
                        
                         <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td>Indicate Action Taken</td></tr> 
                        <tr class="d0">
                            <td>Cervical Cancer Screening</td>
<!--                            <td>Screened Today</td>-->
<% 
                            String QstnQuery17= "SELECT QuestionsID,Question FROM questions where ID=75";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery17);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDG1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                     }
                                
                                                           
                                                   %>
                            <td>
                                <select name="CCScreening" id="CCScreening" onChange="disableOptions3(this.selectedIndex);" >
                                      <% 
            
                     String G1="G1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans26="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+G1+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans26);
   
                                    
                                                    
                                                    String yesno5="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno5=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno5.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno5%>"> <%=yesno5%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno5.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno5%>"> <%=yesno5%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                             <option value=""></option>
                              <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                                 </select>
                            </td>                        
                          <% 
            
                     String G1A="G1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans27="SELECT Action FROM riskreductiondetails  WHERE QID='"+G1A+"' AND RiskReductionID ='"+RiskID+"'"; ; 
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans27);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                      <td><input type="text" name="CCScreeningAction" value="<%=conn.rs.getString("Action")%>"></td>
                                                  
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                             <td><input type="text" name="CCScreeningAction" value=""></td>
                            
                          <%
                                                                       }
          %> 
                        
                        </tr>
                        <tr class="d1">
                            <td></td>
<!--                            <td>If not,appointment for next screening</td>-->
<% 
                            String QstnQuery18= "SELECT QuestionsID,Question FROM questions where ID=76";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery18);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDG2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                     }
                                
                                                           
                                                   %>
            
            
            
             <% 
            
                     String G2="G2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans28="SELECT Appointments FROM riskreductiondetails  WHERE QID='"+G2+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans28);
   
                                    
                                                    
                                                     if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                      
                        <td><input type="text" name="CCAppointment" id="CCAppointment" class="datepicker" title="Enter date" onclick="return date()"  value="<%=conn.rs.getString("Appointments")%>" required ></td>
                                                                            
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                       <td><input type="text" name="CCAppointment" id="CCAppointment" class="datepicker" title="Enter date" onclick="return date()"  value="" required ></td> 
                       
                       <%}%>
                            
                      <% 
            
                     String G2A="G2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans29="SELECT Action FROM riskreductiondetails  WHERE QID='"+G2A+"' AND RiskReductionID ='"+RiskID+"'";  
    conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans29);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
           <td><input type="text" name="CCAppointmentAction" value="<%=conn.rs.getString("Action")%>"></td>                                               
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                        <td><input type="text" name="CCAppointmentAction" value=""></td>               
                           
                       <%}%> 
                           
                        
                        </tr>
                         <tr class="d0">
                            <td>Tuberculosis</td>
<!--                            <td>Screened Today?</td>-->

<% 
                            String QstnQuery19= "SELECT QuestionsID,Question FROM questions where ID=77";
                                                    
				conn.rs = conn.state.executeQuery(QstnQuery19);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDH1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                     }
                                
                                                           
                                                   %>

                            <td><select name="TBCheck" id="TBCheck">
                                     <% 
            
                     String H1="H1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans30="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+H1+"' AND RiskReductionID ='"+RiskID+"'"; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans30);
   
                                    
                                                    
                                                      String yesno6="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno6=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno6.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno6%>"> <%=yesno6%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno6.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno6%>"> <%=yesno6%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                                 </select>
                            </td>                        
                         <% 
            
                     String H1a="H1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans31="SELECT Action FROM riskreductiondetails  WHERE QID='"+H1a+"' AND RiskReductionID ='"+RiskID+"'";  
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans31);
   
                                    
                                                    
                                                     if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                       <td><input type="text" name="TBCheckAction" value="<%=conn.rs.getString("Action")%>"></td>
                      
                                                                            
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                         <td><input type="text" name="TBCheckAction" value=""></td>  
                        <%}%>
                        </tr>
                         <tr class="d1">
                            <td></td>
<!--                            <td>Appointment for next checkup?</td>-->
<% 
                            String QstnQuery20= "SELECT QuestionsID,Question FROM questions where ID=78";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery20);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDH2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>
            
            
             <% 
            
                     String H2="H2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans32="SELECT Action FROM riskreductiondetails  WHERE QID='"+H2+"' AND RiskReductionID ='"+RiskID+"'"; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans32);
   
                                   
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                     
                      
                          <td><input type="text" name="TBCheckAppt" value="<%=conn.rs.getString("Action")%>">
                            </td>                                                        
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>
                       
                         <td><input type="text" name="TBCheckAppt" value="">
                       
                       
                         <%  }%>
              <% 
            
                     String H2A="H2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans33="SELECT Appointments FROM riskreductiondetails  WHERE QID='"+H2A+"' AND RiskReductionID ='"+RiskID+"'";  
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans33);
   
                                    
                                                    
                                                     if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                     
                      
                        
                             <td><input type="text" name="TBCheckApptAction" value="<%=conn.rs.getString("Appointments")%>"></td>
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                   <td><input type="text" name="TBCheckApptAction" value=""></td>        
            
            <%}%>
            
                                              
                        
                           
                        
                        </tr>
                         </table>
  </div>
                          
                          
                          
  			                 
  			<div id="step-5" style="height:350px; width:1206px;">
            <h2 class="StepTitle">Step 5: Questions I,J and K </h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                 
                        
                        
                         <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td>Indicate Action Taken</td></tr> 
                        
                         <tr class="d0">
                            <td>Gender Based Violence(GBV)</td>
<!--                            <td>Referral provided today</td>-->

<% 
                            String QstnQuery21= "SELECT QuestionsID,Question FROM questions where ID=79";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery21);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDI"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>
                            <td><select name="GBVCheck" id="GBVCheck">
                                    
                                     <% 
            
                     String I="I";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans34="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+I+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans34);
   
                                    
                                                     String yesno7="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno7=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno7.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno7%>"> <%=yesno7%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno7.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno7%>"> <%=yesno7%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %> 
                                 </select>
                            </td>                        
                         <% 
            
                     String Ia="I";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans35="SELECT Action FROM riskreductiondetails  WHERE QID='"+Ia+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans35);
   
                                    
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                   %>  
       
                          
                     
                      
                         <td><input type="text" name="GBVCheckAction" value="<%=conn.rs.getString("Action")%>"></td>
                                                 
                        
                        
         
                                                   <%  
                                                                                    }
                       %>  
                           
                           
                        
                        </tr>
                        <tr>
                        <tr class="d0">
                            <td>Family Planning Services</td>
<!--                            <td>Currently on method</td>-->

<% 
                            String QstnQuery22= "SELECT QuestionsID,Question FROM questions where ID=80";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery22);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDJ1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>
                            <td>
                                <select name="FPCurrentMethod" id="FPCurrentMethod" onChange="disableOptions4(this.selectedIndex);">
                                      <% 
            
                     String J="J1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans36="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+J+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans36);
   
                                    
                                                    
                                                    String yesno8="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno8=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno8.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno8%>"> <%=yesno8%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno8.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno8%>"> <%=yesno8%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                                 </select>
                            </td>                        
                         <% 
            
                     String Ja="J1";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans37="SELECT Action FROM riskreductiondetails  WHERE QID='"+Ja+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans37);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                          
                     
                      
                       
                         <td><input type="text" name="FPCurrMAction" id="FPCurrMAction" value="<%=conn.rs.getString("Action")%>"></td>
                                                 
                        
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                           <td><input type="text" name="FPCurrMAction" id="FPCurrMAction" value=""></td>
                           <%}%>
                           
                        
                        </tr>
                        <tr class="d1">
                            <td></td>
<!--                            <td>Provided method today</td>-->
<% 
                            String QstnQuery23= "SELECT QuestionsID,Question FROM questions where ID=81";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery23);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDJ2"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>


                            <td>
                                <select name="FPMethod" id="FPMethod" onChange="disableOptions5(this.selectedIndex);">
                                     <% 
            
                     String J2="J2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans38="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+J2+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans38);
   
                                   
                                                      String yesno9="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno9=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno9.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno9%>"> <%=yesno9%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno9.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno9%>"> <%=yesno9%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                                 </select>
                            </td>                        
                          <% 
            
                     String J2A="J2";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans39="SELECT Action FROM riskreductiondetails  WHERE QID='"+J2A+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans39);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                
                                                 
                        <td><input type="text" name="FPMethodAction" id="FPMethodAction" value="<%=conn.rs.getString("Action")%>"></td>
                        
         
                                                   <%  
                                                                                    }
                                    
                                                                       else{
                       %>  
                           <td><input type="text" name="FPMethodAction" id="FPMethodAction" value=""></td>  
                           
                            <%}%>
                        
                        </tr>
                       
                        <tr class="d0">
                            <td></td>
<!--                            <td>If Yes, what method</td>-->

<% 
                            String QstnQuery24= "SELECT QuestionsID,Question FROM questions where ID=82";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery24);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDJ3"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>
                            
                                
                                <% 
            
                     String J3="J3";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans40="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+J3+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans40);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                
                                                 
                        <td> <input type="text" name="FPMethodType" id="FPMethodType" value="<%=conn.rs.getString("currentStatus")%>"></td>
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                          <td> <input type="text" name="FPMethodType" id="FPMethodType" value=""></td>  
                         <%}%>       
                                
                               
                                                  
                            <% 
            
                     String J3A="J3";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans41="SELECT Action FROM riskreductiondetails  WHERE QID='"+J3A+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans41);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
       
                         <td><input type="text" name="FPMethodTypeAction" value="<%=conn.rs.getString("Action")%>"></td>
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                            <td><input type="text" name="FPMethodTypeAction" value=""></td>
                        <%}%>        
                           
                        
                        </tr>
                        <tr class="d1">
                            <td></td>
<!--                            <td>If not on method and not provided, why</td>-->
<% 
                            String QstnQuery25= "SELECT QuestionsID,Question FROM questions where ID=83";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery25);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDJ4"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                                                           
                                                   %>
            
            
              <% 
            
                     String J4="J4";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans42="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+J4+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans42);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
                                                   
                                                    <td><input type="text" name="NoMethod" id="NoMethod" value="<%=conn.rs.getString("currentStatus")%>"></td>
       
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                          <td><input type="text" name="NoMethod" id="NoMethod" value=""></td>  
                           <%}%>                        
                         <% 
            
                     String J4A="J4";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans43="SELECT Action FROM riskreductiondetails  WHERE QID='"+J4A+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans43);
   
                                    
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
                                                   
                                               <td><input type="text" name="NoMethodAction" value="<%=conn.rs.getString("Action")%>"></td>

       
                        
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                            <td><input type="text" name="NoMethodAction" value=""></td>
                          <%}%>
                        
                        </tr>
                                             <tr class="d1">
                            <td>Alternative sources of income beyond SW</td>
<!--                            <td>Linked to IGA Group</td>-->
<% 
                            String QstnQuery26= "SELECT QuestionsID,Question FROM questions where ID=84";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery26);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDK"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                    }
                                
                                                           
                                                   %>
                            <td>
                                <select name="AltIncomeSource" >
                                      <% 
            
                     String K="K";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans44="SELECT currentStatus FROM riskreductiondetails  WHERE QID='"+K+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans44);
   
                                    
                                                    
                                                       String yesno10="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno10=conn.rs.getString("currentStatus");
                                                      }
                                                          
                                                          if(yesno10.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno10%>"> <%=yesno10%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno10.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno10%>"> <%=yesno10%></option>
                                                       
                                                                                                           <%        } 
                                                              else{
                                                   %>
                            
                            
                            
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            <%
                                                              }
                                %>
                           
                          
                                     
                                 </select>
                            </td>                        
                         <% 
            
                     String Ka="K";
                           //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
           String Ans45="SELECT Action FROM riskreductiondetails  WHERE QID='"+Ka+"' AND RiskReductionID ="+RiskID; 
                                conn.state= conn.connect.createStatement();
                                   conn.rs = conn.state.executeQuery(Ans45);
   
                                   
                                                    
                                                      if(conn.rs.next()==true)
                                                           {
                                                   %>  
                                                   
                                             

       
                          <td><input type="text" name="AltIncomeSourceAction" value="<%=conn.rs.getString("Action")%>"></td>
         
                                                   <%  
                                                                                    }
                                                                       else{
                       %>  
                           <td><input type="text" name="AltIncomeSourceAction" value=""></td> 
                          <%}%>
                        
                        </tr>
                        <tr class="d0">
                    <td>Date of next appointment <font style="color: red">*</font></td>
                    <td> <input type="text" name="nxtapp" id ="nxtapp" value="" onclick= "dateGen();" required></td>
                        </tr>
                       
            </table>
    </div>
                    </div>
                </form>
           </table>
      </div>
</div>
    </body>
</html>