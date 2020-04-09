/*
Day 9

Given two strings S and T,
return if they are equal when both are typed into empty text editors.
# means a backspace character.

Example:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
*/

import java.util.Stack;

class BackspaceStringCompare{
    public static Stack<Character> reducedStack(String str){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '#'){
                if (stack.size() != 0){
                    stack.pop();
                }
            }
            else{
                stack.push(curr);
            }  
        }
        return stack;
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s_stack = reducedStack(S);
        Stack<Character> t_stack = reducedStack(T);

        return (s_stack.equals(t_stack));
    }
    
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }

}