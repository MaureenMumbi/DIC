/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DIC.Admin;

import Maintenance.DICServlet;
import dbConnect.AES;
import dbConnect.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class getDuplicates extends HttpServlet {

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
      
         try {
           
              dbConnect conn = new dbConnect();
             
session = request.getSession(true);
  String type="";
  String startdate="";
  String enddate="";
  type=request.getParameter("type");
  startdate=request.getParameter("startdate");
  enddate=request.getParameter("enddate");
                                
                                        
                                        
                                        ArrayList missingdata = new ArrayList();
      
                                        if(type.equals("fullname")){
//                                        String query = "select UniqueID, DICName,DOB from enrollment where (STR_TO_DATE(DOB,'%e/%c/%Y'))>STR_TO_DATE('01/01/2004','%e/%c/%Y') ";
//                                       
//                                              String query="SELECT uniqueid,dicname,doe "
//           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , upper(u.firstname), upper(u.secondname),"
//+"upper(u.lastname) from "
//+"enrollment as u "
//+" inner join("
//+" select count(*) c ,firstname, secondname,"
//+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname)"
//
//+" from enrollment where"
//+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
//+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname)"
//+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname))>1"
//+" ) as temp"
//+" on"
//+" temp.firstname= u.firstname"
//+" and temp.secondname=u.secondname"
//+" and temp.lastname= u.lastname"
//+" where"
//+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
//+" order by u.firstname, u.secondname,"
//+" u.lastname limit 100000000";

                           String query="SELECT uniqueid,u.dicname,u.doe "
           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) ,"
                                   + " u.firstname, u.secondname,"
+"u.lastname from "
+"enrollment as u "
+" inner join("
+" select count(*) c ,firstname, secondname,dicname,doe,"
+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname ,\"\",dicname)"

+" from enrollment where"
+" (STR_TO_DATE(doe,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dicname)"
+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dicname))>1"
+" ) as temp"
+" on"
+" temp.firstname= u.firstname"
+" and temp.secondname=u.secondname"
+" and temp.lastname= u.lastname"
+ " and temp.dicname=u.dicname "
+ " and temp.doe=u.doe "
+" where"
+" (STR_TO_DATE(u.doe,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" order by u.firstname, u.secondname,"
+" u.lastname limit 100000000";
                        
                                            
                                            System.out.println("query for first one" + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQADUPLICATEBean DB= new DQADUPLICATEBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                       DB.setUNIQUEKEY(conn.rs.getString(4));
                        
                                final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString(5)!=null && !conn.rs.getString(5).trim().equals("") && !conn.rs.getString(5).equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString(5).trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString(5));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
//                                                      FirstName =  AES.getDecryptedString()  ;
                                                       DB.setFIRSTNAME(AES.getDecryptedString());
                                                   }
                                       
                          if(conn.rs.getString(6)!=null && !conn.rs.getString(6).trim().equals("") && !conn.rs.getString(6).equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString(6).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(6));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
//                    MiddleName=AES.getDecryptedString();
                     DB.setSECONDNAME(AES.getDecryptedString());
                          }
                      if(conn.rs.getString(7)!=null && !conn.rs.getString(7).trim().equals("") && !conn.rs.getString(7).equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs.getString(7).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(7));
//                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                     DB.setLASTNAME( AES.getDecryptedString());
                     
                    
                      }
                     
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
         }                           
                                        if(type.equals("fullnamedicdob")){
//                                        String query = "select UniqueID, DICName,DOB from enrollment where (STR_TO_DATE(DOB,'%e/%c/%Y'))>STR_TO_DATE('01/01/2004','%e/%c/%Y') ";
//                                       
//                                              String query="SELECT uniqueid,dicname,doe "
//           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , upper(u.firstname), upper(u.secondname),"
//+"upper(u.lastname) from "
//+"enrollment as u "
//+" inner join("
//+" select count(*) c ,firstname, secondname,"
//+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname)"
//
//+" from enrollment where"
//+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
//+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname)"
//+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname))>1"
//+" ) as temp"
//+" on"
//+" temp.firstname= u.firstname"
//+" and temp.secondname=u.secondname"
//+" and temp.lastname= u.lastname"
//+" where"
//+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
//+" order by u.firstname, u.secondname,"
//+" u.lastname limit 100000000";

                           String query="SELECT uniqueid,u.dicname,u.dob "
           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , u.firstname, u.secondname,"
+"u.lastname from "
+"enrollment as u "
+" inner join("
+" select count(*) c ,firstname, secondname,dicname,dob,"
+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname ,\"\",dicname)"

+" from enrollment where"
+" (STR_TO_DATE(doe,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dicname)"
+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dicname))>1"
+" ) as temp"
+" on"
+" temp.firstname= u.firstname"
+" and temp.secondname=u.secondname"
+" and temp.lastname= u.lastname"
+ " and temp.dicname=u.dicname "
+ " and temp.dob=u.dob "
+" where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" order by u.firstname, u.secondname,"
+" u.lastname limit 100000000";
                        
                                            
                                            System.out.println("query fro first " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQADUPLICATEBean DB= new DQADUPLICATEBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                       
                       
                       
                                final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString(5)!=null && !conn.rs.getString(5).trim().equals("") && !conn.rs.getString(5).equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString(5).trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString(5));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
