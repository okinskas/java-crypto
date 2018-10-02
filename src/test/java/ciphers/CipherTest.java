package ciphers;

import org.junit.Test;
import utils.CipherDictionary;

public class CipherTest {

    private static final String KEY = "ABCDE";
    private static final String PLAIN_TEXT = "EXAMPLE PLAIN TEXT";

    @Test
    public void testIsStandardAlphabet() {
        Cipher cipher = new SubstitutionCipher(CipherDictionary.STANDARD_ALPHABET);
        assert cipher.getAlphabet().equals(CipherDictionary.STANDARD_ALPHABET);
    }
}
