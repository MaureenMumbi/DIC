    
package dbConnect;
//http://aesencryption.net/
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
    /**
    Aes encryption
    */
    public class Destest
    {
        
        private static SecretKeySpec secretKey ;
        private static byte[] key ;
        
        private static String decryptedString;
        private static String encryptedString;
        
        public static void setKey(String myKey){
            
       
            MessageDigest sha = null;
            try {
                key = myKey.getBytes("UTF-8");
                System.out.println(key.length);
                sha = MessageDigest.getInstance("SHA-1");
                key = sha.digest(key);
                key = Arrays.copyOf(key, 16); // use only first 128 bit
                System.out.println(key.length);
                System.out.println(new String(key,"UTF-8"));
                secretKey = new SecretKeySpec(key, "AES");
                
                
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
                  
        
        }
        
        public static String getDecryptedString() {
            return decryptedString;
        }
        public static void setDecryptedString(String decryptedString) {
            Destest.decryptedString = decryptedString;
        }
        public static String getEncryptedString() {
            return encryptedString;
        }
        public static void setEncryptedString(String encryptedString) {
            Destest.encryptedString = encryptedString;
        }
        public static String encrypt(String strToEncrypt)
        {
            try
            {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
             
                setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
            
            }
            catch (Exception e)
            {
               
                System.out.println("Error while encrypting: "+e.toString());
            }
            return null;
        }
        public static String decrypt(String strToDecrypt)
        {
            try
            {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
               
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
                
            }
            catch (Exception e)
            {
             
                System.out.println("Error while decrypting: "+e.toString());
            }
            return null;
        }
        public static void main(String args[])
        {
                    final String strToEncrypt = "My text to encrypt";
                    final String strToEncrypt1 = "Maureen";
                    final String strToEncrypt2 = "Mumbi";
                    final String strPssword = "encryptor key";
                    Destest.setKey(strPssword);
                   
//                  
//                    
//                      String first=  Destest.encrypt (strToEncrypt.trim());
//                        System.out.println("Encrypted______________________: " + strToEncrypt);
//                   
//                    System.out.println("Encrypted:____________________ " + Destest.getEncryptedString());
//                    
//                    
//                    
//                    
//                    String second= Destest.encrypt (strToEncrypt1.trim());
//                      System.out.println("String to Encrypt:_______****(**** " + strToEncrypt1); 
//                    System.out.println("Encrypted:________******** " + Destest.getEncryptedString());
//                    
//                    
//                    
//                      Destest.encrypt (strToEncrypt2.trim());
//                    System.out.println("String to Encrypt:_______+++++++ " + strToEncrypt2); 
//                   System.out.println("Encrypted:_______+++++++ " + Destest.getEncryptedString());
//               
                    final String strToDecrypt =  "pZtJYd2fLbiX3+Smw0YLCA==";
                    Destest.decrypt(strToDecrypt.trim());
                      System.out.println("String To Decrypt : " + strToDecrypt);
                    System.out.println("Decrypted : " + Destest.getDecryptedString());
                    final String strToDecrypt1 =  "dyFFdsLjFwpUvU5ObeY4Ag==";
                    Destest.decrypt(strToDecrypt1.trim());
                     System.out.println("String To Decrypt : " + strToDecrypt1);
                    System.out.println("Decrypted : " + Destest.getDecryptedString());
                    final String strToDecrypt2 =  "4xh7gmKw3Ypcu15PUaNevQ==";
                    Destest.decrypt(strToDecrypt2.trim());
                     System.out.println("String To Decrypt : " + strToDecrypt2);
                    System.out.println("Decrypted : " + Destest.getDecryptedString());
                   
                     String strToDecrypt3 =  "yeiagwbf/stG41c5Y0HfWA==";
                    Destest.decrypt(strToDecrypt3.trim());
                     System.out.println("String To Decrypt : " + strToDecrypt3);
                    System.out.println("Decrypted : " + Destest.getDecryptedString());
                    
                      String strToDecrypt4 =  "lfwqnxl9p27lTU9C7ml5yA==";
                    Destest.decrypt(strToDecrypt4.trim());
                     System.out.println("String To Decrypt : " + strToDecrypt4);
                    System.out.println("Decrypted : " + Destest.getDecryptedString());
                   
//                    System.out.println("String To Decrypt : " + strToDecrypt);
//                    System.out.println("Decrypted : " + Destest.getDecryptedString());
            
        }
         
    }
      