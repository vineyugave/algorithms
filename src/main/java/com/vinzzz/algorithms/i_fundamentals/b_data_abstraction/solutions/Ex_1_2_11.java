package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Date;

/**
 * Smart Date
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_11 {

    public static void main(String[] args) {

        SmartDate date = new SmartDate(13, 32, -1);
    }

    public static class SmartDate extends Date {

        public SmartDate(int month, int day, int year) {
            super(month, day, year);
            if (month > 12 || month < 1) {
                throw new RuntimeException("Error month.");
            }

            if (day > 31 || day < 1) {
                throw new RuntimeException("Error day.");
            }

            if (year < 1) {
                throw new RuntimeException("Error year.");
            }
        }

    }
}
