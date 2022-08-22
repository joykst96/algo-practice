package com.joykst96.practice.boj;

import java.util.*;
import java.io.*;

/*
 *  메모리: 275748 KB
 *  시간: 572 ms
 * 
 */

public class BOJ_17136_색종이붙이기 {
	static int[] papers = {5, 5, 5, 5, 5};
	static int min = 26;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[10][10];
		int count = 0;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) ++count;
			}
		}
		dfs(0, count, map);
		System.out.println(min < 26 ? min : -1);
	}

	private static void dfs(int used, int count, int[][] map) {
		if (used > 25) return;
		if (count == 0) {
			if (min > used) min = used;
			return;
		}
		for (int i = 0; i < 10; i++) for (int j = 0; j < 10; j++) if (map[i][j] == 1) {
			for (int size = 4; size >= 0; size--) if (papers[size] > 0 && isIn(i + size, j + size) && isPossible(i, j, size, map)) {
				--papers[size];
				int[][] newMap = fill(i, j, size, cloneMap(map));
				dfs(used + 1, count - getRangeCount(i, j, size, map), newMap);
				++papers[size];
			}
			return;
		}
	}

	private static int[][] fill(int r, int c, int size, int[][] map) {
		for (int i = r; i <= r + size; i++) for (int j = c; j <= c + size; j++) map[i][j] = 0;
		return map;
	}

	private static boolean isPossible(int r, int c, int size, int[][] map) {
		return getRangeCount(r, c, size, map) == Math.pow(size + 1, 2);
	}

	private static int getRangeCount(int r, int c, int size, int[][] map) {
		int count = 0;
		for (int i = r; i <= r + size; i++) for (int j = c; j <= c + size; j++) if (map[i][j] == 1) ++count;
		return count;
	}
	
	private static boolean isIn(int r, int c) {
		return (r >= 0 && c >= 0 && r < 10 && c < 10);
	}

	private static int[][] cloneMap(int[][] map) {
		int[][] newMap = new int[10][10];
		for (int i = 0; i < 10; i++) for (int j = 0; j < 10; j++) newMap[i][j] = map[i][j];
		return newMap;
	}
}
