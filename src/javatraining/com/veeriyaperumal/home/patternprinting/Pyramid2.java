package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pyramid2 {
	private static void printPyramid2(int length) {
		for (int row = length; row >= 1; row--) {
			for (int column = 1; column <= length; column++) {
				if (column > length - row) {// Define a start point of the row
					System.out.print(row + " ");
				} else {
					System.out.print(" ");
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
		printPyramid2(n);
	}
}
