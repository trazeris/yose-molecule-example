package yose.pages;

import com.objogate.wl.web.AsyncElementDriver;
import com.objogate.wl.web.AsyncWebDriver;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

public class AstroportPage {
    private final AsyncWebDriver browser;

    public AstroportPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public AstroportPage displaysMessage(String message) {
        browser.assertPageSource(containsString(message));
        return this;
    }
}
