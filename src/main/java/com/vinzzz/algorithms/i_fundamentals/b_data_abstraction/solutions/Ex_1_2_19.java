package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Date;
import com.vinzzz.libs.stdlib.Transaction;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_19 {

    public static class DateParser extends Date {

        private final int month;
        private final int day;
        private final int year;

        public DateParser(int month, int day, int year) {
            super(month, day, year);
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public DateParser(String date) {
            super(date);
            String[] fields = date.split("/");
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        }
    }

    public static class TransactionParser extends Transaction {

        private String who;
        private Date when;
        private double amount;

        public TransactionParser(String who, Date when, double amount) {
            super(who, when, amount);
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public TransactionParser(String transaction) {
            super(transaction);
            String[] fields = transaction.split("\\s+");
            who = fields[0];
            when = new Date(fields[1]);
            amount = Double.parseDouble(fields[2]);
        }
    }
}
