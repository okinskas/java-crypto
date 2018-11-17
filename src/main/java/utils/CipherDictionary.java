package utils;

import java.util.HashMap;

public class CipherDictionary {

    public static final String STANDARD_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String alphabet;
    private final HashMap<Character, Integer> stringIntegerHashMap = new HashMap<>();
    private final HashMap<Integer, Character> integerStringHashMap = new HashMap<>();

    public CipherDictionary() {
        this.alphabet = STANDARD_ALPHABET;
        populate();
    }

    public CipherDictionary(String alphabet) {
        if (!CipherUtils.hasOnlyUniqueCharacters(alphabet)) {
            throw new NonUniqueAlphabetException("Cipher alphabet must be unique.");
        }
        this.alphabet = alphabet.toLowerCase();
        populate();
    }

    public String getAlphabet() {
        return alphabet;
    }

    public Character get(Integer key) {
        return integerStringHashMap.get(key);
    }

    public Integer get(Character key) {
        return stringIntegerHashMap.get(key);
    }

    private Character put(Integer key, Character value) {
        return integerStringHashMap.put(key, value);
    }

    private Integer put(Character key, Integer value) {
        return stringIntegerHashMap.put(key, value);
    }

    private void populate() {

        for (int i = 0; i < alphabet.length(); i++) {
            put(alphabet.charAt(i), i);
            put(i, alphabet.charAt(i));
        }
    }
}
