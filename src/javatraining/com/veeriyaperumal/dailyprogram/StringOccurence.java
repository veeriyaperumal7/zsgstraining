package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class StringOccurence {

	private String input;
	private static Scanner read;

	static {
		read = new Scanner(System.in);
	}

	public StringOccurence(String input) {
		this.setInput(input);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public static void main(String[] args) {
		System.out.print("Enter the String : ");
		StringOccurence obj = new StringOccurence(read.nextLine());
		obj.sortApproach1();
		System.out.println("Occurrence of the string is  : " + obj.sortApproach1());
	}

	private String sortApproach1() {// Store the frequency of the string in a integer array.
									// Time O(2n) Space O(26).
		int frequency[] = new int[26];
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				frequency[input.charAt(i) - 65]++;
			} else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				frequency[input.charAt(i) - 97]++;
			} else {
				return "String contains only alphabets.";
			}
		}
		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				if (frequency[input.charAt(i) - 65] < 1) {
					continue;
				} else {
					result += String.valueOf(input.charAt(i)) + String.valueOf(frequency[input.charAt(i) - 65]);
					frequency[input.charAt(i) - 65] = 0;
				}
			} else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				if (frequency[input.charAt(i) - 97] < 1) {
					continue;
				} else {
					result += String.valueOf(input.charAt(i)) + String.valueOf(frequency[input.charAt(i) - 97]);
					frequency[input.charAt(i) - 97] = 0;
				}
			}
		}
		return result;
	}

	private String sortApproach2() {// Store the frequency of the Hashmap.
		                            // Time O(2n) Space O(n).
		HashMap<Character, Integer> map = new HashMap<>();
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (!map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), 1);
			} else {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			}
		}
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				result += input.charAt(i) + String.valueOf(map.get(input.charAt(i)));
				map.remove(input.charAt(i));
			}
		}
		return result;
	}

	private String sortApproach3() {// Brute force approach
									// Time O(n^2) Space O(1).
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (result.contains(String.valueOf(input.charAt(i)))) {
				continue;
			}
			int count = 0;
			for (int j = i; j < input.length(); j++) {
				if (input.charAt(j) == input.charAt(i)) {
					count++;
				}
			}
			result += input.charAt(i) + String.valueOf(count);
		}
		return result;
	}

}
