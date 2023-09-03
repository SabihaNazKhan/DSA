package knapsack.fractionalKnapsack;

import java.util.Arrays;
import java.util.Comparator;

/*Fractional Knapsack Problem

Given the weights and profits of N items, in the form of {profit, weight} 
put these items in a knapsack of capacity W to get the maximum total profit 
in the knapsack. In Fractional Knapsack, we can break items for maximizing 
the total value of the knapsack.

Input: arr[] = {{60, 10}, {100, 20}, {120, 30}}, W = 50
Output: 240 
Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. 
*/

public class MaximumProficFractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 60, 10 }, { 100, 20 }, { 120, 30 } };
		int W = 50;

		System.out.println("Maximum Profit is :" + getMaxProfitGreedy(arr, W));
		System.out.println("Maximum Profit is (0/1) :" + getMaxProfit0to1(arr, W));

		int[] q = { 1, 2, 3, 4, 5 };
		int[][] arr2 = { { 1, 2 }, { 1, 3 }, { 3, 7 } };

		double[] result = getMaxProfitGreedy(arr2, q);

		for (double i : result) {
			System.out.println(i);
		}

	}

	private static int getMaxProfit0to1(int[][] arr, int w) {
		// TODO Auto-generated method stub
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				double d1 = (double) o1[0] / o1[1];
				double d2 = (double) o2[0] / o2[1];
				return d1 < d2 ? 1 : -1;
			}
		});
		int profit = 0;

		for (int[] a : arr) {
			if (w >= a[1]) {
				profit += a[0];
				w -= a[1];
			} else {
				break;
			}
		}
		return profit;
	}

	private static double[] getMaxProfitGreedy(int[][] arr, int[] q) {
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				double d1 = (double) o1[0] / o1[1];
				double d2 = (double) o2[0] / o2[1];
				return d1 < d2 ? 1 : -1;
			}
		});
		double[] result = new double[q.length];
		for (int i = 0; i < q.length; i++) {
			int w = q[i];
			double profit = 0;

			for (int[] a : arr) {
				if (w == 0)

					break;
				if (w >= a[1]) {
					profit += a[0];
					w -= a[1];
				} else {
					double p = (((double) a[0] / a[1]) * w);
					profit += p;
					break;
				}
			}
			result[i] = profit;
		}
		return result;
	}

	private static int getMaxProfitGreedy(int[][] arr, int w) {
		// TODO Auto-generated method stub
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				double d1 = (double) o1[0] / o1[1];
				double d2 = (double) o2[0] / o2[1];
				return d1 < d2 ? 1 : -1;
			}
		});
		int profit = 0;

		for (int[] a : arr) {
			if (w == 0)
				break;
			if (w >= a[1]) {
				profit += a[0];
				w -= a[1];
			} else {
				int p = (int) (((double) a[0] / a[1]) * w);
				profit += p;
				break;
			}
		}
		return profit;
	}

}
