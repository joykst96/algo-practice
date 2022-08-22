package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5664 {
	static int[][] AP;
	static boolean[][][] APCover;
	static int[] A, B;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/SWEA_5664.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int AC = Integer.parseInt(st.nextToken());
			int[] moveA = new int[M + 1];
			int[] moveB = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) moveA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) moveB[i] = Integer.parseInt(st.nextToken());
			AP = new int[AC][4];
			for (int i = 0; i < AC; i++) {
				st = new StringTokenizer(br.readLine());
				AP[i][1] = Integer.parseInt(st.nextToken()) - 1;
				AP[i][0] = Integer.parseInt(st.nextToken()) - 1;
				AP[i][2] = Integer.parseInt(st.nextToken());
				AP[i][3] = Integer.parseInt(st.nextToken());
			}
			init(AP);
			for (int i = 0; i <= M; i++) {
				charge();
				move(moveA[i], A);
				move(moveB[i], B);
			}
			sb.append(String.format("#%d %d%n", t, sum));
		}
		System.out.print(sb);
	}


	private static void move(int i, int[] P) {
		switch (i) {
		case 0:	// 안움직임
			break;
		case 1:	// 위로
			--P[0];
			break;
		case 2:	// 오른쪽으로
			++P[1];
			break;
		case 3: // 아래로
			++P[0];
			break;
		case 4: // 왼쪽으로
			--P[1];
			break;
		}
	}
	
	private static void charge() {
		List<Integer> onA = new ArrayList<>();
		List<Integer> onB = new ArrayList<>();
		for (int i = 0; i < AP.length; i++) {
			if (APCover[i][A[0]][A[1]]) onA.add(i);
			if (APCover[i][B[0]][B[1]]) onB.add(i);
		}
		
		if (onA.size() + onB.size() == 0) return;
		if (onB.size() == 0) {
			int temp = 0;
			for (int a: onA) temp = Math.max(temp, AP[a][3]);
			sum += temp;
			return;
		}
		if (onA.size() == 0) {
			int temp = 0;
			for (int b: onB) temp = Math.max(temp, AP[b][3]);
			sum += temp;
			return;
		}
		int max = 0;
		for (int a: onA) for(int b: onB) {
			int temp = 0;
			if (a == b) {
				temp = AP[a][3];
				if (temp > max) max = temp;
			} else {
				temp = AP[a][3] + AP[b][3];
				if (temp > max) max = temp;
			}
		}
		sum += max;
	}


	private static void init(int[][] APs) {
		APCover = new boolean[APs.length][10][10];
		A = new int[] {0, 0};
		B = new int[] {9, 9};
		int idx = 0;
		sum = 0;
		for (int[] AP: APs) {
			int x = AP[0], y = AP[1], r = AP[2];
			for (int i = x - r, k = r; i <= x; i++, k--) {
				for(int j = y - r + k; j <= y + r - k; j++) {
					if (i < 0 || j < 0 || i >= 10 || j >= 10) continue;
					APCover[idx][i][j] = true;
				}
			}
			for (int i = x + 1, k = 1; i <= x + r; i++, k++) {
				for(int j = y - r + k; j <= y + r - k; j++) {
					if (i < 0 || j < 0 || i >= 10 || j >= 10) continue;
					APCover[idx][i][j] = true;
				}
			}
			++idx;
		}
	}
}