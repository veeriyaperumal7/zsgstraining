package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern4 {

	private static void printPattern4(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length * 2 - 1; column++) {
				if (row == length) {
					System.out.print("*");
				} else {
					if (column == (length + 1) - row || column == (length - 1) + row) {
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
		printPattern4(n);
	}

}
