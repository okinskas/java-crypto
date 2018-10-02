package ciphers;

public class CaesarCipher extends Cipher {

    private final Integer numericKey;

    public CaesarCipher(Integer numericKey) {
        super("");
        this.numericKey = numericKey;
    }

    public CaesarCipher(Integer numericKey, String alphabet) {

        super("", alphabet);
        this.numericKey = numericKey;
    }

    public String encrypt(String plainText) {

        StringBuilder cipherText = new StringBuilder();
        int alphabetLength = dictionary.getAlphabet().length();

        for (int i = 0; i < plainText.length(); i++) {

            int currentValue = dictionary.get(plainText.charAt(i));

            // Java's modulo does not work with negative numbers so we add the modulo number first to ensure LHS >= 0
            cipherText.append(dictionary.get((currentValue + numericKey + alphabetLength) % alphabetLength));
        }

        return cipherText.toString();
    }

    public String decrypt(String cipherText) {

        StringBuilder plainText = new StringBuilder();
        int alphabetLength = dictionary.getAlphabet().length();

        for (int i = 0; i < cipherText.length(); i++) {

            int currentValue = dictionary.get(cipherText.charAt(i));

            // Ensure LHS >= 0
            plainText.append(dictionary.get((currentValue - numericKey + alphabetLength) % alphabetLength));
        }

        return plainText.toString();
    }
}
