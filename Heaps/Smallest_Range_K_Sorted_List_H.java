package Heaps;

import java.util.PriorityQueue;

public class Smallest_Range_K_Sorted_List_H {
    public static int kSorted(int[][] a, int k, int n) {
        PriorityQueue<Info> q = new PriorityQueue<>((x, y) -> x.value - y.value);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Initialize the priority queue and set the initial min and max
        for (int i = 0; i < k; i++) {
            q.add(new Info(a[i][0], i, 0));
            min = Math.min(a[i][0], min);
            max = Math.max(a[i][0], max);
        }

        int smallestRange = max - min;
        int[] ans = new int[2];
        ans[0] = min;
        ans[1] = max;

        while (!q.isEmpty()) {
            Info temp = q.poll();
            int row = temp.row;
            int column = temp.column;

            min = temp.value;

            // Update the range if a smaller range is found
            if (max - min < smallestRange) {
                smallestRange = max - min;
                ans[0] = min;
                ans[1] = max;
            }

            // If the current list is exhausted, break the loop
            if (column + 1 >= n) {
                break;
            }

            // Add the next element from the same list to the priority queue
            int nextValue = a[row][column + 1];
            q.add(new Info(nextValue, row, column + 1));
            max = Math.max(nextValue, max);
        }

        return smallestRange + 1;
    }
}

class Info {
    int value, row, column;

    Info(int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }
}
