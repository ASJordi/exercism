package easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

public class PangramCheckerTest {

    private PangramChecker pangramChecker;

    @BeforeEach
    public void setup() {
        pangramChecker = new PangramChecker();
    }

    @Test
    public void emptySentenceIsNotPangram() {
        assertFalse(pangramChecker.isPangram(""));
    }

    @Test
    public void perfectLowerCasePhraseIsPangram() {
        assertTrue(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void phraseWithOnlyLowerCaseIsPangram() {
        assertTrue(pangramChecker.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void phraseMissingCharacterXIsNotPangram() {
        assertFalse(pangramChecker.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
    }

    @Test
    public void phraseMissingCharacterHIsNotPangram() {
        assertFalse(pangramChecker.isPangram("five boxing wizards jump quickly at it"));
    }

    @Test
    public void phraseWithUnderscoresIsPangram() {
        assertTrue(pangramChecker.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"));
    }

    @Test
    public void phraseWithNumbersIsPangram() {
        assertTrue(pangramChecker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
    }

    @Test
    public void phraseWithMissingLettersReplacedByNumbersIsNotPangram() {
        assertFalse(pangramChecker.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"));
    }

    @Test
    public void phraseWithMixedCaseAndPunctuationIsPangram() {
        assertTrue(pangramChecker.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
    }

    @Test
    public void caseInsensitivePhraseIsNotPangram() {
        assertFalse(pangramChecker.isPangram("the quick brown fox jumps over with lazy FX"));
    }
}
