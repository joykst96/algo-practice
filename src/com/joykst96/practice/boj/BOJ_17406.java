package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int minValue = 50000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] commands = new int[K][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			commands[i][0] = Integer.parseInt(st.nextToken()) - 1;
			commands[i][1] = Integer.parseInt(st.nextToken()) - 1;
			commands[i][2] = Integer.parseInt(st.nextToken());
		}
		
		permutation(commands, K, map);
		System.out.println(minValue);
	}
	
	private static int[][] rotate(int[][] map, int N, int M, int K){
		if (K == 0) return map;
		int x = N - K;
		int y = M - K;
		int save = map[x][y];
		for (++y; y <= M + K; y++) {
			int tmp = map[x][y];
			map[x][y] = save;
			save = tmp;
		}
		for (++x, --y; x <= N + K; x++) {
			int tmp = map[x][y];
			map[x][y] = save;
			save = tmp;
		}
		for (--x, --y; y >= M - K; y--) {
			int tmp = map[x][y];
			map[x][y] = save;
			save = tmp;
		}
		for (--x, ++y; x >= N - K; x--) {
			int tmp = map[x][y];
			map[x][y] = save;
			save = tmp;
		}
		return rotate(map, N, M, --K);
	}
	
	private static int getMin(int[][] map) {
		int min = 50000;
		for(int[] row: map) {
			int sum = 0;
			for (int i: row) sum += i;
			if (min > sum) min = sum;
		}
		return min;
	}
	
	private static void permutation(int[][] arr, int r, int[][] map) {
		permutation(arr, new int[r][3], new boolean[arr.length], 0, r, map);
	}

	private static void permutation(int[][] arr, int[][] out, boolean[] isSelected, int depth, int r, int[][] map) {
		if (depth == r) {
			int[][] copyMap = new int[map.length][map[0].length];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			for (int[] command: out) {
				copyMap = rotate(copyMap, command[0], command[1], command[2]);
			}
			int min = getMin(copyMap);
			if (minValue > min) minValue = min;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, isSelected, depth + 1, r, map);
				isSelected[i] = false;
			}
		}
	}
}