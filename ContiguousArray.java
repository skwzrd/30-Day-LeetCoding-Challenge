import java.util.HashMap;
import java.util.Map;

/*
Day 13

Given a binary array, find the maximum length
of a contiguous subarray with equal number of 0 and 1.

Example:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example:
Input: [0,1,1,1,0,0]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
*/

class ContiguousArray{
    public static int findMaxLength(int[] nums) {

        int max = 0;
        int count = 0;
        Map<Integer, Integer> dict = new HashMap<>();
        dict.put(0, -1);// {counts: indicies}

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count-=1;
            }
            else{
                count+=1;
            }

            if(dict.containsKey(count)){
                // When we get a count we've encountered before,
                // that means our 0/1's are even beginning from that moment.
                // Get the number of iterations taken since that moment.
                // See if there is a new max.
                max = Math.max(max, i-dict.get(count));
            }
            else{
                dict.put(count, i);
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(findMaxLength(nums));//2
        
        nums = new int[]{0,1,0};
        System.out.println(findMaxLength(nums));//2

        nums = new int[]{0,1,0,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));//10
    }

}