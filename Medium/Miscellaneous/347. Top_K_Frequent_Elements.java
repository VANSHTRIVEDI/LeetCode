package Medium;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        int arr[] = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        System.out.print(mp);
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

            enterelement(s, (int) entry.getKey(), (int) entry.getValue(), k);

        }
        int i = 0;
        while (k != 0 && s.isEmpty() == false) {
            int temp = getKeyByValue(mp, s.peek());
            s.pop();

            arr[i] = temp;
            i++;
            k--;

            mp.put(temp, mp.get(temp) - (mp.get(temp) + 1));
        }
        return arr;

    }

    public void enterelement(Stack<Integer> s, int key, int value, int n) {
        if (s.isEmpty() || value > s.peek() || n == -1) {
            s.push(value);
            return;
        }
        int temp = s.pop();
        n--;
        enterelement(s, key, value, n);
        s.push(temp);

    }

    public static int getKeyByValue(Map<Integer, Integer> map, int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return -1;
    }
}