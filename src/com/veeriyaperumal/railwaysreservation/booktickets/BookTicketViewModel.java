package com.veeriyaperumal.railwaysreservation.booktickets;

import java.util.ArrayList;

import com.veeriyaperumal.railwaysreservation.dto.Train;
import com.veeriyaperumal.railwaysreservation.util.Utility;
import com.veeriyaperumal.repository.Repository;

public class BookTicketViewModel {
	private final int MAX_DAYS = 8;// This refer how many advance days we can book from now current date+1 to
	// MAX_DAYS
	private BookTicketView bookTicketView;
	private Train userSelectedTrain;

	public BookTicketViewModel(BookTicketView bookTicketView) {
		this.bookTicketView = bookTicketView;
	}

	public BookTicketView getBookTicketView() {
		return bookTicketView;
	}

	public void setBookTicketView(BookTicketView bookTicketView) {
		this.bookTicketView = bookTicketView;
	}

	public ArrayList<Train> getScheduledTrainList() {
		return Repository.getInstance().getScheduledTrainList();
	}

	public int getMAX_DAYS() {
		return MAX_DAYS;
	}

	public boolean isValidBookingDate(int userEnteredChoice) {
		if (userEnteredChoice >= 1 && userEnteredChoice <= MAX_DAYS) {
			return true;
		}
		return false;
	}

	public boolean isValidTrain(int userEnteredChoice) {
		for (Train train : Repository.getInstance().getScheduledTrainList()) {
			if (train.getTrainNo() == userEnteredChoice) {
				return true;
			}
		}
		return false;
	}

	ArrayList<Train> getScheduledTrain(String bookingDate) {
		return Repository.getInstance().getScheduledTrainList(bookingDate);
	}

	private int getTotalSeatsAvailableInSeater() {
		return userSelectedTrain.getSeaterAvailableCount() + userSelectedTrain.getSeaterRacAvailableCount()
				+ userSelectedTrain.getSeaterWaitingListAvailableCount();
	}

	private int getSeaterTicketCount() {
		System.out.print("Enter the how many ticket count : ");
		int passengerCount = bookTicketView.getValidInput(1, 5, "Ticket count must be greater than 0 and less than 6.");
		int availableSeatsInTrainCount = getTotalSeatsAvailableInSeater();
		if (passengerCount > availableSeatsInTrainCount) {
			bookTicketView.printUserWarningMessage("Currently available ticket count is " + availableSeatsInTrainCount
					+ ".\nSo are you okay with current ticket count ?\n1 - YES\n 2- NO");
			if (bookTicketView.getValidInput(1, 2, "Choose valid option.") == 1) {
				return availableSeatsInTrainCount;
			} else {
				return -1;
			}
		} else {
			return passengerCount;
		}
	}

	public void bookSeater() {
		int passengerCount = getSeaterTicketCount();
		if (passengerCount == -1) {
			return;
		}

		for (int i = 1; i <= passengerCount; i++) {
			if (userSelectedTrain.getSeaterAvailableCount() >= 1) {
                
				userSelectedTrain.setSeaterAvailableCount(userSelectedTrain.getSeaterAvailableCount() - 1);
			} else if (userSelectedTrain.getSeaterRacAvailableCount() >= 1) {

				userSelectedTrain.setSeaterAvailableCount(userSelectedTrain.getSeaterAvailableCount() - 1);
			} else if (userSelectedTrain.getSeaterWaitingListAvailableCount() >= 1) {

				userSelectedTrain
						.setSeaterWaitingListAvailableCount(userSelectedTrain.getSeaterWaitingListAvailableCount() - 1);
			} else {
				System.out.print(
						Utility.BOLD + Utility.CYAN + "Currently no seats available in that sorry." + Utility.RESET);
				break;
			}
		}

	}

	private void bookSeaterInWaitingList() {

	}

	public void bookSleeper() {

	}

	public Train getUserSelectedTrain() {
		return userSelectedTrain;
	}

	public void setUserSelectedTrain(Train userSelectedTrain) {
		this.userSelectedTrain = userSelectedTrain;
	}

}
