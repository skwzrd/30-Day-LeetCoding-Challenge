/*
Day 2

Write an algorithm to determine if a number is "happy".

Example:
Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/

import java.util.HashSet;
import java.util.Set;

class HappyNumber{
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int num) {
        int digit = 0;
        int sum = 0;
        while(num!=0){
            digit = num % 10; //gets the rightmost number
            sum += digit*digit;
            num /= 10;
        }
        if(sum==1){
            return true;
        }
        else if(set.contains(sum)){ //we hit the same sum
            return false;
        }
        else{
            set.add(sum);
            return isHappy(sum); //recursively call this until we hit the same sum, or sum==1
        }
    }
    
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19)==true);
        
        hn = new HappyNumber();
        System.out.println(hn.isHappy(4)==false);
        
        hn = new HappyNumber();
        System.out.println(hn.isHappy(100)==true);
    }

}