package Heaps;

import java.util.*;

public class Lexicographically_Minimum_String {
    public String clearStars(String s) {
        char[] str = s.toCharArray();
        Queue<P> pq = new PriorityQueue<>((a, b) -> {
            if (a.c == b.c) {
                return b.i - a.i;
            }
            return Character.compare(a.c, b.c);
        });
        for (int i = 0; i < str.length; i++) { // O(n)
            if (str[i] != '*') {
                pq.add(new P(str[i], i)); // log(n)
            } else {
                int idx = pq.poll().i;
                str[idx] = '*';
            }
        }
        char[] result = new char[str.length];
        int index = 0;
        for (char c : str) {
            if (c != '*') {
                result[index++] = c;
            }
        }
        return new String(result, 0, index);
    }
}

class P {
    public char c;
    public int i;

    public P(char c, int i) {
        this.c = c;
        this.i = i;
    }
}