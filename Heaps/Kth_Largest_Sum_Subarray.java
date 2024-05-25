package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kth_Largest_Sum_Subarray {
    public static int getKthLargest(ArrayList<Integer> arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            int sum = 0;
            for (int j = i; j < arr.size(); j++) {
                sum = sum + arr.get(j);

                if (q.size() < k) {
                    q.add(sum);
                } else {
                    if (q.peek() < sum) {
                        q.poll();
                        q.offer(sum);
                    }
                }
            }

        }

        return q.peek();
    }
}
