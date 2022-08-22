package com.joykst96.practice.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO_1828_냉장고 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int lowT = Integer.parseInt(st.nextToken());
			int highT = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {lowT, highT});
		}
		int[] product = pq.poll();
		int ref = 1;
		int highT = product[1];
		while (!pq.isEmpty()) {
			product = pq.poll();
			if (product[0] > highT) {
				highT = product[1];
				++ref;
			}
		}
		System.out.println(ref);
	}
}
