package com.joykst96.practice.etc;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int[][] result = combination(arr, 3);
		for (int[] a: result) {
			System.out.println(Arrays.toString(a));
		}
		
	}

	private static int[][] combination(int[] arr, int r) {
		int start = 0, depth = 0;
		boolean[] isSelected = new boolean[arr.length];
		int totalCnt = 0;
		int size = 1;
		for(int i = 0; i < r; i++) {
			size *= arr.length - i;
		}
		for(int i = 0; i < r; i++) {
			size /= r - i;
		}
		int[][] out = new int[size][r];
		combination(arr, out, isSelected, start, depth, r, totalCnt);
		return out;
	}

	private static void combination(int[] arr, int[][] out, boolean[] isSelected, int start, int depth, int r, int totalCnt) {
		if (depth == r) {
			int idx = 0;
			int[] element = new int[r];
			for (int i = 0; i < arr.length; i++) {
				if(isSelected[i]) out[totalCnt++][idx] = arr[i];
			}
			return;
			
		}
		for (int i = start; i < arr.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				combination(arr, out, isSelected, i + 1, depth + 1, r, totalCnt);
				isSelected[i] = false;
			}
		}
	}
	
	
}
