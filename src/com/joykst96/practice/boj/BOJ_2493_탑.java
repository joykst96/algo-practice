package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> idx = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		int[] towers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
			idx.put(towers[i], i + 1);
		}
		stack.push(towers[0]);
		sb.append("0 ");
		for(int i = 1; i < towers.length; i++) {
			if (stack.peek() > towers[i]) {
				sb.append(idx.get(stack.peek()) + " ");
				stack.push(towers[i]);
			} else {
				while (!stack.isEmpty() && stack.peek() < towers[i]) stack.pop();
				if (stack.isEmpty()) {
					sb.append("0 ");
					stack.push(towers[i]);
				} else {
					sb.append(idx.get(stack.peek()) + " ");
					stack.push(towers[i]);
				}
			}
		}
		System.out.println(sb);
	}
}
