package com.veeriyaperumal.inventorymanagement.stockadjustment;

import java.util.ArrayList;

import com.veeriyaperumal.inventorymanagement.repository.*;
import com.veeriyaperumal.inventorymanagement.dto.Product;

public class StockAdjustmentViewModel {
	StockAdjustmentView stockAdjustmentView;
	Product product = new Product();
	private ArrayList<Product> productList = new ArrayList<>();

	public StockAdjustmentViewModel(StockAdjustmentView stockAdjustmentView) {
		this.stockAdjustmentView = stockAdjustmentView;
	}

	public ArrayList<Product> getProductList() {
		productList = Repository.getInstance().getProductList();
		return productList;
	}

}
