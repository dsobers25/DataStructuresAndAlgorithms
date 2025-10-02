package Arrays.slidingwindow;

/*
 * Fixed Width Sliding Window Problem
 * 
 * Example 4: Given an integer array nums and an 
 * integer k, find the sum of the subarray with 
 * the largest sum whose length is k.
 * 
 */

public class SlidingWindowExampleFour {
    public static void main(String[] args) {

        int[] nums = {3, -1, 4, 12, -8, 5, 6};
        int k = 4;
        // expecting to get 18
        System.out.println(fixedWidthLargestSum(nums, k));
        
    }

    static int fixedWidthLargestSum(int[] nums, int k) {
        int curr = 0;
        
        for(int right = 0; right < k; right++) {
            curr +=nums[right];
        }
        
        int ans = curr;
        for(int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(curr, ans);
        }

        return ans;
    }
}
