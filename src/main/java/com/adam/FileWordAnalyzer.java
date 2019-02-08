package com.adam;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        //returns the words ordered by alphabetically as an ArrayList
        List<String> words = getWords();
        words = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        Collections.sort(words);
        return words;
    }

    public List<String> getWordsContainingSubstring(String subString ) throws IOException {
        //returns the words which contains the subString
        return getWords().stream()
                .map(String::toLowerCase)
                .filter(w -> w.contains(subString))
                .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes () throws IOException {
        //returns the words from the String which are palindrome
        return getWords().stream().filter(this::isPalindrome).collect(Collectors.toList());
    }

    private boolean isPalindrome(String word){
        List<String> og = Arrays.asList(word.toLowerCase().split(""));
        List<String> reversed = Arrays.asList(word.toLowerCase().split(""));
        Collections.reverse(reversed);
        return String.join("", og).equals(String.join("", reversed));
    }

    private List<String> getWords() throws IOException {
        String lines = filePartReader.read();
        lines = lines.replace("\n", " ");
        return Arrays.asList(lines.split(" "));
    }
}
