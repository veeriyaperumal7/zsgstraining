package  javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.Scanner;

public class Pattern11 {
	private static void printPattern11(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void myMain() {
int n=0;
Scanner read = new Scanner(System.in);
System.out.print("Enter the number : ");
n=read.nextInt();
printPattern11(n);
}
}
