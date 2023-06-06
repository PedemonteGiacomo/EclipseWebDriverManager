package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FailAddPO extends BasePagePO{
	
	//notEmptyFields
	private By notEmptyFields = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/span[2]");
	private By numericalValueOutOfBounds = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/span[2]");
	
	public FailAddPO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		String url = "http://localhost:8080/owners/new";
		visit(url);
	}
	
	public boolean ShouldNotBeEmpty() {
		return isIn(notEmptyFields);
	}

	public boolean NumericalValueOutOfBounds() {
		return isIn(numericalValueOutOfBounds);
	}

}
