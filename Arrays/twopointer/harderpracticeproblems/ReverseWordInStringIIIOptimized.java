package Arrays.twopointer.harderpracticeproblems;

public class ReverseWordInStringIIIOptimized {
    public static void main(String[] args) {

        // Testing out the functionality of using String split()
        // and StringBuilder reverse() method
        // String s = "what are we doing?";
        // String[] str = s.split(" ");
        // for(String i : str) {
        //     StringBuilder reverseAble = new StringBuilder(i);
        //     System.out.println(reverseAble.reverse());
        // }

        String s = "Mr Ding";
        System.out.println(reverseWords(s));
        
    }
        static String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                StringBuilder word = new StringBuilder(words[i]);
                result.append(word.reverse());
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
}
