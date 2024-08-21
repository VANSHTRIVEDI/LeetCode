package Heaps;

//https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1
import java.util.*;

//but in this question using hasmap and sorting gives better solution 
public class Replace_elements_rank_array {
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Info> q = new PriorityQueue<>((a, b) -> (int) a.value - (int) b.value);
        for (int i = 0; i < arr.length; i++) {
            q.add(new Info(arr[i], i));
        }
        int o = 1;
        int prev = -1;
        while (!q.isEmpty()) {
            Info temp = q.poll();
            int index = temp.index;
            if (prev != -1 && temp.value == prev) {
                o--;
            }

            arr[index] = o;
            prev = temp.value;
            o++;
        }
        return arr;

    }

    // same program using hashmap
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = arr.clone();
        Arrays.sort(nums);
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], k++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            nums[i] = map.get(arr[i]);
        }
        return nums;
    }
}

class Info {
    int value;
    int index;

    Info(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

// same method just the way of writing is different

class Replace_elements_rank_array2 {
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Info> q = new PriorityQueue<>((a, b) -> (int) a.value - (int) b.value);
        for (int i = 0; i < arr.length; i++) {
            q.add(new Info(arr[i], i));
        }
        int rank = 1;
        int prev = q.peek().value;
        while (!q.isEmpty()) {
            Info temp = q.poll();
            int index = temp.index;
            if (temp.value == prev) {
                arr[index] = rank;
            } else {
                rank++;
                arr[index] = rank;

            }
            prev = temp.value;

        }
        return arr;

    }
}

class Info {
int value;
int index;

Info(int value, int index) {
this.value = value;
this.index = index;
}
}
