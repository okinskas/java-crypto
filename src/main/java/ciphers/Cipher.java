package ciphers;

import utils.CipherDictionary;

public abstract class Cipher implements CipherInterface {

    protected final String key;
    protected final CipherDictionary dictionary;

    Cipher(String key) {
        this.key = key.toLowerCase();
        dictionary = new CipherDictionary();
    }

    Cipher(String key, String alphabet) {
        this.key = key.toLowerCase();
        dictionary = new CipherDictionary(alphabet);
    }

    public String getKey() {
        return key;
    }

    public String getAlphabet() {
        return dictionary.getAlphabet();
    }
}
