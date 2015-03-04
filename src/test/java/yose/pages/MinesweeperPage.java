package yose.pages;

import com.objogate.wl.web.AsyncElementDriver;
import com.objogate.wl.web.AsyncWebDriver;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

public class MinesweeperPage {
    private final AsyncWebDriver browser;

    public MinesweeperPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public MinesweeperPage hasTitle(String title) {
        browser.element(By.id("title")).assertText(containsString("Minesweeper"));
        return this;
    }

    public MinesweeperPage hasBoard(Integer colNumber, Integer rowNumber) {

        String seekedId;

        for (int i = 1; i <= colNumber ; i++) {
            for (int j = 1; j <= rowNumber ; j++) {

                seekedId = "cell-" + j + "x" + i;
                browser.element(By.cssSelector("td#" + seekedId)).assertExists();
            }
        }

        return this;
    }
}
