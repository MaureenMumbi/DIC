/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

import Enroll.Enroll;
import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maureen
 */
public class AddDistrict extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       String county= request.getParameter("county");
       String DICName= request.getParameter("DICName");
//       String District= request.getParameter("Districts");
//       out.println(District);
       String MaritalStatus= request.getParameter("MaritalStatus");
       String Ages= request.getParameter("Ages");
       String Religion= request.getParameter("Religion");
       String EducationLevel= request.getParameter("EducationLevel");
       String OperationArea= request.getParameter("OperationArea");
       String Venue= request.getParameter("Venue");
       String Occupation= request.getParameter("Occupation");
       String ClientLearnt= request.getParameter("ClientLearnt");
       String SexualIntCode= request.getParameter("SexualIntCode");
       String SexCode= request.getParameter("SexCode");
       String CondomCode= request.getParameter("CondomCode");
       String CadreCode= request.getParameter("CadreCode");
       String CSCode= request.getParameter("CSCode");
       String CondomProvider= request.getParameter("CondomProvider");
       String Behaviours= request.getParameter("Behaviours");
       String doucheCode= request.getParameter("doucheCode");
       String KnowledgeCode= request.getParameter("KnowledgeCode");
       String LastSex= request.getParameter("LastSex");
       String PlaceTreated= request.getParameter("PlaceTreated");
       String STITreatment= request.getParameter("STITreatment");
       String FPMethodCode= request.getParameter("FPMethodCode");
       String AlcoholCode= request.getParameter("AlcoholCode");
dbConnect conn = new dbConnect();
String query=null;



        query = "INSERT INTO districts(District) VALUES ('"+county+"')";
    
 try {
                    conn.state.executeUpdate(query);
                    out.println("Inserted into db");
//                   response.sendRedirect("../DIC/CountyServlet");
                } catch (SQLException ex) {
                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
                    out.println(ex);
                }}
// if(request.getParameter("DICName")==DICName && request.getParameter("DICName")!= null){
//
//        query = "INSERT INTO dicname(DICName,DistrictID) VALUES ('"+DICName+"','"+District+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("MaritalStatus")==MaritalStatus){
//
//        query = "INSERT INTO MaritalStatus(MaritalStatus) VALUES ('"+MaritalStatus+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//
//if(request.getParameter("Ages")==Ages){
//
//        query = "INSERT INTO Ages(Ages) VALUES ('"+Ages+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//
//if(request.getParameter("Religion")==Religion){
//
//        query = "INSERT INTO Religion(Religion) VALUES ('"+Religion+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("EducationLevel")==EducationLevel){
//
//        query = "INSERT INTO EducationLevel(EducationLevel) VALUES ('"+EducationLevel+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("OperationArea")==OperationArea){
//
//        query = "INSERT INTO OperationArea(OperationArea) VALUES ('"+OperationArea+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("Venue")==Venue){
//
//        query = "INSERT INTO Venue(Venue) VALUES ('"+Venue+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("Occupation")==Occupation){
//
//        query = "INSERT INTO Occupation(Occupation) VALUES ('"+Occupation+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("ClientLearnt")==ClientLearnt){
//
//        query = "INSERT INTO ClientLearnt(ClientLearnt) VALUES ('"+ClientLearnt+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("SexualIntCode")==SexualIntCode){
//
//        query = "INSERT INTO SexualIntCode(SexualIntCode) VALUES ('"+SexualIntCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("SexCode")==SexCode){
//
//        query = "INSERT INTO SexCode(SexCode) VALUES ('"+SexCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("CondomCode")==CondomCode){
//
//        query = "INSERT INTO CondomCode(CondomCode) VALUES ('"+CondomCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("CadreCode")==CadreCode){
//
//        query = "INSERT INTO CadreCode(CadreCode) VALUES ('"+CadreCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("CSCode")==CSCode){
//
//        query = "INSERT INTO CSCode(CSCode) VALUES ('"+CSCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("CondomProvider")==CondomProvider){
//
//        query = "INSERT INTO CondomProvider(CondomProvider) VALUES ('"+CondomProvider+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("KnowledgeCode")==KnowledgeCode){
//
//        query = "INSERT INTO KnowledgeCode(KnowledgeCode) VALUES ('"+KnowledgeCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("Behaviours")==Behaviours){
//
//        query = "INSERT INTO Behaviours(Behaviours) VALUES ('"+Behaviours+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("doucheCode")==doucheCode){
//
//        query = "INSERT INTO KnowledgeCode(doucheCode) VALUES ('"+doucheCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("LastSex")==LastSex){
//
//        query = "INSERT INTO LastSex(LastSex) VALUES ('"+LastSex+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("PlaceTreated")==PlaceTreated){
//
//        query = "INSERT INTO PlaceTreated(PlaceTreated) VALUES ('"+PlaceTreated+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("STITreatment")==STITreatment){
//
//        query = "INSERT INTO STITreatment(STITreatment) VALUES ('"+STITreatment+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("FPMethodCode")==FPMethodCode){
//
//        query = "INSERT INTO FPMethodCode(FPMethodCode) VALUES ('"+FPMethodCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//if(request.getParameter("AlcoholCode")==AlcoholCode){
//
//        query = "INSERT INTO AlcoholCode(AlcoholCode) VALUES ('"+AlcoholCode+"')";
//    
// try {
//                    conn.state.executeUpdate(query);
//                    out.println("Inserted into db");
////                   response.sendRedirect("../DIC/DistrictServletRecord");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Enroll.class.getName()).log(Level.SEVERE, null, ex);
//                    out.println(ex);
//                }}
//    }
    

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
        processRequest(request, response);
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
        processRequest(request, response);
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
