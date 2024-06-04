package Medium.Miscellaneous;

import java.util.*;

public class Longest_Palindrome {

    //// 80 beast
    public int longestPalindrome3(String s) {
        int n = s.length();
        int[] cntArray = new int[52];
        int longestPalinLen = 0;
        Arrays.fill(cntArray, 0);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                cntArray[ch - 'a']++;
            } else {
                cntArray[ch - 'A' + 26]++;
            }
        }
        // if frequency is even add it in your answer
        // if frequecy is odd, consider even count by subtracting 1
        // finally if atleast one odd character is found, add 1 to your answer
        boolean isOddFound = false;
        for (int i = 0; i < 52; i++) {
            if ((cntArray[i] % 2) == 0) {
                longestPalinLen += cntArray[i];
            } else {
                longestPalinLen += (cntArray[i] - 1);
                isOddFound = true;
            }
        }
        longestPalinLen = (isOddFound) ? (++longestPalinLen) : longestPalinLen;
        return longestPalinLen;
    }

    // 60 beast
    public int longestPalindrome2(String s) {
        HashSet<Character> arr = new HashSet<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (arr.contains(ch)) {
                length = length + 2;
                arr.remove(ch);
            } else {
                arr.add(ch);
            }

        }
        if (arr.isEmpty()) {
            return length;
        } else {
            return length + 1;
        }
    }

    // using hashmap
    // 32
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        int maxodd = 0;

        for (Integer temp : map.values()) {
            if ((int) temp % 2 == 0) {
                count += (int) temp;
            } else {
                maxodd = 1;
                count = count + (temp - 1);
            }
        }
        return maxodd > 0 ? count + 1 : count;
    }

    // beats 12
    public int longestPalindrome4(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;
        int oddFreq = 0;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) % 2 != 0) {
                oddFreq++;
            } else {
                oddFreq--;
            }
        }

        if (oddFreq > 0) {
            return n - oddFreq + 1;
        }

        return n;
    }

}
