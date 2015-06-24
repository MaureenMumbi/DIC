<%-- 
    Document   : wizard
    Created on : Aug 23, 2013, 9:18:34 AM
    Author     : Maureen
--%>
<%!
int subdomainid=0;

HttpSession session;

 
%>
<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smart Wizard 2 - Step Validation Example - a javascript jQuery wizard control plugin</title>
<link href="demo_style.css" rel="stylesheet" type="text/css">

    <link href="smart_wizard.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="../scripts/jquery-1.7.2.js"></script>
        <script type="text/javascript" src="jquery.smartWizard.js"></script>

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
       var un = $('#domain').val();
       if(!un && un.length <= 0){
         isValid = false;
         $('#msg_domain').html('Please fill domain').show();
       }else{
         $('#msg_domain').html('').hide();
       }
       
       // validate password
       var pw = $('#subdomain').val();
       if(!pw && pw.length <= 0){
         isValid = false;
         $('#msg_subdomain').html('Please fill subdomain').show();         
       }else{
         $('#msg_subdomain').html('').hide();
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
		

function popselectedMaintainance(v) {
  var df = document.form;
  var code = df.code;
  
if(v==0 || v==1) {
    window.location="Audit.html";
}

}


function filter_domain(SubDomain){

var dist=SubDomain.value;   

//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (dist=="")
{
//filter the districts    



document.getElementById("subdomain").innerHTML="<option value=\"\">Choose Sub-Domain</option>";
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
document.getElementById("subdomain").innerHTML=xmlhttp.responseText;
}
}

xmlhttp.open("POST","/DIC/SubDomainSelector?domain="+dist,true);
xmlhttp.send();

}//end of filter districts

//
//function get_subdomain(subdomains){
//
//var dist1=subdomains.value; 
//alert(dist1);
//xmlhttp.open("POST","/DIC/SubDomainSelector?subdomain="+dist1,true);
//xmlhttp.send();
//}  


function filter_code(Code){

var dist1=Code.value;   

//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (dist1=="")
{
//filter the districts    



document.getElementById("code").innerHTML="<option value=\"\">Choose Code</option>";
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
document.getElementById("code").innerHTML=xmlhttp.responseText;
}
}

xmlhttp.open("POST","/DIC/CodeSelector?subdomain="+dist1,true);
xmlhttp.send();

}//end of filter districts


</script>
</head><body>

<div class="demoHead">   
  <h2>Create Questionnaire</h2>
</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>

 
<form action="../AddQuestionnaire" method="POST">
  <input type='hidden' name="issubmit" value="1">
<!-- Tabs -->
  		<div id="wizard" class="swMain">
  			<ul>
  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   Select Sections<br />
                   <small>Fill details</small>
                </span>
            </a></li>
                           
  				<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   Qstn Details<br />
                   <small>Fill details</small>
                </span>
            </a></li>
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                   Qstn Qualities<br />
                   <small>Fill details</small>
                </span>
             </a></li>
  				<li><a href="#step-4">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                  Dependency<br />
                   <small>Fill details</small>
                </span>
            </a></li>
  			</ul>
  			<div id="step-1">	
            <h2 class="StepTitle">Step 1: Account Details</h2>
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
          			    <tr><td>Select Domain</td>
                <td>   <select name="domain" id="domain" onchange="filter_domain(this)"><option value=""></option>
                       
               <%
               dbConnect conn = new dbConnect();
                                                      String Query= "SELECT DomainID,Domain FROM domains";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
              <option value='<%=conn.rs.getInt("DomainID")%>'><%=conn.rs.getString("Domain")%></option>
                                                   <%
                                                       
                               System.out.println(conn.rs.getInt("DomainID"));
                                System.out.println(conn.rs.getString("Domain"));  
int domainid = conn.rs.getInt("DomainID");
System.out.println("aaaaaaaa"+ domainid);
session.setAttribute("domainid", domainid); 
                        }   
                               
                                                   %>
                    </select>
                </td></tr>
            <tr><td>Select Section</td><td>
                    <select name="subdomain" id="subdomain" onchange="filter_code(this)">
                        <option value=""></option>
                  
                    </select> 
                              
                </td>
         
             </tr>                                   			
            </table>          			
        </div>
  <div id="step-2">
           <h2 class="StepTitle">Step 2: Profile Details</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    <td align="center" colspan="3">&nbsp;</td>
          		</tr>        
         <tr><td>Question No</td><td><input type="text" name="questionNo" value=""></td></tr>
         <tr><td>Question Name</td><td><input type="text" name="questionName" value=""></td></tr>
         <tr><td>Question</td><td><input type="text"  name="question" value=""></td></tr>
         <tr><td>Choose Question Type</td><td>
                     <select name="type" >
                         <option value=""></option>
                         <option value="Text">Text </option>
                         <option value="Checkbox">Checkbox</option>
                         <option value="Dropdown">DropDown</option>
   
                     </select>
            </td>
         </tr></table>      
        
  </div>                      
  		<div id="step-3">
            <h2 class="StepTitle">Step 3: Contact Details</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    <td align="center" colspan="3">&nbsp;</td>
          		</tr>        
          		<!--        is the question required to be filled during data entry -->
         <tr><td>Is it a required question</td>
        
             <td><select name="type">
                     <option value="Yes">Yes</option>
                     <option value="No">No</option> 
                 </select>
             </td>
        
         </tr>
       <!--        for question which have a drop down of codes -->
         <tr><td>Does the question have a code? </td>
            <td><select name="type">
                     <option value="Yes">Yes</option>
                     <option value="No">No</option> 
                 </select>
             </td>
         <tr><td>If yes, choose the code you want </td>
            <td><select name="code" id="code" onChange="popselectedMaintainance(this.selectedIndex);">
                    <option value=""></option>
                                        
                                                   
                    
                    
                    </select> 
               
            </td>
            
            
            <!--        for question which have a drop down of codes -->
       
                                 			
  			   </table>               				          
        </div>
  			<div id="step-4">
            <h2 class="StepTitle">Step 4: Other Details</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
          			<div class="displayDiv" id="DependencyContainer">
 <table cellspacing="3" cellpadding="3" align="center">
       
        <!--        for question whose answers will create a dependance with another question-->
        <tr><td>Does the question have dependants</td> 
        <td><select name="HasDependants">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
      
                </select></td></tr> 
        <tr><td>What is the dependant question?</td>
            <td><input name="dependantquestion" type="text" value=""></td></tr> 
        <tr><td>What is the dependant value?</td>
            <td><input name="dependantvalue" type="text" value=""></td></tr> 
    </table>               			
        </div>
  		</div>
<!-- End SmartWizard Content -->  		
</form> 


</body>
</html>
