<%-- 
    Document   : RiskAssessment
    Created on : Aug 7, 2013, 8:54:35 AM
    Author     : Cheka
--%>
<%@page import="dbConnect.dbConnect"%>
<%!
dbConnect conn = new dbConnect();
%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
 <script type="text/javascript" src="jquery-1.7.2.js"></script>       
       
<!--<script src="lib/jquery.js" type="text/javascript"></script>
<script src="lib/additional-methods.js" type="text/javascript"></script>
<script src="lib/jquery.validate.js" type="text/javascript"></script>-->
        <SCRIPT language=Javascript>
//function disableOptions0(v) {
  //var df = document.form;
  //var LastSex = df.LastSex;
  //var TimeRegPartners = df.TimeRegPartners;
  
//if(!(v==4)) {
//  TimeRegPartners.disabled = false;
  
//  }
//else {
  //TimeRegPartners.disabled = true;
  //}
//}
function disableOptions20(v) {
  var df = document.form;
  var AlcoholUse = df.AlcoholUse;
  var AlcoholFrequency = df.AlcoholFrequency;
  
if(v==2) {
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
  
if(v==2 || v==0) {
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
  
if(v==2 || v==0) {
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
  
 
  
if(v==2) {
   
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
 
if(v==2) {
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
 
 if(v==2) {
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
if(v==2) {
  
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
if(v==2) {
document.getElementById('KYJelly').checked = false;
 document.getElementById('Saliva').checked = false;
  document.getElementById('OtherLubricants').value = "";
  document.getElementById('OtherLubricants1').checked = false;
  document.getElementById('LubUseAnal').checked = false;
  document.getElementById('LubUseVaginal').checked = false;
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
 
if(v==2) {
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
 
if(v==2) {
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
 
  
if(v==2) {
  
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
 
if(v==2) {
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
  //document.getElementById('NoPayingClients').value = "";
  }
else {
  NoPayingClients.disabled = false;
  }
}

function disableOptions52(v) {
  var df = document.form;
  var STISeekTreat = df.STISeekTreat;
  var STIPlaceTreated = df.STIPlaceTreated;
  
if(v==2) {
  STIPlaceTreated.disabled = true;
  //document.getElementById('NoPayingClients').value = "";
  }
else {
  STIPlaceTreated.disabled = false;
  }
}
function disableOptions1(v) {
  var df = document.form;
  var RegPartner = df.RegPartner;
  var NoRegPartner = df.NoRegPartner;
  var TimeRegPartners = df.TimeRegPartners;
  
if(v==2) {
  NoRegPartner.disabled = true;
//  TimeRegPartners.disabled = true;
   document.getElementById('NoRegPartner').value = "";
   document.getElementById('TimeRegPartners').value = "";
  }
else {
  NoRegPartner.disabled = false;
//   TimeRegPartners.disabled = false;
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
  NoHIVPartStatus.disabled = false;
  PartCondomUse.disabled = false;
  document.getElementById('NoHIVPartStatus').value = "";
  document.getElementById('PartCondomUse').value = "";
  
  }
else {
  NoHIVPartStatus.disabled = true;
  PartCondomUse.disabled = true;
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
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

	<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
	<link rel="stylesheet" href="themes/eggplant/jquery.ui.all.css">
<!--	<script src="jquery-1.7.2.js"></script>-->
	<link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="js/DICHelp.js"></script>   
       <script src="js/datepicker.js"></script>
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
        
        
        
   <link rel="StyleSheet" href="css/main.css" type="text/css" />
  <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <style type="text/css">
    #container{
                height:970px;
                width:1225px; 
    }
    .example {
    width:1350px;
    height:1250px;}
    </style>
    
    <link href="css/demo_style.css" rel="stylesheet" type="text/css">

<link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.smartWizard.js"></script>
<script type="text/javascript" src="js/RiskAssessValidate.js"></script> 
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
  
if(v==2 || v==1 || v==4 || v==3) {
   
  popupWindow=window.open( 'audit.jsp','','width=1400,height=500');
//    window.location="audit.jsp";
}

}



function parent_disable() {
if(popupWindow && !popupWindow.closed)
popupWindow.focus();
}
</script>
        <title>Risk Assessment </title>
    </head>
    <body onFocus="parent_disable();" onclick="parent_disable();">
         <%
String UniqueID1 = (String)session.getAttribute("UniqueID");           
//String ClientInit1 = (String)session.getAttribute("ClientInit");           
//String District1 = (String)session.getAttribute("District");           
//String Sex1 = (String)session.getAttribute("Sex");           
//String DICName1 = (String)session.getAttribute("DICName");           
String count =session.getAttribute("count").toString(); 
int counter = (Integer.parseInt(count));
System.out.println("Session"+UniqueID1);
//System.out.println( ClientInit1);
//System.out.println( District1);
//System.out.println( Sex1);
//System.out.println( DICName1);



%>

<div class="example" style="width: 1350px;">
           <div class="login">
     <% String logStatus ="";
     if(session.getAttribute("loggedIn")!=null && !session.getAttribute("loggedIn").equals("")){
     
   logStatus=(String)session.getAttribute("loggedIn");}
               if(session.getAttribute("loggedIn")==null){
     
//               response.sendRedirect("index.jsp");
           }  else{
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
            <%@include file="menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
    
       <% 
 
 //get the helps from the database.
 
 String Sectionshelp[]=new String [15];
int mcount=0;
if(conn.state2.isClosed()){conn= new dbConnect();}
conn.rs2=conn.state2.executeQuery("Select * from help where help_id<='15'");
 
while(conn.rs2.next()){
    
Sectionshelp[mcount]=conn.rs2.getString(2);
if(mcount<=15){
mcount++;
}
}

%>
     <div id="container">
      <p style="color:red"> This is Risk Assessment No: <%= counter+1 %> </p>      
             
<!--        <h3>Risk Assessment: SECTION 1 </h3>
        <h4>To be filled by peer counsellor/Counsellor</h4>
        
         <h4>Please fill all the fields marked with <font style="color: red">*</font> </h4> 
    --> 
    <div class="demoHead">  
        <table>
                       
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[6]!=null){%>
         <%=Sectionshelp[6]%> 
         <%}%>
    </td>
    </tr>
        </table>
  <h2>Risk Assessment <a href="#" id="dialog-link1" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>
</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
 
 
<tr><td>
        
        
       
          

 <form action="RikAssessServlet" name="form" method="post">
 <input type='hidden' name="issubmit" value="1">
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
    <table>
    <tr id="dialog2" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[7]!=null){%>
         <%=Sectionshelp[7]%> 
         <%}%>
    </td>
    </tr>
    </table>             
    <div id="step-1" style="height: 700px; width:1000px; padding:10px 100px 60px 100px;">
                        <h2 class="StepTitle">Step 1: Sexual Practices <a href="#" id="dialog-link2" style="padding-right: 0px;">
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
                              

                                 </select></td></tr>
                                 <tr class="d1">
                                 <td>DIC Name <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName"  >
                                 <option value="">Choose DIC Name</option>  

                                 </select>
                                    </td>
                </tr>
 <tr class="d0">
       <% 
                            String QstnQuery= "SELECT QuestionsID,Question FROM questions where ID=57";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery);
                                 if(conn.state.isClosed()){conn= new dbConnect();}
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QID1"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstn1" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly><font style="color: blue">*</font></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                           
                                                   %>

    <td><input type="text" name="DOA" id="DOA"  class="datepicker" readonly title="Enter date" value="" onclick="return function()" required></td></tr>
                <tr class="d1">
                    <% 
                            String QstnQuery1= "SELECT QuestionsID,Question FROM questions where ID=1";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery1);
                                 if(conn.state.isClosed()){conn= new dbConnect();}
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDA"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnA" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                                                              
                 %>
            
                    <td>
                        <select name="SexLast" id="SexLast" onChange="disableOptions0(this.selectedIndex);">
                            <option value=""></option>
                             <% 
                            String Query= "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query);
                                 if(conn.state.isClosed()){conn= new dbConnect();}
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("LastSex_CodeID")%>'><%=conn.rs.getString("LastSex_Code")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("LastSex_CodeID"));
                                System.out.println(conn.rs.getString("LastSex_Code"));                                                      }
                                
                               
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
                                 if(conn.state.isClosed()){conn= new dbConnect();}
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDB"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnB" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                    
<!--                    <td>Did you use a condom? <font style="color: red"></font></td>-->
                    <td><select name="CondomUse"  id="CondomUse">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %> 
<!--                <td>Genders of your sex partners? <font style="color: red"></font></td>-->
                    <td><select name="SexPartGender" id="SexPartGender">
                            <option value=""></option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Both">Both</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %> 
                  
            <td>   
<!--<td>When was the last time you had sex with a paying partner?(Probe for last 3 months)? <font style="color: red"></font></td>-->
              <select name="ActiveSexWork" id="ActiveSexWork">
                  <option value=""></option>
 <% 
                            String Queryd= "SELECT LastSex_Code,LastSex_CodeID FROM lastsex_code";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Queryd);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("LastSex_CodeID")%>'><%=conn.rs.getString("LastSex_Code")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("LastSex_CodeID"));
                                System.out.println(conn.rs.getString("LastSex_Code"));                                                      }
                                
                               
                                                   %>
                          </select>
            </td>
<!--                    <td><input type="text" name="ActiveSexWork" id="ActiveSexWork" >-->
<!--                        onChange="disableOptions(this.selectedIndex);-->
<!--                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                         </select>-->
<!--                     </td>-->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %> 
<!--                    <td>Average number of paying clients per week: <font style="color: red"></font></td>-->
                    <td><select name="AvgNoPayingClients" id="NoPayingClients" >
                            <option value=""></option> 
                            <option value="0-10">0-10</option> 
                            <option value="10-20">10-20</option> 
                            <option value="30-50">30-50</option> 
                            <option value="Over 50">Over 50</option> 
                            
                        </select>
                    </td>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %> 
                   
                   
<!--                   <td>Do you have a non-paying partner(husband,boyfriend)? <font style="color: red"></font></td>-->
                    <td><select name="RegPartner" id="RegPartner" onChange="disableOptions1(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                         </select>
                     </td>
                </tr>
                <tr class="d1">
                     <%
                            String QstnQuery7= "SELECT QuestionsID,Question FROM questions where ID=7";
                                                     conn.state= conn.connect.createStatement();
				conn.rs3= conn.state.executeQuery(QstnQuery7);
                                                      while(conn.rs3.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDG"  hidden value="<%=conn.rs3.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnG" value="<%=conn.rs3.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs3.getString("QuestionsID"));
                                System.out.println(conn.rs3.getString("Question"));                                                      }
                                
                               
                 %> 
<!--                    <td>How many non-paying partners do you have? <font style="color: red"></font></td>-->
                    <td><input type="number" name="NoRegPartner" value="" id="NoRegPartner"></td>
               </tr>
                <tr class="d0">
                             <%
                            String QstnQuery8= "SELECT QuestionsID,Question FROM questions where ID=8";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery8);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDH"  value="<%=conn.rs.getString("QuestionsID")%>" class="convert_1" readonly>
                <input type="hidden" name="qstnH" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                   In the last one month, how many times did you have sex with a non-paying partner? </td>
        

               
                
<td><input type="number" name="TimeRegPartners" value="" id="TimeRegPartners"></td>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>                  
                    <td><select name="PracticeVaginal" id="PracticeVaginal" onChange="disableOptions2(this.selectedIndex);">
                            
                              <% 
                            String Query1= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                    conn.state= conn.connect.createStatement();
                                        conn.rs = conn.state.executeQuery(Query1);
                                                     while(conn.rs.next()){
                                                           
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("BehavioursCodeID")%>'><%=conn.rs.getString("BehavioursCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("BehavioursCodeID"));
                                 System.out.println(conn.rs.getString("BehavioursCode"));                                                     
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                   
                   
                   
                   
                   
<!--                   <td>Oral Sex <font style="color: red"></font></td>-->
                    <td><select name="PracticeOral" id="PracticeOral" onChange="disableOptions5(this.selectedIndex);">
                             <% 
                            String Query2= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query2);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("BehavioursCodeID")%>'><%=conn.rs.getString("BehavioursCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("BehavioursCodeID"));
                                 System.out.println(conn.rs.getString("BehavioursCode"));                                                      }
                                
                               
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                   
                   
<!--                   <td>Anal Sex <font style="color: red"></font></td>-->
                    <td><select name="PracticeAnal" id="PracticeAnal" onChange="disableOptions6(this.selectedIndex);">
                             <% 
                            String Query3= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query3);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("BehavioursCodeID")%>'><%=conn.rs.getString("BehavioursCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("BehavioursCodeID"));
                                 System.out.println(conn.rs.getString("BehavioursCode"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="Never">Never</option>
                            <option value="Sometimes(<50%)">Sometimes(<50%)</option>
                            <option value="Most times(`>50%)">Most times(>50%)</option>
                            <option value="Always(100%)">Always(100%)</option>-->
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
                                                       
  System.out.println(conn.rs.getString("QuestionsID"));
                                 System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
             
 
                   
                    <td><select name="CondomVaginal" id="CondomVaginal">
                            <% 
                            String Query4= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query4);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("BehavioursCodeID")%>'><%=conn.rs.getString("BehavioursCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("BehavioursCodeID"));
                                 System.out.println(conn.rs.getString("BehavioursCode"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="N/A">N/A</option>
                            <option value="Never">Never</option>
                            <option value="Sometimes(<50%)">Sometimes(<50%)</option>
                            <option value="Most times(>50%)">Most times(>50%)</option>
                            <option value="Always(100%)">Always(100%)</option>-->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                   
                    <td><select name="CondomOral">
                            <% 
                            String Query5= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                    conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query5);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("BehavioursCodeID")%>'><%=conn.rs.getString("BehavioursCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("BehavioursCodeID"));
                                 System.out.println(conn.rs.getString("BehavioursCode"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="N/A">N/A</option>
                            <option value="Never">Never</option>
                            <option value="Sometimes(<50%)">Sometimes(<50%)</option>
                            <option value="Most times(>50%)">Most times(>50%)</option>
                            <option value="Always(100%)">Always(100%)</option>-->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
           
                   
                    <td><select name="CondomAnal">
                            <% 
                            String Query6= "SELECT BehavioursCode,BehavioursCodeID FROM behaviourscode";
                                                    conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query6);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("BehavioursCodeID")%>'><%=conn.rs.getString("BehavioursCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("BehavioursCodeID"));
                                 System.out.println(conn.rs.getString("BehavioursCode"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="N/A">N/A</option>
                            <option value="Never">Never</option>
                            <option value="Sometimes(<50%)">Sometimes(<50%)</option>
                            <option value="Most times(`>50%)">Most times(>50%)</option>
                            <option value="Always(100%)">Always(100%)</option>-->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                   
                    
<!--                   <td>Who provides the condoms?<font style="color: red"></font></td>-->
                    <td><select name="CondomProvider" id="CondomProvider">
                            <option value=""></option>
                            <option value="Self">Self</option>
                            <option value="Client">Client</option>
                            <option value="Both">Both</option>
                           
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
            
<td><select name="HIVPartStatus" id="HIVPartStatus" onChange="disableOptions3(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
            <!--                    <td>If yes, How many? <font style="color: red"></font></td>-->
                   
    <td><input type="number" name="NoHIVPartStatus" id="NoHIVPartStatus" value=""></td>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                   
                    <td><select name="PartCondomUse" id="PartCondomUse">
                             <option value=""></option>
                            <% 
                            String Query7= "SELECT CondomCode,CondomCodeID FROM condomcode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query7);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("CondomCodeID")%>'><%=conn.rs.getString("CondomCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("CondomCodeID"));
                                 System.out.println(conn.rs.getString("CondomCode"));                                                      }
                                
                               
                                                   %>
<!--                            <option value=""></option>
                            <option value="Always">Always</option>
                            <option value="Sometimes">Sometimes</option>
                            <option value="Never">Never</option>-->
                        </select>
                     </td>
                </tr>
 </table>
                        
                          </div>

<table>
      <tr id="dialog3" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[8]!=null){%>
         <%=Sectionshelp[8]%> 
         <%}%>
    </td>
    </tr>
    
    
    
</table>
                    <div id="step-2" style="height: 700px;  width:1206px;">
            <h2 class="StepTitle">Step 2: STI/HIV <a href="#" id="dialog-link3" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                    
                    <td>
                        <select name="DGenitals">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                    
                    <td>
                        <select name="PUrine">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                
                               
                 %>
                    <td>
                        <select name="PSex">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    
                    
<!--                    <td>iv) Swelling in Genital areas?</td>-->
                    <td>
                        <select name="SGenitals">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                             
                               
                 %>
                    
<!--                    <td>v) Genital sores or ulcers?</td>-->
                    <td>
                        <select name="GSores">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                               
                               
                 %>
                    
<!--                    <td>vi) Discoloration of urine?</td>-->
                    <td>
                        <select name="DiscolorUrine">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                           
                               
                 %>
                    
                    <td>
                        <select name="AbdominalPain">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    
