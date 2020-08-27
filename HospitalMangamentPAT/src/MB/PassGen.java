/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

/**
 *
 * @author Bhyatmua
 */
public class PassGen {

    static char[] alph = new char[100];

    /**
     * @param args the command line arguments
     */
    public String makeCode() {
        makeAlph();
        return pass();
    }

    public static String pass() {
        String temp = "";
        for (int i = 0; i < 15; i++) {
            int ran = (int) (Math.random() * 93);
            temp += alph[ran];
        }
        return temp;
    }

    public static void makeAlph() {
        for (int i = 0; i < 93; i++) {
            int c = 33;
            char a = (char) c;
            if (i + c == 44) {
                alph[i] = a;
            } else {
                a = (char) (c + i);
                alph[i] = a;
            }

        }
    }
}
