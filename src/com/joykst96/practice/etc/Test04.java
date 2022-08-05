package com.joykst96.practice.etc;

public class Test04 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		combination(nums, new boolean[nums.length], 0, 0, 3);
		
	}

	static void combination(int[] arr, boolean[] isSelected, int start, int depth, int r) {
		if (depth == r) {
			for (int i = 0; i < arr.length; i++) {
				if (isSelected[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				combination(arr, isSelected, i + 1, depth + 1, r);
				isSelected[i] = false;
			}
		}
	}
}
