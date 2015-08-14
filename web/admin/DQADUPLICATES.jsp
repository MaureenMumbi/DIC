<%-- 
    Document   : DQADUPLICATES
    Created on : Nov 10, 2014, 12:39:38 PM
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

//    if (session.getAttribute("userid") == null) {
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
        
        
                   
        <script type="text/javascript">
        $(document).ready(function () {
       
       
 
//           $.ajax({  
//                    url:"loadgroups_json",  
//                    type:'post',  
//                    dataType: 'html',  
//                    success: function(data) {
//                   chws=data;
//            
//          var table= 
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
                 sDeleteURL: "/DIC/DeleteDuplicates"
                 
                 ,
                "aoColumns": [ null,null,null
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

<!--        <link rel="stylesheet" href="js/demos.css" />-->

        <title>DUPLICATES</title>
        <script type="text/javascript">
            function filter_phoneno(schl){
               
                // var dist=school.value;    
                var school=schl.value;     
                var xmlhttp;    
                if (school=="")
                {
                    //filter the districts    
      
      
  
                    document.getElementById("p_id").innerHTML="<option value=\"\"></option>";
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
                        document.getElementById("p_id").innerHTML=xmlhttp.responseText;
                        filter_nhfs(dist);
                    }
                }
                xmlhttp.open("POST","phonenochooser?school_id="+school,true);
                xmlhttp.send();    
            
            } 
            
            function nullness() {
                var sname,sid,phoneno;
                sname=document.getElementById("sname").value;
                var fname=document.getElementById("fname").value;
                var mname=document.getElementById("mname").value;
                sid=document.getElementById("s_id").value;
                phoneno=document.getElementById("p_id").value;
                if(sname=="" && sid=="" && phoneno==""&&mname==""&&fname==""){
            
                    alert("Choose At least one category");  
            
                    return false;  
                }
          
            }   
            function getNames(){
                //  alert("called");
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
                        document.getElementById("allnames").innerHTML=xmlhttp.responseText;
     
                    }
                }
                xmlhttp.open("POST","member_names_chooser",true);
                xmlhttp.send();   
          
            }
            function editmember(UniqueID){
                
                
                //alert(names);
                
                
                $.ajax({
                    
//                      f.action="/DIC/deleteWorker?UniqueID="+UniqueID; 
                    url:"deleteWorker?UniqueID="+UniqueID,
                    type:'post',
                    dataType:'html',
                    success:function (data){
                        
                            
                                    
                                    
                
                    }
                    
                    
                    
                });
                
            }
            
            
            
            
            function loaddata(){
                                     document.getElementById("loading").innerHTML="<img src='images/loading.gif'>"; 

            var type=document.getElementById("s_id").value;
            var startdate1= document.getElementById("startdate").value;
            var enddate1= document.getElementById("enddate").value;
             $.ajax({
                    url:"../getDuplicates?type="+type+"&startdate="+startdate1+"&enddate="+enddate1,
                    type:'post',
                    dataType:'html',
                    success:function (data){
                        window.location.reload();
                        
//                             var n = noty({text: "<font color='green'>data loaded..</font>",
//                                         layout: 'center',
//                                           type: 'Success', 
//                                        timeout: 1800,
//                                       callback:{
//                                            afterShow:function(){
//                                               // window.location.reload();
//                                                  //var win=window.open("geMemDetails",'_self');
//                                                    //win.focus();
//                                              },
//                                           afterClose:function(){           
//                                               //window.close("edit_member.jsp");
//                                           } 
//                                             
//                                                   
//                                      }
//                                 });                                    
                                    
                
                    }
                    
                    
                    
                });
            
            }
            
            
            
        </script>
 
	<script src="../js/jquery-ui-1.10.3.custom.js"></script>
 <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
       <script src="../js/datepicker.js"></script>
       <script src="../admin/ui/jquery.ui.datepicker.js"></script>
       

       
	 <script>	
                $(function() {
        $( ".datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true
                               
                        });
                    
                });
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
              <h3 style="text-align: center; background-color: orange;">VIEWING DUPLICATES  <img src="images/help_24.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4>
                    <div id="dialog" title="Duplicates Help." style=" font-size: 17px;">
Select the data you need by specifying the date <b>From</b> and date <b>TO</b> <br/>
Then select the data combination you need i.e If u want duplicates according to the
Select the data you need by specifying the date <b>From</b> and date <b>TO</b>
<br/>Then select the data combination you need to show duplicates based on. They can be either:
<br/><b>1) Full names + DOB</b>, 
<br/><b>2) Full Names +  DICName</b>  
<br/><b>3) Full Names + DOB + DICName </b>
<br/> This is to avoid slowing down the system.<br/>

