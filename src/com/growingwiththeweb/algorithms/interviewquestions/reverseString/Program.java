package com.growingwiththeweb.algorithms.interviewquestions.reversestring;

public class Program {
    public static void main(String[] args) {
        assert reverseViaCharArray("abc123def").equals("fed321cba");
        assert reverseViaStringBuilderA("abc123def").equals("fed321cba");
        assert reverseViaStringBuilderB("abc123def").equals("fed321cba");
        assert reverseViaCharArray("abcd1234").equals("4321dcba");
        assert reverseViaStringBuilderA("abcd1234").equals("4321dcba");
        assert reverseViaStringBuilderB("abcd1234").equals("4321dcba");

        System.out.println("Tests passed");
    }

    public static String reverseViaCharArray(String text) {
        char[] charArray = text.toCharArray();
        int start = -1;
        int end = charArray.length;
        while (++start < --end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
        }
        return String.valueOf(charArray);
    }

    public static String reverseViaStringBuilderA(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseViaStringBuilderB(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
