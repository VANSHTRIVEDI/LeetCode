package Medium.Miscellaneous;

//https://leetcode.com/problems/relative-sort-array/?envType=daily-question&envId=2024-06-11
public class Relative_Sort_Array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int arr[] = new int[1001];
        int maxElement = 0;
        for (int i = 0; i < arr1.length; i++) {
            maxElement = maxElement < arr1[i] ? arr1[i] : maxElement;
            arr[arr1[i]]++;
        }

        int newarr[] = new int[arr1.length];
        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            int element = arr2[i];
            int value = arr[element];
            for (int t = 1; t <= value; t++) {
                newarr[index] = element;
                index++;
            }
            arr[element] = 0;
        }

        if (index < newarr.length) {

            for (int i = 0; i <= maxElement; i++) {
                if (arr[i] == 0) {
                    continue;
                } else {
                    int element = i;
                    int value = arr[i];
                    for (int t = 1; t <= value; t++) {
                        newarr[index] = element;
                        index++;
                    }

                }
            }
        }

        return newarr;
    }
}
