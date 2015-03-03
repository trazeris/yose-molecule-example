package yose;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by formation on 03/03/15.
 */
public class HomePageTest {
    
    String homePage;
    //enter here your github user account name
    final String projectName = "wagonli";
    
    @Before
    public void getFileContent() throws IOException {
        homePage = FileUtils.readFileToString(new File("src/main/webapp/HomePage.html"));
    }
        
    
    @Test
    public void projectNameIsWagonli() throws IOException {
        assertThat(homePage, containsString(projectName));
    }

    @Test
    public void linksToGitHubRepository() throws IOException {
        assertThat(homePage, containsString("<a id=\"repository-link\" href=\"https://github.com/"+ projectName +"/yose-molecule-example\">Voir le code source</a>"));
    }
}
