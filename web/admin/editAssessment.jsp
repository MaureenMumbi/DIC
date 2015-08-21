<%-- 
    Document   : editAssessment
    Created on : Aug 12, 2013, 2:57:18 PM
    Author     : Maureen
--%>
<%@page import="java.sql.Array"%>
<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
dbConnect conn = new dbConnect();
//String AssessID="";
String QID="";
String DA="";
List  userList= new ArrayList();
HttpSession session;
           
String AssID = "";
String douche="";
String lub="";
String lubuse="";
%>
<%

session = request.getSession(true);  
AssID=(String)session.getAttribute("UniqueID");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
.convert_1{
 border:0px;
 border-color: #F0F0F0;
 background-color: #F0F0F0; color: black;
 width:10px;
 
  
}
        </style>  
        <SCRIPT language=Javascript>
 function disableOptions0(v) {
  var df = document.form;
  var LastSex = df.LastSex;
  var TimeRegPartners = df.TimeRegPartners;
  
if(!(v==3)) {
  TimeRegPartners.disabled = false;
  
  }
else {
  TimeRegPartners.disabled = true;
  }
}
function disableOptions20(v) {
  var df = document.form;
  var AlcoholUse = df.AlcoholUse;
  var AlcoholFrequency = df.AlcoholFrequency;
  
if(v==1) {
  AlcoholFrequency.disabled = true;
  document.getElementById('AlcoholFrequency').value = "";
  }
else {
  AlcoholFrequency.disabled = false;
  }
}

function disableOptions21(v) {
  var df = document.form;
  var DrugUse = df.DrugUse;
  var DrugType = df.DrugType;
  var DrugFrequency = df.DrugFrequency;
  
if(v==1) {
  DrugType.disabled = true;
  DrugFrequency.disabled = true;
  document.getElementById('DrugType').value = "";
  }
else {
 DrugType.disabled = false;
  DrugFrequency.disabled = false;
  }
}

function disableOptions22(v) {
  var df = document.form;
  var VaginalDouche = df.VaginalDouche;
  var AfterSexDouche = df.AfterSexDouche;
  var BathDouche = df.BathDouche;
  var CdBurstDouche = df.CdBurstDouche;
  var OtherDouche = df.OtherDouche;
  var OtherDouche1 = df.OtherDouche1;
  
if(v==1) {
  AfterSexDouche.disabled = true;
  BathDouche.disabled = true;
  CdBurstDouche.disabled = true;
  OtherDouche.disabled = true;
  OtherDouche1.disabled = true;
  document.getElementById('AfterSexDouche').checked = false;
  document.getElementById('BathDouche').checked = false;
  document.getElementById('CdBurstDouche').checked = false;
  document.getElementById('OtherDouche1').checked = false;
  document.getElementById('OtherDouche').value = "";
  }
else {
 AfterSexDouche.disabled = false;
  BathDouche.disabled = false;
  CdBurstDouche.disabled = false;
  OtherDouche.disabled = false;
  OtherDouche1.disabled = false;
  }
}

function disableOptions23(v) {
  var df = document.form;
  var VerbalInsults = df.VerbalInsults;
  
  
  var LastVerbalInsult = df.LastVerbalInsult;
  
 
  
if(v==1) {
   
  LastVerbalInsult.disabled=true;
  
  }
else {
 
 LastVerbalInsult.disabled=false;
 
  }
}

function disableOptions24(v) {
  var df = document.form;
  var Hit = df.Hit;
  var LastVerbalInsultHit = df.LastVerbalInsultHit;
 
if(v==1) {
   LastVerbalInsultHit.disabled=true;
 }
else {
 LastVerbalInsultHit.disabled=false;
 
  }
}

function disableOptions25(v) {
  var df = document.form;
  var ForcedSex = df.ForcedSex;
  var LastVerbalInsultForced = df.LastVerbalInsultForced;
 
 if(v==1) {
   LastVerbalInsultForced.disabled=true;

  }
else {
  LastVerbalInsultForced.disabled=false;
  }
}

function disableOptions26(v) {
  var df = document.form;
  var SeekTreatment = df.SeekTreatment;
  var PlaceTreated = df.PlaceTreated;
if(v==1) {
  
  PlaceTreated.disabled = true;
  }
else {
  PlaceTreated.disabled = false;
  }
}

function disableOptions27(v) {
  var df = document.form;
  var LubricantUse = df.LubricantUse;
  var KYJelly = df.KYJelly;
  var Saliva = df.Saliva;
  var OtherLubricants1 = df.OtherLubricants1;
  var OtherLubricants = df.OtherLubricants;
  var LubUseAnal = df.LubUseAnal;
  var LubUseVaginal = df.LubUseVaginal;
if(v==1) {
  KYJelly.disabled = true; Saliva.disabled = true;
  OtherLubricants1.disabled = true; OtherLubricants.disabled = true;
  LubUseAnal.disabled = true; LubUseVaginal.disabled = true;
  
  }
else {
  KYJelly.disabled = false; Saliva.disabled = false;
  OtherLubricants1.disabled = false; OtherLubricants.disabled = false;
  LubUseAnal.disabled = false; LubUseVaginal.disabled = false;
  }
}

function disableOptions28(v) {
  var df = document.form;
  var VerbalAbuse = df.VerbalAbuse;
  var VerbalAbuseTime = df.VerbalAbuseTime;
 
if(v==1) {
   VerbalAbuseTime.disabled=true;

  }
else {
  VerbalAbuseTime.disabled=false;
  }
}


function disableOptions29(v) {
  var df = document.form;
  var PartnerProblem = df.PartnerProblem;
  var PartnerProblemTime = df.PartnerProblemTime;
 
if(v==1) {
   PartnerProblemTime.disabled=true;

  }
else {
  PartnerProblemTime.disabled=false;
  }
}

function disableOptions10(v) {
  var df = document.form;
  var UseFP = df.UseFP;
  var FPMethodUsed = df.FPMethodUsed;
 
  
if(v==1) {
  
  FPMethodUsed.disabled = true;
  
  }
else {
 
  FPMethodUsed.disabled = false;
  }
}

function disableOptions9(v) {
  var df = document.form;
  var ReportPolice = df.ReportPolice;
  var ReportWhere = df.ReportWhere;
 
if(v==1) {
   ReportWhere.disabled=true;

  }
else {
  ReportWhere.disabled=false;
  }
}


function disableOptions(v) {
  var df = document.form;
  var ActiveSexWork = df.ActiveSexWork;
  var NoPayingClients = df.NoPayingClients;
  
if(v==1) {
  NoPayingClients.disabled = true;
  document.getElementById('NoPayingClients').value = "";
  }
else {
  NoPayingClients.disabled = false;
  }
}
function disableOptions1(v) {
  var df = document.form;
  var RegPartner = df.RegPartner;
  var NoRegPartner = df.NoRegPartner;
  var TimeRegPartners = df.TimeRegPartners;
  
if(v==1) {
  NoRegPartner.disabled = true;
  TimeRegPartners.disabled = true;
   document.getElementById('NoRegPartner').value = "";
   document.getElementById('TimeRegPartners').value = "";
  }
else {
  NoRegPartner.disabled = false;
   TimeRegPartners.disabled = false;
  }
}

function disableOptions2(v) {
  var df = document.form;
  var PracticeVaginal = df.PracticeVaginal; var CondomVaginal = df.CondomVaginal;
if(!(v==0) ) {
  CondomVaginal.options[0].disabled = true; CondomVaginal.options[1].disabled = false;
  CondomVaginal.options[2].disabled = false; CondomVaginal.options[3].disabled = false;
  CondomVaginal.options[4].disabled = false;
  }
else {
  CondomVaginal.options[0].disabled = false; CondomVaginal.options[1].disabled = true;
  CondomVaginal.options[2].disabled = true; CondomVaginal.options[3].disabled = true;
  CondomVaginal.options[4].disabled = true;
  }
  
}
function disableOptions5(v) {
  var df = document.form;
  var PracticeOral = df.PracticeOral; var CondomOral = df.CondomOral;
if(!(v==0) ) {
  CondomOral.options[0].disabled = true; CondomOral.options[1].disabled = false;
  CondomOral.options[2].disabled = false; CondomOral.options[3].disabled = false;
  CondomOral.options[4].disabled = false;
  }
else {
  CondomOral.options[0].disabled = false; CondomOral.options[1].disabled = true;
  CondomOral.options[2].disabled = true; CondomOral.options[3].disabled = true;
  CondomOral.options[4].disabled = true;
  }
  
}
function disableOptions6(v) {
  var df = document.form;
  var PracticeAnal = df.PracticeAnal; var CondomAnal = df.CondomAnal;
if(!(v==0) ) {
  CondomAnal.options[0].disabled = true; CondomAnal.options[1].disabled = false;
  CondomAnal.options[2].disabled = false; CondomAnal.options[3].disabled = false;
  CondomAnal.options[4].disabled = false;
  }
else {
  CondomAnal.options[0].disabled = false; CondomAnal.options[1].disabled = true;
  CondomAnal.options[2].disabled = true; CondomAnal.options[3].disabled = true;
  CondomAnal.options[4].disabled = true;
  }
  
}

function disableOptions3(v) {
  var df = document.form;
  var HIVPartStatus = df.HIVPartStatus;
  var NoHIVPartStatus = df.NoHIVPartStatus;
  var PartCondomUse = df.PartCondomUse;
  
if(v==1) {
  NoHIVPartStatus.disabled = true;
  PartCondomUse.disabled = true;
  document.getElementById('NoHIVPartStatus').value = "";
  document.getElementById('PartCondomUse').value = "";
  
  }
else {
  NoHIVPartStatus.disabled = false;
  PartCondomUse.disabled = false;
  }
}

function disableOptions4(v) {
  var df = document.form;
  var LubricantUse = df.LubricantUse;
  var KYJelly = df.KYJelly;
  var Saliva=df.Saliva;
  var OtherLubricants=df.OtherLubricants;
  var OtherLubricants1=df.OtherLubricants1;
  var LubUseAnal=df.LubUseAnal;
  var LubUseVaginal=df.LubUseVaginal;
  
if(v==1) {
  KYJelly.disabled = true;
  Saliva.disabled = true;
  OtherLubricants.disabled = true;
  OtherLubricants1.disabled = true;
  LubUseAnal.disabled = true;
  LubUseVaginal.disabled = true;
  document.getElementById('KYJelly').checked = false;
 document.getElementById('Saliva').checked = false;
  document.getElementById('OtherLubricants').value = "";
  document.getElementById('OtherLubricants1').checked = false;
  document.getElementById('LubUseAnal').checked = false;
  document.getElementById('LubUseVaginal').checked = false;
//  location1.physics.disabled = false; 
  }
else {
  KYJelly.disabled = false;
  Saliva.disabled = false;
  OtherLubricants.disabled = false;
  OtherLubricants1.disabled = false;
  LubUseAnal.disabled = false;
  LubUseVaginal.disabled = false;
//  location1.disabled = true;location.disabled = false; 
  }
}



