package Heaps;

import java.util.*;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class Kth_Largest_Element_Stream {
    static PriorityQueue<Integer> q;
    static int kk;

    public Kth_Largest_Element_Stream(int k, int[] nums) {
        q = new PriorityQueue<>();
        kk = k;
        for (int num : nums) {
            this.add(num);
            // add(num); compiler understands it automatically that both are same
            // if we call another non static function from a nonstatic function
        }
    }

    public int add(int val) {
        if (q.size() < kk) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

// for gfg the question is slightly different
// ans in submissions

// https://www.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article