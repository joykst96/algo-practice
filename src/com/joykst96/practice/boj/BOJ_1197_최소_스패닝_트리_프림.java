package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

public class BOJ_1197_최소_스패닝_트리_프림 {
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
		int[] minWeight = new int[V];
		Arrays.fill(minWeight, INF);
		minWeight[0] = 0;
		
		for (int i = 0; i < V; i++) {
			int minW = INF, minV = 0;
			for (int j = 0; j < V; j++) if (!check[j] && minW > minWeight[j]) {
				minW = minWeight[j];
				minV = j;
			}
			
			ans += minW;
			check[minV] = true;
			
			for (Edge edge: graph[minV]) if (!check[edge.to] && edge.weight < minWeight[edge.to]) {
				minWeight[edge.to] = edge.weight;
			}
		}
		
		System.out.println(ans);
	}
}
