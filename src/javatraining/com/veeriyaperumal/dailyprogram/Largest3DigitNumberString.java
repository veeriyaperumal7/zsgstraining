package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Scanner;

/*LeetCode  2264. Largest 3-Same-Digit Number in String 
Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 */

public class Largest3DigitNumberString {
	private static Scanner read = new Scanner(System.in);
	private String number;

	public Largest3DigitNumberString(String number) {
		this.number = number;
	}

	public static void main(String[] args) {
		System.out.print("Enter the number string : ");
		Largest3DigitNumberString obj = new Largest3DigitNumberString(read.nextLine());
		System.out.println(
				"The largest 3 digit number in the given string : " + obj.largestGoodIntegerApproach1(obj.number));
	}

	private String largestGoodIntegerApproach1(String num) {
		int count = 1;
		char max = '0';
		boolean isFound = false;
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(i - 1) == num.charAt(i)) {
				count++;
			} else {
				count = 1;
			}
			if (count == 3) {
				isFound = true;
				max = (num.charAt(i) > max) ? num.charAt(i) : max;
				count = 1;
			}
		}
		return (isFound) ? "" + max + max + max : "";
	}

	private String largestGoodIntegerApproach2(String num) {
		for (int i = 999; i > 0; i -= 111) {
			if (num.indexOf(String.valueOf(i)) != -1) {
				int index = num.indexOf(String.valueOf(i));
				return num.substring(index, index + 3);
			}
		}
		return (num.contains("000")) ? "000" : "";
	}

	private String largestGoodIntegerApproach3(String num) {
		String result = "";
		for (int i = 2; i < num.length(); i++) {
			if (num.charAt(i - 1) == num.charAt(i) && num.charAt(i - 2) == num.charAt(i)) {
				if (result == "") {
					result = num.substring(i - 2, i + 1);
				} else {
					result = (Integer.parseInt(result) > Integer.parseInt(num.substring(i - 2, i + 1))) ? result
							: num.substring(i - 2, i + 1);
				}
			}
		}
		return result;
	}

}
