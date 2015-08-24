<%-- 
    Document   : RiskReduction
    Created on : Aug 8, 2013, 2:14:45 PM
    Author     : Cheka
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!

 dbConnect conn = new dbConnect();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Risk Reduction Planning</title>
        <link rel="stylesheet" type="text/css" href="js/jquery-ui.css"/>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="js/DICHelp.js"></script> 
       <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

       <script src="js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
	
	 <script>
              $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"loadMinDate",
                    type:'post',
                    dataType:'html',
                    success:function (data){
 var mindate=data; 
// alert(mindate);
  $(function() {
             var dt = new Date(mindate);      
                var dateToday = new Date(); 
//               alert("today "+dateToday +" "+mindate +'_'+dt);
        $( ".datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'2011:2015',
                                maxDate: dateToday
//                                ,
//                                minDate:dt
                        });
                    
                });
                    }
          })
               
            </script>
        
	
	 
	
        <!--Javascript function to calculate age-->  
          
	
            <script type="text/javascript">
   function dateGen(){

var x= document.getElementById("datepicker").value;
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
  var HIVTestPartAction = df.HIVTestPartAction;
  //var location1=df.location1;
if(v==2) {
  HIVTestPart.disabled = true; HIVTestPartAction.disabled = true;
  document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    HIVTestPart.disabled = false; HIVTestPartAction.disabled = false; 
  }
}

