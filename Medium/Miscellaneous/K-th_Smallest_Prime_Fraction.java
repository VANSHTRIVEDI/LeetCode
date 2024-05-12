package Medium.Miscellaneous;

import java.util.*;
//https://leetcode.com/problems/k-th-smallest-prime-fraction/?envType=daily-question&envId=2024-05-10

//best solution using binary seach time complexity nlogn
class Kth_Smallest_Prime_Fraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = arr[0] / (double) arr[n - 1];
        double high = 1;
        while (low <= high) {
            double mid = (low + high) / 2;
            int count[] = f(arr, mid); // {count, num, deno}
            if (k < count[0]) {
                high = mid;
            } else if (k > count[0]) {
                low = mid;
            } else {
                return new int[] { count[1], count[2] };
            }
        }
        return null;
    }

    static int[] f(int arr[], double target) {
        int count = 0;
        int i = 0;
        int n = arr.length;
        int num = arr[0];
        int deno = arr[n - 1];
        for (int j = 1; j < n; j++) {

            while (arr[i] <= arr[j] * target) {
                i++;
            }

            count += i;
            if (i > 0 && arr[i - 1] * deno > num * arr[j]) {
                num = arr[i - 1];
                deno = arr[j];
            }
        }
        return new int[] { count, num, deno };
    }
}

// same solution using priority queue
// The time complexity of this code is O((n^n)*logn)

class Kth_Smallest_Prime_Fraction2 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<info> q = new PriorityQueue<>((a, b) -> Double.compare(a.value, b.value));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                double fraction = (double) arr[i] / arr[j];
                q.add(new info(fraction, i, j));
            }
        }
        while (k > 1) {
            q.poll();
            k--;
        }

        info result = q.poll();
        return new int[] { arr[result.i], arr[result.j] };
    }
}

class info {
    double value;
    int i;
    int j;

    info(double v, int i, int j) {
        this.value = v;
        this.i = i;
        this.j = j;
    }
}
