package javatraining.com.veeriyaperumal.starter;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Stack;

public class Home {

	private static String[] getFileName(String directoryPath) {
		File folder = new File(directoryPath);
		return folder.list();
	}

	private static String initialPathSetUp() {
		try {
			return new File(".").getCanonicalPath() + "\\src\\javatraining\\com\\veeriyaperumal\\home";
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	private static boolean isValidChoice(String input, int totalOptionCount) {
		if (!input.matches("[0-9]+")) {
			System.out.println("Please enter the valid input.");
			return false;
		}
		int choice = Integer.parseInt(input);
		if (choice > totalOptionCount || choice < 1) {
			System.out.println("Please choose the valid option.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Scanner read = new Scanner(System.in);
		Stack<String> filePathStack = new Stack<>();
		String input = "", fileName = "";
		String directoryPath = initialPathSetUp();
		filePathStack.push(directoryPath);

		System.out.println("WELCOME TO MY PROGRAM");
		do {
			String[] listOfFiles = getFileName(directoryPath);
			for (int i = 0; i < listOfFiles.length; i++) {
				fileName = listOfFiles[i];
				if (fileName.contains(".java")) {
					System.out.println(i + 1 + "--->" + fileName.substring(0, fileName.indexOf('.')));
				} else {
					System.out.println(i + 1 + "--->" + fileName);
				}
				if (i + 1 == listOfFiles.length) {
					if (filePathStack.size() == 1) {
						System.out.println(i + 2 + "--->" + "Exit");
					} else {
						System.out.println(i + 2 + "--->" + "Go back");
					}
				}

			}
			System.out.print("Choose the above given choices : ");
			input = read.nextLine();
			if (!isValidChoice(input, listOfFiles.length + 1)) {
				continue;
			}
			int choice = Integer.parseInt(input);
			if (choice == listOfFiles.length + 1) {
				if (filePathStack.size() == 1) {
					System.out.println("Program terminates succesfully.Thank you see again.");
					return;
				}
				filePathStack.pop();
				directoryPath = filePathStack.peek();
			} else {
				fileName = listOfFiles[choice - 1];
				if (fileName.contains(".java")) {
					try {
						executeProgram(directoryPath, fileName);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
					continue;
				} else {
					directoryPath = directoryPath + "\\" + fileName;
					filePathStack.push(directoryPath);
				}
			}

		} while (true);

	}
	
	private static void executeProgram(String directoryPath, String className)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int index = directoryPath.indexOf("\\src\\");
		directoryPath = directoryPath.substring(index + 5) + "." + className.substring(0, className.lastIndexOf('.'));
		directoryPath = directoryPath.replace("\\", ".");

		try {
			Class obj = Class.forName(directoryPath);
			try {
				obj.getDeclaredMethod("myMain", null).invoke(obj, null);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("That program doesn't exist.");
		}
		return;

	}
	
}
