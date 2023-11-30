package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;

public class StringReverse {
	private String string;

	public StringReverse(String string) {
		this.string = string;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the string to reverse : ");
		StringReverse obj = new StringReverse(read.nextLine());
		System.out.println("After string reverse : " + obj.reverseStringApproach1());
	}

	private String reverseStringApproach1() {
		String str = "";
		for (int i = 0; i < string.length(); i++) {
			str = string.charAt(i) + str;
		}
		return str;
	}

	private String reverseStringApproach2() {
		return getReverse(0, string);
	}

	private String reverseStringApproach3() {
		StringBuffer sbf = new StringBuffer(string);
		return sbf.reverse().toString();
	}

	private String getReverse(int i, String string) {
		if (i >= string.length()) {
			return "";
		}
		return getReverse(i + 1, string) + string.charAt(i);
	}

}
