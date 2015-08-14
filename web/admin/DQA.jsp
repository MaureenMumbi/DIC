<%-- 
    Document   : DQA
    Created on : Nov 10, 2014, 10:54:51 AM
    Author     : Maureen
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC DQA</title>
        
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
    
    
                <h3 style="text-align: center; background-color: orange;">WRONG DATA<img src="../images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>
                 
 <!--<h3 style="text-align: center; background-color: orange;">VIEWING DUPLICATES  <img src="images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>-->
                    <div id="dialog" title="DQA Help." style=" font-size: 17px;">
                        <b>Select the type of DQA Parameters </b></br>
                       <b> Missing Data </b> - Gives data thats missing DICNAME OR  DOE </br>
                        <b>Wrong Date </b> - Gives all dates that have wrong date format  </br>
                       <b>  Date before 2012 </b> - Gives all Date of enrollments before 2012  </br>
                        <b>DOB < 10 </b> - Gives Clients who are aged less than 10 
                    </div></h3>

    
        <form method="post" action="/DIC/DQAMissingData">
        <table>

                <tr class="d0">
                    
                    <td> Select a parameter</td>
                    <td> <select name="type" required="true">
                      <option value=""> </option>
                            <option value="missingdata"> Missing Data </option>
                            <option value="wrongdate"> Wrong Date</option>
                            <option value="less2012"> Dates before 2012</option>
                            <option value="dob">  DOB<10 </option>
                </select>      
                    </td>
                </tr>
                
                
               
                

                
                <tr><td> <input type="submit"  name="submit" value="View">  </td></tr>
            
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