<%-- 
    Document   : filterDiary
    Created on : Feb 23, 2015, 8:36:48 AM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC APPOINTMENTS </title>
        
        <link rel="stylesheet" type="text/css" href="js/jquery-ui.css"/>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>

      <script type="text/javascript" src="js/DICHelp.js"></script>  

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
        <script type="text/javascript" src="js/DICHelp.js"></script> 

        <link rel="StyleSheet" href="main.css" type="text/css" />
          

        <style type="text/css">
    #container{
                height:500px;
                width:900px; 
    }
    
    </style>
    <script src="js/jquery-1.7.2.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="js/datepicker.js"></script>
       <script src="ui/jquery.ui.datepicker.js"></script>
       

       
	 <script>	
                $(function() {
        $( ".datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true
                               
                        });
                    
                });
            </script>
  
  
    <script type="text/javascript">
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
</script>
  
    
    
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    </head>
    <body>
         
         

        <div class="example" style="width: 1350px; height: 700px;">
          
    
      <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
     
      
    <div style="width:1350px;"> 
                     <%
if(session.getAttribute("AccessLevel")!=null){            

if (session.getAttribute("AccessLevel").equals("2")) {%>
            <%@include file="menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="/menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="/menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>
      
              <% 
 dbConnect conn = new dbConnect();
 //get the helps from the database.
 
 String Sectionshelp[]=new String [25];
int mcount=0;
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
        
        <h3>  <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="images/help_24.png"/> </a></h3>
       <%
 
                            if ( session.getAttribute("duplicated") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("duplicated")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("duplicated");
                            }

                        %>
        <form method="post" action="/DIC/Appointments">
        <table>

 
      
                <tr class="d1"> <td>Date to start </td><td><input type="text" name="selecteddate" id="startdate" class="datepicker" value="" required ="true"></td>
               


                             
                
                <tr class="d1"><td>County <font style="color: blue">*</font> </td><td>
<!--                        //gets the districts as stored in db and dispaly them in a drop down-->
                        <select onchange="filter_districts(this);" required name="district" id="district">
  <%
             
                                                      String QueryDist= "SELECT District,DistrictID FROM districts";
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryDist);
                                 if(conn.state.isClosed()){conn= new dbConnect();}
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value='<%=conn.rs.getString("DistrictID")%>,<%=conn.rs.getString("District")%>'><%=conn.rs.getString("District")%></option>
                                                   <%
                                                      
 System.out.println(conn.rs.getInt("DistrictID"));
                                System.out.println(conn.rs.getString("DistrictID"));                                                      }
                                
                               
                                                   %>
                                

                                 </select></td>
                                 <td>DIC Name <font style="color: blue">*</font></td>
                                 <td>
                                 <select id="DICName"  name="DICName" required>
                                 <option value="">Choose DIC Name</option>  

                                 </select> <input type="hidden" value="" name="client_name" id="client_name"></td>
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