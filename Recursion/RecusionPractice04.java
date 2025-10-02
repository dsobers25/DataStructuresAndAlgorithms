package Recursion;

/*
 * 
 * The Staircase Problem
 * 
    You're climbing a staircase with n steps. Each time you can either climb 1 step or 2 steps.
    Write a recursive method that returns the number of distinct ways you can climb to the top.
    For example:

    If n = 1, there's 1 way (just climb 1 step)
    If n = 2, there are 2 ways (climb 1+1, or climb 2)
    If n = 3, there are 3 ways (1+1+1, 1+2, or 2+1)


 *
 * */

public class RecusionPractice04 {
    public static void main(String[] args) {

        int steps = 5;

        System.out.println(staircase(steps));
        
    }

    static int staircase(int n){
        if (n <= 1) {
            return 1;
        }

        return staircase(n - 1) + staircase(n - 2);

    }
}
