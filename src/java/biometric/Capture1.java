package biometric;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.digitalpersona.uareu.*;
import dbConnect.AES;
import dbConnect.dbConnect;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

public class Capture1 
	extends JPanel
	implements ActionListener
{
	private static final long serialVersionUID = 2;
	private static final String ACT_BACK = "back";
	private static final String ACT_ENROLL = "enrolluser";

	private JDialog       m_dlgParent;
	private CaptureThread m_capture;
	private Reader        m_reader;
        private String uniqid;
        private String capturedhand;
        private String capturedfinger;
	private ImagePanel    m_image;
	private boolean       m_bStreaming;
        public static String Fingerprintstr1="";
        
        private int generalcounter=0;
	
	private Capture1(Reader reader, boolean bStreaming,String uniqueid, String hand,String finger){
		m_reader = reader;
		m_bStreaming = bStreaming;
		uniqid=uniqueid;
                capturedhand=hand;
                capturedfinger=finger;
                Fingerprintstr1="";
                
		m_capture = new CaptureThread(m_reader, m_bStreaming, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);

		final int vgap = 5;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		m_image = new ImagePanel();
		Dimension dm = new Dimension(380, 380);
		m_image.setPreferredSize(dm);
		add(m_image);
		add(Box.createVerticalStrut(vgap));
		
		JButton btnBack = new JButton("Ok");
		btnBack.setActionCommand(ACT_BACK);
		btnBack.addActionListener(this);
		add(btnBack);
                
                add(Box.createVerticalStrut(vgap));
//		JButton btnsave = new JButton("Enroll user");
//		btnsave.setActionCommand(ACT_ENROLL);
//		btnsave.addActionListener(this);
//		add(btnsave);
//		add(Box.createVerticalStrut(vgap));
	}
	
	private void StartCaptureThread(){
		m_capture = new CaptureThread(m_reader, m_bStreaming, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);
		m_capture.start(this);
	                                }

	private void StopCaptureThread(){
		if(null != m_capture) m_capture.cancel();
	}
	
	private void WaitForCaptureThread(){
		if(null != m_capture) m_capture.join(1000);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(ACT_BACK)){
           
                //event from "back" button
                //cancel capture
            m_dlgParent.setVisible(false);
          
                StopCaptureThread();
                 // m_dlgParent.dispose();
               // m_reader.Close();
                
            
                        
		}
//                else if(e.getActionCommand().equals(ACT_ENROLL)){
//			//event from "back" button
//			//cancel capture
//			//Enrollment.Run(m_reader);
//                        
//		}
		else if(e.getActionCommand().equals(CaptureThread.ACT_CAPTURE)){
			//event from capture thread
			CaptureThread.CaptureEvent evt = (CaptureThread.CaptureEvent)e;
			boolean bCanceled = false;
			
			if(null != evt.capture_result){
				if(null != evt.capture_result.image && Reader.CaptureQuality.GOOD == evt.capture_result.quality){
					//display image
					m_image.showImage(evt.capture_result.image);
                            
                                  Engine engine = UareUGlobal.GetEngine();      
                                        
                                        
                                    Fid myfid=evt.capture_result.image;    
                                    
                                    
                                    
                                    
                    try {
                        
                        
                        Fmd myfmd=engine.CreateFmd(myfid, Fmd.Format.ANSI_378_2004);
                   //  Fmd fmd = engine.CreateEnrollmentFmd(Fmd.Format.ANSI_378_2004, this);
                        
                         byte [] fb= myfmd.getData();
                       
                       
               //save to the database..
                       
                        Fingerprintstr1=bytesToHexString1(fb);
                       
//SessionKeeper select = new SessionKeeper();

//select.holdfingerprint(uniqid, bytesToHexString1(fb));

                   boolean dbsaved = savetodb1(uniqid,capturedhand, bytesToHexString1(fb),capturedfinger);
System.out.println("capturedfinger "+capturedfinger);

                    if (dbsaved) {
                        

                        String str = String.format("____________User details saved to db successfully______________");
                        //m_text.append(str);

                    }
                    generalcounter++;
                    
                    
                    if(generalcounter==1){
                    
                    Fid previouscapture=evt.capture_result.image;
                    
                    }
                    
                    if(generalcounter==2){
                    
                    
                    
                    
                    }
                    
                   
                        
                        
                    } catch (UareUException ex) {
                        Logger.getLogger(Capture.class.getName()).log(Level.SEVERE, null, ex);
                    }
                         
                    
                    
                    
                    
                    


//================================================================================================================  
                    
                    
                                        
                                         BufferedImage myimage;
                                         //extract view from 
                  
                                         
                                         //save the image as a file
                                         
//                  Fiv view = evt.capture_result.image.getViews()[0];
//		  myimage = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
//                  myimage.getRaster().setDataElements(0, 0, view.getWidth(), view.getHeight(), view.getImageData());
//                  
            URL location = dbConnect.class.getProtectionDomain().getCodeSource().getLocation();


           String mydrive = location.getFile().substring(1, 2);
                  
                            File outputfile = new File(mydrive+":\\DIC_DBBACKUP\\fingerprint.jpg");
                   // try {
                        
                        
                        
                       // ImageIO.write(myimage, "jpg", outputfile);
                        
                        
                        
                   // } catch (IOException ex) {
                        //Logger.getLogger(Capture.class.getName()).log(Level.SEVERE, null, ex);
                    //}


                                        
				}
				else if(Reader.CaptureQuality.CANCELED == evt.capture_result.quality){
					//capture or streaming was canceled, just quit
					bCanceled = true;
				}
				else{
					//bad quality
                                    
                                    System.out.println("bad quality image");
                                    
					MessageBox.BadQuality(evt.capture_result.quality);
				}
			}
			else if(null != evt.exception){
				//exception during capture
				MessageBox.DpError("Capture",  evt.exception);
                                
                                System.out.println("Exception during capture");
                                
				bCanceled = true;
			}
			else if(null != evt.reader_status){
				MessageBox.BadStatus(evt.reader_status);
                                System.out.println("Exception during capture");
                                
				bCanceled = true;
			}
			
			if(!bCanceled){
				if(!m_bStreaming){
					//restart capture thread
					WaitForCaptureThread();
					StartCaptureThread();
				}
			}
			else{
				//destroy dialog
				m_dlgParent.setVisible(false);
			}
		}
	}

	private void doModal(JDialog dlgParent){
		//open reader
		try{
			m_reader.Open(Reader.Priority.COOPERATIVE);
		}
		catch(UareUException e){ 
                    
                   System.out.println("Exception while opening object");
                    
                   MessageBox.DpError("Reader.Open()", e);
                
                }
		
		boolean bOk = true;
		if(m_bStreaming){
			//check if streaming supported
			Reader.Capabilities rc = m_reader.GetCapabilities();
			if(!rc.can_stream){
                            System.out.println("This reader does not support streaming");
                            
				MessageBox.Warning("This reader does not support streaming");
				bOk = false;
			}
		}
		
		if(bOk){
			//start capture thread
			StartCaptureThread();
	
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
		}
		
		//close reader
		try{
			m_reader.Close();
		}
		catch(UareUException e){
                System.out.println("error while closing reader");    
                    
                    MessageBox.DpError("Reader.Close()", e); 
                }
	}
	
        
        
        
         //==========================a function to convert bytes to string==============================================
    public static String bytesToHexString1(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }

