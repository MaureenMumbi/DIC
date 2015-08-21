<%-- 
    Document   : DQAMissingData
    Created on : Nov 10, 2014, 7:52:09 AM
    Author     : Maureen
--%>


<%@page import="java.util.Calendar"%>
<%@page import="dbConnect.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
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
        <script src="../js/jquery-1.7.2.js"></script>
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
                sUpdateURL: "newupdatemember",            
                 sDeleteURL: "deletemember"
                 
                 ,
                "aoColumns": [ 
                      
                       null ,
                       null
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

        <title>Missing Data</title>
    
<script language="javascript" type="text/javascript" >
    
     function editRecord(UniqueID){
              
    var f=document.form;
    f.method="post";
    f.action="/DIC/WorkerServlet?UniqueID='"+UniqueID+"'";
    window.open("/DIC/WorkerServlet?UniqueID='"+UniqueID+"'",'_blank')
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
    
        <div id="container" style="height: 750px">
     
            <br/>
            <h3 style="text-align: center; background-color: orange;">MISSING DATA<img src="../images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>
                 
 <!--<h3 style="text-align: center; background-color: orange;">VIEWING DUPLICATES  <img src="images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>-->
                    <div id="dialog" title="Duplicates Help." style=" font-size: 17px;">


<br/> <b>Searching a client</b><br/>
To search a certain client type either of their details i.e Unique ID , first name, middle name ,DICName e.t.c in the search field shown . 


<br/><br/>
<b>Edit Client Details</b>
To edit a wrong data entry on the edit for the unique id you need to edit, It will open a new tab that will allows users to edit. the clients details
<br><b>Sorting columns</b>
To sort any column, click at any table column header 

                    </div></h3>


 
                
                
               <div id="demo_jui">
                   <!--<button id="btnDeleteRow" value="cancel">Delete Participant</button>-->
                    <form name="form">
		        <table id="members" class="display">
		            <thead>
		            <tr>
		           <th>UNIQUE ID </th>
                           <th>DIC NAME</th>
                           
                           <% if(session.getAttribute("type")!=null){
                               
    System.out.println("aaa"+session.getAttribute("type"));%>
                           <% if(session.getAttribute("type").equals("dob")){%>
                           <th> DOB </th>
                           
                        <%   } else {%>
                         <th> DOE </th>
                           <%
                                 }                   }
%>
                          
<th>EDIT </th>
                            </tr>
		                
		            </thead>
		            <tbody>
                                
                                 <c:forEach items="${missingdata}" var="data">
                            

                           <tr id="${data.UNIQUEID}">
                                    <td>${data.UNIQUEID}</td>
                                    <td>${data.DICNAME}</td>
                                    <td>${data.DOE}</td>
                                    <td><a href=""  style="background-color: #E0E0E0; height: 12px; width:20px; font-size: 14px; " onclick="editRecord('${data.UNIQUEID}')">Edit</a>   </td>
                                   
                            </tr>
                                        </c:forEach>

                                
		            </tbody>
		        </table>
                    </form>        
		    </div>

           
          </div>       
        </div>
    </body>

</html>

