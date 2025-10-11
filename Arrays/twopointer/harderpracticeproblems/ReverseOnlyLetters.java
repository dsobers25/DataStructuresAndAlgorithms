package Arrays.twopointer.harderpracticeproblems;

/*
 * 
 * 
 * Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.


Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
 * 
 * 
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {

        // 2 pointer approach
        // pointer are at beginning and end of string
        // for loop will iterate through the string
        // each iteration both pointers are tracked
        // beginning pointer is tracked in loop
        // end pointer is tracked by a variable
        // if beginning pointer is valid, end is checked
        // if end pointer is valid the character at the end
        // is appended to a string builder to create a new string
        // and the end variable will be decremented
        // if beginning pointer is invalid the character at beginning pointers index
        // is appended to the string builder
        // if beginning pointer is valid, but end is not valid the end variable is
        // decremented in a while loop until a valid character is identified
        // then it will be appended to the string builder
        // and the for loop will continue

        String s = "Test1ng-Leet=code-Q!";
        // Input: s = "Test1ng-Leet=code-Q!"
        // Output: "Qedo1ct-eeLg=ntse-T!"
        System.out.println(reverseOnlyLetters(s));
        
        
    }

    // ASCII nums between 65-90
    // & 97-122

    static String reverseOnlyLetters(String s) {
        
        if(s.length()<=1) {
            return s;
        }

        int end = s.length() - 1;
        StringBuilder word = new StringBuilder();

        for(int i = 0; i<s.length(); i++) {
            System.out.println("iteration: " + i);
            boolean isBeginnerPointerValid = false, isEndPointerValid = false;
            byte beginnerChar = (byte) s.charAt(i);
            end = end < 0 ? 0: end;
            byte endChar = (byte) s.charAt(end);
            // if i is not a letter add to StringBuilder
            // System.out.println("char = " + s.charAt(i));

            // checking beginner pointer
            if(beginnerChar >=65 && beginnerChar <=90 || beginnerChar >=97 && beginnerChar <=122) {
                isBeginnerPointerValid = true;
                System.out.println("Beginning Character "  + s.charAt(i) + " at index " + i + " is valid");
            } else {
                System.out.println("**Beginning Character "  + s.charAt(i) + " at index " + i + " is invalid**");
                isBeginnerPointerValid = false;
            }

            // check end pointer
            if(endChar >=65 && endChar <=90 || endChar >=97 && endChar <=122) {
                isEndPointerValid = true;
                System.out.println("Ending Character "  + s.charAt(end) + " at index " + end + " is valid");
            } else {
                    System.out.println("**Ending Character "  + s.charAt(end) + " at index " + end + " is invalid**");
                    isEndPointerValid = false;
                }

                // case 1. beginning character is invalid, no need to check end
                //          we set invalid character and advance loop
                if(!isBeginnerPointerValid) {
                    word.append(s.charAt(i));
                    System.out.println("Case 1: Current word is now: " + word.toString());
                    continue;
                }

            // case 2. Both beginning & ending characters are valid
            if(isBeginnerPointerValid && isEndPointerValid) {
                // set valid character from ending pointer
                // in the string builder
                word.append(s.charAt(end));
                System.out.println("Case 2: Current word is now: " + word.toString());
                end--;
            }

            
            // case 3. beginning character is valid but end is invalid
            //          we decrement end pointer 
            //          checking each iteration until valid character is found
            System.out.println("isBeginnerPointerValid = " + isBeginnerPointerValid);
            System.out.println("isEndPointerValid = " + isEndPointerValid);
            while(isBeginnerPointerValid && isEndPointerValid == false) {
                endChar = (byte) s.charAt(end);
                if(endChar >=65 && endChar <=90 || endChar >=97 && endChar <=122) {
                    isEndPointerValid = true;
                    System.out.println("Ending Character "  + s.charAt(end) + " at index " + end + " is valid");
                    // add valid char from end to stringbuilder
                    word.append(s.charAt(end));
                    System.out.println("Case 3: Current word is now: " + word.toString());
                    end--;
                } else {
                    System.out.println("**Ending Character "  + s.charAt(end) + " at index " + end + " is invalid**");
                    end--;
                }
        }
    }

        return word.toString();
    }

}
