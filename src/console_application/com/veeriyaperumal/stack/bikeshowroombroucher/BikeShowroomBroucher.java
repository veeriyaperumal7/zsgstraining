package console_application.com.veeriyaperumal.stack.bikeshowroombroucher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class UserOption {
	private int level;
	private String option, bikeName;

	public UserOption(int level, String option) {
		this.level = level;
		this.option = option;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
}

public class BikeShowroomBroucher {
	private static JSONObject jsonObject;
	private static JSONArray companyNameArray, bikeSegmentArray, bikeArray;
	private static int level;
	private static Stack<UserOption> history;

	//// ANSI escape codes for formatting color in console
	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String CYAN = "\u001B[36m";
	private static final String BOLD = "\u001B[1m";
	private static final String ROSECOLOR = "\u001B[38;5;207m";

	static {
		level = 1;
		history = new Stack<>();
	}

	private static void getObject() { // Create json object and take json data from local file.
		String filePath;
		JSONParser jsonParser = new JSONParser();
		try {
			filePath = new File(".").getCanonicalPath()
					+ "\\src\\console_application\\com\\veeriyaperumal\\stack\\bikeshowroombroucher\\jsondata\\bikedata.json";
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Loan data missing or Loan data folder not able to find.So program terminated.");
			return;
		}
		try {
			jsonObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private static int getValidInput(int min, int max) {
		Scanner read = new Scanner(System.in);
		int choice = 0;
		do {
			try {
				choice = read.nextInt();
				if (choice < min || choice > max) {
					System.out.print("Choose valid option : ");
					continue;
				}
				return choice;
			} catch (InputMismatchException e) {
				System.out.print("Choose valid option : ");
				read.next();
				continue;
			}
		} while (true);
	}

	private static void printCompanyNames() {// Level 1
		int i, choice;
		JSONObject obj = (JSONObject) jsonObject.get("1");
		companyNameArray = (JSONArray) obj.get("Company Name");
		System.out.println(BOLD + YELLOW + "           COMPANY NAME\n" + RESET);
		for (i = 0; i < companyNameArray.size(); i++) {
			String str = (String) companyNameArray.get(i);
			System.out.println(YELLOW + str + RESET);
		}
		System.out.print(CYAN + (i + 1) + ".Exit\nChoose the company name : " + RESET);
		choice = getValidInput(1, companyNameArray.size() + 1);
		if (choice <= companyNameArray.size()) {
			promoteLevel(choice);
		} else {
			level = -1;
		}
	}

	private static void printBikeSegments() {// Level 2
		int i, choice;
		JSONObject obj = (JSONObject) jsonObject.get("2");
		bikeSegmentArray = (JSONArray) obj.get("Bike Segment");
		System.out.println(BOLD + YELLOW + "           BIKE SEGMENT NAME\n" + RESET);
		for (i = 0; i < bikeSegmentArray.size(); i++) {
			String str = (String) bikeSegmentArray.get(i);
			System.out.println(YELLOW + str);
		}
		System.out.print(CYAN + (i + 1) + ". Go back\n" + (i + 2) + ". Exit\nChoose the segment : " + RESET);
		choice = getValidInput(1, bikeSegmentArray.size() + 2);
		if (choice <= bikeSegmentArray.size()) {
			promoteLevel(choice);
		} else if (choice == bikeSegmentArray.size() + 1) {
			dePromoteLevel();
		} else {
			level = -1;
		}
	}

	private static void printBikeName() {// Level 3
		int i, choice;
		String temp = history.peek().getOption();
		JSONObject obj = (JSONObject) jsonObject.get("3");
		bikeArray = (JSONArray) obj.get(temp);
		System.out.println(BOLD + YELLOW + "           BIKE NAME\n" + RESET);
		for (i = 0; i < bikeArray.size(); i++) {
			String str = (String) bikeArray.get(i);
			System.out.println(YELLOW + str);
		}
		System.out.print(CYAN + (i + 1) + ". Go back\n" + (i + 2) + ". Exit\nChoose the Bike : " + RESET);
		choice = getValidInput(1, bikeArray.size() + 2);
		if (choice <= bikeArray.size()) {
			promoteLevel(choice, (String) bikeArray.get(choice - 1));
		} else if (choice == bikeArray.size() + 1) {
			dePromoteLevel();
		} else {
			level = -1;
		}
	}

	private static void printBikeDetails() {// Level 4
		int choice;
		String temp = history.peek().getBikeName();
		JSONObject obj = (JSONObject) jsonObject.get("4");
		System.out
				.println(BOLD + YELLOW + "           " + temp.substring(temp.indexOf('.') + 1).toUpperCase() + "\n\n");
		System.out.println(GREEN + obj.get(temp.substring(temp.indexOf('.') + 1)));
		System.out.print("\n" + CYAN + "1. Go back\n2. Exit\nChoose the option : " + RESET);
		choice = getValidInput(1, 2);
		if (choice == 1) {
			dePromoteLevel();
		} else {
			level = -1;
		}
	}

	private static void dePromoteLevel() {
		if (history.isEmpty()) {
			level = -1;
		} else {
			history.pop();
			level--;
		}
	}

	private static void promoteLevel(int choice) {
		if (history.isEmpty()) {
			history.push(new UserOption(level, Integer.toString(choice)));
		} else {
			UserOption temp = history.peek();
			history.push(new UserOption(level, temp.getOption() + Integer.toString(choice)));
		}
		level++;
	}

	private static void promoteLevel(int choice, String bikeName) {
		UserOption temp = history.peek();
		UserOption newOption = new UserOption(level, temp.getOption() + Integer.toString(choice));
		newOption.setBikeName(bikeName);
		history.push(newOption);
		level++;
	}

	private static void showOptions() {
		switch (level) {
		case 1: {
			printCompanyNames();
			break;
		}
		case 2: {
			printBikeSegments();
			break;
		}
		case 3: {
			printBikeName();
			break;
		}
		case 4: {
			printBikeDetails();
			break;
		}
		}
	}

	public static void myMain() {
		System.out.println(BOLD + GREEN + "______________WELCOME TO BIKE SHOW ROOM BROUCHER______________\n" + RESET);
		getObject();
		do {
			showOptions();
			System.out.println(
					BOLD + ROSECOLOR + "=============================================================\n" + RESET);
		} while (level != -1);
		System.out
				.println(BOLD + GREEN + "__________________THANK YOU FOR VISITING US,SEE YOU SOON__________________\n");
	}

	public static void main(String[] args) {
		myMain();
	}
}
