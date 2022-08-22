package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와_BFS {
	
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>(i);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
			Collections.sort(graph[a]);
			Collections.sort(graph[b]);
		}
		
		dfs(V, visited);
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(V, visited);
		System.out.println(sb);
	}

	private static void dfs(int root, boolean[] visited) {
		if (visited[root]) return;
		visited[root] = true; 
		sb.append(root + " ");
		for (int node: graph[root]) dfs(node, visited);
	}

	private static void bfs(int root, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if (visited[cur]) continue;
			visited[cur] = true;
			sb.append(cur + " ");
			for (int node: graph[cur]) q.offer(node);
		}
		sb.append("\n");
	}
}
