package yose;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.testinfected.hamcrest.dom.DomMatchers;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by formation on 03/03/15.
 */
public class HomePageTest {

    Element homePageDOM;
    
    String homePage;
    //enter here your github user account name

    final String projectName = "trazeris";
    final private String contactInfoURL = "https://fr.linkedin.com/in/maximelardenois";

    @Before
    public void getFileContent() throws IOException, SAXException {
        homePage = FileUtils.readFileToString(new File("src/main/webapp/HomePage.html"));
        homePageDOM = HTMLDocument.toElement(FileUtils.readFileToString(new File("src/main/webapp/HomePage.html")));
    }
        

    @Test
    public void projectNameIsWagonli() throws IOException {
        assertThat(homePage, containsString(projectName));
    }

    @Test
    public void linksToGitHubRepository() throws IOException {
        assertThat(homePageDOM, DomMatchers.hasUniqueSelector("a#repository-link", DomMatchers.hasAttribute("href", "https://github.com/" + projectName + "/yose-molecule-example")));
    }

    @Test
    public void linksToContactInfo() throws IOException {
        assertThat(homePageDOM, DomMatchers.hasUniqueSelector("a#contact-me-link", DomMatchers.hasAttribute("href", contactInfoURL)));
    }
}
