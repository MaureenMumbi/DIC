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
import java.lang.reflect.InvocationTargetException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.digitalpersona.uareu.*;
import dbConnect.dbConnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class saveEditedFingerprint
        extends JPanel
        implements ActionListener {

    public class EnrollmentThread1 extends Thread implements Engine.EnrollmentCallback {

        public static final String ACT_PROMPT1 = "enrollment_prompt";
        public static final String ACT_CAPTURE1 = "enrollment_capture";
        public static final String ACT_FEATURES1 = "enrollment_features";
        public static final String ACT_DONE1 = "enrollment_done";
        public static final String ACT_CANCELED1 = "enrollment_canceled";

        public class EnrollmentEvent1 extends ActionEvent {

            private static final long serialVersionUID1 = 102;
            public Reader.CaptureResult capture_result1;
            public Reader.Status reader_status1;
            public UareUException exception1;
            public Fmd enrollment_fmd1;

            public EnrollmentEvent1(Object source, String action, Fmd fmd, Reader.CaptureResult cr, Reader.Status st, UareUException ex) {
                super(source, ActionEvent.ACTION_PERFORMED, action);
                capture_result1 = cr;
                reader_status1 = st;
                exception1 = ex;
                enrollment_fmd1 = fmd;
            }
        }
        
        private final Reader m_reader;
        private CaptureThread m_capture1;
        private ActionListener m_listener;
        private boolean m_bCancel;

        protected EnrollmentThread1(Reader reader, ActionListener listener) {
            m_reader = reader;
            m_listener = listener;
        }

        public Engine.PreEnrollmentFmd GetFmd(Fmd.Format format) {
            Engine.PreEnrollmentFmd prefmd = null;

            while (null == prefmd && !m_bCancel) {
                //start capture thread
                m_capture1 = new CaptureThread(m_reader, false, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);
                m_capture1.start(null);

                System.out.println("prompting for a fingerprint from user");
                
                
                //prompt for finger
                SendToListener(ACT_PROMPT1, null, null, null, null);

                //wait till done
                m_capture1.join(0);

                //check result
                CaptureThread.CaptureEvent evt = m_capture1.getLastCaptureEvent();
                if (null != evt.capture_result) {
                    if (Reader.CaptureQuality.CANCELED == evt.capture_result.quality) {
                        //capture canceled, return null
                        break;
                    } else if (null != evt.capture_result.image && Reader.CaptureQuality.GOOD == evt.capture_result.quality) {
                        //acquire engine
                        Engine engine = UareUGlobal.GetEngine();

                        try {
                            //extract features
                            Fmd fmd = engine.CreateFmd(evt.capture_result.image, Fmd.Format.ANSI_378_2004);

                            //return prefmd 
                            prefmd = new Engine.PreEnrollmentFmd();
                            prefmd.fmd = fmd;
                            prefmd.view_index = 0;

                            //send success
                            SendToListener(ACT_FEATURES1, null, null, null, null);
                        } catch (UareUException e) {
                            //send extraction error
                            SendToListener(ACT_FEATURES1, null, null, null, e);
                        }
                    } else {
                        //send quality result
                        SendToListener(ACT_CAPTURE1, null, evt.capture_result, evt.reader_status, evt.exception);
                    }
                } else {
                    //send capture error
                    SendToListener(ACT_CAPTURE1, null, evt.capture_result, evt.reader_status, evt.exception);
                }
            }

            return prefmd;
        }

        public void cancel() {
            m_bCancel = true;
            if (null != m_capture1) {
                m_capture1.cancel();
            }
        }

        private void SendToListener(String action, Fmd fmd, Reader.CaptureResult cr, Reader.Status st, UareUException ex) {
            if (null == m_listener || null == action || action.equals("")) {
                
                System.out.println("MLISTENER IS EITHER NULL OR ACTION IS NULL");
                return;
            }

            final saveEditedFingerprint.EnrollmentThread1.EnrollmentEvent1 evt = new saveEditedFingerprint.EnrollmentThread1.EnrollmentEvent1(this, action, fmd, cr, st, ex);

            //invoke listener on EDT thread
            try {
                javax.swing.SwingUtilities.invokeAndWait(new Runnable() {

                    public void run() {
                        m_listener.actionPerformed(evt);
                    }
                });
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            //acquire engine
            Engine engine = UareUGlobal.GetEngine();

            try {
                m_bCancel = false;
                while (!m_bCancel) {
                    //run enrollment
                    Fmd fmd = engine.CreateEnrollmentFmd(Fmd.Format.ANSI_378_2004, this);

                    //send result
                    if (null != fmd) {
                        SendToListener(ACT_DONE1, fmd, null, null, null);
                    } else {
                        SendToListener(ACT_CANCELED1, null, null, null, null);
                        break;
                    }
                }
            } catch (UareUException e) {
                SendToListener(ACT_DONE1, null, null, null, e);
            }
        }
    }
    private static final long serialVersionUID = 6;
    private static final String ACT_BACK = "back";
    private saveEditedFingerprint.EnrollmentThread1 m_enrollment1;
    private String chwid;
    private Reader m_reader;
    private JDialog m_dlgParent;
    private JTextArea m_text;
    private boolean m_bJustStarted;

    private saveEditedFingerprint(Reader reader, String chwidentity) {
        chwid = chwidentity;
        m_reader = reader;
        m_bJustStarted = true;
        m_enrollment1 = new saveEditedFingerprint.EnrollmentThread1(m_reader, this);

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

        JButton btnBack = new JButton("Back");
        btnBack.setActionCommand(ACT_BACK);
        btnBack.addActionListener(this);
        add(btnBack);
        add(Box.createVerticalStrut(vgap));

        setOpaque(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACT_BACK)) {
            //destroy dialog to cancel enrollment
            m_dlgParent.setVisible(false);
        } else {
            saveEditedFingerprint.EnrollmentThread1.EnrollmentEvent1 evt = (saveEditedFingerprint.EnrollmentThread1.EnrollmentEvent1) e;

            if (e.getActionCommand().equals(saveEditedFingerprint.EnrollmentThread1.ACT_PROMPT1)) {
                if (m_bJustStarted) {
                    m_text.append("Enrollment started\n");
                    m_text.append("    put your thumb finger on the reader\n");
                } else {
                    m_text.append("    put the same finger on the reader\n");
                }
                m_bJustStarted = false;
            } else if (e.getActionCommand().equals(saveEditedFingerprint.EnrollmentThread1.ACT_CAPTURE1)) {
                if (null != evt.capture_result1) {
                    MessageBox.BadQuality(evt.capture_result1.quality);
                } else if (null != evt.exception1) {
                    MessageBox.DpError("Capture", evt.exception1);
                } else if (null != evt.reader_status1) {
                    MessageBox.BadStatus(evt.reader_status1);
                }
                m_bJustStarted = false;
            } else if (e.getActionCommand().equals(saveEditedFingerprint.EnrollmentThread1.ACT_FEATURES1)) {
                if (null == evt.exception1) {
                    m_text.append("    fingerprint captured, features extracted\n\n");
                } else {
                    MessageBox.DpError("Feature extraction", evt.exception1);
                }
                m_bJustStarted = false;
            } else if (e.getActionCommand().equals(saveEditedFingerprint.EnrollmentThread1.ACT_DONE1)) {
                if (null == evt.exception1) {




                    //return the fowarded bytes at this stage
//===============================================================================================================                                        
                    Fmd fpdata = evt.enrollment_fmd1;


                    byte[] fb = fpdata.getData();


                    //save to the database..



                    boolean dbsaved = savetodb1(chwid, bytesToHexString1(fb));


                    if (dbsaved) {

                        String str = String.format("____________User details saved to db successfully______________");
                        m_text.append(str);



                    }


//================================================================================================================  




                } else {
                    MessageBox.DpError("Enrollment template creation", evt.exception1);
                }
                m_bJustStarted = true;
            } else if (e.getActionCommand().equals(saveEditedFingerprint.EnrollmentThread1.ACT_CANCELED1)) {
                //canceled, destroy dialog
                m_dlgParent.setVisible(false);
            }

            //cancel enrollment if any exception or bad reader status
            if (null != evt.exception1) {
                m_dlgParent.setVisible(false);
            } else if (null != evt.reader_status1 && Reader.ReaderStatus.READY != evt.reader_status1.status && Reader.ReaderStatus.NEED_CALIBRATION != evt.reader_status1.status) {
                m_dlgParent.setVisible(false);
            }
        }
    }

    private void doModal(JDialog dlgParent) {
        //open reader
        try {
            
            m_reader.Open(Reader.Priority.COOPERATIVE);
            
            
        } catch (UareUException e) {
            MessageBox.DpError("Reader.Open()", e);
        }

        //start enrollment thread
        m_enrollment1.start();

        //bring up modal dialog
        m_dlgParent = dlgParent;
        m_dlgParent.setContentPane(this);
        m_dlgParent.pack();
        m_dlgParent.setLocationRelativeTo(null);
        m_dlgParent.setVisible(true);
        m_dlgParent.dispose();

        //stop enrollment thread
        m_enrollment1.cancel();

        //close reader
        try {
            m_reader.Close();
        } catch (UareUException e) {
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
    public boolean savetodb1(String chwid, String fingerprint) {
        try {

            String fpr = fingerprint;
            dbConnect conn = new dbConnect();




            String addtodb = "update chws SET fingerprint='" + fpr + "', active='1' where chwid='" + chwid + "'";

            System.out.println(addtodb);

            if (!chwid.trim().equals("") && !fingerprint.equals("")) {
                conn.state1.executeUpdate(addtodb);
            }



            conn.state1.close();

         //   m_dlgParent.setVisible(false);




        } catch (SQLException ex) {
            Logger.getLogger(saveEditedFingerprint.class.getName()).log(Level.SEVERE, null, ex);
            return false;


        }

        return true;
    }//end of savetodb method

    public static boolean Run(Reader reader, String chwid) {
        JDialog dlg = new JDialog((JDialog) null, "Enrollment", true);
        saveEditedFingerprint enrollment = new saveEditedFingerprint(reader, chwid);
        enrollment.doModal(dlg);

        System.out.println("CHWID::" + chwid);

        return true;

    }
}