<!--                    <td>a) Did you seek treatment</td>-->
                    <td>
                        <select name="STISeekTreat" id="STISeekTreat" onChange="disableOptions52(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                               
                               
                 %>
                    
                    <td>
                        <select name="STIPlaceTreated" id="STIPlaceTreated">
                            
                               <option value=""></option>
                            <% 
                            String Query8= "SELECT STITreatment_Code,STITreatment_CodeID FROM stitreatment_code";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query8);
                                                       while(conn.rs.next()){
                                                          
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("STITreatment_CodeID")%>'><%=conn.rs.getString("STITreatment_Code")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("STITreatment_CodeID"));
                                 System.out.println(conn.rs.getString("STITreatment_Code"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="Never had any of this signs">Never had any of this signs</option>
                            <option value="Medication from friend/self">Medication from friend/self</option>
                            <option value="Drop in Centre's">Drop in Centre's</option>
                            <option value="Government Hospital">Government Hospital</option>
                            <option value="Herbalist">Herbalist</option>
                            <option value="Did not seek treatment">Did not seek treatment</option>-->
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td><select name="LubricantUse" id="LubricantUse" onChange="disableOptions27(this.selectedIndex);">
                            <option value=""></option>
                          
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
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
            <td><input type="text" name="QIDOb"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnOb" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                             
                               
                 %>
            
            
            
              <%     String QstnQueryLubs= "SELECT QuestionsID,Question FROM questions where ID=89";
                conn.rs = conn.state.executeQuery(QstnQueryLubs);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDOOther"   value="<%= conn.rs.getString("QuestionsID")%>" class="convert1">
            <%}
                %>
            <%
                   
               String QstnQueryKy= "SELECT QuestionsID,Question FROM questions where ID=87";
 
				conn.rs = conn.state.executeQuery(QstnQueryKy);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



            <input type="hidden" name="QIDOKyJelly"   value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
            
            <%
                       }%>
                       <%
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
            
                     <td>KYJelly</td><td><input type="checkbox" name="KYJelly" value="KYJelly" id="KYJelly" class="Lubs"></td></tr>
                <tr class="d1"><td></td><td>Saliva</td><td><input type="checkbox" name="Saliva" value="Saliva" id="Saliva" class="Lubs"></td></tr>
                <tr class="d0"><td></td><td>Other,Specify</td><td><input type="checkbox" id="OtherLubricants1" class="Lubs"></td></tr>
                <tr  class="d1"><td></td><td><input type="text" name="OtherLubricants" id="OtherLubricants" value="" ></td>
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
                                                   
                            
<!--                    <td>If yes, When do you use lubricants? <font style="color: red"></font></td>-->
                <tr class="d1"><td>Anal Sex<input type="checkbox" name="LubUseAnal" id="LubUseAnal" value="LubUseAnal" class="LubsUse"></td>
               <td>Vaginal Sex<input type="checkbox" name="LubUseVaginal" id="LubUseVaginal" value="LubUseVaginal" class="LubsUse"></td>
                 </tr>
               
        </table>
            </div>
            
<table>
      <tr id="dialog4" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[9]!=null){%>
         <%=Sectionshelp[9]%> 
         <%}%>
    </td>
    </tr>
    
    
    
