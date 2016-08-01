<%-- 
    Document   : medical_form
    Created on : Oct 10, 2013, 8:42:56 AM
    Author     : Geofrey yabuto
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%if(session.getAttribute("accessTrail")!=null){ %>
<%@page import="Maintenance.saveAccessTrail"%>
<%
saveAccessTrail access = new saveAccessTrail();
String task="Accessed added a new medical form . ";
String username=session.getAttribute("accessTrail").toString();
access.addAccess(username,task);

%>
<%}%>

<html>

<head>
    <link rel="shortcut icon" href="../images/favicon.png">
        <link rel="StyleSheet" href="css/main.css" type="text/css" />
        <link rel="StyleSheet" href="css/geff_css.css" type="text/css" />
        
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <title>Medical Form</title>
   
<!--   <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>-->

    <link rel="stylesheet" type="text/css" href="../js/jquery-ui.css"/>
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.js"></script>
    <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="../js/DICHelp.js"></script> 
   
   
   
	<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
	<link rel="stylesheet" href="themes/eggplant/jquery.ui.all.css">
	
	<link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<!-- <script src="../js/jquery-1.7.2.js"></script>
 <script src="../js/jquery-ui-1.10.3.custom.js"></script>-->

        <script src="../js/datepicker.js"></script>
        <script src="../admin/ui/jquery.ui.datepicker.js"></script>
	
	 <script>	
                $(function() {
                        $( "#datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true
                        });
                });
               
            </script>
	 <script>	
                $(function() {
                        $( "#datepicker1" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true
                        });
                });
               function filter_wards(DICName){
 
     
   var dist = document.getElementById("DICName").value;
   var distr = new Array();
// this will return an array with strings "1", "2", etc.
distr = dist.split(",");
var dicname=distr[0];
//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (dicname=="")
{
//filter the districts    



document.getElementById("ward").innerHTML="<option value=\"\">Choose Ward</option>";
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
document.getElementById("ward").innerHTML=xmlhttp.responseText;
}
}
xmlhttp.open("POST","/DIC/wardselector?dicname="+dicname,true);

xmlhttp.send();


}//end of filter districts

            </script>
	
	
	
    <script type="text/javascript">
      function validate_next() {
          
//                document.getElementById("ButtonNext").name='Step2';
          
          
      }
       
       
       
    </script>
       <script type="text/javascript">
// a function that filters the districts in the passed county as per the county drop down.

