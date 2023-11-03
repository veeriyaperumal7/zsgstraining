package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern5 {
	private static void printPattern5(int length) {
		for (int row = 0; row < length; row++) {
			for (int column = 1; column <= length + row; column++) {
				if (row == 0) {
					System.out.print("*");
				} else {
					if (column == row || column == length + row || row == length - 1 && column >= row) {
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
		printPattern5(n);
	}
}