</table>                           
  <div id="step-3" style="height: 700px;  width:1206px;">
            <h2 class="StepTitle" >Step 3: Family Planning & Douching <a href="#" id="dialog-link4" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
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
                                                       
                               System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                               
                               
                 %>



                    <td>
                        <select name="pregnant">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td>
                        <select name="HaveKids">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                            
                            
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td>
                        <select name="UseFP" id="UseFP" onChange="disableOptions10(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                        
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td>
                        <select name="FPMethodUsed" id="FPMethodUsed">
                            <option value=""></option>
                            
                             <% 
                            String Query9= "SELECT FPMethods_Code,FPMethods_CodeID FROM fpmethods_code";
                                                     conn.state= conn.connect.createStatement();
				     conn.rs = conn.state.executeQuery(Query9);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("FPMethods_CodeID")%>'><%=conn.rs.getString("FPMethods_Code")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("FPMethods_CodeID"));
                                 System.out.println(conn.rs.getString("FPMethods_Code"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="Pills">Pills</option>
                            <option value="Injectable">Injectable</option>
                            <option value="Condoms">Condoms</option>
                            <option value="Tubal Ligation">Tubal Ligation</option>
                            <option value="IUD">IUD</option>
                            <option value="Rythm">Rythm</option>
                            <option value="Traditional">Traditional</option>-->
                            
                            
                        </select>
                        
                    </td>
                  
                  </tr>
                 
                    
                </table>
   </div>
                          
            <table>
      <tr id="dialog5" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[10]!=null){%>
         <%=Sectionshelp[10]%> 
         <%}%>
    </td>
    </tr>
    
    
    
</table>                                         
                          
  			<div id="step-4" style="height: 700px;  width:1206px;">
            <h2 class="StepTitle">Step 4: Substance Abuse <a href="#" id="dialog-link5" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
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
            <td><input type="text" name="QIDQa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" name="qstnQa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>

                    <td><select name="AlcoholUse" id="AlcoholUse" onChange="disableOptions20(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                           </select>
                    </td>
                </tr>
                <tr class="d0">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                             
                               
                 %>


                    <td><select name="AlcoholFrequency" id="AlcoholFrequency" onChange="popaudit(this.selectedIndex);">
                            <option value=""></option>   
                            <% 
                            String Query10= "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes";
                                                     conn.state= conn.connect.createStatement();
				 conn.rs  = conn.state.executeQuery(Query10);
                                                       while(conn.rs.next()){
                                                           
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("Alcohol_CodesID")%>'><%=conn.rs.getString("Alcohol_Codes")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("Alcohol_CodesID"));
                                 System.out.println(conn.rs.getString("Alcohol_Codes"));                                                     
                                                                }
                               
                                                   %>
<!--                            <option value="5 or more times/week">5 or more times/week</option>
                            <option value="2 to 4 times/week">2 to 4 times/week</option>
                            <option value="Once a week or less">Once a week or less</option>
                            <option value="Monthly or less">Monthly or less</option>-->
                         </select>
                    </td>
                </tr>
                
                <tr class="d1">
<!--                    <td>Have you used any other drug in the last 3 months?</td>-->

<%
                    String QstnQuery40= "SELECT QuestionsID,Question FROM questions where ID=40";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QstnQuery40);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <td><input type="text" name="QIDRa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert1" readonly>
                <input type="text" style="width:400px;" name="qstnRa" value="<%=conn.rs.getString("Question")%>" class="convert1" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                               
                               
                 %>
                    <td><select name="DrugUse" id="DrugUse" onChange="disableOptions21(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                         </select>
                    </td>
                </tr>
                <tr class="d0">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                             
                               
                 %>
                    <td>
                        <select multiple name="DrugType" id="DrugType">
                            <option value="MIRAA">MIRAA</option>
                            <option value="CIGARETTES">CIGARETTES</option>
                            <option value="BHANG">BHANG</option>
                            <option value="ALCOHOL">ALCOHOL</option>
                            <option value="COSMOS">COSMOS</option>
                            <option value="MUGUKA">MUGUKA</option>
                            <option value="ANTIBIOTICS">ANTIBIOTICS</option>
                            <option value="MARIJUANA">MARIJUANA</option>
                            <option value="KUBER">KUBER</option>
                            
                        </select>
