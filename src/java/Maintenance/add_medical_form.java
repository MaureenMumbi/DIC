/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Geofrey Nyabuto
 */
public class add_medical_form extends HttpServlet {
HttpSession session;
String unique_identifier,temperature,temperature_complain,blood_pressure,blood_pressure_complain,p,p_complain,weight,weight_complain;
String ga,ga_findings,skin,skin_findings,ent,ent_findings,eyes,eyes_findings,abdomen,abdomen_findings,genitourinary,genitourinary_findings;
String musculoskeletal,musculoskeletal_findings,respiratory,respiratory_findings,psychological,psychological_findings;
String diagnosis,management,referral,specify_others,TCA,cadre,dater,signature;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        dbConnect conn=new dbConnect();
        session=request.getSession();
        if(session.getAttribute("UniqueID")!=null){
        unique_identifier=session.getAttribute("UniqueID").toString();
        }
        else{
         unique_identifier=request.getParameter("unique_identifier");
        }
        String DICName="";
        String ward="";
         String county="";
         if(request.getParameter("DICName")!=null  && !request.getParameter("DICName").equals("")){
           DICName=request.getParameter("DICName");}
         
           if(request.getParameter("ward")!=null  && !request.getParameter("ward").equals(""))
           {
           ward=request.getParameter("ward");
           }
         
         if(request.getParameter("district")!=null  && !request.getParameter("district").equals("")){
           county=request.getParameter("district");}
       
      
        temperature=request.getParameter("temperature");
        temperature_complain=request.getParameter("temperature_complain");
        blood_pressure=request.getParameter("blood_pressure");
        blood_pressure_complain=request.getParameter("blood_pressure_complain");
        p=request.getParameter("p");
        p_complain=request.getParameter("p_complain");
        weight=request.getParameter("weight"); 
        weight_complain=request.getParameter("weight_complain");
        ga=request.getParameter("ga");
        ga_findings=request.getParameter("ga_findings");
        skin=request.getParameter("skin");
        skin_findings=request.getParameter("skin_findings");
        ent=request.getParameter("ent");        
        ent_findings=request.getParameter("ent_findings");        
        eyes=request.getParameter("eyes");        
        eyes_findings=request.getParameter("eyes_findings");
        abdomen=request.getParameter("abdomen");        
        abdomen_findings=request.getParameter("abdomen_findings");
        genitourinary=request.getParameter("genitourinary");
        genitourinary_findings=request.getParameter("genitourinary_findings");
        musculoskeletal=request.getParameter("musculoskeletal");        
        musculoskeletal_findings=request.getParameter("musculoskeletal_findings");
        respiratory=request.getParameter("respiratory");        
        respiratory_findings=request.getParameter("respiratory_findings");
        psychological=request.getParameter("psychological");        
        psychological_findings=request.getParameter("psychological_findings");
        diagnosis=request.getParameter("diagnosis");
        management=request.getParameter("management");
        referral=request.getParameter("referral");
        specify_others=request.getParameter("specify_others");
        TCA=request.getParameter("TCA");
        cadre=request.getParameter("cadre");        
        dater=request.getParameter("dater");        
        signature=request.getParameter("signature");
        
        
        Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
                String formattedDate = formatter.format(date);
                String cadre_id="";
                if(session.getAttribute("cadre_id")!=null){
         cadre_id=session.getAttribute("cadre_id").toString();}
//        System.out.println("here: "+skin);
        int nums=0;
        String nextpage="";
//        if((unique_identifier==null || unique_identifier.equals(""))){
//         nextpage="index_1.jsp";   
//         session.setAttribute("session_fail", "<font color=\"red\">Failed to save the medical form. try Again.</font>");   
//        }
//        else{
        String medical_form_adder="INSERT INTO medical_form SET ward1='"+ward+"', county1='"+county+"', DICName1='"+DICName+"', unique_identifier='"+unique_identifier+"',temperature='"+temperature+"',"
                + "temperature_complain='"+temperature_complain+"',blood_pressure='"+blood_pressure+"',blood_pressure_complain='"+blood_pressure_complain+"',"
                + "p='"+p+"',p_complain='"+p_complain+"',weight='"+weight+"',weight_complain='"+weight_complain+"',ga='"+ga+"',"
                + "ga_findings='"+ga_findings+"',skin='"+skin+"',skin_findings='"+skin_findings+"',ent='"+ent+"',ent_findings='"+ent_findings+"',"
                + "eyes='"+eyes+"',eyes_findings='"+eyes_findings+"',abdomen='"+abdomen+"',abdomen_findings='"+abdomen_findings+"',"
                + "genitourinary='"+genitourinary+"',genitourinary_findings='"+genitourinary_findings+"',musculoskeletal='"+musculoskeletal+"',"
                + "musculoskeletal_findings='"+musculoskeletal_findings+"',respiratory='"+respiratory+"',respiratory_findings='"+respiratory_findings+"',"
                + "psychological='"+psychological+"',psychological_findings='"+psychological_findings+"',diagnosis='"+diagnosis+"',"
                + "management='"+management+"',referral='"+referral+"',specify_others='"+specify_others+"',TCA='"+TCA+"',"
                + "cadre='"+cadre+"',dater='"+dater+"',signature='"+signature+"',syncstatus='0'";
 nums=conn.state.executeUpdate(medical_form_adder);
       System.out.println(medical_form_adder);
//        }
if(nums>0) {
     nextpage="index_1.jsp";
  session.setAttribute("session_fail", "<font color=\"green\">Medical form saved successfully.</font>");   
 System.out.println("inserted successfully");      
}  
    
 response.sendRedirect(nextpage);   
    
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_medical_form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_medical_form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
