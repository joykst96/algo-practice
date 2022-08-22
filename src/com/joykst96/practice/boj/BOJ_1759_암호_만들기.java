package com.joykst96.practice.boj;

import java.util.*;
import java.io.*;

public class BOJ_1759_암호_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[] pool = br.readLine().replace(" ", "").toCharArray();
		String[] result = combination(pool, L);
		for (String s: result) sb.append(s + "\n");
		System.out.print(sb);
	}

	private static String[] combination(char[] arr, int r) {
		List<String> result = new ArrayList<>();
		combination(arr, new char[r], new boolean[arr.length], 0, 0, r, result);
		Collections.sort(result);
		return result.toArray(new String[0]);
	}

	private static void combination(char[] arr, char[] out, boolean[] isSelected, int start, int depth, int r, List<String> result) {
		if (depth == r) {
			if (!isValid(out)) return;
			char[] tmp = out.clone();
			Arrays.sort(tmp);
			StringBuilder sb = new StringBuilder();
			for (char ch: tmp) sb.append(ch);
			result.add(sb.toString());
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
	
	private static boolean isValid(char[] password) {
		int aeiou = 0;
		int remainder = 0;
		for (char ch: password) {
			switch (ch) {
			case 'a': case 'e': case 'i': case 'o': case 'u': ++aeiou; break;
			default: ++remainder; break;
			}
		}
		return aeiou >= 1 && remainder >= 2;
	}
}
