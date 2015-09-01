<%-- 
    Document   : index
    Created on : Aug 5, 2013, 9:03:18 PM
    Author     : SIXTYFOURBIT
--%>

<%@page import="dbConnect.dbConnect"%>
<%@page import="java.util.Calendar"%>
<%!
dbConnect conn = new dbConnect();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Audit</title>
         <link rel="stylesheet" type="text/css" href="js/jquery-ui.css"/>
            <link rel="StyleSheet" href="main.css" type="text/css" />
         <script src="js/jquery-1.7.2.js"></script>
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
        
        
<!--         <script type="text/javascript" src="js/jquery-ui.js"></script>
         <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
         <script src="js/jquery-ui-1.10.3.custom.js"></script>
         <script type="text/javascript" src="js/DICHelp.js"></script>  
         <script type="text/javascript" src="js/noty/jquery.noty.js"></script>
         <script type="text/javascript" src="js/noty/layouts/top.js"></script>
         <script type="text/javascript" src="js/noty/layouts/center.js"></script>
          You can add more layouts if you want 
         <script type="text/javascript" src="js/noty/themes/default.js"></script>
         <link rel="StyleSheet" href="main.css" type="text/css" />
                 <link rel="StyleSheet" href="css/geff_css.css" type="text/css" />
        
         <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
       <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
         <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
         <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <script src="media/js/jquery-ui.js" type="text/javascript"></script>
   <script src="media/js/jquery.validate.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
        <script src="scripts/jquery.validate.js" type="text/javascript"></script>
        <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />-->

		<script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
									
                                                                        sUpdateURL: "UpdateCondomCode",
                                                                        sAddURL: "AddCondomCode",
                                                                        sDeleteURL: "DeleteCondomCode",
                    							"aoColumns": [ null,                  									
                    									
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving...',
                                                            					tooltip: 'Click to edit ',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									}
//                    									
											]									

										});
				
			} );
		</script>
    </head>
    <body>
    <!-- Body page -->
    
       <div class="example " style=" width:1350px; height: 900px; margin-top: 0px; ">
       
     <div id="container" style=" width:1350px; height: 900px; margin-top: 0px; ">
      
   <div><h1 style="text-align: center"><img src="images/aphia_logo.png" height="70" width="200" /></h1></div>
   <div id="header" style=" width:1350px;">
               <%@include file="/menu/adminmenu.jsp" %>  
            </div>
            <% 
 
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
<!--   <table>              
<tr id="dialog1" title="DIC Help ">
  
    <td>
         <% if(Sectionshelp[21]!=null){%>
         <%=Sectionshelp[21]%> 
         <%}%>
    </td>
    </tr>
     <h3>Audit Form <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="images/help_24.png"/> </a></h3>
           
                        </table> -->
   
   
   
   
   

    
<!--        <table  cellpadding="0px" class="viewpdt" cellspacing="0px" border="1px" style="width:1350px;" id="example">-->
    <table cellpadding="0" cellspacing="0" border="0" class="display" id="example">      
    <thead><tr><th>Action</th><th>Time</th><th>User</th><th>Host Machine</th></tr></thead><tbody>

    <% dbConnect conn= new dbConnect();

String adt="select audit,host_comp,action,time, username  from taskauditor group by action,time ";
 if(conn.state.isClosed()){conn= new dbConnect();}
conn.rs=conn.state.executeQuery(adt);
while(conn.rs.next()){
     String Action=conn.rs.getString(3);
    String Time=conn.rs.getString(4);
    String HostMachine=conn.rs.getString(2);
    String users="Select * from user where Username='"+conn.rs.getString(5) +"'";
   
    conn.rs2=conn.state2.executeQuery(users);
   while( conn.rs2.next()){
%>
<tr><td> <%= Action %> </td><td> <%= Time %></td><td> <%=conn.rs2.getString(2)%></td><td> <%= HostMachine %></td></tr>



<%
}
       }
%>
    
    
    
    
    
    </tbody>     </table>
   
<!--        
       
         

           

           
                

                <div id="midcontent">
                    
                    <iframe width="1100px" style="margin-left:25px;" height="550px"  src="audit_table.jsp"></iframe>
                    
       
                    
                    
                 
                </div>-->
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