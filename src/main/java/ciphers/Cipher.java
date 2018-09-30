package ciphers;

class Cipher {

    final String key;
    final CipherDictionary dictionary;

    public Cipher(String key) {
        this.key = key.toLowerCase();
        dictionary = new CipherDictionary();
    }

    public Cipher(String key, String alphabet) {
        this.key = key.toLowerCase();
        dictionary = new CipherDictionary(alphabet);
    }

    public String encrypt(String plainText) {
        return "";
    }

    public String decrypt(String cipherText) {

        return "";
    }

    public String getKey() {
        return key;
    }

    public String getAlphabet() {
        return dictionary.getAlphabet();
    }
}
