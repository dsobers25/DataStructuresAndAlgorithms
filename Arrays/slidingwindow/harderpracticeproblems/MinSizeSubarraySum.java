package Arrays.slidingwindow.harderpracticeproblems;

/*
 *
 * 
 * 209. Minimum Size Subarray Sum
 *  
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution,
try coding another solution of which the time complexity is O(n log(n)).
 * 
 */

public class MinSizeSubarraySum {

    public static void main(String[] args) {
        // tc1
        // int[] nums = {2,3,1,2,4,3};
        // int target = 7;
        // exp: 2
        // tc2
        // int[] nums = {1,1,1,1,1,1,1,1};
        // int target = 11;
        // exp: 0
        // tc3
        // int[] nums = {1,2,3,4,5};
        // int target = 11;
        // exp: 3
        // tc4
        int[] nums = {1,4,4};
        int target = 4;
        // exp: 1
        // tc5
        // int[] nums = {5,1,3,5,10,7,4,9,2,8};
        // int target = 15;
        // exp: 2

        System.out.println(minLengthSubarray(nums, target));
        
    }

    static int minLengthSubarray(int[] nums, int target) {
        if(nums.length == 1 && nums[0] >= target) {
            return 1;
        } else if (nums.length == 1 && nums[0] < target) {
            return 0;
        }

        // prefix sum
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i = 1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        // now we have the prefix sum array
        // formula for prefix sum array calculation: prefix[right] - prefix[left] + nums[left]

        int left = 0;
        int minSizeSubarray = nums.length;
        int curr = 0;
        boolean noMinSumFound = false;

        // if the right bound gets to the end of the array
        // and the left bound is less than the current index
        // use a while loop to check the remaining subarray
        // sums

        for(int right = 0; right<nums.length ; right++) {
            System.out.println("right = " + right);
            System.out.println("left = " + left);
            int subarraySum = prefix[right] - prefix[left] + nums[left];
            curr = right - left + 1;
            System.out.println("subarraySum = " + subarraySum);
            
            // if(subarraySum >= target) {
                while(subarraySum >= target && left <= right) {
                    System.out.println("while subarray = " + subarraySum);
                    subarraySum = prefix[right] - prefix[left] + nums[left];
                    System.out.println("while minSizeSubarray = " + minSizeSubarray);
                    curr = right - left + 1;

                    if(subarraySum >= target) {
                        System.out.println("subarray = " + subarraySum);
                        minSizeSubarray = Math.min(curr,minSizeSubarray);
                        System.out.println("minSizeSubarray = " + minSizeSubarray);
                        noMinSumFound = true;
                    }
                    
                    left++;
            // }
        }

    }
        if(!noMinSumFound) {
            return 0;
        }

        return minSizeSubarray;

}
    
}
