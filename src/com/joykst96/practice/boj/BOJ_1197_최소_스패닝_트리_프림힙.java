package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BOJ_1197_최소_스패닝_트리_프림힙 {
	static class Edge implements Comparable<Edge> {
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Edge>[] graph = new List[V];
		for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertexA = Integer.parseInt(st.nextToken()) - 1;
			int vertexB = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			graph[vertexA].add(new Edge(vertexB, weight));
			graph[vertexB].add(new Edge(vertexA, weight));
		}
		
		int ans = 0;
		boolean[] check = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		check[0] = true;
		for (Edge edge: graph[0]) pq.add(edge);
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (!check[edge.to]) {
				for (Edge next: graph[edge.to]) if (!check[next.to]) pq.add(next);
				check[edge.to] = true;
				ans += edge.weight;
			}
		}
		
		
		System.out.println(ans);
	}
}
