package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17136_2 {
	static int[][] map;
	static int[][] cumsum;
	static boolean[][] isFill;
	static int[] paper = {5, 5, 5, 5, 5};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];
		int toFill = 0;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) ++toFill;
			}
		}
		// 누적합 행렬
		cumsum = new int[10][10];
		// 원배열 복사
		for (int i = 0; i < 10; i++) for(int j = 0; j < 10; j++) cumsum[i][j] = map[i][j];
		// 행의 누적합 적용
		for (int i = 0; i < 10; i++) for (int j = 1; j < 10; j++) cumsum[i][j] += cumsum[i][j - 1];
		// 열의 누적합 적용
		for (int i = 1; i < 10; i++) for (int j = 0; j < 10; j++) cumsum[i][j] += cumsum[i - 1][j];
		
		isFill = new boolean[10][10];
		dfs(toFill);
		System.out.println(min);
	}
	
	static void dfs(int toFill) {
		if (toFill <= 5) {
			System.out.println(1);
			int consume = toFill;
			for (int i = 0; i < 5; i++) consume +=  5 - paper[i];
			if (min > consume) min = consume;
			return;
		}
		for (int i = 0; i < 10; i++) for (int j = 0; j < 10; j++) if (map[i][j] == 1) {
			for (int size = 4; size >= 0; size--) {
				if (paper[size] != 0 && isAttach(i, j, size)) {
					toFill = attach(i , j, size, toFill);
					dfs(toFill);
					toFill = detach(i, j, size, toFill);
				}
			}
			return;
		}
	}
	
	static int attach(int x, int y, int size, int toFill) {
		for (int i = x; i <= x + size; i++) for (int j = y; j <= y + size; j++) isFill[i][j] = true;
		toFill -= getArea(x, y, size);
		return toFill;
	}
	
	static int detach(int x, int y, int size, int toFill) {
		for (int i = x; i <= x + size; i++) for (int j = y; j <= y + size; j++) isFill[i][j] = false;
		toFill += getArea(x, y, size);
		return toFill;
	}

	static boolean isAttach(int x, int y, int size) {
		for (int i = x; i <= x + size; i++) for (int j = y; j <= y + size; j++) if (isFill[i][j]) return false;
		if (getArea(x, y, size) == (size + 1) * (size + 1)) return true;
		return false;
	}
	
	static int getArea(int x, int y, int size) {
		// 누적합 가져오기
		int area = cumsum[x + size][y + size];
		// 중복부분 빼기
		if (x - 1 >= 0) area -= cumsum[x - 1][y + size];
		if (y - 1 >= 0) area -= cumsum[x + size][y - 1];
		// 이중중복부분 더하기
		if (x - 1 >= 0 && y - 1 >= 0) area += cumsum[x - 1][y - 1];
		return area;
	}
	
	static boolean isIn(int x, int y, int size) {
		return x + size >= 10 || y + size >= 10 ? true : false;
	}
}
