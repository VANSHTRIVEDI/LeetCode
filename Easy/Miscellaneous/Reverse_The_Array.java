package Easy.Miscellaneous;

import java.util.*;

//https://www.codingninjas.com/studio/problems/reverse-the-array_1262298?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
class Reverse {
    public static void reverseArray(ArrayList<Integer> arr, int m) {
        int start = m + 1; // The starting index of the subarray to be reversed
        int end = arr.size() - 1; // The ending index of the subarray to be reversed

        // Reverse the subarray
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            // Move towards the center
            start++;
            end--;
        }
    }
}
