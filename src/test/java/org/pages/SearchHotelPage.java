package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.Libglobal;

public class SearchHotelPage extends Libglobal {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement loginSuccessMsg;

	public WebElement getLoginSuccessMsg() {
		return loginSuccessMsg;
	}

}