</SCRIPT>


	<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
	<link rel="stylesheet" href="themes/eggplant/jquery.ui.all.css">
      <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

       <script src="js/datepicker.js"></script>
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
            <link rel="StyleSheet" href="css/main.css" type="text/css" />
            <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <style type="text/css">
    #container{
                height:970px;
                width:1225px; 
    }
    .example {
     width:1350px;
    height:1200px;}
    </style>
    
    <link href="css/demo_style.css" rel="stylesheet" type="text/css">
    <link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="scripts/jquery.smartWizard.js"></script>

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
       var un = $('#DOA').val();
       if(!un && un.length <= 0){
         isValid = false;
         $('#msg_DOA').html('Please fill DOA').show();
       }else{
         $('#msg_DOA').html('').hide();
       }
       
       // validate password
//       var pw = $('#SexLast').val();
//       if(!pw && pw.length <= 0){
//         isValid = false;
//         $('#msg_SexLast').html('Please fill SexLast').show();         
//       }else{
//         $('#msg_SexLast').html('').hide();
//       }
       
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
<script>
var popupWindow=null;
function popaudit(v) {
  var df = document.form;
  var AlcoholFrequency = df.AlcoholFrequency;
  
if(v==2 || v==1) {
   
  popupWindow=window.open( 'audit.jsp','','width=1400,height=500');
//    window.location="audit.jsp";
}

}



function parent_disable() {
if(popupWindow && !popupWindow.closed)
popupWindow.focus();
}

function check(){

if(document.getElementById("douche").value == (document.getElementById("AfterSexDouche").value)) {
                    document.getElementById("AfterSexDouche").checked=true;
                  
        
     }
//      alert( document.getElementById("AfterSexDouche").value);
  if(document.getElementById("bath").value==(document.getElementById("BathDouche").value)) {
                    document.getElementById("BathDouche").checked=true;
        
     }
  if(document.getElementById("burst").value == (document.getElementById("CdBurstDouche").value)) {
                    document.getElementById("CdBurstDouche").checked=true;
        
     }
  if(document.getElementById("otherdouche").value != " " ) {
                    document.getElementById("OtherDouche1").checked=true;
        
     }
      //for lub use 
     
if(document.getElementById("others").value !=" ") {
                    document.getElementById("OtherLubricants1").checked=true;
                  
        
     }
   
  if(document.getElementById("lub").value.contains(document.getElementById("KYJelly").value)) {
                    document.getElementById("KYJelly").checked=true;
        
     }
  
  if(document.getElementById("lubsaliva").value.contains(document.getElementById("Saliva").value)) {
                    document.getElementById("Saliva").checked=true;
        
     }
     
     //lubuse
  if(document.getElementById("lubuse").value==(document.getElementById("LubUseAnal").value)) {
                    document.getElementById("LubUseAnal").checked=true;
        
     }
  
  if(document.getElementById("vaginal").value == (document.getElementById("LubUseVaginal").value)) {
                    document.getElementById("LubUseVaginal").checked=true;
        
     }
      
}
</script>
        <title>EDIT RISK ASSESSMENT </title>
    </head>
    <body onFocus="parent_disable();" onclick="parent_disable();" onload="check()">
         <%
String UniqueID1 = (String)session.getAttribute("UniqueID");           
String ClientInit1 = (String)session.getAttribute("ClientInit");           
String District1 = (String)session.getAttribute("District");           
String Sex1 = (String)session.getAttribute("Sex");           
String DICName1 = (String)session.getAttribute("DICName");           
//String count =session.getAttribute("count").toString(); 
//int counter = (Integer.parseInt(count));



%>
        
<div class="example">
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
<div style=" width:1350px;">
                <!--=========================================menu=========================================-->     
            
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="../menu/adminmenu.jsp" %>
            <%}
else{%>

 <%@include file="../menu/clerkmenu.jsp" %>

<%}

}

else{ %>
        
             <%@include file="../menu/clerkmenu.jsp" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
    
    
     <div id="container">
          
             
<!--        <h3>Risk Assessment: SECTION 1 </h3>
        <h4>To be filled by peer counsellor/Counsellor</h4>
        
         <h4>Please fill all the fields marked with <font style="color: red">*</font> </h4> 
    --> 
    <div class="demoHead">  
  <h2>Risk Assessment</h2>

</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
        
        
       
          

 <form action="EditRiskAssessment" name="form" method="post">
 <input type='hidden' name="issubmit" value="1">
 
 <input type="hidden" name="AssID" value="<%= AssID %>">
<!-- Tabs -->
<div id="wizard" class="swMain">
  			<ul>
  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                  Sexual Practices<br />
                   <small>Fill details marked <font style="color: blue">*</font></small>
                </span>
            </a></li>
                           
  				<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                  STI/HIV<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                 Family Planning<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
             </a></li>
  				<li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                 Substance Abuse<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  				<li><a href="#step-5">
                <label class="stepNumber">5</label>
                <span class="stepDesc">
                 Sexual & Gender <br /> Violence <br />
                  
                </span>
            </a></li>
  			</ul>
                   
    <div id="step-1" style="height: 700px; width:1000px; padding:10px 100px 60px 100px;">
                        <h2 class="StepTitle">Step 1: Sexual Practices</h2>
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                                   
   
 <tr class="d0">
       <% 
                            String QstnQuery= "SELECT QuestionsID,Question FROM questions where ID=57";
                           if(conn.state.isClosed()){conn= new dbConnect();}                                                    
                          	conn.rs = conn.state.executeQuery(QstnQuery);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QID1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly><font style="color: red">*</font></td>
                                                   <%
                                                        }
                                
                                                           
                                                   %>
            
             <% String W="W";
           
                            //String Ans1= "SELECT DirectAnswers FROM riskassessmentdetails where AssessmentID='"+ AssID +"' && QuestionID='"+W+"'";
    String Ans1="SELECT AssessmentDate FROM riskassessmentmain WHERE riskassessmentmain.AssessmentID = "+ AssID ; 
                          
                                                    
                           conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans1);
                                  
                                                while(conn.rs.next())
                                                           {
                                                   %>                                                                       
                                                   <td><input type="text" ID="DOA" NAME="DOA" class="datepicker" readonly value="<%=conn.rs.getString("AssessmentDate")%>"></td>
               
                                                   <%
                                                                                                         }
 
                                                   %>

<!--    <td><input type="text" name="DOA" id="DOA"  class="datepicker" title="Enter date" value="" onclick="return function()" required></td>-->
 
 
 </tr>
                <tr class="d1">
                    <% 
                            String QstnQuery1= "SELECT QuestionsID,Question FROM questions where ID=1";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery1);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDA"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnA" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                                                              
                 %>
            
                    <td>
                        <select name="SexLast" id="SexLast" onChange="disableOptions0(this.selectedIndex);">
                             <option value=""></option>
                             <% String que="A";
          
                            String Ans2= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+que+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
//                              conn.state1= conn.connect.createStatement();
				conn.rs1 = conn.state1.executeQuery(Ans2);
                                String y= "";
                                                      while(conn.rs1.next())
                                                           {
                                                          
                                                    y= conn.rs1.getString("DirectAnswers");
                                                           
                                                                 }
                            String Query= "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code";
//                                                     conn.state= conn.connect.createStatement();
				                         conn.rs = conn.state.executeQuery(Query);
                                                      ArrayList LastSexList = new ArrayList();
                                                    ArrayList LastSexList1 = new ArrayList();
                                                      while(conn.rs.next()){
                                                    if(LastSexList!= null && LastSexList.size()!=0){
                                                    LastSexList.clear();
                                                    }  if(LastSexList1!= null && LastSexList1.size()!=0){
                                                    LastSexList1.clear();
                                                    }
                                                          
                                                           LastSexList.add(conn.rs.getString("LastSex_Code"));
                                                           LastSexList1.add(conn.rs.getString("LastSex_CodeID"));
                                                      String querylast = "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code where LastSex_CodeID='"+y+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querylast);
                                                                String lastsex="";
                                                                while(conn.rs2.next()){
                                                                 lastsex=  conn.rs2.getString("LastSex_Code"); 
                                                               

                                                  for(int i=0;i<LastSexList.size();i++){
                
  if(LastSexList.get(i).equals(lastsex)){
                                      %>
                                 
                    
                <option selected value="<%= LastSexList1.get(i)%>"><%=LastSexList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= LastSexList1.get(i)%>"><%=LastSexList.get(i)%></option>
             <%   }
                             }     
                                                      
                                             }         
                                                      
                                                                                                          }                                                                         
                                                                                                                                                                 
                               
                                                   %>
                          </select>
                    </td>    
                            
                            
<!--                            <option value="Within 24hrs">Within 24hrs</option>
                            <option value="Within 7days">Within 7days</option>
                            <option value="Within 30days">Within 30days</option>
                            <option value="More than 30 days ago">More than 30 days ago</option>
                          </select></td>-->
                </tr>
                <tr class="d0">
                    <%
                            String QstnQuery2= "SELECT QuestionsID,Question FROM questions where ID=2";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery2);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnB" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       

                                                                                      }
                                
                               
                 %>
                    
<!--                    <td>Did you use a condom? <font style="color: red"></font></td>-->
                    <td><select name="CondomUse">
                             <option value=""></option>
                              <% String B="B";
          
                            String Ans3= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+B+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                          
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans3);
                                  String yesno="";                                                     
                                while(conn.rs.next()){
                                                         
                                                           
                                                           yesno=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno%>"> <%=yesno%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno.equals("No")){%>
                                                                                                                    <option  value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno%>"> <%=yesno%></option>
                                                       
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
                </tr>
                <tr class="d1">
               <%
                            String QstnQuery3= "SELECT QuestionsID,Question FROM questions where ID=3";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery3);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDC"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnC" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                             }
                                
                               
                 %> 
