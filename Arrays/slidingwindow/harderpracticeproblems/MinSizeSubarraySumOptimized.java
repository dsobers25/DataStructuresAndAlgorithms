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

public class MinSizeSubarraySumOptimized {
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
        // int[] nums = {1,4,4};
        // int target = 4;
        // exp: 1
        // tc5
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;
        // exp: 2

        System.out.println(minSubArrayLen(target, nums));
    }

    // the intuition I get here to think ahead to understand the edge cases in which the right data
    // is returned. Since the goal of the program is to return the minimum length subarray
    // for the sum of an array greater than or equal to the target

    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, sum = nums[0], i = 0, j=1, prev=0;

        // sum is == to the first element of the array nums
        // the smallest sub array we can have is 1
        // so if sum is greater than the target
        // we'll return 1 

        if(sum > target){
            return 1;
        }
        
        while (j < nums.length && i < j) {
            if(prev != j){
                sum = sum + nums[j];
            }
            prev = j;

            if (nums[i] == target || nums[j] == target) {
                return 1;
            }

            if (sum < target) {
                j++;
            } else if (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum = sum - nums[i];
                i++;
            }

        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;

        }
    }
}
