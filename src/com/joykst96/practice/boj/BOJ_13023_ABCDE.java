package com.joykst96.practice.boj;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 인접 리스트로 구현
		List<Integer>[] graph = new List[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			// 양방향 연결
			st = new StringTokenizer(br.readLine());
			int vertexA = Integer.parseInt(st.nextToken());
			int vertexB = Integer.parseInt(st.nextToken());
			graph[vertexA].add(vertexB);
			graph[vertexB].add(vertexA);
		}
		// 입력 끝
		boolean isPossible = false;
		// 정점별 연결된 정점 탐색
		for (int i = 0; i < N; i++) if (dfs(i, 0, new boolean[N], graph)) {
			// 연결된 정점이 4개 이상일때 조건을 만족한다고 판단
			isPossible = true;
			break;
		}
		System.out.println(isPossible ? 1 : 0);
	}

	private static boolean dfs(int vertex, int depth, boolean[] visited, List<Integer>[] graph) {
		// 연결된 정점이 4개 이상일때 true반환
		if (visited[vertex]) return false; // 무한 싸이클에 빠지는것을 방지
		if (depth == 4) return true;
		visited[vertex] = true;
		for (int next: graph[vertex]) if (dfs(next, depth + 1, visited, graph)) return true;
		visited[vertex] = false;
		return false;
	}
}
