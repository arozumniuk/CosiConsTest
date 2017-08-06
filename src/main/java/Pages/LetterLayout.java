package main.java.Pages;

import main.java.Logger;
import main.java.TestNGListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

@Listeners(TestNGListener.class)
public class LetterLayout extends AbstractLayout {

    private static final By BUTTON_ADD_LOCATOR = By.id("button-1023-btnIconEl");
    private static final By TARGET_ELEMENT_LOCATOR = By.xpath("//span[.= 'English alphabet']");
    private static final By CHECK_ALL_LETTERS_CHECKBOX_LOCATOR = By.id("gridcolumn-1025-textEl");
    private static final By ELEMENT_ALL_LETTERS_LOCATOR = By.xpath("//tr[contains(@class,'x-grid-row-selected')]");
    private static final By BUTTON_DELETE_LOCATOR = By.id("button-1024-btnIconEl");
    private static final By ENGLISH_LETTERS_LOCATOR = By.xpath("//tbody[@id='gridview-1021-body']/tr[@role='row']");
    private static By ELEMENT_LETTER_LOCATOR;
    private static By CHECKBOX_LETTER_LOCATOR;

    private void setElementLetterLocator(String letter) {
        ELEMENT_LETTER_LOCATOR = By.xpath("//td/div[@class = 'x-grid-cell-inner ' and .= '" + letter + "']");
    }

    private void setCheckBoxLocator(String letter){
        CHECKBOX_LETTER_LOCATOR = By.xpath("//td[div[@class = 'x-grid-cell-inner ' and .= '"+letter+"']]/preceding-sibling::td/div");
    }


    public AlphabetLayout moveLetterToAlphabet(String letter) {
        Logger.STEP("Move letter: " + letter);
        setElementLetterLocator(letter);
        getElement(ELEMENT_LETTER_LOCATOR, TARGET_ELEMENT_LOCATOR).move();
        return new AlphabetLayout();
    }

    public LetterLayout moveAllLettersToAlphabet() {
        checkAllLetters();
        Logger.STEP("Move all letters: ");
        getElement(ELEMENT_ALL_LETTERS_LOCATOR, TARGET_ELEMENT_LOCATOR).move();
        return this;
    }

    public LetterLayout checkAllLetters() {
        Logger.STEP("Select all letters");
        getCheckBox(CHECK_ALL_LETTERS_CHECKBOX_LOCATOR).check();
        return this;
    }

    public LetterLayout checkLetter(String letter) {
        Logger.STEP("Select letter: " + letter);
        setCheckBoxLocator(letter);
        getCheckBox(CHECKBOX_LETTER_LOCATOR).check();
        return this;
    }

    public boolean isLetterExist(String letter) {
        Logger.STEP("Looking for letter "+letter+" in English letter layout");
        setElementLetterLocator(letter);
        return getElement(ELEMENT_LETTER_LOCATOR).isPresent();
    }

    public LetterLayout clickDeleteButton(){
        Logger.STEP("Click Delete button");
        getButton(BUTTON_DELETE_LOCATOR).waitForVisibleAndClick(1);
        return this;
    }

    public int getEnglishLetterCount(){
        Logger.STEP("Count EnglishLetters");
        return getList(ENGLISH_LETTERS_LOCATOR).size();
    }

    public DialogWindow clickAddButton() {
    getButton(BUTTON_ADD_LOCATOR).waitForClickableAndClick(1);
    return new DialogWindow();
    }
}
