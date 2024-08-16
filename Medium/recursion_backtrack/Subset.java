package Medium.recursion_backtrack;

// /https://leetcode.com/problems/subsets/?envType=daily-question&envId=2024-05-21
import java.util.ArrayList;
import java.util.List;

public class Subset {
    static List<List<Integer>> finall;

    public List<List<Integer>> subsets(int[] nums) {

        finall = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(nums, arr, 0);
        return finall;
    }

    public static void backtrack(int[] nums, List<Integer> arr, int i) {
        if (!finall.contains(arr))
            finall.add(new ArrayList<>(arr));

        if (i > nums.length - 1) {
            return;
        }

        arr.add(nums[i]);
        backtrack(nums, arr, i + 1);// takes
        arr.remove(arr.size() - 1);
        backtrack(nums, arr, i + 1);// not takes
    }

}

// Iterative Approch

class subset2 {
    static List<List<Integer>> finall;

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finall = new ArrayList<>();
        finall.add(new ArrayList<>()); // Start with the empty subset

        for (int num : nums) {
            int size = finall.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(finall.get(i));
                subset.add(num);
                finall.add(subset);
            }
        }

        return finall;
    }
}

// backtracking

class subset3 {
    static List<List<Integer>> finall;

    public List<List<Integer>> subsets(int[] nums) {
        finall = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(nums, arr, 0);
        return finall;
    }

    public static void backtrack(int[] nums, List<Integer> arr, int i) {
        if (!finall.contains(arr))
            finall.add(new ArrayList<>(arr));

        if (i > nums.length - 1) {
            return;
        }

        arr.add(nums[i]);
        backtrack(nums, arr, i + 1);
        arr.remove(arr.size() - 1);
        backtrack(nums, arr, i + 1);
    }
}

// backtracking

class subset5 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finall = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), finall);
        return finall;
    }

    private void dfs(int[] nums, int index, List<Integer> path,
            List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.remove(path.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        subset5 solution = new subset5();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}

// bits manipulation

class subset6 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finall = new ArrayList<>();
        int n = nums.length;
        int numOfSubsets = 1 << n; // 2^n subsets

        for (int i = 0; i < numOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            finall.add(subset);
        }

        return finall;
    }

    public static void main(String[] args) {
        subset6 solution = new subset6();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
