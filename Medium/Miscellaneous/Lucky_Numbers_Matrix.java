package Medium.Miscellaneous;

import java.util.*;

//https://leetcode.com/problems/lucky-numbers-in-a-matrix/?envType=daily-question&envId=2024-07-19
class lucky {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int rMinMax = Integer.MIN_VALUE;

        for (int row = 0; row < m; row++) {
            int rMin = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                rMin = Math.min(rMin, matrix[row][col]);
            }
            rMinMax = Math.max(rMinMax, rMin);
        }

        int cMaxMin = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            int cMax = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                cMax = Math.max(cMax, matrix[row][col]);
            }
            cMaxMin = Math.min(cMaxMin, cMax);
        }

        List<Integer> result = new ArrayList<>();
        if (rMinMax == cMaxMin) {
            result.add(rMinMax); // {cMaxMin}
        }
        return result;
    }
}
