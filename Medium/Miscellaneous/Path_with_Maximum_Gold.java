package Medium.Miscellaneous;

//https://leetcode.com/problems/path-with-maximum-gold/?envType=daily-question&envId=2024-05-14
public class Path_with_Maximum_Gold {
    public int getMaximumGold(int[][] grid) {
        int maxSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxSum = Math.max(maxSum, findMaxGold(grid, i, j, 0));
                }
            }
        }
        return maxSum;
    }

    private int findMaxGold(int[][] grid, int i, int j, int sum) {
        sum += grid[i][j];
        int n = grid[i][j];
        grid[i][j] = -1;

        int maxLocalSum = sum;

        if (j != grid[0].length - 1 && grid[i][j + 1] != 0 && grid[i][j + 1] != -1) {
            maxLocalSum = Math.max(maxLocalSum, findMaxGold(grid, i, j + 1, sum));
        }

        if (i != grid.length - 1 && grid[i + 1][j] != 0 && grid[i + 1][j] != -1) {
            maxLocalSum = Math.max(maxLocalSum, findMaxGold(grid, i + 1, j, sum));
        }

        if (j != 0 && grid[i][j - 1] != 0 && grid[i][j - 1] != -1) {
            maxLocalSum = Math.max(maxLocalSum, findMaxGold(grid, i, j - 1, sum));
        }

        if (i != 0 && grid[i - 1][j] != 0 && grid[i - 1][j] != -1) {
            maxLocalSum = Math.max(maxLocalSum, findMaxGold(grid, i - 1, j, sum));
        }

        grid[i][j] = n;

        return maxLocalSum;
    }
}