<!--                        <input type="text"  name="DrugType" id="DrugType" value="">-->
                    </td>
                </tr>
                <tr class="d1">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                            
                               
                 %>

                    <td><select name="DrugFrequency" id="DrugFrequency">
                            <option value=""></option>
                             <% 
                            String Query11= "SELECT Alcohol_Codes,Alcohol_CodesID FROM alcohol_codes";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query11);
                                                       while(conn.rs.next())
                                                           {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("Alcohol_CodesID")%>'><%=conn.rs.getString("Alcohol_Codes")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("Alcohol_CodesID"));
                                 System.out.println(conn.rs.getString("Alcohol_Codes"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="5 or more times/week">5 or more times/week</option>
                            <option value="2 to 4 times/week">2 to 4 times/week</option>
                            <option value="Once a week or less">Once a week or less</option>
                            <option value="Monthly or less">Monthly or less</option>-->
                         </select>
                    </td>
                </tr>
            <tr class="d0"><th>Douching</th></tr>
                    <tr class="d1">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                     <td><select name="VaginalDouche" id="VaginalDouche"  onChange="disableOptions22(this.selectedIndex);">
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                         </select>
                    </td>
                    <td></td>
                    </tr>
                    <tr class="d0">
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                        <td></td><td></td></tr>
                    
                      <%     String AfterSex= "SELECT QuestionsID,Question FROM questions where ID=90";
                conn.rs = conn.state.executeQuery(AfterSex);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



           
            <input type="hidden" name="QIDSbA"   value="<%= conn.rs.getString("QuestionsID")%>">
            <%}
                %>
            <%
                   
               String Bathe= "SELECT QuestionsID,Question FROM questions where ID=91";
 
				conn.rs = conn.state.executeQuery(Bathe);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                     



            <input type="hidden" name="QIDSbB"   value="<%=conn.rs.getString("QuestionsID")%>">
            
            <%
                       }%>
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
            
                    
                    
                    
                    <tr class="d1"><td>After Sex</td><td><input type="checkbox" name="AfterSexDouche" class="douche" id="AfterSexDouche"  value="AfterSexDouche"></td><td></td></tr>
                    <tr class="d0"><td>When Bathing</td><td><input type="checkbox"  name="BathDouche" class="douche" id="BathDouche" value="BathDouche"></td><td></td></tr>
                    <tr class="d1"><td>Condom Burst</td><td><input type="checkbox"  name="CdBurstDouche" class="douche" id="CdBurstDouche" value="CdBurstDouche"></td><td></td></tr>
                    <tr class="d0"><td>Other</td><td><input type="checkbox"  name="OtherDouche1" class="douche"  id="OtherDouche1" value="OtherDouche1"></td>
                        <td><input type="text" name="OtherDouche" id="OtherDouche" placeholder="Please specify"></td>
                        
                    </tr>
                    
                   
                    
                    </table>
                        </div>
         <table>
      <tr id="dialog6" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[11]!=null){%>
         <%=Sectionshelp[11]%> 
         <%}%>
    </td>
    </tr>
    
    
    
