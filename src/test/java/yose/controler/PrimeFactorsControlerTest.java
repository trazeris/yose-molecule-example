package yose.controler;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import org.junit.Before;
import org.junit.Test;
import yose.PrimeFactors;

import static com.vtence.molecule.testing.ResponseAssert.assertThat;

/**
 * Created by formation on 04/03/15.
 */
public class PrimeFactorsControlerTest {

    private PrimeFactors primeFactor;
    private Response response = new Response() ;
    private Request request = new Request();

    @Before
    public void init() {
        Gson gson = new Gson();
        primeFactor = new PrimeFactors(gson);
    }

    @Test
    public void alwaysResponseWithJson() throws Exception {
        request.addParameter("number","4");
        primeFactor.powerOfTwoChallenge(request, response);
        assertThat(response).hasContentType("application/json");
    }

    @Test
    public void badRequestResponseWhenNoParameterNumber() throws Exception {
        primeFactor.powerOfTwoChallenge(request, response);
        assertThat(response).hasStatusCode(400);
    }

    @Test
    public void checkParameterNumberIsANumber() throws Exception {
        request.addParameter("number","bad");
        primeFactor.powerOfTwoChallenge(request, response);
        assertThat(response).hasBodyText("{\"number\":\"bad\",\"error\":\"not a number\"}");
    }
}
