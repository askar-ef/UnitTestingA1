package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsQuizTest {

    // Pengujian untuk metode reverseString()
    @Test
    public void testReverseString() {
        StringUtilsQuiz stringUtils = new StringUtilsQuiz();

        // Testing null input
        // Memastikan bahwa metode mengembalikan null saat input adalah null
        assertNull(stringUtils.reverseString(null));

        // Testing empty string
        // Memastikan bahwa metode mengembalikan string kosong saat input adalah string kosong
        assertEquals("", stringUtils.reverseString(""));

        // Testing non-empty string
        // Memastikan bahwa metode dapat membalikkan string dengan benar
        assertEquals("dlroW olleH", stringUtils.reverseString("Hello World"));
    }

    // Pengujian untuk metode isPalindrome()
    @Test
    public void testIsPalindrome() {
        StringUtilsQuiz stringUtils = new StringUtilsQuiz();

        // Testing null input
        // Memastikan bahwa metode mengembalikan false saat input adalah null
        assertFalse(stringUtils.isPalindrome(null));

        // Testing empty string
        // Memastikan bahwa metode mengembalikan true saat input adalah string kosong
        assertTrue(stringUtils.isPalindrome(""));

        // Testing palindrome
        // Memastikan bahwa metode mengembalikan true saat input adalah palindrome
        assertTrue(stringUtils.isPalindrome("Radar"));

        // Testing non-palindrome
        // Memastikan bahwa metode mengembalikan false saat input adalah non-palindrome
        assertFalse(stringUtils.isPalindrome("Hello World"));
    }

    // Pengujian untuk metode countVowels()
    @Test
    public void testCountVowels() {
        StringUtilsQuiz stringUtils = new StringUtilsQuiz();

        // Testing null input
        // Memastikan bahwa metode mengembalikan 0 saat input adalah null
        assertEquals(0, stringUtils.countVowels(null));

        // Testing empty string
        // Memastikan bahwa metode mengembalikan 0 saat input adalah string kosong
        assertEquals(0, stringUtils.countVowels(""));

        // Testing string with vowels
        // Memastikan bahwa metode mengembalikan jumlah vokal yang benar dalam string
        assertEquals(3, stringUtils.countVowels("Hello World"));

        // Testing string without vowels
        // Memastikan bahwa metode mengembalikan 0 saat input tidak mengandung vokal
        assertEquals(0, stringUtils.countVowels("Try"));
    }
}
