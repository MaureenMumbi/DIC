<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- 
    Document   : editWorkers
    Created on : Aug 12, 2013, 9:42:18 AM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%!
 String child="";
dbConnect conn = new dbConnect();
String operation="";
String occupation="";


%>
<%!
String y[]= null;
//initialising of the fields to be fetched 
String UniqueID="";
String ClientInit="";
String DOE="";
String District="";
String DICName="";
String DOB="";
String Sex="";
String Age="";
String MaritalStatus="";
String Children="";
String ChildNo="";
String Religion="";
String EducationLevel="";
String PhoneNo="";
String Residence="";
String OperationArea="";
String Occupation="";
String MemberofID="";
String DICLearn="";
String Email="";
String PhoneNo1="";
String Venue="";
String AgeID="";
String id1="";
String id2="";
String id3="";
String id4="";
String Diclearn1="";
String venueOther="";
String FirstName="";
String MiddleName="";
String LastName="";
 String rowid="" ;

List  userList=null;
%>
<%
//fetching the data stored in the arraylist called userlist 
if(request.getAttribute("userList")!=null && request.getAttribute("userList")!="")
{
		userList = (ArrayList)request.getAttribute("userList");
		
		UniqueID=userList.get(0).toString();
		ClientInit=userList.get(1).toString();
		DOE=userList.get(2).toString();
		District=userList.get(3).toString();
		DICName=userList.get(4).toString();
		DOB=userList.get(5).toString();
		Sex=userList.get(6).toString();
		Age=userList.get(7).toString();
		MaritalStatus=userList.get(8).toString();
                Children=userList.get(9).toString();
                ChildNo=userList.get(10).toString();
                Religion=userList.get(11).toString();
                EducationLevel=userList.get(12).toString();
                PhoneNo=userList.get(13).toString();
                Residence=userList.get(14).toString();
                OperationArea=userList.get(15).toString();
                Occupation=userList.get(16).toString();
                MemberofID=userList.get(17).toString();
                DICLearn=userList.get(18).toString();
                Email=userList.get(19).toString();
                PhoneNo1=userList.get(20).toString();
                Venue=userList.get(21).toString();
                AgeID=userList.get(22).toString();
                venueOther=userList.get(23).toString();
                Diclearn1=userList.get(24).toString();
                FirstName=userList.get(25).toString();
                MiddleName=userList.get(26).toString();
                LastName=userList.get(27).toString();
                rowid=userList.get(28).toString();
		
		
		

}
%>

<html>
    <head>
        <!--The below code creates a form and shows the input fields-->
        <title>DIC Client Enrollment Form</title>
    
    

    <link rel="StyleSheet" href="admin/css/main.css" type="text/css" />
    <link rel="stylesheet" href="admin/css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="admin/themes/base/jquery.ui.all.css">
    <link rel="stylesheet" href="admin/themes/eggplant/jquery.ui.all.css">
    
    <script src="scripts/jquery-1.7.2.js"></script>
    
    <script src="admin/ui/jquery.ui.core.js"></script>
    <script src="admin/ui/jquery.ui.widget.js"></script>
    <script src="admin/ui/jquery.ui.datepicker.js"></script>
    <script src="admin/js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
        <script>	
                $(function() {
        $( ".datepickerDOB" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1950:2000'
                               
                        });
                    
                });
            </script>
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
    function ageCount() {
        var date1 = new Date();
        var  dob= document.getElementById("date").value;
        var date2=new Date(dob);
        var pattern = /^\d{1,2}\/\d{1,2}\/\d{4}$/; //Regex to validate date format (dd/mm/yyyy)
        if (pattern.test(dob)) {
            var y1 = date1.getFullYear(); //getting current year
            var y2 = date2.getFullYear(); //getting dob year
            var age = y1 - y2;           //calculating age 
            document.getElementById('age').value = age;
            return true;
        } else {
            alert("Invalid date format. Please Input in (dd/mm/yyyy) format!");
            return false;
        }

    }
</script>

<!--javascript code that picks date-->

 

	        <script>
 		
