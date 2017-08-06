package main.java.Pages;

import org.openqa.selenium.By;

public class DialogWindow extends AlphabetLayout {

    private static final By ARROW_DROP_DOWN_LOCATOR = By.xpath("//td[@valign='top']/div");
    private static final By ADD_LETTER_LOCATOR = By.id("button-1031-btnIconEl");
    private static final By INPUT_LETTER_LOCATOR = By.id("combo-1029-inputEl");

    private static By LETTER_LOCATOR;

    private void setElementLetterLocator(String letter) {
        LETTER_LOCATOR = By.xpath("//li[.='" + letter + "']");
    }

    public DialogWindow selectLetter(String letter) {
        getButton(ARROW_DROP_DOWN_LOCATOR).click();
        setElementLetterLocator(letter);
        getButton(LETTER_LOCATOR).click();
        return this;
    }

    public DialogWindow typeLetter(String letter) {
        getInput(INPUT_LETTER_LOCATOR).sendKeys(letter);
        return this;
    }

    public void clickAddButton() {
        getButton(ADD_LETTER_LOCATOR).click();

    }


}
