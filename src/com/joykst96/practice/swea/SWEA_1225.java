package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("data/SWEA_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		while (T != null) {
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int n = 4;
			int next;
			do {
				n = (n + 1) % 5;
				next = queue.poll();
				next = next <= n + 1 ? 0 : next - (n + 1);
				queue.offer(next);
			} while (next != 0);
			sb.append(String.format("#%s %s%n", T, queue.toString().replaceAll("[\\[|\\]|,]", "")));
			T = br.readLine();
		}
		System.out.println(sb);
	}
}
