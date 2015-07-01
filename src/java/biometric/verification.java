/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

/**
 *
 * @author SIXTYFOURBIT
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.digitalpersona.uareu.*;
import dbConnect.AES;
import dbConnect.dbConnect;
import java.math.BigInteger;
import java.util.Calendar;

public class verification 
	extends JPanel
	implements ActionListener
{
	private static final long serialVersionUID = 6;
	private static final String ACT_BACK = "back";

	private CaptureThread m_capture;
	private Reader  m_reader;
	private Fmd[]   m_fmds;
          private    Fmd dbfmd;
	private JDialog m_dlgParent;
	private JTextArea m_text;
//        private String locationid;
//        private String tdate;
	 public static String Uniqid="";
           String decfingerprint="" ;
      
	private final String m_strPrompt1 = "Verification started\n    put your registered finger on the reader\n\n";
	private final String m_strPrompt2 = "    put the same or any other finger on the reader\n\n";

	private verification(Reader reader){
		m_reader = reader;
		m_fmds = new Fmd[2]; //two FMDs to perform comparison

            Uniqid="";
           
             
		final int vgap = 5;
		final int width = 380;
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		m_text = new JTextArea(22, 1);
		m_text.setEditable(false);
		JScrollPane paneReader = new JScrollPane(m_text);
		add(paneReader);
		Dimension dm = paneReader.getPreferredSize();
		dm.width = width;
		paneReader.setPreferredSize(dm);
		
		add(Box.createVerticalStrut(vgap));
		
		JButton btnBack = new JButton("OK");
		btnBack.setActionCommand(ACT_BACK);
		btnBack.addActionListener(this);
		add(btnBack);
		add(Box.createVerticalStrut(vgap));

		setOpaque(true);
                
                
	}

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(ACT_BACK)){
			//cancel capture
			StopCaptureThread();
		}
		else if(e.getActionCommand().equals(CaptureThread.ACT_CAPTURE)){
			//process result
			CaptureThread.CaptureEvent evt = (CaptureThread.CaptureEvent)e;
			if(ProcessCaptureResult(evt)){
				//restart capture thread
				WaitForCaptureThread();
				StartCaptureThread();
			}
			else{
				//destroy dialog
				m_dlgParent.setVisible(false);
			}
		}
	}
	
	private void StartCaptureThread(){
		m_capture = new CaptureThread(m_reader, false, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);
		m_capture.start(this);
	}
	
	private void StopCaptureThread(){
		if(null != m_capture) m_capture.cancel();
	}
	
	private void WaitForCaptureThread(){
		if(null != m_capture) m_capture.join(1000);
	}
	
	private boolean ProcessCaptureResult(CaptureThread.CaptureEvent evt){
		boolean bCanceled = false;

		if(null != evt.capture_result){
			if(null != evt.capture_result.image && Reader.CaptureQuality.GOOD == evt.capture_result.quality){
				//extract features
				Engine engine = UareUGlobal.GetEngine();
					
				try{
					Fmd fmd = engine.CreateFmd(evt.capture_result.image, Fmd.Format.ANSI_378_2004);
                                        
                                        
                                        
					if(null == m_fmds[0]) m_fmds[0] = fmd;
					//else if(null == m_fmds[1]) m_fmds[1] = fmd;
				}
				catch(UareUException e){ MessageBox.DpError("Engine.CreateFmd()", e); }
			
                                //once user details have been captured
                                
				if(null != m_fmds[0] ){
                    try {
                        //========================================DB COMPARISON======================================================                             
                                                     //select * from the database
                                                     
                                           dbConnect conn = new dbConnect();

                        System.out.println("Performing Fingerprint Comparison");

                        
                        //read the chws whose fingerprints are captured
                        
                        conn.rs = conn.state.executeQuery("select * from enrollment where fingerprint!='new data' || fingerprint!=''");
                        int mycount=0;
                        
                         int userdetacted=0;  
                        while (conn.rs.next()) {
                            mycount++;
                            try {
                                  final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
                         if(conn.rs.getString("fingerprint")!=null && !conn.rs.getString("fingerprint").trim().equals("") 
                                 && !conn.rs.getString("fingerprint").equals("null")){
                                    
                                        AES.decrypt(conn.rs.getString("fingerprint").trim());
                                       System.out.println("String To Decrypt : " +  conn.rs.getString("fingerprint"));
                                       System.out.println("Decrypted : " + AES.getDecryptedString());
                                                   
                                                      decfingerprint =  AES.getDecryptedString()  ;
                                                   }
                               if(decfingerprint!=null&&!decfingerprint.equals("")){
                                
                                
                      //get fingerprint data from the database data from the database
                                //convert data back into bytes
                                byte[] fp = new BigInteger(decfingerprint,16).toByteArray();
                                
                                
               dbfmd=UareUGlobal.GetImporter().ImportFmd(fp,Fmd.Format.ANSI_378_2004,Fmd.Format.ANSI_378_2004);
                          
                                //perform comparison
                                try {
                                    
                      int falsematch_rate = engine.Compare(m_fmds[0], 0, dbfmd, 0);
                                    

                       int target_falsematch_rate = Engine.PROBABILITY_ONE / 100000; //target rate is 0.00001
                                    
                                 
                       if (falsematch_rate < target_falsematch_rate) {
                                        
                            userdetacted=1;
                            Uniqid=conn.rs.getString("UniqueID");
//                            String texttodisplay="___"+conn.rs.getString("FirstName") +" "+conn.rs.getString("LastName") +" has matched \n";
                            
                            // Toolkit.getDefaultToolkit().beep(); 
                      // m_text.append("___Match Found___\n");
                     
                        System.out.println("Fingerprints matched"+Uniqid);                
                          
                          Calendar cal = Calendar.getInstance();

       int hour = cal.get(Calendar.HOUR_OF_DAY);
       int min = cal.get(Calendar.MINUTE);
       int sec = cal.get(Calendar.SECOND);
                        
          String time_of_day=hour+":"+min+":"+sec;              
                        //insert into attendance register
          
          
//          String chwid=conn.rs.getString("chwid") ;
//          
//                        String myqry="Insert into attendance(venueid,chwid,date,timein,Agenda)values('"+locationid+"','"+chwid +"','"+tdate+"','"+time_of_day+"','Reports')";
//                        System.out.println(myqry);
//                        
//                        //avoid saving chwid twice..
//                        
//                        conn.rs4=conn.state4.executeQuery("select * from attendance where chwid='"+chwid+"' and date='"+tdate+"'");
//                        
//                        if(!conn.rs4.next()){
//                             
//                        conn.state3.executeUpdate(myqry);
//                        
//                        }
//                        
//                        else{
//                        
//                       System.out.println("user already checked in_____\n"); 
//                       texttodisplay="___"+conn.rs.getString("fname") +" "+conn.rs.getString("lname") +" has AlREADY checked in_____\n"; 
//                       
//                        }
                        
                          m_text.append("Fingerprint Matched");
                        
                        
                       String str = String.format("dissimilarity score: 0x%x.\n", falsematch_rate);
                                      
                                        
                                        //m_text.append(str);
                       str = String.format("false match rate: %e.\n\n\n", (double) (falsematch_rate / Engine.PROBABILITY_ONE));
                                       
                                      //  m_text.append(str);
                       
                       //return userid to the servlet
                       
                       
                       
                       //break out of the loop
                      // m_dlgParent.setVisible(false); 
                       break;
                       
                       
                       } else {
                                        
                       //fr that row, no user was found
                       System.out.println("aaaaaaa");
                       
                       }
                       
                       //
                       
                       
                                } catch (UareUException e) {
                                    MessageBox.DpError("Engine.CreateFmd()", e);
                                }
                                
                                }//end of if that avoids duplicate

                            
                            } catch (UareUException ex) {
                                Logger.getLogger(verification.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                                   
                            System.out.println("Dbase Row no:"+mycount);
                                                     
                                                     }//end of db while
                                                     
                                if(userdetacted==0){
                                    
                                    m_text.append("No matching fingerprint was found in the database.\n Ensure You are using the registered finger\n\n");
                               
                                
                                }                        
                                                                 
                                                         //discard FMDs
                                                         m_fmds[0] = null;
                                                         m_fmds[1] = null;

                                                         //the new loop starts
                                                         m_text.append(m_strPrompt1);
                                                         
                                                         //close the db connections
                                                         
                                                         conn.state.close();
                                                         conn.state3.close();
                                                         conn.state4.close();
                                                         
                                                        
                                                         
                    } catch (SQLException ex) {
                        Logger.getLogger(verification.class.getName()).log(Level.SEVERE, null, ex);
                    }
				}
				else{
					//the loop continues
					m_text.append(m_strPrompt2);
				}
			}
			else if(Reader.CaptureQuality.CANCELED == evt.capture_result.quality){
				//capture or streaming was canceled, just quit
				bCanceled = true;
			}
			else{
				//bad quality
				MessageBox.BadQuality(evt.capture_result.quality);
			}
		}
		else if(null != evt.exception){
			//exception during capture
			MessageBox.DpError("Capture", evt.exception);
			bCanceled = true;
		}
		else if(null != evt.reader_status){
			//reader failure
			MessageBox.BadStatus(evt.reader_status);
			bCanceled = true;
		}

		return !bCanceled;
	}

	private void doModal(JDialog dlgParent){
		//open reader
		try{
			m_reader.Open(Reader.Priority.COOPERATIVE);
		}
		catch(UareUException e){ MessageBox.DpError("Reader.Open()", e); }
		
		//start capture thread
		StartCaptureThread();

		//put initial prompt on the screen
		m_text.append(m_strPrompt1);
		
		//bring up modal dialog
		m_dlgParent = dlgParent;
		m_dlgParent.setContentPane(this);
                m_dlgParent.setAlwaysOnTop(true);
		m_dlgParent.pack();
		m_dlgParent.setLocationRelativeTo(null);
		m_dlgParent.toFront();
		m_dlgParent.setVisible(true);
		m_dlgParent.dispose();
		
		//cancel capture
		StopCaptureThread();
		
		//wait for capture thread to finish
		WaitForCaptureThread();
		
		//close reader
		try{
			m_reader.Close();
		}
		catch(UareUException e){ MessageBox.DpError("Reader.Close()", e); }
	}
	
        
        
       
        
        
        
	public static String Run(Reader reader){
    	JDialog dlg = new JDialog((JDialog)null, "CHECK IN USING YOUR REGISTERED FINGERPRINT", true);
    	verification verification = new verification(reader);
    	verification.doModal(dlg);
        
        return Uniqid;
        
	}
}
