/*
Day 23
Given a range [m, n] where 0 <= m <= n <= 2147483647,
return the bitwise AND of all numbers in this range, inclusive.
*/

class BitwiseAND{

    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for (; m != n; ++i) {
            m >>= 1;
            n >>= 1;
        }
        return n << i;
    }
    
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        System.out.println(rangeBitwiseAnd(m, n));//4
        
        m = 10;
        n = 13;
        System.out.println(rangeBitwiseAnd(m, n));//8

    }

}