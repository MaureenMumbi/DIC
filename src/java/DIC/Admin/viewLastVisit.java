/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Maureen
 */
public class viewLastVisit extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            dbConnect conn = new dbConnect();
            /* TODO output your page here. You may use following sample code. */
               JSONObject jsonobj = new JSONObject();
          String UniqueID="";
          String assID="";
          String DOA="";
          String DirectAns="";
          String qstn="";
          String example="";
          String riskassessmentsummary="";
         UniqueID=request.getParameter("UniqueID");
          String questionsddd="";
          System.out.println(UniqueID);
            example+=" <table class=\"display\" id=\"example\" border=\"1\"><tr><th colspan=\"2\">Behaviours and SGBV </th><tr><th>Question</th><th>Answers</th></tr></tr>" ;
          String[] questions= new String[]{"I1","I2","I3","J1","J2","J","T1","T3","T5","T7","T9"};
          String[] fewquestions= new String[]{"I1","I2","I3","J1","J2","J"};
          String[] fullquestions= new String[]{"<font-size=\"18\">1) How often do u practice the following behaviours?</font><br/> a) Vaginal Sex",
              "b) Oral Sex",
              "c) Anal Sex",
              "2) How often do you use condoms when engaging in the following behaviors <br/> a) Vaginal Sex" ,
              "b) Oral Sex",
              "c) Anal Sex",
              "3) Have you been beaten or seriously threatened by your partner or anyone of the opposite sex?",
              "4) Have you been raped by your partner or any other person?",
              "5)Does your partner deliberately deprive you of economic support?",
              "6) Does your partner deliberately say or do bad things in order to hurt you?",
              "7) Do any partner related problems affect your use of condoms, FP or seeking health services through disclosure and adherence to treatment?"};
          //String query="select * from enrollment where UniqueID='"+UniqueID+"'";
          String query="select MAX(STR_TO_DATE(AssessmentDate,'%e/%c/%Y')) from riskassessmentmain where UniqueID='"+UniqueID+"' ";
          System.out.println(query);
          conn.rs= conn.state.executeQuery(query);
          while(conn.rs.next()){
         
          DOA=  conn.rs.getString(1);
          
          String query2="select AssessmentID from riskassessmentmain where UniqueID='"+UniqueID+"'  AND STR_TO_DATE(AssessmentDate,'%e/%c/%Y')='"+DOA+"'";
            conn.rs3= conn.state3.executeQuery(query2);  
            while(conn.rs3.next()){
             assID=conn.rs3.getString(1);
              System.out.println(assID);
          
          for(int i=0;i<fullquestions.length;i++ ){
         String query1="select * from riskassessmentdetails where AssessmentID='"+assID+"' AND QuestionID='"+questions[i]+"' ";
         conn.rs= conn.state.executeQuery(query1);
          while(conn.rs.next()){
              
             DirectAns = conn.rs.getString("DirectAnswers");
            qstn= conn.rs.getString("QuestionID");
            System.out.println(DirectAns +" "+qstn);
              
             String querys="select * from questions where QuestionsID='"+questions[i]+"'";
             System.out.println(querys);
             conn.rs2 = conn.state1.executeQuery(querys);
             while(conn.rs2.next()){
            
              questionsddd= conn.rs2.getString("Question") ;
             // System.out.println("~~~~~~~~~"+conn.rs2.getString("Question") +"    "+DirectAns);
             }
                System.out.println("~~~~~~~~~"+fullquestions[i] +"@@@@@@@"+DirectAns);
              
             
                String queryBeh="select * from behaviourscode where BehavioursCodeID='"+DirectAns+"'";
                conn.rs3= conn.state5.executeQuery(queryBeh);
                while(conn.rs3.next()){
                    DirectAns=conn.rs3.getString(2);
                }
                
                    example+="<tr ><td >"+fullquestions[i] +"</td><td>"+DirectAns+"</td></tr>" ;
          }
          }
          }
          }
            String[]  questionsRed = new String[]{"B1","B3","D2","E1","E2","F1","G1","H1","I","J3"};
            String[]  qstnsReduction = new String[]{"No of Condoms Provided","No of WBL Provided","Health Education Provided","Provided HIV Testing","Tested with partner","STI Checkup","CC Screening","TB Screening","GBV Referal Provided","FP Method Provided"};
           String assIDs="";
           String DirectAns1="";
           String DOA1="";
           String qstns="";
           String questions1="";
           String action="";
           String [] cd;
           String [] wbl;
          example+="<th colspan=\"2\">Risk Reduction Services Provided</th>";
