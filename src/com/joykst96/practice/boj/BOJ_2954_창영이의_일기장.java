package com.joykst96.practice.boj;

import java.io.*;

public class BOJ_2954_창영이의_일기장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		line = line.replace("apa", "a");
		line = line.replace("epe", "e");
		line = line.replace("ipi", "i");
		line = line.replace("opo", "o");
		line = line.replace("upu", "u");
		System.out.println(line);
	}
}
