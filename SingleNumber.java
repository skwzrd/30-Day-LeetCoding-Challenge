/*
Day 1

Given a non-empty array of integers,
every element appears twice except for one.
Find that single one.

Example:
Input: [4,1,2,1,2]
Output: 4
*/

import java.util.ArrayList;
import java.util.List;

class SingleNumber{
    public static int singleNumber(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(l.contains(nums[i])){
                final int curr = nums[i];
                l.removeIf(x -> x == curr); //this will leave us with the single odd element
            }
            else{
                l.add(nums[i]);
            }
        }
        int ans = l.get(0);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums)==1);
        
        nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums)==4);
    }

}