<!--                <td>Genders of your sex partners? <font style="color: red"></font></td>-->
                    <td><select name="SexPartGender">
                             <option value=""></option>
                             <% String c="C";
          
                            String Ans4= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+c+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans4);
                                String[] sexpart = new String[]{"Male","Female","Both"};
                                
                                String Genderpart="";
                                
                                                      while(conn.rs.next())
                                                           {
                                                       Genderpart= conn.rs.getString("DirectAnswers");
                                                                                                                }
                                                for(int i=0;i<sexpart.length;i++){
                
                        if(sexpart[i].equals(Genderpart)){
                                      %>
                                 
                    
                <option selected value="<%= sexpart[i]%>"><%=sexpart[i]%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= sexpart[i]%>"><%=sexpart[i]%></option>
             <%   }
                                                
                                     
                                                                                    }
                                                   %>
                            
                         </select>
                     </td>
                </tr>
              <tr class="d0">
                   <%
                            String QstnQuery4= "SELECT QuestionsID,Question FROM questions where ID=4";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery4);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDD"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnD" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %> 
                  
                  
<!--<td>When was the last time you had sex with a paying partner?(Probe for last 3 months)? <font style="color: red"></font></td>-->
                    <td>
                        <select name="ActiveSexWork" id="ActiveSexWork">
                             <option value=""></option>
                        <% String D="D";
          
                            String Ans5= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+D+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                             conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans5);
                                String sexLast="";
                                                      while(conn.rs.next())
                                                           {
                                                          sexLast=conn.rs.getString("DirectAnswers");
                                                               }
                            String QuerySex= "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code";
//                                                     conn.state= conn.connect.createStatement();
				                         conn.rs1 = conn.state1.executeQuery(QuerySex);
                                                      ArrayList LastSex = new ArrayList();
                                                    ArrayList LastSex1 = new ArrayList();
                                                      while(conn.rs1.next()){
                                                    if(LastSex!= null && LastSex.size()!=0){
                                                    LastSex.clear();
                                                    }  if(LastSex1!= null && LastSex1.size()!=0){
                                                    LastSex1.clear();
                                                    }
                                                          
                                                           LastSex.add(conn.rs1.getString("LastSex_Code"));
                                                           LastSex1.add(conn.rs1.getString("LastSex_CodeID"));
                                                      String querylast = "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code where LastSex_CodeID='"+sexLast+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querylast);
                                                                String lastsex="";
                                                                while(conn.rs2.next()){
                                                                 lastsex=  conn.rs2.getString("LastSex_Code"); 
                                                               

                                                  for(int i=0;i<LastSex.size();i++){
                
  if(LastSex.get(i).equals(lastsex)){
                                      %>
                                 
                    
                <option selected value="<%= LastSex1.get(i)%>"><%=LastSex.get(i)%></option>
                
               <% }
                
                else{
%>
                    
                <option  value="<%= LastSex1.get(i)%>"><%=LastSex.get(i)%></option>
             <%   }
                             }     
                                                      
                                             }         
                                                      
                                                                                                          }                                                                         
                                                                                                                                                                 
                               
                                                   %>
                          </select>
                    </td>    
                        
                        
<!--                        <input type="text" name="ActiveSexWork" id="ActiveSexWork" >-->
<!--                        onChange="disableOptions(this.selectedIndex);-->
<!--                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                         </select>-->
                     
                </tr>
                
                <tr class="d1">
                    
                     <%
                            String QstnQuery5= "SELECT QuestionsID,Question FROM questions where ID=5";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery5);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDE"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnE" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                       }
                                
                               
                 %> 
<!--                    <td>Average number of paying clients per week: <font style="color: red"></font></td>-->
<td><select>  
                   
                        <% String E="E";
          
                            String Ans6= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+E+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            ArrayList pay = new ArrayList();
//pay.add("");                                                   
pay.add("0-10");                                                   
pay.add("30-50");                                                   
pay.add("Over 50");                                                   
                                                  
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs4= conn.state.executeQuery(Ans6);
                                                      while(conn.rs4.next())
                                                           {
                                                 
                         for(int i=0;i<pay.size();i++){
              //  System.out.println("pay  "+pay.get(i));
              if(pay.get(i).equals(conn.rs4.getString("DirectAnswers"))){
                                      %>
                                 
                    
                <option selected value="<%= pay.get(i)%>"><%=pay.get(i)%></option>
                
               <% }
                
                else{
%>
                    
                <option  value="<%= pay.get(i)%>"><%=pay.get(i)%></option>
             <%   }
                             }     
                                                      
                                             }         
                                                      
                                                                                                                                                                                   
                                                                                                                                                                 
                               
                                                   %>
                          </select>
                    </td>    
                        
<!--                        <input type="text" name="NoPayingClients" id="NoPayingClients" value="">-->
                    
               </tr>
               <tr class="d0">
                    <%
                            String QstnQuery6= "SELECT QuestionsID,Question FROM questions where ID=6";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery6);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDF"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnF" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                               
                 %> 
                   
                   
<!--                   <td>Do you have a non-paying partner(husband,boyfriend)? <font style="color: red"></font></td>-->
                    <td><select name="RegPartner" id="RegPartner" onChange="disableOptions1(this.selectedIndex);">
                             <option value=""></option>
                             <% String F="F";
          
                            String Ans7= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+F+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans7);
                                                                                                           
                                                 String yesno1="";                                                     
                                while(conn.rs.next()){
                                                         
                                                           
                                                           yesno1=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno1.equals("Yes")){
                                                   %> 
                                                    <option  selected value="<%=yesno1%>"> <%=yesno1%></option>
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
                         </select>
                     </td>
                </tr>
                <tr class="d1">
                     <%
                            String QstnQuery7= "SELECT QuestionsID,Question FROM questions where ID=7";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery7);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDG"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnG" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                    }
                                
                               
                 %> 
<!--                    <td>How many non-paying partners do you have? <font style="color: red"></font></td>-->
                   
                          <% String G="G";
          
                            String Ans8= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+G+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans8);
                                                      while(conn.rs.next())
                                                           {
                                                   %> 
                    <td>  <input type="text" name="NoRegPartner" value="<%=conn.rs.getString("DirectAnswers")%>" id="NoRegPartner"></td>
                    
                                                 
               
                                                   <%
                                                                                                         }
 
                                                   %>
               </tr>
                <tr class="d0">
                             <%
                            String QstnQuery8= "SELECT QuestionsID,Question FROM questions where ID=8";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery8);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
<td><input type="text" name="QIDH"   value="<%=conn.rs.getString("QuestionsID")%>" class="convert_1" >
                <input type="hidden" name="qstnH" value="<%=conn.rs.getString("Question")%>"  >
                                                   <%

                                                                                      }
                                
                               
                 %>
                    In the last one month, how many times did you have sex with a non-paying partner? <font style="color: red"></font></td>
        

      <% String H="H";
          
                            String Ans9= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+H+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans9);
                                                      while(conn.rs.next())
                                                           {
                                                   %> 
                <td><input type="text" name="TimeRegPartners" value="<%=conn.rs.getString("DirectAnswers")%>" id="TimeRegPartners"></td>
                  
                    
                                                 
               
                                                   <%
                                                                                                         }
 
                                                   %>          
                

               </tr>
               <tr class="d1">
                   <td>I. How often do you practice the following behaviors?(Probe for the last one year)</td>
              </tr>
              <tr class="d0">
                   <%
                            String QstnQuery9= "SELECT QuestionsID,Question FROM questions where ID=9";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery9);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDIa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnIa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 
                                                                                  }
                                
                               
                 %>                  
                    <td><select name="PracticeVaginal" id="PracticeVaginal" onChange="disableOptions2(this.selectedIndex);">
                           <option value=""></option>
                            <% String Ia="I1";
          
                            String Ans10= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Ia+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans10);
                                                      while(conn.rs.next())
                                                           {
                                                           String x= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertx= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertx);
                                                      while(conn.rs.next())
                                                            {
                                                    ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("BehavioursCode"));
                                                           behaviorList1.add(conn.rs.getString("BehavioursCodeID"));
                                                      String queryvenue =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+x+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("BehavioursCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                          
                                                      
                
                            
<!--                            <option value="Never">Never</option>
                            <option value="Sometimes(<50%)">Sometimes(<50%)</option>
                            <option value="Most times(>50%)">Most times(>50%)</option>
                            <option value="Always(100%)">Always(100%)</option>-->
                         </select>
                     </td>
                </tr>
               <tr class="d1">
                   <%
                    String QstnQuery10= "SELECT QuestionsID,Question FROM questions where ID=10";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery10);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDIb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnIb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %>
                   
                   
                   
                   
                   
<!--                   <td>Oral Sex <font style="color: red"></font></td>-->
                    <td><select name="PracticeOral" id="PracticeOral" onChange="disableOptions5(this.selectedIndex);">
                             <option value=""></option>
                            <% String Ib="I2";
          
                            String Ans11= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Ib+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans11);
                                                      while(conn.rs.next())
                                                           {
                                                    String z= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertz= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertz);
                                                      while(conn.rs.next())
                                                           {
                                                   ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("BehavioursCode"));
                                                           behaviorList1.add(conn.rs.getString("BehavioursCodeID"));
                                                      String queryvenue =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+z+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("BehavioursCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                         
                                                          
                            
                            
                            
                           
<!--                            <option value="Never">Never</option>
                            <option value="Sometimes(<50%)">Sometimes(<50%)</option>
                            <option value="Most times(>50%)">Most times(>50%)</option>
                            <option value="Always(100%)">Always(100%)</option>-->
                         </select>
                     </td>
                </tr>
               <tr class="d0">
                    <%
                    String QstnQuery11= "SELECT QuestionsID,Question FROM questions where ID=11";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery11);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDIc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnIc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %>
                   
                   
