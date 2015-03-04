package yose.worlds;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;
import yose.pages.GitHubPage;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

public class PrimeFactors {

    YoseDriver yose = new YoseDriver(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yose.start();
    }

    @After
    public void stopGame() throws Exception {
        yose.stop();
    }

    @Test
    public void powerOfTwoChallenge() throws IOException {
        response = request.get("/primeFactors?number=4");

        assertThat(response).isOK()
                .hasContentType("application/json")
                .hasBodyText("{\"number\":4,\"decomposition\":[2,2]}");
    }


    @Test
    public void stringGuardChallenge() throws IOException {
        response = request.get("/primeFactors?number=hello");

        assertThat(response).isOK()
                .hasContentType("application/json")
                .hasBodyText("{\"number\":\"hello\",\"error\":\"not a number\"}");
    }
}
