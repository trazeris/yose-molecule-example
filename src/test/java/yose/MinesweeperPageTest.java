package yose;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testinfected.hamcrest.dom.DomMatchers;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by formation on 03/03/15.
 */
public class MinesweeperPageTest {
    
    Element minesweeperDOM;
    
    @Before
    public void getFileContent() throws IOException, org.xml.sax.SAXException {
        minesweeperDOM = HTMLDocument.toElement(FileUtils.readFileToString(new File("src/main/webapp/MinesweeperPage.html")));
    }

    @Test
    public void titleIsMineSweeper() throws IOException {
        assertThat(minesweeperDOM, DomMatchers.hasUniqueSelector("#title", DomMatchers.hasText("Minesweeper")));
    }
    @Test
    public void containsBoard() throws IOException {
        String seekedId;

        for (int i = 1; i <= 8 ; i++) {
            for (int j = 1; j <= 8 ; j++) {

                seekedId = "#cell-" + j + "x" + i;
                assertThat(minesweeperDOM, DomMatchers.hasUniqueSelector(seekedId));
            }
        }
    }
}
