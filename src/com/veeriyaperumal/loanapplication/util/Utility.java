package com.veeriyaperumal.loanapplication.util;

import java.util.Scanner;

public class Utility {
	private static Scanner read = new Scanner(System.in);

	//// ANSI escape codes for formatting color in console
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String CYAN = "\u001B[36m";
	public static final String BOLD = "\u001B[1m";
	public static final String ROSECOLOR = "\u001B[38;5;207m";
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";

	
	public static Scanner getScanner() {
		return read;
	}
}
