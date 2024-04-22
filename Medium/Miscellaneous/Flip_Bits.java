package Medium.Miscellaneous;

//https://www.naukri.com/code360/problems/flip-bits_1063248?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
public class Flip_Bits {
    public static int flipBits(int[] arr, int n) {
        int count_1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count_1++;
                arr[i] = -1;
            } else
                arr[i] = 1;
        }
        int max_sum = findmaxsum(arr);
        max_sum = Math.max(0, max_sum);

        return max_sum + count_1;

    }

    static int findmaxsum(int arr[]) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
