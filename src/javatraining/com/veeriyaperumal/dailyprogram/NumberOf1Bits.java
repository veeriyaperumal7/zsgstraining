package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;

public class NumberOf1Bits {
	private int number;

	public NumberOf1Bits(int binary) {
		this.number = binary;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("To find number of 1 bits in given decimal number.\nEnter the decimal number : ");
		NumberOf1Bits obj = new NumberOf1Bits(read.nextInt());
		System.out.println("The number of 1 bits in given number is : " + obj.countNumberOf1BitsApproach1());
	}

	private int countNumberOf1BitsApproach1() {
		int count = 0, n = number;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	private int countNumberOf1BitsApproach2() {
		String bin = Integer.toBinaryString(number);
		int i = bin.length() - 1, count = 0;
		while (i >= 0) {
			if (bin.charAt(i) == '1') {
				count++;
			}
			i--;
		}
		return count;
	}

	private int countNumberOf1BitsApproach3() {
		return count(number);
	}

	private int count(int number) {
		if (number == 0) {
			return 0;
		}
		return 1 + count(number & (number - 1));
	}
}
