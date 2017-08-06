package test.java;

import main.java.Pages.AlphabetLayout;
import main.java.Pages.LetterLayout;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteLettersTest extends BaseTest {

    @DataProvider(name = "letters")
    public Object[][] LettersToMove() {

        return new Object[][]{
                {"K"}, {"Z"}, {"W"}

        };
    }

    @Test(dataProvider = "letters")
    public void testDeleteLetterTest(String letter) {
        Assert.assertFalse(new LetterLayout()
                        .checkLetter(letter)
                        .clickDeleteButton()
                        .isLetterExist(letter),
                "After deleting of letter: Letter: " + letter + "is found in English letters");
    }

    @DataProvider(name = "lettersAlphabet")
    public Object[][] LettersToDeleteFromAlphabet() {

        return new Object[][]{
                {"A"}, {"J"}, {"E"}

        };
    }

    @Test(dataProvider = "lettersAlphabet")
    public void testDeleteLetterFromAlphabetTest(String letter) {
        Assert.assertFalse(new AlphabetLayout()
                        .openContextMenu(letter)
                        .deleteLetter()
                        .isLetterExist(letter),
                "After deleting of letter: Letter: " + letter + "is found in Alphabet letters");
    }

    @Test
    public void testDeleteAllLetterTest() {

        Assert.assertTrue(new LetterLayout()
                        .checkAllLetters()
                        .clickDeleteButton().getEnglishLetterCount() == 0,
                "After deleting all letters: Count of letters is:" + new LetterLayout().getEnglishLetterCount());
    }


}
