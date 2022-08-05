package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/SWEA_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>();
			br.readLine();
			char[] tasks = br.readLine().toCharArray();
			outer: for (char task: tasks) {
				switch (task) {
				case ')':
					if (stack.peek() != '(') break outer; 
					stack.pop();
					break;
				case ']':
					if (stack.peek() != '[') break outer; 
					stack.pop();
					break;
				case '}':
					if (stack.peek() != '{') break outer; 
					stack.pop();
					break;
				case '>':
					if (stack.peek() != '<') break outer; 
					stack.pop();
					break;
				default: 
					stack.push(task);
				}
			}
			sb.append(String.format("#%d %d%n", t, stack.isEmpty() ? 1 : 0));
		}
		System.out.println(sb);
		
	}
}
