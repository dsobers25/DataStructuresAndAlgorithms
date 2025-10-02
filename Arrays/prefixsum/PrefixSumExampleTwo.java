package Arrays.prefixsum;

public class PrefixSumExampleTwo {

    /*
     * Example 2: 2270. Number of Ways to Split Array
     * 
     * Given an integer array nums, find the number of
     * ways to split the array into two parts so that
     * the first section has a sum greater than or equal
     * to the sum of the second section. The second
     * section should have at least one number.
     * 
     */
    public static void main(String[] args) {

        int[] nums = {10,4,-8,7};

        System.out.println(howManySplits(nums));

        
    }

    static int howManySplits(int[] nums) {

        // create prefix sum array
        int[] prefix = new int[nums.length];
        // initialize first of prefix sum to nums[0]
        prefix[0] = nums[0];

        // initialize the rest of the array
        // each element of prefix sum will add
        // current element of nums + previous element of nums
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int splitCount = 0;
        // int left = 0; //(didn't really need it)
        int currL = 0;
        int currR = 0;

        for(int right = 0; right<prefix.length-1; right++) {
            // check if sum of current window is <= right window
            // currL = prefix[right] - prefix[left] +nums[left]; //(additional complexity)
            currL = prefix[right];
            System.out.println("simplified currL = " + currL);
            // currR = prefix[prefix.length-1] - prefix[right];
            currR = prefix[prefix.length-1] - prefix[right];
            System.out.println("simplified currR = " + currR);

            // If current left subarray is <= current right subarray
            // then increment splitCount by 1
            if(currL>=currR) {
                splitCount++;
            }

        }

        return splitCount;
    }
}