</table>    
  			<div id="step-5" style="height: 700px;  width:1240px;">
            <h2 class="StepTitle">Step 5: Sexual and Gender Based Violence<a href="#" id="dialog-link6" style="padding-right: 0px;">
                                     <img src="images/help_24.png"/> </a></h2>	
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
            <td><input type="text" name="QIDTa"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnTa" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>





                    <td><select name="VerbalInsults" id="VerbalInsults" onChange="disableOptions23(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
                            System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                             
                               
                 %>




                        <select name="LastVerbalInsult" id="LastVerbalInsult">
                                <option value=""></option>
                             <% 
                            String Query12= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query12);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("AbuseCodeID")%>'><%=conn.rs.getString("AbuseCode")%></option>
                                                   <%
                                                       
                                System.out.println(conn.rs.getInt("AbuseCodeID"));
                                 System.out.println(conn.rs.getString("AbuseCode"));                                                      }
                                
                               
                                                   %>
<!--                                <option value="Within Last 24 hrs">Within Last 24 hrs</option> 
                                <option value="Within Last 7 days">Within Last 7 days</option> 
                                <option value="Within Last 30 days">Within Last 30 days</option> 
                                <option value="More than 30 days ago">More than 30 days ago</option> -->
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td><select name="Hit" id="Hit" onChange="disableOptions24(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                            
                            
                            
                            
                       
                       <select name="LastVerbalInsultHit" id="LastVerbalInsultHit">
                           
                                <option value=""></option>
                             <% 
                            String Query13= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query13);
                                                      while(conn.rs.next()){
                                                 
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("AbuseCodeID")%>'><%=conn.rs.getString("AbuseCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("AbuseCodeID"));
                                 System.out.println(conn.rs.getString("AbuseCode"));                                                     
                                                                }
                                                                                             
                                                   %>