<!--                   <td>Anal Sex <font style="color: red"></font></td>-->
                    <td><select name="PracticeAnal" id="PracticeAnal" onChange="disableOptions6(this.selectedIndex);">
                             <option value=""></option>
                             <% String Ic="I3";
          
                            String Ans12= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Ic+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans12);
                                                      while(conn.rs.next())
                                                           {
                                                    String a= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConverta= "SELECT  BehavioursCode,BehavioursCodeID FROM behaviourscode ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConverta);
                                                      while(conn.rs.next()){
                                                          ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("BehavioursCode"));
                                                           behaviorList1.add(conn.rs.getString("BehavioursCodeID"));
                                                      String queryvenue =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+a+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("BehavioursCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
     
                         </select>
                     </td>
                </tr>
               
                    
                 <tr class="d1">
             <td>J. How often do you use condoms when engaging in the following?(Probe for the last one year) </td>
                 </tr>
               <tr class="d0">
     
<!--                   <td>Vaginal Sex </td>-->
          <%
                            String QstnQuery12= "SELECT QuestionsID,Question FROM questions where ID=12";
                                                    conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(QstnQuery12);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <td><input type="text" name="QIDJa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                 <input type="text" name="qstnJa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                        }
                                
                               
                 %>
             
 
                   
                    <td><select name="CondomVaginal" id="CondomVaginal">
                             <option value=""></option>
                             <% String Ja="J1";
          
                            String Ans13= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Ja+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans13);
                                                      while(conn.rs.next())
                                                           {
                                                   String b= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertb= " SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertb);
                                                             while(conn.rs.next()){
                                                          ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("BehavioursCode"));
                                                           behaviorList1.add(conn.rs.getString("BehavioursCodeID"));
                                                      String queryvenue =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+b+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("BehavioursCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
     
                            
                           
                         </select>
                     </td>
                </tr>
               <tr class="d1">
<!--                   <td>Oral Sex</td>-->

                  <%
                    String QstnQuery13= "SELECT QuestionsID,Question FROM questions where ID=13";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery13);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDJb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnJb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %>
                   
                    <td><select name="CondomOral">
                             <option value=""></option>
                              <% String Jb="J2";
          
                            String Ans14= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Jb+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans14);
                                                      while(conn.rs.next())
                                                           {
                                                    String d= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertd= "SELECT  BehavioursCode,BehavioursCodeID FROM behaviourscode ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertd);
                                                     
                                                         while(conn.rs.next()){
                                                          ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("BehavioursCode"));
                                                           behaviorList1.add(conn.rs.getString("BehavioursCodeID"));
                                                      String queryvenue =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+d+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("BehavioursCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
      
                            
                            
                            
                           
                         </select>
                     </td>
                </tr>
               <tr class="d0">
<!--                   <td>Anal Sex</td>-->
<%
                    String QstnQuery14= "SELECT QuestionsID,Question FROM questions where ID=14";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery14);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDJc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnJc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                               
                 %>
           
                   
                    <td><select name="CondomAnal">
                             <option value=""></option>
                              <% String J="J";
          
                            String Ans15= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+J+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans15);
                                                      while(conn.rs.next())
                                                           {
                                                   String e= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConverte= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConverte);
                                                       while(conn.rs.next()){
                                                          ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("BehavioursCode"));
                                                           behaviorList1.add(conn.rs.getString("BehavioursCodeID"));
                                                      String queryvenue =  "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode where BehavioursCodeID='"+e+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("BehavioursCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                            
  
                         </select>
                     </td>
                </tr>
               <tr class="d1">
                      
           
 <%
                    String QstnQuery15= "SELECT QuestionsID,Question FROM questions where ID=15";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery15);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDK"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnK" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %>
                   
                    
<!--                   <td>Who provides the condoms?<font style="color: red"></font></td>-->
                    <td><select name="CondomProvider">
                             <option value=""></option>
                             <% String K="K";
          
                            String Ans16= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+K+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans16);
                                                   
                                                      String[] CondomProvider = new String[]{"Self","Client","Both"};
                                
                                
                                                      while(conn.rs.next())
                                                           {
                                                      String CdProvide= conn.rs.getString("DirectAnswers");
                                                          
                                                for(int i=0;i<sexpart.length;i++){
                
                        if(CondomProvider[i].equals(CdProvide)){
                                      %>
                                 
                    
                <option selected value="<%= CondomProvider[i]%>"><%=CondomProvider[i]%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= CondomProvider[i]%>"><%=CondomProvider[i]%></option>
             <%   }
                                                } 
                                     
                                                                                    }
                                                   %>
                            
                           
                           
                         </select>
                     </td>
                </tr>
               <tr class="d0">
<!--                   <td>Any of your partners in the last six months known/suspected to be HIV+? <font style="color: red"></font></td>-->
 <%
                    String QstnQuery16= "SELECT QuestionsID,Question FROM questions where ID=16";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery16);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDLa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnLa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                    }
                                
                               
                 %>
            
<td><select name="HIVPartStatus" id="HIVPartStatus" onChange="disableOptions3(this.selectedIndex);">
         <option value=""></option>
         <% String L1="L1";
          
                            String Ans17= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+L1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans17);
                                                       String yesno2="";                                                     
                                while(conn.rs.next()){
                                                         
                                                           
                                                           yesno2=conn.rs.getString("DirectAnswers");
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
                        </select>
                     </td>
                                       
               </tr>
               <tr class="d1">
                   <%
                    String QstnQuery17= "SELECT QuestionsID,Question FROM questions where ID=17";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery17);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDLb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnLb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                
                               
                 %>
            <!--                    <td>If yes, How many? <font style="color: red"></font></td>-->
         <% String L2="L2";
          
                            String Ans18= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+L2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans18);
                                                      while(conn.rs.next())
                                                           {
                                                   %> 
                                                
                  
                     <td><input type="text" name="NoHIVPartStatus" id="NoHIVPartStatus" value="<%=conn.rs.getString("DirectAnswers")%>"></td>
                                                 
               
                                                   <%
                                                                                                         }
 
                                                   %>            
   
                </tr>
             <tr class="d0">

 <%
                    String QstnQuery18= "SELECT QuestionsID,Question FROM questions where ID=18";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery18);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDLc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnLc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                               
                 %>
                   
                
               </tr> 
                <tr class="d0">
<!--                    <td>Did you use a condom with this partner <font style="color: red"></font></td>-->
 <%
                    String QstnQuery19= "SELECT QuestionsID,Question FROM questions where ID=19";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery19);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDLc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnLc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                
                               
                 %>
                   
                    <td><select name="PartCondomUse" id="PartCondomUse">
                            <option value=""></option>
                            <% String L3="L3";
          
                            String Ans19= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+L3+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                                                                                 conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans19);
                                                      while(conn.rs.next())
                                                           {
                                                  String f= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertf= "SELECT CondomCode,CondomCodeID FROM condomcode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertf);
                                                      while(conn.rs.next()){
                                                           ArrayList behaviorList = new ArrayList();
                                                    ArrayList behaviorList1 = new ArrayList();
                                                    
                                                      if(behaviorList!= null && behaviorList.size()!=0){
                                                    behaviorList.clear();
                                                    }  if(behaviorList1!= null && behaviorList1.size()!=0){
                                                    behaviorList1.clear();
                                                    }
                                                          
                                                           behaviorList.add(conn.rs.getString("CondomCode"));
                                                           behaviorList1.add(conn.rs.getString("CondomCodeID"));
                                                      String queryvenue =  "SELECT CondomCode,CondomCodeID FROM condomcode where CondomCodeID='"+f+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String behavior="";
                                                                while(conn.rs2.next()){
                                                                 behavior=  conn.rs2.getString("CondomCode"); 
                                                                }

                                                  for(int i=0;i<behaviorList.size();i++){
                
  if(behaviorList.get(i).equals(behavior)){
                                      %>
                                 
                    
                <option selected value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= behaviorList1.get(i)%>"><%=behaviorList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                            
                          
                        </select>
                     </td>
                </tr>
 </table>
                        
                          </div>
                    <div id="step-2" style="height: 700px;  width:1206px;">
            <h2 class="StepTitle">Step 2: STI/HIV</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr> 
                                
                <tr class="d0"> 
                    <td> Have you ever had any of these signs in the last 6 months?</td>
                </tr>
                <tr class="d1">
<!--                    <td>i) Discharge through the genitals</td>-->
 <%
                    String QstnQuery20= "SELECT QuestionsID,Question FROM questions where ID=20";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery20);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnMa" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %>
                    
                    <td>
                        <select name="DGenitals">
                             <option value=""></option>
                             <% String M1="M1";
          
                            String Ans20= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans20);
                                               String yesno3="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno3=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno3.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno3%>"> <%=yesno3%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno3.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno3%>"> <%=yesno3%></option>
                                                       
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
                    
                    
                </tr>
                <tr class="d0">
<!--                    <td>ii) Pain when passing urine?</td>-->
 <%
                    String QstnQuery21= "SELECT QuestionsID,Question FROM questions where ID=21";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery21);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnMb" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 ;                                                      }
                                
                               
                 %>
                    
                    <td>
                        <select name="PUrine">
                             <option value=""></option>
                             <% String M2="M2";
          
                            String Ans21= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans21);
                                                       String yesno4="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno4=conn.rs.getString("DirectAnswers");
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
                    
                    
                </tr>
                <tr class="d1">
<!--                    <td>iii) Pain when engaging in Sex?</td>-->
<%
                    String QstnQuery22= "SELECT QuestionsID,Question FROM questions where ID=22";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery22);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnMc" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                
                               
                 %>
                    <td>
                        <select name="PSex">
                             <% String M3="M3";
          
                            String Ans22= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M3+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans22);
                                                       String yesno5="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno5=conn.rs.getString("DirectAnswers");
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
                    
                    
                </tr>
                <tr class="d0">
                    <%
                    String QstnQuery23= "SELECT QuestionsID,Question FROM questions where ID=23";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery23);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMd"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnMd" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                                              
                               
                 %>
                    
                    
<!--                    <td>iv) Swelling in Genital areas?</td>-->
                    <td>
                        <select name="SGenitals">
                             <% String M4="M4";
          
                            String Ans23= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M4+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans23);
                                                                   String yesno6="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno6=conn.rs.getString("DirectAnswers");
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
                    
                    
                </tr>
                <tr class="d1">
                    
                     <%
                    String QstnQuery24= "SELECT QuestionsID,Question FROM questions where ID=24";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery24);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMe"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnMe" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                                             
                               
                 %>
                    
<!--                    <td>v) Genital sores or ulcers?</td>-->
                    <td>
                        <select name="GSores">
                            
                              <% String M5="M5";
          
                            String Ans24= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M5+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                    
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans24);
                                                                                    String yesno7="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno7=conn.rs.getString("DirectAnswers");
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
                  
                
                
                <tr class="d0">
                    
                     <%
                    String QstnQuery25= "SELECT QuestionsID,Question FROM questions where ID=25";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery25);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMf"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnMf" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                                               
                               
                 %>
                    
<!--                    <td>vi) Discoloration of urine?</td>-->
                    <td>
                        <select name="DiscolorUrine">
                            
                             <% String M6="M6";
          
                            String Ans25= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M6+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans25);
                                                                                  String yesno8="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno8=conn.rs.getString("DirectAnswers");
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
                    
                    
                </tr>
                <tr class="d1">
