package utils;

import ciphers.Caesar;
import org.junit.Test;

public class CipherDictionaryTest {

    @Test
    public void testNonUniqueAlphabet() {
        boolean exceptionThrown = false;
        try {
            Caesar caesar = new Caesar(3, "AAAABBBBCCCC");
        } catch (NonUniqueAlphabetException e) {
            exceptionThrown = true;
        }
        assert exceptionThrown;
    }
}