function disableOptions(v) {
  var df = document.form;
  var Children = df.Children;
  var ChildNo = df.ChildNo;
  var Age_9 = df.Age_9;
  var Age_9No = df.Age_9No;
  var Age_14 = df.Age_14;
  var Age_14No = df.Age_14No;
  var Age_19 = df.Age_19;
  var Age_19No = df.Age_19No;
  var Age_24 = df.Age_24;
  var Age_24No = df.Age_24No;
  var Age_25 = df.Age_25;
  var Age_25No = df.Age_25No;
  //var location1=df.location1;
if(v==1) {
  Age_9.disabled = false; Age_9No.disabled = false;
  Age_14.disabled = false; Age_14No.disabled = false;
  Age_19.disabled = false; Age_19No.disabled = false;
  Age_24.disabled = false; Age_24No.disabled = false;
  Age_25.disabled = false; Age_25No.disabled = false;
  ChildNo.disabled = false;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    ChildNo.disabled = true;
    Age_9.disabled = true; Age_9No.disabled = true;
    Age_14.disabled = true; Age_14No.disabled = true;
    Age_19.disabled = true; Age_19No.disabled = true;
    Age_24.disabled = true; Age_24No.disabled = true;
    Age_25.disabled = true; Age_25No.disabled = true;
  }
}
function disableOptions1(v) {
  var df = document.form;
  var Religion = df.Religion;
  var Religion1 = df.Religion1;
  //var location1=df.location1;
if(v==1 || v==2) {
  Religion1.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    Religion1.disabled = false; 
  }
}
function disableOptions2(v) {
  var df = document.form;
  var OperationArea = df.OperationArea;
  var OperationArea1 = df.OperationArea1;
  //var location1=df.location1;
if(!(v==8)) {
  OperationArea1.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    OperationArea1.disabled = false; 
  }
}
function disableOptions8(v) {
  var df = document.form;
  var Venue = df.Venue;
  var Venue1= df.Venue1;
  //var location1=df.location1;
if(!(v==8)) {
  Venue1.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    Venue1.disabled = false; 
  }
}
function disableOptions3(v) {
  var df = document.form;
  var DICLearn = df.DICLearn;
  var DICLearn1 = df.DICLearn1;
  //var location1=df.location1;
if((v==1 || v==2)) {
  DICLearn1.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    DICLearn1.disabled = false; 
  }
}
</script>
<script type="text/javascript">
// a function that filters the districts in the passed county as per the county drop down.

function filter_districts(DICName){

var dist=DICName.value;   

//
// window.open("districtselector?county="+dist.value);     
var xmlhttp;    
if (dist=="")
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

xmlhttp.open("POST","/DIC/districtselector?district="+dist,true);
xmlhttp.send();
Unique();

}//end of filter districts
</script> 

<SCRIPT language="JAVASCRIPT">
function newWindow1() {
popWindow = window.open('/DIC/home1.jsp', 'popWin',
'width=330,height=250')
}

// End hiding script from old browsers -->
</SCRIPT>


