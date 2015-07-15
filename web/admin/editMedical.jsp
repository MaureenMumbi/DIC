<%-- 
    Document   : editMedical
    Created on : Jan 16, 2014, 1:18:24 PM
   @author Hare Cheka Arnold
--%>
<%@page import="dbConnect.AES"%>
<%@page import="dbConnect.AES"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
dbConnect conn = new dbConnect();
String y[]= null;
//initialising of the fields to be fetched
int medical_id =0;
String uniqueId="";
String temp="";
String temp_complain="";
String bp="";
String bp_complain="";
String p="";
String p_complain="";
String weight="";
String weight_complain="";
String ga="";
String ga_complains="";
String skin="";
String skin_findings="";
String ent="";
String ent_findings="";
String eyes="";
String eyes_findings="";
String abdomen="";
String abdomen_findings="";
String genito="";
String genito_findings="";
String musculo="";
String musculo_findings="";
String respiratory="";
String respiratory_findings="";
String pyscho="";
String pyscho_findings="";
String diagnosis="";
String mgmt="";
String referral="";
String specify="";
String TCA="";
int cadre=0;
String date="";
String signature="";


  

List userList=null;
%>
<%
//fetching the data stored in the arraylist called userlist 
if(request.getAttribute("userList")!=null && request.getAttribute("userList")!="")
{
		userList = (ArrayList)request.getAttribute("userList");
                medical_id = Integer.parseInt(userList.get(0).toString());
		uniqueId=userList.get(1).toString();
		temp=userList.get(2).toString();
		temp_complain=userList.get(3).toString();
                bp=userList.get(4).toString();
                bp_complain=userList.get(5).toString();
		p=userList.get(6).toString();
		p_complain=userList.get(7).toString();
		weight=userList.get(8).toString();
		weight_complain=userList.get(9).toString();
		ga=userList.get(10).toString();
		ga_complains=userList.get(11).toString();
                skin=userList.get(12).toString();
                skin_findings=userList.get(13).toString();
                ent=userList.get(14).toString();
                ent_findings=userList.get(15).toString();
                eyes=userList.get(16).toString();
                eyes_findings=userList.get(17).toString();
                abdomen=userList.get(18).toString();
                abdomen_findings=userList.get(19).toString();
                genito=userList.get(20).toString();
                genito_findings=userList.get(21).toString();
                musculo=userList.get(22).toString();
                musculo_findings=userList.get(23).toString();
                respiratory=userList.get(24).toString();
                respiratory_findings=userList.get(25).toString();
                pyscho=userList.get(26).toString();
                pyscho_findings=userList.get(27).toString();
                diagnosis=userList.get(28).toString();
                mgmt=userList.get(29).toString();
                referral=userList.get(30).toString();
                specify=userList.get(31).toString();
                TCA=userList.get(32).toString();
                cadre=Integer.parseInt(userList.get(33).toString());
                date=userList.get(34).toString();
                signature=userList.get(35).toString();
		System.out.println("j------"+userList);
		System.out.println("j-----"+uniqueId);
		
		

}
%>

<html>
   
