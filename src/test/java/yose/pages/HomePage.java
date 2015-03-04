package yose.pages;

import com.objogate.wl.web.AsyncElementDriver;
import com.objogate.wl.web.AsyncWebDriver;
import com.objogate.wl.web.ElementAction;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

public class HomePage {
    private final AsyncWebDriver browser;

    public HomePage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public HomePage displaysMessage(String message) {
        browser.assertPageSource(containsString(message));
        return this;
    }

    public GitHubPage openGithub() {
        AsyncElementDriver element = browser.element(By.id("repository-link"));
        element.click();
        return new GitHubPage(browser);
    }

    public PersonalInfoPage visitsPersonalProfile() {
        AsyncElementDriver element = browser.element(By.cssSelector("a#contact-me-link"));
        element.click();
        
        return new PersonalInfoPage(browser);
    }
}
