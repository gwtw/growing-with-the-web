package com.growingwiththeweb.algorithms.interviewQuestions.palindromeString;

public class Program {
    public static void main(String[] args) {
        String[] wordPalindromes = {
            "", "a", "aa", "aba", "anna", "madam", "deified"
        };
        String[] wordNotPalindromes = {
            "ab", "abc", "test", "round"
        };
        String[] phrasePalindromes = {
            "A car, a man, a maraca."
        };
        String[] phraseNotPalindromes = {
            "Not a palindrome"
        };

        for (int i = 0; i < wordPalindromes.length; i++) {
            assert isTextPalindrome(wordPalindromes[i]);
            assert isPhrasePalindrome(wordPalindromes[i]);
        }
        for (int i = 0; i < wordNotPalindromes.length; i++) {
            assert !isTextPalindrome(wordNotPalindromes[i]);
            assert !isPhrasePalindrome(wordNotPalindromes[i]);
        }
        for (int i = 0; i < phrasePalindromes.length; i++) {
            assert isPhrasePalindrome(phrasePalindromes[i]);
        }
        for (int i = 0; i < phraseNotPalindromes.length; i++) {
            assert !isPhrasePalindrome(phraseNotPalindromes[i]);
        }

        
        System.out.println("Tests passed");
    }
    
    public static boolean isTextPalindrome(String text) {
        if (text == null) {
            return false;
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPhrasePalindrome(String text) {
        String chars = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return isTextPalindrome(chars);
    }
}
