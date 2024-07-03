package Medium.Miscellaneous;

public class LongestCommonSubsequence {
    public static int lcs(String s, String t) {
        // Your code goes here
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsUtil(s, t, m, n, dp);
    }

    public static int lcsUtil(String s, String t, int m, int n, int[][] dp) {
        // Your code goes here
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            dp[m][n] = 1 + lcsUtil(s, t, m - 1, n - 1, dp);
            return dp[m][n];
        } else {
            return dp[m][n] = Math.max(lcsUtil(s, t, m - 1, n, dp), lcsUtil(s, t, m, n - 1, dp));
        }
    }
}
