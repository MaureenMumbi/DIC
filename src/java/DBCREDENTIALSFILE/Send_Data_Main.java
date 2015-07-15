/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCREDENTIALSFILE;

import dbConnect.dbConnect;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Maureen
 */
public class Send_Data_Main {
 public String filenames,cu,dates,computername,senderofmail;
        
 String full_date;
    public Send_Data_Main(){
    }  
 public void Sendattachments (String date,String path,String comp, String senderofmail,String filname,String location)throws MessagingException, SQLException {
     String toAddress="";
     
     dbConnect conn= new dbConnect();
        try {
            conn.rs=conn.state.executeQuery("select email from mail where mailid='2'");
            
            while(conn.rs.next()){
                toAddress+=conn.rs.getString(1);
            System.out.println("To address"+toAddress);
            }
             if(!toAddress.equals("")){
        toAddress+=",";
        }
//           conn.rs.close();
           conn.state.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Send_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
       String versionname="";
        String version ="select * from version";
        conn.rs3 = conn.state3.executeQuery(version);
        while(conn.rs3.next()){
        versionname = conn.rs3.getString("version_name").replace(" ","_");
        }
        System.out.println(version);
        filenames=path; 
        full_date=date;
        computername=comp;
       senderofmail=senderofmail;
        String textBody="Hi ,\n Attached is DIC data back up as at "+full_date+" "+senderofmail+".\n*******This is a system autogenerated message*****";
    
       toAddress+="mollymumbi@gmail.com,jkuria@aphiarift.org";
        String host = "smtp.mail.yahoo.com";
        String Password ="Nuruyabonde2014";
        String from = "aphiabackup@yahoo.com";
        // toAddress = "aphiapluschwsattendance@gmail.com";  filled above...
        String filename = filenames;
        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("DIC DATA BACK_UP From : "+computername);

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(textBody);

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filename);

        messageBodyPart.setDataHandler(new DataHandler(source));

//        messageBodyPart.setFileName(filname+"_DIC.sql");
         messageBodyPart.setFileName(filname+""+location+""+versionname+".sql");
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
System.out.println(textBody+"___"+filname);
        try {
            javax.mail.Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }
    }

    
}   
