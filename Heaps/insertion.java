package Heaps;

import java.util.*;

public class insertion {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(Integer.MAX_VALUE);
        insert(50, arr);
        insert(55, arr);
        insert(53, arr);
        insert(52, arr);
        insert(54, arr);
        System.out.println();
        delete(arr);
        // for (int i = 1; i < arr.size(); i++) {
        // System.err.print(arr.get(i) + " ");
        // }
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
        for (int i = 0; i < arr.size(); i++) {
            System.err.print(arr.get(i) + " ");
        }

        // arr[0]=arr.get(size);
    }
}
