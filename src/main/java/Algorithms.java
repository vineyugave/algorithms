import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Algorithms {

    public static void main(String[] args) {



        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] words =  paragraph.replaceAll("\\p{P}"," ").split("\\s+");
        System.out.println(Arrays.asList(words).toString());

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        System.out.println(wordSet.toString());

        Map<Integer, List<Integer>>userMap = new HashMap<>();
        userMap.get(5).add(4);
        List<Integer> list = new ArrayList<>();
        ((ArrayList<Integer>) list).clone();
    }

    private static boolean isValidFormat(String format, String value) {
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
