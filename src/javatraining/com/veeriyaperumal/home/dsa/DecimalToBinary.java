package javatraining.com.veeriyaperumal.home.dsa;

import java.util.Scanner;

public class DecimalToBinary {
	public static void myMain() {
		getInput();
	}

	private static void getInput() {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the decimal number : ");
		int decimalNumber = read.nextInt();
		convertIntoBinary(decimalNumber);
	}

	private static void convertIntoBinary(int decimalNumber) {
		String binaryString = "";
		boolean isNegative=false;
		if(decimalNumber<0) {
			decimalNumber = ~decimalNumber;
			decimalNumber +=1;
			isNegative=true;
		}
		while (decimalNumber != 0) {
			binaryString =  decimalNumber%2 +" "+ binaryString;
			decimalNumber=decimalNumber/2;
		}
		if(isNegative) {
			binaryString = "1" +" "+ binaryString;
		}else {
			binaryString = "0" +" "+ binaryString;
		}
		System.out.println("Note  : The left 1st bit represent the positive number or negative number.\nThe binary value of given decimal number value is : " + binaryString);
	}
}
