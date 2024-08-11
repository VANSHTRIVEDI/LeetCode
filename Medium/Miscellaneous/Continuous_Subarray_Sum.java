package Medium.Miscellaneous;

import java.util.HashMap;

//https://leetcode.com/problems/continuous-subarray-sum/?envType=daily-question&envId=2024-06-08
public class Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // This is because if we will mod a k element with a nums element the value be
            // say x
            // then if we add any multiple of k to the nums element and then mod of that
            // value with k value will be x

            // 23 2 4

            // 23%6 =3
            // (23+6)%6=3
            // (23+12)%6=3

            // so we concluded if this nums[i]%k is coming again this means in between there
            // is a multiple of k

            // nums[i]%k=x
            // nums[i]+multiple of k)%k=x
            // so if we found x again it means numtiple of k is between tha last index and
            // index of x in map
            sum = sum + nums[i];
            int h = sum % k;
            if (map.containsKey(h)) {
                int first = map.get(h);
                int last = i;
                int numberOfElement = last - first;
                if (numberOfElement >= 2) {
                    return true;
                }
            } else {
                map.put(h, i);
            }
        }
        return false;
    }
}
