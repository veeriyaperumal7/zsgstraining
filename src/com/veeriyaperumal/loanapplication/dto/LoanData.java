package com.veeriyaperumal.loanapplication.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanData {

	private int loanNumber;
	private float loanAmount, loanPaidAmount, loanInterestPercentage, loanPendingAmount, loanIntresetAmount,
			loanTotalPayableAmount;
	private LocalDate loanIssueDate;
	private ArrayList<LoanHistory> paymentHistory;

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getLoanPaidAmount() {
		return loanPaidAmount;
	}

	public void setLoanPaidAmount(float loanPaidAmount) {
		this.loanPaidAmount = loanPaidAmount;
	}

	public float getLoanPendingAmount() {
		return loanPendingAmount;
	}

	public void setLoanPendingAmount(float loanPendingAmount) {
		this.loanPendingAmount = loanPendingAmount;
	}

	public ArrayList<LoanHistory> getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(ArrayList<LoanHistory> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public float getLoanIntresetAmount() {
		return loanIntresetAmount;
	}

	public void setLoanIntresetAmount(float loanIntresetAmount) {
		this.loanIntresetAmount = loanIntresetAmount;
	}

	public float getLoanInterestPercentage() {
		return loanInterestPercentage;
	}

	public void setLoanInterestPercentage(float loanInterestPercentage) {
		this.loanInterestPercentage = loanInterestPercentage;
	}

	public float getLoanTotalPayableAmount() {
		return loanTotalPayableAmount;
	}

	public void setLoanTotalPayableAmount(float loanTotalPayableAmount) {
		this.loanTotalPayableAmount = loanTotalPayableAmount;
	}

	public LocalDate getLoanIssueDate() {
		return loanIssueDate;
	}

	public void setLoanIssueDate(LocalDate loanIssueDate) {
		this.loanIssueDate = loanIssueDate;
	}

	class LoanHistory {
		public float getCreditAmount() {
			return creditAmount;
		}

		public void setCreditAmount(float creditAmount) {
			this.creditAmount = creditAmount;
		}

		public float getDebitAmount() {
			return debitAmount;
		}

		public void setDebitAmount(float debitAmount) {
			this.debitAmount = debitAmount;
		}

		public LocalDate getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(LocalDate paymentDate) {
			this.paymentDate = paymentDate;
		}

		private float creditAmount, debitAmount;
		private LocalDate paymentDate;
	}

}
