/*
Day 3

Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum
and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class MaximumSubarray{
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;
        int negs = 0; //needed in the case where all elements are negative
        int min_negs = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum < 0){
                sum = 0; //negative numbers only make the potential max lower
                negs++;
                min_negs = Math.max(nums[i], min_negs);
            }
            max = Math.max(sum, max);
        }
        if(negs == nums.length){
            return min_negs;
        }
        else{
            return max;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums)==6);
        
        nums = new int[]{-1,-1,-2,-3};
        System.out.println(maxSubArray(nums)==-1);
    }

}