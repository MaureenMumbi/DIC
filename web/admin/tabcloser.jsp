<%-- 
    Document   : index_Assessment
    Created on : Aug 13, 2013, 9:45:31 AM
    Author     : Maureen
--%>

<%-- 
    Document   : IndexWorker
    Created on : Aug 11, 2013, 7:48:22 AM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>

<
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="shotcut icon" href="../images/favicon.png">
        <title>DIC RISK ASSESSMENTS </title>
        
        <link rel="stylesheet" type="text/css" href="../js/jquery-ui.css"/>
        <script type="text/javascript" src="../js/noty/jquery-1.9.1.js"></script>
        
        <script type="text/javascript" src="../js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="../js/noty/layouts/top.js"></script>
<script type="text/javascript" src="../js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="../js/noty/themes/default.js"></script>
        
    <script type="text/javascript" src="../js/jquery-ui.js"></script>
    <link href="../js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
 
	<!--<script src="../js/jquery-ui-1.10.3.custom.js"></script>-->

      <script type="text/javascript" src="../js/DICHelp.js"></script>  


        <script type="text/javascript" src="../js/DICHelp.js"></script> 

        <link rel="StyleSheet" href="../main.css" type="text/css" />
          

        <style type="text/css">
    #container{
                height:500px;
                width:900px; 
    }
    
    </style>
    
       

       

  
    
    
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen">
    </head>
    <body>
         
         

        <div class="example" style="width: 1350px; height: 700px;">
          
    
      <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>   
     
      
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
        
        <h3> UPDATE COMPLETED 
                <img src="../images/help_24.png"/> </a></h3>
       <%
 
                            if (1==1)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: "<h2> <font color='green'>Update Completed Successfully</font></h2>",
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800
    ,
    callback: {
   
        afterShow: function() {
            window.close();
            
        }
    }                 
    });
                    
                </script> <%
                
              
                            }

                        %>
        <form method="post" action="/DIC/AssessmentServletRecord">
        <table>

 
   

               
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


        
     
    
