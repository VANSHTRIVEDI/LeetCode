package Medium.Stack;

import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int left = k;
        Stack<Integer> added = new Stack<Integer>();
        Stack<Integer> removed = new Stack<Integer>();
        added.push(Character.getNumericValue(num.charAt(0)));
        for (int i = 1; i < num.length(); i++) {
            char ch = num.charAt(i);
            int n = Character.getNumericValue(ch);
            if (added.peek() <= n) {
                added.push(n);
            } else {
                while (added.size() != 0 && added.peek() > n && removed.size() != k) {
                    left--;
                    removed.push(added.pop());
                }
                added.push(n);

            }

        }
        while (added.size() != 0 && left != 0) {
            added.pop();
            left--;
        }
        if (added.size() == 0) {
            return "0";
        } else {
            String ff = "";
            while (added.empty() == false) {
                String cm = added.pop().toString();
                ff = cm + ff;

            }

            if (ff == "") {

                return "0";
            } else {
                int othindex = 0;
                int i = 0;
                while (ff.length() != i) {
                    othindex = i;
                    if (ff.charAt(i) != '0') {
                        break;
                    }
                    i++;

                }
                if (othindex >= ff.length()) {
                    return "0";
                } else {
                    ff = ff.substring(othindex, ff.length());
                }

            }
            return (ff);

        }

    }

}