package LessonR02;

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String sentence = in.nextLine();

        String cleaned = sentence.toLowerCase().replace("^a-z", "");

        if (isPalindrome(cleaned)) {
            System.out.println("The word is a palindrome.");
        } else {
            System.out.println("The word is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }

}
