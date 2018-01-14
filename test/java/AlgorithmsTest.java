package java;

/**
 * Created by Viney Ugave (viney@vinzzz.com) on 1/31/17
 */

public class AlgorithmsTest {
    public static void main(String args[]) {
        Test test = new Test();
        test.text = "abc";

        Test newTest = test;
        newTest.text = "xyz";

        System.out.println(test.text);
    }

    private static class Test{
        public String text;
    }

}