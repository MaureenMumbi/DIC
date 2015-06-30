<%-- 
    Document   : CondomCode
    Created on : Aug 20, 2013, 5:04:02 PM
    Author     : Maureen
--%>


<%@page import="dbConnect.dbConnect"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %> 

<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%! HttpSession session;
String username="";
   %>

<html><head>
	<title>Enrollments</title>
		

        <!--<script src="scripts/jquery-2.0.0.min.js" type="text/javascript"></script>-->
   
        <script src="scripts/jquery-1.7.2.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
      
            <script src="scripts/jquery-ui.js" type="text/javascript"></script>
            <script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
            <script src="scripts/jquery.validate.js" type="text/javascript"></script>

        <link href="../media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="../media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="../media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="../media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
    
     

 <script language="javascript" type="text/javascript" >
    
     function editRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/WorkerServlet?UniqueID='"+UniqueID+"'";
    window.open("/DIC/WorkerServlet?UniqueID='"+UniqueID+"'",'_blank')
    f.submit();
    
}
function deleteRecord(UniqueID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
    f.submit();
}

</script>
<script type="text/javascript">
               
//                jQuery(document).ready(function() {   
            function loaddata(){
//           document.getElementById("loading").innerHTML="<img src='images/loading.gif'>"; 

            var type=document.getElementById("DICName").value;
        
             $.ajax({
                    url:"../getData?type="+type,
                    type:'post',
                    dataType:'html',
                    success:function (data){
//                       alert("enetered"); 
                      window.location.reload();
//                            $("#example").html(data);

                
                    }
                    
                    
                    
                });
            
            } 
//            });
</script>
    
<script>
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
               <script src="jquery.dataTables.js" type="text/javascript"></script>
               <script>
		
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                        "bPaginate": true,
                        "bLengthChange": true,
                        "bFilter": true,
                        "bSort": true,
                        "bInfo": true,
                        "bAutoWidth": true,
                     "aoColumns": [
                                        null,
                                        null,null,
                                                                                      {   
                                                                                          
                                                                                          data: function (value, setting) {
                                                                                              return " {'3':'M&E','4':'Clinical','6':'CU','7':'OVC','8':'HC','9':'SDH', 'selected':'" + value.trim() + "'}"
                                                                                          }
                                                                                          ,                                                                                          
                                                                                                id         : 'cellid',
                                                                                                name       : 'cellvalue',
                                                                                                event      : 'dblclick',
                                                                                                tooltip     : 'Double click to edit...',
                                                                                                placeholder  : '<b style="color:#AAA">Edit</b>',
                                                                                                submitdata   : function(value, setting) {
                                                                                                  var array_val = new Array();
                                                                                                  //array_val['id'] = "1";
                                                                                                  var values = $(this).find('select').val();
                                                                                                  array_val['cellvalue'] = values.join();
                                                                                                  return array_val;
                                                                                                },
                                                                                                type       : 'select',
                                                                                                style    : 'display: inline',
                                                                                                submit     : 'Save',
                                                                                                onblur     : 'ignore',
                                                                                                cancel     : 'Cancel',
                                                                                             callback : function(value, settings)
                                                                                                                        { 
//                                                                                                                           alert(""+value);
                                                                                                                            window.location.reload();
                                                                                                                        
                                                                                                                        }
                                                                                                                        ,
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                                                                                            
                                                                                        
                                                                                    } //put as many null values as your columns

                    ]									

										});
				
			} );
                        
                        
                          
     function editRecord(UniqueID,ward){
//     var ward=document.getElementById("ward").value;
        alert(ward.value);
        
             $.ajax({
                    url:"../addWard?UniqueID="+UniqueID+"&ward="+ward.value,
                    type:'post',
                    dataType:'html',
                    success:function (data){
//                       alert("enetered"); 
//                        window.location.reload();
//                            $("#example").html(data);

                
                    }
                 
});
}
    

		</script>    
       

<link rel="StyleSheet" href="css/main.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
   #container{
                height:500px;
                width:1200px; 
    }
     .example {
    width:1350px;
    height:900px;
     }
    </style>
    </head>
	 <body id="dt_example">
         

