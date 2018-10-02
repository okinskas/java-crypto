package ciphers;

import utils.CipherDictionary;

public class SubstitutionCipher extends Cipher {

    private CipherDictionary encryptionDictionary;

    public SubstitutionCipher(String encryptionAlphabet) {
        // key is treated as the encryption alphabet
        super(encryptionAlphabet);
        encryptionDictionary = new CipherDictionary(encryptionAlphabet);
        compareAlphabetLengths();
    }

    public SubstitutionCipher(String encryptionAlphabet, String alphabet) {
        super(encryptionAlphabet, alphabet);
        encryptionDictionary = new CipherDictionary(encryptionAlphabet);
        compareAlphabetLengths();
    }

    public String encrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            Integer charKey = dictionary.get(plainText.charAt(i));
            cipherText.append(encryptionDictionary.get(charKey));
        }

        return cipherText.toString();
    }

    public String decrypt(String cipherText) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            Integer charKey = encryptionDictionary.get(cipherText.charAt(i));
            plainText.append(dictionary.get(charKey));
        }

        return plainText.toString();
    }

    private void compareAlphabetLengths() {
        if (dictionary.getAlphabet().length() != encryptionDictionary.getAlphabet().length()) {
            throw new AlphabetLengthMismatchException("Base and encryption alphabets must be the same length.");
        }
    }
}
