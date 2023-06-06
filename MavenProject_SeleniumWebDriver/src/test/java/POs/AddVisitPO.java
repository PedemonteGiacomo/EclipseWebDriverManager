package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddVisitPO extends BasePagePO{

	//locator as fields
	private By NewVisit = By.xpath("/html/body/div/div/h2");
	
	//Owner add form
	private By Date = By.xpath("/html/body/div/div/form/div[1]/div[1]/div/div/input");
	private By Description = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/div/input");
	private By Add = By.xpath("/html/body/div/div/form/div[2]/div/button");
	
	//notEmptyFields
	private By notEmptyFields = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/span[2]");
	private By InvalidDate = By.xpath("/html/body/div/div/form/div[1]/div[1]/div/span[2]");
	//private By numericalValueOutOfBounds = By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]");
	private String url;
	private String lastname;
	
	public AddVisitPO(WebDriver driver, String lastName) {
		super(driver);
		url = "http://localhost:8080/owners/1/pets/1/visits/new";
		visit(url);
		lastname = lastName;
	}
	
	public BasePagePO fill(String date, String description) throws InterruptedException {
		if(date != "today")
			type(Date, date);
		clearAndType(Description, description);
		Thread.sleep(1500);
		click(Add);
		//if(((firstname == null || firstname == "") || (lastname == null || lastname == "") || (address == null || address == "") || (telephone == null || telephone == "") || (city == null || city == "")) || telephone.length() > 10){
		String getUrl = getUrl();
		if(getUrl.equals(url))return this;
		else return new OwnerPO(driver, lastname);
	}

	public boolean Displayed() {
		return isIn(NewVisit);
	}
	
	public boolean ShouldNotBeEmpty() {
		return isIn(notEmptyFields);
	}
	
	public boolean InvalidDate() {
		return isIn(InvalidDate);
	}

}
