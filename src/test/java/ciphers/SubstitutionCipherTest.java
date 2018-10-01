package ciphers;

import org.junit.Test;

public class SubstitutionCipherTest {

    private static String ENCRYPTED_ALPHABET = "mhvqptuwikz bdysxcorjlanfge";
    private static String SHORT_ALPHABET = "abcdefghijk";
    private static String PLAIN_TEXT = "text to be encrypted";
    private static String CIPHER_TEXT = "rpnreryehpepdvcfsrpq";

    @Test
    public void testEncryption() {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher(ENCRYPTED_ALPHABET);
        String cipherText = substitutionCipher.encrypt("text to be encrypted");
        assert cipherText.equals(CIPHER_TEXT);
    }

    @Test
    public void testDecryption() {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher(ENCRYPTED_ALPHABET);
        String plainText = substitutionCipher.decrypt("rpnreryehpepdvcfsrpq");
        assert plainText.equals(PLAIN_TEXT);
    }

    @Test
    public void testEncryptThenDecrypt() {

        SubstitutionCipher substitutionCipher = new SubstitutionCipher(ENCRYPTED_ALPHABET);
        String cipherText = substitutionCipher.encrypt(PLAIN_TEXT);
        String decryptedText = substitutionCipher.decrypt(cipherText);
        assert decryptedText.equals(PLAIN_TEXT);
    }

    @Test
    public void testAlphabetWithDuplicatesThrowsException() {
        boolean exceptionThrown = false;
        try {
            SubstitutionCipher substitutionCipher = new SubstitutionCipher(SHORT_ALPHABET);
        } catch (AlphabetLengthMismatchException e) {
            exceptionThrown = true;
        }
        assert exceptionThrown;
    }
}
