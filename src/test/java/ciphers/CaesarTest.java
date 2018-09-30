package ciphers;

import org.junit.Test;

public class CaesarTest {

    @Test
    public void testEncryption() {

        Caesar caesar = new Caesar(1);
        String cipherText = caesar.encrypt("hello");
        assert cipherText.equals("ifmmp");
    }

    @Test
    public void testDecryption() {

        Caesar caesar = new Caesar(1);
        String plainText = caesar.decrypt("ifmmp");
        assert plainText.equals("hello");
    }

    @Test
    public void testEncryptThenDecrypt() {

        Caesar caesar = new Caesar(3);
        String plainText = "s s";
        String cipherText = caesar.encrypt(plainText);
        String decryptedText = caesar.decrypt(cipherText);
        assert plainText.equals(decryptedText);
    }
}
