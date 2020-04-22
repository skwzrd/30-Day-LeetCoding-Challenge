/*
Day 21

A binary matrix means that all elements are 0 or 1.
For each individual row of the matrix,
this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix,
return leftmost column index(0-indexed) with at least a 1 in it.
If such index doesn't exist, return -1.

*/

import java.util.List;

// interface BinaryMatrix {
//     public int get(int x, int y) {}
//     public List<Integer> dimensions {}
// };

class LeftmostColumn{

    public static int leftmostBinarySearch(BinaryMatrix bm, int left, int right, int row){
        boolean foundOne = false;
        while(left <= right){
            int mid = left + (right-left)/2;
            int point = bm.get(row, mid);
            if(point == 1){
                right = mid-1;
                foundOne = true;
            }
            else{
                left = mid+1;
            }
        }
        if(!foundOne){
            return -1;
        }
        return left;
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0);
        int cols = dims.get(1);
        
        int leftmostCol = -1;
        
        int left = 0;
        int right = cols-1;

        int row = 0;
        while(row < rows && leftmostCol!=0){
            int col = leftmostBinarySearch(binaryMatrix, left, right, row);
            if(leftmostCol < 0 && col>=0){
                leftmostCol = Integer.MAX_VALUE;
            }
            if(col >= 0){
                leftmostCol = Math.min(col, leftmostCol);
            }
            row++;
        }

        if(leftmostCol == Integer.MAX_VALUE){
            leftmostCol = -1;
        }
        return leftmostCol;
    }
}