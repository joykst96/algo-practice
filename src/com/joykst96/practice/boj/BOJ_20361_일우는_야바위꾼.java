package com.joykst96.practice.boj;

import java.util.*;
import java.io.*;

public class BOJ_20361_일우는_야바위꾼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] tasks = new int[K][];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			tasks[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		int[] cups = new int[N + 1];
		cups[X] = 1;
		for (int[] task: tasks) {
			int A = task[0];
			int B = task[1];
			cups[A] = cups[A] ^ cups[B];
			cups[B] = cups[A] ^ cups[B];
			cups[A] = cups[A] ^ cups[B];
		} 
		int ans = -1;
		for (int i = 0; i < cups.length; i++) if(cups[i] == 1) {
			ans = i;
			break;
		}
		System.out.print(ans); // 정답 출력
	}
}
