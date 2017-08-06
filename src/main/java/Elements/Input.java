package main.java.Elements;
import main.java.Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input extends AbstractElement {
    public Input(By locator) {
        super(locator);
    }

    /**
     * Sends text to Input.
     *
     * @param text - String that has to be sent
     */
    public void sendKeys(String text) {
        if (text !=null) {
            getWebElement().click();
            getWebElement().clear();
            getWebElement().sendKeys(text);
        }
    }

    public void sendKeysWithoutClick(String text) {
        getWebElement().clear();
        getWebElement().sendKeys(text);
    }


    /**
     * Returns text that is inside of Input element
     */
    public String getText(){
        return getWebElement().getAttribute("value");
    }
}
