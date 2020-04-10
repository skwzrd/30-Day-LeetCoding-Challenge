/*
Day 10

Design a stack that supports push, pop, top,
and retrieving the minimum element in constant time.
*/

import java.util.ArrayList;
import java.util.List;

class MinStack {
    int min = Integer.MAX_VALUE;
    List<Integer> list;
    
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        if(x <= min){
            // add in the previous min to the "stack"
            list.add(min);
            min = x;
        }
        list.add(x);
    }
    
    public void pop() {
        if(list.get(list.size() - 1) == min){
            // remove previous min from the "stack"
            list.remove(list.size() -1);
            min = list.get(list.size() - 1);
        }
        list.remove(list.size() -1);
    }
    
    public int top() {
        if(list.size() == 0){
            return min;// question does not specify this case
        }
        else{
            return list.get(list.size() - 1);
        }
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        // Your MinStack object will be instantiated and called as such:
        MinStack obj = new MinStack();
        obj.push(9);
        obj.push(11);
        obj.push(18);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

}