package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_9229 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/SWEA_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			int[] sumWeight = combination(snacks, 2);
			int max = 0;
			for (int i = 0; i < sumWeight.length; i++) {
				if (sumWeight[i] > max && sumWeight[i] <= M) max = sumWeight[i];
			}
			if (max != 0) {
				sb.append(String.format("#%d %d%n", t, max));
			} else {
				sb.append(String.format("#%d %d%n", t, -1));
			}
		}
		System.out.println(sb);
	}

	private static int[] combination(int[] arr, int r) {
		Set<Integer> result = new HashSet<>();
		combination(arr, new int[r], new boolean[arr.length], 0, 0, r, result);
		return result.stream().mapToInt(i -> (int)i).toArray();
	}

	private static void combination(int[] arr, int[] out, boolean[] isSelected, int start, int depth, int r, Set<Integer> result) {
		if (depth == r) {
			int sum = 0;
			for (int i: out) sum += i;
			result.add(sum);
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				out[depth] = arr[i];
				combination(arr, out, isSelected, i + 1, depth + 1, r, result);
				isSelected[i] = false;
			}
		}
	}
}
