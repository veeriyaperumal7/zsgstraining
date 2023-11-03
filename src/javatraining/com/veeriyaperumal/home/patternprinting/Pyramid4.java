package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pyramid4 {
	private static void printPyramid4(int length) {
		for (int row = length; row >= 1; row--) {
			for (int column = 1; column <= length * 2; column++) {
				if (column >= row) { // For define start point of the row
					if (column <= length) {// Divide the the two part of row
						System.out.print(column + " ");
					} else {
						if (length - (column - length) >= row) {// print the second part of the row
							System.out.print(length - (column - length) + " ");
						} else {
							break;
						}
					}
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
		printPyramid4(n);
	}
}
