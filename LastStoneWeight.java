/*
Day 12

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.
Suppose the stones have weights x and y with x <= y.

The result of this smash is:

If x == y, both stones are totally destroyed;

If x != y, the stone of weight x is totally destroyed,
and the stone of weight y has new weight y-x;

At the end, there is at most 1 stone left.
Return the weight of this stone (or 0 if there are no stones left.)

Example:
Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
*/

import java.util.PriorityQueue;
import java.util.Collections;

class LastStoneWeight {

    public static int getLastWeight(int[] stones) {
        if(stones.length == 0 || stones == null){
            return 0;
        }

        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            qu.add(stone);
        }
        while(qu.size() >= 2){
            int largest = qu.poll();
            int pen_largest = qu.poll();
            if(largest != pen_largest){
                qu.add(largest - pen_largest);
            }
        }
        if(qu.size() == 0){
            return 0;
        }
        else{
            return qu.peek();
        }
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(getLastWeight(stones));//1
        stones = new int[] {2,2};
        System.out.println(getLastWeight(stones));//0
    }

}