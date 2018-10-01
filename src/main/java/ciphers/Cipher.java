package ciphers;

import utils.CipherDictionary;

class Cipher {

    final String key;
    final CipherDictionary dictionary;

    Cipher(String key) {
        this.key = key.toLowerCase();
        dictionary = new CipherDictionary();
    }

    Cipher(String key, String alphabet) {
        this.key = key.toLowerCase();
        dictionary = new CipherDictionary(alphabet);
    }

    public String encrypt(String plainText) {
        return "";
    }

    public String decrypt(String cipherText) {

        return "";
    }

    String getKey() {
        return key;
    }

    String getAlphabet() {
        return dictionary.getAlphabet();
    }
}
