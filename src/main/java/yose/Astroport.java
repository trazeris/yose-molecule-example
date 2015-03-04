package yose;

import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import com.vtence.molecule.lib.FileBody;

import java.io.File;

/**
 * Created by formation on 04/03/15.
 */

public class Astroport {
    public void astroportNameChallenge(Request request, Response response) throws Exception {
        response.body(new FileBody(new File("src/main/webapp/Astroport.html")));
        response.contentType("text/html");
    }
}
