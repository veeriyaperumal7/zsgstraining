package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern3 {
	private static void printPattern3(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length * 2 - 1; column++) {
				if (row == 1) {
					System.out.print("*");
				} else {
					if (column == row || column == (length * 2 - 1) - (row - 1)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
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
		printPattern3(n);
	}
}
