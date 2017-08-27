package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Date;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.Comparator;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_13 {

    public static void main(String[] args) {
        Transaction t = new Transaction("Honey Singh", new Date(1, 11, 2017), 9000);
        StdOut.println(t.who());
        StdOut.println(t.when());
        StdOut.println(t.amount());
    }

    public static class Transaction implements Comparable<Transaction> {

        private final String who;      // customer
        private final Date when;     // date
        private final double amount;   // amount

        public Transaction(String who, Date when, double amount) {
            if (Double.isNaN(amount) || Double.isInfinite(amount))
                throw new IllegalArgumentException("Amount cannot be NaN or infinite");
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public Transaction(String transaction) {
            String[] a = transaction.split("\\s+");
            who = a[0];
            when = new Date(a[1]);
            amount = Double.parseDouble(a[2]);
            if (Double.isNaN(amount) || Double.isInfinite(amount))
                throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        }


        public String who() {
            return who;
        }

        public Date when() {
            return when;
        }

        public double amount() {
            return amount;
        }

        @Override
        public String toString() {
            return String.format("%-10s %10s %8.2f", who, when, amount);
        }

        public int compareTo(Transaction that) {
            return Double.compare(this.amount, that.amount);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (other.getClass() != this.getClass()) return false;
            Transaction that = (Transaction) other;
            return (this.amount == that.amount) && (this.who.equals(that.who))
                    && (this.when.equals(that.when));
        }

        public int hashCode() {
            int hash = 1;
            hash = 31 * hash + who.hashCode();
            hash = 31 * hash + when.hashCode();
            hash = 31 * hash + ((Double) amount).hashCode();
            return hash;
            // return Objects.hash(who, when, amount);
        }

        public static class WhoOrder implements Comparator<Transaction> {

            @Override
            public int compare(Transaction v, Transaction w) {
                return v.who.compareTo(w.who);
            }
        }

        public static class WhenOrder implements Comparator<Transaction> {

            @Override
            public int compare(Transaction v, Transaction w) {
                return v.when.compareTo(w.when);
            }
        }

        public static class HowMuchOrder implements Comparator<Transaction> {

            @Override
            public int compare(Transaction v, Transaction w) {
                return Double.compare(v.amount, w.amount);
            }
        }
    }
}
