/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

/**
 *
 * @author Muaaz Bhyat
 */
public class MasterValidator {

    private Hasher h = new Hasher();

    public MasterValidator() {

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
