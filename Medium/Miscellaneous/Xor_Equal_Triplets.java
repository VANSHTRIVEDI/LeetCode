public class Xor_Equal_Triplets {
    // https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/?envType=daily-question&envId=2024-05-30
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefix[i] == prefix[k + 1]) {
                    count += (k - i);
                }
            }
        }

        return count;
    }
}
