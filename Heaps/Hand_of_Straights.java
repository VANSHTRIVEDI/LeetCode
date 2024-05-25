package Heaps;

import java.util.*;

public class Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0; i < hand.length; i++) {
            q.add(hand[i]);
        }
        while (!q.isEmpty()) {
            int smallest = q.poll();
            for (int i = 1; i < groupSize; i++) {
                if (q.remove(smallest + i))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}
