package utils;

import ciphers.CaesarCipher;
import org.junit.Test;

public class CipherDictionaryTest {

    @Test
    public void testNonUniqueAlphabet() {
        boolean exceptionThrown = false;
        try {
            CaesarCipher caesarCipher = new CaesarCipher(3, "AAAABBBBCCCC");
        } catch (NonUniqueAlphabetException e) {
            exceptionThrown = true;
        }
        assert exceptionThrown;
    }
}
