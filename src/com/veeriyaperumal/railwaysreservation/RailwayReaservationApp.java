package com.veeriyaperumal.railwaysreservation;

import java.util.InputMismatchException;

import com.veeriyaperumal.railwaysreservation.booktickets.BookTicketView;
import com.veeriyaperumal.railwaysreservation.util.Utility;

public class RailwayReaservationApp {
	BookTicketView bookTicketView;

	public RailwayReaservationApp() {
		bookTicketView = new BookTicketView(this);
	}

	public static void main(String[] args) {
		RailwayReaservationApp obj = new RailwayReaservationApp();
		obj.start();
	}

	private void start() {
		int userInput;
		System.out.println(Utility.BOLD + Utility.CYAN + " ====================================================" + Utility.RESET);
		System.out.println(
				Utility.BOLD + Utility.CYAN + " |           " + Utility.ROSECOLOR + "WELCOME TO IRCTC" + Utility.CYAN + "              |" + Utility.RESET);
		System.out.println(Utility.BOLD + Utility.CYAN + " ====================================================\n\n" + Utility.RESET);

		do {
			printFeatures();
			userInput = getUserInput(1, 4);
			chooseFeature(userInput);
		} while (userInput != 4);
		System.out.println(Utility.BOLD + Utility.CYAN + " ====================================================" + Utility.RESET);
		System.out.println(
				Utility.BOLD + Utility.CYAN + "      " + Utility.ROSECOLOR + "THANK YOU FOR VISITING US,SEE YOU SOON" + Utility.CYAN + "        ");
		System.out.println(Utility.BOLD + Utility.CYAN + " ====================================================" + Utility.RESET);

	}

	private void chooseFeature(int userInput) {
		switch (userInput) {
		case 1:
			bookTicketView.showBooking();
			break;
		default:
			break;
		}
	}

	private void printFeatures() {
		System.out.println("1 - Book Tickets");
		System.out.println("2 - Cancel Tickets");
		System.out.println("3 - Check Ticket Status");
		System.out.println("4 - Exit");
	}

	private int getUserInput(int minSelection, int maxSelection) {
		int userEnteredChoice = -1;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				if (userEnteredChoice < minSelection || userEnteredChoice > maxSelection) {
					showWrongSelectionMessage("Choose Valid Option : ");
					Utility.getScanner().next();
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				showWrongSelectionMessage("Choose Valid Option : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredChoice;
	}
	
	public static void showWrongSelectionMessage(String message) {
		System.out.print(Utility.BOLD + Utility.RED + message + Utility.RESET);
	}


}
