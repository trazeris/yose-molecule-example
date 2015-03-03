package yose.factor;

import org.hamcrest.Matchers;
import org.junit.Test;
import yose.primefactor.PrimeFactor;

import java.io.IOException;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;
import static yose.primefactor.PrimeFactor.powerOfTwoDecomposition;

/**
 * Created by formation on 03/03/15.
 */
public class TestNumberFactor {

    @Test
    public void powerOf2() throws IOException {
        assertThat(powerOfTwoDecomposition(2), arrayContaining(2));

    }

    @Test
    public void powerOf4() throws IOException {
        assertThat(powerOfTwoDecomposition(4), arrayContaining(2, 2));

    }


    @Test
    public void powerOf8() throws IOException {
        assertThat(powerOfTwoDecomposition(8), arrayContaining(2, 2, 2));

    }

    @Test
    public void powerOf1024() throws IOException {
        assertThat(powerOfTwoDecomposition(1024), arrayContaining(2, 2, 2, 2, 2, 2, 2, 2, 2, 2));
    }
}
