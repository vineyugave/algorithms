package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_06 {

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";

        StdOut.println(checkIfCircularRotation(s, t));
    }

    private static boolean checkIfCircularRotation(String s, String t) {
        if(s.length() != t.length() || s == null || t == null) return false;

        int index = 0;

        while(t.indexOf(s.charAt(0), index) != -1){
            index = t.indexOf(s.charAt(0), index);
            if((t.substring(index, t.length()) + t.substring(0,index)).equals(s)) return true;
            index++;
        }

        return false;
    }
}