<!--                                <option value="Within Last 24 hrs">Within Last 24 hrs</option> 
                                <option value="Within Last 7 days">Within Last 7 days</option> 
                                <option value="Within Last 30 days">Within Last 30 days</option> 
                                <option value="More than 30 days ago">More than 30 days ago</option> -->
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
            <td><input type="text" name="QIDTc"  hidden value="<%=conn.rs.getString("QuestionsID")%>" class="convert2" readonly>
                <input type="text" name="qstnTc" value="<%=conn.rs.getString("Question")%>" class="convert2" readonly></td>
                                                   <%
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td><select name="ForcedSex" id="ForcedSex" onChange="disableOptions25(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                            
                            
                            
                            
                       
                        <select name="LastVerbalInsultForced"  id="LastVerbalInsultForced">
                                <option value=""></option>
                             <% 
                            String Query14= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                    conn.state= conn.connect.createStatement();
                                    conn.rs = conn.state.executeQuery(Query14);
                                                        while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("AbuseCodeID")%>'><%=conn.rs.getString("AbuseCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("AbuseCodeID"));
                                 System.out.println(conn.rs.getString("AbuseCode"));                                                      }
                                
                               
                                                   %>
<!--                                <option value="Within Last 24 hrs">Within Last 24 hrs</option> 
                                <option value="Within Last 7 days">Within Last 7 days</option> 
                                <option value="Within Last 30 days">Within Last 30 days</option> 
                                <option value="More than 30 days ago">More than 30 days ago</option> -->
                            </select></td>
                    </tr>
                    <tr class="d0">
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                    <td><select name="VerbalAbuse" id="VerbalAbuse" onChange="disableOptions28(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>
                            
             
                        
                        <select name="VerbalAbuseTime" id="VerbalAbuseTime">
                                <option value=""></option>
                             <% 
                            String Query15= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query15);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("AbuseCodeID")%>'><%=conn.rs.getString("AbuseCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("AbuseCodeID"));
                                 System.out.println(conn.rs.getString("AbuseCode"));                                                      }
                                
                               
                                                   %>
