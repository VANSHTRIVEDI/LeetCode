package Hard;

import java.util.*;

//https://leetcode.com/problems/maximal-rectangle/description/


class Solution {
    public int maximalRectangle(char[][] arr) {
        int finallvalue = 0;
        int n = arr.length;
        int m = arr[0].length;
        int auu[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int pp = Character.getNumericValue(arr[i][j]);
                if (pp == 1) {
                    auu[j] = auu[j] + pp;
                } else {
                    auu[j] = pp;
                }

            }

            int largest = solve(auu, m);
            finallvalue = Math.max(finallvalue, largest);
        }
        return (finallvalue);

    }

    public static int solve(int auu[], int m) {

        int prev[] = new int[m];
        smallestprevious(prev, auu, m);

        int next[] = new int[m];

        smallnext(next, auu, m);

        int maxarea = 0;
        int b = 0;
        for (int i = 0; i < m; i++) {
            int t = prev[i];
            if (next[i] == -1) {
                b = m - t - 1;
            } else {
                b = next[i] - t - 1;
            }

            int area = auu[i] * b;
            maxarea = Math.max(area, maxarea);
        }
        return maxarea;

    }

    public static void smallestprevious(int[] prev, int auu[], int m) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < m; i++) {
            while (stack.peek() != -1 && auu[stack.peek()] >= auu[i]) {
                stack.pop();

            }

            prev[i] = stack.peek();

            stack.push(i);

        }

    }

    public static void smallnext(int[] next, int auu[], int m) {
        Stack<Integer> stackk = new Stack<Integer>();
        stackk.push(-1);
        for (int i = m - 1; i >= 0; i--) {
            while (stackk.peek() != -1 && auu[stackk.peek()] >= auu[i]) {
                stackk.pop();

            }

            next[i] = stackk.peek();

            stackk.push(i);

        }

    }

}