function disableOptions2(v) {
  var df = document.risk;
  var STICheck = df.STICheck;
  var STINextCheck = df.STINextCheck;
  //var location1=df.location1;
if(v==2) {
    
    document.getElementById("STINextCheck").value="";
//     STINextCheck.value="";
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
if(v==1) {
  CCAppointment.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    CCAppointment.disabled = false; 
  }
}

function disableOptions4() {
  var df = document.risk;
//  var FPCurrentMethod = df.FPCurrentMethod;
//  var FPMethod = df.FPMethod;
  var FPMethodType = df.FPMethodType;
  var NoMethod = df.NoMethod;
  var NoMethodAction = df.NoMethodAction;
  
  var FPCurrentMethod= document.getElementById("FPCurrentMethod").value;
  var FPMethod=document.getElementById("FPMethod").value;
  

  //var location1=df.location1;
if(FPCurrentMethod==="No" && FPMethod==="No" ) {
  //FPMethod.disabled = false; FPMethodType.disabled = true;
  NoMethod.disabled = false; NoMethodAction.disabled = false;
  //document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
 // FPMethod.disabled = false; FPMethodType.disabled = false;
  NoMethod.disabled = true; NoMethodAction.disabled = true;
  }
}

function disableOptions5(v) {
  var df = document.risk;
  var FPMethod = df.FPMethod;
  var FPMethodType = df.FPMethodType;
  var NoMethod = df.NoMethod;
  var FPMethodAction = df.FPMethodAction;
  var NoMethodAction = df.NoMethodAction;
  var FPMethodTypeAction = df.FPMethodTypeAction;
  //var location1=df.location1;
if(v==1) {
  FPMethodType.disabled = false; 
//  NoMethod.disabled = true;
  FPMethodTypeAction.disabled = false;
//  NoMethodAction.disabled = true;
  //document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  FPMethodType.disabled = true;
//  NoMethod.disabled = true;
  FPMethodTypeAction.disabled = true; 
//  NoMethodAction.disabled = true;
  }
}

function disableOptions6(v) {
  var df = document.risk;
  var CdProvided = df.CdProvided;
  var NoCD = df.NoCD;
  
  //var location1=df.location1;
if(v==1) {
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
if(v==1) {
  NoWBL.disabled = false; 
  //document.getElementById("HIVTestPart").value="";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
  NoWBL.disabled = true; 
  }
}

//function disableOptions11(v) {
//  var df = document.risk;
//  var HSFTAppointment = df.HSFTAppointment;
//  var NextApptAction = df.NextApptAction;
//  
//  //var location1=df.location1;
//if(v==0) {
//  NextApptAction.disabled = false; 
//  //document.getElementById("HIVTestPart").value="";
//  //location1.physics.disabled = false; 
//  }
//else {
// // location1.disabled = true;
//  NextApptAction.disabled = true; 
//  }
//}
  </script>
        
   <link rel="StyleSheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <style type="text/css">
    #container{
               height:610px;
               width:1300px;
                
    }
     .example {
    height:900px;
    width:1350px;
     
     
     }
    </style>
  <script type="text/javascript">
// a function that filters the districts in the passed county as per the county drop down.

function filter_districts(District){
 
     
   var dist = document.getElementById("district").value;
   var distr = new Array();
// this will return an array with strings "1", "2", etc.
distr = dist.split(",");
var districtsName=distr[0];
//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (districtsName=="")
{
//filter the districts    



document.getElementById("DICName").innerHTML="<option value=\"\">Choose DIC Name</option>";
return;
}
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange=function()
{
if (xmlhttp.readyState==4 && xmlhttp.status==200)
{
document.getElementById("DICName").innerHTML=xmlhttp.responseText;
}
}
xmlhttp.open("POST","/DIC/districtselector?district="+districtsName,true);

xmlhttp.send();


}//end of filter 
</script>
<link href="css/demo_style.css" rel="stylesheet" type="text/css">

<link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.smartWizard.js"></script>
<!--<script src="jquery-1.7.2.js"></script>-->
<link href="css/demo_style.css" rel="stylesheet" type="text/css">

<link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.smartWizard.js"></script>
<script type="text/javascript" src="js/RiskRedValidate.js"></script>
    
<!--
//   
//    $(document).ready(function(){
//    	// Smart Wizard     	
//  		$('#wizard').smartWizard({transitionEffect:'slideleft',onLeaveStep:leaveAStepCallback,onFinish:onFinishCallback,enableFinishButton:true});
//
//      function leaveAStepCallback(obj){
//        var step_num= obj.attr('rel');
//        return validateSteps(step_num);
//      }
//      
//      function onFinishCallback(){
//       if(validateAllSteps()){
//        $('form').submit();
//       }
//      }
//            
//		});
//	   
//    function validateAllSteps(){
//       var isStepValid = true;
//       
//       if(validateStep1() == false){
//         isStepValid = false;
//         $('#wizard').smartWizard('setError',{stepnum:1,iserror:true});         
//       }else{
//         $('#wizard').smartWizard('setError',{stepnum:1,iserror:false});
//       }
//       
//       if(validateStep3() == false){
//         isStepValid = false;
//         $('#wizard').smartWizard('setError',{stepnum:3,iserror:true});         
//       }else{
//         $('#wizard').smartWizard('setError',{stepnum:3,iserror:false});
//       }
//       
//       if(!isStepValid){
//          $('#wizard').smartWizard('showMessage','Please fill the blue marked fields in the steps and continue');
//       }
//              
//       return isStepValid;
//    } 	
//		
//		
//		function validateSteps(step){
//		  var isStepValid = true;
//      // validate step 1
//      if(step == 1){
//        if(validateStep1() == false ){
//          isStepValid = false; 
//          $('#wizard').smartWizard('showMessage','Please fill the blue marked fields in step'+step+ ' and click next.');
//          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
//        }else{
//          $('#wizard').smartWizard('hideMessage');
//          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
//        }
//      }
//      
//      // validate step3
//      if(step == 3){
//        if(validateStep3() == false ){
//          isStepValid = false; 
//          $('#wizard').smartWizard('showMessage','Please fill the blue marked fields in step'+step+ ' and click next.');
//          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
//        }else{
//          $('#wizard').smartWizard('hideMessage');
//          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
//        }
//      }
//      
//      return isStepValid;
//    }
//		
//		function validateStep1(){
//       var isValid = true; 
//       // Validate Username
//       var un = $('#Cadre').val();
//       if(!un && un.length <= 0){
//         isValid = false;
//         $('#msg_Cadre').html('Please fill Cadre').show();
//       }else{
//         $('#msg_Cadre').html('').hide();
//       }
//       
//       // validate password
//       var pw = $('#datepicker').val();
//       if(!pw && pw.length <= 0){
//         isValid = false;
//         $('#msg_datepicker').html('Please fill DOA').show();         
//       }else{
//         $('#msg_datepicker').html('').hide();
//       }
//       
//       // validate confirm password
////       var cpw = $('#cpassword').val();
////       if(!cpw && cpw.length <= 0){
////         isValid = false;
////         $('#msg_cpassword').html('Please fill confirm password').show();         
////       }else{
////         $('#msg_cpassword').html('').hide();
////       }  
//       
//       // validate password match
////       if(pw && pw.length > 0 && cpw && cpw.length > 0){
////         if(pw != cpw){
////           isValid = false;
////           $('#msg_cpassword').html('Password mismatch').show();            
////         }else{
////           $('#msg_cpassword').html('').hide();
////         }
////       }
//       return isValid;
//    }
//       function validateStep3(){
//     var isValid = true;  }  
//      //validate email  email
////      var email = $('#email').val();
////       if(email && email.length > 0){
////         if(!isValidEmailAddress(email)){
////           isValid = false;
////           $('#msg_email').html('Email is invalid').show();           
////         }else{
////          $('#msg_email').html('').hide();
////         }
////       }else{
////         isValid = false;
////         $('#msg_email').html('Please enter email').show();
////       }       
//           //return isValid;
////    }
////    
////    // Email Validation
////    function isValidEmailAddress(emailAddress) {
////      var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
////      return pattern.test(emailAddress);
//   // } 
//		
//		-->


        
            
            <script type="text/javascript">
  function medical_form3() {
  alert("medical form") ;   
      
      
      
  } 
    
    
    
</script>

 
 <style>
.swMain ul.anchor {
    width:1300px;
}
.swMain .stepContainer {
   width:1300px;}
.actionBar{  width:1300px;}
</style>
    </head>
    <body >
   
       <% 
 
 //get the helps from the database.
 
 String Sectionshelp[]=new String [20];
int mcount=0;
 if(conn.state3.isClosed()){conn= new dbConnect();}
conn.rs3=conn.state3.executeQuery("Select * from help where help_id<='20'");

while(conn.rs3.next()){
    
Sectionshelp[mcount]=conn.rs3.getString(2);
if(mcount<=20){
mcount++;
}
}

%>      

<div class="example">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
               if(session.getAttribute("loggedIn")==null){
     
               response.sendRedirect("index.jsp");}
     else{
     %>
                    <a class="button-1" href="../DIC/logoutServlet">LogOut</a>
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
  
             <div style=" width:1350px;">
                <!--=========================================menu=========================================-->     
            
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="menu/adminmenu.jsp" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.jsp" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.jsp" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
  
           <%
 if(session.getAttribute("UniqueID")!=null && !session.getAttribute("UniqueID").equals("")){
String UniqueID1 = (String)session.getAttribute("UniqueID"); 
System.out.println("UniqueID1"+ UniqueID1);
} 
if(session.getAttribute("ClientInit")!=null && !session.getAttribute("ClientInit").equals("")){               
String ClientInit1 = (String)session.getAttribute("ClientInit");  
System.out.println( "ClientInit1"+ClientInit1); }
if(session.getAttribute("District")!=null && !session.getAttribute("District").equals("")){                
String District1 = (String)session.getAttribute("District");    
System.out.println( "District1"+District1);      }
        if(session.getAttribute("Sex")!=null && !session.getAttribute("Sex").equals("")){
String Sex1 = (String)session.getAttribute("Sex"); 
System.out.println( "Sex1"+Sex1);         }
        if(session.getAttribute("DICName")!=null && !session.getAttribute("DICName").equals("")){
String DICName1 = (String)session.getAttribute("DICName"); 
        System.out.println( "DICName1"+DICName1);}
        int count1=0;
        if(session.getAttribute("count1")!=null && !session.getAttribute("count1").equals("")){
 count1= Integer.parseInt(session.getAttribute("count1").toString());            
        }









%>             

        <div id ="container">
            
     <div class="demoHead">  
         <table>
                     
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[12]!=null){%>
         <%=Sectionshelp[12]%> 
         <%}%>
    </td>
    </tr>
         </table>
  <h2>Risk Reduction  <a href="#" id="dialog-link1" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>
</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
                <form name="risk"  method="post" action="RiskRedServlet">
                    
                     <input type='hidden' name="issubmit" value="1">
                      <p style="color:red"> This is Risk Reduction No: <%= count1+1 %> </p>   
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
                    <table>
                                            
<tr id="dialog2" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[13]!=null){%>
         <%=Sectionshelp[13]%> 
         <%}%>
    </td>
    </tr>
                    </table>
              
         <div id="step-1" style="height: 390px; width:1300px;">	
            <h2 class="StepTitle">Step 1: Questions A & B <a href="#" id="dialog-link2" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                       
            
                                 <tr class="d0"><td>County <font style="color: blue">*</font> </td><td>
                        
