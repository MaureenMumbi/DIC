<%-- 
    Document   : ServicesProvided
    Created on : Jun 23, 2014, 4:18:40 PM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Service Provided Chart</title>

                <script type="text/javascript" src="../Reports/js/jquery-1.9.1.js "></script>
  
		<script type="text/javascript">
//$(function () {
//        $('#container').highcharts({
//            chart: {
//            },
//            title: {
//                text: 'Combination chart'
//            },
//            xAxis: {
//                categories: ['Condoms', 'WBL', 'HEALTH EDUCATION', 'HIV TESTING', 'STI CHECKUP','CC SCREENING']
//            },
//            tooltip: {
//                formatter: function() {
//                    var s;
//                    if (this.point.name) { // the pie chart
//                        s = ''+
//                            this.point.name +': '+ this.y +' fruits';
//                    } else {
//                        s = ''+
//                            this.x  +': '+ this.y;
//                    }
//                    return s;
//                }
//            },
//            labels: {
//                items: [{
//                    html: 'Total fruit consumption',
//                    style: {
//                        left: '40px',
//                        top: '8px',
//                        color: 'black'
//                    }
//                }]
//            },
//            series: [{
//                type: 'column',
//                name: 'Jane',
//                data: [3, 2, 1, 3, 4]
//            }, {
//                type: 'column',
//                name: 'John',
//                data: [2, 3, 5, 7, 6]
//            }, {
//                type: 'column',
//                name: 'Joe',
//                data: [4, 3, 3, 9, 0]
//            }, {
//                type: 'spline',
//                name: 'Average',
//                data: [3, 2.67, 3, 6.33, 3.33],
//                marker: {
//                	lineWidth: 2,
//                	lineColor: Highcharts.getOptions().colors[3],
//                	fillColor: 'white'
//                }
//            }, {
//                type: 'pie',
//                name: 'Total consumption',
//                data: [{
//                    name: 'Jane',
//                    y: 13,
//                    color: Highcharts.getOptions().colors[0] // Jane's color
//                }, {
//                    name: 'John',
//                    y: 23,
//                    color: Highcharts.getOptions().colors[1] // John's color
//                }, {
//                    name: 'Joe',
//                    y: 19,
//                    color: Highcharts.getOptions().colors[2] // Joe's color
//                }],
//                center: [100, 80],
//                size: 100,
//                showInLegend: false,
//                dataLabels: {
//                    enabled: false
//                }
//            }]
//        });
//    });
//    

		</script>
     <%

//   String districts="";
   String reporttype="";
   String reportyear="";
   String period="";
   String months1="";
 
    String districts=session.getAttribute("districts").toString();
       reporttype=session.getAttribute("reporttype").toString();
       reportyear=session.getAttribute("reportyear").toString();
       period=session.getAttribute("period").toString();
       months1=session.getAttribute("months1").toString();
     String quarters2= session.getAttribute("quarters2").toString();
     
%>           
               
     <script type="text/javascript">
        $(document).ready(function() {
            
            document.getElementById("loading").innerHTML="<img src=\"../images/sending.gif\" alt=\"uploading\"><b><font color=\"grey\"> Creating Report... Please Wait</font></b>";
            var chart;
            var line;
            var options = {
                chart: {
                    renderTo: 'container',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25
                }, 
                
                title: {
                    text: 'Services vs. DIC',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: []
                },
                yAxis: {
                    title: {
                        text: 'Amount'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    formatter: function() {
                            return '<b>'+ this.series.name +'</b><br/>'+
                            this.x +': '+ this.y;
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -10,
                    y: 100,
                    borderWidth: 0
                },
                series: []
            }
          
           $.ajax({  
                  url:'/DIC/ServiceProvidedChart?district=<%=districts%>&parameter=<%=reporttype%>&year=<%=reportyear%>&period=<%=period%>&Quarter=<%=quarters2%>&months=<%=months1%>',  
                    type:'post',  
                    dataType: 'json',  
                    success: function(data) {  
                    
                
                 var dlength=data.length;
             var quaterpos=dlength-1; 
//                options.xAxis.categories = data[0]['data'];
//alert(quaterpos);
options.xAxis.categories = data[quaterpos].data;
               for(var a=0;a<quaterpos;a++){
                options.series.push({
  name: data[a].name,
               data: data[a].data
  
})}
              
               //options.series[1] = data[2];
                chart = new Highcharts.Chart(options);
                line = new Highcharts.Chart(options);
            }
        });});
        </script>
                    
	</head>
	<body>
  <script src="../Reports/js/highcharts.js"></script>
<script src="../Reports/js/modules/exporting.js"></script>

<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto">   <table><td style="width:200px;" colspan="2"><p id="loading" style="text-align: center;"></p></td> <td style="width:200px;" colspan="2"><p id="loading" style="text-align: center;"></p></td></table></div>

	</body>
</html>