//=============================================METHOD TO SAVE CONTENTS TO THE DATABASE=====================================           
    public boolean savetodb1(String uid,String hands, String fingerprint,String capturedfingers) {
        try {

            String fpr = fingerprint;
            String handss=hands;
            String fingers=capturedfingers;
            dbConnect conn = new dbConnect();
String biofing="";
System.out.println(fpr);
String checkifexist="select * from enrollment where UniqueID='" + uid + "'";
conn.rs2 = conn.state2.executeQuery(checkifexist);
if(conn.rs2.next()==true){
   final  String strPssword ="?*1>9@(&#";    
              AES.setKey(strPssword);
              
                if(fpr!=null && !fpr.trim().equals("") && !fpr.equals("null")){
                    
                    
                      AES.encrypt (fpr.trim());
                    System.out.println("String to Encrypt:_______+++++++ " + fpr); 
                   System.out.println("Encrypted:_______+++++++ " + AES.getEncryptedString());
                    biofing=AES.getEncryptedString();
                     }
            String addtodb = "update enrollment SET fingerprint='" + biofing + "', capturedhand='"+handss+"',capturedfinger='"+fingers+"', syncstatus='0' where UniqueID='" + uid + "'";

            System.out.println(addtodb);

            if (!uid.trim().equals("") && !fingerprint.equals("")) {
                conn.state1.executeUpdate(addtodb);
                
            }
}
else{


System.out.println("Should be an insert");

}


            
            conn.state1.close();

         //   m_dlgParent.setVisible(false);




        } catch (SQLException ex) {
            Logger.getLogger(saveEditedFingerprint.class.getName()).log(Level.SEVERE, null, ex);
            return false;


        }

        return true;
    }//end of savetodb method

        
        
        
        
	public static String Run(Reader reader, boolean bStreaming,String uniqueid, String chand,String cfinger){
    	JDialog dlg = new JDialog((JDialog)null, "Update Fingerprint", true);
    	Capture1 capture = new Capture1(reader, bStreaming,uniqueid,chand,cfinger);
    	capture.doModal(dlg);
        //======
        return Fingerprintstr1;
	}
        
        
        
        
        
}
