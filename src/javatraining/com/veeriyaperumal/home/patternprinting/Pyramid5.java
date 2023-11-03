package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pyramid5 {
	private static void printPyramid5(int length) {
		for (int row = 1; row <= length; row++) {
			int count = 1;
			for (int column = 1; column <= length * 2 - 1; column++) {
				if (column > length - row) {   // For define start point of the row
					if (column <= length) { //Divide the the two part
						System.out.print(count + " ");
						count = (column != length) ? count + 1 : count;//After reach mid of the pattern row no need to increment
					} else {
						count--;
						if (column - length < row) {//print the second part of the row
							System.out.print(count + " ");
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
		printPyramid5(n);
	}
}
