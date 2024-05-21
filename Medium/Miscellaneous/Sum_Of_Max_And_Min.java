package Medium.Miscellaneous;

//https://www.naukri.com/code360/problems/sum-of-max-and-min_1081476?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
public class Sum_Of_Max_And_Min {
    public static int sumOfMaxMin(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max + min;
    }
}
