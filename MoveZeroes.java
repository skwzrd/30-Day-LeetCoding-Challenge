/*
Day 4

Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

import java.util.Arrays;

class MoveZeroes{
    public static int[] moveZeroes(int[] nums) {
        int non_zero = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[non_zero] = nums[i];
                non_zero++;
            }
        }
        for (int i=non_zero; i<nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] ans = {1,3,12,0,0};
        System.out.println(Arrays.equals(moveZeroes(nums), ans));
    }

}