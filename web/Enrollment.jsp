<%-- 
    Document   : Enrollment
    Created on : Aug 12, 2013, 9:42:18 AM
    Author     : Maureen
--%>

<%@page import="dbConnect.dbConnect"%>
<%!

  dbConnect conn = new dbConnect();
String mindate="";
%>
<html>
    <head>
        <!--The below code creates a form and shows the input fields-->
        <title>DIC Client Enrollment Form</title>
        
           <!--javascript code that picks date-->
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

       <script src="js/datepicker.js"></script>
       <script src="admin/ui/jquery.ui.datepicker.js"></script>
       <script src="js/DICHelp.js"></script>
       
       <!----------------------button style----------------------->
       <style>
       .btn {
  background: #d9344f;
  background-image: -webkit-linear-gradient(top, #d9344f, #b82b2b);
  background-image: -moz-linear-gradient(top, #d9344f, #b82b2b);
  background-image: -ms-linear-gradient(top, #d9344f, #b82b2b);
  background-image: -o-linear-gradient(top, #d9344f, #b82b2b);
  background-image: linear-gradient(to bottom, #d9344f, #b82b2b);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 13px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}
</style>
       
       <!--------------------------------------------------------->
       
       
       
       
	 <script>	
                $(function() {
                      var dateTodays = new Date(); 
                
        $( ".datepickerDOB" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1950:2000',
                                maxDate:dateTodays
                               
                        });
                    
                });
            </script>
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
                                maxDate: dateToday,
                                minDate:dt
                        });
                    
                });
                    }
          })
               
            </script>
        
        <script type="text/javascript">
   
    $(document).ready(function(){
    	// Smart Wizard     	
  		$('#wizard').smartWizard({transitionEffect:'slideleft',onLeaveStep:leaveAStepCallback,onFinish:onFinishCallback,enableFinishButton:true});

      function leaveAStepCallback(obj){
           ChildrenNo();
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
           //ChildrenNo();
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:false});
       }
       
       
       if(!isStepValid){
          $('#wizard').smartWizard('showMessage','Please fill the field marked in blue ');
       }
              
       return isStepValid;
    } 	
		
		
		function validateSteps(step){
		  var isStepValid = true;
      // validate step 1
      if(step == 1){
        if(validateStep1() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the blue marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      // validate step3
      if(step == 2){
        if(validateStep2() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the blue marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      return isStepValid;
    }
		
		function validateStep1(){
       var isValid2 = true; 
       // Validate Username
     
       // validate password
       var pw = $('#DOE').val();
       if(!pw && pw.length <= 0){
         isValid2 = false;
           alert('Please fill DOE');
         $('#msg_DOE').html('Please fill DOE').show();         
       }else{
         $('#msg_DOE').html('').hide();
       }
       var dic = $('#DICName').val();
       if(!dic && dic.length <= 0){
         isValid2 = false;
            alert('Please select a DIC');   
       }else{
         $('#msg_DOE').html('').hide();
       }
       
       var ward = $('#ward').val();
       if(!ward && ward.length <= 0){
         isValid2 = false;
            alert('Please select a ward');   
       }else{
         $('#msg_DOE').html('').hide();
       }
         var un = $('#ClientInit').val();
       if(!un && un.length <= 0){
         isValid2 = false;
         alert('Please fill Client Initials');
         $('#msg_ClientInit').html('Please fill Client Initials').show();
       }
       if(un.length < 3){
         isValid2 = false;
         alert('Please enter two or more names');
         $('#msg_ClientInit').html('Please fill Client Initials').show();
       }
       
       else{
         $('#msg_ClientInit').html('').hide();
       }
       
         var clientname = $('#client_name').val();
          if(un.length > 0){
       if( clientname.length <= 4){
         isValid2 = false;
         alert('The full names entered is less than 4 characters');
          names_pop_up()
       }}
       
//      var start_date,end_date,dateObject,day,month,year,current_date;
//start_date=document.getElementById("datepicker1").value;
//end_date=document.getElementById("datepicker2").value;
   

////created the date object
dateObject =new Date();
day=dateObject.getDate();
month=dateObject.getMonth()+1;
year=dateObject.getFullYear();
//fully year separated by backward slash
var days=0;
days=day;
var dates=day;
if(parseInt(days)<10){
 dates="0"+day;  
}

var months=0;
months=month;
var months1=month;
if(parseInt(months)<10){
 months1="0"+month;  
}
//alert(dates);
current_date=months1+"/"+dates+"/"+year;
//current_date=months1+"/"+dates+"/"+year;

//alert(current_date);
//we compare the date

var dateofenroll = $('#DOE').val();
var g= dateofenroll.split("/");
//alert(g[0] +"  "+g[1]+"  "+g[2]);
var curdate=new Date(current_date);

var entereddate = g[1] +"/"+g[0]+"/"+g[2];
var newdate=new Date(entereddate);
//alert(newdate +"  gererr  "+curdate );

if( newdate > curdate){
alert("Enrollment date cannot be greater than current date");
return false;
}




  
       return isValid2;
    }
       function validateStep2(){
     var isValid = true; 
       // Validate Gender
       var un = $('#Sex').val();
       if(!un && un.length <= 0){
         isValid = false;
         $('#msg_Sex').html('Please fill Client Gender').show();
       }else{
         $('#msg_Sex').html('').hide();
       }
       
       // validate Marital Status
       var pw = $('#MaritalStatus').val();
       if(!pw && pw.length <= 0){
         isValid = false;
         $('#msg_MaritalStatus').html('Please fill MaritalStatus').show();         
       }else{
         $('#msg_MaritalStatus').html('').hide();
       }
       
//        validate Date of Birth
       var cpw = $('#date').val();
       if(!cpw && cpw.length <= 0){
         isValid = false;
         $('#msg_date').html('Please fill Date of Birth').show();         
       }else{
         $('#msg_date').html('').hide();
       }  
       
       // validate Client's Age
       var cp = $('#age').val();
       if(!cp && cp.length <= 0){
         isValid = false;
         $('#msg_age').html('Please fill Client Age').show();         
       }else{
         $('#msg_age').html('').hide();
       } 
       
       //Validate Religion
       var cpl = $('#Religion').val();
       if(!cpl && cpl.length <= 0){
         isValid = false;
         $('#msg_Religion').html('Please fill Client Religion').show();         
       }else{
         $('#msg_Religion').html('').hide();
       }
       return isValid;
      
    }
		
		
</script>
         <script>
$( document ).tooltip();
</script> 
        
        
        
        
        
        
        
        
        <!--Javascript function to calculate age-->  
          <script type="text/javascript">
              function names_pop_up(){
              var fname, mname, lname;
              var   name=document.getElementById("client_name").value;
              
              if(name==""){
              var person=prompt("Please Enter Client Full name","");
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
         }
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
              }else{
                  
                   var person=prompt("Please Enter Client Full name","");
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
                  
                  
                  
              }
              
              
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
            alert("Please input Clients Date of Birth!");
            return false;
        }

    }
    
    
    
</script>

<script>
    function ChildrenNo() {
    var  childno = document.getElementById("ChildNo").value;
    var  childno1 = document.getElementById("Age_9No").value;
    var  childno2 = document.getElementById("Age_14No").value;
    var  childno3 = document.getElementById("Age_19No").value;
    var  childno4 = document.getElementById("Age_24No").value;
    var  childno5 = document.getElementById("Age_25No").value;
    if (childno1 == ""){
        childno1 = 0;
        }
    else {
        childno1= document.getElementById("Age_9No").value;
    }
        
    if (childno2 == ""){
        childno2 = 0;
    }
    else {
        childno2= document.getElementById("Age_14No").value; 
    }
    if (childno3 == ""){
        childno3 = 0;
        }
    else{
        childno3= document.getElementById("Age_19No").value;
    }
    if (childno4 == ""){
            childno4 = 0;
        }
    else{
        childno4= document.getElementById("Age_24No").value;
        
    }
    if (childno5 == ""){
        childno5 = 0;
        }
    else{
        childno5= document.getElementById("Age_25No").value;
    }
        
    var child = parseInt(childno1) + parseInt(childno2) + parseInt(childno3) + parseInt(childno4) +parseInt(childno5);
    if (child != childno){
        //document.getElementById('age').value = child;
        alert("The number of children in the ages doesn't match the Chlidren number inputed")
    }
    
    }
</script>


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
    //ChildrenNo();
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
if(v==1 || v==2) {
  DICLearn1.disabled = true;
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    DICLearn1.disabled = false; 
  }
}


function disableOptionsVenue(v) {
  var df = document.form;
  var Venue = df.Venue;
  var Venue1 = df.Venue1;
  //var location1=df.location1;
if( v==2) {
  Venue1.disabled = true;
  Venue1.value = "";
  //location1.physics.disabled = false; 
  }
else {
 // location1.disabled = true;
    Venue1.disabled = false; 
  }
}
</script>
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

<SCRIPT language="JAVASCRIPT">
function newWindow1() {
popWindow = window.open('/DIC/home1.jsp', 'popWin',
'width=330,height=250')
}

// End hiding script from old browsers -->
</SCRIPT>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<link rel="StyleSheet" href="main.css" type="text/css" />

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
<script>
    
           
            function numbers(evt){
var charCode=(evt.which) ? evt.which : event.keyCode
if(charCode > 31 && (charCode < 48 || charCode>57)){
return false;
}

else{
 


 
return true;
}
}
</script>
<!--<link href="css/demo_style.css" rel="stylesheet" type="text/css">-->

<link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.smartWizard.js"></script>


<!--<script type="text/javascript">
    function Unique(){
    var dist = document.getElementById("district").value;
    
    var enroll = document.getElementById("DOE").value;
  
    var Uniq = document.getElementById("UniqueId").value;
    
    var Sub = enroll.substring(3);
    var ans  = parseInt(Uniq)+1;
    var x= dist+"/"+Sub+"/"+ans;
    document.getElementById("UniqueID").value = x;
   }
</script>-->
<script>
    function start(){
        form.AgeNo1.disabled = true;
    }
    onload = start;
    function chgAgeNo1(){
        form.AgeNo1.disabled =!
        form.AgeID1.checked;
    }
    
    function start1(){
        form.AgeNo2.disabled = true;
    }
    onload = start1;
    function chgAgeNo2(){
        form.AgeNo2.disabled =!
        form.AgeID2.checked;
    }
    
    function start2(){
        form.AgeNo3.disabled = true;
    }
    onload = start2;
    function chgAgeNo3(){
        form.AgeNo3.disabled =!
        form.AgeID3.checked;
    }
    
    function start3(){
        form.AgeNo4.disabled = true;
    }
    onload = start3;
    function chgAgeNo4(){
        form.AgeNo4.disabled =!
        form.AgeID4.checked;
    }
    
    function start4(){
        form.AgeNo5.disabled = true;
    }
    onload = start4;
    function chgAgeNo5(){
        form.AgeNo5.disabled =!
        form.AgeID5.checked;
    }
</script>
    <SCRIPT language=Javascript>
		<!--
function isCharacterKey(evt){

var charCode=(evt.which) ? evt.which : event.keyCode
if(charCode > 31 && (charCode < 48 || charCode>57))
return true;
return false;
}

function isNumberKey(evt){

var charCode=(evt.which) ? evt.which : event.keyCode
if(charCode > 31 && (charCode < 48 || charCode>57))
return false;
return true;
}

//-->
</SCRIPT>
<script type="text/javascript">
    function Unique(){
    var dist = document.getElementById("district").value;
      var distr= dist.split(",");
    
    var enroll = document.getElementById("DOE").value;
  
    var Uniq = document.getElementById("UniqueId").value;
    var initial=document.getElementById("ClientInit").value;
    var Sub = enroll.substring(3);
    var ans  = parseInt(Uniq)+1;
    var x=   distr[1]+"/"+initial+"/"+Sub+"/"+ans;
    document.getElementById("UniqueID").value = x;
   }
</script>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
<script type="text/javascript">
    
    
   function  capturefingerprint(){
        
        //alert(id +"::"+fname);l
       var id= document.getElementById("UniqueID").value  
        
        
        
        var xmlhttp;  
                
               
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
                        
         document.getElementById("msg").innerHTML=xmlhttp.responseText;
          //refresh page              
      ///  window.location.reload();
                    }
                }
                xmlhttp.open("POST","Selection?uniqueid="+id,true);
                xmlhttp.send();
