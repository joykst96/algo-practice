package com.joykst96.practice.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSetTest {
	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(totalCnt);
		
		
	}
	
	private static void subset(int index) {
		if (index == N) {
			++totalCnt;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X");
				System.out.print("\t");
			}
			System.out.println("\n");
			return;
		}
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1);
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);
	}
}
