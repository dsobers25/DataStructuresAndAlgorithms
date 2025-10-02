package Recursion;


public class RecursionPractice01 {


    public static void main(String[] args) {

        System.out.println(countDown(10));

    }


    public static int countDown(int i){
        if(i < 1) {
            return i;
        }
        System.out.println(i);
        return countDown(i - 1);
    }
}