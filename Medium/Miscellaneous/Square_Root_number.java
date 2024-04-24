package Medium.Miscellaneous;

//https://www.naukri.com/code360/problems/square-root-integral_893351?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
public class Square_Root_number {
    public static int sqrtN(long N) {
        long start = 1;

        long end = N;

        while (start <= end) {

            long mid = (start + end) / 2;

            long val = mid * mid;

            if (val == N)
                return (int) mid;

            else if (val < N)
                start = mid + 1;

            else
                end = mid - 1;

        }

        return (int) end;
    }
}