//          example+="Risk Reduction Services provided";
          
//           String queryRed="select RRM.RiskReductionID,RRM.DOA,RRM.UniqueID from riskreductionmain WHERE RRM.UniqueID='"+UniqueID+"' RRM INNER JOIN ( SELECT RiskReductionID,UniqueID,MAX(STR_TO_DATE(DOA,'%e/%c/%Y' )) AS MAXDOA FROM riskreductionmain WHERE UniqueID='"+UniqueID+"')RRM1 ON RRM.UniqueID= RRM1.UniqueID AND RRM.DOA = RRM1.MAXDOA";
//           String queryRed="select  RiskReductionID,UniqueID,DOA FROM riskreductionmain WHERE UniqueID='"+UniqueID+"' AND DOA = (SELECT MAX(STR_TO_DATE(DOA,'%e/%c/%Y')) from riskreductionmain where UniqueID='"+UniqueID+"') ";
           String queryRed="select MAX(STR_TO_DATE(DOA,'%e/%c/%Y')) FROM riskreductionmain WHERE UniqueID='"+UniqueID+"'";
          System.out.println(queryRed);
          conn.rs= conn.state.executeQuery(queryRed);
          
          
          while(conn.rs.next()){
          DOA1=  conn.rs.getString(1);
            String queryRedA="select RiskReductionID FROM riskreductionmain WHERE UniqueID='"+UniqueID+"' AND STR_TO_DATE(DOA,'%e/%c/%Y')='"+DOA1+"'";
                   conn.rs3= conn.state3.executeQuery(queryRedA);
                   while(conn.rs3.next()){
            assIDs=conn.rs3.getString(1);
          System.out.println("AAAA"+assIDs);
            System.out.println(DOA1);
          System.out.println(DOA1);
        for(int i=0;i<questionsRed.length;i++ ){
         String queryRd1="select * from riskreductiondetails where RiskReductionID='"+assIDs+"' AND QID='"+questionsRed[i]+"' ";
         conn.rs= conn.state.executeQuery(queryRd1);
          while(conn.rs.next()){
              
             DirectAns1 = conn.rs.getString("currentStatus");
             action = conn.rs.getString("Action");
            qstns= conn.rs.getString("QID");
            System.out.println(DirectAns +" "+qstns);
              
             String querys="select * from questions where QuestionsID='"+questionsRed[i]+"'";
             System.out.println(querys);
             conn.rs2 = conn.state1.executeQuery(querys);
             while(conn.rs2.next()){
            
              questions1= conn.rs2.getString("Question") ;
             // System.out.println("~~~~~~~~~"+conn.rs2.getString("Question") +"    "+DirectAns);
             }
                System.out.println("~~~~~~~~~"+fullquestions[i] +"@@@@@@@"+DirectAns1);
              
             
               if(action.contains("Condoms were provided")){
                   
               cd=action.split("_");
               if(cd[1].equals("null")){
                      DirectAns1="0";
                  }
               else{
               DirectAns1=cd[1];
               }
               }
                  if(action.contains("WBL Provided")){  
                  wbl=action.split("_");
                  if(wbl[1].equals("null")){
                      DirectAns1="0";
                  }
                  else{
                      DirectAns1=wbl[1];
                  }
                  } 
                
                    example+="<tr ><td>"+qstnsReduction[i] +"</td><td>"+DirectAns1+"</td></tr>" ;
          }
          }
          }}
                              example+="</table>";

        try {
                
                jsonobj.put("example", example);
              
               
                //System.out.println(jsonobj);
                
                out.println(jsonobj);
                
          
        
        
        
        		
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
        } finally {                
                out.close();
            }  
          
          
        } catch(SQLException ex) {            
          System.out.println(ex.toString());
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
        } catch (SQLException ex) {
            Logger.getLogger(viewLastVisit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(viewLastVisit.class.getName()).log(Level.SEVERE, null, ex);
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
