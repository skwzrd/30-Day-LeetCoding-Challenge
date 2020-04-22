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
        int temp = 1;
        for (int i = 0; i < products.length; i++) {
            products[i] = temp;
            temp = temp * nums[i];
        }
        
        temp = 1;
        for(int i = products.length - 1; i >= 0; i--){
            products[i] = temp * products[i];
            temp = temp * nums[i];
        }
        return products;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(productExceptSelf(arr)));// [720, 360, 240, 180, 144, 120]
    }

}