//                document.getElementById("example").innerHTML="";
   document.getElementById("msg").innerHTML="<img src=\"images/sending.gif\" alt=\"searching\">Adding fingerprint";
        
        
    }
    
     
                    
         
             
    
</script>
</head><body>

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
System.out.println(conn.rs.getInt(1));
}
int uni=Unique+1;
String UniqueCode;
//UniqueCode = District +'/'+time +'/'+ uni;
//HttpSession session =request.getSession(true);
//session.setAttribute("UniqueCode", UniqueCode);
%>

     
   
<div class="example" >
           <div class="login">
     <% 
               if(session.getAttribute("Username")==null){
     
//               response.sendRedirect("index.jsp");
           } else{
     %>
                   
     <%
               }
        String username=(String)session.getAttribute("Username");
      
               if(username==null){
                     
               } else{
     %>
      <a class="button-1" href="../DIC/logoutServlet">LogOut</a>          
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
 
 //get the helps from the database.
 
 String Sectionshelp[]=new String [12];
int mcount=0;
 if(conn.state2.isClosed()){conn= new dbConnect();}
conn.rs2=conn.state2.executeQuery("Select * from help where help_id<='12'");

while(conn.rs2.next()){
    
Sectionshelp[mcount]=conn.rs2.getString(2);
if(mcount<=12){
mcount++;
}
}

%>   
        
        
    <div id ="container">
          
     <div class="demoHead">  
         
         <table>
              <tr id="dialog1" title="Enrollment Help ">
  
    <td>
         <% if(Sectionshelp[0]!=null){%>
         <%=Sectionshelp[0]%> 
         <%}%>
    </td>
    </tr>
         </table>
  <h2>Enrollment
    <a href="#" id="dialog-link1" style="padding-right: 0px;"> <img src="images/help_24.png"/> </a>
  
  </h2>
</div>

<table align="center" border="0" cellpadding="0" cellspacing="0">
 
<tr><td>
                <form name="form" id="form" method="post" action="EnrollServlet">
                    
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
           
                    <table>
                        
                        
                        
                    </table>
                    
                    <div id="step-1">	
            <h2 class="StepTitle">Step 1: Clients Details 
                <a href="#" id="dialog-link2" style="padding-right: 0px;"> <img src="images/help_24.png"/> </a> </h2>
            <table cellspacing="3" cellpadding="3" align="center">
                
                <tr id="dialog2" title="Enrollment Help " >
  
    <td>
         <% if(Sectionshelp[1]!=null){%>
         <%=Sectionshelp[1]%> 
         <%}%>
    </td>
    </tr>
                
          			<tr >
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                  
              
           
                <tr class="d0"><td>Date of Enrollment <font style="color: blue">*</font></td>
                    <td><input type="text" name="DOE" class="datepicker" title="Enter date of Enrollment" id="DOE" required value=""></td>
                    <td></td>
                    <td></td>
                </tr>
                
                <tr class="d1"><td>County <font style="color: blue">*</font> </td><td>
                        
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
          if(conn.state.isClosed()){conn= new dbConnect();}           
         conn.rs = conn.state.executeQuery(QueryDist);
                                
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getString("DistrictID")%>,<%=conn.rs.getString("District")%>'><%=conn.rs.getString("District")%></option>
                                                   <%
                                                      
 System.out.println(conn.rs.getInt("DistrictID"));
                                System.out.println(conn.rs.getString("DistrictID"));                                                      }
                                
                               
