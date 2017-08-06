package main.java.Elements;


import main.java.Logger;
import main.java.Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends AbstractElement {

    public Button(By locator) {
        super(locator);
    }

    /**
     * Returns text of this element.
     */
    public String getText() {
        return getWebElement().getText();
    }

    /**
     * Imitate cursor hovering over this element, then clicks on it.
     */
    public void click() {
        getWebElement().click();
        /*try {
            Actions actions = new Actions(WebDriverManager.getDriver());
            actions.moveToElement(getWebElement()).sendKeys("").click().build().perform();
        }catch (IllegalArgumentException | StaleElementReferenceException e){

                Actions actions = new Actions(WebDriverManager.getDriver());
                actions.moveToElement(getWebElement()).sendKeys("").click().build().perform();

        }*/
    }

    /**
     * Waits for element visible, then clicks it.
     */
    public void waitForVisibleAndClick(int seconds) {
        waitForElementVisible(seconds);
        click();
    }

    /**
     * Waits for element clickable, then clicks it.
     */
    public void waitForClickableAndClick(int seconds) {
        waitForElementClickable(seconds);
        click();
    }

    /**
     * Imitate cursor hovering over this element, then performs double clicking on it.
     */
    public void doubleClick() {

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions
                .moveToElement(getWebElement())
                .doubleClick()
                .build()
                .perform();
    }

    /**
     * Waits until element becomes clickable on the page.
     * NOTICE: works only with clickable elements.
     *
     * @param seconds - int
     */
    public void waitForElementClickable(int seconds) throws TimeoutException {
        //to avoid redundant waiting because of implicitlyWait
        changeImplicitlyWait(0);

        try {
            WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), (seconds));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            try {
                WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), (seconds));
                wait.until(ExpectedConditions.elementToBeClickable(locator));
            } catch (WebDriverException e2) {
                Logger.EXCEPTION(e2.getMessage());
                throw e2;
            } finally {
                //restoring default value
                restoreDefaultImplicitlyWait();
            }
        } finally {
            //restoring default value
            restoreDefaultImplicitlyWait();
        }
    }
}
