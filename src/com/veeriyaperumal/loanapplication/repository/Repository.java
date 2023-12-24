package com.veeriyaperumal.loanapplication.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.veeriyaperumal.loanapplication.model.JdbcConnection;
import com.veeriyaperumal.loanapplication.dto.Customer;
import com.veeriyaperumal.loanapplication.dto.LoanData;

public class Repository {
	private String query;
	private static Repository repository;
	private HashMap<Integer, Customer> customerList = new HashMap<>();

	private Repository() {
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public boolean addCustomer(Customer customer) {
		int rowsAffected = 0;
		query = "insert into customer_data (customer_id,customer_name, customer_dob, customer_gender,customer_place,customer_mobile,customer_status) "
				+ "values(" + customer.getCustomerId() + ",'" + customer.getName() + "','"
				+ java.sql.Date.valueOf(customer.getDob()) + "','" + customer.getGender() + "','" + customer.getPlace()
				+ "','" + customer.getMobileNumber() + "','ONLINE')";

		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		return (rowsAffected >= 1) ? true : false;
	}

	public int getNewCustomerId() {
		query = "SELECT MAX(customer_id) AS max_customer_id FROM customer_data";
		ResultSet resultSet = JdbcConnection.getInstance().executeSelectQuery(query);
		try {
			if (resultSet.next()) {
				int maxCustomerId = resultSet.getInt("max_customer_id");
				return maxCustomerId + 1;
			} else {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean addLoan(LoanData loan, Customer customer) {
		int rowsAffected = 0;
		String query = "INSERT INTO loan_data (Customer_id, loan_amount, loan_pending_amount, loan_paid_amount, "
				+ "loan_status, loan_interest_percentage, loan_interest_amount, loan_total_payable_amount, loan_issue_date) "
				+ "VALUES (" + customer.getCustomerId() + ", " + loan.getLoanAmount() + ", "
				+ loan.getLoanPendingAmount() + ", " + loan.getLoanPaidAmount() + ", 'PENDING', "
				+ loan.getLoanInterestPercentage() + ", " + loan.getLoanIntresetAmount() + ", "
				+ loan.getLoanTotalPayableAmount() + ", '" + java.sql.Date.valueOf(loan.getLoanIssueDate()) + "')";

		rowsAffected = JdbcConnection.getInstance().executeInsertOrUpdateQuery(query);
		if (rowsAffected < 1) {
			JdbcConnection.getInstance().printErrorMessageWithQuery("Error while insert into table", query);
		}
		return (rowsAffected >= 1) ? true : false;
	}

	public HashMap<Integer, Customer> getCustomerList() {
		query = "select * from customer_data where customer_status='ONLINE'";
		ResultSet result = JdbcConnection.getInstance().executeSelectQuery(query);
		try {
			while (result.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(result.getInt("customer_id"));
				customer.setName(result.getString("customer_name"));
				customer.setMobileNumber(result.getString("customer_mobile"));
				customer.setGender(result.getString("customer_gender"));
				customer.setPlace(result.getString("customer_place"));
				customerList.put(customer.getCustomerId(), customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customerList;
	}

}