<style type="text/css">
    #container{
                height:550px;
                width:980px; 
    }
   
    .example  {  
        height:760px;
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
       var un = $('#DOE').val();
       if(!un && un.length <= 0){
         isValid = false;
         $('#msg_DOE').html('Please fill DOE').show();
       }else{
         $('#msg_DOE').html('').hide();
       }
       
       // validate password
       var pw = $('#ClientInit').val();
       if(!pw && pw.length <= 0){
         isValid = false;
         $('#msg_ClientInit').html('Please fill ClientInit').show();         
       }else{
         $('#msg_ClientInit').html('').hide();
       }
       
       
          var x= document.getElementById("client_name").value;
         var  y=document.form
         var txt;
        txt=y.client_name.value;
// alert(x);
// alert("a  "+ txt.length);
    if (txt.length<4){
         isValid = false;
        alert("The client name cannot contain less than 3 characters!")
//        return false
    }else {
//        return true
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
<script>
  
    function check(){
  
for(var i=0; i<=7; i++) {
    var o=document.getElementById("occupationalString").value;

    var t =document.getElementById("Occupation"+i).value;
   
 if(o.contains(t)) {
   document.getElementById("Occupation"+i).checked=true;
   }
}
 
   
  
for(var i=0; i<=8; i++) {
    var j= document.getElementById("operation").value;
   if(j.contains(document.getElementById("OperationArea"+i).value)) {
                    document.getElementById("OperationArea"+i).checked=true;
    
}
   
}
for(var i=0; i<6; i++) {
var f = document.getElementById("child").value;
var k = document.getElementById("childage").value;
var t= k.split("_");
var c= f.split("_");
//alert("hhhh"+f);
//alert(c[i]);
if(c[i]!=null && t[i]!=null && c[i]!="" && t[i]!="" ){
//    alert("a"+t[i]);
  if(c[i] == document.getElementById("Age_9").value) {
      
       document.getElementById("Age_9").checked=true;
       document.getElementById("Age_9No").value=t[i];
        
     }
 else if(c[i]==document.getElementById("Age_14").value) {
                    document.getElementById("Age_14").checked=true;
                     document.getElementById("Age_14No").value=t[i];
        
     }
  else if(c[i]==document.getElementById("Age_19").value) {
                    document.getElementById("Age_19").checked=true;
                     document.getElementById("Age_19No").value=t[i];
        
     }
  else if(c[i]==document.getElementById("Age_24").value) {
                    document.getElementById("Age_24").checked=true;
                     document.getElementById("Age_24No").value=t[i];
        
     }
  else if(c[i]==document.getElementById("Age_25").value) {
                    document.getElementById("Age_25").checked=true;
                     document.getElementById("Age_25No").value=t[i];
        
     }
   } 
   }
}
</script>

 <script type="text/javascript">
              function names_pop_up(){
              var fname, mname, lname;
              var   name=document.getElementById("client_name").value;
//              alert(name);
//              if(name==""){
              var person=prompt("Please Enter Client Full name",name);
               var person2=person;
              if(person!=null || person!=""){
                person2.replace("  "," ");  
              
             var n=person2.split(" "); 
             var q=n.length
         var    p=q-1;
         var i=0;
         var full_name="";
         var initials="";
         while( i<=p){
              var ni=n[i].split("");
             var nii=ni[0]+".";
           if(nii!="undefined."){ 
             n[i]=n[i]+" ";
            }
             if(nii=="undefined."){
                 nii="";
                 n[i]="";
             }
             initials+=nii;

             full_name+=n[i];
             i++;
        // }
//              var n1=n[0].split("");
//              var n11=n1[0];
//                var n2=n[1].split("");
//              var n22=n2[0];
//                var n3=n[2].split("");
//              var n33=n3[0];
//              var initials=n11+n22+n33;
             document.getElementById("ClientInit").value=initials;       
             document.getElementById("client_name").value=full_name;  
              Unique();
              }
              }
                  
                  
                  
              }
              
              

    
   
    function Unique(){
    var dist = document.getElementById("district");
      var distr= dist.options[dist.selectedIndex].text;
    
    var enroll = document.getElementById("DOE").value;
  
    var Uniq = document.getElementById("OLDUniqueID").value;
    var initial=document.getElementById("ClientInit").value;
    var Sub = enroll.substring(3);
    var ans  = Uniq.split("/");
    var x=   distr+"/"+initial+"/"+Sub+"/"+ans[4];
    document.getElementById("UniqueID").value = x;
   }

</script>

<script type="text/javascript">
function validate(){
   var x= document.getElementById("client_name").value;
 
    if (x.length<3){
        alert("The field cannot contain less than 3 characters!")
        return false
    }else {
        return true
    }
}
</script>
</head><body onload="check();">

<%




String query2="SELECT max(UniqueID) from dummy";
int Unique=0;
   if(conn.state.isClosed()){conn= new dbConnect();}
conn.state= conn.connect.createStatement();
conn.rs = conn.state.executeQuery(query2);

while(conn.rs.next()){
    %>
 <input type="text" name="UniqueId" id="UniqueId" hidden value="<%= conn.rs.getInt(1) %>">
 
<%

}
int uni=Unique+1;
String UniqueCode;
//UniqueCode = District +'/'+time +'/'+ uni;
//HttpSession session =request.getSession(true);
//session.setAttribute("UniqueCode", UniqueCode);
%>

     
   
<div class="example">
           <div class="login">
     <% String logStatus=(String)session.getAttribute("loggedIn");
       if(session.getAttribute("loggedIn").toString()==null){
//                   response.sendRedirect("/DIC/index.jsp");
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
   
           <!--=========================================menu=========================================-->     
              <div style=" width:1350px;"> 
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
  <h2>Enrollment</h2>
</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
                <form name="form"  method="post" action="EditWorker">
                    
                     <input type='hidden' name="issubmit" value="1">
<!-- Tabs -->
  		<div id="wizard" class="swMain">
  			<ul>
  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                  Client Details<br />
                   <small>Fill details marked <font style="color: blue">*</font></small>
                </span>
            </a></li>
                           
  				<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                  Personal Details<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                 Contact Details<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
             </a></li>
  				<li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                 Other  Details<br />
                   <small>Fill details marked<font style="color: blue">*</font></small>
                </span>
            </a></li>
  			</ul>
                   
                    <div id="step-1">	
            <h2 class="StepTitle">Step 1: Clients Details</h2>
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                   
              
           <input type="hidden" name="AgeID" value="<%= AgeID%>">
                            <input type="hidden" name="MemberOfID" value="<%= MemberofID%>">
                            <input type="hidden" name="OperationAreaID" value="<%= OperationArea%>">
                            <input type="hidden" name="OccupationID" value="<%= Occupation%>">
                             
                <tr class="d0"><td>Date of Enrollment <font style="color: blue">*</font></td>
                    <td><input type="text" name="DOE" class="datepicker" title="Enter date" id="DOE" value="<%= DOE %>"   readonly required><input type="hidden" name="ROWID" id="ROWID" value="<%= rowid %>"  ></td>
                     <td></td>
                     <td></td>
                 </tr>
                
                 <tr class="d1"><td>County <font style="color: blue">*</font> </td><td>
                        <select onchange="filter_districts(this);" name="district" id="district">
   
                            
                            
                               
                                <% 
                                String QueryConvertn= " SELECT District,DistrictID FROM districts ";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryConvertn);
                                                      while(conn.rs.next())
                                                           {
                                                               if(District.equals(conn.rs.getString("DistrictID"))){
                                                   %>                                                                       
                           <option selected value="<%= conn.rs.getString("DistrictID") %>"><%= conn.rs.getString("District") %></option>  
                                                   
                    
                                                   <%
                                                                                                         }
                                                               else{
                              
                                                   %>
                          <option value="<%= conn.rs.getString("DistrictID") %>"><%= conn.rs.getString("District") %></option>  
                               
                                                   <%}}%>
                                 

                                 </select></td>
                                 <td>DIC Name <font style="color: red">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName" >
                                 <option selected value="<%= DICName %>"><%= DICName %></option>  

                                 </select></td>
                </tr>
                <tr class="d0"><td>Client Initials <font style="color: blue">*</font></td><td><input class="inputSize" type="text" name="ClientInit" id="ClientInit" value="<%= ClientInit%>" onfocus="return names_pop_up();" required><input type="hidden" name="client_name" id="client_name" value="<%=FirstName +" "+MiddleName+" "+LastName %>"></td>
                    <td>Unique Identifier <font style="color: blue">*</font></td><td><input type="text" class="inputSize" name="UniqueID"  value="<%= UniqueID %>" id="UniqueID" required> <input type="hidden" class="inputSize" name="OLDUniqueID"  value="<%= UniqueID %>" id="OLDUniqueID" ></td>
                 </tr>
                <tr>
          
              </table>          			
         </div>
                    <div id="step-2">
            <h2 class="StepTitle">Step 2: Personal Details</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	 <td align="center" colspan="3">&nbsp;</td>
          			</tr>        
            
               
                <tr class="d1">
                    <td>Date of Birth <font style="color: blue">*</font></td><td><input type="text"  name="DOB" class="datepickerDOB" readonly title="Enter date" value="<%= DOB %>"  required ></td>
                <td>Sex <font style="color: blue">*</font></td>
                    <td><select name="Sex" class="inputSize">
                       <% if((Sex).equalsIgnoreCase("Female")){ %>
                           
                             <option selected value=" <%= Sex  %>"><%= Sex %></option>
                           
                             <%}
                       else{%>
                        <option selected value=""></option>
                        <option selected value="Female"></option>
                       <%}%>
                        </select>
                     </td>
                 </tr>
                 <tr class="d0">
                    <td>Client Age <font style="color: blue">*</font></td>
                    <td><input type="text" name="age" id ="age" value="<%= Age %>" onclick= "ageCount();" readonly="readonly" required></td>
                    <td>Marital Status <font style="color: blue">*</font> </td>
                    <td><select name="MaritalStatus">
                            
                 
               <%
             
                                                      String Query= "SELECT Marital_Status,Marital_StatusID FROM Marital_Status";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query);
                                                      while(conn.rs.next())
                                                           {
                                                   ArrayList MaritalList = new ArrayList();
                                                    ArrayList MaritalList1 = new ArrayList();
                                                    if(MaritalList!= null && MaritalList.size()!=0){
                                                    MaritalList.clear();
                                                    }
                                                    if(MaritalList1!= null && MaritalList1.size()!=0){
                                                    MaritalList1.clear();
                                                    }
                                                          
                                                           MaritalList.add(conn.rs.getString("Marital_Status"));
                                                           MaritalList1.add(conn.rs.getString("Marital_StatusID"));
                                                      String querymarital = "SELECT Marital_Status,Marital_StatusID FROM Marital_Status where Marital_StatusID='"+MaritalStatus+"'";
                                                        if(conn.state2.isClosed()){conn= new dbConnect();}                                                              
                                                      conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(querymarital);
                                                                String maritalstat="";
                                                                while(conn.rs2.next()){
                                                                 maritalstat=  conn.rs2.getString("Marital_Status"); 
                                                                }

                                                  for(int i=0;i<MaritalList.size();i++){
                
  if(MaritalList.get(i).equals(maritalstat)){
                                      %>
                                 
                    
                <option selected value="<%= MaritalList1.get(i)%>"><%=MaritalList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= MaritalList1.get(i)%>"><%=MaritalList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }
                                              
                               
                                                   %>
                                            

</select>
                    </td>               
                    
         </tr>
                
                 
                  
                  
                  <tr class="d1"><td>Do you have Children <font style="color: blue"></font></td>
                      <td><select name="Children" id="Children" class="inputSize" onChange="disableOptions(this.selectedIndex);">
                              
                              <%if((Children).equalsIgnoreCase("yes")){
                                  
                             %>
                              <option selected value="<%= Children %>"><%= Children %></option>
                              <option value="No">No</option>
                              
                              <%}
                                 else if((Children).equalsIgnoreCase("no")){%>
                              
                              <option value="Yes">Yes</option>
                               <option selected value="<%= Children %>"><%= Children %></option>
                              
                              
                              <%} else{%>
                              <option value="Yes">Yes</option>
                              <option value="No">No</option>
                              <%
                                                           }
  %>
                        </select>
                      </td>
                   <td>Area of Residence</td>
                   <td><select name="Residence"> 
                       
               <%
 String Query1= "SELECT ResidenceArea,ResidenceAreaID FROM residencearea";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query1);
                                                      while(conn.rs.next())
                                                           {
                                                  ArrayList residenceList = new ArrayList();
                                                    ArrayList residenceList1 = new ArrayList();
                                                        
 if(residenceList!= null && residenceList.size()!=0){
                                                    residenceList.clear();
                                                    }
                                                    if(residenceList!= null && residenceList.size()!=0){
                                                    residenceList.clear();
                                                    }

                                                                                                                                                           
                                                           residenceList.add(conn.rs.getString("ResidenceArea"));
                                                           residenceList1.add(conn.rs.getString("ResidenceAreaID"));
                                                      String queryvenue = "SELECT * FROM residencearea where ResidenceAreaID='"+Residence+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String residences="";
                                                                while(conn.rs2.next()){
                                                                 residences=  conn.rs2.getString("ResidenceArea"); 
                                                                }

                                                  for(int i=0;i<residenceList.size();i++){
                
                                  if(residenceList.get(i).equals(residences)){
                                      %>
                                 
                    
                <option selected value="<%= residenceList1.get(i)%>"><%=residenceList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= residenceList1.get(i)%>"><%=residenceList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }
                                              
                               
                                                   %>
                       </select></td>
                                                   
<!--                   <td><input type="text" name="Residence" class="inputSize" value="" ></td>-->
                  </tr>
                  <tr class="d0">
                      <td>If Yes, how many? </td><td><input type="text"  class="inputSize" onkeypress="return isNumberKey(event)" name="ChildNo" value="<%= ChildNo%>" id="ChildNo" ></td>
                  </tr>
                  <tr class="d0">
                      <td>If Yes, what are their ages? </td>
                  </tr>
                   <%
                            String QueryAge= "SELECT * FROM childage where ChildID ='"+AgeID+"'";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryAge);
                                                      
				ArrayList b = new ArrayList();
				ArrayList ages = new ArrayList();
                                String childage="";
                                String AgesID="";
                                
                                if(b!= null && b.size()!=0){
                                                    b.clear();
                                                    }
                                 if(ages!= null && ages.size()!=0){
                                                   ages.clear();
                                                    }
                                                   
                                                      while(conn.rs.next())
                                                           {
                                                         
				 child+=conn.rs.getString("AgeBrackets")+"_";
				 childage+=conn.rs.getString("NoChild")+"_";
				 AgesID+=conn.rs.getString("ID")+"_";
                                
                                  %>                      
                                 
                              <%  System.out.println("Arraylist for age__________________________"+child);
                                
                                    } %>
                 
                    
                  
                  
                  <tr class="d1">
                 
                    <td> <input type="hidden" name="child" id="child" value="<%= child %>">
                        <input type="hidden" name="childage" id="childage" value="<%= childage %>">
                        <input type="hidden" name="childsID" id="childsID" value="<%= AgesID %>">
                        <input type="checkbox" name="AgeID0" id="Age_9" value="1"> 0 - 9 yrs
                      <input type="text" name="AgeNo0" id ="Age_9No" value="" placeholder="Enter No of Children" ></td>
                   <td><input type="checkbox" name="AgeID1" id="Age_14" value="2"> 10 - 14 yrs
                   <input type="text" name="AgeNo1" id ="Age_14No" value="" placeholder="Enter No of Children" ></td></tr>
                  <tr class="d0"> <td><input type="checkbox" id="Age_19" name="AgeID2" value="3"> 15-19 yrs
                   <input type="text" name="AgeNo2" id ="Age_19No" value="" placeholder="Enter No of Children" ></td>
                   <td><input type="checkbox" name="AgeID3" id="Age_24" value="4"> 20 - 24 yrs 
                   <input type="text" name="AgeNo3" id ="Age_24No" value="" placeholder="Enter No of Children" ></td></tr>
                  <tr class="d1"> <td></td><td><input type="checkbox" name="AgeID4" id="Age_25" value="5"> 25+ yrs
                      <input type="text" name="AgeNo4" id ="Age_25No" value="" placeholder="Enter No of Children" ></td></tr>

                  <tr class="d1">
                      <td>Religion <font style="color: blue">*</font></td>
                      <td>
                          <select name="Religion" id="Religion" class="inputSize" onChange="disableOptions1(this.selectedIndex);" >
                            
                         <%      String RelList[] = new String[]{"Christian","Muslim","Others"};
                                                   

                                                  for(int i=0;i<RelList.length;i++){
                
                        if(RelList[i].equals(Religion)){
                                      %>
                                 
                    
                <option selected value="<%= RelList[i]%>"><%=RelList[i]%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= RelList[i]%>"><%=RelList[i]%></option>
             <%   }
                                                } 
                                              
                               
                                                   %>
                       </select>
                           <input type="text" name="Religion1" class="inputSize" id="Religion1" value="" ></td>
                    </tr>
                
                 <tr class="d0">
                      <td>Completed Education Level </td>
                      <td>
                          <select name="EducationLevel"  class="inputSize">
                          
                              
                         <%
 String Query2= "SELECT EducationLevel,EducationLevelID FROM educationlevel";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query2);
                                                      while(conn.rs.next())
                                                           {
                                                    ArrayList EDList = new ArrayList();
                                                    ArrayList EDList1 = new ArrayList();
                                                    
                                                      if(EDList!= null && EDList.size()!=0){
                                                    EDList.clear();
                                                    }  if(EDList1!= null && EDList1.size()!=0){
                                                    EDList1.clear();
                                                    }
                                                          
                                                           EDList.add(conn.rs.getString("EducationLevel"));
                                                           EDList1.add(conn.rs.getString("EducationLevelID"));
                                                      String queryvenue = "SELECT * FROM educationlevel where EducationLevelID='"+EducationLevel+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String edlevel="";
                                                                while(conn.rs2.next()){
                                                                 edlevel=  conn.rs2.getString("EducationLevel"); 
                                                                }

                                                  for(int i=0;i<EDList.size();i++){
                
  if(EDList.get(i).equals(edlevel)){
                                      %>
                                 
                    
                <option selected value="<%= EDList1.get(i)%>"><%=EDList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= EDList1.get(i)%>"><%=EDList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }
                                              
                               
                                                   %>
                          </select></td>
<!--                      <td>
                          <select name="EducationLevel"  class="inputSize">
                              <option value=""></option>
                              <option value="Pre-Primary">Pre-Primary</option>
                              <option value="Primary">Primary</option>
                              <option value="Secondary">Secondary</option>
                              <option value="Post-Secondary">Post-Secondary</option>
                           </select>
                      </td>-->
                  </tr>
            </table></div>
                                       
  <div id="step-3">
            <h2 class="StepTitle">Step 3: Contact Details</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
              
                  <tr class="d1">
                      <td>Client Phone # <font style="color: blue">*</font></td><td><input type="text" pattern="(07)[0-9]{8}" onkeypress="return isNumberKey(event)" name="PhoneNo" class="inputSize" value="<%= PhoneNo %>" ></td>
                     
                  </tr>
                  <tr class="d0">
                      <td>Client e-mail address </td><td><input type="text" name="Email" class="inputSize" value="<%= Email %>" ></td>
                     
                  </tr>
                  <tr class="d1">
                      <td>Alternative Phone# </td><td><input type="text" pattern="(07)[0-9]{8}" onkeypress="return isNumberKey(event)" name="PhoneNo1" class="inputSize" value="<%= PhoneNo1 %>"></td>
                     
                  </tr>
                  <tr class="d0">
                  </tr>
                  <tr class="d0">
                      <td>Client area of Operation <font style="color: blue">*</font> </td></tr>
                    <%
                            String QueryOperation= "SELECT * FROM clientoparea where COPID ='"+OperationArea+"'";
                                                     conn.state= conn.connect.createStatement();
                                                    String  operations="";
				conn.rs = conn.state.executeQuery(QueryOperation);
                                                     String OperationsID="";
                                                      while(conn.rs.next())
                                                           {
                                                         
				 operation+=conn.rs.getString(4)+"_";
				 OperationsID+=conn.rs.getString(1)+"_";
        
                                                        }
                                
                                System.out.println("String for operation   "+operation);
                                System.out.println("String for OperationsID     "+OperationsID);
                                
                         %>
                  <tr><td><input type="checkbox" name="OperationArea" value="1" id="OperationArea0">Naivasha</td>
                      <input type="hidden" name="operation" id="operation" value="<%= operation %>">
                      <input type="hidden" name="OperationsID" id="operationid" value="<%= OperationsID %>">
                      <td><input type="checkbox" name="OperationArea" value="2" id="OperationArea1">Gilgil</td></tr>
                  <tr><td><input type="checkbox" name="OperationArea" value="3" id="OperationArea2">Nanyuki</td>
                      <td><input type="checkbox" name="OperationArea" value="4" id="OperationArea3">Ngong</td></tr>
                  <tr><td><input type="checkbox" name="OperationArea" value="5" id="OperationArea4">Narok</td>
                      <td><input type="checkbox" name="OperationArea" value="6" id="OperationArea5">Nakuru</td></tr>
                  <tr> <td><input type="checkbox" name="OperationArea" value="7" id="OperationArea6">Salgaa</td>
                     <td><input type="checkbox" name="OperationArea" value="8" id="OperationArea7">Makutano</td></tr>
                  <tr>  <td><input type="checkbox" name="OperationArea" value="9" id="OperationArea8">Others,Specify 
                          <input type="text" name="Others" value="" class="inputSize" id="Others"> </td>
                  </tr>
                  
                  
                  
                  
                 

                     
                
       <tr class="d1">
                     <td>Venue <font style="color: blue">*</font></td>
                     <td>
                        <select name="Venue"  class="inputSize" onChange="disableOptions8(this.selectedIndex);">
                  
               <%
               System.out.println("Venue      "+Venue);
               
                            String Query4= "SELECT Venue,VenueID FROM Venue";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query4);
                                                      while(conn.rs.next())
                                                           {
                                                    ArrayList venueList = new ArrayList();
                                                    ArrayList venueList1 = new ArrayList();
                                                          if(venueList!=null && venueList.size()!=0){
                                                           venueList.clear();
                                                          }
                                                          if(venueList1!=null && venueList1.size()!=0){
                                                           venueList1.clear();
                                                          }
                                                           venueList.add(conn.rs.getString("Venue"));
                                                           venueList1.add(conn.rs.getString("VenueID"));
                                                      String queryvenue = "SELECT Venue,VenueID FROM Venue where VenueID='"+Venue+"' ";
                                                               conn.state2= conn.connect.createStatement();
				                                conn.rs2 = conn.state2.executeQuery(queryvenue);
                                                                String venues="";
                                                                while(conn.rs2.next()){
                                                                 venues=  conn.rs2.getString("Venue"); 
                                                                }

                                                  for(int i=0;i<venueList.size();i++){
                
                                  if(venueList.get(i).equals(venues)){
                                      %>
                                 
                    
                <option selected value="<%= venueList1.get(i)%>"><%=venueList.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= venueList1.get(i)%>"><%=venueList.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }
                                              
                               
                                                   %>
                          </select>
                           <input type="text" name="Venue1" value="<%= venueOther %>" class="inputSize" id="Venue1">
                     </td>
                 </tr> 
            </table>
  </div>
                          
                          
                          
  			<div id="step-4">
            <h2 class="StepTitle">Step 4: Other Details</h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                 
                   <tr class="d0">
                      <td>Occupation <font style="color: blue">*</font> </td></tr>
                    <%
                            String QueryOcc= "SELECT * FROM clientoccupation where CoccID ='"+Occupation+"'";
                                                   
		conn.rs = conn.state.executeQuery(QueryOcc);
                                              String occupationString ="";       
                                              String occupationID ="";       
				
                                                      while(conn.rs.next())
                                                           {
                                                         
				 occupationString+=conn.rs.getString("OccupationID")+"_";
				 occupationID+=conn.rs.getString(1)+"_";
        
                                                        }
                                
                                System.out.println("String for occupation"+occupationString);
                                System.out.println("String for occupationID"+occupationID);
                                
                         %>
                   
                    <input type="hidden" name="occupationalString" id="occupationalString" value="<%= occupationString %>">
                    <input type="hidden" name="occupationID" id="occupationID" value="<%= occupationID %>">
                  <tr><td><input type="checkbox" name="Occupation" value="1" id="Occupation0">Small Business  </td>
                  
                      <td><input type="checkbox" name="Occupation" value="2" id="Occupation1">Hawking</td></tr>
                  <tr><td><input type="checkbox" name="Occupation" value="3" id="Occupation2">Farming</td>
                      <td><input type="checkbox" name="Occupation" value="4" id="Occupation3">Artisan(Jua Kali)</td></tr>
                  <tr><td><input type="checkbox" name="Occupation" value="5" id="Occupation4">Formal Employment</td>
                      <td><input type="checkbox" name="Occupation" value="6" id="Occupation5">Sex Work</td></tr>
                  <tr> <td><input type="checkbox" name="Occupation" value="7" id="Occupation6">Casual Labourer</td>
                  <tr> <td><input type="checkbox" name="Occupation" value="8" id="Occupation7">None</td>
                  
                  
                  </tr>
                    
                   
                 <tr class="d0">
                     <td>Are you a member of: 
                 </tr>
                   <tr class="d1">
                     <td align="right">NHIF</td>
                     <td>
                     <select name="member" class="inputSize">
                         
                   <%    String Query5= "SELECT * FROM clientmember where MemberID='"+MemberofID+"'";
                               conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query5);
                                ArrayList al=null;
				List userList1 =new ArrayList();
				List memID =new ArrayList();
                                                      while(conn.rs.next())
                                                           {
                                                          al  = new ArrayList();
				 
                                           al.add(conn.rs.getString("MemID"));
                                            userList1.add(al);      
                                           
				             memID.add(conn.rs.getString(1));
                                                                                                          
                                                   
                                                       
                               
                                                        }
                                
                               
      List users1=null;                         
          if(userList1!=null && userList1.size()>0 ){
  // users1=(List)userList1;
     id1= userList1.get(0).toString();
     
     String id2= userList1.get(1).toString();
     String id3= userList1.get(2).toString();
     String id4= userList1.get(3).toString();
     
     String memID0= memID.get(0).toString();
     String memID1= memID.get(1).toString();
     String memID2= memID.get(2).toString();
     String memID3= memID.get(3).toString();
     
   System.out.println(id1);  
   System.out.println(id2);  
   System.out.println(id3);  
   System.out.println(id4);  
    
if(id1.equals("[1]")) { %>

                          <option selected value="1">Yes</option>
                          <option  value="2">No</option>
    <% }                    
  
else if(id1.equals("[2]")){%>

   <option  value="1">Yes</option>
   <option selected value="2">No</option>
   <%  } 
      else{                          
   %>
    <option  value="1">Yes</option>
   <option  value="2">No</option>
   
     <%}%>                       
       <input type="hidden" name="memID0" value="<%= memID0%>">                   
       <input type="hidden" name="memID1" value="<%= memID1%>">                   
       <input type="hidden" name="memID2" value="<%= memID2%>">                   
       <input type="hidden" name="memID3" value="<%= memID3%>">                   
                            
                     </select>
                      </td>
                 </tr>
                 <tr class="d0">
                     <td align="right">NSSF <font style="color: blue"></font></td>
                     <td><select name="member" class="inputSize">
                            <%                          
                          if(id2.equals("[1]")) { %>

                            <option selected value="1">Yes</option>
                            <option value="2">No</option>
                             <% }                    

                         else if(id2.equals("[2]")){%>
                            <option value="1">Yes</option>
                            <option selected value="2">No</option>
                            <%  } 
     else if(id2.equals("")){
                            %>
                            
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                             
                             <%}%>
                     </select>
                      </td>
                 </tr>
                 <tr class="d1">
                     <td align="right">MicroFinance Group </td>
                     <td>
                     <select name="member" class="inputSize">
                              <%                          
                          if(id3.equals("[1]")) { %>

                            <option selected value="1">Yes</option>
                            <option  value="2">No</option>
                             <% }                    

                         else if(id3.equals("[2]")){%>
                            <option value="1">Yes</option>
                            <option value="2" selected >No</option>
                            <%  } 
   else{
                            %>
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                             
                             <%}%>
                     </select>
                      </td>
                 </tr>
                 <tr class="d0">
                     <td align="right">Women Group </td>
                     <td>
                     <select name="member" class="inputSize">
                             <%                          
                          if(id4.equals("[1]")) { %>

                            <option selected value="1">Yes</option>
                            <option value="2">No</option>
                             <% }                    

                         else if(id4.equals("[2]")){%>
                            <option  value="1">Yes</option>
                            <option selected value="2" >No</option>
                            <%  } 

                             else{
                            %>
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                             <%
                                                         }
%>
                     </select>
                      </td>
                 </tr>
                 <%
          }
      %>
                 <tr class="d1">
                     <td>How client learnt about DIC </td>
                     <td>
                     <select name="DICLearn" class="inputSize" onChange="disableOptions3(this.selectedIndex);">
                  
                            
                        
               <%
                            String Query6= "SELECT ClientLearnt,ClientLearntID FROM clientlearnt";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query6);
                                                      while(conn.rs.next())
                                                           {
                                                         
                                                          
                                               
                                                      ArrayList clientLearnt = new ArrayList();
                                                      ArrayList clientLearnt1 = new ArrayList();
                                                          
                                                           clientLearnt.add(conn.rs.getString("ClientLearnt"));
                                                           clientLearnt1.add(conn.rs.getString("ClientLearntID"));
                                                      
                                                  for(int i=0;i<clientLearnt.size();i++){
                
                                  if(clientLearnt1.get(i).equals(DICLearn)){
                                      %>
                                 
                    
                <option selected value="<%= clientLearnt1.get(i)%>"> <%=clientLearnt.get(i)%></option>
                
               <% }
                
                else{%>
                    
                <option  value="<%= clientLearnt1.get(i)%>"> <%=clientLearnt.get(i)%></option>
             <%   }
                             }     
                                                      
                                                      
                                                      
                                                      }
                                              
                               
                                                   %>
                          </select>
<!--                             <option value=""></option>
                             <option value="Friend">Friend</option>
                             <option value="Peer Educator">Peer Educator</option>
                             <option value="Health Provider">Health Provider</option>
                             <option value="Other">Other(Specify)</option>-->
<!--                     </select>-->
                         <input type="text" name="DICLearn1" value="<%=Diclearn1%>" class="inputSize" id="DICLearn1" >
                      </td>
                 </tr>
                
                 <tr>
<!--                   <td><a href="javascript:newWindow1()"><input type="submit" class="button" name="Save" value="Save"></a></td>-->
<!--                   <td><input type="submit" class="button" name="Save" value="Save"></td></tr>-->
                     
                     
                 </tr>
                 
             </table>
                        </div>
       
      </div>
                           </form> 
    </td></tr></table>
</div>
        
        </div>
    </body>
</html>
