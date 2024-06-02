package Medium.Miscellaneous;

//https://leetcode.com/problems/reverse-integer/
public class Reverse_Integer {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            int d = x % 10;
            ans = ans * 10 + d;
            x = x / 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) ans;
    }
}
