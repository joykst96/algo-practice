package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15663_N과_M_9 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		String[] result = permutation(nums, r);
		for (String s: result) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}

	private static String[] permutation(int[] nums, int r) {
		Set<String> result = new LinkedHashSet<>();
		permutation(nums, new int[r], new boolean[nums.length], 0, r, result);
		return result.toArray(new String[0]);
	}

	private static void permutation(int[] nums, int[] out, boolean[] isSelected, int depth, int r, Set<String> result) {
		if (depth == r) {
			StringBuilder element = new StringBuilder();
			for (int i: out) element.append(i + " ");
			result.add(element.toString());
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				out[depth] = nums[i];
				permutation(nums, out, isSelected, depth + 1, r, result);
				isSelected[i] = false;
			}
		}
	}
}
