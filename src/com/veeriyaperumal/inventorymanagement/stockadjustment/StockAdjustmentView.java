package com.veeriyaperumal.inventorymanagement.stockadjustment;

import java.util.ArrayList;
import java.util.InputMismatchException;

import com.veeriyaperumal.inventorymanagement.dto.Product;
import com.veeriyaperumal.inventorymanagement.util.Utility;

public class StockAdjustmentView {

	private StockAdjustmentViewModel stockAdjustmentViewModel;

	public StockAdjustmentView() {
		this.stockAdjustmentViewModel = new StockAdjustmentViewModel(this);
	}

	public void showStockAdjustmentOptions() {
		String userSelectedOptions;
		userSelectedOptions = getSelectedOption();
		showProductData();
	}

	private void showProductData() {
		Utility.printSeperatorLine();
		ArrayList<Product> productList = stockAdjustmentViewModel.getProductList();
		if (productList.isEmpty()) {
			Utility.printUserWarningMessage("There is no product.First add the product and come back to this option");
			Utility.printSeperatorLine();
			return;
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		System.out.printf("| %-12s | %-30s | %-15s | %-12s | %-16s |\n", "Product Id", "Product Name", "Product Price",
				"Product Unit", "Product Quantity");
		System.out.println(
				"----------------------------------------------------------------------------------------------------");

		for (Product product : productList) {
			System.out.printf("| %-12d | %-30s | %-15.2f | %-12s | %-16d |\n", product.getId(),
					product.getProductName(), product.getPrice(), product.getUnit(), product.getQuantity());
		}
   
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
	}

	private String getSelectedOption() {
		int userEnteredChoice = -1;
		System.out.print("1 - Add quantity\n2 - Subtract quantity\nChoose your option : ");
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextInt();
				Utility.getScanner().nextLine();
				if (!(userEnteredChoice >= 1 && userEnteredChoice <= 2)) {
					Utility.showWrongSelectionMessage("Choose Valid option : ");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				Utility.showWrongSelectionMessage("Choose Valid option : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return (userEnteredChoice == 1) ? "ADD" : "SUBTRACT";
	}

}
