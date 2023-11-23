package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;

public class JumbledNumber {
	private int number;

	public JumbledNumber(int n) {
		this.setNumber(n);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void changeIntoPositiveNumber() {
		setNumber(~getNumber() + 1);// We use complement operator to change a negative number into positive number.
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int input = read.nextInt();
		JumbledNumber num = new JumbledNumber(input);
		if (input < 0) {
			num.changeIntoPositiveNumber();
		}
		if (num.isJumbledNumberApproch2()) {
			System.out.print(num.getNumber() + " is a jumbled number.");
		} else {
			System.out.print(num.getNumber() + " is not a jumbled number.");
		}
	}

	private boolean isJumbledNumberApproch1() {// Approach 1
		// Number changed into string and iterate to throw every character then find the
		// difference.
		String num = String.valueOf(number);
		for (int i = 1; i < num.length(); i++) {
			if ((int) num.charAt(i - 1) - (int) num.charAt(i) == 1
					|| (int) num.charAt(i - 1) - (int) num.charAt(i) == -1 || num.charAt(i - 1) == num.charAt(i)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isJumbledNumberApproch2() {// Approach 2
		// Number was separated by each number in digits and find out is jumbled number
		// or not.
		int n = number;
		int previousNumber = n % 10;
		n /= 10;
		while (n != 0) {
			if (Math.abs(n % 10 - previousNumber) > 1) {
				return false;
			}
			previousNumber = n % 10;
			n /= 10;
		}
		return true;
	}

	private boolean isJumbledNumberApproch3() {// Approach 3
		// Recursive approach
		return isJumbledNumber(number);
	}

	private boolean isJumbledNumber(int number) {
		// Here also we do a like a approach 2.But we use here recursion.Recursion
		if (number < 10) {// When come into one digit we return.Previous stack check the number is jumbled
							// or not.
			return true;
		}
		int num1 = number % 10, num2 = (number / 10) % 10;
		if (isJumbledNumber(number / 10)) {
			if (Math.abs(num1 - num2) > 1) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

}
