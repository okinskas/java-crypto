package ciphers;

import java.util.HashMap;
import java.util.stream.IntStream;

public class VigenereCipher {

    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static HashMap<Character, Integer> alphaMap = new HashMap<>();
    public static HashMap<Integer, Character> numMap = new HashMap<>();
    public static HashMap<Character, Double> freqMap = new HashMap<>();
    static {
        IntStream.range(0, ALPHABET.length())
                .forEach(i -> {
                    alphaMap.put(ALPHABET.charAt(i), i);
                    numMap.put(i, ALPHABET.charAt(i));
                });
        freqMap.put('A', 8.167);
        freqMap.put('B', 1.492);
        freqMap.put('C', 2.782);
        freqMap.put('D', 4.253);
        freqMap.put('E', 12.702);
        freqMap.put('F', 2.228);
        freqMap.put('G', 2.015);
        freqMap.put('H', 6.094);
        freqMap.put('I', 6.996);
        freqMap.put('J', 0.153);
        freqMap.put('K', 0.772);
        freqMap.put('L', 4.025);
        freqMap.put('M', 2.406);
        freqMap.put('N', 6.749);
        freqMap.put('O', 7.507);
        freqMap.put('P', 1.929);
        freqMap.put('Q', 0.095);
        freqMap.put('R', 5.987);
        freqMap.put('S', 6.327);
        freqMap.put('T', 9.056);
        freqMap.put('U', 2.758);
        freqMap.put('V', 0.978);
        freqMap.put('W', 2.460);
        freqMap.put('X', 0.150);
        freqMap.put('Y', 1.974);
        freqMap.put('Z', 0.074);
    }

    public static String encrypt(String plainText) {
        return null;
    }

    public static String decrypt(String key, String cipherText) {
        int keyLength = key.length();
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            int cipherCharValue = alphaMap.get(cipherText.charAt(i));
            int keyCharValue = alphaMap.get(key.charAt(i % keyLength));
            int plainTextValue = Math.floorMod(cipherCharValue - keyCharValue, ALPHABET.length());
            plainText.append(numMap.get(plainTextValue));
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
        String s = decrypt("TESSOFTHEDURBERVILLES", "XRWVDFVLEQXKVVEZLLWPLAVWWOXBKI");
        System.out.println(s);
    }
}