//  int firstnumber=0;
//  int secondnumber=1; 
//int total=0;                                                
//for(int i=0;i<=10;i++){
//total=firstnumber+secondnumber;
//System.out.println("nn   "+total);
//firstnumber=secondnumber;
//secondnumber=total;
//}                                                   
%>
                              

                                 </select></td>
                                 <td>DIC Name <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName"  onchange="filter_wards(this);">
                                 <option value="">Choose DIC Name</option>  

                                 </select>
                                     <input type="hidden" value="" name="client_name" id="client_name"></td>
                </tr>
                <tr  class="d0">
               
                         <td>Ward <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="ward"  name="ward" >
                                 <option value="">Choose Ward </option>  

                                 </select></td>
                   
                    
                </tr>
               
                <tr class="d0"><td>Client Initials <font style="color: blue;">*</font></td><td><input class="inputSize" required type="text" name="ClientInit" id="ClientInit" value="" onfocus="return names_pop_up();" ></td>
                    <td>Unique Identifier <font style="color: blue;">*</font></td><td><input type="text" required class="inputSize" name="UniqueID" value="" id="UniqueID"  style="position: relative; width: 200px"></td>
                </tr>
                
                
                
                <tr class="d1"> <td><label for="town">Hand<font color="red">*</font></label></td>
                            <td><select name="capturedhand" required id="capturedhand">
                                    <option value="">used hand</option>
                                    <option value="right hand" title="default hand">right hand</option>
                                    <option value="left hand">left hand</option>
                                    <option value="left and right">both hands</option>
                                </select></td>
               <td><label for="town">Finger captured<font color="red">*</font></label></td>
                            <td><select name="capturedfinger" required id="capturedfinger">
                                    <option value="">Captured Finger</option>
                                    <option value="thumb" > Thumb</option>
                                    <option value="middle">Middle Finger</option>
                                    
                                </select></td>
                                
                </tr>   
                <br/> 
                <tr></tr>
                <tr class="d1"> <td><label for="town">Finger Print.<font color="red">*</font></label></td>
                            <td>   
                            

