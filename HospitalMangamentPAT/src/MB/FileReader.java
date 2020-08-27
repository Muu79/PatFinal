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
public class FileReader {
    private String fileName;
    public FileReader(String n){
        fileName = n;
    }
    
    @Override
    public String toString(){
        String temp  = "";
        try {
            Scanner sc = new Scanner(new File("help.txt")).useDelimiter(":");
            while(sc.hasNext()){
                temp += sc.next() + "\n";
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            return "File not Found";
        }
        return temp;
    }
}
