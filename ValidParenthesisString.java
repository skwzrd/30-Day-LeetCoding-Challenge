/*
Day 16

Given a string containing only three types of characters: '(', ')' and '*',
write a function to check whether this string is valid.

We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.

Any right parenthesis ')' must have a corresponding left parenthesis '('.

Left parenthesis '(' must go before the corresponding right parenthesis ')'.

'*' could be treated as a single right parenthesis ')'
or a single left parenthesis '(' or an empty string.

An empty string is also valid.

*/

class ValidParenthesisString{

    public static boolean checkValidString(String s) {
        int count = 0;
        // As long as there are always more '(' and '*' counts than ')' counts,
        // we can balance the syntax. For the cases where we have something like
        // s = "(((((*", i.e. more '(' and '*' counts than ')' counts,
        // the next for loop will catch that.
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ')') count++;
            else count --;
            if(count < 0) return false;
        }

        count = 0;
        for (int i = s.length() - 1; i>=0; i--) {
            if(s.charAt(i) != '(') count++;
            else count --;
            if(count < 0) return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        String s = "(*)";
        System.out.println(checkValidString(s));
        
        s = "((*)";
        System.out.println(checkValidString(s));

        s = "()()**)";
        System.out.println(checkValidString(s));

        s = "((()*";
        System.out.println(checkValidString(s));
    }

}