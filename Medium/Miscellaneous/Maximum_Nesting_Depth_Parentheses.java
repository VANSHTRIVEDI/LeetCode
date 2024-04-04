package Medium.Miscellaneous;

//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/?envType=daily-question&envId=2024-04-04
public class Maximum_Nesting_Depth_Parentheses {
    public int maxDepth(String s) {
        int count = 0;
        int maxNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (maxNum < count)
                    maxNum = count;
            } else if (c == ')') {
                count--;
            }
        }
        return maxNum;
    }
}