<!--                    <a href="#" class="button blue" id="capturefp" onclick="return getReader();"  style="background-color:#202020 ;color:white ; height:30px; width:166px;"><b><font color="white">Capture Fingerprint</font></b></a> </section>-->
      <a href="#"  class="btn" title="Ensure the fingerprint scanner device is plugged into a usb port" onclick="capturefingerprint();" class="linkstyle">Capture fingerprint</a>
    
                            </td></tr>
                            
                <tr>
           <p id="msg"><p>
             </table>          			
        </div>
                    <div id="step-2">
            <h2 class="StepTitle">Step 2: Personal Details <a href="#" id="dialog-link3" style="padding-right: 0px;"> <img src="images/help_24.png"/> </a></h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
             <tr id="dialog3" title="Enrollment Help " >
  
    <td>
         <% if(Sectionshelp[2]!=null){%>
         <%=Sectionshelp[2]%> 
         <%}%>
    </td>
    </tr>
               
                <tr class="d1">
                    <td>Date of Birth <font style="color: blue">*</font></td><td><input type="text" required name="DOB" onchange="ageCount();" class="datepickerDOB" id="date" title="Enter date of Birth" value="" ></td>
                <td>Sex <font style="color: blue">*</font></td>
                    <td><select name="Sex" class="inputSize" title="Enter Client's Gender" id="Sex">
                            <option value=""></option>
                                                     <option value="Female">Female</option>
                                                     <option value="Male">Male</option>
                        </select>
                     </td>
                 </tr>
                 <tr class="d0">
                    <td>Client Age <font style="color: blue">*</font></td>
                    <td><input type="text" name="age" id ="age" value="" onclick= "" readonly="readonly" required></td>
                    <td>Marital Status <font style="color: blue">*</font> </td>
                    <td><select name="MaritalStatus" id="MaritalStatus" >
                        <option value=""></option>
                       
               <%
             
                                                      String Query= "SELECT Marital_Status,Marital_StatusID FROM Marital_Status";
                                                      if(conn.state.isClosed()){conn= new dbConnect();}
                                                      conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query);
                                
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("Marital_StatusID")%>'><%=conn.rs.getString("Marital_Status")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("Marital_StatusID"));
                                System.out.println(conn.rs.getString("Marital_Status"));                                                      }
                                
                               
                                                   %>
                                            

