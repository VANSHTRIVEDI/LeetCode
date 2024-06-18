package Medium.Miscellaneous;

public class Inversion_control {
    public static long getInversions(long arr[], int n) {

        long count = 0;
        int i = 0;
        while (i < n - 1) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
            i++;
        }
        return count;
    }
}
