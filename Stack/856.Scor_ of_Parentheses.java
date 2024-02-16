package Stack;

import java.util.*;

//https://leetcode.com/problems/score-of-parentheses/
//very important 
class Parentheses {
    public int scoreOfParentheses(final String str) {
        Stack<Integer> s = new Stack<Integer>();
        int score = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                s.push(score);
                score = 0;
            } else {
                score = s.pop() + (score == 0 ? 1 : 2 * score);
            }

        }
        return score;

    }
}
