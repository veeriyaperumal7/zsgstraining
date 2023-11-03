package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pyramid3 {
	private static void printPyramid3(int length) {
		for (int i = length; i >= 1; i--) {
			for (int column = 1; column <= length; column++) {
				if (column > length - i) {// Define start point of the row
					System.out.print("* ");
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
		printPyramid3(n);
	}
}