<!--                        //gets the districts as stored in db and dispaly them in a drop down-->
                        <select onchange="filter_districts(this);" name="district" id="district">
                              <option value="">Choose County</option> 
  <%
  String Location="";
              if(session.getAttribute("Location")!=null){
 Location=session.getAttribute("Location").toString();
 }
  
   String QueryDist="";
                                               

         QueryDist= "SELECT District,DistrictID FROM districts where DistrictID!='1' and DistrictID!='5'";
                    conn.rs = conn.state.executeQuery(QueryDist);
                                 if(conn.state.isClosed()){conn= new dbConnect();}
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getString("DistrictID")%>'><%=conn.rs.getString("District")%></option>
                                                   <%
                                                      
 System.out.println(conn.rs.getInt("DistrictID"));
                                System.out.println(conn.rs.getString("DistrictID"));                                                      }
                                
                                                   
%>
                              

                                 </select></td>
                                 </tr>
                                 <tr class="d1">
                                 <td>DIC Name <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName"  >
                                 <option value="">Choose DIC Name</option>  

                                 </select>
                                    </td>
                </tr>    
<tr class="d0">
<!--    <td>Date of Assessment</td>-->
 <% 
                            String QstnQuery= "SELECT QuestionsID,Question FROM questions where ID=58";
                                                     conn.state= conn.connect.createStatement();
                                                          if(conn.state.isClosed()){conn= new dbConnect();}
				conn.rs = conn.state.executeQuery(QstnQuery);
                            
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDA1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly><font style="color: blue">*</font></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
            <td><input type="text"  class="datepicker" readonly title="Enter date" name="DOA"  id="datepicker" value=""   onclick="date()" required></td></tr>
