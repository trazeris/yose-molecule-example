package yose.pages;

import com.objogate.wl.web.AsyncWebDriver;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

/**
 * Created by formation on 04/03/15.
 */
public class PersonalInfoPage {
    private AsyncWebDriver browser;
    private String cssSelector;
    
    
    

    public PersonalInfoPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public void seesJobTitle(String s) {

        browser.element(By.cssSelector("#headline .title")).assertText(Matchers.equalTo(s));
    }
}
