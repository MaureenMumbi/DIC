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
       // Validate Username
       var un = $('#DOA').val();
       
       var county=$("#district").val();
       var dic=$("#DICName").val();
       var ward=$("#ward").val();
       
         if(!county && county.length <= 0){
       
         $('#msg_DOA').html('Please select County').show();
       
            document.getElementById("district").required="true"; 
            $("#district").css("border-color","#ff0000");
            $("#district").slideToggle( "slow", function() {});
            $("#district").slideToggle( "slow", function() {});
            $("#district").focus();
            
              isValid = false;
       }
       
       else if(!un && un.length <= 0){
       
         $('#msg_DOA').html('Please fill DOA').show();
       
         document.getElementById("DOA").required="true"; 
      $("#DOA").css("border-color","#ff0000");
            $("#DOA").slideToggle( "slow", function() {});
            $("#DOA").slideToggle( "slow", function() {});
            $("#DOA").focus();
            
              isValid = false;
       }
       
       else  if(!dic && dic.length <= 0){
       
         $('#msg_DOA').html('Please select DIC').show();
       
            document.getElementById("DICName").required="true"; 
            $("#DICName").css("border-color","#ff0000");
            $("#DICName").slideToggle( "slow", function() {});
            $("#DICName").slideToggle( "slow", function() {});
            $("#DICName").focus();
            
              isValid = false;
       }  
       
       
       else   if(!ward && ward.length <= 0){
       
         $('#msg_DOA').html('Please select Ward').show();
       
            document.getElementById("ward").required="true"; 
            $("#ward").css("border-color","#ff0000");
            $("#ward").slideToggle( "slow", function() {});
            $("#ward").slideToggle( "slow", function() {});
            $("#ward").focus();
            
              isValid = false;
       } 
       
                    else{
         $('#msg_DOA').html('').hide();
          document.getElementById("district").required="false";
          document.getElementById("DICName").required="false";
          document.getElementById("ward").required="false";
          document.getElementById("DOA").required="false";
              }
       
 
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

var dateofassess = $('#DOA').val();
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


 
 
 
////created the date object
//dateObject =new Date();
//day=dateObject.getDate();
//month=dateObject.getMonth()+1;
//year=dateObject.getFullYear();
////fully year separated by backward slash
//current_date=day+"/"+month+"/"+year;
////we compare the date
//if(new Date(un) > new Date(current_date)){
//    
//     
//
//alert("assessment date cannot be greater than current date");
//   isValid = false;
//
//}
       
       var RegPartner = $('#RegPartner').val();
       var NoRegPartner = $('#NoRegPartner').val();
       if(RegPartner === "Yes" && NoRegPartner.length <= 0 &&!NoRegPartner){
       
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("NoRegPartner").required="true"; 
      $("#NoRegPartner").css("border-color","#ff0000");
            $("#NoRegPartner").slideToggle( "slow", function() {});
            $("#NoRegPartner").slideToggle( "slow", function() {});
            $("#NoRegPartner").focus();
            isValid = false;  
       }else{
         $('#msg_DOA').html('').hide();
       
       }
       
       
       var HIVPartStatus = $('#HIVPartStatus').val();
       var NoHIVPartStatus = $('#NoHIVPartStatus').val();
       var PartCondomUse = $('#PartCondomUse').val();
       if(HIVPartStatus === "Yes" && NoHIVPartStatus.length <= 0 && !NoHIVPartStatus){
        
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("NoHIVPartStatus").required="true"; 
         document.getElementById("PartCondomUse").required="true"; 
             $("#NoHIVPartStatus").css("border-color","#ff0000");
            $("#NoHIVPartStatus").slideToggle( "slow", function() {});
            $("#NoHIVPartStatus").slideToggle( "slow", function() {});
            $("#NoHIVPartStatus").focus();
            
            
             $("#PartCondomUse").css("border-color","#ff0000");
            $("#PartCondomUse").slideToggle( "slow", function() {});
            $("#PartCondomUse").slideToggle( "slow", function() {});
            $("#PartCondomUse").focus();
          isValid = false;
       }
       else if(HIVPartStatus === "Yes" && PartCondomUse.length <= 0 && !PartCondomUse){
        
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("NoHIVPartStatus").required="true"; 
         document.getElementById("PartCondomUse").required="true"; 
         
          isValid = false;
       }
       else{
         $('#msg_DOA').html('').hide();
         
       }
       
       
       
       
       
       