<!--!      <input type="text" size="12" class="datepicker" title="Enter date" name="dob" value="" onclick="return date()">-->     
           
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
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly><font style="color: blue">*</font></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }   
                                
                                                           
                                                   %>
                    <td><select name="Cadre" id="Cadre"  onclick="dateGen()">
                                
                     <option value=""></option>
                       
               <%
              
                                                      String Query= "SELECT CadreCode,CadreCodeID FROM cadrecode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("CadreCodeID")%>'><%=conn.rs.getString("CadreCode")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("CadreCodeID"));
                                System.out.println(conn.rs.getString("CadreCode"));                                                      }
                                
                               
                                                   %>
                                            

</select>
         
<!--                    <td><select name="Cadre" id="Cadre">
                <option value="Doctor">Doctor</option>
                <option value="Nurse">Nurse</option>
                <option value="Community Volunteer">Community Volunteer</option>
                <option value="Counsellor">Counsellor</option>
                <option value="Other">Other</option>
                </select>-->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                       <td><select name="CasualCdUse">
                               
                                  <option value=""></option>
                       
               <%
              
                                                      String Query6= "SELECT currentStatusID,currentStatus FROM currentStatus";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query6);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("currentStatusID")%>'><%=conn.rs.getString("currentStatus")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("currentStatusID"));
                                System.out.println(conn.rs.getString("currentStatus"));                                                      }
                                
                               
                                                   %>
                                    
<!--                            <option value="Always">Always</option>    
                            <option value="Sometimes">Sometimes</option>    
                            <option value="Never">Never</option>    -->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                        <td> <select name="CdProvided" id="CdProvided" onChange="disableOptions6(this.selectedIndex);">
                                <option value=""></option>
                                <option value="Condoms were provided">Yes</option>
                                <option value="Condoms not provided">No</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
                        <input type="number" name="NoCD" id="NoCD" value="">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td><select name="RegCdUse">
                                     <option value=""></option>
                                     <option value="N/A">N/A</option>
                       
               <%
              
                                                      String Query2= "SELECT currentStatusID,currentStatus FROM currentStatus";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query2);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("currentStatusID")%>'><%=conn.rs.getString("currentStatus")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("currentStatusID"));
                                System.out.println(conn.rs.getString("currentStatus"));                                                      }
                                
                               
                                                   %>
                                    
                                    
