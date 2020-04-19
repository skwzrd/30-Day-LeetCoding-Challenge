/*
Day 19

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/


class RotatedArraySearch{
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 1,2,3 t=2
            if (nums[mid] == target) {
                return mid;
            }

            // 2,3,4,0,1
            else if (nums[mid] >= nums[left]) {
                // t=2 or t=3
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }
                // t=0 or t=1
                else{
                    left = mid + 1;
                }
            }

            // 3,4,0,1,2
            else{
                // t=1 or t=2
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                // t=3 or t=4
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));// 4
        
        nums = new int[]{4,5,6,7,0,1,2};
        target = 3;
        System.out.println(search(nums, target));// -1

        nums = new int[]{3,1};
        target = 1;
        System.out.println(search(nums, target));// 1
    }

}