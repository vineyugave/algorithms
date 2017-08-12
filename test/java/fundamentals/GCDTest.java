package fundamentals;

import com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.GCD;
import org.junit.Test;

/**
 * Created by Viney Ugave (viney@vinzzz.com) on 6/5/17
 */

public class GCDTest {

    @Test
    public void checkGCD(){
        System.out.println(GCD.gcd(5,4));
        System.out.println(GCD.gcd(4,8));
        System.out.println(GCD.gcd(525,375));
    }
}
