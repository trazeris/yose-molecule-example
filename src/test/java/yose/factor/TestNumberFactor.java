package yose.factor;

import org.hamcrest.Matchers;
import org.junit.Test;
import yose.primefactor.PrimeFactor;


import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by formation on 03/03/15.
 */
public class TestNumberFactor {

    @Test
    public void powerOf2() throws IOException {
        Integer[] decompositon = PrimeFactor.powerOfTwoDecomposition(2);
        assertThat(decompositon, Matchers.arrayContaining(2));

    }

    @Test
    public void powerOf4() throws IOException {
        Integer[] decompositon = PrimeFactor.powerOfTwoDecomposition(4);
        assertThat(decompositon, Matchers.arrayContaining(2, 2));

    }


    @Test
    public void powerOf8() throws IOException {
        Integer[] decompositon = PrimeFactor.powerOfTwoDecomposition(8);
        assertThat(decompositon, Matchers.arrayContaining(2, 2, 2));

    }
    @Test
    public void powerOf1024() throws IOException {
        Integer[] decompositon = PrimeFactor.powerOfTwoDecomposition(1024);
        assertThat(decompositon, Matchers.arrayContaining(2, 2, 2,2,2,2,2, 2, 2,2));

    }
}
