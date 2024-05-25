package Heaps;

import java.util.*;

public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                q.add(arr[i]);
            }
        }
        int time = 0;
        while (!q.isEmpty()) {
            ArrayList<Integer> kk = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {
                if (!q.isEmpty()) {
                    int f = q.poll();
                    f--;
                    kk.add(f);
                }

            }
            for (int i : kk) {
                if (i > 0)
                    q.add(i);
            }

            if (q.isEmpty()) {
                time = time + kk.size();
            } else {
                time = time + (n + 1);
            }
        }
        return time;
    }
}
