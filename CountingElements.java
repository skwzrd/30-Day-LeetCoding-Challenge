/*
Day 7

Given an integer array arr, count element x such that x + 1 is also in arr.
If there're duplicates in arr, count them seperately.


Examples:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
]
*/

import java.util.Set;
import java.util.HashSet;

class CountingElements{
    public static int counts(int[] arr) {
        if(arr.length == 0 || arr == null)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]+1))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,5,0};
        System.out.println(counts(arr));

        arr = new int[] {1,1,2,2};
        System.out.println(counts(arr));
    }
}

