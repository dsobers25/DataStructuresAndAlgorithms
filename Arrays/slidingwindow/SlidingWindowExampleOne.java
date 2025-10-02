package Arrays.slidingwindow;

public class SlidingWindowExampleOne {
    
    /*
     * Example 1: Given an array of positive integers 
     * nums and an integer k, find the length of the 
     * longest subarray whose sum is less than or equal
     * to k. This is the problem we have been talking
     * about above. We will now formally solve it.
     * 
     */
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5 , 6};

        int k = 7;

        System.out.println(longestSubArraySumGreaterThanK(nums, k));


        
    }

    static int longestSubArraySumGreaterThanK(int[] nums, int k) {
        int longestSubArraySum = 0;
        int left = 0;
        int current = 0;

        for(int right =0; right < nums.length; right++) {
            current += nums[right];
            
            while(current > k) {
                current -= nums[left];
                left++;
            }
            
            int subArrayFormula = right - left + 1;
            longestSubArraySum =  subArrayFormula > longestSubArraySum ? subArrayFormula : longestSubArraySum;
        }



        return longestSubArraySum;

    }


}
