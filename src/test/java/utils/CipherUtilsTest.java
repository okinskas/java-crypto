package utils;

import org.junit.Test;

public class CipherUtilsTest {

    private static final String UNIQUE_CHARACTER_SEQUENCE = "ABSDTYPOWQL";
    private static final String DUPLICATE_CHARACTER_SEQUENCE = "ABSDTBPOWAL";

    @Test
    public void testHasOnlyUniqueCharacters() {
        assert CipherUtils.hasOnlyUniqueCharacters(UNIQUE_CHARACTER_SEQUENCE);
    }

    @Test
    public void testHasDuplicateCharacters() {
        assert !CipherUtils.hasOnlyUniqueCharacters(DUPLICATE_CHARACTER_SEQUENCE);
    }
}
