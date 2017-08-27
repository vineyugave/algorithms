package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Interval1D;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_2 {
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    public static void main(String[] args) {
        int N = StdIn.readInt();

        ArrayList<Interval1D> intervals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] temp = WHITESPACE_PATTERN.split(StdIn.readLine());
            if (temp.length == 2) {
                intervals.add(new Interval1D(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
            }
        }

        StdOut.println("No. of intersections : " + findTotalIntersections(intervals));
    }

    private static int findTotalIntersections(ArrayList<Interval1D> intervals) {
        int total = 0;
        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = i; j < intervals.size(); j++) {
                if (i != j && intervals.get(i).intersects(intervals.get(j))) {
                    total++;
                    StdOut.println(intervals.get(i).toString() + " " + intervals.get(j).toString() + "intersects");
                }
            }
        }
        return total;
    }
}