<!--                    <td>vii) Abdominal Pain?</td>-->
 <%
                    String QstnQuery26= "SELECT QuestionsID,Question FROM questions where ID=26";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery26);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDMg"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnMg" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                                           
                               
                 %>
                    
                    <td>
                        <select name="AbdominalPain">
                             <% String M7="M7";
          
                            String Ans26= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+M7+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                          
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans26);
                                                                   String yesno9="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno9=conn.rs.getString("DirectAnswers");
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
                    
                    
                </tr>
               
                      <tr class="d0">
       <%
                    String QstnQuery27= "SELECT QuestionsID,Question FROM questions where ID=27";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery27);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDNa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnNa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                                              
                               
                 %>
                    
<!--                    <td>a) Did you seek treatment</td>-->
                    <td>
                        <select name="STISeekTreat">
                             <% String N1="N1";
          
                            String Ans27= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+N1+"' AND riskassessmentdetails.AssessmentID ="+ AssID;
                            
                          
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans27);
                                                     String yesno10="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno10=conn.rs.getString("DirectAnswers");
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
                  
                </tr>
                      <tr class="d1">
<!--                    <td>b)if yes, where did you seek treatment?</td>-->

 <%
                    String QstnQuery28= "SELECT QuestionsID,Question FROM questions where ID=28";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery28);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDNb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnNb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                       }
                                                               
                               
                 %>
                    
                    <td>
                        <select name="STIPlaceTreated">
                             <option value=""></option>
                              <% String N2="N2";
          
                            String Ans28= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+N2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                             
                                                      conn.state1= conn.connect.createStatement();
				 conn.rs1 = conn.state1.executeQuery(Ans28);
                                                       while(conn.rs1.next())
                                                            {
                                                   String g= conn.rs1.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertg= "SELECT STITreatment_Code,STITreatment_CodeID FROM stitreatment_code";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(QueryConvertg);
                                                       while(conn.rs.next())
                                                               {
                                                    ArrayList STIList = new ArrayList();
                                                    ArrayList STIList1 = new ArrayList();
                                                    
                                                      if(STIList!= null && STIList.size()!=0){
                                                    STIList.clear();
                                                    }  if(STIList1!= null && STIList1.size()!=0){
                                                   STIList1.clear();
                                                    }
                                                          
                                                           STIList.add(conn.rs.getString("STITreatment_Code"));
                                                          STIList1.add(conn.rs.getString("STITreatment_CodeID"));
                                                      String queryvenue = "SELECT STITreatment_Code,STITreatment_CodeID FROM stitreatment_code where STITreatment_CodeID='"+g+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String stitreat="";
                                                                while(conn.rs2.next()){
                                                                 stitreat=  conn.rs2.getString("STITreatment_Code"); 
                                                                }

                                                  for(int i=0;i<STIList.size();i++){
                
  if(STIList.get(i).equals(stitreat)){
                                      %>
                                 
                    
                <option selected value="<%= STIList1.get(i)%>"><%=STIList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= STIList1.get(i)%>"><%=STIList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }}
                                              
                               
                                                   %>
                           
                            
                        </select>
                        
                    </td>
                  
                </tr>
                
                <tr class="d1">
<!--                    <td>Do you use lubricants? <font style="color: red"></font></td>-->
<%
                    String QstnQuery29= "SELECT QuestionsID,Question FROM questions where ID=29";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery29);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDOa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnOa" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                                              
                               
                 %>
                    <td><select name="LubricantUse" id="LubricantUse" onChange="disableOptions27(this.selectedIndex);">
                            
                           <% String O1="O1";
          
                            String Ans29= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+O1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans29);
                                                           String yesno11="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno11=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno11.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno11%>"> <%=yesno11%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno11.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno11%>"> <%=yesno11%></option>
                                                       
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
                </tr>
                <tr class="d0"> 
<!--                    <td>If yes, What do you use? <font style="color: red"></font></td>-->
<%
                    String QstnQuery30= "SELECT QuestionsID,Question FROM questions where ID=30";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery30);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="hidden" name="QIDOb"   value="<%=conn.rs.getString("QuestionsID")%>" class="convert1">
                <input type="text" name="qstnOb" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                                 
                                                    }
                                                     
                                                             
                               
                %>
           
            <%     String QstnQueryLubs= "SELECT QuestionsID,Question FROM questions where ID=89";
                     conn.rs = conn.state.executeQuery(QstnQueryLubs);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDOOther"   value="<%= conn.rs.getString("QuestionsID")%>" class="convert1">
            <%}
             
                   
               String QstnQueryKy= "SELECT QuestionsID,Question FROM questions where ID=87";
 
				conn.rs = conn.state.executeQuery(QstnQueryKy);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



            <input type="hidden" name="QIDOKyJelly"   value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
            
            <%
                       }
            String QstnQuerySaliva= "SELECT QuestionsID,Question FROM questions where ID=88";
 conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuerySaliva);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDOSaliva"   value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
           
            <%
                       }
          %>         
            
            
            <td>KYJelly</td>
                           <% String O2A="O2A";
          
                            String Ans30= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+O2A+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans30);
                                                      while(conn.rs.next())
                                                           {
                                               
                                                     lub +=conn.rs.getString("DirectAnswers");
                                                   
                                                                                                        
 
                                                  
                     
                                
                                    } %>
                 
                    
                  
                   
                    
                       <td> <input type="hidden" name="lub" id="lub" value="<%= lub %>"><input type="checkbox" name="KYJelly" value="KYJelly" id="KYJelly"></td>
                           <% String O2B="O2B";
          
                           String ansSaliva= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+O2B+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            String saliva="";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(ansSaliva);
                                                      while(conn.rs.next())
                                                           {
                                               
                                                     saliva +=conn.rs.getString("DirectAnswers");
                                                   
                                                                                                        
 
                                                  
                     
                                
                                    } %>
                 
                    
                  
                   
                    
                        <input type="hidden" name="lubsaliva" id="lubsaliva" value="<%= saliva %>">
                
                                        
                         
                        </tr>
                <tr class="d1"><td></td><td>Saliva</td>
                    
                                                   
                       <td> <input type="checkbox" name="Saliva" value="Saliva" id="Saliva"></td>
                
                                       
                         
                        </tr>
                    
                    
                    
                   
                <tr class="d0"><td></td><td>Other,Specify</td>
                      <% String O2BSaliva="O2C";
          
                           String ansOthers= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+O2BSaliva+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            String others="";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(ansOthers);
                                                      while(conn.rs.next())
                                                           {
                                               
                                                     others +=conn.rs.getString("DirectAnswers");
                                                   
                                                                                                        
 
                                                  
                     
                                
                                    } %>
                 
                    
                  
                   
                    
                        <input type="hidden" name="others" id="others" value="<%= others %>"> 
                                                   
                       <td> <input type="checkbox" name="OtherLubricants1" value="OtherLubricants1" id="OtherLubricants1"></td>
                
                                    
                    
                    
                  </tr>
                <tr  class="d1"><td></td><td><input type="text" name="OtherLubricants" id="OtherLubricants" value="<%= others %>"></td>
                 </tr>
                
                <tr class="d0">
                    <%
                    String QstnQuery31= "SELECT QuestionsID,Question FROM questions where ID=31";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery31);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDOc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnOc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                     }
                                                             
                               
                 %>
<!--                    <td>If yes, When do you use lubricants? <font style="color: red"></font></td>-->
                <tr class="d1"><td>Anal Sex
                        <% String O3A="O3A";
          
                            String Ans33= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+O3A+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                          
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans33);
                                                      while(conn.rs.next())
                                                           {
                                                lubuse+= conn.rs.getString("DirectAnswers");
                                                                                                         }
 
                                                   %> 
                                                   <input  type="hidden" value="<%=lubuse %>" id="lubuse" name="lubuse">
                        <% String O3b="O3B";
          
                            String lubuseVaginal= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+O3b+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                          
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(lubuseVaginal);
                                 String vaginal="";
                                                      while(conn.rs.next())
                                                         
                                                           {
                                                vaginal+= conn.rs.getString("DirectAnswers");
                                                                                                         }
 
                                                   %> 
                                                   <input  type="hidden" value="<%=vaginal %>" id="vaginal" name="vaginal">
                                               
                         <%     String QstnQueryVag= "SELECT QuestionsID,Question FROM questions where ID=86";
 conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQueryVag);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     

        
            <input type="hidden" name="QIDOVaginal"  value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" >
            <%
                       }
                    %>
                       
                       <%
              String QstnQueryAnal= "SELECT QuestionsID,Question FROM questions where ID=85";
 conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQueryAnal);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     

         <input type="hidden" name="QIDOAnal"  value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" >
            
            <%
                       }
          %>                                      
                                                   
                                                   
                                                   
                                                   
                       <input type="checkbox" name="LubUseAnal" value="LubUseAnal" id="LubUseAnal"></td>
                
                                         
                    
                        
                        
                        
                        
                        
<!--                        <input type="checkbox" name="LubUseAnal" id="LubUseAnal" value="LubUseAnal"></td>-->
               <td>Vaginal Sex
                    
                                                   
                       <input type="checkbox" name="LubUseVaginal" value="LubUseVaginal" id="LubUseVaginal"></td>
                
                                       
                   
                   
<!--                   <input type="checkbox" name="LubUseVaginal" id="LubUseVaginal" value="LubUseVaginal"></td>-->
                 </tr>
               
        </table>
            </div>
                                       
  <div id="step-3" style="height: 700px;  width:1206px;">
            <h2 class="StepTitle" >Step 3: Family Planning & Douching</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                    <tr><th>Family Planning</th></tr>
                  <tr class="d0">
<!--                    <td>Are you pregnant</td>-->

<%
                    String QstnQuery32= "SELECT QuestionsID,Question FROM questions where ID=32";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery32);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
             <td><input type="text" name="QIDPa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                 <input type="text" name="qstnPa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                    }
                                                               
                               
                 %>



                    <td>
                        <select name="pregnant">
                            <% String P1="P1";
          
                            String Ans35= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+P1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans35);
                                                    String yesno12="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno12=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno12.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno12%>"> <%=yesno12%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno12.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno12%>"> <%=yesno12%></option>
                                                       
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
                  
                </tr>
                  <tr class="d1">
<!--                    <td>Do you wish to have children with the next 2 years</td>-->

<%
                    String QstnQuery33= "SELECT QuestionsID,Question FROM questions where ID=33";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery33);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDPb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnPb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                     }
                                                              
                               
                 %>
                    <td>
                        <select name="HaveKids">
                              <% String P2="P2";
          
                            String Ans36= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+P2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans36);
                                                      String yesno13="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno13=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno13.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno13%>"> <%=yesno13%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno13.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno13%>"> <%=yesno13%></option>
                                                       
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
                  
                </tr>
                  <tr class="d0">