<head>
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
               
            </script>
	
	
	
    <script type="text/javascript">
      function validate_next() {
          
//                document.getElementById("ButtonNext").name='Step2';
          
          
      }
       
       
       
    </script>
    <script type="text/javascript">

    

        // This function handles style and display changes for each next button click

        function handleWizardNext()

        {

            if (document.getElementById('ButtonNext').name == 'Step1')

            {

                // Change the button name - we use this to keep track of which step to display on a click

                document.getElementById('ButtonNext').name = 'Step2';

                document.getElementById('ButtonPrevious').disadled = true;

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
var temperature,blood_pressure,p,weight,unique_identifier,client_name;
temperature=document.getElementById("temperature").value;
blood_pressure=document.getElementById("blood_pressure").value;
p=document.getElementById("p").value;
weight=document.getElementById("weight").value;
 if(temperature==""){
     alert("Enter temperature value");
     document.getElementById("temperature").focus();
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
   
    <div id="container" style="width: 1200px; height: 900px; margin-top: 0px;">
      
    <% 

 //get the helps from the database.
 
 String Sectionshelp[]=new String [25];
int mcount=0;
   if (conn.state2.isClosed()) {
           conn = new dbConnect();
       }
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
   
                              <form id="SubscriptionWizard" action="Update_MedicalForm1" method="post" onsubmit="return null_validator();">
 <table border="1" cellpadding="5" cellspacing="0" id="viewpdt" style="width: 500px;">

        <tr>

            <td id="HeaderTableStep1" style="background-color:Yellow; height: 60px;">

                Step 1: Basic Information.</td>

            <td id="HeaderTableStep2" style="background-color:Silver; height: 60px;">

                Step 2: System Exam.</td>
            
            <td id="HeaderTableStep3" style="background-color:Silver; height: 60px;">

                Step 3: Management. </td>

        </tr>

    </table>

    <br />

<span id="Step1">
    <table  style="position: relative; width: 700px;">
        <%!
 
    public String generateRandom(){
       
        String random = "select * from enrollment where UniqueID ='"+uniqueId+"'";
       System.out.println(random);
       String client_name="";
       String client_name1="";
       String full_name = "";
      String FirstName="";
      String MiddleName="";
      String LastName="";
       try {
              if(conn.state.isClosed()){conn= new dbConnect();}
       conn.rs=conn.state.executeQuery(random);
       
       if(conn.rs.next()){
	    final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString("FirstName")!=null && !conn.rs.getString("FirstName").trim().equals("") && !conn.rs.getString("FirstName").equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString("FirstName").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString("FirstName"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      FirstName =  AES.getDecryptedString()  ;
                                                   }
                                       
                          if(conn.rs.getString("SecondName")!=null && !conn.rs.getString("SecondName").trim().equals("") && !conn.rs.getString("SecondName").equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString("SecondName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("SecondName"));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    MiddleName=AES.getDecryptedString();
                          }
                      if(conn.rs.getString("LastName")!=null && !conn.rs.getString("LastName").trim().equals("") && !conn.rs.getString("LastName").equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs.getString("LastName").trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString("LastName"));
                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                    
                      }			
//            client_name = conn.rs.getString(24);
//            client_name1 = conn.rs.getString(26);
            full_name = (FirstName +" "+ LastName);
            System.out.println(random);
            System.out.println(full_name);
            
       }
       
             }
       catch(SQLException ex) {
           
           System.out.println(ex);
       }
       return full_name;
             }
    
        
    
%>  
        <tr>
            <td></td> 
               
             <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> <td>Client Name :</td> <td>  <input type="text" name="client_name" id="client_name" value="<%= generateRandom() %>" style="width: 200px" required="true" readonly class="textbox"><%}}%>

  
                
            </td>  </tr>
        <tr></tr>
         <tr></tr>
         
         <% System.out.println("after"+uniqueId);%>
          <tr>
              <td></td> 
              <td>Unique Identifier </td>   
              <td><input type="text" name="unique_identifier" id="unique_identifier" value="<%= uniqueId %>" style="width: 200px" required="true" readonly="true" class="textbox" > </td>     
          <input type="hidden" name="medical_identifier" id="medical_identifier" value="<%= medical_id %>" style="width: 200px" required="true" readonly class="textbox" >
          </tr>
                <tr></tr>
         <tr></tr>
                 
         <tr><td colspan="2">Vital Signs:</td> <td>Current Complains:</td></tr>
<!--                 <tr></tr>
                 <tr></tr>-->
                 <tr><td>Temperature: </td> 
                     <td><input type="text" name="temperature" id="temperature" value="<%= temp%>" required="true" class="textbox"> </td>    
                     <td><textarea name="temperature_complain" value=""><%= temp_complain %></textarea></td>    
                 </tr>
                  <tr>
                      <td>Blood Pressure: </td> 
                     <td><input type="text" name="blood_pressure" id="blood_pressure" value="<%= bp %>" required="true" class="textbox"> </td>    
                     <td><textarea name="blood_pressure_complain" value=""><%= bp_complain %> </textarea> </td>    
                 </tr>
               <tr>
                   <td>P: </td> 
                     <td><input type="text" name="p" id="p" value="<%= p %>" required="true" class="textbox"> </td>    
                     <td><textarea name="p_complain" value=""><%= p_complain %> </textarea> </td>    
                 </tr>
               <tr>
                   <td>Weight: </td> 
                     <td><input type="text" name="weight" id="weight" value="<%= weight %>" required="true" class="textbox"> </td>    
                     <td><textarea name="weight_complain" value=""><%= weight_complain %> </textarea> </td>    
                 </tr>
  </table>   
    
</span>

<span id="Step2" style="display:none">
    <table style="position: relative; width: 700px; height: 400px">
        <tr><th colspan="5">System Exam.</th>  </tr>  
        <tr><td></td> <td>Choose Appropriately</td><td></td><td>Finding</td> </tr> 
        <tr><td>General Appearance</td> <td colspan="2"><select name="ga" id="ga" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= ga%>" selected="true"><%= ga %> </option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                    
            </td><td><textarea name="ga_findings" placeholder="Findings" id="ga_findings" disabled="false" rows="1" required="true" value=""><%= ga_complains%></textarea></td> </tr> 
        <tr><td>Skin</td> <td colspan="2"><select name="skin" id="skin" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= skin %>" selected="true"><%= skin %></option>                  
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                
            </td><td><textarea name="skin_findings" placeholder="Findings" id="skin_findings" disabled="false" rows="1" required="true" value=""><%= skin_findings %></textarea></td> </tr> 
        <tr><td>Ent</td> <td colspan="2"><select name="ent" id="ent" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= ent %>" selected="true"><%= ent %></option> 
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="ent_findings" placeholder="Findings" id="ent_findings" rows="1" disabled="false" required="true" value=""><%= ent_findings %></textarea></td> </tr> 
        <tr><td>Eyes</td> <td colspan="2"><select name="eyes" id="eyes" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%=eyes%>" selected="true"><%=eyes%></option> 
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="eyes_findings" value="" placeholder="Findings" id="eyes_findings" rows="1" disabled="false" required="true"><%= eyes_findings%></textarea></td> </tr>  
        <tr><td>Abdomen</td> <td colspan="2"><select name="abdomen" id="abdomen" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%=abdomen%>" selected="true"><%= abdomen %></option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="abdomen_findings" placeholder="Findings" value="" id="abdomen_findings" rows="1" disabled="false" required="true"><%= abdomen_findings%></textarea></td> </tr> 
        <tr><td>Genitourinary</td> <td colspan="2"><select name="genitourinary" id="genitourinary" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= genito%>" selected="true"><%= genito %></option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="genitourinary_findings" value="" placeholder="Findings" id="genitourinary_findings" rows="1" disabled="false" required="true"><%= genito_findings%></textarea></td> </tr> 
        <tr><td>Musculoskeletal</td><td colspan="2"><select name="musculoskeletal" id="musculoskeletal" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= musculo%>" selected="true"><%=musculo %></option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
               </td><td><textarea name="musculoskeletal_findings" value="" placeholder="Findings" rows="1" id="musculoskeletal_findings" disabled="false" required="true"><%= musculo_findings %></textarea></td> </tr>  
        <tr><td>Respiratory</td><td colspan="2"><select name="respiratory" id="respiratory" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= respiratory%>" selected="true"><%= respiratory %></option>
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="respiratory_findings" placeholder="Findings" value="" rows="1" id="respiratory_findings" disabled="false" required="true"><%= respiratory_findings%></textarea></td> </tr> 
        <tr><td>Psychological</td> <td colspan="2"><select name="psychological" id="psychological" required="true" style="width: 140px" onchange="return de_activator();" class="textbox2">
                    <option value="<%= pyscho%>" selected="true"><%= pyscho %></option> 
                    <option value="Normal">Normal</option>
                    <option value="Abnormal">Abnormal</option>
                    <option value="Not Done">Not Done</option>
                </select>
                
                </td><td><textarea name="psychological_findings" value="" placeholder="Findings" rows="1" id="psychological_findings" disabled="false" required="true"><%= pyscho_findings%></textarea></td> </tr> 
        
    </table>  
</span>
<span id="Step3" style="display:none">
    <table>  
     <tr><td>Clinical Impression/Diagnosis</td><td><textarea name="diagnosis" value="" placeholder="Clinical Impression/Diagnosis" > <%= diagnosis %></textarea></td> <tr> 
 <tr><td>Management</td><td><textarea name="management" placeholder="Management" value=""><%= mgmt %></textarea></td> <tr> 
 <tr><td>Referral</td><td><select name="referral" id="referral" onchange="return auto_hide()" style="width: 150px" class="textbox2">
             <option value="<%=referral %>" selected="true"><%= referral %></option>
             <option value="Lab">Lab</option>
             <option value="CCC">CCC</option>
             <option value="Others">Others</option>
         </select></td><td><input type="text" name="specify_others" id="specify_others" value="<%= specify %>" placeholder="Specify here" hidden="true" class="textbox"></td> <tr> 
 <tr><td>TCA : </td><td><input type="text" name="TCA"  id="datepicker1" value="<%=TCA %>" placeholder="" class="textbox"></td> <tr> 
 <%!
 
    public String generateRandomNumber(int cadre ){
        dbConnect conn=new dbConnect();
        String random = "select * from cadrecode where CadreCodeID ="+cadre;
       System.out.println(random);
       String cadre_name="";
       
       try {
           
              if(conn.state.isClosed()){conn= new dbConnect();}
       conn.rs=conn.state.executeQuery(random);
       
       if(conn.rs.next())
				{
            cadre_name = conn.rs.getString(2);
       }
       
             }
       catch(SQLException ex) {
           
           System.out.println(ex);
       }
       return cadre_name;
             }
    
        
    
%>  
 <tr><td>Cadre of Provider :</td><td> <input type="text" name="cadre" value="<%= generateRandomNumber(cadre) %>" placeholder="" readonly="true" class="textbox"></td> <tr> 
 <tr><td>Date : </td><td><input type="text" name="dater" value="<%= date %>" id="datepicker" placeholder="" class="textbox"></td> <tr> 
 <tr><td>Signature: </td><td><input type="text" name="signature" value="<%= signature %>" placeholder="" class="textbox"></td> <tr> 
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
