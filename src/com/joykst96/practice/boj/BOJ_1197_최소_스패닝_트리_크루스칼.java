package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

public class BOJ_1197_최소_스패닝_트리_크루스칼 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] p;
	
	static void make(int V) {
		p = new int[V];
		for (int i = 0; i < V; i++) p[i] = i;
	}
	
	static int find(int a) {
		return a == p[a] ? a : (p[a] = find(p[a]));
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		p[b] = a;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edgeList);
		make(V);
		
		int ans = 0;
		int cnt = 0;
		for (Edge edge: edgeList) {
			if (union(edge.from, edge.to)) {
				ans += edge.weight;
				if (++cnt == V - 1) break;
			}
		}
		
		System.out.println(ans);
	}
}
