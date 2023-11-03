package javatraining.com.veeriyaperumal.home.dsa;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void myMain() {
		getInput();
	}

	private static void getInput() {
		Scanner read = new Scanner(System.in);
		System.out.print(
				"Note : Your 1st digit of a number represent it is positive or negative if give 1 that is negative and 0 that is positive.\nEnter the binary number : ");
		String binaryString = read.nextLine();
		convertIntoDecimal(binaryString);
	}

	private static void convertIntoDecimal(String binaryString) {
		int decimalValue = 0;
		int baseValue = 1;
		while (binaryString.length() != 0) {
			if (binaryString.charAt(binaryString.length() - 1) != '1'
					&& binaryString.charAt(binaryString.length() - 1) != '0') {
				System.out.print("Binary value contains only '0' and '1'.Input mismatched program terminated.");
				return;
			}
			if (binaryString.length() == 1 && binaryString.charAt(0) == '1') {
				decimalValue = ~decimalValue;
				decimalValue += 1;
				break;
			}
			if (binaryString.charAt(binaryString.length() - 1) == '1') {
				decimalValue += baseValue;
			}
			baseValue *= 2;
			binaryString = binaryString.substring(0, binaryString.length() - 1);
		}
		System.out.println("The decimal value of given binary is : " + decimalValue);
	}

}
