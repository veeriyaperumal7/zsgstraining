package com.veeriyaperumal.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

}
