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

class Parentheses2 {
    public int scoreOfParentheses(String s) {
        Stack<Character> ss = new Stack<Character>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ss.push(ch);

            } else {
                int count = 0;
                while (ss.peek() != '(') {
                    int t = (char) (ss.pop() - '0');
                    count = count + t;
                }
                ss.pop();
                if (count == 0) {
                    ss.push('1');
                } else {
                    int k = 2 * count;
                    ss.push((char) (k + '0'));
                }
            }
        }
        while (ss.isEmpty() == false) {
            int t = (char) (ss.pop() - '0');
            ;
            score = score + t;
        }
        return score;
    }
}
