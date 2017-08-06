package main.java.Pages;


import main.java.Logger;
import main.java.Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AlphabetLayout extends AbstractLayout {

    private static By ELEMENT_ALPHABET_LETTER_LOCATOR;
    private static final By TARGET_ALPHABET_ELEMENT_LOCATOR = By.xpath("//div[@class='x-grid-cell-inner ']");
    private static final By ALPHABET_LETTERS_LOCATOR = By.xpath("//tr[contains(@class,'x-grid-tree-node-leaf')]");

    private void setElementLetterLocator(String letter) {
        ELEMENT_ALPHABET_LETTER_LOCATOR = By.xpath("//span[@class='x-tree-node-text ' and .='" + letter + "']");
    }


    public LetterLayout moveLetterFromAlphabet(String letter) {
        Logger.STEP("Move letter: " + letter + " from alphabet");
        setElementLetterLocator(letter);
        getElement(ELEMENT_ALPHABET_LETTER_LOCATOR, TARGET_ALPHABET_ELEMENT_LOCATOR)
                .move();
        return new LetterLayout();
    }

    public int getAlphabetLetterCount(){
        Logger.STEP("Count alphabetLetters");
        return getList(ALPHABET_LETTERS_LOCATOR).size();
    }

    public boolean isLetterExist(String letter) {
        Logger.STEP("Looking for letter "+letter+" in English Alphabet");
        setElementLetterLocator(letter);
        return getElement(ELEMENT_ALPHABET_LETTER_LOCATOR).isPresent();
    }

    public ContextMenu openContextMenu(String letter){
        setElementLetterLocator(letter);
        getElement(ELEMENT_ALPHABET_LETTER_LOCATOR).openContextMenu();
        return new ContextMenu();
    }
}
