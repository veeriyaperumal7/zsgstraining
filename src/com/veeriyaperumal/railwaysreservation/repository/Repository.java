package com.veeriyaperumal.railwaysreservation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.veeriyaperumal.railwaysreservation.dto.Passenger;
import com.veeriyaperumal.railwaysreservation.dto.Train;
import com.veeriyaperumal.railwaysreservation.model.JdbcConnection;

public class Repository {
	private String query;
	private ArrayList<Train> scheduledTrainList = new ArrayList<>();
	private static Repository repository;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public ArrayList<Train> getScheduledTrainList() {
		return scheduledTrainList;
	}

	public void setScheduledTrainList(ArrayList<Train> scheduledTrainList) {
		this.scheduledTrainList = scheduledTrainList;
	}

	public ArrayList<Train> getScheduledTrainList(String bookingDate) {
		scheduledTrainList.clear();
		query = "SELECT * FROM trip_entry WHERE travel_start_date ='" + bookingDate + "' AND trip_status='ONLINE'";
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		if (result == null) {
			scheduledTrainList = null;
		} else {
			try {
				while (result.next()) {
					Train train = new Train();
					train.setTripId(result.getInt("trip_id"));
					train.setTrainNo(result.getInt("train_no"));
					train.setTrainName(result.getString("train_name"));
					train.setStartDate(result.getDate("travel_start_date"));
					train.setEndDate(result.getDate("travel_end_date"));
					train.setStartTime(result.getTime("travel_start_time"));
					train.setEndTime(result.getTime("travel_end_time"));
					train.setSeaterAvailableCount(result.getInt("seats_remaining_in_seater"));
					train.setSeaterWaitingListAvailableCount(result.getInt("waitinglist_remaining_in_seater"));
					train.setSeaterRacAvailableCount(result.getInt("rac_remaining_in_seater"));
					train.setSleeperAvailableCount(result.getInt("seats_remaining_in_sleeper"));
					train.setSleeperWaitingListAvailableCount(result.getInt("waitinglist_remaining_in_sleeper"));
					train.setSleeperRacAvailableCount(result.getInt("rac_remaining_in_sleeper"));
					train.setSeaterPrice(result.getFloat("seater_fair"));
					train.setSleeperPrice(result.getFloat("sleeper_fair"));
					train.setDeparturePlace(result.getString("departure_place"));
					train.setArrivalPlace(result.getString("arrival_place"));
					scheduledTrainList.add(train);
				}
			} catch (SQLException e) {
				scheduledTrainList = null;
				JdbcConnection.getInstance().printErrorMessageWithQuery("Error while getting ScheduledTrain", query);
				e.printStackTrace();
			} finally {
				JdbcConnection.getInstance().closeSQLConnection();
			}
		}
		return scheduledTrainList;
	}

	public boolean bookTicketInSeater(Passenger passenger, Train userSelectedTrain) {
		int passengerId = getPassengerId(passenger), rowsAffected = 0;
		passenger.setPassengerId(passengerId);
		query = "insert into booking_entry (trip_id, passenger_id, passenger_paid_amount, passenger_ticket_status, passenger_class,journey_status) "
				+ "values(" + userSelectedTrain.getTripId() + "," + passengerId + ","
				+ userSelectedTrain.getSeaterPrice() + ",'CNF','SEATER','CONFIRMED')";
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		query = "update trip_entry set seats_remaining_in_seater=seats_remaining_in_seater-1 where trip_id="
				+ userSelectedTrain.getTripId();
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		return (rowsAffected >= 1) ? true : false;
	}

	public boolean bookTicketInRacSeater(Passenger passenger, Train userSelectedTrain) {
		int passengerId = getPassengerId(passenger), rowsAffected = 0;
		passenger.setPassengerId(passengerId);
		query = "insert into booking_entry (trip_id, passenger_id, passenger_paid_amount, passenger_ticket_status, passenger_class,journey_status) "
				+ "values(" + userSelectedTrain.getTripId() + "," + passengerId + ","
				+ userSelectedTrain.getSeaterPrice() + ",'RAC','SEATER','CONFIRMED')";
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		query = "update trip_entry set rac_remaining_in_seater=rac_remaining_in_seater-1 where trip_id="
				+ userSelectedTrain.getTripId();
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		return (rowsAffected >= 1) ? true : false;
	}

	public boolean bookTicketInWaitingListSeater(Passenger passenger, Train userSelectedTrain) {
		int passengerId = getPassengerId(passenger), rowsAffected = 0;
		passenger.setPassengerId(passengerId);
		query = "insert into booking_entry (trip_id, passenger_id, passenger_paid_amount, passenger_ticket_status, passenger_class,journey_status) "
				+ "values(" + userSelectedTrain.getTripId() + "," + passengerId + ","
				+ userSelectedTrain.getSeaterPrice() + ",'WL','SEATER','CONFIRMED')";
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		query = "update trip_entry set waitinglist_remaining_in_seater=waitinglist_remaining_in_seater-1 where trip_id="
				+ userSelectedTrain.getTripId();
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		return (rowsAffected >= 1) ? true : false;
	}

