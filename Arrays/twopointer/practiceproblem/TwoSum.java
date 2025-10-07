package Arrays.twopointer.practiceproblem;

import java.util.Arrays;

/*
 * 
 * 
 * Example 2: Given a sorted array of unique 
 * integers and a target integer, return true 
 * if there exists a pair of numbers that sum 
 * to target, false otherwise. This problem is 
 * similar to Two Sum. (In Two Sum, the input 
 * is not sorted).
 * 
 * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] 
 * and target = 13, return true because 4 + 9 = 13.
 * 
 * 
 */

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 6, 8, 9, 14, 15};
        System.out.println(twoSum(nums, 0));
        
    }

    static boolean twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);

        while (left < right) {
            if(nums[left] + nums[right] == target) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }
}
