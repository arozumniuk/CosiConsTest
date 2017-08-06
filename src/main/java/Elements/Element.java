package main.java.Elements;

import main.java.Managers.WebDriverManager;
import main.java.Pages.AbstractLayout;
import main.java.Pages.ContextMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Element extends AbstractElement {

    public Element(By locator) {
        super(locator);
    }
    public Element(By locator, By targetLocator) {
        super(locator, targetLocator);
    }



    public void move() {
        WebElement element = getWebElement().findElement(locator);

        WebElement target = getWebElement().findElement(targetLocator);

        (new Actions(WebDriverManager.getDriver())).dragAndDrop(element, target).perform();
    }

    public boolean isExist() {
        return isPresent();
    }

    public void openContextMenu(){
        invokeContextMenu();
    }
}
