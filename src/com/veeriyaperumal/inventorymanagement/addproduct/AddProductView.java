package com.veeriyaperumal.inventorymanagement.addproduct;

import java.util.InputMismatchException;

import com.veeriyaperumal.inventorymanagement.util.Utility;

public class AddProductView {
	AddProductViewModel addProductViewModel;

	public AddProductView() {
		this.addProductViewModel = new AddProductViewModel(this);
	}

	public void addProduct() {
		addProductViewModel.getProduct().setProductName(getProductName());
		addProductViewModel.getProduct().setPrice(getProductPrice());
		addProductViewModel.getProduct().setUnit(getProductUnit());
		if (addProductViewModel.addProduct()) {
			Utility.printUserWarningMessage(
					addProductViewModel.getProduct().getProductName() + " successfully added.\n");
		} else {
			Utility.printUserWarningMessage(addProductViewModel.getProduct().getProductName() + " not added.\n");
		}

		Utility.printSeperatorLine();
	}

	public String getProductUnit() {
		System.out.print("Enter your Product Unit : ");
		String userEnteredProductUnit = "";
		do {
			try {
				userEnteredProductUnit = Utility.getScanner().nextLine();
				if (!addProductViewModel.isValidProductUnit(userEnteredProductUnit)) {
					Utility.showWrongSelectionMessage("Enter Valid  Product Unit : ");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				Utility.showWrongSelectionMessage("Enter Valid  Product Unit : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredProductUnit;
	}

	public float getProductPrice() {
		System.out.print("Enter your Product price : ");
		float userEnteredChoice = -1f;
		do {
			try {
				userEnteredChoice = Utility.getScanner().nextFloat();
				Utility.getScanner().nextLine();
				if (!addProductViewModel.isValidProductPrice(userEnteredChoice)) {
					Utility.showWrongSelectionMessage("Enter Valid Product Price : ");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				Utility.showWrongSelectionMessage("Enter Valid Product Price : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredChoice;
	}

	public String getProductName() {
		System.out.print("Enter your Product Name : ");
		String userEnteredProduct = "";
		do {
			try {
				userEnteredProduct = Utility.getScanner().nextLine();
				if (!addProductViewModel.isValidProductName(userEnteredProduct)) {
					Utility.showWrongSelectionMessage("Enter Valid  Product Name : ");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				Utility.showWrongSelectionMessage("Enter Valid  Product Name : ");
				Utility.getScanner().next();
				continue;
			}
		} while (true);
		return userEnteredProduct;
	}

}
