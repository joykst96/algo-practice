package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/SWEA_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] table = new int[N][N];
			int[][] cumsum = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
					for (int k = 0; k <= i; k++) {
						for (int l = 0; l <= j; l++) {
							cumsum[i][j] += table[k][l];
						}
					}
				}
			}
			for(int[] arr: table) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
			for(int[] arr: cumsum) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
			for (int i = 0; i <= N - M; i ++) {
				for (int j = 0; j <= N - M; j++) {
					int killCnt = cumsum[i + M - 1][j + M - 1];
					if (i - 1 >= 0) killCnt -= cumsum[i - 1][j + M - 1];
					if (j - 1 >= 0) killCnt -= cumsum[i + M - 1][j - 1];
					if (i - 1 >= 0 && j - 1 >= 0) killCnt += cumsum[i - 1][j - 1];
					max = Math.max(max, killCnt);
				}
			}
			sb.append(String.format("#%d %d%n", t, max));
		}
		System.out.println(sb);
	}
}
