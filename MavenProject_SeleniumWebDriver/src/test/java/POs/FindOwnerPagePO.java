package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindOwnerPagePO extends BasePagePO{

	//locator as fields
	private By LastNameField = By.xpath("//input[@id='lastName']");
	private By FindOwner = By.xpath("//button[@type='submit']");
	private By FindOwnersLabel = By.xpath("//h2[contains(text(),'Find Owners')]");
	private By AddOwner = By.xpath("//a[@class='btn btn-primary']");
	
	public FindOwnerPagePO(WebDriver driver) {
		super(driver);
		visit("http://localhost:8080/owners/find");
	}
	
	public BasePagePO search(String LastName) {
		if(LastName == null) {
			click(FindOwner);
			return new OwnersPO(driver);
		}else {
			type(LastNameField, LastName);
			click(FindOwner);
			return new OwnerPO(driver,LastName);
		}
	}
	
	public BasePagePO add() {
		click(AddOwner);
		return new AddOwnerPO(driver);
	}

	public boolean Displayed() {
		return isIn(FindOwnersLabel);
	}

}
