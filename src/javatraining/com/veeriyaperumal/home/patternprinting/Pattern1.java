package  javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.*;

public class Pattern1 {
	private static void printPattern1(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				if (row == 1) {
					System.out.print("*");
				} else {
					if (row == column || column == length) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	public static void myMain() {
		int n = 0;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		n = read.nextInt();
		read.close();
		printPattern1(n);
	}
}
