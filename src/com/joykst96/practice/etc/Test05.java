package com.joykst96.practice.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Test05 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int r = Integer.parseInt(br.readLine());
		
		combination(nums, new boolean[nums.length], 0, 0, r);
	}

	private static void combination(int[] nums, boolean[] isSelected, int start, int depth, int r) {
		if (depth == r) {
			for (int i = 0; i < nums.length; i++) {
				if (isSelected[i]) System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				combination(nums, isSelected, i + 1, depth + 1, r);
				isSelected[i] = false;
			}
		}
	}
}
