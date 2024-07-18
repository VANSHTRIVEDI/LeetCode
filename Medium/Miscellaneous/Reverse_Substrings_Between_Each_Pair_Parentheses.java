package Medium.Miscellaneous;

import java.util.Stack;

//Approach-1 (Brute Force)
//T.C : O(n^2)
//S.C : O(n)
public class Reverse_Substrings_Between_Each_Pair_Parentheses {
    public String reverseParentheses(String s) {
        Stack<Integer> openBracket = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracket.push(result.length());
            } else if (ch == ')') {
                int start = openBracket.pop();
                reverse(result, start, result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    // Approach-2 (Linear Approach)
    // T.C : O(n)
    // S.C : O(n)
    public String reverseParentheses2(String s) {
        int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        int[] door = new int[n];

        // First pass: Pair up parentheses
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                openBracket.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openBracket.pop();
                door[i] = j;
                door[j] = i;
            }
        }

        // Second pass: Build the result string
        StringBuilder result = new StringBuilder();
        int direction = 1; // Left to Right
        for (int i = 0; i < n; i += direction) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = door[i];
                direction = -direction;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
