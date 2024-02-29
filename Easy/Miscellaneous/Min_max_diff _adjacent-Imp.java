package Easy.Miscellaneous;

//https://www.codingninjas.com/studio/problems/minimize-the-maximum-difference-between-adjacent-elements-in-an-array_893177?leftPanelTabValue=PROBLEM
class minmax {

	public static int maxAdjDifference(int arr[], int n, int k) {
		int minAnswer = Integer.MAX_VALUE;

		for (int i = 0; i <= k; ++i) {
			int maxDiff = Integer.MIN_VALUE;

			for (int j = i + 1; j < i + n - k; ++j) {
				maxDiff = Math.max(maxDiff, arr[j] - arr[j - 1]);
			}

			minAnswer = Math.min(minAnswer, maxDiff);
		}

		return minAnswer;
	}

}
