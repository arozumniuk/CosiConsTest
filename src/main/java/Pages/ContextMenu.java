package main.java.Pages;

import org.openqa.selenium.By;

public class ContextMenu extends AbstractLayout {

    private static final By ADD_BUTON_LOCATOR = By.id("menuitem-1013-textEl");
    private static final By DELETE_BUTON_LOCATOR = By.id("menuitem-1014-textEl");

    public DialogWindow clickAdd() {
        getButton(ADD_BUTON_LOCATOR).click();
        return new DialogWindow();
    }

    public AlphabetLayout deleteLetter() {
        getButton(DELETE_BUTON_LOCATOR).click();
        return new AlphabetLayout();
    }
}
