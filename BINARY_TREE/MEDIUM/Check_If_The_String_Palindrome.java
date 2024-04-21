package BINARY_TREE.MEDIUM;

public class Check_If_The_String_Palindrome {
    public static boolean checkPalindrome(String str) {

        str = str.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9]", "");

        int low = 0;
        int high = str.length() - 1;
        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;

    }
}
