package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

/*
 *  메모리: 296012 KB
 *  시간: 1828 ms
 *  
 */

public class BOJ_1987 {
	static int R, C, max;
	static char[][] map;
	static Set<Character> visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		map = new char[R][C];
		visited = new HashSet<>();
		max = 0;
		for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int x, int y) {
		if (visited.contains(map[x][y])) {
			if (max < visited.size()) max = visited.size();
			return;
		}
		visited.add(map[x][y]);
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isIn(nx, ny)) continue;
			dfs(nx, ny);
		}
		visited.remove(map[x][y]);
	}
	
	private static boolean isIn(int x, int y) {
		return (x >= 0 && y >= 0 && x < R && y < C);
	}
}
