package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern7 {
	private static void printPattern7(int length) {
		for (int row = 1; row <= length * 2; row++) {
			int columnEnd = (row <= length) ? row : length - (row - length);
			/*
			 * For first half of the pattern true part value will be assigned. For second
			 * half of the pattern false part value will be assigned. Because row value will
			 * be goes to length * 2 on that case row will be greater than length,so we need
			 * to handle that part row based value when we used.
			 */
			for (int column = 1; column <= columnEnd; column++) {
				if (column == 1 || column == columnEnd) {
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
		printPattern7(n);
	}
}
