package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern10 {
	private static void printPattern10(int length) {
		int left = length * 2 / 2, right = (length * 2 / 2) + 1;// left and right pointer sets
		for (int row = 1; row <= length * 2; row++) {
			for (int column = 1; column <= length * 2; column++) {
				if (column <= left || column >= right) {// print the values before the left and
														// after the right pointer.
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			if (row < length) {// First half of the pattern pointer increment,decrement happened.
				left--;
				right++;
			} else {
				if (row != length) {// For check mid of the pattern reached or not reached.
					left++;
					right--;
				} else {// Set the values to pointer for next below half will be print.
					left = 1;
					right = length * 2;
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
		printPattern10(n);
	}
}
