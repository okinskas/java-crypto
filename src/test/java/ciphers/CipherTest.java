package ciphers;

import org.junit.Test;
import utils.CipherDictionary;

public class CipherTest {

    private static final String KEY = "ABCDE";
    private static final String PLAIN_TEXT = "EXAMPLE PLAIN TEXT";

    @Test
    public void testKeyIsLowerCase() {
        Cipher cipher = new Cipher(KEY);
        assert cipher.key.equals(KEY.toLowerCase());
    }

    @Test
    public void testIsStandardAlphabet() {
        Cipher cipher = new Cipher(KEY);
        assert cipher.getAlphabet().equals(CipherDictionary.STANDARD_ALPHABET);
    }

    @Test
    public void testEncrypt() {
        Cipher cipher = new Cipher(KEY);
        assert cipher.encrypt(PLAIN_TEXT).equals("");
    }

    @Test
    public void testDecrypt() {
        Cipher cipher = new Cipher(KEY);
        assert cipher.decrypt(PLAIN_TEXT).equals("");
    }
}
