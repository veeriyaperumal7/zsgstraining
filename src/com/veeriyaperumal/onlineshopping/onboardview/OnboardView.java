package com.veeriyaperumal.onlineshopping.onboardview;

import com.veeriyaperumal.onlineshopping.base.BaseView;


public class OnboardView extends BaseView {

	 public void showOnBoardOptions() {
		 options.clear();
		 options.add("Sign in");
		 options.add("Sign up");
		printOptionsTable(options, "ONBOARD OPTIONS");
	}

}
