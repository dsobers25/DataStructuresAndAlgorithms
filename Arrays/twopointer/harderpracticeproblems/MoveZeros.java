package Arrays.twopointer.harderpracticeproblems;

import java.util.Arrays;

/**
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
left = 0
right = 0

for (int right = 0; right < nums.length; right++) {
if (nums[right] != 0) false

nums = [0,1,0,3,12]

left = 0
right = 1
if (nums[right] != 0) true
int temp = nums[left];
nums[left] = nums[right];
nums[right] = temp;
left++;

nums = [1,0,0,3,12]

left = 1
right = 2
if (nums[right] != 0) false

nums = [1,0,0,3,12]

left = 1
right = 3
if (nums[right] != 0) true
int temp = nums[left];
nums[left] = nums[right];
nums[right] = temp;
left++;

nums = [1,3,0,0,12]

left = 2
right = 4
if (nums[right] != 0)  true
int temp = nums[left];
nums[left] = nums[right];
nums[right] = temp;
left++;

nums = [1,3,12,0,0]

Output: [1,3,12,0,0]


Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
 
 *
 */

public class MoveZeros {
    
    public static void main(String[] args) {
        // TC1
        // expected output: [1, 3, 12, 0, 0]
        int[] nums = {0,1,0,3,12};

        System.out.println(Arrays.toString(moveZeros(nums)));
        
    }

    static int[] moveZeros(int[] nums) {
        int left = 0;  // Pointer for position to place next non-zero
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap non-zero element to the left pointer position
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return nums;
    }
}
