/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muaaz Bhyat
 */
public class Hasher {

    public Hasher() {

    }

    public  byte[] getSHA(String input) 
    {  
        byte [] temp = new byte[1];
        try {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hasher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    } 
    
    
    
    public boolean testHash(String in, String hash){
        if(toHexString(getSHA(in)) == "-1"){
            return false;
        }
        else if(toHexString(getSHA(in)).compareToIgnoreCase(hash) == 0){
            return true;
        }
        else{
            return false;
        }
    }

   public  String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 

}
