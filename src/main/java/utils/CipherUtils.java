package utils;

import java.util.HashMap;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class CipherUtils {

    public static boolean hasOnlyUniqueCharacters(String sequence) {

        HashMap<Integer, Integer> charInstanceCountMap = new HashMap<>();

        IntStream characters = sequence.chars();
        OptionalInt duplicateChar = characters
                .filter(currentChar -> charInstanceCountMap.putIfAbsent(currentChar, 1) != null)
                .findFirst();

        return !duplicateChar.isPresent();
    }
}
