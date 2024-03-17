package Medium.recursion_backtrack;

//https://leetcode.com/problems/permutations/description/
import java.util.*;

class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        int array[] = nums;
        int n = array.length;
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> finalarr = new ArrayList<>();

        solve(array, 0, n, arr, finalarr);
        return finalarr;
    }

    public static void solve(int s[], int index, int nn, List<Integer> arr, List<List<Integer>> finalarr) {
        if (index >= nn) {

            finalarr.add(new ArrayList<>(arr));

            return;
        }

        for (int i = index; i < nn; i++) {
            // System.out.println(s);
            int temp = s[i];
            s[i] = s[index];
            s[index] = temp;

            arr.add(s[index]);
            solve(s, index + 1, nn, arr, finalarr);
            arr.remove(arr.size() - 1);
            int tempp = s[index];
            s[index] = s[i];
            s[i] = tempp;
        }
    }

}

// /https://www.codingninjas.com/studio/problems/permutations-of-a-string_985254

class Permutation2 {
    public static ArrayList<String> generatePermutations(String S) {

        ArrayList<String> arr = new ArrayList<>();

        System.out.println();

        solve(arr, S, "", 0);

        Collections.sort(arr);
        return arr;

    }

    public static void solve(ArrayList<String> arr, String S, String cur, int count) {
        if (count >= S.length()) {
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (cur.contains(String.valueOf(S.charAt(i)))) {
                continue;
            }
            String temp = cur + String.valueOf(S.charAt(i));
            if (temp.length() == S.length()) {
                arr.add(temp);

            }

            solve(arr, S, cur + String.valueOf(S.charAt(i)), count + 1);

        }

    }
}
