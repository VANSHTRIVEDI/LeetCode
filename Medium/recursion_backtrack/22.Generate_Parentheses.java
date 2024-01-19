package Medium.recursion_backtrack;

//https://leetcode.com/problems/generate-parentheses/description/

import java.util.*;;

class Solution {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> arr = new ArrayList<String>();
        recursion(n, 0, 0, "", arr);
        return (arr);
    }

    public static void recursion(int n, int opencount, int closecount, String kk, ArrayList<String> arr) {
        if (opencount == n && closecount == n) {
            // System.out.println(kk);

            arr.add(kk);

            return;
        }
        if (opencount < n) {
            recursion(n, opencount + 1, closecount, kk + "(", arr);
        }
        if (opencount > closecount && closecount < n) {
            recursion(n, opencount, closecount + 1, kk + ")", arr);
        }
    }
}