<!--                            <option value="Always">Always</option>    
                            <option value="Sometimes">Sometimes</option>    
                            <option value="Never">Never</option>    -->
                         </select>
                        </td>
                        <td></td>
                        <td><input type="hidden" name="RegCdAction" value=""></td>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td><select name="WBLubricant">
                                    
                                                 <option value=""></option>
                       
               <%
              
                                                      String Query3= "SELECT currentStatusID,currentStatus FROM currentStatus";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query3);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("currentStatusID")%>'><%=conn.rs.getString("currentStatus")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("currentStatusID"));
                                System.out.println(conn.rs.getString("currentStatus"));                                                      }
                                
                               
                                                   %>
                                    
                                    
                                    
<!--                            <option value="Always">Always</option>    
                            <option value="Sometimes">Sometimes</option>    
                            <option value="Never">Never</option>    -->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>                                                


                        <td> <select name="WBLubProvided" id="WBLubProvided" onChange="disableOptions7(this.selectedIndex);">
                                <option value=""></option>
                                    <option value="WBL Provided">Yes</option>
                                <option value="WBL Not Provided">No</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
                        <input type="number" name="NoWBL" value="" id="NoWBL">
                        </td>
                        </tr> 
                          </table>          			
        </div>
                              <table>
                                            
<tr id="dialog3" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[14]!=null){%>
         <%=Sectionshelp[14]%> 
         <%}%>
    </td>
    </tr>
                    </table>
                    <div id="step-2" style="height:350px; width:1300px;">
            <h2 class="StepTitle">Step 2: Questions C & D <a href="#" id="dialog-link3" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
            
                <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td>Indicate Action Taken</td></tr> 
                        
                        
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
            <td><input type="text" name="QIDC"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            
            
                       
                                <% 
                                session = request.getSession(true);
                                String UniqueID="";
                                if(session.getAttribute("UniqueID")!=null){
                                UniqueID = (String)session.getAttribute("UniqueID");
                                }
             String queryauditor="SELECT MAX(timestamp) FROM audit where UniqueID='"+UniqueID+"'";
              System.out.println(queryauditor);
             conn.rs6 = conn.state6.executeQuery(queryauditor);
             if(conn.rs6.next()==true){
             
                                                     String QueryAudit= "SELECT FinalAudit FROM audit where UniqueID='"+UniqueID+"' and timestamp='"+conn.rs6.getTimestamp(1)+"'";
                                                      System.out.println(QueryAudit);
                                                   
				              conn.rs2 = conn.state2.executeQuery(QueryAudit);
                                                      while(conn.rs2.next())
                                                           {
                                                   System.out.println(conn.rs2.getInt("FinalAudit"));
//                                          if(  conn.rs.getInt("FinalAudit")!= 0 ) { 
                                                   if(conn.rs2.getInt("FinalAudit") >= 20){ %> 
                            <td> <font style="color: red"><input type="text" name="AlDrugUseScore"  class="convert" style="width: 15px;" value="<%= conn.rs2.getInt("FinalAudit")%>"> Diagnostic Evaluation and Referral </font> </ </td>
                                               <%  } 
                                               else if(conn.rs2.getInt("FinalAudit") >=19   &&  conn.rs.getInt("FinalAudit") <=16){
                            %>
                            <td>   <font style="color: blue"><input type="text" name="AlDrugUseScore"  class="convert" style="width: 15px;" value="<%= conn.rs2.getInt("FinalAudit")%>"> Need for counselling</font> </td>
                                                <% 
                                                                            }                                                
                                 else if(conn.rs2.getInt("FinalAudit")<=15 && conn.rs2.getInt("FinalAudit")>= 8){
                            %>
                            <td>  <font style="color: purple"> <input type="text" name="AlDrugUseScore"  class="convert" style="width: 15px;" value="<%= conn.rs2.getInt("FinalAudit")%>">Simple Advice </font></td>
                            <%
                            }
                                                                             else{
                                                   %>
                                              <td>  <font style="color: purple"> <input type="text" name="AlDrugUseScore"  style="width: 15px;" class="convert" value="<%= conn.rs2.getInt("FinalAudit")%>">Simple Advice </font></td>

<%}}} else{%>
                                
                                  <td>  <font style="color: purple"> <input type="text" name="AlDrugUseScore" style="width: 15px;" class="convert" value="0">Simple Advice </font></td>
                                
                          <%}%>
                                
                        <td><input type="text" name="AlDrugUseAction" value=""></td>
                       
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                              <td>
                          <select name="HSFTKnowToday">
                            
                                                 <option value=""></option>
                       
               <%
              
                                                      String Query4= "SELECT Knowledge_CodeID,Knowledge_Code FROM knowledge_code";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query4);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("Knowledge_CodeID")%>'><%=conn.rs.getString("Knowledge_Code")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("Knowledge_CodeID"));
                                System.out.println(conn.rs.getString("Knowledge_Code"));                                                      }
                                
                               
                                                   %>
                                            

