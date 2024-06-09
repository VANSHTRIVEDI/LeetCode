package Medium.Miscellaneous;

/**
 * Subarray_Sums_Divisible_by_K_IMP
 */
import java.util.*;

public class Subarray_Sums_Divisible_by_K_IMP {

    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            int mod = sum % k;
            System.out.println(mod);
            // every time we will encounter reminder in negative we will change it to its
            // positive alternate by adding k into it
            // so we dont miss any egde case like nums =[-1,2,9] k=2
            // now all the reminder will be in range of 0 to k so we can use array also
            // instead of HashMap
            if (mod < 0) {
                mod = mod + k;
            }
            if (map.containsKey(mod)) {
                ans += map.get(mod);
                map.put(mod, map.get(mod) + 1);

            } else {
                map.put(mod, 1);
            }
        }
        return ans;
    }
}