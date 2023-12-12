package com.veeriyaperumal.queue;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Candidate {
	private String name, qualification, role, experience;
	private int age;

	public Candidate(String name, int age, String qualification, String role, String experience) {
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.role = role;
		this.experience = experience;
	}

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}

public class InterviewScheduler implements Runnable {
	Queue<Candidate> candidatesQueue;
	private Thread interviewThread;
	private boolean isInterviewStarted = false;
	final private int INTERVAL_TIME = 10000;// in milli second

	// ANSI escape codes for formatting color in console
	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String CYAN = "\u001B[36m";
	private static final String BOLD = "\u001B[1m";
	private static final String ROSECOLOR = "\u001B[38;5;207m";

	public InterviewScheduler() {
		candidatesQueue = new LinkedList<>();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(INTERVAL_TIME);
			finishInterview();
			if (!candidatesQueue.isEmpty()) {
				interviewThread = new Thread(this);
				interviewThread.start();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void addCanditateToQueue(Candidate candidate) {
		candidatesQueue.add(candidate);
		if (!candidatesQueue.isEmpty() && isInterviewStarted) {
			interviewThread = new Thread(this);
			interviewThread.start();
		}
	}

	private void finishInterview() {
		if (!candidatesQueue.isEmpty() && isInterviewStarted) {
			System.out.println(GREEN + "Interview finished for " + candidatesQueue.peek().getName() + RESET);
			candidatesQueue.poll();
		}
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

	private void startInterview() {
		isInterviewStarted = true;
		interviewThread = new Thread(this);
		interviewThread.start();
	}

	private void endInterview() {
		isInterviewStarted = false;
	}

	private void start() {
		boolean flag = true;
		System.out.println(BOLD + GREEN + "================= Welcome To Interview Panel =================" + RESET);
		do {
			switch (printOptions()) {
			case 1: {
				addCanditateToQueue(getCandidateInput());
				System.out.println(GREEN + "Candidate added successfully" + RESET);
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
				System.out.println(GREEN + "Interview started." + RESET);
				break;
			}
			case 5: {
				endInterview();
				System.out.println(CYAN + "Interview ended." + RESET);
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

	private void showCandidateQueue() {
		if (candidatesQueue.size() <= 1 || candidatesQueue.size() == 1 && isInterviewStarted) {
			System.out.println(GREEN + "There is no candidate waiting to take a interview." + RESET);
		} else {
			int i = 1;
			for (Candidate obj : candidatesQueue) {
				if (i == 1 && isInterviewStarted) {
					i++;
					continue;
				} else {
					System.out.println((isInterviewStarted) ? i : i - 1 + " " + obj.getName());
					i++;
				}
			}
		}
	}

	private void printCurrentInterviewingCandidate() {
		if (candidatesQueue.isEmpty() || !isInterviewStarted) {
			System.out.println(GREEN + "There is no candidate currently takes a interview." + RESET);
		} else {
			System.out.println(
					GREEN + "Current interviewing person name is : " + candidatesQueue.peek().getName() + RESET);
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

	public static void myMain() {// This method implemented for my own purpose.
		InterviewScheduler schedule = new InterviewScheduler();
		schedule.start();
	}

	public static void main(String[] args) throws InterruptedException {
		myMain();
	}

}