<div class="example">
            <div class="login">
      <% 
          if(session.getAttribute("Username")!=null){
        String username=(String)session.getAttribute("Username");
      %>
          
       <a class="button-1" href="../DIC/logoutServlet">LogOut</a>          
     <h5>Welcome <%=username%></h5>
     <% }else{
//               response.sendRedirect("/DIC/index.jsp");
              }
     %>
           </div>
             <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
   
       <!--=========================================menu=========================================-->     
              <div style="width:1550px;"> 
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
    
    
    
		<div id="container">
		
			<div id="demo">
<!--  <button id="btnAddNewRow" value="Ok">Add new code...</button> 
  <button id="btnDeleteRow" value="cancel">Delete selected code</button>-->
<!--    <form name="form">
        -->
        
         <br/>
         <h3 style="text-align: center; background-color: orange;"> Edit Wards  </h3>



            <div id="header">
                <h3>SELECT COUNTY AND DIC NAME</h3>
                
            <form style="width:980px;margin-left: 100px;" name="form" >
                   
                    <table  class="table_form1" style="width:880px; height:50px;" >




                          
                            
            
                            
      <tr> <td>County</td> <td> <select onchange="filter_districts(this);" name="district" id="district" >
                                    <option value="" >Select County</option>
                                   <%
             dbConnect conn = new dbConnect();
                                               
                                   
  String Location="";
              if(session.getAttribute("Location")!=null){
 Location=session.getAttribute("Location").toString();
 }
  
   String QueryDist="";
                                                if(Location.equalsIgnoreCase("Naivasha")){    
                                                     QueryDist= "SELECT District,DistrictID FROM districts where DistrictID='3'";
                                                   
                                                }
     else{
          QueryDist= "SELECT District,DistrictID FROM districts where DistrictID!='1' and DistrictID!='5'";
                                                 
     }

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
                                 <select id="DICName"  name="DICName"  onchange="loaddata();">
                                 <option value="">Choose DIC Name</option>  

                                 </select>
                              
</tr>
                         


  
                    </table>
                </form>
            </div>


 
       



        
     <!--<p id="msg" style="color:red; font-size:15px;"><p>-->
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
    <thead>
    <th>UNIQUEID</th>
<%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%>  <th>FULLNAME</th><%}}%>
   <th>DICNAME</th>
    <th>WARD</th>
<!--    <th>Current</th>-->
</thead>  
<tbody>
        
                                 <c:forEach items="${warddata}" var="alldata">
                            <c:set var="fname" value="fname"></c:set>
                        <c:set var="DICNAME"  value="${alldata.DICNAME}"></c:set>
                        <c:set var="WARD"  value="${alldata.WARD}"></c:set>
                                <tr id="${alldata.UNIQUEID}">
                                     <td>${alldata.UNIQUEID}</td>                                     
<%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> <td>${alldata.FULLNAME}</td><%}}%>
                                    <td>${alldata.DICNAME}</td>
                                      <td><select id="ward" onchange="editRecord('${alldata.UNIQUEID}',this)"> 
                                              <option value=""></option>
                                              
                                   <%
                                   ArrayList wards=new ArrayList();
                                  if(wards!=null && wards.size()>0 ){wards.clear();}
                                   String getWards="select * from wards where subcounty='"+pageContext.getAttribute("DICNAME")+"'";
  conn.rs2= conn.state2.executeQuery(getWards);
  while(conn.rs2.next()){
  wards.add(conn.rs2.getString("ward"));
 
   }
                                
  for(int i=0;i<wards.size();i++){
//      System.out.println("mmm   "+wards+"   "+pageContext.getAttribute("WARD"));
if(wards.get(i).equals(pageContext.getAttribute("WARD"))){
    System.out.println("sele "+wards.get(i)+"       "+pageContext.getAttribute("WARD"));
%>
  
                                
                            <option selected value="<%=wards.get(i)%>"><%=wards.get(i)%></option>
                           <%     }
   else{
//  System.out.println(" "+wards.get(i));
%> 
        <option  value="<%=wards.get(i)%>"><%=wards.get(i)%></option>
   <%}}%>
                                </select></td>
                              
                            </tr>
                        </c:forEach>
       

                                
		            </tbody>	
</table>
    <!--</form>-->
			</div>
			<div class="spacer"></div>

			
			

			
			
			
		</div>
    
    </div>
    
    
  

	</body>
       
               
         
             
    
<!--</script>-->
</html>
