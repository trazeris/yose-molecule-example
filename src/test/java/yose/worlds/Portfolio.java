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

public class Portfolio {

    YoseDriver user = new YoseDriver(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        user.start();
    }

    @After
    public void stopGame() throws Exception {
        user.stop();
    }

    @Test
    public void firstWebPageChallenge() throws IOException {
        user.home().displaysMessage("Hello Yose");
    }

    @Test
    public void firstWebServiceChallenge() throws IOException {
        response = request.get("/ping");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"alive\":true}");
    }

    @Test
    public void shareWebPageChallenge() throws IOException {
        GitHubPage gitHubPage = user.home().openGithub();
        gitHubPage.seesInReadme("YoseTheGame");
    }
    
    @Test
    public void contactMePageChallenge() throws IOException {
        user.home().visitsPersonalProfile().seesJobTitle("Lead developper, web & mobile web");
    }

}
