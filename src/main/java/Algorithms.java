import com.sun.tools.javac.util.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Algorithms {

    public static void main(String[] args) {
        String s = "Hello World";
        int[][] temp = new int[3][3];
        temp[0] = new int[]{1, 2, 3};
        System.out.println(7/2);

        isValidFormat("yyyy-MM-dd", "2018-12-19");

    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
            date = sdf.parse(value);
            System.out.println(sdf.format(date)+"**"+value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
