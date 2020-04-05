/*
Day 5

Say you have an array for which the ith element is
the price of a given stock on day i.

Design an algorithm to find the maximum profit.

You may not engage in multiple transactions on the same day.

Examples:
Input: [7,1,5,3,6,4]
Output: 7

Input: [1,2,3,4,5]
Output: 4

Input: [7,6,4,3,1]
Output: 0
*/

class BuySell{
    public static int maxProfits(int[] prices) {
        if(prices.length==0) return 0;

        int profit = 0;
        int prev_buy = -1*prices[0];
        for (int i=0; i<prices.length; i++) {
            //are we better off using our previous buy, or buying now, to increase our profits?
            int buy = Math.max(prev_buy, profit - prices[i]);
            //are we better off keeping what we have, or selling?
            profit = Math.max(profit, prev_buy + prices[i]);
            prev_buy = buy;
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfits(nums)==7);
        
        nums = new int[]{8,7,6,5,4};
        System.out.println(maxProfits(nums)==0);

        nums = new int[]{1,2,3,4,5};
        System.out.println(maxProfits(nums)==4);

        nums = new int[] {6,1,3,2,4,7};
        System.out.println(maxProfits(nums)==7);

    }

}