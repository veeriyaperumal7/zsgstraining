package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern13 {
	private static void printPattern13(int length) {
		for (int left = 1; left <= length * 2 - 1; left++) {
			int end = (left <= length) ? (length - left) + 1 : ((left + 1) - length);// Define the end of the column by
																						// rows value.
			for (int space = 1; space <= length - end; space++) {
				System.out.print(" ");
			}
			for (int right = 1; right <= end; right++) {
				if (left == 1 || left == length * 2 - 1) { // First and last row full column print
					System.out.print("* ");
					continue;
				}
				if (right == 1 || right == end) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void myMain()  {
		int n = 0;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		n = read.nextInt();
		printPattern13(n);
	}
}
