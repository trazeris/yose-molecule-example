package yose.pages;

import com.objogate.wl.web.AsyncElementDriver;
import com.objogate.wl.web.AsyncWebDriver;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

public class GitHubPage {
    private final AsyncWebDriver browser;

    public GitHubPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public void seesInReadme(String textInReadmeElement)
    {
        browser.assertPageSource(containsString("yose-molecule-example"));
        browser.element(By.id("readme")).assertText(containsString(textInReadmeElement));
    }
}
