package com.veeriyaperumal.onlineshopping;


import com.veeriyaperumal.onlineshopping.base.BaseView;
import com.veeriyaperumal.onlineshopping.onboardview.OnboardView;

public class ShoppingApp extends BaseView {
	
	
	OnboardView onboardView = new OnboardView();

	public ShoppingApp() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingApp app = new ShoppingApp();
		app.start();
	}

	private void start() {
		printHeader("WELOME TO ONLINE SHOPPING");
		onboardView.showOnBoardOptions();
	}

}