</select>
                              </td>           
                           
<!--                        <td>
                          <select name="HSFTKnowToday">
                            <option value="Low">Low</option>    
                            <option value="Average">Average</option>    
                            <option value="Good">Good</option>    
                         </select>
                        </td>-->
                         <td></td>
                        <td><input type="text" name="HSFTKnowTodayAction" value=""></td>
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
                            <select name="HealthEducation" id="HealthEducation">
                                <option value=""></option>    
                                <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select></td>
                            <td><input type="text" name="HealthEducationAction" value=""></td>
                        </tr>
                        <tr class="d0"><td></td>
<!--                            <td>Appointment for next session(s)</td>-->
<% 
                            String QstnQuery12= "SELECT QuestionsID,Question FROM questions where ID=70";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery12);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDD3"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>


                            <td><input type="text" value="" name="NextAppt" onclick="date()" id="datepicker2" class="datepicker"></td>
                            <td><input type="text" value="" name="NextApptAction"></td></tr>
                        </table></div>
                            <table>
                                            
<tr id="dialog4" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[15]!=null){%>
         <%=Sectionshelp[15]%> 
         <%}%>
    </td>
    </tr>
                    </table>            
  <div id="step-3" style="height:350px; width:1300px;">
            <h2 class="StepTitle">Step 3: Questions E & F <a href="#" id="dialog-link4" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>  
                                <tr class="d2"><td>Activity</td><td>Current Status</td><td></td><td> HIV Status</td><td>Indicate Action Taken</td></tr> 
                        
                        <tr class="d1">
                            <td>HIV Testing</td>
                           
<!--                            <td>Tested today</td>-->
<% 
                            String QstnQuery13= "SELECT QuestionsID,Question FROM questions where ID=71";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery13);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDE1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
           
                            <td>  <select name="HIVTodayTest" id="HIVTodayTest" onChange="disableOptions1(this.selectedIndex);">
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                </select>
                                </td>
                                <td>
                              <select name="HIVTodayTestStatus" id="HIVTodayTestStatus" onChange="disableOptions1(this.selectedIndex);">
                                    <option value=""></option>
                                    <option value="P">P (Positive)</option>  
                                    <option value="N">N (Negative)</option>  
                                </select> 
                                </td> 
                            
                                <td>
                              <select name="HIVTodayAction" id="HIVTodayAction" onChange="disableOptions1(this.selectedIndex);">
                                    <option value=""></option> 
                                    <option value="Referred">Referred</option>  
                                    <option value="On Care">On care</option>  
                                </select> 
                                </td> 
                            
                                 <td><input type="text" name="HIVTodayTestAction" value=""></td>
                        
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
<!--                            <td>Tested with partner?</td>-->
                            <td>
                                <select name="HIVTestPart" id="HIVTestPart">
                                    <option value=""></option> 
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>
                            <td>
                                <select name="HIVTestPartStatus" id="HIVTestPartStatus">
                                    <option value=""></option> 
                                    <option value="P">P (Positive)</option>  
                                    <option value="N">N (Negative)</option>  
                                 </select>
                            </td>  
                            <td>
                                <select name="HIVAction_PARTNER" id="HIVAction_PARTNER">
                                    <option value=""></option> 
                                    <option value="Referred">Referred</option>  
                                    <option value="On Care">On care</option>  
                                  
                                 </select>
                            </td>  
                            <td><input type="text" name="HIVTestPartAction" value=""></td>
                        
                        </tr>
                        
              

                        <tr class="d1">
                            <td>Sexually Transmitted Infections(STIs)</td>
