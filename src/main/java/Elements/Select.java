package main.java.Elements;

import main.java.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class Select extends AbstractElement {
    public Select(By locator) {
        super(locator);
    }

    public void selectByVisibleText(String label){

        for (int i =0; i<3 && !getButton(By.xpath("//a/span[contains(.,'"+label+"')]")).isPresent(); i++) {
            getButton(locator).waitForVisibleAndClick(3);
            try {
                getButton(By.xpath("//a/span[contains(.,'"+label+"')]")).waitForVisibleAndClick(2);
                return;

            } catch (TimeoutException e) {
                getButton(locator).waitForVisibleAndClick(3);
                Logger.INFO(e.getMessage());
            }

        }

    }

}
