/*
Day 14

You are given a string s containing
lowercase English letters,
and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.

Return the final string after all operations.

Example:
Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
*/

import java.util.Deque;
import java.util.LinkedList;

class PerformStringShifts {
    public static String stringShift(String s, int[][] shift) {
        int left_shifts = 0;
        int right_shifts = 0;
        for (int i = 0; i < shift.length; i++) {
            if(shift[i][0] == 0){
                left_shifts += shift[i][1];
            }
            else{
                right_shifts += shift[i][1];
            }
        }
        
        boolean right = false;
        if(right_shifts > left_shifts){
            right = true;
        }
        int shifts = Math.abs(right_shifts - left_shifts);

        if(shifts == 0){
            return s;
        }
        else{
            Deque<Character> dq = new LinkedList<>();
            for (char c : s.toCharArray()) {
                dq.add(c);
            }
    
            for (int i = 0; i < shifts; i++) {
                if(right){
                    dq.offerFirst(dq.pollLast());
                }
                else{
                    dq.offerLast(dq.pollFirst());
                }
            }
    
            String answer = "";
            for (Character character : dq) {
                answer+=character;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0,1}, {1,2}};
        System.out.println(stringShift(s, shifts)); // cab
        
        s = "abcdefg";
        shifts = new int[][] {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(stringShift(s, shifts)); // efgabcd
    }

}