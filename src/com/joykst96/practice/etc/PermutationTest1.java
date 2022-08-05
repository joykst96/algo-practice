package com.joykst96.practice.etc;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest1 {
	
	static int N, R, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		isSelected = new boolean[N+1]; // 수가 1부터 시작해서 인덱스도 1부터 논리적 매칭 사용
		
		perm(0);
		sb.append("총 경우의 수: " + totalCnt + "\n");
		System.out.println(sb);
	}
	
	public static void perm(int cnt) {
		if (cnt == R) {
			totalCnt++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}
