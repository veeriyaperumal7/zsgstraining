package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern6 {
	private static void printPattern6(int length) {
		for (int row = 1; row <= length; row++) {
			for (int space = 1; space <= length - row; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= length; column++) {
				if (row == 1 || row == length) {
					System.out.print("*");
				} else {
					if (column == 1 || column == length) {
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
		printPattern6(n);
	}
}
