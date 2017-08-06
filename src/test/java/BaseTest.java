package test.java;


import main.java.Pages.Navigator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeSuite
    public void beforeClass() throws Exception {
        new Navigator().open();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        new Navigator().refreshPage();
    }

}