//                                                      FirstName =  AES.getDecryptedString()  ;
                                                       DB.setFIRSTNAME(AES.getDecryptedString());
                                                   }
                                       
                          if(conn.rs.getString(6)!=null && !conn.rs.getString(6).trim().equals("") && !conn.rs.getString(6).equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString(6).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(6));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
//                    MiddleName=AES.getDecryptedString();
                     DB.setSECONDNAME(AES.getDecryptedString());
                          }
                      if(conn.rs.getString(7)!=null && !conn.rs.getString(7).trim().equals("") && !conn.rs.getString(7).equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs.getString(7).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(7));
//                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                     DB.setLASTNAME( AES.getDecryptedString());
                     
                    
                      }
                       DB.setUNIQUEKEY(conn.rs.getString(4));
                      
                      
                      
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
         }                           
                                        if(type.equals("fullnamedob")){
//                                        String query = "select UniqueID, DICName,DOB from enrollment where (STR_TO_DATE(DOB,'%e/%c/%Y'))>STR_TO_DATE('01/01/2004','%e/%c/%Y') ";
                                       
                                              String query="SELECT uniqueid,dicname,u.dob "
           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , u.firstname, u.secondname,"
+"u.lastname from "
+"enrollment as u "
+" inner join("
+" select count(*) c ,firstname, secondname,dob,  "
+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dob)"

+" from enrollment where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dob)"
+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dob))>1"
+" ) as temp"
+" on"
+" temp.firstname= u.firstname"
+" and temp.secondname=u.secondname"
+" and temp.lastname= u.lastname "
+ " and temp.dob = u.dob "
+" where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" order by u.firstname, u.secondname,"
+" u.lastname limit 100000000";

                                            
                                            
                                            System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQADUPLICATEBean DB= new DQADUPLICATEBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                       DB.setUNIQUEKEY(conn.rs.getString(4));
                                 final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString(5)!=null && !conn.rs.getString(5).trim().equals("") && !conn.rs.getString(5).equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString(5).trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString(5));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
//                                                      FirstName =  AES.getDecryptedString()  ;
                                                       DB.setFIRSTNAME(AES.getDecryptedString());
                                                   }
                                       
                          if(conn.rs.getString(6)!=null && !conn.rs.getString(6).trim().equals("") && !conn.rs.getString(6).equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString(6).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(6));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
//                    MiddleName=AES.getDecryptedString();
                     DB.setSECONDNAME(AES.getDecryptedString());
                          }
                      if(conn.rs.getString(7)!=null && !conn.rs.getString(7).trim().equals("") && !conn.rs.getString(7).equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs.getString(7).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(7));
//                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                     DB.setLASTNAME( AES.getDecryptedString());
                     
                    
                      }
                     
//                       DB.setFIRSTNAME(conn.rs.getString(5));
//                       DB.setSECONDNAME(conn.rs.getString(6));
//                       DB.setLASTNAME(conn.rs.getString(7));
                     
                       
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
         }                           
                                        if(type.equals("fullnamedic")){
//                                        String query = "select UniqueID, DICName,DOB from enrollment where (STR_TO_DATE(DOB,'%e/%c/%Y'))>STR_TO_DATE('01/01/2004','%e/%c/%Y') ";
                                       
                                              String query="SELECT uniqueid,u.dicname,doe "
           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , u.firstname, u.secondname,"
+"u.lastname from "
+"enrollment as u "
+" inner join("
+" select count(*) c ,firstname, secondname,dicname, "
+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname ,\"\",dicname)"

+" from enrollment where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dicname)"
+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname,\"\",dicname))>1"
+" ) as temp"
+" on"
+" temp.firstname= u.firstname"
+" and temp.secondname=u.secondname"
+" and temp.lastname= u.lastname"
+ " and temp.dicname=u.dicname "
+" where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" order by u.firstname, u.secondname,"
+" u.lastname limit 100000000";

                                            
                                            
                                            System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQADUPLICATEBean DB= new DQADUPLICATEBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                       DB.setUNIQUEKEY(conn.rs.getString(4));
//                       DB.setFIRSTNAME(conn.rs.getString(5));
//                       DB.setSECONDNAME(conn.rs.getString(6));
//                       DB.setLASTNAME(conn.rs.getString(7));
                     
                            final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString(5)!=null && !conn.rs.getString(5).trim().equals("") && !conn.rs.getString(5).equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString(5).trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString(5));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
