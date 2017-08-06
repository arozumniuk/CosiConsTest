package test.java;


import main.java.Pages.AlphabetLayout;
import main.java.Pages.LetterLayout;
import main.java.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class DragNDropUITests extends BaseTest {

    @DataProvider(name = "letters")
    public Object[][] LettersToMove() {

        return new Object[][]{
                {"L"}, {"Z"}, {"W"}

        };
    }

    @Test(dataProvider = "letters")
    public void testMoveLetterTest(String letter) {
        Assert.assertTrue(new LetterLayout()
                .moveLetterToAlphabet(letter)
                .isLetterExist(letter));
    }

    @Test
    public void testMoveAllLetters() throws Exception {
        new LetterLayout().moveAllLettersToAlphabet();
        Assert.assertTrue(new AlphabetLayout().getAlphabetLetterCount() == 26,
                "After moving all letters: Count of letters in alphabet is:" + new AlphabetLayout().getAlphabetLetterCount());
    }

    @Test
    public void testMoveLetterFromAlphabet() throws Exception {
        Assert.assertTrue(new AlphabetLayout()
                .moveLetterFromAlphabet("A")
                .isLetterExist("A"));
    }
}
