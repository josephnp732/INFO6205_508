package Knapsack;
import static Knapsack.Values.knapsackCapacity;
import static Knapsack.Values.totalItems;

import java.util.ArrayList;
import java.util.List;

public class KnapsackPhenotype {
	
	public static int phenotype;

	public KnapsackPhenotype() {
		int[] value = new int[totalItems]; // Values of items
		int[] weight = new int[totalItems]; // Weight of items
		List<Item> list = Run.itemList;
		
		for(int i = 0; i < totalItems; i++)
		{
			value[i] = list.get(i).getPrice();
			weight[i] = list.get(i).getWeight();
		}
		solution(knapsackCapacity, weight, value, totalItems);
	}

	public static void solution(int capacity, int[] weight, int[] value, int itemsCount) {
		int[][] K = new int[itemsCount + 1][capacity + 1];

		for (int i = 0; i <= itemsCount; ++i) {
			for (int w = 0; w <= capacity; ++w) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (weight[i - 1] <= w)
					K[i][w] = Math.max((value[i - 1] + K[i - 1][w - weight[i - 1]]), K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		phenotype = K[itemsCount][capacity];
	}
}
