package com.evllabs.pcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pcalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("[useage] pcal {probability} {n} {k}");
		} else {
			BigDecimal probability = BigDecimal
					.valueOf(Double.valueOf(args[0]));
			int n = Integer.valueOf(args[1]);
			int k = Integer.valueOf(args[2]);
			System.out.println(n);
			System.out.println(k);
			probability = probability.pow(n);
			BigDecimal alpha = BigDecimal.ZERO;
			while (k <= n) {
				alpha = alpha.add(choose(n, k));
				k++;
			}
			System.out.println(probability.multiply(alpha));
		}
	}

	public static BigDecimal choose(int n, int k) {
		if(k ==0){
			return BigDecimal.ONE;
		}else if (n == 0){
			return BigDecimal.ZERO;
		}else if (k == n){
			return BigDecimal.ONE;
		}
		long a = factorial(n);
		System.out.println("a"+a);
		long b = factorial(k);
		System.out.println("b"+b);
		long c = factorial(n-k);
		System.out.println("c"+c);
		long d = b * c;
		System.out.println("d"+d);
		
		return new BigDecimal(a).divide(new BigDecimal(d), RoundingMode.HALF_EVEN);
	}

	public static long factorial(int n) {
		if (n <= 1) // base case
			return 1;
		else
			return n * factorial(n - 1);
	}

}
