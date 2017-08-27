package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Date;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.ArrayList;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_12 {

    public static void main(String[] args) {

        SmartDate date = new SmartDate(8, 26, 2017);
        StdOut.println(date.dayOfTheWeek());

    }

    public static class SmartDate extends Date {

        private static ArrayList<String> daysofWeek = new ArrayList<>();

        static {
            daysofWeek.add("Sat");
            daysofWeek.add("Sun");
            daysofWeek.add("Mon");
            daysofWeek.add("Tue");
            daysofWeek.add("Wed");
            daysofWeek.add("Thu");
            daysofWeek.add("Fri");
        }

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

        /**
         * Using Zellers congruence to determine the day of the week in the Gregorian calendar
         * <p>
         * Also see
         * <a href = "https://en.wikipedia.org/wiki/Zeller%27s_congruence">Zellers Congruence</a>
         *
         * @return day of week
         */
        public String dayOfTheWeek() {
            int year = super.year();

            int k = year % 100; // The year of the century
            int j = (int) (year / 100.0); // the century
            int q = super.day();
            int m = super.month();
            int h = (q + (int)((26 * (m + 1)) / 10.0) + k + (int)(k / 4.0)
                    + (int)(j / 4.0) + (5 * j)) % 7;

            return daysofWeek.get(h);
        }
    }

}
