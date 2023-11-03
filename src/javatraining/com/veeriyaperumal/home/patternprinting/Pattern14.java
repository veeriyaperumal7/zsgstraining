package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern14 {
	private static void printPattern14(int length) {
		for (int left = 1, right = length * 2; left <= length * 2; left++, right--) {
			if (right + 1 == left) {// To avoid mid line printing two times
				continue;
			}
			for (int column = 1; column <= length * 2; column++) {
				if (left <= length) { // For printing above half block
					if (column <= left || column >= right) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					if (column <= right || column >= left) { // For printing below half block
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

	public static void myMain() {
		int n = 0;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		n = read.nextInt();
		printPattern14(n);
	}
}
