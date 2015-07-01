/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

import dbConnect.dbConnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emmanuel E
 */
public class Migrateencdata {
    
    
    
    public static void main(String args[]) {
        try {
            dbConnect conn= new dbConnect();
            
            String selectdata="Select UniqueID,FirstName,SecondName,LastName, PhoneNo,fingerprint from enrollment  where ( PhoneNo not like '%==' && FirstName not like '%==' && SecondName not like '%==' && LastName not like '%=='  ) ";            
            conn.rs=conn.state.executeQuery(selectdata);
            AES aes=new AES();
            String val=AES.encrypt("yes");
        System.out.println(" Encrypted: " + AES.getEncryptedString());
            
            while(conn.rs.next()){
                String update="update enrollment set ";                
           // System.out.println("__"+conn.rs.getString(2));
            if(conn.rs.getString("FirstName")!=null&&!conn.rs.getString("FirstName").equals("null")&& !conn.rs.getString("FirstName").trim().equals("")){
            AES.encrypt(conn.rs.getString("FirstName").trim());
            String fname=AES.getEncryptedString();
            update+=" FirstName='"+fname+"' , ";
            //AES.decrypt(fname);
            //System.out.println(" Decrepted name__"+AES.getDecryptedString());
            
                                                     }
            else {
              update+=" FirstName='' , ";
            }
            if(conn.rs.getString("SecondName")!=null&&!conn.rs.getString("SecondName").equals("null")&& !conn.rs.getString("SecondName").trim().equals("")){
            AES.encrypt(conn.rs.getString("SecondName").trim());
            String mname=AES.getEncryptedString();
            update+=" SecondName='"+mname+"' , ";
                                                     }
             else {
              update+=" SecondName='' , ";
            }
            
            
             if(conn.rs.getString("LastName")!=null&&!conn.rs.getString("LastName").equals("null")&& !conn.rs.getString("LastName").trim().equals("")){
            AES.encrypt(conn.rs.getString("LastName").trim());
            String lname=AES.getEncryptedString();
            update+=" LastName='"+lname+"' , ";
                                                     }
             else {
              update+=" LastName='' , ";
            }
            
             
              if(conn.rs.getString("PhoneNo")!=null&&!conn.rs.getString("PhoneNo").equals("null")&& !conn.rs.getString("PhoneNo").trim().equals("")){
            AES.encrypt(conn.rs.getString("PhoneNo").trim());
            String phone=AES.getEncryptedString();
            update+=" PhoneNo='"+phone+"' , ";
                                                     }
             else {
              update+=" PhoneNo='' , ";
            }
            System.out.println("Fingerprint_" + conn.rs.getString("fingerprint")+"_");
                if (conn.rs.getString("fingerprint") != null && !conn.rs.getString("fingerprint").equals("null")&& !conn.rs.getString("fingerprint").trim().equals("")) {
                    AES.encrypt(conn.rs.getString("fingerprint").trim());
                    String fp = AES.getEncryptedString();
                    update += " fingerprint='" + fp + "'  ";
                    
                    //AES.decrypt(fp);
                   // System.out.println(" Decrepted Fingerprint__" + AES.getDecryptedString());
                } else {
                    update += " fingerprint='' ";
                }
                //null
             update+=" where  UniqueID='"+conn.rs.getString("UniqueID")+"' ";
              
                System.out.println(update); 
             conn.state2.executeUpdate(update);
            }//end of while 
            
        } catch (SQLException ex) {
            Logger.getLogger(Migrateencdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
