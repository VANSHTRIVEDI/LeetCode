package Medium.Miscellaneous;

public class Print_Like_A_Wave {
    public static int[] wavePrint(int arr[][], int nRows, int mCols) {

        int[] ans = new int[nRows * mCols];

        int k = 0;

        for (int j = 0; j < mCols; j++) {

            if (j % 2 == 0)
                for (int i = 0; i < nRows; i++)
                    ans[k++] = arr[i][j];

            else
                for (int i = nRows - 1; i >= 0; i--)
                    ans[k++] = arr[i][j];

        }

        return ans;

    }
}
