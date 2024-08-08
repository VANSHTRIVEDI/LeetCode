
public class Ceil_The_Floor {
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {

        // Wriute your code here.

        int floor = -1, ceil = -1;

        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (arr[mid] == x) {

                floor = x;

                ceil = x;

                break;

            } else if (arr[mid] > x) {

                ceil = arr[mid];

                right = mid - 1;

            } else {

                floor = arr[mid];

                left = mid + 1;

            }

        }

        int[] ans = new int[2];

        ans[0] = floor;

        ans[1] = ceil;

        return ans;

    }

}
