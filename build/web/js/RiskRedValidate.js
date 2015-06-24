/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  $(document).ready(function(){
    	// Smart Wizard     	
  		$('#wizard').smartWizard({transitionEffect:'slideleft',onLeaveStep:leaveAStepCallback,onFinish:onFinishCallback,enableFinishButton:true});

      function leaveAStepCallback(obj){
        var step_num= obj.attr('rel');
        return validateSteps(step_num);
      }
      
      function onFinishCallback(){
       if(validateAllSteps()){
        $('form').submit();
       }
      }
            
		});
	   
    function validateAllSteps(){
       var isStepValid = true;
       
       if(validateStep1() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:false});
       }
       if(validateStep2() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:2,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:2,iserror:false});
       }
       
       if(validateStep3() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:3,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:3,iserror:false});
       }
       if(validateStep4() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:4,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:4,iserror:false});
       }
       
       
       if(validateStep5() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:5,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:5,iserror:false});
       }
       
       if(!isStepValid){
          $('#wizard').smartWizard('showMessage','Please fill the marked fields in step1 and click Next');
       }
              
       return isStepValid;
    } 	
		
		
		function validateSteps(step){
		  var isStepValid = true;
      // validate step 1
      if(step == 1){
        if(validateStep1() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      if(step == 2){
        if(validateStep2() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      // validate step3
      if(step == 3){
        if(validateStep3() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      //validate step 4
      if(step == 4){
        if(validateStep4() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      //validate step 5
      if(step == 5){
        if(validateStep5() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      return isStepValid;
    }
		
		function validateStep1(){
       var isValid = true; 
      var un = $('#Cadre').val();
       if(!un && un.length <= 0){
         isValid = false;
         $('#msg_Cadre').html('Please fill Cadre').show();
         
          $("#Cadre").css("border-color","#ff0000");
            $("#Cadre").slideToggle( "slow", function() {});
            $("#Cadre").slideToggle( "slow", function() {});
            $("#Cadre").focus();
       }else{
         $('#msg_Cadre').html('').hide();
       }
       
       // validate password
       var pw = $('#datepicker').val();
       if(!pw && pw.length <= 0){
         isValid = false;
         $('#msg_datepicker').html('Please fill DOA').show();  
         
          $("#datepicker").css("border-color","#ff0000");
            $("#datepicker").slideToggle("slow", function() {});
            $("#datepicker").slideToggle("slow", function() {});
            $("#datepicker").focus();
       }else{
         $('#msg_datepicker').html('').hide();
       }
       
       
             
////created the date object
//dateObject =new Date();
//day=dateObject.getDate();
//month=dateObject.getMonth()+1;
//year=dateObject.getFullYear();
////fully year separated by backward slash
//current_date=day+"/"+month+"/"+year;
////we compare the date
//if(new Date(pw) > new Date(current_date)){
//    
//        isValid = false;
//
//alert("assessment date cannot be greater than current date");
//
//}
    
     ////created the date object
dateObject =new Date();
day=dateObject.getDate();
month=dateObject.getMonth()+1;
year=dateObject.getFullYear();
 var current_date;
//fully year separated by backward slash
var days=0;
days=day;
var dates=day;
if(parseInt(days)<10){
 dates="0"+day;  
}

var months=0;
months=month;
var months1=month;
if(parseInt(months)<10){
 months1="0"+month;  
}
//alert(dates);
current_date=months1+"/"+dates+"/"+year;
//current_date=months1+"/"+dates+"/"+year;

//alert(current_date);
//we compare the date

var dateofassess = $('#datepicker').val();
var g= dateofassess.split("/");
//alert(g[0] +"  "+g[1]+"  "+g[2]);
var curdate=new Date(current_date);

var entereddate = g[1] +"/"+g[0]+"/"+g[2];
var newdate=new Date(entereddate);
//alert(newdate +"  gererr  "+curdate );

if( newdate > curdate){
alert("Assessment date cannot be greater than current date");
return false;
}

      var CdProvided = $('#CdProvided').val();
   
       var NoCD = $('#NoCD').val();
       if(CdProvided === "Condoms were provided" && NoCD.length <= 0 &&!NoCD && isNaN(NoCD)){
         isValid = false;
         $('#msg_DOA').html('Please fill field').show();
             document.getElementById("NoCD").required="true"; 
            $("#NoCD").css("border-color","#ff0000");
            $("#NoCD").slideToggle( "slow", function() {});
            $("#NoCD").slideToggle( "slow", function() {});
            $("#NoCD").focus();
            
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("NoCD").required="false"; 
       }
       var WBLubProvided = $('#WBLubProvided').val();
       var NoWBL = $('#NoWBL').val();
     
       if(WBLubProvided === "WBL Provided" && NoWBL.length <= 0 && !NoWBL ){
       
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("NoWBL").required="true"; 
   
            $("#NoWBL").css("border-color","#ff0000");
            $("#NoWBL").slideToggle( "slow", function() {});
            $("#NoWBL").slideToggle( "slow", function() {});
            $("#NoWBL").focus();
         
          isValid = false;
       }
       else{
           
           $('#msg_DOA').html('').hide();
          document.getElementById("NoWBL").required="false"; 
           
       }
//         var NoCD1 = $('#NoCD').val();
//        if(isNaN(NoCD1)){
//             isValid = false;
//         $("#NoCD").css("border-color","#ff0000");
//            $("#NoCD").slideToggle( "slow", function() {});
//            $("#NoCD").slideToggle( "slow", function() {});
//            $("#NoCD").focus();
////              alert("Enter only numbers");
//         
//       }
//       
//       else{
//        
//         isValid = true;
//       }
//         var NoWBL1 = $('#NoWBL').val();
//        if(isNaN(NoWBL1)){
//               isValid = false;
//         $("#NoWBL").css("border-color","#ff0000");
//            $("#NoWBL").slideToggle( "slow", function() {});
//            $("#NoWBL").slideToggle( "slow", function() {});
//            $("#NoWBL").focus();
////           alert("Enter only numbers");
//       
//       }
//       
//       else{
//        
//         isValid = true;
//       }
     

       return isValid;
    }
       function validateStep2(){
     var isValid2 = true; 

        
        return isValid2;
    }  
       function validateStep3(){
     var isValid3 = true; 
 
 
 
        var HIVTodayTest = $('#HIVTodayTest').val();
       var HIVTodayTestStatus = $('#HIVTodayTestStatus').val();
       if(HIVTodayTest === "Yes" && HIVTodayTestStatus.length <= 0 &&!HIVTodayTestStatus){
         isValid3 = false;
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("HIVTodayTestStatus").required="true"; 
         
         $("#HIVTodayTestStatus").css("border-color","#ff0000");
            $("#HIVTodayTestStatus").slideToggle( "slow", function() {});
            $("#HIVTodayTestStatus").slideToggle( "slow", function() {});
            $("#HIVTodayTestStatus").focus();
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("HIVTodayTestStatus").required="false";
             
       }
        var HIVTestPart = $('#HIVTestPart').val();
       var HIVTestPartStatus = $('#HIVTestPartStatus').val();
       if(HIVTestPart === "Yes" && HIVTestPartStatus.length <= 0 &&!HIVTestPartStatus){
         isValid3 = false;
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("HIVTestPartStatus").required="true"; 
         
         $("#HIVTestPartStatus").css("border-color","#ff0000");
            $("#HIVTestPartStatus").slideToggle( "slow", function() {});
            $("#HIVTestPartStatus").slideToggle( "slow", function() {});
            $("#HIVTestPartStatus").focus();
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("HIVTestPartStatus").required="false";
             
       }
       
          var STICheck = $('#STICheck').val();
       var STINextCheck = $('#STINextCheck').val();
       if(STICheck === "Yes" && STINextCheck.length <= 0 &&!STINextCheck){
         isValid3 = false;
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("STINextCheck").required="true"; 
         
         $("#STINextCheck").css("border-color","#ff0000");
            $("#STINextCheck").slideToggle( "slow", function() {});
            $("#STINextCheck").slideToggle( "slow", function() {});
            $("#STINextCheck").focus();
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("STINextCheck").required="false";
             
       }
     return isValid3;
    
    }  
       function validateStep4(){
     var isValid4 = true; 
  var CCScreening = $('#CCScreening').val();
       var CCAppointment = $('#CCAppointment').val();
       if(CCScreening === "No" && CCAppointment.length <= 0 &&!CCAppointment){
         isValid4 = false;
       
         document.getElementById("CCAppointment").required="true"; 
         
            $("#CCAppointment").css("border-color","#ff0000");
            $("#CCAppointment").slideToggle( "slow", function() {});
            $("#CCAppointment").slideToggle( "slow", function() {});
            $("#CCAppointment").focus();
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("CCAppointment").required="false";
             
       }
    
  
     return isValid4;
    
    }  
       function validateStep5(){
     var isValid5 = true; 
 
  var FPCurrentMethod = $('#FPCurrentMethod').val();
  var FPMethod = $('#FPMethod').val();
       var NoMethod = $('#NoMethod').val();
       if(FPCurrentMethod === "No" && FPMethod === "No" && NoMethod.length <= 0 &&!NoMethod){
         isValid5 = false;
          
         document.getElementById("NoMethod").required="true"; 
      
           $("#NoMethod").css("border-color","#ff0000");
            $("#NoMethod").slideToggle( "slow", function() {});
            $("#NoMethod").slideToggle( "slow", function() {});
            $("#NoMethod").focus();
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("NoMethod").required="false";
             
       }
 
  var FPMethods = $('#FPMethod').val();
       var FPMethodType = $('#FPMethodType').val();
       if(FPMethods === "Yes" && FPMethodType.length <= 0 &&!FPMethodType){
         isValid5 = false;
          
         document.getElementById("FPMethodType").required="true"; 
      
           $("#FPMethodType").css("border-color","#ff0000");
            $("#FPMethodType").slideToggle( "slow", function() {});
            $("#FPMethodType").slideToggle( "slow", function() {});
            $("#FPMethodType").focus();
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("FPMethodType").required="false";
             
       }
 
 
        return isValid5;
    
    }  

		
	