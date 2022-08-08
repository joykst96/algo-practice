package com.joykst96.practice.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1230 {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("data/SWEA_1230.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int srcLen = Integer.parseInt(br.readLine());
			List<Integer> src = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < srcLen; i++) {
				src.add(Integer.parseInt(st.nextToken()));
			}
			int task = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < task; i++) {
				char type = st.nextToken().charAt(0);
				int target = Integer.parseInt(st.nextToken());
				int count;
				int[] contents;
				switch (type) {
				case 'I':
					count = Integer.parseInt(st.nextToken());
					contents = new int[count];
					for (int j = count - 1; j >= 0; j--) {
						contents[j] = Integer.parseInt(st.nextToken());
					}
					for (int content: contents) src.add(target, content);
					break;
				case 'D':
					count = Integer.parseInt(st.nextToken());
					for (int j = 0; j < count; j++) {
						src.remove(target);
					}
					break;
				case 'A':
					contents = new int[target];
					for (int j = target - 1; j >= 0; j--) {
						contents[j] = Integer.parseInt(st.nextToken());
					}
					for (int content: contents) src.add(content);
					break;
				}
			}
			sb.append("#" + t + " ");
			for (int i: src.subList(0, 10)) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
