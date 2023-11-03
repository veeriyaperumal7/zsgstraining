package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern12 {

	private static void printPattern12(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				if (column == 1 || column == length || row == 1 || row == length) {
					System.out.print("*");
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
		printPattern12(n);
	}

}
