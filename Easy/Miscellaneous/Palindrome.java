package Easy.Miscellaneous;

import java.util.Scanner;

//Palindrome in leetcode

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(isPalindrome(n));
        sc.close();
    }

    // best way using interation
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}

// Using Recursion
class Palindrome4 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        return isPalindromeHelper(x, 0);
    }

    private boolean isPalindromeHelper(int num, int reversed) {
        if (reversed >= num) {
            return reversed == num || reversed / 10 == num;
        }
        return isPalindromeHelper(num / 10, (reversed * 10) + (num % 10));
    }

}

// using string
class Palindrome2 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {

            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;

    }
}

// Using usual way
class Palindrome3 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int temp = x;
            int reverse = 0;
            while (temp != 0) {
                int d = temp % 10;
                reverse = (reverse * 10) + d;
                temp = temp / 10;
            }
            if (reverse == x) {
                return true;
            } else {
                return false;
            }
        }

    }
}