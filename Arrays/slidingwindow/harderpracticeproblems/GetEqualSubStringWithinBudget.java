package Arrays.slidingwindow.harderpracticeproblems;

/*
 * 
 * 
 * 
1208. Get Equal Substrings Within Budget

Difficulty Level: Medium

You are given two strings s and t of the same length and an integer maxCost.

You want to change s to t. Changing the ith character of s to ith character
of t costs |s[i] - t[i]| 
(i.e., the absolute difference between the ASCII values of the characters).

Return the maximum length of a substring of s that can be changed to be the
same as the corresponding substring of t with a cost less than or equal to
maxCost. If there is no substring from s that can be changed to its 
corresponding substring from t, return 0.

 

Example 1:

Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd".
That costs 3, so the maximum length is 3.
Example 2:

Input: s = "abcd", t = "cdef", maxCost = 3
Output: 1
Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
Example 3:

Input: s = "abcd", t = "acde", maxCost = 0
Output: 1
Explanation: You cannot make any change, so the maximum length is 1.
 

Constraints:

1 <= s.length <= 105
t.length == s.length
0 <= maxCost <= 106
s and t consist of only lowercase English letters.

 * 
 * 
 */

public class GetEqualSubStringWithinBudget {
    public static void main(String[] args) {

        // TC#1: Output = 3
        // String s = "abcd";
        // String t = "bcdf";
        // int maxCost = 3;

        // TC#2: Output = 1
        // String s = "abcd";
        // String t = "cdef";
        // int maxCost = 3;

        // TC#3: Output = 1
        // String s = "abcd";
        // String t = "acde";
        // int maxCost = 0;

        
        // TC#4: Output = 2
        // String s = "krrgw";
        // String t = "zjxss";
        // int maxCost = 19;

        // TC#5: Output = 4
        String s = "pxezla";
        String t = "loewbi";
        int maxCost = 25;

        System.out.println(getMaxLengthSubString(s, t, maxCost));
        
    }

    public static int getMaxLengthSubString(String s, String t, int maxCost) {

        int maxLength = 0;
        int left = 0;
        int currentCost = 0;

        // for loop iterates over s & t char arrays with right bound
        // cost is the abs difference of |s[right] - t[right]|
        // each iteration the abs diff will be added to the current cost
        // then While loop checks if current accumulated subarray cost > maxCost
        // if true we will increment +1 to left bound length
        // and subtract abs difference of |s[left] - t[left]|
        // until current cost is < maxCost 
        // Once inner while loop is false
        // We'll update maxLength with updated subarray length
        // Once loop is done, return maxLength

        for(int right = 0; right<s.length(); right++) {
            int absDiffRight = Math.abs(s.charAt(right) - t.charAt(right));
            System.out.println("absDiffRight = " + absDiffRight);
            currentCost += absDiffRight;
            System.out.println("Starting currentCost = " + currentCost);

            while(currentCost > maxCost) {
                int absDiffLeft = Math.abs(s.charAt(left) - t.charAt(left));
                currentCost -= absDiffLeft;
                left++;
            }

            maxLength = Math.max(right - left + 1, maxLength);

        }

        return maxLength;

    }
}
