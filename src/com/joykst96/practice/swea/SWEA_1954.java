package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] table = new int[n][n];
			int d = 0;
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			int x = 0, y = 0;
			int count = 1;
			table[x][y] = count++;
			while (count <= n * n) {
				if (x + dx[d] >= 0 && x + dx[d] < n && y + dy[d] >= 0 && y + dy[d] < n) {
					if (table[x + dx[d]][y + dy[d]] == 0) {
						table[x + dx[d]][y + dy[d]] = count++;
					} else {
						d = (d + 1) % 4;
						continue;
					}
				} else {
					d = (d + 1) % 4;
					continue;
				}
				x += dx[d];
				y += dy[d];
				
			}
			sb.append("#" + t + "\n");
			for(int[] arr: table) {
				for (int i: arr) {
					sb.append(String.format("%d ", i));
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
