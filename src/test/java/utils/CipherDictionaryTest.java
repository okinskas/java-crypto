package utils;

import ciphers.CaesarCipher;
import ciphers.Cipher;
import ciphers.SubstitutionCipher;
import org.junit.Test;

public class CipherDictionaryTest {

    private static final String KEY = "ABCDE";

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

    @Test
    public void testKeyIsLowerCase() {
        Cipher cipher = new SubstitutionCipher(KEY, KEY);
        assert cipher.getKey().equals(KEY.toLowerCase());
    }
}
