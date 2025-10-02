package Recursion;

public class MyFirstRecursionProgram {

    // What is recursion??
    // - Recursion is when you have a method calling itself
    //   ultimately stopping once it reaches the base case

    public static void main(String[] args) {

        recursionExample(3);
        
    }

    public static int recursionExample(int n) {

        System.out.println("n = " + n);

        if(n <= 1) {
            return 1;
        }

        return recursionExample(n - 1);
    }
    
}
