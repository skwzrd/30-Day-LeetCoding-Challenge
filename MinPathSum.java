/*
Day 18

Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes
the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
    [1,3,1],
    [1,5,1],
    [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
    
import java.lang.Math;

class MinPathSum{

    public static int minPathSum(int[][] grid) {
        // i - rows
        // j - cols
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // sum up the 0th column, sum up the 0th row elements
                if(i==0 && j!=0){
                    grid[i][j]+=grid[i][j-1];
                }
                if(i!=0 && j==0){
                    grid[i][j]+=grid[i-1][j];
                }
                // compare if a right step or a down step results in a lower sum
                if(i!=0 && j!=0){
                    grid[i][j]+=Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};

        System.out.println(minPathSum(arr));// 7

        arr = new int[][] {{1, 3, 5},
                            {1, 9, 9},
                            {1, 1, 1}};
        System.out.println(minPathSum(arr));// 5
    }
}

