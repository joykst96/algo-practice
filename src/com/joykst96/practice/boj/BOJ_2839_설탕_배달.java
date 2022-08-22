package com.joykst96.practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		while(N > 0) {
			if (N % 15 == 0) {
				ans += 3;
				N -= 15;
			}
			else if (N % 5 == 0) {
				N -= 5;
				++ans;
			}
			else if (N % 3 == 0) {
				N -= 3;
				++ans;
			} else if (N >= 5) {
				N -= 5;
				++ans;
			} else if (N >= 3) {
				N -= 3;
				++ans;
			} else {
				System.out.println(-1);
				break;
			}
		}
		if (N == 0) System.out.println(ans);
	}
}
