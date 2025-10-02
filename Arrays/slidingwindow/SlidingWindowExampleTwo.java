package Arrays.slidingwindow;


/*
 * Example 2: You are given a binary 
 * string s (a string containing only "0" and "1").
 * You may choose up to one "0" and flip it to a "1".
 * What is the length of the longest substring achievable
 * that contains only "1"?

For example, given s = "1101100111", the answer is 5.
If you perform the flip at index 2, the string becomes 1111100111.
 */

public class SlidingWindowExampleTwo {
    
    public static void main(String[] args) {
        String binaryString = "1101100111";
        System.out.println(findLongestSubarray(binaryString));
    }

    static int findLongestSubarray(String binaryString){

        int left = 0;
        int curr = 0;
        int ans = 0;

        for(int right = 0; right < binaryString.length(); right++) {
            if(binaryString.charAt(right) == '0') {
                curr++;
            }

            while(curr > 1) {
                if(binaryString.charAt(left) == '0'){
                    curr--;
                }
                left++;
            }

            int subArrayFormula = right - left + 1;
            ans = Math.max(ans, subArrayFormula);
        }

        return ans;

    }
}