//                                                      FirstName =  AES.getDecryptedString()  ;
                                                       DB.setFIRSTNAME(AES.getDecryptedString());
                                                   }
                                       
                          if(conn.rs.getString(6)!=null && !conn.rs.getString(6).trim().equals("") && !conn.rs.getString(6).equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString(6).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(6));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
//                    MiddleName=AES.getDecryptedString();
                     DB.setSECONDNAME(AES.getDecryptedString());
                          }
                      if(conn.rs.getString(7)!=null && !conn.rs.getString(7).trim().equals("") && !conn.rs.getString(7).equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs.getString(7).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(7));
//                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                     DB.setLASTNAME( AES.getDecryptedString());
                     
                    
                      }
                          
                    
                      
          
                       missingdata.add(DB);
                       
                      
        }
         }                           
                                        if(type.equals("fullname")){
//                                        String query = "select UniqueID, DICName,DOB from enrollment where (STR_TO_DATE(DOB,'%e/%c/%Y'))>STR_TO_DATE('01/01/2004','%e/%c/%Y') ";
                                       
                                              String query="SELECT uniqueid,dicname,doe "
           + ",CONCAT(upper(u.firstname),\"\", upper(u.secondname),\"\", upper(u.lastname)) , u.firstname,u.secondname,"
+"u.lastname from "
+"enrollment as u "
+" inner join("
+" select count(*) c ,firstname, secondname,"
+" lastname,CONCAT(firstname,\"\", secondname,\"\", lastname)"

+" from enrollment where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" group by  CONCAT(firstname,\"\", secondname,\"\", lastname)"
+" having count(CONCAT(firstname,\"\", secondname,\"\", lastname))>1"
+" ) as temp"
+" on"
+" temp.firstname= u.firstname"
+" and temp.secondname=u.secondname"
+" and temp.lastname= u.lastname"
+" where"
+" (STR_TO_DATE(DOE,'%e/%c/%Y')) BETWEEN (STR_TO_DATE('"+startdate+"','%e/%c/%Y')) AND (STR_TO_DATE('"+enddate+"','%e/%c/%Y'))"
+" order by u.firstname, u.secondname,"
+" u.lastname limit 100000000";

                                            
                                            
                                            System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(missingdata!=null && missingdata.size()>0 ){missingdata.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       DQADUPLICATEBean DB= new DQADUPLICATEBean();
                       DB.setUNIQUEID(conn.rs.getString(1));
                       DB.setDICNAME(conn.rs.getString(2));
                       DB.setDOE(conn.rs.getString(3));
                       DB.setUNIQUEKEY(conn.rs.getString(4));
//                       DB.setFIRSTNAME(conn.rs.getString(5));
//                       DB.setSECONDNAME(conn.rs.getString(6));
//                       DB.setLASTNAME(conn.rs.getString(7));
                     
                       
                              final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString(5)!=null && !conn.rs.getString(5).trim().equals("") && !conn.rs.getString(5).equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString(5).trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString(5));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
//                                                      FirstName =  AES.getDecryptedString()  ;
                                                       DB.setFIRSTNAME(AES.getDecryptedString());
                                                   }
                                       
                          if(conn.rs.getString(6)!=null && !conn.rs.getString(6).trim().equals("") && !conn.rs.getString(6).equals("null")){               
//                        
                    AES.decrypt(conn.rs.getString(6).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(6));
                    System.out.println("Decrypted : " + AES.getDecryptedString());
//                    MiddleName=AES.getDecryptedString();
                     DB.setSECONDNAME(AES.getDecryptedString());
                          }
                      if(conn.rs.getString(7)!=null && !conn.rs.getString(7).trim().equals("") && !conn.rs.getString(7).equals("null")){
//                      Lastname =  conn.rs2.getString("LastName");
                    AES.decrypt(conn.rs.getString(7).trim());
                     System.out.println("String To Decrypt : " + conn.rs.getString(7));
//                     LastName=AES.getDecryptedString();
                    System.out.println("Decrypted : " + AES.getDecryptedString());
                     DB.setLASTNAME( AES.getDecryptedString());
                     
                    
                      }
                     
                      
          
                       missingdata.add(DB);
                       
                      
        }
         }                           
                                     
                                     
                                     
                                     
                                     
                                     
                                     
       session.setAttribute("missingdata", missingdata);
         session.setAttribute("type",type);
         
         System.out.println(type);
       String nextJSP = "/admin/DQADUPLICATES.jsp";
                                        
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                                        dispatcher.forward(request,response);
//                                        conn.connect.close();
//                                        System.out.println("Disconnected from database");
        } catch (SQLException ex) {
            Logger.getLogger(DICServlet.class.getName()).log(Level.SEVERE, null, ex);
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
