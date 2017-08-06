package main.java.Pages;

import main.java.Config;

import java.io.IOException;

public class Navigator extends AbstractLayout {

    public Navigator() throws IOException {
        url = Config.getStartUrl();
    }

    @Override
    public Navigator open() {
        super.open();
        return this;
    }

    public Navigator openApp() {
        open();
        return this;
    }

    public void refreshPage(){
        new AbstractLayout().refreshPage();
    }

}
