package Arrays.slidingwindow.harderpracticeproblems;

import java.util.ArrayList;
import java.util.List;

public class MaxNumVowelsInSubStringOptimized {

    /*
     * 
     * 
     *  
     * 
     * 
     * 
1456. Maximum Number of Vowels in a Substring of Given Length

Difficulty: Medium

Hint

Given a string s and an integer k, return the maximum number of
vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

     * 
     * 
     */
    
    public static void main(String[] args) {

        // TC#1: Output = 3
        // String s = "abciiidef";
        // int k = 3;

        // TC#2: Output = 2
        // String s = "aeiou";
        // int k = 2;

        // TC#3: Output = 2
        String s = "leetcode";
        int k = 3;

        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char[] str = s.toCharArray();
        int left = 0;
        int vowelCount = 0;
        int maxVowels = 0;

        for(int right = 0; right < str.length; right++) {

            if(vowels.contains(str[right])) {
                vowelCount++;
            }

            if(right - left +1 == k) {
                // get max vowel count from substring
                maxVowels = Math.max(vowelCount, maxVowels);

                if(vowels.contains(str[left])) {
                    vowelCount--;
                }
                left++; // move left bound forward

            }
            
        }

        return maxVowels;
    }
}
