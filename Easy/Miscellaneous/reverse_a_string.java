package Easy.Miscellaneous;

import java.util.*;
import java.io.*;

class Solution {

    // Using StringBuffer 1st Method
    public static String reverseString(String str) {

        StringBuffer br = new StringBuffer(str);
        return br.reverse().toString();

    }

    // Using array 2nd method
    public static String reverseString2(String str) {

        // StringBuffer br=new StringBuffer(str);
        // return br.reverse().toString();

        char[] charArray = str.toCharArray();
        int n = str.length();
        for (int i = 0; i < n / 2; ++i) {
            // Swap characters.
            char ch = charArray[i];
            charArray[i] = charArray[n - i - 1];
            charArray[n - i - 1] = ch;
        }
        // return charArray.toString();
        return String.valueOf(charArray);

    }

    // using while two pointer
    public static String reverseString3(String str) {
        // Write your code here.
        char arr[] = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            char x = arr[left];
            arr[left] = arr[right];
            arr[right] = x;
            left++;
            right--;
        }
        return new String(arr);
    }

    // Using recursion but till will come as stackoverflow if the string is two
    // large 3st Method
    public static String rec(int index, String str) {
        if (index == str.length()) {
            return "";
        }
        char ch = str.charAt(index);
        return rec(index + 1, str) + ch;

    }

}
