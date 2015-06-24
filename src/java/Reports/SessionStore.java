/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class SessionStore extends HttpServlet {

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
    
     HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    String [] districts=null;
    String reporttype="";
    String reportyear="";
    String period="";
    String []months1=null;
    String [] quarters2=null; 
        try {
             session=request.getSession(); 
        if(request.getParameterValues("district") !=null && !request.getParameterValues("district").equals("") ){
 districts=request.getParameterValues("district");
 }
if(request.getParameter("parameter")!= null && !request.getParameter("parameter").equals("")){
reporttype = request.getParameter("parameter");
}
if(request.getParameter("year")!= null && !request.getParameter("year").equals("")){
reportyear = request.getParameter("year");
}
if(request.getParameter("period")!= null && !request.getParameter("period").equals("")){
period = request.getParameter("period");
}
 String months="";
if(request.getParameterValues("months")!= null && !request.getParameterValues("months").equals("")){
months1=request.getParameterValues("months");

 
for(int i=0;i<months1.length;i++){
System.out.println(months1[i]);

   

     months+=months1[i];
if(i<months1.length-1){
 months+=",";
}
}
}
  String quarters="";
if(request.getParameterValues("Quarter")!= null && !request.getParameterValues("Quarter").equals("")){
  quarters2=request.getParameterValues("Quarter");

for(int i=0;i<quarters2.length;i++){
System.out.println(quarters2[i]);

   

     quarters+=quarters2[i];
if(i<quarters2.length-1){
 quarters+=",";
}
}
}
  

String district="";
for(int j=0;j<districts.length;j++){
System.out.println(districts[j]);
district+=districts[j];
if(j<districts.length-1){
 district+=",";
}
}


  session.setAttribute("districts", district);
       session.setAttribute("reporttype", reporttype);
       session.setAttribute("reportyear", reportyear);
       session.setAttribute("period", period);
       session.setAttribute("months1", months);
       session.setAttribute("quarters2", quarters);

       
       System.out.println(districts[0]);
       System.out.println(reporttype);
       System.out.println(reportyear);
    
    
   response.sendRedirect("Reports/ServicesProvided.jsp");

        } finally {            
            out.close();
        }
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
