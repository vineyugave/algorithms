package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.Queue;
import com.vinzzz.libs.stdlib.StdOut;

import java.io.File;
import java.util.Locale;

/**
 * Listing Files
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_43 {


    public static void main(String[] args) {
        ListingFiles listingFiles = new ListingFiles("/algorithms");
        listingFiles.print();
    }

    private static class ListingFiles {

        Queue<String> queue;
        int depth;

        public ListingFiles(String parentDir) {
            queue = new Queue<>();
            depth = 1;
            getFiles(new File(parentDir));
        }

        private void getFiles(File dir) {
            if (dir.isDirectory()) {
                if (dir.isHidden()) return;
                add(dir.getAbsolutePath());
                depth++;
                File[] listFiles = dir.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        getFiles(listFiles[i]);
                    } else {
                        add(listFiles[i].getName());
                    }
                }
                depth--;
            } else {
                throw new IllegalArgumentException();
            }
        }

        private void add(String fileName) {
            queue.enqueue(String.format(Locale.getDefault(), "%1$" + depth + "s", fileName));
        }

        public void print() {
            for (String fileName : queue) {
                StdOut.println(fileName);
            }
        }
    }
}