</select>
                    </td>               
                    
                    
<!--                     <td>Marital Status <font style="color: red">*</font></td>
                     <td>
                         <select name="MaritalStatus" class="inputSize" required>
                             <option value=""> </option>
                             <option value="Married"> Married</option>
                             <option value="Single"> Single</option>
                             <option value="Widowed"> Widowed</option>
                             <option value="Divorced"> Divorced</option>
                             <option value="Separated"> Separated</option>
                             <option value="Live-in-partners"> Live-in-partners</option>
                         </select>
                      </td>-->
                       
                  </tr>
                
                  <tr class="d1"><td>Do you have Children <font style="color: blue"></font></td>
                      <td><select name="Children" id="Children" class="inputSize" onChange="disableOptions(this.selectedIndex);">
                              <option value=""></option>
                              <option value="Yes">Yes</option>
                              <option value="No">No</option>
                        </select>
                      </td>
                   <td>Area of Residence</td>
                   <td><select name="Residence"> <option value=""></option>
                       
               <%
 String Query1= "SELECT ResidenceArea,ResidenceAreaID FROM ResidenceArea";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query1);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("ResidenceAreaID")%>'><%=conn.rs.getString("ResidenceArea")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("ResidenceAreaID"));
                                System.out.println(conn.rs.getString("ResidenceArea"));                                                      }
                                
                               
                                                   %>
                       </select></td>
                                                   
