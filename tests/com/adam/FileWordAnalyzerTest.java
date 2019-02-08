package com.adam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileWordAnalyzerTest {

    FileWordAnalyzer fwa;

    @BeforeAll
    void init(){
        FilePartReader reader = new FilePartReader();
        reader.setup("/Users/adamgonda/IdeaProjects/current/filepartreader-testing-with-junit-AdamGonda/fileWordAnalyzer_Test.txt");
        fwa = new FileWordAnalyzer(reader);
    }

    @Test
    void testGetWordsOrderedAlphabetically() throws IOException {
        //returns the words ordered by alphabetically as an ArrayList
        final String EXPECTED = String.join(" ", Arrays.asList(
                "anna", "bella", "bello", "cic", "civic", "deified", "dewed",
                "eve", "evitative", "hanah", "hello", "kayak", "makita", "minim",
                "mom", "redder", "reifier", "rotator", "rotor"));

        String result = String.join(" ", fwa.getWordsOrderedAlphabetically());
        assertEquals(EXPECTED, result);
    }


    @Test
    void testGetWordsContainingSubstring_1() throws IOException {
        //returns the words which contains the subString
        String EXPECTED = "bella hello bello";
        String result = String.join(" ", fwa.getWordsContainingSubstring("ell"));
        assertEquals(EXPECTED, result);
    }

    @Test
    void testGetWordsContainingSubstring_2() throws IOException {
        //returns the words which contains the subString
        String EXPECTED = "cic civic";
        String result = String.join(" ", fwa.getWordsContainingSubstring("ci"));
        assertEquals(EXPECTED, result);
    }

    @Test
    void testGetWordsContainingSubstring_3() throws IOException {
        //returns the words which contains the subString
        String EXPECTED = "evitative eve";
        String result = String.join(" ", fwa.getWordsContainingSubstring("ev"));
        assertEquals(EXPECTED, result);
    }

    @Test
    void testGetStringsWhichPalindromes() throws IOException {
        //returns the words from the String which are palindrome
        String EXPECTED = String.join(" ", Arrays.asList(
                "rotator", "evitative", "dewed", "rotor", "cic", "minim", "civic", "kayak",
                "Eve", "Anna", "deified", "Hanah", "mom", "redder", "reifier"));

        String result = String.join(" ", fwa.getStringsWhichPalindromes());
        assertEquals(EXPECTED, result);
    }

}