<!--                                <option value="Within Last 24 hrs">Within Last 24 hrs</option> 
                                <option value="Within Last 7 days">Within Last 7 days</option> 
                                <option value="Within Last 30 days">Within Last 30 days</option> 
                                <option value="More than 30 days ago">More than 30 days ago</option> -->
                            </select></td>
                    </tr>
                    <tr class="d0">
                        
                        <td><input type="text" name="QIDTe"  hidden value="T9" class="convert2" readonly>
                        e)Do any partner related problems affect your use of condoms,FP</br> or seeking health services through disclosure and adherence to treatment  </td>
<!--                <input type="text" name="qstnTe" value="e)Do any partner related problems affect your use of condoms,FP</br> or seeking health services through disclosure and adherence to treatment " class="convert2" readonly></td>-->
  
                    <td><select name="PartnerProblem" id="PartnerProblem" onChange="disableOptions29(this.selectedIndex);">
                            <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                               
                               
                 %>
                       
                        <select name="PartnerProblemTime" id="PartnerProblemTime">
                                <option value=""></option>
                             <% 
                            String Query16= "SELECT AbuseCode,AbuseCodeID FROM abusecode";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query16);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("AbuseCodeID")%>'><%=conn.rs.getString("AbuseCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("AbuseCodeID"));
                                 System.out.println(conn.rs.getString("AbuseCode"));                        
                                                              }
                                                               
                               
                                                   %>
