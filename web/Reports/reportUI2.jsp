<%-- 
    Document   : reportUI
    Created on : Nov 26, 2013, 9:21:06 AM
    Author     : Maureen
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC REPORTS</title>
        
        <link rel="stylesheet" type="text/css" href="../js/jquery-ui.css"/>
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.js"></script>
    <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="../js/DICHelp.js"></script>  

<script type="text/javascript" src="../js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="../js/noty/layouts/top.js"></script>
<script type="text/javascript" src="../js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="../js/noty/themes/default.js"></script>
        <script type="text/javascript" src="../js/DICHelp.js"></script> 

        <link rel="StyleSheet" href="../main.css" type="text/css" />
          

        <style type="text/css">
    #container{
                height:500px;
                width:900px; 
    }
    
    </style>
    
    
<!--    <script type="text/javascript">
// a function that filters the districts in the passed county as per the county drop down.

function filter_districts(DICName){
 
     
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


}//end of filter districts
</script> -->
    <script type="text/javascript">
            function select_parameter(){
                
             
                var parameter=document.getElementById("parameter").value;
                   alert(parameter);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(parameter!=""){
    document.getElementById("quarter").innerHTML="<option value=\"\">Select Quarter</option><option value=\"Q1\">Oct-Dec </option><option value=\"Q2\">Jan-March</option><option value=\"Q3\">April-June</option><option value=\"Q4\">July-Sept</option>>";
    document.getElementById("year").innerHTML="<option value=\"\">Select Year</option><option value=\"2011\">2011</option><option value=\"2012\">2012</option><option value=\"2013\">2013</option><option value=\"2014\">2014</option>>";
    document.getElementById("semi-annual").innerHTML="<option value=\"\">Select Half</option><option value=\"Half-1\">Oct-March</option><option value=\"Half-2\">April-Sept</option>>";
 document.getElementById("year").disabled=false;                
 document.getElementById("quarter").disabled=false;                
 document.getElementById("semi-annual").disabled=false;                
}   
       if(parameter=="")     {
 document.getElementById("year").disabled=true;                
 document.getElementById("quarter").disabled=true;                
 document.getElementById("semi-annual").disabled=true;              
            }
}
        </script> 
    <script type="text/javascript">
            function changeyear(){
                
             
                var year=document.getElementById("year").value;
                   alert(year);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(year!=""){
            
 document.getElementById("quarter").disabled=true;                
 document.getElementById("semi-annual").disabled=true;                
}   
       if(year=="")     {
                
 document.getElementById("quarter").disabled=false;                
 document.getElementById("semi-annual").disabled=false;              
            }
}
        </script> 
    <script type="text/javascript">
            function changequarter(){
                
             
                var quarter=document.getElementById("quarter").value;
                   alert(quarter);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(quarter!=""){
            
// document.getElementById("year").disabled=true;                
 document.getElementById("semi-annual").disabled=true;                
}   
       if(quarter=="")     {
                
// document.getElementById("year").disabled=false;                
 document.getElementById("semi-annual").disabled=false;              
            }
}
        </script> 
    <script type="text/javascript">
            function changesemi(){
                
             
                var semiannual=document.getElementById("semi-annual").value;
                   alert(semiannual);
//                var quarter=document.getElementById("quarter").value;
//alert("previous year : "+prev_year)
if(semiannual!=""){
            
// document.getElementById("year").disabled=true;                
 document.getElementById("quarter").disabled=true;                
}   
       if(semiannual=="")     {
                
// document.getElementById("year").disabled=false;                
 document.getElementById("quarter").disabled=false;              
            }
}
        </script> 
    
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen">
    </head>
    <body>
         

        <div class="example" style="width: 1350px; height: 700px;">
          
    
      <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>   
     
      
      <div style="width:1350px;"> 
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

    
    
    <div id="container">
        <table>
        <tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[20]!=null){%>
         <%=Sectionshelp[20]%> 
         <%}%>
    </td>
    </tr>
                        </table>   
    <h3>RISK REDUCTION REPORT</h3>
        <h4> Reports <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="../images/help_24.png"/> </a></h4>
       
        <form method="post" action="/DIC/NumberOfEnrollments">
        <table>
<!--            <tr class="d0"><td>County <font style="color: blue">*</font> </td><td>
                        //gets the districts as stored in db and dispaly them in a drop down
                        <select onchange="filter_districts(this);" name="district" id="district">
                            <option value=""></option>
                            <option value="all countys">All Countys </option>
  <%
             
                                                      String QueryDist= "SELECT District,DistrictID FROM districts";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryDist);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getString("DistrictID")%>,<%=conn.rs.getString("District")%>'><%=conn.rs.getString("District")%></option>
                                                   <%
                                                      
                                                       }
                                
                               
                                                   %>
 </select></td>
                                 <td>DIC Name <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName">
                                 <option value="">Choose DIC Name</option>  
                                 <option value="all">All DICs</option>  
                                

                                 </select></td>-->
<!--                </tr>-->
            
                <tr class="d1">
                    
                    <td>Select a Parameter</td>
                    <td>
                        <select name="parameter" id="parameter" onchange="return select_parameter();">
                            <option value=""> </option>
                            <option value="No of Enrollment"> No. of Enrollments</option>
                            <option value="No of Risk Assessment"> No of Risk Assessment Done</option>
                            <option value="No of Risk Reductions"> No of Risk Reductions</option>
<!--                            <option value="Risk Assessments"> Risk Assessment Questions</option>
                            <option value="Risk Reductions">Risk Reduction Questions</option>-->
                          
                            
                            
                            
                        </select>
                        
                       
                        
                    </td></tr>
                
                <tr class="d0">
                    <td>Year</td>
                    <td><select name="year" id="year"  disabled="true">
                            <option value="">Choose an Year</option> 
                            <option value="2010">2010</option> 
                            <option value="2011">2011</option> 
                            <option value="2012">2012</option> 
                            <option value="2013">2013</option> 
                            <option value="2014">2014</option> 
                           
                        </select></td>
                </tr>
                <tr class="d1">
                    <td>Quarter</td>
                    <td><select name="quarter" id="quarter" onchange="return changequarter(); "disabled="true">
                            <option value=""></option> 
                            <option value="Q1">Oct- Dec</option> 
                            <option value="Q2">Jan-March</option> 
                            <option value="Q3">April-June</option> 
                            <option value="Q4">July-Sept</option> 
                           
                        </select>
                    </td>
                </tr>
                <tr class="d1">
                    <td>Semi Annual</td>
                    <td><select name="semi-annual" id="semi-annual" onchange="return changesemi();" disabled="true">
                            <option value=""></option> 
                            <option value="Half1">Oct-March</option> 
                            <option value="Half2">April-Sept</option> 
                         </select>
                    </td>
                </tr>
                
                
                <tr><td> <input type="submit"  name="submit" value="Generate Report">  </td></tr>
            
        </table>
        </form>
      </div>
                          
  
</div>
  
 
 
      
    </body>
</html>

