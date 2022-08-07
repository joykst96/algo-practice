package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_15650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] nums = IntStream.range(1, Integer.parseInt(st.nextToken()) + 1).toArray();
		int r = Integer.parseInt(st.nextToken());
		int[][] result = combination(nums, r);
		for (int[] arr: result) {
			for (int i: arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] combination(int[] nums, int r) {
		List<int[]> result = new ArrayList<>();
		combination(nums, new int[r], new boolean[nums.length], 0, 0, r, result);
		return result.toArray(new int[0][r]);
	}

	private static void combination(int[] nums, int[] out, boolean[] isSelected, int start, int depth, int r, List<int[]> result) {
		if (depth == r) {
			result.add(out.clone());
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				out[depth] = nums[i];
				combination(nums, out, isSelected, i + 1, depth + 1, r, result);
				isSelected[i] = false;
			}
		}
	}
}
