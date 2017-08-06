package test.java;

import main.java.Pages.AlphabetLayout;
import main.java.Pages.LetterLayout;
import main.java.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class AddLettersTest extends BaseTest{

    @DataProvider(name = "letters")
    public Object[][] LettersToMove() {

        return new Object[][]{
                {"K"}, {"Z"}, {"W"}

        };
    }

    @Test(dataProvider = "letters")
    public void testAddLetterTest(String letter) {

        LetterLayout letterLayout = new LetterLayout();
        letterLayout
                .checkLetter(letter)
                .clickDeleteButton()
                .clickAddButton()
                .selectLetter(letter)
                .clickAddButton();

        Assert.assertTrue(letterLayout
                .isLetterExist(letter), "Letter " + letter + "was not add to English letters");
    }

    @Test(dataProvider = "letters")
    public void testAddLetterFromAlphabetTest(String letter) {

        new LetterLayout().checkLetter(letter)
                .clickDeleteButton();

        AlphabetLayout layout = new AlphabetLayout();
        layout
                .openContextMenu("A")
                .clickAdd()
                .selectLetter(letter)
                .clickAddButton();

        Assert.assertTrue(layout
                .isLetterExist(letter), "Letter " + letter + " was NOT add to Alphabet letters");
    }

}
