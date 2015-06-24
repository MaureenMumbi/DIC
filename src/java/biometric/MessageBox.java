/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

/**
 *
 * @author SIXTYFOURBIT
 */
import javax.swing.JOptionPane;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.UareUException;
import java.awt.Window.Type;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class MessageBox {
	public static void BadQuality(Reader.CaptureQuality q){
		JOptionPane.showMessageDialog(null, q.toString(), "Bad quality", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void BadStatus(Reader.Status s){
		String str = String.format("Reader status: %s", s.toString());
		JOptionPane.showMessageDialog(null, str, "Reader status", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void DpError(String strFunctionName, UareUException e){
		String str = String.format("%s returned DP error %d \n%s", strFunctionName, (e.getCode() & 0xffff), e.toString());
		JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void Warning(String strText){
		JOptionPane.showMessageDialog(null, strText, "Warning", JOptionPane.WARNING_MESSAGE);
                
//                JOptionPane optionPane = new JOptionPane();
//                
//                
//                
//                optionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
//         JDialog dialog = optionPane.createDialog("BIOMETRIC SYSTEM WARNING");
//
//             JLabel text= new JLabel();
//                 text.setText(strText);
//                   dialog.add(text);
//
//                dialog.setAlwaysOnTop(true);
//                  dialog.setVisible(true);
                
	}
}
