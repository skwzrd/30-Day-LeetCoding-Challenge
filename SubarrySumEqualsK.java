/*
Day 21

Given an array of integers and an integer k,
you need to find the total number of continuous
subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
*/

import java.util.HashMap;
import java.util.Map;

class SubarrySumEqualsK{

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        
        Map<Integer, Integer> sum_freqs = new HashMap<>();
        sum_freqs.put(0, 1);
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            count += sum_freqs.getOrDefault(sum - k, 0);
            sum_freqs.put(sum, sum_freqs.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));// 2
        
    }

}