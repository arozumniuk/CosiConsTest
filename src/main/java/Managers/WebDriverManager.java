package main.java.Managers;


import main.java.Config;
import main.java.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {    private static WebDriver driver = null;

    private WebDriverManager() {
    }

    public static WebDriver getDriver(String browser) {
        if (driver != null) {
            return driver;
        }
        switch (browser) {
            case "chrome":


                selectDriverForSystem();
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }


    public static WebDriver getDriver() {
        return getDriver(Config.getBrowserName());
    }

    private static void selectDriverForSystem() {
        String opSystem = System.getProperty("os.name");
        Logger.INFO("Your system is: " + opSystem);

        if (opSystem.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
            return;
        }
        if (opSystem.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "./resources/chromedriver_linux");
            return;
        }
        if (opSystem.contains("Win")) {
            System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
            return;
        } else {
            Logger.ERROR("Your system is: " + opSystem + ", no chrome driver for it");
        }

    }

    /**
     * Closes WebDriver as well as Browser.
     */
    public static void close() {
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.ERROR("It was unable to close WebDriver properly for some reason");
                driver.quit();
                driver = null;
            }
        }
    }

}