<br/> <b>Searching a client</b><br/>
To search a certain client type either of their details i.e Unique ID , first name, middle name ,DICName e.t.c in the search field shown . 


<br/><br/>
<b>Delete Client Details</b>
To delete  a duplicate entry click on the row of the entry you need to delete once highlighted click click the <b>Delete Client</b> button to delete her.
<br><br/>Sorting columns</br>
To sort any column, click at any table column header 

                    </div></h3>


            <div id="header">
                <h3>SELECT THE DATE RANGE AND TYPE OF DATA COMBINATION YOU NEED</h3>
                
            <form style="width:980px;margin-left: 100px;"  >
                   
                    <table  class="table_form1" style="width:980px; height:50px;" >




                          
                            
      <tr> <td>From</td><td><input type="text" name="startdate" id="startdate" class="datepicker" value="" required ="true"></td>
                <td>To</td><td><input type="text" name="enddate" id="enddate" class="datepicker" value="" required ="true"></td></tr>
              
                            
      <tr> <td>Data Combination</td> <td> <select  id="s_id" name="type" class="textbox2" onchange="loaddata();">
                                    <option value="" selected="true">Select combinations</option>
                                    <option value="fullname">Full Names + DOE + DIC NAME</option>
                                    <option value="fullnamedicdob">Full Names + DOB + DIC NAME</option>
                                    <option value="fullnamedob">Full Name + DOB </option>
                                    <option value="fullnamedic">Full Name + DIC NAME</option>
                                  
                                  
                                    
                                </select></td> 
                                <td>                  <button id="btnDeleteRow" value="cancel">Delete Client </button>            
</td>
</tr>
                         



<!--                            <td colspan="2">  <input type="submit"  name="sub"  value="Search..." class="submit"/>   </td>  -->


                        </tr>     
                    </table>
                </form>
            </div>



       





      
                
               <div id="demo_jui">
                  
                    <%   if(session.getAttribute("type")!=null){
                        if(session.getAttribute("type").equals("fullname")){
                        %>
                         <h4>DATA COMBINATION: FULL NAME+ DICNAME + DOE</h4>
                       <%
                                          } 
                        if(session.getAttribute("type").equals("fullnamedic")){%>
                         <h4>DATA COMBINATION: FULL NAME+ DICNAME </h4>
                       <% 
                        }
                           if(session.getAttribute("type").equals("fullnamedob")){%>
                             <h4>DATA COMBINATION: FULL NAME+ DOE </h4>  
                        <%
 }
                           if(session.getAttribute("type").equals("fullnamedicdob")){%>
                             <h4>DATA COMBINATION: FULL NAME+ DOB +DICNAME </h4>  
                        <%
 }



}
%>
    
                   <p id="loading"></p>
               
		        <table id="members" class="display">
		            <thead>
		            <tr>
		          
                           <th>UNIQUE ID </th>
                           <th>DIC NAME</th>
                           
                          <% if(session.getAttribute("type")!=null){
        if( session.getAttribute("type").equals("fullnamedob") || session.getAttribute("type").equals("fullnamedicdob")) {%>
           <th> DOB</th>
                           <%
        } else{%>
         <th> DOE</th>
                           <%  }              
}%>
                          
                           <!--<th>UNIQUE KEY </th>-->
                           
                           
                             <%if(session.getAttribute("lockNames")==null){%><%} else{if(session.getAttribute("lockNames").toString().equals("YES")){}else{%> <th>FIRST NAME</th>
                           <th>MIDDLE NAME</th>
                           <th>LAST NAME</th><%}}%>

                           
                        
                                                  
                         
                            </tr>
		                
		            </thead>
		            <tbody>
                                
                                 <c:forEach items="${missingdata}" var="alldata">
                            <c:set var="fname" value="fname"></c:set>

                                <tr id="${alldata.UNIQUEID}">
                                    <td>${alldata.UNIQUEID}</td>
                                    <td>${alldata.DICNAME}</td>
                                    <td>${alldata.DOE}</td>
                                    <!--<td>${alldata.UNIQUEKEY}</td>--> 
                                    
                                    <%if(session.getAttribute("lockNames")==null){%><%} else
                                    {if(session.getAttribute("lockNames").toString().equals("YES")){}
                    else{%>    <td>${alldata.FIRSTNAME}</td>                               
                                    <td>${alldata.SECONDNAME}</td>
                                    <td>${alldata.LASTNAME}</td>
                           
                           <%}}%>
                                 
                                   
                            </tr>
                        </c:forEach>

                                
		            </tbody>
		        </table>
                                
		    </div>

           
                
        </div>
    </body>

</html>

