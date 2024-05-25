package Heaps;

import java.util.PriorityQueue;

public class Minimum_Cost_ropes {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(arr[i]);

        }
        long ans = 0;
        while (q.size() != 1) {
            long p = q.poll();

            long o = q.poll();

            ans = ans + p + o;

            q.add(p + o);

        }
        return ans;
    }
}
