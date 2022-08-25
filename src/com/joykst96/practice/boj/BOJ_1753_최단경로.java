package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
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
		final int INF = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;
		List<Edge>[] graph = new List[V];
		for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int vertexA = Integer.parseInt(st.nextToken()) - 1;
			int vertexB = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			graph[vertexA].add(new Edge(vertexB, weight));
		}
		
		boolean[] check = new boolean[V];
		int[] minWeight = new int[V];
		Arrays.fill(minWeight, INF);
		minWeight[start] = 0;
		for (int i = 0; i < V; i++) {
			int minW = INF,  minV = -1;
			for (int j = 0; j < V; j++) if (!check[j] && minW > minWeight[j]) {
				minW = minWeight[j];
				minV = j;
			}
			
			if (minV == -1) continue;
			check[minV] = true;
			
			for (Edge edge: graph[minV]) if (!check[edge.to] && minWeight[edge.to] > minWeight[minV] + edge.weight) {
				minWeight[edge.to] = minWeight[minV] + edge.weight;
			}
		}
		for (int ans: minWeight) sb.append((ans == INF ? "INF" : ans) + "\n");
		System.out.print(sb);
	}
}
