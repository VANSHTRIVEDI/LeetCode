package Heaps;

public class Merge_two_binary_Max_heaps {
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int arr[] = new int[n + m];
        int bb = 0;
        for (int i = 0; i < a.length; i++) {
            arr[bb] = a[i];
            bb++;
        }
        for (int i = 0; i < b.length; i++) {
            arr[bb] = b[i];
            bb++;
        }
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(i, arr, arr.length);
        }
        return arr;
    }

    public static void heapify(int i, int arr[], int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest, arr);
            heapify(largest, arr, n);
        } else {
            return;
        }
    }

    public static void swap(int i, int largest, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
