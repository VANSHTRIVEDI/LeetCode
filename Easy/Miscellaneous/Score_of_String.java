package Easy.Miscellaneous;

public class Score_of_String {
    public int scoreOfString(String s) {
        int maxsum = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            // int h=Integer.valueOf(Math.abs(s.charAt(i)-s.charAt(i+1)));
            // maxsum=maxsum+h;

            // both are same below is the best way

            maxsum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return maxsum;
    }
}