<!--                    <td>Do you use any family planning method?</td>-->
<%
                    String QstnQuery34= "SELECT QuestionsID,Question FROM questions where ID=34";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery34);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDPc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnPc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                                              
                               
                 %>
                    <td>
                        <select name="UseFP" id="UseFP" onChange="disableOptions10(this.selectedIndex);">
                            <% String P3="P3";
          
                            String Ans37= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+P3+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans37);
                                                             String yesno14="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno14=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno14.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno14%>"> <%=yesno14%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno14.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno14%>"> <%=yesno14%></option>
                                                       
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
                  
                </tr>
                  <tr class="d1">
<!--                    <td>If yes, which method?</td>-->

<%
                    String QstnQuery35= "SELECT QuestionsID,Question FROM questions where ID=35";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery35);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDPd"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnPd" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                    }
                                                              
                               
                 %>
                    <td>
                        <select name="FPMethodUsed" id="FPMethodUsed">
                            <option value=""></option>
                             <% String P4="P4";
          
                            String Ans38= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+P4+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans38);
                                                      while(conn.rs.next())
                                                           {
                                                  String h= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConverth= "SELECT FPMethods_Code,FPMethods_CodeID FROM fpmethods_code ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConverth);
                                                      while(conn.rs.next())
                                                               {
                                                    ArrayList STIList = new ArrayList();
                                                    ArrayList STIList1 = new ArrayList();
                                                    
                                                      if(STIList!= null && STIList.size()!=0){
                                                    STIList.clear();
                                                    }  if(STIList1!= null && STIList1.size()!=0){
                                                   STIList1.clear();
                                                    }
                                                          
                                                           STIList.add(conn.rs.getString("FPMethods_Code"));
                                                          STIList1.add(conn.rs.getString("FPMethods_CodeID"));
                                                      String queryvenue = "SELECT FPMethods_Code,FPMethods_CodeID FROM fpmethods_code where FPMethods_CodeID='"+h+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String stitreat="";
                                                                while(conn.rs2.next()){
                                                                 stitreat=  conn.rs2.getString("FPMethods_Code"); 
                                                                }

                                                  for(int i=0;i<STIList.size();i++){
                
  if(STIList.get(i).equals(stitreat)){
                                      %>
                                 
                    
                <option selected value="<%= STIList1.get(i)%>"><%=STIList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= STIList1.get(i)%>"><%=STIList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }}
                                              
                               
                                                   %>
                            
                            
                            
                        </select>
                        
                    </td>
                  
                  </tr>
                 
                    
                </table>
   </div>
                          
                          
                          
  			<div id="step-4" style="height: 700px;  width:1206px;">
            <h2 class="StepTitle">Step 4: Substance Abuse</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
           
                 <tr class="d1">
<!--                    <td>Have you used alcohol in the past 3 months?</td>-->
<%
                    String QstnQuery38= "SELECT QuestionsID,Question FROM questions where ID=38";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery38);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDQa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnQa" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                      }
                                                              
                               
                 %>

                    <td><select name="AlcoholUse" id="AlcoholUse" onChange="disableOptions20(this.selectedIndex);">
                            
                             <% String Q1="Q1";
          
                            String Ans40= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Q1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans40);
                                                     
                                                          String yesno15="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno15=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno15.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno15%>"> <%=yesno15%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno15.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno15%>"> <%=yesno15%></option>
                                                       
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
                </tr>
                <tr class="d1">
<!--                    <td>If yes, how often do you take alcohol?</td>-->
<%
                    String QstnQuery39= "SELECT QuestionsID,Question FROM questions where ID=39";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery39);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDQb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnQb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                     }
                                                             
                               
                 %>


                    <td><select name="AlcoholFrequency" id="AlcoholFrequency" onChange="popaudit(this.selectedIndex);">
                            <option value=""></option>   
                        <% String Q2="Q2";
          
                            String Ans41= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+Q2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans41);
                                                      while(conn.rs.next())
                                                           {
                                                    String i= conn.rs.getString("DirectAnswers");
                                                           
                             String QueryConverti= "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConverti);
                                                    
                                                         while(conn.rs.next()){
                                                          ArrayList alcohol = new ArrayList();
                                                    ArrayList alcohol1 = new ArrayList();
                                                    
                                                      if(alcohol!= null && alcohol.size()!=0){
                                                    alcohol.clear();
                                                    }  if(alcohol1!= null && alcohol1.size()!=0){
                                                    alcohol1.clear();
                                                    }
                                                          
                                                           alcohol.add(conn.rs.getString("Alcohol_Codes"));
                                                           alcohol1.add(conn.rs.getString("Alcohol_CodesID"));
                                                      String queryalcohol =  "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes where Alcohol_CodesID='"+i+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String alcoholcodes="";
                                                                while(conn.rs2.next()){
                                                                 alcoholcodes=  conn.rs2.getString("Alcohol_Codes"); 
                                                                }

                                                 for(int j=0;j<alcohol.size();j++){
                
  if(alcohol.get(j).equals(alcoholcodes)){
                                      %>
                                 
                    
                <option selected value="<%= alcohol1.get(j)%>"><%=alcohol.get(j)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= alcohol1.get(j)%>"><%=alcohol.get(j)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                        
                         </select>
                    </td>
                </tr>
                
                <tr class="d0">
<!--                    <td>Have you used any other drug in the last 3 months?</td>-->

<%
                    String QstnQuery40= "SELECT QuestionsID,Question FROM questions where ID=40";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery40);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDRa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnRa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                                               
                               
                 %>
                    <td><select name="DrugUse" id="DrugUse" onChange="disableOptions21(this.selectedIndex);">
                              <% String R1="R1";
          
                            String Ans42= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+R1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans42);
                                                      
                                                                                String yesno16="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno16=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno16.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno16%>"> <%=yesno16%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno16.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno16%>"> <%=yesno16%></option>
                                                       
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
                </tr>
                <tr class="d1">
<!--                    <td>If yes, which one?</td>-->
<%
                    String QstnQuery41= "SELECT QuestionsID,Question FROM questions where ID=41";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery41);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDRb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnRb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                       }
                                                             
                               
                 %>
             <td>   <select  name="DrugType" id="DrugType">
              <% String R2="R2";
              String drugtype[]={"MIRAA","CIGARETTES","BHANG","ALCOHOL","COSMOS","MUGUKA","ANTIBIOTICS","MARIJUANA","KUBER"};
            String AnsR2= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+R2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(AnsR2);
                                                      while(conn.rs.next())
                                                           {
                                                               for(int w=0;w<drugtype.length;w++){
                                                               if(drugtype[w].contains(conn.rs.getString("DirectAnswers"))){
                                                   %> 
                                                
                                                   <option selected value="<%=drugtype[w]%>" ><%=drugtype[w]%></option>
                   
                
                                         <%}
                                                               else{%>
                                           <option  value="<%=drugtype[w]%>" ></option>
                                                   <%
                                                                                                         }
                                                           }}
                                                   %> 
                      </select>
                     </td>
                </tr>
                <tr class="d0">
