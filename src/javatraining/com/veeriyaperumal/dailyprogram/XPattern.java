package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;

public class XPattern {

	private String input;
	private static Scanner read;

	static {
		read = new Scanner(System.in);
	}

	public XPattern(String input) {
		this.setInput(input);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public static void main(String[] args) {
		System.out.print("Enter the string to print in X Pattern : ");
		XPattern obj = new XPattern(read.nextLine());
		System.out.println("Odd length string only print correct order.");
		obj.printXPatternApproach1();
	}

	private void printXPatternApproach1() { // Using 2 loops
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if (j == i || j == input.length() - 1 - i) {
					System.out.print(input.charAt(j));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	private void printXPatternApproach2() { // Using 1 loop with matrix
		char matrix[][] = new char[input.length()][input.length()];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = input.charAt(i);
			matrix[i][matrix.length - 1 - i] = input.charAt(i);
		}
		for (char[] arr : matrix) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}

	private void printXPatternApproach3() {// Using Recursion
		char matrix[][] = new char[input.length()][input.length()];
		generatePattern(0, matrix, input);
		for (char[] arr : matrix) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}

	private void generatePattern(int row, char[][] matrix, String str) {
		if (row >= str.length()) {
			return;
		}
		generatePattern(row + 1, matrix, str);
		matrix[row][row] = str.charAt(row);
		matrix[row][str.length() - 1 - row] = str.charAt(str.length() - 1 - row);
	}

}
