package ciphers;

import utils.CipherUtils;
import java.util.HashMap;

public class TranspositionCipher extends Cipher {

    public TranspositionCipher(String key) {
        super(key);
    }

    public TranspositionCipher(String key, String alphabet) {
        super(key, alphabet);
    }

    @Override
    public String encrypt(String plainText) {

        StringBuilder cipherTextBuilder = new StringBuilder();
        String[] keywordToPlaintextMapping = new String[key.length()];

        int currentKeyPosition = 0;
        for (int i = 0; i < plainText.length(); i++) {
            if (currentKeyPosition >= key.length()) {
                currentKeyPosition = 0;
            }
            if (keywordToPlaintextMapping[currentKeyPosition] == null) {
                keywordToPlaintextMapping[currentKeyPosition] = "";
            }
            keywordToPlaintextMapping[currentKeyPosition] += plainText.charAt(i);
            currentKeyPosition++;
        }

        String sortedKey = CipherUtils.getSortedString(key);

        for (int i = 0; i < sortedKey.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (keywordToPlaintextMapping[j] != null && key.charAt(j) == sortedKey.charAt(i)) {
                    cipherTextBuilder.append(keywordToPlaintextMapping[j]);
                    keywordToPlaintextMapping[j] = null;
                }
            }
        }

        return cipherTextBuilder.toString();
    }

    @Override
    public String decrypt(String cipherText) {

        StringBuilder plainTextBuilder = new StringBuilder();
        String sortedKey = CipherUtils.getSortedString(key);
        String[] keywordToCipherTextMapping = new String[sortedKey.length()];

        int remainder = cipherText.length() % sortedKey.length();
        int numberOfKeyCharsWithRemainders = remainder;
        int charsPerKeyChar = (int) Math.floor(cipherText.length() / sortedKey.length());
        int currentKeyPosition = 0;
        int currentCharPosition = 0;

        while (currentCharPosition < cipherText.length()) {

            int extra = 0;

            for (int i = 0; i < sortedKey.length(); i++) {
                for (int j = 0; j < key.length(); j++) {
                    if (sortedKey.charAt(j) == key.charAt(i)
                            &&  i < numberOfKeyCharsWithRemainders
                            && remainder > 0) {
                        extra = 1;
                        remainder--;
                    }
                }
            }

            keywordToCipherTextMapping[currentKeyPosition] = cipherText.substring(currentCharPosition, currentCharPosition + charsPerKeyChar + extra);
            currentCharPosition += charsPerKeyChar + extra;
            currentKeyPosition++;
        }

        String[] orderedChars = new String[key.length()];

        for (int i = 0; i < orderedChars.length; i++) {
            for (int j = 0; j < sortedKey.length(); j++) {
                if (keywordToCipherTextMapping[j] != null && sortedKey.charAt(j) == key.charAt(i)) {
                    orderedChars[i] = keywordToCipherTextMapping[j];
                    keywordToCipherTextMapping[i] = null;
                }
            }
        }

        for(String encryptedText : orderedChars) {
            plainTextBuilder.append(encryptedText).append(" ");
        }

        return plainTextBuilder.toString();
    }

    public static TranspositionDataHolder[] getEncrytionArray(String plainText, String key) {

        HashMap<Character, Integer> instanceMap = new HashMap<>();
        TranspositionDataHolder[] data = new TranspositionDataHolder[key.length()];
        String sortedKey = CipherUtils.getSortedString(key);

        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            TranspositionDataHolder current = new TranspositionDataHolder(currentChar);
            Integer characterCount = instanceMap.get(currentChar);
            if (characterCount != null) {
                current.setPosition(i);
                current.setAlphaPosition(i + characterCount);
                instanceMap.put(currentChar, characterCount + 1);
            } else {
                for (int j = 0; j < sortedKey.length(); j++) {
                    if (sortedKey.charAt(j) == currentChar) {
                        current.setPosition(i);
                        current.setAlphaPosition(j);
                        instanceMap.put(currentChar, 1);
                        break;
                    }
                }
            }
            data[i] = current;
        }

        int dataIndex = 0;
        for (int i = 0; i < plainText.length(); i++) {
            if (dataIndex >= data.length) {
                dataIndex = 0;
            }
            data[dataIndex].addChar(plainText.charAt(i));
            dataIndex++;
        }

        return data;
    }

        public static TranspositionDataHolder[] getDecryptionArray(String cipherText, String key) {

        HashMap<Character, Integer> instanceMap = new HashMap<>();
        TranspositionDataHolder[] data = new TranspositionDataHolder[key.length()];
        String sortedKey = CipherUtils.getSortedString(key);
        int maxCharsLength = (int) Math.ceil(((double) cipherText.length() / (double) key.length()));
        int overValues = cipherText.length() % key.length();

        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            TranspositionDataHolder current = new TranspositionDataHolder(currentChar);
            Integer characterCount = instanceMap.get(currentChar);
            if (characterCount != null) {
                current.setPosition(i);
                current.setAlphaPosition(i + characterCount);
                instanceMap.put(currentChar, characterCount + 1);
            } else {
                for (int j = 0; j < sortedKey.length(); j++) {
                    if (sortedKey.charAt(j) == currentChar) {
                        current.setPosition(i);
                        current.setAlphaPosition(j);
                        instanceMap.put(currentChar, 1);
                        break;
                    }
                }
            }
            data[i] = current;
        }

        int cipherIndex = 0;
        for (int i = 0; i < sortedKey.length(); i++) {
            int current = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[j].getAlphaPosition() == i) {
                    current = j;
                    break;
                }
            }
            int lengthToAdd = maxCharsLength - 1;
            if (data[current].getPosition() < overValues) {
                lengthToAdd++;
            }

            data[current].addString(cipherText.substring(cipherIndex, cipherIndex + lengthToAdd));
            cipherIndex += lengthToAdd;
        }

        return data;
    }

    public static String encrypt(String plainText, String key) {

        TranspositionDataHolder[] data = getEncrytionArray(plainText, key);
        StringBuilder cipherText = new StringBuilder();

        int keyIndex = 0;
        while (keyIndex < key.length()) {
            for (int i = 0; i < key.length(); i++) {
                if (data[i].getAlphaPosition() == keyIndex) {
                    cipherText.append(data[i].getChars());
                    keyIndex++;
                }
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        TranspositionDataHolder[] data = getDecryptionArray(cipherText, key);
        StringBuilder plainText = new StringBuilder();


        for (TranspositionDataHolder current : data) {
            plainText.append(current.getChars());
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
//        TranspositionDataHolder[] arr = getDataArray("computer", "smarty");

        String plain = "computer";
        String key = "smarty";

        String cipherText = encrypt(plain, key);
        System.out.println(cipherText);
        String plainText = decrypt(cipherText, key);
        System.out.println(plainText);
    }
}
