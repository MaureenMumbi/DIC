<%-- 
    Document   : clerkmenu
    Created on : Aug 21, 2015, 9:51:18 AM
    Author     : Maureen
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>

<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>

<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <ul id="nav">
            <li><a href="/DIC/admin/index_admin.jsp">Home</a>
            <ul>
            <!--<li><a href="/DIC/admin/index_admin.jsp">Home</a></li>-->
            <li ><a href="/DIC/audit_1.jsp">Audit Trail</a></li></ul>
                </li>
          <li><a href="#">Enrollments</a>
            <ul>
             <li><a href="/DIC/Enrollment.jsp">New Enrollment</a></li>    
             <li><a href="/DIC/globalsyncing.jsp">Track on Online Database</a></li>    
             <li><a href="/DIC/searchBiometric.jsp">Track on Local Database </a> </li>      
                
            </ul>
        </li>
         <li><a href="/DIC/index_1.jsp">Perform Risk Assessment</a></li>
         
        <li><a href="#">Manage Forms</a>
             
        
            <ul>
                <li><a href="/DIC/admin/indexWorker.jsp">Manage Enrollments</a>
                   <li><a href="/DIC/admin/index_Assessment.jsp">Risk Assessments </a></li>
                <li><a href="/DIC/admin/index_RiskReduction.jsp">Risk Reduction Forms</a> </li>
                 <li><a href="/DIC/admin/addWard.jsp">Add Ward</a> </li>
               <li><a href="/DIC/admin/viewMedicalDetails.jsp">Medical Forms</a> </li>
               <li><a href="/DIC/admin/viewMedicalForm.jsp">New Medical Forms</a> </li>
              <li><a href="/DIC/summaryVisit.jsp">Last Visit Summary</a> </li>
               <li><a href="/DIC/filterDiary.jsp">Appointments Diary</a> </li>
                   <li><a href="/DIC/searchBiometric.jsp">Biometric Verification</a> </li>
               
            </ul>
        </li>
        
      
    
      
        <li><a href="#">Reports</a> 
            <ul>
                <li><a href="/DIC/Reports/reportUI.jsp">Enrollments </a> </li>
                <li><a href="/DIC/Reports/riskreductionReport.jsp">Services Provided</a> </li>
                <li><a href="/DIC/Reports/reportUI1.jsp">Risk Assessment</a> </li>
                <li><a href="/DIC/Reports/selectParameter.jsp">Charts</a> </li>
                <li><a href="/DIC/Reports/SummaryReport.jsp">Summaries</a> </li>
                <li><a href="/DIC/Reports/RawData.jsp">Raw Data</a> </li>
                <li><a href="/DIC/Reports/KPMSReport.jsp">KPMS Report</a> </li>
                      <li><a href="/DIC/Reports/KPMSReportAged.jsp">KPMS Report(Aged)</a> </li>
                         <li><a href="/DIC/Reports/KPMSReportWards.jsp">KPMS Report(Datim)</a> </li>
                  <li><a href="/DIC/Reports/FPReport.jsp">Family Planning Report</a> </li>
                  <!--<li><a href="/DIC/Reports/BiometricReport.jsp">Biometric Report</a> </li>-->
                <li><a href="/DIC/Reports/repeatVisit.jsp">Visits Report</a> </li>
            </ul>
        </li>
        <li><a href="#">DQA</a> 
            <ul>
                <li><a href="/DIC/admin/DQADUPLICATES.jsp">Duplicate Entries </a> </li>
                <li><a href="/DIC/admin/DQA.jsp">Wrong Data Fields</a> </li>
                <!--<li><a href="/DIC/Reports/DuplicateReport.jsp">Duplicates Report</a> </li>-->
                <li><a href="/DIC/admin/MissingData.jsp">HIV Status Report</a> </li>
               
            </ul>
        </li>
             <li><a href="#">Backups</a> 
                 <ul>
        <li>
            <a href="/DIC/backup2.jsp">Backup </a>
        </li>
        <li>
            <a href="/DIC/editMnEmail.jsp">Edit M&E Mail </a>
        </li>
        <li>
            <a href="/DIC/importSQLData.jsp">Import Data </a>
        </li>
                 </ul>
        </li>
        
         <li><a href="/DIC/help/DICUserGuide.pdf">Help</a> </li>
    </ul>
    
    </body>
</html>

