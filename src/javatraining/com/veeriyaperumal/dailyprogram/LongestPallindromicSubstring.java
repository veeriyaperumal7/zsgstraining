package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;

public class LongestPallindromicSubstring {
	String str;
	String result = "";

	public LongestPallindromicSubstring(String input) {
		this.str = input;
	}

	public static void main(String[] args) {
		System.out.print("Enter the string : ");
		Scanner read = new Scanner(System.in);
		LongestPallindromicSubstring obj = new LongestPallindromicSubstring(read.nextLine());
		System.out.println("The longest pallindrome in the given string is : " + obj.findLongestPallindromeApproach3());
	}

	private String findLongestPallindromeApproach1() {// Dynamic Programming
		byte dp[][] = new byte[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
		}
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				dp[i - 1][i] = 1;
			}
		}
		for (int i = 2; i < str.length(); i++) {
			for (int j = i, row = 0; j < str.length(); j++, row++) {
				if (str.charAt(j - i) == str.charAt(j)) {
					if (dp[row + 1][j - 1] == 1) {
						dp[row][j] = 1;
					}
				}
			}
		}
		int maxLen = 0, start = 0, end = 0;
		for (int row = 0; row < str.length(); row++) {
			for (int column = row + 1; column < str.length(); column++) {
				if (dp[row][column] == 1) {
					if (maxLen < column - row) {
						maxLen = column - row;
						start = row;
						end = column + 1;
					}
				}
			}
		}
		return (maxLen == 0) ? str.charAt(0) + "" : str.substring(start, end);
	}

	private String findLongestPallindromeApproach2() {// Brute Force
		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j > i; j--) {
				if (isPallindrome(i, j)) {
					return str.substring(i, j + 1);
				}
			}
		}
		return str.charAt(0) + "";
	}

	private boolean isPallindrome(int start, int end) {
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private String findLongestPallindromeApproach3() {
		getPallindrome(0, str.length() - 1, str);
		return (result.length() != 0) ? result : str.charAt(0) + "";
	}

	private void getPallindrome(int start, int end, String str) {
		if (start >= str.length() || end <= start) {
			if (start >= str.length()) {
				return;
			} else {
				getPallindrome(start + 1, str.length() - 1, str);
			}
		} else {
			if (isPallindrome(start, end)) {
				result = (str.substring(start, end + 1).length() > result.length()) ? str.substring(start, end + 1)
						: result;
			}
			getPallindrome(start, end - 1, str);
		}

	}

}
