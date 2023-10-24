package arrayproblems;

import java.util.Scanner;

public class FindGrandChildren {
	private static int rows;
	private static String grandParentName;
	private static Scanner read;

	static {
		read = new Scanner(System.in);
	}
	private static void getInput(String family[][]) {
		for (int i = 0; i < rows; i++) {
			for (int j = 1; j >= 0; j--) {
				if (j == 0) {
					System.out.print("Enter the " + (i + 1) + " generation children  name : ");
					family[i][j] = read.nextLine();
				} else {
					System.out.print("Enter the " + (i + 1) + " generation parent  name : ");
					family[i][j] = read.nextLine();
				}
			}
		}
		System.out.print("Enter the Grandfather name : ");
		grandParentName = read.nextLine();
	}

	private static String getChildrenName(String family[][]) {
		for (int i = 0; i < rows; i++) {
			for (int j = 1; j >= 0; j--) {
				if (grandParentName.equals(family[i][j])) {
						return family[i][0];
				}
			}
		}
		return "";
	}
	
	private static int getGrandChildrenCount(String family[][],String parentName) {
		int count =0;
		for(int i=0;i<rows;i++) {
			if(family[i][1].equals(parentName)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.print("Enter the rows of family : ");
		rows = read.nextInt();
		read.nextLine();// if we read input int and get string input immediately new line will be
						// capture as a input for string.So that new line will be capture by
						// read.nextLine() to avoid our string input will be empty.
		if (rows < 1) {
			System.out.print("Family rows must be greater than 0!!!");
			return;
		}
		String[][] family = new String[rows][2];
		getInput(family);
		System.out.println();
		System.out.println("Here " + grandParentName + " has " + getGrandChildrenCount(family,getChildrenName(family)) + " grandchildren");
	}
}