	public boolean bookTicketInSleeper(Passenger passenger, Train userSelectedTrain) {
		int passengerId = getPassengerId(passenger), rowsAffected = 0;
		passenger.setPassengerId(passengerId);
		query = "insert into booking_entry (trip_id, passenger_id, passenger_paid_amount, passenger_ticket_status, passenger_class,journey_status) "
				+ "values(" + userSelectedTrain.getTripId() + "," + passengerId + ","
				+ userSelectedTrain.getSleeperPrice() + ",'CNF','SLEEPER','CONFIRMED')";
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		query = "update trip_entry set seats_remaining_in_sleeper=seats_remaining_in_sleeper-1 where trip_id="
				+ userSelectedTrain.getTripId();
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		return (rowsAffected >= 1) ? true : false;
	}

	public boolean bookTicketInRacSleeper(Passenger passenger, Train userSelectedTrain) {
		int passengerId = getPassengerId(passenger), rowsAffected = 0;
		passenger.setPassengerId(passengerId);
		query = "insert into booking_entry (trip_id, passenger_id, passenger_paid_amount, passenger_ticket_status, passenger_class,journey_status) "
				+ "values(" + userSelectedTrain.getTripId() + "," + passengerId + ","
				+ userSelectedTrain.getSleeperPrice() + ",'RAC','SLEEPER','CONFIRMED')";
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		query = "update trip_entry set rac_remaining_in_sleeper=rac_remaining_in_sleeper-1 where trip_id="
				+ userSelectedTrain.getTripId();
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		return (rowsAffected >= 1) ? true : false;
	}

	public boolean bookTicketInWaitingListSleeper(Passenger passenger, Train userSelectedTrain) {
		int passengerId = getPassengerId(passenger), rowsAffected = 0;
		passenger.setPassengerId(passengerId);
		query = "insert into booking_entry (trip_id, passenger_id, passenger_paid_amount, passenger_ticket_status, passenger_class,journey_status) "
				+ "values(" + userSelectedTrain.getTripId() + "," + passengerId + ","
				+ userSelectedTrain.getSleeperPrice() + ",'WL','SLEEPER','CONFIRMED')";
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		query = "update trip_entry set waitinglist_remaining_in_sleeper=waitinglist_remaining_in_sleeper-1 where trip_id="
				+ userSelectedTrain.getTripId();
		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		return (rowsAffected >= 1) ? true : false;
	}

	public int getPassengerId(Passenger passenger) {
		query = "Select passenger_id from passenger where passenger_name='" + passenger.getName()
				+ "' and passenger_mobile ='" + passenger.getMobileNumber() + "'";
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		try {
			if (!result.next()) {
				return createPassengerId(passenger);
			} else {
				try {
					return result.getInt("passenger_id");
				} catch (SQLException e) {
					JdbcConnection.getInstance().printErrorMessageWithQuery("Error while getting passenger id", query);
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.getInstance().closeSQLConnection();
		}
		return -1;
	}

	public int createPassengerId(Passenger passenger) {
		int id = getMaxPassengerId();
		query = "insert into passenger (passenger_id,passenger_name,passenger_dob,passenger_gender,passenger_place,passenger_mobile) values ("
				+ id + ",'" + passenger.getName() + "','" + passenger.getDob() + "','" + passenger.getGender() + "','"
				+ passenger.getPlace() + "','" + passenger.getMobileNumber() + "')";
		if (JdbcConnection.getInstance().executeInsertOrUpdateQuery(query) >= 1) {
			return id;
		} else {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert new passenger data", query);
			return -1;
		}
	}

	public int getMaxPassengerId() {
		query = "SELECT MAX(passenger_id) AS maxId FROM passenger";
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		try {
			result.next();
			return result.getInt("maxId") + 1;
		} catch (SQLException e) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while getting max passenger id", query);
			e.printStackTrace();
		} finally {
			JdbcConnection.getInstance().closeSQLConnection();
		}
		return -1;

	}

	public int getPNR(Passenger currentPassenger, Train userSelectedTrain) {
		query = "SELECT MAX(pnr_no) AS maxPnr FROM booking_entry where passenger_id="
				+ currentPassenger.getPassengerId() + " and trip_id=" + userSelectedTrain.getTripId();
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		try {
			result.next();
			return result.getInt("maxPnr");
		} catch (SQLException e) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while getting max passenger id", query);
			e.printStackTrace();
		} finally {
			JdbcConnection.getInstance().closeSQLConnection();
		}
		return -1;

	}
}
