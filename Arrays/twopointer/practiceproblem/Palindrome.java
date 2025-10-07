package Arrays.twopointer.practiceproblem;

/*
 * 
 * 
 * Two Pointer concept
 * 
 * Start the pointers at the edges of the input. 
 * Move them towards each other until they meet.
 * 
 * 
 * Example 1: Given a string s, return true if it is 
 * a palindrome, false otherwise.
 * 
 * A string is a palindrome if it reads the same forward 
 * as backward. That means, after reversing it, it is 
 * still the same string. For example: "abcdcba", or "racecar".
 * 
 */

public class Palindrome {

    public static void main(String[] args) {
        // String s = "amIapanlindrome?";
        String s = "racecar";

        System.out.println(palindromeChecker(s));
    }

    static boolean palindromeChecker(String s) {
        int leftIndex = 0, rightIndex = s.length()-1;
        
        while(leftIndex < rightIndex) {
            if(s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }
            
            leftIndex++;
            rightIndex--;
        }

        return true;
    }
    
}