<!--                                <option value="Within Last 24 hrs">Within Last 24 hrs</option> 
                                <option value="Within Last 7 days">Within Last 7 days</option> 
                                <option value="Within Last 30 days">Within Last 30 days</option> 
                                <option value="More than 30 days ago">More than 30 days ago</option> -->
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                               
                               
                 %>




            <td><select name="SeekTreatment" id="SeekTreatment" onChange="disableOptions26(this.selectedIndex);" required>
                    <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>

                     <td><select name="PlaceTreated" id="PlaceTreated" required>
                             <option value=""></option>
                             <% 
                            String Query17= "SELECT PlaceTreated_Code,PlaceTreated_CodeID FROM placetreated_code";
                                                      conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query17);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("PlaceTreated_CodeID")%>'><%=conn.rs.getString("PlaceTreated_Code")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("PlaceTreated_CodeID"));
                                 System.out.println(conn.rs.getString("PlaceTreated_Code"));               
                                                                       }
                                
                               
                                                   %>
<!--                            <option value="Self Treatment">Self Treatment</option>
                            <option value="Govt Hospital">Govt Hospital</option>
                            <option value="Private Hospital">Private Hospital</option>
                            <option value="Did not seek treatment">Did not seek treatment</option>
                            <option value="Other">Other</option>-->
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
                                                       
 System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                             
                               
                 %>




                     <td><select name="ReportPolice" id="ReportPolice" onChange="disableOptions9(this.selectedIndex);">
                             <option value=""></option>
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
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
                                                       
                                System.out.println(conn.rs.getString("QuestionsID"));
                                System.out.println(conn.rs.getString("Question"));                                                      }
                                                              
                               
                 %>





                        <td><select name="ReportWhere" id="ReportWhere">
                                <option value=""></option>
                             <% 
                            String Query18= "SELECT ReportCode,ReportCodeID FROM reportCode";
                                                    conn.state= conn.connect.createStatement();
				 conn.rs = conn.state.executeQuery(Query18);
                                                       while(conn.rs.next())
                                                            {
                                                   %>                                                                       
             <option value='<%=conn.rs.getInt("ReportCodeID")%>'><%=conn.rs.getString("ReportCode")%></option>
                                                   <%
                                                       
  System.out.println(conn.rs.getInt("ReportCodeID"));
                                 System.out.println(conn.rs.getString("ReportCode"));                                                      }
                                
                               
                                                   %>
<!--                            <option value="Police">Police</option>
                            <option value="Chief">Chief</option>
                            <option value="Village Elder">Village Elder</option>-->
                         </select>
                    </td>
                    </tr>
                   
                    
    
    
                </table>
            
                  </form>
     </div>
      </div>
</div>
         
<script>
    
    $(document).ready(function(){
        $(form).submit(function(){
         
        
      if( document.getElementById("SexLast").value!=="" ){
          
//         alert("aaa") ;
      }
        
            
        });
        
        
        
    });
    
</script>          
    
       
            
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