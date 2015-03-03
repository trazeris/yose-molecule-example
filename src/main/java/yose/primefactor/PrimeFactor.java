package yose.primefactor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 03/03/15.
 */
public class PrimeFactor {


    public static Integer[] powerOfTwoDecomposition(int power) {
     
            List<Integer> result = new
                    ArrayList<>();
            for (int remainder=power; remainder>=2; remainder=remainder/2) {
                result.add(2);
            }
            return result.toArray(new Integer[result.size()]);
    }
}
