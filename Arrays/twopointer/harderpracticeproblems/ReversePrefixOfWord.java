package Arrays.twopointer.harderpracticeproblems;

/*
 * 
 * 
 * 
 * 2000. Reverse Prefix of Word
Easy
Topics
premium lock icon
Companies
Hint
Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.

 

Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3. 
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
 

Constraints:

1 <= word.length <= 250
word consists of lowercase English letters.
ch is a lowercase English letter.
 * 
 * 
 */

public class ReversePrefixOfWord {

    public static void main(String[] args) {
        // TC1 (expected output: dcbaefd)
        // String word = "abcdefd";
        // Character ch = 'd';

        // TC2 (expected output: zxyxxe)
        // String word = "xyxzxe";
        // Character ch = 'z';

        //TC3 (expected output: abcd)
        String word = "abcd";
        Character ch = 'z';

        System.out.println(reversePrefix(word, ch));
        
    }

    static String reversePrefix(String word, char ch) {
        if(word.length() <= 1) {
            return word;
        }

        char[] wordArr = word.toCharArray();
        int left = 0;

        for(int right = 0; right<wordArr.length; right++) {
            if(wordArr[right] == ch) {
                while(left < right) {
                    char temp = wordArr[left];
                    wordArr[left] = wordArr[right];
                    wordArr[right] = temp;
                    left++;
                    right--;
                }
                break;
            }
        }

        return new String(wordArr);
    }
    
}
