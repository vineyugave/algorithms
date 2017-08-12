package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_21 {

    public static void main(String[] args) {
        StdOut.println("Please enter your sentences here : ");
        //in mac once you are done entering the data press cmd + d  which is equivalent of end of file
        //and hasNextLine will return false
        String[] temp = StdIn.readStrings();
        System.out.println(temp.length);
        if (temp.length == 3)
            //assuming you have entered valid characters
            try {
                System.out.printf("%s | %d | %d | %.2f", temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
                        Float.parseFloat(temp[1]) / Float.parseFloat(temp[2]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                StdOut.println("Please enter valid integers...");
            }

    }
}
