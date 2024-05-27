package Heaps;

import java.util.*;

public class Maximum_Sum_Combinations_H {
    public int[] solve(int[] A, int[] B, int C) {
        // Sort arrays in descending order
        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        HashSet<String> visited = new HashSet<>();

        int n = A.length;

        // Initial push (largest elements from both arrays)
        maxHeap.add(new int[] { A[n - 1] + B[n - 1], n - 1, n - 1 });
        visited.add((n - 1) + "," + (n - 1));

        int[] result = new int[C];

        for (int i = 0; i < C; i++) {
            int[] top = maxHeap.poll();
            result[i] = top[0];
            int indexA = top[1];
            int indexB = top[2];

            // Next potential sums
            if (indexA - 1 >= 0 && !visited.contains((indexA - 1) + "," + indexB)) {
                maxHeap.add(new int[] { A[indexA - 1] + B[indexB], indexA - 1, indexB });
                visited.add((indexA - 1) + "," + indexB);
            }
            if (indexB - 1 >= 0 && !visited.contains(indexA + "," + (indexB - 1))) {
                maxHeap.add(new int[] { A[indexA] + B[indexB - 1], indexA, indexB - 1 });
                visited.add(indexA + "," + (indexB - 1));
            }
        }

        return result;
    }
}
