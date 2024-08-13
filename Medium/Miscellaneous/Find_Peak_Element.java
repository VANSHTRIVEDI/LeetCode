package Medium.Miscellaneous;


//https://leetcode.com/problems/find-peak-element/description/
import java.util.*;

public class Find_Peak_Element {
    public static int findPeakElement(ArrayList<Integer> arr) {

        // Write your code here.

        int n = arr.size();

        if (n == 1)
            return 0;

        if (arr.get(0) > arr.get(1))
            return 0;

        if (arr.get(n - 1) > arr.get(n - 2))
            return n - 1;

        int low = 1;

        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if ((arr.get(mid) > arr.get(mid - 1)) && arr.get(mid) > arr.get(mid + 1))
                return mid;

            else if (arr.get(mid) > arr.get(mid - 1)) {

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        return -1;

    }
}
