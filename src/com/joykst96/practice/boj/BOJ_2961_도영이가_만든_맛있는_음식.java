package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가_만든_맛있는_음식 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] ingredients = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(subSet(ingredients));
	}

	private static int subSet(int[][] ingredients) {
		int n = ingredients.length;
		int tasteTier = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << n); i++) {
			int sour = 1;
			int sweet = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0){
					sour *= ingredients[j][0];
					sweet += ingredients[j][1];
				}
			}
			int tmp = Math.abs(sour - sweet);
			if (tasteTier > tmp) tasteTier = tmp;
		}
		return tasteTier;
	}
}