<!--                    <td>How often?</td>-->
<%
                    String QstnQuery42= "SELECT QuestionsID,Question FROM questions where ID=42";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery42);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDRc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnRc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                    }
                                                            
                               
                 %>

                    <td><select name="DrugFrequency" id="DrugFrequency">
                             <option value=""></option>
                             <% R2="R2";
          
                            String Ans43= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+R2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans43);
                                                      while(conn.rs.next())
                                                           
                                                        {
                                                    String j= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertj= "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertj);
                                                       while(conn.rs.next()){
                                                          ArrayList alcohol = new ArrayList();
                                                    ArrayList alcohol1 = new ArrayList();
                                                    
                                                      if(alcohol!= null && alcohol.size()!=0){
                                                    alcohol.clear();
                                                    }  if(alcohol1!= null && alcohol1.size()!=0){
                                                    alcohol1.clear();
                                                    }
                                                          
                                                           alcohol.add(conn.rs.getString("Alcohol_Codes"));
                                                           alcohol1.add(conn.rs.getString("Alcohol_CodesID"));
                                                      String queryalcohol =  "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes where Alcohol_CodesID='"+j+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String alcoholcodes="";
                                                                while(conn.rs2.next()){
                                                                 alcoholcodes=  conn.rs2.getString("Alcohol_Codes"); 
                                                                }

                                                 for(int a=0;a<alcohol.size();a++){
                
  if(alcohol.get(a).equals(alcoholcodes)){
                                      %>
                                 
                    
                <option selected value="<%= alcohol1.get(a)%>"><%=alcohol.get(a)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= alcohol1.get(a)%>"><%=alcohol.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                    
                        
                         </select>
                    </td>
                </tr>
            <tr class="d1"><th>Douching</th></tr>
                    <tr class="d0">
<!--                        <td>Do you practice Vaginal Douching?</td>-->
<%
                    String QstnQuery36= "SELECT QuestionsID,Question FROM questions where ID=36";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery36);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDSa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnSa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                     }
                                                              
                               
                 %>
                     <td><select name="VaginalDouche" id="VaginalDouche" onChange="disableOptions22(this.selectedIndex);">
                              <% String S1="S1";
          
                            String Ans44= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+S1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans44);
                                                     
                                                                 
                                                                                String yesno17="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno17=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno17.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno17%>"> <%=yesno17%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno17.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno17%>"> <%=yesno17%></option>
                                                       
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
                    <td></td>
                    </tr>
                    <tr class="d1">
<!--                        <td>When do you douche?</td>-->
<%
                    String QstnQuery37= "SELECT QuestionsID,Question FROM questions where ID=37";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery37);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDSb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnSb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                
                                                                                                        }
                                                              
                               
                 %>
                        <td></td><td></td></tr>
                   <%
                     String S="SbA";
                            String QueryDouche= "SELECT DirectAnswers FROM riskassessmentdetails where QuestionID ='"+S+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryDouche);
                                                    
                                                      while(conn.rs.next())
                                                           {
                                                         
				 douche+=conn.rs.getString("DirectAnswers");
                               
                                
                                    } %>
                    <input type="hidden" name="douche" id="douche" value="<%= douche %>">
                    <%
                     String S1a="SbB";
                            String QueryBath= "SELECT DirectAnswers FROM riskassessmentdetails where QuestionID ='"+S1a+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                                                     
				conn.rs = conn.state.executeQuery(QueryBath);
                                                    String bath="";
                                                      while(conn.rs.next())
                                                           {
                                                         
				  bath+=conn.rs.getString("DirectAnswers");
                               
                                
                                    } %>
                    <input type="hidden" name="bath" id="bath" value="<%= bath %>">
                    <%
                     String S2="SbC";
                            String QueryBurst= "SELECT DirectAnswers FROM riskassessmentdetails where QuestionID ='"+S2 +"' AND riskassessmentdetails.AssessmentID ="+AssID;
                                                     
				conn.rs = conn.state.executeQuery(QueryBurst);
                                                    String burst="";
                                                      while(conn.rs.next())
                                                           {
                                                         
				 burst+=conn.rs.getString("DirectAnswers");
                              
                                
                                    } %>
                    <input type="hidden" name="burst" id="burst" value="<%= burst %>">
                   
                 
                    
                  
                   
                    
                                         <%     String AfterSex= "SELECT QuestionsID,Question FROM questions where ID=90";
                conn.rs = conn.state.executeQuery(AfterSex);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDSbA"   value="<%= conn.rs.getString("QuestionsID")%>">
            <%}
                   
               String Bathe= "SELECT QuestionsID,Question FROM questions where ID=91";
 
				conn.rs = conn.state.executeQuery(Bathe);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



            <input type="hidden" name="QIDSbB"   value="<%=conn.rs.getString("QuestionsID")%>">
            
            <%
                       }
                    %>
                       <%
            String Burst= "SELECT QuestionsID,Question FROM questions where ID=92";
 conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Burst);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDSbC"   value="<%=conn.rs.getString("QuestionsID")%>">
           
            <%
                       }
          %>         
                       <%
            String OtherDouche= "SELECT QuestionsID,Question FROM questions where ID=93";
 conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(OtherDouche);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDSbD"   value="<%=conn.rs.getString("QuestionsID")%>">
           
            <%
                       }
          %>         
            
                   
                    
                    <tr class="d0"><td>After Sex</td>
                          
                                                
                       <td><input type="checkbox" name="AfterSexDouche" id="AfterSexDouche"  value="AfterSexDouche"></td>
                
                                        
                        
                        
                        <td></td></tr>
                    <tr class="d1"><td>When Bathing</td>
                        
                             <td><input type="checkbox"  name="BathDouche" id="BathDouche" value="BathDouche"></td>                   
                      
                
                                    
                        
                        
                        
                        <td></td></tr>
                    <tr class="d0"><td>Condom Burst</td>
                   <td><input type="checkbox"  name="CdBurstDouche" id="CdBurstDouche" value="CdBurstDouche"></td>
                                            
                      
                
                        
                        
                        
                       <td></td></tr>
                    <tr class="d1"><td>Other</td>
                                        
               <td><input type="checkbox"  name="OtherDouche1" id="OtherDouche1" value="CdBurstDouche"></td>
                                            
                  <%
                     String S3="SbD";
                            String QueryOthers= "SELECT DirectAnswers FROM riskassessmentdetails where QuestionID ='"+S3 +"' AND riskassessmentdetails.AssessmentID ="+AssID;
                                                     
				conn.rs = conn.state.executeQuery(QueryOthers);
                                                    String otherdouche="";
                                                      while(conn.rs.next())
                                                           {
                                                         
				 otherdouche+=conn.rs.getString("DirectAnswers"); 
                              
                                
                                    } %>
                    <input type="hidden" name="otherdouche" id="otherdouche" value="<%= otherdouche %>">
                        <td><input type="text" name="OtherDouche" id="OtherDouche" value="<%= otherdouche %>"></td>
                        
                    </tr>
                    
                   
                    
                    </table>
                        </div>
       
  			<div id="step-5" style="height: 700px;  width:1200px;">
            <h2 class="StepTitle">Step 5: Sexual and Gender Based Violence</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>   
                                
                                <tr class="d1"><td>T. In the past 3 months, has anyone:</td></tr>
                    <tr class="d0">
<!--                    <td>a) Have you been beaten or seriously threatened by your partner or anyone of the opposite sex? </td>-->
<%
                    String QstnQuery43= "SELECT QuestionsID,Question FROM questions where ID=43";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery43);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                                              
                               
                 %>





                    <td><select name="VerbalInsults" id="VerbalInsults" onChange="disableOptions23(this.selectedIndex);">
                             <option value=""></option>
                             <% String T1="T1";
          
                            String Ans49= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans49);
                                                    
                               String yesno18="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno18=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno18.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno18%>"> <%=yesno18%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno18.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno18%>"> <%=yesno18%></option>
                                                       
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
<!--                        <td>When was the last time</td>-->
<%
                    String QstnQuery44= "SELECT QuestionsID,Question FROM questions where ID=44";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery44);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTa1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTa1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
                                                   <%
                                                       
                                                                                  }
                                                             
                               
                 %>




                        <select name="LastVerbalInsult">
                              <option value=""></option>
                    <% String T2="T2";
           String abusecodes1="";
            ArrayList abuses = new ArrayList();
                                                    ArrayList abuses1 = new ArrayList();
                            String Ans50= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans50);
                                                      while(conn.rs.next())
                                                           {
                                                    String k= conn.rs.getString("DirectAnswers");
                                                            
                            
                            String QueryConvertk= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertk);
                                                      while(conn.rs.next()){
                                                         
                                                    
                                                      if(abuses!= null && abuses.size()!=0){
                                                    abuses.clear();
                                                    }  if(abuses1!= null && abuses1.size()!=0){
                                                    abuses1.clear();
                                                    }
                                                          
                                                           abuses.add(conn.rs.getString("AbuseCode"));
                                                           abuses1.add(conn.rs.getString("AbuseCodeID"));
                                                      String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+k+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                              
                                                                while(conn.rs2.next()){
                                                                 abusecodes1=  conn.rs2.getString("AbuseCode"); 
                                                                }
   
                                                 for(int a=0;a<abuses.size();a++){
                
  if(abuses.get(a).equals(abusecodes1)){
                                      %>
                                 
                    
                <option selected value="<%= abuses1.get(a)%>"><%=abuses.get(a)%></option>
                
               <% }
                
                else {%>
                    
                <option  value="<%= abuses1.get(a)%>"><%=abuses.get(a)%></option>
             <%   }
                             }   }                     
                                                      
                                                      }   
                                                      
                                                                                            
                                              
                               
                                                   %>
                                                    

                         
                            </select></td>
                    </tr>
                    <tr class="d1">
