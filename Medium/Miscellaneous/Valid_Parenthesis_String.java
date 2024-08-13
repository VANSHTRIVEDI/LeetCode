package Medium.Miscellaneous;



//https://leetcode.com/problems/valid-parenthesis-string/?envType=daily-question&envId=2024-04-07
public class Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0)
                return false;
            if (leftMin < 0)
                leftMin = 0;
        }

        return leftMin == 0;
    }
}
