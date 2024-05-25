package Heaps;

import java.util.PriorityQueue;

public class Median_in_stream_H {
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    public static int[] findMedian(int[] arr, int n) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int ans[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            addNum(arr[i]);
            ans[i] = findMedian();
        }
        return ans;

    }

    public static void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);

        } else {
            minHeap.add(num);
        }
        if ((int) maxHeap.size() - (int) minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if ((int) minHeap.size() > (int) maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public static int findMedian() {

        if ((int) maxHeap.size() == (int) minHeap.size()) {
            return ((int) maxHeap.peek() + (int) minHeap.peek()) / 2;
        } else {
            return (int) maxHeap.peek();
        }
    }
}
