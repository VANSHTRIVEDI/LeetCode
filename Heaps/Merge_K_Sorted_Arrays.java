package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Arrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        // add comparetor
        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<info> queue = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < kArrays.size(); i++) {
            queue.add(new info(kArrays.get(i).get(0), i, 0));
        }
        while (queue.size() > 0) {
            info temp = queue.poll();
            int value = temp.data;
            int row = temp.row;
            int column = temp.column;

            arr.add(value);
            if (column + 1 <= kArrays.get(row).size() - 1) {
                queue.add(new info(kArrays.get(row).get(column + 1), row, column + 1));
            }

        }
        return arr;
    }
}

class info {
    int data;
    int row;
    int column;

    info(int v, int a, int b) {
        this.data = v;
        this.row = a;
        this.column = b;
    }
}
