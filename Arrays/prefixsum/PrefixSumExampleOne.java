package Arrays.prefixsum;

public class PrefixSumExampleOne {

    /*
     * 
     * Example 1: Given an integer array nums,
     * an array queries where queries[i] = [x, y]
     * and an integer limit, return a boolean array
     * that represents the answer to each query.
     * A query is true if the sum of the subarray
     * from x to y is less than limit, or false otherwise.
     * 
     * Prefix Sum Formula
     * prefix[j] - prefix[i] + nums[i]
     * or
     * prefix[j] - prefix[i-1]
     * 
     * prefix[] = [1, 7, 10, 12, 19, 21]
     * 12 - 1 + 1 = 12 (true)
     * 21 - 10 + 3 = 14 (false)
     * 19 - 10 + 3 = 12 (true)
     * 
     * For example, given nums = [1, 6, 3, 2, 7, 2], 
     * queries = [[0, 3], [2, 5], [2, 4]], and 
     * limit = 13, the answer is [true, false, true]. 
     * For each query, the subarray sums are [12, 14, 12].
     * 
     */
    public static void main(String[] args) {

        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{0,3},{2,5},{2,4}};
        int limit = 13;

        boolean[] results = prefixSum(nums, queries, limit);

        for (boolean b : results) {
            System.out.print(b + "... ");
        }
        
    }

    static boolean[] prefixSum(int [] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int curr = 0;

        // O(n) time complexity to initialize the prefix sum array
        for(int i = 1; i < nums.length; i++) {
            prefix[i]= prefix[i-1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i< queries.length; i++) {
            // what do I want to do?
            // get x and y
            int x = queries[i][0], y = queries[i][1];
            // then get the sum of the subarray at the
            curr = prefix[y] - prefix[x] + nums[x];
            // x and y bounds
            ans[i] = curr < limit;
        }

        return ans;

    }

}
