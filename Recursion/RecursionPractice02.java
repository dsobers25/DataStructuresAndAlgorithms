package Recursion;


/*
 * 
 *  Author: Long Wind
 *  Date: 4-15-2025
 * 
 */

public class RecursionPractice02 {
    
    public static void main(String[] args) {

        int x = 10000;

        long startTime = System.currentTimeMillis();
        // countX(1, x);
        countArr(x);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        
    }


    // Fibinacci Sequence


    // Count Up to X
    public static int countX(int start, int x)
    {

        if(start > x) {
            return start;
        }

        System.out.println(start);
        return countX(start + 1, x);
    }

    // how fast would it take to linearly traverse a data structure
    public static void countArr(int x)
    {
        int[] arr = new int[x];

        for(int i = 0; i < x; i++)
        {
            System.out.println(i);
        }
    }
}
