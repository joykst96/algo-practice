package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

public class BOJ_2252_줄_세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new List[V];
		int[] D = new int[V];
		for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertexA = Integer.parseInt(st.nextToken()) - 1; 
			int vertexB = Integer.parseInt(st.nextToken()) - 1;
			graph[vertexA].add(vertexB);
			++D[vertexB];
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < V; i++) if (D[i] == 0) q.offer(i);
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append((cur + 1)+ " ");
			for (int vertex: graph[cur]) if (--D[vertex] == 0) q.add(vertex);
		}
		System.out.println(sb);
	}
}
