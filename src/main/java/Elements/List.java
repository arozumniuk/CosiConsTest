package main.java.Elements;


import org.openqa.selenium.By;

public class List extends AbstractElement {
    public List(By locator) {
        super(locator);
    }

    public int size(){
       return getWebElements().size();
    }
}