<!--                            <td>Provided an STI checkup today</td>-->
<% 
                            String QstnQuery15= "SELECT QuestionsID,Question FROM questions where ID=73";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery15);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDF1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" style="width:200px;" class="convert" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
          
                            <td><select name="STICheck" id="STICheck" onChange="disableOptions2(this.selectedIndex);">
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                          <td></td>
                            <td><input type="text" name="STICheckAction" value=""></td>
                        
                        </tr>
                        <tr class="d0">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                         
            <td><input type="text" name="STINextCheck" id="STINextCheck"  class="datepicker" title="Enter date"  value=""></td>
                                           
                     <td></td>       
                            <td><input type="text" name="STINextCheckAction" value=""></td>
                        
                        </tr>
                         </table>
  </div>
               <table>
      <tr id="dialog5" title="DIC  Help ">
  
    <td>
         <% if(Sectionshelp[16]!=null){%>
         <%=Sectionshelp[16]%> 
         <%}%>
    </td>
    </tr>
               </table>         
                          
                          
  			<div id="step-4" style="height:350px; width:1300px;">
            <h2 class="StepTitle">Step 4: Questions G & H <a href="#" id="dialog-link5" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
                                <select name="CCScreening" id="CCScreening" onChange="disableOptions3(this.selectedIndex);" >
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                        
                            <td><input type="text" name="CCScreeningAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td><input type="text" name="CCAppointment" id="CCAppointment" class="datepicker" title="Enter date"   value="" required ></td>
                                                 
                        
                            <td><input type="text" name="CCAppointmentAction" value=""></td>
                        
                        </tr>
                         <tr class="d0">
                            <td>Tuberculosis</td>
<!--                            <td>Screened Today?</td>-->

<% 
                            String QstnQuery19= "SELECT QuestionsID,Question FROM questions where ID=77";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery19);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDH1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>

            <td><select name="TBCheck" id="TBCheck">
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                        
                            <td><input type="text" name="TBCheckAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td><input type="text" name="TBCheckAppt" id="datepicker5"  class="datepicker" value="">
                            </td>                        
                        
                            <td><input type="text" name="TBCheckApptAction" value=""></td>
                        
                        </tr>
                         </table>
  </div>
                
               <table>
      <tr id="dialog6" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[17]!=null){%>
         <%=Sectionshelp[17]%> 
         <%}%>
    </td>
    </tr>
               </table>             
                          
                          
  			<div id="step-5" style="height:350px; width:1206px;">
            <h2 class="StepTitle">Step 5: Questions I,J and K <a href="#" id="dialog-link6" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a> </h2>	
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td><select name="GBVCheck" id="GBVCheck">
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                        
                            <td><input type="text" name="GBVCheckAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
                                <select name="FPCurrentMethod" id="FPCurrentMethod" onChange="disableOptions4();">
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                        
                            <td><input type="text" name="FPCurrMAction" id="FPCurrMAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>


                            <td>
                                <select name="FPMethod" id="FPMethod" onChange="disableOptions4();disableOptions5(this.selectedIndex);">
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                        
                            <td><input type="text" name="FPMethodAction" id="FPMethodAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
<!--                                <input type="text" name="FPMethodType" id="FPMethodType" value="">-->
                                
                                <select name="FPMethodType" id="FPMethodType" >
                                    <option value=""></option>
                                    <option value="COC PILLS">COC PILLS</option>
                                    <option value="POC PILLS">POC PILLS</option>
                                    <option value="INJECTABLE">INJECTABLE</option>
                                    <option value="CONDOMS">CONDOMS</option>
                                    <option value="TUBAL LIGATION">TUBAL LIGATION</option>
                                    <option value="IUD">IUD</option>
                                    <option value="TRADITIONAL">TRADITIONAL</option>
                                    <option value="IMPLANON IMPLANTS">IMPLANON IMPLANTS</option>
                                    <option value="JADELLE IMPLANTS">JADELLE IMPLANTS</option>
                                    
                                </select>
                            </td>                        
                        
                            <td><input type="text" name="FPMethodTypeAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td><input type="text" name="NoMethod" id="NoMethod" value="">
                            </td>                        
                        
                            <td><input type="text" name="NoMethodAction" id="NoMethodAction" value=""></td>
                        
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>
                            <td>
                                <select name="AltIncomeSource" >
                                    <option value=""></option>
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                 </select>
                            </td>                        
                        
                            <td><input type="text" name="AltIncomeSourceAction" value=""></td>
                        
                        </tr>
                        <tr class="d0">
                            <td><input type="hidden" name="QIDL" value="L">Date of next appointment <font style="color: blue">*</font></td>
                            <td><input type="text" name="nxtapp" class="datepicker" value="" required></td>
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
<%

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



%>