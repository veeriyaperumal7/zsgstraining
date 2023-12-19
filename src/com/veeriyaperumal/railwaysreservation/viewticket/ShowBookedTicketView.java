package com.veeriyaperumal.railwaysreservation.viewticket;

import java.util.InputMismatchException;

import com.veeriyaperumal.railwaysreservation.RailwayReservationApp;
import com.veeriyaperumal.railwaysreservation.util.Utility;

public class ShowBookedTicketView {

	RailwayReservationApp railwayReaservationApp;
	ShowBookedTicketModel showBookedTicketModel;

	public ShowBookedTicketView(RailwayReservationApp railwayReaservationApp) {
		this.railwayReaservationApp = railwayReaservationApp;
		this.showBookedTicketModel = new ShowBookedTicketModel(this);
	}

	public void showBookedTicket() {
		getPnrNumber();
		printSeperatorLine();
		showTicket();
		printSeperatorLine();
	}

	public void showTicket() {

		System.out
				.println(Utility.BOLD + "PNR NO                    : " + showBookedTicketModel.getTicket().getPnrNo());
		System.out.println("Passenger Name            : " + showBookedTicketModel.getTicket().getPassengerName());
		System.out.println("Passenger Mobile          : " + showBookedTicketModel.getTicket().getPassengerMobile());
		System.out.println("Passenger Ticket Status   : " + Utility.YELLOW + Utility.BOLD
				+ showBookedTicketModel.getTicket().getPassengerTicketStatus() + " - "
				+ showBookedTicketModel.getTicket().getPassengerClass() + Utility.RESET);
		System.out.println(Utility.BOLD + "Passenger Journey Status  : " + Utility.YELLOW + Utility.BOLD
				+ showBookedTicketModel.getTicket().getJourneyStatus() + Utility.RESET);
		System.out.println(Utility.BOLD + "Ticker Fair               : "
				+ showBookedTicketModel.getTicket().getPassengerPaidAmount() + "\n");
		System.out.println("Train NO                  : " + showBookedTicketModel.getTicket().getTrainNo());
		System.out.println("Train Name                : " + showBookedTicketModel.getTicket().getTrainName());
		System.out.println("Depature Place            : " + showBookedTicketModel.getTicket().getDeparturePlace());
		System.out.println("Depature Date             : " + showBookedTicketModel.getTicket().getStartDate());
		System.out.println("Depature Time             : " + showBookedTicketModel.getTicket().getStartTime());
		System.out.println(
				"Destination Place         : " + showBookedTicketModel.getTicket().getArrivalPlace() + Utility.RESET);
   
	}

	int getPnrNumber() {
		System.out.print("Enter valid pnr no : ");
		int userEnteredChoice = -1;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				Utility.getScanner().nextLine();
				if (!showBookedTicketModel.isValidPnr(userEnteredChoice)) {
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
