/*
 * 
 * 1732. Find the Highest Altitude
Difficulty Level: Easy

There is a biker going on a road trip. The road trip consists of n + 1 points 
at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in 
altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest 
altitude of a point.

 

Example 1:

Input: gain = [-5,1,5,0,-7]
-5 + 1 = -4
-4 + 5 = 1
1 + 0 = 1
1 + -7 = -6
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 

Constraints:

n == gain.length
1 <= n <= 100
-100 <= gain[i] <= 100

 * 
 * 
 */

package Arrays.prefixsum.harderpracticeproblems;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        
        // TC#1 Output = 1
        // int[] gain = {-5,1,5,0,-7};
        
        // TC#2 Output = 0
        int[] gain = {-4,-3,-2,-1,4,3,2};

        System.out.println(highestAltitude(gain));
        
    }
    
    static int highestAltitude(int[] gain) {

        if(gain.length <= 1) {
            System.out.println("less than 0");
            return 0;
        }

        int[] prefix = new int[gain.length];
        prefix[0] = gain[0];

        int highestAltitude = prefix[0];

        for(int i = 1; i < gain.length; i++) {
            prefix[i] = gain[i] + prefix[i-1];
            if(prefix[i] > highestAltitude) {
                highestAltitude = Math.max(highestAltitude, prefix[i]);
            }
        }


        return  highestAltitude > 0 ? highestAltitude: 0;
    }
}
