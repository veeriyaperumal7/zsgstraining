package com.veeriyaperumal.loanapplication;

import java.util.InputMismatchException;

import com.veeriyaperumal.loanapplication.createloan.LoanCreateView;
import com.veeriyaperumal.loanapplication.util.Utility;

public class LoanApplication {

	private LoanCreateView loanCreditView;
	
	public LoanApplication() {
    this.loanCreditView = new LoanCreateView();
	}

	public static void main(String[] args) {
		LoanApplication obj = new LoanApplication();
		obj.start();
	}

	private void start() {
		int userInput;
		System.out.println(
				Utility.BOLD + Utility.CYAN + " ====================================================" + Utility.RESET);
		System.out.println(Utility.BOLD + Utility.CYAN + "            " + Utility.ROSECOLOR + "WELCOME TO LOAN APPLICATION"
				+ Utility.CYAN + "              " + Utility.RESET);
		System.out.println(Utility.BOLD + Utility.CYAN + " ====================================================\n\n"
				+ Utility.RESET);

		do {
			printFeatures();
			userInput = getUserInput(1, 4);
			chooseFeature(userInput);
		} while (userInput != 4);
		System.out.println(
				Utility.BOLD + Utility.CYAN + " ====================================================" + Utility.RESET);
		System.out.println(Utility.BOLD + Utility.CYAN + "      " + Utility.ROSECOLOR
				+ "THANK YOU FOR VISITING US,SEE YOU SOON" + Utility.CYAN + "        ");
		System.out.println(
				Utility.BOLD + Utility.CYAN + " ====================================================" + Utility.RESET);

	}

	private void chooseFeature(int userInput) {
		switch (userInput) {
		case 1:
			loanCreditView.startCredit();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}

	private void printFeatures() {
		System.out.println("1 - Loan Credit");
		System.out.println("2 - Loan Debit");
		System.out.println("3 - Loan Report");
		System.out.print("4 - Exit\nChoose your option : ");
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
