package com.joykst96.practice.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test01 {
	public static void main(String[] args) {
		System.out.println(log2());
	}
	
	static double log2(double x) {
		return Math.log10(x) / Math.log10(2);
	}
}