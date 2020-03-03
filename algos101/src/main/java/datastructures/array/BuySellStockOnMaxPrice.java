package datastructures.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
	design an algorithm to find the maximum profit.

	Note that you cannot sell a stock before you buy one.

	Example 1:

	Input: [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
 */

public class BuySellStockOnMaxPrice {

	class Interval {
		int buyDay;
		int buyPrice;
		int sellDay;
		int sellPrice;
		int profit;
	}

	// Get Maximum profit out of given prices. Non-Optimized Solution O(n^2)
	public int maxProfit(int[] prices) {
		List<Interval> intervals = new ArrayList<Interval>();

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] < prices[j]) {
					intervals.add(createInterval(i + 1, prices[i], j + 1, prices[j]));
				}
			}
		}

		int maxProfitIndex = 0, maxProfit = 0;
		int idx = 0;
		for (Interval i : intervals) {
			if (maxProfit < i.profit) {
				maxProfitIndex = idx;
				maxProfit = i.profit;
			}

			idx++;
		}
		Interval interval = intervals.get(maxProfitIndex);
		System.out.println("Best day for buy is " + interval.buyDay + " and for sell is " + interval.sellDay);
		System.out.println("Max Profile is " + interval.sellPrice + " - " + interval.buyPrice + " = " + interval.profit);
		return maxProfit;
	}
	
	// Get Maximum profit out of given prices. Optimized Solution O(n)
	public int maximumProfit(int[] prices) {
		int buyPrice = prices[0];
		int sellPrice = prices[0];
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			
			if (prices[i] < buyPrice) {
				buyPrice = prices[i];
			} else if (prices[i] > buyPrice) {
				if (prices[i] - buyPrice > maxProfit) {
					maxProfit = prices[i] - buyPrice;
					sellPrice =  prices[i];
				}
			}
			
		}
		return maxProfit;
	}

	public Interval createInterval(int buyDay, int buyPrice, int sellDay, int sellPrice) {
		Interval i = new Interval();
		i.buyDay = buyDay;
		i.buyPrice = buyPrice;
		i.sellDay = sellDay;
		i.sellPrice = sellPrice;
		i.profit = sellPrice - buyPrice;
		return i;
	}

	public static void main(String[] args) {
		//int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		int[] prices = new int[] {4, 2, 10, 1, 5, 3, 6};
		BuySellStockOnMaxPrice stock = new BuySellStockOnMaxPrice();
		int profit = stock.maxProfit(prices);
		System.out.println("NON-OPTIMIZED PROFIT = " + profit);
		
		profit = stock.maximumProfit(prices);
		System.out.println("OPTIMIZED SOLUTION PROFIT = " + profit);
	}
}
