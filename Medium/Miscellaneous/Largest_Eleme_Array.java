package Medium.Miscellaneous;

//https://www.naukri.com/code360/problems/largest-element-in-the-array-largest-element-in-the-array_5026279?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
public class Largest_Eleme_Array {
    static int largestElement(int[] arr, int n) {

        // Write your code here.

        int max = arr[0];

        for (int i = 1; i < n; i++)

            if (arr[i] > max)

                max = arr[i];

        return max;

    }
}
