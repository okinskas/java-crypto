package ciphers;

import org.junit.Test;

public class TranspositionCipherTest {

    @Test
    public void testEncrypt() {
        String plainText = "0123456789ABCDEFGHIJKLMNOP";
        TranspositionCipher transposition = new TranspositionCipher("hello");
        String cipherText = transposition.encrypt(plainText);
        System.out.println(cipherText);
    }

    @Test
    public void testDecrypt() {
        String cipherText = "16BGL05AFKP27CHM38DIN49EJO";
        TranspositionCipher transposition = new TranspositionCipher("hello");
        String plainText = transposition.decrypt(cipherText);
        System.out.println(plainText);
    }
}
