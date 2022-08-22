package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설_공주와_일곱_난쟁이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarves = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
		}
		combination(dwarves);
	}

	private static void combination(int[] dwarves) {
		combination(dwarves, new int[7], new boolean[9], 0, 0);
	}

	private static void combination(int[] dwarves, int[] out, boolean[] isSelected, int start, int depth) {
		if (depth == 7) {
			int sum = 0;
			for (int i: out) sum += i;
			if (sum == 100) {
				StringBuilder sb = new StringBuilder();
				for (int i: out) sb.append(i + "\n");
				System.out.print(sb);
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < dwarves.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				out[depth] = dwarves[i];
				combination(dwarves, out, isSelected, i + 1, depth + 1);
				isSelected[i] = false;
			}
		}
	}
}
