package arrayproblems;

import java.util.*;

public class PrintXPattern {

	private static Scanner read;

	static {
		read = new Scanner(System.in);
	}

	private static void printPattern(String str) {
		if (str.length() % 2 == 0) {
			System.out.println("0");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (j == i || j == (str.length() - 1) - i) {
					System.out.print(str.charAt(j));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter the string : ");
		String str = read.nextLine();
		printPattern(str);
	}
}
