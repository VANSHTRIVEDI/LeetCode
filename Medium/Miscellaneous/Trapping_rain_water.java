package Medium.Miscellaneous;

public class Trapping_rain_water {
    // https://www.naukri.com/code360/problems/trapping-rainwater_630519?leftPanelTabValue=DISCUSS
    public static long getTrappedWater(long[] arr, int n) {

        // Write your code here.

        long[] left = new long[n];

        long[] right = new long[n];

        left[0] = arr[0];

        for (int i = 1; i < n; i++) {

            left[i] = Math.max(left[i - 1], arr[i]);

        }

        right[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            right[i] = Math.max(right[i + 1], arr[i]);

        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            ans += (Math.min(left[i], right[i]) - arr[i]);

        }

        return ans;

    }
}
// newset