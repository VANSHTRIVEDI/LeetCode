package Easy.Miscellaneous;
// https://www.codingninjas.com/studio/problems/two-sum_839653?leftPanelTabValue=PROBLEM

// import java.util.ArrayList;
// import java.util.*;
// class TwoSum {
// public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer>
// nums, int target, int n)
// {
// HashMap<Integer, Integer> map = new HashMap<>();
// int t = 0;
// ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();

// for (int i = 0; i < n; i++)
// {
// int element = nums.get(i);
// int want = target - element;

// if (map.containsKey(want) && map.get(want) >0 && map.get(want)!=-1 ) { //
// Fixing the syntax error here
// t = 1;
// result.add(new Pair<>(want, element));
// int p=map.get(want);
// map.put(want, p-1);
// map.put(element,-1);
// }

// // Always put the current element in the map, even if no match is found,
// // to handle the case of duplicates.
// if(map.containsKey(element))
// {
// int p=map.get(element);
// map.put(element, p+1);
// }
// else
// {
// map.put(element,1);
// }

// }

// if (t == 0)
// {
// result.add(new Pair<>(-1, -1));
// }

// return result;
// }
// }
