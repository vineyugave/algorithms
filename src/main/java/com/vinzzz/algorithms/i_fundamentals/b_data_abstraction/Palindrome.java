package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction;

/**
 * Palindrome
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Palindrome {

    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N/2; i++) {
            if(s.charAt(i) != s.charAt((N-1-i)))
                return false;
        }

        return true;
    }
}
