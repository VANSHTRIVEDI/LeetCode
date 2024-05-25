package Heaps;

public class Convert_Min_Heap_Max_Heap {
    static void convertMinToMaxHeap(int N, int arr[]) {

        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }

    }

    public static void heapify(int arr[], int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < arr.length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, largest);

        } else {
            return;
        }
    }
}
