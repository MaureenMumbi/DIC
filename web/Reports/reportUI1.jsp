<%-- 
    Document   : reportUI1
    Created on : Mar 3, 2014, 10:24:52 AM
    Author     : Hare Cheka Arnold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="dbConnect.dbConnect"%>
<%! dbConnect conn= new dbConnect();%>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIC REPORTS</title>
        
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
    
    
    <script type="text/javascript">
// a function that hides either quarterly or monthly fields wen a report type is selected.

function disabler() {
    
  var v= document.getElementById("type").value;
  var months = document.getElementById("months");
  var Quarter = document.getElementById("Quarter");
  var label_months = document.getElementById("label_months");
  var label_Quarter = document.getElementById("label_Quarter");
//  alert(" geek     :  "+v)
 
if(v==1) {
  months.hidden = false; 
  Quarter.hidden = true; 
  label_months.hidden = false; 
  label_Quarter.hidden = true;
  months.required = true; 
  Quarter.required = false; 
  
  //
  }
if(v==2) {
 months.hidden = true; 
  Quarter.hidden = false;
  label_months.hidden = true; 
  label_Quarter.hidden = false;
  months.required = false; 
  Quarter.required = true;
  }
  if(v!=1 && v!=2){
     months.hidden = true; 
  Quarter.hidden = true; 
  label_months.hidden = true; 
  label_Quarter.hidden = true;
  months.required = true; 
  Quarter.required = true;
  }}
</script> 
    
    
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen">
    </head>
    <body onload="disabler();">
         

        <div class="example" style="width: 1350px; height: 700px;">
          
    
      <div><h1 style="text-align: center"><img src="../images/aphia_logo.png" height="70" width="200"/></h1></div>   
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
     
              <% 
 dbConnect conn = new dbConnect();
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
    <H3>RISK ASSESSMENT REPORT </H3>
        <h4> Reports <a href="#" id="dialog-link1" style="padding-right: 0px;">
                <img src="../images/help_24.png"/> </a></h4>
       
        <form name="form" method="post" action="/DIC/RiskAssesmentReport">
        <table>
           
               <tr class="d0">
                    <td>Year</td>
                    <td><select  name="year" id="year" required="true" >
                            <option value="">Select Year</option>
                             
                            <option value="2011">2011</option> 
                            <option value="2012">2012</option> 
                            <option value="2013">2013</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                            
                           
                        </select></td>
                </tr>
                
                <tr class="d1"><td>county<font style="color: blue">*</font> </td><td>

                        <select  name="dic_name" id="dic_name" multiple= "true">
  <%
             
                                                      String QueryDist= "SELECT * FROM districts";
                                                      if(conn.state.isClosed()){conn= new dbConnect();}
                                                     conn.state= conn.connect.createStatement();
				conn.rs = conn.state.executeQuery(QueryDist);
                                                      while(conn.rs.next())
                                                           {
                                                   %>                                                                       
            <option value=<%=conn.rs.getString("DistrictID")%>><%=conn.rs.getString("District")%></option>
                                                   <%
                                                      
 
                                System.out.println(conn.rs.getString("District"));                                                      }
                                
                               
                                                   %>


                                 </select></td>
                </tr>
                <tr class="d0">
                    <td>Report Type</td>
                    <td><select  name="type" id="type"  onchange="disabler()" required="true">
                            <option value="">Select Report Type</option>
                            <option value="1">Monthly</option> 
                            <option value="2">Quarterly</option> 
                            
                            
                           
                        </select></td>
                </tr>
                
                <tr class="d0">
                    <td id="label_months">Months</td>
                    <td><select name="months" id="months" multiple= "true" size = "4px" >
                          <!--  <option value="">Select Quarter</option>-->
                            <option value="10">October</option> 
                            <option value="11">November</option> 
                            <option value="12">December</option>
                            <option value="1">January</option> 
                            <option value="2">February</option> 
                            <option value="3">March</option> 
                            <option value="4">April</option>
                            <option value="5">May</option> 
                            <option value="6">June</option> 
                            <option value="7">July</option> 
                            <option value="8">August</option>
                            <option value="9">September</option> 
                            
                            
                            
                           
                        </select></td>
                </tr>
                
                <tr class="d0">
                    <td id="label_Quarter">Quarter</td>
                    <td><select name="Quarter" id="Quarter" multiple= "true" size = "4px"  >
                          <!--  <option value="">Select Quarter</option>-->
                            <option value="1">Oct - Dec</option> 
                            <option value="2">Jan - Mar</option> 
                            <option value="3">Apr - Jun</option> 
                            <option value="4">Jul - Sep</option> 
                            
                           
                        </select></td>
                </tr>
                
                <tr><td> <input type="submit"  name="submit" value="Submit">  </td></tr>
                </table>
 </form>
      </div>
                          
  
</div>
  
 
 
      
    </body>
</html>

