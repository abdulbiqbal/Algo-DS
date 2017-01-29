package com.abi;

import java.io.IOException;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int _prices_size = 0;
		_prices_size = Integer.parseInt(in.nextLine().trim());
		int[] _prices = new int[_prices_size];
		int _prices_item;
		for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
			_prices_item = Integer.parseInt(in.nextLine().trim());
			_prices[_prices_i] = _prices_item;
		}

		finalPrice(_prices);

	}

	static void finalPrice(int[] prices) {

		int discount[] = new int[prices.length];

		discount[prices.length-1] = 0;

		for (int i = prices.length-2; i >= 0; i--) {

			for (int j = i+1; j < discount.length; j++) {
				if(prices[i] >= prices[j]){
					discount[i] = prices[j];
					break;
				}/*else{
					if(prices[i] >= discount[j]){
						discount[i] = prices[j];
						break;
					}
				}*/
			}

		}
		
		int totalPrice = 0;
		
		
		for (int i = 0; i < discount.length; i++) {
			totalPrice = totalPrice + (prices[i] - discount[i]);
		}
		System.out.println(totalPrice);
		
		for (int i = 0; i < discount.length; i++) {
			if(discount[i] ==0)
				System.out.print(i + " ");
		}


	}

}
