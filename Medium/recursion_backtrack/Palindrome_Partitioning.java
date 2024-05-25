package Medium.recursion_backtrack;

import java.util.*;

//best method
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                tempList.add(s.substring(start, end + 1));
                backtrack(result, tempList, s, end + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}

// my method

class Palindrome_Partitioning2 {
    static List<List<String>> f;

    public List<List<String>> partition(String s) {
        f = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        recursion(s, Character.toString(s.charAt(0)), 1);
        return f;
    }

    public static void recursion(String s, String r, int i) {
        List<String> auu = new ArrayList<>();
        if (i >= s.length()) {
            String arr[] = r.split(" ");
            for (int t = 0; t < arr.length; t++) {
                if (Palindrome(arr[t]) == false) {
                    return;
                }
                auu.add(arr[t]);
            }

            f.add(auu);
            return;

        }
        recursion(s, r + Character.toString(s.charAt(i)), i + 1);

        recursion(s, r + " " + Character.toString(s.charAt(i)), i + 1);

    }

    public static boolean Palindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return true;
        } else {

            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}