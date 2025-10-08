package Arrays.twopointer.harderpracticeproblems;

public class ReverseWordInStringIII {

    /*
     * 
     * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     * 
     * Example 1:
     * 
     * Input: s = "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Example 2:
     * 
     * Input: s = "Mr Ding"
     * Output: "rM gniD"
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 5 * 104
     * 
     * s contains printable ASCII characters.
     * s does not contain any leading or trailing spaces.
     * There is at least one word in s.
     * All the words in s are separated by a single space.
     * 
     */
    
    public static void main(String[] args) {
        String s = "Mr Ding";
        System.out.println(revereWordsInPhrase(s));
    }

    static String revereWordsInPhrase(String s) {

        if(s.length() <= 1) {
            return s;
        }

        char[] arr = s.toCharArray();

        // create new string while iterating over elements
        // stop when whitespace is reached
        // then reverse string add white space
        // then start over with creating a new string
        // until end is reached
        StringBuilder temp = new StringBuilder();
        StringBuilder real = new StringBuilder();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ' ') { // when whitespace is found
                // reverse temp if not empty
                if(temp.toString().length() > 0) {
                    System.out.println(temp.toString()+ "***** if temp");
                    char[] tempStr = temp.toString().toCharArray();
                    int start = 0;
                    int end = tempStr.length - 1;
                    while(end>=start) {
                        char t = tempStr[end];
                        real.append(t);
                        System.out.println(real.toString()+ "***** if real");
                        end--;
                    }
                }
                // add whitespace to real
                real.append(arr[i]);
                // and reset temp
                temp.setLength(0);
            } else {
                temp.append(arr[i]);
                // for the last word reversal
                if(i == arr.length - 1) {
                    // reverse temp if not empty
                if(temp.toString().length() > 0) {
                    char[] tempStr = temp.toString().toCharArray();
                    int start = 0;
                    int end = tempStr.length - 1;
                    while(end>=start) {
                        char t = tempStr[end];
                        real.append(t);
                        end--;
                    }
                }
                }
            }
        }

        return real.toString();
    }


}
