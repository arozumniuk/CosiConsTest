package main.java.Elements;

import org.openqa.selenium.By;

public class Text extends AbstractElement {
    public Text(By locator) {
        super(locator);
    }

    /**
     * Returns text of this element.
     */
    public String getText(){

        return getWebElement().getText();
    }
}

