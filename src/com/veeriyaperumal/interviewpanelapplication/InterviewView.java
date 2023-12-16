package com.veeriyaperumal.interviewpanelapplication;

import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

import com.veeriyaperumal.interviewpanelapplication.dto.Candidate;

public class InterviewView {
	private InterviewViewModel viewModel;

	// ANSI escape codes for formatting color in console
	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String CYAN = "\u001B[36m";
	private static final String BOLD = "\u001B[1m";
	private static final String ROSECOLOR = "\u001B[38;5;207m";

	public InterviewView() {
		this.viewModel = new InterviewViewModel(this);
	}

	public void start() {
		boolean flag = true;
		System.out.println(BOLD + GREEN + "================= Welcome To Interview Panel =================" + RESET);
		do {
			switch (printOptions()) {
			case 1: {
				addCandidate();
				break;
			}
			case 2: {
				showCandidateQueue();
				break;
			}
			case 3: {
				printCurrentInterviewingCandidate();
				break;
			}
			case 4: {
				startInterview();
				break;
			}
			case 5: {
				endInterview();
				break;
			}
			case 6: {
				flag = false;
			}
			}
			System.out.println(YELLOW + "===================================================" + RESET);
		} while (flag);
		System.out.println(BOLD + GREEN + "================ Thank you using us,see you soon. ================");
		System.exit(0);
	}

	private int printOptions() {
		System.out.println("1 --> Add new Candidate");
		System.out.println("2 --> See how many candidate yet to take interview.");
		System.out.println("3 --> See who currently take a interview.");
		System.out.println("4 --> Start a interview.");
		System.out.println("5 --> End a interview.");
		System.out.println("6 --> Exit.");
		System.out.print(ROSECOLOR + "Choose your option : " + RESET);
		return getValidIntegerInput(1, 6);
	}

	private void addCandidate() {
		viewModel.addCandidate(getCandidateInput());
		System.out.println("Candidate added successfully");
	}

	private void startInterview() {
		viewModel.startInterview();
	}

	private void endInterview() {
		viewModel.endInterview();
	}

	private void showCandidateQueue() {
		Queue<Candidate> queue = viewModel.getCandidatesQueue();
		if (queue.isEmpty()) {
			System.out.println("There is no candidate waiting to take an interview.");
		} else {
			int i = 1;
			for (Candidate obj : queue) {
				if (i == 1 && viewModel.isInterviewStarted()) {
					i++;
					continue;
				} else {
					System.out.println((viewModel.isInterviewStarted()) ? i : i - 1 + " " + obj.getName());
					i++;
				}
			}
		}
	}

	private void printCurrentInterviewingCandidate() {
		if (viewModel.getCandidatesQueue().isEmpty() || !viewModel.isInterviewStarted()) {
			System.out.println(GREEN + "There is no candidate currently takes a interview." + RESET);
		} else {
			System.out.println(GREEN + "Current interviewing person name is : "
					+ viewModel.getCandidatesQueue().peek().getName() + RESET);
		}
	}

	private static int getValidIntegerInput(int min, int max) {
		Scanner read = new Scanner(System.in);
		int choice = 0;
		do {
			try {
				choice = read.nextInt();
				if (choice < min || choice > max) {
					System.out.print(ROSECOLOR + "Choose valid option : " + RESET);
					continue;
				}
				return choice;
			} catch (InputMismatchException e) {
				System.out.print(ROSECOLOR + "Choose valid option : " + RESET);
				read.next();
				continue;
			}
		} while (true);
	}

	private static String getValidStringInput() {
		Scanner read = new Scanner(System.in);
		String choice;
		do {
			try {
				choice = read.nextLine();
				if (choice.length() < 1) {
					System.out.print(ROSECOLOR + "Choose valid option : " + RESET);
					continue;
				}
				return choice;
			} catch (InputMismatchException e) {
				System.out.print(ROSECOLOR + "Choose valid option : " + RESET);
				read.next();
				continue;
			}
		} while (true);
	}

	private Candidate getCandidateInput() {
		Candidate candidate = new Candidate();
		System.out.print(CYAN + "Enter your name : " + RESET);
		candidate.setName(getValidStringInput());
		System.out.print(CYAN + "Enter your qualification : " + RESET);
		candidate.setQualification(getValidStringInput());
		System.out.print(CYAN + "Enter your role : " + RESET);
		candidate.setRole(getValidStringInput());
		System.out.print(CYAN + "Enter your experience : " + RESET);
		candidate.setExperience(getValidStringInput());
		System.out.print(CYAN + "Enter your age : " + RESET);
		candidate.setAge(getValidIntegerInput(1, 99));
		return candidate;
	}

	void printUserMessage(String message) {
		System.out.println(GREEN + message + RESET);
	}

	void printInterviewStatusMessage(String message) {
		System.out.println(CYAN + message + RESET);
	}
}
