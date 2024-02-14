package Medium.Miscellaneous;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(isPalindrome(n));
        sc.close();
    }

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

class Palindrome2 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        for (int i = 0; i < n / 2; i++) {
            // We check whether the elements at the same distance from
            // beginning and from ending are same, if not we return false
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;

    }
}

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