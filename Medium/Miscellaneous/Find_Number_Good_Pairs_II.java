
import java.util.*;

// /https://leetcode.com/problems/find-the-number-of-good-pairs-ii/description/
//beats 92
public class Find_Number_Good_Pairs_II {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long count = 0;

        int max = 0;
        HashMap<Integer, Long> mapnum1 = new HashMap<>();
        HashMap<Integer, Long> mapnum2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            mapnum1.put(nums1[i], mapnum1.getOrDefault(nums1[i], 0L) + 1L);
            max = max > nums1[i] ? max : nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            mapnum2.put(nums2[i], mapnum2.getOrDefault(nums2[i], 0L) + 1L);
            max = max > nums2[i] ? max : nums2[i];
        }
        // System.out.println(mapnum1);
        // System.out.println(mapnum2);

        for (Map.Entry<Integer, Long> temp : mapnum2.entrySet()) {
            int number = temp.getKey() * k;
            for (int j = 1; j <= max / number; j++) {
                if (number * j > max) {
                    break;
                }
                if (mapnum1.containsKey(number * j)) {
                    Long p = mapnum1.get(number * j);
                    count = count + (p * mapnum2.get(temp.getKey()));
                }
            }
        }
        return count;

    }

    // second
    // beats 21
    public long numberOfPairs2(int[] nums1, int[] nums2, int k) {
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            map.put(i * k, map.getOrDefault(i * k, 0) + 1);
        }

        for (int i : nums1) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    int val = i / j;
                    if (map.containsKey(j))
                        count += map.get(j);
                    if (val != j && map.containsKey(val))
                        count += map.get(val);
                }
            }
        }
        return count;
    }
}
