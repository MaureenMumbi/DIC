<%-- 
    Document   : createSMS
    Created on : Jun 8, 2015, 12:06:33 PM
    Author     : user
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC SMS</title>
        
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
    <script src="../js/jquery-1.7.2.js"></script>
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>
 <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="../js/datepicker.js"></script>
       <script src="../admin/ui/jquery.ui.datepicker.js"></script>
  
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen">
     <script>
	$(function() {
		$( "#dialog" ).dialog({
			autoOpen: false,
			show: {
				effect: "blind",
				duration: 500
			},
			hide: {
				effect: "explode",
				duration: 700
			}
		});

		$( "#opener" ).click(function() {
			$( "#dialog" ).dialog( "open" );
		});
	});
	</script> 
        
         <script type="text/javascript">
// a function that filters the id in the passed county as per the county drop down.
    
function checkCat(){
  
    
    
      var j = document.getElementById("category");
  
   var k = j.options[j.selectedIndex].value;
    alert("category"+k);

    
 var xmlhttp;  
// alert(ids)

   
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
 document.getElementById("msgs_0").innerHTML=xmlhttp.responseText;

}
}


xmlhttp.open("POST","/DIC/getSMSEdit?category="+k,true);

xmlhttp.send();
 //sendMsg() 
  
 } 
 
 function chekBox(){
   if (!anyCheckboxesChecked()) {
     alert("Please select an SMS to Send");
     return false;
   }
   
        }
        
        //toggle messages
        function togglesms(cbid){
        
        if(document.getElementById("msg_"+cbid).checked==true){
                
                document.getElementById("msg_"+cbid).value=document.getElementById("sms_"+cbid).value;
            }
            else{
                
             document.getElementById("sms_"+cbid).value="";    
                
                
            }
            
            
        }
        
 </script>
  <style>
     
     table.viewpdt tr td {
    background: #fafafa none repeat scroll 0 0;
    border-color: #ffffff #e0e0e0 #e0e0e0;
    border-style: solid;
    border-width: 1px;
    padding: 4px;
}
table.viewpdt td {
    border-color: #999999;
    border-style: solid;
    color: black;
    height: 1px;
}
table.viewpdt tr {
    text-align: center;
}
table.viewpdt {
    border-collapse: collapse;
    color: #666;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 16px;
    text-align: center;
    text-shadow: 1px 1px 0 #fff;
}
 </style>

    </head>
    <body>
         

        <div class="example" style="width: 1350px; height: 700px;">
          
    
      <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>   
     
      
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

%>
            
            
        <!--=====================================================================================--> 
            </div>
      
              <% 
 dbConnect conn = new dbConnect();
 //get the helps from the database.


%>

    
    
    <div id="container">
        <table>
        <!--<tr id="dialog1" title="Program Progress Help ">-->
  
    
    <!--</tr>-->
                        </table>   
        
<!--        <h3> Reports <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="../images/help_24.png"/> </a></h3>
       -->
    
    
                <h3 style="text-align: center; background-color: orange;">ADD NEW SMS</h3>
                 
 <!--<h3 style="text-align: center; background-color: orange;">VIEWING DUPLICATES  <img src="images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>-->
                  

    
        <form method="post" action="/DIC/addSMS">
        <table class="viewpdt">

              <tr><td >CATEGORY</td>
                  <td>
                      <select id="category" name="category"  >
                       <option value="">SELECT SMS CATEGORY </option>
                            <option value="general"> General SMS</option>
                            <option value="fp"> No FP method </option>
                            <option value="vct"> HIV+  </option>
                            <option value="nohiv"> No HIV Test</option>
                            <option value="cc"> No CC Screening </option>
                            <option value="sti"> No STI Screening </option>
                    
                        
                    </select></td>
              </tr>
              
              <tr><td>Enter SMS</td><td><textarea id="sms" name="sms" cols="40" rows="5"></textarea></td></tr>


<tr><td><input type="submit" value="submit" name="submit" class="submit" id="submit"  ></td></tr>
            
        </table>
        </form>
     
               
                

                
<!--                <tr><td> <input type="submit"  name="submit" value="View">  </td></tr>
            
        </table>
        </form>-->
      </div>
                          
  
</div>
  
 
 
      
    </body>
</html>



