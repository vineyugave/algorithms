package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.Queue;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_16 {

    public static void main(String[] args) {

        Date[] dates = readDates();
        StdOut.println("Date Array : " + Arrays.toString(dates));
    }

    public static Date[] readDates() {
        Queue<Date> queue = new Queue<>();

        while (!StdIn.isEmpty()) {
            SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
            try {
                Date date = sd.parse(StdIn.readString());
                queue.enqueue(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Date[] result = new Date[queue.size()];
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            result[i] = queue.dequeue();
        }

        return result;
    }
}
