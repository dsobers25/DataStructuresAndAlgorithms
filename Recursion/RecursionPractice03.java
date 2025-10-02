package Recursion;


/*
 * 
 *  Author: Long Wind
 *  Date: 4-15-2025
 * 
 */

public class RecursionPractice03 {
    
    public static void main(String[] args) {

        int x = 4;

        System.out.println(fibonacci(x));
        
    }


    // Fibinacci Sequence

    // Main Idea: Each number is the sum of the 2 previous numbers before it
    // Fomula: Fn = F(n-1) + F(n-2)
    public static int fibonacci(int x) {
        // System.out.println("x is = " + x);
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        
        // System.out.println("(x - 1) = " + (x - 1));
        int oneBack = fibonacci(x - 1);
        // System.out.println("(x - 2) = " + (x - 2));
        int twoBack = fibonacci(x - 2);
        
        return oneBack + twoBack;
    }
    


    /*
     * I want it to perform the factorial
     * given a number x = 4
     * 
     * sequence should be like below
     * 4! = 4 * 3 * 2 * 1
     * 4! = (12 * 2) * 1
     * 4! = 24 * 1 = 24
     * 4! = 24
     * 
    */

}