<!--                    <td>b) Have you been raped by your partner or or any other person? </td>-->
<%
                    String QstnQuery45= "SELECT QuestionsID,Question FROM questions where ID=45";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery45);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnTb" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                                              
                               
                 %>
                    <td><select name="Hit" id="Hit" onChange="disableOptions24(this.selectedIndex);">
                              <% String T3="T3";
          
                            String Ans51= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T3+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans51);
                                                     
                            String yesno19="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno19=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno19.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno19%>"> <%=yesno19%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno19.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno19%>"> <%=yesno19%></option>
                                                       
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
                    String QstnQuery46= "SELECT QuestionsID,Question FROM questions where ID=46";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery46);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTb1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTb1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
                                                   <%
                                                       
                                                                                      }
                                                              
                               
                 %>
                            
                            
                            
                            
                       
                       <select name="LastVerbalInsultHit" id="LastVerbalInsultHit">
                            <option value=""></option>
                             <% String T4="T4";
          
                            String Ans52= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T4+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans52);
                                                      while(conn.rs.next())
                                                           {
                                                         
                                                    String l= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertl= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertl);
                                                       while(conn.rs.next()){
                                                          ArrayList abuse = new ArrayList();
                                                    ArrayList abuse1 = new ArrayList();
                                                    
                                                      if(abuse!= null && abuse.size()!=0){
                                                    abuse.clear();
                                                    }  if(abuse1!= null && abuse1.size()!=0){
                                                    abuse1.clear();
                                                    }
                                                          
                                                           abuse.add(conn.rs.getString("AbuseCode"));
                                                           abuse1.add(conn.rs.getString("AbuseCodeID"));
                                                      String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+l+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String abusecodes="";
                                                                while(conn.rs2.next()){
                                                                 abusecodes=  conn.rs2.getString("AbuseCode"); 
                                                                }

                                                 for(int a=0;a<abuse.size();a++){
                
  if(abuse.get(a).equals(abusecodes)){
                                      %>
                                 
                    
                <option selected value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                    

                           
                          
                            </select></td>
                    </tr>
                    <tr class="d0">
<!--                    <td>c)Does your partner deliberately deprive you of economic support? </td>-->

<%
                    String QstnQuery47= "SELECT QuestionsID,Question FROM questions where ID=47";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery47);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTc" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                      }
                                                              
                               
                 %>
                    <td><select name="ForcedSex" id="ForcedSex" onChange="disableOptions25(this.selectedIndex);">
                             <option value=""></option>
                              <% String T5="T5";
          
                            String Ans53= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T5+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans53);
                                                     String yesno20="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno20=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno20.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno20%>"> <%=yesno20%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno20.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno20%>"> <%=yesno20%></option>
                                                       
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
                    String QstnQuery48= "SELECT QuestionsID,Question FROM questions where ID=48";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery48);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTc1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTc1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
                                                   <%
                                                       
                                                       }
                                                              
                               
                 %>
                            
                            
                            
                            
                       
                        <select name="LastVerbalInsultForced">
                             <option value=""></option>
                             <% String T6="T6";
          
                            String Ans54= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T6+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                         
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans54);
                                                      while(conn.rs.next())
                                                           {
                                                    String m= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertm= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertm);
                                                    
                                                                 while(conn.rs.next()){
                                                          ArrayList abuse = new ArrayList();
                                                    ArrayList abuse1 = new ArrayList();
                                                    
                                                      if(abuse!= null && abuse.size()!=0){
                                                    abuse.clear();
                                                    }  if(abuse1!= null && abuse1.size()!=0){
                                                    abuse1.clear();
                                                    }
                                                          
                                                           abuse.add(conn.rs.getString("AbuseCode"));
                                                           abuse1.add(conn.rs.getString("AbuseCodeID"));
                                                      String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+m+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String abusecodes="";
                                                                while(conn.rs2.next()){
                                                                 abusecodes=  conn.rs2.getString("AbuseCode"); 
                                                                }

                                                 for(int a=0;a<abuse.size();a++){
                
  if(abuse.get(a).equals(abusecodes)){
                                      %>
                                 
                    
                <option selected value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                    

                           
                     
                            </select></td>
                    </tr>
                    <tr class="d1">
<!--                    <td>d)Does your partner deliberately say or do bad things in order to hurt you? </td>-->
<%
                    String QstnQuery49= "SELECT QuestionsID,Question FROM questions where ID=49";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery49);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTd"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnTd" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                      }
                                                              
                               
                 %>
                    <td><select name="VerbalAbuse" id="VerbalAbuse" onChange="disableOptions28(this.selectedIndex);">
                             <option value=""></option>
                             <% String T7="T7";
          
                            String Ans55= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T7+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans55);
                                                      String yesno21="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno21=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno21.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno21%>"> <%=yesno21%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno21.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno21%>"> <%=yesno21%></option>
                                                       
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
                    String QstnQuery50= "SELECT QuestionsID,Question FROM questions where ID=50";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery50);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTd1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTd1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
                                                   <%
                                                       
                                                       }
                                                              
                               
                 %>
                            
             
                        
                        <select name="VerbalAbuseTime" id="VerbalAbuseTime">
                               <option value=""></option>
                                <% String T8="T8";
          
                            String Ans56= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T8+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans56);
                                                      while(conn.rs.next())
                                                           {
                                                    String n= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertn= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertn);
                                                                    
                                                                 while(conn.rs.next()){
                                                          ArrayList abuse = new ArrayList();
                                                    ArrayList abuse1 = new ArrayList();
                                                    
                                                      if(abuse!= null && abuse.size()!=0){
                                                    abuse.clear();
                                                    }  if(abuse1!= null && abuse1.size()!=0){
                                                    abuse1.clear();
                                                    }
                                                          
                                                           abuse.add(conn.rs.getString("AbuseCode"));
                                                           abuse1.add(conn.rs.getString("AbuseCodeID"));
                                                      String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+n+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String abusecodes="";
                                                                while(conn.rs2.next()){
                                                                 abusecodes=  conn.rs2.getString("AbuseCode"); 
                                                                }

                                                 for(int a=0;a<abuse.size();a++){
                
  if(abuse.get(a).equals(abusecodes)){
                                      %>
                                 
                    
                <option selected value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                                                    


                            </select></td>
                    </tr>
                    <tr class="d0">
                        
                        <td><input type="text" name="QIDTe"  hidden value="T9" class="convert2" readonly>
                        e)Do any partner related problems affect your use of condoms,FP</br> or seeking health services through disclosure and adherence to treatment  </td>
<!--                <input type="text" name="qstnTe" value="e)Do any partner related problems affect your use of condoms,FP</br> or seeking health services through disclosure and adherence to treatment " class="convert2" readonly></td>-->
  
                    <td><select name="PartnerProblem" id="PartnerProblem" onChange="disableOptions29(this.selectedIndex);">
                            
                             <% String T9="T9";
          
                            String Ans57= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T9+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans57);
                                                                          String yesno22="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno22=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno22.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno22%>"> <%=yesno22%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno22.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option  selected value="<%=yesno22%>"> <%=yesno22%></option>
                                                       
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
                    String QstnQuery52= "SELECT QuestionsID,Question FROM questions where ID=52";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery52);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDTe1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnTe1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
                                                   <%
                                                       
                                                                                      }
                                                               
                               
                 %>
                       
                        <select name="PartnerProblemTime" id="PartnerProblemTime">
                               <option value=""></option> 
                        <% String T10="T10";
          
                            String Ans58= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+T10+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans58);
                                                      while(conn.rs.next())
                                                           {
                                                   String o= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConverto= "SELECT AbuseCode,AbuseCodeID FROM abusecode ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConverto);
                                                      while(conn.rs.next()){
                                                          ArrayList abuse = new ArrayList();
                                                    ArrayList abuse1 = new ArrayList();
                                                    
                                                      if(abuse!= null && abuse.size()!=0){
                                                    abuse.clear();
                                                    }  if(abuse1!= null && abuse1.size()!=0){
                                                    abuse1.clear();
                                                    }
                                                          
                                                           abuse.add(conn.rs.getString("AbuseCode"));
                                                           abuse1.add(conn.rs.getString("AbuseCodeID"));
                                                      String queryalcohol =  "SELECT AbuseCode,AbuseCodeID FROM abusecode where AbuseCodeID='"+o+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String abusecodes="";
                                                                while(conn.rs2.next()){
                                                                 abusecodes=  conn.rs2.getString("AbuseCode"); 
                                                                }

                                                 for(int a=0;a<abuse.size();a++){
                
  if(abuse.get(a).equals(abusecodes)){
                                      %>
                                 
                    
                <option selected value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
                
               <% }
                
                else{%>
                
                <option  value="<%= abuse1.get(a)%>"><%=abuse.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                            
                            </select></td>
                    </tr>
                <tr class="d1">
<!--                    <td>Did you seek treatment after this happened?</td>-->
<%
                    String QstnQuery53= "SELECT QuestionsID,Question FROM questions where ID=53";
                                    conn.state= conn.connect.createStatement();
				  conn.rs = conn.state.executeQuery(QstnQuery53);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDUa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnUa" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                                               
                               
                 %>




            <td><select name="SeekTreatment" id="SeekTreatment" onChange="disableOptions26(this.selectedIndex);" >
                    
                      <% String U1="U1";
          
                            String Ans59= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+U1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans59);
                                                                          String yesno23="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno23=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno23.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno23%>"> <%=yesno23%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno23.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno23%>"> <%=yesno23%></option>
                                                       
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
                    <td></td><td></td>
                    </tr>    
                <tr class="d0">
<!--                    <td>Where did you seek treatment?</td>-->
<%
                    String QstnQuery54= "SELECT QuestionsID,Question FROM questions where ID=54";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery54);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDUb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnUb" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                       }
                                                              
                               
                 %>

                     <td><select name="PlaceTreated" id="PlaceTreated" required>
                              <option value=""></option>
                              <% String U2="U2";
          
                            String Ans60= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+U2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                           
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans60);
                                                      while(conn.rs.next())
                                                           {
                                                    String p= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertp= "SELECT PlaceTreated_Code,PlaceTreated_CodeID FROM placetreated_code ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertp);
                                                      while(conn.rs.next()){
                                                          ArrayList treated = new ArrayList();
                                                    ArrayList treated1 = new ArrayList();
                                                    
                                                      if(treated!= null && treated.size()!=0){
                                                    treated.clear();
                                                    }  if(treated1!= null && treated1.size()!=0){
                                                    treated1.clear();
                                                    }
                                                          
                                                           treated.add(conn.rs.getString("PlaceTreated_Code"));
                                                           treated1.add(conn.rs.getString("PlaceTreated_CodeID"));
                                                      String queryalcohol =  "SELECT PlaceTreated_Code,PlaceTreated_CodeID FROM placetreated_code where PlaceTreated_CodeID='"+p+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String treatedcodes="";
                                                                while(conn.rs2.next()){
                                                                 treatedcodes=  conn.rs2.getString("PlaceTreated_Code"); 
                                                                }

                                                 for(int a=0;a<treated.size();a++){
                
  if(treated.get(a).equals(treatedcodes)){
                                      %>
                                 
                    
                <option selected value="<%= treated1.get(a)%>"><%=treated.get(a)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= treated1.get(a)%>"><%=treated.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                             
  
                         </select>
                    </td>
                    <td></td><td></td>
                    </tr>  
                    <tr class="d1">
<!--                        <td>Did you report?</td>-->

<%
                    String QstnQuery55= "SELECT QuestionsID,Question FROM questions where ID=55";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery55);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDVa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnVa" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                                       }
                                                             
                               
                 %>




                     <td><select name="ReportPolice" id="ReportPolice" onChange="disableOptions9(this.selectedIndex);">
                              <option value=""></option>
                              <% String V1="V1";
          
                            String Ans61= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+V1+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans61);
                                                     String yesno24="";                                                                               
                                while(conn.rs.next()){
                                                             
                                                           
                                                           yesno24=conn.rs.getString("DirectAnswers");
                                                      }
                                                          
                                                          if(yesno24.equals("Yes")){
                                                   %> 
                                                    <option selected value="<%=yesno24%>"> <%=yesno24%></option>
                                                        <option value="No">No</option>
               
                                                   <%
                                                                                                         }
                                        else if(yesno24.equals("No")){%>
                                                                                                                    <option value="Yes">Yes</option>
                                                                                                                    <option selected value="<%=yesno24%>"> <%=yesno24%></option>
                                                       
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
                    </tr>
                    <tr  class="d0">
<!--                        <td>If yes, where?</td>-->
<%
                    String QstnQuery56= "SELECT QuestionsID,Question FROM questions where ID=56";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery56);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDVb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnVb" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
                                                                                      }
                                                              
                               
                 %>





                        <td><select name="ReportWhere" id="ReportWhere">
                                 <option value=""></option>
<!--                                <option value=""></option>-->
 <% String V2="V2";
          
                            String Ans62= "SELECT DirectAnswers FROM riskassessmentdetails WHERE QuestionID='"+V2+"' AND riskassessmentdetails.AssessmentID ="+AssID;
                            
                            
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Ans62);
                                                      while(conn.rs.next())
                                                           {
                                                  String q= conn.rs.getString("DirectAnswers");
                                                           
                            
                            String QueryConvertq= "SELECT ReportCode,ReportCodeID FROM reportCode";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertq);
                                                      while(conn.rs.next()){
                                                          ArrayList report = new ArrayList();
                                                    ArrayList report1 = new ArrayList();
                                                    
                                                      if(report!= null && report.size()!=0){
                                                    report.clear();
                                                    }  if(report1!= null && report1.size()!=0){
                                                    report1.clear();
                                                    }
                                                          
                                                           report.add(conn.rs.getString("ReportCode"));
                                                           report1.add(conn.rs.getString("ReportCodeID"));
                                                      String queryalcohol =  "SELECT ReportCode,ReportCodeID FROM reportCode where ReportCodeID='"+q+"'";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryalcohol);
                                                                String reportcodes="";
                                                                while(conn.rs2.next()){
                                                                 reportcodes=  conn.rs2.getString("ReportCode"); 
                                                                }

                                                 for(int a=0;a<report.size();a++){
                
  if(report.get(a).equals(reportcodes)){
                                      %>
                                 
                    
                <option selected value="<%= report1.get(a)%>"><%=report.get(a)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= report1.get(a)%>"><%=report.get(a)%></option>
             <%   }
                             }     
                                                      
                                                                                                }                     
                                                      
                                                      }
                                              
                               
                                                   %>
                           
                         </select>
                    </td>
                    </tr>
                   
                    
    
    
                </table>
            
                  </form>
     </div>
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