package Medium.recursion_backtrack;

public class Palindrome {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9]", "");

        if (isPalindrome2(str)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome2(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome2(str.substring(1, str.length() - 1));
    }
}
