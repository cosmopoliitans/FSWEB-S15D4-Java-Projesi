package workintech.s14d4.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("*****************");
        System.out.println(checkForPalindrome2("abccba"));
        System.out.println(checkForPalindrome2("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome2("I did, did I?"));
        System.out.println(checkForPalindrome2("hello"));
        System.out.println(checkForPalindrome2("Don't node"));
        System.out.println("*****************");
        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(75));

    }

    public static boolean checkForPalindrome(String text) {


        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Stack<Character> stack = new Stack<>(); // LIFO (Last in First Out)

        for (char c : cleanedText.toCharArray()) {
            stack.push(c);
        }

        int textLength = cleanedText.length();
        for (int i = 0; i < textLength; i++) {
            if (cleanedText.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkForPalindrome2(String text){
        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : cleanedText.toCharArray()){
            queue.offer(c);
            stack.push(c);

        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(((LinkedList<Character>) queue).removeFirst())){
                return false;
            }
        }
        return true;
    }
    public static String convertDecimalToBinary(int num){
        final int base = 2;
        Stack digits = new Stack<>();

        while (num > 0){
            digits.push(num % 2);
            num = num / 2;
        }

        String bits = "";
        while (!digits.isEmpty()){
            bits += digits.pop();
        }
        digits.toString();
        return bits;
    }

}