<!--                   <td><input type="text" name="Residence" class="inputSize" value="" ></td>-->
                  </tr>
                  <tr class="d0">
                      <td>If Yes, how many? </td><td><input type="text"  class="inputSize" onkeypress="return isNumberKey(event)" name="ChildNo" value="" id="ChildNo" ></td>
                  </tr>
                  <tr class="d0">
                      <td>If Yes, what are their ages? </td>
                  </tr>
                  <tr class="d1">
                      <td><input type="checkbox" name="AgeID1" id="Age_9" value="1" onchange="chgAgeNo1();"> 0 - 9 yrs
                      <input type="text" name="AgeNo1" id ="Age_9No" value="" onkeypress="return isNumberKey(event)" placeholder="Enter No of Children" ></td>
                   <td><input type="checkbox" name="AgeID2" id="Age_14" value="2" onchange="chgAgeNo2();"> 10 - 14 yrs
                   <input type="text" name="AgeNo2" id ="Age_14No" value="" onkeypress="return isNumberKey(event)" placeholder="Enter No of Children" ></td></tr>
                  <tr class="d0">  <td><input type="checkbox" id="Age_19" name="AgeID3" value="3" onchange="chgAgeNo3();"> 15-19 yrs
                   <input type="text" name="AgeNo3" id ="Age_19No" value="" onkeypress="return isNumberKey(event)" placeholder="Enter No of Children" ></td>
                   <td><input type="checkbox" name="AgeID4" id="Age_24" value="4" onchange="chgAgeNo4();"> 20 - 24 yrs 
                   <input type="text" name="AgeNo4" id ="Age_24No" value="" onkeypress="return isNumberKey(event)" placeholder="Enter No of Children" ></td></tr>
                  <tr class="d1"> <td></td><td><input type="checkbox" name="AgeID5" id="Age_25" value="5" onchange="chgAgeNo5();"> 25+ yrs
                      <input type="text" name="AgeNo5" id ="Age_25No" value="" onkeypress="return isNumberKey(event)" placeholder="Enter No of Children" ></td></tr>

                  <tr class="d1">
                      <td>Religion <font style="color: blue">*</font></td>
                      <td>
                          <select name="Religion" id="Religion" class="inputSize" onChange="disableOptions1(this.selectedIndex);" >
                              <option value=""></option>
                              <option value="Christian">Christian</option>
                              <option value="Muslim">Muslim</option>
                              <option value="Other" onClick="disable()">Other(Specify)</option>
                           </select>
                          <input type="text" name="Religion1" class="inputSize" id="Religion1" value="" ></td>
                    </tr>
                
                <tr class="d0">
                      <td>Completed Education Level </td>
                      <td>
                          <select name="EducationLevel"  class="inputSize">
                              <option value=""></option> 
                         <%
 String Query2= "SELECT EducationLevel,EducationLevelID FROM educationlevel";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query2);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("EducationLevelID")%>'><%=conn.rs.getString("EducationLevel")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("EducationLevelID"));
                                System.out.println(conn.rs.getString("EducationLevel"));                                                      }
                                
                               
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
            <h2 class="StepTitle">Step 3: Contact Details <a href="#" id="dialog-link4" style="padding-right: 0px;"> <img src="images/help_24.png"/> </a></h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
               <tr id="dialog4" title="Enrollment Help " >
  
    <td>
         <% if(Sectionshelp[3]!=null){%>
         <%=Sectionshelp[3]%> 
         <%}%>
    </td>
    </tr>
                  <tr class="d1">
                      <td>Client Phone # <font style="color: blue"></font></td><td><input type="text" pattern="(07)[0-9]{8}" onkeypress="return numbers(event);" name="PhoneNo" class="inputSize" value="" ></td>
                     
                  </tr>
                  <tr class="d0">
                      <td>Client e-mail address </td><td><input type="text" name="Email" class="inputSize" value="" ></td>
                     
                  </tr>
                  <tr class="d1">
                      <td>Alternative Phone# </td><td><input type="text" pattern="(07)[0-9]{8}" onkeypress="return numbers(event);" name="PhoneNo1" class="inputSize" value=""></td>
                     
                  </tr>
                  <tr class="d0">
                      <td>Client area of Operation  </td></tr>
                  <tr><td><input type="checkbox" name="OperationArea" value="1" id="OperationArea">Naivasha</td>
                      <td><input type="checkbox" name="OperationArea" value="2" id="OperationArea">Gilgil</td></tr>
                  <tr><td><input type="checkbox" name="OperationArea" value="3" id="OperationArea">Nanyuki</td>
                      <td><input type="checkbox" name="OperationArea" value="4" id="OperationArea">Ngong</td></tr>
                  <tr><td><input type="checkbox" name="OperationArea" value="5" id="OperationArea">Narok</td>
                      <td><input type="checkbox" name="OperationArea" value="6" id="OperationArea">Nakuru</td></tr>
                  <tr> <td><input type="checkbox" name="OperationArea" value="7" id="OperationArea">Salgaa</td>
                     <td><input type="checkbox" name="OperationArea" value="8" id="OperationArea">Makutano</td></tr>
                  <tr>  <td><input type="checkbox" name="OperationArea" value="9" id="OperationArea">Others,Specify 
                          <input type="text" name="Others" value="" class="inputSize" id="Others"> </td>
                      
                 
                        
