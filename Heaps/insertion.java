package Heaps;

import java.util.*;

//insertion and deletion in heap is time complexity of o(logn)
public class insertion {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(Integer.MAX_VALUE);
        insert(50, arr);
        insert(55, arr);
        insert(53, arr);
        insert(52, arr);
        insert(54, arr);
        for (int i = 1; i < arr.size(); i++) {
            System.err.print(arr.get(i) + " ");
        }
        System.out.println();
        delete(arr);
        for (int i = 1; i < arr.size(); i++) {
            System.err.print(arr.get(i) + " ");
        }

    }

    public static void insert(int n, ArrayList<Integer> arr) {
        arr.add(n);
        int index = arr.size() - 1;

        while (index > 0) {
            if (arr.get(index / 2) < arr.get(index)) {
                int temp = arr.get(index / 2);
                arr.set(index / 2, arr.get(index));
                arr.set(index, temp);
                index = index / 2;
            } else {
                return;
            }

        }
    }

    public static void delete(ArrayList<Integer> arr) {
        int size = arr.size() - 1;
        arr.set(1, arr.get(size));
        arr.remove(size);

        // for (int i = 0; i < arr.size(); i++) {
        // System.err.print(arr.get(i) + " ");
        // }
        int index = 1;
        while (index <= arr.size()) {
            int left = 2 * index;
            int right = 2 * index + 1;

            if (left < arr.size() && arr.get(left) > arr.get(index)) {
                int temp = arr.get(left);
                arr.set(left, arr.get(index));
                arr.set(index, temp);
            } else if (right < arr.size() && arr.get(right) > arr.get(index)) {
                int temp = arr.get(right);
                arr.set(left, arr.get(index));
                arr.set(index, temp);
            } else {
                return;
            }
        }

    }
}
