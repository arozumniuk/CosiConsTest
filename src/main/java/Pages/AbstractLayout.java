package main.java.Pages;

import main.java.Elements.*;
import main.java.Logger;
import main.java.Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AbstractLayout {

    protected String url;

    public AbstractLayout open() {
        Logger.STEP("Navigating to: " + url);

        WebDriverManager.getDriver().get(url);
        return this;
    }

//GETTERS FOR WEB_ELEMENT WRAPPERS

    public Button getButton(By locator) {
        return new Button(locator);
    }

    public Input getInput() {
        return getInput();
    }

    public Input getInput(By locator) {
        return new Input(locator);
    }

    public Select getSelect(By locator) {
        return new Select(locator);
    }

    public Text getText(By locator) {
        return new Text(locator);
    }

    public CheckBox getCheckBox(By locator) {
        return new CheckBox(locator);
    }

    public Element getElement(By locator, By targetLocator) {
        return new Element(locator, targetLocator);
    }

    public Element getElement(By locator) {
        return new Element(locator);
    }

    public List getList(By locator) {
        return new List(locator);
    }

//COMMON FUNCTIONALITY


    /**
     * Switches to default content of the page.
     * Useful when IFrame was selected and access to default content is required
     */
    public void switchToDefaultContent() {
        Logger.DEBUG("Switching to default content");
        WebDriverManager.getDriver().switchTo().defaultContent();
    }

    /**
     * Returns current url of the page
     *
     * @return String - Current url
     */
    public String getCurrentUrl() {
        return WebDriverManager.getDriver().getCurrentUrl();
    }

    /**
     * refresh defined page
     */
    public void refreshPage() {
        Logger.STEP(this.getClass().getSimpleName() + ": refresh page");

        WebDriverManager.getDriver().navigate().refresh();
    }

    /**
     * get defined page's source
     *
     * @return
     */
    public String getSource() {
        return WebDriverManager.getDriver().getPageSource();
    }


    /**
     * execute javaScript
     *
     * @param command
     */
    public void executeJavaScript(String command) {
        WebDriver driver = WebDriverManager.getDriver();

        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(command);
        }
    }
}
