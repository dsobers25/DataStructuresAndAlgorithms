package Arrays.twopointer;

/*
* Given an integer array nums sorted in non-decreasing order, 
* return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, 
could you find an O(n) solution using a different approach?
* 
* 
*/

public class SortedSquares {
    
    public static int[] sortedSquares(int[] nums) {
        // use loop to iterate over array
        int size = nums.length;
        int left = 0, right = size - 1;
        int pos = size -1;
        int[] result = new int[size];
        
        // key insight is that the ends of the array will always be the most extreme
        // whether the squared neg is larger than the squared positive or vice versa
        // left starts at 0
        // right and position starts at end index
        // while loop iterates until it reaches middle with left & right collide
        // each iteration left will increase +1 and right will decrease -1
        // left & right index will be squared and compared.
        // largest number will be stored at the end of the result array
        // starting at the end of the results list using pos variable as index
        // decrementing every iteration
        // ending in fully squared and sorted input array
        
        while(left <= right) {
            // local var for checking left and right square
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];
            if(leftSqr > rightSqr) {
                result[pos] = leftSqr;
                // don't move index until value is set for larger squared number
                left++;
            } else {
                result[pos] = rightSqr;
                // don't move index until value is set for larger squared number
                right--;
            }
            pos--;
        }
        
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        int[] result = sortedSquares(arr);
        
        System.out.print("[");
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if(i == result.length - 1) {                
                System.out.print("]");
            } else {
                System.out.print(", ");
            }
        }
    }
}