<!--                              <option value="Naivasha">Naivasha</option>
                              <option value="Gilgil">Gilgil</option>
                              <option value="Nanyuki">Nanyuki</option>
                              <option value="Ngong">Ngong</option>
                              <option value="Narok">Narok</option>
                              <option value="Nakuru">Nakuru</option>
                              <option value="Salgaa">Salgaa</option>
                              <option value="Makutano">Makutano</option>
                              <option value="Other">Other(Specify)</option>-->
                              
                              
<!--                          </select>-->
                 

                     <!-- <input type="text" name="Venue" value="" class="inputSize" id="Venue" required>--> 
                     
                 </tr>
       <tr class="d1">
                     <td>Venue </td>
                     <td>
                        <select name="Venue"  class="inputSize" onChange="">
                        <option value=""></option> 
               <%
                            String Query4= "SELECT Venue,VenueID FROM Venue";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query4);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("VenueID")%>'><%=conn.rs.getString("Venue")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("VenueID"));
                                System.out.println(conn.rs.getString("Venue"));                                                      }
                                
                               
                                                   %>
                          </select>
                           <input type="text" name="Venue1" value="" class="inputSize" id="Venue1">
<!--
<option value=""></option>
                              <option value="STREET">STREET</option>
                              <option value="HOME">HOME</option>
                              <option value="TRUCK STOP">TRUCK STOP</option>
                              <option value="SEX DEN">SEX DEN</option>
                              <option value="BAR/Night club">BAR/Night club</option>
                              <option value="ESCORT">ESCORT</option>
                              <option value="MASSAGE PARLOUR">MASSAGE PARLOUR</option>
                              <option value="OTHER">OTHERS(Specify)</option>-->
