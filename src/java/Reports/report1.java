/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
/**
 *
 * @author Maureen
 */
public class report1 extends HttpServlet {

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
            throws ServletException, IOException, JRException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
      
        try {
              ServletOutputStream servletOutputStream = response.getOutputStream();
              
JasperReport jasperReport;
JasperPrint jasperPrint;
JasperDesign jasperDesign;
 dbConnect conn = new dbConnect();
            // create a map of parameters to pass to the report.
 Map<String, Object> params = new HashMap<String, Object>();
    params.put("reportTitle", "ARTISAN ACCOUNTS");
params.put("author", "Maureen Mumbi");
params.put("startDate", (new java.util.Date()).toString());
  
//Map parameters = new HashMap();
//parameters.put("Report_Title", "Salesman Details");
 
// load JasperDesign from XML and compile it into JasperReport
jasperDesign = JRXmlLoader.load("C:/Users/Maureen/Documents/NetBeansProjects/dic for fair/DIC WITH VALIDATION/DIC/web/Reports/report1.jrxml");
jasperReport = JasperCompileManager.compileReport(jasperDesign);
 
// fill JasperPrint using fillReport() method
jasperPrint = JasperFillManager.fillReport(jasperReport,params,conn.connect);
 
JasperExportManager.exportReportToPdfFile(jasperPrint,
"C:/Users/Maureen/Documents/NetBeansProjects/dic for fair/DIC WITH VALIDATION/DIC/web/Reports/report2.pdf");
response.setContentType("application/pdf");
//for creating report in excel format
JRXlsExporter exporterXls = new JRXlsExporter();
exporterXls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporterXls.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
"C:/Users/Maureen/Documents/NetBeansProjects/dic for fair/DIC WITH VALIDATION/DIC/web/Reports/report2.xls");
exporterXls.exportReport();
JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
 
servletOutputStream.flush();
servletOutputStream.close();
        } finally {            
//            out.close();
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
        try {
            processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(report1.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (JRException ex) {
            Logger.getLogger(report1.class.getName()).log(Level.SEVERE, null, ex);
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
