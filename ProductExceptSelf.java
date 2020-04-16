/*
Day 15

Given an array nums of n integers where n > 1,
return an array output such that output[i] is
equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
*/

import java.util.Arrays;

class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

        int[] products = new int[nums.length];

        int left_products = 1;
        for (int i = 0; i < nums.length; i++) {
            // make an array, products, like
            // {1, 1*nums[0], 1*nums[0]*nums[1], ..., 1*nums[0]*nums[1]*nums[2]*...*nums[nums.length-1]}
            products[i] = left_products;
            left_products = left_products * nums[i];
        }
        
        // now roll back from right to left doing a similar thing as before
        int right_products = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] = products[i] * right_products;
            right_products = right_products * nums[i];
        }

        return products;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(productExceptSelf(arr)));// [720, 360, 240, 180, 144, 120]
    }

}