<!--                              <input type="text" name="Venue1" value="" class="inputSize" id="Venue1">
                           </select></td>-->
                     </td>
                 </tr> 
            </table>
  </div>
                          
                          
                          
  			<div id="step-4">
            <h2 class="StepTitle">Step 4: Other Details <a href="#" id="dialog-link5" style="padding-right: 0px;"> <img src="images/help_24.png"/> </a></h2>	
            <table cellspacing="3" cellpadding="3" align="center">
          			<tr>
                    	<td align="center" colspan="3">&nbsp;</td>
          			</tr>        
                 			        
               <tr id="dialog5" title="Enrollment Help " >
  
    <td>
         <% if(Sectionshelp[4]!=null){%>
         <%=Sectionshelp[4]%> 
         <%}%>
    </td>
               </tr>
                   <tr class="d0">
                      <td>Occupation  </td></tr>
                  <tr><td><input type="checkbox" name="Occupation" value="1" id="Occupation1">Small Business</td>
                      <td><input type="checkbox" name="Occupation" value="2" id="Occupation2">Hawking</td></tr>
                  <tr><td><input type="checkbox" name="Occupation" value="3" id="Occupation3">Farming</td>
                      <td><input type="checkbox" name="Occupation" value="4" id="Occupation4">Artisan(Jua Kali)</td></tr>
                  <tr><td><input type="checkbox" name="Occupation" value="5" id="Occupation5">Formal Employment</td>
                      <td><input type="checkbox" name="Occupation" value="6" id="Occupation6">Sex Work</td></tr>
                  <tr> <td><input type="checkbox" name="Occupation" value="7" id="Occupation7">Casual Laborer</td>
                  <tr> <td><input type="checkbox" name="Occupation" value="8" id="Occupation8">None</td>
                  
                  </tr>
                    
                   
                 <tr class="d0">
                     <td>Are you a member of: 
                 </tr>
                 <tr class="d1">
                     <td align="right">NHIF</td>
                     <td>
                     <select name="member" class="inputSize">
                             <option value=""></option>
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                     </select>
                      </td>
                 </tr>
                 <tr class="d0">
                     <td align="right">NSSF <font style="color: blue"></font></td>
                     <td><select name="member" class="inputSize">
                             <option value=""></option>
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                     </select>
                      </td>
                 </tr>
                 <tr class="d1">
                     <td align="right">MicroFinance Group </td>
                     <td>
                     <select name="member" class="inputSize">
                             <option value=""></option>
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                     </select>
                      </td>
                 </tr>
                 <tr class="d0">
                     <td align="right">Women Group </td>
                     <td>
                     <select name="member" class="inputSize">
                             <option value=""></option>
                             <option value="1">Yes</option>
                             <option value="2">No</option>
                     </select>
                      </td>
                 </tr>
                 
                 <tr class="d1">
                     <td>How client learnt about DIC </td>
                     <td>
                     <select name="DICLearn" class="inputSize" onChange="disableOptions3(this.selectedIndex);">
                          <option value=""></option> 
               <%
                            String Query5= "SELECT ClientLearnt,ClientLearntID FROM clientlearnt";
                              if(conn.state.isClosed()){conn= new dbConnect();}                         
                            conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(Query5);
                               
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getInt("ClientLearntID")%>'><%=conn.rs.getString("ClientLearnt")%></option>
                                                   <%
                                                       
 System.out.println(conn.rs.getInt("ClientLearntID"));
                                System.out.println(conn.rs.getString("ClientLearntID"));                                                      }
                                
                               
                                                   %>
                          </select>
<!--                             <option value=""></option>
                             <option value="Friend">Friend</option>
                             <option value="Peer Educator">Peer Educator</option>
                             <option value="Health Provider">Health Provider</option>
                             <option value="Other">Other(Specify)</option>-->
<!--                     </select>-->
                         <input type="text" name="DICLearn1" value="" class="inputSize" id="DICLearn1" >
                      </td>
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