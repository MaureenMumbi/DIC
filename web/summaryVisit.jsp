<%-- 
    Document   : summaryVisit
    Created on : May 16, 2014, 4:13:19 PM
    Author     : Maureen
--%>


<%@page import="dbConnect.dbConnect"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<html><head>
	<title>Summary</title>
		

        <script src="scripts/jquery-1.8.3.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
<!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
<script src="scripts/jquery.validate.js" type="text/javascript"></script>
<link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />

<!--		<script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
                    							"aoColumns": [ null, null,null,null,null,null
//                    									
											]									

										});
				
			} );
		</script>-->

<script>
    
//    function viewRecord(UniqueID){
//    var f=document.form;
//    f.method="post";
//    f.action="/DIC/viewLastVisit?UniqueID="+UniqueID; 
//    f.submit();
//}

</script>
<script>
 //=================load existing data============
            
            
            function viewRecord(UniqueID){
                
                          
                        var Uniqueids= UniqueID; 
//                           $("#view_"+Uniqueids).css();
                             document.getElementById("view_"+Uniqueids).style.display="none";
                             document.getElementById("viewimage"+Uniqueids).style.display="block";

//var viewid="view_"+Uniqueids;
//lert(viewid);
//document.getElementById(viewid).innerHTML= " loading data...<img src='images/utube.gif'></img> " ;
//                  document.getElementById("view").innerHTML="<i style='margin-left: 450px; margin-top: 200px;'> loading data...<img src='images/utube.gif'</i> >";    
                  
                if(Uniqueids!=""){  
//                 alert(Uniqueids);
                 $.ajax({  
                        url:"viewLastVisit?UniqueID="+Uniqueids ,  
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                    
                            document.getElementById("demo").innerHTML=data.example;
                          
                          
                      
                       
                        
                        }}); 
                
                }//end of if
                
               
                
            }
              function LoadRecord(){
            var dicname= document.getElementById("DICName").value;
            document.getElementById("loading").innerHTML=" loading data...<img src='images/utube.gif'>";
           $.ajax({  
               
                           url:"visitSummary?DICName="+dicname ,  
                            type:'post',  
                            dataType: 'html',  
                            success: function(data) {
//                                 alert(data);
                     
        document.getElementById("example").innerHTML=data;
            document.getElementById("loading").innerHTML=" ";
//                         $('#example').html=data;
//                  var table=  $('#example').dataTable();
      
 
               var table=$('#example').dataTable( {
                   destroy: true
                    } );
                  table.destroy();
                table= $('#example').dataTable( {
                    paging:true
                } );

//                 table=  $('#example').dataTable();
                        
                        }});  }

        
     
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
	<link rel="StyleSheet" href="css/main.css" type="text/css" />
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
     #container{
                height:700px;
                width:700px; 
    }
     .example {
  
    height:1000px;
     width:1350px; 
     }
    </style>
    </head>
	 <body id="dt_example">
         

<div class="example">
                   <div class="login">
            
     <%
              
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

    

		<div id="container">
		
			<div id="demo">
                            <table>
  <tr class="d1"><td>County <font style="color: blue">*</font> </td><td>
<!--                        //gets the districts as stored in db and dispaly them in a drop down-->
                        <select onchange="filter_districts(this);" required name="district" id="district">
  <%
             dbConnect conn = new dbConnect();
             
                                                      String QueryDist= "SELECT District,DistrictID FROM districts";
                                                    if(conn.state.isClosed()){conn= new dbConnect();}
				conn.rs = conn.state.executeQuery(QueryDist);
                               
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
                                     <select id="DICName"  name="DICName" required onchange="LoadRecord()">
                                 <option value="">Choose DIC Name</option>  

                                 </select> </td>
                </tr> 
                            </table>
                            <form name="form">
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
<tr> 
<th>UniqueID</th>
<th>Full Name</th>
<th>Client Initials</th>
<th>DIC Name</th>
<th>DOA</th>
<th>RR</th>
<th>RR</th>
<th>LAST VISIT</th>
</tr>
</thead>
<tbody>
    
    <i style="margin-left: 450px; margin-top: 200px;" id="loading"> </i>
                         
<!--</tbody>-->
	
</table>
                                
                                
                                
                            </form>
                            
			</div>
                    
                    
                    <div id="assess"></div>
			<div class="spacer"></div>

			
			

			
                </div>
</div>
			
		
    
    
    
    

	</body>


</html>

