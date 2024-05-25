package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_smallest_element {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }

        for (int i = k; i <= r; i++) {
            if (q.peek() > arr[i]) {
                q.poll();
                q.add(arr[i]);
            }

        }
        return q.peek();
    }
}
