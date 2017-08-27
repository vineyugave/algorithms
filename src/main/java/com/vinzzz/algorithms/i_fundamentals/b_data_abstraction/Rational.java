package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction;

import com.sun.istack.internal.NotNull;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * Source : https://github.com/morrxy/algs4/blob/master/exercise/1.2.16/Rational.java
 */

public class Rational {

    private final long numerator;
    private final long denominator;

    public Rational(@NotNull long n, @NotNull long d) {
        if (d == 0) {
            throw new RuntimeException("can't set denominator to zero");
        } else {
            assert n < Long.MAX_VALUE && n > Long.MIN_VALUE : "numerator overflow";
            assert d < Long.MAX_VALUE && d > Long.MIN_VALUE : "denominator overflow";

            long x = gcd(n, d);
            numerator = n / x;
            denominator = d / x;
        }
    }

    private long gcd(long p, long q) {
        if (q == 0) {
            return p;
        }
        long r = p % q;
        return gcd(q, r);
    }

    public Rational plus(Rational b) {
        long n = this.numerator * b.denominator + this.denominator * b.numerator;
        long d = this.denominator * b.denominator;
        long x = gcd(n, d);
        n = n / x;
        d = d / x;
        return new Rational(n, d);
    }

    public Rational minus(Rational b) {
        long n = this.numerator * b.denominator - this.denominator * b.numerator;
        long d = this.denominator * b.denominator;
        long x = gcd(n, d);
        n = n / x;
        d = d / x;
        return new Rational(n, d);
    }

    public Rational times(Rational b) {
        long n = this.numerator * b.numerator;
        long d = this.denominator * b.denominator;
        long x = gcd(n, d);
        n = n / x;
        d = d / x;
        return new Rational(n, d);
    }

    public Rational divides(Rational b) {
        if (b.numerator == 0) {
            throw new RuntimeException("divides by zero");
        } else {
            long n = this.numerator * b.denominator;
            long d = this.denominator * b.numerator;
            long x = gcd(n, d);
            n = n / x;
            d = d / x;
            return new Rational(n, d);
        }
    }

    public boolean equals(Rational that) {
        return this.numerator * that.denominator == this.denominator * that.numerator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        long nu1 = 20;
        long de1 = 5;
        long nu2 = 13;
        long de2 = 7;

        Rational r1 = new Rational(nu1, de1);
        Rational r2 = new Rational(nu2, de2);

        StdOut.println("r1: " + r1);
        StdOut.println("r2: " + r2);
        StdOut.println("r1 + r2: " + r1.plus(r2));
        StdOut.println("r1 - r2: " + r1.minus(r2));
        StdOut.println("r1 * r2: " + r1.times(r2));
        StdOut.println("r1 / r2: " + r1.divides(r2));
        StdOut.println("r1 equals r2?: " + r1.equals(r2));
    }
}