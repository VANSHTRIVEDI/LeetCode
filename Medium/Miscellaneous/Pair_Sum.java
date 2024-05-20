package Medium.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair_Sum {
    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        Arrays.sort(arr);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
        return result;
    }
}
