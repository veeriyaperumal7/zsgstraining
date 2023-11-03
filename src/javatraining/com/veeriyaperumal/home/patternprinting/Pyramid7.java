package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pyramid7 {
	private static void printPyramid7(int length) {
		for (int row = 1; row <= length; row++) {
			for (int space = 1; space <= length - row; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= row; column++) {
				System.out.print(column + " ");
			}
			System.out.println();
		}
	}

	public static void myMain()  {
		int n = 0;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		n = read.nextInt();
		printPyramid7(n);
	}
}
