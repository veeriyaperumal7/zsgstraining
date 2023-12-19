package com.veeriyaperumal.railwaysreservation.cancelticket;

import java.util.InputMismatchException;

import com.veeriyaperumal.railwaysreservation.RailwayReservationApp;
import com.veeriyaperumal.railwaysreservation.util.Utility;

public class CancelTicketView {

	private CancelTicketViewModel cancelTicketViewModel;

	public CancelTicketView(RailwayReservationApp railwayReservationApp) {
		this.cancelTicketViewModel = new CancelTicketViewModel(this);
	}

	public void showCancellation() {
		getPnrNumber();
		cancelTicketViewModel.cancelTicket();
	}

	int getPnrNumber() {
		System.out.print("Enter valid pnr no : ");
		int userEnteredChoice = -1;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				Utility.getScanner().nextLine();
				if (!cancelTicketViewModel.isValidPnr(userEnteredChoice)) {
					showWrongSelectionMessage("Given PNR number wrong.Choose a valid Pnr number : ");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				showWrongSelectionMessage("Given PNR number wrong.Choose a valid Pnr number : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredChoice;
	}

	public void showTicket() {
		System.out
				.println(Utility.BOLD + "PNR NO                    : " + cancelTicketViewModel.getTicket().getPnrNo());
		System.out.println("Passenger Name            : " + cancelTicketViewModel.getTicket().getPassengerName());
		System.out.println("Passenger Mobile          : " + cancelTicketViewModel.getTicket().getPassengerMobile());
		System.out.println("Passenger Ticket Status   : " + Utility.YELLOW + Utility.BOLD
				+ cancelTicketViewModel.getTicket().getPassengerTicketStatus() + " - "
				+ cancelTicketViewModel.getTicket().getPassengerClass() + Utility.RESET);
		System.out.println(Utility.BOLD + "Passenger Journey Status  : " + Utility.YELLOW + Utility.BOLD + "CANCELLED"
				+ Utility.RESET);
		System.out.println(Utility.BOLD + "Ticker Fair               : "
				+ cancelTicketViewModel.getTicket().getPassengerPaidAmount() + "\n");
		System.out.println("Train NO                  : " + cancelTicketViewModel.getTicket().getTrainNo());
		System.out.println("Train Name                : " + cancelTicketViewModel.getTicket().getTrainName());
		System.out.println("Depature Place            : " + cancelTicketViewModel.getTicket().getDeparturePlace());
		System.out.println("Depature Date             : " + cancelTicketViewModel.getTicket().getStartDate());
		System.out.println("Depature Time             : " + cancelTicketViewModel.getTicket().getStartTime());
		System.out.println(
				"Destination Place         : " + cancelTicketViewModel.getTicket().getArrivalPlace() + Utility.RESET);

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
