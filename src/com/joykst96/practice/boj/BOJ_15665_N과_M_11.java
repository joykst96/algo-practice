package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15665_N과_M_11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		String[] result = permutationWithReplacement(nums, r);
		for (String s: result) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}

	private static String[] permutationWithReplacement(int[] nums, int r) {
		Set<String> result = new LinkedHashSet<>();
		permutationWithReplacement(nums, new int[r], 0, r, result);
		return result.toArray(new String[0]);
	}

	private static void permutationWithReplacement(int[] nums, int[] out, int depth, int r, Set<String> result) {
		if (depth == r) {
			StringBuilder element = new StringBuilder();
			for (int i: out) element.append(i + " ");
			result.add(element.toString());
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			out[depth] = nums[i];
			permutationWithReplacement(nums, out, depth + 1, r, result);
		}
	}
}
