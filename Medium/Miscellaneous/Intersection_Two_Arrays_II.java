package Medium.Miscellaneous;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Intersection_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                arr.add(nums2[i]);
                int value = map.get(nums2[i]) - 1;

                if (value <= 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], value);

                }

            }
        }

        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;

    }

    // if array is sorted this is the best approach
    class Intersection_Two_Arrays_II2 {
        public int[] intersect(int[] nums1, int[] nums2) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            int i = 0, j = 0, k = 0;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            while (i < l1 && j < l2) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    nums1[k++] = nums1[i++];
                    j++;
                }
            }
            return Arrays.copyOfRange(nums1, 0, k);
        }
    }
}
