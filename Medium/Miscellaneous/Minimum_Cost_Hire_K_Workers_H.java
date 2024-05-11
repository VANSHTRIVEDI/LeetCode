package Medium.Miscellaneous;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
// import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/?envType=daily-question&envId=2024-05-11
// public class Minimum_Cost_Hire_K_Workers {
// public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
// PriorityQueue<Integer> maxHeap = new
// PriorityQueue<>(Collections.reverseOrder());
// List<Pair<Double, Integer>> ratio = new ArrayList<>();
// int n = quality.length, qualitySum = 0;
// double res = Double.MAX_VALUE, maxRate = 0.0;

// for (int i = 0; i < n; ++i) {
// ratio.add(new Pair<>((double) wage[i] / quality[i], i));
// }

// ratio.sort(Comparator.comparingDouble(p -> p.getKey()));
// for (int i = 0; i < k; ++i) {
// qualitySum += quality[ratio.get(i).getValue()];
// maxRate = Math.max(maxRate, ratio.get(i).getKey());
// maxHeap.offer(quality[ratio.get(i).getValue()]);
// }

// res = maxRate * qualitySum;
// for (int i = k; i <n; ++i) {
// maxRate = Math.max(maxRate, ratio.get(i).getKey());
// qualitySum -= maxHeap.poll();
// qualitySum += quality[ratio.get(i).getValue()];
// maxHeap.offer(quality[ratio.get(i).getValue()]);
// res = Math.min(res, maxRate * qualitySum);
// }

// return res;
// }
// }
