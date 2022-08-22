package com.joykst96.practice.swea;

import java.util.*;
import java.io.*;

public class SWEA_1238_Contact {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/SWEA_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			// 인접 리스트로 구현
			List<Integer>[] graph = new List[101];
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				if (graph[idx] == null) graph[idx] = new ArrayList<>();
				graph[idx].add(value);
			}
			// 입력 끝
			
			// BFS로 구현
			boolean[] visited = new boolean[101];
			Queue<Integer> q = new LinkedList<>();
			q.add(start); // 시작점 지정
			int lastFreind = start; // 마지막으로 전화를 받은사람(중에 제일 숫자가 큰사람)
			while(!q.isEmpty()) {
				PriorityQueue<Integer> called = new PriorityQueue<>((i1, i2) -> -Integer.compare(i1, i2)); // 마지막으로 전화를 받은사람들을 최대힙에 넣음
				for (int s = 0, S = q.size(); s < S; s++) {
					int cur = q.poll();
					if (visited[cur]) continue; // 전화를 받았던 사람이면 건너뜀
					visited[cur] = true; // 전화 받았음을 기억
					called.offer(cur); // 전화 받은사람을 힙에 넣음
					if (graph[cur] != null) for (int i: graph[cur]) q.offer(i); // 연락망이 닿는 사람에게 모두 연락
				}
				if (!called.isEmpty()) lastFreind = called.poll(); // 힙이 비어있지않다면 제일 숫자가 큰 사람을 마지막으로 전화받은사람으로 지정
			}
			sb.append(String.format("#%d %d%n", t, lastFreind)); // 출력
		}
		System.out.print(sb);
	}
}
