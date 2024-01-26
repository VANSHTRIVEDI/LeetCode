package Easy.recursion;

//https://leetcode.com/problems/fibonacci-number/description/

class Solution {
    public int fib(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int sum = fib(n - 1) + fib(n - 2);
        return sum;

    }
}