function filter_districts(District){

     
   var dist = document.getElementById("district").value;
   
   var distr = new Array();
// this will return an array with strings "1", "2", etc.
distr = dist;
var districtsName=distr;
// alert(districtsName);
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
    <script type="text/javascript">

    

        // This function handles style and display changes for each next button click

        function handleWizardNext()

        {

            if (document.getElementById('ButtonNext').name == 'Step1')

            {

                // Change the button name - we use this to keep track of which step to display on a click

                document.getElementById('ButtonNext').name = 'Step2';

                document.getElementById('ButtonPrevious').disabled = true;

                // Disable/enable buttons when reach reach start and review steps

//                document.getElementById('ButtonPrevious').disabled = '';

                // Set new step to display and turn off display of current step

                document.getElementById('Step1').style.display = '';

                document.getElementById('Step2').style.display = 'none';

                // Change background color on header to highlight new step

                document.getElementById('HeaderTableStep2').style.backgroundColor = 'silver';

                document.getElementById('HeaderTableStep1').style.backgroundColor = 'Yellow';
document.getElementById('SubmitFinal').disabled = true;
            }


            else if(document.getElementById('ButtonNext').name == 'Step2')

            {
var temperature,blood_pressure,p,weight,unique_identifier,client_name,ward;
temperature=document.getElementById("temperature").value;
ward=document.getElementById("ward").value;
blood_pressure=document.getElementById("blood_pressure").value;
p=document.getElementById("p").value;
weight=document.getElementById("weight").value;
 if(temperature==""){
     alert("Enter temperature value");
     document.getElementById("temperature").focus();
     return false;
 }
  if(ward==""){
     alert("Select Ward");
     document.getElementById("ward").focus();
     return false;
 }
 if(blood_pressure==""){
     alert("Enter blood pressure value");
     document.getElementById("blood_pressure").focus();
     return false;
 }
  if(p==""){
     alert("Enter p value");
     document.getElementById("p").focus();
     return false;
 }
  if(weight==""){
     alert("Enter weight value");
     document.getElementById("weight").focus();
     return false;
 }






                // Change the button name - we use this to keep track of which step to display on a click

              

                document.getElementById('ButtonNext').name = 'Step3';
                document.getElementById('ButtonPrevious').name = 'Step1';

                document.getElementById('SubmitFinal').disabled =true;
                document.getElementById('ButtonPrevious').disabled = false;
                // Set new step to display and turn off display of current step

                document.getElementById('Step1').style.display = 'none';

                document.getElementById('Step2').style.display = '';
                document.getElementById('Step3').style.display = 'none';
                // Change background color on header to highlight new step
                document.getElementById('HeaderTableStep3').style.backgroundColor = 'Silver';
                document.getElementById('HeaderTableStep2').style.backgroundColor = 'Yellow';
document.getElementById('SubmitFinal').disabled = true;
                document.getElementById('HeaderTableStep1').style.backgroundColor = 'Green';


            }
            
            else if(document.getElementById('ButtonNext').name == 'Step3')

            {
var ga,skin,eyes,ent,abdomen,genitourinary,musculoskeletal,respiratory,psychological;
    ga=document.getElementById("ga").value;
    skin=document.getElementById("skin").value;
    eyes=document.getElementById("eyes").value;
    ent=document.getElementById("ent").value;
    abdomen=document.getElementById("abdomen").value;
    genitourinary=document.getElementById("genitourinary").value;
    musculoskeletal=document.getElementById("musculoskeletal").value;
    respiratory=document.getElementById("respiratory").value;
    psychological=document.getElementById("psychological").value;
if(ga==""){
    alert("select an item in General Apperance  please");
    document.getElementById('ga').focus(ga);
    return false;    
}
if(skin==""){
    alert("select an item in skin please");
    document.getElementById('skin').focus();
    return false;    
}
if(eyes==""){
    alert("select an item in eyes please");
    document.getElementById('eyes').focus();
    return false;    
}
if(ent==""){
    alert("select an item in ent please");
    document.getElementById('ent').focus();
    return false;    
}
if(abdomen==""){
    alert("select an item in abdomen please");
    document.getElementById('abdomen').focus();
    return false;    
}
if(genitourinary==""){
    alert("select an item in genitourinary please");
    document.getElementById('genitourinary').focus();
    return false;    
}
if(musculoskeletal==""){
    alert("select an item in musculoskeletal please");
    document.getElementById('musculoskeletal').focus();
    return false;    
}
if(respiratory==""){
    alert("select an item in respiratory please");
    document.getElementById('respiratory').focus();
    return false;    
}
if(psychological==""){
    alert("select an item in psychological please");
    document.getElementById('psychological').focus();
    return false;    
}

               document.getElementById('ButtonNext').disabled = true;
               document.getElementById('SubmitFinal').disabled = false;
                document.getElementById('ButtonPrevious').name = 'Step2';

                document.getElementById('ButtonPrevious').disabled = false;
                // Set new step to display and turn off display of current step

                document.getElementById('Step1').style.display = 'none';

                document.getElementById('Step2').style.display = 'none';
                document.getElementById('Step3').style.display = '';
                // Change background color on header to highlight new step

                document.getElementById('HeaderTableStep3').style.backgroundColor = 'Yellow';
                document.getElementById('HeaderTableStep2').style.backgroundColor = 'green';
                document.getElementById('HeaderTableStep1').style.backgroundColor = 'green';

            }


        }

        

        // This function handles style and display changes for each previous button click

        function handleWizardPrevious()

        {

            if (document.getElementById('ButtonPrevious').name == 'Step1')

            {

                // Change the button name - we use this to keep track of which step to display on a click

                document.getElementById('ButtonNext').name = 'Step2';

                document.getElementById('ButtonPrevious').name = '';
 document.getElementById('SubmitFinal').disabled = true;
                // Disable/enable buttons when reach reach start and review steps

                document.getElementById('ButtonPrevious').disabled =false;

                // Set new step to display and turn off display of current step

                document.getElementById('Step2').style.display = 'none';

                document.getElementById('Step1').style.display = '';

                // Change background color on header to highlight new step

                document.getElementById('HeaderTableStep1').style.backgroundColor = 'Yellow';

                document.getElementById('HeaderTableStep2').style.backgroundColor = 'Silver';

            }

            else if (document.getElementById('ButtonPrevious').name == 'Step2')

            {

                // Change the button name - we use this to keep track of which step to display on a click
                document.getElementById('ButtonNext').disabled = false;
                document.getElementById('ButtonNext').name = 'Step3';
document.getElementById('SubmitFinal').disabled = true;
                document.getElementById('ButtonPrevious').name = 'Step1';

                // Set new step to display and turn off display of current step

                document.getElementById('Step3').style.display = 'none';

                document.getElementById('Step2').style.display = '';

                // Change background color on header to highlight new step

                document.getElementById('HeaderTableStep2').style.backgroundColor = 'Yellow';

                document.getElementById('HeaderTableStep3').style.backgroundColor = 'Silver';

            }

        }
    </script>
    <script type="text/javascript">
     function disable_options()  {
        
         
     } 
    function   auto_hide() {
        
   var referral=document.getElementById("referral").value;   
         if(referral=="Others"){ 
          document.getElementById("specify_others").hidden=false; 
          document.getElementById("specify_others").required=true; 
         }
         
              else    if(referral!="Others"){
          document.getElementById("specify_others").hidden=true; 
          document.getElementById("specify_others").required=false;
          document.getElementById("specify_others").value="";
         }
         
        
        
    } 
        
        
        
        
        
        
        
    </script>
    <script type="text/javascript">
     function de_activator(){
//    alert("function called");
    var ga,skin,eyes,ent,abdomen,genitourinary,musculoskeletal,respiratory,psychological;
    ga=document.getElementById("ga").value;
    skin=document.getElementById("skin").value;
    eyes=document.getElementById("eyes").value;
    ent=document.getElementById("ent").value;
    abdomen=document.getElementById("abdomen").value;
    genitourinary=document.getElementById("genitourinary").value;
    musculoskeletal=document.getElementById("musculoskeletal").value;
    respiratory=document.getElementById("respiratory").value;
    psychological=document.getElementById("psychological").value;
    
    if(ga=="Not Done"){
       
     document.getElementById("ga_findings").disabled=true;
     document.getElementById("ga_findings").value="";
      document.getElementById("ga_findings").required=false;
    }
   if(ga!="Not Done") {
     document.getElementById("ga_findings").disabled=false;
     document.getElementById("ga_findings").required=true;
    }
    
        if(skin=="Not Done"){
       
     document.getElementById("skin_findings").disabled=true;
     document.getElementById("skin_findings").value="";
        document.getElementById("skin_findings").required=false;
    }
   if(skin!="Not Done") {
     document.getElementById("skin_findings").disabled=false; 
      document.getElementById("skin_findings").required=true;
    }
    
        if(eyes=="Not Done"){
       
     document.getElementById("eyes_findings").disabled=true;
     document.getElementById("eyes_findings").value="";
     document.getElementById("eyes_findings").required=false;
    }
   if(eyes!="Not Done") {
     document.getElementById("eyes_findings").disabled=false; 
      document.getElementById("eyes_findings").required=true;
    }
    
        if(ent=="Not Done"){
       
     document.getElementById("ent_findings").disabled=true;
     document.getElementById("ent_findings").value="";
     document.getElementById("ent_findings").required=false;
    }
   if(ent!="Not Done") {
     document.getElementById("ent_findings").disabled=false; 
      document.getElementById("ent_findings").required=true; 
    }
    
        if(abdomen=="Not Done"){
       
     document.getElementById("abdomen_findings").disabled=true;
     document.getElementById("abdomen_findings").value="";
      document.getElementById("abdomen_findings").required=false; 
    }
   if(abdomen!="Not Done") {
     document.getElementById("abdomen_findings").disabled=false;  
      document.getElementById("abdomen_findings").required=true; 
    }
    
        if(genitourinary=="Not Done"){
       
     document.getElementById("genitourinary_findings").disabled=true;
     document.getElementById("genitourinary_findings").value="";
      document.getElementById("genitourinary_findings").required=false;
    }
   if(genitourinary!="Not Done") {
     document.getElementById("genitourinary_findings").disabled=false;
     document.getElementById("genitourinary_findings").required=true;
    }
    
        if(musculoskeletal=="Not Done"){
       
     document.getElementById("musculoskeletal_findings").disabled=true;
     document.getElementById("musculoskeletal_findings").value="";
     document.getElementById("musculoskeletal_findings").required=false;
    }
   if(musculoskeletal!="Not Done") {
     document.getElementById("musculoskeletal_findings").disabled=false; 
     document.getElementById("musculoskeletal_findings").required=true;
    }
    
        if(respiratory=="Not Done"){
       
     document.getElementById("respiratory_findings").disabled=true;
     document.getElementById("respiratory_findings").value="";
     document.getElementById("respiratory_findings").required=false;
    }
   if(respiratory!="Not Done") {
     document.getElementById("respiratory_findings").disabled=false; 
      document.getElementById("respiratory_findings").required=true;
    }
    
            if(psychological=="Not Done"){
       
     document.getElementById("psychological_findings").disabled=true;
     document.getElementById("psychological_findings").value="";
    }
   if(psychological!="Not Done") {
     document.getElementById("psychological_findings").disabled=false;   
    }
    
     }
     
     
    </script>
    <script type="text/javascript">
        function null_validator(){
  var diagnosis,management;          
            
        }
    </script>
</head>

<body style="margin-top: 0px;padding-top:0px;">
   
    <div id="container" style="width: 1300px; height: 900px; margin-top: 0px;">
      
    <% 
 dbConnect conn = new dbConnect();
 //get the helps from the database.
 
 String Sectionshelp[]=new String [25];
int mcount=0;
   if(conn.state2.isClosed()){conn= new dbConnect();}
conn.rs2=conn.state2.executeQuery("Select * from help where help_id<='25'");
while(conn.rs2.next()){
    
Sectionshelp[mcount]=conn.rs2.getString(2);
if(mcount<=25){
mcount++;
}
}

%>
   
   
   
         <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    String username=(String)session.getAttribute("Username");
      
               if(session.getAttribute("Username")==null){
//                    response.sendRedirect("../index.jsp"); 
               }           
     
        else{
     %>
    <a class="button-1" href="/DIC/logoutServlet">LogOut</a>         
     <h5>Welcome <%=username%></h5>
     <%
               }
        
 
      %>
   
   
    <div> 
          <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200" /></h1></div>

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
    
           <div style="width: 900px; margin-left: 200px;">
    <table>              
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[21]!=null){%>
         <%=Sectionshelp[21]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
        
        <h3> Medical Form <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="images/help_24.png"/> </a></h3>
   
                              <form id="SubscriptionWizard" action="../add_medical_form" method="post" onsubmit="return null_validator();">
 <table border="1" cellpadding="5" cellspacing="0" id="viewpdt" style="width: 500px;">

        <tr>

            <td id="HeaderTableStep1" style="background-color:Yellow; height: 60px;">

               <h2> Step 1: Basic Information.</h2></td>

            <td id="HeaderTableStep2" style="background-color:Silver; height: 60px;">

               <h2> Step 2: System Exam.</h2></td>
            
            <td id="HeaderTableStep3" style="background-color:Silver; height: 60px;">

               <h2> Step 3: Management.</h2> </td>

        </tr>

    </table>

    <br />
 <%
String UniqueID="";
String name="";
if(request.getParameter("name")!=null && !request.getParameter("name").equals(""))  {  
name=request.getParameter("name");
       }
if(request.getParameter("UniqueID")!=null && !request.getParameter("UniqueID").equals(""))  {  
UniqueID=request.getParameter("UniqueID");
       }

 
%>
<span id="Step1">
    <table  style="position: relative; width: 700px;">
        <tr>
            <td></td> 
            <td>Client Name :</td> <td>     
              <% if(session.getAttribute("UniqueID")!=null){%>
                <input type="text" name="client_name" id="client_name" value="<%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> <%=name%><%}}%>" style="width: 200px" required="true" disabled="true" class="textbox">
           
                <%} else if(!name.equals("") && name!=null){%>
                
                <input type="text" name="client_name" id="client_name" value="<%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> <%=name%><%}}%>" style="width: 200px" required="true" disabled="true" class="textbox">
           
            <%}%>
            </td>  </tr>
        <tr></tr>
         <tr></tr>
        
         
          <tr>
              <td></td> 
              <td>Unique Identifier </td>  
              <% if(session.getAttribute("UniqueID")!=null){%>
              <td><input type="text" name="unique_identifier" id="unique_identifier" value="<%= session.getAttribute("UniqueID") %>" style="width: 200px" required="true" readonly class="textbox" > </td>     
          
              <%} else if(!UniqueID.equals("") && UniqueID!=null){%>
              <td><input type="text" name="unique_identifier" id="unique_identifier" value="<%= UniqueID %>" style="width: 200px" required="true" readonly class="textbox" > </td>     
          
              <%}%>
          </tr>
                <tr></tr>
         <tr></tr>
         <tr><td><h2>County</h2><font style="color: blue">*</font></td><td><h2>Dic</h2> <font style="color: blue">*</font></td><td><h2>Ward</h2> <font style="color: blue">*</font></td></tr>
            <tr ><td>
                        
<!--                        //gets the districts as stored in db and dispaly them in a drop down-->
                        <select onchange="filter_districts(this);" class="textbox2"   required name="district" id="district">
                              
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
                                 
                                 <td>
                                 <select id="DICName" onchange="filter_wards(this);"  class="textbox2"  required  name="DICName" >
                                 <option value="">Choose County first</option>  

                                 </select>
                                    </td>
                                    
                                   <td>
                                 <select id="ward" class="textbox2"  name="ward"  >
                                 <option value="">Choose Dic First</option>  

                                 </select>
                                    </td>
                </tr>
     
         <tr><td colspan="2">Vital Signs:</td> <td>Current Complains:</td></tr>
<!--                 <tr></tr>
                 <tr></tr>-->
                 <tr><td>Temperature: </td> 
                     <td><input type="text" name="temperature" id="temperature" value="" required="true" class="textbox"> </td>    
                     <td><textarea name="temperature_complain" value=""> </textarea></td>    
                 </tr>
                  <tr>
                      <td>Blood Pressure: </td> 
                     <td><input type="text" name="blood_pressure" id="blood_pressure" value="" required="true" class="textbox"> </td>    
                     <td><textarea name="blood_pressure_complain" value=""> </textarea> </td>    
                 </tr>
               <tr>
                   <td>P: </td> 
                     <td><input type="text" name="p" id="p" value="" required="true" class="textbox"> </td>    
                     <td><textarea name="p_complain" value=""> </textarea> </td>    
                 </tr>
               <tr>
                   <td>Weight: </td> 
                     <td><input type="text" name="weight" id="weight" value="" required="true" class="textbox"> </td>    
                     <td><textarea name="weight_complain" value=""> </textarea> </td>    
                 </tr>
  </table>   
    
</span>

<span id="Step2" style="display:none">
    <table style="position: relative; width: 700px; height: 400px">
        <tr><th colspan="5">System Exam.</th>  </tr>  
        <tr><td></td> <td>Choose Appropriately</td><td></td><td>Finding</td> </tr> 
        <tr><td>General Appearance</td> <td colspan="2"><select name="ga" id="ga" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                    
            </td><td><textarea name="ga_findings" placeholder="Findings" id="ga_findings" disabled="false" rows="1" required="true"></textarea></td> </tr> 
        <tr><td>Skin</td> <td colspan="2"><select name="skin" id="skin" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                     <option value="" selected="true">Choose Category</option>                  
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                
            </td><td><textarea name="skin_findings" placeholder="Findings" id="skin_findings" disabled="false" rows="1" required="true"></textarea></td> </tr> 
        <tr><td>Ent</td> <td colspan="2"><select name="ent" id="ent" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option> 
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="ent_findings" placeholder="Findings" id="ent_findings" rows="1" disabled="false" required="true"></textarea></td> </tr> 
        <tr><td>Eyes</td> <td colspan="2"><select name="eyes" id="eyes" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option> 
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="eyes_findings" placeholder="Findings" id="eyes_findings" rows="1" disabled="false" required="true"></textarea></td> </tr>  
        <tr><td>Abdomen</td> <td colspan="2"><select name="abdomen" id="abdomen" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="abdomen_findings" placeholder="Findings" id="abdomen_findings" rows="1" disabled="false" required="true"></textarea></td> </tr> 
        <tr><td>Genitourinary</td> <td colspan="2"><select name="genitourinary" id="genitourinary" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="genitourinary_findings" placeholder="Findings" id="genitourinary_findings" rows="1" disabled="false" required="true"></textarea></td> </tr> 
        <tr><td>Musculoskeletal</td><td colspan="2"><select name="musculoskeletal" id="musculoskeletal" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
               </td><td><textarea name="musculoskeletal_findings" placeholder="Findings" rows="1" id="musculoskeletal_findings" disabled="false" required="true"></textarea></td> </tr>  
        <tr><td>Respiratory</td><td colspan="2"><select name="respiratory" id="respiratory" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="respiratory_findings" placeholder="Findings" rows="1" id="respiratory_findings" disabled="false" required="true"></textarea></td> </tr> 
        <tr><td>Psychological</td> <td colspan="2"><select name="psychological" id="psychological" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="" selected="true">Choose Category</option> 
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="psychological_findings" placeholder="Findings" rows="1" id="psychological_findings" disabled="false" required="true"></textarea></td> </tr> 
        
    </table>  
</span>
<span id="Step3" style="display:none">
    <table>  
     <tr><td>Clinical Impression/Diagnosis</td><td><textarea name="diagnosis" placeholder="Clinical Impression/Diagnosis" ></textarea></td> <tr> 
 <tr><td>Management</td><td><textarea name="management" placeholder="Management"></textarea></td> <tr> 
 <tr><td>Referral</td><td><select name="referral" id="referral" onchange="return auto_hide()" style="width: 150px" class="textbox2">
             <option value="" selected="true">Select Referral</option>
             <option value="Lab">Lab</option>
             <option value="CCC">CCC</option>
             <option value="Others">Others</option>
         </select></td><td><input type="text" name="specify_others" id="specify_others" value="" placeholder="Specify here" hidden="true" class="textbox"></td> <tr> 
 <tr><td>TCA : </td><td><input type="text" name="TCA"  id="datepicker1" value="" placeholder="" class="textbox"></td> <tr> 
 <tr><td>Cadre of Provider :</td>
     <% if (session.getAttribute("cadre")!=null){%>
     <td> <input type="text" name="cadre" value="<%=session.getAttribute("cadre")%>" placeholder=""  class="textbox"></td>

     <%} else {%>
      <td> <input type="text" name="cadre" value="" placeholder="" class="textbox"></td>
<% } %>

 <tr> 
 <tr><td>Date : </td><td><input type="text" name="dater" value="" id="datepicker" placeholder="" class="textbox"></td> <tr> 
 <tr><td>Signature: </td><td><input type="text" name="signature" value="" placeholder="" class="textbox"></td> <tr> 
 </table>
</span>
<br />    

<table border="0" cellpadding="5" cellspacing="0">

    <tr>

        <td>

            <input id="ButtonPrevious" type="button" value="Previous" name="" onclick="handleWizardPrevious()" /></td>

        <td>

            <input id="ButtonNext" type="button" value="Next" name="Step2" onclick="handleWizardNext()" /></td>

        <td>

            <input id="SubmitFinal" type="submit" value="Finish" disabled /></td>

    </tr>

</table>

</form>
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