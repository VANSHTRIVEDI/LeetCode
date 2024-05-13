package Medium.Miscellaneous;

//https://leetcode.com/problems/score-after-flipping-matrix/?envType=daily-question&envId=2024-05-13
class Score {

    public int matrixScore(int[][] grid) {
        int m = grid[0].length;
        int ans = grid.length * (1 << m - 1 - 0);

        for (int j = 1; j < grid[0].length; j++) {
            int zero = 0;
            for (int i = 0; i < grid.length; i++) {
                int d = grid[i][j];

                if (grid[i][0] == 0) {
                    d = grid[i][j] ^ 1;
                }
                if (d == 0) {
                    zero++;
                }

            }
            if (zero > grid.length - zero) {
                ans = ans + ((zero) * (1 << m - 1 - j));
            } else {
                ans = ans + ((grid.length - zero) * (1 << m - 1 - j));
            }
        }
        return ans;

    }
}