//        var SexLast1 = $('#SexLast').val();
//        var CondomUse1 = $('#CondomUse').val();
//        var SexPartGender1 = $('#SexPartGender').val();
//        var ActiveSexWork1 = $('#ActiveSexWork').val();
//        var NoPayingClients1 = $('#NoPayingClients').val();
//        var RegPartner1 = $('#RegPartner').val();
//        var NoRegPartner1 = $('#NoRegPartner').val();
//        var TimeRegPartners1= $('#TimeRegPartners').val();
//        var CondomProvider1 = $('#CondomProvider').val();
//        var HIVPartStatus1 = $('#HIVPartStatus').val(); 
//        var NoHIVPartStatus1 = $('#NoHIVPartStatus').val();
//        var PartCondomUse1 = $('#PartCondomUse').val();
//       if(
//               (!SexLast1 && SexLast1.length <= 0 )||  (!CondomUse1 && CondomUse1.length <= 0 )||
//               (!SexPartGender1 && SexPartGender1.length <= 0 )||
//               (!ActiveSexWork1 && SexLast1.length <= 0) ||
//               (!NoPayingClients1 && NoPayingClients1.length <= 0) ||
//               (!RegPartner1 && RegPartner1.length <= 0 )||
//               (!NoRegPartner1 && NoRegPartner1.length <= 0) ||
//               (!TimeRegPartners1 && TimeRegPartners1.length <= 0 )||
//               (!CondomProvider1 && CondomProvider1.length <= 0 )||
//               (!HIVPartStatus1 && HIVPartStatus1.length <= 0) ||
//               (!NoHIVPartStatus1 && NoHIVPartStatus1.length <= 0) ||
//               (!PartCondomUse1 && PartCondomUse1.length <= 0) ){
//                     
//                        alert("Some fields have not been entered in this form")
//                        
//                        
//                             $("#SexLast").css("border-color","#ff0000");
//                             $("#CondomUse").css("border-color","#ff0000");
//                             $("#SexPartGender").css("border-color","#ff0000");
//                             $("#ActiveSexWork").css("border-color","#ff0000");
//                             $("#NoPayingClients").css("border-color","#ff0000");
//                             $("#NoRegPartner").css("border-color","#ff0000");
//                             $("#TimeRegPartners").css("border-color","#ff0000");
//                             $("#CondomProvider").css("border-color","#ff0000");
////                                      isValid = false;  
//                            }
       
       
        return isValid;
    }
    
    
    
       function validateStep2(){
     var isValid2 = true;  
 
        var STISeekTreat = $('#STISeekTreat').val();
       var STIPlaceTreated = $('#STIPlaceTreated').val();
       if(STISeekTreat === "Yes" && STIPlaceTreated.length <= 0 &&!STIPlaceTreated){
       
         $('#msg_DOA').html('Please fill field').show();
         document.getElementById("STIPlaceTreated").required="true"; 
         
         $("#STIPlaceTreated").css("border-color","#ff0000");
            $("#STIPlaceTreated").slideToggle( "slow", function() {});
            $("#STIPlaceTreated").slideToggle( "slow", function() {});
            $("#STIPlaceTreated").focus();
              isValid2 = false;
       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("STIPlaceTreated").required="false";
               $("#STIPlaceTreated").css("border-color","#B0C4DE");
       }
 
       var LubricantUse = $('#LubricantUse').val();
     
        var checkboxs=document.getElementsByClassName("Lubs");
        
    var okay=false;
    for(var i=0,l=checkboxs.length;i<l;i++)
    {
      
        if(LubricantUse==="Yes" && checkboxs[i].checked==true)
        {
            okay=true;
         // alert("aaa"+checkboxs[i].checked);
        }
        else if(LubricantUse==="No" && checkboxs[i].checked==false){
           okay=true; 
       }
     else if ( LubricantUse.length <= 0 &&!LubricantUse){
              okay=true; 
         }
        
    }
    if(okay==true){
      
    }
    
    else{
        alert("Please check either KYJelly, Saliva or Other");
      isValid2 = false;
  }
  
  
   var selects=document.getElementsByClassName("LubsUse");
    var checks=false;
    for(var j=0,l=selects.length;j<l;j++)
    {
        
//       alert(selects[0] +" "+selects[1]);
        if(LubricantUse==="Yes" && (selects[0].checked===true ||selects[1].checked===true) )
        {
            checks=true;
        }
        else if(LubricantUse==="No" && selects[j].checked==false){
           checks=true; 
           
        }
        else if(LubricantUse==="Yes" && (selects[0].checked==false|| selects[1].checked==false)){ 
            checks=false;
        }
        
         else if ( LubricantUse.length <= 0 &&!LubricantUse){
              checks=true; 
         }
    }
    if(checks==true){
      
    }
    
    else{ 
      alert("Please check either Anal Sex or Vaginal");
      isValid2 = false;
  }
    
  
  
      var OtherLubricants1 = $('#OtherLubricants1').val();
       var OtherLubricants = $('#OtherLubricants').val();
  if( $('#OtherLubricants1').prop('checked')===true &&  OtherLubricants.length <= 0 &&!OtherLubricants ){
        
            document.getElementById("OtherLubricants").required="true"; 
         alert("Specify Other");
         $("#OtherLubricants").css("border-color","#ff0000");
            $("#OtherLubricants").slideToggle( "slow", function() {});
            $("#OtherLubricants").slideToggle( "slow", function() {});
            $("#OtherLubricants").focus();
                    isValid2 = false;

       }else{
         $('#msg_DOA').html('').hide();
          document.getElementById("OtherLubricants").required="false";
          
       }
  
  
  
        
        return isValid2;
    }  
       function validateStep3(){
     var isValid3 = true; 
 
     var UseFP = $('#UseFP').val();
       var FPMethodUsed = $('#FPMethodUsed').val();
       if(UseFP === "Yes" && FPMethodUsed.length <= 0 &&!FPMethodUsed){
       
     
         document.getElementById("FPMethodUsed").required="true"; 
         
         $("#FPMethodUsed").css("border-color","#ff0000");
            $("#FPMethodUsed").slideToggle( "slow", function() {});
            $("#FPMethodUsed").slideToggle( "slow", function() {});
            $("#FPMethodUsed").focus();
              isValid3 = false;
       }else{
        
          document.getElementById("FPMethodUsed").required="false";
             
       }
    
     return isValid3;
    
    }  
       function validateStep4(){
     var isValid4 = true; 
 
     var AlcoholUse = $('#AlcoholUse').val();
       var AlcoholFrequency = $('#AlcoholFrequency').val();
       if(AlcoholUse === "Yes" && AlcoholFrequency.length <= 0 &&!AlcoholFrequency){
      
            document.getElementById("AlcoholFrequency").required="true"; 
            $("#AlcoholFrequency").css("border-color","#ff0000");
            $("#AlcoholFrequency").slideToggle( "slow", function() {});
            $("#AlcoholFrequency").slideToggle( "slow", function() {});
            $("#AlcoholFrequency").focus();
               isValid4 = false;
       }else{
         document.getElementById("AlcoholFrequency").required="false";
                }
     var DrugUse = $('#DrugUse').val();
       var DrugType = $('#DrugType').val();
       if(DrugUse === "Yes" && (DrugType.length <= 0 &&!DrugType) ||(DrugFrequency.length <= 0 &&!DrugFrequency)){
      
            document.getElementById("DrugType").required="true"; 
            document.getElementById("DrugFrequency").required="true"; 
            $("#DrugType").css("border-color","#ff0000");
            $("#DrugType").slideToggle( "slow", function() {});
            $("#DrugType").slideToggle( "slow", function() {});
            $("#DrugType").focus();
            
            // drug frequency 
            $("#DrugFrequency").css("border-color","#ff0000");
            $("#DrugFrequency").slideToggle( "slow", function() {});
            $("#DrugFrequency").slideToggle( "slow", function() {});
            $("#DrugFrequency").focus();
               isValid4 = false;
       }else{
         document.getElementById("DrugType").required="false";
                }
    
    
       var VaginalDouche = $('#VaginalDouche').val();
//     alert(VaginalDouche);
        var checkboxes=document.getElementsByClassName("douche");
        
    var checker=false;
    for(var k=0,m=checkboxes.length;k<m;k++)
    {
//      alert("llll"+checkboxes[k].checked);
        if(VaginalDouche==="Yes" && checkboxes[k].checked==true)
        {
            checker=true;
         // alert("aaa"+checkboxs[i].checked);
        }
        else if(VaginalDouche==="No" && checkboxes[k].checked==false){
           checker=true; 
           
         
        } else if ( VaginalDouche.length <= 0 &&!VaginalDouche){
              checker=true; 
         }
        
      
        
    }
    if(checker===true){
      
    }
    
    else{
        alert("Please check either of the Douche Methods");
      isValid4 = false;
  }
  
  
  
  
     return isValid4;
    
    }  
       function validateStep5(){
     var isValid5 = true; 
 
 
 
  var VerbalInsults = $('#VerbalInsults').val();
       var LastVerbalInsult = $('#LastVerbalInsult').val();
       if(VerbalInsults === "Yes" && LastVerbalInsult.length <= 0 &&!LastVerbalInsult){
      
     
         document.getElementById("LastVerbalInsult").required="true"; 
         
            $("#LastVerbalInsult").css("border-color","#ff0000");
            $("#LastVerbalInsult").slideToggle( "slow", function() {});
            $("#LastVerbalInsult").slideToggle( "slow", function() {});
            $("#LastVerbalInsult").focus();
               isValid5 = false;
       }else{
        
          document.getElementById("LastVerbalInsult").required="false";
             
       }
  var Hit = $('#Hit').val();
       var LastVerbalInsult = $('#LastVerbalInsultHit').val();
       if(Hit === "Yes" && LastVerbalInsult.length <= 0 &&!LastVerbalInsult){
       
         document.getElementById("LastVerbalInsultHit").required="true"; 
         
            $("#LastVerbalInsultHit").css("border-color","#ff0000");
            $("#LastVerbalInsultHit").slideToggle( "slow", function() {});
            $("#LastVerbalInsultHit").slideToggle( "slow", function() {});
            $("#LastVerbalInsultHit").focus();
              isValid5 = false;
     
       }else{
        
          document.getElementById("LastVerbalInsultHit").required="false";
             
       }
  var ForcedSex = $('#ForcedSex').val();
       var LastVerbalInsult = $('#LastVerbalInsultForced').val();
       if(ForcedSex === "Yes" && LastVerbalInsult.length <= 0 &&!LastVerbalInsult){
         
     
         document.getElementById("LastVerbalInsultForced").required="true"; 
         
            $("#LastVerbalInsultForced").css("border-color","#ff0000");
            $("#LastVerbalInsultForced").slideToggle( "slow", function() {});
            $("#LastVerbalInsultForced").slideToggle( "slow", function() {});
            $("#LastVerbalInsultForced").focus();
              isValid5 = false;
       }else{
        
          document.getElementById("LastVerbalInsultForced").required="false";
             
       }
  var VerbalAbuse = $('#VerbalAbuse').val();
       var VerbalAbuseTime = $('#VerbalAbuseTime').val();
       if(VerbalAbuse === "Yes" && VerbalAbuseTime.length <= 0 &&!VerbalAbuseTime){
        
     
         document.getElementById("VerbalAbuseTime").required="true"; 
         
            $("#VerbalAbuseTime").css("border-color","#ff0000");
            $("#VerbalAbuseTime").slideToggle( "slow", function() {});
            $("#VerbalAbuseTime").slideToggle( "slow", function() {});
            $("#VerbalAbuseTime").focus();
            
             isValid5 = false;
       }else{
        
          document.getElementById("VerbalAbuseTime").required="false";
             
       }
 
  var PartnerProblem = $('#PartnerProblem').val();
       var PartnerProblemTime = $('#PartnerProblemTime').val();
       if(PartnerProblem === "Yes" && PartnerProblemTime.length <= 0 &&!PartnerProblemTime){
       
     
         document.getElementById("PartnerProblemTime").required="true"; 
         
            $("#PartnerProblemTime").css("border-color","#ff0000");
            $("#PartnerProblemTime").slideToggle( "slow", function() {});
            $("#PartnerProblemTime").slideToggle( "slow", function() {});
            $("#PartnerProblemTime").focus();
            
              isValid5 = false;
       }else{
        
          document.getElementById("PartnerProblemTime").required="false";
             
       }
       
       var SeekTreatment = $('#SeekTreatment').val();
  
       var PlaceTreated = $('#PlaceTreated').val();
    
       if(SeekTreatment === "Yes" && PlaceTreated.length <= 0 &&!PlaceTreated){
       
     
         document.getElementById("PlaceTreated").required="true"; 

         
            $("#PlaceTreated").css("border-color","#ff0000");
            $("#PlaceTreated").slideToggle( "slow", function() {});
            $("#PlaceTreated").slideToggle( "slow", function() {});
            $("#PlaceTreated").focus();
            
            $("#ReportPolice").css("border-color","#ff0000");
            $("#ReportPolice").slideToggle( "slow", function() {});
            $("#ReportPolice").slideToggle( "slow", function() {});
            $("#ReportPolice").focus();
              isValid5 = false;
       }
       else if(SeekTreatment.length <= 0 &&!SeekTreatment){
        
          document.getElementById("PlaceTreated").required="false";
        
             
       }
 else{
     
       document.getElementById("PlaceTreated").required="false";
          
        }
 
  
  var ReportPolice = $('#ReportPolice').val();
       var ReportWhere = $('#ReportWhere').val();
       if(ReportPolice === "Yes" && ReportWhere.length <= 0 &&!ReportWhere){
       
     
         document.getElementById("ReportWhere").required="true"; 
         
            $("#ReportWhere").css("border-color","#ff0000");
            $("#ReportWhere").slideToggle( "slow", function() {});
            $("#ReportWhere").slideToggle( "slow", function() {});
            $("#ReportWhere").focus();
            
              isValid5 = false;
       }else{
        
          document.getElementById("ReportWhere").required="false";
             
       }
        return isValid5;
    
    }  

		
	