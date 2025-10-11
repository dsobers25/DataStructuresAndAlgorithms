package Arrays.twopointer.harderpracticeproblems;

public class ReverseOnlyLettersOptimized {

    public static void main(String[] args) {

        String s = "Test1ng-Leet=code-Q!";

        System.out.println(reverseOnlyLetters(s));
        
    }

    static String reverseOnlyLetters(String s) {
        char[] arr=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            if(!Character.isLetter(arr[i])){
                i++;
            }else if(!Character.isLetter(arr[j])){
                j--;
            }else{
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    
}
