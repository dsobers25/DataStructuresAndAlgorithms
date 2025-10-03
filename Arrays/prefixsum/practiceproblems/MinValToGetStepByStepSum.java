package Arrays.prefixsum.practiceproblems;


/*
 * 
 * Given an array of integers nums, you start 
 * with an initial positive value startValue.
 * 
 * In each iteration, you calculate the step 
 * by step sum of startValue plus elements 
 * in nums (from left to right).
 * 
 * Return the minimum positive value of startValue 
 * such that the step by step sum is never less than 1.
 * 
 * 
 * 

Example 1:

Input: nums = [-3,2,-3,4,2]
prefix sum =  [-3,-1,-4,0,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2

Example 2:

Input: nums = [1,2]
prefix sum: [1,3]
Output: 1
Explanation: Minimum start value should be positive.

Example 3:

Input: nums = [1,-2,-3]
prefix sum = [1,-1,-4]
Output: 5


Example 4:

Input: nums = [-5,-2,4,4,-2]
prefix sum = [-5,-7,-3,1,-1]
Output: 8

Example 5:

Input: nums = [-12]
Output: 13

Example 6:

Input: nums = [1,2]
Output: 1

Example 7:

Input: nums = [2,3,5,-5,-1]
prefix sum = [2,5,10,5,4]
Output: 1

Pattern: when prefix sum is > 0 the minimum positive start value = 1
         and when minimun prefix sum < 0 
         the minimum positive start value = minimun prefix sum * -1 + 1


*/

public class MinValToGetStepByStepSum {
    public static void main(String[] args) {
        // int[] nums = {-3,2,-3,4,2};
        // int[] nums = {1,2};
        // int[] nums = {1, -2, -3};
        // int[] nums = {-5,-2,4,4,-2};
        int[] nums = {2,3,5,-5,-1};
        System.out.println(minValStepByStepSum(nums));
        
    }

    static int minValStepByStepSum(int[] nums) {
        // get prefix sum
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int startValue = 0;

        for(int i = 1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
            // get the smallest number
            startValue = Math.min(prefix[i], nums[0]);
        }

        if(startValue < 0) {
            startValue*=-1;
            startValue++;
        } else {
            startValue = 1;
        }

        return startValue;
    }
}
