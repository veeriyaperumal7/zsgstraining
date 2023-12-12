package com.veeriyaperumal.railwaysreservation.booktickets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.veeriyaperumal.bikeshowroom.viewmodel.BikeViewModel;
import com.veeriyaperumal.railwaysreservation.RunnerClass;
import com.veeriyaperumal.railwaysreservation.dto.Train;
import com.veeriyaperumal.railwaysreservation.util.Utility;

public class BookTicketView {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	RunnerClass runnerClass;
	BookTicketViewModel bookTicketViewModel;

	public BookTicketView(RunnerClass runnerClass) {
		runnerClass = this.runnerClass;
		bookTicketViewModel = new BookTicketViewModel(this);
	}

	public void showBooking() {
		printBookingDates();
	}

	private void printBookingDates() {
		LocalDate currentDate = LocalDate.now();
		for (int i = 1; i <= bookTicketViewModel.getMAX_DAYS(); i++) {
			currentDate = currentDate.plusDays(1);
			System.out.println(i + " -> " + currentDate.format(formatter));
		}
		printAvailableTrains(getBookingDate(LocalDate.now()));
	}

	private void printAvailableTrains(String bookingDate) {
		ArrayList<Train> scheduledList = bookTicketViewModel.getScheduledTrain(bookingDate);
		if (scheduledList.size() == 0) {
			System.out.println("There is no train available for this date : " + bookingDate);
			return;
		}
		for (Train train : scheduledList) {
			System.out.println(
					Utility.GREEN + Utility.BOLD + "Train NO             : " + train.getTrainNo() + Utility.RESET);
			System.out.println("Train Name           : " + train.getTrainName());
			System.out.println("Depature Place       : " + train.getDeparturePlace());
			System.out.println("Depature Date        : " + train.getStartDate());
			System.out.println("Depature Time        : " + train.getStartTime());
			System.out.println("Destination Place    : " + train.getArrivalPlace());
			System.out.println("Arrival Date         : " + train.getEndDate());
			System.out.println("Arrival Time         : " + train.getEndTime());
			printSeperatorLine();
		}
		System.out.print("Enter Valid Train No : ");

		printSeatAvailability(getUserSelectedTrainInput());
	}

	private void printSeatAvailability(int userSelectedTrainInput) {
		for (Train train : bookTicketViewModel.getScheduledTrainList()) {
			if (train.getTrainNo() == userSelectedTrainInput) {
				bookTicketViewModel.setUserSelectedTrain(train);
				System.out.println(
						Utility.GREEN + Utility.BOLD + "Train NO             : " + train.getTrainNo() + Utility.RESET);
				System.out.println(Utility.GREEN + Utility.BOLD + "Train Name                        : "
						+ train.getTrainName() + Utility.RESET);
				System.out.println("Seater Availability               : " + train.getSeaterAvailableCount());
				System.out.println("Seater Waiting List Availability  : " + train.getSeaterWaitingListAvailableCount());
				System.out.println("Seater RAC Availability           : " + train.getSeaterRacAvailableCount());
				System.out.println("Sleeper Availability              : " + train.getSleeperAvailableCount());
				System.out
						.println("Sleeper Waiting List Availability : " + train.getSleeperWaitingListAvailableCount());
				System.out.println("Sleeper RAC Availability          : " + train.getSleeperRacAvailableCount());
				break;
			}
		}
		System.out.print("1 - Ticket Booking\n2 - Exit");
		if (getValidInput(1, 2, "Choose valid option : ") == 1) {
			showBookingClass();
		} else {
			return;
		}
	}

	private void showBookingClass() {
		System.out.print("1 - Seater\n2 - Seater\n3 - Exit");
		int userChoice = getValidInput(1, 2, "Choose valid option : ");
		if (userChoice == 1) {
			bookTicketViewModel.bookSeater();
		} else if (userChoice == 2) {
			bookTicketViewModel.bookSleeper();
		} else {
			return;
		}
	}

	private String getBookingDate(LocalDate todayDate) {
		System.out.print("Enter valid booking date : ");
		return todayDate.plusDays(getUserBookingDateInput()).format(formatter);
	}

	private int getUserBookingDateInput() {
		int userEnteredChoice = -1;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				if (!bookTicketViewModel.isValidBookingDate(userEnteredChoice)) {
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

	private int getUserSelectedTrainInput() {
		int userEnteredChoice = -1;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				if (!bookTicketViewModel.isValidTrain(userEnteredChoice)) {
					showWrongSelectionMessage("Enter Valid Train No : ");
					Utility.getScanner().next();
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				showWrongSelectionMessage("Enter Valid Train No : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredChoice;
	}

	public int getValidInput(int min, int max, String message) {
		int userEnteredChoice = -1;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				if (!(userEnteredChoice >= min) && !(userEnteredChoice <= max)) {
					showWrongSelectionMessage(message);
					Utility.getScanner().next();
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				showWrongSelectionMessage(message);
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredChoice;
	}

	public void printSeperatorLine() {
		System.out.println(Utility.BOLD + Utility.CYAN + "\n====================================================\n"
				+ Utility.RESET);
	}

	public void showWrongSelectionMessage(String message) {
		System.out.print(Utility.BOLD + Utility.RED + message + Utility.RESET);
	}

	public void printErrorMessage(String message) {
		System.out.print(Utility.BOLD + Utility.RED + message + Utility.RESET);
	}

	public void printUserWarningMessage(String message) {
		System.out.println(Utility.BOLD + Utility.YELLOW + message + Utility.RESET);
	}

	

}
