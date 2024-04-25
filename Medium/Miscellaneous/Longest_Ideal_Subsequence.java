package Medium.Miscellaneous;

//https://leetcode.com/problems/longest-ideal-subsequence/?envType=daily-question&envId=2024-04-25
public class Longest_Ideal_Subsequence {
    public int longestIdealString(String s, int k) {
        int[] alpha = new int[26];
        int res = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            int min = Math.max(0, idx - k);
            int max = Math.min(25, idx + k);
            int maxVal = 0;
            for (int i = min; i <= max; i++) {
                maxVal = Math.max(maxVal, alpha[i]);
            }
            alpha[idx] = maxVal + 1;
            res = Math.max(res, maxVal + 1);
        }
        return res;
    }
}
