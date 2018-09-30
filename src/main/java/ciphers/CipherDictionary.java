package ciphers;

import java.util.HashMap;

class CipherDictionary {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz ";
    private final HashMap<Character, Integer> stringIntegerHashMap = new HashMap<>();
    private final HashMap<Integer, Character> integerStringHashMap = new HashMap<>();

    CipherDictionary() {
        populate();
    }

    CipherDictionary(String alphabet) {
        this.alphabet = alphabet.toLowerCase();
        populate();
    }

    String getAlphabet() {
        return alphabet;
    }

    Character get(Integer key) {
        return integerStringHashMap.get(key);
    }

    Integer get(Character key) {
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
