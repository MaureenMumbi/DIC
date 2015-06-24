<%-- 
    Document   : addHIVStatus
    Created on : Jan 27, 2015, 9:20:22 AM
    Author     : Maureen
--%>


<%@page import="java.util.Calendar"%>
<%@page import="dbConnect.dbConnect"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
 dbConnect conn = new dbConnect();
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

//    if (session.getAttribute("Username") == null) {
//        response.sendRedirect("index.jsp");
//    }
%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="css/divCss.css"/>-->
        <link rel="shortcut icon" href="images/dic.png"/>
        <script src="../js/jquery-1.9.1.js"></script>
        <!--<script type="text/javascript" src="js/jquery-1.js"></script>-->
<!--        <script src="scripts/jquery.js" type="text/javascript"></script>  -->
      
        <link href="css/style.css" media="screen" rel="stylesheet" type="text/css" />
          
       <script src="scripts/jquery.dataTables.js" type="text/javascript"></script>
         <script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
         <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
          <script src="scripts/jquery-ui.js" type="text/javascript"></script>
          <script src="scripts/jquery.validate.js" type="text/javascript"></script>
          
          <script src="scripts/dataTables.tableTools.js" type="text/javascript"></script>
          <script src="scripts/jquery.dataTables.columnFilter.js" type="text/javascript"></script>
          
          <link href="media/dataTables/jquery.dataTables.css" rel="stylesheet" type="text/css" />
          <link href="scripts/dataTables.tableTools.css" rel="stylesheet" type="text/css" />
          
        <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="themes/base/jquery.ui.all.css">
               
                   
<link rel="StyleSheet" href="css/main.css" type="text/css" />
 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
  <style type="text/css">
    #container{
                height:600px;
                width:1000px;
/*                 overflow-x: auto;*/
    }
     .example {
    width:1350px;
    height:900px;
    overflow-x: auto; 
     }
    </style>    
        
       
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
        $(document).ready(function () {
         // document.getElementById("loading").innerHTML="<img src='images/loading.gif'>";
       
 
//           $.ajax({  
//                    url:"loadgroups_json",  
//                    type:'post',  
//                    dataType: 'html',  
//                    success: function(data) {
//                   chws=data;
//            
          $("#members").dataTable({
              
             
              
              "dom": 'T<"clear">lfrtip',
        "tableTools": {
            "sSwfPath": "swf/copy_csv_xls_pdf.swf",
            "aButtons": [ {
                    "sExtends": "csv",
                    "sButtonText": "Save to csv"
                },
                {
                    "sExtends": "xls",
                    "sButtonText": "Save to xls"
                },
                {
                    "sExtends": "pdf",
                    "sButtonText": "Save to pdf"
                } ],
             "sRowSelect": "single"
            
        },
              
                "bProcessing": true,
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            }).makeEditable({
//                sUpdateURL: "/DIC/newHIVStatus",            
                 //sDeleteURL: "deletemember"
                 
                 //,
                "aoColumns": [ 
                      
                       null ,
                       null,null
                        ,
                       null
                       
                        ]
            }
            
            ).columnFilter({aoColumns: [{type: "text"},{},{},{},{},{},{},{},{},{} ]});
            
            
// $('#members tbody').on( 'click', 'tr', function () {
//        $(this).toggleClass('selected');
//    } );
              // document.getElementById("loading").innerHTML="";
             // }
                    
                               
        });
         
//        });
        
        </script>
        
       <script src="../js/jquery-ui-1.10.3.custom.js"></script>
 <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="../js/datepicker.js"></script>
       <script src="../admin/ui/jquery.ui.datepicker.js"></script>

        <!--<link rel="stylesheet" href="../js/demos.css" />-->

        <title>HIV Status</title>
    
<script language="javascript" type="text/javascript" >
    
     function editRecord(UniqueID,name){
         
//     alert(UniqueID+"   "+MedicalID);
    var f=document.form;
    f.method="post";
    f.action="/DIC/admin/addStatus.jsp?UniqueID="+UniqueID+"&name="+name+"";
    f.submit();
    
}
function deleteRecord(UniqueID,MedicalID){
    var f=document.form;
    f.method="post";
    f.action="/DIC/addStatus?UniqueID="+UniqueID+","+MedicalID+""; 
    f.submit();
}

</script>

    </head>
    <body>
        
        <div class="example">
          
          
      <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200"/></h1></div>   
           <!--=========================================menu=========================================-->     
              <div style="width:1350px;"> 
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
    
        <div id="container" style="height: 750px">
     
            <br/>
            <h3 style="text-align: center; background-color: orange;">ADD HIV STATUS<img src="../images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>
                 
 <!--<h3 style="text-align: center; background-color: orange;">VIEWING DUPLICATES  <img src="images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>-->
                    


 
                
                
               <div id="demo_jui">
                   <!--<button id="btnDeleteRow" value="cancel">Delete Participant</button>-->
                   
                   
                    <form name="form">
                        
                        
                        
                        <div id="dialog" title="Duplicates Help." style=" font-size: 17px;">


<b>Adding a Clients Status </b>
Search for the Client, then click <b>Add Status</b> button. It will redirect you to a page that allows users to add the required details


                    </div>
		        <table id="members" class="display">
		            <thead>
		            <tr>
		           <th>UNIQUE ID </th>
		           <th>FULL NAME </th>
                          
                           <th>ADD </th>
                                                     </tr>
		                
		            </thead>
		            <tbody>
                             <% 
                     
                                   
String getName="select UPPER(FirstName),UPPER(SecondName), UPPER(LastName), UniqueID from enrollment" ; 
conn.rs4 = conn.state4.executeQuery(getName);
while(conn.rs4.next()){
%>
 <tr id="<%= conn.rs4.getString("UniqueID")%>">       
                                    <td><%= conn.rs4.getString(4)%></td>
                                    
                                    <td>
                                        
                            <%= conn.rs4.getString(1) +"  "+conn.rs4.getString(2)+"  "+ conn.rs4.getString(3)%>

  <%String name="";
     name=  conn.rs4.getString(1)+" "+ conn.rs4.getString(2)+" "+ conn.rs4.getString(3);%>
     
                                    </td>                            
                                    <td><input type="button" name="Edit" value="ADD STATUS"  onclick="editRecord('<%= conn.rs4.getString(4)  %>','<%=name%>')"></td>
                                        </tr>
<%

}
                                                                          
%>
                                    
   
                                   
                               
      
                           
                                     
                                
		            </tbody>
		        </table>
                    </form>        
		    </div>

           
          </div>       
        </div>
    </body>

</html>


