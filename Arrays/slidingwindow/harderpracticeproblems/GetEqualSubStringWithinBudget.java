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
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

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
        // String s = "pxezla";
        // String t = "loewbi";
        // int maxCost = 25;

        System.out.println(getMaxLengthSubString(s, t, maxCost));
        
    }

    public static int getMaxLengthSubString(String s, String t, int maxCost) {

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int absoluteCost = 0;
        int subStringLength = 0;
        int currentCost = maxCost;

        for(int i = 0; i<charS.length; i++) {
            System.out.println("Starting currentCost = " + currentCost);

            byte tempS = (byte) charS[i];
            byte tempT = (byte) charT[i];

            int cost = tempS - tempT;
            System.out.println(charS[i] + " = " + tempS);
            System.out.println(charT[i] + " = " + tempT);
            System.out.println(charS[i] + " - " + charT[i] + " = " + cost);
            System.out.println(tempS + " - " + tempT + " = " + cost);
            System.out.println("cost = tempS - tempT\n" + tempS + " - " + tempT + " = " + cost);

            boolean areTheyEqual = charS[i] == charT[i] ? true: false;

            absoluteCost = cost < 0 ? cost* -1: cost;
            System.out.println("absoluteCost = " + absoluteCost);

            if(currentCost <= maxCost || areTheyEqual) {
                System.out.println("currentCost is less than or equal to maxCost");
                currentCost-=absoluteCost;
                // maxCost=-absoluteCost;
                System.out.println("updated currentCost = " + currentCost);
                System.out.println("maxCost = " + maxCost);
                if(currentCost >= absoluteCost) {
                    subStringLength++;
                    // break;
                } else {
                    currentCost+=absoluteCost;
                }
                System.out.println("subStringLength = " + subStringLength);
            }
            System.out.println();
        }

        return subStringLength;

    }
}
