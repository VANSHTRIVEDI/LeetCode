package Easy.Miscellaneous;

import java.util.*;
//https://leetcode.com/problems/relative-ranks/
public class Relative_Ranks {

    // using hashing nlogn
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        int[] temp = Arrays.copyOf(score, score.length);
        Arrays.sort(temp);
        Map<Integer, String> mp = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                mp.put(temp[i], "Gold Medal");
            else if (i == temp.length - 2)
                mp.put(temp[i], "Silver Medal");
            else if (i == temp.length - 3)
                mp.put(temp[i], "Bronze Medal");
            else {
                mp.put(temp[i], Integer.toString(temp.length - i));
            }
        }
        for (int i = 0; i < score.length; i++) {
            ans[i] = mp.get(score[i]);
        }
        return ans;
    }

    // best way o(m+n)
    public String[] findRelativeRanks2(int[] score) {

        int n = score.length;

        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }

        int[] score2Index = new int[maxScore + 1];

        for (int i = 0; i < n; i++) {
            score2Index[score[i]] = i + 1;
        }

        String[] ans = new String[n];

        int place = 1;

        for (int i = maxScore; i >= 0; i--) {

            if (score2Index[i] == 0)
                continue;

            int actualIndex = score2Index[i] - 1;
            if (place == 1) {
                ans[actualIndex] = "Gold Medal";
            } else if (place == 2) {
                ans[actualIndex] = "Silver Medal";
            } else if (place == 3) {
                ans[actualIndex] = "Bronze Medal";
            } else {
                ans[actualIndex] = String.valueOf(place);
            }
            place++;
        }

        return ans;
    }
    // using priority queue
    // public String[] findRelativeRanks3(int[] score) {

    // int n = score.length;

    // PriorityQueue<Pair<Integer, Integer>> maxheap = new PriorityQueue<>((p1, p2)
    // -> (p2.getValue() - p1.getValue()));

    // for (int i = 0 ; i < n ; i++) {
    // maxheap.add(new Pair(i, score[i]));
    // }

    // String[] ans = new String[n];

    // int place = 1;

    // while (!maxheap.isEmpty()) {
    // Pair<Integer, Integer> top = maxheap.poll();

    // int curIndex = top.getKey();

    // if (place == 1) {
    // ans[curIndex] = "Gold Medal";
    // } else if (place == 2) {
    // ans[curIndex] = "Silver Medal";
    // } else if (place == 3) {
    // ans[curIndex] = "Bronze Medal";
    // } else {
    // ans[curIndex] = String.valueOf(place);
    // }
    // place++;

    // }

    // return ans;
    // }
}
