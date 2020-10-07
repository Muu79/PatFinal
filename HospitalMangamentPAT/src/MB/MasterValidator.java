/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muaaz Bhyat
 */
public class MasterValidator {

    private Hasher h = new Hasher();
    private String[] bty = new String[8];

    public MasterValidator()  {
        try {
            Scanner sc = new Scanner(new File("bloodType.txt")).useDelimiter(";");
            for(int i = 0; i < 8; i++){
                bty[i] = sc.next();
            }
        } catch (FileNotFoundException ex) {
            System.err.print("Master validator broke :(");
        }
    }

    public boolean cBlTy(String s){
        System.out.println(s.length());
        if(s.length()>4){
            return false;
        }
        else{
            for(int i = 0; i < 8; i++){
                if(s.trim().equalsIgnoreCase(bty[i])){
                    return true;
                }
            }
        }
        return false;
    }
    
   
    
    public boolean isStringEqual(String s, String s1) {
        if (s.compareTo(s1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStringTooLong(String s, int length) {
        return s.length() > length;
    }

    public boolean isStringEmpty(String s) {
        return s.equals("");
    }

    public boolean isStringTooShort(String s, int length) {
        return s.length() < length;
    }

}
