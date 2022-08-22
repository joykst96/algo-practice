package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_15652_N과_M_4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] nums = IntStream.range(1, Integer.parseInt(st.nextToken()) + 1).toArray();
		int r = Integer.parseInt(st.nextToken());
		int[][] result = combinationWithReplacement(nums, r);
		for (int[] arr: result) {
			for (int i: arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] combinationWithReplacement(int[] nums, int r) {
		List<int[]> result = new ArrayList<>();
		combinationWithReplacement(nums, new int[r], 0, 0, r, result);
		return result.toArray(new int[0][r]);
	}

	private static void combinationWithReplacement(int[] nums, int[] out, int start, int depth, int r, List<int[]> result) {
		if (depth == r) {
			result.add(out.clone());
			return;
		}
		for (int i = start; i < nums.length; i++) {
			out[depth] = nums[i];
			combinationWithReplacement(nums, out, i, depth + 1, r, result);
		}
	}
}
