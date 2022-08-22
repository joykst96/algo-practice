package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
	static int[] colors = new int [2]; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		run(map);
		System.out.println(colors[0]);
		System.out.println(colors[1]);
		
	}
	
	static void run(int[][] map) {
		if (isPure(map)) {
			++colors[map[0][0]];
			return;
		}
		for (int[][] divMap: cut(map)) {
			run(divMap);
		}
	}

	static boolean isPure(int[][] map) {
		int pv = map[0][0];
		for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) if (map[i][j] != pv) return false;
		return true;
	}
	
	static int[][][] cut(int[][] map){
		final int size = map.length /2;
		int[][] map1 = new int[size][size];
		int[][] map2 = new int[size][size];
		int[][] map3 = new int[size][size];
		int[][] map4 = new int[size][size];
		
		for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) map1[i][j] = map[i][j];
		for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) map2[i][j] = map[i][j + size];
		for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) map3[i][j] = map[i + size][j];
		for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) map4[i][j] = map[i + size][j + size];
		
		return new int[][][] {map1, map2, map3, map4};
		
	}
}
