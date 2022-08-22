package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치_켜고_끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] switches = new int[n]; 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[][] actions = new int[m][2];
		for (int i = 0; i < actions.length; i++) {
			st = new StringTokenizer(br.readLine());
			actions[i][0] = Integer.parseInt(st.nextToken());
			actions[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		for (int[] action: actions) {
			int cur = action[1];
			switch (action[0]) {
			case 1:
				// 남학생
				for (int i = cur; i < switches.length; i += cur + 1) {
					switches[i] = switches[i] == 0 ? 1 : 0;
				}
				break;
			case 2:
				// 여학생
				switches[cur] = switches[cur] == 0 ? 1 : 0;
				for (int i = 1; i < switches.length; i++) {
					if (cur - i < 0 || cur + i >= switches.length || switches[cur - i] != switches[cur + i]) break;
					switches[cur - i] = switches[cur - i] == 0 ? 1 : 0;
					switches[cur + i] = switches[cur + i] == 0 ? 1 : 0;
				}
				break;
			}
		}
		for (int i = 0; i < switches.length; i++) {
			if ((i + 1) % 20 == 0) {
				System.out.println(switches[i]);
			} else {
				System.out.printf("%d ", switches[i]);
			}
		}
	}
}
