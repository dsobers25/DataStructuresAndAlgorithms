package Arrays.twopointer.harderpracticeproblems;

/*
 * Difficulty: Easy
 * 
 * 
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 

Constraints:

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 109
Both nums1 and nums2 are sorted in non-decreasing order.

 * 
 * 
 */

public class MinimumCommonValue {

    public static void main(String[] args) {
        // int[] nums1 = {1,2,3}, nums2 = {2,4};
        // expected output: 2
        // int[] nums1 = {1,2,3,6}, nums2 = {2,3,4,5};
        // expected output: 2
        int[] nums1 = {2,4}, nums2 = {1,2};
        System.out.println(minimumCommonInt(nums1, nums2));
        
    }

    // for loop iterates over nums1
    // each iteration check if value at nums2 on same index
    // nums1 = [1,2,3,4]
    // nums2 = [3,4,5]

    // track each pointer 
    // int i & j
    // use a while loop with condition based on
    // pointers being less than array length
    // then we use an if statement to see if elements at pointers
    // are equal, if so return the value as the first commonn element
    // is the minimum since the arrays are in non-decreasing order
    // otherwise increment the pointer who has the lesser value
    // if element at nums1[i] is less increment i
    // if element at nums2[j] is less increment j via the else statement
    static int minimumCommonInt(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];  // First common element is the minimum
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return -1;
    }
    
}
